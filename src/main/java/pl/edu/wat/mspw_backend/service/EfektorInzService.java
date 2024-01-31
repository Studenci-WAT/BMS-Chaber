package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorInzEntity;
import pl.edu.wat.mspw_frontend.model.EfektorInzDto;

public class EfektorInzService extends GenericService<EfektorInzEntity, EfektorInzDto> {
    public EfektorInzService() {
        super(EfektorInzEntity.class,
                e -> new EfektorInzDto(e.getId(), e.getDoPracZiemnych(), e.getElementPrzeprProm(),
                        e.getElementPrzeprMost(), e.getNosnosc(), e.getSzerokPrzeprawy()),
                d -> new EfektorInzEntity(d.getId(), d.getDoPracZiemnych(), d.getElementPrzeprProm(),
                        d.getElementPrzeprMost(), d.getNosnosc(), d.getSzerokPrzeprawy())
        );
    }
}
