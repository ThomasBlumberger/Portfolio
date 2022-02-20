package uk.ac.le.co2103.hw4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

@Dao
public interface ShoppingListDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ShoppingList shoppingList);

    @Query("DELETE FROM shoppinglists")
    void deleteAll();

    @Delete
    void deleteList(ShoppingList shoppingList);

    @Query("SELECT * FROM shoppinglists")
    LiveData<List<ShoppingList>> getShoppingList();


}
