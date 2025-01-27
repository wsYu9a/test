package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class j implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f30974a;

    /* renamed from: b */
    final /* synthetic */ List f30975b;

    /* renamed from: c */
    final /* synthetic */ List f30976c;

    /* renamed from: d */
    final /* synthetic */ String f30977d;

    /* renamed from: e */
    final /* synthetic */ h f30978e;

    j(h hVar, int i2, List list, List list2, String str) {
        this.f30978e = hVar;
        this.f30974a = i2;
        this.f30975b = list;
        this.f30976c = list2;
        this.f30977d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        h hVar = this.f30978e;
        PushMessageCallback pushMessageCallback = ((z) hVar).f30996b;
        context = ((com.vivo.push.l) hVar).f31028a;
        pushMessageCallback.onDelAlias(context, this.f30974a, this.f30975b, this.f30976c, this.f30977d);
    }
}
