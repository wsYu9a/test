package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.m f30979a;

    /* renamed from: b */
    final /* synthetic */ l f30980b;

    m(l lVar, com.vivo.push.b.m mVar) {
        this.f30980b = lVar;
        this.f30979a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f30980b;
        PushMessageCallback pushMessageCallback = ((z) lVar).f30996b;
        context = ((com.vivo.push.l) lVar).f31028a;
        pushMessageCallback.onListTags(context, this.f30979a.h(), this.f30979a.d(), this.f30979a.g());
    }
}
