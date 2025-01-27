package com.zk_oaction.adengine.lk_unlock;

import com.zk_oaction.adengine.lk_command.g;
import com.zk_oaction.adengine.lk_view.i;
import com.zk_oaction.adengine.lk_view.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    protected com.zk_oaction.adengine.lk_view.f f34998a;

    /* renamed from: b */
    private com.zk_oaction.adengine.lk_sdk.c f34999b;

    /* renamed from: c */
    private com.zk_oaction.adengine.lk_view.d f35000c;

    /* renamed from: d */
    private ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.b> f35001d = new ArrayList<>();

    /* renamed from: e */
    private boolean f35002e;

    /* renamed from: f */
    private g f35003f;

    /* renamed from: g */
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> f35004g;

    class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.e(xmlPullParser);
            return null;
        }
    }

    class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.i(xmlPullParser);
            return null;
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_unlock.c$c */
    class C0815c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C0815c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.m(xmlPullParser);
            return null;
        }
    }

    class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.o(xmlPullParser);
            return null;
        }
    }

    class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.q(xmlPullParser);
            return null;
        }
    }

    class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.s(xmlPullParser);
            return null;
        }
    }

    public c(com.zk_oaction.adengine.lk_sdk.c cVar) {
        this.f34999b = cVar;
        this.f35000c = cVar.I;
        k();
    }

    public void e(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this.f34999b);
        if (gVar.W(xmlPullParser, "Image")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f34998a;
            if (fVar != null) {
                gVar.r(fVar);
            } else {
                this.f35000c.h(gVar);
            }
            this.f35001d.add(gVar);
        }
    }

    public void i(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this.f34999b);
        if (eVar.T(xmlPullParser, "Frame")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f34998a;
            if (fVar != null) {
                eVar.r(fVar);
            } else {
                this.f35000c.h(eVar);
            }
            this.f35001d.add(eVar);
        }
    }

    private void k() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.f35004g = hashMap;
        hashMap.put("Image", new a());
        this.f35004g.put("Frame", new b());
        this.f35004g.put("Text", new C0815c());
        this.f35004g.put("ImageNumber", new d());
        this.f35004g.put("Group", new e());
        this.f35004g.put("Trigger", new f());
    }

    public void m(XmlPullParser xmlPullParser) {
        m mVar = new m(this.f34999b);
        if (mVar.R(xmlPullParser, "Text")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f34998a;
            if (fVar != null) {
                mVar.r(fVar);
            } else {
                this.f35000c.h(mVar);
            }
            this.f35001d.add(mVar);
        }
    }

    public void o(XmlPullParser xmlPullParser) {
        i iVar = new i(this.f34999b);
        if (iVar.R(xmlPullParser, "ImageNumber")) {
            com.zk_oaction.adengine.lk_view.f fVar = this.f34998a;
            if (fVar != null) {
                iVar.r(fVar);
            } else {
                this.f35000c.h(iVar);
            }
            this.f35001d.add(iVar);
        }
    }

    public void q(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.f fVar = new com.zk_oaction.adengine.lk_view.f(this.f34999b);
        if (fVar.s(xmlPullParser, "Group")) {
            com.zk_oaction.adengine.lk_view.f fVar2 = this.f34998a;
            if (fVar2 != null) {
                fVar.n(fVar2);
            } else {
                this.f35000c.h(fVar);
            }
            this.f35001d.add(fVar);
        }
    }

    public void s(XmlPullParser xmlPullParser) {
        g gVar = new g(this.f34999b);
        this.f35003f = gVar;
        if (gVar.c(xmlPullParser, "Trigger")) {
            return;
        }
        this.f35003f = null;
    }

    public void a() {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.f35001d.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            next.c(1.0f);
            next.l(1.0f);
            next.f();
        }
        g gVar = this.f35003f;
        if (gVar != null) {
            gVar.a();
        }
        this.f35002e = true;
    }

    public void b(float f2, float f3) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.f35001d.iterator();
        while (it.hasNext()) {
            it.next().b(f2, f3);
        }
    }

    public void d(com.zk_oaction.adengine.lk_view.f fVar) {
        this.f34998a = fVar;
    }

    public void f(boolean z) {
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.b> it = this.f35001d.iterator();
        while (it.hasNext()) {
            com.zk_oaction.adengine.lk_sdk.interfaces.b next = it.next();
            if (z) {
                next.g();
            } else {
                next.h();
            }
            next.c(0.0f);
            next.l(0.0f);
        }
        this.f35002e = false;
    }

    public boolean g(XmlPullParser xmlPullParser, String str) {
        while (true) {
            try {
                int next = xmlPullParser.next();
                if (next == 1) {
                    break;
                }
                if (next == 2) {
                    com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar = this.f35004g.get(xmlPullParser.getName());
                    if (cVar != null) {
                        cVar.a(xmlPullParser);
                    }
                } else if (next == 3 && xmlPullParser.getName().equals(str)) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return false;
    }

    public boolean j() {
        return this.f35002e;
    }
}
