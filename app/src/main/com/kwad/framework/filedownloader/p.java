package com.kwad.framework.filedownloader;

import android.os.IBinder;
import android.os.RemoteException;
import com.kwad.framework.filedownloader.c.a;
import com.kwad.framework.filedownloader.c.b;
import com.kwad.framework.filedownloader.message.MessageSnapshot;

/* loaded from: classes3.dex */
final class p extends com.kwad.framework.filedownloader.services.a<a, com.kwad.framework.filedownloader.c.b> {

    public static class a extends a.AbstractBinderC0465a {
        @Override // com.kwad.framework.filedownloader.c.a
        public final void q(MessageSnapshot messageSnapshot) {
            com.kwad.framework.filedownloader.message.e.xn().s(messageSnapshot);
        }
    }

    public p(Class<?> cls) {
        super(cls);
    }

    private static a vY() {
        return new a();
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* bridge */ /* synthetic */ void a(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        a2(bVar, aVar);
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ com.kwad.framework.filedownloader.c.b b(IBinder iBinder) {
        return a(iBinder);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean be(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.be(i10);
        }
        try {
            return xy().be(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final byte bf(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bf(i10);
        }
        try {
            return xy().bf(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return (byte) 0;
        }
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean bg(int i10) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.bg(i10);
        }
        try {
            return xy().bg(i10);
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    @Override // com.kwad.framework.filedownloader.services.a
    public final /* synthetic */ a vZ() {
        return vY();
    }

    private static com.kwad.framework.filedownloader.c.b a(IBinder iBinder) {
        return b.a.a(iBinder);
    }

    /* renamed from: a */
    private static void a2(com.kwad.framework.filedownloader.c.b bVar, a aVar) {
        bVar.a(aVar);
    }

    @Override // com.kwad.framework.filedownloader.u
    public final boolean a(String str, String str2, boolean z10, int i10, int i11, int i12, boolean z11, com.kwad.framework.filedownloader.d.b bVar, boolean z12) {
        if (!isConnected()) {
            return com.kwad.framework.filedownloader.f.a.h(str, str2, z10);
        }
        try {
            xy().b(str, str2, z10, i10, i11, i12, z11, bVar, z12);
            return true;
        } catch (RemoteException e10) {
            e10.printStackTrace();
            return false;
        }
    }
}
