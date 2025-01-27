package com.kwad.framework.filedownloader;

import android.content.Context;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;

/* loaded from: classes3.dex */
public final class n implements u {
    private final u ahZ;

    public static final class a {
        private static final n aia = new n((byte) 0);
    }

    public /* synthetic */ n(byte b10) {
        this();
    }

    public static n vU() {
        return a.aia;
    }

    public static e.a vV() {
        if (vU().ahZ instanceof o) {
            return (e.a) vU().ahZ;
        }
        return null;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        return this.ahZ.a(str, str2, z10, i10, i11, i12, z11, bVar, z12);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void az(Context context) {
        this.ahZ.az(context);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean be(int i10) {
        return this.ahZ.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bf(int i10) {
        return this.ahZ.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bg(int i10) {
        return this.ahZ.bg(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.ahZ.isConnected();
    }

    private n() {
        this.ahZ = com.kwad.framework.filedownloader.f.e.xV().alx ? new o() : new p(FileDownloadService.SeparateProcessService.class);
    }
}
