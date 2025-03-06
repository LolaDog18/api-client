package com.woozy.car_rentals.clients.interfaces;

import com.woozy.UpdateCustomerRequestDto;
import com.woozy.car_rentals.response.ClientResponse;

public interface CustomerServiceClient extends Authenticated {
    ClientResponse getCustomer(String userId);

    ClientResponse updateCustomer(String userId, UpdateCustomerRequestDto updateCustomerDto);

    ClientResponse deleteCustomer(String userId);
}
