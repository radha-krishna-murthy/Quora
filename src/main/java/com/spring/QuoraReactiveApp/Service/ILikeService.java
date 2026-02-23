package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.dto.LikeRequestDTO;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ILikeService {
    Mono<LikeResponseDTO>addLike(LikeRequestDTO likeRequestDTO);
    Flux<LikeResponseDTO> countLikesByTargetIDAndTargetType(String targetId,String targetType);
    Flux<LikeResponseDTO> countDisLikesByTargetIDAndTargetType(String targetId,String targetType);
    Mono<LikeResponseDTO>toggleLike(String targetId,String targetType,Boolean isLike);
} 


