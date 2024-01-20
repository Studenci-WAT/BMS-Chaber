package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.EfektorLacznEntity;
import pl.edu.wat.mspw_frontend.model.EfektorLacznDto;

public class EfektorLacznService extends GenericService<EfektorLacznEntity, EfektorLacznDto> {
    public EfektorLacznService() {
        super(EfektorLacznEntity.class,
                e -> new EfektorLacznDto(e.getId(), e.getLiczbaTraktowKabl(), e.getLiczbaTraktowRadiol(),
                        e.getLiczbaSieciCnrDoPrzylacz(), e.getMocNadajnikaRadiol(), e.getWysokAntenyRadiol(),
                        e.getMocNadajnika(), e.getZasiegNadajnika()),
                d -> new EfektorLacznEntity(d.getId(), d.getLiczbaTraktowKabl(), d.getLiczbaTraktowRadiol(),
                        d.getLiczbaSieciCnrDoPrzylacz(), d.getMocNadajnikaRadiol(), d.getWysokAntenyRadiol(),
                        d.getMocNadajnika(), d.getZasiegNadajnika())
        );
    }
}
