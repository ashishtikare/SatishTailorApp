package satish.com.satistailors;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ash on 29-Jun-16.
 */
public class CustomerDAO extends SQLiteOpenHelper {
    public CustomerDAO(Context context) {
        super(context, "CustomerContact", null, 1);
    }



    // EDIT Add provision for last updated in db and customer Details screen
    //TO-DO TAbbed view, Edit/save option for details screen ie. Update function

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE customers(id TEXT NOT NULL PRIMARY KEY, name TEXT NOT NULL, mobile TEXT, office TEXT, address TEXT, reference TEXT, email TEXT, pant TEXT, shirt TEXT,coat TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insert(Customer customer) {
        ContentValues data = customer.toContentValues();
        SQLiteDatabase database = getReadableDatabase();
        database.insert("customers",null,data);
    }

    public List<Customer> listAll() {
        List<Customer> customers = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM customers", null);
        while (cursor.moveToNext()){
            String cno = cursor.getString(cursor.getColumnIndex("id"));
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String mobile = cursor.getString(cursor.getColumnIndex("mobile"));
            String office = cursor.getString(cursor.getColumnIndex("office"));
            String address = cursor.getString(cursor.getColumnIndex("address"));
            String reference = cursor.getString(cursor.getColumnIndex("reference"));
            String email = cursor.getString(cursor.getColumnIndex("email"));
            String pant = cursor.getString(cursor.getColumnIndex("pant"));
            String shirt = cursor.getString(cursor.getColumnIndex("shirt"));
            String coat = cursor.getString(cursor.getColumnIndex("coat"));
            Customer customer = new Customer(cno,name,mobile,office,address,reference,email,pant,shirt,coat);
            customers.add(customer);
        }
        return customers;
    }

    public void remove(Customer customer) {
        SQLiteDatabase database = getWritableDatabase();
        String[] params = {customer.getId()+""};
        database.delete("customers","id = ?", params);

    }

    public void update(Customer customer, String originalId) {
        ContentValues data = customer.toContentValues();
        SQLiteDatabase database = getWritableDatabase();
        String[] params={originalId + ""};
        database.update("customers",data,"id=?",params);
    }
}
