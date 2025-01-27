package com.kwad.sdk.core.download;

import android.content.Context;
import android.text.TextUtils;
import com.ksad.download.DownloadTask;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.LruHashMap;
import com.kwad.sdk.utils.ad;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* loaded from: classes2.dex */
public final class c {
    private static final Map<String, Integer> aeY = Collections.synchronizedMap(new LruHashMap(10));
    private static final Map<String, String> afb = new LruHashMap(10);
    private final WeakHashMap<d, AdTemplate> aeW;
    private final Map<d, AdTemplate> aeX;
    private final HashMap<String, AdTemplate> aeZ;
    private final Map<String, AdTemplate> afa;
    private final com.kwad.sdk.a.a afc;
    private volatile boolean mHasInit;

    /* renamed from: com.kwad.sdk.core.download.c$1 */
    final class AnonymousClass1 extends com.ksad.download.b {
        AnonymousClass1() {
        }

        private static String m(DownloadTask downloadTask) {
            String url = downloadTask.getUrl();
            String str = (String) c.afb.get(url);
            if (!TextUtils.isEmpty(str)) {
                return str;
            }
            String eC = ad.eC(downloadTask.getUrl());
            c.afb.put(url, eC);
            return eC;
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void a(DownloadTask downloadTask) {
            c.this.r(m(downloadTask), downloadTask.getTargetFilePath());
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void a(DownloadTask downloadTask, int i2, int i3) {
            c.this.a(m(downloadTask), i3 > 0 ? (int) ((i2 * 100.0f) / i3) : 0, i2, i3);
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void a(DownloadTask downloadTask, Throwable th) {
            String str;
            if (th == null || th.getStackTrace().length <= 0) {
                str = "";
            } else {
                str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
            }
            c.this.b(m(downloadTask), 0, str);
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void b(DownloadTask downloadTask) {
            if (downloadTask.getSmallFileSoFarBytes() == 0) {
                if (com.kwad.b.kwai.a.bI.booleanValue()) {
                    com.kwad.sdk.core.d.b.d("DownloadStatusManager", "onDownloadStart(), id=" + m(downloadTask));
                }
                c.this.bO(m(downloadTask));
            }
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void c(DownloadTask downloadTask) {
            c.this.bP(m(downloadTask));
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void d(DownloadTask downloadTask) {
            c.this.bR(m(downloadTask));
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void e(DownloadTask downloadTask) {
            c.this.bQ(m(downloadTask));
        }

        @Override // com.ksad.download.b, com.ksad.download.a
        public final void f(DownloadTask downloadTask) {
            c.this.bT(m(downloadTask));
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$10 */
    final class AnonymousClass10 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass10(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.d(str, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$11 */
    final class AnonymousClass11 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass11(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.e(str, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$2 */
    final class AnonymousClass2 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass2(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.aq(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$3 */
    final class AnonymousClass3 implements com.kwad.sdk.a.a {
        AnonymousClass3() {
        }

        @Override // com.kwad.sdk.a.a
        public final void X(String str) {
            c.this.bU(str);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$4 */
    final class AnonymousClass4 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass4(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.a(str, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$5 */
    final class AnonymousClass5 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ int afg;
        final /* synthetic */ int afh;
        final /* synthetic */ int afi;

        AnonymousClass5(String str, int i2, int i3, int i4) {
            str = str;
            i2 = i2;
            i3 = i3;
            i4 = i4;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.a(str, i2, i3, i4);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$6 */
    final class AnonymousClass6 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;
        final /* synthetic */ String afj;

        AnonymousClass6(String str, String str2, f fVar) {
            str = str;
            str2 = str2;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.a(str, str2, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$7 */
    final class AnonymousClass7 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ int HY;
        final /* synthetic */ String HZ;
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass7(String str, int i2, String str2, f fVar) {
            str = str;
            i3 = i2;
            str2 = str2;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.a(str, i3, str2, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$8 */
    final class AnonymousClass8 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass8(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.b(str, fVar);
        }
    }

    /* renamed from: com.kwad.sdk.core.download.c$9 */
    final class AnonymousClass9 implements com.kwad.sdk.e.a<d> {
        final /* synthetic */ String afe;
        final /* synthetic */ f aff;

        AnonymousClass9(String str, f fVar) {
            str = str;
            fVar = fVar;
        }

        @Override // com.kwad.sdk.e.a
        /* renamed from: b */
        public void accept(d dVar) {
            dVar.c(str, fVar);
        }
    }

    static final class a {
        static final c afk = new c((byte) 0);
    }

    private c() {
        WeakHashMap<d, AdTemplate> weakHashMap = new WeakHashMap<>();
        this.aeW = weakHashMap;
        this.aeX = Collections.synchronizedMap(weakHashMap);
        this.mHasInit = false;
        HashMap<String, AdTemplate> hashMap = new HashMap<>();
        this.aeZ = hashMap;
        this.afa = Collections.synchronizedMap(hashMap);
        this.afc = new com.kwad.sdk.a.a() { // from class: com.kwad.sdk.core.download.c.3
            AnonymousClass3() {
            }

            @Override // com.kwad.sdk.a.a
            public final void X(String str) {
                c.this.bU(str);
            }
        };
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    private void a(String str, com.kwad.sdk.e.a<d> aVar) {
        Set<d> keySet = this.aeX.keySet();
        synchronized (this.aeX) {
            for (d dVar : keySet) {
                if (dVar != null && TextUtils.equals(dVar.nc(), str)) {
                    try {
                        aVar.accept(dVar);
                    } catch (Exception e2) {
                        com.kwad.sdk.core.d.b.printStackTrace(e2);
                    }
                }
            }
        }
    }

    public static int bN(String str) {
        Integer num;
        if (TextUtils.isEmpty(str) || (num = aeY.get(str)) == null) {
            return 0;
        }
        return num.intValue();
    }

    public void bU(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f fVar = new f();
        synchronized (this.aeX) {
            for (d dVar : this.aeX.keySet()) {
                if (dVar != null && !TextUtils.isEmpty(str) && TextUtils.equals(str, dVar.nd())) {
                    dVar.a((String) null, 0, fVar);
                }
            }
        }
        com.ksad.download.d O = com.ksad.download.c.M().O();
        if (O != null) {
            O.n(str);
        }
        synchronized (this.afa) {
            Iterator<Map.Entry<String, AdTemplate>> it = this.afa.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, AdTemplate> next = it.next();
                if (next != null) {
                    String key = next.getKey();
                    if (!TextUtils.isEmpty(str) && TextUtils.equals(str, key)) {
                        it.remove();
                    }
                }
            }
        }
    }

    private void f(String str, f fVar) {
        AdTemplate value;
        for (Map.Entry<String, AdTemplate> entry : this.afa.entrySet()) {
            if (entry != null && (value = entry.getValue()) != null) {
                AdInfo cb = com.kwad.sdk.core.response.a.d.cb(value);
                com.kwad.sdk.core.a.tS().c(str, value);
                if (!TextUtils.isEmpty(str) && cb.downloadId.equals(str) && !value.mDownloadFinishReported) {
                    if (fVar.vx()) {
                        com.kwad.sdk.core.download.a.c(1, value);
                        fVar.vw();
                    }
                    value.mDownloadFinishReported = true;
                }
            }
        }
    }

    public static c vu() {
        return a.afk;
    }

    public final void a(d dVar) {
        this.aeX.remove(dVar);
    }

    public final void a(d dVar, AdTemplate adTemplate) {
        this.aeX.put(dVar, adTemplate);
    }

    public final void a(String str, int i2, int i3, int i4) {
        aeY.put(str, 2);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.5
            final /* synthetic */ String afe;
            final /* synthetic */ int afg;
            final /* synthetic */ int afh;
            final /* synthetic */ int afi;

            AnonymousClass5(String str2, int i22, int i32, int i42) {
                str = str2;
                i2 = i22;
                i3 = i32;
                i4 = i42;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, i2, i3, i4);
            }
        });
    }

    public final synchronized void aM(Context context) {
        if (!this.mHasInit || context == null) {
            return;
        }
        try {
            com.kwad.sdk.a.b.tA().b(this.afc);
            this.aeX.clear();
            this.afa.clear();
            this.mHasInit = false;
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(th);
        }
    }

    public final void al(AdTemplate adTemplate) {
        try {
            String aq = com.kwad.sdk.core.response.a.a.aq(com.kwad.sdk.core.response.a.d.cb(adTemplate));
            if (TextUtils.isEmpty(aq)) {
                return;
            }
            this.afa.put(aq, adTemplate);
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.printStackTrace(th);
        }
    }

    public final void b(String str, int i2, String str2) {
        aeY.put(str, 7);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.7
            final /* synthetic */ int HY;
            final /* synthetic */ String HZ;
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass7(String str3, int i22, String str22, f fVar) {
                str = str3;
                i3 = i22;
                str2 = str22;
                fVar = fVar;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, i3, str2, fVar);
            }
        });
    }

    public final void bO(String str) {
        aeY.put(str, 1);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.4
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass4(String str2, f fVar) {
                str = str2;
                fVar = fVar;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, fVar);
            }
        });
    }

    public final void bP(String str) {
        f fVar = new f();
        aeY.put(str, 4);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.8
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass8(String str2, f fVar2) {
                str = str2;
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.b(str, fVar);
            }
        });
    }

    public final void bQ(String str) {
        f fVar = new f();
        aeY.put(str, 1);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.9
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass9(String str2, f fVar2) {
                str = str2;
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.c(str, fVar);
            }
        });
    }

    public final void bR(String str) {
        f fVar = new f();
        aeY.put(str, 5);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.10
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass10(String str2, f fVar2) {
                str = str2;
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.d(str, fVar);
            }
        });
    }

    public final void bS(String str) {
        f fVar = new f();
        aeY.put(str, 9);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.11
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass11(String str2, f fVar2) {
                str = str2;
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.e(str, fVar);
            }
        });
    }

    public final void bT(String str) {
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.2
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;

            AnonymousClass2(String str2, f fVar) {
                str = str2;
                fVar = fVar;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.aq(str);
            }
        });
    }

    public final synchronized void init(Context context) {
        if (!this.mHasInit && context != null) {
            com.ksad.download.c.M().a(new com.ksad.download.b() { // from class: com.kwad.sdk.core.download.c.1
                AnonymousClass1() {
                }

                private static String m(DownloadTask downloadTask) {
                    String url = downloadTask.getUrl();
                    String str = (String) c.afb.get(url);
                    if (!TextUtils.isEmpty(str)) {
                        return str;
                    }
                    String eC = ad.eC(downloadTask.getUrl());
                    c.afb.put(url, eC);
                    return eC;
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask) {
                    c.this.r(m(downloadTask), downloadTask.getTargetFilePath());
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, int i2, int i3) {
                    c.this.a(m(downloadTask), i3 > 0 ? (int) ((i2 * 100.0f) / i3) : 0, i2, i3);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void a(DownloadTask downloadTask, Throwable th) {
                    String str;
                    if (th == null || th.getStackTrace().length <= 0) {
                        str = "";
                    } else {
                        str = th.getMessage() + " @ " + th.getStackTrace()[0].getFileName() + th.getStackTrace()[0].getClassName() + th.getStackTrace()[0].getLineNumber();
                    }
                    c.this.b(m(downloadTask), 0, str);
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void b(DownloadTask downloadTask) {
                    if (downloadTask.getSmallFileSoFarBytes() == 0) {
                        if (com.kwad.b.kwai.a.bI.booleanValue()) {
                            com.kwad.sdk.core.d.b.d("DownloadStatusManager", "onDownloadStart(), id=" + m(downloadTask));
                        }
                        c.this.bO(m(downloadTask));
                    }
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void c(DownloadTask downloadTask) {
                    c.this.bP(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void d(DownloadTask downloadTask) {
                    c.this.bR(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void e(DownloadTask downloadTask) {
                    c.this.bQ(m(downloadTask));
                }

                @Override // com.ksad.download.b, com.ksad.download.a
                public final void f(DownloadTask downloadTask) {
                    c.this.bT(m(downloadTask));
                }
            });
            com.kwad.sdk.a.b.tA().a(this.afc);
            this.mHasInit = true;
        }
    }

    public final void r(String str, String str2) {
        f fVar = new f();
        aeY.put(str, 8);
        a(str, new com.kwad.sdk.e.a<d>() { // from class: com.kwad.sdk.core.download.c.6
            final /* synthetic */ String afe;
            final /* synthetic */ f aff;
            final /* synthetic */ String afj;

            AnonymousClass6(String str3, String str22, f fVar2) {
                str = str3;
                str2 = str22;
                fVar = fVar2;
            }

            @Override // com.kwad.sdk.e.a
            /* renamed from: b */
            public void accept(d dVar) {
                dVar.a(str, str2, fVar);
            }
        });
        f(str3, fVar2);
    }
}
