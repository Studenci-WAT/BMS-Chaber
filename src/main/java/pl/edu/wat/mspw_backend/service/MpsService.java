package pl.edu.wat.mspw_backend.service;

import org.w3c.dom.Entity;
import pl.edu.wat.mspw_backend.model.MpsEntity;
import pl.edu.wat.mspw_backend.util.MainDao;
import pl.edu.wat.mspw_frontend.model.MpsDto;

import java.util.List;
import java.util.stream.Collectors;

public class MpsService {
    public void create(MpsDto mps) {
        MainDao.getInstance().createRecord(
                MpsEntity.builder()
                        .nazwa(mps.getNazwa())
                        .skrot(mps.getSkrot())
                        .kod(mps.getKod())
                        .build()
        );
    }

    public List<MpsDto> getAll() {
        return MainDao.getInstance()
                .readAllRecords(MpsEntity.class)
                .stream()
                .map(e ->
                        MpsDto.builder()
                                .nazwa(e.getNazwa())
                                .skrot(e.getSkrot())
                                .kod(e.getKod())
                                .build()
                )
                .collect(Collectors.toList());
    }
}
