package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.sigmob.sdk.base.mta.PointType;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.tencent.connect.common.Constants;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class co {

    /* renamed from: a */
    private Context f10948a;

    public co(Context context) {
        this.f10948a = context;
    }

    public String a(String str) {
        JSONObject a10;
        JSONObject a11;
        try {
            cm cmVar = new cm(str, ck.f10916l);
            String a12 = dl.a(cu.f10966a);
            String b10 = b(a12);
            if (TextUtils.isEmpty(b10) || (a10 = cmVar.a(this.f10948a)) == null) {
                return null;
            }
            String str2 = cu.f10973h + "?" + cv.a(this.f10948a);
            if (cu.a() && cu.f10966a.contains("api")) {
                str2 = "/api" + str2;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ip", b10);
            jSONObject.put(z2.c.f33638f, a12);
            jSONObject.put(t8.a.f30751f, str2);
            String str3 = WeaponHI.cookieData;
            if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                jSONObject.put("cookie", str3);
            }
            jSONObject.put(MonitorConstants.CONNECT_TYPE_HEAD, a10);
            StringBuilder sb2 = new StringBuilder();
            sb2.append("sdk=" + Build.VERSION.SDK_INT);
            jSONObject.put("parame", sb2.toString());
            if (str.equals(ck.f10912h) && (a11 = a()) != null) {
                jSONObject.put("sjd", a11);
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
            String hostAddress = InetAddress.getByName(dl.a(str)).getHostAddress();
            try {
                if (!TextUtils.isEmpty(hostAddress)) {
                    if (hostAddress.contains(p1.b.f29697h)) {
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

    private JSONObject a() {
        try {
            System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            h a10 = h.a(this.f10948a, "re_po_rt");
            a10.e("a1_p_s_p_s");
            a10.e("a1_p_s_p_s_c_b");
            aj ajVar = new aj(this.f10948a);
            jSONObject.put("0", ajVar.d());
            jSONObject.put("1", ajVar.a());
            jSONObject.put("2", ajVar.c());
            jSONObject.put("3", ajVar.f());
            jSONObject.put("24", ajVar.e());
            jSONObject.put("35", ab.b() ? 1 : 0);
            jSONObject.put("36", ab.a(this.f10948a) ? 1 : 0);
            Object a11 = ai.a(this.f10948a);
            if (a11 != null) {
                jSONObject.put("4", a11);
            }
            a10.b(df.f11028ac, 0);
            ac acVar = new ac();
            jSONObject.put("7", acVar.a() ? 1 : 0);
            boolean a12 = acVar.a(this.f10948a);
            jSONObject.put("8", a12 ? 1 : 0);
            if (a12) {
                jSONObject.put("61", acVar.b(this.f10948a));
            }
            jSONObject.put("10", acVar.e(this.f10948a));
            jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, acVar.c(this.f10948a));
            ae aeVar = new ae();
            jSONObject.put("26", aeVar.a("cpuinfo") ? 1 : 0);
            jSONObject.put("27", aeVar.a("meminfo") ? 1 : 0);
            ao aoVar = new ao();
            jSONObject.put("65", aoVar.d() ? 1 : 0);
            boolean b10 = aoVar.b();
            jSONObject.put("66", b10 ? 1 : 0);
            if (b10) {
                jSONObject.put("67", aoVar.a() ? 1 : 0);
            }
            jSONObject.put("68", aoVar.f() ? 1 : 0);
            jSONObject.put("69", aoVar.e());
            jSONObject.put(PointType.ANTI_SPAM, aoVar.c() ? 1 : 0);
            jSONObject.put(PointType.ANTI_SPAM_TOUCH, aoVar.g() ? 1 : 0);
            jSONObject.put("99", new af().a());
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("03007", bv.a(this.f10948a));
            jSONObject2.put("03014", bh.g(this.f10948a));
            jSONObject2.put("03020", bv.b(this.f10948a));
            jSONObject2.put("03030", bg.d(this.f10948a));
            jSONObject.put("51", jSONObject2);
            jSONObject.put(PointType.WIND_ACTIVE, new an().d());
            jSONObject.put("60", ab.b(this.f10948a) ? 1 : 0);
            try {
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Kh().Kg()));
                jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Kh().getSdkVersion()));
                jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Kh().getAppId()));
                jSONObject.put("11002", Engine.soVersion);
            } catch (Throwable unused) {
            }
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }
}
