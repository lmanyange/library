package za.co.absa.obs.model.bs;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookOrderRetrievalRequest {
    @NotBlank
    private String isbn;
}
