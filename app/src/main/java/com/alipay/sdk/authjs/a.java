package com.alipay.sdk.authjs;

import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: a */
    public static final String f5374a = "CallInfo";

    /* renamed from: b */
    public static final String f5375b = "call";

    /* renamed from: c */
    public static final String f5376c = "callback";

    /* renamed from: d */
    public static final String f5377d = "bundleName";

    /* renamed from: e */
    public static final String f5378e = "clientId";

    /* renamed from: f */
    public static final String f5379f = "param";

    /* renamed from: g */
    public static final String f5380g = "func";

    /* renamed from: h */
    public static final String f5381h = "msgType";

    /* renamed from: i */
    String f5382i;

    /* renamed from: j */
    String f5383j;
    String k;
    private String l;
    JSONObject m;
    private boolean n = false;

    /* renamed from: com.alipay.sdk.authjs.a$a */
    public enum EnumC0062a {
        NONE_ERROR,
        FUNCTION_NOT_FOUND,
        INVALID_PARAMETER,
        RUNTIME_ERROR,
        NONE_PERMISS
    }

    public a(String str) {
        this.l = str;
    }

    private static String b(EnumC0062a enumC0062a) {
        int i2 = b.f5390a[enumC0062a.ordinal()];
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? com.baidu.mobads.sdk.internal.a.f5472a : "runtime error" : "invalid parameter" : "function not found";
    }

    private void c(String str) {
        this.f5382i = str;
    }

    private void d(JSONObject jSONObject) {
        this.m = jSONObject;
    }

    private void e(boolean z) {
        this.n = z;
    }

    private void f(String str) {
        this.f5383j = str;
    }

    private boolean g() {
        return this.n;
    }

    private String h() {
        return this.f5382i;
    }

    private void i(String str) {
        this.k = str;
    }

    private String j() {
        return this.f5383j;
    }

    private void k(String str) {
        this.l = str;
    }

    private String l() {
        return this.k;
    }

    private String m() {
        return this.l;
    }

    private JSONObject n() {
        return this.m;
    }

    public final String a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(f5378e, this.f5382i);
        jSONObject.put(f5380g, this.k);
        jSONObject.put(f5379f, this.m);
        jSONObject.put(f5381h, this.l);
        return jSONObject.toString();
    }
}
