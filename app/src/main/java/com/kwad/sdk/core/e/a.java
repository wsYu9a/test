package com.kwad.sdk.core.e;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.kwad.sdk.core.e.kwai.b;
import com.kwad.sdk.core.e.kwai.c;
import com.kwad.sdk.core.e.kwai.d;
import com.kwad.sdk.core.e.kwai.e;
import com.kwad.sdk.core.e.kwai.g;
import com.kwad.sdk.core.e.kwai.h;
import com.kwad.sdk.core.e.kwai.i;
import com.kwad.sdk.core.e.kwai.j;
import com.kwad.sdk.oaid.OADIDSDKHelper;
import com.kwad.sdk.oaid.OADIDSDKHelper25;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.f;
import com.kwad.sdk.utils.at;
import com.kwad.sdk.utils.aw;

/* loaded from: classes2.dex */
public final class a {
    private static String ahA = "";
    private static boolean ahB = false;
    private static boolean sGetOaidFail = false;

    /* renamed from: com.kwad.sdk.core.e.a$1 */
    static class AnonymousClass1 extends aw {
        final /* synthetic */ Context jN;

        /* renamed from: com.kwad.sdk.core.e.a$1$1 */
        final class C02141 implements OADIDSDKHelper.a {
            C02141() {
            }

            @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
            public final void cw(String str) {
                String unused = a.ahA = str;
                a.mz();
            }
        }

        /* renamed from: com.kwad.sdk.core.e.a$1$2 */
        final class AnonymousClass2 implements OADIDSDKHelper25.a {
            AnonymousClass2() {
            }

            @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
            public final void cw(String str) {
                String unused = a.ahA = str;
                a.mz();
            }
        }

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            a.aS(context);
            if (OADIDSDKHelper.isSupport()) {
                OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                    C02141() {
                    }

                    @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                    public final void cw(String str) {
                        String unused = a.ahA = str;
                        a.mz();
                    }
                });
            } else if (OADIDSDKHelper25.isSupport()) {
                OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                    AnonymousClass2() {
                    }

                    @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                    public final void cw(String str) {
                        String unused = a.ahA = str;
                        a.mz();
                    }
                });
            }
        }
    }

    public static String aR(Context context) {
        if (at.Ec() && !TextUtils.isEmpty(at.Ed())) {
            return at.Ed();
        }
        if (!TextUtils.isEmpty(ahA)) {
            return ahA;
        }
        if (at.Ec() || ((f) ServiceProvider.get(f.class)).E(2048L)) {
            return ahA;
        }
        initAsync(context);
        return ahA;
    }

    public static void aS(Context context) {
        String oaid;
        if (!TextUtils.isEmpty(ahA) || context == null || ahB) {
            return;
        }
        ahB = true;
        if (sGetOaidFail) {
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            String upperCase = Build.MANUFACTURER.toUpperCase();
            switch (upperCase) {
                case "HUAWEI":
                    oaid = new b(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "XIAOMI":
                case "BLACKSHARK":
                    oaid = new i(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "OPPO":
                case "ONEPLUS":
                    oaid = new com.kwad.sdk.core.e.kwai.f(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "VIVO":
                    oaid = new h(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "LENOVO":
                case "MOTOLORA":
                    oaid = new c(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "MEIZU":
                    oaid = new d(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "NUBIA":
                    oaid = new e(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "SAMSUNG":
                    oaid = new g(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "ASUS":
                    oaid = new com.kwad.sdk.core.e.kwai.a(applicationContext).getOAID();
                    ahA = oaid;
                    break;
                case "ZTE":
                case "FERRMEOS":
                case "SSUI":
                    oaid = new j(applicationContext).getOAID();
                    ahA = oaid;
                    break;
            }
            com.kwad.sdk.core.d.b.i("OAIDHelper", "manufacturer:" + upperCase + "--OAID:" + ahA);
            if (TextUtils.isEmpty(ahA)) {
                sGetOaidFail = true;
            }
            ahB = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public static void initAsync(Context context) {
        if (!TextUtils.isEmpty(ahA) || context == null) {
            return;
        }
        com.kwad.sdk.utils.g.execute(new aw() { // from class: com.kwad.sdk.core.e.a.1
            final /* synthetic */ Context jN;

            /* renamed from: com.kwad.sdk.core.e.a$1$1 */
            final class C02141 implements OADIDSDKHelper.a {
                C02141() {
                }

                @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                public final void cw(String str) {
                    String unused = a.ahA = str;
                    a.mz();
                }
            }

            /* renamed from: com.kwad.sdk.core.e.a$1$2 */
            final class AnonymousClass2 implements OADIDSDKHelper25.a {
                AnonymousClass2() {
                }

                @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                public final void cw(String str) {
                    String unused = a.ahA = str;
                    a.mz();
                }
            }

            AnonymousClass1(Context context2) {
                context = context2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                a.aS(context);
                if (OADIDSDKHelper.isSupport()) {
                    OADIDSDKHelper.getOAId(context, new OADIDSDKHelper.a() { // from class: com.kwad.sdk.core.e.a.1.1
                        C02141() {
                        }

                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper.a
                        public final void cw(String str) {
                            String unused = a.ahA = str;
                            a.mz();
                        }
                    });
                } else if (OADIDSDKHelper25.isSupport()) {
                    OADIDSDKHelper25.getOAId(context, new OADIDSDKHelper25.a() { // from class: com.kwad.sdk.core.e.a.1.2
                        AnonymousClass2() {
                        }

                        @Override // com.kwad.sdk.oaid.OADIDSDKHelper25.a
                        public final void cw(String str) {
                            String unused = a.ahA = str;
                            a.mz();
                        }
                    });
                }
            }
        });
    }

    static /* synthetic */ void mz() {
    }
}
