package p000catch;

import android.content.Context;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import kj.b;
import kj.c;

/* renamed from: catch.do */
/* loaded from: classes.dex */
public final class Cdo implements InnerIdSupplier {

    /* renamed from: b */
    public Context f1762b;

    public Cdo(Context context) {
        this.f1762b = context;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        try {
            Context context = this.f1762b;
            b b10 = b.b();
            return b10.a(context.getApplicationContext(), b10.f27852c);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        try {
            Context context = this.f1762b;
            b b10 = b.b();
            return b10.a(context.getApplicationContext(), b10.f27851b);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        try {
            Context context = this.f1762b;
            b b10 = b.b();
            return b10.a(context.getApplicationContext(), b10.f27850a);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        try {
            Context context = this.f1762b;
            b b10 = b.b();
            return b10.a(context.getApplicationContext(), b10.f27853d);
        } catch (Throwable unused) {
            return "";
        }
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        try {
            return c.a();
        } catch (Throwable unused) {
            return false;
        }
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
