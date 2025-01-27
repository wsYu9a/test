package uk.co.senab.actionbarpulltorefresh.library;

import uk.c;
import uk.d;

/* loaded from: classes5.dex */
public final class b {

    /* renamed from: h */
    public static final int f31163h = R.layout.default_header;

    /* renamed from: i */
    public static final float f31164i = 0.5f;

    /* renamed from: j */
    public static final boolean f31165j = false;

    /* renamed from: k */
    public static final int f31166k = 1000;

    /* renamed from: l */
    public static final boolean f31167l = true;

    /* renamed from: a */
    public c f31168a = null;

    /* renamed from: b */
    public int f31169b = f31163h;

    /* renamed from: c */
    public d f31170c = null;

    /* renamed from: d */
    public float f31171d = 0.5f;

    /* renamed from: e */
    public boolean f31172e = false;

    /* renamed from: f */
    public int f31173f = 1000;

    /* renamed from: g */
    public boolean f31174g = true;

    public static class a {

        /* renamed from: a */
        public final b f31175a = new b();

        public b a() {
            return this.f31175a;
        }

        public a b(c cVar) {
            this.f31175a.f31168a = cVar;
            return this;
        }

        public a c(int i10) {
            this.f31175a.f31169b = i10;
            return this;
        }

        public a d(d dVar) {
            this.f31175a.f31170c = dVar;
            return this;
        }

        public a e() {
            return f(1000);
        }

        public a f(int i10) {
            b bVar = this.f31175a;
            bVar.f31173f = i10;
            bVar.f31174g = true;
            return this;
        }

        public a g() {
            this.f31175a.f31174g = false;
            return this;
        }

        public a h(boolean z10) {
            this.f31175a.f31172e = z10;
            return this;
        }

        public a i(float f10) {
            this.f31175a.f31171d = f10;
            return this;
        }
    }

    public static a a() {
        return new a();
    }
}
