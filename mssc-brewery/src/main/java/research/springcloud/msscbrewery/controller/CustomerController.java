package research.springcloud.msscbrewery.controller;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import research.springcloud.msscbrewery.model.BeerDTO;
import research.springcloud.msscbrewery.model.CustomerDTO;
import research.springcloud.msscbrewery.service.CustomerService;

import java.util.UUID;

@RequestMapping("/api/v1/customer")
@RestController
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping({"/{customerId}"})
    public ResponseEntity<CustomerDTO> getBeer( @PathVariable("customerId") UUID customerId){
        System.out.println("inside beer controller");
        return new ResponseEntity<>(customerService.getCustomerById(customerId), HttpStatus.OK);


    }

    @PostMapping
    public ResponseEntity handlePost(@RequestBody CustomerDTO customerDto){
        System.out.println("inside beer save");
        CustomerDTO savedCustomer = customerService.saveNewCustomer(customerDto);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+savedCustomer.getId().toString());

        return new ResponseEntity(headers,HttpStatus.CREATED);
    }


    @PutMapping("/{customerId}")
    public ResponseEntity handleUpdate(@PathVariable("customerId") UUID customerId, CustomerDTO customerDto){
        System.out.println("inside customer UPDATE");
        customerService.updateCustomer(customerId,customerDto);


        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/v1/customer/"+customerDto.getId().toString());

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }



    @DeleteMapping("/{customerId}")
    public ResponseEntity handleDelete(@PathVariable("customerId") UUID customerId){
        System.out.println("inside customer delete");
        customerService.deleteCustomer(customerId);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
