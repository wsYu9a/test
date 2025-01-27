package com.vivo.mobilead.util;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: b */
    private static b f30537b;

    /* renamed from: a */
    private Location f30538a;

    public static b b() {
        if (f30537b == null) {
            f30537b = new b();
        }
        return f30537b;
    }

    private double c() {
        Location location = this.f30538a;
        if (location != null) {
            return location.getLatitude();
        }
        return 0.0d;
    }

    private double d() {
        Location location = this.f30538a;
        if (location != null) {
            return location.getLongitude();
        }
        return 0.0d;
    }

    public void a(Context context) {
        x0.a("ADSDKLocationHelper", "Obtain the LBS data");
        try {
            if (!(context.getPackageManager().checkPermission(com.kuaishou.weapon.p0.g.f9322g, context.getPackageName()) == 0)) {
                x0.a("ADSDKLocationHelper", "no permission");
                return;
            }
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null || !locationManager.isProviderEnabled("gps")) {
                b(context);
                return;
            }
            x0.a("ADSDKLocationHelper", "GPS Provider Enable");
            Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
            this.f30538a = lastKnownLocation;
            if (lastKnownLocation != null) {
                return;
            }
            b(context);
        } catch (Exception e2) {
            VOpenLog.w("ADSDKLocationHelper", "" + e2.getMessage());
        }
    }

    private void b(Context context) {
        try {
            this.f30538a = ((LocationManager) context.getSystemService("location")).getLastKnownLocation("network");
        } catch (SecurityException e2) {
            x0.a("ADSDKLocationHelper", "getLocationByNetWork error", e2);
        } catch (Exception e3) {
            x0.a("ADSDKLocationHelper", "getLocationByNetWork error", e3);
        }
    }

    public String a() {
        if (this.f30538a == null) {
            return null;
        }
        return d() + "*" + c();
    }
}
