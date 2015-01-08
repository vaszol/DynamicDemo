package com.example.vas.dynamicdemo;

import android.app.ListActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;


public class DynamicDemo extends ListActivity {

    private static final String[] items={"lorem", "ipsum", "dolor",
            "sit", "amet",
            "consectetuer", "adipiscing", "elit", "morbi", "vel",
            "ligula", "vitae", "arcu", "aliquet", "mollis",
            "etiam", "vel", "erat", "placerat", "ante",
            "porttitor", "sodales", "pellentesque", "augue", "purus"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new IconicAdapter());
    }

    class IconicAdapter extends ArrayAdapter<String> {
        IconicAdapter() {
            super(DynamicDemo.this, R.layout.row, R.id.label, items);
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View row=super.getView(position, convertView, parent);
            //////////////////вычисление иконки
            ImageView icon=(ImageView)row.findViewById(R.id.icon);
            if (items[position].length()>4) {
                icon.setImageResource(R.drawable.delete);
            }
            else {
                icon.setImageResource(R.drawable.ok);
            }
            /////////////////вычисление длины слова
            TextView size=(TextView)row.findViewById(R.id.size);
            size.setText(String.format(getString(R.string.size_template),
                    items[position].length()));
            return(row);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
