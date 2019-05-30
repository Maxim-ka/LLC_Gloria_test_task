package com.reschikov.llcgloria.testtask.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import com.reschikov.llcgloria.testtask.R;
import com.reschikov.llcgloria.testtask.model.data.City;
import com.reschikov.llcgloria.testtask.presenter.Cohesive;

import butterknife.BindView;
import butterknife.ButterKnife;

class MainAdapter extends RecyclerView.Adapter {

	private final Cohesive cohesive;

	MainAdapter(Cohesive cohesive) {
		this.cohesive = cohesive;
	}

	@NonNull
	@Override
	public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
		return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false), cohesive);
	}

	@Override
	public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
		MyViewHolder myViewHolder = (MyViewHolder) holder;
		cohesive.bindView(myViewHolder, position);
	}

	@Override
	public int getItemCount() {
		return cohesive.getItemCount();
	}

	public static class MyViewHolder extends RecyclerView.ViewHolder implements Bindable, View.OnClickListener {
		private final Cohesive cohesive;
		@BindView(R.id.city_id) AppCompatTextView idView;
		@BindView(R.id.city_name) AppCompatTextView nameView;
		@BindView(R.id.city_latitude) AppCompatTextView latitudeView;
		@BindView(R.id.city_longitude) AppCompatTextView longitudeView;
		@BindView(R.id.city_spn_latitude) AppCompatTextView spnLatitudeView;
		@BindView(R.id.city_spn_longitude) AppCompatTextView spnLongitudeView;
		@BindView(R.id.last_app_android_version) AppCompatTextView versionView;
		@BindView(R.id.transfers) AppCompatTextView transfersView;
		@BindView(R.id.client_email_required) AppCompatTextView clientEmailView;
		@BindView(R.id.registration_promocode) AppCompatTextView promocodeView;
		@BindView(R.id.parent_city) AppCompatTextView parentCityView;

		MyViewHolder(@NonNull View itemView, Cohesive cohesive) {
			super(itemView);
			ButterKnife.bind(this, itemView);
			this.cohesive = cohesive;
			itemView.setOnClickListener(this);
		}

		@Override
		public void bind(City city) {
			idView.setText(String.valueOf(city.getCityId()));
			nameView.setText(city.getCityName());
			latitudeView.setText(String.valueOf(city.getCityLatitude()));
			longitudeView.setText(String.valueOf(city.getCityLongitude()));
			spnLatitudeView.setText(String.valueOf(city.getCitySpnLatitude()));
			spnLongitudeView.setText(String.valueOf(city.getCitySpnLongitude()));
			versionView.setText(String.valueOf(city.getLastAppAndroidVersion()));
			transfersView.setText(String.valueOf(city.getTransfers()));
			clientEmailView.setText(String.valueOf(city.getClientEmailRequired()));
			promocodeView.setText(String.valueOf(city.getRegistrationPromocode()));
			parentCityView.setText(String.valueOf(city.getParentCity()));
		}

		@Override
		public void onClick(View v) {
			cohesive.getCity(getAdapterPosition());
		}
	}
}
