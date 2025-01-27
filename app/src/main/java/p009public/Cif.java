package p009public;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.lib.sysParamters;
import com.repack.bun.miitmdid.supplier.msa.MsaClient;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import w0.a;

/* renamed from: public.if */
/* loaded from: classes4.dex */
public final class Cif implements InnerIdSupplier, a {

    /* renamed from: b */
    public SupplierListener f29931b;

    /* renamed from: c */
    public MsaClient f29932c;

    public Cif(Context context) {
        if (MsaClient.CheckService(context)) {
            String d10 = sysParamters.d();
            if (!TextUtils.isEmpty(d10)) {
                MsaClient.StartMsaKlService(context, d10);
            }
            this.f29932c = new MsaClient(context, this);
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        String aaid;
        return (!isSupported() || (aaid = this.f29932c.getAAID()) == null) ? "" : aaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        String oaid;
        return (!isSupported() || (oaid = this.f29932c.getOAID()) == null) ? "" : oaid;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        String udid;
        return (!isSupported() || (udid = this.f29932c.getUDID()) == null) ? "" : udid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        String vaid;
        return (!isSupported() || (vaid = this.f29932c.getVAID()) == null) ? "" : vaid;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        MsaClient msaClient = this.f29932c;
        if (msaClient != null) {
            return msaClient.isSupported();
        }
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
        this.f29931b = supplierListener;
        MsaClient msaClient = this.f29932c;
        if (msaClient != null) {
            msaClient.BindService(sysParamters.d());
        } else {
            m();
        }
    }

    @Override // w0.a
    public final void l() {
        SupplierListener supplierListener = this.f29931b;
        if (supplierListener != null) {
            supplierListener.OnSupport(isSupported(), this);
        }
    }

    @Override // w0.a
    public final void m() {
        SupplierListener supplierListener = this.f29931b;
        if (supplierListener != null) {
            supplierListener.OnSupport(false, new DefaultSupplier());
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
        MsaClient msaClient = this.f29932c;
        if (msaClient != null) {
            msaClient.shutdown();
        }
    }
}
