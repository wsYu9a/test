package com.oplus.quickgame.sdk.hall.a;

import com.oplus.quickgame.sdk.QuickGame;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class a extends QuickGame.GameHallRouterBuilder {

    /* renamed from: a */
    private Map<String, Object> f16262a = new HashMap();

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public String build() {
        return com.oplus.quickgame.sdk.hall.b.a.a(this.f16262a);
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setHost(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f16262a).b(str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setParams(Map<String, Object> map) {
        if (map != null) {
            com.oplus.quickgame.sdk.hall.c.b.b(this.f16262a).a(map);
        }
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setPath(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f16262a).c(str);
        return this;
    }

    @Override // com.oplus.quickgame.sdk.QuickGame.GameHallRouterBuilder
    public QuickGame.GameHallRouterBuilder setScheme(String str) {
        com.oplus.quickgame.sdk.hall.c.b.b(this.f16262a).d(str);
        return this;
    }
}
