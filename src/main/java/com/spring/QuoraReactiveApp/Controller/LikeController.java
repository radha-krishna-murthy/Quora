package com.spring.QuoraReactiveApp.Controller;

import com.spring.QuoraReactiveApp.Service.ILikeService;
import com.spring.QuoraReactiveApp.dto.LikeRequestDTO;
import com.spring.QuoraReactiveApp.dto.LikeResponseDTO;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/likes")
@AllArgsConstructor
public class LikeController {

    private final ILikeService likeService;

    @PostMapping("/addLike")
    public Mono<LikeResponseDTO> addLike(@RequestBody LikeRequestDTO likeRequestDTO) {
        return likeService.addLike(likeRequestDTO);
    }

    @GetMapping("/getLikesByIdAndType/{id}/{type}")
    public Flux<LikeResponseDTO> countLikesByTargetIDAndTargetType(@PathVariable String id, @PathVariable String type) {
        return likeService.countLikesByTargetIDAndTargetType(id, type);
    }

    @GetMapping("/getDisLikesByIdAndType/{id}/{type}")
    public Flux<LikeResponseDTO> countDisLikesByTargetIDAndTargetType(@PathVariable String id, @PathVariable String type) {
        return likeService.countDisLikesByTargetIDAndTargetType(id, type);
    }

    @PutMapping("/toggleLike")
    public Mono<LikeResponseDTO> toggleLike(@RequestBody LikeRequestDTO likeRequestDTO) {
        return likeService.toggleLike(likeRequestDTO.getTargetId(), likeRequestDTO.getTargetType(), likeRequestDTO.getIsLike());
    }
}

