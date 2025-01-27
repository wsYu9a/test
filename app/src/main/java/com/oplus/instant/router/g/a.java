package com.oplus.instant.router.g;

import com.oplus.instant.router.Instant;
import com.oplus.instant.router.h.d;
import java.util.Map;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    private static a f16078a = new a();

    /* renamed from: b */
    private Instant.IStatisticsProvider f16079b = null;

    /* renamed from: c */
    private Instant.IStatisticsProvider f16080c = new C0364a(this);

    /* renamed from: com.oplus.instant.router.g.a$a */
    class C0364a implements Instant.IStatisticsProvider {
        C0364a(a aVar) {
        }

        @Override // com.oplus.instant.router.Instant.IStatisticsProvider
        public void onStat(Map<String, String> map) {
            StringBuilder sb = new StringBuilder();
            for (String str : map.keySet()) {
                sb.append("[");
                sb.append(str);
                sb.append(":");
                sb.append(map.get(str));
                sb.append("]");
            }
            d.f("router_stat", "fail to stat:" + sb.toString());
        }
    }

    private a() {
    }

    public static a a() {
        return f16078a;
    }

    public void b(Instant.IStatisticsProvider iStatisticsProvider) {
        this.f16079b = iStatisticsProvider;
    }

    public Instant.IStatisticsProvider c() {
        Instant.IStatisticsProvider iStatisticsProvider = this.f16079b;
        return iStatisticsProvider != null ? iStatisticsProvider : this.f16080c;
    }
}
