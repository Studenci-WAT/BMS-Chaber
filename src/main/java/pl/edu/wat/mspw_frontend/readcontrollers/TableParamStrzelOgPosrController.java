package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.ParamStrzelOgPosrService;
import pl.edu.wat.mspw_frontend.model.ParamStrzelOgPosrDto;

import java.util.List;

public class TableParamStrzelOgPosrController extends AbstractTableController<ParamStrzelOgPosrDto, ParamStrzelOgPosrService> {

    @Override
    protected void initializeService() {
        this.service = new ParamStrzelOgPosrService();
    }

    @Override
    protected List<ParamStrzelOgPosrDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<ParamStrzelOgPosrDto> getGenericTypeClass() {
        return ParamStrzelOgPosrDto.class;
    }
}

