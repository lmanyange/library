package za.co.absa.obs.repository.ob;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.absa.obs.entity.bs.BookOrder;

import java.util.List;

@Repository
public interface BookOrderRepository extends JpaRepository<BookOrder, Integer> {
    List<BookOrder> findByIsbn(String isbn);
}
