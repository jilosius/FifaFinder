package com.fifafinder.fifadb.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ClubDTO {
    private Integer clubID;
    private String clubName;
    private String clubLogo;
}
