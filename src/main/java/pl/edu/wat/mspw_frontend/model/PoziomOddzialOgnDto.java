package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PoziomOddzialOgnDto implements Serializable  {

    private int id;

    private String nazwa;

    private String skrot;

}
