package com.bytedance.pangle.service.a;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.d;
import com.bytedance.pangle.f;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public class a extends d.a {

    /* renamed from: b */
    private static volatile a f6282b;

    /* renamed from: c */
    private final HashMap<ComponentName, IBinder> f6284c = new HashMap<>();

    /* renamed from: d */
    private final HashMap<ComponentName, b> f6285d = new HashMap<>();

    /* renamed from: e */
    private final C0075a<Intent> f6286e = new C0075a<>();

    /* renamed from: f */
    private final HashMap<ComponentName, com.bytedance.pangle.service.a> f6287f = new HashMap<>();

    /* renamed from: g */
    private final HashSet<ComponentName> f6288g = new HashSet<>();

    /* renamed from: h */
    private final HashSet<ComponentName> f6289h = new HashSet<>();

    /* renamed from: a */
    private final Handler f6283a = new Handler(Looper.getMainLooper());

    /* renamed from: com.bytedance.pangle.service.a.a$1 */
    final class AnonymousClass1 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f6290a;

        /* renamed from: b */
        final /* synthetic */ String f6291b;

        AnonymousClass1(Intent intent, String str) {
            intent = intent;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.c(intent, str);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$2 */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f6293a;

        AnonymousClass2(Intent intent) {
            intent = intent;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.b().a(intent.getComponent());
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Intent f6295a;

        /* renamed from: b */
        final /* synthetic */ f f6296b;

        /* renamed from: c */
        final /* synthetic */ int f6297c;

        /* renamed from: d */
        final /* synthetic */ String f6298d;

        AnonymousClass3(Intent intent, f fVar, int i2, String str) {
            intent = intent;
            fVar = fVar;
            i2 = i2;
            str = str;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                a.this.a(intent, fVar, str);
            } catch (RemoteException e2) {
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
            }
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$4 */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ f f6300a;

        AnonymousClass4(f fVar) {
            fVar = fVar;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a.this.b(fVar);
        }
    }

    /* renamed from: com.bytedance.pangle.service.a.a$a */
    class C0075a<T> extends HashMap<f, T> {
        C0075a() {
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        public final boolean containsKey(@Nullable Object obj) {
            if (super.containsKey(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = keySet().iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
        @Nullable
        public final T remove(@Nullable Object obj) {
            f fVar;
            T t = (T) super.remove(obj);
            if (t != null) {
                return t;
            }
            Iterator<f> it = keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    fVar = null;
                    break;
                }
                fVar = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (fVar.a() == ((f) obj).a()) {
                    break;
                }
            }
            return (T) super.remove(fVar);
        }
    }

    class b extends HashSet<f> {
        b() {
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean contains(@Nullable Object obj) {
            if (super.contains(obj)) {
                return true;
            }
            if (!(obj instanceof f)) {
                return false;
            }
            Iterator<f> it = iterator();
            while (it.hasNext()) {
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (it.next().a() == ((f) obj).a()) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final boolean remove(@Nullable Object obj) {
            if (super.remove(obj)) {
                return true;
            }
            f fVar = null;
            Iterator<f> it = iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                f next = it.next();
                try {
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
                if (next.a() == ((f) obj).a()) {
                    fVar = next;
                    break;
                }
            }
            return super.remove(fVar);
        }
    }

    private a() {
    }

    public static a b() {
        if (f6282b == null) {
            synchronized (a.class) {
                if (f6282b == null) {
                    f6282b = new a();
                }
            }
        }
        return f6282b;
    }

    public synchronized ComponentName c(Intent intent, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f6287f.containsKey(component)) {
            com.bytedance.pangle.service.a d2 = d(intent, str);
            if (d2 == null) {
                return component;
            }
            this.f6287f.put(component, d2);
            this.f6288g.add(component);
        }
        com.bytedance.pangle.service.a aVar = this.f6287f.get(component);
        if (aVar != null) {
            aVar.onStartCommand(intent, 0, 0);
        }
        return component;
    }

    private static com.bytedance.pangle.service.a d(Intent intent, String str) {
        com.bytedance.pangle.service.a e2 = e(intent, str);
        if (e2 != null) {
            e2.onCreate();
        }
        return e2;
    }

    private static com.bytedance.pangle.service.a e(Intent intent, String str) {
        boolean z;
        ComponentName component = intent.getComponent();
        Plugin plugin = PluginManager.getInstance().getPlugin(str);
        try {
            z = Zeus.loadPlugin(str);
            try {
                com.bytedance.pangle.service.a aVar = (com.bytedance.pangle.service.a) plugin.mClassLoader.loadClass(component.getClassName()).newInstance();
                aVar.attach(plugin);
                return aVar;
            } catch (Exception e2) {
                e = e2;
                ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "newServiceInstance failed! loadPlugin = ".concat(String.valueOf(z)), e);
                throw new RuntimeException(e);
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
    }

    @Override // com.bytedance.pangle.d.a, android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // com.bytedance.pangle.d
    public final ComponentName a(Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return c(intent, str);
        }
        this.f6283a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.1

            /* renamed from: a */
            final /* synthetic */ Intent f6290a;

            /* renamed from: b */
            final /* synthetic */ String f6291b;

            AnonymousClass1(Intent intent2, String str2) {
                intent = intent2;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.this.c(intent, str);
            }
        });
        return intent2.getComponent();
    }

    @Override // com.bytedance.pangle.d
    public final boolean b(Intent intent, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b().a(intent.getComponent());
            return true;
        }
        this.f6283a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.2

            /* renamed from: a */
            final /* synthetic */ Intent f6293a;

            AnonymousClass2(Intent intent2) {
                intent = intent2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                a.b().a(intent.getComponent());
            }
        });
        return true;
    }

    public final synchronized boolean a(ComponentName componentName) {
        if (!this.f6287f.containsKey(componentName)) {
            return false;
        }
        this.f6289h.add(componentName);
        return b(componentName);
    }

    private boolean b(ComponentName componentName) {
        if (!this.f6288g.contains(componentName)) {
            if (this.f6285d.get(componentName) != null) {
                return false;
            }
            c(componentName);
            return true;
        }
        if (!this.f6289h.contains(componentName) || this.f6285d.containsKey(componentName)) {
            return false;
        }
        c(componentName);
        return true;
    }

    private void c(ComponentName componentName) {
        com.bytedance.pangle.service.a remove = this.f6287f.remove(componentName);
        this.f6289h.remove(componentName);
        this.f6284c.remove(componentName);
        this.f6288g.remove(componentName);
        if (remove != null) {
            remove.onDestroy();
        }
    }

    @Override // com.bytedance.pangle.d
    public final boolean a(Intent intent, f fVar, int i2, String str) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            return a(intent, fVar, str);
        }
        this.f6283a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.3

            /* renamed from: a */
            final /* synthetic */ Intent f6295a;

            /* renamed from: b */
            final /* synthetic */ f f6296b;

            /* renamed from: c */
            final /* synthetic */ int f6297c;

            /* renamed from: d */
            final /* synthetic */ String f6298d;

            AnonymousClass3(Intent intent2, f fVar2, int i22, String str2) {
                intent = intent2;
                fVar = fVar2;
                i2 = i22;
                str = str2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    a.this.a(intent, fVar, str);
                } catch (RemoteException e2) {
                    ZeusLogger.errReport(ZeusLogger.TAG_SERVICE, "bindService failed", e2);
                }
            }
        });
        return true;
    }

    public synchronized boolean a(Intent intent, f fVar, String str) {
        ComponentName component = intent.getComponent();
        if (!this.f6287f.containsKey(component)) {
            com.bytedance.pangle.service.a d2 = d(intent, str);
            if (d2 == null) {
                return false;
            }
            this.f6287f.put(component, d2);
        }
        com.bytedance.pangle.service.a aVar = this.f6287f.get(component);
        if (!this.f6284c.containsKey(component)) {
            this.f6284c.put(component, aVar.onBind(intent));
        }
        IBinder iBinder = this.f6284c.get(component);
        if (iBinder != null) {
            if (this.f6285d.containsKey(component)) {
                if (!this.f6285d.get(component).contains(fVar)) {
                    this.f6285d.get(component).add(fVar);
                    this.f6286e.put(fVar, intent);
                    fVar.a(component, iBinder);
                }
            } else {
                b bVar = new b();
                bVar.add(fVar);
                this.f6285d.put(component, bVar);
                this.f6286e.put(fVar, intent);
                fVar.a(component, iBinder);
            }
        }
        return true;
    }

    public synchronized void b(f fVar) {
        for (ComponentName componentName : this.f6285d.keySet()) {
            b bVar = this.f6285d.get(componentName);
            if (bVar.contains(fVar)) {
                bVar.remove(fVar);
                Intent remove = this.f6286e.remove(fVar);
                if (bVar.size() == 0) {
                    this.f6285d.remove(componentName);
                    com.bytedance.pangle.service.a aVar = this.f6287f.get(componentName);
                    if (aVar != null) {
                        aVar.onUnbind(remove);
                    }
                }
                b(componentName);
                return;
            }
        }
    }

    @Override // com.bytedance.pangle.d
    public final void a(f fVar) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            b(fVar);
        } else {
            this.f6283a.post(new Runnable() { // from class: com.bytedance.pangle.service.a.a.4

                /* renamed from: a */
                final /* synthetic */ f f6300a;

                AnonymousClass4(f fVar2) {
                    fVar = fVar2;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    a.this.b(fVar);
                }
            });
        }
    }
}
