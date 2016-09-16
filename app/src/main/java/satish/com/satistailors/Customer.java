package satish.com.satistailors;

import android.content.ContentValues;

import java.io.Serializable;

/**
 * Created by Ash on 29-Jun-16.
 */
public class Customer implements Serializable {

    private final String name;
    private String cno;
    private final String mobile;
    private final String office;
    private final String reference;
    private final String address;
    private final String email;
    private final String pant;
    private final String shirt;
    private final String coat;

    public Customer(String cno, String name, String mobile, String office, String address, String reference, String email,String pant, String shirt,String coat) {

        this.cno = cno;
        this.name = name;
        this.mobile = mobile;
        this.office = office;
        this.address = address;
        this.reference = reference;
        this.email = email;
        this.pant=pant;
        this.shirt=shirt;
        this.coat=coat;
    }



    @Override
    public String toString() {
        return cno + " "+ name;
    }

    public String getCno() {
        return cno;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getOffice() {
        return office;
    }

    public String getReference() {
        return reference;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getId(   ) {
        return cno;
    }

    public String getPant(){return pant;}

    public String getShirt(){return shirt;}

    public String getCoat() {
        return coat;
    }



    public ContentValues toContentValues() {
        ContentValues data = new ContentValues();
        data.put("id",cno);
        data.put("name",name);
        data.put("mobile",mobile);
        data.put("office",office);
        data.put("address",address);
        data.put("reference",reference);
        data.put("email",email);
        data.put("pant",pant);
        data.put("shirt",shirt);
        data.put("coat",coat);
        return data;
    }

}
