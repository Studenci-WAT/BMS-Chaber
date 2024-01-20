package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class KadlubDto implements Serializable {

    private int id;

    private Double pancerzBokKinetRha;

    private Double pancerzBokKumulRha;

    private Double pancerzFrontKinetRha;

    private Double pancerzFrontKumulRha;

    private Double pancerzTylKinetRha;

    private Double pancerzTylKumulRha;

    private Double pancerzSpodKinetRha;

    private Double pancerzSpodKumulRha;

    private Double pancerzStropKinetRha;

    private Double pancerzStropKumulRha;

    public String getNazwa() {
        StringBuilder sb = new StringBuilder("Nazwa: ");

        if (pancerzBokKinetRha != null) {
            sb.append("Pancerz bok kinetyczny RHA: ").append(pancerzBokKinetRha).append(", ");
        }

        if (pancerzBokKumulRha != null) {
            sb.append("Pancerz bok kumulacyjny RHA: ").append(pancerzBokKumulRha).append(", ");
        }

        if (pancerzFrontKinetRha != null) {
            sb.append("Pancerz front kinetyczny RHA: ").append(pancerzFrontKinetRha).append(", ");
        }

        if (pancerzFrontKumulRha != null) {
            sb.append("Pancerz front kumulacyjny RHA: ").append(pancerzFrontKumulRha).append(", ");
        }

        if (pancerzTylKinetRha != null) {
            sb.append("Pancerz tył kinetyczny RHA: ").append(pancerzTylKinetRha).append(", ");
        }

        if (pancerzTylKumulRha != null) {
            sb.append("Pancerz tył kumulacyjny RHA: ").append(pancerzTylKumulRha).append(", ");
        }

        if (pancerzSpodKinetRha != null) {
            sb.append("Pancerz spód kinetyczny RHA: ").append(pancerzSpodKinetRha).append(", ");
        }

        if (pancerzSpodKumulRha != null) {
            sb.append("Pancerz spód kumulacyjny RHA: ").append(pancerzSpodKumulRha).append(", ");
        }

        if (pancerzStropKinetRha != null) {
            sb.append("Pancerz strop kinetyczny RHA: ").append(pancerzStropKinetRha).append(", ");
        }

        if (pancerzStropKumulRha != null) {
            sb.append("Pancerz strop kumulacyjny RHA: ").append(pancerzStropKumulRha);
        }

        // Usuń ostatnią przecinkę i spację, jeśli istnieją
        int length = sb.length();
        if (length > 0 && sb.charAt(length - 1) == ' ') {
            sb.setLength(length - 2);
        }

        return sb.toString();
    }

}
