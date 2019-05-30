package com.reschikov.llcgloria.testtask.model.net;

import com.reschikov.llcgloria.testtask.model.data.Reply;

import io.reactivex.Single;
import retrofit2.http.GET;

interface Derivable {
	@GET("/taxik/api/test")
	Single<Reply> getListCity();
}
