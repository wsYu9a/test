package com.kwad.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.InstalledAppInfoManager;
import com.kwad.sdk.utils.bp;
import com.opos.acs.st.STManager;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public final class au {
    public static String aAm = "";

    /* renamed from: com.kwad.sdk.utils.au$1 */
    static class AnonymousClass1 implements com.kwad.sdk.d.c {
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.d.a
        public final String Al() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI:" + au.j(context, true));
            return au.j(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String Am() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + au.k(context, true));
            return au.k(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String An() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getMac:" + au.l(context, true));
            return au.l(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String Ao() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + au.m(context, true));
            return au.m(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String Ap() {
            String n = au.n(context, true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + n);
            return n;
        }

        @Override // com.kwad.sdk.d.a
        public final String Aq() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMSI:" + au.o(context, true));
            return au.o(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String Ar() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + au.q(context, true));
            return au.q(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String As() {
            String bB = au.bB(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + bB);
            return bB;
        }

        @Override // com.kwad.sdk.d.a
        public final String At() {
            String bC = au.bC(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + bC);
            return bC;
        }

        @Override // com.kwad.sdk.d.a
        public final String Au() {
            String r = au.r(context, true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getWifiList:" + r);
            return r;
        }

        @Override // com.kwad.sdk.d.a
        public final String Av() {
            String t = au.t(context, true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppList:" + t);
            return t;
        }

        @Override // com.kwad.sdk.d.a
        public final String Aw() {
            String bF = au.bF(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkType:" + bF);
            return bF;
        }

        @Override // com.kwad.sdk.d.a
        public final String getAppId() {
            String bH = au.bH(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppId:" + bH);
            return bH;
        }

        @Override // com.kwad.sdk.d.a
        public final String getDeviceId() {
            String bD = au.bD(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bD);
            return bD;
        }

        @Override // com.kwad.sdk.d.a
        public final String getIccId() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIccId:" + au.p(context, true));
            return au.p(context, true);
        }

        @Override // com.kwad.sdk.d.a
        public final String getIp() {
            String bE = au.bE(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIp:" + bE);
            return bE;
        }

        @Override // com.kwad.sdk.d.a
        public final String getLocation() {
            String s = au.s(context, true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getLocation:" + s);
            return s;
        }

        @Override // com.kwad.sdk.d.a
        public final String getOaid() {
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getOaid:" + au.bA(true));
            return au.bA(true);
        }

        @Override // com.kwad.sdk.d.a
        public final String getSdkVersion() {
            String bG = au.bG(true);
            com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + bG);
            return bG;
        }
    }

    public static com.kwad.sdk.h.kwai.b Ci() {
        return com.kwad.sdk.h.kwai.b.Ci();
    }

    public static com.kwad.sdk.h.kwai.f Cj() {
        return com.kwad.sdk.h.kwai.f.Cj();
    }

    private static String Ei() {
        com.kwad.sdk.h.kwai.f Cj = com.kwad.sdk.h.kwai.f.Cj();
        int i2 = Cj != null ? Cj.axK : -1;
        if (i2 >= 0) {
            return com.kwad.sdk.d.b.a(false, String.valueOf(i2), 0);
        }
        boolean sx = ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sx();
        String valueOf = String.valueOf(i2);
        return !sx ? com.kwad.sdk.d.b.a(false, valueOf, 1) : com.kwad.sdk.d.b.a(false, valueOf, 2);
    }

    private static String Ej() {
        com.kwad.sdk.h.kwai.b Ci = com.kwad.sdk.h.kwai.b.Ci();
        return Ci != null ? com.kwad.sdk.d.b.a(false, Ci.toJson(), 0) : !((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).sz() ? com.kwad.sdk.d.b.a(false, "", 1) : com.kwad.sdk.d.b.a(false, "", 2);
    }

    public static List<com.kwad.sdk.h.kwai.e> Ek() {
        return ax.Ek();
    }

    private static String El() {
        return com.kwad.sdk.d.b.a(false, "1", 0);
    }

    private static String Em() {
        return com.kwad.sdk.d.b.a(false, String.valueOf(getSdkVersion()), 0);
    }

    private static String En() {
        return com.kwad.sdk.d.b.a(false, String.valueOf(getAppId()), 0);
    }

    static /* synthetic */ String bA(boolean z) {
        return bx(true);
    }

    static /* synthetic */ String bB(boolean z) {
        return Ei();
    }

    static /* synthetic */ String bC(boolean z) {
        return Ej();
    }

    static /* synthetic */ String bD(boolean z) {
        return by(true);
    }

    static /* synthetic */ String bE(boolean z) {
        return bz(true);
    }

    static /* synthetic */ String bF(boolean z) {
        return El();
    }

    static /* synthetic */ String bG(boolean z) {
        return Em();
    }

    static /* synthetic */ String bH(boolean z) {
        return En();
    }

    public static Location bL(Context context) {
        return r.bL(context);
    }

    private static String bx(boolean z) {
        String bI = bd.bI(z);
        if (!z) {
            return TextUtils.isEmpty(bI) ? "" : bI;
        }
        if (TextUtils.isEmpty(bI)) {
            return (at.Ec() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(2048L)) ? com.kwad.sdk.d.b.a(false, bI, 1) : com.kwad.sdk.d.b.a(false, bI, 5);
        }
        return com.kwad.sdk.d.b.a(at.Ec() && !TextUtils.isEmpty(at.Ed()), bI, 0);
    }

    private static String by(boolean z) {
        if (com.kwad.b.kwai.a.bI.booleanValue() && !TextUtils.isEmpty(be.getDeviceId())) {
            return be.getDeviceId();
        }
        String deviceId = bd.getDeviceId();
        if (!z) {
            return TextUtils.isEmpty(deviceId) ? "" : deviceId;
        }
        if (TextUtils.isEmpty(deviceId)) {
            return (at.DW() || !o.CU()) ? com.kwad.sdk.d.b.a(false, deviceId, 1) : com.kwad.sdk.d.b.a(false, deviceId, 5);
        }
        return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DZ()), deviceId, 0);
    }

    private static String bz(boolean z) {
        String ES = bd.ES();
        return !z ? TextUtils.isEmpty(ES) ? "" : ES : !TextUtils.isEmpty(ES) ? com.kwad.sdk.d.b.a(at.Ee(), ES, 0) : (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(8L)) ? com.kwad.sdk.d.b.a(false, ES, 1) : com.kwad.sdk.d.b.a(false, ES, 2);
    }

    private static String c(Context context, boolean z) {
        String u = bd.u(context, z);
        if (!z) {
            return TextUtils.isEmpty(u) ? "" : u;
        }
        if (!TextUtils.isEmpty(u)) {
            return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DX()), u, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, u, 4);
        }
        if (at.DW() || !o.CZ()) {
            return com.kwad.sdk.d.b.a(false, u, 1);
        }
        return com.kwad.sdk.d.b.a(false, u, SystemUtil.cO(context) ? 3 : 1);
    }

    public static String cl(Context context) {
        return c(context, false);
    }

    public static String cm(Context context) {
        return d(context, false);
    }

    public static String cn(Context context) {
        return e(context, false);
    }

    public static String co(Context context) {
        return f(context, false);
    }

    public static String cp(Context context) {
        return g(context, false);
    }

    public static String cq(Context context) {
        return h(context, false);
    }

    public static String cr(Context context) {
        return i(context, false);
    }

    public static int cs(Context context) {
        return bd.cV(context);
    }

    private static String ct(Context context) {
        int cV = bd.cV(context);
        if (cV > 0) {
            return com.kwad.sdk.d.b.a(false, String.valueOf(cV), 0);
        }
        int i2 = Build.VERSION.SDK_INT;
        String valueOf = String.valueOf(cV);
        return i2 < 23 ? com.kwad.sdk.d.b.a(false, valueOf, 1) : com.kwad.sdk.d.b.a(false, valueOf, 3);
    }

    public static int cu(Context context) {
        return bd.cW(context);
    }

    private static String cv(Context context) {
        List<bp.a> m = m(context, 15);
        if (m != null && m.size() > 0) {
            return com.kwad.sdk.d.b.a(at.Ee(), t.C(m), 0);
        }
        if (at.Ee() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(32L)) {
            return com.kwad.sdk.d.b.a(false, "", 1);
        }
        return com.kwad.sdk.d.b.a(false, "", bp.dd(context) ? 1 : 3);
    }

    private static String cw(Context context) {
        Map<String, InstalledAppInfoManager.AppPackageInfo> bM = InstalledAppInfoManager.bM(context);
        if (bM.size() > 0) {
            return com.kwad.sdk.d.b.a(at.Eg() && at.Eh() != null, InstalledAppInfoManager.e(bM), 0);
        }
        if (at.Eg() || !o.CX()) {
            return com.kwad.sdk.d.b.a(false, "", 1);
        }
        return com.kwad.sdk.d.b.a(false, "", bd.dc(context) ? 3 : 1);
    }

    private static String cx(Context context) {
        Location bL = r.bL(context);
        if (bL != null) {
            HashMap hashMap = new HashMap();
            hashMap.put(STManager.KEY_LATITUDE, String.valueOf(bL.getLatitude()));
            hashMap.put(STManager.KEY_LONGITUDE, String.valueOf(bL.getLongitude()));
            return com.kwad.sdk.d.b.a(at.DU() && at.DV() != null, t.parseMap2JSON(hashMap), 0);
        }
        if (at.DU() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).E(64L)) {
            return com.kwad.sdk.d.b.a(false, "", 1);
        }
        return com.kwad.sdk.d.b.a(false, "", ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.g.f9322g) == 0 ? 3 : 1);
    }

    @NonNull
    private static com.kwad.sdk.d.c cy(Context context) {
        return new com.kwad.sdk.d.c() { // from class: com.kwad.sdk.utils.au.1
            final /* synthetic */ Context jN;

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.d.a
            public final String Al() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI:" + au.j(context, true));
                return au.j(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Am() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAndroidID:" + au.k(context, true));
                return au.k(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String An() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getMac:" + au.l(context, true));
                return au.l(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ao() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + au.m(context, true));
                return au.m(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ap() {
                String n = au.n(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMEI2:" + n);
                return n;
            }

            @Override // com.kwad.sdk.d.a
            public final String Aq() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIMSI:" + au.o(context, true));
                return au.o(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String Ar() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardPhoneCount:" + au.q(context, true));
                return au.q(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String As() {
                String bB = au.bB(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSimCardActivePhoneCount:" + bB);
                return bB;
            }

            @Override // com.kwad.sdk.d.a
            public final String At() {
                String bC = au.bC(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getBaseStationInfo:" + bC);
                return bC;
            }

            @Override // com.kwad.sdk.d.a
            public final String Au() {
                String r = au.r(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getWifiList:" + r);
                return r;
            }

            @Override // com.kwad.sdk.d.a
            public final String Av() {
                String t = au.t(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppList:" + t);
                return t;
            }

            @Override // com.kwad.sdk.d.a
            public final String Aw() {
                String bF = au.bF(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkType:" + bF);
                return bF;
            }

            @Override // com.kwad.sdk.d.a
            public final String getAppId() {
                String bH = au.bH(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getAppId:" + bH);
                return bH;
            }

            @Override // com.kwad.sdk.d.a
            public final String getDeviceId() {
                String bD = au.bD(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getDeviceId:" + bD);
                return bD;
            }

            @Override // com.kwad.sdk.d.a
            public final String getIccId() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIccId:" + au.p(context, true));
                return au.p(context, true);
            }

            @Override // com.kwad.sdk.d.a
            public final String getIp() {
                String bE = au.bE(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getIp:" + bE);
                return bE;
            }

            @Override // com.kwad.sdk.d.a
            public final String getLocation() {
                String s = au.s(context, true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getLocation:" + s);
                return s;
            }

            @Override // com.kwad.sdk.d.a
            public final String getOaid() {
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getOaid:" + au.bA(true));
                return au.bA(true);
            }

            @Override // com.kwad.sdk.d.a
            public final String getSdkVersion() {
                String bG = au.bG(true);
                com.kwad.sdk.core.d.b.d("SDKPrivateSafetyDataUtil", "getSdkVersion:" + bG);
                return bG;
            }
        };
    }

    private static String d(Context context, boolean z) {
        String cm = bd.cm(context);
        if (!z) {
            return TextUtils.isEmpty(cm) ? "" : cm;
        }
        if (TextUtils.isEmpty(cm)) {
            return (at.DW() || !o.CU()) ? com.kwad.sdk.d.b.a(false, cm, 1) : com.kwad.sdk.d.b.a(false, cm, 5);
        }
        return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DZ()), cm, 0);
    }

    private static String e(Context context, boolean z) {
        String da = bd.da(context);
        if (!z) {
            return TextUtils.isEmpty(da) ? "" : da;
        }
        if (!TextUtils.isEmpty(da)) {
            return com.kwad.sdk.d.b.a(at.Ea() && !TextUtils.isEmpty(at.Eb()), da.toLowerCase(), 0);
        }
        if (at.Ea() || !o.CV()) {
            return com.kwad.sdk.d.b.a(false, da, 0);
        }
        return com.kwad.sdk.d.b.a(false, da, al.al(context, com.kuaishou.weapon.p0.g.f9319d) == 0 ? 3 : 1);
    }

    private static String f(Context context, boolean z) {
        String[] cU = bd.cU(context);
        String str = (cU == null || cU.length <= 0) ? null : cU[0];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DX()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, str, 4);
        }
        if (at.DW() || !o.CZ()) {
            return com.kwad.sdk.d.b.a(false, str, 1);
        }
        return com.kwad.sdk.d.b.a(false, str, SystemUtil.cO(context) ? 3 : 1);
    }

    private static String g(Context context, boolean z) {
        String[] cU = bd.cU(context);
        String str = (cU == null || cU.length <= 1) ? null : cU[1];
        if (!z) {
            return TextUtils.isEmpty(str) ? "" : str;
        }
        if (!TextUtils.isEmpty(str)) {
            return com.kwad.sdk.d.b.a(at.DW() && !TextUtils.isEmpty(at.DX()), str, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, str, 4);
        }
        if (at.DW() || !o.CZ()) {
            return com.kwad.sdk.d.b.a(false, str, 1);
        }
        return com.kwad.sdk.d.b.a(false, str, SystemUtil.cO(context) ? 3 : 1);
    }

    private static String getAppId() {
        return ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).getAppId();
    }

    public static String getDeviceId() {
        return by(false);
    }

    public static String getOaid() {
        return bx(false);
    }

    private static String getSdkVersion() {
        return "3.3.40";
    }

    private static String h(Context context, boolean z) {
        String cq = bd.cq(context);
        if (!z) {
            return TextUtils.isEmpty(cq) ? "" : cq;
        }
        if (!TextUtils.isEmpty(cq)) {
            return com.kwad.sdk.d.b.a(at.DW(), cq, 0);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return com.kwad.sdk.d.b.a(false, cq, 4);
        }
        if (at.DW() || !o.Da()) {
            return com.kwad.sdk.d.b.a(false, cq, 1);
        }
        return com.kwad.sdk.d.b.a(false, cq, SystemUtil.cO(context) ? 3 : 1);
    }

    private static String i(Context context, boolean z) {
        String cX = bd.cX(context);
        if (!z) {
            return TextUtils.isEmpty(cX) ? "" : cX;
        }
        if (!TextUtils.isEmpty(cX)) {
            return com.kwad.sdk.d.b.a(at.DW(), cX, 0);
        }
        if (at.DW() || !o.Db()) {
            return com.kwad.sdk.d.b.a(false, cX, 1);
        }
        return com.kwad.sdk.d.b.a(false, cX, SystemUtil.cO(context) ? 3 : 1);
    }

    public static void init(Context context) {
        com.kwad.sdk.d.b.a(cy(context));
    }

    static /* synthetic */ String j(Context context, boolean z) {
        return c(context, true);
    }

    static /* synthetic */ String k(Context context, boolean z) {
        return d(context, true);
    }

    static /* synthetic */ String l(Context context, boolean z) {
        return e(context, true);
    }

    static /* synthetic */ String m(Context context, boolean z) {
        return f(context, true);
    }

    public static List<bp.a> m(Context context, int i2) {
        return bp.m(context, 15);
    }

    static /* synthetic */ String n(Context context, boolean z) {
        return g(context, true);
    }

    static /* synthetic */ String o(Context context, boolean z) {
        return h(context, true);
    }

    static /* synthetic */ String p(Context context, boolean z) {
        return i(context, true);
    }

    static /* synthetic */ String q(Context context, boolean z) {
        return ct(context);
    }

    static /* synthetic */ String r(Context context, boolean z) {
        return cv(context);
    }

    static /* synthetic */ String s(Context context, boolean z) {
        return cx(context);
    }

    static /* synthetic */ String t(Context context, boolean z) {
        return cw(context);
    }
}
