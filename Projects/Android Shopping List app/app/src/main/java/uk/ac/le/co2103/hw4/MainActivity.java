package uk.ac.le.co2103.hw4;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.browse.MediaBrowser;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ItemViewModel itemViewModel;
    private ShoppingListViewModel shoppingListViewModel;
    public static final int ADD_SHOPPING_LIST_ACTIVITY_REQUEST_CODE = 1;
    private LiveData<List<ShoppingList>> mAllLists;
    private ShoppingListAdapter shopAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_main);



        Log.d(TAG, "Creating recyclerView");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        final ShoppingListAdapter adapter = new ShoppingListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Log.d(TAG, "Adding shopping lists to adapter");
        shoppingListViewModel = new ViewModelProvider(this).get(ShoppingListViewModel.class);
        shoppingListViewModel.getAllShoppingLists().observe(this, new Observer<List<ShoppingList>>() {
            @Override
            public void onChanged(List<ShoppingList> shoppingLists) {
                adapter.setShoppingLists(shoppingLists);

            }
        });

        registerForContextMenu(recyclerView);

        Log.d(TAG, "Setting up floating action button");
        final FloatingActionButton button = findViewById(R.id.fab);
        button.setOnClickListener(view -> {
            Log.d(TAG, "Floating action button clicked.");
            Intent intent = new Intent(MainActivity.this, CreateListActivity.class);
            startActivityForResult(intent, ADD_SHOPPING_LIST_ACTIVITY_REQUEST_CODE);
        });
        adapter.setOnShoppingListener(new ShoppingListAdapter.OnShoppingListListener() {
            @Override
            public void onShoppingListClick(ShoppingList shoppingList) {
                Intent intent = new Intent(MainActivity.this, ShoppingListActivity.class);
                intent.putExtra("listId", shoppingList.getListId());
                   startActivity(intent);
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
                shoppingListViewModel.delete(adapter.getShoppinglistAt(viewHolder.getAdapterPosition()));
                Toast.makeText(MainActivity.this, "Shopping list deleted", Toast.LENGTH_SHORT).show();
            }
        }).attachToRecyclerView(recyclerView);


    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ADD_SHOPPING_LIST_ACTIVITY_REQUEST_CODE && resultCode == RESULT_OK) {
            String listimage = data.getStringExtra("listimage");
            ShoppingList shoppingList = new ShoppingList(data.getStringExtra(CreateListActivity.EXTRA_REPLY), listimage);
            shoppingListViewModel.insert(shoppingList);
        } else {
            Toast.makeText(
                    getApplicationContext(),
                    "Shopping List name cannot be empty.",
                    Toast.LENGTH_LONG).show();
        }
    }

}
