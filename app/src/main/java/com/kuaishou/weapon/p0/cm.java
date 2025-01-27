package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cm {

    /* renamed from: a */
    private Context f9211a;

    /* renamed from: b */
    private int f9212b;

    public cm(Context context, int i2) {
        this.f9211a = context;
        this.f9212b = i2;
    }

    public String a(String str) {
        JSONObject a2;
        try {
            JSONObject a3 = new cl(str, cj.f9197j).a(this.f9211a);
            if (a3 == null || (a2 = a()) == null) {
                return null;
            }
            a3.put("module_section", a2);
            return a3.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public JSONObject a() {
        long j2;
        h hVar;
        boolean z;
        boolean z2;
        String str;
        String str2;
        cm cmVar;
        try {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f9211a, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            if (a2.b(de.aG, 1) == 1 && (e2 || e3)) {
                String a3 = bg.a(this.f9211a);
                if (!TextUtils.isEmpty(a3) && !a3.startsWith("RISK")) {
                    jSONObject.put("01001", a3);
                }
                String c2 = bg.c(this.f9211a);
                if (!TextUtils.isEmpty(c2) && !c2.startsWith("RISK")) {
                    jSONObject.put("01003", c2);
                }
                String b2 = bg.b(this.f9211a, 0);
                if (!TextUtils.isEmpty(b2) && !b2.startsWith("RISK")) {
                    jSONObject.put("01019", b2);
                }
                String b3 = bg.b(this.f9211a, 1);
                if (!TextUtils.isEmpty(b3) && !b3.startsWith("RISK")) {
                    jSONObject.put("01004", b3);
                }
                String d2 = bg.d(this.f9211a);
                if (!TextUtils.isEmpty(d2) && !d2.startsWith("RISK")) {
                    jSONObject.put("01007", d2);
                }
            }
            if (a2.b(de.aH, 0) == 1 && (e2 || e3)) {
                bf bfVar = new bf();
                if (a2.b(de.aU, 1) == 1) {
                    jSONObject.put("10020", bfVar.f(this.f9211a));
                }
            }
            if (a2.b(de.aI, 1) == 1 && (e2 || e3)) {
                jSONObject.put("01011", bg.e(this.f9211a));
            }
            if (a2.b(de.aJ, 1) == 1 && (e2 || e3)) {
                String p = bg.p(this.f9211a);
                if (!TextUtils.isEmpty(p) && !p.startsWith("RISK")) {
                    jSONObject.put("01016", p);
                }
            }
            if (a2.b(de.ax, 1) == 1) {
                if (e2 || e3) {
                    String f2 = bg.f(this.f9211a);
                    if (!TextUtils.isEmpty(f2) && !f2.startsWith("RISK")) {
                        jSONObject.put("01013", f2);
                    }
                    jSONObject.put("02042", bg.v(this.f9211a));
                }
                jSONObject.put("02054", bg.z(this.f9211a));
                j2 = currentTimeMillis;
                str = "RISK";
                z2 = e3;
                z = e2;
                try {
                    if (Engine.loadSuccess) {
                        try {
                            jSONObject.put("02019", bk.b(this.f9211a));
                            jSONObject.put("02021", bk.d(this.f9211a));
                            jSONObject.put("02022", bk.c(this.f9211a));
                            jSONObject.put("02030", bk.f(this.f9211a));
                            cd cdVar = new cd(this.f9211a);
                            jSONObject.put("01014", cdVar.a("01014") != null ? cdVar.a("01014") : "");
                            jSONObject.put("02001", cdVar.a("02001") != null ? cdVar.a("02001") : bk.a());
                            jSONObject.put("02002", cdVar.a("02002") != null ? cdVar.a("02002") : bk.b());
                            jSONObject.put("02003", cdVar.a("02003") != null ? cdVar.a("02003") : bk.c());
                            jSONObject.put("02004", cdVar.a("02004") != null ? cdVar.a("02004") : bk.d());
                            jSONObject.put("02005", cdVar.a("02005") != null ? cdVar.a("02005") : bk.e());
                            jSONObject.put("02006", cdVar.a("02006") != null ? cdVar.a("02006") : bk.f());
                            jSONObject.put("02007", cdVar.a("02007") != null ? cdVar.a("02007") : bk.g());
                            jSONObject.put("02008", cdVar.a("02008") != null ? cdVar.a("02008") : bk.h());
                            jSONObject.put("02009", cdVar.a("02009") != null ? cdVar.a("02009") : bk.i());
                            jSONObject.put("02010", cdVar.a("02010") != null ? cdVar.a("02010") : bk.j());
                            jSONObject.put("02011", cdVar.a("02011") != null ? cdVar.a("02011") : bk.k());
                            jSONObject.put("02012", cdVar.a("02012") != null ? cdVar.a("02012") : bk.l());
                            jSONObject.put("02013", cdVar.a("02013") != null ? cdVar.a("02013") : bk.m());
                            jSONObject.put("02014", cdVar.a("02014") != null ? cdVar.a("02014") : bk.n());
                            jSONObject.put("02015", cdVar.a("02015") != null ? cdVar.a("02015") : bk.p());
                            jSONObject.put("02016", cdVar.a("02016") != null ? cdVar.a("02016") : bk.q());
                            jSONObject.put("02017", cdVar.a("02017") != null ? cdVar.a("02017") : Integer.valueOf(bk.r()));
                            jSONObject.put("02018", cdVar.a("02018") != null ? cdVar.a("02018") : bk.s());
                            jSONObject.put("02020", cdVar.a("02020") != null ? cdVar.a("02020") : bk.u());
                            jSONObject.put("02023", cdVar.a("02023") != null ? cdVar.a("02023") : "");
                            jSONObject.put("02031", cdVar.a("02031") != null ? cdVar.a("02031") : bk.y());
                            jSONObject.put("02032", cdVar.a("02032") != null ? cdVar.a("02032") : bk.o());
                            jSONObject.put("02033", cdVar.a("02033") != null ? cdVar.a("02033") : bk.x());
                            jSONObject.put("02034", cdVar.a("02034") != null ? cdVar.a("02034") : bk.z());
                            jSONObject.put("02035", cdVar.a("02035") != null ? cdVar.a("02035") : bk.A());
                            jSONObject.put("02036", cdVar.a("02036") != null ? cdVar.a("02036") : "");
                            jSONObject.put("02037", cdVar.a("02037") != null ? cdVar.a("02037") : bk.w());
                            jSONObject.put("02038", cdVar.a("02038") != null ? cdVar.a("02038") : bk.v());
                            jSONObject.put("02045", cdVar.a("02045") != null ? cdVar.a("02045") : bk.B());
                        } catch (Exception unused) {
                        }
                        cmVar = this;
                    } else {
                        jSONObject.put("02001", bk.a());
                        jSONObject.put("02002", bk.b());
                        jSONObject.put("02003", bk.c());
                        jSONObject.put("02004", bk.d());
                        jSONObject.put("02005", bk.e());
                        jSONObject.put("02006", bk.f());
                        jSONObject.put("02007", bk.g());
                        jSONObject.put("02008", bk.h());
                        jSONObject.put("02009", bk.i());
                        jSONObject.put("02010", bk.j());
                        jSONObject.put("02011", bk.k());
                        jSONObject.put("02012", bk.l());
                        jSONObject.put("02013", bk.m());
                        jSONObject.put("02014", bk.n());
                        jSONObject.put("02015", bk.p());
                        jSONObject.put("02016", bk.q());
                        jSONObject.put("02017", bk.r());
                        jSONObject.put("02018", bk.s());
                        cmVar = this;
                        try {
                            jSONObject.put("02019", bk.b(cmVar.f9211a));
                            jSONObject.put("02020", bk.u());
                            jSONObject.put("02021", bk.d(cmVar.f9211a));
                            jSONObject.put("02022", bk.c(cmVar.f9211a));
                            jSONObject.put("02030", bk.f(cmVar.f9211a));
                            jSONObject.put("02031", bk.y());
                            jSONObject.put("02032", bk.o());
                            jSONObject.put("02033", bk.x());
                            jSONObject.put("02034", bk.z());
                            jSONObject.put("02035", bk.A());
                            jSONObject.put("02037", bk.w());
                            jSONObject.put("02038", bk.v());
                            jSONObject.put("02045", bk.B());
                        } catch (Throwable unused2) {
                            return null;
                        }
                    }
                    str2 = "";
                    jSONObject.put("02067", cmVar.f9211a.getApplicationContext().getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                    jSONObject.put("02039", bg.h());
                    jSONObject.put("02040", bg.i());
                    jSONObject.put("02041", bg.u(cmVar.f9211a));
                    jSONObject.put("02044", bk.t());
                    jSONObject.put("02046", bk.C());
                    String a4 = bg.a("persist.service.adb.enable");
                    if (!TextUtils.isEmpty(a4)) {
                        jSONObject.put("03058", a4);
                    }
                    String a5 = bg.a("sys.resettype");
                    if (!TextUtils.isEmpty(a5)) {
                        jSONObject.put("03057", a5);
                    }
                    String a6 = bg.a("ro.boot.bootreason");
                    if (!TextUtils.isEmpty(a6)) {
                        jSONObject.put("03056", a6);
                    }
                    String a7 = bg.a("ro.runtime.firstboot");
                    if (!TextUtils.isEmpty(a7)) {
                        jSONObject.put("03055", a7);
                    }
                    String a8 = bg.a("init.svc.atcmdserver");
                    if (!TextUtils.isEmpty(a8)) {
                        jSONObject.put("03054", a8);
                    }
                    String a9 = bg.a("ro.build.date.utc");
                    if (!TextUtils.isEmpty(a9)) {
                        jSONObject.put("03061", a9);
                    }
                    String a10 = bg.a("ro.bootimage.build.date.utc");
                    if (!TextUtils.isEmpty(a10)) {
                        jSONObject.put("03062", a10);
                    }
                    String a11 = bg.a("ro.build.date.YmdHM");
                    if (!TextUtils.isEmpty(a11)) {
                        jSONObject.put("03063", a11);
                    }
                    String a12 = bg.a("dhcp.ipv6.wlan0.dns1");
                    if (!TextUtils.isEmpty(a12)) {
                        jSONObject.put("03067", a12);
                    }
                    String a13 = bg.a("dhcp.ipv6.wlan0.dns2");
                    if (!TextUtils.isEmpty(a13)) {
                        jSONObject.put("03068", a13);
                    }
                    String a14 = bg.a("dhcp.wlan0.dns1");
                    if (!TextUtils.isEmpty(a14)) {
                        jSONObject.put("03069", a14);
                    }
                    String a15 = bg.a("dhcp.wlan0.dns2");
                    if (!TextUtils.isEmpty(a15)) {
                        jSONObject.put("03070", a15);
                    }
                    String a16 = bg.a("net.change");
                    if (!TextUtils.isEmpty(a16)) {
                        jSONObject.put("03071", a16);
                    }
                    String a17 = bg.a("net.dns1");
                    if (!TextUtils.isEmpty(a17)) {
                        jSONObject.put("03072", a17);
                    }
                    String a18 = bg.a("net.dns2");
                    if (!TextUtils.isEmpty(a18)) {
                        jSONObject.put("03073", a18);
                    }
                    hVar = a2;
                    long a19 = hVar.a(de.f9282d, -1L);
                    if (a19 != -1) {
                        jSONObject.put("03074", a19 + System.currentTimeMillis());
                    }
                    try {
                        jSONObject.put("03064", Settings.System.getInt(cmVar.f9211a.getContentResolver(), "screen_brightness_mode"));
                        jSONObject.put("03065", Settings.System.getInt(cmVar.f9211a.getContentResolver(), "accelerometer_rotation"));
                    } catch (Throwable unused3) {
                    }
                    jSONObject.put("03081", bk.L());
                    jSONObject.put("03053", bg.A(cmVar.f9211a));
                    jSONObject.put("03052", bk.i(cmVar.f9211a));
                    jSONObject.put("03050", bk.h(cmVar.f9211a));
                    jSONObject.put("03049", bk.g(cmVar.f9211a));
                    jSONObject.put("02027", bk.H());
                    jSONObject.put("02028", bk.D());
                    jSONObject.put("02029", bk.E());
                    jSONObject.put("02057", bk.F());
                    jSONObject.put("02058", bk.G());
                } catch (Throwable unused4) {
                    return null;
                }
            } else {
                j2 = currentTimeMillis;
                hVar = a2;
                z = e2;
                z2 = e3;
                str = "RISK";
                str2 = "";
                cmVar = this;
            }
            if (hVar.b(de.ay, 1) == 1) {
                jSONObject.put("03001", bn.a());
                jSONObject.put("03002", bn.b());
                jSONObject.put("03001", bn.a());
                jSONObject.put("03043", SystemClock.elapsedRealtime());
                jSONObject.put("03044", SystemClock.uptimeMillis());
                jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                bx bxVar = new bx(cmVar.f9211a);
                if (Engine.loadSuccess) {
                    jSONObject.put("03004", bxVar.a("03004") != null ? bxVar.a("03004") : str2);
                    jSONObject.put("03036", bxVar.b("03036") != null ? bxVar.b("03036") : str2);
                    jSONObject.put("03039", bxVar.a("03039") != null ? bxVar.a("03039") : str2);
                    jSONObject.put("03040", bxVar.a("03040") != null ? bxVar.a("03040") : str2);
                    jSONObject.put("03041", bxVar.a("03041") != null ? bxVar.a("03041") : str2);
                    jSONObject.put("03042", bxVar.a("03042") != null ? bxVar.a("03042") : str2);
                    jSONObject.put("03079", bxVar.a("03079") != null ? bxVar.a("03079") : null);
                    jSONObject.put("03080", bxVar.a("03080") != null ? bxVar.a("03080") : null);
                }
                jSONObject.put("03007", bu.a(cmVar.f9211a));
                jSONObject.put("03008", bu.c(cmVar.f9211a));
                jSONObject.put("03011", am.b(cmVar.f9211a));
                jSONObject.put("03012", am.b());
                jSONObject.put("03014", bg.g(cmVar.f9211a));
                jSONObject.put("03034", bg.h(cmVar.f9211a));
                jSONObject.put("03020", bu.b(cmVar.f9211a));
                jSONObject.put("03037", bk.I());
                jSONObject.put("03038", bk.J());
                jSONObject.put("03077", bk.K());
                try {
                    bf bfVar2 = new bf();
                    jSONObject.put("03006", bfVar2.a(cmVar.f9211a));
                    jSONObject.put("03010", bfVar2.b(cmVar.f9211a));
                    jSONObject.put("03033", bfVar2.c(cmVar.f9211a));
                    jSONObject.put("03013", bfVar2.a());
                    jSONObject.put("03021", bfVar2.e(cmVar.f9211a));
                    jSONObject.put("03030", bf.d(cmVar.f9211a));
                    jSONObject.put("10031", bfVar2.b());
                } catch (Exception unused5) {
                }
            }
            if (hVar.b(de.aM, 1) == 1) {
                jSONObject.put("03019", bg.k(cmVar.f9211a));
                String l = bg.l(cmVar.f9211a);
                if (!TextUtils.isEmpty(l)) {
                    jSONObject.put("03046", l);
                }
                String m = bg.m(cmVar.f9211a);
                if (!TextUtils.isEmpty(m)) {
                    jSONObject.put("03047", m);
                }
                jSONObject.put("03018", bg.i(cmVar.f9211a));
            }
            if (hVar.b(de.aN, 1) == 1) {
                jSONObject.put("02059", bl.a(cmVar.f9211a));
                jSONObject.put("02060", bl.a());
                jSONObject.put("02061", bl.b());
                jSONObject.put("02062", bl.c());
                if (Engine.loadSuccess) {
                    bz bzVar = new bz(cmVar.f9211a);
                    jSONObject.put("08001", bzVar.a("08001") != null ? bzVar.a("08001") : str2);
                }
                JSONObject d3 = bl.d();
                if (d3 != null && d3.length() > 0) {
                    jSONObject.put("10050", d3);
                }
            }
            if (hVar.b(de.aL, 1) == 1 && (z || z2)) {
                jSONObject.put("03029", bg.j(cmVar.f9211a));
            }
            if (hVar.b(de.az, 1) == 1) {
                if (Engine.loadSuccess) {
                    by byVar = new by(cmVar.f9211a);
                    jSONObject.put("04001", byVar.a("04001") != null ? byVar.a("04001") : str2);
                    jSONObject.put("04002", byVar.a("04002") != null ? byVar.a("04002") : str2);
                    jSONObject.put("04003", byVar.a("04003") != null ? byVar.a("04003") : str2);
                    jSONObject.put("04004", byVar.a("04004") != null ? byVar.a("04004") : str2);
                } else {
                    try {
                        bi b4 = bj.b();
                        jSONObject.put("04001", bj.a());
                        jSONObject.put("04002", b4.b());
                        jSONObject.put("04003", b4.c());
                        jSONObject.put("04004", b4.a());
                    } catch (Exception unused6) {
                    }
                }
            }
            if (hVar.b(de.aC, 0) == 1 && (z || z2)) {
                JSONArray e4 = bg.e();
                if (e4 != null) {
                    jSONObject.put("06014", e4);
                }
                if (Engine.loadSuccess) {
                    ce ceVar = new ce(cmVar.f9211a);
                    jSONObject.put("06015", ceVar.b("06015") != null ? ceVar.b("06015") : str2);
                }
            }
            if (z || z2) {
                String g2 = bg.g();
                if ((TextUtils.isEmpty(g2) || g2.startsWith(str)) && g2 == null) {
                    jSONObject.put("07005", str2);
                } else {
                    jSONObject.put("07005", g2);
                }
            }
            if (hVar.b(de.aA, 0) == 1 && (z || z2)) {
                if (Engine.loadSuccess) {
                    jSONObject.put("07007", new cb(cmVar.f9211a).a("07007"));
                }
                JSONArray a20 = bq.a(cmVar.f9211a);
                if (a20 != null && a20.length() > 0) {
                    jSONObject.put("03035", a20);
                }
            }
            if (z || z2) {
                try {
                    double a21 = bg.a();
                    if (a21 > 0.0d) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(a21);
                        jSONObject.put("09002", sb.toString());
                    }
                    double b5 = bg.b();
                    if (b5 > 0.0d) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(b5);
                        jSONObject.put("09003", sb2.toString());
                    }
                    jSONObject.put("09001", bg.c());
                } catch (Exception unused7) {
                }
            }
            if (hVar.b(de.aE, 1) == 1 && (z || z2)) {
                jSONObject.put("10002", new w(cmVar.f9211a).a(1));
            }
            if (hVar.b(de.aB, 1) == 1 && Engine.loadSuccess) {
                String a22 = new cc(cmVar.f9211a).a("05001");
                try {
                    if (!TextUtils.isEmpty(a22) && a22.length() > 10) {
                        jSONObject.put("05001", new JSONArray(a22));
                    }
                } catch (Exception unused8) {
                }
            }
            if (Engine.loadSuccess) {
                ca caVar = new ca(cmVar.f9211a);
                jSONObject.put("13001", caVar.a("13001") != null ? caVar.a("13001") : str2);
            }
            jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11003", bh.v);
            jSONObject.put("11004", Engine.loadSoCount);
            jSONObject.put("11006", z ? 1 : 0);
            jSONObject.put("11029", z2 ? 1 : 0);
            jSONObject.put("11008", hVar.b(de.f9285g, bp.f9127e));
            jSONObject.put("11009", br.a(cmVar.f9211a.getApplicationContext()));
            try {
                String y = bg.y(cmVar.f9211a);
                if (!TextUtils.isEmpty(y)) {
                    jSONObject.put("01026", y);
                }
                if (hVar.b(de.aD, 1) == 1) {
                    String Am = com.kwad.sdk.d.b.Ax().Am();
                    if (!TextUtils.isEmpty(Am)) {
                        jSONObject.put("11102", Am);
                    }
                    jSONObject.put("11104", com.kwad.sdk.d.b.Ax().At());
                    jSONObject.put("11105", com.kwad.sdk.d.b.Ax().getDeviceId());
                    jSONObject.put("11106", com.kwad.sdk.d.b.Ax().getIccId());
                    jSONObject.put("11107", com.kwad.sdk.d.b.Ax().Al());
                    jSONObject.put("11108", com.kwad.sdk.d.b.Ax().Ao());
                    jSONObject.put("11109", com.kwad.sdk.d.b.Ax().Ap());
                    jSONObject.put("11110", com.kwad.sdk.d.b.Ax().Aq());
                    jSONObject.put("11111", com.kwad.sdk.d.b.Ax().getIp());
                    jSONObject.put("11112", com.kwad.sdk.d.b.Ax().getLocation());
                    jSONObject.put("11113", com.kwad.sdk.d.b.Ax().getOaid());
                    jSONObject.put("11114", com.kwad.sdk.d.b.Ax().An());
                    jSONObject.put("11115", com.kwad.sdk.d.b.Ax().As());
                    jSONObject.put("11116", com.kwad.sdk.d.b.Ax().Ar());
                    jSONObject.put("11202", bg.b(com.kwad.sdk.d.b.Ax().Am()));
                    jSONObject.put("11203", bg.b(com.kwad.sdk.d.b.Ax().Av()));
                    jSONObject.put("11204", bg.b(com.kwad.sdk.d.b.Ax().At()));
                    jSONObject.put("11205", bg.b(com.kwad.sdk.d.b.Ax().getDeviceId()));
                    jSONObject.put("11206", bg.b(com.kwad.sdk.d.b.Ax().getIccId()));
                    jSONObject.put("11207", bg.b(com.kwad.sdk.d.b.Ax().Al()));
                    jSONObject.put("11208", bg.b(com.kwad.sdk.d.b.Ax().Ao()));
                    jSONObject.put("11209", bg.b(com.kwad.sdk.d.b.Ax().Ap()));
                    jSONObject.put("11210", bg.b(com.kwad.sdk.d.b.Ax().Aq()));
                    jSONObject.put("11211", bg.b(com.kwad.sdk.d.b.Ax().getIp()));
                    jSONObject.put("11212", bg.b(com.kwad.sdk.d.b.Ax().getLocation()));
                    jSONObject.put("11213", bg.b(com.kwad.sdk.d.b.Ax().getOaid()));
                    jSONObject.put("11214", bg.b(com.kwad.sdk.d.b.Ax().An()));
                    jSONObject.put("11215", bg.b(com.kwad.sdk.d.b.Ax().As()));
                    jSONObject.put("11216", bg.b(com.kwad.sdk.d.b.Ax().Ar()));
                    jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                    jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                    jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                }
            } catch (Throwable unused9) {
            }
            try {
                jSONObject.put("02078", A.getE("W_S_V"));
                jSONObject.put("02079", A.getE("W_S_S_V"));
                if (Build.VERSION.SDK_INT > 21) {
                    jSONObject.put("02069", Build.VERSION.SECURITY_PATCH);
                }
                String string = Settings.Global.getString(cmVar.f9211a.getContentResolver(), "Phenotype_boot_count");
                if (!TextUtils.isEmpty(string)) {
                    jSONObject.put("03085", string);
                }
                String string2 = Settings.Global.getString(cmVar.f9211a.getContentResolver(), "boot_count");
                if (!TextUtils.isEmpty(string2)) {
                    jSONObject.put("03086", string2);
                }
                String string3 = Settings.System.getString(cmVar.f9211a.getContentResolver(), "power_on_times");
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject.put("03091", string3);
                }
                String string4 = Settings.System.getString(cmVar.f9211a.getContentResolver(), "first_boot_flag");
                if (!TextUtils.isEmpty(string4)) {
                    jSONObject.put("03104", string4);
                }
            } catch (Throwable unused10) {
            }
            jSONObject.put("11007", System.currentTimeMillis() - j2);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused11) {
            return null;
        }
    }
}
