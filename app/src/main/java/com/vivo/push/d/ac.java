package com.vivo.push.d;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* loaded from: classes4.dex */
final class ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f30959a;

    /* renamed from: b */
    final /* synthetic */ List f30960b;

    /* renamed from: c */
    final /* synthetic */ List f30961c;

    /* renamed from: d */
    final /* synthetic */ String f30962d;

    /* renamed from: e */
    final /* synthetic */ aa f30963e;

    ac(aa aaVar, int i2, List list, List list2, String str) {
        this.f30963e = aaVar;
        this.f30959a = i2;
        this.f30960b = list;
        this.f30961c = list2;
        this.f30962d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        aa aaVar = this.f30963e;
        PushMessageCallback pushMessageCallback = ((z) aaVar).f30996b;
        context = ((com.vivo.push.l) aaVar).f31028a;
        pushMessageCallback.onSetAlias(context, this.f30959a, this.f30960b, this.f30961c, this.f30962d);
    }
}
