package com.heytap.mcssdk.n;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {

    /* renamed from: a, reason: collision with root package name */
    private static final String f8915a = "globalID";

    /* renamed from: b, reason: collision with root package name */
    private static final String f8916b = "taskID";

    /* renamed from: c, reason: collision with root package name */
    private static final String f8917c = "appPackage";

    /* renamed from: d, reason: collision with root package name */
    private static final String f8918d = "eventID";

    /* renamed from: e, reason: collision with root package name */
    private static final String f8919e = "property";

    /* renamed from: f, reason: collision with root package name */
    private static final String f8920f = "messageType";

    /* renamed from: g, reason: collision with root package name */
    private static final String f8921g = "eventTime";

    /* renamed from: h, reason: collision with root package name */
    private int f8922h;

    /* renamed from: i, reason: collision with root package name */
    private String f8923i;

    /* renamed from: j, reason: collision with root package name */
    private String f8924j;
    private String k;
    private String l;
    private String m;
    private long n;

    public e() {
        this.f8922h = 4096;
        this.n = System.currentTimeMillis();
    }

    public e(int i2, String str, String str2, String str3) {
        this(i2, str, null, null, str2, str3);
    }

    public e(int i2, String str, String str2, String str3, String str4, String str5) {
        this.f8922h = 4096;
        this.n = System.currentTimeMillis();
        o(i2);
        h(str);
        k(str2);
        n(str3);
        i(str4);
        l(str5);
    }

    public e(String str, String str2) {
        this(4096, str, null, null, str2, "");
    }

    public e(String str, String str2, String str3) {
        this(4096, str, null, null, str2, str3);
    }

    public static e g(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.o(jSONObject.optInt(f8920f, 0));
            eVar.h(jSONObject.optString("appPackage"));
            eVar.i(jSONObject.optString(f8918d));
            eVar.k(jSONObject.optString("globalID", ""));
            eVar.n(jSONObject.optString("taskID", ""));
            eVar.l(jSONObject.optString(f8919e, ""));
            eVar.j(jSONObject.optLong(f8921g, System.currentTimeMillis()));
            return eVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.f8923i;
    }

    public String b() {
        return this.f8924j;
    }

    public long c() {
        return this.n;
    }

    public String d() {
        return this.k;
    }

    public String e() {
        return this.m;
    }

    public String f() {
        return this.l;
    }

    public int getType() {
        return this.f8922h;
    }

    public void h(String str) {
        this.f8923i = str;
    }

    public void i(String str) {
        this.f8924j = str;
    }

    public void j(long j2) {
        this.n = j2;
    }

    public void k(String str) {
        this.k = str;
    }

    public void l(String str) {
        this.m = str;
    }

    public void m(int i2) {
        this.l = String.valueOf(i2);
    }

    public void n(String str) {
        this.l = str;
    }

    public void o(int i2) {
        this.f8922h = i2;
    }

    public String p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(f8920f, Integer.valueOf(this.f8922h));
            jSONObject.putOpt(f8918d, this.f8924j);
            jSONObject.putOpt("appPackage", this.f8923i);
            jSONObject.putOpt(f8921g, Long.valueOf(this.n));
            if (!TextUtils.isEmpty(this.k)) {
                jSONObject.putOpt("globalID", this.k);
            }
            if (!TextUtils.isEmpty(this.l)) {
                jSONObject.putOpt("taskID", this.l);
            }
            if (!TextUtils.isEmpty(this.m)) {
                jSONObject.putOpt(f8919e, this.m);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }
}
