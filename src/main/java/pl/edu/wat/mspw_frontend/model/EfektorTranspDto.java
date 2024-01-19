package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorTranspDto implements Serializable {

    private int id;

    private Integer desant;

    private Double ladowMasa;

    private Double ladowWymX;

    private Double ladowWymY;

    private Double ladowWymZ;

    private Double pojem;

    private Boolean transportWody;

}
