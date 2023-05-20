package web.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Genre;
import web.repository.GenreRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class GenreService {
  private final GenreRepository genreRepository;
  @Transactional
  public List<Genre> findAll() {
    List<Genre> all = genreRepository.findAll();
    for (Genre category : all) {
      Hibernate.initialize(category.getBooks());
    }
    return all;
  }
}
