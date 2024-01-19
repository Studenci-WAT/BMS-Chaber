package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StanAmoSpwDto implements Serializable {

    private int id;

    private Integer spwFk;

    private Integer amoFk;

    private Integer stanNormatyw;

}
