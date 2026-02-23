package com.spring.QuoraReactiveApp.Service;

import com.spring.QuoraReactiveApp.Entity.Question;
import com.spring.QuoraReactiveApp.Repositories.QuestionRepo;
import com.spring.QuoraReactiveApp.Utils.CursorUtils;
import com.spring.QuoraReactiveApp.dto.QuestionRequestDTO;
import org.springframework.data.domain.Pageable;
import com.spring.QuoraReactiveApp.dto.QuestionResponseDTO;
import com.spring.QuoraReactiveApp.Mapper.QuestionMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class QuestionService implements IQuestionService{
    private final QuestionRepo questionRepo;
    @Override
    public Mono<QuestionResponseDTO> createQuestion(QuestionRequestDTO questionRequestDTO) {
      Question question=Question.builder()
                .title(questionRequestDTO.getTitle())
                .content(questionRequestDTO.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now()).
              build();
      return questionRepo.save(question)
      .map(QuestionMapper::toQuestionResponseDTO)
      .doOnSuccess(questionResponseDTO -> {
        System.out.println("Question created successfully: " + questionResponseDTO);
      })
      .doOnError(error -> {
        System.out.println("Error creating question: " + error);
      });
    }
    public Flux<QuestionResponseDTO> paginationOffset(String searchTerm,int page, int size){
        PageRequest pageRequest = PageRequest.of(page, size);

        return questionRepo.findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(searchTerm, (Pageable) pageRequest)
                .map(QuestionMapper::toQuestionResponseDTO);
    }

    @Override
    public Flux<QuestionResponseDTO> paginationCursor(String cursor, int size) {
     Pageable pageable=PageRequest.of(0,size);
        if(!CursorUtils.isValidCusor(cursor)){
            return questionRepo.findAll10Questions(cursor,pageable)
                    .map(QuestionMapper::toQuestionResponseDTO);
        }
            LocalDateTime cursorTimeStamp=CursorUtils.parseCursor(cursor);
            return questionRepo.findByCreatedAtGreaterThanOrderByCreatedAtAsc(cursorTimeStamp,pageable)
                    .map(QuestionMapper::toQuestionResponseDTO)
                    .doOnComplete(() -> {
                        System.out.println("Question fetched successfully");
                    })
                    .doOnError(error -> {
                        System.out.println("Error fetching question: " + error);
                    });


    }
    @Override
    public Mono<QuestionResponseDTO> getQuestionById(String id) {
        return questionRepo.findById(id)
        .map(QuestionMapper::toQuestionResponseDTO);
    }
}
