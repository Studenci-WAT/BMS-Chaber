package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorJezdnyEntity;
import pl.edu.wat.mspw_frontend.model.EfektorJezdnyDto;

public class EfektorJezdnyService extends GenericService<EfektorJezdnyEntity, EfektorJezdnyDto> {
    public EfektorJezdnyService() {
        super(EfektorJezdnyEntity.class,
                e -> new EfektorJezdnyDto(e.getId(), e.getRodzajPodwoziaFk(), e.getZuzyciePaliwaPredkEkoDroga(),
                        e.getZuzyciePaliwaPredkEkoTeren(), e.getZuzyciePaliwaMax(), e.getPredkMaxDroga(),
                        e.getPredkMaxTeren(), e.getPredkEkoDroga(), e.getPredkEkoTeren(),
                        e.getSzerokPokonywRowow(), e.getGlebokBrodz()),
                d -> new EfektorJezdnyEntity(d.getId(), d.getRodzajPodwoziaFk(), d.getZuzyciePaliwaPredkEkoDroga(),
                        d.getZuzyciePaliwaPredkEkoTeren(), d.getZuzyciePaliwaMax(), d.getPredkMaxDroga(),
                        d.getPredkMaxTeren(), d.getPredkEkoDroga(), d.getPredkEkoTeren(),
                        d.getSzerokPokonywRowow(), d.getGlebokBrodz())
        );
    }
}
