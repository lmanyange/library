package za.co.absa.obs.model.bs;

import lombok.*;
import za.co.absa.obs.entity.bs.BookOrder;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookOrderResponse {
    private String message;
    private List<BookOrder> bookOrders;
}
