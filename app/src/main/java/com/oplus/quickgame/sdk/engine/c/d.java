package com.oplus.quickgame.sdk.engine.c;

import android.content.Context;
import com.oplus.quickgame.sdk.engine.utils.g;
import com.oplus.quickgame.sdk.engine.utils.j;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class d extends a {
    d(b bVar) {
        super(bVar);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void preload(Context context) {
        if (this.f16192d == null) {
            this.f16192d = new HashMap(1);
        }
        j.a(context, this.f16194f, this.f16189a, this.f16190b, this.f16191c, this.f16192d, this.f16193e);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqCleanGameCache(Context context) {
        g.a(context, this.f16193e, this.f16190b.get("origin"), this.f16190b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqCleanOneGameCache(Context context, String str) {
        g.a(context, this.f16193e, this.f16190b.get("origin"), this.f16190b.get("secret"), str);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqGameCacheSize(Context context) {
        g.b(context, this.f16193e, this.f16190b.get("origin"), this.f16190b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqGamePkgList(Context context) {
        g.c(context, this.f16193e, this.f16190b.get("origin"), this.f16190b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void reqReportErrorLog(Context context) {
        g.d(context, this.f16193e, this.f16190b.get("origin"), this.f16190b.get("secret"));
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.Req
    public void request(Context context) {
        if (this.f16192d == null) {
            this.f16192d = new HashMap(1);
        }
        j.b(context, this.f16194f, this.f16189a, this.f16190b, this.f16191c, this.f16192d, this.f16193e);
    }
}
