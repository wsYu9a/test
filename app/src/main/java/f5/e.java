package f5;

import b5.u;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.CheckForNull;

@a5.b
@f
/* loaded from: classes2.dex */
public final class e {

    /* renamed from: b */
    public int f25984b = -1;

    /* renamed from: a */
    public final Map<Character, String> f25983a = new HashMap();

    public static class a extends d {

        /* renamed from: c */
        public final char[][] f25985c;

        /* renamed from: d */
        public final int f25986d;

        public a(char[][] cArr) {
            this.f25985c = cArr;
            this.f25986d = cArr.length;
        }

        @Override // f5.d, f5.h
        public String b(String str) {
            int length = str.length();
            for (int i10 = 0; i10 < length; i10++) {
                char charAt = str.charAt(i10);
                char[][] cArr = this.f25985c;
                if (charAt < cArr.length && cArr[charAt] != null) {
                    return d(str, i10);
                }
            }
            return str;
        }

        @Override // f5.d
        @CheckForNull
        public char[] c(char c10) {
            if (c10 < this.f25986d) {
                return this.f25985c[c10];
            }
            return null;
        }
    }

    @CanIgnoreReturnValue
    public e a(char c10, String str) {
        this.f25983a.put(Character.valueOf(c10), (String) u.E(str));
        if (c10 > this.f25984b) {
            this.f25984b = c10;
        }
        return this;
    }

    @CanIgnoreReturnValue
    public e b(char[] cArr, String str) {
        u.E(str);
        for (char c10 : cArr) {
            a(c10, str);
        }
        return this;
    }

    public char[][] c() {
        char[][] cArr = new char[this.f25984b + 1][];
        for (Map.Entry<Character, String> entry : this.f25983a.entrySet()) {
            cArr[entry.getKey().charValue()] = entry.getValue().toCharArray();
        }
        return cArr;
    }

    public h d() {
        return new a(c());
    }
}
