package com.aggmoread.sdk.z.d.a.a.d.a.d.r;

import android.text.TextUtils;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public class d {

    /* renamed from: a */
    private static final Map<b, com.aggmoread.sdk.z.d.a.a.d.a.d.r.b<?>> f5547a = new ConcurrentHashMap();

    /* renamed from: b */
    private static volatile d f5548b;

    public static /* synthetic */ class a {

        /* renamed from: a */
        static final /* synthetic */ int[] f5549a;

        static {
            int[] iArr = new int[com.aggmoread.sdk.z.d.a.a.c.i.values().length];
            f5549a = iArr;
            try {
                iArr[com.aggmoread.sdk.z.d.a.a.c.i.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.SPLASH.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.INTERSTITIAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.REWARD_VIDEO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.FULL_SCREEN_VIDEO.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.DRAW.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f5549a[com.aggmoread.sdk.z.d.a.a.c.i.MIX_INFORMATION_FLOW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    public static final class b extends Enum<b> {

        /* renamed from: b */
        public static final b f5550b = new b("BANNER", 0, 1);

        /* renamed from: c */
        public static final b f5551c = new b("SPLASH", 1, 2);

        /* renamed from: d */
        public static final b f5552d = new b("INTERSTITIAL", 2, 3);

        /* renamed from: e */
        public static final b f5553e = new b("NATIVE_AD", 3, 4);

        /* renamed from: f */
        public static final b f5554f = new b("EXPRESS_AD", 4, 9);

        /* renamed from: g */
        public static final b f5555g = new b("REWARD_VIDEO", 5, 5);

        /* renamed from: h */
        public static final b f5556h = new b("DRAW", 6, 8);

        /* renamed from: i */
        public static final b f5557i = new b("FULL_SCREEN_VIDEO", 7, 7);

        /* renamed from: j */
        public static final b f5558j = new b("MXI_FEED_AD", 8, 9);

        private b(String str, int i10, int i11) {
            super(str, i10);
        }
    }

    private d() {
        Map<b, com.aggmoread.sdk.z.d.a.a.d.a.d.r.b<?>> map = f5547a;
        map.put(b.f5553e, new n());
        map.put(b.f5554f, new g());
        map.put(b.f5551c, new m());
        map.put(b.f5555g, new l());
        map.put(b.f5552d, new i());
        map.put(b.f5557i, new h());
        map.put(b.f5550b, new com.aggmoread.sdk.z.d.a.a.d.a.d.r.a());
        map.put(b.f5556h, new f());
        map.put(b.f5558j, new j());
    }

    private com.aggmoread.sdk.z.d.a.a.d.a.d.r.b<?> a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        Map<b, com.aggmoread.sdk.z.d.a.a.d.a.d.r.b<?>> map;
        b bVar;
        String c10 = eVar.f5907c.c(e.c.U);
        try {
            if (!TextUtils.isEmpty(c10)) {
                if (dVar.f5859e.a() == Integer.parseInt(c10)) {
                    switch (a.f5549a[dVar.f5859e.ordinal()]) {
                        case 1:
                            map = f5547a;
                            bVar = b.f5550b;
                            break;
                        case 2:
                            map = f5547a;
                            bVar = b.f5551c;
                            break;
                        case 3:
                            map = f5547a;
                            bVar = b.f5552d;
                            break;
                        case 4:
                            map = f5547a;
                            bVar = b.f5555g;
                            break;
                        case 5:
                            String a10 = eVar.f5907c.a(e.c.S, "2");
                            com.aggmoread.sdk.z.d.a.a.e.e.b("xxx", "v1 " + a10 + ", v2 " + dVar.f5860f);
                            if (!TextUtils.isEmpty(dVar.f5860f) && dVar.f5860f.equals(a10)) {
                                if (!a10.equalsIgnoreCase("2")) {
                                    map = f5547a;
                                    bVar = b.f5554f;
                                    break;
                                } else {
                                    map = f5547a;
                                    bVar = b.f5553e;
                                    break;
                                }
                            }
                            break;
                        case 6:
                            map = f5547a;
                            bVar = b.f5557i;
                            break;
                        case 7:
                            map = f5547a;
                            bVar = b.f5556h;
                            break;
                        case 8:
                            map = f5547a;
                            bVar = b.f5558j;
                            break;
                    }
                } else if (dVar.f5859e.a() == com.aggmoread.sdk.z.d.a.a.c.i.DRAW.a()) {
                    map = f5547a;
                    bVar = b.f5556h;
                } else if (dVar.f5859e.a() == com.aggmoread.sdk.z.d.a.a.c.i.MIX_INFORMATION_FLOW.a()) {
                    map = f5547a;
                    bVar = b.f5558j;
                }
                return map.get(bVar);
            }
        } catch (Exception e10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(e10.getMessage());
        }
        return null;
    }

    public boolean b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.r.b<?> a10 = a(dVar, eVar);
        if (a10 != null) {
            a10.a(dVar, eVar);
            return true;
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b("ADCBH", "不支持的类型!");
        return false;
    }

    public static d a() {
        if (f5548b == null) {
            synchronized (d.class) {
                try {
                    if (f5548b == null) {
                        f5548b = new d();
                    }
                } finally {
                }
            }
        }
        return f5548b;
    }
}
