package com.kwai.filedownloader;

import android.content.Context;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.services.e;

/* loaded from: classes2.dex */
public final class n implements u {
    private final u aFW;

    static final class a {
        private static final n aFX = new n((byte) 0);
    }

    private n() {
        this.aFW = com.kwai.filedownloader.e.e.Jb().aJu ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }

    /* synthetic */ n(byte b2) {
        this();
    }

    public static n Hh() {
        return a.aFX;
    }

    public static e.a Hi() {
        if (Hh().aFW instanceof o) {
            return (e.a) Hh().aFW;
        }
        return null;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        return this.aFW.a(str, str2, z, i2, i3, i4, z2, bVar, z3);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i2) {
        return this.aFW.cB(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i2) {
        return this.aFW.cC(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i2) {
        return this.aFW.cD(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final void dr(Context context) {
        this.aFW.dr(context);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aFW.isConnected();
    }
}
