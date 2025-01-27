package com.vivo.ad.model;

import com.cdo.oaps.ad.OapsKey;
import com.tencent.open.SocialConstants;
import com.vivo.ic.jsonparser.JsonParserUtil;
import java.io.Serializable;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class a0 implements Serializable {

    /* renamed from: a */
    private String f26845a;

    /* renamed from: b */
    private String f26846b;

    /* renamed from: c */
    private int f26847c;

    /* renamed from: d */
    private int f26848d;

    /* renamed from: e */
    private int f26849e;

    /* renamed from: f */
    private String f26850f;

    /* renamed from: g */
    private String f26851g;

    /* renamed from: h */
    private String f26852h;

    public a0(JSONObject jSONObject) {
        this.f26845a = JsonParserUtil.getString("videoId", jSONObject);
        this.f26846b = JsonParserUtil.getString("videoUrl", jSONObject);
        this.f26847c = JsonParserUtil.getInt("duration", jSONObject);
        JsonParserUtil.getInt(OapsKey.KEY_SIZE, jSONObject);
        JsonParserUtil.getString("type", jSONObject);
        this.f26848d = JsonParserUtil.getInt("width", jSONObject);
        this.f26849e = JsonParserUtil.getInt("height", jSONObject);
        this.f26850f = JsonParserUtil.getString("title", jSONObject);
        this.f26851g = JsonParserUtil.getString(SocialConstants.PARAM_APP_DESC, jSONObject);
        this.f26852h = JsonParserUtil.getString("previewImgUrl", jSONObject);
    }

    public String a() {
        return this.f26851g;
    }

    public int b() {
        return this.f26847c;
    }

    public int c() {
        return this.f26849e;
    }

    public String d() {
        return this.f26852h;
    }

    public String e() {
        return this.f26850f;
    }

    public String f() {
        return this.f26845a;
    }

    public String g() {
        return this.f26846b;
    }

    public int h() {
        return this.f26848d;
    }
}
