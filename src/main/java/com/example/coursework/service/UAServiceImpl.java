package com.example.coursework.service;

import com.example.coursework.entity.UserActions;
import com.example.coursework.repository.UARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UAServiceImpl implements UAService {

    private final UARepository UARepository;

    @Autowired
    public UAServiceImpl(UARepository UARepository) {
        this.UARepository = UARepository;
    }


    private UserActions createLogging(String message) {
        UserActions userActions = new UserActions();
        userActions.setMessage(message);
        userActions.setDate_actions(new Date());
        return userActions;
    }

    @Override
    public void saveUserAction(String message) {
        UARepository.save(this.createLogging(message));

    }
}
