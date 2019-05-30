package com.reschikov.llcgloria.testtask.view.map;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.reschikov.llcgloria.testtask.R;
import com.reschikov.llcgloria.testtask.Rule;
import com.reschikov.llcgloria.testtask.model.data.City;
import com.reschikov.llcgloria.testtask.view.Backable;

import java.util.Locale;

public class MapsFragment extends Fragment implements OnMapReadyCallback{

	private static final float ZOOM = 8.0f;
	private static final float TILT = 0.0f;
	private static final float BEARING = 0.0f;

	public static MapsFragment newInstance(City city){
		MapsFragment fragment = new MapsFragment();
		Bundle bundle = new Bundle();
		bundle.putParcelable(Rule.KEY_CITY, city);
		fragment.setArguments(bundle);
		return fragment;
	}

	private City city;
	private Backable backable;

	@Nullable
	@Override
	public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_maps, container, false);
		if (getArguments() != null){
			city = getArguments().getParcelable(Rule.KEY_CITY);
		}
		if (getActivity() != null){
			SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
				.findFragmentById(R.id.map);
			if (mapFragment != null) mapFragment.getMapAsync(this);
		}
		return view;
	}

	@Override
	public void onAttach(@NonNull Context context) {
		super.onAttach(context);
		backable = (Backable) context;
	}

	@Override
	public void onMapReady(GoogleMap googleMap) {
		if (googleMap != null){
			backable.toBack();
			if (city != null){
				LatLng place = new LatLng(city.getCityLatitude(), city.getCityLongitude());
				String title = String.format(Locale.getDefault(),"lat: %f, lon: %f", city.getCityLatitude(), city.getCityLongitude());
				MarkerOptions markerOptions = new MarkerOptions().position(place)
					.title(city.getCityName())
					.snippet(title);
				Marker marker = googleMap.addMarker(markerOptions);
				googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition(place, ZOOM, TILT, BEARING)));
				marker.showInfoWindow();
			}
		}
	}
}
