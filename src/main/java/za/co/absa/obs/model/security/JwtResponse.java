package za.co.absa.obs.model.security;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class JwtResponse implements Serializable {
    private String token;
    private String type = "Bearer";

    public JwtResponse(String token) {
        this.token = token;
    }
}
