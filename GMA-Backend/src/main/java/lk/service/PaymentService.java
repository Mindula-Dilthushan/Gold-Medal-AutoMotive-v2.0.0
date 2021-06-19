//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-19
package lk.service;

import lk.dto.PaymentDTO;
import java.util.ArrayList;

public interface PaymentService {
    void savePayment(PaymentDTO paymentDTO);
    void deletePayment(String id);
    void updatePayment(PaymentDTO paymentDTO);
    PaymentDTO searchPayment(String id);
    ArrayList<PaymentDTO> getAllPayments();
}
