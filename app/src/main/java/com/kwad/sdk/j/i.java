package com.kwad.sdk.j;

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

/* loaded from: classes2.dex */
public class i {
    private static final String CLAZZ_NAME = "com.kwad.sdk.j.i";
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static final Map<Context, Context> sResContextCache = new WeakHashMap();
    private static final AtomicBoolean aDO = new AtomicBoolean(false);

    /* renamed from: com.kwad.sdk.j.i$1 */
    static class AnonymousClass1 extends com.kwad.sdk.core.b.d {
        final /* synthetic */ Context jN;

        AnonymousClass1(Context context) {
            context = context;
        }

        @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
        public final void onActivityDestroyed(@NonNull Activity activity) {
            if (activity == context) {
                com.kwad.sdk.core.b.b.vS();
                com.kwad.sdk.core.b.b.b(this);
                i.onDestroy(context);
            }
        }
    }

    static class a {
        private WeakReference<Context> aaH;
        private int aaI;
        private StackTraceElement[] aaJ;
        private int aaK;
        private long aaL;

        private a() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
        }

        /* synthetic */ a(byte b2) {
            this();
        }

        static /* synthetic */ int c(a aVar) {
            int i2 = aVar.aaI;
            aVar.aaI = i2 + 1;
            return i2;
        }

        public void clear() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
            this.aaL = 0L;
        }

        static /* synthetic */ int g(a aVar) {
            int i2 = aVar.aaK;
            aVar.aaK = i2 + 1;
            return i2;
        }
    }

    public static boolean FO() {
        return aDO.get();
    }

    private static void a(Context context, Context context2) {
        sResContextCache.put(context, context2);
        if (context instanceof Activity) {
            com.kwad.sdk.core.b.b.vS();
            com.kwad.sdk.core.b.b.a(new com.kwad.sdk.core.b.d() { // from class: com.kwad.sdk.j.i.1
                final /* synthetic */ Context jN;

                AnonymousClass1(Context context3) {
                    context = context3;
                }

                @Override // com.kwad.sdk.core.b.d, com.kwad.sdk.core.b.c
                public final void onActivityDestroyed(@NonNull Activity activity) {
                    if (activity == context) {
                        com.kwad.sdk.core.b.b.vS();
                        com.kwad.sdk.core.b.b.b(this);
                        i.onDestroy(context);
                    }
                }
            });
        }
    }

    private static boolean a(Context context, a aVar) {
        String str;
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, aVar.aaJ)) {
            if (aVar.aaJ != null) {
                aVar.clear();
                return false;
            }
            aVar.aaJ = stackTrace;
            int i2 = 0;
            int i3 = 0;
            while (i2 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                String className = stackTraceElement.getClassName();
                for (String str2 : getAutoUnWrapStackList()) {
                    if (!TextUtils.isEmpty(str2) && className.contains(str2)) {
                        str = "needAutoUnWrap true 命中白名单";
                    }
                }
                String methodName = stackTraceElement.getMethodName();
                i2++;
                if (i2 < stackTrace.length && CLAZZ_NAME.equals(className) && "wrapContextIfNeed".equals(methodName)) {
                    StackTraceElement stackTraceElement2 = stackTrace[i2];
                    if (TextUtils.equals(name, stackTraceElement2.getClassName()) && "getBaseContext".equals(stackTraceElement2.getMethodName()) && (i3 = i3 + 1) >= 5) {
                        return true;
                    }
                }
            }
            return false;
        }
        a.g(aVar);
        aVar.aaJ = stackTrace;
        if (aVar.aaK < 5) {
            return false;
        }
        str = "needAutoUnWrap true 连续相同堆栈";
        Log.d("Wrapper", str);
        return true;
    }

    public static void bO(boolean z) {
        aDO.set(z);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0, types: [android.content.Context] */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v3 */
    static Context de(Context context) {
        boolean z = context instanceof com.kwad.sdk.j.a;
        Context context2 = context;
        if (z) {
            context2 = ((com.kwad.sdk.j.a) context).getDelegatedContext();
        }
        if (k.m62do(context2)) {
            return context2;
        }
        RuntimeException runtimeException = null;
        int i2 = 0;
        Context context3 = context2;
        while (i2 < 10) {
            if (runtimeException == null) {
                RuntimeException runtimeException2 = new RuntimeException("expect normalContext --context:" + context3.getClass().getName() + "--initFinish:" + ((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).hasInitFinish());
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(runtimeException2);
                runtimeException = runtimeException2;
            }
            boolean dg = j.dg(context3);
            ?? r5 = context3;
            if (dg) {
                r5 = j.dh(context3);
            }
            boolean z2 = r5 instanceof com.kwad.sdk.j.a;
            Context context4 = r5;
            if (z2) {
                context4 = ((com.kwad.sdk.j.a) r5).getDelegatedContext();
            }
            if (k.m62do(context4)) {
                return context4;
            }
            i2++;
            context3 = context4;
        }
        return context3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5 */
    static Context df(Context context) {
        if (context instanceof Application) {
            return context;
        }
        Context applicationContext = de(context).getApplicationContext();
        if (applicationContext instanceof Application) {
            return applicationContext;
        }
        int i2 = 0;
        Context context2 = applicationContext;
        while (i2 < 10) {
            Context applicationContext2 = context2.getApplicationContext();
            if (applicationContext2 instanceof Application) {
                return applicationContext2;
            }
            if (applicationContext2 instanceof com.kwad.sdk.j.a) {
                applicationContext2 = ((com.kwad.sdk.j.a) applicationContext2).getDelegatedContext();
            }
            i2++;
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

    static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader classLoader2 = e.FK().getClassLoader();
        return classLoader2 != null ? classLoader2 : classLoader;
    }

    static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i2) {
        Resources resources = e.FK().getResources();
        if (resources == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i2, true);
        return newTheme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        if (aVar == null) {
            threadLocal.set(new a((byte) 0));
        } else if (aVar.aaH.get() != context || Math.abs(System.currentTimeMillis() - aVar.aaL) >= 150) {
            aVar.clear();
            aVar.aaH = new WeakReference(context);
            aVar.aaL = System.currentTimeMillis();
        } else {
            a.c(aVar);
            if (aVar.aaI >= (context instanceof Application ? 15 : 5) && a(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    static Context wrapContextIfNeed(Context context) {
        Context context2;
        if (context == null) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new RuntimeException("KSWrapper wrapContextIfNeed context is null"));
            return null;
        }
        if (!((com.kwad.sdk.service.kwai.e) ServiceProvider.get(com.kwad.sdk.service.kwai.e.class)).getIsExternal() || (context instanceof com.kwad.sdk.j.a)) {
            return context;
        }
        Context context3 = sResContextCache.get(context);
        if (context3 instanceof com.kwad.sdk.j.a) {
            return context3;
        }
        if (j.dg(context)) {
            context = j.unwrapContextIfNeed(context);
            if (j.dg(context)) {
                ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new RuntimeException("KSWrapper unwrapContextIfNeed fail"));
                return context;
            }
        }
        if (returnUnWrappedContext(context)) {
            ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).gatherException(new RuntimeException("KSWrapper returnUnWrappedContext context: " + context.getClass().getName()));
            return context;
        }
        if (context instanceof Application) {
            f fVar = new f((Application) context, new g(context, e.FK()));
            k.a(fVar);
            context2 = fVar;
        } else {
            context2 = context instanceof ContextThemeWrapper ? new b((ContextThemeWrapper) context) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new c((androidx.appcompat.view.ContextThemeWrapper) context) : context instanceof ContextWrapper ? new d(context) : new d(context);
        }
        a(context, context2);
        return context2;
    }
}
