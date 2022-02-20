package uk.ac.le.co2103.hw4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.room.Database;

import android.content.Intent;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteConstraintException;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.Serializable;
import java.util.List;

public class AddProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = AddProductActivity.class.getSimpleName();
    private EditText productName;
    private EditText productQuantity;
    private ItemViewModel itemViewModel;
    private String productUnit;
    ShoppingDB shoppingDB;
    ItemDao itemDao;

    Boolean DuplicateItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        int listid = getIntent().getIntExtra("listid", 0);

    Spinner spinner = findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_unit, android.R.layout.simple_spinner_item);
    adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
    spinner.setAdapter(adapter);
    spinner.setOnItemSelectedListener(this);

        final Button button = findViewById(R.id.button_Add);
        button.setOnClickListener(view ->{
            productName = findViewById(R.id.editTextName);
            productQuantity = findViewById(R.id.editTextQuantity);



            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(productName.getText()) || TextUtils.isEmpty(productQuantity.getText())){
                Toast.makeText(this, "Name or quantity cannot be empty", Toast.LENGTH_LONG).show();
            }else if (shoppingDB.getDatabase(this).itemDao().isRecordExist(productName.getText().toString(), listid) == false){
                replyIntent.putExtra("productName", productName.getText().toString());
                replyIntent.putExtra("productQuantity", Integer.parseInt(productQuantity.getText().toString()));
                replyIntent.putExtra("productUnit", productUnit);
                replyIntent.putExtra("listid", listid);
                setResult(RESULT_OK, replyIntent);
                finish();
            }else if (shoppingDB.getDatabase(this).itemDao().isRecordExist(productName.getText().toString(), listid) == true){
                setResult(RESULT_CANCELED, replyIntent);
                finish();
            }
        });

}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String text = parent.getItemAtPosition(position).toString();
        productUnit = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}