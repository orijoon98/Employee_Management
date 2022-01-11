package com.fleta.employee.repository;

import com.fleta.employee.entity.PublicInformation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicInformationRepository extends JpaRepository<PublicInformation, Long> {
}
