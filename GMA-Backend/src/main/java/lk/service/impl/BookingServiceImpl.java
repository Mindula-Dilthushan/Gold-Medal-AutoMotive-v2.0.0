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
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookingServiceImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public void saveBooking(BookingDTO bookingDTO) {

        Booking booking = modelMapper.map(bookingDTO, Booking.class);
        booking.setBookingId(getLastBookingID());

        Booking booking1 = new Booking(
                booking.getBookingId(),
                booking.getBookingDate(),
                booking.getBookingPickDate(),
                booking.getBookingStatus(),
                booking.getBookingNote(),
                booking.getBookingReturnDate(),
                booking.getCustomerId(),
                booking.getCarId(),
                booking.getDriverId()
        );
        bookingRepo.save(booking1);
    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {
        if (bookingRepo.existsById(bookingDTO.getBookingId())) {
            bookingRepo.save(modelMapper.map(bookingDTO, Booking.class));
        }
    }

    @Override
    public void deleteBooking(String id) {
        if (!bookingRepo.existsById(id)) {
            throw new ValidateException("No Booking for Delete..!");
        }
        bookingRepo.deleteById(id);
    }

    @Override
    public BookingDTO searchBooking(String id) {
        Optional<Booking> bookingOptional = bookingRepo.findById(id);
        if (bookingOptional.isPresent()){
            return modelMapper.map(bookingOptional.get(), BookingDTO.class);
        }
        return null;
    }

    @Override
    public ArrayList<BookingDTO> getAllBooking() {
        List<Booking> bookingList = bookingRepo.findAll();
        return modelMapper.map(bookingList, new TypeToken<ArrayList<BookingDTO>>() {
        }.getType());
    }

    @Override
    public String getLastBookingID() {
        String lastID = bookingRepo.getLastBookingID();
        if (lastID != null) {
            String[] split = lastID.split("B");
            int id = Integer.parseInt(split[1]);
            id++;
            if (id < 10) return "B00" + id;
            else if (id < 100) return "B0" + id;
            else return "B" + id;
        }else{
            return "B001";
        }
    }

    @Override
    public int getBookingCount() {
        return bookingRepo.getBookingCount();
    }
}
