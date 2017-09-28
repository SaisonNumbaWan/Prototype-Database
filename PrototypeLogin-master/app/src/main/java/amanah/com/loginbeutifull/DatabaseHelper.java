package amanah.com.loginbeutifull;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lithi on 9/27/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private final static String DB_NAME = "walkhealthy";
    private final static int DB_VERSION = 2;

    //tables and columns
    public static final String TABLE_NAME1 = "Users";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "EMAIL";
    public static final String COL_3 = "USERNAME";
    public static final String COL_4 = "FIRSTNAME";
    public static final String COL_5 = "LASTNAME";

    private static DatabaseHelper instance;
    private static SQLiteDatabase db;


    public DatabaseHelper(Context context)
    {
        super(context, DB_NAME, null, 1);
        db = this.getWritableDatabase();
    }

    public static synchronized DatabaseHelper getInstance(final Context c)
    {
        if(instance == null) {
            instance = new DatabaseHelper(c.getApplicationContext());
        }
        return instance;
    }

    public void onCreate(final SQLiteDatabase db)
    {
        db.execSQL("CREATE TABLE" + TABLE_NAME1 + "(" +
            COL_1 + " INTEGER PRIMARY KEY, " +
            COL_2 + " TEXT, " +
            COL_3 + " TEXT, " +
            COL_4 + " TEXT, " +
            COL_5 + " TEXT)");

    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        onCreate(db);
    }
    public boolean insertPerson(String email, String username, String firstname, String lastname)
    {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues cV = new ContentValues();
        cV.put(COL_2,email);
        cV.put(COL_3,username);
        cV.put(COL_4, firstname);
        cV.put(COL_5, lastname);
        db.insert("Users", null, cV);
        return true;
    }
}
