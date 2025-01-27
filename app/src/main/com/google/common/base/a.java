package com.google.common.base;

import b5.g;
import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@g
/* loaded from: classes2.dex */
public final class a {

    public static final class b {

        /* renamed from: a */
        public final String f9119a;

        /* renamed from: b */
        public final C0261b f9120b;

        /* renamed from: c */
        public C0261b f9121c;

        /* renamed from: d */
        public boolean f9122d;

        /* renamed from: e */
        public boolean f9123e;

        /* renamed from: com.google.common.base.a$b$a */
        public static final class C0260a extends C0261b {
            public C0260a() {
                super();
            }

            public /* synthetic */ C0260a(C0259a c0259a) {
                this();
            }
        }

        /* renamed from: com.google.common.base.a$b$b */
        public static class C0261b {

            /* renamed from: a */
            @CheckForNull
            public String f9124a;

            /* renamed from: b */
            @CheckForNull
            public Object f9125b;

            /* renamed from: c */
            @CheckForNull
            public C0261b f9126c;

            public C0261b() {
            }

            public /* synthetic */ C0261b(C0259a c0259a) {
                this();
            }
        }

        public /* synthetic */ b(String str, C0259a c0259a) {
            this(str);
        }

        public static boolean u(Object obj) {
            return obj instanceof CharSequence ? ((CharSequence) obj).length() == 0 : obj instanceof Collection ? ((Collection) obj).isEmpty() : obj instanceof Map ? ((Map) obj).isEmpty() : obj instanceof Optional ? !((Optional) obj).isPresent() : obj.getClass().isArray() && Array.getLength(obj) == 0;
        }

        @CanIgnoreReturnValue
        public b a(String str, char c10) {
            return m(str, String.valueOf(c10));
        }

        @CanIgnoreReturnValue
        public b b(String str, double d10) {
            return m(str, String.valueOf(d10));
        }

        @CanIgnoreReturnValue
        public b c(String str, float f10) {
            return m(str, String.valueOf(f10));
        }

        @CanIgnoreReturnValue
        public b d(String str, int i10) {
            return m(str, String.valueOf(i10));
        }

        @CanIgnoreReturnValue
        public b e(String str, long j10) {
            return m(str, String.valueOf(j10));
        }

        @CanIgnoreReturnValue
        public b f(String str, @CheckForNull Object obj) {
            return j(str, obj);
        }

        @CanIgnoreReturnValue
        public b g(String str, boolean z10) {
            return m(str, String.valueOf(z10));
        }

        public final C0261b h() {
            C0261b c0261b = new C0261b();
            this.f9121c.f9126c = c0261b;
            this.f9121c = c0261b;
            return c0261b;
        }

        public final b i(@CheckForNull Object obj) {
            h().f9125b = obj;
            return this;
        }

        public final b j(String str, @CheckForNull Object obj) {
            C0261b h10 = h();
            h10.f9125b = obj;
            h10.f9124a = (String) u.E(str);
            return this;
        }

        public final C0260a k() {
            C0260a c0260a = new C0260a();
            this.f9121c.f9126c = c0260a;
            this.f9121c = c0260a;
            return c0260a;
        }

        public final b l(Object obj) {
            k().f9125b = obj;
            return this;
        }

        public final b m(String str, Object obj) {
            C0260a k10 = k();
            k10.f9125b = obj;
            k10.f9124a = (String) u.E(str);
            return this;
        }

        @CanIgnoreReturnValue
        public b n(char c10) {
            return l(String.valueOf(c10));
        }

        @CanIgnoreReturnValue
        public b o(double d10) {
            return l(String.valueOf(d10));
        }

        @CanIgnoreReturnValue
        public b p(float f10) {
            return l(String.valueOf(f10));
        }

        @CanIgnoreReturnValue
        public b q(int i10) {
            return l(String.valueOf(i10));
        }

        @CanIgnoreReturnValue
        public b r(long j10) {
            return l(String.valueOf(j10));
        }

        @CanIgnoreReturnValue
        public b s(@CheckForNull Object obj) {
            return i(obj);
        }

        @CanIgnoreReturnValue
        public b t(boolean z10) {
            return l(String.valueOf(z10));
        }

        public String toString() {
            boolean z10 = this.f9122d;
            boolean z11 = this.f9123e;
            StringBuilder sb2 = new StringBuilder(32);
            sb2.append(this.f9119a);
            sb2.append('{');
            String str = "";
            for (C0261b c0261b = this.f9120b.f9126c; c0261b != null; c0261b = c0261b.f9126c) {
                Object obj = c0261b.f9125b;
                if (!(c0261b instanceof C0260a)) {
                    if (obj == null) {
                        if (z10) {
                        }
                    } else if (z11 && u(obj)) {
                    }
                }
                sb2.append(str);
                String str2 = c0261b.f9124a;
                if (str2 != null) {
                    sb2.append(str2);
                    sb2.append('=');
                }
                if (obj == null || !obj.getClass().isArray()) {
                    sb2.append(obj);
                } else {
                    String deepToString = Arrays.deepToString(new Object[]{obj});
                    sb2.append((CharSequence) deepToString, 1, deepToString.length() - 1);
                }
                str = ", ";
            }
            sb2.append('}');
            return sb2.toString();
        }

        @CanIgnoreReturnValue
        public b v() {
            this.f9122d = true;
            return this;
        }

        public b(String str) {
            C0261b c0261b = new C0261b();
            this.f9120b = c0261b;
            this.f9121c = c0261b;
            this.f9122d = false;
            this.f9123e = false;
            this.f9119a = (String) u.E(str);
        }
    }

    public static <T> T a(@CheckForNull T t10, T t11) {
        if (t10 != null) {
            return t10;
        }
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public static b b(Class<?> cls) {
        return new b(cls.getSimpleName());
    }

    public static b c(Object obj) {
        return new b(obj.getClass().getSimpleName());
    }

    public static b d(String str) {
        return new b(str);
    }
}
