package com.example.backend.model.DTO;

import com.example.backend.model.Client;
import com.example.backend.model.Gokart;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
public class RidePrepare {
    List<Gokart> gokarts;
    List<Client> clients;
    public RidePrepare(List<Gokart> gokarts, List<Client> clients) {
        this.gokarts = gokarts;
        this.clients = clients;
    }
}
