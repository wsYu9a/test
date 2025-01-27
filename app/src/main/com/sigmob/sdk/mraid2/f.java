package com.sigmob.sdk.mraid2;

import android.view.View;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class f extends com.sigmob.sdk.mraid.j {

    /* renamed from: e */
    public static final String f19747e = "motion_shake_start";

    /* renamed from: f */
    public static final String f19748f = "motion_shake_end";

    /* renamed from: g */
    public static final String f19749g = "motion_twist_start";

    /* renamed from: h */
    public static final String f19750h = "motion_twist_end";

    /* renamed from: c */
    public i f19751c;

    /* renamed from: d */
    public y.b f19752d;

    public class a implements y.c {
        public a() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("turn_x");
                Number number2 = map.get("turn_y");
                Number number3 = map.get("turn_z");
                Number number4 = map.get("turn_time");
                hashMap.put("x", number);
                hashMap.put("y", number2);
                hashMap.put(bt.aJ, number3);
                hashMap.put("time", number4);
                if (f.this.f19751c != null) {
                    f.this.f19751c.a(f.this.f19592a, "twist", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (f.this.f19751c != null) {
                f.this.f19751c.a(f.this.f19592a, "twist", "began", hashMap);
            }
        }
    }

    public class b implements y.c {
        public b() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put(bt.aJ, String.valueOf(number3));
                if (f.this.f19751c != null) {
                    f.this.f19751c.a(f.this.f19592a, "shake", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (f.this.f19751c != null) {
                f.this.f19751c.a(f.this.f19592a, "shake", "began", hashMap);
            }
        }
    }

    public class c implements y.c {
        public c() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put(bt.aJ, String.valueOf(number3));
                if (f.this.f19751c != null) {
                    f.this.f19751c.a(f.this.f19592a, "slope", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (f.this.f19751c != null) {
                f.this.f19751c.a(f.this.f19592a, "slope", "began", hashMap);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (f.this.f19751c != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("progress", Integer.valueOf((int) (f10 * 100.0f)));
                f.this.f19751c.a(f.this.f19592a, "slope", "progress", hashMap);
            }
        }
    }

    public class d implements y.c {
        public d() {
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(Map<String, Number> map) {
            if (map != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                Number number = map.get("x_max_acc");
                Number number2 = map.get("y_max_acc");
                Number number3 = map.get("z_max_acc");
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put(bt.aJ, String.valueOf(number3));
                if (f.this.f19751c != null) {
                    f.this.f19751c.a(f.this.f19592a, "swing", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (f.this.f19751c != null) {
                f.this.f19751c.a(f.this.f19592a, "swing", "began", hashMap);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (f.this.f19751c != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("progress", Integer.valueOf((int) (f10 * 100.0f)));
                f.this.f19751c.a(f.this.f19592a, "swing", "progress", hashMap);
            }
        }
    }

    public f(String str, String str2) {
        super(str);
        str2.hashCode();
        switch (str2) {
            case "shake":
                d();
                break;
            case "slope":
                e();
                break;
            case "swing":
                f();
                break;
            case "twist":
                g();
                break;
        }
    }

    @Override // com.sigmob.sdk.mraid.j
    public View c() {
        return null;
    }

    @Override // com.sigmob.sdk.mraid.j
    public void a() {
        this.f19751c = null;
        y.b bVar = this.f19752d;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void b(int i10) {
        y.b bVar = this.f19752d;
        if (bVar != null) {
            bVar.b(i10);
        }
    }

    public final void d() {
        y.f fVar = new y.f(com.sigmob.sdk.a.d(), new b());
        fVar.c(1);
        this.f19752d = fVar;
    }

    public final void e() {
        y.d dVar = new y.d(com.sigmob.sdk.a.d(), new c(), y.e.SLOPE);
        dVar.c(1);
        this.f19752d = dVar;
    }

    public final void f() {
        y.d dVar = new y.d(com.sigmob.sdk.a.d(), new d(), y.e.SWING);
        dVar.c(1);
        this.f19752d = dVar;
    }

    public final void g() {
        this.f19752d = new y.d(com.sigmob.sdk.a.d(), new a(), y.e.WRING);
    }

    public void h() {
        y.b bVar = this.f19752d;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(int i10) {
        y.b bVar = this.f19752d;
        if (bVar != null) {
            bVar.a(i10);
        }
    }

    public void a(i iVar) {
        this.f19751c = iVar;
    }
}
