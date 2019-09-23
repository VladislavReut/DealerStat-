package dealerstat.domain.entites;
import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, TRADER, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
