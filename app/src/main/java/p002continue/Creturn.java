package p002continue;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import bh.b;
import bh.h;
import bh.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import p002continue.e;
import p002continue.f;

/* renamed from: continue.return */
/* loaded from: classes4.dex */
public final class Creturn extends Observable {

    /* renamed from: a */
    public final e.c f25218a;

    /* renamed from: b */
    public final e.d f25219b;

    /* renamed from: c */
    public final e.a f25220c;

    /* renamed from: d */
    public final e.b f25221d;

    /* renamed from: e */
    public final Context f25222e;

    /* renamed from: f */
    public volatile e f25223f;

    /* renamed from: g */
    public volatile a f25224g;

    /* renamed from: continue.return$a */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        /* JADX WARN: Type inference failed for: r5v4, types: [java.util.ArrayList, java.util.List<java.lang.Class<? extends continue.c<?>>>] */
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            Object obj = message.obj;
            if (obj != null) {
                c<?> cVar = (c) obj;
                b.a.f1608a.i("StateContext", "handleMessage before mCurrentState=%s event:%s", Creturn.this.f25223f.a(), cVar.f25193a);
                e eVar = Creturn.this.f25223f;
                Iterator it = eVar.f25205a.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        str = "Skip";
                        break;
                    } else if (((Class) it.next()).isInstance(cVar)) {
                        cVar.a();
                        str = "Process";
                        break;
                    }
                }
                eVar.b(cVar, str);
                Object[] objArr = new Object[0];
                Creturn.this.getClass();
                try {
                    if (cVar.f25194b) {
                        Throwable th2 = cVar.f25197e;
                        String str2 = "";
                        try {
                            str2 = cVar.c();
                        } catch (Exception unused) {
                        }
                        if (th2 != null) {
                            b.a.f1608a.n("PluginManager", th2, "onEvent(name:%s reportValue:%s) args:%s", cVar.f25193a, str2, Arrays.toString(objArr));
                        } else {
                            b.a.f1608a.i("PluginManager", "onEvent(name:%s reportValue:%s) args:%s", cVar.f25193a, str2, Arrays.toString(objArr));
                        }
                    }
                } catch (Throwable th3) {
                    j jVar = b.a.f1608a;
                    StringBuilder a10 = nh.b.a("reportEvent FAIL:");
                    a10.append(cVar.f25193a);
                    jVar.c("StateContext", th3, a10.toString());
                }
                b.a.f1608a.i("StateContext", "handleMessage after mCurrentState=%s event:%s", Creturn.this.f25223f.a(), cVar.f25193a);
            }
        }
    }

    public Creturn(Context context) {
        this.f25222e = context;
        e.c cVar = new e.c(this);
        this.f25218a = cVar;
        this.f25219b = new e.d(this);
        this.f25220c = new e.a(this);
        this.f25221d = new e.b(this);
        this.f25223f = cVar;
        HandlerThread handlerThread = new HandlerThread("snadsdk_state_context_thread");
        handlerThread.start();
        this.f25224g = new a(handlerThread.getLooper());
    }

    public final List<String> a() {
        ArrayList arrayList = new ArrayList();
        Iterator it = ((ArrayList) f.b.f25213a.i()).iterator();
        while (it.hasNext()) {
            arrayList.add(((h) it.next()).f1621e);
        }
        return arrayList;
    }

    public final void b(c cVar) {
        this.f25224g.sendMessage(this.f25224g.obtainMessage(1, cVar));
    }

    public final void c(e eVar) {
        this.f25223f = eVar;
        setChanged();
        notifyObservers(eVar);
    }
}
