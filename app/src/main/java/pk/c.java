package pk;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import mk.a;

/* loaded from: classes5.dex */
public final class c implements ServiceConnection {

    /* renamed from: b */
    public final b f29930b;

    public c(b bVar) {
        this.f29930b = bVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        mk.a c0744a;
        b bVar = this.f29930b;
        int i10 = a.AbstractBinderC0743a.f28716b;
        if (iBinder == null) {
            c0744a = null;
        } else {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.heytap.openid.IOpenID");
            c0744a = (queryLocalInterface == null || !(queryLocalInterface instanceof mk.a)) ? new a.AbstractBinderC0743a.C0744a(iBinder) : (mk.a) queryLocalInterface;
        }
        bVar.f29924a = c0744a;
        synchronized (this.f29930b.f29927d) {
            this.f29930b.f29927d.notify();
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f29930b.f29924a = null;
    }
}
