package uk.ac.le.co2103.hw4;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ItemRepository {
    private ItemDao itemDao;
    private LiveData<List<Item>> allItems;

    ItemRepository(Application application) {
        ShoppingDB db = ShoppingDB.getDatabase(application);
        itemDao = db.itemDao();
        allItems = itemDao.getAllItems();
    }

    LiveData<List<Item>> getAllItems() {
        return allItems;
    }

    public void update(Item item){
        new UpdateItemAsyncTask(itemDao).execute(item);
    }

    public void delete(Item item) {
        new DeleteItemAsyncTask(itemDao).execute(item);
    }
    public void deleteAllItems() {
        new DeleteAllItemsAsyncTask(itemDao).execute();
    }



    LiveData<List<Item>> getItemInShoppingList(int shoppingListID){
        return itemDao.getItemInShoppingList(shoppingListID);
    }


    void insert(Item item) {
        ShoppingDB.databaseWriteExecutor.execute(() -> {
            itemDao.insert(item);
        });
    }

    private static class UpdateItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;
        private UpdateItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }
        @Override
        protected Void doInBackground(Item... items) {
            itemDao.update(items[0]);
            return null;
        }
    }
    private static class DeleteItemAsyncTask extends AsyncTask<Item, Void, Void> {
        private ItemDao itemDao;
        private DeleteItemAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }
        @Override
        protected Void doInBackground(Item... items) {
            itemDao.deleteItem(items[0]);
            return null;
        }
    }
    private static class DeleteAllItemsAsyncTask extends AsyncTask<Void, Void, Void> {
        private ItemDao itemDao;
        private DeleteAllItemsAsyncTask(ItemDao itemDao) {
            this.itemDao = itemDao;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.deleteAll();
            return null;
        }
    }
    }
