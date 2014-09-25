package abat.underthebridge.com.abat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Quan on 9/25/2014.
 */
public class NewActivity extends Activity {

    Button btnSend;
    EditText edtInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        btnSend = (Button) findViewById(R.id.btnSend);
        edtInput = (EditText) findViewById(R.id.edtInput);

        // Set on click listener to record our input from the edit text
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Grab whatever was typed into the EditText widget and store it in "inputText"
                String inputText = edtInput.getText().toString();

                // Create an intent that will carry our data back
                Intent intentReturn = new Intent();
                // Our key / value pair to package with our intent
                intentReturn.putExtra("RETURN VALUE", inputText);

                // finish it off with resultcode and commit the intent object
                setResult(RESULT_OK, intentReturn);

                // Close this activity's life cycle
                finish();
            }
        });

    }
}
