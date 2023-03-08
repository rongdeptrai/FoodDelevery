package OrderFood.ute.udn.vn.ltdtdd_nhom1.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import OrderFood.ute.udn.vn.ltdtdd_nhom1.R;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.activity.HomeActivity;
import OrderFood.ute.udn.vn.ltdtdd_nhom1.model.Nearby;


public class NearbyAdapter extends RecyclerView.Adapter<NearbyAdapter.NearbyViewHolder>{

    Context context;
    List<Nearby> nearbyList;

    public NearbyAdapter(Context context, List<Nearby> nearbyList) {
        this.context = context;
        this.nearbyList = nearbyList;
    }

    @NonNull
    @Override
    public NearbyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.nearby_item, parent, false);
        return new NearbyAdapter.NearbyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NearbyViewHolder holder, int position) {
        holder.imgStore.setImageResource(nearbyList.get(position).getImageStore());
        holder.imgFood1.setImageResource(nearbyList.get(position).getImageFood1());
        holder.imgFood2.setImageResource(nearbyList.get(position).getImageFood2());
        holder.imgFood3.setImageResource(nearbyList.get(position).getImageFood3());
        holder.imgFood4.setImageResource(nearbyList.get(position).getImageFood4());
        holder.imgFood5.setImageResource(nearbyList.get(position).getImageFood5());

        holder.txtStore.setText(nearbyList.get(position).getNameStore());
        holder.txtLocation.setText(nearbyList.get(position).getLocation());
        holder.txtReviewers.setText(nearbyList.get(position).getReviewers());
//        holder.txtTime.setText(nearbyList.get(position).getTime());
//        //holder.txtDistance.setText(nearbyList.get(position).getDistance());
//        holder.txtRating.setText(nearbyList.get(position).getRating());

        holder.txtFood1.setText(nearbyList.get(position).getFood1());
        holder.txtFood2.setText(nearbyList.get(position).getFood2());
        holder.txtFood3.setText(nearbyList.get(position).getFood3());
        holder.txtFood4.setText(nearbyList.get(position).getFood4());
        holder.txtFood5.setText(nearbyList.get(position).getFood5());

//        holder.txtPrice1.setText(nearbyList.get(position).getPrice1());
//        holder.txtPrice2.setText(nearbyList.get(position).getPrice2());
//        holder.txtPrice3.setText(nearbyList.get(position).getPrice3());
//        holder.txtPrice4.setText(nearbyList.get(position).getPrice4());
//        holder.txtPrice5.setText(nearbyList.get(position).getPrice5());


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, HomeActivity.class);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return nearbyList.size();
    }

    public static final class NearbyViewHolder extends RecyclerView.ViewHolder{

        ImageView imgStore, imgFood1, imgFood2, imgFood3, imgFood4, imgFood5;
        TextView txtStore, txtLocation, txtRating, txtTime, txtDistance, txtFood1, txtFood2, txtFood3, txtFood4, txtFood5, txtPrice1, txtPrice2, txtPrice3, txtPrice4, txtPrice5, txtReviewers;


        public NearbyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgStore = itemView.findViewById(R.id.store_image);
            imgFood1 = itemView.findViewById(R.id.food_image_1);
            imgFood2 = itemView.findViewById(R.id.food_image_2);
            imgFood3 = itemView.findViewById(R.id.food_image_3);
            imgFood4 = itemView.findViewById(R.id.food_image_4);
            imgFood5 = itemView.findViewById(R.id.food_image_5);
            txtStore = itemView.findViewById(R.id.txtNameStore);
            txtDistance = itemView.findViewById(R.id.txtDistance);
            txtLocation = itemView.findViewById(R.id.txtLocation);
            txtRating = itemView.findViewById(R.id.txtRating);
            txtTime = itemView.findViewById(R.id.txtTime);
            txtFood1 = itemView.findViewById(R.id.txtFood1);
            txtFood2 = itemView.findViewById(R.id.txtFood2);
            txtFood3 = itemView.findViewById(R.id.txtFood3);
            txtFood4 = itemView.findViewById(R.id.txtFood4);
            txtFood5 = itemView.findViewById(R.id.txtFood5);

            txtPrice1 = itemView.findViewById(R.id.price_1);
            txtPrice2 = itemView.findViewById(R.id.price_2);
            txtPrice3 = itemView.findViewById(R.id.price_3);
            txtPrice4 = itemView.findViewById(R.id.price_4);
            txtPrice5 = itemView.findViewById(R.id.price_5);

            txtReviewers = itemView.findViewById(R.id.txtReviewers);

        }
    }
}