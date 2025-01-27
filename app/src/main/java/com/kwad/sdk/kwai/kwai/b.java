package com.kwad.sdk.kwai.kwai;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bj;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Stack;

/* loaded from: classes2.dex */
public class b {
    private static volatile b YF;
    private Stack<AdTemplate> YD = new Stack<>();
    private File YE;
    private boolean mHasInit;

    /* renamed from: com.kwad.sdk.kwai.kwai.b$1 */
    final class AnonymousClass1 extends aw {
        final /* synthetic */ a YG;

        AnonymousClass1(a aVar) {
            aVar = aVar;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:57:0x0115 A[Catch: all -> 0x0123, TryCatch #0 {all -> 0x0123, blocks: (B:3:0x0002, B:7:0x0009, B:10:0x0010, B:48:0x00b4, B:54:0x00f0, B:55:0x0111, B:57:0x0115, B:72:0x0119, B:73:0x011c, B:66:0x010a, B:69:0x010e, B:80:0x00d9, B:85:0x011f, B:86:0x0122), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:59:? A[RETURN, SYNTHETIC] */
        @Override // com.kwad.sdk.utils.aw
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final void doTask() {
            /*
                Method dump skipped, instructions count: 296
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.kwai.kwai.b.AnonymousClass1.doTask():void");
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.b$2 */
    final class AnonymousClass2 implements Runnable {
        final /* synthetic */ AdTemplate YI;

        AnonymousClass2(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.Z(adTemplate);
        }
    }

    /* renamed from: com.kwad.sdk.kwai.kwai.b$3 */
    final class AnonymousClass3 implements Runnable {
        final /* synthetic */ AdTemplate YJ;

        AnonymousClass3(AdTemplate adTemplate) {
            adTemplate = adTemplate;
        }

        @Override // java.lang.Runnable
        public final void run() {
            b.this.Y(adTemplate);
        }
    }

    public interface a {
        void gv();

        void sY();
    }

    private b() {
    }

    public synchronized void Y(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        boolean z = false;
        Iterator<AdTemplate> it = this.YD.iterator();
        while (it.hasNext()) {
            if (com.kwad.sdk.core.response.a.d.cl(it.next()) == com.kwad.sdk.core.response.a.d.cl(adTemplate)) {
                it.remove();
                z = true;
            }
        }
        if (z) {
            try {
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(this.YE));
            } catch (Exception e3) {
                objectOutputStream = null;
                e2 = e3;
            } catch (Throwable th2) {
                objectOutputStream = null;
                th = th2;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
            try {
                try {
                    objectOutputStream.writeObject(this.YD);
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                } catch (Throwable th3) {
                    th = th3;
                    com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                    throw th;
                }
            } catch (Exception e4) {
                e2 = e4;
                com.kwad.sdk.core.d.b.d("InstallTipsDataManager", " removeApkDownloadedData e" + e2);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            }
        }
    }

    public synchronized void Z(AdTemplate adTemplate) {
        ObjectOutputStream objectOutputStream;
        Throwable th;
        Exception e2;
        this.YD.add(adTemplate);
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(sV()));
        } catch (Exception e3) {
            objectOutputStream = null;
            e2 = e3;
        } catch (Throwable th2) {
            objectOutputStream = null;
            th = th2;
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            throw th;
        }
        try {
            try {
                objectOutputStream.writeObject(this.YD);
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
            } catch (Throwable th3) {
                th = th3;
                com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
                throw th;
            }
        } catch (Exception e4) {
            e2 = e4;
            com.kwad.sdk.core.d.b.printStackTrace(e2);
            com.kwad.sdk.crash.utils.b.closeQuietly(objectOutputStream);
        }
    }

    public static File ac(AdTemplate adTemplate) {
        File file = new File(com.kwad.sdk.core.download.a.A(com.kwad.sdk.core.response.a.d.cb(adTemplate)));
        if (q.G(file)) {
            return file;
        }
        return null;
    }

    public synchronized File sV() {
        File file = this.YE;
        if (file != null) {
            return file;
        }
        Context context = KsAdSDKImpl.get().getContext();
        if (context == null) {
            return null;
        }
        String cE = av.cE(context);
        File file2 = new File(cE);
        if (!file2.exists()) {
            file2.mkdir();
        }
        File file3 = new File(cE + File.separator + "uninstall_ad");
        this.YE = file3;
        if (!file3.exists()) {
            try {
                this.YE.createNewFile();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return this.YE;
    }

    public static b sW() {
        if (YF == null) {
            synchronized (b.class) {
                if (YF == null) {
                    YF = new b();
                }
            }
        }
        return YF;
    }

    public final synchronized void a(a aVar) {
        if (this.mHasInit) {
            return;
        }
        this.mHasInit = true;
        g.execute(new aw() { // from class: com.kwad.sdk.kwai.kwai.b.1
            final /* synthetic */ a YG;

            AnonymousClass1(a aVar2) {
                aVar = aVar2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                /*
                    Method dump skipped, instructions count: 296
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.kwai.kwai.b.AnonymousClass1.doTask():void");
            }
        });
    }

    public final void aa(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.2
            final /* synthetic */ AdTemplate YI;

            AnonymousClass2(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.Z(adTemplate);
            }
        });
    }

    public final void ab(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        g.execute(new Runnable() { // from class: com.kwad.sdk.kwai.kwai.b.3
            final /* synthetic */ AdTemplate YJ;

            AnonymousClass3(AdTemplate adTemplate2) {
                adTemplate = adTemplate2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                b.this.Y(adTemplate);
            }
        });
    }

    public final synchronized AdTemplate sX() {
        AdTemplate adTemplate;
        adTemplate = null;
        Stack stack = (Stack) this.YD.clone();
        while (true) {
            if (stack.isEmpty()) {
                break;
            }
            AdTemplate adTemplate2 = (AdTemplate) stack.pop();
            if (adTemplate2 != null) {
                String str = com.kwad.sdk.core.response.a.d.cb(adTemplate2).adBaseInfo.appPackageName;
                Context context = KsAdSDKImpl.get().getContext();
                File ac = ac(adTemplate2);
                if (ac != null && ac.exists() && ac.lastModified() + bj.f5599d > System.currentTimeMillis() && !ak.ah(context, str)) {
                    adTemplate = adTemplate2;
                    break;
                }
            }
        }
        return adTemplate;
    }
}
