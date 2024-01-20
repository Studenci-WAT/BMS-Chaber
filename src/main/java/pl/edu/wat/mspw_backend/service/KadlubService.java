package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.KadlubEntity;
import pl.edu.wat.mspw_frontend.model.KadlubDto;

public class KadlubService extends GenericService<KadlubEntity, KadlubDto> {
    public KadlubService() {
        super(KadlubEntity.class,
                e -> new KadlubDto(e.getId(), e.getPancerzBokKinetRha(), e.getPancerzBokKumulRha(),
                        e.getPancerzFrontKinetRha(), e.getPancerzFrontKumulRha(), e.getPancerzTylKinetRha(),
                        e.getPancerzTylKumulRha(), e.getPancerzSpodKinetRha(), e.getPancerzSpodKumulRha(),
                        e.getPancerzStropKinetRha(), e.getPancerzStropKumulRha()),
                d -> new KadlubEntity(d.getId(), d.getPancerzBokKinetRha(), d.getPancerzBokKumulRha(),
                        d.getPancerzFrontKinetRha(), d.getPancerzFrontKumulRha(), d.getPancerzTylKinetRha(),
                        d.getPancerzTylKumulRha(), d.getPancerzSpodKinetRha(), d.getPancerzSpodKumulRha(),
                        d.getPancerzStropKinetRha(), d.getPancerzStropKumulRha())
        );
    }
}
