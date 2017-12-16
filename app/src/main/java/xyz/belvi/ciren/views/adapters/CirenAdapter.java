package xyz.belvi.ciren.views.adapters;

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

import xyz.belvi.ciren.R;
import xyz.belvi.ciren.models.Ciren;
import xyz.belvi.ciren.views.holders.CirenHolder;

/**
 * Created by zone2 on 6/27/17.
 */

abstract public class CirenAdapter extends RecyclerView.Adapter<CirenHolder> implements Filterable {

    private ArrayList<Ciren> cirens;
    private ArrayList<Ciren> completeCirens;

    public CirenAdapter(ArrayList<Ciren> cirens) {
        this.cirens = cirens;
        this.completeCirens = cirens;
    }

    @Override
    public CirenHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CirenHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.ciren_item, parent, false));
    }

    @Override
    public void onBindViewHolder(CirenHolder holder, int position) {
        final Ciren ciren = cirens.get(position);
        holder.getCirenImg().setImageDrawable(ContextCompat.getDrawable(holder.getContext(), ciren.getResouceId()));
        holder.getCirenTitle().setText(ciren.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemSelected(ciren);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cirens.size();
    }

    @Override
    public Filter getFilter() {
        return new CirenFilter();
    }

    protected abstract void onItemSelected(Ciren ciren);

    private class CirenFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults filterResults = new FilterResults();
            if (constraint == null || constraint.toString().trim().isEmpty()) {
                filterResults.values = completeCirens;
                filterResults.count = completeCirens.size();
            } else {
                ArrayList<Ciren> filteredCirens = new ArrayList<>();
                for (Ciren ciren : completeCirens) {
                    if (ciren.getName().toLowerCase().contains(constraint.toString())) {
                        filteredCirens.add(ciren);
                    }
                }
                filterResults.count = filteredCirens.size();
                filterResults.values = filteredCirens;
            }
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            cirens = (ArrayList<Ciren>) results.values;
            notifyDataSetChanged();
        }
    }
}
