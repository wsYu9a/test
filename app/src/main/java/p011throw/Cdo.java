package p011throw;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import jh.c;
import zk.b;

/* renamed from: throw.do */
/* loaded from: classes5.dex */
public final class Cdo implements InnerIdSupplier {

    /* renamed from: b */
    public String f30903b = "";

    /* renamed from: c */
    public Context f30904c;

    /* renamed from: throw.do$a */
    public class a implements Runnable {

        /* renamed from: b */
        public final SupplierListener f30905b;

        public a(SupplierListener supplierListener) {
            this.f30905b = supplierListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                SupplierListener supplierListener = this.f30905b;
                if (supplierListener == null) {
                    return;
                }
                if (Build.VERSION.SDK_INT < 28) {
                    supplierListener.OnSupport(false, new DefaultSupplier());
                } else {
                    supplierListener.OnSupport(Cdo.this.isSupported(), Cdo.this);
                }
            } catch (Exception e10) {
                c.b("vivosuplier", "exception", e10);
            }
        }
    }

    public Cdo(Context context) {
        this.f30904c = context;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        String str;
        Context context = this.f30904c;
        String str2 = this.f30903b;
        b a10 = b.a(context);
        a10.getClass();
        if (b.f33873b) {
            String str3 = b.f33885n;
            if (str3 != null) {
                str = str3;
            } else {
                a10.b(2, str2);
                if (b.f33878g == null && b.f33885n != null) {
                    b.c(b.f33872a, 2, str2);
                }
                str = b.f33885n;
            }
        } else {
            str = null;
        }
        return TextUtils.isEmpty(str) ? "" : str;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        b a10 = b.a(this.f30904c);
        a10.getClass();
        String str = null;
        if (b.f33873b) {
            String str2 = b.f33883l;
            if (str2 != null) {
                str = str2;
            } else {
                a10.b(0, null);
                if (b.f33876e == null) {
                    b.c(b.f33872a, 0, null);
                }
                str = b.f33883l;
            }
        }
        return str == null ? "" : str;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        String str;
        Context context = this.f30904c;
        String str2 = this.f30903b;
        b a10 = b.a(context);
        a10.getClass();
        if (b.f33873b) {
            String str3 = b.f33884m;
            if (str3 != null) {
                str = str3;
            } else {
                a10.b(1, str2);
                if (b.f33877f == null && b.f33884m != null) {
                    b.c(b.f33872a, 1, str2);
                }
                str = b.f33884m;
            }
        } else {
            str = null;
        }
        return str == null ? "" : str;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        b.a(this.f30904c).getClass();
        return b.f33873b;
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
