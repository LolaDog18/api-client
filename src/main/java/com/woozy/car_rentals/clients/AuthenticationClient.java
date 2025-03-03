package com.woozy.car_rentals.clients;

import com.woozy.AuthenticationRequestDto;
import com.woozy.RegisterCustomerRequestDto;
import com.woozy.car_rentals.response.ClientResponse;

public interface AuthenticationClient {
    ClientResponse registerCustomer(RegisterCustomerRequestDto registerCustomerDto);

    ClientResponse authenticateCustomer(AuthenticationRequestDto authenticationCustomerDto);
}
