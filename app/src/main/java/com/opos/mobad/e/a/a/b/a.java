package com.opos.mobad.e.a.a.b;

import android.content.Context;
import com.opos.acs.st.STManager;
import com.opos.mobad.e.a.j;
import com.opos.mobad.e.a.l;
import com.opos.mobad.e.a.m;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public final class a implements j {

    /* renamed from: b */
    private static volatile a f20501b;

    /* renamed from: a */
    public m f20502a;

    /* renamed from: c */
    private j f20503c;

    /* renamed from: com.opos.mobad.e.a.a.b.a$a */
    public static class C0441a<T extends C0441a<T>> {

        /* renamed from: a */
        protected Map<String, String> f20504a = new HashMap();

        public final T a(C0441a c0441a) {
            Map<String, String> map;
            if (c0441a != null && (map = c0441a.f20504a) != null) {
                this.f20504a.putAll(map);
            }
            return this;
        }

        public final T a(String str) {
            this.f20504a.put("matId", str);
            return this;
        }

        public final T a(Map<String, String> map) {
            if (map != null) {
                this.f20504a.putAll(map);
            }
            return this;
        }

        public final void a(Context context) {
            Map<String, String> map = this.f20504a;
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            map.put("eventTime", sb.toString());
            this.f20504a.put("appPkg", context != null ? context.getPackageName() : "");
            a.a().a(context, this.f20504a);
        }

        public final T b(String str) {
            this.f20504a.put(STManager.KEY_AD_ID, str);
            return this;
        }

        public final T c(String str) {
            this.f20504a.put("loadId", str);
            return this;
        }
    }

    public static final class b extends C0441a<b> {
        public b() {
            this.f20504a.put(STManager.KEY_DATA_TYPE, "dy-mat-click");
        }

        public final b a(int i2) {
            this.f20504a.put("sceneType", String.valueOf(i2));
            return this;
        }

        public final b a(l lVar) {
            if (lVar != null) {
                Map<String, String> map = this.f20504a;
                StringBuilder sb = new StringBuilder();
                sb.append(lVar.f20510c);
                map.put(STManager.KEY_DOWN_X, sb.toString());
                Map<String, String> map2 = this.f20504a;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(lVar.f20511d);
                map2.put(STManager.KEY_DOWN_Y, sb2.toString());
                Map<String, String> map3 = this.f20504a;
                StringBuilder sb3 = new StringBuilder();
                sb3.append(lVar.f20513f);
                map3.put(STManager.KEY_UP_X, sb3.toString());
                Map<String, String> map4 = this.f20504a;
                StringBuilder sb4 = new StringBuilder();
                sb4.append(lVar.f20514g);
                map4.put(STManager.KEY_UP_Y, sb4.toString());
            }
            return this;
        }

        public final b d(String str) {
            this.f20504a.put("clickType", str);
            return this;
        }

        public final b e(String str) {
            this.f20504a.put("adAreaType", str);
            return this;
        }

        public final b f(String str) {
            this.f20504a.put("sceneId", str);
            return this;
        }
    }

    public static final class c extends C0441a<c> {
        public c() {
            this.f20504a.put(STManager.KEY_DATA_TYPE, "dy-mat-error");
        }

        public final c d(String str) {
            this.f20504a.put("errorType", str);
            return this;
        }

        public final c e(String str) {
            this.f20504a.put("errorMsg", str);
            return this;
        }
    }

    public static final class d extends C0441a<d> {
        public d() {
            this.f20504a.put(STManager.KEY_DATA_TYPE, "dy-mat-expose");
        }

        public final d a(int i2) {
            this.f20504a.put("sceneType", String.valueOf(i2));
            return this;
        }

        public final d a(long j2) {
            this.f20504a.put("loadTime", String.valueOf(j2));
            return this;
        }

        public final d d(String str) {
            this.f20504a.put("lastScene", str);
            return this;
        }

        public final d e(String str) {
            this.f20504a.put("curScene", str);
            return this;
        }
    }

    private a() {
    }

    public static C0441a a(String str, String str2, String str3, Map map) {
        return new C0441a().c(str).b(str2).a(str3).a((Map<String, String>) map);
    }

    public static a a() {
        if (f20501b == null) {
            synchronized (j.class) {
                if (f20501b == null) {
                    f20501b = new a();
                }
            }
        }
        return f20501b;
    }

    public static d b() {
        return new d();
    }

    public static b c() {
        return new b();
    }

    public static c d() {
        return new c();
    }

    private j e() {
        j jVar;
        j bVar;
        synchronized (this) {
            jVar = this.f20503c;
            if (jVar == null) {
                m mVar = this.f20502a;
                if (mVar == null || (bVar = mVar.f20516a) == null) {
                    bVar = new com.opos.mobad.e.a.a.b.b();
                }
                this.f20503c = bVar;
                jVar = this.f20503c;
            }
        }
        return jVar;
    }

    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, String str, String str2, String str3) {
        try {
            e().a(context, str, str2, str3);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "MatReporter init error!", th);
        }
    }

    @Override // com.opos.mobad.e.a.j
    public final void a(Context context, Map<String, String> map) {
        try {
            e().a(context, map);
        } catch (Throwable th) {
            com.opos.cmn.an.f.a.d("MatReporter", "MatReporter report error!", th);
        }
    }
}
