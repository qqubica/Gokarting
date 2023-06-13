package com.example.backend.model.DTO;

import com.example.backend.model.Gokart;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GokartDTO {
    private long id;
    private int horsepower;
    private Gokart.GokartType typGokarta;

    public GokartDTO(Gokart gokart) {
        System.out.println(gokart);
        this.id = gokart.getId();
        this.horsepower = gokart.getHorsepower();
        this.typGokarta = gokart.getTypGokarta();
    }
}
