package magdalena.pl.callmistake;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import magdalena.pl.callmistake.model.Person;

/**
 * Created by magdalenadziesinska on 28.03.2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    public List<Person> personList = new ArrayList<>();

    public Context mContex;

    public PersonAdapter(Context mContex, List<Person> personList) {
        this.mContex = mContex;
        this.personList = personList;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        Person person = personList.get(position);
        holder.name.setText(person.getName());
        holder.surname.setText(person.getSurname());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }


    public class PersonViewHolder extends RecyclerView.ViewHolder {


        public TextView name, surname;


        public PersonViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.person_name);
            surname = (TextView) itemView.findViewById(R.id.person_surname);
        }

    }
}
