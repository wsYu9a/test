package com.vivo.ad.model;

import com.ss.android.socialbase.downloader.constants.DBDefinition;
import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class j implements Serializable {

    /* renamed from: a */
    private long f26901a;

    /* renamed from: b */
    private String f26902b;

    /* renamed from: c */
    private String f26903c;

    /* renamed from: d */
    private String f26904d;

    /* renamed from: e */
    private int f26905e;

    public j(JSONObject jSONObject) {
        this.f26901a = JsonParserUtil.getLong("id", jSONObject);
        this.f26902b = JsonParserUtil.getString("name", jSONObject);
        this.f26903c = JsonParserUtil.getString(com.heytap.mcssdk.n.d.p, jSONObject);
        this.f26904d = JsonParserUtil.getString(DBDefinition.ICON_URL, jSONObject);
        this.f26905e = JsonParserUtil.getInt("versionCode", jSONObject);
    }

    public String a() {
        return this.f26903c;
    }

    public String b() {
        return this.f26904d;
    }

    public long c() {
        return this.f26901a;
    }

    public String d() {
        return this.f26902b;
    }

    public String toString() {
        return "AppAdInfo{id=" + this.f26901a + ", name='" + this.f26902b + "', appPackage='" + this.f26903c + "', iconUrl='" + this.f26904d + "', versionCode=" + this.f26905e + '}';
    }
}
