package pl.edu.wat.mspw_frontend.readcontrollers;



import pl.edu.wat.mspw_backend.service.EfektorLataniaService;
import pl.edu.wat.mspw_frontend.model.EfektorLataniaDto;

import java.util.List;

public class TableEfektorLataniaController extends AbstractTableController<EfektorLataniaDto, EfektorLataniaService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorLataniaService();
    }

    @Override
    protected List<EfektorLataniaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorLataniaDto> getGenericTypeClass() {
        return EfektorLataniaDto.class;
    }
}

