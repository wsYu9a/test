package rg;

import java.util.Map;

/* loaded from: classes4.dex */
public class c {
    public static void a(String str, Map<String, Object> map, boolean z10) {
        sg.a.c(str, map);
        hg.b i10 = hg.c.c().i();
        if (i10 != null) {
            if (z10 && i10.b()) {
                return;
            }
            i10.i().b(str, map);
        }
    }
}
