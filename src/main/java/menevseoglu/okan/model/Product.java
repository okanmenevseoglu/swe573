package menevseoglu.okan.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import java.util.List;

/**
 * Entity representation of the product table that stores the products of the cooperative.
 */
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue
    private short id;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private float price;

    @Column(nullable = false)
    private int stock;

    @Column(nullable = false)
    private float starRate;

    @Column(columnDefinition = "VARCHAR(2083)")
    private String photoUrl;

    @Column(nullable = false)
    private int unit;

    @ManyToOne(optional = false)
    private UnitType unitType;

    @ManyToOne(optional = false)
    private PackageType packageType;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private ProductCategory productCategory;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(optional = false)
    private Producer producer;

    @OneToMany(mappedBy = "product")
    private List<Photo> photoList;

    @OneToMany(mappedBy = "product")
    private List<Comment> commentList;

    @OneToMany(mappedBy = "product")
    private List<StarRating> starRatingList;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<SaleProduct> saleProductList;
}
