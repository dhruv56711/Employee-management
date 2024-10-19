package ca.sheridancollege.dhruvyadav.beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private Long id;
    private String title;
    private String department;
    private LocalDate startDate;
    private LocalDate endDate;
    private int age;
}
