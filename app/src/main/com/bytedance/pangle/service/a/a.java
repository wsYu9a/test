package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.e;
import com.bytedance.pangle.g;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class a extends e.a {

    /* renamed from: c */
    private static volatile a f7796c;

    /* renamed from: d */
    private final HashMap<ComponentName, IBinder> f7799d = new HashMap<>();

    /* renamed from: e */
    private final HashMap<ComponentName, b> f7800e = new HashMap<>();

    /* renamed from: f */
    private final C0235a<Intent> f7801f = new C0235a<>();

    /* renamed from: g */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f7802g = new HashMap<>();

    /* renamed from: h */
    private final HashSet<ComponentName> f7803h = new HashSet<>();

    /* renamed from: i */
    private final HashSet<ComponentName> f7804i = new HashSet<>();

    /* renamed from: b */
    public final List<Runnable> f7798b = new ArrayList();

    /* renamed from: a */
    public final Handler f7797a = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$1 */
    public class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f7805a;

        /* renamed from: b */
        final /* synthetic */ String f7806b;

        public AnonymousClass1(Intent intent, String str) {
            intent = intent;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.c(intent, str);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f7808a;

        /* renamed from: b */
        final /* synthetic */ String f7809b;

        public AnonymousClass2(Intent intent, String str) {
            intent = intent;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.c(intent, str);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f7811a;

        public AnonymousClass3(Intent intent) {
            intent = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.b().a(intent.getComponent());
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$4 */
    public class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f7813a;

        /* renamed from: b */
        final /* synthetic */ g f7814b;

        /* renamed from: c */
        final /* synthetic */ int f7815c;

        /* renamed from: d */
        final /* synthetic */ String f7816d;

        public AnonymousClass4(Intent intent, g gVar, int i10, String str) {
            intent = intent;
            gVar = gVar;
            i10 = i10;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.a(intent, gVar, str);
            } catch (RemoteException e10) {
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e10);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$5 */
    public class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f7818a;

        /* renamed from: b */
        final /* synthetic */ g f7819b;

        /* renamed from: c */
        final /* synthetic */ int f7820c;

        /* renamed from: d */
        final /* synthetic */ String f7821d;

        public AnonymousClass5(Intent intent, g gVar, int i10, String str) {
            intent = intent;
            gVar = gVar;
            i10 = i10;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.a(intent, gVar, str);
            } catch (RemoteException e10) {
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e10);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ g f7823a;

        public AnonymousClass6(g gVar) {
            gVar = gVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.b(gVar);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$a */
    public class C0235a<T> extends HashMap<g, T> {
        public C0235a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            g gVar;
            T t10 = (T) super.remove(obj);
            if (t10 != null) {
                return t10;
            }
            Iterator<g> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = it.next();
                try {
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                if (gVar.a() == ((g) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(gVar);
        }
    }

    public class b extends HashSet<g> {
        public b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof g)) {
                return false;
            }
            Iterator<g> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                if (it.next().a() == ((g) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            g gVar;
            if (super.remove(obj)) {
                return true;
            }
            Iterator it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    gVar = null;
                    break;
                }
                gVar = (g) it.next();
                try {
                } catch (RemoteException e10) {
                    e10.printStackTrace();
                }
                if (gVar.a() == ((g) obj).a()) {
                    break;
                }
            }
            return super.remove(gVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (f7796c == null) {
            synchronized (a.class) {
                try {
                    if (f7796c == null) {
                        f7796c = new a();
                    }
                } finally {
                }
            }
        }
        return f7796c;
    }

    public synchronized ComponentName c(Intent intent, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.f7802g.containsKey(component)) {
                com.bytedance.pangle.service.a d10 = d(intent, str);
                if (d10 == null) {
                    return component;
                }
                this.f7802g.put(component, d10);
                this.f7803h.add(component);
            }
            com.bytedance.pangle.service.a aVar = this.f7802g.get(component);
            if (aVar != null) {
                aVar.onStartCommand(intent, 0, 0);
            }
            return component;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e10 = e(intent, str);
        if (e10 != null) {
            e10.onCreate();
        }
        return e10;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z10;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z10 = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e10) {
                e = e10;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z10)), e);
                return null;
            }
        } catch (Exception e11) {
            e = e11;
            z10 = false;
        }
    }

    @Override // com.bytedance.pangle.e.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.e
    public final ComponentName a(Intent intent, String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return c(intent, str);
            }
            this.f7797a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1

                /* renamed from: a */
                final /* synthetic */ Intent f7805a;

                /* renamed from: b */
                final /* synthetic */ String f7806b;

                public AnonymousClass1(Intent intent2, String str2) {
                    intent = intent2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        } else {
            this.f7798b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2

                /* renamed from: a */
                final /* synthetic */ Intent f7808a;

                /* renamed from: b */
                final /* synthetic */ String f7809b;

                public AnonymousClass2(Intent intent2, String str2) {
                    intent = intent2;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.c(intent, str);
                }
            });
        }
        return intent2.getComponent();
    }

    @Override // com.bytedance.pangle.e
    public final boolean b(Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f7797a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3

            /* renamed from: a */
            final /* synthetic */ Intent f7811a;

            public AnonymousClass3(Intent intent2) {
                intent = intent2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    private boolean b(ComponentName componentName) {
        if (!this.f7803h.contains(componentName)) {
            if (this.f7800e.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.f7804i.contains(componentName) || this.f7800e.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f7802g.remove(componentName);
        this.f7804i.remove(componentName);
        this.f7799d.remove(componentName);
        this.f7803h.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.f7802g.containsKey(componentName)) {
            return false;
        }
        this.f7804i.add(componentName);
        return b(componentName);
    }

    @Override // com.bytedance.pangle.e
    public final boolean a(Intent intent, g gVar, int i10, String str) {
        if (Zeus.hasInit()) {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return a(intent, gVar, str);
            }
            this.f7797a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4

                /* renamed from: a */
                final /* synthetic */ Intent f7813a;

                /* renamed from: b */
                final /* synthetic */ g f7814b;

                /* renamed from: c */
                final /* synthetic */ int f7815c;

                /* renamed from: d */
                final /* synthetic */ String f7816d;

                public AnonymousClass4(Intent intent2, g gVar2, int i102, String str2) {
                    intent = intent2;
                    gVar = gVar2;
                    i10 = i102;
                    str = str2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    try {
                        a.this.a(intent, gVar, str);
                    } catch (RemoteException e10) {
                        ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e10);
                    }
                }
            });
            return true;
        }
        this.f7798b.add(new Runnable() { // from class: com.bytedance.pangle.service.a.a.5

            /* renamed from: a */
            final /* synthetic */ Intent f7818a;

            /* renamed from: b */
            final /* synthetic */ g f7819b;

            /* renamed from: c */
            final /* synthetic */ int f7820c;

            /* renamed from: d */
            final /* synthetic */ String f7821d;

            public AnonymousClass5(Intent intent2, g gVar2, int i102, String str2) {
                intent = intent2;
                gVar = gVar2;
                i10 = i102;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, gVar, str);
                } catch (RemoteException e10) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "pending bindService failed", e10);
                }
            }
        });
        return true;
    }

    public synchronized void b(g gVar) {
        try {
            for (ComponentName componentName : this.f7800e.keySet()) {
                b bVar = this.f7800e.get(componentName);
                if (bVar.contains(gVar)) {
                    bVar.remove(gVar);
                    Intent remove = this.f7801f.remove(gVar);
                    if (bVar.size() == 0) {
                        this.f7800e.remove(componentName);
                        com.bytedance.pangle.service.a aVar = this.f7802g.get(componentName);
                        if (aVar != null) {
                            aVar.onUnbind(remove);
                        }
                    }
                    b(componentName);
                    return;
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public synchronized boolean a(Intent intent, g gVar, String str) {
        try {
            ComponentName component = intent.getComponent();
            if (!this.f7802g.containsKey(component)) {
                com.bytedance.pangle.service.a d10 = d(intent, str);
                if (d10 == null) {
                    return false;
                }
                this.f7802g.put(component, d10);
            }
            com.bytedance.pangle.service.a aVar = this.f7802g.get(component);
            if (!this.f7799d.containsKey(component)) {
                this.f7799d.put(component, aVar.onBind(intent));
            }
            IBinder iBinder = this.f7799d.get(component);
            if (iBinder != null) {
                if (this.f7800e.containsKey(component)) {
                    if (!this.f7800e.get(component).contains(gVar)) {
                        this.f7800e.get(component).add(gVar);
                        this.f7801f.put(gVar, intent);
                        gVar.a(component, iBinder);
                    }
                } else {
                    b bVar = new b();
                    bVar.add(gVar);
                    this.f7800e.put(component, bVar);
                    this.f7801f.put(gVar, intent);
                    gVar.a(component, iBinder);
                }
            }
            return true;
        } catch (Throwable th2) {
            throw th2;
        }
    }

    @Override // com.bytedance.pangle.e
    public final void a(g gVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(gVar);
        } else {
            this.f7797a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.6

                /* renamed from: a */
                final /* synthetic */ g f7823a;

                public AnonymousClass6(g gVar2) {
                    gVar = gVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(gVar);
                }
            });
        }
    }
}
