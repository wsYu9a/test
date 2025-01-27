package b.b.a.c;

import android.os.Build;
import android.text.TextUtils;
import com.martian.mibook.application.MiConfigSingleton;
import java.lang.ref.WeakReference;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a */
    public a f4235a;

    /* renamed from: b */
    private JSONObject f4236b;

    /* renamed from: c */
    private JSONObject f4237c;

    /* renamed from: d */
    private long f4238d;

    /* renamed from: e */
    public WeakReference<c> f4239e;

    /* renamed from: f */
    public boolean f4240f;

    /* renamed from: g */
    boolean f4241g;

    public e(a aVar, JSONObject jSONObject) {
        this(aVar, jSONObject, (byte) 0);
    }

    private e(a aVar, JSONObject jSONObject, byte b2) {
        this.f4239e = null;
        this.f4240f = true;
        this.f4241g = true;
        this.f4235a = aVar;
        this.f4236b = jSONObject;
        this.f4237c = null;
        this.f4239e = new WeakReference<>(null);
    }

    private void b(long j2) {
        this.f4238d = j2;
    }

    private void c(c cVar) {
        this.f4239e = new WeakReference<>(cVar);
    }

    private void d(JSONObject jSONObject) {
        this.f4237c = jSONObject;
    }

    private void e(boolean z) {
        this.f4241g = z;
    }

    private boolean f() {
        return this.f4241g;
    }

    private String g() {
        return this.f4235a.f4218a;
    }

    private void h(boolean z) {
        this.f4240f = z;
    }

    private long i() {
        return this.f4238d;
    }

    private c j() {
        return this.f4239e.get();
    }

    private boolean k() {
        return this.f4240f;
    }

    private a l() {
        return this.f4235a;
    }

    public final JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("device", Build.MODEL);
            JSONObject jSONObject3 = new JSONObject();
            JSONObject b2 = com.alipay.sdk.util.d.b(jSONObject2, this.f4237c);
            b2.put(b.b.a.b.c.l, this.f4235a.f4219b);
            b2.put("api_name", this.f4235a.f4222e);
            b2.put("api_version", this.f4235a.f4221d);
            if (this.f4236b == null) {
                this.f4236b = new JSONObject();
            }
            this.f4236b.put("action", jSONObject3);
            String str2 = this.f4235a.f4220c;
            if (!TextUtils.isEmpty(str2)) {
                try {
                    String[] split = str2.split("/");
                    jSONObject3.put("type", split[1]);
                    if (split.length > 1) {
                        jSONObject3.put("method", split[2]);
                    }
                } catch (Exception unused) {
                }
            }
            this.f4236b.put("gzip", this.f4241g);
            if (this.f4240f) {
                JSONObject jSONObject4 = new JSONObject();
                String str3 = "requestData before: " + this.f4236b.toString();
                String jSONObject5 = this.f4236b.toString();
                String a2 = b.b.a.d.d.a(str, b.b.a.b.a.f4190c);
                String a3 = b.b.a.d.e.a(str, jSONObject5);
                jSONObject4.put("req_data", String.format(Locale.getDefault(), "%08X%s%08X%s", Integer.valueOf(a2.length()), a2, Integer.valueOf(a3.length()), a3));
                b2.put("params", jSONObject4);
            } else {
                b2.put("params", this.f4236b);
            }
            jSONObject.put(MiConfigSingleton.t0, b2);
        } catch (Exception unused2) {
        }
        String str4 = "requestData : " + jSONObject.toString();
        return jSONObject;
    }

    public final String toString() {
        return this.f4235a.toString() + ", requestData = " + com.alipay.sdk.util.d.b(this.f4236b, this.f4237c) + ", timeStamp = " + this.f4238d;
    }
}
