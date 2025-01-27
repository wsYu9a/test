package p1;

import java.util.Map;

/* loaded from: classes.dex */
public class d {
    public static boolean a(Map<?, ?> map) {
        return map == null || map.isEmpty();
    }

    public static boolean b(Map<?, ?> map) {
        return !a(map);
    }
}
