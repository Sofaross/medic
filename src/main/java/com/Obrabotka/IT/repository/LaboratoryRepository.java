package com.Obrabotka.IT.repository;

import com.Obrabotka.IT.entity.Laboratory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LaboratoryRepository extends JpaRepository<Laboratory, Long> {

//    Optional<Laboratory> findByType_analysis(String type);
}
