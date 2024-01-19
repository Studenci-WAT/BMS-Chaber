package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunPstwoZniszczOpEntity;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczOpDto;

public class FunPstwoZniszczOpService extends GenericService<FunPstwoZniszczOpEntity, FunPstwoZniszczOpDto> {
    public FunPstwoZniszczOpService() {
        super(FunPstwoZniszczOpEntity.class,
                e -> new FunPstwoZniszczOpDto(e.getId(), e.getPoziomFortCelu(), e.getKategStrzelFk(),
                        e.getKlasaStrzel(), e.getKategCeluFk(), e.getKlasaCelu(), e.getPoziomWyszkStrzel(),
                        e.getSpwStrzelFk(), e.getSpwCelFk(), e.getPstwo(), e.getOdleg()),
                d -> new FunPstwoZniszczOpEntity(d.getId(), d.getPoziomFortCelu(), d.getKategStrzelFk(),
                        d.getKlasaStrzel(), d.getKategCeluFk(), d.getKlasaCelu(), d.getPoziomWyszkStrzel(),
                        d.getSpwStrzelFk(), d.getSpwCelFk(), d.getPstwo(), d.getOdleg())
        );
    }
}
