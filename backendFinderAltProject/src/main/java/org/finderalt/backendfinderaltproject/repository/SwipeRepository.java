package org.finderalt.backendfinderaltproject.repository;

import org.finderalt.backendfinderaltproject.model.Swipe;
import org.finderalt.backendfinderaltproject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SwipeRepository extends JpaRepository<Swipe, Long> {
    List<Swipe> findBySwiper(User swiper);
    List<Swipe> findBySwipedUser(User swipedUser);
}
