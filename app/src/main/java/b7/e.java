package b7;

import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class e {

    /* renamed from: h, reason: collision with root package name */
    public static final String f1377h = "globalID";

    /* renamed from: i, reason: collision with root package name */
    public static final String f1378i = "taskID";

    /* renamed from: j, reason: collision with root package name */
    public static final String f1379j = "appPackage";

    /* renamed from: k, reason: collision with root package name */
    public static final String f1380k = "eventID";

    /* renamed from: l, reason: collision with root package name */
    public static final String f1381l = "property";

    /* renamed from: m, reason: collision with root package name */
    public static final String f1382m = "messageType";

    /* renamed from: n, reason: collision with root package name */
    public static final String f1383n = "eventTime";

    /* renamed from: a, reason: collision with root package name */
    public int f1384a;

    /* renamed from: b, reason: collision with root package name */
    public String f1385b;

    /* renamed from: c, reason: collision with root package name */
    public String f1386c;

    /* renamed from: d, reason: collision with root package name */
    public String f1387d;

    /* renamed from: e, reason: collision with root package name */
    public String f1388e;

    /* renamed from: f, reason: collision with root package name */
    public String f1389f;

    /* renamed from: g, reason: collision with root package name */
    public long f1390g;

    public e() {
        this.f1384a = 4096;
        this.f1390g = System.currentTimeMillis();
    }

    public static e g(String str) {
        e eVar = new e();
        try {
            JSONObject jSONObject = new JSONObject(str);
            eVar.o(jSONObject.optInt("messageType", 0));
            eVar.h(jSONObject.optString("appPackage"));
            eVar.i(jSONObject.optString("eventID"));
            eVar.k(jSONObject.optString("globalID", ""));
            eVar.n(jSONObject.optString("taskID", ""));
            eVar.l(jSONObject.optString(f1381l, ""));
            eVar.j(jSONObject.optLong(f1383n, System.currentTimeMillis()));
            return eVar;
        } catch (Exception e10) {
            e10.printStackTrace();
            return null;
        }
    }

    public String a() {
        return this.f1385b;
    }

    public String b() {
        return this.f1386c;
    }

    public long c() {
        return this.f1390g;
    }

    public String d() {
        return this.f1387d;
    }

    public String e() {
        return this.f1389f;
    }

    public String f() {
        return this.f1388e;
    }

    public int getType() {
        return this.f1384a;
    }

    public void h(String str) {
        this.f1385b = str;
    }

    public void i(String str) {
        this.f1386c = str;
    }

    public void j(long j10) {
        this.f1390g = j10;
    }

    public void k(String str) {
        this.f1387d = str;
    }

    public void l(String str) {
        this.f1389f = str;
    }

    public void m(int i10) {
        this.f1388e = String.valueOf(i10);
    }

    public void n(String str) {
        this.f1388e = str;
    }

    public void o(int i10) {
        this.f1384a = i10;
    }

    public String p() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("messageType", Integer.valueOf(this.f1384a));
            jSONObject.putOpt("eventID", this.f1386c);
            jSONObject.putOpt("appPackage", this.f1385b);
            jSONObject.putOpt(f1383n, Long.valueOf(this.f1390g));
            if (!TextUtils.isEmpty(this.f1387d)) {
                jSONObject.putOpt("globalID", this.f1387d);
            }
            if (!TextUtils.isEmpty(this.f1388e)) {
                jSONObject.putOpt("taskID", this.f1388e);
            }
            if (!TextUtils.isEmpty(this.f1389f)) {
                jSONObject.putOpt(f1381l, this.f1389f);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        return jSONObject.toString();
    }

    public e(int i10, String str, String str2, String str3) {
        this(i10, str, null, null, str2, str3);
    }

    public e(int i10, String str, String str2, String str3, String str4, String str5) {
        this.f1384a = 4096;
        this.f1390g = System.currentTimeMillis();
        o(i10);
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
}
