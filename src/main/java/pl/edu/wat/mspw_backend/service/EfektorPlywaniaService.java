package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorPlywaniaEntity;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;

public class EfektorPlywaniaService extends GenericService<EfektorPlywaniaEntity, EfektorPlywaniaDto> {
    public EfektorPlywaniaService() {
        super(EfektorPlywaniaEntity.class,
                e -> new EfektorPlywaniaDto(e.getId(), e.getPredkMaxNaWodzie(), e.getPredkEkoNaWodzie(),
                        e.getPredkMaxPodWoda(), e.getPredkEkoPodWoda(), e.getDzielnosc(),
                        e.getZuzyciePaliwaPredkMaxNaWod(), e.getZuzyciePaliwaPredkEkoNaWod(),
                        e.getZuzyciePaliwaPredkMaxPodWod(), e.getZuzyciePaliwaPredkEkoPodWod()),
                d -> new EfektorPlywaniaEntity(d.getId(), d.getPredkMaxNaWodzie(), d.getPredkEkoNaWodzie(),
                        d.getPredkMaxPodWoda(), d.getPredkEkoPodWoda(), d.getDzielnosc(),
                        d.getZuzyciePaliwaPredkMaxNaWod(), d.getZuzyciePaliwaPredkEkoNaWod(),
                        d.getZuzyciePaliwaPredkMaxPodWod(), d.getZuzyciePaliwaPredkEkoPodWod())
        );
    }
}
