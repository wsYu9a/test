package z0;

import android.content.Context;
import android.os.RemoteException;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* loaded from: classes.dex */
public final class b implements InnerIdSupplier, w0.a {

    /* renamed from: b */
    public a f33588b;

    /* renamed from: c */
    public SupplierListener f33589c;

    public b(Context context, SupplierListener supplierListener) {
        this.f33589c = supplierListener;
        this.f33588b = new a(context, this);
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0027  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAAID() {
        /*
            r4 = this;
            boolean r0 = r4.isSupported()
            java.lang.String r1 = ""
            if (r0 == 0) goto L31
            z0.a r0 = r4.f33588b
            android.content.Context r2 = r0.f33583a
            if (r2 == 0) goto L29
            java.lang.String r2 = r2.getPackageName()
            if (r2 == 0) goto L24
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L1b
            goto L24
        L1b:
            b.a r0 = r0.f33584b     // Catch: android.os.RemoteException -> L24
            if (r0 == 0) goto L24
            java.lang.String r0 = r0.getAAID(r2)     // Catch: android.os.RemoteException -> L24
            goto L25
        L24:
            r0 = 0
        L25:
            if (r0 == 0) goto L31
            r1 = r0
            goto L31
        L29:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L31:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.b.getAAID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getOAID() {
        /*
            r2 = this;
            boolean r0 = r2.isSupported()
            if (r0 == 0) goto L25
            z0.a r0 = r2.f33588b
            android.content.Context r1 = r0.f33583a
            if (r1 == 0) goto L1d
            b.a r0 = r0.f33584b     // Catch: android.os.RemoteException -> L15
            if (r0 == 0) goto L19
            java.lang.String r0 = r0.getOAID()     // Catch: android.os.RemoteException -> L15
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L25
            goto L27
        L1d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L25:
            java.lang.String r0 = ""
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.b.getOAID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.InnerIdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getUDID() {
        /*
            r2 = this;
            boolean r0 = r2.isSupported()
            if (r0 == 0) goto L25
            z0.a r0 = r2.f33588b
            android.content.Context r1 = r0.f33583a
            if (r1 == 0) goto L1d
            b.a r0 = r0.f33584b     // Catch: android.os.RemoteException -> L15
            if (r0 == 0) goto L19
            java.lang.String r0 = r0.getUDID()     // Catch: android.os.RemoteException -> L15
            goto L1a
        L15:
            r0 = move-exception
            r0.printStackTrace()
        L19:
            r0 = 0
        L1a:
            if (r0 == 0) goto L25
            goto L27
        L1d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L25:
            java.lang.String r0 = ""
        L27:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.b.getUDID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getVAID() {
        /*
            r4 = this;
            boolean r0 = r4.isSupported()
            java.lang.String r1 = ""
            if (r0 == 0) goto L35
            z0.a r0 = r4.f33588b
            android.content.Context r2 = r0.f33583a
            if (r2 == 0) goto L2d
            java.lang.String r2 = r2.getPackageName()
            if (r2 == 0) goto L28
            boolean r3 = r2.equals(r1)
            if (r3 == 0) goto L1b
            goto L28
        L1b:
            b.a r0 = r0.f33584b     // Catch: android.os.RemoteException -> L24
            if (r0 == 0) goto L28
            java.lang.String r0 = r0.getVAID(r2)     // Catch: android.os.RemoteException -> L24
            goto L29
        L24:
            r0 = move-exception
            r0.printStackTrace()
        L28:
            r0 = 0
        L29:
            if (r0 == 0) goto L35
            r1 = r0
            goto L35
        L2d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Context is null, must be new OpenDeviceId first"
            r0.<init>(r1)
            throw r0
        L35:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: z0.b.getVAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        a aVar = this.f33588b;
        if (aVar == null) {
            return false;
        }
        try {
            b.a aVar2 = aVar.f33584b;
            if (aVar2 == null) {
                return false;
            }
            return aVar2.l();
        } catch (RemoteException unused) {
            return false;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // w0.a
    public final void l() {
        SupplierListener supplierListener = this.f33589c;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // w0.a
    public final void m() {
        SupplierListener supplierListener = this.f33589c;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
        a aVar = this.f33588b;
        if (aVar != null) {
            try {
                aVar.f33583a.unbindService(aVar.f33585c);
            } catch (IllegalArgumentException unused) {
            }
            aVar.f33584b = null;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
    }
}
