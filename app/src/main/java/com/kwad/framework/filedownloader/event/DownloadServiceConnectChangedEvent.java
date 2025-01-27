package com.kwad.framework.filedownloader.event;

/* loaded from: classes3.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus ako;
    private final Class<?> akp;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.ako = connectStatus;
        this.akp = cls;
    }

    public final ConnectStatus xb() {
        return this.ako;
    }
}
