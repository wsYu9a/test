package p005import;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import qh.a;

/* renamed from: import.if */
/* loaded from: classes4.dex */
public final class Cif implements InnerIdSupplier {

    /* renamed from: b */
    public Context f27050b;

    public Cif(Context context) {
        this.f27050b = context;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        String a10 = a.a(this.f27050b, a.f30081e);
        return TextUtils.isEmpty(a10) ? "" : a10;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        String a10 = a.a(this.f27050b, a.f30079c);
        return a10 == null ? "" : a10;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        String a10 = a.a(this.f27050b, a.f30080d);
        return a10 == null ? "" : a10;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        return (a.f30078b == null || a.f30077a == null) ? false : true;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return true;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
    }
}
