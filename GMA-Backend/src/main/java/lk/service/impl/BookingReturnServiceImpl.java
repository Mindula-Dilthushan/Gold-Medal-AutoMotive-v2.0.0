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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingReturnServiceImpl implements BookingReturnService {


    @Autowired
    private BookingReturnRepo bookingReturnRepo;

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
        if (bookingReturnRepo.existsById(bookingReturnDTO.getBookingReturnId())) {
            bookingReturnRepo.save(modelMapper.map(bookingReturnDTO, BookingReturn.class));
        }
    }

    @Override
    public void deleteBookingReturn(String id) {
        if (!bookingReturnRepo.existsById(id)) {
            throw new ValidateException("No Booking Return for Delete..!");
        }
        bookingReturnRepo.deleteById(id);
    }

    @Override
    public BookingReturnDTO searchBookingReturn(String id) {
        Optional<BookingReturn> bookingReturnOptional = bookingReturnRepo.findById(id);
        if (bookingReturnOptional.isPresent()){
            return modelMapper.map(bookingReturnOptional.get(), BookingReturnDTO.class);
        }
        return null;
    }

    @Override
    public List<BookingReturnDTO> getAllBookingReturns() {
        List<BookingReturn> bookingReturnList = bookingReturnRepo.findAll();
        return modelMapper.map(bookingReturnList, new TypeToken<ArrayList<BookingReturnDTO>>() {
        }.getType());
    }
}
