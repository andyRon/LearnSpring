package com.andyron.sb01.entity.param;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author andyron
 **/
@Data
@Builder
@AllArgsConstructor
public class AddressParam {
    private String city;
    private String zipcode;
}
