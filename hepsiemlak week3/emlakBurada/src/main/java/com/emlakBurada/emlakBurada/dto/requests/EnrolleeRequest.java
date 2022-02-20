package com.emlakBurada.emlakBurada.dto.requests;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EnrolleeRequest {

    String enrolleeType;
    String name;
    String email;
    String enrolleePhoto;
    String enrolleeDescription;

}
