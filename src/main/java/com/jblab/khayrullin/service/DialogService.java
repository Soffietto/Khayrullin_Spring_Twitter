package com.jblab.khayrullin.service;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.User;

public interface DialogService {

    void add(Dialog dialog);

    Dialog findOneByFirstUserAndSecondUser(User firstUser, User secondUser);

    Dialog findOneById(Long id);
}
