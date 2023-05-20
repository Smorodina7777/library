package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Author;
import web.repository.AuthorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthorService {
  private final AuthorRepository authorRepository;
  public Optional<Author> findById(Long id) {
    return authorRepository.findById(id);
  }

}
