package org.partsCatalog.models;

import jakarta.persistence.*;
import org.partsCatalog.models.carsForCatalog.CarManufacturer;
import org.partsCatalog.models.enums.PartCondition;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_id")
    private Long id;

    @Column(name = "original_part_code", nullable = false)
    private String originalPartCode;

    @Column(name = "vendor_part_code", nullable = false)
    private String vendorCode;

    @Column(name = "part_condition", nullable = false)
    private PartCondition condition;

    @Column(name = "part_price", nullable = false)
    private int price;

    @Column(name = "parts_count", nullable = false)
    private int count;

    @ManyToMany(mappedBy = "likedParts")
    private Set<User> usersWhichLike = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private CarManufacturer carManufacturer;

    public Part() {
    }

    public Part(Long id, String originalPartCode, String vendorCode, PartCondition condition, int price, int count, Set<User> usersWhichLike, CarManufacturer carManufacturer) {
        this.id = id;
        this.originalPartCode = originalPartCode;
        this.vendorCode = vendorCode;
        this.condition = condition;
        this.price = price;
        this.count = count;
        this.usersWhichLike = usersWhichLike;
        this.carManufacturer = carManufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOriginalPartCode() {
        return originalPartCode;
    }

    public void setOriginalPartCode(String originalPartCode) {
        this.originalPartCode = originalPartCode;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public PartCondition getCondition() {
        return condition;
    }

    public void setCondition(PartCondition condition) {
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Set<User> getUsersWhichLike() {
        return usersWhichLike;
    }

    public void setUsersWhichLike(Set<User> usersWhichLike) {
        this.usersWhichLike = usersWhichLike;
    }

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Part part = (Part) o;
        return price == part.price && count == part.count && id.equals(part.id) && originalPartCode.equals(part.originalPartCode) && vendorCode.equals(part.vendorCode) && condition == part.condition && Objects.equals(usersWhichLike, part.usersWhichLike) && carManufacturer.equals(part.carManufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, originalPartCode, condition);
    }
}
