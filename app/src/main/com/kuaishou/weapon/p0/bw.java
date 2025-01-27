package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class bw {

    /* renamed from: d */
    private static final byte[] f10857d = new byte[0];

    /* renamed from: a */
    private Context f10858a;

    /* renamed from: b */
    private boolean f10859b;

    /* renamed from: c */
    private int f10860c;

    public bw(Context context, int i10, boolean z10) {
        this.f10858a = context;
        this.f10859b = z10;
        this.f10860c = i10;
    }

    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            h a10 = h.a(this.f10858a, "re_po_rt");
            boolean e10 = a10.e("a1_p_s_p_s");
            boolean e11 = a10.e("a1_p_s_p_s_c_b");
            jSONObject.put("11006", e10 ? 1 : 0);
            jSONObject.put("11029", e11 ? 1 : 0);
            if (a10.b(df.au, 1) == 1 && (e10 || e11)) {
                String a11 = bh.a(this.f10858a);
                if (!TextUtils.isEmpty(a11) && !a11.startsWith("RISK")) {
                    jSONObject.put("01001", f.a(a11));
                }
                String c10 = bh.c(this.f10858a);
                if (!TextUtils.isEmpty(c10) && !c10.startsWith("RISK")) {
                    jSONObject.put("01003", c10);
                }
                String b10 = bh.b(this.f10858a, 0);
                if (!TextUtils.isEmpty(b10) && !b10.startsWith("RISK")) {
                    jSONObject.put("01019", b10);
                }
                String b11 = bh.b(this.f10858a, 1);
                if (!TextUtils.isEmpty(b11) && !b11.startsWith("RISK")) {
                    jSONObject.put("01004", f.a(b11));
                }
            }
            int b12 = a10.b(df.at, 1);
            if (b12 == 1 && (e10 || e11)) {
                String f10 = bh.f(this.f10858a);
                if (!TextUtils.isEmpty(f10) && !f10.startsWith("RISK")) {
                    jSONObject.put("01013", f10);
                }
            }
            if (a10.b(df.av, 1) == 1 && (e10 || e11)) {
                String d10 = bh.d(this.f10858a);
                if (!TextUtils.isEmpty(d10) && !d10.startsWith("RISK")) {
                    jSONObject.put("01007", d10);
                }
            }
            if (a10.b(df.aw, 1) == 1 && (e10 || e11)) {
                jSONObject.put("01011", bh.e(this.f10858a));
            }
            if (e10 || e11) {
                String h10 = bh.h();
                if (!TextUtils.isEmpty(h10) && !h10.startsWith("RISK")) {
                    jSONObject.put("07005", h10);
                } else if (h10 == null) {
                    jSONObject.put("07005", "");
                } else {
                    jSONObject.put("07005", h10);
                }
                jSONObject.put("07006", bh.g());
            }
            if (a10.b(df.ay, 1) == 1 && (e10 || e11)) {
                String p10 = bh.p(this.f10858a);
                if (!TextUtils.isEmpty(p10) && !p10.startsWith("RISK")) {
                    jSONObject.put("01016", p10);
                }
            }
            if (e10 || e11) {
                try {
                    double b13 = bh.b();
                    if (b13 > l5.c.f27899e) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(b13);
                        jSONObject.put("09002", sb2.toString());
                    }
                    double c11 = bh.c();
                    if (c11 > l5.c.f27899e) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append(c11);
                        jSONObject.put("09003", sb3.toString());
                    }
                } catch (Exception unused) {
                }
            }
            jSONObject.put("11013", Integer.parseInt(bx.a(this.f10858a.getApplicationContext()), 2));
            jSONObject.put("11012", bx.b(this.f10858a));
            try {
                jSONObject.put("11202", bh.b(com.kwad.sdk.e.b.Kh().JW()));
                jSONObject.put("11204", bh.b(com.kwad.sdk.e.b.Kh().Kd()));
                jSONObject.put("11205", bh.b(com.kwad.sdk.e.b.Kh().getDeviceId()));
                jSONObject.put("11206", bh.b(com.kwad.sdk.e.b.Kh().getIccId()));
                jSONObject.put("11207", bh.b(com.kwad.sdk.e.b.Kh().JV()));
                jSONObject.put("11208", bh.b(com.kwad.sdk.e.b.Kh().JY()));
                jSONObject.put("11209", bh.b(com.kwad.sdk.e.b.Kh().JZ()));
                jSONObject.put("11210", bh.b(com.kwad.sdk.e.b.Kh().Ka()));
                jSONObject.put("11211", bh.b(com.kwad.sdk.e.b.Kh().getIp()));
                jSONObject.put("11212", bh.b(com.kwad.sdk.e.b.Kh().getLocation()));
                jSONObject.put("11213", bh.b(com.kwad.sdk.e.b.Kh().getOaid()));
                jSONObject.put("11214", bh.b(com.kwad.sdk.e.b.Kh().JX()));
                jSONObject.put("11215", bh.b(com.kwad.sdk.e.b.Kh().Kc()));
                jSONObject.put("11216", bh.b(com.kwad.sdk.e.b.Kh().Kb()));
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Kh().Kg()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Kh().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Kh().getAppId()));
                jSONObject.put("11104", com.kwad.sdk.e.b.Kh().Kd());
                jSONObject.put("11105", com.kwad.sdk.e.b.Kh().getDeviceId());
                jSONObject.put("11106", com.kwad.sdk.e.b.Kh().getIccId());
                jSONObject.put("11107", com.kwad.sdk.e.b.Kh().JV());
                jSONObject.put("11108", com.kwad.sdk.e.b.Kh().JY());
                jSONObject.put("11109", com.kwad.sdk.e.b.Kh().JZ());
                jSONObject.put("11110", com.kwad.sdk.e.b.Kh().Ka());
                jSONObject.put("11111", com.kwad.sdk.e.b.Kh().getIp());
                jSONObject.put("11112", com.kwad.sdk.e.b.Kh().getLocation());
                jSONObject.put("11113", com.kwad.sdk.e.b.Kh().getOaid());
                jSONObject.put("11114", com.kwad.sdk.e.b.Kh().JX());
                jSONObject.put("11115", com.kwad.sdk.e.b.Kh().Kc());
                jSONObject.put("11116", com.kwad.sdk.e.b.Kh().Kb());
            } catch (Throwable unused2) {
            }
            String w10 = bh.w(this.f10858a);
            if (!TextUtils.isEmpty(w10)) {
                jSONObject.put("01026", w10);
            }
            if (b12 == 1) {
                try {
                    Object a12 = ai.a(this.f10858a);
                    if (a12 != null) {
                        jSONObject.put("11015", a12);
                    }
                    if (Engine.loadSuccess) {
                        ce ceVar = new ce(this.f10858a);
                        jSONObject.put("02001", ceVar.a("02001") != null ? ceVar.a("02001") : bl.a());
                        jSONObject.put("02002", ceVar.a("02002") != null ? ceVar.a("02002") : bl.b());
                        jSONObject.put("02003", ceVar.a("02003") != null ? ceVar.a("02003") : bl.c());
                        jSONObject.put("02007", ceVar.a("02007") != null ? ceVar.a("02007") : bl.g());
                        jSONObject.put("02006", ceVar.a("02006") != null ? ceVar.a("02006") : bl.f());
                        jSONObject.put("02004", ceVar.a("02004") != null ? ceVar.a("02004") : bl.d());
                        jSONObject.put("02005", ceVar.a("02005") != null ? ceVar.a("02005") : bl.e());
                        jSONObject.put("02018", ceVar.a("02018") != null ? ceVar.a("02018") : bl.s());
                        jSONObject.put("02013", ceVar.a("02013") != null ? ceVar.a("02013") : bl.m());
                        jSONObject.put("02016", ceVar.a("02016") != null ? ceVar.a("02016") : bl.q());
                    } else {
                        jSONObject.put("02001", bl.a());
                        jSONObject.put("02002", bl.b());
                        jSONObject.put("02003", bl.c());
                        jSONObject.put("02004", bl.d());
                        jSONObject.put("02005", bl.e());
                        jSONObject.put("02006", bl.f());
                        jSONObject.put("02007", bl.g());
                        jSONObject.put("02018", bl.s());
                        jSONObject.put("02013", bl.m());
                        jSONObject.put("02016", bl.q());
                    }
                    jSONObject.put("02021", bl.d(this.f10858a));
                    jSONObject.put("02022", bl.c(this.f10858a));
                    jSONObject.put("02044", bl.t());
                    jSONObject.put("11009", bs.a(this.f10858a.getApplicationContext()));
                    if (Engine.loadSuccess) {
                        bz bzVar = new bz(this.f10858a);
                        jSONObject.put("04001", bzVar.a("04001") != null ? bzVar.a("04001") : "");
                        jSONObject.put("04002", bzVar.a("04002") != null ? bzVar.a("04002") : "");
                        jSONObject.put("04003", bzVar.a("04003") != null ? bzVar.a("04003") : "");
                        jSONObject.put("04004", bzVar.a("04004") != null ? bzVar.a("04004") : "");
                    } else {
                        try {
                            bj b14 = bk.b();
                            jSONObject.put("04001", bk.a());
                            jSONObject.put("04002", b14.b());
                            jSONObject.put("04003", b14.c());
                            jSONObject.put("04004", b14.a());
                        } catch (Exception unused3) {
                        }
                    }
                } catch (Throwable unused4) {
                    return null;
                }
            }
            if (this.f10859b) {
                jSONObject.put("20004", 1);
            }
            jSONObject.put("11017", jSONObject.toString().length());
            jSONObject.put("20000", this.f10860c);
            jSONObject.put("11028", WeaponHI.sKSSdkver);
            return jSONObject;
        } catch (Throwable unused5) {
            return null;
        }
    }

    public String a(String str) {
        try {
            synchronized (f10857d) {
                try {
                    JSONObject a10 = new cm(str, ck.f10916l).a(this.f10858a);
                    if (a10 == null) {
                        return null;
                    }
                    JSONObject a11 = a();
                    if (a11 == null) {
                        return null;
                    }
                    a10.put("module_section", a11);
                    return a10.toString();
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        } catch (Throwable unused) {
            return null;
        }
    }
}
