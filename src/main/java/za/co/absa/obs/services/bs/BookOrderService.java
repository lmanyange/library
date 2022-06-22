package za.co.absa.obs.services.bs;

import za.co.absa.obs.entity.bs.BookOrder;
import za.co.absa.obs.model.bs.BookOrderRequest;
import za.co.absa.obs.model.bs.BookOrderRetrievalRequest;

import java.util.List;

public interface BookOrderService {
    BookOrder saveBookOrder(BookOrderRequest bookOrderRequest);

    List<BookOrder> findAllBookOrders();

    List<BookOrder> findBookOrderByIsbn(BookOrderRetrievalRequest bookOrderRequest);
}
