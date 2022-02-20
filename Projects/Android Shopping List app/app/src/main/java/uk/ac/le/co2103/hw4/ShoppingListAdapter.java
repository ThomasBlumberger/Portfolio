package uk.ac.le.co2103.hw4;

import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ShoppingListViewHolder> {

    public OnShoppingListListener mOnShoppingListener;
    private List<ShoppingList> shoppingLists = new ArrayList<>();

    @Override
    public ShoppingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_shoppinglist, parent, false);
        return new ShoppingListViewHolder(view);
           }

    @Override
    public void onBindViewHolder(ShoppingListViewHolder holder, int position) {
        ShoppingList current = shoppingLists.get(position);
        holder.ShoppingListTextView.setText(current.getName());
        holder.ShoppingListImageView.setImageResource(Integer.parseInt(current.getListimage()));

    }

    @Override
    public int getItemCount() { return shoppingLists.size();}

    public void setShoppingLists(List<ShoppingList> shoppingLists){
        this.shoppingLists=shoppingLists;
        notifyDataSetChanged();
    }

    public ShoppingList getShoppinglistAt(int position){return shoppingLists.get(position);}

    class ShoppingListViewHolder extends RecyclerView.ViewHolder {
        private final TextView ShoppingListTextView;
        private final ImageView ShoppingListImageView;



        private ShoppingListViewHolder(View shoppingListView) {
            super(shoppingListView);
            ShoppingListTextView = shoppingListView.findViewById(R.id.textView);
            ShoppingListImageView = shoppingListView.findViewById(R.id.imageView2);

            shoppingListView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getLayoutPosition();
                    if (mOnShoppingListener != null && position != RecyclerView.NO_POSITION) {
                        mOnShoppingListener.onShoppingListClick(shoppingLists.get(position));
                    }
                }
            });

        }

    }
    public interface OnShoppingListListener {
        void onShoppingListClick(ShoppingList shoppingList);
    }

    public void setOnShoppingListener(OnShoppingListListener listener){this.mOnShoppingListener = listener;}


    }



