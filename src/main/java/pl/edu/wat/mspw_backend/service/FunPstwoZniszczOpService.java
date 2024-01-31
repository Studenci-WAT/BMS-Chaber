package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunPstwoZniszczOpEntity;
import pl.edu.wat.mspw_frontend.model.FunPstwoZniszczOpDto;

public class FunPstwoZniszczOpService extends GenericService<FunPstwoZniszczOpEntity, FunPstwoZniszczOpDto> {
    public FunPstwoZniszczOpService() {
        super(FunPstwoZniszczOpEntity.class,
                e -> new FunPstwoZniszczOpDto(e.getId(), e.getPoziomFortCelu(),
                        e.getKlasaStrzel(), e.getKlasaCelu(), e.getPoziomWyszkStrzel(),
                        e.getPstwo(), e.getOdleg()),
                d -> new FunPstwoZniszczOpEntity(d.getId(), d.getPoziomFortCelu(),
                        d.getKlasaStrzel(), d.getKlasaCelu(), d.getPoziomWyszkStrzel(), d.getPstwo(), d.getOdleg())
        );
    }
}
