package com.jblab.khayrullin.repository;

import com.jblab.khayrullin.model.Dialog;
import com.jblab.khayrullin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DialogRepository extends JpaRepository<Dialog, Long> {

    @Query("select d from Dialog d where d.firstUser = :sender and d.secondUser = :recipient or " +
            "d.firstUser = :recipient and d.secondUser = :sender")
    Dialog findOneByUsers(@Param("sender") User sender, @Param("recipient") User recipient);
}
