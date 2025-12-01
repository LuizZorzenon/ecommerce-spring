package com.zorzenon.crud.entities;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O nome do produto não pode estar vazio")
    @Column(nullable = false, length = 100)
    private String name;

    @Positive(message = "O preço deve ser maior que zero!")
    private Float priceInCents;

// ** Isso são getters e setters, substituidos pelo Lombok para deixar o código mais organizado! vale buscar sobre! ** //
//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name = name;
//    }
//
//    public Float getPriceInCents(){
//        return priceInCents;
//    }
//
//    public void setPriceInCents(float priceInCents){
//        this.priceInCents = priceInCents;
//
//    }
}
