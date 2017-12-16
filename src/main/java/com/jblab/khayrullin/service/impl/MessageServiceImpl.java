package com.jblab.khayrullin.service.impl;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Message;
import com.jblab.khayrullin.repository.MessageRepository;
import com.jblab.khayrullin.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public void add(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> findAllByDialog(Dialog dialog) {
        return messageRepository.findAllByDialog(dialog);
    }
}
