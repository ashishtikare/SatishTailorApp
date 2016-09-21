package satish.com.satistailors;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

public class HomePage extends AppCompatActivity {

    ArrayAdapter<Customer> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);






        getcustomerList().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> customerList, View item, int position, long id) {

                Customer customer = (Customer) customerList.getItemAtPosition(position);
                Toast.makeText(HomePage.this," Details of "+customer.getName(),Toast.LENGTH_SHORT).show();
                Intent intention = new Intent(HomePage.this,CustomerDetails.class);
                intention.putExtra("customer",customer);
                startActivity(intention);
            }
        });

        getcustomerList().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> customerList, View item, int position, long id) {

                Customer customer = (Customer) customerList.getItemAtPosition(position);
                Toast.makeText(HomePage.this," Customer Long Press "+customer.getName(),Toast.LENGTH_SHORT).show();
                return false;
            }
        });

        registerForContextMenu(getcustomerList());

        Button newCustomer = (Button) findViewById(R.id.activity_home_page_newCustomer_button);
        newCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HomePage.this,"Showing form..",Toast.LENGTH_SHORT).show();
                Intent intention2 = new Intent(HomePage.this,NewCustomer.class);
                startActivity(intention2);
            }
        });
    }

    @Override
    protected void onResume() {
        loadCustomers();
        super.onResume();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        if (v.equals(getcustomerList())) {
            AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
            Customer customer = (Customer) getcustomerList().getItemAtPosition(info.position);
            showContextMenuForCustomer(menu, customer);
        }
    }

    private void showContextMenuForCustomer(ContextMenu menu, final Customer customer) {
        MenuItem remove = menu.add("Remove");
        remove.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                CustomerDAO dao = new CustomerDAO(HomePage.this);
                dao.remove(customer);
                dao.close();
                loadCustomers();
                Toast.makeText(HomePage.this, "Removing " + customer.getName(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void loadCustomers() {
        //Loading Customers from DB
        CustomerDAO dao = new CustomerDAO(this);
        List<Customer> customers = dao.listAll();
        dao.close();
        this.getcustomerList();
        adapter = new ArrayAdapter<Customer>(this, android.R.layout.simple_list_item_1, customers);
        getcustomerList().setAdapter(adapter);
        EditText searchBox = (EditText) findViewById(R.id.searchbox);
        searchBox.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                HomePage.this.adapter.getFilter().filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    private ListView getcustomerList() {
        return (ListView) findViewById(R.id.activity_home_page_customerList);
    }
}

