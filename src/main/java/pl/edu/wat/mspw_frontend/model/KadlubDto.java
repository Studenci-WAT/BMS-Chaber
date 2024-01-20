package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KadlubDto implements Serializable {

    private int id;

    private Double pancerzBokKinetRha;

    private Double pancerzBokKumulRha;

    private Double pancerzFrontKinetRha;

    private Double pancerzFrontKumulRha;

    private Double pancerzTylKinetRha;

    private Double pancerzTylKumulRha;

    private Double pancerzSpodKinetRha;

    private Double pancerzSpodKumulRha;

    private Double pancerzStropKinetRha;

    private Double pancerzStropKumulRha;

}
