package magdalena.pl.callmistake.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import magdalena.pl.callmistake.model.Person;
import magdalena.pl.callmistake.R;

public class Stage3Activity extends AppCompatActivity {


    @BindView(R.id.emailTextView)
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage3);
        ButterKnife.bind(this);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String email = extras.getString("emailString");
            emailTextView.setText(email);
        }
    }

    @OnClick(R.id.buttonNextButton)
    public void onClick() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
