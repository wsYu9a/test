package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bu implements Parcelable {

    /* renamed from: a */
    public static final String f5659a = "MD5";

    /* renamed from: b */
    public static final Parcelable.Creator<bu> f5660b = new bv();

    /* renamed from: c */
    private JSONObject f5661c;

    /* renamed from: d */
    private double f5662d;

    /* renamed from: e */
    private String f5663e;

    /* renamed from: f */
    private String f5664f;

    /* renamed from: g */
    private String f5665g;

    /* renamed from: h */
    private int f5666h;

    /* renamed from: i */
    private int f5667i;

    /* synthetic */ bu(Parcel parcel, bv bvVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f5667i == 1);
    }

    public double b() {
        return this.f5662d;
    }

    public String c() {
        return cn.a().c(this.f5663e);
    }

    public String d() {
        return this.f5664f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f5665g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f5666h == 1);
    }

    public String toString() {
        return this.f5661c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f5664f);
        parcel.writeInt(this.f5667i);
        parcel.writeString(this.f5663e);
        parcel.writeDouble(this.f5662d);
        parcel.writeString(this.f5665g);
        parcel.writeInt(this.f5666h);
    }

    public bu(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f5661c = jSONObject;
            this.f5662d = jSONObject.getDouble("version");
            this.f5663e = this.f5661c.getString("url");
            this.f5664f = this.f5661c.getString("sign");
            this.f5667i = 1;
            this.f5665g = "";
            this.f5666h = 0;
        } catch (JSONException unused) {
            this.f5667i = 0;
        }
        this.f5667i = c() == null ? 0 : 1;
    }

    public bu(bu buVar, String str, Boolean bool) {
        this.f5662d = buVar.b();
        this.f5663e = buVar.c();
        this.f5664f = buVar.d();
        this.f5667i = buVar.a().booleanValue() ? 1 : 0;
        this.f5665g = str;
        this.f5666h = bool.booleanValue() ? 1 : 0;
    }

    private bu(Parcel parcel) {
        this.f5664f = parcel.readString();
        this.f5667i = parcel.readInt();
        this.f5663e = parcel.readString();
        this.f5662d = parcel.readDouble();
        this.f5665g = parcel.readString();
        this.f5666h = parcel.readInt();
    }
}
