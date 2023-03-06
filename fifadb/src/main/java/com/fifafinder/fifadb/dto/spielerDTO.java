package com.fifafinder.fifadb.dto;

import com.fifafinder.fifadb.entities.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class spielerDTO {
    private Integer id;
    private Integer fifaID;
    private String knownName;
    private String fullName;
    private LocalDate birthDate;
    private String countryName;
    private String flag;

    // getters and setters
}
