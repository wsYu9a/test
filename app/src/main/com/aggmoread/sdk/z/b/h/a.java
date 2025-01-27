package com.aggmoread.sdk.z.b.h;

import android.content.Context;
import android.util.Log;
import com.aggmoread.sdk.z.b.g.h;
import com.aggmoread.sdk.z.b.m.f;
import com.martian.ads.ad.AdConfig;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class a {

    /* renamed from: i */
    private static a f4514i;

    /* renamed from: a */
    private Context f4515a;

    /* renamed from: b */
    private com.aggmoread.sdk.z.b.g.a f4516b;

    /* renamed from: d */
    private boolean f4518d;

    /* renamed from: e */
    private b f4519e;

    /* renamed from: c */
    private h f4517c = h.f4510d;

    /* renamed from: f */
    private final Map<EnumC0075a, com.aggmoread.sdk.z.b.g.a> f4520f = new HashMap();

    /* renamed from: g */
    private final Map<EnumC0075a, h> f4521g = new HashMap();

    /* renamed from: h */
    private boolean f4522h = true;

    /* renamed from: com.aggmoread.sdk.z.b.h.a$a */
    public static final class EnumC0075a extends Enum<EnumC0075a> {

        /* renamed from: b */
        public static final EnumC0075a f4523b = new EnumC0075a(AdConfig.UnionType.API, 0);

        /* renamed from: c */
        public static final EnumC0075a f4524c = new EnumC0075a("DSP", 1);

        /* renamed from: d */
        public static final EnumC0075a f4525d = new EnumC0075a("AG", 2);

        /* renamed from: e */
        public static final EnumC0075a f4526e = new EnumC0075a("RS", 3);

        private EnumC0075a(String str, int i10) {
            super(str, i10);
        }
    }

    private a() {
    }

    public static synchronized a d() {
        a aVar;
        synchronized (a.class) {
            try {
                if (f4514i == null) {
                    synchronized (a.class) {
                        try {
                            if (f4514i == null) {
                                f4514i = new a();
                            }
                        } finally {
                        }
                    }
                }
                aVar = f4514i;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return aVar;
    }

    public Context a() {
        return this.f4515a;
    }

    public com.aggmoread.sdk.z.b.g.a b() {
        return a(EnumC0075a.f4523b);
    }

    public b c() {
        return this.f4519e;
    }

    public h e() {
        return b(EnumC0075a.f4523b);
    }

    public boolean f() {
        return this.f4518d;
    }

    public boolean g() {
        return this.f4522h;
    }

    public com.aggmoread.sdk.z.b.g.a a(EnumC0075a enumC0075a) {
        return this.f4520f.containsKey(enumC0075a) ? this.f4520f.get(enumC0075a) : this.f4516b;
    }

    public h b(EnumC0075a enumC0075a) {
        return this.f4521g.containsKey(enumC0075a) ? this.f4521g.get(enumC0075a) : this.f4517c;
    }

    public void a(EnumC0075a enumC0075a, h hVar) {
        this.f4521g.put(enumC0075a, hVar);
    }

    public boolean a(Context context, EnumC0075a enumC0075a, com.aggmoread.sdk.z.b.g.a aVar, b bVar) {
        if (this.f4518d) {
            if (enumC0075a != null && aVar != null && !this.f4520f.containsKey(enumC0075a)) {
                this.f4520f.put(enumC0075a, aVar);
            }
            return true;
        }
        if (context == null || aVar == null) {
            Log.e("apia_manager_tag", "初始化参数为空，初始化失败！");
            return this.f4518d;
        }
        this.f4515a = context.getApplicationContext();
        if (enumC0075a != null) {
            this.f4520f.put(enumC0075a, aVar);
        } else {
            this.f4520f.put(EnumC0075a.f4523b, aVar);
            this.f4516b = aVar;
        }
        this.f4519e = bVar;
        f.a(context);
        this.f4518d = true;
        return true;
    }
}
