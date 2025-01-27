package com.qq.e.comm.constants;

import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class LoadAdParams {

    /* renamed from: a */
    private LoginType f16548a;

    /* renamed from: b */
    private String f16549b;

    /* renamed from: c */
    private String f16550c;

    /* renamed from: d */
    private String f16551d;

    /* renamed from: e */
    private Map<String, String> f16552e;

    /* renamed from: f */
    private JSONObject f16553f;

    /* renamed from: g */
    private final JSONObject f16554g = new JSONObject();

    public Map getDevExtra() {
        return this.f16552e;
    }

    public String getDevExtraJsonString() {
        try {
            Map<String, String> map = this.f16552e;
            return (map == null || map.size() <= 0) ? "" : new JSONObject(this.f16552e).toString();
        } catch (Exception e10) {
            e10.printStackTrace();
            return "";
        }
    }

    public JSONObject getExtraInfo() {
        return this.f16553f;
    }

    public String getLoginAppId() {
        return this.f16549b;
    }

    public String getLoginOpenid() {
        return this.f16550c;
    }

    public LoginType getLoginType() {
        return this.f16548a;
    }

    public JSONObject getParams() {
        return this.f16554g;
    }

    public String getUin() {
        return this.f16551d;
    }

    public void setDevExtra(Map<String, String> map) {
        this.f16552e = map;
    }

    public void setExtraInfo(JSONObject jSONObject) {
        this.f16553f = jSONObject;
    }

    public void setLoginAppId(String str) {
        this.f16549b = str;
    }

    public void setLoginOpenid(String str) {
        this.f16550c = str;
    }

    public void setLoginType(LoginType loginType) {
        this.f16548a = loginType;
    }

    public void setUin(String str) {
        this.f16551d = str;
    }

    public String toString() {
        return "LoadAdParams{, loginType=" + this.f16548a + ", loginAppId=" + this.f16549b + ", loginOpenid=" + this.f16550c + ", uin=" + this.f16551d + ", passThroughInfo=" + this.f16552e + ", extraInfo=" + this.f16553f + '}';
    }
}
