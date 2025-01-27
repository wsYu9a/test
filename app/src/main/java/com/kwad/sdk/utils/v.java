package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.sigmob.sdk.base.mta.PointCategory;

/* loaded from: classes3.dex */
public final class v {
    private static boolean aTo;
    private static com.kwad.sdk.utils.c.a aTp = new com.kwad.sdk.utils.c.a();

    @SuppressLint({"MissingPermission"})
    private static Location a(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            if (lastKnownLocation == null) {
                aTo = true;
            }
            return lastKnownLocation;
        } catch (Exception e10) {
            aTo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location b(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) != 0 && ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11107h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation(PointCategory.NETWORK);
            if (lastKnownLocation == null) {
                aTo = true;
            }
            return lastKnownLocation;
        } catch (Exception e10) {
            aTo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    @SuppressLint({"MissingPermission"})
    private static Location c(Context context, LocationManager locationManager) {
        try {
            if (ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11107h) != 0) {
                return null;
            }
            Location lastKnownLocation = locationManager.getLastKnownLocation("passive");
            if (lastKnownLocation == null) {
                aTo = true;
            }
            return lastKnownLocation;
        } catch (Exception e10) {
            aTo = true;
            com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            return null;
        }
    }

    @Nullable
    public static com.kwad.sdk.utils.c.a cm(Context context) {
        com.kwad.sdk.utils.c.a aVar;
        com.kwad.sdk.utils.c.a aVar2 = new com.kwad.sdk.utils.c.a();
        if (az.Ob() && az.Oc() != null) {
            aVar2.aWW = az.Oc();
            aVar2.type = 1;
            return aVar2;
        }
        if (aTo || (!((aVar = aTp) == null || aVar.aWW == null) || context == null)) {
            return aTp;
        }
        if (!az.Ob() && !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(64L)) {
            try {
                LocationManager locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager.isProviderEnabled("gps")) {
                    aTp.aWW = a(context, locationManager);
                }
                if (aTp == null && locationManager.isProviderEnabled(PointCategory.NETWORK)) {
                    aTp.aWW = b(context, locationManager);
                }
                if (aTp == null && locationManager.isProviderEnabled("passive")) {
                    aTp.aWW = c(context, locationManager);
                }
                com.kwad.sdk.utils.c.a aVar3 = aTp;
                aVar3.type = 0;
                return aVar3;
            } catch (Exception e10) {
                aTo = true;
                com.kwad.sdk.core.d.c.printStackTraceOnly(e10);
            }
        }
        return null;
    }
}
