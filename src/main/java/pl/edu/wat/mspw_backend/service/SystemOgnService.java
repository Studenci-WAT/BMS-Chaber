package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.SystemOgnEntity;
import pl.edu.wat.mspw_frontend.model.SystemOgnDto;

public class SystemOgnService  extends GenericService<SystemOgnEntity, SystemOgnDto> {
    public SystemOgnService() {
        super(SystemOgnEntity.class,
                e -> new SystemOgnDto(
                        e.getId(), e.getNazwa(), e.getSkrot(), e.getSzybkostrzelnosc(), e.getKaliber(), e.getDlugSerii(), e.getCzasCelowania(), e.getLiczbaKanCel(), e.getRodzajSystemuOgnFk(), e.getKlasaPrzyrzOc()
                ),
                d -> new SystemOgnEntity(
                        d.getId(), d.getNazwa(), d.getSkrot(), d.getSzybkostrzelnosc(), d.getKaliber(), d.getDlugSerii(), d.getCzasCelowania(), d.getLiczbaKanCel(), d.getRodzajSystemuOgnFk(), d.getKlasaPrzyrzOc()
                )
        );
    }
}
