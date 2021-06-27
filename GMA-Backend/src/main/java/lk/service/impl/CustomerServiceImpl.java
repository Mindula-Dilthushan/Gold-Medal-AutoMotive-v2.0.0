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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            throw new ValidateException("Customer Already Exist");
        }
        System.out.println("customerDTO 37 "+customerDTO);
        customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        System.out.println("customerDTO 39 "+customerDTO);
    }

    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        if (customerRepo.existsById(customerDTO.getCustomerId())) {
            customerRepo.save(modelMapper.map(customerDTO, Customer.class));
        }
    }

    @Override
    public void deleteCustomer(String id) {
        if (!customerRepo.existsById(id)) {
            throw new ValidateException("No customer for Delete..!");
        }
        customerRepo.deleteById(id);
    }

    @Override
    public CustomerDTO searchCustomer(String id) {
        Optional<Customer> customerOptional = customerRepo.findById(id);
        if (customerOptional.isPresent()) {
            return modelMapper.map(customerOptional.get(), CustomerDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {
        List<Customer> customerList = customerRepo.findAll();
        System.out.println("in getall  68");
        return modelMapper.map(customerList, new TypeToken<ArrayList<CustomerDTO>>() {
        }.getType());
    }

    @Override
    public String getLastCustomerID() {
        String lastID = customerRepo.getCustomerLastID();
        if (lastID != null) {
            String[] split = lastID.split("C");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "C00" + id;
            else if (id < 100) return "C0" + id;
            else return "C" + id;
        }else{
            return "C001";
        }
    }

    @Override
    public int getCustomerCount() {
        return customerRepo.getCustomerCount();
    }

    @Override
    public String getCustomerDLIC() {
        String lastID = customerRepo.getCustomerDLIC();
        if (lastID != null) {
            String[] split = lastID.split("DL");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "DL00" + id;
            else if (id < 100) return "DL0" + id;
            else return "C" + id;
        }else{
            return "DL001";
        }
    }

}
