package com.wbl.ad.yzz.wigdet.h;

import android.app.Dialog;
import android.content.Context;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.wbl.ad.yzz.wigdet.h.e;
import com.wbl.ad.yzz.wigdet.h.f;

/* loaded from: classes5.dex */
public class a {

    /* renamed from: a */
    public static volatile a f34431a;

    public static a a() {
        return (a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-8558, null, null);
    }

    public Dialog a(Context context, boolean z, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i2, f.InterfaceC0800f interfaceC0800f, f.e eVar, f.d dVar) {
        e.d dVar2 = new e.d(context);
        dVar2.a(z).i(str).g(str9).h(str2).c(str3).d(str4).e(str5).f(str6).a(str8).a(i2).b(str7);
        if (eVar != null) {
            dVar2.a(eVar);
        }
        if (interfaceC0800f != null) {
            dVar2.a(interfaceC0800f);
        }
        if (dVar != null) {
            dVar2.a(dVar);
        }
        return dVar2.a().b();
    }
}
