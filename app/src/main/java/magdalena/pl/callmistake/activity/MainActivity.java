package magdalena.pl.callmistake.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import magdalena.pl.callmistake.db.DatabaseHelper;
import magdalena.pl.callmistake.model.Person;
import magdalena.pl.callmistake.PersonAdapter;
import magdalena.pl.callmistake.R;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();
    private DatabaseHelper databaseHelper;
    public PersonAdapter personAdapter;
    @BindView(R.id.recycleViewList)
    RecyclerView recycleViewList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        databaseHelper = new DatabaseHelper(this);

        databaseHelper.addPerson(new Person("Magdalena", "Dziesińska", "magda@wp.pl", "789065", "fvdfvfdbdfvdfvfd"));
        databaseHelper.addPerson(new Person("Magdalena", "Dziesińska", "magda@wp.pl", "789065", "fvdfvfdbdfvdfvfd"));
        databaseHelper.addPerson(new Person("Magdalena", "Dziesińska", "magda@wp.pl", "789065", "fvdfvfdbdfvdfvfd"));
        databaseHelper.addPerson(new Person("Magdalena", "Dziesińska", "magda@wp.pl", "789065", "fvdfvfdbdfvdfvfd"));
        personList = databaseHelper.getAllPreson();
        RecyclerView.LayoutManager mLayoutManage = new LinearLayoutManager(getApplicationContext());
        recycleViewList.setLayoutManager(mLayoutManage);
        personAdapter = new PersonAdapter(this, personList);
        recycleViewList.setAdapter(personAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_add, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_person:
                add();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void add() {
        Intent intent = new Intent(MainActivity.this, PersonActivity.class);
        startActivity(intent);
        finish();
    }

}
