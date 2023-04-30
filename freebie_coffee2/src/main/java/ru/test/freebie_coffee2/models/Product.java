package ru.test.freebie_coffee2.models;


import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Product")
public class Product extends AbstractBaseEntity {
    @Column(name = "price", nullable = false)
    @NotBlank
    private Integer price;

    @Column(name = "title", nullable = false)
    @NotBlank
    @Size(min = 2, max = 128)
    private String title;

    @Column(name = "description")
    @NotBlank
    @Size(min = 2, max = 500)
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "product")
    private List<Image> images = new ArrayList<>();

    public Product() {
    }

    public Product(Integer id, String name, Integer price, String title, String description) {
        super(id, name);
        this.price = price;
        this.title = title;
        this.description = description;
    }

    public void addImage(Image image) {
        image.setProduct(this);
        images.add(image);
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
