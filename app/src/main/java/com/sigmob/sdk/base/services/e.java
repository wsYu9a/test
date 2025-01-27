package com.sigmob.sdk.base.services;

import android.annotation.SuppressLint;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.services.j;

/* loaded from: classes4.dex */
public class e implements j.a {

    /* renamed from: c */
    public static LocationManager f18356c;

    /* renamed from: a */
    public k f18358a = k.STOP;

    /* renamed from: b */
    public static final LocationListener f18355b = new a();

    /* renamed from: d */
    public static String f18357d = PointCategory.NETWORK;

    public class a implements LocationListener {
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (ClientMetadata.getInstance() == null) {
                return;
            }
            ClientMetadata.getInstance().setLocation(location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i10, Bundle bundle) {
        }
    }

    public e() {
        LocationManager e10;
        if (ClientMetadata.getInstance() == null || (e10 = e()) == null) {
            return;
        }
        Criteria criteria = new Criteria();
        criteria.setAccuracy(2);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setCostAllowed(false);
        criteria.setPowerRequirement(1);
        f18357d = e10.getBestProvider(criteria, false);
    }

    public static LocationManager e() {
        if (f18356c == null) {
            synchronized (e.class) {
                try {
                    if (f18356c == null) {
                        f18356c = ClientMetadata.getInstance().getLocationManager();
                    }
                } finally {
                }
            }
        }
        return f18356c;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public boolean a() {
        if (this.f18358a == k.RUNNING) {
            return false;
        }
        f();
        return true;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public void b() {
        if (this.f18358a == k.RUNNING) {
            g();
            this.f18358a = k.STOP;
        }
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public k c() {
        return this.f18358a;
    }

    @Override // com.sigmob.sdk.base.services.j.a
    public Error d() {
        return null;
    }

    @SuppressLint({"MissingPermission"})
    public final void f() {
        String str;
        try {
            LocationManager e10 = e();
            if (e10 == null || (str = f18357d) == null || !e10.isProviderEnabled(str)) {
                return;
            }
            SigmobLog.d("private :use_location ");
            e10.requestLocationUpdates(f18357d, 10000L, 10.0f, f18355b);
            this.f18358a = k.RUNNING;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }

    @SuppressLint({"MissingPermission"})
    public final void g() {
        try {
            LocationManager locationManager = f18356c;
            if (locationManager != null) {
                locationManager.removeUpdates(f18355b);
            }
            f18356c = null;
        } catch (Throwable th2) {
            SigmobLog.e(th2.getMessage());
        }
    }
}
