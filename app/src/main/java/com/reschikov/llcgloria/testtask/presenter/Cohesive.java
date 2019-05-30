package com.reschikov.llcgloria.testtask.presenter;

import com.reschikov.llcgloria.testtask.view.main.Bindable;

public interface Cohesive {
	void bindView(Bindable bindable, int position);
	int getItemCount();
	void getCity(int position);
}
