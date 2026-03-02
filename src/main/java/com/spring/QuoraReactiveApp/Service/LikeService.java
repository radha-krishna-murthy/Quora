package com.spring.QuoraReactiveApp.Service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.spring.QuoraReactiveApp.Entity.Like;
import com.spring.QuoraReactiveApp.Repositories.LikeRepo;
import com.spring.QuoraReactiveApp.dto.LikeRequestDTO;
import com.spring.QuoraReactiveApp.dto.LikeResponseDTO;
import com.spring.QuoraReactiveApp.producers.LikeNotifyEvent;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class LikeService implements ILikeService {

    private final LikeRepo likeRepo;
    private final LikeNotifyEvent likeNotifyEvent;

    @Override
    public Mono<LikeResponseDTO> addLike(LikeRequestDTO likeRequestDTO) {
        Like like = Like.builder()
                .targetId(likeRequestDTO.getTargetId())
                .targetType(likeRequestDTO.getTargetType())
                .isLiked(likeRequestDTO.getIsLike())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();

        return likeRepo.save(like)
                .map(this::toDto)
                .doOnSuccess(dto -> {
                    if ("question".equalsIgnoreCase(dto.getTargetType()) && Boolean.TRUE.equals(dto.getIsLike())) {
                        System.out.println("Question " + dto.getTargetId() + " got liked!");
                        likeNotifyEvent.publishLikeNotification(dto.getTargetId(), dto.getTargetType(), true);
                    }
                });
    }

    @Override
    public Flux<LikeResponseDTO> countLikesByTargetIDAndTargetType(String targetId, String targetType) {
        return likeRepo.findByTargetIdAndTargetTypeAndIsLiked(targetId, targetType, true)
                .map(this::toDto);
    }

    @Override
    public Flux<LikeResponseDTO> countDisLikesByTargetIDAndTargetType(String targetId, String targetType) {
        return likeRepo.findByTargetIdAndTargetTypeAndIsLiked(targetId, targetType, false)
                .map(this::toDto);
    }

    @Override
    public Mono<LikeResponseDTO> toggleLike(String targetId, String targetType, Boolean isLike) {
        return likeRepo.findFirstByTargetIdAndTargetType(targetId, targetType)
                .flatMap(existing -> {
                    existing.setIsLiked(isLike);
                    existing.setUpdatedAt(LocalDateTime.now());
                    return likeRepo.save(existing);
                })
                .switchIfEmpty(Mono.defer(() -> {
                    Like like = Like.builder()
                            .targetId(targetId)
                            .targetType(targetType)
                            .isLiked(isLike)
                            .createdAt(LocalDateTime.now())
                            .updatedAt(LocalDateTime.now())
                            .build();
                    return likeRepo.save(like);
                }))
                .map(this::toDto)
                .doOnSuccess(dto -> {
                    if ("question".equalsIgnoreCase(dto.getTargetType()) && Boolean.TRUE.equals(dto.getIsLike())) {
                        System.out.println("Question " + dto.getTargetId() + " got liked (toggle)!");
                        likeNotifyEvent.publishLikeNotification(dto.getTargetId(), dto.getTargetType(), true);
                    }
                });
    }

    private LikeResponseDTO toDto(Like like) {
        return LikeResponseDTO.builder()
                .id(like.getId())
                .targetId(like.getTargetId())
                .targetType(like.getTargetType())
                .isLike(like.getIsLiked())
                .createdAt(like.getCreatedAt())
                .updatedAt(like.getUpdatedAt())
                .build();
    }
}
