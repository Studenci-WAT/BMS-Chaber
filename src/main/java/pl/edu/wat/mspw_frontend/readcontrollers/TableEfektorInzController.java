package pl.edu.wat.mspw_frontend.readcontrollers;



import pl.edu.wat.mspw_backend.service.EfektorInzService;
import pl.edu.wat.mspw_frontend.model.EfektorInzDto;

import java.util.List;

public class TableEfektorInzController extends AbstractTableController<EfektorInzDto, EfektorInzService> {

    @Override
    protected void initializeService() {
        this.service = new EfektorInzService();
    }

    @Override
    protected List<EfektorInzDto> fetchData() {
        return service.getAll();
    }

    @Override
    protected Class<EfektorInzDto> getGenericTypeClass() {
        return EfektorInzDto.class;
    }
}

