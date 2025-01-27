package com.kwai.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public final class e extends b.a implements i {
    private final g aJc;
    private final WeakReference<FileDownloadServiceProxy> aJd;

    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.aJd = weakReference;
        this.aJc = gVar;
    }

    @Override // com.kwai.filedownloader.services.i
    public final void IR() {
        n.Hi().a(this);
    }

    @Override // com.kwai.filedownloader.services.i
    public final IBinder IS() {
        return null;
    }

    @Override // com.kwai.filedownloader.b.b
    public final void Il() {
        this.aJc.Il();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void a(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean am(String str, String str2) {
        return this.aJc.ao(str, str2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(com.kwai.filedownloader.b.a aVar) {
    }

    @Override // com.kwai.filedownloader.b.b
    public final void b(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        this.aJc.b(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cB(int i2) {
        return this.aJc.cB(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final byte cC(int i2) {
        return this.aJc.cC(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cD(int i2) {
        return this.aJc.cD(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean cV(int i2) {
        return this.aJc.cV(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cW(int i2) {
        return this.aJc.dh(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final long cX(int i2) {
        return this.aJc.cX(i2);
    }

    @Override // com.kwai.filedownloader.b.b
    public final boolean isIdle() {
        return this.aJc.isIdle();
    }

    @Override // com.kwai.filedownloader.services.i
    public final void onDestroy() {
        n.Hi().onDisconnected();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void pauseAllTasks() {
        this.aJc.IT();
    }

    @Override // com.kwai.filedownloader.b.b
    public final void startForeground(int i2, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aJd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aJd.get().context.startForeground(i2, notification);
    }

    @Override // com.kwai.filedownloader.b.b
    public final void stopForeground(boolean z) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.aJd;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.aJd.get().context.stopForeground(z);
    }
}
