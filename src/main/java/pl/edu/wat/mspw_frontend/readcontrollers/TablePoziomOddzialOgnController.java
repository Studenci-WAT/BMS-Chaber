package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.PoziomOddzialOgnService;
import pl.edu.wat.mspw_frontend.model.PoziomOddzialOgnDto;

import java.util.List;

public class TablePoziomOddzialOgnController extends AbstractTableController<PoziomOddzialOgnDto, PoziomOddzialOgnService> {

    @Override
    protected void initializeService() {
        this.service = new PoziomOddzialOgnService();
    }

    @Override
    protected List<PoziomOddzialOgnDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<PoziomOddzialOgnDto> getGenericTypeClass() {
        return PoziomOddzialOgnDto.class;
    }
}

