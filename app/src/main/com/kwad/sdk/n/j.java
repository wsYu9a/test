package com.kwad.sdk.n;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.NonNull;
import com.kwad.sdk.service.ServiceProvider;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes3.dex */
public class j {
    private static final String CLAZZ_NAME = "com.kwad.sdk.n.j";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aXW = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.n.j$1 */
    public class AnonymousClass1 extends com.kwad.sdk.core.c.d {
        final /* synthetic */ Context hB;

        public AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
        /* renamed from: onActivityDestroyed */
        public final void b(@NonNull Activity activity) {
            if (activity == context) {
                com.kwad.sdk.core.c.b.Fi();
                com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                j.onDestroy(context);
            }
        }
    }

    public static class a {
        private WeakReference<Context> alR;
        private int alS;
        private StackTraceElement[] alT;
        private int alU;
        private long alV;

        private a() {
            this.alR = new WeakReference<>(null);
            this.alS = 0;
            this.alT = null;
            this.alU = 0;
        }

        public static /* synthetic */ int c(a aVar) {
            int i10 = aVar.alS;
            aVar.alS = i10 + 1;
            return i10;
        }

        public void clear() {
            this.alR = new WeakReference<>(null);
            this.alS = 0;
            this.alT = null;
            this.alU = 0;
            this.alV = 0L;
        }

        public static /* synthetic */ int g(a aVar) {
            int i10 = aVar.alU;
            aVar.alU = i10 + 1;
            return i10;
        }

        public /* synthetic */ a(byte b10) {
            this();
        }
    }

    public static boolean PX() {
        return aXW.get();
    }

    private static void a(Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.c.b.Fi();
            com.kwad.sdk.core.c.b.a(new com.kwad.sdk.core.c.d() { // from class: com.kwad.sdk.n.j.1
                final /* synthetic */ Context hB;

                public AnonymousClass1(Context context3) {
                    context = context3;
                }

                @Override // com.kwad.sdk.core.c.d, com.kwad.sdk.core.c.c
                /* renamed from: onActivityDestroyed */
                public final void b(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.c.b.Fi();
                        com.kwad.sdk.core.c.b.b((com.kwad.sdk.core.c.c) this);
                        j.onDestroy(context);
                    }
                }
            });
        }
    }

    public static void cm(boolean z10) {
        aXW.set(z10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    public static Context dE(Context context) {
        boolean z10 = context instanceof b;
        Context context2 = context;
        if (z10) {
            context2 = ((b) context).getDelegatedContext();
        }
        if (m.dM(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i10 = 0;
        Context context3 = context2;
        while (i10 < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE());
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean aG = k.aG(context3);
            ?? r52 = context3;
            if (aG) {
                r52 = k.aF(context3);
            }
            boolean z11 = r52 instanceof b;
            Context context4 = r52;
            if (z11) {
                context4 = ((b) r52).getDelegatedContext();
            }
            if (m.dM(context4)) {
                return context4;
            }
            i10++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    public static Context dF(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = dE(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i10 = 0;
        Context context2 = applicationContext;
        while (i10 < 10) {
            Context applicationContext2 = context2.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            if (applicationContext2 instanceof b) {
                applicationContext2 = ((b) applicationContext2).getDelegatedContext();
            }
            i10++;
            context2 = applicationContext2;
        }
        return context2;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static void onDestroy(Context context) {
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = f.PU().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i10) {
        Resources resources = f.PU().getResources();
        if (resources == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i10, true);
        return newTheme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        if (aVar == null) {
            threadLocal.set(new a((byte) 0));
        } else if (aVar.alR.get() != context || Math.abs(System.currentTimeMillis() - aVar.alV) >= 150) {
            aVar.clear();
            aVar.alR = new WeakReference(context);
            aVar.alV = System.currentTimeMillis();
        } else {
            a.c(aVar);
            if (aVar.alS >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    public static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        if (!((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zB()) {
            return context;
        }
        if (context instanceof b) {
            return context;
        }
        if (k.aG(context)) {
            context = k.unwrapContextIfNeed(context);
            if (k.aG(context)) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof b) {
            return context3;
        }
        if (l.dG(context)) {
            return context;
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
            return context;
        }
        if (context instanceof Application) {
            try {
                g gVar = new g((Application) context, new h(context, f.PU()));
                m.a(gVar);
                context2 = gVar;
            } catch (Throwable unused) {
                ((com.kwad.sdk.service.a.e) ServiceProvider.get(com.kwad.sdk.service.a.e.class)).gatherException(new RuntimeException("wrapper Application fail --context:" + context.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.a.f) ServiceProvider.get(com.kwad.sdk.service.a.f.class)).zE()));
                return context;
            }
        } else {
            context2 = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context) : context instanceof ContextWrapper ? new e(context) : new e(context);
        }
        a(context, context2);
        return context2;
    }

    private static boolean a(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.alT)) {
            if (aVar.alT != null) {
                aVar.clear();
                return false;
            }
            aVar.alT = stackTrace;
            int i10 = 0;
            int i11 = 0;
            while (i10 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                String className = stackTraceElement.getClassName();
                for (String str : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str) && className.contains(str)) {
                        Log.d("Wrapper", "needAutoUnWrap true 命中白名单");
                        return true;
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i10++;
                if (i10 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i10];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i11 = i11 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.alT = stackTrace;
        if (aVar.alU < 5) {
            return false;
        }
        Log.d("Wrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }
}
