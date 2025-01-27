package com.tencent.bugly.beta.global;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes4.dex */
public class ResBean implements Parcelable, Parcelable.Creator<ResBean> {

    /* renamed from: a */
    public static ResBean f24609a;

    /* renamed from: c */
    private Map<String, String> f24611c = new ConcurrentHashMap();

    /* renamed from: d */
    public final String f24612d = "#273238";

    /* renamed from: e */
    public final String f24613e = "#757575";

    /* renamed from: b */
    public static final String[] f24610b = {"IMG_title", "VAL_style", "tacticsSource", "h5"};
    public static final Parcelable.Creator<ResBean> CREATOR = new ResBean();

    public ResBean() {
    }

    public String a(String str) {
        return this.f24611c.get(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable.Creator
    public ResBean[] newArray(int i2) {
        return new ResBean[0];
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        for (String str : f24610b) {
            parcel.writeString(this.f24611c.get(str));
        }
    }

    public void a(String str, Object obj) {
        if (obj instanceof String) {
            this.f24611c.put(str, (String) obj);
        }
    }

    @Override // android.os.Parcelable.Creator
    public ResBean createFromParcel(Parcel parcel) {
        return new ResBean(parcel);
    }

    public ResBean(Parcel parcel) {
        try {
            for (String str : f24610b) {
                this.f24611c.put(str, parcel.readString());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
