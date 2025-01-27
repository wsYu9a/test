package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.n;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class e extends b.a implements i {
    private final g alg;
    private final WeakReference<FileDownloadServiceProxy> alh;

    public interface a {
        void a(e eVar);

        void onDisconnected();
    }

    public e(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.alh = weakReference;
        this.alg = gVar;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bA(int i10) {
        return this.alg.bA(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean be(int i10) {
        return this.alg.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final byte bf(int i10) {
        return this.alg.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean bg(int i10) {
        return this.alg.bg(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean by(int i10) {
        return this.alg.by(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final long bz(int i10) {
        return this.alg.bK(i10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean isIdle() {
        return this.alg.isIdle();
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void onDestroy() {
        n.vV().onDisconnected();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.alg.xM();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void startForeground(int i10, Notification notification) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.alh;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.alh.get().context.startForeground(i10, notification);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void stopForeground(boolean z10) {
        WeakReference<FileDownloadServiceProxy> weakReference = this.alh;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.alh.get().context.stopForeground(z10);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final boolean u(String str, String str2) {
        return this.alg.y(str, str2);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final void xJ() {
        n.vV().a(this);
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder xK() {
        return null;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void xd() {
        this.alg.xd();
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        this.alg.b(str, str2, z10, i10, i11, i12, z11, bVar, z12);
    }
}
