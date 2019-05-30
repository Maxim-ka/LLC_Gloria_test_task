package com.reschikov.llcgloria.testtask.model.net;

import com.reschikov.llcgloria.testtask.model.data.Reply;
import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class Request {

	private final Derivable derivable;

	public Request() {
		derivable = new Retrofit.Builder()
			.baseUrl("https://beta.taxistock.ru")
			.addCallAdapterFactory(RxJava2CallAdapterFactory.create())
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create(Derivable.class);
	}

	public Single<Reply> toRequest(){
		return (derivable.getListCity().subscribeOn(Schedulers.io()));
	}
}
