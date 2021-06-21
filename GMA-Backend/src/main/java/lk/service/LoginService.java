//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
//21-06-21
package lk.service;

import lk.dto.LoginDTO;
import java.util.ArrayList;

public interface LoginService {
    void saveLogin(LoginDTO loginDTO);
    void deleteLogin(String id);
    void updateLogin(LoginDTO loginDTO);
    LoginDTO searchLogin(String id);
    ArrayList<LoginDTO> getAllLogs();
}
