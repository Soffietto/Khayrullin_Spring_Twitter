package com.jblab.khayrullin.controller;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Message;
import com.jblab.khayrullin.model.User;
import com.jblab.khayrullin.service.DialogService;
import com.jblab.khayrullin.service.MessageService;
import com.jblab.khayrullin.service.UserService;
import com.jblab.khayrullin.util.forms.MessageForm;
import com.jblab.khayrullin.util.transformers.MessageFormToMessageTransformer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Function;

@Controller
public class MessageController {

    private final UserService userService;
    private final DialogService dialogService;
    private final MessageService messageService;
    private final Function<MessageForm, Message> messageTransformer;

    public MessageController(UserService userService, DialogService dialogService, MessageService messageService) {
        this.userService = userService;
        this.dialogService = dialogService;
        this.messageService = messageService;
        messageTransformer = new MessageFormToMessageTransformer();
    }

    @RequestMapping(value = "/dialogs/{dialog_id}")
    public String getDialog(@PathVariable(value = "dialog_id") Long dialogId, Model model) {
        Dialog dialog = dialogService.findOneById(dialogId);
        List<Message> messageList = messageService.findAllByDialog(dialog);
        User user1 = dialog.getFirstUser();
        User user2 = dialog.getSecondUser();
        model.addAttribute("messages", messageList);
        model.addAttribute("message", new MessageForm());
        model.addAttribute("sender_id", user1.getId());
        model.addAttribute("getter_id", user2.getId());
        return "dialog";
    }

    @RequestMapping(value = "/new_message/{sender_id}/{getter_id}", method = RequestMethod.POST)
    public String getNewMessage(@PathVariable(value = "sender_id") Long senderId, @PathVariable(value = "getter_id") Long getterId,
                                @ModelAttribute("message") @Valid MessageForm messageForm, Model model) {
        Message message = messageTransformer.apply(messageForm);
        User user1 = userService.findOneById(senderId);
        User user2 = userService.findOneById(getterId);
        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Dialog dialog = dialogService.findOneByFirstUserAndSecondUser(user1, user2);
        if (dialog == null) {
            dialog = new Dialog();
            dialog.setFirstUser(user1);
            dialog.setSecondUser(user2);
            dialogService.add(dialog);
            return "redirect:/dialogs/" + dialog.getId();
        }
        message.setDialog(dialog);
        message.setAuthor(currentUser);
        if (message.getText() != null)
            messageService.add(message);
        model.addAttribute("current_user_id", senderId);
        model.addAttribute("id", getterId);
        return "redirect:/dialogs/" + dialog.getId();
    }
}
