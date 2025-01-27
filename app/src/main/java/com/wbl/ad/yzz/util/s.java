package com.wbl.ad.yzz.util;

import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;

/* loaded from: classes5.dex */
public class s {

    /* renamed from: a */
    public static final com.wbl.ad.yzz.bean.o f34373a = new com.wbl.ad.yzz.bean.n("wbloaidkey", true);

    /* renamed from: b */
    public static final com.wbl.ad.yzz.bean.o f34374b = new com.wbl.ad.yzz.bean.n("wblimeikey", false);

    public static class a implements IIdentifierListener {

        /* renamed from: a */
        public final /* synthetic */ Context f34375a;

        public a(Context context) {
            this.f34375a = context;
        }

        public void OnSupport(boolean z, IdSupplier idSupplier) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8336, this, Boolean.valueOf(z), idSupplier);
        }
    }

    public static /* synthetic */ com.wbl.ad.yzz.bean.o a() {
        return (com.wbl.ad.yzz.bean.o) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8335, null, null);
    }

    public static String a(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8330, null, context);
    }

    public static void a(int i2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8329, null, Integer.valueOf(i2));
    }

    public static String b(Context context) {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8332, null, context);
    }

    public static void c(Context context) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-8331, null, context);
    }
}
