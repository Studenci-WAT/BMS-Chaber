package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FunPstwoZniszczTrafObDto implements Serializable {

    private int id;

    private Integer sysOgnFk;

    private Integer amoFk;

    private Integer spwCelFk;

    private Double odleg;

    private Double pstwo;

}
