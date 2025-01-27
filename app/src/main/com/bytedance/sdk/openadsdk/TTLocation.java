package com.bytedance.sdk.openadsdk;

/* loaded from: classes2.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: a */
    private double f7962a;

    /* renamed from: b */
    private double f7963b;

    public TTLocation(double d10, double d11) {
        this.f7962a = d10;
        this.f7963b = d11;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f7962a;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.f7963b;
    }

    public void setLatitude(double d10) {
        this.f7962a = d10;
    }

    public void setLongitude(double d10) {
        this.f7963b = d10;
    }
}
