package x6;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;

/* loaded from: classes2.dex */
public final class g implements ServiceConnection {

    /* renamed from: b */
    public final /* synthetic */ Intent f31870b;

    /* renamed from: c */
    public final /* synthetic */ b f31871c;

    public g(b bVar, Intent intent) {
        this.f31871c = bVar;
        this.f31870b = intent;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Context context;
        Bundle bundle = new Bundle();
        bundle.putAll(this.f31870b.getExtras());
        try {
            pe.b.g(iBinder).d(bundle);
        } catch (Exception e10) {
            c7.e.a("bindMcsService exception:" + e10);
        }
        context = this.f31871c.f31857b;
        context.unbindService(this);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
