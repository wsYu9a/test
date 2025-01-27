package pi;

import android.content.Context;
import android.util.Log;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.repack.bun.miitmdid.core.MdidSdkHelper;
import com.repack.bun.supplier.IIdentifierListener;
import com.repack.bun.supplier.IdSupplier;
import com.shu.priory.config.AdKeys;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class j {

    /* renamed from: a */
    public String f29914a;

    /* renamed from: b */
    public String f29915b;

    /* renamed from: c */
    public String f29916c;

    /* renamed from: d */
    public long f29917d;

    /* renamed from: e */
    public int f29918e;

    /* renamed from: f */
    public boolean f29919f;

    public final JSONObject b() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(MediationConstant.KEY_ERROR_CODE, this.f29918e);
        jSONObject.put("isSupported", this.f29919f);
        jSONObject.put(AdKeys.OAID, this.f29914a);
        jSONObject.put("vaid", this.f29915b);
        jSONObject.put("aaid", this.f29916c);
        jSONObject.put("takeMs", this.f29917d);
        return jSONObject;
    }

    public final /* synthetic */ void c(long j10, boolean z10, IdSupplier idSupplier) {
        if (idSupplier != null && idSupplier.isSupported()) {
            this.f29914a = idSupplier.getOAID();
            this.f29915b = idSupplier.getVAID();
            this.f29916c = idSupplier.getAAID();
            this.f29919f = idSupplier.isSupported();
        }
        this.f29917d = System.currentTimeMillis() - j10;
        if (rh.d.d()) {
            StringBuilder a10 = nh.b.a("Msa Init: oaid = ");
            a10.append(this.f29914a);
            a10.append(" vaid = ");
            a10.append(this.f29915b);
            a10.append(" aaid = ");
            a10.append(this.f29916c);
            Log.d("new", a10.toString());
        }
    }

    public final void d(Context context) {
        this.f29918e = MdidSdkHelper.InitSdk(context, true, new IIdentifierListener() { // from class: pi.i

            /* renamed from: b */
            public final /* synthetic */ long f29913b;

            public /* synthetic */ i(long j10) {
                currentTimeMillis = j10;
            }

            @Override // com.repack.bun.supplier.IIdentifierListener
            public final void OnSupport(boolean z10, IdSupplier idSupplier) {
                j.this.c(currentTimeMillis, z10, idSupplier);
            }
        });
        if (rh.d.d()) {
            StringBuilder a10 = nh.b.a("Msa Init: code = ");
            a10.append(this.f29918e);
            Log.d("new", a10.toString());
        }
    }
}
