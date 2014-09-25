package abat.underthebridge.com.abat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Abat extends Activity {

    TextView tvValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abat);
        tvValue = (TextView) findViewById(R.id.tvValue);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.abat, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        // We declared a new element in our menu xml
        if (id == R.id.new_button) {
            // Starting a new activity with Intent Class
            // It expects two arguments, current activity and new activity class
            Intent newActivity = new Intent(this, NewActivity.class);

            // If you are expecting a result to be returned
            // Use the starActivityForResult method
            // Pass in the Intent declared above and your custom REQUEST CODE!
            // REQUEST CODE WE SPECIFIED HERE IS 99
            startActivityForResult(newActivity, 99);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // This is a require method overload to capture an incoming payload sent from the last activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Must be the same request code specified when we launch the new activity which was 99
        if(requestCode == 99 ){
            // We are looking for a result code pair which has to mark RESULT_OK
            if(resultCode == RESULT_OK){
                // To retrieve the value from the new activity, we grab the data from the packaged
                // intent that we have placed into the data object and grabbing its string key
                // which is represented as "RETURN VALUE"
                // Then finally set the text!
                tvValue.setText(data.getStringExtra("RETURN VALUE"));
            }
        }

    }
}
