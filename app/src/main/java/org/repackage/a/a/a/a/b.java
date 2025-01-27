package org.repackage.a.a.a.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import org.repackage.a.a.a.a;

/* loaded from: classes4.dex */
public class b implements ServiceConnection {

    /* renamed from: a */
    public final /* synthetic */ c f29360a;

    public b(c cVar) {
        this.f29360a = cVar;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f29360a.f29361a = a.AbstractBinderC0756a.a(iBinder);
        synchronized (this.f29360a.f29364d) {
            this.f29360a.f29364d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f29360a.f29361a = null;
    }
}
