//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-16
package lk.service.impl;

import lk.dto.CustomerDTO;
import lk.entity.Customer;
import lk.exeption.ValidateException;
import lk.repo.CustomerRepo;
import lk.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())){
            throw new ValidateException("Customer Already Exist");
        }
        System.out.println(customerDTO);
        customerRepo.save(
                modelMapper.map(customerDTO, Customer.class)
        );
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {

    }

    @Override
    public void deleteCustomer(String id) {

    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        return null;
    }
}
