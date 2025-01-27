package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.ranger.kwai.a;
import com.kwad.sdk.utils.aw;
import com.kwad.sdk.utils.g;
import com.kwad.sdk.utils.s;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* renamed from: com.kwad.sdk.ranger.b$1 */
    final class AnonymousClass1 extends aw {
        final /* synthetic */ List axN;

        AnonymousClass1(List list) {
            list2 = list;
        }

        @Override // com.kwad.sdk.utils.aw
        public final void doTask() {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.ranger.kwai.a aVar : list2) {
                if (aVar != null && !TextUtils.isEmpty(aVar.ayr)) {
                    String str = aVar.ayr;
                    b.this.a(aVar);
                    b bVar = b.this;
                    com.kwad.sdk.ranger.a.kwai.c a2 = b.a(bVar, str, bVar.value);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            com.kwad.sdk.ranger.a.kwai.d dVar = new com.kwad.sdk.ranger.a.kwai.d();
            dVar.ayG = arrayList;
            com.kwad.sdk.ranger.a.a.a(dVar);
        }
    }

    static class a {
        private static final b axP = new b((byte) 0);
    }

    private b() {
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public static b Ck() {
        return a.axP;
    }

    @Nullable
    private static com.kwad.sdk.ranger.a.kwai.c X(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.ranger.a.kwai.c cVar = new com.kwad.sdk.ranger.a.kwai.c();
        cVar.name = str;
        cVar.ayF = str2;
        return cVar;
    }

    static /* synthetic */ com.kwad.sdk.ranger.a.kwai.c a(b bVar, String str, String str2) {
        return X(str, str2);
    }

    private static Object a(com.kwad.sdk.ranger.kwai.a aVar, boolean z, Class<?> cls) {
        Object[] Cu = aVar.ays.Cu();
        return (Cu == null || Cu.length == 0) ? z ? s.b(cls, aVar.ays.name, new Object[0]) : s.a(aVar.ayn, aVar.ays.name, new Object[0]) : z ? s.b(cls, aVar.ays.name, Cu) : s.a(aVar.ayn, aVar.ays.name, Cu);
    }

    public void a(com.kwad.sdk.ranger.kwai.a aVar) {
        com.kwad.sdk.ranger.kwai.a aVar2;
        Object b2;
        com.kwad.sdk.ranger.kwai.a aVar3 = aVar.ayt;
        if (aVar3 != null && !aVar3.Cr()) {
            if (TextUtils.isEmpty(aVar.ayp)) {
                a.b bVar = aVar.ays;
                if (bVar != null && !bVar.Cr()) {
                    aVar2 = aVar.ayt;
                    b2 = b(aVar);
                }
                a(aVar.ayt);
                return;
            }
            aVar2 = aVar.ayt;
            b2 = c(aVar);
            aVar2.ayn = b2;
            a(aVar.ayt);
            return;
        }
        if (!TextUtils.isEmpty(aVar.ayp)) {
            g(c(aVar));
            return;
        }
        a.b bVar2 = aVar.ays;
        if (bVar2 != null && !bVar2.Cr()) {
            g(b(aVar));
            return;
        }
        com.kwad.sdk.core.d.b.d(TAG, "node.nodeClassName:" + aVar.ayo);
        this.value = s.ez(aVar.ayo) ? "true" : "false";
    }

    private Object b(com.kwad.sdk.ranger.kwai.a aVar) {
        Class<?> cls;
        if (!aVar.ays.ayB) {
            if (aVar.ayn != null) {
                return a(aVar, false, (Class<?>) null);
            }
            return null;
        }
        try {
            if (TextUtils.isEmpty(aVar.ayo)) {
                Object obj = aVar.ayn;
                cls = obj != null ? obj.getClass() : null;
            } else {
                cls = Class.forName(aVar.ayo);
            }
            if (cls != null) {
                return a(aVar, true, cls);
            }
            return null;
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.w(TAG, Log.getStackTraceString(e2));
            return null;
        }
    }

    private static Object c(com.kwad.sdk.ranger.kwai.a aVar) {
        if (aVar.ayq) {
            try {
                return s.c(Class.forName(aVar.ayo), aVar.ayp);
            } catch (Exception e2) {
                com.kwad.sdk.core.d.b.w(TAG, Log.getStackTraceString(e2));
            }
        } else {
            Object obj = aVar.ayn;
            if (obj != null) {
                return s.d(obj, aVar.ayp);
            }
        }
        return null;
    }

    private void g(Object obj) {
        String str;
        if (obj != null) {
            str = String.valueOf(obj);
        } else {
            com.kwad.sdk.core.d.b.w(TAG, "value is null by ob null");
            str = "";
        }
        this.value = str;
    }

    public final void b(d dVar) {
        List<com.kwad.sdk.ranger.kwai.a> list;
        if (dVar == null || (list = dVar.axX) == null || list.isEmpty()) {
            return;
        }
        g.schedule(new aw() { // from class: com.kwad.sdk.ranger.b.1
            final /* synthetic */ List axN;

            AnonymousClass1(List list2) {
                list2 = list2;
            }

            @Override // com.kwad.sdk.utils.aw
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.ranger.kwai.a aVar : list2) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.ayr)) {
                        String str = aVar.ayr;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.ranger.a.kwai.c a2 = b.a(bVar, str, bVar.value);
                        if (a2 != null) {
                            arrayList.add(a2);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.ranger.a.kwai.d dVar2 = new com.kwad.sdk.ranger.a.kwai.d();
                dVar2.ayG = arrayList;
                com.kwad.sdk.ranger.a.a.a(dVar2);
            }
        }, 120L, TimeUnit.SECONDS);
    }
}
