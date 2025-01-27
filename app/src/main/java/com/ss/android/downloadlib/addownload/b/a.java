package com.ss.android.downloadlib.addownload.b;

import com.ss.android.downloadlib.g.m;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    public long f21181a;

    /* renamed from: b */
    public long f21182b;

    /* renamed from: c */
    public long f21183c;

    /* renamed from: d */
    public String f21184d;

    /* renamed from: e */
    public String f21185e;

    /* renamed from: f */
    public String f21186f;

    /* renamed from: g */
    public String f21187g;

    /* renamed from: h */
    public volatile long f21188h;

    public a() {
    }

    public JSONObject a() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f21181a);
            jSONObject.put("mAdId", this.f21182b);
            jSONObject.put("mExtValue", this.f21183c);
            jSONObject.put("mPackageName", this.f21184d);
            jSONObject.put("mAppName", this.f21185e);
            jSONObject.put("mLogExtra", this.f21186f);
            jSONObject.put("mFileName", this.f21187g);
            jSONObject.put("mTimeStamp", this.f21188h);
        } catch (JSONException e10) {
            e10.printStackTrace();
        }
        return jSONObject;
    }

    public a(long j10, long j11, long j12, String str, String str2, String str3, String str4) {
        this.f21181a = j10;
        this.f21182b = j11;
        this.f21183c = j12;
        this.f21184d = str;
        this.f21185e = str2;
        this.f21186f = str3;
        this.f21187g = str4;
    }

    public static a a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        a aVar = new a();
        try {
            aVar.f21181a = m.a(jSONObject, "mDownloadId");
            aVar.f21182b = m.a(jSONObject, "mAdId");
            aVar.f21183c = m.a(jSONObject, "mExtValue");
            aVar.f21184d = jSONObject.optString("mPackageName");
            aVar.f21185e = jSONObject.optString("mAppName");
            aVar.f21186f = jSONObject.optString("mLogExtra");
            aVar.f21187g = jSONObject.optString("mFileName");
            aVar.f21188h = m.a(jSONObject, "mTimeStamp");
            return aVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }
}
