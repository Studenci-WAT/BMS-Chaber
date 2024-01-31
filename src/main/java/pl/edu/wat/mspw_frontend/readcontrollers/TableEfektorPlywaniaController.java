package pl.edu.wat.mspw_frontend.readcontrollers;

import pl.edu.wat.mspw_backend.service.EfektorPlywaniaService;
import pl.edu.wat.mspw_frontend.model.EfektorPlywaniaDto;

import java.util.List;

public class TableEfektorPlywaniaController extends AbstractTableController<EfektorPlywaniaDto, EfektorPlywaniaService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorPlywaniaService();
    }

    @Override
    protected List<EfektorPlywaniaDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorPlywaniaDto> getGenericTypeClass() {
        return EfektorPlywaniaDto.class;
    }
}

