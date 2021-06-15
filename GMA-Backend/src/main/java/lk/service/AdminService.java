//Alpha X Software Company
//Mindula Dilthushan
//GMA v2.0.3
package lk.service;

import lk.dto.AdminDTO;
import java.util.ArrayList;

public interface AdminService {
    void saveAdmin(AdminDTO adminDTO);
    AdminDTO searchAdmin(String id);
    void updateAdmin(AdminDTO adminDTO);
    void deleteAdmin(String id);
    ArrayList<AdminDTO> getAllAdmin();
}
