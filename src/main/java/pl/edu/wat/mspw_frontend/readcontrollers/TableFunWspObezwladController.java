package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunWspObezwladService;
import pl.edu.wat.mspw_frontend.model.FunWspObezwladDto;

import java.util.List;

public class TableFunWspObezwladController extends AbstractTableController<FunWspObezwladDto, FunWspObezwladService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspObezwladService();
    }

    @Override
    protected List<FunWspObezwladDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspObezwladDto> getGenericTypeClass() {
        return FunWspObezwladDto.class;
    }
}

