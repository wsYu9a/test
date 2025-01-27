package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes4.dex */
public class AppDownloadData extends a implements Parcelable {
    public static final Parcelable.Creator<AppDownloadData> CREATOR = new Parcelable.Creator<AppDownloadData>() { // from class: com.opos.mobad.model.data.AppDownloadData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AppDownloadData appDownloadData = new AppDownloadData();
            appDownloadData.a(parcel.readString());
            appDownloadData.b(parcel.readString());
            appDownloadData.d(parcel.readString());
            appDownloadData.c(parcel.readString());
            return appDownloadData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData[] newArray(int i2) {
            return new AppDownloadData[i2];
        }
    };

    /* renamed from: a */
    private String f21701a;

    /* renamed from: b */
    private String f21702b;

    /* renamed from: c */
    private String f21703c;

    /* renamed from: d */
    private String f21704d;

    /* renamed from: com.opos.mobad.model.data.AppDownloadData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<AppDownloadData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData createFromParcel(Parcel parcel) {
            if (parcel == null) {
                return null;
            }
            AppDownloadData appDownloadData = new AppDownloadData();
            appDownloadData.a(parcel.readString());
            appDownloadData.b(parcel.readString());
            appDownloadData.d(parcel.readString());
            appDownloadData.c(parcel.readString());
            return appDownloadData;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public AppDownloadData[] newArray(int i2) {
            return new AppDownloadData[i2];
        }
    }

    public String a() {
        return this.f21701a;
    }

    public void a(String str) {
        this.f21701a = str;
    }

    public String b() {
        return this.f21702b;
    }

    public void b(String str) {
        this.f21702b = str;
    }

    public String c() {
        return this.f21703c;
    }

    public void c(String str) {
        this.f21703c = str;
    }

    public String d() {
        return this.f21704d;
    }

    public void d(String str) {
        this.f21704d = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "appDownloadData{url=" + this.f21701a + ", md5=" + this.f21702b + ", pkgName=" + this.f21703c + ", appName=" + this.f21704d + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21701a);
        parcel.writeString(this.f21702b);
        parcel.writeString(this.f21703c);
        parcel.writeString(this.f21704d);
    }
}
