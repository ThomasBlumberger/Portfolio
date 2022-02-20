package uk.ac.le.co2103.hw4;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class ShoppingListRepository {
    private ShoppingListDao ShoppingListDao;
    private LiveData<List<ShoppingList>> allShoppingLists;

    ShoppingListRepository(Application application){
        ShoppingDB db = ShoppingDB.getDatabase(application);
        ShoppingListDao = db.shoppingListDao();
        allShoppingLists = ShoppingListDao.getShoppingList();
    }

    LiveData<List<ShoppingList>> getAllShoppingLists() { return allShoppingLists;}

    public void delete(ShoppingList shoppingList) {
        new DeleteListAsyncTask(ShoppingListDao).execute(shoppingList);
    }

    void insert(ShoppingList shoppingList){
    ShoppingDB.databaseWriteExecutor.execute(() -> {
    ShoppingListDao.insert(shoppingList);
    });
    }
    private static class DeleteListAsyncTask extends AsyncTask<ShoppingList, Void, Void> {
        private ShoppingListDao ShoppingListDao;
        private DeleteListAsyncTask(ShoppingListDao ShoppingListDao) {
            this.ShoppingListDao = ShoppingListDao;
        }
        @Override
        protected Void doInBackground(ShoppingList... shoppingList) {
            ShoppingListDao.deleteList(shoppingList[0]);
            return null;
        }
    }
}
