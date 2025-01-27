package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import com.martian.mibook.activity.appwall.AppwallTaskDetailActivity;
import com.sigmob.sdk.base.mta.PointType;
import com.tencent.connect.common.Constants;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class cj {

    /* renamed from: a */
    private Context f10904a;

    public cj(Context context) {
        this.f10904a = context;
    }

    public JSONObject a() {
        int i10;
        try {
            JSONObject jSONObject = new JSONObject();
            h a10 = h.a(this.f10904a, "re_po_rt");
            boolean e10 = a10.e("a1_p_s_p_s");
            boolean e11 = a10.e("a1_p_s_p_s_c_b");
            if (a10.b(df.G, 1) != 1) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (a10.b(df.K, 0) == 1 && Engine.loadSuccess) {
                ap apVar = new ap(this.f10904a);
                jSONObject.put("0", apVar.b("0"));
                jSONObject.put("1", apVar.b("1"));
                jSONObject.put("2", apVar.b("2"));
                jSONObject.put("4", apVar.b("4"));
                jSONObject.put("5", apVar.b("5"));
                jSONObject.put("6", apVar.b("6"));
                jSONObject.put("7", apVar.b("7"));
                jSONObject.put("8", apVar.b("8"));
                jSONObject.put("9", apVar.b("9"));
                jSONObject.put("10", apVar.b("10"));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE, apVar.b(Constants.VIA_REPORT_TYPE_SHARE_TO_QZONE));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SET_AVATAR, apVar.b(Constants.VIA_REPORT_TYPE_SET_AVATAR));
                jSONObject.put("13", apVar.b("13"));
                jSONObject.put(Constants.VIA_REPORT_TYPE_MAKE_FRIEND, apVar.b(Constants.VIA_REPORT_TYPE_MAKE_FRIEND));
                jSONObject.put(Constants.VIA_REPORT_TYPE_WPA_STATE, apVar.b(Constants.VIA_REPORT_TYPE_WPA_STATE));
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_WAP, apVar.b(Constants.VIA_REPORT_TYPE_START_WAP));
                jSONObject.put(Constants.VIA_REPORT_TYPE_START_GROUP, apVar.b(Constants.VIA_REPORT_TYPE_START_GROUP));
                jSONObject.put("18", apVar.b("18"));
                jSONObject.put(Constants.VIA_ACT_TYPE_NINETEEN, apVar.b(Constants.VIA_ACT_TYPE_NINETEEN));
                jSONObject.put("20", apVar.b("20"));
                jSONObject.put(Constants.VIA_REPORT_TYPE_QQFAVORITES, apVar.b(Constants.VIA_REPORT_TYPE_QQFAVORITES));
                jSONObject.put(Constants.VIA_REPORT_TYPE_DATALINE, apVar.b(Constants.VIA_REPORT_TYPE_DATALINE));
                jSONObject.put(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, apVar.b(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR));
                jSONObject.put("24", apVar.b("24"));
                jSONObject.put("25", apVar.b("25"));
                jSONObject.put("26", apVar.b("26"));
                jSONObject.put("27", apVar.b("27"));
                jSONObject.put(Constants.VIA_ACT_TYPE_TWENTY_EIGHT, apVar.b(Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
                jSONObject.put("29", apVar.b("29"));
                jSONObject.put(PointType.DOWNLOAD_TRACKING, apVar.b(PointType.DOWNLOAD_TRACKING));
                jSONObject.put("31", apVar.b("31"));
                jSONObject.put("32", apVar.b("32"));
                jSONObject.put("33", apVar.b("33"));
                jSONObject.put("34", apVar.b("34"));
                jSONObject.put("35", apVar.b("35"));
                jSONObject.put("36", apVar.b("36"));
                jSONObject.put("37", apVar.b("37"));
                jSONObject.put("38", apVar.b("38"));
                jSONObject.put("39", apVar.b("39"));
                jSONObject.put("40", apVar.b("40"));
                jSONObject.put("41", apVar.b("41"));
                jSONObject.put("42", apVar.b("42"));
                jSONObject.put("43", apVar.a("43"));
                jSONObject.put("44", apVar.a("44"));
                jSONObject.put(PointType.ANTI_SPAM, apVar.b(PointType.ANTI_SPAM));
                jSONObject.put(PointType.ANTI_SPAM_TOUCH, apVar.b(PointType.ANTI_SPAM_TOUCH));
                jSONObject.put("105", apVar.b("105"));
                jSONObject.put("106", apVar.b("106"));
                jSONObject.put("49", dl.b(this.f10904a));
            }
            if (a10.b(df.J, 1) == 1 && Engine.loadSuccess) {
                at atVar = new at(this.f10904a);
                jSONObject.put("45", atVar.d("45"));
                if (atVar.a()) {
                    i10 = 1;
                    jSONObject.put("93", 1);
                } else {
                    i10 = 1;
                }
                if (atVar.b()) {
                    jSONObject.put("94", i10);
                }
                jSONObject.put(AppwallTaskDetailActivity.f13149a0, atVar.d(AppwallTaskDetailActivity.f13149a0));
                jSONObject.put("48", atVar.a("48"));
                jSONObject.put("51", atVar.b("51"));
                jSONObject.put("52", atVar.a(this.f10904a, "52", 0));
                jSONObject.put("55", atVar.c("55"));
                jSONObject.put("66", atVar.a("66"));
                jSONObject.put("67", di.d());
                jSONObject.put("78", atVar.a("78"));
                jSONObject.put("79", atVar.a("79"));
                az azVar = new az(this.f10904a, 200);
                jSONObject.put("70", azVar.a("70"));
                jSONObject.put("71", azVar.a("71"));
                jSONObject.put("72", azVar.a("72"));
                jSONObject.put("73", azVar.a("73"));
                jSONObject.put("74", azVar.a("74"));
            }
            if (a10.b(df.M, 1) == 1) {
                ax axVar = new ax(this.f10904a);
                jSONObject.put("53", axVar.a(this.f10904a, "53", 1));
                jSONObject.put("56", axVar.a("56"));
                jSONObject.put("57", axVar.a("57"));
                jSONObject.put("64", di.a());
            }
            if (a10.b(df.N, 1) == 1) {
                cs csVar = new cs();
                jSONObject.put("98", csVar.a());
                jSONObject.put(PointType.WIND_ACTIVE, csVar.b());
                String d10 = am.d();
                if (!TextUtils.isEmpty(d10)) {
                    jSONObject.put("77", d10);
                }
                jSONObject.put("104", am.c());
                jSONObject.put("109", dl.e(this.f10904a));
                aj ajVar = new aj(this.f10904a);
                jSONObject.put("82", ajVar.h());
                String i11 = ajVar.i();
                if (!TextUtils.isEmpty(i11)) {
                    jSONObject.put("83", i11);
                }
                String j10 = ajVar.j();
                if (!TextUtils.isEmpty(j10)) {
                    jSONObject.put("84", j10);
                }
                String k10 = ajVar.k();
                if (!TextUtils.isEmpty(k10)) {
                    jSONObject.put("86", k10);
                }
            }
            if (a10.b(df.L, 1) == 1) {
                au auVar = new au(this.f10904a);
                jSONObject.put("95", auVar.b("95"));
                jSONObject.put("96", auVar.a() ? 1 : 0);
                jSONObject.put("97", di.e());
                try {
                    jSONObject.put("11301", bh.c(com.kwad.sdk.e.b.Kh().Kg()));
                    jSONObject.put("11302", bh.c(com.kwad.sdk.e.b.Kh().getSdkVersion()));
                    jSONObject.put("11303", bh.c(com.kwad.sdk.e.b.Kh().getAppId()));
                } catch (Throwable unused) {
                }
            }
            jSONObject.put("11006", e10 ? 1 : 0);
            jSONObject.put("11029", e11 ? 1 : 0);
            jSONObject.put("11002", Engine.soVersion);
            jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
            jSONObject.put("11017", jSONObject.toString().length());
            return jSONObject;
        } catch (Throwable unused2) {
            return null;
        }
    }

    public String a(String str) {
        JSONObject a10;
        try {
            JSONObject a11 = new cm(str, ck.f10916l).a(this.f10904a);
            if (a11 == null || (a10 = a()) == null) {
                return null;
            }
            a11.put("module_section", a10);
            return a11.toString();
        } catch (Throwable unused) {
            return null;
        }
    }
}
