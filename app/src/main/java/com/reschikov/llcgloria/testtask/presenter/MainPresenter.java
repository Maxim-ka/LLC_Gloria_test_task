package com.reschikov.llcgloria.testtask.presenter;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.reschikov.llcgloria.testtask.model.data.City;
import com.reschikov.llcgloria.testtask.model.net.Request;
import com.reschikov.llcgloria.testtask.view.main.Bindable;
import com.reschikov.llcgloria.testtask.view.main.Watchable;

import java.util.Collections;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

@InjectViewState
public class MainPresenter  extends MvpPresenter<Watchable> {

	private List<City> list;
	private final RecyclePresenter recyclePresenter = new RecyclePresenter();

	public RecyclePresenter getRecyclePresenter() {
		return recyclePresenter;
	}

	public void getListCities() {
		Disposable disposable = new Request().toRequest()
			.observeOn(AndroidSchedulers.mainThread())
			.subscribe(reply -> {
					list = reply.getCities();
					Collections.sort(list);
					getViewState().seeListCity();
				}, e -> Log.e("getListCities: ", e.getMessage()));
	}

	private class RecyclePresenter implements Cohesive{

		@Override
		public void bindView(Bindable bindable, int position) {
			bindable.bind(list.get(position));
		}

		@Override
		public int getItemCount() {
			if (list == null) return 0;
			return list.size();
		}

		@Override
		public void getCity(int position) {
			getViewState().seePlaceOnMap(list.get(position));
		}
	}
}
