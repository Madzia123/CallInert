package magdalena.pl.callmistake;


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

    Person person;
    private LayoutInflater layoutInflater;

    public PersonAdapter(LayoutInflater layoutInflater) {
        this.layoutInflater = layoutInflater;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.
                from(parent.getContext()).inflate(R.layout.item_card, parent, false);

        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        person = personList.get(position);


        holder.surname.setText(person.getSurname());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public void addPerson(Person person) {

        int position = getItemCount();
        personList.add(position, person);
        notifyDataSetChanged();
    }


    public class PersonViewHolder extends RecyclerView.ViewHolder {


        public TextView name, surname;


        public PersonViewHolder(View itemView) {
            super(itemView);
            name = (TextView)itemView.findViewById(R.id.person_name);
            surname = (TextView)itemView.findViewById(R.id.person_surname);
        }

    }
}
