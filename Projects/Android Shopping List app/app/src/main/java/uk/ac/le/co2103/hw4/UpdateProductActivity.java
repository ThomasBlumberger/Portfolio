package uk.ac.le.co2103.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class UpdateProductActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

        private EditText quantityText;
        private EditText nameText;
        private String unitSpin;
    public static final String UPDATE_ID = "uk.ac.le.co2103.hw4.UPDATE_ID";
    public static final String UPDATE_NAME = "uk.ac.le.co2103.hw4.UPDATE_NAME";
    public static final String UPDATE_QUANTITY = "uk.ac.le.co2103.hw4.UPDATE_QUANTITY";
    public static final String UPDATE_SPINNER = "uk.ac.le.co2103.hw4.UPDATE_SPINNER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);


        quantityText = findViewById(R.id.editTextUpdateQuantity);
        nameText = findViewById(R.id.editTextUpdateName);

        Spinner spinner = findViewById(R.id.updateUnitSpin);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.labels_unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        Intent intent = getIntent();

        if (intent.hasExtra(UPDATE_ID)){
            nameText.setText(intent.getStringExtra(UPDATE_NAME));
            quantityText.setText(Integer.toString(intent.getIntExtra(UPDATE_QUANTITY, 0)));

        }
        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view ->{
            nameText = findViewById(R.id.editTextUpdateName);
            quantityText = findViewById(R.id.editTextUpdateQuantity);

            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(nameText.getText()) || TextUtils.isEmpty(quantityText.getText())){
                setResult(RESULT_CANCELED, replyIntent);
            }else {
                replyIntent.putExtra(UPDATE_NAME, nameText.getText().toString());
                replyIntent.putExtra(UPDATE_QUANTITY, Integer.parseInt(quantityText.getText().toString()));
                replyIntent.putExtra(UPDATE_SPINNER, unitSpin);
                int id = getIntent().getIntExtra(UPDATE_ID, 0);
        if (id != -1){
                replyIntent.putExtra(UPDATE_ID, id);
        }
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
    int quantity = 0;
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
    }
    public void decrement(View view) {
        if (quantity > 0) {
            quantity = quantity - 1;
            display(quantity);
        }
    }

    private void display(int number) {
        quantityText.setText("" + number);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        unitSpin = text;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}