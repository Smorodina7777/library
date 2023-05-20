package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@NamedEntityGraph(
        name = "bookEntityGraphWithAuthorAndGenre",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("genre"),
                @NamedAttributeNode("authors"),

        }
)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private Integer year;

  @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
  private List<Author> authors;
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn
  private Genre genre;

}
