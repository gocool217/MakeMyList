package com.android.gokulakrishnan.makemylist.Remote;

import com.android.gokulakrishnan.makemylist.Model.Myplaces;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface IGoogleAPIService {
    @GET
    Call<Myplaces>getNearByPlaces(@Url String url);
}
