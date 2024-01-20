package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorJezdnyDto implements Serializable {

    private int id;

    private Integer rodzajPodwoziaFk;

    private Double zuzyciePaliwaPredkEkoDroga;

    private Double zuzyciePaliwaPredkEkoTeren;

    private Double zuzyciePaliwaMax;

    private Double predkMaxDroga;

    private Double predkMaxTeren;

    private Double predkEkoDroga;

    private Double predkEkoTeren;

    private Double szerokPokonywRowow;

    private Double glebokBrodz;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (rodzajPodwoziaFk != null) {
            sb.append("Rodzaj podwozia: ").append(rodzajPodwoziaFk).append(", ");
        }

        if (zuzyciePaliwaPredkEkoDroga != null) {
            sb.append("Zużycie paliwa ekonomiczna droga: ").append(zuzyciePaliwaPredkEkoDroga).append(", ");
        }

        if (zuzyciePaliwaPredkEkoTeren != null) {
            sb.append("Zużycie paliwa ekonomiczna teren: ").append(zuzyciePaliwaPredkEkoTeren).append(", ");
        }

        if (zuzyciePaliwaMax != null) {
            sb.append("Zużycie paliwa maksymalna prędkość: ").append(zuzyciePaliwaMax).append(", ");
        }

        if (predkMaxDroga != null) {
            sb.append("Prędkość maksymalna droga: ").append(predkMaxDroga).append(", ");
        }

        if (predkMaxTeren != null) {
            sb.append("Prędkość maksymalna teren: ").append(predkMaxTeren).append(", ");
        }

        if (predkEkoDroga != null) {
            sb.append("Prędkość ekonomiczna droga: ").append(predkEkoDroga).append(", ");
        }

        if (predkEkoTeren != null) {
            sb.append("Prędkość ekonomiczna teren: ").append(predkEkoTeren).append(", ");
        }

        if (szerokPokonywRowow != null) {
            sb.append("Szerokość pokonywania rowów: ").append(szerokPokonywRowow).append(", ");
        }

        if (glebokBrodz != null) {
            sb.append("Głębokość brodzenia: ").append(glebokBrodz);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
