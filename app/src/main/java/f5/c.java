package f5;

import b5.u;
import java.util.Map;
import javax.annotation.CheckForNull;
import kotlin.jvm.internal.CharCompanionObject;

@a5.b
@f
/* loaded from: classes2.dex */
public abstract class c extends l {

    /* renamed from: c */
    public final char[][] f25976c;

    /* renamed from: d */
    public final int f25977d;

    /* renamed from: e */
    public final int f25978e;

    /* renamed from: f */
    public final int f25979f;

    /* renamed from: g */
    public final char f25980g;

    /* renamed from: h */
    public final char f25981h;

    public c(Map<Character, String> map, int i10, int i11, String str) {
        this(b.a(map), i10, i11, str);
    }

    @Override // f5.l, f5.h
    public final String b(String str) {
        u.E(str);
        for (int i10 = 0; i10 < str.length(); i10++) {
            char charAt = str.charAt(i10);
            if ((charAt < this.f25977d && this.f25976c[charAt] != null) || charAt > this.f25981h || charAt < this.f25980g) {
                return e(str, i10);
            }
        }
        return str;
    }

    @Override // f5.l
    @CheckForNull
    public final char[] d(int i10) {
        char[] cArr;
        if (i10 < this.f25977d && (cArr = this.f25976c[i10]) != null) {
            return cArr;
        }
        if (i10 < this.f25978e || i10 > this.f25979f) {
            return h(i10);
        }
        return null;
    }

    @Override // f5.l
    public final int g(CharSequence charSequence, int i10, int i11) {
        while (i10 < i11) {
            char charAt = charSequence.charAt(i10);
            if ((charAt < this.f25977d && this.f25976c[charAt] != null) || charAt > this.f25981h || charAt < this.f25980g) {
                break;
            }
            i10++;
        }
        return i10;
    }

    @CheckForNull
    public abstract char[] h(int i10);

    public c(b bVar, int i10, int i11, String str) {
        u.E(bVar);
        char[][] c10 = bVar.c();
        this.f25976c = c10;
        this.f25977d = c10.length;
        if (i11 < i10) {
            i11 = -1;
            i10 = Integer.MAX_VALUE;
        }
        this.f25978e = i10;
        this.f25979f = i11;
        if (i10 >= 55296) {
            this.f25980g = CharCompanionObject.MAX_VALUE;
            this.f25981h = (char) 0;
        } else {
            this.f25980g = (char) i10;
            this.f25981h = (char) Math.min(i11, 55295);
        }
    }
}
