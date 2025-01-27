package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h implements Comparable<h>, Serializable {

    /* renamed from: a */
    private int f26894a;

    /* renamed from: b */
    private int f26895b;

    /* renamed from: c */
    private String f26896c;

    public h(JSONObject jSONObject) {
        this.f26894a = JsonParserUtil.getInt("type", jSONObject);
        this.f26895b = JsonParserUtil.getInt("level", jSONObject);
        this.f26896c = JsonParserUtil.getString("url", jSONObject);
    }

    public int a() {
        return this.f26895b;
    }

    public int b() {
        return this.f26894a;
    }

    public String c() {
        return this.f26896c;
    }

    public String toString() {
        return "AdMonitorUrl{type=" + this.f26894a + ", level='" + this.f26895b + "', url='" + this.f26896c + "'}";
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(h hVar) {
        return a() - hVar.a();
    }
}
