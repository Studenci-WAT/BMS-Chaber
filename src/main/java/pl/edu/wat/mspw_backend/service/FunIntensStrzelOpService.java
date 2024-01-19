package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.FunIntensStrzelOpEntity;
import pl.edu.wat.mspw_frontend.model.FunIntensStrzelOpDto;

public class FunIntensStrzelOpService extends GenericService<FunIntensStrzelOpEntity, FunIntensStrzelOpDto> {
    public FunIntensStrzelOpService() {
        super(FunIntensStrzelOpEntity.class,
                e -> new FunIntensStrzelOpDto(e.getId(), e.getKategStrzelFk(), e.getKlasaStrzel(),
                        e.getKategCeluFk(), e.getKlasaCelu(), e.getPoziomWyszkStrzel(),
                        e.getTypOperacjiStrzelFk(), e.getTypOperacjiCeluFk(), e.getOdleg(), e.getIntens()),
                d -> new FunIntensStrzelOpEntity(d.getId(), d.getKategStrzelFk(), d.getKlasaStrzel(),
                        d.getKategCeluFk(), d.getKlasaCelu(), d.getPoziomWyszkStrzel(),
                        d.getTypOperacjiStrzelFk(), d.getTypOperacjiCeluFk(), d.getOdleg(), d.getIntens())
        );
    }
}
