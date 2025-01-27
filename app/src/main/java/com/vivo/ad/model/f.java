package com.vivo.ad.model;

import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class f implements Serializable {

    /* renamed from: a */
    private String f26886a;

    /* renamed from: b */
    private String f26887b;

    /* renamed from: c */
    private String f26888c;

    /* renamed from: d */
    private String f26889d;

    /* renamed from: e */
    private List<String> f26890e;

    /* renamed from: f */
    private List<String> f26891f;

    public f(JSONObject jSONObject) {
        this.f26890e = new ArrayList();
        this.f26891f = new ArrayList();
        this.f26886a = JsonParserUtil.getString("uuid", jSONObject);
        this.f26887b = JsonParserUtil.getString("title", jSONObject);
        this.f26888c = JsonParserUtil.getString("summary", jSONObject);
        this.f26889d = JsonParserUtil.getString("dimensions", jSONObject);
        this.f26890e = JsonParserUtil.getStringArray("imageUrls", jSONObject);
        this.f26891f = JsonParserUtil.getStringArray("fileUrls", jSONObject);
    }

    public String a() {
        return this.f26889d;
    }

    public List<String> b() {
        return this.f26891f;
    }

    public List<String> c() {
        return this.f26890e;
    }

    public String d() {
        return this.f26888c;
    }

    public String e() {
        return this.f26887b;
    }

    public String f() {
        return this.f26886a;
    }

    public String toString() {
        return "AdMaterial{uuid='" + this.f26886a + "', title='" + this.f26887b + "', summary='" + this.f26888c + "', dimensions='" + this.f26889d + "'}";
    }
}
