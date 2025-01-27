package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.cdo.oaps.ad.OapsWrapper;
import com.cdo.oaps.ad.wrapper.BaseWrapper;
import com.kuaishou.weapon.p0.jni.Engine;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class cn {

    /* renamed from: a */
    private Context f9213a;

    public cn(Context context) {
        this.f9213a = context;
    }

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a2 = h.a(this.f9213a, "re_po_rt");
            boolean e2 = a2.e("a1_p_s_p_s");
            boolean e3 = a2.e("a1_p_s_p_s_c_b");
            ai aiVar = new ai(this.f9213a);
            jSONObject.put("0", aiVar.d());
            jSONObject.put("1", aiVar.a());
            jSONObject.put("2", aiVar.c());
            jSONObject.put("3", aiVar.f());
            jSONObject.put("24", aiVar.e());
            int i2 = 1;
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_SPEECH_ASSIST, ab.b() ? 1 : 0);
            jSONObject.put(BaseWrapper.ENTER_ID_OAPS_FLOWMARKET, ab.a(this.f9213a) ? 1 : 0);
            JSONObject a3 = ah.a(this.f9213a);
            if (a3 != null) {
                jSONObject.put("4", a3);
            }
            if (a2.b(de.aa, 0) == 1 && (e2 || e3)) {
                jSONObject.put("25", al.a(this.f9213a) ? 1 : 0);
            }
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a4 = acVar.a(this.f9213a);
            jSONObject.put("8", a4 ? 1 : 0);
            if (a4) {
                jSONObject.put("61", acVar.b(this.f9213a));
            }
            jSONObject.put("10", acVar.e(this.f9213a));
            jSONObject.put("11", acVar.c(this.f9213a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b2 = aoVar.b();
            jSONObject.put("66", b2 ? 1 : 0);
            if (b2) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put("101", aoVar.c() ? 1 : 0);
            jSONObject.put("102", aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bu.a(this.f9213a));
            jSONObject2.put("03014", bg.g(this.f9213a));
            jSONObject2.put("03020", bu.b(this.f9213a));
            jSONObject2.put("03030", bf.d(this.f9213a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put("107", new an().d());
            if (!ab.b(this.f9213a)) {
                i2 = 0;
            }
            jSONObject.put("60", i2);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bg.c(com.kwad.sdk.d.b.Ax().Aw()));
                jSONObject.put("11302", bg.c(com.kwad.sdk.d.b.Ax().getSdkVersion()));
                jSONObject.put("11303", bg.c(com.kwad.sdk.d.b.Ax().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a2;
        JSONObject a3;
        try {
            cl clVar = new cl(str, cj.f9197j);
            String a4 = dk.a(ct.f9230a);
            String b2 = b(a4);
            if (TextUtils.isEmpty(b2) || (a2 = clVar.a(this.f9213a)) == null) {
                return null;
            }
            String str2 = ct.f9237h + "?" + cu.a(this.f9213a);
            if (ct.a() && ct.f9230a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", b2);
            jSONObject.put("host", a4);
            jSONObject.put(OapsWrapper.KEY_PATH, str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put(MonitorConstants.CONNECT_TYPE_HEAD, a2);
            StringBuilder sb = new StringBuilder();
            sb.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb.toString());
            if (str.equals(cj.f9195h) && (a3 = a()) != null) {
                jSONObject.put("sjd", a3);
            }
            return jSONObject.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public String b(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            String hostAddress = InetAddress.getByName(dk.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(".")) {
                        return hostAddress;
                    }
                }
                return "";
            } catch (UnknownHostException unused) {
                return hostAddress;
            }
        } catch (UnknownHostException unused2) {
            return "";
        }
    }
}
