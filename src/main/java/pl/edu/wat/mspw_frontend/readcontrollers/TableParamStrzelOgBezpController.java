package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.ParamStrzelOgBezpService;
import pl.edu.wat.mspw_frontend.model.ParamStrzelOgBezpDto;

import java.util.List;

public class TableParamStrzelOgBezpController extends AbstractTableController<ParamStrzelOgBezpDto, ParamStrzelOgBezpService> {

    @Override
    protected void initializeService() {
        this.service = new ParamStrzelOgBezpService();
    }

    @Override
    protected List<ParamStrzelOgBezpDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<ParamStrzelOgBezpDto> getGenericTypeClass() {
        return ParamStrzelOgBezpDto.class;
    }
}

