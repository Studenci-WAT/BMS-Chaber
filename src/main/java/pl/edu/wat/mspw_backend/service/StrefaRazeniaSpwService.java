package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.StrefaRazeniaSpwEntity;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSpwDto;

public class StrefaRazeniaSpwService extends GenericService<StrefaRazeniaSpwEntity, StrefaRazeniaSpwDto>{
    public StrefaRazeniaSpwService() {
        super(StrefaRazeniaSpwEntity.class,
                e -> new StrefaRazeniaSpwDto(
                        e.getId(), e.getAmoFk(), e.getPowRazCelOdkr(), e.getPowRazCelZakr(), e.getOdlegStrzel(), e.getKategSpwFk()
                ),
                d -> new StrefaRazeniaSpwEntity(
                        d.getId(), d.getAmoFk(), d.getPowRazCelOdkr(), d.getPowRazCelZakr(), d.getOdlegStrzel(), d.getKategSpwFk()
                )
        );
    }
}
