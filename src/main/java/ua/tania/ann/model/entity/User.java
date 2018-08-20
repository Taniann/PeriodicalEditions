package ua.tania.ann.model.entity;

/**
 * Created by Таня on 17.08.2018.
 */
public class User {
    private int id;
    private String email;
    private String phone;
    private String login;
    private String password;
    private boolean isAdmin;
    private String firstName;
    private String secondName;
    private String middleName;

    public User() {
    }

    public User(String email, String phone, String login, String password, boolean isAdmin) {
        this.email = email;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.isAdmin = isAdmin;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
}
