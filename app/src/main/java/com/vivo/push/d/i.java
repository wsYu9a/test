package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f30969a;

    /* renamed from: b */
    final /* synthetic */ List f30970b;

    /* renamed from: c */
    final /* synthetic */ List f30971c;

    /* renamed from: d */
    final /* synthetic */ String f30972d;

    /* renamed from: e */
    final /* synthetic */ h f30973e;

    i(h hVar, int i2, List list, List list2, String str) {
        this.f30973e = hVar;
        this.f30969a = i2;
        this.f30970b = list;
        this.f30971c = list2;
        this.f30972d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f30973e;
        PushMessageCallback pushMessageCallback = ((z) hVar).f30996b;
        context = ((com.vivo.push.l) hVar).f31028a;
        pushMessageCallback.onDelTags(context, this.f30969a, this.f30970b, this.f30971c, this.f30972d);
    }
}
