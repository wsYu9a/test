package com.kwad.sdk.h;

import androidx.annotation.WorkerThread;
import com.kwad.sdk.h.l;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.SubBusinessType;
import com.kwai.adclient.kscommerciallogger.model.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
final class m {
    private static final Map<String, k> aNW = new ConcurrentHashMap();
    private static long aNX;

    /* renamed from: com.kwad.sdk.h.m$1 */
    public class AnonymousClass1 implements l.a {
        final /* synthetic */ List aBD;

        public AnonymousClass1(List list) {
            actionList = list;
        }

        @Override // com.kwad.sdk.h.l.a
        public final void onSuccess() {
            j.Lc();
            m.x(actionList);
        }
    }

    public static void Le() {
        long currentTimeMillis = System.currentTimeMillis() - aNX;
        if (aNW.size() <= 0 || currentTimeMillis <= h.KR().KX()) {
            return;
        }
        aNX = System.currentTimeMillis();
        List<k> actionList = getActionList();
        actionList.size();
        j.Lc();
        l.a(actionList, new l.a() { // from class: com.kwad.sdk.h.m.1
            final /* synthetic */ List aBD;

            public AnonymousClass1(List actionList2) {
                actionList = actionList2;
            }

            @Override // com.kwad.sdk.h.l.a
            public final void onSuccess() {
                j.Lc();
                m.x(actionList);
            }
        });
    }

    @WorkerThread
    public static synchronized void a(i iVar, boolean z10) {
        synchronized (m.class) {
            try {
                Map<String, k> map = aNW;
                if (map.size() > 200) {
                    j.ak("LogRequestManger", "enqueueAction fail size limit");
                } else {
                    k b10 = b(iVar, z10);
                    map.put(b10.actionId, b10);
                }
                Le();
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    private static k b(i iVar, boolean z10) {
        com.kwai.adclient.kscommerciallogger.model.c Qo = (z10 ? c.a.Qm() : c.a.Qn()).b(BusinessType.OTHER).b(SubBusinessType.OTHER).hz("ad_sdk_local_log").hy(iVar.aNP).A(iVar.toJson()).Qo();
        return new k(Qo.Qg(), Qo.toString(), iVar);
    }

    private static synchronized List<k> getActionList() {
        ArrayList arrayList;
        synchronized (m.class) {
            Map<String, k> map = aNW;
            arrayList = new ArrayList(map.size());
            Iterator<Map.Entry<String, k>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(it.next().getValue());
            }
        }
        return arrayList;
    }

    public static synchronized void x(List<k> list) {
        synchronized (m.class) {
            if (list != null) {
                Iterator<k> it = list.iterator();
                while (it.hasNext()) {
                    aNW.remove(it.next().actionId);
                }
            }
        }
    }
}
