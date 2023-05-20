package org.partsCatalog.models.carsForCatalog;

import jakarta.persistence.*;
import org.partsCatalog.models.Part;

import java.util.Set;

@Entity
public class CarManufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "manufacturer_name")
    private String name;

    @OneToMany(mappedBy = "carManufacturer")
    private Set<Part> parts;

    public CarManufacturer() {
    }

    public CarManufacturer(Long id, String name, Set<Part> parts) {
        this.id = id;
        this.name = name;
        this.parts = parts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Part> getParts() {
        return parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}
