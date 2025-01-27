package b.b.a.f;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private static double f4276a = -1.0d;

    /* renamed from: b, reason: collision with root package name */
    private static double f4277b = -1.0d;

    public static String a() {
        return f4277b + ";" + f4276a;
    }

    private static void b(Context context) {
        Location lastKnownLocation;
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (!locationManager.isProviderEnabled("gps") || (lastKnownLocation = locationManager.getLastKnownLocation("gps")) == null) {
                return;
            }
            f4276a = lastKnownLocation.getLatitude();
            f4277b = lastKnownLocation.getLongitude();
        } catch (Exception unused) {
        }
    }

    private static double c() {
        return f4276a;
    }

    private static double d() {
        return f4277b;
    }
}
