package magdalena.pl.callmistake.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import magdalena.pl.callmistake.model.Person;

/**
 * Created by magdalenadziesinska on 09.08.2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    // Database version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "personName";
    // Person table name
    private static final String TABLE_PERSON = "Person";

    // Person table column name
    private static final String PERSON_ID = "Id";
    private static final String PERSON_NAME = "Name";
    private static final String PERSON_SURNAME = "Surname";
    private static final String PERSON_EMAIL = "Email";
    private static final String PERSON_PHONE = "Phone";
    private static final String PERSON_DESCRIPTION = "Description";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TAABLE = "CREATE TABLE " + TABLE_PERSON + "(" + PERSON_ID + " INTEGER PRIMARY KEY," + PERSON_NAME + " TEXT,"
                + PERSON_SURNAME + " TEXT," + PERSON_EMAIL + " TEXT," + PERSON_PHONE + " TEXT," + PERSON_DESCRIPTION + " TEXT," + ")";
        db.execSQL(CREATE_CONTACTS_TAABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);
        onCreate(db);
    }

    //add Person
    public void addPerson(Person person) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(PERSON_NAME, person.getName());
        values.put(PERSON_SURNAME, person.getSurname());
        values.put(PERSON_EMAIL, person.getEmail());
        values.put(PERSON_PHONE, person.getPhone());
        values.put(PERSON_DESCRIPTION, person.getDescription());

        db.insert(TABLE_PERSON, null, values);
        db.close();
    }

    //get all Person
    public List<Person> getAllPreson() {
        List<Person> personList = new ArrayList<Person>();
        String selectQuery = "SELECT * FROM " + TABLE_PERSON;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Person person = new Person();
                person.setId(Integer.parseInt(cursor.getString(0)));
                person.setName(cursor.getString(1));
                person.setSurname(cursor.getString(2));
                person.setEmail(cursor.getString(3));
                person.setPhone(cursor.getString(4));
                person.setDescription(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        return personList;
    }

// delete single person

    public void deletePerson(Person person) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PERSON, PERSON_ID + " = ?",
                new String[]{String.valueOf(person.getId())});
        db.close();
    }

    // Getting singl90e Person
    Person getPerson(int id) {

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_PERSON, new String[]{PERSON_ID,
                        PERSON_NAME, PERSON_SURNAME, PERSON_EMAIL, PERSON_PHONE, PERSON_DESCRIPTION}, PERSON_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
            Person person = new Person(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4), cursor.getString(5));
            return person;

    }


    //getting person count

    public int getPersonCount() {
        String countQuery = "SELECT * FROM " + TABLE_PERSON;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();
    }

}
