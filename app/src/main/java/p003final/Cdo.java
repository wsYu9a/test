package p003final;

import android.content.Context;
import android.os.Build;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* renamed from: final.do */
/* loaded from: classes4.dex */
public final class Cdo implements InnerIdSupplier {

    /* renamed from: b */
    public Context f26051b;

    /* renamed from: final.do$a */
    public class a implements Runnable {

        /* renamed from: b */
        public final SupplierListener f26052b;

        public a(SupplierListener supplierListener) {
            this.f26052b = supplierListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                SupplierListener supplierListener = this.f26052b;
                if (supplierListener == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT <= 28) {
                    supplierListener.OnSupport(false, new DefaultSupplier());
                } else {
                    Cdo.this.getClass();
                    supplierListener.OnSupport(pk.a.f29923b, Cdo.this);
                }
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public Cdo(Context context) {
        dh.a.a(context);
        this.f26051b = context;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getAAID() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = r4.f26051b     // Catch: java.lang.Exception -> L1a
            boolean r2 = pk.a.f29922a     // Catch: java.lang.Exception -> L1a
            if (r2 != 0) goto L9
            goto L1c
        L9:
            boolean r2 = pk.a.f29923b     // Catch: java.lang.Exception -> L1a
            if (r2 == 0) goto L1c
            pk.b r2 = pk.b.a.f29929a     // Catch: java.lang.Exception -> L1a
            android.content.Context r1 = pk.a.a(r1)     // Catch: java.lang.Exception -> L1a
            java.lang.String r3 = "AUID"
            java.lang.String r1 = r2.a(r1, r3)     // Catch: java.lang.Exception -> L1a
            goto L1d
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = r0
        L1d:
            if (r1 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            return r0
        L22:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p003final.Cdo.getAAID():java.lang.String");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getOAID() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = r4.f26051b     // Catch: java.lang.Exception -> L1a
            boolean r2 = pk.a.f29922a     // Catch: java.lang.Exception -> L1a
            if (r2 != 0) goto L9
            goto L1c
        L9:
            boolean r2 = pk.a.f29923b     // Catch: java.lang.Exception -> L1a
            if (r2 == 0) goto L1c
            pk.b r2 = pk.b.a.f29929a     // Catch: java.lang.Exception -> L1a
            android.content.Context r1 = pk.a.a(r1)     // Catch: java.lang.Exception -> L1a
            java.lang.String r3 = "OUID"
            java.lang.String r1 = r2.a(r1, r3)     // Catch: java.lang.Exception -> L1a
            goto L1d
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = r0
        L1d:
            if (r1 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            return r0
        L22:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p003final.Cdo.getOAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    /* JADX WARN: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0020  */
    @Override // com.repack.bun.supplier.IdSupplier
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String getVAID() {
        /*
            r4 = this;
            java.lang.String r0 = ""
            android.content.Context r1 = r4.f26051b     // Catch: java.lang.Exception -> L1a
            boolean r2 = pk.a.f29922a     // Catch: java.lang.Exception -> L1a
            if (r2 != 0) goto L9
            goto L1c
        L9:
            boolean r2 = pk.a.f29923b     // Catch: java.lang.Exception -> L1a
            if (r2 == 0) goto L1c
            pk.b r2 = pk.b.a.f29929a     // Catch: java.lang.Exception -> L1a
            android.content.Context r1 = pk.a.a(r1)     // Catch: java.lang.Exception -> L1a
            java.lang.String r3 = "DUID"
            java.lang.String r1 = r2.a(r1, r3)     // Catch: java.lang.Exception -> L1a
            goto L1d
        L1a:
            r1 = move-exception
            goto L22
        L1c:
            r1 = r0
        L1d:
            if (r1 != 0) goto L20
            goto L21
        L20:
            r0 = r1
        L21:
            return r0
        L22:
            r1.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p003final.Cdo.getVAID():java.lang.String");
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        return pk.a.f29923b;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
        new Thread(new a(supplierListener)).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
    }
}
