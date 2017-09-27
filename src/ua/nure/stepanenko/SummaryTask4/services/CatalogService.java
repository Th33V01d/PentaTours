package ua.nure.stepanenko.SummaryTask4.services;

import com.sun.istack.internal.Nullable;
import ua.nure.stepanenko.SummaryTask4.dao.CatalogDAO;
import ua.nure.stepanenko.SummaryTask4.db.entity.Accommodation;
import ua.nure.stepanenko.SummaryTask4.db.entity.City;
import ua.nure.stepanenko.SummaryTask4.db.entity.Tour;
import ua.nure.stepanenko.SummaryTask4.db.entity.Transport;
import ua.nure.stepanenko.SummaryTask4.dbmanager.DBManager;
import ua.nure.stepanenko.SummaryTask4.exceptions.BigFieldSizeException;
import ua.nure.stepanenko.SummaryTask4.exceptions.DBConnectException;
import ua.nure.stepanenko.SummaryTask4.exceptions.NullFieldException;

import java.util.List;

public class CatalogService {
    private CatalogService() {}

    public static List<String> getAllAccommodationTypes() throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getAllAccommodationTypes();
    }

    public static List<String> getAllTransportTypes() throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getAllTransportTypes();
    }

    public static List<String> getAllCities() throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getAllCities();
    }

    public static List<Tour> searchTours(@Nullable String city,
                                         @Nullable String transport,
                                         @Nullable String accommodation,
                                         @Nullable Double price_min,
                                         @Nullable Double price_max,
                                         @Nullable Integer quantity) throws DBConnectException, BigFieldSizeException, NullFieldException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.searchTours(city, transport, accommodation, price_min, price_max, quantity);
    }

    public static List<City> getCitiesByTourId(int id) throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getCitiesByTourId(id);
    }

    public static List<Accommodation> getAccommodationsByTourId(int id) throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getAccommodationsByTourId(id);
    }

    public static List<Transport> getTransportsByTourId(int id) throws DBConnectException {
        CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
        return catalogDAO.getTransportsByTourId(id);
    }
}
