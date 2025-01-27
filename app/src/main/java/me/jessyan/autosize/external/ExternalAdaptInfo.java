package me.jessyan.autosize.external;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class ExternalAdaptInfo implements Parcelable {
    public static final Parcelable.Creator<ExternalAdaptInfo> CREATOR = new Parcelable.Creator<ExternalAdaptInfo>() { // from class: me.jessyan.autosize.external.ExternalAdaptInfo.1
        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo createFromParcel(Parcel parcel) {
            return new ExternalAdaptInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo[] newArray(int i10) {
            return new ExternalAdaptInfo[i10];
        }
    };
    private boolean isBaseOnWidth;
    private float sizeInDp;

    /* renamed from: me.jessyan.autosize.external.ExternalAdaptInfo$1 */
    public static class AnonymousClass1 implements Parcelable.Creator<ExternalAdaptInfo> {
        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo createFromParcel(Parcel parcel) {
            return new ExternalAdaptInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ExternalAdaptInfo[] newArray(int i10) {
            return new ExternalAdaptInfo[i10];
        }
    }

    public ExternalAdaptInfo(boolean z10) {
        this.isBaseOnWidth = z10;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public float getSizeInDp() {
        return this.sizeInDp;
    }

    public boolean isBaseOnWidth() {
        return this.isBaseOnWidth;
    }

    public void setBaseOnWidth(boolean z10) {
        this.isBaseOnWidth = z10;
    }

    public void setSizeInDp(float f10) {
        this.sizeInDp = f10;
    }

    public String toString() {
        return "ExternalAdaptInfo{isBaseOnWidth=" + this.isBaseOnWidth + ", sizeInDp=" + this.sizeInDp + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeByte(this.isBaseOnWidth ? (byte) 1 : (byte) 0);
        parcel.writeFloat(this.sizeInDp);
    }

    public ExternalAdaptInfo(boolean z10, float f10) {
        this.isBaseOnWidth = z10;
        this.sizeInDp = f10;
    }

    public ExternalAdaptInfo(Parcel parcel) {
        this.isBaseOnWidth = parcel.readByte() != 0;
        this.sizeInDp = parcel.readFloat();
    }
}
