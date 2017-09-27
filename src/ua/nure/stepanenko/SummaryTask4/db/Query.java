package ua.nure.stepanenko.SummaryTask4.db;

import com.sun.istack.internal.Nullable;

public class Query {

    public static final String SELECT_USER = "select * " +
                "from " + DBNames.User.getName() +
                " where " + DBNames.User.LOGIN + " = ?";

    public static final String CREATE_USER = "insert into " + DBNames.User.getName() +
                " values (default, ?, ?, ?, ?, ?, ?, ?, default);";

    public static final String SELECT_ACCOM_TYPE = "select " + DBNames.Accommodation.TYPE +
                " from " + DBNames.Accommodation.getName() +
                " group by " + DBNames.Accommodation.TYPE;

    public static final String SELECT_TRANSPORT_TYPE = "select " + DBNames.Transport.TYPE +
            " from " + DBNames.Transport.getName() +
            " group by " + DBNames.Transport.TYPE;

    public static final String SELECT_CITIES = "select " + DBNames.City.getName() + "." + DBNames.City.NAME + " as city, " +
            DBNames.Country.getName() + "." + DBNames.Country.NAME + " as country" +
            " from " + DBNames.City.getName() + " inner join " + DBNames.Country.getName() +
            " on " + DBNames.City.getName() + "." + DBNames.City.COUNTRY + "=" + DBNames.Country.getName() + "." + DBNames.Country.ID;


    public static final String SELECT_TOUR_CITIES = "select * from " + DBNames.City.getName() +
            " where " + DBNames.City.ID + " in (select " + DBNames.TourCity.CITY + " from " + DBNames.TourCity.getName() +
            " where " + DBNames.TourCity.TOUR + "=?);";

    public static final String SELECT_TOUR_ACCOMM = "select * from " + DBNames.Accommodation.getName() +
            " where " + DBNames.Accommodation.ID + " in (select " + DBNames.TourAccommodation.ACCOMMODATION + " from " + DBNames.TourAccommodation.getName() +
            " where " + DBNames.TourAccommodation.TOUR + "=?);";

    public static final String SELECT_TOUR_TRANSPORT = "select * from " + DBNames.Transport.getName() +
            " where " + DBNames.Transport.ID + " in (select " + DBNames.TourTransport.TRANSPORT + " from " + DBNames.TourTransport.getName() +
            " where " + DBNames.TourTransport.TOUR + "=?);";

    private Query() {}

    public static String catalogQueryBuilder(@Nullable String city,
                                             @Nullable String transport,
                                             @Nullable String accommodation,
                                             @Nullable Double price_min,
                                             @Nullable Double price_max,
                                             @Nullable Integer quantity) {
        StringBuilder base = new StringBuilder("select tour.id as id, \n" +
                "tour.name_ as name_, \n" +
                "tour.description as description,\n" +
                "tour.quantity as quantity,\n" +
                "tour.booked as booked,\n" +
                "tour.price as price,\n" +
                "tour.isfire as isfire,\n" +
                "tour.disc_max as disc_max,\n" +
                "tour.disc_step as disc_step,\n" +
                "tour.type_ as type_,\n" +
                "tour.date_begin as date_begin,\n" +
                "tour.date_end as date_end,\n" +
                "tour.image_link as image_link\n" +
                "from\n" +
                "\ttour ");

        if(city != null) {
            if(!"".equals(city)) {
                base.append("inner join tour_city on tour.id=tour_city.tour ");
            }
        }
        if(accommodation != null) {
            if(!"".equals(accommodation)) {
                base.append("inner join tour_accommodation on tour.id=tour_accommodation.tour ");
            }
        }
        if(transport != null) {
            if(!"".equals(transport)) {
                base.append("inner join tour_transport on tour.id=tour_transport.tour ");
            }
        }

        if(city != null || transport != null || accommodation != null || price_min != null || price_max != null || quantity!= null) {
            base.append(" where ");
            StringBuilder tempWhere = new StringBuilder();
            if(city != null) {
                if(!"".equals(city)) {
                    tempWhere.append("tour_city.city in (select id from city where name_='")
                            .append(city)
                            .append("') ");
                }
            }
            if(accommodation != null) {
                if(!"".equals(accommodation)) {
                    if (tempWhere.length() != 0) {
                        tempWhere.append(" and ");
                    }
                    tempWhere.append("tour_accommodation.accommodation in (select id from accommodation where type_='")
                            .append(accommodation)
                            .append("') ");
                }
            }
            if(transport != null) {
                if(!"".equals(transport)) {
                    if (tempWhere.length() != 0) {
                        tempWhere.append(" and ");
                    }
                    tempWhere.append("tour_transport.transport in (select id from transport where type_='")
                            .append(transport)
                            .append("') ");
                }
            }
            if(price_min != null || price_max != null) {
                if(tempWhere.length() != 0) {
                    tempWhere.append(" and ");
                }
                tempWhere.append(" price between ");
                if(price_min != null) {
                    tempWhere.append(price_min);
                }
                else {
                    tempWhere.append(0);
                }
                tempWhere.append(" and ");
                if(price_max != null) {
                    tempWhere.append(price_max);
                }
                else {
                    tempWhere.append("(select max(price) from tour)");
                }

            }
            if(quantity != null) {
                if(tempWhere.length() != 0) {
                    tempWhere.append(" and ");
                }
                tempWhere.append("(quantity - booked) > ")
                        .append(quantity);
            }
            base.append(tempWhere);
        }
        base.append(" order by isfire desc, date_begin asc;");

        return base.toString();
    }

}
