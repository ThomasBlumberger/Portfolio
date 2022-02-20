package uk.ac.le.co2103.hw4;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private ItemRepository repo;


   private final LiveData<List<Item>> allItems;



    public ItemViewModel (Application application) {
        super(application);
        repo = new ItemRepository(application);
        allItems = repo.getAllItems();
    }


    public void update(Item item) {
        repo.update(item);
    }

    public void delete(Item item) { repo.delete(item);}

    public void deleteAll() {repo.deleteAllItems();}

    LiveData<List<Item>> getAllItems() { return allItems;}

    LiveData<List<Item>> getItemInShoppingList(int shoppingListID) { return repo.getItemInShoppingList(shoppingListID); }

    public void insert(Item item) { repo.insert(item); }
}
