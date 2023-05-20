package web.repository;


import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Author;
import java.util.Optional;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
  @EntityGraph(value = "authorEntityGraph", type = EntityGraph.EntityGraphType.FETCH)
  Optional<Author> findById(Long id);
}
