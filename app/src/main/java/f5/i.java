package f5;

import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@a5.b
@f
/* loaded from: classes2.dex */
public final class i {

    /* renamed from: a */
    public static final h f25989a = new a();

    public class a extends d {
        @Override // f5.d, f5.h
        public String b(String str) {
            return (String) u.E(str);
        }

        @Override // f5.d
        @CheckForNull
        public char[] c(char c10) {
            return null;
        }
    }

    public class b extends l {

        /* renamed from: c */
        public final /* synthetic */ d f25990c;

        public b(d dVar) {
            this.f25990c = dVar;
        }

        @Override // f5.l
        @CheckForNull
        public char[] d(int i10) {
            if (i10 < 65536) {
                return this.f25990c.c((char) i10);
            }
            char[] cArr = new char[2];
            Character.toChars(i10, cArr, 0);
            char[] c10 = this.f25990c.c(cArr[0]);
            char[] c11 = this.f25990c.c(cArr[1]);
            if (c10 == null && c11 == null) {
                return null;
            }
            int length = c10 != null ? c10.length : 1;
            char[] cArr2 = new char[(c11 != null ? c11.length : 1) + length];
            if (c10 != null) {
                for (int i11 = 0; i11 < c10.length; i11++) {
                    cArr2[i11] = c10[i11];
                }
            } else {
                cArr2[0] = cArr[0];
            }
            if (c11 != null) {
                for (int i12 = 0; i12 < c11.length; i12++) {
                    cArr2[length + i12] = c11[i12];
                }
            } else {
                cArr2[length] = cArr[1];
            }
            return cArr2;
        }
    }

    public static final class c {

        /* renamed from: a */
        public final Map<Character, String> f25991a;

        /* renamed from: b */
        public char f25992b;

        /* renamed from: c */
        public char f25993c;

        /* renamed from: d */
        @CheckForNull
        public String f25994d;

        public class a extends f5.a {

            /* renamed from: g */
            @CheckForNull
            public final char[] f25995g;

            public a(Map map, char c10, char c11) {
                super((Map<Character, String>) map, c10, c11);
                this.f25995g = c.this.f25994d != null ? c.this.f25994d.toCharArray() : null;
            }

            @Override // f5.a
            @CheckForNull
            public char[] f(char c10) {
                return this.f25995g;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        @CanIgnoreReturnValue
        public c b(char c10, String str) {
            u.E(str);
            this.f25991a.put(Character.valueOf(c10), str);
            return this;
        }

        public h c() {
            return new a(this.f25991a, this.f25992b, this.f25993c);
        }

        @CanIgnoreReturnValue
        public c d(char c10, char c11) {
            this.f25992b = c10;
            this.f25993c = c11;
            return this;
        }

        @CanIgnoreReturnValue
        public c e(String str) {
            this.f25994d = str;
            return this;
        }

        public c() {
            this.f25991a = new HashMap();
            this.f25992b = (char) 0;
            this.f25993c = CharCompanionObject.MAX_VALUE;
            this.f25994d = null;
        }
    }

    public static l a(h hVar) {
        u.E(hVar);
        if (hVar instanceof l) {
            return (l) hVar;
        }
        if (hVar instanceof d) {
            return g((d) hVar);
        }
        String name = hVar.getClass().getName();
        throw new IllegalArgumentException(name.length() != 0 ? "Cannot create a UnicodeEscaper from: ".concat(name) : new String("Cannot create a UnicodeEscaper from: "));
    }

    public static c b() {
        return new c(null);
    }

    @CheckForNull
    public static String c(d dVar, char c10) {
        return f(dVar.c(c10));
    }

    @CheckForNull
    public static String d(l lVar, int i10) {
        return f(lVar.d(i10));
    }

    public static h e() {
        return f25989a;
    }

    @CheckForNull
    public static String f(@CheckForNull char[] cArr) {
        if (cArr == null) {
            return null;
        }
        return new String(cArr);
    }

    public static l g(d dVar) {
        return new b(dVar);
    }
}
