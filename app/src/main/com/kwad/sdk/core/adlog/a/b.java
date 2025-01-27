package com.kwad.sdk.core.adlog.a;

import androidx.annotation.Nullable;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.h;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.bt;
import com.kwad.sdk.utils.x;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class b {
    private final c asW;
    private final List<com.kwad.sdk.core.adlog.a.a> asX;

    /* renamed from: com.kwad.sdk.core.adlog.a.b$1 */
    public class AnonymousClass1 implements com.kwad.sdk.core.c<c> {
        public AnonymousClass1() {
        }

        private static c CL() {
            return new c();
        }

        @Override // com.kwad.sdk.core.c
        public final /* synthetic */ c Ct() {
            return CL();
        }
    }

    /* renamed from: com.kwad.sdk.core.adlog.a.b$2 */
    public class AnonymousClass2 extends bd {
        public AnonymousClass2() {
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            com.kwad.sdk.core.adlog.b.CD();
        }
    }

    public static final class a {
        private static final b asZ = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b CG() {
        return a.asZ;
    }

    @Nullable
    private synchronized com.kwad.sdk.core.adlog.a.a CI() {
        if (am.H(this.asX)) {
            return null;
        }
        return this.asX.remove(0);
    }

    private boolean CK() {
        c cVar = this.asW;
        return cVar == null || !cVar.ata;
    }

    public final void CH() {
        try {
            if (CK() || am.H(this.asX)) {
                return;
            }
            bt.runOnUiThread(new bd() { // from class: com.kwad.sdk.core.adlog.a.b.2
                public AnonymousClass2() {
                }

                @Override // com.kwad.sdk.utils.bd
                public final void doTask() {
                    com.kwad.sdk.core.adlog.b.CD();
                }
            });
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    @Nullable
    public final com.kwad.sdk.core.adlog.a.a CJ() {
        com.kwad.sdk.core.adlog.a.a CI = CI();
        if (CI == null) {
            return null;
        }
        com.kwad.sdk.core.adlog.b.a.d(CI, this.asW, this.asX.size());
        long currentTimeMillis = System.currentTimeMillis() - CI.asT;
        c cVar = this.asW;
        if (currentTimeMillis <= cVar.atc * 1000) {
            CI.retryCount++;
            com.kwad.sdk.core.adlog.b.a.a(CI, cVar, this.asX.size(), currentTimeMillis);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache success：" + CI);
            return CI;
        }
        com.kwad.sdk.core.adlog.b.a.b(CI, cVar, this.asX.size(), currentTimeMillis);
        com.kwad.sdk.core.d.c.i("AdLogCacheManager", "getCache fail expired cacheTime: " + currentTimeMillis + ", adLogCache：" + CI);
        return null;
    }

    public final void a(@Nullable com.kwad.sdk.core.adlog.a.a aVar, String str, JSONObject jSONObject, com.kwad.sdk.core.adlog.c.a aVar2, int i10, String str2) {
        try {
            if (CK()) {
                return;
            }
            if (aVar == null) {
                aVar = com.kwad.sdk.core.adlog.a.a.CF().di(str).i(jSONObject).c(aVar2).am(System.currentTimeMillis());
            }
            aVar.cs(i10).dj(str2);
            com.kwad.sdk.core.adlog.b.a.a(aVar, this.asW, this.asX.size());
            int i11 = aVar.retryCount;
            c cVar = this.asW;
            if (i11 >= cVar.atb) {
                com.kwad.sdk.core.adlog.b.a.c(aVar, cVar, this.asX.size());
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache fail limit retryCount: " + aVar.retryCount + ", log: " + aVar);
                return;
            }
            if (this.asX.size() >= this.asW.atd) {
                com.kwad.sdk.core.adlog.a.a CI = CI();
                com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache limit size: " + this.asX.size() + ", remove log：" + CI);
                com.kwad.sdk.core.adlog.b.a.e(CI, this.asW, this.asX.size());
            }
            a(aVar);
            com.kwad.sdk.core.d.c.i("AdLogCacheManager", "addCache success size: " + this.asX.size() + ", log: " + aVar);
            com.kwad.sdk.core.adlog.b.a.b(aVar, this.asW, this.asX.size());
        } catch (Throwable th2) {
            ServiceProvider.reportSdkCaughtException(th2);
        }
    }

    private b() {
        this.asX = new CopyOnWriteArrayList();
        this.asW = (c) x.b(((h) ServiceProvider.get(h.class)).Am(), new com.kwad.sdk.core.c<c>() { // from class: com.kwad.sdk.core.adlog.a.b.1
            public AnonymousClass1() {
            }

            private static c CL() {
                return new c();
            }

            @Override // com.kwad.sdk.core.c
            public final /* synthetic */ c Ct() {
                return CL();
            }
        });
    }

    private synchronized void a(com.kwad.sdk.core.adlog.a.a aVar) {
        this.asX.add(aVar);
    }
}
