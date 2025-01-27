package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class o implements Serializable {

    /* renamed from: a */
    private Integer f26916a;

    /* renamed from: b */
    private String f26917b;

    public o(JSONObject jSONObject) {
        this.f26916a = Integer.valueOf(JsonParserUtil.getInt("screenOrientation", jSONObject, 0));
        this.f26917b = JsonParserUtil.getString("interactUrl", jSONObject);
    }

    public String a() {
        return this.f26917b;
    }

    public Integer b() {
        return this.f26916a;
    }
}
