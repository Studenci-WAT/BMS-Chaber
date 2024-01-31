package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorLacznDto implements Serializable {

    private int id;

    private Integer liczbaTraktowKabl;

    private Integer liczbaTraktowRadiol;

    private Integer liczbaSieciCnrDoPrzylacz;

    private Double mocNadajnikaRadiol;

    private Double wysokAntenyRadiol;

    private Double mocNadajnika;

    private Double zasiegNadajnika;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (liczbaTraktowKabl != null) {
            sb.append("Liczba traktów kablowych: ").append(liczbaTraktowKabl).append(", ");
        }

        if (liczbaTraktowRadiol != null) {
            sb.append("Liczba traktów radiolokacyjnych: ").append(liczbaTraktowRadiol).append(", ");
        }

        if (liczbaSieciCnrDoPrzylacz != null) {
            sb.append("Liczba sieci CNR do przylączania: ").append(liczbaSieciCnrDoPrzylacz).append(", ");
        }

        if (mocNadajnikaRadiol != null) {
            sb.append("Moc nadajnika radiolokacyjnego: ").append(mocNadajnikaRadiol).append(", ");
        }

        if (wysokAntenyRadiol != null) {
            sb.append("Wysokość anteny radiolokacyjnej: ").append(wysokAntenyRadiol).append(", ");
        }

        if (mocNadajnika != null) {
            sb.append("Moc nadajnika: ").append(mocNadajnika).append(", ");
        }

        if (zasiegNadajnika != null) {
            sb.append("Zasięg nadajnika: ").append(zasiegNadajnika);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
