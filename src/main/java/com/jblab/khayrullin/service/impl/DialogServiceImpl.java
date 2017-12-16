package com.jblab.khayrullin.service.impl;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.repository.DialogRepository;
import com.jblab.khayrullin.service.DialogService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DialogServiceImpl implements DialogService {

    private final DialogRepository dialogRepository;

    public DialogServiceImpl(DialogRepository dialogRepository) {
        this.dialogRepository = dialogRepository;
    }

    @Override
    public void add(Dialog dialog) {
        dialogRepository.save(dialog);
    }

    @Override
    public Dialog findOneByFirstUserAndSecondUser(User firstUser, User secondUser) {
        return dialogRepository.findOneByUsers(firstUser, secondUser);
    }

    @Override
    public Dialog findOneById(Long id) {
        return dialogRepository.findOne(id);
    }
}
