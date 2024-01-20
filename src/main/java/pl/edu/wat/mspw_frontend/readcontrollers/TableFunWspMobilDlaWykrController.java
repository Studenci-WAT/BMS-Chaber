package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunWspMobilDlaWykrService;
import pl.edu.wat.mspw_frontend.model.FunWspMobilDlaWykrDto;

import java.util.List;

public class TableFunWspMobilDlaWykrController extends AbstractTableController<FunWspMobilDlaWykrDto, FunWspMobilDlaWykrService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspMobilDlaWykrService();
    }

    @Override
    protected List<FunWspMobilDlaWykrDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspMobilDlaWykrDto> getGenericTypeClass() {
        return FunWspMobilDlaWykrDto.class;
    }
}

