package com.fleta.employee.repository;

import com.fleta.employee.entity.PrivateInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PrivateInformationRepository extends JpaRepository<PrivateInformation, Long> {
}
