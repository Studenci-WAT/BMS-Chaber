package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrzebijalPancRhaDto implements Serializable {

    private int id;

    private Integer amoFk;

    private Double predkPocisku;

    private Double przebijalPocisku;

}
