package com.sigmob.sdk.base.services;

import com.czhj.sdk.common.ClientMetadata;

/* loaded from: classes4.dex */
public class j {

    /* renamed from: a */
    public static final String f18384a = "LocationService";

    /* renamed from: b */
    public static final String f18385b = "AppInstallService";

    /* renamed from: c */
    public static final String f18386c = "WifiScanService";

    /* renamed from: d */
    public static final String f18387d = "DownloadService";

    /* renamed from: e */
    public static a f18388e;

    /* renamed from: f */
    public static a f18389f;

    /* renamed from: g */
    public static a f18390g;

    /* renamed from: h */
    public static a f18391h;

    public interface a {
        boolean a();

        void b();

        k c();

        Error d();
    }

    public static synchronized a a(String str) {
        char c10;
        synchronized (j.class) {
            try {
                str.hashCode();
                switch (str.hashCode()) {
                    case -967662845:
                        if (str.equals(f18386c)) {
                            c10 = 0;
                            break;
                        }
                        c10 = 65535;
                        break;
                    case 353926395:
                        if (!str.equals(f18385b)) {
                            c10 = 65535;
                            break;
                        } else {
                            c10 = 1;
                            break;
                        }
                    case 854806816:
                        if (!str.equals(f18384a)) {
                            c10 = 65535;
                            break;
                        } else {
                            c10 = 2;
                            break;
                        }
                    case 1382229229:
                        if (!str.equals(f18387d)) {
                            c10 = 65535;
                            break;
                        } else {
                            c10 = 3;
                            break;
                        }
                    default:
                        c10 = 65535;
                        break;
                }
                if (c10 == 0) {
                    a aVar = f18390g;
                    if (aVar != null) {
                        return aVar;
                    }
                    l lVar = new l();
                    f18390g = lVar;
                    return lVar;
                }
                if (c10 == 1) {
                    a aVar2 = f18389f;
                    if (aVar2 != null) {
                        return aVar2;
                    }
                    b bVar = new b();
                    f18389f = bVar;
                    return bVar;
                }
                if (c10 == 2) {
                    a aVar3 = f18388e;
                    if (aVar3 != null) {
                        return aVar3;
                    }
                    e eVar = new e();
                    f18388e = eVar;
                    return eVar;
                }
                if (c10 != 3) {
                    return null;
                }
                a aVar4 = f18391h;
                if (aVar4 != null) {
                    return aVar4;
                }
                d dVar = new d();
                f18391h = dVar;
                return dVar;
            } finally {
            }
        }
    }

    public static a b() {
        return f18391h;
    }

    public static a c() {
        return f18388e;
    }

    public static a d() {
        return f18390g;
    }

    public static a a() {
        return f18389f;
    }

    public static void a(String str, boolean z10) {
        a aVar;
        str.hashCode();
        switch (str) {
            case "WifiScanService":
                if (!z10) {
                    aVar = f18390g;
                    if (aVar == null) {
                    }
                    aVar.b();
                    break;
                }
                a(str).a();
                break;
            case "AppInstallService":
                if (!z10) {
                    aVar = f18389f;
                    if (aVar == null) {
                    }
                    aVar.b();
                    break;
                }
                a(str).a();
                break;
            case "LocationService":
                if (z10) {
                    a(str).a();
                } else {
                    a aVar2 = f18388e;
                    if (aVar2 != null) {
                        aVar2.b();
                    }
                }
                ClientMetadata.getInstance().setEnableLocation(z10);
                break;
            case "DownloadService":
                if (!z10) {
                    aVar = f18391h;
                    if (aVar == null) {
                    }
                    aVar.b();
                    break;
                }
                a(str).a();
                break;
        }
    }
}
