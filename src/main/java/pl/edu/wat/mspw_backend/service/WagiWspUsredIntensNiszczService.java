package pl.edu.wat.mspw_backend.service;

import pl.edu.wat.mspw_backend.model.SystemOgnEntity;
import pl.edu.wat.mspw_backend.model.WagiWspUsredIntensNiszczEntity;
import pl.edu.wat.mspw_frontend.model.SystemOgnDto;
import pl.edu.wat.mspw_frontend.model.WagiWspUsredIntensNiszczDto;

public class WagiWspUsredIntensNiszczService extends GenericService<WagiWspUsredIntensNiszczEntity, WagiWspUsredIntensNiszczDto> {
    public WagiWspUsredIntensNiszczService() {
        super(WagiWspUsredIntensNiszczEntity.class,
                e -> new WagiWspUsredIntensNiszczDto(
                        e.getId(),
                        e.getTypKlimatuFk(),
                        e.getTypOperacjiPkaFk(),
                        e.getDzien(),
                        e.getPoziomOpadIstotny(),
                        e.getPoziomZamglIstotny(),
                        e.getPoziomFortCelu(),
                        e.getPoziomMaskCeluIstotny(),
                        e.getPoziomZadymCeluIstotny(),
                        e.getMobilStrzelIstotna(),
                        e.getMobilCeluIstotna(),
                        e.getPoziomOddzialOgnPkaFk(),
                        e.getWaga()),
                d -> new WagiWspUsredIntensNiszczEntity(
                        d.getId(),
                        d.getTypKlimatuFk(),
                        d.getTypOperacjiPkaFk(),
                        d.getDzien(),
                        d.getPoziomOpadIstotny(),
                        d.getPoziomZamglIstotny(),
                        d.getPoziomFortCelu(),
                        d.getPoziomMaskCeluIstotny(),
                        d.getPoziomZadymCeluIstotny(),
                        d.getMobilStrzelIstotna(),
                        d.getMobilCeluIstotna(),
                        d.getPoziomOddzialOgnPkaFk(),
                        d.getWaga()
                )
        );
    }
}
