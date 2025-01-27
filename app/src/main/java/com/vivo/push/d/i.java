package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f24996a;

    /* renamed from: b */
    final /* synthetic */ List f24997b;

    /* renamed from: c */
    final /* synthetic */ List f24998c;

    /* renamed from: d */
    final /* synthetic */ String f24999d;

    /* renamed from: e */
    final /* synthetic */ h f25000e;

    public i(h hVar, int i10, List list, List list2, String str) {
        this.f25000e = hVar;
        this.f24996a = i10;
        this.f24997b = list;
        this.f24998c = list2;
        this.f24999d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f25000e;
        PushMessageCallback pushMessageCallback = ((z) hVar).f25023b;
        context = ((com.vivo.push.l) hVar).f25064a;
        pushMessageCallback.onDelTags(context, this.f24996a, this.f24997b, this.f24998c, this.f24999d);
    }
}
