package web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import web.model.Book;
import web.repository.BookRepository;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
  private final BookRepository repo;
  public Page<Book> findByYear(Integer year, Pageable pageable) {
    return repo.findAllByYearGreaterThan(year, pageable);
  }
  public List<Book> findAllWithAuthorAndGenre(){
    return repo.findAllWithAuthorAndGenre();
  }

}
