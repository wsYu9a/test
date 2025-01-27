package f5;

import b5.u;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.Map;

@a5.b
@f
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: b */
    public static final char[][] f25974b = (char[][]) Array.newInstance((Class<?>) Character.TYPE, 0, 0);

    /* renamed from: a */
    public final char[][] f25975a;

    public b(char[][] cArr) {
        this.f25975a = cArr;
    }

    public static b a(Map<Character, String> map) {
        return new b(b(map));
    }

    @a5.d
    public static char[][] b(Map<Character, String> map) {
        u.E(map);
        if (map.isEmpty()) {
            return f25974b;
        }
        char[][] cArr = new char[((Character) Collections.max(map.keySet())).charValue() + 1][];
        for (Character ch2 : map.keySet()) {
            cArr[ch2.charValue()] = map.get(ch2).toCharArray();
        }
        return cArr;
    }

    public char[][] c() {
        return this.f25975a;
    }
}
