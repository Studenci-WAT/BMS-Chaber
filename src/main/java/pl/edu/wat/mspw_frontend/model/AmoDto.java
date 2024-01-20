package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AmoDto implements Serializable {

    private int id;

    private String nazwa;

    private String skrot;

    private String kod;

    private Double kaliber;

    private Integer sztukWPaczce;

    private Integer masaSztuki;

    private Double wymPaczkiX;

    private Double wymPaczkiY;

    private Double wymPaczkiZ;

    private Integer kategFk;

    private Integer rodzajGlowicyBojFk;

    private Integer rodzajGlowicyNaprowFk;

    private Integer rodzajNaprowFk;

}
