package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.RodzajPodwoziaEntity;
import pl.edu.wat.mspw_frontend.model.RodzajPodwoziaDto;

public class RodzajPodwoziaService extends GenericService<RodzajPodwoziaEntity, RodzajPodwoziaDto> {
    public RodzajPodwoziaService() {
        super(RodzajPodwoziaEntity.class,
                e -> new RodzajPodwoziaDto(e.getId(), e.getNazwa(), e.getSkrot()),
                d -> new RodzajPodwoziaEntity(d.getId(), d.getNazwa(), d.getSkrot())
        );
    }
}
