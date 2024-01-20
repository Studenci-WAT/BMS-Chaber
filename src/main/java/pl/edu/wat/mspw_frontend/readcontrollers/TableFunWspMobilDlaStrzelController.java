package pl.edu.wat.mspw_frontend.readcontrollers;


import pl.edu.wat.mspw_backend.service.FunWspMobilDlaStrzelService;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaStrzelDto;

import java.util.List;

public class TableFunWspMobilDlaStrzelController extends AbstractTableController<FunWspMobilDlaStrzelDto, FunWspMobilDlaStrzelService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspMobilDlaStrzelService();
    }

    @Override
    protected List<FunWspMobilDlaStrzelDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspMobilDlaStrzelDto> getGenericTypeClass() {
        return FunWspMobilDlaStrzelDto.class;
    }
}

