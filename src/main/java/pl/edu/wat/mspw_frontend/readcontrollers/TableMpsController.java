package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.MpsService;
import pl.edu.wat.mspw_frontend.model.MpsDto;


import java.util.List;

public class TableMpsController extends AbstractTableController<MpsDto, MpsService> {

    @Override
    protected void initializeService() {
        this.service = new MpsService();
    }

    @Override
    protected List<MpsDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<MpsDto> getGenericTypeClass() {
        return MpsDto.class;
    }
}

