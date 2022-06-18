package za.co.absa.obs.api.bs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.absa.obs.control.security.AuthController;
import za.co.absa.obs.entity.bs.BookOrder;
import za.co.absa.obs.model.bs.BookOrderRequest;
import za.co.absa.obs.model.bs.BookOrderResponse;
import za.co.absa.obs.model.security.MessageResponse;
import za.co.absa.obs.services.bs.BookOrderService;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/bookstore")
public class BookStoreApi {
    private final AuthController authController;
    @Autowired
    private BookOrderService bookOrderService;

    public BookStoreApi(AuthController authController) {
        this.authController = authController;
    }

    @PostMapping("/orders/place")
    public ResponseEntity<BookOrderResponse> placeBookOrders(@Valid @RequestBody BookOrderRequest bookOrderRequest) {

        BookOrder bookOrder = bookOrderService.saveBookOrder(bookOrderRequest);

        return ResponseEntity.ok(BookOrderResponse.builder()
                .message("Orders successfully placed with ID " + bookOrder.getId() + "!")
                .build());
    }

    @GetMapping("/orders/retrieve/isbn")
    public ResponseEntity<BookOrderResponse> retrieveBookOrderByIsbn(@Valid @RequestBody BookOrderRequest bookOrderRequest) {
        List<BookOrder> bookOrderByIsbn = bookOrderService.findBookOrderByIsbn(bookOrderRequest);
        if (bookOrderByIsbn.isEmpty()) {
            return ResponseEntity.ok(
                    BookOrderResponse.builder()
                            .message("No Orders for the ISBN specified")
                            .build()
            );
        }

        return ResponseEntity.ok(
                BookOrderResponse.builder()
                        .bookOrders(bookOrderByIsbn)
                        .message("Orders successfully fetched")
                        .build()
        );

    }

    @GetMapping("/orders/retrieve/all")
    public ResponseEntity<BookOrderResponse> retrieveBooksOrders() {
        List<BookOrder> allBookOrders = bookOrderService.findAllBookOrders();
        if (allBookOrders.isEmpty()) {
            ResponseEntity.ok(
                    BookOrderResponse.builder()
                            .message("No Orders for the ISBN specified")
                            .build()
            );
        }

        return ResponseEntity.ok(
                BookOrderResponse.builder()
                        .bookOrders(allBookOrders)
                        .message("All Orders successfully fetched")
                        .build()
        );
//        return authController.registerUser(signUpRequest);
    }
}
