package p010this;

import android.content.Context;
import android.text.TextUtils;
import com.repack.bun.supplier.DefaultSupplier;
import com.repack.bun.supplier.InnerIdSupplier;
import com.repack.bun.supplier.SupplierListener;
import com.repack.huawei.hms.ads.identifier.AdvertisingIdClient;
import jh.c;

/* renamed from: this.do */
/* loaded from: classes5.dex */
public final class Cdo implements InnerIdSupplier {

    /* renamed from: b */
    public Context f30898b;

    /* renamed from: c */
    public String f30899c = "";

    /* renamed from: d */
    public boolean f30900d = false;

    /* renamed from: e */
    public SupplierListener f30901e;

    /* renamed from: this.do$a */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(Cdo.this.f30898b);
                Cdo.this.f30899c = advertisingIdInfo.getId();
                advertisingIdInfo.isLimitAdTrackingEnabled();
            } catch (Exception e10) {
                c.b(Cdo.class.getSimpleName(), "thread", e10);
            }
            Cdo cdo = Cdo.this;
            cdo.getClass();
            try {
                boolean z10 = !TextUtils.isEmpty(cdo.f30899c);
                cdo.f30900d = z10;
                if (z10) {
                    SupplierListener supplierListener = cdo.f30901e;
                    if (supplierListener != null) {
                        supplierListener.OnSupport(z10, cdo);
                    }
                } else {
                    SupplierListener supplierListener2 = cdo.f30901e;
                    if (supplierListener2 != null) {
                        supplierListener2.OnSupport(z10, new DefaultSupplier());
                    }
                }
            } catch (Exception e11) {
                c.b(Cdo.class.getSimpleName(), "CallBack", e11);
            }
        }
    }

    public Cdo(Context context) {
        this.f30898b = context;
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getAAID() {
        TextUtils.isEmpty("");
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getOAID() {
        return this.f30899c;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final String getUDID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final String getVAID() {
        return "";
    }

    @Override // com.repack.bun.supplier.IdSupplier
    public final boolean isSupported() {
        return this.f30900d;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final boolean j() {
        return false;
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void k(SupplierListener supplierListener) {
        this.f30901e = supplierListener;
        new Thread(new a()).start();
    }

    @Override // com.repack.bun.supplier.InnerIdSupplier
    public final void shutDown() {
    }
}
