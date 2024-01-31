package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.EfektorTranspService;
import pl.edu.wat.mspw_frontend.model.EfektorTranspDto;

import java.util.List;

public class TableEfektorTranspController extends AbstractTableController<EfektorTranspDto, EfektorTranspService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorTranspService();
    }

    @Override
    protected List<EfektorTranspDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorTranspDto> getGenericTypeClass() {
        return EfektorTranspDto.class;
    }
}

