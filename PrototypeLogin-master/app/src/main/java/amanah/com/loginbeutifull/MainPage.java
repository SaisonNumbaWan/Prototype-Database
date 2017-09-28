package amanah.com.loginbeutifull;

import android.os.Bundle;

/**
 * Created by lithi on 9/27/2017.
 */

public class MainPage extends LoginActivity {

    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        DatabaseHelper dbh = DatabaseHelper.getInstance(this);
        db = new DatabaseHelper(this);
        db.getWritableDatabase();
        db.getReadableDatabase();

    }
}
