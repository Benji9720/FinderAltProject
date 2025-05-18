package org.finderalt.backendfinderaltproject.service;

import lombok.RequiredArgsConstructor;
import org.finderalt.backendfinderaltproject.dto.SwipeDto;
import org.finderalt.backendfinderaltproject.model.Swipe;
import org.finderalt.backendfinderaltproject.model.User;
import org.finderalt.backendfinderaltproject.repository.SwipeRepository;
import org.finderalt.backendfinderaltproject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SwipeService {

    private final SwipeRepository swipeRepository;
    private final UserRepository userRepository;

    public SwipeDto createSwipe(SwipeDto dto) {
        Optional<User> swiper = userRepository.findById(dto.getSwiperId());
        Optional<User> swiped = userRepository.findById(dto.getSwipedUserId());

        if (swiper.isEmpty() || swiped.isEmpty()) return null;

        Swipe swipe = Swipe.builder()
                .swiper(swiper.get())
                .swipedUser(swiped.get())
                .liked(dto.isLiked())
                .swipedAt(LocalDateTime.now())
                .build();

        return toDto(swipeRepository.save(swipe));
    }

    public boolean hasUserLikedTarget(Long swiperId, Long swipedId) {
        Optional<User> swiper = userRepository.findById(swiperId);
        Optional<User> swiped = userRepository.findById(swipedId);

        if (swiper.isEmpty() || swiped.isEmpty()) return false;

        return swipeRepository.findBySwiper(swiper.get()).stream()
                .anyMatch(s -> s.getSwipedUser().getId().equals(swipedId) && s.isLiked());
    }


    private SwipeDto toDto(Swipe s) {
        return SwipeDto.builder()
                .id(s.getId())
                .swiperId(s.getSwiper().getId())
                .swipedUserId(s.getSwipedUser().getId())
                .liked(s.isLiked())
                .swipedAt(s.getSwipedAt())
                .build();
    }
}
