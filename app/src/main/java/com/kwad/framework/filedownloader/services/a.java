package com.kwad.framework.filedownloader.services;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.event.DownloadServiceConnectChangedEvent;
import com.kwad.framework.filedownloader.u;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class a<CALLBACK extends Binder, INTERFACE extends IInterface> implements ServiceConnection, u {
    private volatile INTERFACE akU;
    private final Class<?> akp;
    private final HashMap<String, Object> akV = new HashMap<>();
    private final List<Context> akW = new ArrayList();
    private final ArrayList<Runnable> aic = new ArrayList<>();
    private final CALLBACK akT = vZ();

    public a(Class<?> cls) {
        this.akp = cls;
    }

    private void a(Context context, Runnable runnable) {
        if (com.kwad.framework.filedownloader.f.f.aC(context)) {
            throw new IllegalStateException("Fatal-Exception: You can't bind the FileDownloadService in :filedownloader process.\n It's the invalid operation and is likely to cause unexpected problems.\n Maybe you want to use non-separate process mode for FileDownloader, More detail about non-separate mode, please move to wiki manually: https://github.com/lingochamp/FileDownloader/wiki/filedownloader.properties");
        }
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "bindStartByContext %s", context.getClass().getSimpleName());
        }
        Intent intent = new Intent(context, this.akp);
        if (!this.akW.contains(context)) {
            this.akW.add(context);
        }
        context.bindService(intent, this, 1);
        context.startService(intent);
    }

    private void bh(boolean z10) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "release connect resources %s", this.akU);
        }
        this.akU = null;
        com.kwad.framework.filedownloader.f.vH().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.lost, this.akp));
    }

    public abstract void a(INTERFACE r12, CALLBACK callback);

    @Override // com.kwad.framework.filedownloader.u
    public final void az(Context context) {
        a(context, (Runnable) null);
    }

    public abstract INTERFACE b(IBinder iBinder);

    @Override // com.kwad.framework.filedownloader.u
    public final boolean isConnected() {
        return xy() != null;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.akU = b(iBinder);
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceConnected %s %s", componentName, this.akU);
        }
        try {
            a((a<CALLBACK, INTERFACE>) this.akU, (INTERFACE) this.akT);
        } catch (RemoteException e10) {
            e10.printStackTrace();
        }
        List list = (List) this.aic.clone();
        this.aic.clear();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
        com.kwad.framework.filedownloader.f.vH().c(new DownloadServiceConnectChangedEvent(DownloadServiceConnectChangedEvent.ConnectStatus.connected, this.akp));
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        if (com.kwad.framework.filedownloader.f.d.alt) {
            com.kwad.framework.filedownloader.f.d.c(this, "onServiceDisconnected %s %s", componentName, this.akU);
        }
        bh(true);
    }

    public abstract CALLBACK vZ();

    public final INTERFACE xy() {
        return this.akU;
    }
}
