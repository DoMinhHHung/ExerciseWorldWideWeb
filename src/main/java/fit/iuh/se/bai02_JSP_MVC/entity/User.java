package fit.iuh.se.bai02_JSP_MVC.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private String dob;
    private String gender;
}
