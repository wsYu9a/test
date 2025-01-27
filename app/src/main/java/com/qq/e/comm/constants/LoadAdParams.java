package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class LoadAdParams {

    /* renamed from: a */
    private LoginType f23999a;

    /* renamed from: b */
    private String f24000b;

    /* renamed from: c */
    private String f24001c;

    /* renamed from: d */
    private String f24002d;

    /* renamed from: e */
    private Map<String, String> f24003e;

    /* renamed from: f */
    private JSONObject f24004f;

    /* renamed from: g */
    private final JSONObject f24005g = new JSONObject();

    public Map getDevExtra() {
        return this.f24003e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f24003e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f24003e).toString();
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f24004f;
    }

    public String getLoginAppId() {
        return this.f24000b;
    }

    public String getLoginOpenid() {
        return this.f24001c;
    }

    public LoginType getLoginType() {
        return this.f23999a;
    }

    public JSONObject getParams() {
        return this.f24005g;
    }

    public String getUin() {
        return this.f24002d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f24003e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f24004f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f24000b = str;
    }

    public void setLoginOpenid(String str) {
        this.f24001c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f23999a = loginType;
    }

    public void setUin(String str) {
        this.f24002d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f23999a + ", loginAppId=" + this.f24000b + ", loginOpenid=" + this.f24001c + ", uin=" + this.f24002d + ", passThroughInfo=" + this.f24003e + ", extraInfo=" + this.f24004f + '}';
    }
}
