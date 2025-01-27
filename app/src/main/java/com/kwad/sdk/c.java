package com.kwad.sdk;

import android.content.Context;
import androidx.annotation.NonNull;
import com.kwad.framework.filedownloader.f.c;
import com.kwad.framework.filedownloader.r;
import com.kwad.framework.filedownloader.services.c;
import com.kwad.sdk.DownloadTask;
import com.kwad.sdk.k;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.u;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class c {
    private com.kwad.sdk.a anC;
    private d anE;
    private Context mContext;
    private final Map<Integer, DownloadTask> anA = new ConcurrentHashMap();
    private final Map<String, Integer> anB = new ConcurrentHashMap();
    private boolean anD = false;

    /* renamed from: com.kwad.sdk.c$1 */
    public class AnonymousClass1 implements c.a {
        public AnonymousClass1() {
        }

        @Override // com.kwad.framework.filedownloader.services.c.a
        public final c.b wC() {
            try {
                k.a aVar = new k.a(false);
                aVar.bi("");
                return aVar;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    /* renamed from: com.kwad.sdk.c$2 */
    public class AnonymousClass2 implements ap.a {
        final /* synthetic */ String anG;

        public AnonymousClass2(String str) {
            by = str;
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void d(Throwable th2) {
            com.kwad.sdk.core.download.b.EI().f(by, th2);
        }

        @Override // com.kwad.sdk.utils.ap.a
        public final void pa() {
            com.kwad.sdk.core.download.b.EI().dQ(by);
        }
    }

    public static final class a {
        private static final c anH = new c();
    }

    private void bU(int i10) {
        DownloadTask downloadTask = this.anA.get(Integer.valueOf(i10));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public static void bX(String str) {
        if (str == null) {
            return;
        }
        u.delete(com.kwad.framework.filedownloader.f.f.bx(str));
        u.delete(str);
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.anA.remove(Integer.valueOf(downloadTask.getId()));
        this.anB.remove(downloadTask.getUrl());
    }

    public static c yU() {
        return a.anH;
    }

    public static boolean yX() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void yY() {
        k.a aVar;
        try {
            aVar = new k.a(true);
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.ww().b(new c.b().bI(Integer.MAX_VALUE).a(aVar));
            this.anD = true;
        }
    }

    private static void yZ() {
        k.a aVar;
        try {
            aVar = new k.a(false);
        } catch (Throwable th2) {
            th2.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwad.framework.filedownloader.download.b.ww().b(new c.b().bI(Integer.MAX_VALUE).a(aVar));
        }
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.kwad.sdk.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            yY();
        } else if (this.anD) {
            yZ();
        }
        if (this.anA.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            bU(downloadTask.getId());
        } else {
            this.anA.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.anB.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.anC);
        return downloadTask.getId();
    }

    public final DownloadTask bT(int i10) {
        return this.anA.get(Integer.valueOf(i10));
    }

    public final void bV(int i10) {
        DownloadTask bT = bT(i10);
        if (bT == null) {
            return;
        }
        if (!bT.isUserPause()) {
            pause(i10);
        } else {
            bT.downloadType = 2;
            resume(i10);
        }
    }

    public final void cancel(int i10) {
        DownloadTask downloadTask = this.anA.get(Integer.valueOf(i10));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        ap.a(downloadTask.getTargetFilePath(), new ap.a() { // from class: com.kwad.sdk.c.2
            final /* synthetic */ String anG;

            public AnonymousClass2(String str) {
                by = str;
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void d(Throwable th2) {
                com.kwad.sdk.core.download.b.EI().f(by, th2);
            }

            @Override // com.kwad.sdk.utils.ap.a
            public final void pa() {
                com.kwad.sdk.core.download.b.EI().dQ(by);
            }
        });
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().bI(Integer.MAX_VALUE).a(new c.a() { // from class: com.kwad.sdk.c.1
            public AnonymousClass1() {
            }

            @Override // com.kwad.framework.filedownloader.services.c.a
            public final c.b wC() {
                try {
                    k.a aVar = new k.a(false);
                    aVar.bi("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i10) {
        DownloadTask downloadTask = this.anA.get(Integer.valueOf(i10));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i10) {
        a(i10, (DownloadTask.DownloadRequest) null);
    }

    public final File yV() {
        return bb.de(this.mContext);
    }

    public final d yW() {
        if (this.anE == null) {
            this.anE = new com.kwad.sdk.core.download.b.a();
        }
        return this.anE;
    }

    public final boolean za() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.anA.entrySet().iterator();
        while (true) {
            boolean z10 = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z10 = true;
                    }
                }
            }
            return z10;
        }
    }

    private void a(int i10, com.kwad.sdk.a... aVarArr) {
        DownloadTask downloadTask = this.anA.get(Integer.valueOf(i10));
        if (downloadTask != null) {
            for (int i11 = 0; i11 < 2; i11++) {
                com.kwad.sdk.a aVar = aVarArr[i11];
                if (aVar != null) {
                    aVar.setId(i10);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    public final void a(com.kwad.sdk.a aVar) {
        this.anC = aVar;
    }

    private void a(int i10, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.anA.get(Integer.valueOf(i10));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }
}
