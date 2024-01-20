package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SystemOgnDto implements Serializable {

    private int id;

    private String nazwa;

    private String skrot;

    private Double szybkostrzelnosc;

    private Double kaliber;

    private Integer dlugSerii;

    private Double czasCelowania;

    private Integer liczbaKanCel;

    private Integer rodzajSystemuOgnFk;

    private Integer klasaPrzyrzOc;

}
