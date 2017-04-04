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
import butterknife.OnClick;

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
                add();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    private void add() {
        Intent intent = new Intent(this, PersonActivity.class);
        startActivityForResult(intent, REQUEST_CODE_CREATE);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CODE_CREATE) {
                if (data.hasExtra("data")) {

                     personAdapter.addPerson(person);
                    Toast.makeText(getApplication(), "Add person", Toast.LENGTH_SHORT).show();
                }
            }

            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    @OnClick(R.id.addButton)
    public void onViewClicked() {
        add();
    }
}
