package com.annonce.voiture.repository;

import com.annonce.voiture.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends JpaRepository<Owner, Long> {

  @Query("select o from Owner o where o.phoneNumber = :phoneNumber")
  Optional<Owner> findByPhoneNumber(@Param("phoneNumber") String phoneNumber);
}