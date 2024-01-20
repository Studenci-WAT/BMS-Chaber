package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunIntensNiszczNosicSym2Entity;
import pl.edu.wat.mspw_frontend.model.FunIntensNiszczNosicSym2Dto;

public class FunIntensNiszczNosicSym2Service extends GenericService<FunIntensNiszczNosicSym2Entity, FunIntensNiszczNosicSym2Dto> {
    public FunIntensNiszczNosicSym2Service() {
        super(FunIntensNiszczNosicSym2Entity.class,
                e -> new FunIntensNiszczNosicSym2Dto(e.getId(), e.getTypTerenuWidoczFk(), e.getTypKlimatuFk(),
                        e.getTypOperacjiFk(), e.getPoziomFort(), e.getIntensywnosc(), e.getOdleg(),
                        e.getCelOpanc(), e.getPoziomWyszk(), e.getPoziomZdolnManewr(), e.getKategStrzelFk(),
                        e.getKategCeluFk(), e.getKlasaStrzel(), e.getKlasaCelu(), e.getWspA(), e.getWspB(),
                        e.getZasiegMin(), e.getZasiegMax(), e.getSpwStrzelFk(), e.getSpwCelFk()),
                d -> new FunIntensNiszczNosicSym2Entity(d.getId(), d.getTypTerenuWidoczFk(), d.getTypKlimatuFk(),
                        d.getTypOperacjiFk(), d.getPoziomFort(), d.getIntensywnosc(), d.getOdleg(),
                        d.getCelOpanc(), d.getPoziomWyszk(), d.getPoziomZdolnManewr(), d.getKategStrzelFk(),
                        d.getKategCeluFk(), d.getKlasaStrzel(), d.getKlasaCelu(), d.getWspA(), d.getWspB(),
                        d.getZasiegMin(), d.getZasiegMax(), d.getSpwStrzelFk(), d.getSpwCelFk())
        );
    }
}
