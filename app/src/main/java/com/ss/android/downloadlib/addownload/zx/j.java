package com.ss.android.downloadlib.addownload.zx;

import com.ss.android.downloadlib.lg.nt;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: g */
    public String f24230g;
    public String gv;

    /* renamed from: i */
    public long f24231i;

    /* renamed from: j */
    public long f24232j;
    public String lg;
    public String q;
    public volatile long y;
    public long zx;

    public j() {
    }

    public JSONObject j() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("mDownloadId", this.f24232j);
            jSONObject.put("mAdId", this.zx);
            jSONObject.put("mExtValue", this.f24231i);
            jSONObject.put("mPackageName", this.f24230g);
            jSONObject.put("mAppName", this.q);
            jSONObject.put("mLogExtra", this.gv);
            jSONObject.put("mFileName", this.lg);
            jSONObject.put("mTimeStamp", this.y);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject;
    }

    public j(long j2, long j3, long j4, String str, String str2, String str3, String str4) {
        this.f24232j = j2;
        this.zx = j3;
        this.f24231i = j4;
        this.f24230g = str;
        this.q = str2;
        this.gv = str3;
        this.lg = str4;
    }

    public static j j(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        j jVar = new j();
        try {
            jVar.f24232j = nt.j(jSONObject, "mDownloadId");
            jVar.zx = nt.j(jSONObject, "mAdId");
            jVar.f24231i = nt.j(jSONObject, "mExtValue");
            jVar.f24230g = jSONObject.optString("mPackageName");
            jVar.q = jSONObject.optString("mAppName");
            jVar.gv = jSONObject.optString("mLogExtra");
            jVar.lg = jSONObject.optString("mFileName");
            jVar.y = nt.j(jSONObject, "mTimeStamp");
            return jVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
