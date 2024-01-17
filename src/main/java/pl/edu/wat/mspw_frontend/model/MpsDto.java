package pl.edu.wat.mspw_frontend.model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MpsDto implements Serializable {

    private String nazwa;

    private String skrot;

    private String kod;
}
