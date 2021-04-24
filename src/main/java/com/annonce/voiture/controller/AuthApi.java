package com.annonce.voiture.controller;

import com.annonce.voiture.configuration.JwtTokenUtil;
import com.annonce.voiture.dto.OwnerDto;
import com.annonce.voiture.entity.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = "api/public")
public class AuthApi {

  @Autowired
  private AuthenticationManager authenticationManager;
  @Autowired
  private JwtTokenUtil jwtTokenUtil;

  @PostMapping("login")
  public ResponseEntity<OwnerDto> login(@RequestBody @Valid OwnerDto request) {
    try {
      Authentication authenticate = authenticationManager
          .authenticate(
              new UsernamePasswordAuthenticationToken(
                  request.getPhoneNumber(), request.getPassword()
              )
          );

      Owner owner = (Owner) authenticate.getPrincipal();

      return ResponseEntity.ok()
          .header(
              HttpHeaders.AUTHORIZATION,
              jwtTokenUtil.generateAccessToken(owner)
          )
          .body(new OwnerDto(owner));
    } catch (BadCredentialsException ex) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}
