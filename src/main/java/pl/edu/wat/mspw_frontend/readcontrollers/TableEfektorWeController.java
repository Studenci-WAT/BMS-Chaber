package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.EfektorWeService;
import pl.edu.wat.mspw_frontend.model.EfektorWeDto;

import java.util.List;

public class TableEfektorWeController extends AbstractTableController<EfektorWeDto, EfektorWeService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorWeService();
    }

    @Override
    protected List<EfektorWeDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorWeDto> getGenericTypeClass() {
        return EfektorWeDto.class;
    }
}

