package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorRozpozDto  implements Serializable {

    private int id;

    private Boolean rozpozAkust;

    private Double rozpozAkustPromien;

    private Boolean rozpozTermicz;

    private Double rozpozTermiczPromienDzien;

    private Double rozpozTermiczPromienNoc;

    private Boolean rozpozNoktow;

    private Double rozpozNoktowPromien;

    private Boolean rozpozRadar;

    private Double rozpozRadarPromien;

    private Integer klasaPrzyrzOc;

}
