//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service.impl;

import lk.dto.PaymentDTO;
import lk.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class PaymentServiceImpl implements PaymentService {

    @Override
    public void savePayment(PaymentDTO paymentDTO) {

    }

    @Override
    public void deletePayment(PaymentDTO paymentDTO) {

    }

    @Override
    public void updatePayment(PaymentDTO paymentDTO) {

    }

    @Override
    public PaymentDTO searchPayment(String id) {
        return null;
    }

    @Override
    public ArrayList<PaymentDTO> getAllPayments() {
        return null;
    }
}
