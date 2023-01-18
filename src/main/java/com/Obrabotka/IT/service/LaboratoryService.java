package com.Obrabotka.IT.service;

import com.Obrabotka.IT.entity.Laboratory;
import com.Obrabotka.IT.entity.User;
import com.Obrabotka.IT.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class LaboratoryService {
    @Autowired
    LaboratoryRepository laboratoryRepository;
    public List<Laboratory> findAllOperation() {
        return laboratoryRepository.findAll();
    }
    public Laboratory getLaboratory(Long id) {
        return laboratoryRepository.findById(id).get();
    }
    public boolean deleteOperation(Long requestId) {
        if (laboratoryRepository.findById(requestId).isPresent()) {
            laboratoryRepository.deleteById(requestId);
            return true;
        }
        return false;
    }
    @PersistenceContext
    private EntityManager em;
    public List<User> dataList(String type_analysis) {
        return em.createQuery("SELECT u FROM Laboratory u WHERE u.type_analysis = :type_analysisId", User.class)
                .setParameter("type_analysisId", type_analysis).getResultList();
    }
    public List<Laboratory> allLaboratory() {
        return laboratoryRepository.findAll();
    }
}
