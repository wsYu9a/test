package com.ksad.download;

import android.content.Context;
import androidx.annotation.NonNull;
import com.ksad.download.DownloadTask;
import com.ksad.download.f;
import com.kwad.sdk.utils.ad;
import com.kwad.sdk.utils.ak;
import com.kwad.sdk.utils.av;
import com.kwai.filedownloader.e.c;
import com.kwai.filedownloader.r;
import com.kwai.filedownloader.services.c;
import java.io.File;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class c {
    private com.ksad.download.a br;
    private d bt;
    private Context mContext;
    private final Map<Integer, DownloadTask> bp = new ConcurrentHashMap();
    private final Map<String, Integer> bq = new ConcurrentHashMap();
    private boolean bs = false;

    /* renamed from: com.ksad.download.c$1 */
    final class AnonymousClass1 implements c.a {
        AnonymousClass1() {
        }

        @Override // com.kwai.filedownloader.services.c.a
        public final c.b T() {
            try {
                f.a aVar = new f.a(false);
                aVar.q("");
                return aVar;
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    static final class a {
        private static final c bv = new c();
    }

    public static c M() {
        return a.bv;
    }

    public static boolean P() {
        try {
            Class.forName("com.kwad.sdk.api.proxy.app.BaseFragmentActivity.RequestInstallPermissionActivity");
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void Q() {
        f.a aVar;
        try {
            aVar = new f.a(true);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.HF().b(new c.b().df(Integer.MAX_VALUE).a(aVar));
            this.bs = true;
        }
    }

    private static void R() {
        f.a aVar;
        try {
            aVar = new f.a(false);
        } catch (Throwable th) {
            th.printStackTrace();
            aVar = null;
        }
        if (aVar != null) {
            com.kwai.filedownloader.download.b.HF().b(new c.b().df(Integer.MAX_VALUE).a(aVar));
        }
    }

    private void a(int i2, DownloadTask.DownloadRequest downloadRequest) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.resume(downloadRequest);
        }
    }

    private void a(int i2, com.ksad.download.a... aVarArr) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            for (int i3 = 0; i3 < 2; i3++) {
                com.ksad.download.a aVar = aVarArr[i3];
                if (aVar != null) {
                    aVar.setId(i2);
                    downloadTask.addListener(aVar);
                }
            }
        }
    }

    private void h(@NonNull DownloadTask downloadTask) {
        this.bp.remove(Integer.valueOf(downloadTask.getId()));
        this.bq.remove(downloadTask.getUrl());
    }

    private void t(int i2) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.clearListener();
        }
    }

    public final File N() {
        return av.cB(this.mContext);
    }

    public final d O() {
        if (this.bt == null) {
            this.bt = new com.kwad.sdk.core.download.a.a();
        }
        return this.bt;
    }

    public final boolean S() {
        Iterator<Map.Entry<Integer, DownloadTask>> it = this.bp.entrySet().iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                DownloadTask value = it.next().getValue();
                if (value != null) {
                    int status = value.getStatus();
                    if (status != -2 && status != 1 && status != 2 && status != 3 && status != 5 && status != 6 && status != 10 && status != 11 && Math.abs(value.getStatusUpdateTime() - System.currentTimeMillis()) > 120000) {
                        z = true;
                    }
                }
            }
            return z;
        }
    }

    public final int a(@NonNull DownloadTask.DownloadRequest downloadRequest, com.ksad.download.a aVar) {
        DownloadTask downloadTask = new DownloadTask(downloadRequest);
        if (downloadRequest.getDownloadUrl().contains("downali.game.uc.cn")) {
            Q();
        } else if (this.bs) {
            R();
        }
        if (this.bp.get(Integer.valueOf(downloadTask.getId())) != null) {
            a(downloadTask.getId(), downloadRequest);
            t(downloadTask.getId());
        } else {
            this.bp.put(Integer.valueOf(downloadTask.getId()), downloadTask);
            this.bq.put(downloadTask.getUrl(), Integer.valueOf(downloadTask.getId()));
            downloadTask.submit();
        }
        a(downloadTask.getId(), null, this.br);
        return downloadTask.getId();
    }

    public final void a(com.ksad.download.a aVar) {
        this.br = aVar;
    }

    public final void cancel(int i2) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.cancel();
            h(downloadTask);
        }
    }

    public final void g(DownloadTask downloadTask) {
        if (ak.ak(this.mContext, downloadTask.getTargetFilePath())) {
            com.kwad.sdk.core.download.c.vu().bS(ad.eC(downloadTask.getUrl()));
        }
    }

    public final Context getContext() {
        return this.mContext;
    }

    public final void init(@NonNull Context context) {
        this.mContext = context;
        r.a(context, new c.b().df(Integer.MAX_VALUE).a(new c.a() { // from class: com.ksad.download.c.1
            AnonymousClass1() {
            }

            @Override // com.kwai.filedownloader.services.c.a
            public final c.b T() {
                try {
                    f.a aVar = new f.a(false);
                    aVar.q("");
                    return aVar;
                } catch (Throwable unused) {
                    return null;
                }
            }
        }));
    }

    public final void pause(int i2) {
        DownloadTask downloadTask = this.bp.get(Integer.valueOf(i2));
        if (downloadTask != null) {
            downloadTask.userPause();
        }
    }

    public final void resume(int i2) {
        a(i2, (DownloadTask.DownloadRequest) null);
    }

    public final DownloadTask s(int i2) {
        return this.bp.get(Integer.valueOf(i2));
    }

    public final void u(int i2) {
        DownloadTask s = s(i2);
        if (s == null) {
            return;
        }
        if (s.isUserPause()) {
            resume(i2);
        } else {
            pause(i2);
        }
    }
}
