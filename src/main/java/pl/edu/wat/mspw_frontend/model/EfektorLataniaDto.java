package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorLataniaDto implements Serializable {

    private int id;

    private Double predkMin;

    private Double predkEko;

    private Double predkMax;

    private Double wysokMin;

    private Double wysokPrzelot;

    private Double wysokMax;

    private Double zuzyciePredkMin;

    private Double zuzyciePredkPrzelot;

    private Double zuzyciePredkMax;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (predkMin != null) {
            sb.append("Prędkość min: ").append(predkMin).append(", ");
        }

        if (predkEko != null) {
            sb.append("Prędkość ekonomiczna: ").append(predkEko).append(", ");
        }

        if (predkMax != null) {
            sb.append("Prędkość max: ").append(predkMax).append(", ");
        }

        if (wysokMin != null) {
            sb.append("Wysokość min: ").append(wysokMin).append(", ");
        }

        if (wysokPrzelot != null) {
            sb.append("Wysokość przelot: ").append(wysokPrzelot).append(", ");
        }

        if (wysokMax != null) {
            sb.append("Wysokość max: ").append(wysokMax).append(", ");
        }

        if (zuzyciePredkMin != null) {
            sb.append("Zużycie paliwa przy prędkości min: ").append(zuzyciePredkMin).append(", ");
        }

        if (zuzyciePredkPrzelot != null) {
            sb.append("Zużycie paliwa przy prędkości przelot: ").append(zuzyciePredkPrzelot).append(", ");
        }

        if (zuzyciePredkMax != null) {
            sb.append("Zużycie paliwa przy prędkości max: ").append(zuzyciePredkMax);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }
}
