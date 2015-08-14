package com.example.multiselectlistview;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView.MultiChoiceModeListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private ListView mListView;
	private ArrayAdapter<String> mAdapter;
	private String [] data={"A","B","C","D","E","F","G"};
		@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mListView=(ListView)findViewById(R.id.listview);
		mAdapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, data);
		mListView.setAdapter(mAdapter);
						
		mListView.setMultiChoiceModeListener(new MultiChoiceModeListener() {
			
			@Override
			public boolean onPrepareActionMode(ActionMode arg0, Menu arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onPrepareActionMode", Toast.LENGTH_LONG).show();
				return false;
			}
			
			@Override
			public void onDestroyActionMode(ActionMode arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onDestroyActionMode", Toast.LENGTH_LONG).show();
			}
			
			@Override
			public boolean onCreateActionMode(ActionMode arg0, Menu arg1) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onCreateActionMode", Toast.LENGTH_LONG).show();
		        MenuInflater inflater = arg0.getMenuInflater();
		        inflater.inflate(R.menu.main, arg1);
		        return true;

			}
			
			@Override
			public boolean onActionItemClicked(ActionMode arg0, MenuItem arg1) {
				Toast.makeText(MainActivity.this, "onActionItemClicked", Toast.LENGTH_LONG).show();
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public void onItemCheckedStateChanged(ActionMode arg0, int arg1, long arg2,
					boolean arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "onItemCheckedStateChanged", Toast.LENGTH_LONG).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
}
