package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.SpwSysOgnService;
import pl.edu.wat.mspw_frontend.model.SpwSysOgnDto;

import java.util.List;

public class TableSpwSysOgnController extends AbstractTableController<SpwSysOgnDto, SpwSysOgnService> {

    @Override
    protected void initializeService() {
        this.service = new SpwSysOgnService();
    }

    @Override
    protected List<SpwSysOgnDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<SpwSysOgnDto> getGenericTypeClass() {
        return SpwSysOgnDto.class;
    }
}

