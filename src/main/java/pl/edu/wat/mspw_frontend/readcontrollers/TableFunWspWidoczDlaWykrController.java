package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunWspWidoczDlaWykrService;
import pl.edu.wat.mspw_frontend.model.FunWspWidoczDlaWykrDto;

import java.util.List;

public class TableFunWspWidoczDlaWykrController extends AbstractTableController<FunWspWidoczDlaWykrDto, FunWspWidoczDlaWykrService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspWidoczDlaWykrService();
    }

    @Override
    protected List<FunWspWidoczDlaWykrDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspWidoczDlaWykrDto> getGenericTypeClass() {
        return FunWspWidoczDlaWykrDto.class;
    }
}

