package com.vivo.mobilead.i;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.ic.SystemUtils;
import com.vivo.mobilead.util.h0;
import com.vivo.mobilead.util.n0;
import com.vivo.mobilead.util.w0;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Callable;

/* loaded from: classes4.dex */
public class n implements Callable<List<com.vivo.ad.model.b>> {

    /* renamed from: a */
    private f f28902a;

    /* renamed from: b */
    private o f28903b;

    public n(String str, String str2, int i2, int i3, int i4, int i5, int i6, HashMap<String, String> hashMap, o oVar, int i7, int i8, String str3, int i9, int i10) {
        this.f28903b = oVar;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("positionId", str);
        if (i8 != -1) {
            hashMap2.put("bidFloor", String.valueOf(i8));
        }
        if (!TextUtils.isEmpty(str3)) {
            hashMap2.put("miniProgramAppId", str3);
        }
        if (i9 != 0) {
            hashMap2.put("browserVersion", String.valueOf(i9));
        }
        hashMap2.put("isSupportMiniProgram", String.valueOf(i10));
        str2 = TextUtils.isEmpty(str2) ? "" : str2;
        if (i2 == 2) {
            hashMap2.put("orientationSplash", String.valueOf(com.vivo.mobilead.manager.b.l().getInt("splash_orientation_key", 1)));
            hashMap2.put("launchType", "0");
        } else if (i2 == 4) {
            hashMap2.put("materialRequireType", String.valueOf(i3));
        } else if (i2 != 5) {
            hashMap2.put("orientationSplash", String.valueOf(w0.c()));
        } else {
            hashMap2.put("renderStyle", String.valueOf(i7));
        }
        hashMap2.put("renderType", String.valueOf(i4));
        hashMap2.put("sourceAppend", str2);
        String a2 = g.a(hashMap);
        if (!TextUtils.isEmpty(a2)) {
            hashMap2.put("extParam", g.b(a2));
        }
        hashMap2.put("ua", h0.K().t());
        if (SystemUtils.isVivoPhone() && h0.K().I()) {
            hashMap2.put("appStoreList", n0.b().a(i2));
        }
        Context c2 = com.vivo.mobilead.manager.f.j().c();
        if (c2 != null) {
            com.vivo.ad.model.n a3 = com.vivo.mobilead.manager.d.a().a(c2);
            if (a3 != null) {
                int a4 = a3.a();
                int b2 = a3.b();
                hashMap2.put("rpkPkgVerCode", String.valueOf(a4));
                hashMap2.put("rpkPVerCode", String.valueOf(b2));
            }
            if (SystemUtils.isVivoPhone()) {
                hashMap2.put("appstoreSecurityCode", com.vivo.ad.g.a.a(c2));
            }
        }
        if (2 == i4 && 5 == i2) {
            hashMap2.put("adCount", String.valueOf(i5));
        }
        hashMap2.put("interfaceVersion", String.valueOf(i6));
        this.f28902a = new f(2, com.vivo.mobilead.model.a.f29553c, hashMap2, null, new com.vivo.mobilead.j.a(i2, i7));
    }

    @Override // java.util.concurrent.Callable
    public List<com.vivo.ad.model.b> call() throws Exception {
        try {
            List<com.vivo.ad.model.b> list = (List) new b(this.f28902a).a();
            o oVar = this.f28903b;
            if (oVar != null) {
                oVar.a(list);
            }
            return list;
        } catch (c e2) {
            o oVar2 = this.f28903b;
            if (oVar2 == null) {
                return null;
            }
            oVar2.a(e2.a(), e2.b());
            return null;
        }
    }
}
