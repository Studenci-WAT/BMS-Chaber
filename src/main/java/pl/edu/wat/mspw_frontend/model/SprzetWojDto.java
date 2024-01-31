package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SprzetWojDto implements Serializable {

    private int id;

    private String nazwa;

    private String skrot;

    private String kod;

    private Integer kategoriaFk;

    private Integer klasa;

    private Integer obsluga;

    private Boolean opancerzony;

    private Double kosztJednCykluZycia;

    private Double kosztJednNabycia;

    private Double kosztJednUtrzymWyszkPerson;

    private Double masa;

    private Double dlug;

    private Double szerok;

    private Double wysok;

    private Double potencjalBoj;

    private Double value;

    private Double pojemZbiorPaliwa;

    private Double pojemZbiorPaliwaDodat;

    private Double pojemAkumulatorow;

    private Boolean jezdzacy;

    private Boolean latajacy;

    private Boolean plywajacy;

    private Boolean przenosny;

    private Boolean ciagniony;

    private Integer efektorLacznFk;

    private Integer rodzajSrodowFk;

    private Integer efektorJezdnyFk;

    private Integer efektorPlywaniaFk;

    private Integer efektorInzFk;

    private Integer efektorWeFk;

    private Integer paramKadlubaFk;

    private Integer efektorTranspFk;

    private Integer efektorLataniaFk;

    private Integer efektorRozpozFk;

    private Integer klasaPrzyrzOc;

    private Double moc;

    private Double zuzyciePaliwaPraca;

    @Override
    public String toString() {
        return "SprzetWojDto{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", skrot='" + skrot + '\'' +
                ", kod='" + kod + '\'' +
                ", kategoriaFk=" + kategoriaFk +
                ", klasa=" + klasa +
                ", obsluga=" + obsluga +
                ", opancerzony=" + opancerzony +
                ", kosztJednCykluZycia=" + kosztJednCykluZycia +
                ", kosztJednNabycia=" + kosztJednNabycia +
                ", kosztJednUtrzymWyszkPerson=" + kosztJednUtrzymWyszkPerson +
                ", masa=" + masa +
                ", dlug=" + dlug +
                ", szerok=" + szerok +
                ", wysok=" + wysok +
                ", potencjalBoj=" + potencjalBoj +
                ", value=" + value +
                ", pojemZbiorPaliwa=" + pojemZbiorPaliwa +
                ", pojemZbiorPaliwaDodat=" + pojemZbiorPaliwaDodat +
                ", pojemAkumulatorow=" + pojemAkumulatorow +
                ", jezdzacy=" + jezdzacy +
                ", latajacy=" + latajacy +
                ", plywajacy=" + plywajacy +
                ", przenosny=" + przenosny +
                ", ciagniony=" + ciagniony +
                ", efektorLacznFk=" + efektorLacznFk +
                ", rodzajSrodowFk=" + rodzajSrodowFk +
                ", efektorJezdnyFk=" + efektorJezdnyFk +
                ", efektorPlywaniaFk=" + efektorPlywaniaFk +
                ", efektorInzFk=" + efektorInzFk +
                ", efektorWeFk=" + efektorWeFk +
                ", paramKadlubaFk=" + paramKadlubaFk +
                ", efektorTranspFk=" + efektorTranspFk +
                ", efektorLataniaFk=" + efektorLataniaFk +
                ", efektorRozpozFk=" + efektorRozpozFk +
                ", klasaPrzyrzOc=" + klasaPrzyrzOc +
                ", moc=" + moc +
                ", zuzyciePaliwaPraca=" + zuzyciePaliwaPraca +
                '}';
    }

}

