package com.opos.mobad.service.g;

import android.content.Context;
import com.opos.cmn.biz.monitor.MonitorEvent;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static volatile com.opos.mobad.provider.monitor.a f23671a;

    /* renamed from: com.opos.mobad.service.g.b$1 */
    static final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ List f23672a;

        /* renamed from: b */
        final /* synthetic */ Context f23673b;

        /* renamed from: c */
        final /* synthetic */ MonitorEvent f23674c;

        AnonymousClass1(List list, Context context, MonitorEvent monitorEvent) {
            list = list;
            context = context;
            monitorEvent = monitorEvent;
        }

        @Override // java.lang.Runnable
        public void run() {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                try {
                    b.b(context).a((String) it.next(), monitorEvent);
                } catch (Exception unused) {
                    com.opos.cmn.an.f.a.b("", "monitor fail");
                }
            }
        }
    }

    public static final a a() {
        return new a();
    }

    public static final String a(Context context, String str, a aVar) {
        return com.opos.cmn.biz.monitor.a.a().b(context.getApplicationContext(), str, aVar.a());
    }

    public static final void a(Context context, List<String> list) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, null);
    }

    public static final void a(Context context, List<String> list, MonitorEvent monitorEvent) {
        if (context == null || list == null || list.size() <= 0) {
            return;
        }
        b(context, list, monitorEvent);
    }

    public static com.opos.mobad.provider.monitor.a b(Context context) {
        com.opos.mobad.provider.monitor.a aVar = f23671a;
        if (aVar == null) {
            synchronized (b.class) {
                aVar = f23671a;
                if (aVar == null) {
                    aVar = new com.opos.mobad.provider.monitor.a(context.getApplicationContext());
                    f23671a = aVar;
                }
            }
        }
        return aVar;
    }

    private static final void b(Context context, List<String> list, MonitorEvent monitorEvent) {
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.service.g.b.1

            /* renamed from: a */
            final /* synthetic */ List f23672a;

            /* renamed from: b */
            final /* synthetic */ Context f23673b;

            /* renamed from: c */
            final /* synthetic */ MonitorEvent f23674c;

            AnonymousClass1(List list2, Context context2, MonitorEvent monitorEvent2) {
                list = list2;
                context = context2;
                monitorEvent = monitorEvent2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    try {
                        b.b(context).a((String) it.next(), monitorEvent);
                    } catch (Exception unused) {
                        com.opos.cmn.an.f.a.b("", "monitor fail");
                    }
                }
            }
        });
    }
}
