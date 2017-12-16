package com.jblab.khayrullin.util.transformers;

import com.jblab.khayrullin.model.Message;
import com.jblab.khayrullin.util.forms.MessageForm;

import java.util.function.Function;

public class MessageFormToMessageTransformer implements Function<MessageForm, Message> {
    @Override
    public Message apply(MessageForm messageForm) {
        Message message = new Message();
        message.setText(messageForm.getText());
        return message;
    }
}
