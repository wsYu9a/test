package f5;

import b5.u;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@a5.b
@f
/* loaded from: classes2.dex */
public abstract class a extends d {

    /* renamed from: c */
    public final char[][] f25970c;

    /* renamed from: d */
    public final int f25971d;

    /* renamed from: e */
    public final char f25972e;

    /* renamed from: f */
    public final char f25973f;

    public a(Map<Character, String> map, char c10, char c11) {
        this(b.a(map), c10, c11);
    }

    @Override // f5.d, f5.h
    public final String b(String str) {
        u.E(str);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < this.f25971d && this.f25970c[charAt] != null) || charAt > this.f25973f || charAt < this.f25972e) {
                return d(str, i10);
            }
        }
        return str;
    }

    @Override // f5.d
    @CheckForNull
    public final char[] c(char c10) {
        char[] cArr;
        if (c10 < this.f25971d && (cArr = this.f25970c[c10]) != null) {
            return cArr;
        }
        if (c10 < this.f25972e || c10 > this.f25973f) {
            return f(c10);
        }
        return null;
    }

    @CheckForNull
    public abstract char[] f(char c10);

    public a(b bVar, char c10, char c11) {
        u.E(bVar);
        char[][] c12 = bVar.c();
        this.f25970c = c12;
        this.f25971d = c12.length;
        if (c11 < c10) {
            c11 = 0;
            c10 = CharCompanionObject.MAX_VALUE;
        }
        this.f25972e = c10;
        this.f25973f = c11;
    }
}
