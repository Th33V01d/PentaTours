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

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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

    public static void setSortParameters(HttpServletRequest req) {
        try {
            req.setAttribute("cities", CatalogService.getAllCities());
            req.setAttribute("accomms", CatalogService.getAllAccommodationTypes());
            req.setAttribute("transports", CatalogService.getAllTransportTypes());
        } catch (DBConnectException e) {
            e.printStackTrace();
        }
    }

    public static void searchTours(HttpServletRequest req) {
        String city = null;
        String transport = null;
        String accommodation = null;
        Double priceMin = null;
        Double priceMax = null;
        Integer quantity = null;

        city = req.getParameter("city");
        transport = req.getParameter("transport");
        accommodation = req.getParameter("accommodation");
        String price_min = req.getParameter("price_min");
        String price_max = req.getParameter("price_max");
        String quant = req.getParameter("quant");

        if(price_min != null) {
            if(!"".equals(price_min)) {
                priceMin = Double.parseDouble(price_min);
            }
        }
        if(price_max != null) {
            if(!"".equals(price_max)) {
                priceMax = Double.parseDouble(price_max);
            }
        }
        if(quant != null) {
            if(!"".equals(quant)) {
                quantity = Integer.parseInt(quant);
            }
        }

        List<Tour> tours = new ArrayList<>();
        boolean found = false;

        try {
            CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
            tours = catalogDAO.searchTours(city,transport, accommodation, priceMin, priceMax, quantity);
        } catch (DBConnectException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
        }

        if(tours.size() > 0) {
            found = true;
        }

        req.setAttribute("found", found);
        req.setAttribute("tours", tours);
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

    public static boolean buyTour(int tourId, String login, int quantity, @Nullable String notes) {
        try {
            CatalogDAO catalogDAO = new CatalogDAO(DBManager.getInstance());
            return catalogDAO.buyTour(tourId, login, quantity, notes);
        } catch (DBConnectException | BigFieldSizeException | NullFieldException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
