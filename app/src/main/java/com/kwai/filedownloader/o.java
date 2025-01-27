package com.kwai.filedownloader;

import android.content.Context;
import android.content.Intent;
import com.kwad.sdk.api.proxy.app.FileDownloadService;
import com.kwai.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwai.filedownloader.services.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
final class o implements e.a, u {
    private static Class<?> aFY;
    private final ArrayList<Runnable> aFZ = new ArrayList<>();
    private com.kwai.filedownloader.services.e aGa;

    o() {
    }

    private static Class<?> Hk() {
        if (aFY == null) {
            aFY = FileDownloadService.SharedMainProcessService.class;
        }
        return aFY;
    }

    private void a(Context context, Runnable runnable) {
        context.startService(new Intent(context, Hk()));
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void a(com.kwai.filedownloader.services.e eVar) {
        this.aGa = eVar;
        List list = (List) this.aFZ.clone();
        this.aFZ.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, Hk()));
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.l(str, str2, z);
        }
        this.aGa.b(str, str2, z, i2, i3, i4, z2, bVar, z3);
        return true;
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cB(i2) : this.aGa.cB(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cC(i2) : this.aGa.cC(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i2) {
        return !isConnected() ? com.kwai.filedownloader.e.a.cD(i2) : this.aGa.cD(i2);
    }

    @Override // com.kwai.filedownloader.u
    public final void dr(Context context) {
        a(context, null);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean isConnected() {
        return this.aGa != null;
    }

    @Override // com.kwai.filedownloader.services.e.a
    public final void onDisconnected() {
        this.aGa = null;
        f.GU().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.disconnected, Hk()));
    }
}
