package com.oplus.quickgame.sdk.engine.d;

import com.oplus.quickgame.sdk.QuickGame;
import com.oplus.quickgame.sdk.engine.utils.i;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: c */
    private static a f16206c = new a();

    /* renamed from: a */
    private QuickGame.IStatisticsProvider f16207a = null;

    /* renamed from: b */
    private QuickGame.IStatisticsProvider f16208b = new C0366a(this);

    /* renamed from: com.oplus.quickgame.sdk.engine.d.a$a */
    class C0366a implements QuickGame.IStatisticsProvider {
        C0366a(a aVar) {
        }

        @Override // com.oplus.quickgame.sdk.QuickGame.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[");
                sb.append(str);
                sb.append(":");
                sb.append(map.get(str));
                sb.append("]");
            }
            i.b("router_stat", "fail to stat:" + sb.toString());
        }
    }

    private a() {
    }

    public static a b() {
        return f16206c;
    }

    public QuickGame.IStatisticsProvider a() {
        QuickGame.IStatisticsProvider iStatisticsProvider = this.f16207a;
        return iStatisticsProvider != null ? iStatisticsProvider : this.f16208b;
    }

    public void a(QuickGame.IStatisticsProvider iStatisticsProvider) {
        this.f16207a = iStatisticsProvider;
    }
}
