package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ com.vivo.push.b.m f25006a;

    /* renamed from: b */
    final /* synthetic */ l f25007b;

    public m(l lVar, com.vivo.push.b.m mVar) {
        this.f25007b = lVar;
        this.f25006a = mVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        l lVar = this.f25007b;
        PushMessageCallback pushMessageCallback = ((z) lVar).f25023b;
        context = ((com.vivo.push.l) lVar).f25064a;
        pushMessageCallback.onListTags(context, this.f25006a.h(), this.f25006a.d(), this.f25006a.g());
    }
}
