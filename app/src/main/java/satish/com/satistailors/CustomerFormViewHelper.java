package satish.com.satistailors;

import android.app.Activity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Ash on 29-Jun-16.
 */
public class CustomerFormViewHelper {

    private final Activity activity;

    public CustomerFormViewHelper(Activity activity){
        this.activity=activity;
    }

    public String getCno(){ return getTextFieldValue(R.id.activity_new_customer_cno);    }
    public String getName(){
       return getTextFieldValue(R.id.activity_new_customer_name);
    }
    public String getMobile(){
        return getTextFieldValue(R.id.activity_new_customer_mobile);
    }
    public String getOffice(){
        return getTextFieldValue(R.id.activity_new_customer_office);
    }
    public String getReference(){
        return getTextFieldValue(R.id.activity_new_customer_reference);
    }
    public String getAddress(){
        return getTextFieldValue(R.id.activity_new_customer_address);
    }
    public String getEmail(){
        return getTextFieldValue(R.id.activity_new_customer_email);
    }
    public String getPant() {
        return getTextFieldValue(R.id.activity_new_customer_pant);
    }

    public String getShirt() {
        return getTextFieldValue(R.id.activity_new_customer_shirt);
    }

    public String getCoat() {
        return getTextFieldValue(R.id.activity_new_customer_coat);
    }

    public String updateCno(){ return getTextFieldValue(R.id.activity_customer_cno);    }
    public String updateName(){
        return getTextFieldValue(R.id.activity_customer_name);
    }
    public String updateMobile(){
        return getTextFieldValue(R.id.activity_customer_mobile);
    }
    public String updateOffice(){
        return getTextFieldValue(R.id.activity_customer_office);
    }
    public String updateReference(){
        return getTextFieldValue(R.id.activity_customer_reference);
    }
    public String updateAddress(){
        return getTextFieldValue(R.id.activity_customer_address);
    }
    public String updateEmail(){
        return getTextFieldValue(R.id.activity_customer_email);
    }
    public String updatePant(){
        return getTextFieldValue(R.id.activity_customer_pant);
    }
    public String updateShirt(){
        return getTextFieldValue(R.id.activity_customer_shirt);
    }
    public String updateCoat(){        return getTextFieldValue(R.id.activity_customer_coat);
    }

    private String getTextFieldValue(int fieldId) {
        EditText fieldid = (EditText) activity.findViewById(fieldId);
        String value = fieldid.getText().toString();
        return value;

    }


    public Customer createCustomer() {
        return new Customer(getCno(),getName(),getMobile(),getOffice(),getReference(),getAddress(),getEmail(),getPant(),getShirt(),getCoat());
    }


    public Customer updateCustomer() {
        return new Customer(updateCno(),updateName(),updateMobile(),updateOffice(),updateReference(),updateAddress(),updateEmail(),updatePant(),updateShirt(),updateCoat());
    }

    public void fillCustomerDetails(Customer customer) {

        EditText cno = (EditText) activity.findViewById(R.id.activity_customer_cno);
        cno.setText(customer.getCno());
        EditText name = (EditText) activity.findViewById(R.id.activity_customer_name);
        name.setText(customer.getName());
        EditText mobile = (EditText) activity.findViewById(R.id.activity_customer_mobile);
        mobile.setText(customer.getMobile());
        EditText office = (EditText) activity.findViewById(R.id.activity_customer_office);
        office.setText(customer.getOffice());
        EditText ref = (EditText) activity.findViewById(R.id.activity_customer_reference);
        ref.setText(customer.getReference());
        EditText email = (EditText) activity.findViewById(R.id.activity_customer_email);
        email.setText(customer.getEmail());
        EditText address = (EditText) activity.findViewById(R.id.activity_customer_address);
        address.setText(customer.getAddress());
        EditText pant = (EditText) activity.findViewById(R.id.activity_customer_pant);
        pant.setText(customer.getPant());
        EditText shirt = (EditText) activity.findViewById(R.id.activity_customer_shirt);
        shirt.setText(customer.getShirt());
        EditText coat = (EditText) activity.findViewById(R.id.activity_customer_coat);
        coat.setText(customer.getCoat());


    }


}
