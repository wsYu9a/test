package com.sigmob.sdk.mraid;

import android.view.View;
import android.widget.FrameLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.czhj.sdk.common.utils.Dips;
import com.sigmob.sdk.base.common.y;
import com.sigmob.sdk.base.mta.PointCategory;
import com.sigmob.sdk.base.views.k0;
import com.sigmob.sdk.base.views.n0;
import com.sigmob.sdk.base.views.v;
import com.umeng.analytics.pro.bt;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class h extends j {

    /* renamed from: c */
    public int f19574c;

    /* renamed from: d */
    public v f19575d;

    /* renamed from: e */
    public y.b f19576e;

    /* renamed from: f */
    public com.sigmob.sdk.mraid2.i f19577f;

    public class a implements y.c {

        /* renamed from: a */
        public final /* synthetic */ String f19578a;

        public a(String str) {
            this.f19578a = str;
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
                if (h.this.f19577f != null) {
                    h.this.f19577f.a(this.f19578a, "shake", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (h.this.f19577f != null) {
                h.this.f19577f.a(this.f19578a, "shake", "began", hashMap);
            }
        }
    }

    public class b implements y.c {

        /* renamed from: a */
        public final /* synthetic */ String f19580a;

        public b(String str) {
            this.f19580a = str;
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
                hashMap.put("x", String.valueOf(number));
                hashMap.put("y", String.valueOf(number2));
                hashMap.put(bt.aJ, String.valueOf(number3));
                hashMap.put("time", number4);
                if (h.this.f19577f != null) {
                    h.this.f19577f.a(this.f19580a, "twist", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (h.this.f19577f != null) {
                h.this.f19577f.a(this.f19580a, "twist", "began", hashMap);
            }
        }
    }

    public class c implements y.c {

        /* renamed from: a */
        public final /* synthetic */ String f19582a;

        public c(String str) {
            this.f19582a = str;
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
                if (h.this.f19577f != null) {
                    h.this.f19577f.a(this.f19582a, "slope", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (h.this.f19577f != null) {
                h.this.f19577f.a(this.f19582a, "slope", "began", hashMap);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (h.this.f19575d instanceof k0) {
                ((k0) h.this.f19575d).a(f10);
            }
            if (h.this.f19577f != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("progress", Integer.valueOf((int) (f10 * 100.0f)));
                h.this.f19577f.a(this.f19582a, "slope", "progress", hashMap);
            }
        }
    }

    public class d implements y.c {

        /* renamed from: a */
        public final /* synthetic */ String f19584a;

        public d(String str) {
            this.f19584a = str;
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
                if (h.this.f19577f != null) {
                    h.this.f19577f.a(this.f19584a, "swing", PointCategory.END, hashMap);
                }
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a() {
            HashMap<String, Object> hashMap = new HashMap<>();
            if (h.this.f19577f != null) {
                h.this.f19577f.a(this.f19584a, "swing", "began", hashMap);
            }
        }

        @Override // com.sigmob.sdk.base.common.y.c
        public void a(float f10) {
            if (h.this.f19575d instanceof n0) {
                ((n0) h.this.f19575d).a(f10);
            }
            if (h.this.f19577f != null) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("progress", Integer.valueOf((int) (f10 * 100.0f)));
                h.this.f19577f.a(this.f19584a, "swing", "progress", hashMap);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0080  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public h(android.content.Context r4, java.lang.String r5, int r6) {
        /*
            r3 = this;
            r3.<init>(r5)
            r3.f19574c = r6
            r0 = 3
            r1 = 1
            if (r6 == 0) goto L63
            if (r6 == r1) goto L4b
            r2 = 2
            if (r6 == r2) goto L33
            if (r6 == r0) goto L16
            java.lang.String r4 = "MMotionView type is not support"
            com.czhj.sdk.logger.SigmobLog.e(r4)
            goto L7c
        L16:
            com.sigmob.sdk.base.views.n0 r6 = new com.sigmob.sdk.base.views.n0
            r6.<init>(r4)
            r3.f19575d = r6
            com.sigmob.sdk.base.common.y$d r4 = new com.sigmob.sdk.base.common.y$d
            android.content.Context r6 = com.sigmob.sdk.a.d()
            com.sigmob.sdk.mraid.h$d r2 = new com.sigmob.sdk.mraid.h$d
            r2.<init>(r5)
            com.sigmob.sdk.base.common.y$e r5 = com.sigmob.sdk.base.common.y.e.SWING
            r4.<init>(r6, r2, r5)
        L2d:
            r4.c(r1)
        L30:
            r3.f19576e = r4
            goto L7c
        L33:
            com.sigmob.sdk.base.views.k0 r6 = new com.sigmob.sdk.base.views.k0
            r6.<init>(r4)
            r3.f19575d = r6
            com.sigmob.sdk.base.common.y$d r4 = new com.sigmob.sdk.base.common.y$d
            android.content.Context r6 = com.sigmob.sdk.a.d()
            com.sigmob.sdk.mraid.h$c r2 = new com.sigmob.sdk.mraid.h$c
            r2.<init>(r5)
            com.sigmob.sdk.base.common.y$e r5 = com.sigmob.sdk.base.common.y.e.SLOPE
            r4.<init>(r6, r2, r5)
            goto L2d
        L4b:
            com.sigmob.sdk.base.views.u0 r6 = new com.sigmob.sdk.base.views.u0
            r6.<init>(r4)
            r3.f19575d = r6
            com.sigmob.sdk.base.common.y$d r4 = new com.sigmob.sdk.base.common.y$d
            android.content.Context r6 = com.sigmob.sdk.a.d()
            com.sigmob.sdk.mraid.h$b r1 = new com.sigmob.sdk.mraid.h$b
            r1.<init>(r5)
            com.sigmob.sdk.base.common.y$e r5 = com.sigmob.sdk.base.common.y.e.WRING
            r4.<init>(r6, r1, r5)
            goto L30
        L63:
            com.sigmob.sdk.base.views.c0 r6 = new com.sigmob.sdk.base.views.c0
            r6.<init>(r4)
            r3.f19575d = r6
            com.sigmob.sdk.base.common.y$f r4 = new com.sigmob.sdk.base.common.y$f
            android.content.Context r6 = com.sigmob.sdk.a.d()
            com.sigmob.sdk.mraid.h$a r2 = new com.sigmob.sdk.mraid.h$a
            r2.<init>(r5)
            r4.<init>(r6, r2)
            r4.c(r1)
            goto L30
        L7c:
            com.sigmob.sdk.base.views.v r4 = r3.f19575d
            if (r4 == 0) goto L83
            r4.a()
        L83:
            com.sigmob.sdk.base.common.y$b r4 = r3.f19576e
            r4.a(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.mraid.h.<init>(android.content.Context, java.lang.String, int):void");
    }

    @Override // com.sigmob.sdk.mraid.j
    public View c() {
        return this.f19575d;
    }

    public void d() {
        y.b bVar = this.f19576e;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void i(JSONObject jSONObject) {
        if (this.f19575d != null) {
            JSONObject optJSONObject = jSONObject.optJSONObject(TypedValues.AttributesType.S_FRAME);
            int optDouble = (int) optJSONObject.optDouble("x", l5.c.f27899e);
            int optDouble2 = (int) optJSONObject.optDouble("y", l5.c.f27899e);
            int optDouble3 = (int) optJSONObject.optDouble(IAdInterListener.AdReqParam.WIDTH, -1.0d);
            int optDouble4 = (int) optJSONObject.optDouble("h", -1.0d);
            if (optDouble3 > 0) {
                optDouble3 = Dips.dipsToIntPixels(optDouble3, com.sigmob.sdk.a.d());
            }
            if (optDouble4 > 0) {
                optDouble4 = Dips.dipsToIntPixels(optDouble4, com.sigmob.sdk.a.d());
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(optDouble3, optDouble4);
            this.f19575d.setX(Dips.dipsToIntPixels(optDouble, com.sigmob.sdk.a.d()));
            this.f19575d.setY(Dips.dipsToIntPixels(optDouble2, com.sigmob.sdk.a.d()));
            this.f19575d.setLayoutParams(layoutParams);
            this.f19575d.requestLayout();
        }
    }

    public h(String str) {
        super(str);
    }

    @Override // com.sigmob.sdk.mraid.j
    public void a() {
        v vVar = this.f19575d;
        if (vVar != null) {
            com.sigmob.sdk.base.utils.e.e(vVar);
            this.f19575d = null;
        }
        y.b bVar = this.f19576e;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void b(int i10) {
        y.b bVar = this.f19576e;
        if (bVar != null) {
            bVar.b(i10);
        }
    }

    public void a(int i10) {
        y.b bVar = this.f19576e;
        if (bVar != null) {
            if (i10 == 0) {
                i10 = 3;
            } else if (i10 == 2) {
                i10 = 1;
            } else if (i10 == 1) {
                i10 = 2;
            }
            bVar.a(i10);
        }
    }

    public void a(boolean z10) {
        v vVar = this.f19575d;
        if (vVar != null) {
            if (z10) {
                vVar.setVisibility(4);
                this.f19576e.b();
            } else {
                vVar.setVisibility(0);
                this.f19576e.c();
            }
        }
    }

    public void a(com.sigmob.sdk.mraid2.i iVar) {
        this.f19577f = iVar;
    }
}
