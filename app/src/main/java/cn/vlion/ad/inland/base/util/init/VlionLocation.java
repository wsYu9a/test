package cn.vlion.ad.inland.base.util.init;

/* loaded from: classes.dex */
public class VlionLocation {
    private double lat;
    private double lon;
    private double radius;

    public VlionLocation() {
        this.lat = -1.0d;
        this.lon = -1.0d;
        this.radius = -1.0d;
    }

    public double getLatitude() {
        return this.lat;
    }

    public double getLongitude() {
        return this.lon;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setLatitude(double d10) {
        this.lat = d10;
    }

    public void setLongitude(double d10) {
        this.lon = d10;
    }

    public void setRadius(double d10) {
        this.radius = d10;
    }

    public VlionLocation(double d10, double d11, double d12) {
        this.lat = d10;
        this.lon = d11;
        this.radius = d12;
    }
}
