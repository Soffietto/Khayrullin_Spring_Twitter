package com.jblab.khayrullin.service;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Message;

import java.util.List;

public interface MessageService {
    void add(Message message);

    List<Message> findAllByDialog(Dialog dialog);
}
