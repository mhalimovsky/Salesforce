package dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

public class Account {

    String accountName;
    String website;
    String type;
    String number;
    String industry;
    String accountCity;
    String accountIndex;
    String deliveryCity;
    String deliveryIndex;

    public Account() {
    }
}