package exercise.specification;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import exercise.dto.ProductParamsDTO;
import exercise.model.Product;

// BEGIN
@Component
public class ProductSpecification {
    public Specification<Product> build(ProductParamsDTO params) {
        return withCategoryId(params.getCategoryId())
                .and(withPriceGt(params.getPriceGt()))
                .and(withTitleCont(params.getTitleCont()))
                .and(withRatingGt(params.getRatingGt()))
                .and(withPriceLt(params.getPriceLt()));
    }

    private Specification<Product> withCategoryId(Long categoryId) {
        return (root, query, cb) -> categoryId == null
                ? cb.conjunction()
                : cb.equal(root.get("category").get("id"), categoryId);
    }
    private Specification<Product> withPriceGt(Integer priceGt) {
        return (root, query, cb) -> priceGt == null
                ? cb.conjunction()
                : cb.greaterThan(root.get("price"), priceGt);
    }
    private Specification<Product> withPriceLt(Integer priceLt) {
        return (root, query, cb) -> priceLt == null
                ? cb.conjunction()
                : cb.lessThan(root.get("price"), priceLt);
    }
    private Specification<Product> withRatingGt(Double rating) {
        return (root, query, cb) -> rating == null
                ? cb.conjunction()
                : cb.greaterThan(root.get("rating"), rating);
    }
    private Specification<Product> withTitleCont(String title) {
        return (root, query, cb) -> title == null
                ? cb.conjunction()
                : cb.like(root.get("title"), title);
    }

}
// END
