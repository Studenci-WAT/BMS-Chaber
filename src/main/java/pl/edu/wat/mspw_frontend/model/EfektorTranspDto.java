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

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (desant != null) {
            sb.append("Desant: ").append(desant).append(", ");
        }

        if (ladowMasa != null) {
            sb.append("Lądowanie masa: ").append(ladowMasa).append(", ");
        }

        if (ladowWymX != null) {
            sb.append("Lądowanie wymiar X: ").append(ladowWymX).append(", ");
        }

        if (ladowWymY != null) {
            sb.append("Lądowanie wymiar Y: ").append(ladowWymY).append(", ");
        }

        if (ladowWymZ != null) {
            sb.append("Lądowanie wymiar Z: ").append(ladowWymZ).append(", ");
        }

        if (pojem != null) {
            sb.append("Pojemność: ").append(pojem).append(", ");
        }

        if (transportWody != null && transportWody) {
            sb.append("Transport wody, ");
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
