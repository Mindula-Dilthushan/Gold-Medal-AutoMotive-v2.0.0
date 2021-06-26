//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-17
package lk.service;

import lk.dto.BookingDTO;
import java.util.ArrayList;

public interface BookingService {
    void saveBooking(BookingDTO bookingDTO);
    void updateBooking(BookingDTO bookingDTO);
    void deleteBooking(String id);
    BookingDTO searchBooking(String id);
    ArrayList<BookingDTO>getAllBooking();
    String getLastBookingID();
    int getBookingCount();

}
