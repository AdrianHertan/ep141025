package usarb.web.ep.rabbit;

import jakarta.persistence.*;
import usarb.web.ep.type.Type;

import java.math.BigDecimal;

@Entity
@Table(name = "rabbits")
public class Rabbit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private Integer age;
    private BigDecimal weight;
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    public Rabbit() {}

    public Rabbit(String name, Integer age, BigDecimal weight, BigDecimal price, Type type) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.price = price;
        this.type = type;
    }

    public Integer getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Integer getAge() { return age; }
    public void setAge(Integer age) { this.age = age; }
    public BigDecimal getWeight() { return weight; }
    public void setWeight(BigDecimal weight) { this.weight = weight; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
    public Type getType() { return type; }
    public void setType(Type type) { this.type = type; }
}
