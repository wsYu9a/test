package com.kwai.filedownloader.event;

/* loaded from: classes2.dex */
public final class DownloadServiceConnectChangedEvent extends b {
    private final ConnectStatus aIk;
    private final Class<?> aIl;

    public enum ConnectStatus {
        connected,
        disconnected,
        lost
    }

    public DownloadServiceConnectChangedEvent(ConnectStatus connectStatus, Class<?> cls) {
        super("event.service.connect.changed");
        this.aIk = connectStatus;
        this.aIl = cls;
    }

    public final ConnectStatus Ij() {
        return this.aIk;
    }
}
