package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.List;

/* loaded from: classes4.dex */
public class ActivatingData extends a implements Parcelable {
    public static final Parcelable.Creator<ActivatingData> CREATOR = new Parcelable.Creator<ActivatingData>() { // from class: com.opos.mobad.model.data.ActivatingData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new ActivatingData(parcel.readString(), parcel.readString(), parcel.readArrayList(ApkSignerData.class.getClassLoader()), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData[] newArray(int i2) {
            return new ActivatingData[i2];
        }
    };

    /* renamed from: a */
    public final String f21671a;

    /* renamed from: b */
    public final String f21672b;

    /* renamed from: c */
    public final List<ApkSignerData> f21673c;

    /* renamed from: d */
    public final int f21674d;

    /* renamed from: com.opos.mobad.model.data.ActivatingData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<ActivatingData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new ActivatingData(parcel.readString(), parcel.readString(), parcel.readArrayList(ApkSignerData.class.getClassLoader()), parcel.readInt());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ActivatingData[] newArray(int i2) {
            return new ActivatingData[i2];
        }
    }

    public ActivatingData(String str, String str2, List<ApkSignerData> list, int i2) {
        this.f21671a = str;
        this.f21672b = str2;
        this.f21673c = list;
        this.f21674d = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ActivatingData{pkgName=" + this.f21671a + ", target='" + this.f21672b + "', apkSignerDataList=" + this.f21673c + ", minVerCode=" + this.f21674d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21671a);
        parcel.writeString(this.f21672b);
        parcel.writeList(this.f21673c);
        parcel.writeInt(this.f21674d);
    }
}
