package za.co.absa.obs.services.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.absa.obs.entity.bs.BookOrder;
import za.co.absa.obs.model.bs.BookOrderRequest;
import za.co.absa.obs.model.bs.BookOrderRetrievalRequest;
import za.co.absa.obs.repository.ob.BookOrderRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BookOrderServiceImpl implements BookOrderService {

    BookOrderRepository bookOrderRepository;

    @Autowired
    public BookOrderServiceImpl(BookOrderRepository bookOrderRepository) {
        this.bookOrderRepository = bookOrderRepository;
    }

    @Override
    public BookOrder saveBookOrder(BookOrderRequest bookOrderRequest) {
        BookOrder bookOrder = BookOrder.builder()
                .isbn(bookOrderRequest.getIsbn())
                .author(bookOrderRequest.getAuthor())
                .title(bookOrderRequest.getTitle())
                .quantity(bookOrderRequest.getQuantity())
                .orderTime(LocalDateTime.now())
                .build();
        return bookOrderRepository.save(bookOrder);
    }

    @Override
    public List<BookOrder> findAllBookOrders() {
        return bookOrderRepository.findAll();
    }

    @Override
    public List<BookOrder> findBookOrderByIsbn(BookOrderRetrievalRequest bookOrderRequest) {
        return bookOrderRepository.findByIsbn(bookOrderRequest.getIsbn());
    }
}
