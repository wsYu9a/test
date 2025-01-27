package com.vivo.ic.dm;

import android.content.Context;
import com.vivo.ic.VLog;
import com.vivo.ic.dm.Downloads;

/* loaded from: classes4.dex */
public class k extends Thread {

    /* renamed from: a */
    private static final String f28487a = Constants.PRE_TAG + "DownloadThread";

    /* renamed from: b */
    private final Context f28488b;

    /* renamed from: c */
    private final DownloadInfo f28489c;

    /* renamed from: d */
    private n f28490d;

    public k(Context context, DownloadInfo downloadInfo) {
        this.f28488b = context;
        this.f28489c = downloadInfo;
        this.f28490d = new n(context, downloadInfo);
    }

    public void a(int i2, String str) {
        this.f28490d.a(i2, str);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        boolean z;
        try {
            a("DownloadThread run(), info.title = " + this.f28489c.getTitle());
            synchronized (this.f28489c) {
                z = true;
                try {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    if (this.f28489c.isDownloading()) {
                        a("vsp id " + this.f28489c.getId() + " has already been downloading");
                        return;
                    }
                    this.f28489c.setDownloading(true);
                    if (!this.f28489c.isReadyToDownload()) {
                        a("record " + this.f28489c.getId() + " is not ready");
                        this.f28489c.setDownloading(false);
                        return;
                    }
                    a("vsp record " + this.f28489c.getId() + " downloading");
                    if (this.f28489c.getStatus() == 192) {
                        this.f28489c.writeToDatabase("startDownloadIfReady");
                    } else {
                        a(Downloads.Impl.STATUS_RUNNING, "startDownloadIfReady");
                    }
                    this.f28490d.l();
                    a("DownloadThread is over");
                    this.f28489c.setDownloading(false);
                } catch (Throwable th2) {
                    th = th2;
                    z = false;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        if (!z) {
                            this.f28489c.setDownloading(false);
                        }
                        throw th;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
            z = false;
        }
    }

    private void a(String str) {
        VLog.i(f28487a, "[" + this.f28489c.getId() + "] " + str);
    }
}
