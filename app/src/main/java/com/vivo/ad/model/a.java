package com.vivo.ad.model;

import com.tencent.open.SocialConstants;
import com.vivo.ic.webview.JsonParserUtil;
import java.io.Serializable;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a implements Serializable {

    /* renamed from: a */
    private String f26840a;

    /* renamed from: b */
    private String f26841b;

    /* renamed from: c */
    private String f26842c;

    /* renamed from: d */
    private String f26843d;

    /* renamed from: e */
    private ArrayList<a> f26844e;

    public a() {
    }

    public ArrayList<a> a() {
        return this.f26844e;
    }

    public String b() {
        return this.f26842c;
    }

    public String c() {
        return this.f26843d;
    }

    public String d() {
        return this.f26840a;
    }

    public String e() {
        return this.f26841b;
    }

    public a(JSONObject jSONObject) {
        this.f26840a = JsonParserUtil.getString("id", jSONObject);
        this.f26841b = JsonParserUtil.getString("name", jSONObject);
        this.f26842c = JsonParserUtil.getString(SocialConstants.PARAM_APP_DESC, jSONObject);
        JSONArray jSONArray = JsonParserUtil.getJSONArray("children", jSONObject);
        if (jSONArray == null || jSONArray.length() <= 0) {
            return;
        }
        this.f26844e = new ArrayList<>();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null) {
                this.f26844e.add(new a(optJSONObject));
            }
        }
    }

    public void a(String str) {
        this.f26842c = str;
    }

    public void b(String str) {
        this.f26843d = str;
    }

    public void c(String str) {
        this.f26840a = str;
    }

    public void d(String str) {
        this.f26841b = str;
    }

    public void a(ArrayList<a> arrayList) {
        this.f26844e = arrayList;
    }
}
