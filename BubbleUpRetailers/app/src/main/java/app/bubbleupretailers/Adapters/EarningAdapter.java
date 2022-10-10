package app.bubbleupretailers.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleupretailers.Model.EarningsModel;
import app.bubbleupretailers.R;

public class EarningAdapter extends RecyclerView.Adapter<EarningAdapter.ViewHolder> {

    Context context;
    ArrayList<EarningsModel> earningsModels = new ArrayList<>();

    public EarningAdapter(Context context, ArrayList<EarningsModel> earningsModels) {
        this.context = context;
        this.earningsModels = earningsModels;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.my_earnings,parent,false);
        return new EarningAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        EarningsModel earningsModel = earningsModels.get(position);
        holder.service_name.setText("Product :"+ earningsModel.getName());
        holder.txt_job_id.setText("Service ID :"+ earningsModel.getServiceID());
        holder.txt_amount_paid.setText("₹ "+ earningsModel.getAmount());
        holder.job_details.setText(earningsModel.getJobDetails());
        holder.customer_address.setText(earningsModel.getLoc());
        holder.date_of_booking.setText(earningsModel.getBookingDate());
        holder.delivery_date.setText(earningsModel.getDeliveryDate());

    }

    @Override
    public int getItemCount() {
        return earningsModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView service_name,txt_job_id,txt_amount_paid,job_details,customer_address,date_of_booking,delivery_date;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            service_name = itemView.findViewById(R.id.service_name);
            txt_job_id = itemView.findViewById(R.id.txt_job_id);
            txt_amount_paid = itemView.findViewById(R.id.txt_amount_paid);
            job_details = itemView.findViewById(R.id.job_details);
            customer_address = itemView.findViewById(R.id.customer_address);
            date_of_booking = itemView.findViewById(R.id.date_of_booking);
            delivery_date = itemView.findViewById(R.id.delivery_date);

        }
    }
}
