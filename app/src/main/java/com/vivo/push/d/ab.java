package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24981a;

    /* renamed from: b */
    final /* synthetic */ List f24982b;

    /* renamed from: c */
    final /* synthetic */ List f24983c;

    /* renamed from: d */
    final /* synthetic */ String f24984d;

    /* renamed from: e */
    final /* synthetic */ aa f24985e;

    public ab(aa aaVar, int i10, List list, List list2, String str) {
        this.f24985e = aaVar;
        this.f24981a = i10;
        this.f24982b = list;
        this.f24983c = list2;
        this.f24984d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.f24985e;
        PushMessageCallback pushMessageCallback = ((z) aaVar).f25023b;
        context = ((com.vivo.push.l) aaVar).f25064a;
        pushMessageCallback.onSetTags(context, this.f24981a, this.f24982b, this.f24983c, this.f24984d);
    }
}
