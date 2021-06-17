//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.service;

import lk.dto.BookingReturnDTO;
import java.util.List;

public interface BookingReturnService {

    void saveBookingReturn(BookingReturnDTO bookingReturnDTO);
    void updateBookingReturn(BookingReturnDTO bookingReturnDTO);
    void deleteBookingReturn(String id);
    BookingReturnDTO searchBookingReturn(String id);
    List<BookingReturnDTO> getAllBookingReturns();
}
