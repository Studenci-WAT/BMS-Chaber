package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunIntensNiszczNosicSymEntity;
import pl.edu.wat.mspw_frontend.model.FunIntensNiszczNosicSymDto;

public class FunIntensNiszczNosicSymService extends GenericService<FunIntensNiszczNosicSymEntity, FunIntensNiszczNosicSymDto> {
    public FunIntensNiszczNosicSymService() {
        super(FunIntensNiszczNosicSymEntity.class,
                e -> new FunIntensNiszczNosicSymDto(e.getId(), e.getTypTerenuWidoczFk(), e.getTypKlimatuFk(),
                        e.getTypOperacjiFk(), e.getIntensywnosc(), e.getOdleg(), e.getCelOpanc(),
                        e.getPoziomWyszk(), e.getPoziomZdolnManewr(), e.getKategStrzelFk(),
                        e.getKategCeluFk(), e.getKlasaStrzel(), e.getKlasaCelu(), e.getWspA(),
                        e.getWspB(), e.getZasiegMin(), e.getZasiegMax(), e.getSpwStrzelFk(),
                        e.getSpwCelFk()),
                d -> new FunIntensNiszczNosicSymEntity(d.getId(), d.getTypTerenuWidoczFk(), d.getTypKlimatuFk(),
                        d.getTypOperacjiFk(), d.getIntensywnosc(), d.getOdleg(), d.getCelOpanc(),
                        d.getPoziomWyszk(), d.getPoziomZdolnManewr(), d.getKategStrzelFk(),
                        d.getKategCeluFk(), d.getKlasaStrzel(), d.getKlasaCelu(), d.getWspA(),
                        d.getWspB(), d.getZasiegMin(), d.getZasiegMax(), d.getSpwStrzelFk(),
                        d.getSpwCelFk())
        );
    }
}
