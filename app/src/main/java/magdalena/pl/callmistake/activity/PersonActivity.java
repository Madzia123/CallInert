package magdalena.pl.callmistake.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magdalena.pl.callmistake.model.Person;
import magdalena.pl.callmistake.R;

public class PersonActivity extends AppCompatActivity {

    @BindView(R.id.nameEditText)
    EditText nameEditText;
    @BindView(R.id.emailEditText)
    EditText emailEditText;
    @BindView(R.id.phoneEditText)
    EditText phoneEditText;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.surnameEditText)
    EditText surnameEditText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.buttonNextButton)
    public void onClick() {

        String name = nameEditText.getText().toString();
        String surname = surnameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String phone = phoneEditText.getText().toString();
        String description = editText.getText().toString();

        Person person = new Person(name, surname, email, phone, description);



    }
}
