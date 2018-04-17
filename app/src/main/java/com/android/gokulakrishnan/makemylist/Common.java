package com.android.gokulakrishnan.makemylist;

import com.android.gokulakrishnan.makemylist.Remote.IGoogleAPIService;
import com.android.gokulakrishnan.makemylist.Remote.Retrofitclient;

public class Common {
    private static final String GOOGLE_API_URL="https://maps.googleapis.com/";

    public static IGoogleAPIService getGoogleAPIService()
    {
        return Retrofitclient.getClient(GOOGLE_API_URL).create(IGoogleAPIService.class);
    }
}
