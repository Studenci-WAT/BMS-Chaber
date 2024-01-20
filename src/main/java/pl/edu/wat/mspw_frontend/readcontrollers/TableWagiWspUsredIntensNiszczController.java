package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.WagiWspUsredIntensNiszczService;
import pl.edu.wat.mspw_frontend.model.WagiWspUsredIntensNiszczDto;

import java.util.List;

public class TableWagiWspUsredIntensNiszczController extends AbstractTableController<WagiWspUsredIntensNiszczDto, WagiWspUsredIntensNiszczService> {

    @Override
    protected void initializeService() {
        this.service = new WagiWspUsredIntensNiszczService();
    }

    @Override
    protected List<WagiWspUsredIntensNiszczDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<WagiWspUsredIntensNiszczDto> getGenericTypeClass() {
        return WagiWspUsredIntensNiszczDto.class;
    }
}

