package uk.ac.le.co2103.hw4;

import android.net.Uri;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.Insert;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "shoppinglists", indices = @Index(value = "name", unique = true))
public class ShoppingList {
@NonNull
@PrimaryKey(autoGenerate = true)
public int listId;
@NonNull
public String name;
public String listimage;


public String getListimage(){return listimage;}
public void setListimage(String listimage){this.listimage=listimage;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public ShoppingList(@NonNull String name, String listimage){this.name=name; this.listimage=listimage;}

    public String getShoppingList(){ return name +  listimage;}


    public int getListId(){return listId;}
    public void setListId(){this.listId=listId;}

}
