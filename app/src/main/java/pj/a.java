package pj;

import android.content.Context;
import com.repack.bun.miitmdid.supplier.sumsung.SumsungCore;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* loaded from: classes4.dex */
public final class a implements InnerIdSupplier, w0.a {

    /* renamed from: b */
    public SupplierListener f29920b;

    /* renamed from: c */
    public SumsungCore f29921c;

    public a(Context context, SupplierListener supplierListener) {
        this.f29920b = supplierListener;
        this.f29921c = new SumsungCore(context, this);
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        String aaid;
        return (!isSupported() || (aaid = this.f29921c.getAAID()) == null) ? "" : aaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        String oaid;
        return (!isSupported() || (oaid = this.f29921c.getOAID()) == null) ? "" : oaid;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        String udid;
        return (!isSupported() || (udid = this.f29921c.getUDID()) == null) ? "" : udid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        String vaid;
        return (!isSupported() || (vaid = this.f29921c.getVAID()) == null) ? "" : vaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        SumsungCore sumsungCore = this.f29921c;
        if (sumsungCore != null) {
            return sumsungCore.isSupported();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // w0.a
    public final void l() {
        SupplierListener supplierListener = this.f29920b;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // w0.a
    public final void m() {
        SupplierListener supplierListener = this.f29920b;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, new DefaultSupplier());
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
        SumsungCore sumsungCore = this.f29921c;
        if (sumsungCore != null) {
            sumsungCore.shutdown();
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
    }
}
