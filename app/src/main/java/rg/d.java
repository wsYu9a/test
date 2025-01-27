package rg;

import java.util.Map;

/* loaded from: classes4.dex */
public class d implements a {

    /* renamed from: a */
    public static a f30425a;

    public d(a aVar) {
        f30425a = aVar;
    }

    @Override // rg.a
    public void a(String str, int i10, Object obj, Object obj2, Object obj3, Map<String, Object> map) {
        try {
            a aVar = f30425a;
            if (aVar != null) {
                aVar.a(str, i10, obj, obj2, obj3, map);
            }
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }

    public void b(String str, Map<String, Object> map) {
        a("tanx_exposer_sdk_trace", b.a(), str, null, null, map);
    }
}
