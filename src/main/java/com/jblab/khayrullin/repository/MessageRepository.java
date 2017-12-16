package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findAllByDialog(Dialog dialog);
}
