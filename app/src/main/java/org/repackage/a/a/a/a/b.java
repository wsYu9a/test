package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* loaded from: classes5.dex */
public class b implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ c f35550a;

    public b(c cVar) {
        this.f35550a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f35550a.f35551a = a.AbstractBinderC0831a.a(iBinder);
        synchronized (this.f35550a.f35554d) {
            this.f35550a.f35554d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f35550a.f35551a = null;
    }
}
