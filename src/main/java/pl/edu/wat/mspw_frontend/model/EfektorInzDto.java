package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorInzDto implements Serializable {

    private int id;

    private Boolean doPracZiemnych;

    private Boolean elementPrzeprProm;

    private Boolean elementPrzeprMost;

    private Double nosnosc;

    private Double szerokPrzeprawy;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (doPracZiemnych != null && doPracZiemnych) {
            sb.append("Prace ziemne, ");
        }

        if (elementPrzeprProm != null && elementPrzeprProm) {
            sb.append("Przeprawa promowa, ");
        }

        if (elementPrzeprMost != null && elementPrzeprMost) {
            sb.append("Przeprawa mostowa, ");
        }

        if (nosnosc != null) {
            sb.append("Nośność: ").append(nosnosc).append(", ");
        }

        if (szerokPrzeprawy != null) {
            sb.append("Szerokość przeprawy: ").append(szerokPrzeprawy);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
