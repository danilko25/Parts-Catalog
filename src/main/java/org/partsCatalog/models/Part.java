package org.partsCatalog.models;

import jakarta.persistence.*;
import org.partsCatalog.models.carsForCatalog.CarManufacturer;

@Entity
public class Part {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "part_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "manufacturer_id", nullable = false)
    private CarManufacturer carManufacturer;

    public Part() {
    }

    public Part(Long id, CarManufacturer carManufacturer) {
        this.id = id;
        this.carManufacturer = carManufacturer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarManufacturer getCarManufacturer() {
        return carManufacturer;
    }

    public void setCarManufacturer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }
}
