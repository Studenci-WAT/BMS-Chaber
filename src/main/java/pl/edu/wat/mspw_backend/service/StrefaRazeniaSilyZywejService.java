package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.StrefaRazeniaSilyZywejEntity;
import pl.edu.wat.mspw_frontend.model.StrefaRazeniaSilyZywejDto;

public class StrefaRazeniaSilyZywejService extends GenericService<StrefaRazeniaSilyZywejEntity, StrefaRazeniaSilyZywejDto> {
    public StrefaRazeniaSilyZywejService() {
        super(StrefaRazeniaSilyZywejEntity.class,
                e -> new StrefaRazeniaSilyZywejDto(e.getId(), e.getAmoFk(), e.getOdlegStrzel(), e.getPowRazOdkr(),
                        e.getPowRazRozbDorazna(), e.getPowRazRozbPrzygot()),
                d -> new StrefaRazeniaSilyZywejEntity(d.getId(), d.getAmoFk(), d.getOdlegStrzel(), d.getPowRazOdkr(),
                        d.getPowRazRozbDorazna(), d.getPowRazRozbPrzygot())
        );
    }
}