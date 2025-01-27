package b.h.a;

import android.os.Process;
import com.kuaishou.weapon.p0.t;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: f */
    private b f4961f;
    private b.h.a.j.a k;

    /* renamed from: a */
    private String f4956a = "";

    /* renamed from: b */
    private String f4957b = "";

    /* renamed from: c */
    private String f4958c = "";

    /* renamed from: d */
    private String f4959d = "";

    /* renamed from: g */
    private String f4962g = "";

    /* renamed from: h */
    private int f4963h = 1;

    /* renamed from: i */
    private int f4964i = 1;

    /* renamed from: j */
    private int f4965j = 7;

    /* renamed from: e */
    private c f4960e = new a();

    final class a implements c {
        a() {
        }

        @Override // b.h.a.d.c
        public final String a() {
            return "";
        }

        @Override // b.h.a.d.c
        public final String b() {
            return "";
        }

        @Override // b.h.a.d.c
        public final String c() {
            return "";
        }
    }

    public interface b {
        String a();
    }

    public interface c {
        String a();

        String b();

        String c();
    }

    /* renamed from: b.h.a.d$d */
    public final class C0055d {
        public final String a(String str, String str2, byte b2) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("m", str2);
                jSONObject.put("t", str);
                jSONObject.put(t.f9404d, (int) b2);
                jSONObject.put("p", b.h.a.e.b.j(b.h.a.e.b.a()));
                jSONObject.put("pid", Process.myPid());
                return jSONObject.toString();
            } catch (JSONException e2) {
                if (b.h.a.c.j()) {
                    e2.printStackTrace();
                }
                return "format exception:" + e2.toString();
            }
        }
    }

    public b a() {
        return this.f4961f;
    }

    public void b(int i2) {
        this.f4963h = i2;
    }

    public void c(b bVar) {
        this.f4961f = bVar;
    }

    public void d(c cVar) {
        this.f4960e = cVar;
    }

    public void e(b.h.a.j.a aVar) {
        this.k = aVar;
    }

    public void f(String str) {
        this.f4962g = str;
    }

    public c g() {
        return this.f4960e;
    }

    public void h(int i2) {
        this.f4964i = i2;
    }

    public void i(String str) {
        this.f4956a = str;
    }

    public String j() {
        return this.f4962g;
    }

    public void k(int i2) {
        this.f4965j = i2;
    }

    public void l(String str) {
        this.f4957b = str;
    }

    public String m() {
        return this.f4957b;
    }

    public void n(String str) {
        this.f4958c = str;
    }

    public String o() {
        return this.f4956a;
    }

    public void p(String str) {
        this.f4959d = str;
    }

    public String q() {
        return this.f4958c;
    }

    public String r() {
        return this.f4959d;
    }

    public int s() {
        return this.f4963h;
    }

    public int t() {
        return this.f4964i;
    }

    public int u() {
        return this.f4965j;
    }

    public b.h.a.j.a v() {
        return this.k;
    }
}
