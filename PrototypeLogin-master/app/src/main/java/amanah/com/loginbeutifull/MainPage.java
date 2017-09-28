package amanah.com.loginbeutifull;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;


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
        //DatabaseHelper dbh = DatabaseHelper.getInstance(this);
        //db = new DatabaseHelper(this);
        //db.getWritableDatabase();
        //db.getReadableDatabase();

        findViewById(R.id.createGroup_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText groupname = (EditText)findViewById(R.id.createGroupText);
                String result = groupname.getText().toString();
                db.insertGroup(result);
            }
        });
    }

}
