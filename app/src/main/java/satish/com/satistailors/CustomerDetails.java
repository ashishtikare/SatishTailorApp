package satish.com.satistailors;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class CustomerDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_details);

        final TextInputLayout cnoWrapper = (TextInputLayout) findViewById(R.id.cnowrapper);
        cnoWrapper.setHint("C.No");
        final TextInputLayout nameWrapper = (TextInputLayout) findViewById(R.id.nameWrapper);
        nameWrapper.setHint("Name");
        final TextInputLayout mobileWrapper = (TextInputLayout) findViewById(R.id.mobileWrapper);
        mobileWrapper.setHint("Mobile");
        final TextInputLayout addressWrapper = (TextInputLayout) findViewById(R.id.addressWrapper);
        addressWrapper.setHint("Address");
        final TextInputLayout officeWrapper = (TextInputLayout) findViewById(R.id.offWrapper);
        officeWrapper.setHint("Office");
        final TextInputLayout refWrapper = (TextInputLayout) findViewById(R.id.refWrapper);
        refWrapper.setHint("Reference");
        final TextInputLayout emailWrapper = (TextInputLayout) findViewById(R.id.emailWrapper);
        emailWrapper.setHint("Email");

        if (intentionForUpdate()){
            Customer customer = getOriginalCustomer();
            CustomerFormViewHelper helper = new CustomerFormViewHelper(this);
            helper.fillCustomerDetails(customer);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_update_customer,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.activity_update_customer){
            CustomerFormViewHelper helper =  new CustomerFormViewHelper(this);
            Customer customer = helper.updateCustomer();
            CustomerDAO dao = new CustomerDAO(this);
            dao.update(customer,getOriginalCustomer().getCno());
            dao.close();
            Toast.makeText(CustomerDetails.this, "Customer updated", Toast.LENGTH_SHORT).show();
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private boolean intentionForUpdate() {
        return getIntent().hasExtra("customer");
    }

    private Customer getOriginalCustomer() {
        Intent intent = getIntent();
        Customer customer = (Customer) intent.getSerializableExtra("customer");
        return customer;
    }
}
