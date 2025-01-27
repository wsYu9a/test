package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.kwad.sdk.m.a.a;
import com.kwad.sdk.utils.bd;
import com.kwad.sdk.utils.h;
import com.kwad.sdk.utils.w;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class b {
    public static final String TAG = "Ranger_" + b.class.getSimpleName();
    private String value;

    /* renamed from: com.kwad.sdk.m.b$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ List aRA;

        public AnonymousClass1(List list) {
            list2 = list;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ArrayList arrayList = new ArrayList();
            for (com.kwad.sdk.m.a.a aVar : list2) {
                if (aVar != null && !TextUtils.isEmpty(aVar.aRP)) {
                    String str = aVar.aRP;
                    b.this.a(aVar);
                    b bVar = b.this;
                    com.kwad.sdk.m.b.a.c a10 = b.a(bVar, str, bVar.value);
                    if (a10 != null) {
                        arrayList.add(a10);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return;
            }
            com.kwad.sdk.m.b.a.d dVar = new com.kwad.sdk.m.b.a.d();
            dVar.aSe = arrayList;
            com.kwad.sdk.m.b.a.a(dVar);
        }
    }

    public static class a {
        private static final b aRC = new b((byte) 0);
    }

    public /* synthetic */ b(byte b10) {
        this();
    }

    public static b Mm() {
        return a.aRC;
    }

    public static /* synthetic */ com.kwad.sdk.m.b.a.c a(b bVar, String str, String str2) {
        return am(str, str2);
    }

    @Nullable
    private static com.kwad.sdk.m.b.a.c am(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        com.kwad.sdk.m.b.a.c cVar = new com.kwad.sdk.m.b.a.c();
        cVar.name = str;
        cVar.aSd = str2;
        return cVar;
    }

    private static Object c(com.kwad.sdk.m.a.a aVar) {
        if (aVar.aRO) {
            try {
                return w.c(Class.forName(aVar.aRM), aVar.aRN);
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e10));
            }
        } else {
            Object obj = aVar.aRL;
            if (obj != null) {
                return w.getField(obj, aVar.aRN);
            }
        }
        return null;
    }

    private void l(Object obj) {
        if (obj != null) {
            this.value = String.valueOf(obj);
        } else {
            com.kwad.sdk.core.d.c.w(TAG, "value is null by ob null");
            this.value = "";
        }
    }

    public final void b(c cVar) {
        List<com.kwad.sdk.m.a.a> list;
        if (cVar == null || (list = cVar.aRF) == null || list.isEmpty()) {
            return;
        }
        h.schedule(new bd() { // from class: com.kwad.sdk.m.b.1
            final /* synthetic */ List aRA;

            public AnonymousClass1(List list2) {
                list2 = list2;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ArrayList arrayList = new ArrayList();
                for (com.kwad.sdk.m.a.a aVar : list2) {
                    if (aVar != null && !TextUtils.isEmpty(aVar.aRP)) {
                        String str = aVar.aRP;
                        b.this.a(aVar);
                        b bVar = b.this;
                        com.kwad.sdk.m.b.a.c a10 = b.a(bVar, str, bVar.value);
                        if (a10 != null) {
                            arrayList.add(a10);
                        }
                    }
                }
                if (arrayList.isEmpty()) {
                    return;
                }
                com.kwad.sdk.m.b.a.d dVar = new com.kwad.sdk.m.b.a.d();
                dVar.aSe = arrayList;
                com.kwad.sdk.m.b.a.a(dVar);
            }
        }, 20L, TimeUnit.SECONDS);
    }

    private b() {
    }

    public void a(com.kwad.sdk.m.a.a aVar) {
        com.kwad.sdk.m.a.a aVar2 = aVar.aRR;
        if (aVar2 != null && !aVar2.Mr()) {
            if (!TextUtils.isEmpty(aVar.aRN)) {
                aVar.aRR.aRL = c(aVar);
            } else {
                a.b bVar = aVar.aRQ;
                if (bVar != null && !bVar.Mr()) {
                    aVar.aRR.aRL = b(aVar);
                }
            }
            a(aVar.aRR);
            return;
        }
        if (!TextUtils.isEmpty(aVar.aRN)) {
            l(c(aVar));
            return;
        }
        a.b bVar2 = aVar.aRQ;
        if (bVar2 != null && !bVar2.Mr()) {
            l(b(aVar));
            return;
        }
        com.kwad.sdk.core.d.c.d(TAG, "node.nodeClassName:" + aVar.aRM);
        this.value = w.classExists(aVar.aRM) ? "true" : "false";
    }

    private Object b(com.kwad.sdk.m.a.a aVar) {
        Class<?> cls;
        if (aVar.aRQ.aRZ) {
            try {
                if (!TextUtils.isEmpty(aVar.aRM)) {
                    cls = Class.forName(aVar.aRM);
                } else {
                    Object obj = aVar.aRL;
                    cls = obj != null ? obj.getClass() : null;
                }
                if (cls != null) {
                    return a(aVar, true, cls);
                }
                return null;
            } catch (Exception e10) {
                com.kwad.sdk.core.d.c.w(TAG, Log.getStackTraceString(e10));
                return null;
            }
        }
        if (aVar.aRL != null) {
            return a(aVar, false, (Class<?>) null);
        }
        return null;
    }

    private static Object a(com.kwad.sdk.m.a.a aVar, boolean z10, Class<?> cls) {
        Object[] Mu = aVar.aRQ.Mu();
        if (Mu == null || Mu.length == 0) {
            if (z10) {
                return w.callStaticMethod(cls, aVar.aRQ.name, new Object[0]);
            }
            return w.callMethod(aVar.aRL, aVar.aRQ.name, new Object[0]);
        }
        if (z10) {
            return w.callStaticMethod(cls, aVar.aRQ.name, Mu);
        }
        return w.callMethod(aVar.aRL, aVar.aRQ.name, Mu);
    }
}
