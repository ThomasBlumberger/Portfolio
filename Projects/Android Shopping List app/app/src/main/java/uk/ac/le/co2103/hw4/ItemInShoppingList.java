package uk.ac.le.co2103.hw4;

import androidx.lifecycle.LiveData;
import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class ItemInShoppingList {
    @Embedded public ShoppingList shoppingList;
    @Relation(
            parentColumn = "listid",
            entityColumn = "shoppingListID",
            entity = Item.class
    )
    public List<Item> items;
}
