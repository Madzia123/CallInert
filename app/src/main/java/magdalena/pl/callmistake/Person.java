package magdalena.pl.callmistake;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.health.ServiceHealthStats;

/**
 * Created by magdalenadziesinska on 28.03.2017.
 */

public class Person implements Parcelable
{

    private String name;
    private String surname;
    private String email;
    private String phone;
    private String description;

    protected Person(Parcel in) {
        name = in.readString();
        surname = in.readString();
        email = in.readString();
        phone = in.readString();
        description = in.readString();
    }


    public Person(String name, String surname, String email, String phone, String description) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.description = description;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
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

    public static Creator<Person> getCREATOR() {
        return CREATOR;
    }

    public static final Creator<Person> CREATOR = new Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    public String getName() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(surname);
        parcel.writeString(email);
        parcel.writeString(phone);
        parcel.writeString(description);
    }
}
