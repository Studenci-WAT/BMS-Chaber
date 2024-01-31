package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorLataniaEntity;
import pl.edu.wat.mspw_frontend.model.EfektorLataniaDto;

public class EfektorLataniaService extends GenericService<EfektorLataniaEntity, EfektorLataniaDto> {
    public EfektorLataniaService() {
        super(EfektorLataniaEntity.class,
                e -> new EfektorLataniaDto(e.getId(), e.getPredkMin(), e.getPredkEko(),
                        e.getPredkMax(), e.getWysokMin(), e.getWysokPrzelot(),
                        e.getWysokMax(), e.getZuzyciePredkMin(), e.getZuzyciePredkPrzelot(),
                        e.getZuzyciePredkMax()),
                d -> new EfektorLataniaEntity(d.getId(), d.getPredkMin(), d.getPredkEko(),
                        d.getPredkMax(), d.getWysokMin(), d.getWysokPrzelot(),
                        d.getWysokMax(), d.getZuzyciePredkMin(), d.getZuzyciePredkPrzelot(),
                        d.getZuzyciePredkMax())
        );
    }
}
