package pl.edu.wat.mspw_frontend.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EfektorWeDto implements Serializable {

    private int id;

    private Integer namierzPromien;

    private Integer namierzCzestotlmin;

    private Integer namierzCzestotlMax;

    private Integer namierzCzas;

    private Integer namierzSzybkoscPrzeszuk;

    private Integer zaklocPromien;

    private Integer zaklocCzestotlMin;

    private Integer zaklocCzestotlMax;

}
