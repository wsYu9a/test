package com.kwad.sdk.commercial.h;

import android.content.Context;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ksad.annotation.invoker.InvokeBy;
import com.kwad.sdk.core.c.b;
import com.kwad.sdk.core.c.d;
import com.kwad.sdk.core.d.c;
import com.kwad.sdk.h.f;
import com.kwad.sdk.h.g;
import com.kwad.sdk.h.h;
import com.kwad.sdk.m.e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ba;
import com.kwad.sdk.utils.bd;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public final class a implements com.kwad.sdk.core.d.a.a {
    private final AtomicBoolean LB;

    /* renamed from: com.kwad.sdk.commercial.h.a$1 */
    public class AnonymousClass1 implements f {
        final /* synthetic */ com.kwad.sdk.service.a.f asa;

        public AnonymousClass1(com.kwad.sdk.service.a.f fVar) {
            fVar = fVar;
        }

        @Override // com.kwad.sdk.h.f
        public final void a(String str, Map<String, String> map, String str2) {
            fVar.a(str, map, str2);
        }

        @Override // com.kwad.sdk.h.f
        public final String an(String str) {
            return fVar.an(str);
        }
    }

    /* renamed from: com.kwad.sdk.commercial.h.a$2 */
    public class AnonymousClass2 extends d {

        /* renamed from: com.kwad.sdk.commercial.h.a$2$1 */
        public class AnonymousClass1 extends bd {
            public AnonymousClass1() {
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                h.KR().KS();
            }
        }

        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToBackground() {
            super.onBackToBackground();
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        public final void onBackToForeground() {
            super.onBackToForeground();
            com.kwad.sdk.utils.h.schedule(new bd() { // from class: com.kwad.sdk.commercial.h.a.2.1
                public AnonymousClass1() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    h.KR().KS();
                }
            }, 3L, TimeUnit.SECONDS);
        }
    }

    /* renamed from: com.kwad.sdk.commercial.h.a$a */
    public static final class C0481a {
        private static final a asd = new a((byte) 0);
    }

    public /* synthetic */ a(byte b10) {
        this();
    }

    public static a Co() {
        return C0481a.asd;
    }

    @InvokeBy(invokerClass = c.class, methodId = "registerLogger")
    public static void register() {
        c.a(Co());
    }

    public final void cO(String str) {
        try {
            if (this.LB.get()) {
                return;
            }
            Context MA = ServiceProvider.MA();
            com.kwad.sdk.service.a.f fVar = (com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class);
            h.KR().a(str, g.KM().ge(ServiceProvider.MB().appId).gf(ServiceProvider.getSdkVersion()).gg(ba.getOaid()).gj(ba.cN(MA)).gh(ba.getDeviceId()).gi(ba.cO(MA)).m(fVar.zJ()).bH(com.kwad.sdk.components.g.encryptDisable()).gk(fVar.zI()).h(fVar.zL()).n(fVar.zK()), new f() { // from class: com.kwad.sdk.commercial.h.a.1
                final /* synthetic */ com.kwad.sdk.service.a.f asa;

                public AnonymousClass1(com.kwad.sdk.service.a.f fVar2) {
                    fVar = fVar2;
                }

                @Override // com.kwad.sdk.h.f
                public final void a(String str2, Map<String, String> map, String str22) {
                    fVar.a(str2, map, str22);
                }

                @Override // com.kwad.sdk.h.f
                public final String an(String str2) {
                    return fVar.an(str2);
                }
            });
            b.Fi();
            b.a(new d() { // from class: com.kwad.sdk.commercial.h.a.2

                /* renamed from: com.kwad.sdk.commercial.h.a$2$1 */
                public class AnonymousClass1 extends bd {
                    public AnonymousClass1() {
                    }

                    @Override // com.kwad.sdk.utils.bd
                    public final void doTask() {
                        h.KR().KS();
                    }
                }

                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToBackground() {
                    super.onBackToBackground();
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                public final void onBackToForeground() {
                    super.onBackToForeground();
                    com.kwad.sdk.utils.h.schedule(new bd() { // from class: com.kwad.sdk.commercial.h.a.2.1
                        public AnonymousClass1() {
                        }

                        @Override // com.kwad.sdk.utils.bd
                        public final void doTask() {
                            h.KR().KS();
                        }
                    }, 3L, TimeUnit.SECONDS);
                }
            });
            this.LB.set(true);
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void d(String str, String str2) {
        h.KR().f("d", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void e(String str, String str2) {
        h.KR().f(e.TAG, str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void i(String str, String str2) {
        h.KR().f("i", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void printStackTraceOnly(Throwable th2) {
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2) {
        h.KR().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2) {
        h.KR().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }

    private a() {
        this.LB = new AtomicBoolean(false);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void v(String str, String str2, boolean z10) {
        h.KR().f("v", str, str2);
    }

    @Override // com.kwad.sdk.core.d.a.a
    public final void w(String str, String str2, boolean z10) {
        h.KR().f(IAdInterListener.AdReqParam.WIDTH, str, str2);
    }
}
