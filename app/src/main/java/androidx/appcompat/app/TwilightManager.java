package androidx.appcompat.app;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.annotation.VisibleForTesting;
import androidx.core.content.PermissionChecker;
import com.kuaishou.weapon.p0.g;
import java.util.Calendar;

/* loaded from: classes.dex */
class TwilightManager {

    /* renamed from: a */
    private static final String f315a = "TwilightManager";

    /* renamed from: b */
    private static final int f316b = 6;

    /* renamed from: c */
    private static final int f317c = 22;

    /* renamed from: d */
    private static TwilightManager f318d;

    /* renamed from: e */
    private final Context f319e;

    /* renamed from: f */
    private final LocationManager f320f;

    /* renamed from: g */
    private final TwilightState f321g = new TwilightState();

    private static class TwilightState {

        /* renamed from: a */
        boolean f322a;

        /* renamed from: b */
        long f323b;

        /* renamed from: c */
        long f324c;

        /* renamed from: d */
        long f325d;

        /* renamed from: e */
        long f326e;

        /* renamed from: f */
        long f327f;

        TwilightState() {
        }
    }

    @VisibleForTesting
    TwilightManager(@NonNull Context context, @NonNull LocationManager locationManager) {
        this.f319e = context;
        this.f320f = locationManager;
    }

    static TwilightManager a(@NonNull Context context) {
        if (f318d == null) {
            Context applicationContext = context.getApplicationContext();
            f318d = new TwilightManager(applicationContext, (LocationManager) applicationContext.getSystemService("location"));
        }
        return f318d;
    }

    @SuppressLint({"MissingPermission"})
    private Location b() {
        Location c2 = PermissionChecker.checkSelfPermission(this.f319e, g.f9323h) == 0 ? c("network") : null;
        Location c3 = PermissionChecker.checkSelfPermission(this.f319e, g.f9322g) == 0 ? c("gps") : null;
        return (c3 == null || c2 == null) ? c3 != null ? c3 : c2 : c3.getTime() > c2.getTime() ? c3 : c2;
    }

    @RequiresPermission(anyOf = {g.f9323h, g.f9322g})
    private Location c(String str) {
        try {
            if (this.f320f.isProviderEnabled(str)) {
                return this.f320f.getLastKnownLocation(str);
            }
            return null;
        } catch (Exception e2) {
            Log.d(f315a, "Failed to get last known location", e2);
            return null;
        }
    }

    private boolean e() {
        return this.f321g.f327f > System.currentTimeMillis();
    }

    @VisibleForTesting
    static void f(TwilightManager twilightManager) {
        f318d = twilightManager;
    }

    private void g(@NonNull Location location) {
        long j2;
        TwilightState twilightState = this.f321g;
        long currentTimeMillis = System.currentTimeMillis();
        TwilightCalculator a2 = TwilightCalculator.a();
        a2.calculateTwilight(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j3 = a2.sunset;
        a2.calculateTwilight(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a2.state == 1;
        long j4 = a2.sunrise;
        long j5 = a2.sunset;
        boolean z2 = z;
        a2.calculateTwilight(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j6 = a2.sunrise;
        if (j4 == -1 || j5 == -1) {
            j2 = 43200000 + currentTimeMillis;
        } else {
            j2 = (currentTimeMillis > j5 ? 0 + j6 : currentTimeMillis > j4 ? 0 + j5 : 0 + j4) + 60000;
        }
        twilightState.f322a = z2;
        twilightState.f323b = j3;
        twilightState.f324c = j4;
        twilightState.f325d = j5;
        twilightState.f326e = j6;
        twilightState.f327f = j2;
    }

    boolean d() {
        TwilightState twilightState = this.f321g;
        if (e()) {
            return twilightState.f322a;
        }
        Location b2 = b();
        if (b2 != null) {
            g(b2);
            return twilightState.f322a;
        }
        Log.i(f315a, "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i2 = Calendar.getInstance().get(11);
        return i2 < 6 || i2 >= 22;
    }
}
