package web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import web.model.Genre;


@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {

}
