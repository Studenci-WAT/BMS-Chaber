package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.EfektorJezdnyService;
import pl.edu.wat.mspw_frontend.model.EfektorJezdnyDto;

import java.util.List;

public class TableEfektorJezdnyController extends AbstractTableController<EfektorJezdnyDto, EfektorJezdnyService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorJezdnyService();
    }

    @Override
    protected List<EfektorJezdnyDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorJezdnyDto> getGenericTypeClass() {
        return EfektorJezdnyDto.class;
    }
}

