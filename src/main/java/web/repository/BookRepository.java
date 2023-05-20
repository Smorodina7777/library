package web.repository;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
  @EntityGraph(value = "bookEntityGraphWithAuthorAndGenre", type = EntityGraph.EntityGraphType.FETCH)
  Optional<Book> findById(Long id);

  @EntityGraph(value = "bookEntityGraphWithAuthorAndGenre")
  List<Book> findAllByYearGreaterThan(Integer year);

  @EntityGraph(value = "bookEntityGraphWithAuthorAndGenre")
  Page<Book> findAllByYearGreaterThan(Integer year, Pageable pageble);

  @EntityGraph(attributePaths = {"authors", "genre"})
  List<Book> findAllWithAuthorAndGenre();
}
