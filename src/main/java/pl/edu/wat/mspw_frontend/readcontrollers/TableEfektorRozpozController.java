package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.EfektorRozpozService;
import pl.edu.wat.mspw_frontend.model.EfektorRozpozDto;

import java.util.List;

public class TableEfektorRozpozController extends AbstractTableController<EfektorRozpozDto, EfektorRozpozService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorRozpozService();
    }

    @Override
    protected List<EfektorRozpozDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorRozpozDto> getGenericTypeClass() {
        return EfektorRozpozDto.class;
    }
}

