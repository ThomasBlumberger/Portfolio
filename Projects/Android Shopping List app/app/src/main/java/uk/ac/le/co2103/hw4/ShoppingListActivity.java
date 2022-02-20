package uk.ac.le.co2103.hw4;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Update;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.Serializable;
import java.util.List;

public class ShoppingListActivity extends AppCompatActivity {

    private ItemViewModel itemViewModel;
    private static final String TAG = ShoppingListActivity.class.getSimpleName();
    public static final int ADD_PRODUCT_ACTIVITY_REQUEST_CODE = 1;
    public static final int UPDATE_PRODUCT_ACTIVITY_REQUEST_CODE = 2;
    private ItemListAdapter adapter;
    private Item items;
    private ItemListAdapter.ItemViewHolder holder;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list);

       int listid = getIntent().getIntExtra("listId", 0);

        RecyclerView recyclerView = findViewById(R.id.recyclerview1);
        final ItemListAdapter adapter = new ItemListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        itemViewModel = new ViewModelProvider(this).get(ItemViewModel.class);
        itemViewModel.getItemInShoppingList(listid).observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(List<Item> itemList) {
                adapter.setItems(itemList);
            }
        });

        registerForContextMenu(recyclerView);

        Log.d(TAG, "Setting up floating action button");
        final FloatingActionButton button = findViewById(R.id.fabAddProduct);
        button.setOnClickListener(view -> {
            Log.d(TAG, "Floating action button clicked.");
            Intent intent = new Intent(this, AddProductActivity.class);
            intent.putExtra("listid", listid);
            startActivityForResult(intent, ADD_PRODUCT_ACTIVITY_REQUEST_CODE);
        });

        adapter.setOnItemListener(new ItemListAdapter.OnItemListener() {
            @Override
            public void onItemClick(Item item) {
                Intent intent = new Intent(ShoppingListActivity.this, UpdateProductActivity.class);
                intent.putExtra(UpdateProductActivity.UPDATE_ID, item.getShoppingListID());
                intent.putExtra(UpdateProductActivity.UPDATE_NAME, item.getName());
                intent.putExtra(UpdateProductActivity.UPDATE_QUANTITY, item.getQuantity());
                intent.putExtra(UpdateProductActivity.UPDATE_SPINNER, item.getUnit());
                startActivityForResult(intent, UPDATE_PRODUCT_ACTIVITY_REQUEST_CODE);

            }
        });
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                itemViewModel.delete(adapter.getItemAt(viewHolder.getAdapterPosition()));
                Toast.makeText(ShoppingListActivity.this, "Product deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_PRODUCT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            Item item = new Item(data.getStringExtra("productName"), data.getIntExtra("productQuantity", 0), data.getStringExtra("productUnit"), data.getIntExtra("listid", 0));
            itemViewModel.insert(item);
        } else if (requestCode == UPDATE_PRODUCT_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK){
            int id = data.getIntExtra(UpdateProductActivity.UPDATE_ID, 0);
            if (id == -1){
                Toast.makeText(this, "Item cannot be updated", Toast.LENGTH_SHORT).show();
                return;
            }
            String newName = data.getStringExtra(UpdateProductActivity.UPDATE_NAME);
            int quantity = data.getIntExtra(UpdateProductActivity.UPDATE_QUANTITY, 0);
            String unit = data.getStringExtra(UpdateProductActivity.UPDATE_SPINNER);

            Item item = new Item(newName, quantity, unit , id);
            item.setShoppingListID();
            itemViewModel.update(item);

            Toast.makeText(this, "Item Updated", Toast.LENGTH_SHORT).show();
        }
            else{
            Toast.makeText(
                    getApplicationContext(),
                    "Product already exists",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        super.onContextItemSelected(item);
        switch (item.getItemId()){
            case R.id.edit:
                return true;
            case R.id.delete:
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        getMenuInflater().inflate(R.menu.menu_item, menu);
    }

}