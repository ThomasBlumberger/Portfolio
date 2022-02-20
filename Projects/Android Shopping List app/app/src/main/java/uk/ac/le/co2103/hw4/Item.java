package uk.ac.le.co2103.hw4;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "items", primaryKeys = {"name", "shoppingListID"}, foreignKeys = {@ForeignKey(onDelete = CASCADE, entity = ShoppingList.class, parentColumns = {"listId"}, childColumns = {"shoppingListID"})})
public class Item {

    @NonNull
    public String name;
    @NonNull
    public int quantity;
    @NonNull
    public String unit;
    @NonNull
    @ColumnInfo(name = "shoppingListID")
    public int shoppingListID;


    public Item(@NonNull String name, @NonNull int quantity, @NonNull String unit, int shoppingListID){ this.name = name; this.quantity = quantity; this.unit = unit; this.shoppingListID=shoppingListID;}
    public String getItem() { return name + quantity + unit;}

    public String getName(){return name;}
    public void setName(){this.name=name;}

    public int getQuantity(){return quantity;}
    public void setQuantity(){this.quantity=quantity;}

    public String getUnit(){return unit;}
    public void setUnit(){this.unit=unit;}

    public int getShoppingListID(){return shoppingListID;}
    public void setShoppingListID(){this.shoppingListID=shoppingListID;}
}
