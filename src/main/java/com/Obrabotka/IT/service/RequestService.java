package com.Obrabotka.IT.service;

import com.Obrabotka.IT.entity.RequestRegistration;
import com.Obrabotka.IT.entity.User;
import com.Obrabotka.IT.repository.RequestRegistrationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RequestService {
    @Autowired
    RequestRegistrationUserRepository requestRepository;

    public List<RequestRegistration> findAllRequest() {
        return requestRepository.findAll();
    }

    public boolean deleteReq(Long requestId) {
        if (requestRepository.findById(requestId).isPresent()) {
            requestRepository.deleteById(requestId);
            return true;
        }
        return false;
    }

}
