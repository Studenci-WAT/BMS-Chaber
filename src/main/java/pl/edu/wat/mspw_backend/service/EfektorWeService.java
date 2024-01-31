package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorWeEntity;
import pl.edu.wat.mspw_frontend.model.EfektorWeDto;

public class EfektorWeService extends GenericService<EfektorWeEntity, EfektorWeDto> {
    public EfektorWeService() {
        super(EfektorWeEntity.class,
                e -> new EfektorWeDto(e.getId(), e.getNamierzPromien(), e.getNamierzCzestotlmin(),
                        e.getNamierzCzestotlMax(), e.getNamierzCzas(), e.getNamierzSzybkoscPrzeszuk(),
                        e.getZaklocPromien(), e.getZaklocCzestotlMin(), e.getZaklocCzestotlMax()),
                d -> new EfektorWeEntity(d.getId(), d.getNamierzPromien(), d.getNamierzCzestotlmin(),
                        d.getNamierzCzestotlMax(), d.getNamierzCzas(), d.getNamierzSzybkoscPrzeszuk(),
                        d.getZaklocPromien(), d.getZaklocCzestotlMin(), d.getZaklocCzestotlMax())
        );
    }
}
