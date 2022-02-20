package uk.ac.le.co2103.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.stream.Stream;

public class CreateListActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private static final String TAG = CreateListActivity.class.getSimpleName();
    public static final String EXTRA_REPLY = "uk.ac.le.co2103.hw4.REPLY";
    public static final String IMAGE_REPLY = "uk.ac.le.co2103.hw4.REPLY";
    private EditText editTextList;
    private Spinner spinnerImage;
    private String listImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");

        setContentView(R.layout.activity_create_list);

    editTextList = findViewById(R.id.editTextShopListName);
    spinnerImage = findViewById(R.id.image_spinner);

    SimpleImageArrayAdapter adapter = new SimpleImageArrayAdapter(this,
            new Integer[]{R.drawable.shopping_list, R.drawable.phone, R.drawable.clothes, R.drawable.party_hat, R.drawable.shopping_bag});
    spinnerImage.setAdapter(adapter);
        spinnerImage.setOnItemSelectedListener(this);
    
    final Button button = findViewById(R.id.button_create);
    button.setOnClickListener(view ->{
        Intent replyIntent = new Intent();
        if (TextUtils.isEmpty(editTextList.getText())){
            Log.i(TAG, "Empty text could be controlled in UI (Save button disabled");
            setResult(RESULT_CANCELED, replyIntent);
        } else {
            Log.i(TAG, "Adding List");
            replyIntent.putExtra(EXTRA_REPLY, editTextList.getText().toString());
            replyIntent.putExtra("listimage", listImage);
            setResult(RESULT_OK, replyIntent);
        }
        finish();
    });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
        String text = parent.getItemAtPosition(position).toString();
        listImage = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}