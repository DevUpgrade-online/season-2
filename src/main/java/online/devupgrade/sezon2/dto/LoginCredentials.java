package online.devupgrade.sezon2.dto;

import java.util.List;

public class LoginCredentials {
    private String login;
    private String password;
    private List<String> roles;

    public LoginCredentials() {
    }

    public LoginCredentials(String login, String password, List<String> roles) {
        this.login = login;
        this.password = password;
        this.roles = roles;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
