package uk.ac.le.co2103.hw4;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ItemDao {
    @Insert
    void insert(Item item);

    @Delete
    void deleteItem(Item item);

    @Query("DELETE FROM items")
    void deleteAll();

    @Update
    void update(Item item);

    @Query("SELECT * FROM items")
    public LiveData<List<Item>> getAllItems();

    @Transaction
    @Query( "SELECT * FROM items WHERE shoppingListID = :shoppingListID" )
    public LiveData<List<Item>> getItemInShoppingList(int shoppingListID);

    @Query("SELECT EXISTS(SELECT * FROM items WHERE name= :name AND shoppingListID= :shoppingListID)")
    boolean isRecordExist(String name, int shoppingListID);
}
