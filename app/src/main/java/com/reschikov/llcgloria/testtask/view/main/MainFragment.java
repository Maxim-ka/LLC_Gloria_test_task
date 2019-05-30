package com.reschikov.llcgloria.testtask.view.main;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.reschikov.llcgloria.testtask.R;
import com.reschikov.llcgloria.testtask.Rule;
import com.reschikov.llcgloria.testtask.model.data.City;
import com.reschikov.llcgloria.testtask.presenter.MainPresenter;
import com.reschikov.llcgloria.testtask.view.Backable;
import com.reschikov.llcgloria.testtask.view.progress.ProgressFragment;
import com.reschikov.llcgloria.testtask.view.map.MapsFragment;


public class MainFragment extends MvpAppCompatFragment implements Watchable {

	private static final int SPAN_COUNT = 2;
	private MainAdapter adapter;
	private Backable backable;

	@InjectPresenter MainPresenter presenter;

	@ProvidePresenter
	MainPresenter providePresenter(){
		return new MainPresenter();
	}

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		RecyclerView recyclerView = (RecyclerView) inflater.inflate(R.layout.fragment_main, container, false);
		recyclerView.setLayoutManager(new GridLayoutManager(getContext(), SPAN_COUNT));
		adapter = new MainAdapter(presenter.getRecyclePresenter());
		recyclerView.setAdapter(adapter);
		new LinearSnapHelper().attachToRecyclerView(recyclerView);
		recyclerView.setHasFixedSize(true);
		presenter.getListCities();
		return recyclerView;
	}

	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		backable = (Backable) context;
	}

	@Override
	public void seeListCity() {
		backable.toBack();
		adapter.notifyDataSetChanged();
	}

	@Override
	public void seePlaceOnMap(City city) {
		if (getActivity() != null){
			getActivity().getSupportFragmentManager()
				.beginTransaction()
				.replace(R.id.frame_master, MapsFragment.newInstance(city), Rule.TAG_MAP)
				.add(R.id.frame_master, new ProgressFragment(), Rule.TAG_PROGRESS)
				.commit();
		}
	}
}
