package iocexamples.services;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomerService {

    public List<String> getCustomers() {
       return List.of("ali","ekber");
    }
}
