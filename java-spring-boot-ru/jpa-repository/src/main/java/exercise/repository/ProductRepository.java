package exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import exercise.model.Product;

import org.springframework.data.domain.Sort;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // BEGIN
    List<Product> findByPriceBetweenOrderByPriceAsc(Integer startPrice, Integer endPrice);

    List<Product> findByPriceIsGreaterThanOrderByPriceAsc(Integer startPrice);

    List<Product> findByPriceIsLessThanOrderByPriceAsc(Integer endPrice);

    // END
}
