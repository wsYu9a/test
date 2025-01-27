package com.kwad.sdk.n;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.am;
import com.kwad.sdk.utils.bd;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public final class l {
    private static final AtomicBoolean LB = new AtomicBoolean(false);
    private static a aXX;

    /* renamed from: com.kwad.sdk.n.l$1 */
    public class AnonymousClass1 extends bd {

        /* renamed from: com.kwad.sdk.n.l$1$1 */
        public class C05121 extends com.kwad.sdk.f.b<JSONObject, JSONObject> {
            public C05121() {
            }

            private static JSONObject o(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return null;
                }
                jSONObject.optJSONObject("wrapperBlackConfig");
                return null;
            }

            @Override // com.kwad.sdk.f.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                return o(jSONObject);
            }
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            a unused = l.aXX = new a();
            try {
                l.aXX.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.f.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.l.1.1
                    public C05121() {
                    }

                    private static JSONObject o(JSONObject jSONObject) {
                        if (jSONObject == null) {
                            return null;
                        }
                        jSONObject.optJSONObject("wrapperBlackConfig");
                        return null;
                    }

                    @Override // com.kwad.sdk.f.b
                    public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                        return o(jSONObject);
                    }
                }));
            } catch (Throwable unused2) {
            }
        }
    }

    @KsJson
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aXZ;
        public List<C0513a> aYa;

        @KsJson
        /* renamed from: com.kwad.sdk.n.l$a$a */
        public static class C0513a extends com.kwad.sdk.core.response.a.a {
            public String aYb;
            public String aYc;
        }
    }

    public static void HF() {
        if (LB.getAndSet(true)) {
            return;
        }
        com.kwad.sdk.utils.h.execute(new bd() { // from class: com.kwad.sdk.n.l.1

            /* renamed from: com.kwad.sdk.n.l$1$1 */
            public class C05121 extends com.kwad.sdk.f.b<JSONObject, JSONObject> {
                public C05121() {
                }

                private static JSONObject o(JSONObject jSONObject) {
                    if (jSONObject == null) {
                        return null;
                    }
                    jSONObject.optJSONObject("wrapperBlackConfig");
                    return null;
                }

                @Override // com.kwad.sdk.f.b
                public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                    return o(jSONObject);
                }
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                a unused = l.aXX = new a();
                try {
                    l.aXX.parseJson((JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.f.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.n.l.1.1
                        public C05121() {
                        }

                        private static JSONObject o(JSONObject jSONObject) {
                            if (jSONObject == null) {
                                return null;
                            }
                            jSONObject.optJSONObject("wrapperBlackConfig");
                            return null;
                        }

                        @Override // com.kwad.sdk.f.b
                        public final /* synthetic */ JSONObject apply(JSONObject jSONObject) {
                            return o(jSONObject);
                        }
                    }));
                } catch (Throwable unused2) {
                }
            }
        });
    }

    public static boolean dG(Context context) {
        a aVar = aXX;
        if (aVar == null || am.H(aVar.aXZ) || am.H(aXX.aYa) || !a(context, aXX)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, aXX)) {
                return true;
            }
        }
        return false;
    }

    private static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        Iterator it = new CopyOnWriteArrayList(aVar.aXZ).iterator();
        while (it.hasNext()) {
            if (am.a((String) it.next(), name)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    private static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0513a c0513a : new CopyOnWriteArrayList(aVar.aYa)) {
            String str = c0513a.aYb;
            String str2 = c0513a.aYc;
            if (am.a(str, className) && am.a(str2, methodName)) {
                com.kwad.sdk.core.d.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }
}
