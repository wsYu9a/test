package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24986a;

    /* renamed from: b */
    final /* synthetic */ List f24987b;

    /* renamed from: c */
    final /* synthetic */ List f24988c;

    /* renamed from: d */
    final /* synthetic */ String f24989d;

    /* renamed from: e */
    final /* synthetic */ aa f24990e;

    public ac(aa aaVar, int i10, List list, List list2, String str) {
        this.f24990e = aaVar;
        this.f24986a = i10;
        this.f24987b = list;
        this.f24988c = list2;
        this.f24989d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.f24990e;
        PushMessageCallback pushMessageCallback = ((z) aaVar).f25023b;
        context = ((com.vivo.push.l) aaVar).f25064a;
        pushMessageCallback.onSetAlias(context, this.f24986a, this.f24987b, this.f24988c, this.f24989d);
    }
}
