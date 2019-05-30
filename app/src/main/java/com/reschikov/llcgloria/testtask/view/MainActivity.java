package com.reschikov.llcgloria.testtask.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.reschikov.llcgloria.testtask.R;
import com.reschikov.llcgloria.testtask.Rule;
import com.reschikov.llcgloria.testtask.view.main.MainFragment;
import com.reschikov.llcgloria.testtask.view.map.MapsFragment;
import com.reschikov.llcgloria.testtask.view.progress.ProgressFragment;

public class MainActivity extends AppCompatActivity implements Backable{

	private static final String TAG_MAIN = "main";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity);
		if (savedInstanceState == null){
			load();
		}
	}

	private void load(){
		getSupportFragmentManager().beginTransaction()
			.replace(R.id.frame_master, new MainFragment(), TAG_MAIN)
			.add(R.id.frame_master, new ProgressFragment(), Rule.TAG_PROGRESS)
			.commit();
	}

	@Override
	public void onBackPressed() {
		MapsFragment fragment = (MapsFragment) getSupportFragmentManager().findFragmentByTag(Rule.TAG_MAP);
		if (fragment != null){
			load();
			return;
		}
		super.onBackPressed();
	}

	@Override
	public void toBack() {
		ProgressFragment fragment = (ProgressFragment) getSupportFragmentManager().findFragmentByTag(Rule.TAG_PROGRESS);
		if (fragment != null){
			getSupportFragmentManager().beginTransaction()
				.remove(fragment)
				.commit();
		}
	}
}