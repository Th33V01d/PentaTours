package ua.nure.stepanenko.SummaryTask4.db.entity;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.enums.UserRole;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

public class User extends Entity {
    private String login;
    private String name;
    private String lastname;
    private String password;
    private UserRole role;
    private String phone;
    private String email;
    private boolean isBanned;

    public User(int id,
                String login,
                String name,
                String lastname,
                String password,
                UserRole role,
                @Nullable String phone,
                @Nullable String email,
                boolean isBanned) throws NullFieldException, BigFieldSizeException {
        if(login == null ||
                name == null ||
                lastname == null ||
                password == null ||
                role == null) {
            throw new NullFieldException();
        }

        if(login.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.LOGIN) ||
                name.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.NAME) ||
                lastname.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.LASTNAME) ||
                password.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.PASSWORD)) {
            throw new BigFieldSizeException();
        }
        if(phone != null) {
            if(phone.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.PHONE)) {
                throw new BigFieldSizeException();
            }
        }
        if(email != null) {
            if(email.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.EMAIL)) {
                throw new BigFieldSizeException();
            }
        }


        this.id = id;
        this.login = login;
        this.password = password;
        this.role = role;
        this.phone = phone;
        this.email = email;
        this.isBanned = isBanned;
    }

    // todo: в сеттерах сделать проверку инфы и запрос на UPDATE


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isBanned() {
        return isBanned;
    }

    public void setBanned(boolean banned) {
        isBanned = banned;
    }
}
