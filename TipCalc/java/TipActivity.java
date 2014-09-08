package tipcalculator.underthebridge.com.tipcalculator;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class TipActivity extends Activity {

    // Define our widgets for our Activity Class (allow access to all our methods)
    EditText inputPrice;
    Button processButton;
    TextView tipValue;

    // Build your tip calc in this method!
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Step 1: Load the xml page by inflating it with the activity's method setContentView
        setContentView(R.layout.activity_tip);

        // Step 2: Find the elements in that xml page through a method called findViewById
        // Find them by the id's we named them in the XML page
        // After finding them we can then handle each of their functionality through dot operators
        inputPrice = (EditText) findViewById(R.id.edtPrice);
        processButton = (Button) findViewById(R.id.btnProcessTip);
        tipValue = (TextView) findViewById(R.id.tvTipValue);

        // Step 3: Observe changes by checking when the button is click with a listener method
        processButton.setOnClickListener(new View.OnClickListener() {

            // Write your block of code of what is expected when you hit the button!
            @Override
            public void onClick(View v) {

                // Grab the price from our input box
                String inputString = inputPrice.getText().toString();

                // Convert the value to a double to process later
                double inputDouble = Double.valueOf(inputString);

                // Give our custom method we created the double value to process!
                // then store it in a variable to display
                double tip = calculateTip(inputDouble);

                // Convert our tip value to a string so the setText method can understand
                String displayTip = String.valueOf(tip);

                // Finally display our result to the activity!!
                tipValue.setText("Tip: $" + displayTip);
            }
        });

    }

    // Our custom method to calculate our tips
    private double calculateTip(double passThisValue) {

        // Assume our tip will be 20% of our meal
        double tipPercent = 0.20;

        // Return the calculations
        return passThisValue*tipPercent;
    }


    // Do not worry about this pregenerated method for now...
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip, menu);
        return true;
    }

    // Do not worry about this pregenerated method for now...
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
