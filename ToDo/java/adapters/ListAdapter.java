package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import todo.underthebridge.com.todo.R;

/**
 * Created by Quan on 9/10/2014.
 */
public class ListAdapter extends ArrayAdapter<List<String>> {

    List<String> items;

    // our constructor will pass in the current activity's context and datasource
    public ListAdapter(Context context, List<String> items) {
        super(context, R.layout.adapter_item);
        this.items = items;
    }

    // This method generates each row of the list view individually
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // gets the current String at the position of the list
        String currentItem = items.get(position);

        // inflates the row with our custom row gui
        if (convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_item, parent, false);
        }

        // find the elements in that row
        TextView tvItem = (TextView) convertView.findViewById(R.id.tvItem);

        // display the value on that element
        tvItem.setText(currentItem);

        return convertView;
    }
}
