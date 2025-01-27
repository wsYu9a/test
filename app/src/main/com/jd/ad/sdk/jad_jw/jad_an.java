package com.jd.ad.sdk.jad_jw;

import android.text.TextUtils;
import com.bun.miitmdid.interfaces.IIdentifierListener;
import com.bun.miitmdid.interfaces.IdSupplier;
import com.jd.ad.sdk.jad_uh.jad_an;

/* loaded from: classes2.dex */
public class jad_an {
    public static String jad_an = "";

    /* renamed from: com.jd.ad.sdk.jad_jw.jad_an$jad_an */
    public class C0330jad_an implements IIdentifierListener {
        public void OnSupport(boolean z10, IdSupplier idSupplier) {
            if (z10 && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void onSupport(IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0066 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x011e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00c5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0065 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void jad_an(android.content.Context r10) {
        /*
            Method dump skipped, instructions count: 419
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_jw.jad_an.jad_an(android.content.Context):void");
    }

    public class jad_bo implements com.bun.miitmdid.core.IIdentifierListener {
        public void OnSupport(boolean z10, com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (z10 && idSupplier != null && idSupplier.isSupported()) {
                String oaid = idSupplier.getOAID();
                jad_an.jad_an = oaid;
                if (TextUtils.isEmpty(oaid)) {
                    return;
                }
                com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
                jad_anVar.jad_an("refo", jad_an.jad_an);
                jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
            }
        }

        public void OnSupport(com.bun.miitmdid.supplier.IdSupplier idSupplier) {
            if (idSupplier == null || !idSupplier.isSupported()) {
                return;
            }
            String oaid = idSupplier.getOAID();
            jad_an.jad_an = oaid;
            if (TextUtils.isEmpty(oaid)) {
                return;
            }
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            jad_anVar.jad_an("refo", jad_an.jad_an);
            jad_anVar.jad_an("refot", Long.valueOf(System.currentTimeMillis()));
        }
    }
}
