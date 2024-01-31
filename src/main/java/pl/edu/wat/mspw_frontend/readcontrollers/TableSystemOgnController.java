package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.SystemOgnService;
import pl.edu.wat.mspw_frontend.model.SystemOgnDto;

import java.util.List;

public class TableSystemOgnController extends AbstractTableController<SystemOgnDto, SystemOgnService> {

    @Override
    protected void initializeService() {
        this.service = new SystemOgnService();
    }

    @Override
    protected List<SystemOgnDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<SystemOgnDto> getGenericTypeClass() {
        return SystemOgnDto.class;
    }
}

