package web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedEntityGraph(
        name = "authorEntityGraph",
        attributeNodes = {
                @NamedAttributeNode("name"),
                @NamedAttributeNode("books"),
        }
)

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
 private  String country;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id")
  private List<Book> books;

    public Author(String name) {
        this.name = name;
    }
}
