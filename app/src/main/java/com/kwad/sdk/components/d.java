package com.kwad.sdk.components;

import android.content.Context;
import androidx.annotation.Nullable;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public final class d {
    private static final Map<Class, b> aso = new ConcurrentHashMap();

    /* renamed from: com.kwad.sdk.components.d$1 */
    public class AnonymousClass1 implements Comparator<b> {
        private static int a(b bVar, b bVar2) {
            if (bVar == null) {
                return -1;
            }
            if (bVar2 == null) {
                return 1;
            }
            try {
                try {
                    return bVar.priority() - bVar2.priority();
                } catch (Exception unused) {
                    return 1;
                }
            } catch (Exception unused2) {
                return -1;
            }
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(b bVar, b bVar2) {
            return a(bVar, bVar2);
        }
    }

    public static void a(Class cls, b bVar) {
        aso.put(cls, bVar);
    }

    @Nullable
    public static DevelopMangerComponents.DevelopValue da(String str) {
        return null;
    }

    @Nullable
    public static <T extends b> T f(Class<T> cls) {
        Map<Class, b> map = aso;
        T t10 = (T) map.get(cls);
        if (t10 != null) {
            return t10;
        }
        com.kwad.sdk.core.d.c.w("KSAd_", new ComponentsNotFoundException(cls.getSimpleName()));
        try {
            if (!DevelopMangerComponents.class.isAssignableFrom(cls)) {
                return null;
            }
            f fVar = new f();
            map.put(cls, fVar);
            return fVar;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void init(Context context) {
        ArrayList arrayList = new ArrayList(aso.values());
        Collections.sort(arrayList, new Comparator<b>() { // from class: com.kwad.sdk.components.d.1
            private static int a(b bVar, b bVar2) {
                if (bVar == null) {
                    return -1;
                }
                if (bVar2 == null) {
                    return 1;
                }
                try {
                    try {
                        return bVar.priority() - bVar2.priority();
                    } catch (Exception unused) {
                        return 1;
                    }
                } catch (Exception unused2) {
                    return -1;
                }
            }

            @Override // java.util.Comparator
            public final /* synthetic */ int compare(b bVar, b bVar2) {
                return a(bVar, bVar2);
            }
        });
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar != null) {
                try {
                    bVar.init(context);
                } catch (Throwable th2) {
                    ServiceProvider.reportSdkCaughtException(th2);
                }
            }
        }
    }
}
