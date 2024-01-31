package pl.edu.wat.mspw_frontend.readcontrollers;



import pl.edu.wat.mspw_backend.service.EfektorLacznService;
import pl.edu.wat.mspw_frontend.model.EfektorLacznDto;

import java.util.List;

public class TableEfektorLacznController extends AbstractTableController<EfektorLacznDto, EfektorLacznService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorLacznService();
    }

    @Override
    protected List<EfektorLacznDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorLacznDto> getGenericTypeClass() {
        return EfektorLacznDto.class;
    }
}

