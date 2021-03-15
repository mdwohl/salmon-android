package com.mdwohl.salmoncookies;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StoreLocationAdapter extends RecyclerView.Adapter <StoreLocationAdapter.viewStoreHolder>{
    private List<Store> storeList;
    public StoreLocationAdapter(List<Store> storeList){
        this.storeList = storeList;
    };
    @NonNull
    @Override
    public viewStoreHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listStore = layoutInflater.inflate(R.layout.store_row, parent, false);
        viewStoreHolder storeView = new viewStoreHolder(listStore);
        return storeView;
    }

    @Override
    public void onBindViewHolder(@NonNull viewStoreHolder holder, int position) {
        holder.locationName.setText(storeList.get(position).getLocation());
        holder.sixAm.setText(storeList.get(position).getHourlySales());
    }

    @Override
    public int getItemCount() {
        return storeList.size();
    }

    class viewStoreHolder extends RecyclerView.ViewHolder{
        public TextView locationName;
        public TextView sixAm;
        public TextView sevenAm;
        public TextView eightAm;
        public TextView nineAm;
        public TextView tenAm;
        public TextView elevenAm;
        public TextView twelvePm;
        public TextView onePm;
        public TextView twoPm;
        public TextView threePm;
        public TextView fourPm;
        public TextView fivePm;
        public TextView sixPm;
        public TextView sevenPm;

        public viewStoreHolder(@NonNull View itemView) {
            super(itemView);
            this.locationName = itemView.findViewById(R.id.location);
            this.sixAm = itemView.findViewById(R.id.editView6am);
            this.sevenAm = itemView.findViewById(R.id.editView7am);
            this.eightAm = itemView.findViewById(R.id.editView8am);
            this.nineAm = itemView.findViewById(R.id.editView9am);
            this.tenAm = itemView.findViewById(R.id.editView10am);
            this.elevenAm = itemView.findViewById(R.id.editView11am);
            this.twelvePm = itemView.findViewById(R.id.editView12pm);
            this.onePm = itemView.findViewById(R.id.editView1pm);
            this.twoPm = itemView.findViewById(R.id.editView2pm);
            this.threePm = itemView.findViewById(R.id.editView3pm);
            this.fourPm = itemView.findViewById(R.id.editView4pm);
            this.fivePm = itemView.findViewById(R.id.editView5pm);
            this.sixPm = itemView.findViewById(R.id.editView6pm);
            this.sevenPm = itemView.findViewById(R.id.editView7pm);
        }
    }
}
