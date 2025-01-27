package com.kwai.sodler.lib.kwai.b;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwai.sodler.lib.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwai.sodler.lib.kwai.b.a";
    private static final ThreadLocal<C0252a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwai.sodler.lib.kwai.b.a$a */
    static class C0252a {
        private WeakReference<Context> aaH;
        private int aaI;
        private StackTraceElement[] aaJ;
        private int aaK;
        private long aaL;

        private C0252a() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
        }

        /* synthetic */ C0252a(byte b2) {
            this();
        }

        static /* synthetic */ int c(C0252a c0252a) {
            int i2 = c0252a.aaI;
            c0252a.aaI = i2 + 1;
            return i2;
        }

        public void clear() {
            this.aaH = new WeakReference<>(null);
            this.aaI = 0;
            this.aaJ = null;
            this.aaK = 0;
            this.aaL = 0L;
        }

        static /* synthetic */ int g(C0252a c0252a) {
            int i2 = c0252a.aaK;
            c0252a.aaK = i2 + 1;
            return i2;
        }
    }

    @Nullable
    private static Context a(String str, Context context) {
        WeakReference<Context> weakReference = sResContextCache.get(str + System.identityHashCode(context));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i2, String str) {
        Resources resources;
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO == null || !fO.isLoaded() || (resources = fO.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i2, true);
        return newTheme;
    }

    static Resources a(Resources resources, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO == null || !fO.isLoaded()) {
            StringBuilder sb = new StringBuilder("replaceExternalResources pluginId: ");
            sb.append(str);
            sb.append(" , plugin: ");
            sb.append(fO);
            sb.append(", isLoaded(): false");
            return resources;
        }
        Resources resources2 = fO.getResources();
        StringBuilder sb2 = new StringBuilder("replaceExternalResources pluginId: ");
        sb2.append(str);
        sb2.append(", wrappedResources: ");
        sb2.append(resources2);
        return resources2 != null ? resources2 : resources;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO == null || !fO.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context at = at(context, str);
        return at instanceof b ? layoutInflater.cloneInContext(at) : layoutInflater;
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0252a c0252a) {
        String str2;
        Context a2 = a(str, context);
        String name = a2 != null ? a2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0252a.aaJ)) {
            if (c0252a.aaJ != null) {
                c0252a.clear();
                return false;
            }
            c0252a.aaJ = stackTrace;
            int i2 = 0;
            int i3 = 0;
            while (i2 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i2];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        str2 = "needAutoUnWrap true 命中白名单";
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
        C0252a.g(c0252a);
        c0252a.aaJ = stackTrace;
        if (c0252a.aaK < 5) {
            return false;
        }
        str2 = "needAutoUnWrap true 连续相同堆栈";
        Log.d("Solder.PluginWrapper", str2);
        return true;
    }

    @NonNull
    public static Context at(Context context, String str) {
        if (context == null) {
            return null;
        }
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        if (fO == null || !fO.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context a2 = a(str, context);
        if (a2 != null) {
            return a2;
        }
        Context cVar = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context, str) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context, str) : context instanceof ContextWrapper ? new e(context, str) : new e(context, str);
        a(str, context, cVar);
        return cVar;
    }

    static ClassLoader b(ClassLoader classLoader, String str) {
        com.kwai.sodler.lib.kwai.kwai.b Jv;
        com.kwai.sodler.lib.kwai.a fO = fO(str);
        return (fO == null || !fO.isLoaded() || (Jv = fO.Jv()) == null) ? classLoader : Jv;
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0252a> threadLocal = sAutoUnWrapModelTL;
        C0252a c0252a = threadLocal.get();
        if (c0252a == null) {
            threadLocal.set(new C0252a((byte) 0));
        } else if (c0252a.aaH.get() != context || Math.abs(System.currentTimeMillis() - c0252a.aaL) >= 150) {
            c0252a.clear();
            c0252a.aaH = new WeakReference(context);
            c0252a.aaL = System.currentTimeMillis();
        } else {
            C0252a.c(c0252a);
            if (c0252a.aaI >= (context instanceof Application ? 15 : 5) && a(str, context, c0252a)) {
                c0252a.clear();
                return true;
            }
        }
        return false;
    }

    private static boolean dg(Context context) {
        return context instanceof b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static Context dh(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static com.kwai.sodler.lib.kwai.a fO(String str) {
        com.kwai.sodler.lib.a.a fM = i.Jl().Jo().fM(str);
        if (fM != null && fM.isLoaded() && (fM instanceof com.kwai.sodler.lib.kwai.a)) {
            return (com.kwai.sodler.lib.kwai.a) fM;
        }
        return null;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (dg(context)) {
            context = dh(context);
        }
        if (!dg(context)) {
            return context;
        }
        for (int i2 = 0; i2 < 10; i2++) {
            context = dh(context);
            if (!dg(context)) {
                return context;
            }
        }
        return context;
    }

    static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }
}
