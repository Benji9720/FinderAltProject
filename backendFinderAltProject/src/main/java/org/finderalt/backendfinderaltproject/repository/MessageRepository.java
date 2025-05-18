package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.Message;
import org.finderalt.backendfinderaltproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndReceiver(User sender, User receiver);
    List<Message> findByReceiver(User receiver);
}
