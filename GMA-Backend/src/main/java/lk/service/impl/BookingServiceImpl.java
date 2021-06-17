//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.service.impl;

import lk.dto.BookingDTO;
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

    }

    @Override
    public void updateBooking(BookingDTO bookingDTO) {

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
