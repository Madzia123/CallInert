package magdalena.pl.callmistake.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.health.ServiceHealthStats;

/**
 * Created by magdalenadziesinska on 28.03.2017.
 */

public class Person {

    private int id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Person() {
    }

    public Person(int id, String name, String surname, String email, String phone, String description) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public Person(String name, String surname, String email, String phone, String description) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public String setName(String name) {
        this.name = name;
        return null;
    }

    public String getSurname() {
        return surname;
    }

    public String setSurname(String surname) {
        this.surname = surname;
        return null;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
