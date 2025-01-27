package com.zk_oaction.adengine.lk_view;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class f implements a.w, com.zk_oaction.adengine.lk_sdk.interfaces.b, com.zk_oaction.adengine.lk_sdk.interfaces.f {
    private float A;
    private float B;
    private float C;
    private f D;

    /* renamed from: b */
    private float f35126b;

    /* renamed from: e */
    protected com.zk_oaction.adengine.lk_sdk.c f35129e;

    /* renamed from: f */
    protected String f35130f;

    /* renamed from: g */
    protected com.zk_oaction.adengine.lk_expression.a f35131g;

    /* renamed from: h */
    protected com.zk_oaction.adengine.lk_expression.a f35132h;

    /* renamed from: i */
    protected com.zk_oaction.adengine.lk_expression.a f35133i;

    /* renamed from: j */
    protected com.zk_oaction.adengine.lk_expression.a f35134j;
    protected com.zk_oaction.adengine.lk_expression.a k;
    protected com.zk_oaction.adengine.lk_expression.a l;
    protected com.zk_oaction.adengine.lk_expression.a m;
    protected float n;
    protected Object p;
    protected HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> r;
    private com.zk_oaction.adengine.lk_expression.a s;
    private com.zk_oaction.adengine.lk_expression.a t;
    private com.zk_oaction.adengine.lk_expression.a u;
    private com.zk_oaction.adengine.lk_expression.a v;
    private float w;
    private float x;
    private float y;
    protected ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> o = new ArrayList<>();
    private float z = 255.0f;

    /* renamed from: a */
    private ArrayList<com.zk_oaction.adengine.lk_animation.b> f35125a = new ArrayList<>();

    /* renamed from: c */
    private ArrayList<com.zk_oaction.adengine.lk_unlock.b> f35127c = new ArrayList<>();

    /* renamed from: d */
    private ArrayList<com.zk_oaction.adengine.lk_command.a> f35128d = new ArrayList<>();
    protected ArrayList<com.zk_oaction.adengine.lk_view.g> q = new ArrayList<>();

    class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.P(xmlPullParser);
            return null;
        }
    }

    class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.r(xmlPullParser);
            return null;
        }
    }

    class c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.v(xmlPullParser);
            return null;
        }
    }

    class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.y(xmlPullParser);
            return null;
        }
    }

    class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.B(xmlPullParser);
            return null;
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_view.f$f */
    class C0821f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C0821f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.D(xmlPullParser);
            return null;
        }
    }

    class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.F(xmlPullParser);
            return null;
        }
    }

    class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.H(xmlPullParser);
            return null;
        }
    }

    class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.J(xmlPullParser);
            return null;
        }
    }

    class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            f.this.M(xmlPullParser);
            return null;
        }
    }

    public f(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f35129e = cVar;
        j();
    }

    public void B(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.i iVar = new com.zk_oaction.adengine.lk_view.i(this.f35129e);
        if (iVar.R(xmlPullParser, "ImageNumber")) {
            iVar.setTag(this.p);
            iVar.r(this);
            if (iVar.e() != null) {
                this.f35129e.L.put(iVar.e(), iVar);
            }
        }
    }

    public void D(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.b bVar = new com.zk_oaction.adengine.lk_unlock.b(this.f35129e);
        if (bVar.i(xmlPullParser, "Slider")) {
            this.f35129e.M.add(bVar);
            if (bVar.e() != null) {
                this.f35129e.L.put(bVar.e(), bVar);
            }
            this.f35127c.add(bVar);
        }
    }

    public void F(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.a aVar = new com.zk_oaction.adengine.lk_command.a(this.f35129e);
        aVar.c(this);
        if (aVar.e(xmlPullParser, "Button")) {
            this.f35129e.M.add(aVar);
            if (aVar.e() != null) {
                this.f35129e.L.put(aVar.e(), aVar);
            }
        }
    }

    public void H(XmlPullParser xmlPullParser) {
        f fVar = new f(this.f35129e);
        fVar.q(this.p);
        if (fVar.s(xmlPullParser, "Group")) {
            fVar.n(this);
            if (fVar.e() != null) {
                this.f35129e.L.put(fVar.e(), fVar);
            }
        }
    }

    public void J(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.d dVar = new com.zk_oaction.adengine.lk_animation.d(this);
        if (dVar.c(xmlPullParser)) {
            this.f35129e.n(dVar);
            this.f35125a.add(dVar);
        }
    }

    public void M(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.a aVar = new com.zk_oaction.adengine.lk_animation.a(this);
        if (aVar.c(xmlPullParser)) {
            this.f35129e.n(aVar);
            this.f35125a.add(aVar);
        }
    }

    public void P(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_animation.e eVar = new com.zk_oaction.adengine.lk_animation.e(this);
        if (eVar.c(xmlPullParser)) {
            this.f35129e.n(eVar);
            this.f35125a.add(eVar);
        }
    }

    private void p(com.zk_oaction.adengine.lk_view.g gVar) {
        gVar.setTag(this.p);
        gVar.r(this);
        if (gVar.e() != null) {
            this.f35129e.L.put(gVar.e(), gVar);
        }
    }

    public void r(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this.f35129e);
        if (gVar.W(xmlPullParser, "Image")) {
            if (this.v.b() == 1.0f && TextUtils.isEmpty(gVar.b0())) {
                u(gVar);
            } else {
                p(gVar);
            }
        }
    }

    private void u(com.zk_oaction.adengine.lk_view.g gVar) {
        this.q.add(gVar);
    }

    public void v(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this.f35129e);
        if (eVar.T(xmlPullParser, "Frame")) {
            eVar.setTag(this.p);
            eVar.r(this);
            if (eVar.e() != null) {
                this.f35129e.L.put(eVar.e(), eVar);
            }
        }
    }

    public void y(XmlPullParser xmlPullParser) {
        m mVar = new m(this.f35129e);
        if (mVar.R(xmlPullParser, "Text")) {
            mVar.setTag(this.p);
            mVar.r(this);
            if (mVar.e() != null) {
                this.f35129e.L.put(mVar.e(), mVar);
            }
        }
    }

    public float K() {
        f fVar = this.D;
        return (fVar != null ? fVar.K() : 0.0f) + this.f35131g.b() + this.x + this.w;
    }

    public float N() {
        f fVar = this.D;
        return (fVar != null ? fVar.N() : 0.0f) + this.f35132h.b() + this.y + this.n;
    }

    public float Q() {
        return this.f35133i.b();
    }

    public float R() {
        return this.f35134j.b();
    }

    public float S() {
        return (int) (((((this.D != null ? r0.S() / 255.0f : 1.0f) * this.k.b()) * this.z) / 255.0f) + 0.5f);
    }

    public float T() {
        f fVar = this.D;
        return (fVar != null ? fVar.T() : 0.0f) + this.s.b() + this.A;
    }

    public float U() {
        f fVar = this.D;
        return (fVar != null ? fVar.U() : 0.0f) + this.t.b() + this.B;
    }

    public float V() {
        f fVar = this.D;
        return (fVar != null ? fVar.V() : 0.0f) + this.u.b() + this.C;
    }

    public float W() {
        f fVar = this.D;
        return (fVar != null ? fVar.W() : 1.0f) * this.l.b() * this.f35126b;
    }

    public boolean X() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.m;
        return aVar != null && aVar.b() == 1.0f;
    }

    public ArrayList<com.zk_oaction.adengine.lk_view.g> Y() {
        return this.q;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void a(float f2) {
        this.z = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d("alpha");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (r2.l.b() == 1.0f) goto L29;
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
            goto L2d
        Lb:
            java.lang.String r0 = "false"
            boolean r0 = r3.equals(r0)
            if (r0 == 0) goto L14
            goto L26
        L14:
            java.lang.String r0 = "toggle"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L32
            com.zk_oaction.adengine.lk_expression.a r3 = r2.l
            float r3 = r3.b()
            int r3 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r3 != 0) goto L2d
        L26:
            com.zk_oaction.adengine.lk_expression.a r3 = r2.l
            r0 = 0
            r3.h(r0)
            goto L32
        L2d:
            com.zk_oaction.adengine.lk_expression.a r3 = r2.l
            r3.h(r1)
        L32:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.f.a(java.lang.String):void");
    }

    @Override // com.zk_oaction.adengine.lk_expression.a.w
    public void a(String str, float f2) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
        if (str.equals("x") || str.equals("y")) {
            Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.f35128d.iterator();
            while (it2.hasNext()) {
                it2.next().g();
            }
        }
        if (str.equals(Downloads.Column.VISIBILITY)) {
            if (W() != 0.0f) {
                f();
                Iterator<com.zk_oaction.adengine.lk_unlock.b> it3 = this.f35127c.iterator();
                while (it3.hasNext()) {
                    it3.next().a("true");
                }
            } else {
                g();
                Iterator<com.zk_oaction.adengine.lk_unlock.b> it4 = this.f35127c.iterator();
                while (it4.hasNext()) {
                    it4.next().a("false");
                }
            }
            if (this.f35130f != null) {
                this.f35129e.u(this.f35130f + ".visibility", "" + W());
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public com.zk_oaction.adengine.lk_sdk.c b() {
        return this.f35129e;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void b(float f2, float f3) {
        this.w = f2;
        this.n = f3;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.d("x");
            next.d("y");
        }
        Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.f35128d.iterator();
        while (it2.hasNext()) {
            it2.next().g();
        }
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
        this.f35126b = f2;
        a(Downloads.Column.VISIBILITY, 0.0f);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public void c(String str) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            if (next instanceof com.zk_oaction.adengine.lk_sdk.interfaces.f) {
                ((com.zk_oaction.adengine.lk_sdk.interfaces.f) next).c(str);
            }
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f2) {
        this.C = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d("rotationY");
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(float f2, float f3) {
        this.x = f2;
        this.y = f3;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.d("x");
            next.d("y");
        }
        Iterator<com.zk_oaction.adengine.lk_command.a> it2 = this.f35128d.iterator();
        while (it2.hasNext()) {
            it2.next().g();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void d(String str) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d(str);
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.f
    public String e() {
        return this.f35130f;
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void e(float f2, float f3) {
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void f() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.f35125a.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.f35125a.iterator();
        while (it.hasNext()) {
            it.next().f();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void g(float f2) {
        this.A = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d("rotation");
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void h() {
        Iterator<com.zk_oaction.adengine.lk_animation.b> it = this.f35125a.iterator();
        while (it.hasNext()) {
            it.next().e();
        }
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void i(float f2) {
        this.B = f2;
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.o.iterator();
        while (it.hasNext()) {
            it.next().d("rotationX");
        }
    }

    protected void j() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.r = hashMap;
        hashMap.put("Image", new b());
        this.r.put("Frame", new c());
        this.r.put("Text", new d());
        this.r.put("ImageNumber", new e());
        this.r.put("Slider", new C0821f());
        this.r.put("Button", new g());
        this.r.put("Group", new h());
        this.r.put("PositionAnimation", new i());
        this.r.put("AlphaAnimation", new j());
        this.r.put("RotationAnimation", new a());
    }

    public void k(com.zk_oaction.adengine.lk_command.a aVar) {
        this.f35128d.add(aVar);
    }

    @Override // com.zk_oaction.adengine.lk_sdk.interfaces.b
    public void l(float f2) {
        this.l.h(f2);
    }

    public void m(com.zk_oaction.adengine.lk_sdk.interfaces.b bVar) {
        this.o.add(bVar);
    }

    public void n(f fVar) {
        this.D = fVar;
        fVar.m(this);
    }

    public void q(Object obj) {
        this.p = obj;
    }

    public boolean s(XmlPullParser xmlPullParser, String str) {
        try {
            this.f35130f = xmlPullParser.getAttributeValue(null, "name");
            this.f35131g = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, null, true);
            this.f35132h = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, null, true);
            String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
            if (attributeValue == null) {
                attributeValue = xmlPullParser.getAttributeValue(null, "width");
            }
            this.f35133i = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "width", attributeValue, 0.0f, null, true);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
            if (attributeValue2 == null) {
                attributeValue2 = xmlPullParser.getAttributeValue(null, "height");
            }
            this.f35134j = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "height", attributeValue2, 0.0f, null, true);
            this.k = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "alpha", xmlPullParser.getAttributeValue(null, "alpha"), 255.0f, null, false);
            String attributeValue3 = xmlPullParser.getAttributeValue(null, "rotation");
            if (attributeValue3 == null) {
                attributeValue3 = xmlPullParser.getAttributeValue(null, "angle");
            }
            this.s = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "rotation", attributeValue3, 0.0f, null, false);
            this.t = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "rotationX", xmlPullParser.getAttributeValue(null, "rotationX"), 0.0f, null, false);
            this.u = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "rotationY", xmlPullParser.getAttributeValue(null, "rotationY"), 0.0f, null, false);
            this.f35126b = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "active", xmlPullParser.getAttributeValue(null, "active"), 1.0f, null, false).b();
            this.l = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, Downloads.Column.VISIBILITY, xmlPullParser.getAttributeValue(null, Downloads.Column.VISIBILITY), 1.0f, null, false);
            this.v = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "layered", xmlPullParser.getAttributeValue(null, "layered"), 0.0f, null, false);
            this.m = new com.zk_oaction.adengine.lk_expression.a(this.f35129e, "clip", xmlPullParser.getAttributeValue(null, "clip"), 0.0f, null, false);
            while (true) {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.r.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    w();
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    public void w() {
        this.f35131g.i(this);
        this.f35132h.i(this);
        this.f35133i.i(this);
        this.f35134j.i(this);
        this.k.i(this);
        this.s.i(this);
        this.t.i(this);
        this.u.i(this);
        this.l.i(this);
    }

    public ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> z() {
        return this.o;
    }
}
