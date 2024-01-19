package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParamStrzelOgBezpDto implements Serializable  {

    private int id;

    private Integer amoFk;

    private Integer systemOgnFk;

    private Double odleg;

    private Double predkPocisku;

    private Double uchylSzer;

    private Double uchylWys;

    private Double wysok;

}
