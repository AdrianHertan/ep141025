package usarb.web.ep.type;

import usarb.web.ep.rabbit.Rabbit;  // импорт Rabbit
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String description;
    private BigDecimal basePrice;

    @OneToMany(mappedBy = "type", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rabbit> rabbits;

    public Type() {}

    public Type(String name, String description, BigDecimal basePrice) {
        this.name = name;
        this.description = description;
        this.basePrice = basePrice;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
    public List<Rabbit> getRabbits() { return rabbits; }
    public void setRabbits(List<Rabbit> rabbits) { this.rabbits = rabbits; }
}
