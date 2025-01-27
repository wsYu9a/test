package com.kwad.framework.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.services.e;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
final class o implements e.a, u {
    private static Class<?> aib;
    private final ArrayList<Runnable> aic = new ArrayList<>();
    private com.kwad.framework.filedownloader.services.e aid;

    private static Class<?> vX() {
        if (aib == null) {
            aib = FileDownloadService.SharedMainProcessService.class;
        }
        return aib;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z10);
        }
        this.aid.b(str, str2, z10, i10, i11, i12, z11, bVar, z12);
        return true;
    }

    @Override // com.kwad.framework.filedownloader.u
    public final void az(Context context) {
        a(context, null);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean be(int i10) {
        return !isConnected() ? com.kwad.framework.filedownloader.f.a.be(i10) : this.aid.be(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bf(int i10) {
        return !isConnected() ? com.kwad.framework.filedownloader.f.a.bf(i10) : this.aid.bf(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bg(int i10) {
        return !isConnected() ? com.kwad.framework.filedownloader.f.a.bg(i10) : this.aid.bg(i10);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return this.aid != null;
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aid = null;
        f.vH().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, vX()));
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, vX()));
    }

    @Override // com.kwad.framework.filedownloader.services.e.a
    public final void a(com.kwad.framework.filedownloader.services.e eVar) {
        this.aid = eVar;
        List list = (List) this.aic.clone();
        this.aic.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.vH().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, vX()));
    }
}
