package pl.edu.wat.mspw_projekt.model;
//TODO: 1) zmiana nazwy klasy

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
@Table(name = "fun_wsp_ukrycia")

public class Fun_wsp_ukrycia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne()
    @JoinColumn(name = "TYP_TERENU_WIDOCZ_FK")
    private TerrainVisibility terrainVisibility;

    @Column(name = "WSP")
    private float coefficient;

    @Column(name = "POZIOM_FORT")
    private int fortificationLevel;
}
