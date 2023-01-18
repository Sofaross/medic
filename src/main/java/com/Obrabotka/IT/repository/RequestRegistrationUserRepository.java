package com.Obrabotka.IT.repository;

import com.Obrabotka.IT.entity.RequestRegistration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRegistrationUserRepository extends JpaRepository<RequestRegistration, Long> {
}
