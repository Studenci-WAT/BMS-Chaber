package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.AmoService;
import pl.edu.wat.mspw_frontend.model.AmoDto;

import java.util.List;

public class TableAmoController extends AbstractTableController<AmoDto, AmoService> {

    @Override
    protected void initializeService() {
        this.service = new AmoService();
    }

    @Override
    protected List<AmoDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<AmoDto> getGenericTypeClass() {
        return AmoDto.class;
    }
}

