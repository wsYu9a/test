package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f25001a;

    /* renamed from: b */
    final /* synthetic */ List f25002b;

    /* renamed from: c */
    final /* synthetic */ List f25003c;

    /* renamed from: d */
    final /* synthetic */ String f25004d;

    /* renamed from: e */
    final /* synthetic */ h f25005e;

    public j(h hVar, int i10, List list, List list2, String str) {
        this.f25005e = hVar;
        this.f25001a = i10;
        this.f25002b = list;
        this.f25003c = list2;
        this.f25004d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f25005e;
        PushMessageCallback pushMessageCallback = ((z) hVar).f25023b;
        context = ((com.vivo.push.l) hVar).f25064a;
        pushMessageCallback.onDelAlias(context, this.f25001a, this.f25002b, this.f25003c, this.f25004d);
    }
}
