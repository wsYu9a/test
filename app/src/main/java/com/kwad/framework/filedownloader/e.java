package com.kwad.framework.filedownloader;

import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;

/* loaded from: classes3.dex */
public abstract class e extends com.kwad.framework.filedownloader.event.c {
    private DownloadServiceConnectChangedEvent.ConnectStatus ahH;

    @Override // com.kwad.framework.filedownloader.event.c
    public final boolean a(com.kwad.framework.filedownloader.event.b bVar) {
        if (!(bVar instanceof DownloadServiceConnectChangedEvent)) {
            return false;
        }
        DownloadServiceConnectChangedEvent.ConnectStatus xb2 = ((DownloadServiceConnectChangedEvent) bVar).xb();
        this.ahH = xb2;
        if (xb2 == DownloadServiceConnectChangedEvent.ConnectStatus.connected) {
            vE();
            return false;
        }
        vF();
        return false;
    }

    public abstract void vE();

    public abstract void vF();

    public final DownloadServiceConnectChangedEvent.ConnectStatus vG() {
        return this.ahH;
    }
}
