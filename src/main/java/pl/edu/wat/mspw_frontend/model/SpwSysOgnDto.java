package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpwSysOgnDto implements Serializable {

    private int id;

    private Integer liczba;

    private Integer spwFk;

    private Integer systemOgnFk;

}
