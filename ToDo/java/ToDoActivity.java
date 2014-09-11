package todo.underthebridge.com.todo;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import adapters.ListAdapter;

public class ToDoActivity extends Activity implements View.OnClickListener {

    // Declare widgets up here to allow our whole class access to our widgets
    EditText edtInput;
    Button btnAdd;
    ListView lvList;

    // DataSource
    List<String> dsItems;

    // Using Custom Adapter by extending the ArrayAdapter
    ListAdapter adapter;

    // Android Templated Adapter
    // ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create and instantiate a new Collection of Strings
        dsItems = new ArrayList<String>();

        // Inflate the GUI that we have created in xml
        setContentView(R.layout.activity_todo);

        // assign our widgets to our elements in the xml above so that we can manipulate in code
        edtInput = (EditText) findViewById(R.id.edtInput);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        lvList = (ListView) findViewById(R.id.lvList);

        // Create and instantiate android's default ArrayAdapter Class and use its default template
        // adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dsItems);

        // Create and instantiate our custom ArrayAdapter Class and use our defined views
        adapter = new ListAdapter(getApplicationContext(), dsItems);

        // Finally give our listview a datasource by providing an adapter to it
        lvList.setAdapter(adapter);

        // Create our listener to watch the button activate
        btnAdd.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.to_do, menu);
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
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        // the collection dsitem has a method to add new Strings called "add"
        dsItems.add(edtInput.getText().toString());

        // update the adapter with the newly added item
        adapter.add(dsItems);

        // clear the input box
        edtInput.setText("");
    }

    // Use this for android's default adapter
//    @Override
//    public void onClick(View v) {
//        dsItems.add(edtInput.getText().toString());
//        adapter.notifyDataSetChanged();
//        edtInput.setText("");
//    }
}
