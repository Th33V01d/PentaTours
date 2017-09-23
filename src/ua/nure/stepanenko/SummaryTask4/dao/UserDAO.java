package ua.nure.stepanenko.SummaryTask4.dao;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.Query;
import ua.nure.stepanenko.SummaryTask4.db.entity.User;
import ua.nure.stepanenko.SummaryTask4.db.enums.UserRole;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO extends AbstractDAO {

    public UserDAO(DBManager dbManager) {
        super(dbManager);
    }

    public User getUser(String login) {
        User user = null;
        ResultSet res;
        try(Connection conn = getConnection()) {
            PreparedStatement st = conn.prepareStatement(Query.SELECT_USER);
            st.setString(1, login);
            res = st.executeQuery();

            if (res.next()) {
                user = new User(res.getInt(DBNames.User.ID),
                        res.getString(DBNames.User.LOGIN),
                        res.getString(DBNames.User.NAME),
                        res.getString(DBNames.User.LASTNAME),
                        res.getString(DBNames.User.PASSWORD),
                        UserRole.getEnumValueByRolename(res.getString(DBNames.User.ROLE)),
                        res.getString(DBNames.User.PHONE),
                        res.getString(DBNames.User.EMAIL),
                        res.getBoolean(DBNames.User.IS_BANNED));
            }
        } catch (SQLException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }

        return user;
    }

    public boolean createUser(String login,
                              String password,
                              String name,
                              String lastname,
                              @Nullable String phone,
                              @Nullable String email) throws SQLException {
        boolean res = false;
        try (Connection conn = getConnection()) {
            PreparedStatement st = conn.prepareStatement(Query.CREATE_USER);
            st.setString(1, login);
            st.setString(2, name);
            st.setString(3, lastname);
            st.setString(4, password);
            st.setString(5, UserRole.USER.getRoleName());
            st.setString(6, phone);
            st.setString(7, email);

            st.executeUpdate();

            res = true;
        }

        return res;
    }
}
