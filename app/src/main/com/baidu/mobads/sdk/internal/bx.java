package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bx implements Parcelable {

    /* renamed from: a */
    public static final String f6974a = "MD5";

    /* renamed from: b */
    public static final Parcelable.Creator<bx> f6975b = new by();

    /* renamed from: c */
    private JSONObject f6976c;

    /* renamed from: d */
    private double f6977d;

    /* renamed from: e */
    private String f6978e;

    /* renamed from: f */
    private String f6979f;

    /* renamed from: g */
    private String f6980g;

    /* renamed from: h */
    private int f6981h;

    /* renamed from: i */
    private int f6982i;

    public /* synthetic */ bx(Parcel parcel, by byVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f6982i == 1);
    }

    public double b() {
        return this.f6977d;
    }

    public String c() {
        return cq.a().c(this.f6978e);
    }

    public String d() {
        return this.f6979f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f6980g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f6981h == 1);
    }

    public String toString() {
        return this.f6976c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f6979f);
        parcel.writeInt(this.f6982i);
        parcel.writeString(this.f6978e);
        parcel.writeDouble(this.f6977d);
        parcel.writeString(this.f6980g);
        parcel.writeInt(this.f6981h);
    }

    public bx(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f6976c = jSONObject;
            this.f6977d = jSONObject.getDouble("version");
            this.f6978e = this.f6976c.getString("url");
            this.f6979f = this.f6976c.getString("sign");
            this.f6982i = 1;
            this.f6980g = "";
            this.f6981h = 0;
        } catch (JSONException unused) {
            this.f6982i = 0;
        }
        this.f6982i = c() == null ? 0 : 1;
    }

    public bx(bx bxVar, String str, Boolean bool) {
        this.f6977d = bxVar.b();
        this.f6978e = bxVar.c();
        this.f6979f = bxVar.d();
        this.f6982i = bxVar.a().booleanValue() ? 1 : 0;
        this.f6980g = str;
        this.f6981h = bool.booleanValue() ? 1 : 0;
    }

    private bx(Parcel parcel) {
        this.f6979f = parcel.readString();
        this.f6982i = parcel.readInt();
        this.f6978e = parcel.readString();
        this.f6977d = parcel.readDouble();
        this.f6980g = parcel.readString();
        this.f6981h = parcel.readInt();
    }
}
