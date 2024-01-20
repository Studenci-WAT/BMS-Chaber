package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorLacznDto implements Serializable {

    private int id;

    private Integer liczbaTraktowKabl;

    private Integer liczbaTraktowRadiol;

    private Integer liczbaSieciCnrDoPrzylacz;

    private Double mocNadajnikaRadiol;

    private Double wysokAntenyRadiol;

    private Double mocNadajnika;

    private Double zasiegNadajnika;
}
