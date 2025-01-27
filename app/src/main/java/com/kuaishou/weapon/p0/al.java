package com.kuaishou.weapon.p0;

import android.content.Context;
import android.location.LocationManager;
import android.location.LocationProvider;
import android.os.Build;
import android.provider.Settings;

/* loaded from: classes.dex */
public class al {
    public static boolean a(Context context) {
        try {
            if (Build.VERSION.SDK_INT > 22) {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                LocationProvider provider = locationManager.getProvider("gps");
                if (provider != null) {
                    locationManager.addTestProvider(provider.getName(), provider.requiresNetwork(), provider.requiresSatellite(), provider.requiresCell(), provider.hasMonetaryCost(), provider.supportsAltitude(), provider.supportsSpeed(), provider.supportsBearing(), provider.getPowerRequirement(), provider.getAccuracy());
                } else {
                    locationManager.addTestProvider("gps", true, true, false, false, true, true, true, 3, 1);
                }
                locationManager.setTestProviderEnabled("gps", true);
                locationManager.setTestProviderStatus("gps", 2, null, System.currentTimeMillis());
            } else if (Settings.Secure.getInt(context.getContentResolver(), "mock_location", 0) == 0) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
