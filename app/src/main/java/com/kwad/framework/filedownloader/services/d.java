package com.kwad.framework.filedownloader.services;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;
import com.kwad.framework.filedownloader.message.e;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public final class d extends b.a implements e.b, i {
    private final RemoteCallbackList<com.kwad.framework.filedownloader.c.a> alf = new RemoteCallbackList<>();
    private final g alg;
    private final WeakReference<FileDownloadServiceProxy> alh;

    public d(WeakReference<FileDownloadServiceProxy> weakReference, g gVar) {
        this.alh = weakReference;
        this.alg = gVar;
        com.kwad.framework.filedownloader.message.e.xn().a(this);
    }

    private synchronized int v(MessageSnapshot messageSnapshot) {
        int beginBroadcast;
        RemoteCallbackList<com.kwad.framework.filedownloader.c.a> remoteCallbackList;
        try {
            beginBroadcast = this.alf.beginBroadcast();
            for (int i10 = 0; i10 < beginBroadcast; i10++) {
                try {
                    try {
                        this.alf.getBroadcastItem(i10).q(messageSnapshot);
                    } catch (RemoteException e10) {
                        com.kwad.framework.filedownloader.f.d.a(this, e10, "callback error", new Object[0]);
                        remoteCallbackList = this.alf;
                    }
                } catch (Throwable th2) {
                    this.alf.finishBroadcast();
                    throw th2;
                }
            }
            remoteCallbackList = this.alf;
            remoteCallbackList.finishBroadcast();
        } catch (Throwable th3) {
            throw th3;
        }
        return beginBroadcast;
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void a(com.kwad.framework.filedownloader.c.a aVar) {
        this.alf.register(aVar);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void b(com.kwad.framework.filedownloader.c.a aVar) {
        this.alf.unregister(aVar);
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
        com.kwad.framework.filedownloader.message.e.xn().a(null);
    }

    @Override // com.kwad.framework.filedownloader.c.b
    public final void pauseAllTasks() {
        this.alg.xM();
    }

    @Override // com.kwad.framework.filedownloader.message.e.b
    public final void r(MessageSnapshot messageSnapshot) {
        v(messageSnapshot);
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
    }

    @Override // com.kwad.framework.filedownloader.services.i
    public final IBinder xK() {
        return this;
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
