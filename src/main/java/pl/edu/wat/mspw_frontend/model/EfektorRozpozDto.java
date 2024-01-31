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

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (rozpozAkust != null && rozpozAkust) {
            sb.append("Rozpoznanie akustyczne, ");
        }

        if (rozpozAkustPromien != null) {
            sb.append("Promień rozpoznania akustycznego: ").append(rozpozAkustPromien).append(", ");
        }

        if (rozpozTermicz != null && rozpozTermicz) {
            sb.append("Rozpoznanie termiczne, ");
        }

        if (rozpozTermiczPromienDzien != null) {
            sb.append("Promień rozpoznania termicznego (dzień): ").append(rozpozTermiczPromienDzien).append(", ");
        }

        if (rozpozTermiczPromienNoc != null) {
            sb.append("Promień rozpoznania termicznego (noc): ").append(rozpozTermiczPromienNoc).append(", ");
        }

        if (rozpozNoktow != null && rozpozNoktow) {
            sb.append("Rozpoznanie noktowizyjne, ");
        }

        if (rozpozNoktowPromien != null) {
            sb.append("Promień rozpoznania noktowizyjnego: ").append(rozpozNoktowPromien).append(", ");
        }

        if (rozpozRadar != null && rozpozRadar) {
            sb.append("Rozpoznanie radarowe, ");
        }

        if (rozpozRadarPromien != null) {
            sb.append("Promień rozpoznania radarowego: ").append(rozpozRadarPromien).append(", ");
        }

        if (klasaPrzyrzOc != null) {
            sb.append("Klasa przyrządów optycznych: ").append(klasaPrzyrzOc);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
