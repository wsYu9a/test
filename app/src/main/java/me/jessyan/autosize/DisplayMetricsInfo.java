package me.jessyan.autosize;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class DisplayMetricsInfo implements Parcelable {
    public static final Parcelable.Creator<DisplayMetricsInfo> CREATOR = new Parcelable.Creator<DisplayMetricsInfo>() { // from class: me.jessyan.autosize.DisplayMetricsInfo.1
        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo createFromParcel(Parcel parcel) {
            return new DisplayMetricsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo[] newArray(int i10) {
            return new DisplayMetricsInfo[i10];
        }
    };
    private float density;
    private int densityDpi;
    private float scaledDensity;
    private int screenHeightDp;
    private int screenWidthDp;
    private float xdpi;

    /* renamed from: me.jessyan.autosize.DisplayMetricsInfo$1 */
    public static class AnonymousClass1 implements Parcelable.Creator<DisplayMetricsInfo> {
        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo createFromParcel(Parcel parcel) {
            return new DisplayMetricsInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public DisplayMetricsInfo[] newArray(int i10) {
            return new DisplayMetricsInfo[i10];
        }
    }

    public DisplayMetricsInfo(float f10, int i10, float f11, float f12) {
        this.density = f10;
        this.densityDpi = i10;
        this.scaledDensity = f11;
        this.xdpi = f12;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getDensity() {
        return this.density;
    }

    public int getDensityDpi() {
        return this.densityDpi;
    }

    public float getScaledDensity() {
        return this.scaledDensity;
    }

    public int getScreenHeightDp() {
        return this.screenHeightDp;
    }

    public int getScreenWidthDp() {
        return this.screenWidthDp;
    }

    public float getXdpi() {
        return this.xdpi;
    }

    public void setDensity(float f10) {
        this.density = f10;
    }

    public void setDensityDpi(int i10) {
        this.densityDpi = i10;
    }

    public void setScaledDensity(float f10) {
        this.scaledDensity = f10;
    }

    public void setScreenHeightDp(int i10) {
        this.screenHeightDp = i10;
    }

    public void setScreenWidthDp(int i10) {
        this.screenWidthDp = i10;
    }

    public void setXdpi(float f10) {
        this.xdpi = f10;
    }

    public String toString() {
        return "DisplayMetricsInfo{density=" + this.density + ", densityDpi=" + this.densityDpi + ", scaledDensity=" + this.scaledDensity + ", xdpi=" + this.xdpi + ", screenWidthDp=" + this.screenWidthDp + ", screenHeightDp=" + this.screenHeightDp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeFloat(this.density);
        parcel.writeInt(this.densityDpi);
        parcel.writeFloat(this.scaledDensity);
        parcel.writeFloat(this.xdpi);
        parcel.writeInt(this.screenWidthDp);
        parcel.writeInt(this.screenHeightDp);
    }

    public DisplayMetricsInfo(float f10, int i10, float f11, float f12, int i11, int i12) {
        this.density = f10;
        this.densityDpi = i10;
        this.scaledDensity = f11;
        this.xdpi = f12;
        this.screenWidthDp = i11;
        this.screenHeightDp = i12;
    }

    public DisplayMetricsInfo(Parcel parcel) {
        this.density = parcel.readFloat();
        this.densityDpi = parcel.readInt();
        this.scaledDensity = parcel.readFloat();
        this.xdpi = parcel.readFloat();
        this.screenWidthDp = parcel.readInt();
        this.screenHeightDp = parcel.readInt();
    }
}
