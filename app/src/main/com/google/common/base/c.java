package com.google.common.base;

import b5.p;
import b5.u;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@a5.b(emulated = true)
@b5.g
/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a */
    public final b5.b f9129a;

    /* renamed from: b */
    public final boolean f9130b;

    /* renamed from: c */
    public final h f9131c;

    /* renamed from: d */
    public final int f9132d;

    public class a implements h {

        /* renamed from: a */
        public final /* synthetic */ b5.b f9133a;

        /* renamed from: com.google.common.base.c$a$a */
        public class C0263a extends g {
            public C0263a(c cVar, CharSequence charSequence) {
                super(cVar, charSequence);
            }

            @Override // com.google.common.base.c.g
            public int e(int i10) {
                return i10 + 1;
            }

            @Override // com.google.common.base.c.g
            public int f(int i10) {
                return a.this.f9133a.o(this.f9146d, i10);
            }
        }

        public a(b5.b bVar) {
            this.f9133a = bVar;
        }

        @Override // com.google.common.base.c.h
        /* renamed from: b */
        public g a(c cVar, CharSequence charSequence) {
            return new C0263a(cVar, charSequence);
        }
    }

    public class b implements h {

        /* renamed from: a */
        public final /* synthetic */ String f9135a;

        public class a extends g {
            public a(c cVar, CharSequence charSequence) {
                super(cVar, charSequence);
            }

            @Override // com.google.common.base.c.g
            public int e(int i10) {
                return i10 + b.this.f9135a.length();
            }

            /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
            
                r6 = r6 + 1;
             */
            @Override // com.google.common.base.c.g
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public int f(int r6) {
                /*
                    r5 = this;
                    com.google.common.base.c$b r0 = com.google.common.base.c.b.this
                    java.lang.String r0 = r0.f9135a
                    int r0 = r0.length()
                    java.lang.CharSequence r1 = r5.f9146d
                    int r1 = r1.length()
                    int r1 = r1 - r0
                Lf:
                    if (r6 > r1) goto L2d
                    r2 = 0
                L12:
                    if (r2 >= r0) goto L2c
                    java.lang.CharSequence r3 = r5.f9146d
                    int r4 = r2 + r6
                    char r3 = r3.charAt(r4)
                    com.google.common.base.c$b r4 = com.google.common.base.c.b.this
                    java.lang.String r4 = r4.f9135a
                    char r4 = r4.charAt(r2)
                    if (r3 == r4) goto L29
                    int r6 = r6 + 1
                    goto Lf
                L29:
                    int r2 = r2 + 1
                    goto L12
                L2c:
                    return r6
                L2d:
                    r6 = -1
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.common.base.c.b.a.f(int):int");
            }
        }

        public b(String str) {
            this.f9135a = str;
        }

        @Override // com.google.common.base.c.h
        /* renamed from: b */
        public g a(c cVar, CharSequence charSequence) {
            return new a(cVar, charSequence);
        }
    }

    /* renamed from: com.google.common.base.c$c */
    public class C0264c implements h {

        /* renamed from: a */
        public final /* synthetic */ b5.e f9137a;

        /* renamed from: com.google.common.base.c$c$a */
        public class a extends g {

            /* renamed from: i */
            public final /* synthetic */ b5.d f9138i;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public a(C0264c c0264c, c cVar, CharSequence charSequence, b5.d dVar) {
                super(cVar, charSequence);
                this.f9138i = dVar;
            }

            @Override // com.google.common.base.c.g
            public int e(int i10) {
                return this.f9138i.a();
            }

            @Override // com.google.common.base.c.g
            public int f(int i10) {
                if (this.f9138i.c(i10)) {
                    return this.f9138i.f();
                }
                return -1;
            }
        }

        public C0264c(b5.e eVar) {
            this.f9137a = eVar;
        }

        @Override // com.google.common.base.c.h
        /* renamed from: b */
        public g a(c cVar, CharSequence charSequence) {
            return new a(this, cVar, charSequence, this.f9137a.matcher(charSequence));
        }
    }

    public class d implements h {

        /* renamed from: a */
        public final /* synthetic */ int f9139a;

        public class a extends g {
            public a(c cVar, CharSequence charSequence) {
                super(cVar, charSequence);
            }

            @Override // com.google.common.base.c.g
            public int e(int i10) {
                return i10;
            }

            @Override // com.google.common.base.c.g
            public int f(int i10) {
                int i11 = i10 + d.this.f9139a;
                if (i11 < this.f9146d.length()) {
                    return i11;
                }
                return -1;
            }
        }

        public d(int i10) {
            this.f9139a = i10;
        }

        @Override // com.google.common.base.c.h
        /* renamed from: b */
        public g a(c cVar, CharSequence charSequence) {
            return new a(cVar, charSequence);
        }
    }

    public class e implements Iterable<String> {

        /* renamed from: b */
        public final /* synthetic */ CharSequence f9141b;

        public e(CharSequence charSequence) {
            this.f9141b = charSequence;
        }

        @Override // java.lang.Iterable
        public Iterator<String> iterator() {
            return c.this.p(this.f9141b);
        }

        public String toString() {
            p p10 = p.p(", ");
            StringBuilder sb2 = new StringBuilder();
            sb2.append('[');
            StringBuilder f10 = p10.f(sb2, this);
            f10.append(']');
            return f10.toString();
        }
    }

    @a5.a
    public static final class f {

        /* renamed from: c */
        public static final String f9143c = "Chunk [%s] is not a valid entry";

        /* renamed from: a */
        public final c f9144a;

        /* renamed from: b */
        public final c f9145b;

        public /* synthetic */ f(c cVar, c cVar2, a aVar) {
            this(cVar, cVar2);
        }

        public Map<String, String> a(CharSequence charSequence) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : this.f9144a.n(charSequence)) {
                Iterator p10 = this.f9145b.p(str);
                u.u(p10.hasNext(), f9143c, str);
                String str2 = (String) p10.next();
                u.u(!linkedHashMap.containsKey(str2), "Duplicate key [%s] found.", str2);
                u.u(p10.hasNext(), f9143c, str);
                linkedHashMap.put(str2, (String) p10.next());
                u.u(!p10.hasNext(), f9143c, str);
            }
            return Collections.unmodifiableMap(linkedHashMap);
        }

        public f(c cVar, c cVar2) {
            this.f9144a = cVar;
            this.f9145b = (c) u.E(cVar2);
        }
    }

    public static abstract class g extends AbstractIterator<String> {

        /* renamed from: d */
        public final CharSequence f9146d;

        /* renamed from: e */
        public final b5.b f9147e;

        /* renamed from: f */
        public final boolean f9148f;

        /* renamed from: g */
        public int f9149g = 0;

        /* renamed from: h */
        public int f9150h;

        public g(c cVar, CharSequence charSequence) {
            this.f9147e = cVar.f9129a;
            this.f9148f = cVar.f9130b;
            this.f9150h = cVar.f9132d;
            this.f9146d = charSequence;
        }

        @Override // com.google.common.base.AbstractIterator
        @CheckForNull
        /* renamed from: d */
        public String a() {
            int f10;
            int i10 = this.f9149g;
            while (true) {
                int i11 = this.f9149g;
                if (i11 == -1) {
                    return b();
                }
                f10 = f(i11);
                if (f10 == -1) {
                    f10 = this.f9146d.length();
                    this.f9149g = -1;
                } else {
                    this.f9149g = e(f10);
                }
                int i12 = this.f9149g;
                if (i12 == i10) {
                    int i13 = i12 + 1;
                    this.f9149g = i13;
                    if (i13 > this.f9146d.length()) {
                        this.f9149g = -1;
                    }
                } else {
                    while (i10 < f10 && this.f9147e.B(this.f9146d.charAt(i10))) {
                        i10++;
                    }
                    while (f10 > i10 && this.f9147e.B(this.f9146d.charAt(f10 - 1))) {
                        f10--;
                    }
                    if (!this.f9148f || i10 != f10) {
                        break;
                    }
                    i10 = this.f9149g;
                }
            }
            int i14 = this.f9150h;
            if (i14 == 1) {
                f10 = this.f9146d.length();
                this.f9149g = -1;
                while (f10 > i10 && this.f9147e.B(this.f9146d.charAt(f10 - 1))) {
                    f10--;
                }
            } else {
                this.f9150h = i14 - 1;
            }
            return this.f9146d.subSequence(i10, f10).toString();
        }

        public abstract int e(int i10);

        public abstract int f(int i10);
    }

    public interface h {
        Iterator<String> a(c cVar, CharSequence charSequence);
    }

    public c(h hVar) {
        this(hVar, false, b5.b.G(), Integer.MAX_VALUE);
    }

    public static c e(int i10) {
        u.e(i10 > 0, "The length may not be less than 1");
        return new c(new d(i10));
    }

    public static c h(char c10) {
        return i(b5.b.q(c10));
    }

    public static c i(b5.b bVar) {
        u.E(bVar);
        return new c(new a(bVar));
    }

    public static c j(b5.e eVar) {
        u.u(!eVar.matcher("").d(), "The pattern may not match the empty string: %s", eVar);
        return new c(new C0264c(eVar));
    }

    public static c k(String str) {
        u.e(str.length() != 0, "The separator may not be the empty string.");
        return str.length() == 1 ? h(str.charAt(0)) : new c(new b(str));
    }

    @a5.c
    public static c l(Pattern pattern) {
        return j(new JdkPattern(pattern));
    }

    @a5.c
    public static c m(String str) {
        return j(com.google.common.base.b.b(str));
    }

    public c f(int i10) {
        u.k(i10 > 0, "must be greater than zero: %s", i10);
        return new c(this.f9131c, this.f9130b, this.f9129a, i10);
    }

    public c g() {
        return new c(this.f9131c, true, this.f9129a, this.f9132d);
    }

    public Iterable<String> n(CharSequence charSequence) {
        u.E(charSequence);
        return new e(charSequence);
    }

    public List<String> o(CharSequence charSequence) {
        u.E(charSequence);
        Iterator<String> p10 = p(charSequence);
        ArrayList arrayList = new ArrayList();
        while (p10.hasNext()) {
            arrayList.add(p10.next());
        }
        return Collections.unmodifiableList(arrayList);
    }

    public final Iterator<String> p(CharSequence charSequence) {
        return this.f9131c.a(this, charSequence);
    }

    public c q() {
        return r(b5.b.X());
    }

    public c r(b5.b bVar) {
        u.E(bVar);
        return new c(this.f9131c, this.f9130b, bVar, this.f9132d);
    }

    @a5.a
    public f s(char c10) {
        return t(h(c10));
    }

    @a5.a
    public f t(c cVar) {
        return new f(this, cVar, null);
    }

    @a5.a
    public f u(String str) {
        return t(k(str));
    }

    public c(h hVar, boolean z10, b5.b bVar, int i10) {
        this.f9131c = hVar;
        this.f9130b = z10;
        this.f9129a = bVar;
        this.f9132d = i10;
    }
}
