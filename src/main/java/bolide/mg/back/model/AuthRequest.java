package bolide.mg.back.model;

import lombok.Data;

@Data
public class AuthRequest {
    private String email;
    private String password;
}
