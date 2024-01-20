package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MiaraZdolnosciRazeniaDto implements Serializable {

    private int id;

    private Integer nosicielZdolnFk;

    private Double zdolnRazPancOpancZasiegBliski;

    private Double zdolnRazSrodkOgnZasiegBliski;

    private Double zdolnRazSilyZywejZasiegBliski;

    private Double zdolnRazPancOpancZasiegSredni;

    private Double zdolnRazSrodkOgnZasiegSredni;

    private Double zdolnRazSilyZywejZasiegSredni;

}
