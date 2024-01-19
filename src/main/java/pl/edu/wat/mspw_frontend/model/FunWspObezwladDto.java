package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunWspObezwladDto implements Serializable {

    private int id;

    private Integer poziomOddzialOgnFk;

    private Double wsp;

    private Boolean strzelOpanc;

    private Integer poziomWyszk;

}
