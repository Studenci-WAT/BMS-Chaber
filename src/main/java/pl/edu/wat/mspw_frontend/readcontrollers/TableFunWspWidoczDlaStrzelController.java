package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunWspWidoczDlaStrzelService;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaStrzelDto;

import java.util.List;

public class TableFunWspWidoczDlaStrzelController extends AbstractTableController<FunWspWidoczDlaStrzelDto, FunWspWidoczDlaStrzelService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspWidoczDlaStrzelService();
    }

    @Override
    protected List<FunWspWidoczDlaStrzelDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspWidoczDlaStrzelDto> getGenericTypeClass() {
        return FunWspWidoczDlaStrzelDto.class;
    }
}

