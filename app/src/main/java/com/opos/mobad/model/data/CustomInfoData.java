package com.opos.mobad.model.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class CustomInfoData implements Parcelable {
    public static final Parcelable.Creator<CustomInfoData> CREATOR = new Parcelable.Creator<CustomInfoData>() { // from class: com.opos.mobad.model.data.CustomInfoData.1
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new CustomInfoData(parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData[] newArray(int i2) {
            return new CustomInfoData[i2];
        }
    };

    /* renamed from: a */
    private String f21709a;

    /* renamed from: b */
    private JSONObject f21710b;

    /* renamed from: com.opos.mobad.model.data.CustomInfoData$1 */
    static final class AnonymousClass1 implements Parcelable.Creator<CustomInfoData> {
        AnonymousClass1() {
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData createFromParcel(Parcel parcel) {
            if (parcel != null) {
                return new CustomInfoData(parcel.readString());
            }
            return null;
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public CustomInfoData[] newArray(int i2) {
            return new CustomInfoData[i2];
        }
    }

    public CustomInfoData(String str) {
        str = str == null ? "" : str;
        this.f21709a = str;
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f21710b = new JSONObject(this.f21709a);
        } catch (JSONException e2) {
            com.opos.cmn.an.f.a.a("", e2);
        }
    }

    public boolean a() {
        JSONObject jSONObject = this.f21710b;
        return 1 == (jSONObject != null ? jSONObject.optInt("c_vrs", 0) : 0);
    }

    public int b() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_il", 0);
        }
        return 0;
    }

    public int c() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_vp", 2);
        }
        return 2;
    }

    public int d() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_lo", 0);
        }
        return 0;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public int e() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_iom", 0);
        }
        return 0;
    }

    public int f() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_ct", 3000);
        }
        return 3000;
    }

    public int g() {
        JSONObject jSONObject = this.f21710b;
        if (jSONObject != null) {
            return jSONObject.optInt("c_dpt", 2000);
        }
        return 2000;
    }

    public String toString() {
        return "CustomInfoData{mInfoString='" + this.f21709a + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f21709a);
    }
}
