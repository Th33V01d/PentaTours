package ua.nure.stepanenko.SummaryTask4.dao;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.db.DBNames;
import ua.nure.stepanenko.SummaryTask4.db.Query;
import ua.nure.stepanenko.SummaryTask4.db.entity.Accommodation;
import ua.nure.stepanenko.SummaryTask4.db.entity.City;
import ua.nure.stepanenko.SummaryTask4.db.entity.Tour;
import ua.nure.stepanenko.SummaryTask4.db.entity.Transport;
import ua.nure.stepanenko.SummaryTask4.db.enums.TourType;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO extends AbstractDAO {
    public CatalogDAO(DBManager dbManager) {
        super(dbManager);
    }

    public List<String> getAllAccommodationTypes() {
        List<String> res = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(Query.SELECT_ACCOM_TYPE);
            while (set.next()) {
                res.add(set.getString(DBNames.Accommodation.TYPE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public List<String> getAllTransportTypes() {
        List<String> res = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(Query.SELECT_TRANSPORT_TYPE);
            while (set.next()) {
                res.add(set.getString(DBNames.Transport.TYPE));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public List<String> getAllCities() {
        List<String> res = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(Query.SELECT_CITIES);
            while (set.next()) {
                res.add(set.getString("city"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }


    public List<Tour> searchTours(@Nullable String city,
                                  @Nullable String transport,
                                  @Nullable String accommodation,
                                  @Nullable Double price_min,
                                  @Nullable Double price_max,
                                  @Nullable Integer quantity) throws BigFieldSizeException, NullFieldException, DBConnectException {
        List<Tour> res = new ArrayList<>();

        try (Connection conn = getConnection()) {
            Statement st = conn.createStatement();
            ResultSet set = st.executeQuery(Query.catalogQueryBuilder(city, transport, accommodation, price_min, price_max, quantity));
            while(set.next()) {
                res.add(new Tour(
                        set.getInt(DBNames.Tour.ID),
                        set.getString(DBNames.Tour.NAME),
                        set.getString(DBNames.Tour.DESCRIPTION),
                        set.getInt(DBNames.Tour.QUANTITY),
                        set.getInt(DBNames.Tour.BOOKED),
                        set.getDouble(DBNames.Tour.PRICE),
                        set.getBoolean(DBNames.Tour.ISFIRE),
                        set.getDouble(DBNames.Tour.DISCOUNT_MAX),
                        set.getDouble(DBNames.Tour.DISCOUNT_STEP),
                        TourType.getEnumValueByRolename(set.getString(DBNames.Tour.TYPE)),
                        set.getTimestamp(DBNames.Tour.DATE_BEGIN),
                        set.getTimestamp(DBNames.Tour.DATE_END),
                        set.getString(DBNames.Tour.IMAGE_LINK)
                ));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public List<City> getCitiesByTourId(int id) {
        List<City> res = new ArrayList<>();

        try(Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(Query.SELECT_TOUR_CITIES);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();

            while(set.next()) {
                res.add(new City(set.getInt(DBNames.City.ID), set.getString(DBNames.City.NAME), set.getInt(DBNames.City.COUNTRY)));
            }

        } catch (SQLException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public List<Accommodation> getAccommodationsByTourId(int id) {
        List<Accommodation> res = new ArrayList<>();

        try(Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(Query.SELECT_TOUR_ACCOMM);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();

            while(set.next()) {
                res.add(new Accommodation(set.getInt(DBNames.Accommodation.ID),
                        set.getString(DBNames.Accommodation.NAME),
                        set.getInt(DBNames.Accommodation.CITY),
                        set.getString(DBNames.Accommodation.ADDRESS),
                        set.getInt(DBNames.Accommodation.STARS),
                        set.getString(DBNames.Accommodation.DESCRIPTION),
                        set.getString(DBNames.Accommodation.LINK),
                        set.getString(DBNames.Accommodation.TYPE)));
            }

        } catch (SQLException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }

    public List<Transport> getTransportsByTourId(int id) {
        List<Transport> res = new ArrayList<>();

        try(Connection conn = getConnection()) {
            PreparedStatement ps = conn.prepareStatement(Query.SELECT_TOUR_TRANSPORT);
            ps.setInt(1, id);
            ResultSet set = ps.executeQuery();

            while(set.next()) {
                res.add(new Transport(set.getInt(DBNames.Transport.ID),
                        set.getString(DBNames.Transport.NAME),
                        set.getString(DBNames.Transport.TYPE),
                        set.getString(DBNames.Transport.DESCRIPTION),
                        set.getInt(DBNames.Transport.QUANTITY)));
            }

        } catch (SQLException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }
        return res;
    }
}
