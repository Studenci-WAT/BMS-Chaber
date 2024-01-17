package pl.edu.wat.mspw_backend.model;

//TODO: 1) Zmiana nazwy klasy
//      2) dodanie OpticsClass


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "fun_wsp_widocz_dla_strzel")
public class Fun_wsp_widocz_dla_strzel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //private OpticsClass opticsClass;

    @Column(name = "WSP")
    private float coefficient;

    @Column(name = "POZIOM_ZADYM_ISTOTNY")
    private boolean isSmokeLevelRelevant;

    @Column(name = "POZIOM_ZAMGL_ISTOTNY")
    private boolean isFogLevelRelevant;

    @Column(name = "POZIOM_OPAD_ISTOTNY")
    private boolean isRainfallLevelRelevant;

    @Column(name = "POZIOM_MASK_ISTOTNY")
    private boolean isConcealmentLevelRelevant;

    @Column(name = "DZIEN")
    private boolean isDay;

    @Column(name = "POZIOM_WYSZK")
    private boolean skillLevel;

    @Column(name = "POZIOM_FORT")
    private boolean fortificationLevel;

}
