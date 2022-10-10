package app.bubbleupretailers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleupretailers.Model.DeliveredModel;
import app.bubbleupretailers.R;

public class DeliveryAdapter extends RecyclerView.Adapter<DeliveryAdapter.ViewHolder> {

    Context context;
    ArrayList<DeliveredModel> deliveredModels = new ArrayList<>();

    public DeliveryAdapter(Context context, ArrayList<DeliveredModel> deliveredModels) {
        this.context = context;
        this.deliveredModels = deliveredModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivered_status,parent,false);
        return new DeliveryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        DeliveredModel deliveredModel = deliveredModels.get(position);
        holder.username.setText(deliveredModel.getName());
        holder.total_amt.setText(deliveredModel.getAmount());
        holder.user_number.setText(deliveredModel.getMobileNo());
        holder.user_loc.setText(deliveredModel.getAddress());
        holder.date_of_booking.setText(deliveredModel.getDeliveryDate());
        holder.time_slot.setText(deliveredModel.getDeliveryTime());

    }

    @Override
    public int getItemCount() {
        return deliveredModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView username,total_amt,user_number,user_loc,date_of_booking,time_slot;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            username = itemView.findViewById(R.id.username);
            total_amt = itemView.findViewById(R.id.total_amt);
            user_number = itemView.findViewById(R.id.user_number);
            user_loc = itemView.findViewById(R.id.user_loc);
            date_of_booking = itemView.findViewById(R.id.date_of_booking);
            time_slot = itemView.findViewById(R.id.time_slot);
        }
    }
}
