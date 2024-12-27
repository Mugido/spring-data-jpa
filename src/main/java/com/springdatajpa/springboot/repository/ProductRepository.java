package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //finByName query method returns the found product
    //entry by using its name as search criteria. If no product
    //entry is found, this method returns null.
    public Product findByName(String name);


    //findById query method returns optional which contains
    //the found product entry by using its id as search criteria.
    //if no product entry is found, this method returns an empty optional.
    Optional<Product> findById(Long id);


    //findByNameOrDescription query method find a list of product
    //entries whose name or description is given as a method parameters
    //if no product entry is found for this query method, then this query
    //method returns empty list.
    List<Product> findByNameOrDescription(String name, String description);


    //findByNameAndDescription query method find a list of product
    //entries whose name and description is given as a method parameters
    //if no product entry is found for this query method, then this query
    //method returns empty list.
    List<Product> findByNameAndDescription(String name, String description);


    //findDistinctByName returns a distinct product whose name is given
    //as a method parameter as a search criteria. if no product entry is found
    //this method returns null.
    Product findDistinctByName(String name);


    //findByPriceGreaterThan return products whose price is greater than given
    //price as method parameter
    //@param price
    //@return
    List<Product> findByPriceGreaterThan(BigDecimal price);


    //findByPriceLessThan return products whose price is less than given
    //price as method parameter
    //@param price
    //@return
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * findByNameContaining return the filtered product records that matches a given text.
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);


    /**
     * findByNameLike return products based on SQL like condition
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);

    /**
     *findByPriceBetween returns a product whose price is between start price and end price
     * @param startPrice
     * @param endPrice
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * findByDateCreatedBetween returns a product whose dateCreated between start date and end date
     * @param startDate
     * @param endDate
     * @return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);

    /**
     * findByNameIn returns list of products based on multiple values
     * @param names
     * @return
     */
    List<Product> findByNameIn(List<String> names);

    List<Product> findFirst2ByOrderByNameAsc();

    List<Product> findTop2ByOrderByPriceDesc();
}
