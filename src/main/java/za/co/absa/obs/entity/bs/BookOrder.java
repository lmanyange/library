package za.co.absa.obs.entity.bs;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_order")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookOrder implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Size(max = 50)
    private String isbn;

    @NotBlank
    private String title;

    @NotBlank
    private String author;

    private Integer quantity;

    private LocalDateTime orderTime;
}
