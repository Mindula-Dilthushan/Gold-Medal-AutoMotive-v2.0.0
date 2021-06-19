//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service.impl;

import lk.dto.PaymentDTO;
import lk.entity.Payment;
import lk.exeption.ValidateException;
import lk.repo.PaymentRepo;
import lk.service.PaymentService;
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
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void savePayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getPaymentId())){
            throw new ValidateException("Payment Already Exist");
        }
        System.out.println(paymentDTO);
        paymentRepo.save(
                modelMapper.map(paymentDTO, Payment.class)
        );
    }

    @Override
    public void deletePayment(String id) {
        if (!paymentRepo.existsById(id)){
            throw new ValidateException("No Payment for Delete..!");
        }
    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {
        if (paymentRepo.existsById(paymentDTO.getPaymentId())){
            paymentRepo.save(modelMapper.map(paymentDTO, Payment.class));
        }
    }

    @Override
    public PaymentDTO searchPayment(String id) {
        Optional<Payment> paymentOptional = paymentRepo.findById(id);
        if (paymentOptional.isPresent()){
            return modelMapper.map(paymentOptional.get(), PaymentDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() {
        List<Payment> paymentList = paymentRepo.findAll();
        return modelMapper.map(paymentList,new TypeToken<ArrayList<PaymentDTO>>(){
        }.getType());
    }
}
