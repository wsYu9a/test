package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.core.e.a.b;
import com.kwad.sdk.core.e.a.d;
import com.kwad.sdk.core.e.a.f;
import com.kwad.sdk.core.e.a.g;
import com.kwad.sdk.core.e.a.h;
import com.kwad.sdk.core.e.a.i;
import com.kwad.sdk.core.e.a.j;
import com.kwad.sdk.core.e.a.k;
import com.kwad.sdk.core.e.a.l;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.q;
import com.martian.ads.ad.AdConfig;
import java.util.concurrent.atomic.AtomicBoolean;
import ke.e;

/* loaded from: classes3.dex */
public final class a {
    private static String aAY = "";
    private static final AtomicBoolean aAZ = new AtomicBoolean();
    private static final AtomicBoolean aBa = new AtomicBoolean();
    private static boolean sGetOaidFail = false;

    /* renamed from: com.kwad.sdk.core.e.a$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ Context hB;

        /* renamed from: com.kwad.sdk.core.e.a$1$1 */
        public class C04931 implements OADIDSDKHelper.a {
            public C04931() {
            }

            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
            public final void ey(String str) {
                String unused = a.aAY = str;
                a.ev(str);
                a.Ga();
            }
        }

        /* renamed from: com.kwad.sdk.core.e.a$1$2 */
        public class AnonymousClass2 implements OADIDSDKHelper25.a {
            public AnonymousClass2() {
            }

            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
            public final void ey(String str) {
                String unused = a.aAY = str;
                a.ev(str);
                a.Ga();
            }
        }

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            String unused = a.aAY = a.FY();
            if (TextUtils.isEmpty(a.aAY)) {
                a.bu(context);
                if (OADIDSDKHelper.isSupport()) {
                    OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                        public C04931() {
                        }

                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                        public final void ey(String str) {
                            String unused2 = a.aAY = str;
                            a.ev(str);
                            a.Ga();
                        }
                    });
                } else if (OADIDSDKHelper25.isSupport()) {
                    OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                        public AnonymousClass2() {
                        }

                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                        public final void ey(String str) {
                            String unused2 = a.aAY = str;
                            a.ev(str);
                            a.Ga();
                        }
                    });
                }
                a.aAZ.set(false);
            }
        }
    }

    public static String FY() {
        if (aBa.getAndSet(true)) {
            return aAY;
        }
        String h10 = ad.h("ksadsdk_pref", "kasd_oaid_key", "");
        aAY = h10;
        return h10;
    }

    public static /* synthetic */ void Ga() {
    }

    public static String bt(Context context) {
        if (az.Oi() && !TextUtils.isEmpty(az.Oj())) {
            return az.Oj();
        }
        if (!TextUtils.isEmpty(aAY)) {
            return aAY;
        }
        if (!az.Oi() && q.MX()) {
            initAsync(context);
            return aAY;
        }
        String FY = FY();
        aAY = FY;
        return FY;
    }

    public static void bu(Context context) {
        char c10;
        if (!TextUtils.isEmpty(aAY) || context == null || sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase.hashCode()) {
                case -2053026509:
                    if (upperCase.equals("LENOVO")) {
                        c10 = 7;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1712043046:
                    if (upperCase.equals("SAMSUNG")) {
                        c10 = 11;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1706170181:
                    if (upperCase.equals("XIAOMI")) {
                        c10 = 2;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -1134767290:
                    if (upperCase.equals("BLACKSHARK")) {
                        c10 = 3;
                        break;
                    }
                    c10 = 65535;
                    break;
                case -602397472:
                    if (upperCase.equals("ONEPLUS")) {
                        c10 = 5;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 89163:
                    if (upperCase.equals("ZTE")) {
                        c10 = '\r';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2018896:
                    if (upperCase.equals("ASUS")) {
                        c10 = '\f';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2432928:
                    if (upperCase.equals("OPPO")) {
                        c10 = 4;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2555124:
                    if (upperCase.equals("SSUI")) {
                        c10 = 15;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2634924:
                    if (upperCase.equals(AdConfig.UnionType.VIVO)) {
                        c10 = 6;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 68924490:
                    if (upperCase.equals(e.f27805c)) {
                        c10 = 1;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 73239724:
                    if (upperCase.equals("MEIZU")) {
                        c10 = '\t';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 74632627:
                    if (upperCase.equals("NUBIA")) {
                        c10 = '\n';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 630905871:
                    if (upperCase.equals("MOTOLORA")) {
                        c10 = '\b';
                        break;
                    }
                    c10 = 65535;
                    break;
                case 976565563:
                    if (upperCase.equals("FERRMEOS")) {
                        c10 = 14;
                        break;
                    }
                    c10 = 65535;
                    break;
                case 2141820391:
                    if (upperCase.equals(e.f27804b)) {
                        c10 = 0;
                        break;
                    }
                    c10 = 65535;
                    break;
                default:
                    c10 = 65535;
                    break;
            }
            switch (c10) {
                case 0:
                    aAY = new d(applicationContext).getOAID();
                    break;
                case 1:
                    aAY = new b(applicationContext).getOAID();
                    break;
                case 2:
                case 3:
                    aAY = new k(applicationContext).getOAID();
                    break;
                case 4:
                case 5:
                    aAY = new h(applicationContext).getOAID();
                    break;
                case 6:
                    aAY = new j(applicationContext).getOAID();
                    break;
                case 7:
                case '\b':
                    aAY = new com.kwad.sdk.core.e.a.e(applicationContext).getOAID();
                    break;
                case '\t':
                    aAY = new f(applicationContext).getOAID();
                    break;
                case '\n':
                    aAY = new g(applicationContext).getOAID();
                    break;
                case 11:
                    aAY = new i(applicationContext).getOAID();
                    break;
                case '\f':
                    aAY = new com.kwad.sdk.core.e.a.a(applicationContext).getOAID();
                    break;
                case '\r':
                case 14:
                case 15:
                    aAY = new l(applicationContext).getOAID();
                    break;
            }
            c.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + aAY);
            if (TextUtils.isEmpty(aAY)) {
                sGetOaidFail = true;
            }
            ev(aAY);
        } catch (Throwable th2) {
            c.printStackTraceOnly(th2);
        }
    }

    public static void ev(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ad.g("ksadsdk_pref", "kasd_oaid_key", str);
    }

    private static void initAsync(Context context) {
        if (context == null || aAZ.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.core.e.a.1
            final /* synthetic */ Context hB;

            /* renamed from: com.kwad.sdk.core.e.a$1$1 */
            public class C04931 implements OADIDSDKHelper.a {
                public C04931() {
                }

                @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                public final void ey(String str) {
                    String unused2 = a.aAY = str;
                    a.ev(str);
                    a.Ga();
                }
            }

            /* renamed from: com.kwad.sdk.core.e.a$1$2 */
            public class AnonymousClass2 implements OADIDSDKHelper25.a {
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                public final void ey(String str) {
                    String unused2 = a.aAY = str;
                    a.ev(str);
                    a.Ga();
                }
            }

            public AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                String unused = a.aAY = a.FY();
                if (TextUtils.isEmpty(a.aAY)) {
                    a.bu(context);
                    if (OADIDSDKHelper.isSupport()) {
                        OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                            public C04931() {
                            }

                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                            public final void ey(String str) {
                                String unused2 = a.aAY = str;
                                a.ev(str);
                                a.Ga();
                            }
                        });
                    } else if (OADIDSDKHelper25.isSupport()) {
                        OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                            public AnonymousClass2() {
                            }

                            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                            public final void ey(String str) {
                                String unused2 = a.aAY = str;
                                a.ev(str);
                                a.Ga();
                            }
                        });
                    }
                    a.aAZ.set(false);
                }
            }
        });
    }
}
