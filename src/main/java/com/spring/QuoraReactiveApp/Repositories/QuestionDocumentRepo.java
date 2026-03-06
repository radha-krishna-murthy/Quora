package com.spring.QuoraReactiveApp.Repositories;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.spring.QuoraReactiveApp.Entity.QuestionElasticDocument;

import reactor.core.publisher.Flux;

public interface QuestionDocumentRepo extends ElasticsearchRepository<QuestionDocumentRepo,String> {
 Flux<QuestionElasticDocument>findByTitleContainingOrContentContaining(String title,String content);
}