package za.co.absa.obs.services.bs;

import za.co.absa.obs.entity.bs.BookOrder;
import za.co.absa.obs.model.bs.BookOrderRequest;

import java.util.List;

public interface BookOrderService {
    BookOrder saveBookOrder(BookOrderRequest bookOrderRequest);

    List<BookOrder> findAllBookOrders();

    List<BookOrder> findBookOrderByIsbn(BookOrderRequest bookOrderRequest);
}
