package com.oplus.instant.router.e;

import android.content.Context;
import com.oplus.instant.router.callback.Callback;
import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.callback.Callback;
import com.oplus.quickgame.sdk.engine.utils.QgRouterManager;

/* loaded from: classes4.dex */
public class e extends com.oplus.instant.router.e.a {

    class a extends Callback {

        /* renamed from: a */
        final /* synthetic */ com.oplus.instant.router.callback.Callback f16070a;

        a(e eVar, com.oplus.instant.router.callback.Callback callback) {
            this.f16070a = callback;
        }

        @Override // com.oplus.quickgame.sdk.engine.callback.Callback
        public void onResponse(Callback.Response response) {
            Callback.Response response2 = new Callback.Response();
            response2.setCode(response.getCode());
            response2.setMsg(response.getMsg());
            this.f16070a.onResponse(response2);
        }
    }

    e(b bVar) {
        super(bVar);
    }

    private com.oplus.quickgame.sdk.engine.callback.Callback a(com.oplus.instant.router.callback.Callback callback) {
        if (callback != null) {
            return new a(this, callback);
        }
        return null;
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void preload(Context context) {
        QuickGame.Req createReq = QgRouterManager.createReq(context, this.f16062f, this.f16057a, this.f16058b, this.f16059c, this.f16060d, a(this.f16061e));
        if (createReq != null) {
            createReq.preload(context);
        } else {
            com.oplus.instant.router.h.e.t(context.getApplicationContext(), this.f16062f, this.f16057a, this.f16058b, this.f16059c, this.f16060d, this.f16061e);
        }
    }

    @Override // com.oplus.instant.router.Instant.Req
    public void request(Context context) {
        QuickGame.Req createReq = QgRouterManager.createReq(context, this.f16062f, this.f16057a, this.f16058b, this.f16059c, this.f16060d, a(this.f16061e));
        if (createReq == null) {
            com.oplus.instant.router.h.e.j(context, this.f16062f, this.f16057a, this.f16058b, this.f16059c, this.f16060d, this.f16061e);
        } else {
            createReq.request(context);
            com.oplus.instant.router.h.d.b("XGame_Router_TAG", "router newEngineRequest.request ");
        }
    }
}
