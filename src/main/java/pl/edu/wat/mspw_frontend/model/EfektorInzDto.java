package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorInzDto implements Serializable {

    private int id;

    private Boolean doPracZiemnych;

    private Boolean elementPrzeprProm;

    private Boolean elementPrzeprMost;

    private Double nosnosc;

    private Double szerokPrzeprawy;

}
