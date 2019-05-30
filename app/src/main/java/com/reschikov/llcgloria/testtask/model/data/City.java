package com.reschikov.llcgloria.testtask.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City implements Comparable<City>, Parcelable {

	@SerializedName("city_id")
	@Expose
	private final Integer cityId;
	@SerializedName("city_name")
	@Expose
	private final String cityName;
	@SerializedName("city_latitude")
	@Expose
	private final Double cityLatitude;
	@SerializedName("city_longitude")
	@Expose
	private final Double cityLongitude;
	@SerializedName("city_spn_latitude")
	@Expose
	private final Double citySpnLatitude;
	@SerializedName("city_spn_longitude")
	@Expose
	private final Double citySpnLongitude;
	@SerializedName("last_app_android_version")
	@Expose
	private final Integer lastAppAndroidVersion;
	@SerializedName("transfers")
	@Expose
	private final Boolean transfers;
	@SerializedName("client_email_required")
	@Expose
	private final Boolean clientEmailRequired;
	@SerializedName("registration_promocode")
	@Expose
	private final Boolean registrationPromocode;
	@SerializedName("parent_city")
	@Expose
	private final Integer parentCity;

	private City(Parcel in) {
		if (in.readByte() == 0) {
			cityId = null;
		} else {
			cityId = in.readInt();
		}
		cityName = in.readString();
		if (in.readByte() == 0) {
			cityLatitude = null;
		} else {
			cityLatitude = in.readDouble();
		}
		if (in.readByte() == 0) {
			cityLongitude = null;
		} else {
			cityLongitude = in.readDouble();
		}
		if (in.readByte() == 0) {
			citySpnLatitude = null;
		} else {
			citySpnLatitude = in.readDouble();
		}
		if (in.readByte() == 0) {
			citySpnLongitude = null;
		} else {
			citySpnLongitude = in.readDouble();
		}
		if (in.readByte() == 0) {
			lastAppAndroidVersion = null;
		} else {
			lastAppAndroidVersion = in.readInt();
		}
		byte tmpTransfers = in.readByte();
		transfers = tmpTransfers == 0 ? null : tmpTransfers == 1;
		byte tmpClientEmailRequired = in.readByte();
		clientEmailRequired = tmpClientEmailRequired == 0 ? null : tmpClientEmailRequired == 1;
		byte tmpRegistrationPromocode = in.readByte();
		registrationPromocode = tmpRegistrationPromocode == 0 ? null : tmpRegistrationPromocode == 1;
		if (in.readByte() == 0) {
			parentCity = null;
		} else {
			parentCity = in.readInt();
		}
	}

	public static final Creator<City> CREATOR = new Creator<City>() {
		@Override
		public City createFromParcel(Parcel in) {
			return new City(in);
		}

		@Override
		public City[] newArray(int size) {
			return new City[size];
		}
	};

	public Integer getCityId() {
		return cityId;
	}

	public String getCityName() {
		return cityName;
	}

	public Double getCityLatitude() {
		return cityLatitude;
	}

	public Double getCityLongitude() {
		return cityLongitude;
	}

	public Double getCitySpnLatitude() {
		return citySpnLatitude;
	}

	public Double getCitySpnLongitude() {
		return citySpnLongitude;
	}

	public Integer getLastAppAndroidVersion() {
		return lastAppAndroidVersion;
	}

	public Boolean getTransfers() {
		return transfers;
	}

	public Boolean getClientEmailRequired() {
		return clientEmailRequired;
	}

	public Boolean getRegistrationPromocode() {
		return registrationPromocode;
	}

	public Integer getParentCity() {
		return parentCity;
	}

	@Override
	public int compareTo(City city) {
		if (cityId < city.cityId) return -1;
		if (cityId > city.cityId) return 1;
		return 0;
	}

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		if (cityId == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(cityId);
		}
		dest.writeString(cityName);
		if (cityLatitude == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(cityLatitude);
		}
		if (cityLongitude == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(cityLongitude);
		}
		if (citySpnLatitude == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(citySpnLatitude);
		}
		if (citySpnLongitude == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeDouble(citySpnLongitude);
		}
		if (lastAppAndroidVersion == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(lastAppAndroidVersion);
		}
		dest.writeByte((byte) (transfers == null ? 0 : transfers ? 1 : 2));
		dest.writeByte((byte) (clientEmailRequired == null ? 0 : clientEmailRequired ? 1 : 2));
		dest.writeByte((byte) (registrationPromocode == null ? 0 : registrationPromocode ? 1 : 2));
		if (parentCity == null) {
			dest.writeByte((byte) 0);
		} else {
			dest.writeByte((byte) 1);
			dest.writeInt(parentCity);
		}
	}
}
