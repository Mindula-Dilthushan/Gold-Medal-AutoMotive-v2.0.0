//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.service.impl;

import lk.dto.BookingReturnDTO;
import lk.entity.BookingReturn;
import lk.exeption.ValidateException;
import lk.repo.BookingRepo;
import lk.repo.BookingReturnRepo;
import lk.service.BookingReturnService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookingReturnServiceImpl implements BookingReturnService {


    @Autowired
    private BookingReturnRepo bookingReturnRepo;

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveBookingReturn(BookingReturnDTO bookingReturnDTO) {
        if (bookingReturnRepo.existsById(bookingReturnDTO.getBookingReturnId())) {
            throw new ValidateException("BookingReturn Already Exist");
        }
        System.out.println(bookingReturnDTO);
        bookingReturnRepo.save(modelMapper.map(bookingReturnDTO, BookingReturn.class));
    }

    @Override
    public void updateBookingReturn(BookingReturnDTO bookingReturnDTO) {

    }

    @Override
    public void deleteBookingReturn(String id) {

    }

    @Override
    public BookingReturnDTO searchBookingReturn(String id) {
        return null;
    }

    @Override
    public List<BookingReturnDTO> getAllBookingReturns() {
        return null;
    }
}
