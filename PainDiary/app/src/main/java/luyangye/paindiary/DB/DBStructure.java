package luyangye.paindiary.DB;

import android.provider.BaseColumns;

/**
 * Created by YLY on 21/04/2016.
 */
public class DBStructure {
    public static abstract class tableEntry implements BaseColumns {
        public static final String TABLE_NAME = "Record";
        public static final String COLUMN_ID = "userid";
        public static final String COLUMN_ADDR = "address";
        public static final String COLUMN_LAT = "latitude";
        public static final String COLUMN_LONG = "longtitude";
        public static final String COLUMN_DATE = "date";
        public static final String COLUMN_TIME = "time";}
}