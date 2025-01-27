package com.vivo.ad.model;

import com.tencent.open.SocialConstants;
import com.vivo.ic.webview.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class i implements Serializable {

    /* renamed from: a */
    private String f26897a;

    /* renamed from: b */
    private String f26898b;

    /* renamed from: c */
    private String f26899c;

    /* renamed from: d */
    private String f26900d;

    public i(JSONObject jSONObject) {
        this.f26897a = JsonParserUtil.getString("id", jSONObject);
        this.f26899c = JsonParserUtil.getString("name", jSONObject);
        this.f26900d = JsonParserUtil.getString(SocialConstants.PARAM_APP_DESC, jSONObject);
        this.f26898b = JsonParserUtil.getString("icon", jSONObject);
    }

    public String a() {
        return this.f26900d;
    }

    public String b() {
        return this.f26898b;
    }

    public String c() {
        return this.f26897a;
    }

    public String d() {
        return this.f26899c;
    }
}
