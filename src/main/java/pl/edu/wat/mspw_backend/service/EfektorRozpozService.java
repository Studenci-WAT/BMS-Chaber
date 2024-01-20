package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorRozpozEntity;
import pl.edu.wat.mspw_frontend.model.EfektorRozpozDto;

public class EfektorRozpozService extends GenericService<EfektorRozpozEntity, EfektorRozpozDto> {
    public EfektorRozpozService() {
        super(EfektorRozpozEntity.class,
                e -> new EfektorRozpozDto(e.getId(), e.getRozpozAkust(), e.getRozpozAkustPromien(),
                        e.getRozpozTermicz(), e.getRozpozTermiczPromienDzien(), e.getRozpozTermiczPromienNoc(),
                        e.getRozpozNoktow(), e.getRozpozNoktowPromien(), e.getRozpozRadar(), e.getRozpozRadarPromien(),
                        e.getKlasaPrzyrzOc()),
                d -> new EfektorRozpozEntity(d.getId(), d.getRozpozAkust(), d.getRozpozAkustPromien(),
                        d.getRozpozTermicz(), d.getRozpozTermiczPromienDzien(), d.getRozpozTermiczPromienNoc(),
                        d.getRozpozNoktow(), d.getRozpozNoktowPromien(), d.getRozpozRadar(), d.getRozpozRadarPromien(),
                        d.getKlasaPrzyrzOc())
        );
    }
}
