package com.spring.QuoraReactiveApp.Controller;
import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Service.QuestionService;
import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import com.spring.QuoraReactiveApp.Service.IQuestionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;


@RestController
//@RequiredArgsConstructor
@RequestMapping("/api/questions")
public class QuestionController {
    private final IQuestionService questionService;

    public QuestionController(IQuestionService questionService) {
        this.questionService = questionService;
    }

    @PostMapping("/create")
    public Mono<QuestionResponseDTO> createQuestion(@RequestBody QuestionRequestDTO questionRequestDTO) {
        return questionService.createQuestion(questionRequestDTO);
    }
    @GetMapping("/search")
    public Flux<QuestionResponseDTO> paginationOffset(
            @RequestParam String searchTerm,
            @RequestParam int page,
            @RequestParam int size){
        return questionService.paginationOffset(searchTerm,page,size);
    }

    @GetMapping("/search2")
    public Flux<QuestionResponseDTO> paginationCursor(
            @RequestParam String cursor,
            @RequestParam int size){
        return questionService.paginationCursor(cursor,size);
    }



}
