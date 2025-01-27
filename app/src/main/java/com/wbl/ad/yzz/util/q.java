package com.wbl.ad.yzz.util;

import android.content.Context;
import android.location.Address;
import android.location.Location;
import android.location.LocationListener;
import android.os.Bundle;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;

/* loaded from: classes5.dex */
public class q {

    /* renamed from: b */
    public static String f34367b = "q";

    /* renamed from: c */
    public static q f34368c;

    /* renamed from: d */
    public static LocationListener f34369d = new a();

    /* renamed from: a */
    public Context f34370a;

    public static class a implements LocationListener {
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8374, this, location);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8373, this, str);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8376, this, str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8375, this, str, Integer.valueOf(i2), bundle);
        }
    }

    public q(Context context) {
        this.f34370a = context;
    }

    public static q a(Context context) {
        return (q) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8370, null, context);
    }

    public static /* synthetic */ String a() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8369, null, null);
    }

    public Address a(double d2, double d3) {
        return (Address) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8372, this, Double.valueOf(d2), Double.valueOf(d3));
    }

    public Location b() {
        return (Location) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8371, this, null);
    }

    public final Location c() {
        return (Location) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8334, this, null);
    }
}
