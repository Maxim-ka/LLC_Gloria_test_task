package com.reschikov.llcgloria.testtask.model.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Reply {

	@SerializedName("cities")
	@Expose
	private List<City> cities;

	public List<City> getCities() {
		return cities;
	}
}
