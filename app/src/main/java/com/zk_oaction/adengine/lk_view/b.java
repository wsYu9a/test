package com.zk_oaction.adengine.lk_view;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class b extends FrameLayout implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.b, com.zk_oaction.adengine.lk_sdk.interfaces.f {
    protected com.zk_oaction.adengine.lk_expression.a A;
    protected com.zk_oaction.adengine.lk_expression.a B;
    protected com.zk_oaction.adengine.lk_expression.a C;
    protected com.zk_oaction.adengine.lk_expression.a D;
    protected com.zk_oaction.adengine.lk_expression.a E;
    protected com.zk_oaction.adengine.lk_expression.a F;
    protected com.zk_oaction.adengine.lk_expression.a G;
    protected com.zk_oaction.adengine.lk_expression.a H;
    protected String I;
    protected int J;
    protected String K;
    protected String L;
    protected com.zk_oaction.adengine.lk_expression.a M;
    protected com.zk_oaction.adengine.lk_sdk.interfaces.a N;
    protected boolean O;
    protected float P;
    protected float Q;
    protected float R;
    protected float S;
    protected float T;
    protected float U;

    /* renamed from: a */
    protected float f35066a;

    /* renamed from: b */
    protected float f35067b;

    /* renamed from: c */
    protected float f35068c;

    /* renamed from: d */
    protected float f35069d;

    /* renamed from: e */
    protected com.zk_oaction.adengine.lk_view.f f35070e;

    /* renamed from: f */
    protected float f35071f;

    /* renamed from: g */
    protected float f35072g;

    /* renamed from: h */
    protected float f35073h;

    /* renamed from: i */
    protected float f35074i;

    /* renamed from: j */
    protected float f35075j;
    protected float k;
    protected float l;
    protected float m;
    protected float n;
    protected float o;
    protected float p;
    protected ArrayList<com.zk_oaction.adengine.lk_animation.b> q;
    protected boolean r;
    protected Rect s;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void>> t;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b>> u;
    protected com.zk_oaction.adengine.lk_sdk.c v;
    protected String w;
    protected com.zk_oaction.adengine.lk_expression.a x;
    protected com.zk_oaction.adengine.lk_expression.a y;
    protected com.zk_oaction.adengine.lk_expression.a z;

    class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.N(f2.floatValue());
            return null;
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_view.b$b */
    class C0818b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        C0818b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.P(f2.floatValue());
            return null;
        }
    }

    class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.Q(f2.floatValue());
            return null;
        }
    }

    class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.d(b.this);
        }
    }

    class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.a(b.this);
        }
    }

    class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.f(b.this);
        }
    }

    class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.e(b.this);
        }
    }

    class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public com.zk_oaction.adengine.lk_animation.b a(String str) {
            return new com.zk_oaction.adengine.lk_animation.g((com.zk_oaction.adengine.lk_view.g) b.this);
        }
    }

    class i implements com.zk_oaction.adengine.lk_sdk.interfaces.a {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public boolean a(float f2, float f3) {
            return f2 > b.this.getTranslationX() && f2 < b.this.getTranslationX() + b.this.z.b() && f3 > b.this.getTranslationY() && f3 < b.this.getTranslationY() + b.this.A.b();
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public boolean c() {
            return false;
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void f(float f2, float f3) {
            b bVar = b.this;
            bVar.T = bVar.f35071f;
            bVar.U = bVar.f35072g;
            bVar.f35066a = f2;
            bVar.f35067b = f3;
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void h(float f2, float f3) {
            b bVar = b.this;
            float f4 = (bVar.T + f2) - bVar.f35066a;
            float f5 = (bVar.U + f3) - bVar.f35067b;
            if (bVar.O) {
                float f6 = bVar.P;
                if (f4 < f6) {
                    f4 = f6;
                }
                float f7 = bVar.R;
                if (f4 > f7) {
                    f4 = f7;
                }
                float f8 = bVar.Q;
                if (f5 < f8) {
                    f5 = f8;
                }
                float f9 = bVar.S;
                if (f5 > f9) {
                    f5 = f9;
                }
            }
            bVar.b(f4, f5);
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void j(float f2, float f3) {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.a
        public void k(float f2, float f3) {
        }
    }

    class j implements Runnable {

        /* renamed from: a */
        final /* synthetic */ float f35085a;

        j(float f2) {
            this.f35085a = f2;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.zk_oaction.adengine.lk_sdk.c cVar;
            String str;
            String str2;
            b bVar = b.this;
            float f2 = bVar.J;
            float f3 = this.f35085a;
            float f4 = bVar.p;
            com.zk_oaction.adengine.lk_view.f fVar = bVar.f35070e;
            if ((fVar != null ? fVar.W() : 1.0f) * f2 * f3 * f4 == 0.0f) {
                b.super.setVisibility(4);
                b.this.g();
                b bVar2 = b.this;
                if (bVar2.w == null) {
                    return;
                }
                cVar = bVar2.v;
                str = b.this.w + ".visibility";
                str2 = "0";
            } else {
                b.super.setVisibility(0);
                b.this.f();
                b bVar3 = b.this;
                if (bVar3.w == null) {
                    return;
                }
                cVar = bVar3.v;
                str = b.this.w + ".visibility";
                str2 = "1";
            }
            cVar.u(str, str2);
        }
    }

    class k implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        k() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.F(f2.floatValue());
            return null;
        }
    }

    class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Float> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(Float f2) {
            return Float.valueOf(b.this.K.equals("center") ? f2.floatValue() / 2.0f : b.this.K.equals("left") ? 0.0f : f2.floatValue());
        }
    }

    class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Float> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        public Float a(Float f2) {
            return Float.valueOf(b.this.L.equals("center") ? f2.floatValue() / 2.0f : b.this.L.equals("top") ? 0.0f : f2.floatValue());
        }
    }

    class n implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        n() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.H(f2.floatValue());
            return null;
        }
    }

    class o implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        o() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.I(f2.floatValue());
            return null;
        }
    }

    class p implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        p() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.L(f2.floatValue());
            return null;
        }
    }

    class q implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        q() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.setPivotX(f2.floatValue());
            return null;
        }
    }

    class r implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        r() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.setPivotY(f2.floatValue());
            return null;
        }
    }

    class s implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        s() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.setRotation(f2.floatValue() + b.this.k);
            return null;
        }
    }

    class t implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        t() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.setRotationX(f2.floatValue() + b.this.l);
            return null;
        }
    }

    class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(Float f2) {
            b.this.setRotationY(f2.floatValue() + b.this.m);
            return null;
        }
    }

    public b(com.zk_oaction.adengine.lk_sdk.c cVar) {
        super(cVar.F);
        this.v = cVar;
        this.q = new ArrayList<>();
        this.s = new Rect();
        this.f35075j = 255.0f;
        this.p = 1.0f;
        a();
        y();
        setWillNotDraw(false);
    }

    private boolean B() {
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        return fVar != null && fVar.X();
    }

    public void F(float f2) {
        setTranslationX(f2);
        if (this.w != null) {
            this.v.u(this.w + ".actual_x", "" + (getTranslationX() / this.v.P));
        }
    }

    public void H(float f2) {
        setTranslationY(f2);
        if (this.w != null) {
            this.v.u(this.w + ".actual_y", "" + (getTranslationY() / this.v.P));
        }
    }

    public void I(float f2) {
        if (this.K != null) {
            this.f35068c = new l().a((l) Float.valueOf(f2)).floatValue();
            setTranslationX(this.x.b());
            com.zk_oaction.adengine.lk_expression.a aVar = this.B;
            if (aVar != null && aVar.f34839d == null) {
                aVar.h(this.f35068c);
            }
        }
        if (this.w != null) {
            if ((this instanceof com.zk_oaction.adengine.lk_view.g) || (this instanceof com.zk_oaction.adengine.lk_view.i)) {
                this.v.u(this.w + ".bmp_width", "" + (f2 / this.v.P));
            }
            this.v.u(this.w + ".actual_w", "" + (f2 / this.v.P));
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = this.z;
        if (aVar2 == null || this.A == null) {
            return;
        }
        this.s.set(0, 0, (int) aVar2.b(), (int) this.A.b());
        K();
        invalidate();
    }

    public void L(float f2) {
        if (this.L != null) {
            this.f35069d = new m().a((m) Float.valueOf(f2)).floatValue();
            setTranslationY(this.y.b());
            com.zk_oaction.adengine.lk_expression.a aVar = this.C;
            if (aVar != null && aVar.f34839d == null) {
                aVar.h(this.f35069d);
            }
        }
        if (this.w != null) {
            if ((this instanceof com.zk_oaction.adengine.lk_view.g) || (this instanceof com.zk_oaction.adengine.lk_view.i)) {
                this.v.u(this.w + ".bmp_height", "" + (f2 / this.v.P));
            }
            this.v.u(this.w + ".actual_h", "" + (f2 / this.v.P));
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = this.z;
        if (aVar2 == null || this.A == null) {
            return;
        }
        this.s.set(0, 0, (int) aVar2.b(), (int) this.A.b());
        K();
        invalidate();
    }

    public void N(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        } else if (f2 > 255.0f) {
            f2 = 255.0f;
        }
        float f3 = f2 / 255.0f;
        this.n = f3;
        setAlpha((f3 * this.f35075j) / 255.0f);
    }

    public void P(float f2) {
        this.o = f2;
        l(f2);
    }

    public void Q(float f2) {
        if (f2 == 0.0f) {
            this.v.M.remove(this.N);
            b(0.0f, 0.0f);
        } else {
            if (this.v.M.contains(this.N)) {
                return;
            }
            this.v.M.add(this.N);
        }
    }

    private void a() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<Float, Void>> hashMap = new HashMap<>();
        this.t = hashMap;
        hashMap.put("x", new k());
        this.t.put("y", new n());
        this.t.put("width", new o());
        this.t.put("height", new p());
        this.t.put("pivotX", new q());
        this.t.put("pivotY", new r());
        this.t.put("rotation", new s());
        this.t.put("rotationX", new t());
        this.t.put("rotationY", new u());
        this.t.put("alpha", new a());
        this.t.put(Downloads.Column.VISIBILITY, new C0818b());
        this.t.put("enableMove", new c());
    }

    private void w(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.v, "enableMove", xmlPullParser.getAttributeValue(null, "enableMove"), 0.0f, this, false);
        this.M = aVar;
        if (aVar.b() != 0.0f) {
            String attributeValue = xmlPullParser.getAttributeValue(null, "moveRect");
            if (attributeValue != null) {
                this.O = true;
                String[] split = attributeValue.split(",");
                this.P = Float.parseFloat(split[0]);
                this.Q = Float.parseFloat(split[1]);
                this.R = Float.parseFloat(split[2]);
                this.S = Float.parseFloat(split[3]);
            }
            i iVar = new i();
            this.N = iVar;
            this.v.M.add(iVar);
        }
    }

    private com.zk_oaction.adengine.lk_animation.b x(XmlPullParser xmlPullParser) {
        String name = xmlPullParser.getName();
        com.zk_oaction.adengine.lk_animation.b a2 = (name == null || this.u.get(name) == null) ? null : this.u.get(name).a(name);
        if (a2 != null && a2.c(xmlPullParser)) {
            synchronized (this) {
                this.v.n(a2);
                this.q.add(a2);
            }
        }
        return a2;
    }

    private void y() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<String, com.zk_oaction.adengine.lk_animation.b>> hashMap = new HashMap<>();
        this.u = hashMap;
        hashMap.put("PositionAnimation", new d());
        this.u.put("AlphaAnimation", new e());
        this.u.put("SizeAnimation", new f());
        this.u.put("RotationAnimation", new g());
        this.u.put("SourcesAnimation", new h());
    }

    public void D(String str) {
    }

    protected boolean J() {
        return false;
    }

    protected void K() {
        int makeMeasureSpec;
        float R;
        if (this.r) {
            if (J() || B()) {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.f35070e.Q(), 1073741824);
                R = this.f35070e.R();
            } else {
                makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.z.b(), 1073741824);
                R = this.A.b();
            }
            int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) R, 1073741824);
            forceLayout();
            measure(makeMeasureSpec, makeMeasureSpec2);
            layout(0, 0, getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public float M() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.z;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }

    public float O() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.A;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void a(float f2) {
        this.f35075j = f2;
        setAlpha((this.n * f2) / 255.0f);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0020, code lost:
    
        if (r2.o == 1.0f) goto L28;
     */
    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r3) {
        /*
            r2 = this;
            java.lang.String r0 = "true"
            boolean r0 = r3.equals(r0)
            r1 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto Lb
            goto L26
        Lb:
            java.lang.String r0 = "false"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L14
            goto L22
        L14:
            java.lang.String r0 = "toggle"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L28
            float r3 = r2.o
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L26
        L22:
            r3 = 0
            r2.o = r3
            goto L28
        L26:
            r2.o = r1
        L28:
            float r3 = r2.o
            r2.l(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.b.a(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        if (str == null || this.t.get(str) == null) {
            return;
        }
        this.t.get(str).a(Float.valueOf(f2));
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public com.zk_oaction.adengine.lk_sdk.c b() {
        return this.v;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void b(float f2, float f3) {
        this.f35071f = f2;
        this.f35072g = f3;
        setTranslationX(this.x.b());
        setTranslationY(this.y.b());
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void b(String str) {
        if (str.equals("play")) {
            f();
        } else if (str.equals("stop")) {
            g();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void c(float f2) {
        this.p = f2;
        l(this.o);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f2) {
        this.m = f2;
        setRotationY(this.F.b() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f2, float f3) {
        this.f35073h = f2;
        this.f35074i = f3;
        setTranslationX(this.x.b());
        setTranslationY(this.y.b());
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(String str) {
        if (str.equals("x")) {
            setTranslationX(this.x.b());
            return;
        }
        if (str.equals("y")) {
            setTranslationY(this.y.b());
            return;
        }
        if (str.equals(n(this.G, "alpha"))) {
            setAlpha((this.n * this.f35075j) / 255.0f);
            return;
        }
        if (str.equals("rotation")) {
            setRotation(this.D.b() + this.k);
            return;
        }
        if (str.equals("rotationX")) {
            setRotationX(this.E.b() + this.l);
        } else if (str.equals("rotationY")) {
            setRotationY(this.F.b() + this.m);
        } else if (str.equals(n(this.H, Downloads.Column.VISIBILITY))) {
            l(this.o);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.w;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void e(float f2, float f3) {
        try {
            setScaleX(f2 / this.z.b());
            setScaleY(f3 / this.A.b());
        } catch (Exception unused) {
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().d();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().f();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g(float f2) {
        this.k = f2;
        setRotation(this.D.b() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h() {
        synchronized (this) {
            Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.q.iterator();
            while (it.hasNext()) {
                it.next().e();
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void i(float f2) {
        this.l = f2;
        setRotationX(this.E.b() + f2);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void l(float f2) {
        com.zk_oaction.adengine.lk_sdk.c cVar;
        String str;
        String str2;
        Thread currentThread = Thread.currentThread();
        com.zk_oaction.adengine.lk_sdk.c cVar2 = this.v;
        if (currentThread != cVar2.S) {
            cVar2.U.post(new j(f2));
            return;
        }
        float f3 = this.J;
        float f4 = this.p;
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        if ((fVar != null ? fVar.W() : 1.0f) * f4 * f3 * f2 == 0.0f) {
            super.setVisibility(4);
            g();
            if (this.w == null) {
                return;
            }
            cVar = this.v;
            str = this.w + ".visibility";
            str2 = "0";
        } else {
            super.setVisibility(0);
            f();
            if (this.w == null) {
                return;
            }
            cVar = this.v;
            str = this.w + ".visibility";
            str2 = "1";
        }
        cVar.u(str, str2);
    }

    public String n(com.zk_oaction.adengine.lk_expression.a aVar, String str) {
        return aVar != null ? aVar.f34838c : str;
    }

    public void o(int i2, int i3) {
        this.z.h(i2);
        this.A.h(i3);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        int makeMeasureSpec;
        float R;
        if (J() || B()) {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.f35070e.Q(), 1073741824);
            R = this.f35070e.R();
        } else {
            makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) this.z.b(), 1073741824);
            R = this.A.b();
        }
        super.onMeasure(makeMeasureSpec, View.MeasureSpec.makeMeasureSpec((int) R, 1073741824));
        this.r = true;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void r(com.zk_oaction.adengine.lk_view.f fVar) {
        this.f35070e = fVar;
        fVar.m(this);
    }

    protected boolean s(XmlPullParser xmlPullParser) {
        this.w = xmlPullParser.getAttributeValue(null, "name");
        this.x = new com.zk_oaction.adengine.lk_expression.a(this.v, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
        this.y = new com.zk_oaction.adengine.lk_expression.a(this.v, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
        this.K = xmlPullParser.getAttributeValue(null, "align");
        this.L = xmlPullParser.getAttributeValue(null, "alignV");
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        if (attributeValue == null) {
            attributeValue = xmlPullParser.getAttributeValue(null, "width");
        }
        com.zk_oaction.adengine.lk_expression.a aVar = new com.zk_oaction.adengine.lk_expression.a(this.v, "width", attributeValue, 0.0f, null, true);
        this.z = aVar;
        aVar.i(this);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        if (attributeValue2 == null) {
            attributeValue2 = xmlPullParser.getAttributeValue(null, "height");
        }
        com.zk_oaction.adengine.lk_expression.a aVar2 = new com.zk_oaction.adengine.lk_expression.a(this.v, "height", attributeValue2, 0.0f, null, true);
        this.A = aVar2;
        aVar2.i(this);
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "pivotX");
        if (attributeValue3 == null) {
            attributeValue3 = xmlPullParser.getAttributeValue(null, "centerX");
        }
        this.B = new com.zk_oaction.adengine.lk_expression.a(this.v, "pivotX", attributeValue3, 0.0f, this, true);
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "pivotY");
        if (attributeValue4 == null) {
            attributeValue4 = xmlPullParser.getAttributeValue(null, "centerY");
        }
        this.C = new com.zk_oaction.adengine.lk_expression.a(this.v, "pivotY", attributeValue4, 0.0f, this, true);
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "rotation");
        if (attributeValue5 == null) {
            attributeValue5 = xmlPullParser.getAttributeValue(null, "angle");
        }
        this.D = new com.zk_oaction.adengine.lk_expression.a(this.v, "rotation", attributeValue5, 0.0f, this, false);
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "rotationX");
        if (attributeValue6 == null) {
            attributeValue6 = xmlPullParser.getAttributeValue(null, "angleX");
        }
        this.E = new com.zk_oaction.adengine.lk_expression.a(this.v, "rotationX", attributeValue6, 0.0f, this, false);
        String attributeValue7 = xmlPullParser.getAttributeValue(null, "rotationY");
        if (attributeValue7 == null) {
            attributeValue7 = xmlPullParser.getAttributeValue(null, "angleY");
        }
        this.F = new com.zk_oaction.adengine.lk_expression.a(this.v, "rotationY", attributeValue7, 0.0f, this, false);
        this.G = new com.zk_oaction.adengine.lk_expression.a(this.v, "alpha", xmlPullParser.getAttributeValue(null, "alpha"), 255.0f, this, false);
        String attributeValue8 = xmlPullParser.getAttributeValue(null, "category");
        this.I = attributeValue8;
        if (attributeValue8 == null) {
            this.J = 1;
        }
        this.p = new com.zk_oaction.adengine.lk_expression.a(this.v, "active", xmlPullParser.getAttributeValue(null, "active"), 1.0f, null, false).b();
        this.H = new com.zk_oaction.adengine.lk_expression.a(this.v, Downloads.Column.VISIBILITY, xmlPullParser.getAttributeValue(null, Downloads.Column.VISIBILITY), 1.0f, this, false);
        w(xmlPullParser);
        return true;
    }

    @Override // android.view.View
    public void setAlpha(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setAlpha(((fVar != null ? fVar.S() : 255.0f) * f2) / 255.0f);
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setRotation((fVar != null ? fVar.T() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setRotationX(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setRotationX((fVar != null ? fVar.U() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setRotationY(float f2) {
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setRotationY((fVar != null ? fVar.V() : 0.0f) + f2);
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        float f3 = this.f35068c;
        float f4 = this.f35073h;
        float f5 = this.f35071f;
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setTranslationX((fVar != null ? fVar.K() : 0.0f) + f5 + (f2 - f3) + f4);
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        float f3 = this.f35069d;
        float f4 = this.f35074i;
        float f5 = this.f35072g;
        com.zk_oaction.adengine.lk_view.f fVar = this.f35070e;
        super.setTranslationY((fVar != null ? fVar.N() : 0.0f) + f5 + (f2 - f3) + f4);
    }

    protected boolean t(XmlPullParser xmlPullParser, String str) {
        int next;
        while (true) {
            try {
                next = xmlPullParser.next();
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (next == 1) {
                break;
            }
            if (next != 2) {
                if (next == 3 && xmlPullParser.getName().equals(str)) {
                    if (getVisibility() != 0) {
                        return true;
                    }
                }
            } else if (x(xmlPullParser) != null) {
                continue;
            } else if (xmlPullParser.getName().equals("Mask")) {
                if (getVisibility() != 0) {
                    return true;
                }
            } else if (xmlPullParser.getName().equals("Paint")) {
                return true;
            }
            th.printStackTrace();
        }
        f();
        return true;
        return false;
    }
}
