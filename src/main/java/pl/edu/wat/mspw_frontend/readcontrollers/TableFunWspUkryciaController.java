package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.FunWspUkryciaService;
import pl.edu.wat.mspw_frontend.model.FunWspUkryciaDto;

import java.util.List;

public class TableFunWspUkryciaController extends AbstractTableController<FunWspUkryciaDto, FunWspUkryciaService> {

    @Override
    protected void initializeService() {
        this.service = new FunWspUkryciaService();
    }

    @Override
    protected List<FunWspUkryciaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<FunWspUkryciaDto> getGenericTypeClass() {
        return FunWspUkryciaDto.class;
    }
}

