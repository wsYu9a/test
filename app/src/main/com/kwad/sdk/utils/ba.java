package com.kwad.sdk.utils;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.offline.api.BuildConfig;
import com.kwad.sdk.app.AppPackageInfo;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ca;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public final class ba {
    public static String aUo = "";

    /* renamed from: com.kwad.sdk.utils.ba$1 */
    public class AnonymousClass1 implements com.kwad.sdk.e.c {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.e.a
        public final String JV() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + ba.j(context, true));
            return ba.j(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String JW() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + ba.k(context, true));
            return ba.k(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String JX() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + ba.l(context, true));
            return ba.l(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String JY() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + ba.m(context, true));
            return ba.m(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String JZ() {
            String n10 = ba.n(context, true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + n10);
            return n10;
        }

        @Override // com.kwad.sdk.e.a
        public final String Ka() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + ba.o(context, true));
            return ba.o(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String Kb() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + ba.q(context, true));
            return ba.q(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String Kc() {
            String bZ = ba.bZ(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + bZ);
            return bZ;
        }

        @Override // com.kwad.sdk.e.a
        public final String Kd() {
            String ca2 = ba.ca(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + ca2);
            return ca2;
        }

        @Override // com.kwad.sdk.e.a
        public final String Ke() {
            String r10 = ba.r(context, true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + r10);
            return r10;
        }

        @Override // com.kwad.sdk.e.a
        public final String Kf() {
            String t10 = ba.t(context, true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + t10);
            return t10;
        }

        @Override // com.kwad.sdk.e.a
        public final String Kg() {
            String cd2 = ba.cd(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + cd2);
            return cd2;
        }

        @Override // com.kwad.sdk.e.a
        public final String getAppId() {
            String cf2 = ba.cf(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + cf2);
            return cf2;
        }

        @Override // com.kwad.sdk.e.a
        public final String getDeviceId() {
            String cb2 = ba.cb(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + cb2);
            return cb2;
        }

        @Override // com.kwad.sdk.e.a
        public final String getIccId() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + ba.p(context, true));
            return ba.p(context, true);
        }

        @Override // com.kwad.sdk.e.a
        public final String getIp() {
            String cc2 = ba.cc(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + cc2);
            return cc2;
        }

        @Override // com.kwad.sdk.e.a
        public final String getLocation() {
            String s10 = ba.s(context, true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + s10);
            return s10;
        }

        @Override // com.kwad.sdk.e.a
        public final String getOaid() {
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + ba.bY(true));
            return ba.bY(true);
        }

        @Override // com.kwad.sdk.e.a
        public final String getSdkVersion() {
            String ce2 = ba.ce(true);
            com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + ce2);
            return ce2;
        }
    }

    public static com.kwad.sdk.k.a.b Mk() {
        return com.kwad.sdk.k.a.b.Mk();
    }

    public static com.kwad.sdk.k.a.f Ml() {
        return com.kwad.sdk.k.a.f.Ml();
    }

    private static String Oq() {
        com.kwad.sdk.k.a.f Ml = com.kwad.sdk.k.a.f.Ml();
        int i10 = Ml != null ? Ml.aRx : -1;
        return i10 >= 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(i10), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zM() ? com.kwad.sdk.e.b.a(false, String.valueOf(i10), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(i10), 2);
    }

    private static String Or() {
        com.kwad.sdk.k.a.b Mk = com.kwad.sdk.k.a.b.Mk();
        return Mk != null ? com.kwad.sdk.e.b.a(false, Mk.toJson(), 0) : !((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).zO() ? com.kwad.sdk.e.b.a(false, "", 1) : com.kwad.sdk.e.b.a(false, "", 2);
    }

    private static String Os() {
        return com.kwad.sdk.e.b.a(false, "1", 0);
    }

    private static String Ot() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String Ou() {
        return com.kwad.sdk.e.b.a(false, String.valueOf(getAppId()), 0);
    }

    private static String bV(boolean z10) {
        String cg2 = bo.cg(z10);
        if (!z10) {
            return TextUtils.isEmpty(cg2) ? "" : cg2;
        }
        if (TextUtils.isEmpty(cg2)) {
            return (az.Oi() || !q.MX()) ? com.kwad.sdk.e.b.a(false, cg2, 1) : com.kwad.sdk.e.b.a(false, cg2, 5);
        }
        return com.kwad.sdk.e.b.a(az.Oi() && !TextUtils.isEmpty(az.Oj()), cg2, 0);
    }

    private static String bW(boolean z10) {
        if (com.kwad.framework.a.a.ns.booleanValue() && !TextUtils.isEmpty(bp.getDeviceId())) {
            return bp.getDeviceId();
        }
        String deviceId = bo.getDeviceId();
        if (!z10) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (az.usePhoneStateDisable() || !q.MV()) ? com.kwad.sdk.e.b.a(false, deviceId, 1) : com.kwad.sdk.e.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.e.b.a(az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Of()), deviceId, 0);
    }

    private static String bX(boolean z10) {
        String Pj = bo.Pj();
        return !z10 ? TextUtils.isEmpty(Pj) ? "" : Pj : !TextUtils.isEmpty(Pj) ? com.kwad.sdk.e.b.a(az.Ok(), Pj, 0) : (az.Ok() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(8L)) ? com.kwad.sdk.e.b.a(false, Pj, 1) : com.kwad.sdk.e.b.a(false, Pj, 2);
    }

    public static /* synthetic */ String bY(boolean z10) {
        return bV(true);
    }

    public static /* synthetic */ String bZ(boolean z10) {
        return Oq();
    }

    private static String c(Context context, boolean z10) {
        String u10 = bo.u(context, z10);
        if (!z10) {
            return TextUtils.isEmpty(u10) ? "" : u10;
        }
        if (!TextUtils.isEmpty(u10)) {
            return com.kwad.sdk.e.b.a(az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Od()), u10, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, u10, 4);
        }
        if (az.usePhoneStateDisable() || !q.Nb()) {
            return com.kwad.sdk.e.b.a(false, u10, 1);
        }
        return com.kwad.sdk.e.b.a(false, u10, SystemUtil.m41do(context) ? 3 : 1);
    }

    public static String cN(Context context) {
        return c(context, false);
    }

    public static String cO(Context context) {
        return d(context, false);
    }

    public static String cP(Context context) {
        return e(context, false);
    }

    public static String cQ(Context context) {
        return f(context, false);
    }

    public static String cR(Context context) {
        return g(context, false);
    }

    public static String cS(Context context) {
        return h(context, false);
    }

    public static String cT(Context context) {
        return i(context, false);
    }

    public static int cU(Context context) {
        return bo.dv(context);
    }

    private static String cV(Context context) {
        int dv = bo.dv(context);
        return dv > 0 ? com.kwad.sdk.e.b.a(false, String.valueOf(dv), 0) : Build.VERSION.SDK_INT < 23 ? com.kwad.sdk.e.b.a(false, String.valueOf(dv), 1) : com.kwad.sdk.e.b.a(false, String.valueOf(dv), 3);
    }

    public static int cW(Context context) {
        return bo.dw(context);
    }

    private static String cX(Context context) {
        List<ca.a> o10 = o(context, 15);
        if (o10 != null && o10.size() > 0) {
            return com.kwad.sdk.e.b.a(az.Ok(), x.N(o10), 0);
        }
        if (az.Ok() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(32L)) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", ca.dD(context) ? 1 : 3);
    }

    private static Map<String, AppPackageInfo> cY(Context context) {
        com.kwad.sdk.components.o oVar = (com.kwad.sdk.components.o) com.kwad.sdk.components.d.f(com.kwad.sdk.components.o.class);
        return (oVar == null || !q.MZ()) ? new HashMap() : oVar.M(context);
    }

    private static String cZ(Context context) {
        com.kwad.sdk.core.c.b.Fi();
        if (!com.kwad.sdk.core.c.b.isAppOnForeground()) {
            return com.kwad.sdk.e.b.a(false, "", 5);
        }
        Map<String, AppPackageInfo> cY = cY(context);
        if (cY.size() > 0) {
            boolean z10 = az.Om() && az.On() != null;
            com.kwad.sdk.components.o oVar = (com.kwad.sdk.components.o) com.kwad.sdk.components.d.f(com.kwad.sdk.components.o.class);
            if (oVar != null && q.MZ()) {
                return com.kwad.sdk.e.b.a(z10, oVar.c(cY), 0);
            }
        }
        if (az.Om() || !q.MZ()) {
            return com.kwad.sdk.e.b.a(false, "", 1);
        }
        return com.kwad.sdk.e.b.a(false, "", bo.dC(context) ? 3 : 1);
    }

    public static /* synthetic */ String ca(boolean z10) {
        return Or();
    }

    public static /* synthetic */ String cb(boolean z10) {
        return bW(true);
    }

    public static /* synthetic */ String cc(boolean z10) {
        return bX(true);
    }

    public static /* synthetic */ String cd(boolean z10) {
        return Os();
    }

    public static /* synthetic */ String ce(boolean z10) {
        return Ot();
    }

    public static /* synthetic */ String cf(boolean z10) {
        return Ou();
    }

    public static com.kwad.sdk.utils.c.a cm(Context context) {
        return v.cm(context);
    }

    private static String d(Context context, boolean z10) {
        String cO = bo.cO(context);
        if (!z10) {
            return TextUtils.isEmpty(cO) ? "" : cO;
        }
        if (TextUtils.isEmpty(cO)) {
            return (az.usePhoneStateDisable() || !q.MV()) ? com.kwad.sdk.e.b.a(false, cO, 1) : com.kwad.sdk.e.b.a(false, cO, 5);
        }
        return com.kwad.sdk.e.b.a(az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Of()), cO, 0);
    }

    private static String da(Context context) {
        com.kwad.sdk.utils.c.a cm = v.cm(context);
        if (cm == null || cm.aWW == null) {
            if (az.Ob() || ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).ac(64L)) {
                return com.kwad.sdk.e.b.a(false, "", 1);
            }
            return com.kwad.sdk.e.b.a(false, "", ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f11106g) == 0 ? 3 : 1);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("latitude", String.valueOf(cm.aWW.getLatitude()));
        hashMap.put("longitude", String.valueOf(cm.aWW.getLongitude()));
        return com.kwad.sdk.e.b.a(az.Ob() && az.Oc() != null, x.parseMap2JSON(hashMap), 0);
    }

    @NonNull
    private static com.kwad.sdk.e.c db(Context context) {
        return new com.kwad.sdk.e.c() { // from class: com.kwad.sdk.utils.ba.1
            final /* synthetic */ Context hB;

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.e.a
            public final String JV() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI:" + ba.j(context, true));
                return ba.j(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String JW() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + ba.k(context, true));
                return ba.k(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String JX() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getMac:" + ba.l(context, true));
                return ba.l(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String JY() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + ba.m(context, true));
                return ba.m(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String JZ() {
                String n10 = ba.n(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + n10);
                return n10;
            }

            @Override // com.kwad.sdk.e.a
            public final String Ka() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIMSI:" + ba.o(context, true));
                return ba.o(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Kb() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + ba.q(context, true));
                return ba.q(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String Kc() {
                String bZ = ba.bZ(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + bZ);
                return bZ;
            }

            @Override // com.kwad.sdk.e.a
            public final String Kd() {
                String ca2 = ba.ca(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + ca2);
                return ca2;
            }

            @Override // com.kwad.sdk.e.a
            public final String Ke() {
                String r10 = ba.r(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getWifiList:" + r10);
                return r10;
            }

            @Override // com.kwad.sdk.e.a
            public final String Kf() {
                String t10 = ba.t(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppList:" + t10);
                return t10;
            }

            @Override // com.kwad.sdk.e.a
            public final String Kg() {
                String cd2 = ba.cd(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkType:" + cd2);
                return cd2;
            }

            @Override // com.kwad.sdk.e.a
            public final String getAppId() {
                String cf2 = ba.cf(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getAppId:" + cf2);
                return cf2;
            }

            @Override // com.kwad.sdk.e.a
            public final String getDeviceId() {
                String cb2 = ba.cb(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + cb2);
                return cb2;
            }

            @Override // com.kwad.sdk.e.a
            public final String getIccId() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIccId:" + ba.p(context, true));
                return ba.p(context, true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getIp() {
                String cc2 = ba.cc(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getIp:" + cc2);
                return cc2;
            }

            @Override // com.kwad.sdk.e.a
            public final String getLocation() {
                String s10 = ba.s(context, true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getLocation:" + s10);
                return s10;
            }

            @Override // com.kwad.sdk.e.a
            public final String getOaid() {
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getOaid:" + ba.bY(true));
                return ba.bY(true);
            }

            @Override // com.kwad.sdk.e.a
            public final String getSdkVersion() {
                String ce2 = ba.ce(true);
                com.kwad.sdk.core.d.c.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + ce2);
                return ce2;
            }
        };
    }

    private static String e(Context context, boolean z10) {
        String dA = bo.dA(context);
        if (!z10) {
            return TextUtils.isEmpty(dA) ? "" : dA;
        }
        if (!TextUtils.isEmpty(dA)) {
            return com.kwad.sdk.e.b.a(az.Og() && !TextUtils.isEmpty(az.Oh()), dA.toLowerCase(), 0);
        }
        if (az.Og() || !q.MW()) {
            return com.kwad.sdk.e.b.a(false, dA, 0);
        }
        return com.kwad.sdk.e.b.a(false, dA, ar.ar(context, com.kuaishou.weapon.p0.g.f11103d) == 0 ? 3 : 1);
    }

    private static String f(Context context, boolean z10) {
        String[] du = bo.du(context);
        String str = (du == null || du.length <= 0) ? null : du[0];
        if (!z10) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Od()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (az.usePhoneStateDisable() || !q.Nb()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.m41do(context) ? 3 : 1);
    }

    private static String g(Context context, boolean z10) {
        String[] du = bo.du(context);
        String str = (du == null || du.length <= 1) ? null : du[1];
        if (!z10) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.e.b.a(az.usePhoneStateDisable() && !TextUtils.isEmpty(az.Od()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, str, 4);
        }
        if (az.usePhoneStateDisable() || !q.Nb()) {
            return com.kwad.sdk.e.b.a(false, str, 1);
        }
        return com.kwad.sdk.e.b.a(false, str, SystemUtil.m41do(context) ? 3 : 1);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppId();
    }

    public static String getDeviceId() {
        return bW(false);
    }

    public static String getOaid() {
        return bV(false);
    }

    private static String getSdkVersion() {
        return BuildConfig.VERSION_NAME;
    }

    private static String h(Context context, boolean z10) {
        String cS = bo.cS(context);
        if (!z10) {
            return TextUtils.isEmpty(cS) ? "" : cS;
        }
        if (!TextUtils.isEmpty(cS)) {
            return com.kwad.sdk.e.b.a(az.usePhoneStateDisable(), cS, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.e.b.a(false, cS, 4);
        }
        if (az.usePhoneStateDisable() || !q.Nc()) {
            return com.kwad.sdk.e.b.a(false, cS, 1);
        }
        return com.kwad.sdk.e.b.a(false, cS, SystemUtil.m41do(context) ? 3 : 1);
    }

    private static String i(Context context, boolean z10) {
        String dx = bo.dx(context);
        if (!z10) {
            return TextUtils.isEmpty(dx) ? "" : dx;
        }
        if (!TextUtils.isEmpty(dx)) {
            return com.kwad.sdk.e.b.a(az.usePhoneStateDisable(), dx, 0);
        }
        if (az.usePhoneStateDisable() || !q.Nd()) {
            return com.kwad.sdk.e.b.a(false, dx, 1);
        }
        return com.kwad.sdk.e.b.a(false, dx, SystemUtil.m41do(context) ? 3 : 1);
    }

    public static void init(Context context) {
        com.kwad.sdk.e.b.a(db(context));
    }

    public static /* synthetic */ String j(Context context, boolean z10) {
        return c(context, true);
    }

    public static /* synthetic */ String k(Context context, boolean z10) {
        return d(context, true);
    }

    public static /* synthetic */ String l(Context context, boolean z10) {
        return e(context, true);
    }

    public static /* synthetic */ String m(Context context, boolean z10) {
        return f(context, true);
    }

    public static /* synthetic */ String n(Context context, boolean z10) {
        return g(context, true);
    }

    public static /* synthetic */ String o(Context context, boolean z10) {
        return h(context, true);
    }

    public static /* synthetic */ String p(Context context, boolean z10) {
        return i(context, true);
    }

    public static /* synthetic */ String q(Context context, boolean z10) {
        return cV(context);
    }

    public static /* synthetic */ String r(Context context, boolean z10) {
        return cX(context);
    }

    public static /* synthetic */ String s(Context context, boolean z10) {
        return da(context);
    }

    public static /* synthetic */ String t(Context context, boolean z10) {
        return cZ(context);
    }

    public static List<ca.a> o(Context context, int i10) {
        return ca.o(context, 15);
    }
}
