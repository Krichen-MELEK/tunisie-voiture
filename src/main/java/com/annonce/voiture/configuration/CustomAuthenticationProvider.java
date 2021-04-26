package com.annonce.voiture.configuration;

import com.annonce.voiture.entity.Owner;
import com.annonce.voiture.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.NullAuthoritiesMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private OwnerService ownerService;

    private GrantedAuthoritiesMapper authoritiesMapper = new NullAuthoritiesMapper();
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public Authentication authenticate(Authentication authentication) throws BadCredentialsException {

        String phoneNumber = authentication.getName();
        String password = authentication.getCredentials().toString();

        Optional<Owner> owner = ownerService.findByPhoneNumber(phoneNumber);
        if (owner.isPresent()) {
            if (!this.passwordEncoder.matches(password, owner.get().getPassword()))
                throw new BadCredentialsException("Wrong Password");
            if (owner.get().getExpiredDatePassword().before(new Date()))
                throw new BadCredentialsException("Expired Password");
            if (!owner.get().getIsValidPassword())
                throw new BadCredentialsException("Invalid Password");

            disablePassword(owner.get());
            return new UsernamePasswordAuthenticationToken(owner.get(),
                    authentication.getCredentials(), this.authoritiesMapper.mapAuthorities(owner.get().getAuthorities()));
        } else {
            throw new BadCredentialsException("Authentication failed");
        }
    }

    private void disablePassword(Owner owner) {
        owner.setIsValidPassword(false);
        ownerService.updateOwner(owner);
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(UsernamePasswordAuthenticationToken.class);
    }
}
