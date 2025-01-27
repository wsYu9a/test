package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class l implements Serializable {

    /* renamed from: a */
    private String f26911a;

    /* renamed from: b */
    private int f26912b;

    public l(JSONObject jSONObject) {
        this.f26911a = JsonParserUtil.getString("url", jSONObject);
        this.f26912b = JsonParserUtil.getInt("status", jSONObject);
    }

    public int a() {
        return this.f26912b;
    }

    public String b() {
        return this.f26911a;
    }
}
