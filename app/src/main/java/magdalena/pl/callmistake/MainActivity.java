package magdalena.pl.callmistake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_CREATE = 2;
    public PersonAdapter personAdapter;

    public Person person;
    @BindView(R.id.recycleViewList)
    RecyclerView recycleViewList;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        personAdapter = new PersonAdapter(getLayoutInflater());
        recycleViewList.setLayoutManager(new LinearLayoutManager(this));
        recycleViewList.setAdapter(personAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_person:
                Intent intent = new Intent(this, PersonActivity.class);
                startActivityForResult(intent, REQUEST_CODE_CREATE);
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_CREATE && resultCode == RESULT_OK) {
            Toast.makeText(getApplication(),"Add person",Toast.LENGTH_SHORT).show();

            personAdapter.addPerson(person);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
