package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ai;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes3.dex */
public final class b {
    public static final WeakHashMap<String, Integer> ayj = new WeakHashMap<>();
    private static final Map<String, Integer> ayl = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> aym = new LruHashMap(10);
    private final WeakHashMap<c, AdTemplate> ayi;
    private final Map<c, AdTemplate> ayk;
    private final com.kwad.sdk.app.a ayn;
    private volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.b$1 */
    public class AnonymousClass1 extends com.kwad.sdk.b {
        public AnonymousClass1() {
        }

        private static String l(DownloadTask downloadTask) {
            String url = downloadTask.getUrl();
            String str = (String) b.aym.get(url);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String by = ai.by(downloadTask.getUrl());
            b.aym.put(url, by);
            return by;
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void a(DownloadTask downloadTask, int i10, int i11) {
            b.this.a(l(downloadTask), i11 > 0 ? (int) ((i10 * 100.0f) / i11) : 0, i10, i11);
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void b(DownloadTask downloadTask) {
            if (downloadTask.getSmallFileSoFarBytes() == 0) {
                if (com.kwad.framework.a.a.ns.booleanValue()) {
                    com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                }
                b.this.dM(l(downloadTask));
            }
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void c(DownloadTask downloadTask) {
            b.this.dN(l(downloadTask));
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void d(DownloadTask downloadTask) {
            b.this.dP(l(downloadTask));
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void e(DownloadTask downloadTask) {
            String l10 = l(downloadTask);
            int i10 = downloadTask.downloadType;
            if (i10 != 0) {
                b.ayj.put(l10, Integer.valueOf(i10));
            }
            b.this.dO(l10);
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void f(DownloadTask downloadTask) {
            b.this.dR(l(downloadTask));
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void a(DownloadTask downloadTask) {
            b.this.O(l(downloadTask), downloadTask.getTargetFilePath());
        }

        @Override // com.kwad.sdk.b, com.kwad.sdk.a
        public final void a(DownloadTask downloadTask, Throwable th2) {
            String str;
            if (th2 != null && th2.getStackTrace().length > 0) {
                str = th2.getMessage() + " @ " + th2.getStackTrace()[0].getFileName() + th2.getStackTrace()[0].getClassName() + th2.getStackTrace()[0].getLineNumber();
            } else {
                str = "";
            }
            b.this.c(l(downloadTask), 0, str);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$10 */
    public class AnonymousClass10 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ int Lw;
        final /* synthetic */ String Lx;
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass10(String str, int i10, String str2, e eVar) {
            str = str;
            i11 = i10;
            str2 = str2;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.a(str, i11, str2, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$11 */
    public class AnonymousClass11 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass11(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.b(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$12 */
    public class AnonymousClass12 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass12(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.c(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$13 */
    public class AnonymousClass13 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass13(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.d(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$14 */
    public class AnonymousClass14 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass14(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.e(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$2 */
    public class AnonymousClass2 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String ayp;
        final /* synthetic */ e ayq;

        public AnonymousClass2(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            String oL = cVar.oL();
            b.ayl.put(oL, 12);
            cVar.b(oL, str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$3 */
    public class AnonymousClass3 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String ayp;
        final /* synthetic */ e ayq;

        public AnonymousClass3(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            String oL = cVar.oL();
            b.ayl.put(oL, 0);
            cVar.f(oL, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$4 */
    public class AnonymousClass4 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;
        final /* synthetic */ Throwable tN;

        public AnonymousClass4(String str, Throwable th2, e eVar) {
            str = str;
            th2 = th2;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.a(str, th2, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$5 */
    public class AnonymousClass5 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass5(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.g(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$6 */
    public class AnonymousClass6 implements com.kwad.sdk.app.a {
        public AnonymousClass6() {
        }

        @Override // com.kwad.sdk.app.a
        public final void Q(String str) {
            b.this.dS(str);
        }

        @Override // com.kwad.sdk.app.a
        public final void R(String str) {
            b.this.cr(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$7 */
    public class AnonymousClass7 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;

        public AnonymousClass7(String str, e eVar) {
            str = str;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.a(str, eVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$8 */
    public class AnonymousClass8 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ int ayr;
        final /* synthetic */ int ays;
        final /* synthetic */ int ayt;

        public AnonymousClass8(String str, int i10, int i11, int i12) {
            str = str;
            i10 = i10;
            i11 = i11;
            i12 = i12;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.a(str, i10, i11, i12);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.b$9 */
    public class AnonymousClass9 implements com.kwad.sdk.f.a<c> {
        final /* synthetic */ String anG;
        final /* synthetic */ e ayq;
        final /* synthetic */ String ayu;

        public AnonymousClass9(String str, String str2, e eVar) {
            str = str;
            str2 = str2;
            eVar = eVar;
        }

        @Override // com.kwad.sdk.f.a
        /* renamed from: b */
        public void accept(c cVar) {
            cVar.a(str, str2, eVar);
        }
    }

    public static final class a {
        static final b ayv = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b EI() {
        return a.ayv;
    }

    private void Q(String str) {
        b(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.2
            final /* synthetic */ String ayp;
            final /* synthetic */ e ayq;

            public AnonymousClass2(String str2, e eVar) {
                str = str2;
                eVar = eVar;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                String oL = cVar.oL();
                b.ayl.put(oL, 12);
                cVar.b(oL, str, eVar);
            }
        });
    }

    private void R(String str) {
        b(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.3
            final /* synthetic */ String ayp;
            final /* synthetic */ e ayq;

            public AnonymousClass3(String str2, e eVar) {
                str = str2;
                eVar = eVar;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                String oL = cVar.oL();
                b.ayl.put(oL, 0);
                cVar.f(oL, eVar);
            }
        });
    }

    public void cr(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        R(str);
    }

    public static int dL(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = ayl.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void dS(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        Q(str);
        com.kwad.sdk.d yW = com.kwad.sdk.c.yU().yW();
        if (yW != null) {
            yW.bY(str);
        }
    }

    public final void O(String str, String str2) {
        e eVar = new e();
        ayl.put(str, 8);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.9
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;
            final /* synthetic */ String ayu;

            public AnonymousClass9(String str3, String str22, e eVar2) {
                str = str3;
                str2 = str22;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, str2, eVar);
            }
        });
    }

    public final synchronized void bo(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.app.b.BJ().b(this.ayn);
            this.ayk.clear();
            this.mHasInit = false;
        } catch (Throwable th2) {
            com.kwad.sdk.core.d.c.printStackTraceOnly(th2);
        }
    }

    public final void c(String str, int i10, String str2) {
        ayl.put(str, 7);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.10
            final /* synthetic */ int Lw;
            final /* synthetic */ String Lx;
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass10(String str3, int i102, String str22, e eVar) {
                str = str3;
                i11 = i102;
                str2 = str22;
                eVar = eVar;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, i11, str2, eVar);
            }
        });
    }

    public final void dM(String str) {
        ayl.put(str, 1);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.7
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass7(String str2, e eVar) {
                str = str2;
                eVar = eVar;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, eVar);
            }
        });
    }

    public final void dN(String str) {
        e eVar = new e();
        ayl.put(str, 4);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.11
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass11(String str2, e eVar2) {
                str = str2;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.b(str, eVar);
            }
        });
    }

    public final void dO(String str) {
        e eVar = new e();
        ayl.put(str, 1);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.12
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass12(String str2, e eVar2) {
                str = str2;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.c(str, eVar);
            }
        });
    }

    public final void dP(String str) {
        e eVar = new e();
        ayl.put(str, 5);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.13
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass13(String str2, e eVar2) {
                str = str2;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.d(str, eVar);
            }
        });
    }

    public final void dQ(String str) {
        e eVar = new e();
        ayl.put(str, 9);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.14
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass14(String str2, e eVar2) {
                str = str2;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.e(str, eVar);
            }
        });
    }

    public final void dR(String str) {
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.5
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;

            public AnonymousClass5(String str2, e eVar) {
                str = str2;
                eVar = eVar;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.g(str, eVar);
            }
        });
    }

    public final void f(String str, Throwable th2) {
        e eVar = new e();
        ayl.put(str, 11);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.4
            final /* synthetic */ String anG;
            final /* synthetic */ e ayq;
            final /* synthetic */ Throwable tN;

            public AnonymousClass4(String str2, Throwable th22, e eVar2) {
                str = str2;
                th2 = th22;
                eVar = eVar2;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, th2, eVar);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.kwad.sdk.c.yU().a(new com.kwad.sdk.b() { // from class: com.kwad.sdk.core.download.b.1
                public AnonymousClass1() {
                }

                private static String l(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) b.aym.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String by = ai.by(downloadTask.getUrl());
                    b.aym.put(url, by);
                    return by;
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, int i10, int i11) {
                    b.this.a(l(downloadTask), i11 > 0 ? (int) ((i10 * 100.0f) / i11) : 0, i10, i11);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.framework.a.a.ns.booleanValue()) {
                            com.kwad.sdk.core.d.c.d("DownloadStatusManager", "onDownloadStart(), id=" + l(downloadTask));
                        }
                        b.this.dM(l(downloadTask));
                    }
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void c(DownloadTask downloadTask) {
                    b.this.dN(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void d(DownloadTask downloadTask) {
                    b.this.dP(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void e(DownloadTask downloadTask) {
                    String l10 = l(downloadTask);
                    int i10 = downloadTask.downloadType;
                    if (i10 != 0) {
                        b.ayj.put(l10, Integer.valueOf(i10));
                    }
                    b.this.dO(l10);
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void f(DownloadTask downloadTask) {
                    b.this.dR(l(downloadTask));
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask) {
                    b.this.O(l(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.kwad.sdk.b, com.kwad.sdk.a
                public final void a(DownloadTask downloadTask, Throwable th2) {
                    String str;
                    if (th2 != null && th2.getStackTrace().length > 0) {
                        str = th2.getMessage() + " @ " + th2.getStackTrace()[0].getFileName() + th2.getStackTrace()[0].getClassName() + th2.getStackTrace()[0].getLineNumber();
                    } else {
                        str = "";
                    }
                    b.this.c(l(downloadTask), 0, str);
                }
            });
            com.kwad.sdk.app.b.BJ().a(this.ayn);
            this.mHasInit = true;
        }
    }

    public final List<AdTemplate> zH() {
        ArrayList arrayList = new ArrayList();
        synchronized (this.ayk) {
            try {
                for (AdTemplate adTemplate : this.ayk.values()) {
                    if (adTemplate != null) {
                        arrayList.add(adTemplate);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return arrayList;
    }

    private b() {
        WeakHashMap<c, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.ayi = weakHashMap;
        this.ayk = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        this.ayn = new com.kwad.sdk.app.a() { // from class: com.kwad.sdk.core.download.b.6
            public AnonymousClass6() {
            }

            @Override // com.kwad.sdk.app.a
            public final void Q(String str) {
                b.this.dS(str);
            }

            @Override // com.kwad.sdk.app.a
            public final void R(String str) {
                b.this.cr(str);
            }
        };
    }

    private void b(String str, com.kwad.sdk.f.a<c> aVar) {
        Set<c> keySet = this.ayk.keySet();
        synchronized (this.ayk) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(str, cVar.oM())) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
            }
        }
    }

    public final void a(c cVar, AdTemplate adTemplate) {
        this.ayk.put(cVar, adTemplate);
    }

    public final void a(c cVar) {
        this.ayk.remove(cVar);
    }

    public final void a(String str, int i10, int i11, int i12) {
        ayl.put(str, 2);
        a(str, new com.kwad.sdk.f.a<c>() { // from class: com.kwad.sdk.core.download.b.8
            final /* synthetic */ String anG;
            final /* synthetic */ int ayr;
            final /* synthetic */ int ays;
            final /* synthetic */ int ayt;

            public AnonymousClass8(String str2, int i102, int i112, int i122) {
                str = str2;
                i10 = i102;
                i11 = i112;
                i12 = i122;
            }

            @Override // com.kwad.sdk.f.a
            /* renamed from: b */
            public void accept(c cVar) {
                cVar.a(str, i10, i11, i12);
            }
        });
    }

    private void a(String str, com.kwad.sdk.f.a<c> aVar) {
        Set<c> keySet = this.ayk.keySet();
        synchronized (this.ayk) {
            for (c cVar : keySet) {
                if (cVar != null && TextUtils.equals(cVar.oL(), str)) {
                    try {
                        aVar.accept(cVar);
                    } catch (Exception e10) {
                        com.kwad.sdk.core.d.c.printStackTrace(e10);
                    }
                }
            }
        }
    }
}
