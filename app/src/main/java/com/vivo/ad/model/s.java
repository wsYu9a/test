package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class s implements Serializable {

    /* renamed from: a */
    private String f26927a;

    /* renamed from: b */
    private String f26928b;

    public s(JSONObject jSONObject) {
        JsonParserUtil.getString("permissionType", jSONObject);
        this.f26927a = JsonParserUtil.getString("describe", jSONObject);
        this.f26928b = JsonParserUtil.getString("title", jSONObject);
    }

    public String a() {
        return this.f26927a;
    }

    public String b() {
        return this.f26928b;
    }

    public s() {
    }
}
