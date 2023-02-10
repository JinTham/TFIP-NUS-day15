package tfip.ssf.day15.model;

import java.io.Serializable;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Item implements Serializable {
    @NotNull(message = "Item name cannot be empty")
    @Size(min=3,message="Item name cannot be less than 3 characters")
    private String name;
    
    @Min(value=1,message="Minimum quantity is 1")
    @Digits(integer=5, fraction=2, message="x quantity is 5 digits and 2 decimals")
    private Float quantity;
    
    //Getters & Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Float getQuantity() {
        return quantity;
    }
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }
    
}
