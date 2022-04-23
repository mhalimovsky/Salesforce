package dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Contact {
    String greeting;
    String firstName;
    String lastName;
    String organization;
    String email;
    String mobile;
    String city;


}
