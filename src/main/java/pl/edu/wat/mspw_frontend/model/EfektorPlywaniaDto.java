package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorPlywaniaDto implements Serializable {

    private int id;

    private Double predkMaxNaWodzie;

    private Double predkEkoNaWodzie;

    private Double predkMaxPodWoda;

    private Double predkEkoPodWoda;

    private Integer dzielnosc;

    private Double zuzyciePaliwaPredkMaxNaWod;

    private Double zuzyciePaliwaPredkEkoNaWod;

    private Double zuzyciePaliwaPredkMaxPodWod;

    private Double zuzyciePaliwaPredkEkoPodWod;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (predkMaxNaWodzie != null) {
            sb.append("Prędkość maksymalna na wodzie: ").append(predkMaxNaWodzie).append(", ");
        }

        if (predkEkoNaWodzie != null) {
            sb.append("Prędkość ekonomiczna na wodzie: ").append(predkEkoNaWodzie).append(", ");
        }

        if (predkMaxPodWoda != null) {
            sb.append("Prędkość maksymalna pod wodą: ").append(predkMaxPodWoda).append(", ");
        }

        if (predkEkoPodWoda != null) {
            sb.append("Prędkość ekonomiczna pod wodą: ").append(predkEkoPodWoda).append(", ");
        }

        if (dzielnosc != null) {
            sb.append("Dzielność: ").append(dzielnosc).append(", ");
        }

        if (zuzyciePaliwaPredkMaxNaWod != null) {
            sb.append("Zużycie paliwa przy prędkości maksymalnej na wodzie: ").append(zuzyciePaliwaPredkMaxNaWod).append(", ");
        }

        if (zuzyciePaliwaPredkEkoNaWod != null) {
            sb.append("Zużycie paliwa przy prędkości ekonomicznej na wodzie: ").append(zuzyciePaliwaPredkEkoNaWod).append(", ");
        }

        if (zuzyciePaliwaPredkMaxPodWod != null) {
            sb.append("Zużycie paliwa przy prędkości maksymalnej pod wodą: ").append(zuzyciePaliwaPredkMaxPodWod).append(", ");
        }

        if (zuzyciePaliwaPredkEkoPodWod != null) {
            sb.append("Zużycie paliwa przy prędkości ekonomicznej pod wodą: ").append(zuzyciePaliwaPredkEkoPodWod);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }
}
