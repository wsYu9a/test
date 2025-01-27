package com.bytedance.sdk.openadsdk;

/* loaded from: classes.dex */
public class TTLocation implements LocationProvider {

    /* renamed from: j */
    private double f6368j;
    private double zx;

    public TTLocation(double d2, double d3) {
        this.f6368j = 0.0d;
        this.zx = 0.0d;
        this.f6368j = d2;
        this.zx = d3;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLatitude() {
        return this.f6368j;
    }

    @Override // com.bytedance.sdk.openadsdk.LocationProvider
    public double getLongitude() {
        return this.zx;
    }

    public void setLatitude(double d2) {
        this.f6368j = d2;
    }

    public void setLongitude(double d2) {
        this.zx = d2;
    }
}
