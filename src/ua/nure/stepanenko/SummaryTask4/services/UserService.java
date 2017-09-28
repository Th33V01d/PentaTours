package ua.nure.stepanenko.SummaryTask4.services;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.dao.UserDAO;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.entity.User;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;

import java.sql.SQLException;

public class UserService {
    private UserService() {}

    public static User getUser(String login, String password) throws DBConnectException {
        UserDAO userDAO = new UserDAO(DBManager.getInstance());
        User user = userDAO.getUser(login);
        if(user != null) {
            if (user.getPassword().equals(password)) {
                System.out.println(user.isBanned());
                if(!user.isBanned()) {
                    return user;
                }
            }
        }
        return null;
    }

    public static boolean createUser(String login,
                                     String password,
                                     String name,
                                     String lastname,
                                     @Nullable String phone,
                                     @Nullable String email) throws DBConnectException, SQLException {
        UserDAO userDAO;
        boolean res = false;
        userDAO = new UserDAO(DBManager.getInstance());

        if(userDAO.getUser(login) != null) {
            return false;
        }
        if(login == null ||
                password == null ||
                name == null ||
                lastname == null) {
            return false;
        }
        if(login.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.LOGIN) ||
                password.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.PASSWORD) ||
                name.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.NAME) ||
                lastname.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.LASTNAME) ||
                phone.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.PHONE) ||
                email.length() > DBNames.User.VARCHAR_COLUMN_LENGTHS.get(DBNames.User.EMAIL)) {
            return false;
        }
        res = userDAO.createUser(login, password, name, lastname, phone, email);

        return res;
    }
}
