package com.spring.QuoraReactiveApp.Repositories;
import java.util.List;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import com.spring.QuoraReactiveApp.Entity.QuestionElasticDocument;

public interface QuestionDocumentRepo extends ElasticsearchRepository<QuestionDocumentRepo,String> {
List<QuestionElasticDocument>findByTitleContainingOrContentContaining(String title,String content);
}