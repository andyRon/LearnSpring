package com.andyron.tacocloud.pojo;

import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class Order {
    @NotBlank(message="Name is required")
    private String name;

    @NotBlank(message="Street is required")
    private String street;

    @NotBlank(message="City is required")
    private String city;

    @NotBlank(message="State is required")
    private String state;

    @NotBlank(message="Zip code is required")
    private String zip;

    /**
     * 信用卡号
     * @CreditCardNumber 声明该属性的值必须是合法的信用卡号，它要能通过Luhn算法的检查
     */
    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    /**
     * 信用卡到期时间 MM/YY
     * 没有现成的注解实现，通过正则来校验
     */
    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

}
