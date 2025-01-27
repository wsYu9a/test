package com.vivo.push.d;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* loaded from: classes4.dex */
final class e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f30966a;

    /* renamed from: b */
    final /* synthetic */ com.vivo.push.b.i f30967b;

    /* renamed from: c */
    final /* synthetic */ d f30968c;

    e(d dVar, String str, com.vivo.push.b.i iVar) {
        this.f30968c = dVar;
        this.f30966a = str;
        this.f30967b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f30966a)) {
            d dVar = this.f30968c;
            PushMessageCallback pushMessageCallback = ((z) dVar).f30996b;
            context2 = ((com.vivo.push.l) dVar).f31028a;
            pushMessageCallback.onReceiveRegId(context2, this.f30966a);
        }
        d dVar2 = this.f30968c;
        PushMessageCallback pushMessageCallback2 = ((z) dVar2).f30996b;
        context = ((com.vivo.push.l) dVar2).f31028a;
        pushMessageCallback2.onBind(context, this.f30967b.h(), this.f30967b.d());
    }
}
