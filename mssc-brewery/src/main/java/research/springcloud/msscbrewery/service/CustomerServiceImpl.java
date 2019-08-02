package research.springcloud.msscbrewery.service;

import org.springframework.stereotype.Service;
import research.springcloud.msscbrewery.model.CustomerDTO;

import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public CustomerDTO getCustomerById ( UUID customerId ) {
        return CustomerDTO.builder().id(UUID.randomUUID()).customerName("Perunazhi Gunasingham").customerAddress("Thirupachi gramamm").build();

    }

    @Override
    public void updateCustomer ( UUID customerId, CustomerDTO customerDto ) {

    }

    @Override
    public void deleteCustomer ( UUID customerId ) {

    }

    @Override
    public CustomerDTO saveNewCustomer ( CustomerDTO customerDto ) {
        return null;
    }
}
