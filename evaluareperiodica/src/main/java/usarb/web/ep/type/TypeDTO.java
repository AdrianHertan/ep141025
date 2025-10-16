package usarb.web.ep.type;

import java.math.BigDecimal;

public class TypeDTO {

    private Integer id;
    private String name;
    private String description;
    private BigDecimal basePrice;

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public BigDecimal getBasePrice() { return basePrice; }
    public void setBasePrice(BigDecimal basePrice) { this.basePrice = basePrice; }
}
