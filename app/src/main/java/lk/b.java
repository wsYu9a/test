package lk;

import android.os.Parcel;
import android.os.RemoteException;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* loaded from: classes5.dex */
public final class b implements InnerIdSupplier {

    /* renamed from: b */
    public a f28143b = new a();

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            lk.a r0 = r5.f28143b
            android.os.IBinder r1 = r0.f28142a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.f28142a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 0
            r4 = 6
            r0.transact(r4, r1, r2, r3)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.b.getAAID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getOAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            lk.a r0 = r5.f28143b
            android.os.IBinder r1 = r0.f28142a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.f28142a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 0
            r4 = 4
            r0.transact(r4, r1, r2, r3)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.b.getOAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:10:? A[RETURN, SYNTHETIC] */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getVAID() {
        /*
            r5 = this;
            boolean r0 = r5.isSupported()
            if (r0 == 0) goto L3e
            lk.a r0 = r5.f28143b
            android.os.IBinder r1 = r0.f28142a
            if (r1 == 0) goto L3a
            android.os.Parcel r1 = android.os.Parcel.obtain()
            android.os.Parcel r2 = android.os.Parcel.obtain()
            android.os.IBinder r0 = r0.f28142a     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r3 = 0
            r4 = 5
            r0.transact(r4, r1, r2, r3)     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            java.lang.String r0 = r2.readString()     // Catch: java.lang.Throwable -> L26 android.os.RemoteException -> L28
            r1.recycle()
            r2.recycle()
            goto L3b
        L26:
            r0 = move-exception
            goto L33
        L28:
            r0 = move-exception
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L26
            r1.recycle()
            r2.recycle()
            goto L3a
        L33:
            r1.recycle()
            r2.recycle()
            throw r0
        L3a:
            r0 = 0
        L3b:
            if (r0 == 0) goto L3e
            goto L40
        L3e:
            java.lang.String r0 = ""
        L40:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: lk.b.getVAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        a aVar = this.f28143b;
        if (aVar != null) {
            return aVar.a();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return true;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
        a aVar = this.f28143b;
        if (aVar != null) {
            if (aVar.f28142a != null) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    try {
                        aVar.f28142a.transact(7, obtain, obtain2, 0);
                    } catch (RemoteException e10) {
                        e10.printStackTrace();
                    }
                } finally {
                    obtain.recycle();
                    obtain2.recycle();
                }
            }
            this.f28143b = null;
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
    }
}
