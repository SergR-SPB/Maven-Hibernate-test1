package test1.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity

public class Product {

    @Id
    @GeneratedValue
    private Integer id;

    private Integer idProduct;
    private String titleProduct;


}
