package com.reschikov.llcgloria.testtask.view.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.SingleStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.reschikov.llcgloria.testtask.model.data.City;

public interface Watchable extends MvpView {
	@StateStrategyType(SingleStateStrategy.class)
	void seeListCity();
	@StateStrategyType(SingleStateStrategy.class)
	void seePlaceOnMap(City city);
}
