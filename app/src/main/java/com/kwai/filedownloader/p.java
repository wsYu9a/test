package com.kwai.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwai.filedownloader.b.a;
import com.kwai.filedownloader.b.b;
import com.kwai.filedownloader.message.MessageSnapshot;

/* loaded from: classes2.dex */
final class p extends com.kwai.filedownloader.services.a<a, com.kwai.filedownloader.b.b> {

    protected static class a extends a.AbstractBinderC0239a {
        protected a() {
        }

        @Override // com.kwai.filedownloader.b.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwai.filedownloader.message.e.Iv().s(messageSnapshot);
        }
    }

    p(Class<?> cls) {
        super(cls);
    }

    private static a Hl() {
        return new a();
    }

    private static com.kwai.filedownloader.b.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* renamed from: a */
    private static void a2(com.kwai.filedownloader.b.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ a Hm() {
        return Hl();
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwai.filedownloader.b.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean a(String str, String str2, boolean z, int i2, int i3, int i4, boolean z2, com.kwai.filedownloader.c.b bVar, boolean z3) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.l(str, str2, z);
        }
        try {
            IF().b(str, str2, z, i2, i3, i4, z2, bVar, z3);
            return true;
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.kwai.filedownloader.services.a
    public final /* synthetic */ com.kwai.filedownloader.b.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cB(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cB(i2);
        }
        try {
            return IF().cB(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    @Override // com.kwai.filedownloader.u
    public final byte cC(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cC(i2);
        }
        try {
            return IF().cC(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwai.filedownloader.u
    public final boolean cD(int i2) {
        if (!isConnected()) {
            return com.kwai.filedownloader.e.a.cD(i2);
        }
        try {
            return IF().cD(i2);
        } catch (RemoteException e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
