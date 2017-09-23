package ua.nure.stepanenko.SummaryTask4.db;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DBNames {
    private DBNames() {}

    public static class User extends Entity {
        public static final String LOGIN = "login";
        public static final String NAME = "name_";
        public static final String LASTNAME = "lastname";
        public static final String PASSWORD = "password_";
        public static final String ROLE = "role";
        public static final String PHONE = "phone";
        public static final String EMAIL = "email";
        public static final String IS_BANNED = "isBanned";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/user.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private User() {}

        public static String getName() {
            return "user_";
        }
    }

    public static class Tour extends Entity {
        public static final String NAME = "name_";
        public static final String DESCRIPTION = "description";
        public static final String QUANTITY = "quantity";
        public static final String BOOKED = "booked";
        public static final String PRICE = "price";
        public static final String ISFIRE = "isFire";
        public static final String DISCOUNT_MAX = "disc_max";
        public static final String DISCOUNT_STEP = "disc_step";
        public static final String TYPE = "type_";
        public static final String DATE_BEGIN = "date_begin";
        public static final String DATE_END = "date_end";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/tour.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private Tour() {}

        public static String getName() {
            return "tour";
        }
    }

    public static class Tag extends Entity {
        public static final String NAME = "name_";
        public static final String TYPE = "type_";
        public static final String DESCRIPTION = "description";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/tag.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private Tag() {}

        public static String getName() {
            return "tag";
        }
    }

    public static class Country extends Entity {
        public static final String NAME = "name_";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/country.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private Country() {}

        public static String getName() {
            return "country";
        }
    }

    public static class Transport extends Entity {
        public static final String NAME = "name_";
        public static final String TYPE = "type_";
        public static final String DESCRIPTION = "description";
        public static final String QUANTITY = "quantity";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/transport.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private Transport() {}

        public static String getName() {
            return "transport";
        }
    }

    public static class City extends Entity {
        public static final String NAME = "name_";
        public static final String COUNTRY = "country";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/city.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private City() {}

        public static String getName() {
            return "city";
        }
    }

    public static class Order extends Entity {
        public static final String USER = "user_";
        public static final String TOUR = "tour";
        public static final String DISCOUNT = "discount";
        public static final String QUANTITY = "quantity";
        public static final String TOTAL_SUM = "total_sum";
        public static final String STATUS = "status_";
        public static final String DATE_TIME = "date_time";
        public static final String NOTES = "notes";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/order.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }

        private Order() {}

        public static String getName() {
            return "order_";
        }
    }

    public static class Accommodation {
        public static final String NAME = "name_";
        public static final String CITY = "city";
        public static final String ADDRESS = "address";
        public static final String STARS = "stars";
        public static final String DESCRIPTION = "description";
        public static final String LINK = "link";
        public static final String TYPE = "type_";

        public static final Map<String, Integer> VARCHAR_COLUMN_LENGTHS;

        static {
            Map<String, Integer> map = new HashMap<>();
            try {
                map = DBNames.getDataFromJSON("./web/resources/other/restrictions/accom.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
            VARCHAR_COLUMN_LENGTHS = Collections.unmodifiableMap(map);
        }
        
        private Accommodation() {}
        
        public static String getName() {
            return "accommodation";
        }
    }

    // todo: нужны ли мне вообще таблицы ниже?? (нет).
//    public static final class TourTag {
//        public static final String TOUR = "tour";
//        public static final String TAG = "tag";
//
//        private TourTag() {}
//
//        public static String getName() {
//            return "tour_tag";
//        }
//    }
//
//    public static final class TourAccommodation {
//        public static final String TOUR = "tour";
//        public static final String ACCOMMODATION = "accommodation";
//
//        private TourAccommodation() {}
//
//        public static String getName() {
//            return "tour_accommodation";
//        }
//    }
//
//    public static final class TourCity {
//        public static final String TOUR = "tour";
//        public static final String CITY = "city";
//
//        private TourCity() {}
//
//        public static String getName() {
//            return "tour_city";
//        }
//    }
//
//    public static final class TourTransport {
//        public static final String TOUR = "tour";
//        public static final String TRANSPORT = "transport";
//
//        private TourTransport() {}
//
//        public static String getName() {
//            return "tour_transport";
//        }
//    }


    private static abstract class Entity {
        public static final String ID = "id";
    }


    public static Map<String, Integer> getDataFromJSON(String filePath) throws IOException {
        Map<String, Integer> res = new HashMap<>();

        String data = "";

        byte[] bytes = Files.readAllBytes(Paths.get(filePath));
        data = new String(bytes, "ISO-8859-1");

        System.out.println(data);

        Pattern pattern = Pattern.compile("(?m)\"(\\w+)\": (\\d+)");
        Matcher matcher = pattern.matcher(data);

        while(matcher.find()) {
            res.put(matcher.group(1), Integer.parseInt(matcher.group(2)));
        }

        return res;
    }
}
