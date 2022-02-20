package uk.ac.le.co2103.hw4;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter<ItemListAdapter.ItemViewHolder> {

    public OnItemListener mOnItemListener;
    private List<Item> items = new ArrayList<>();


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        Item current = items.get(position);
        holder.itemTextView.setText(current.getName() + " " + current.getQuantity() + " " + current.getUnit());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(List<Item> items){
        this.items = items;
        notifyDataSetChanged();
    }

    public Item getItemAt(int position){
        return items.get(position);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView itemTextView;


        private ItemViewHolder(View itemView) {
            super(itemView);
            itemTextView = itemView.findViewById(R.id.textViewName);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    if (mOnItemListener != null && position != RecyclerView.NO_POSITION) {
                        mOnItemListener.onItemClick(items.get(position));
                    }

                }
            });
        }
    }
    public interface OnItemListener {
        void onItemClick(Item item);
    }
    public void setOnItemListener(OnItemListener listener){
    this.mOnItemListener = listener;
    }
}
