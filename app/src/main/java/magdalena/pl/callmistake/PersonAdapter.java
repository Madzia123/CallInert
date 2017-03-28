package magdalena.pl.callmistake;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by magdalenadziesinska on 28.03.2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    public List<Person> personList = new ArrayList<>();
    public Person person;

    private LayoutInflater layoutInflater;

    public PersonAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }


    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_card, parent, false);

        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PersonAdapter.ViewHolder holder, int position) {
        person = personList.get(position);

        String nameString = person.getName();
        String emailString = person.getEmail();

        holder.setText(nameString, emailString);
    }

    public void addPerson(Person person) {

        int position = getItemCount();
        personList.add(position, person);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {

        if (personList.size() == 0) {
            return 1;
        } else {
            return personList.size();
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public String nameString, emailString;
        public TextView name, email;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.nameTextView);
            email = (TextView) itemView.findViewById(R.id.surnameTextView);
        }


        public void setText(String nameString, String emailString) {
            this.nameString = nameString;
            this.emailString = emailString;
            name.setText(nameString);
            email.setText(emailString);
        }

    }
}
