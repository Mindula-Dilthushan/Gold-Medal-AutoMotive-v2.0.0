//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
//21-06-21 (Method Update)
package lk.service.impl;

import lk.dto.BookingDTO;
import lk.entity.Booking;
import lk.exeption.ValidateException;
import lk.repo.BookingRepo;
import lk.service.BookingService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {
        if (bookingRepo.existsById(bookingDTO.getBookingId())) {
            throw new ValidateException("BookingReturn Already Exist");
        }
        System.out.println(bookingDTO);
        bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        if (bookingRepo.existsById(bookingDTO.getBookingId())) {
            bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        }
    }

    @Override
    public void deleteBooking(String id) {

    }

    @Override
    public BookingDTO searchBooking(String id) {
        return null;
    }

    @Override
    public ArrayList<BookingDTO> getAllBooking() {
        return null;
    }
}
