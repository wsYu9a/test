package p001const;

import android.content.Context;
import com.repack.bun.lib.sysParamters;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import jh.c;

/* renamed from: const.if */
/* loaded from: classes4.dex */
public final class Cif implements InnerIdSupplier {

    /* renamed from: b */
    public Context f25189b;

    /* renamed from: const.if$a */
    public class a implements Runnable {

        /* renamed from: b */
        public final SupplierListener f25190b;

        public a(SupplierListener supplierListener) {
            this.f25190b = supplierListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                SupplierListener supplierListener = this.f25190b;
                if (supplierListener != null) {
                    supplierListener.OnSupport(Cif.this.isSupported(), Cif.this);
                }
            } catch (Exception e10) {
                c.b("buniasuplier", "exception", e10);
            }
        }
    }

    public Cif(Context context) {
        this.f25189b = context;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        try {
            return ah.a.a(this.f25189b, sysParamters.d());
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        try {
            return ah.a.c(this.f25189b);
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        try {
            return ah.a.d(this.f25189b, sysParamters.d());
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        try {
            return ah.a.b(this.f25189b);
        } catch (Exception unused) {
            return false;
        }
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
