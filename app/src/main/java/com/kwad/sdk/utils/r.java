package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;

/* loaded from: classes2.dex */
public final class r {
    private static boolean azJ;
    private static Location azK;

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                azJ = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9323h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("network");
            if (lastKnownLocation == null) {
                azJ = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }

    @Nullable
    public static Location bL(Context context) {
        if (at.DU() && at.DV() != null) {
            return at.DV();
        }
        if (azJ || azK != null || context == null) {
            return azK;
        }
        if (!at.DU() && !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    azK = a(context, locationManager);
                }
                if (azK == null && locationManager.isProviderEnabled("network")) {
                    azK = b(context, locationManager);
                }
                if (azK == null && locationManager.isProviderEnabled("passive")) {
                    azK = c(context, locationManager);
                }
                return azK;
            } catch (Exception e2) {
                azJ = true;
                com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            }
        }
        return null;
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9323h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                azJ = true;
            }
            return lastKnownLocation;
        } catch (Exception e2) {
            azJ = true;
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            return null;
        }
    }
}
