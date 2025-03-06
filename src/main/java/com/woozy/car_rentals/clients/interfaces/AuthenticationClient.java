package com.woozy.car_rentals.clients.interfaces;

import com.woozy.AuthenticationRequestDto;
import com.woozy.RegisterCustomerRequestDto;
import com.woozy.car_rentals.response.ClientResponse;

public interface AuthenticationClient {
    ClientResponse registerCustomer(RegisterCustomerRequestDto registerCustomerDto);

    ClientResponse authenticateCustomer(AuthenticationRequestDto authenticationCustomerDto);
}
