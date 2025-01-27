package mh;

import android.content.Context;
import android.os.IBinder;
import com.repack.asus.msa.sdid.SupplementaryDIDManager;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;

/* loaded from: classes4.dex */
public final class a implements InnerIdSupplier, nh.a {

    /* renamed from: b */
    public SupplierListener f28699b;

    /* renamed from: g */
    public SupplementaryDIDManager f28704g;

    /* renamed from: c */
    public String f28700c = "";

    /* renamed from: d */
    public String f28701d = "";

    /* renamed from: e */
    public String f28702e = "";

    /* renamed from: f */
    public String f28703f = "";

    /* renamed from: h */
    public boolean f28705h = false;

    /* renamed from: i */
    public boolean f28706i = false;

    public a(Context context, SupplierListener supplierListener) {
        this.f28699b = supplierListener;
        this.f28704g = new SupplementaryDIDManager(context);
    }

    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return null;
    }

    public final void g(eh.a aVar) {
        try {
            String udid = aVar.getUDID();
            this.f28700c = udid;
            if (udid == null) {
                this.f28700c = "";
            }
        } catch (Exception unused) {
        }
        try {
            String oaid = aVar.getOAID();
            this.f28701d = oaid;
            if (oaid == null) {
                this.f28701d = "";
            }
        } catch (Exception unused2) {
        }
        try {
            String vaid = aVar.getVAID();
            this.f28702e = vaid;
            if (vaid == null) {
                this.f28702e = "";
            }
        } catch (Exception unused3) {
        }
        try {
            String aaid = aVar.getAAID();
            this.f28703f = aaid;
            if (aaid == null) {
                this.f28703f = "";
            }
        } catch (Exception unused4) {
        }
        try {
            this.f28706i = aVar.m();
        } catch (Exception unused5) {
        }
        this.f28705h = true;
        SupplierListener supplierListener = this.f28699b;
        if (supplierListener != null) {
            supplierListener.OnSupport(this.f28706i, this);
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        return this.f28703f;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        return this.f28701d;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return this.f28700c;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        return this.f28702e;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        return this.f28706i;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
        this.f28704g.init(this);
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
        SupplementaryDIDManager supplementaryDIDManager;
        if (!this.f28705h || (supplementaryDIDManager = this.f28704g) == null) {
            return;
        }
        supplementaryDIDManager.deInit();
    }
}
