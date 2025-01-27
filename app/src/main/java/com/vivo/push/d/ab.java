package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class ab implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f30954a;

    /* renamed from: b */
    final /* synthetic */ List f30955b;

    /* renamed from: c */
    final /* synthetic */ List f30956c;

    /* renamed from: d */
    final /* synthetic */ String f30957d;

    /* renamed from: e */
    final /* synthetic */ aa f30958e;

    ab(aa aaVar, int i2, List list, List list2, String str) {
        this.f30958e = aaVar;
        this.f30954a = i2;
        this.f30955b = list;
        this.f30956c = list2;
        this.f30957d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.f30958e;
        PushMessageCallback pushMessageCallback = ((z) aaVar).f30996b;
        context = ((com.vivo.push.l) aaVar).f31028a;
        pushMessageCallback.onSetTags(context, this.f30954a, this.f30955b, this.f30956c, this.f30957d);
    }
}
