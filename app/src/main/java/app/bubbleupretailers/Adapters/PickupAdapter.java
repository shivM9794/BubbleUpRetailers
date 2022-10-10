package app.bubbleupretailers.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.bubbleupretailers.Model.PickUpModel;
import app.bubbleupretailers.OrderRejectSection.CancelActivity;
import app.bubbleupretailers.R;
import app.bubbleupretailers.SeeUserDetailsSection.See_DetailsActivity;

public class PickupAdapter extends RecyclerView.Adapter<PickupAdapter.ViewHolder> {

    Context context;
    ArrayList<PickUpModel> pickUpModels = new ArrayList<>();
    public OnclickListener onclickListener;

    public PickupAdapter(Context context, ArrayList<PickUpModel> pickUpModels, OnclickListener onclickListener) {
        this.context = context;
        this.pickUpModels = pickUpModels;
        this.onclickListener = onclickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pickup_secheduled,parent,false);
        return new PickupAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        PickUpModel pickUpModel = pickUpModels.get(position);
        holder.user_name.setText(pickUpModel.getName());
        holder.service_name.setText("Service Type : "+ pickUpModel.getServiceType());
        holder.service_job_id.setText("Service Id : "+ pickUpModel.getService_id());
        holder.user_location.setText(pickUpModel.getAddress());
        holder.date_of_booking.setText(pickUpModel.getBookingDate());
        holder.time_slot.setText(pickUpModel.getBookingTime());
        holder.btn_reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(context, CancelActivity.class);
                intent1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent1);
            }
        });
        holder.see_details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, See_DetailsActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onclickListener.onClick();

                Toast.makeText(context.getApplicationContext(), "Order Accepted",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return pickUpModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView user_name,service_name,service_job_id,user_location,date_of_booking,time_slot,see_details;
        Button btn_accept,btn_reject;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            user_name = itemView.findViewById(R.id.user_name);
            service_name = itemView.findViewById(R.id.service_name);
            service_job_id = itemView.findViewById(R.id.service_job_id);
            user_location = itemView.findViewById(R.id.user_location);
            date_of_booking = itemView.findViewById(R.id.date_of_booking);
            see_details = itemView.findViewById(R.id.see_details);
            time_slot = itemView.findViewById(R.id.time_slot);
            btn_accept = itemView.findViewById(R.id.btn_accept);
            btn_reject = itemView.findViewById(R.id.btn_reject);
        }
    }

    public interface OnclickListener{

        public void onClick();

    }
}
