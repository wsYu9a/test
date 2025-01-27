package com.kwad.sdk.a.a;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bm;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.u;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Stack;

/* loaded from: classes3.dex */
public class b {
    private static volatile b aoN;
    private Stack<AdTemplate> aoL = new Stack<>();
    private File aoM;
    private boolean mHasInit;

    /* renamed from: com.kwad.sdk.a.a.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ a aoO;

        public AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        /* JADX WARN: Not initialized variable reg: 4, insn: 0x00a1: MOVE (r3 I:??[OBJECT, ARRAY]) = (r4 I:??[OBJECT, ARRAY]) (LINE:162), block:B:84:0x00a1 */
        /* JADX WARN: Removed duplicated region for block: B:57:0x011f A[Catch: all -> 0x00c6, TryCatch #3 {all -> 0x00c6, blocks: (B:3:0x0002, B:7:0x0009, B:10:0x0010, B:48:0x00c2, B:54:0x00fa, B:55:0x011b, B:57:0x011f, B:71:0x0123, B:72:0x0126, B:66:0x0114, B:68:0x0118, B:85:0x0127, B:86:0x012a, B:80:0x00e3), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
        @Override // com.kwad.sdk.utils.bd
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void doTask() {
            /*
                Method dump skipped, instructions count: 303
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
        }
    }

    /* renamed from: com.kwad.sdk.a.a.b$2 */
    public class AnonymousClass2 extends bd {
        final /* synthetic */ AdTemplate aoQ;

        public AnonymousClass2(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.aO(adTemplate);
        }
    }

    /* renamed from: com.kwad.sdk.a.a.b$3 */
    public class AnonymousClass3 extends bd {
        final /* synthetic */ AdTemplate aoR;

        public AnonymousClass3(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            b.this.aN(adTemplate);
        }
    }

    public interface a {
        void Bf();

        void gJ();
    }

    private b() {
    }

    public synchronized File Bc() {
        try {
            File file = this.aoM;
            if (file != null) {
                return file;
            }
            String dh2 = bb.dh(ServiceProvider.getContext());
            File file2 = new File(dh2);
            if (!file2.exists()) {
                file2.mkdir();
            }
            File file3 = new File(dh2 + File.separator + "uninstall_ad");
            this.aoM = file3;
            if (!file3.exists()) {
                try {
                    this.aoM.createNewFile();
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
            }
            return this.aoM;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public static b Bd() {
        if (aoN == null) {
            synchronized (b.class) {
                try {
                    if (aoN == null) {
                        aoN = new b();
                    }
                } finally {
                }
            }
        }
        return aoN;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.util.Iterator] */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v6, types: [java.io.Closeable] */
    public synchronized void aN(AdTemplate adTemplate) {
        Throwable th2;
        ObjectOutputStream objectOutputStream;
        Exception e10;
        ?? it = this.aoL.iterator();
        boolean z10 = false;
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.b.e.el((AdTemplate) it.next()) == com.kwad.sdk.core.response.b.e.el(adTemplate)) {
                it.remove();
                z10 = true;
            }
        }
        if (z10) {
            try {
                try {
                    objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.aoM));
                } catch (Exception e11) {
                    objectOutputStream = null;
                    e10 = e11;
                } catch (Throwable th3) {
                    it = 0;
                    th2 = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
                    throw th2;
                }
                try {
                    objectOutputStream.writeObject(this.aoL);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Exception e12) {
                    e10 = e12;
                    com.kwad.sdk.core.d.c.d("InstallTipsDataManager", " removeApkDownloadedData e" + e10);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                }
            } catch (Throwable th4) {
                th2 = th4;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) it);
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.AbstractCollection, java.util.Stack<com.kwad.sdk.core.response.model.AdTemplate>] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.io.Closeable] */
    public synchronized void aO(AdTemplate adTemplate) {
        Throwable th2;
        ObjectOutputStream objectOutputStream;
        Exception e10;
        ?? r02 = this.aoL;
        r02.add(adTemplate);
        try {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(Bc()));
            } catch (Exception e11) {
                objectOutputStream = null;
                e10 = e11;
            } catch (Throwable th3) {
                r02 = 0;
                th2 = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
                throw th2;
            }
            try {
                objectOutputStream.writeObject(this.aoL);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Exception e12) {
                e10 = e12;
                com.kwad.sdk.core.d.c.printStackTrace(e10);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        } catch (Throwable th4) {
            th2 = th4;
            com.kwad.sdk.crash.utils.b.closeQuietly((Closeable) r02);
            throw th2;
        }
    }

    public static File aR(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.H(com.kwad.sdk.core.response.b.e.eb(adTemplate)));
        if (u.M(file)) {
            return file;
        }
        return null;
    }

    public final synchronized AdTemplate Be() {
        AdTemplate adTemplate;
        Stack stack = (Stack) this.aoL.clone();
        while (true) {
            if (stack.isEmpty()) {
                adTemplate = null;
                break;
            }
            adTemplate = (AdTemplate) stack.pop();
            if (adTemplate != null) {
                String str = com.kwad.sdk.core.response.b.e.eb(adTemplate).adBaseInfo.appPackageName;
                Context context = ServiceProvider.getContext();
                File aR = aR(adTemplate);
                if (aR != null && aR.exists() && aR.lastModified() + bm.f6899d > System.currentTimeMillis() && !ap.an(context, str)) {
                    break;
                }
            }
        }
        return adTemplate;
    }

    public final void aP(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bd() { // from class: com.kwad.sdk.a.a.b.2
            final /* synthetic */ AdTemplate aoQ;

            public AnonymousClass2(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.aO(adTemplate);
            }
        });
    }

    public final void aQ(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        h.execute(new bd() { // from class: com.kwad.sdk.a.a.b.3
            final /* synthetic */ AdTemplate aoR;

            public AnonymousClass3(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                b.this.aN(adTemplate);
            }
        });
    }

    public final synchronized void a(a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        h.execute(new bd() { // from class: com.kwad.sdk.a.a.b.1
            final /* synthetic */ a aoO;

            public AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 303
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.a.a.b.AnonymousClass1.doTask():void");
            }
        });
    }
}
