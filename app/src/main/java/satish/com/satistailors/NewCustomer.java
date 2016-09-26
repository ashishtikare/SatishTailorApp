package satish.com.satistailors;

import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class NewCustomer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_customer);

        final TextInputLayout newCnoWrapper = (TextInputLayout) findViewById(R.id.newcnowrapper);
        newCnoWrapper.setHint("CNo.");
        final TextInputLayout newCnameWrapper = (TextInputLayout) findViewById(R.id.newcnamewrapper);
        newCnameWrapper.setHint("NAME");
        final TextInputLayout newPantWrapper = (TextInputLayout) findViewById(R.id.newpantwrapper);
        newPantWrapper.setHint("PANT");
        final TextInputLayout newShirtWrapper = (TextInputLayout) findViewById(R.id.newshirtwrapper);
        newShirtWrapper.setHint("SHIRT");
        final TextInputLayout newCoatWrapper = (TextInputLayout) findViewById(R.id.newcoatwrapper);
        newCoatWrapper.setHint("COAT");


        newCnoWrapper.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 3) {
                    newCnoWrapper.setError(getString(R.string.cno_required));
                    newCnoWrapper.setErrorEnabled(true);
                } else {
                    newCnoWrapper.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        newCnameWrapper.getEditText().addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() < 3) {
                    newCnameWrapper.setError(getString(R.string.cname_required));
                    newCnameWrapper.setErrorEnabled(true);
                } else {
                    newCnameWrapper.setErrorEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_new_customer,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.activity_new_customer_save){
            CustomerFormViewHelper helper = new CustomerFormViewHelper(this);
            Customer customer = helper.createCustomer();
            CustomerDAO dao = new CustomerDAO(this);
            dao.insert(customer);
            dao.close();
            Toast.makeText(NewCustomer.this, "Customer was created", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}