package de.thbingen.android.foodforall.userInterface.logicalRessources;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import de.thbingen.android.foodforall.R;

/**
 * Created by Richard on 04.12.2017.
 */

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder>
{
    private List<Food> foodList;

    protected class FoodViewHolder extends RecyclerView.ViewHolder
    {
        private TextView foodView;
        private TextView typeView;
        private TextView quantityView;

        public FoodViewHolder(View itemView)
        {
            super(itemView);
            foodView = (TextView) itemView.findViewById(R.id.name);
            typeView = (TextView) itemView.findViewById(R.id.type);
            quantityView = (TextView) itemView.findViewById(R.id.quantity);
        }
    }

    public FoodAdapter(List<Food> foods)
    {
        this.foodList = foods;
    }

    @Override
    public FoodViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.food_list_row, parent, false);
        return new FoodViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(FoodViewHolder holder, int position)
    {
        Food food = foodList.get(position);
        holder.foodView.setText(food.getName());
        holder.typeView.setText(food.getType());
        holder.quantityView.setText(food.getQuantity());
    }

    @Override
    public int getItemCount()
    {
        return foodList.size();
    }
}
