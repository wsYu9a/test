package com.kwad.library.b.c;

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
import com.kwad.sdk.utils.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* loaded from: classes3.dex */
public class a {
    private static final String CLAZZ_NAME = "com.kwad.library.b.c.a";
    private static final ThreadLocal<C0473a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new ArrayList();
    private static final Map<String, WeakReference<Context>> sResContextCache = new HashMap();

    /* renamed from: com.kwad.library.b.c.a$a */
    public static class C0473a {
        private WeakReference<Context> alR;
        private int alS;
        private StackTraceElement[] alT;
        private int alU;
        private long alV;

        private C0473a() {
            this.alR = new WeakReference<>(null);
            this.alS = 0;
            this.alT = null;
            this.alU = 0;
        }

        public static /* synthetic */ int c(C0473a c0473a) {
            int i10 = c0473a.alS;
            c0473a.alS = i10 + 1;
            return i10;
        }

        public void clear() {
            this.alR = new WeakReference<>(null);
            this.alS = 0;
            this.alT = null;
            this.alU = 0;
            this.alV = 0L;
        }

        public static /* synthetic */ int g(C0473a c0473a) {
            int i10 = c0473a.alU;
            c0473a.alU = i10 + 1;
            return i10;
        }

        public /* synthetic */ C0473a(byte b10) {
            this();
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

    /* JADX WARN: Multi-variable type inference failed */
    private static Context aF(Context context) {
        return ((b) context).getDelegatedContext();
    }

    private static boolean aG(Context context) {
        return context instanceof b;
    }

    private static boolean b(String str, Context context) {
        ThreadLocal<C0473a> threadLocal = sAutoUnWrapModelTL;
        C0473a c0473a = threadLocal.get();
        if (c0473a == null) {
            threadLocal.set(new C0473a((byte) 0));
        } else if (c0473a.alR.get() != context || Math.abs(System.currentTimeMillis() - c0473a.alV) >= 150) {
            c0473a.clear();
            c0473a.alR = new WeakReference(context);
            c0473a.alV = System.currentTimeMillis();
        } else {
            C0473a.c(c0473a);
            if (c0473a.alS >= (context instanceof Application ? 15 : 5) && a(str, context, c0473a)) {
                c0473a.clear();
                return true;
            }
        }
        return false;
    }

    private static com.kwad.library.b.a bH(String str) {
        return com.kwad.library.solder.a.a.j(null, str);
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object a10 = w.a((Object) context, "android.view.ContextThemeWrapper", "getThemeResId");
        if (a10 != null) {
            return ((Integer) a10).intValue();
        }
        return 0;
    }

    @NonNull
    public static Context i(Context context, String str) {
        if (context == null) {
            return null;
        }
        com.kwad.library.b.a bH = bH(str);
        if (bH == null || !bH.isLoaded() || (context instanceof b) || b(str, context)) {
            return context;
        }
        Context a10 = a(str, context);
        if (a10 != null) {
            return a10;
        }
        Context cVar = context instanceof ContextThemeWrapper ? new c((ContextThemeWrapper) context, str) : context instanceof androidx.appcompat.view.ContextThemeWrapper ? new d((androidx.appcompat.view.ContextThemeWrapper) context, str) : context instanceof ContextWrapper ? new e(context, str) : new e(context, str);
        a(str, context, cVar);
        return cVar;
    }

    public static Context unwrapContextIfNeed(Context context) {
        if (aG(context)) {
            context = aF(context);
        }
        if (!aG(context)) {
            return context;
        }
        for (int i10 = 0; i10 < 10; i10++) {
            context = aF(context);
            if (!aG(context)) {
                return context;
            }
        }
        return context;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof b ? layoutInflater : layoutInflater.cloneInContext(context);
    }

    private static void a(String str, Context context, Context context2) {
        sResContextCache.put(str + System.identityHashCode(context), new WeakReference<>(context2));
    }

    private static boolean a(String str, Context context, C0473a c0473a) {
        Context a10 = a(str, context);
        String name = a10 != null ? a10.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (!Arrays.equals(stackTrace, c0473a.alT)) {
            if (c0473a.alT != null) {
                c0473a.clear();
                return false;
            }
            c0473a.alT = stackTrace;
            int i10 = 0;
            int i11 = 0;
            while (i10 < stackTrace.length) {
                StackTraceElement stackTraceElement = stackTrace[i10];
                String className = stackTraceElement.getClassName();
                Iterator<String> it = getAutoUnWrapStackList().iterator();
                while (it.hasNext()) {
                    if (className.contains(it.next())) {
                        Log.d("PluginWrapper", "needAutoUnWrap true 命中白名单");
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
        C0473a.g(c0473a);
        c0473a.alT = stackTrace;
        if (c0473a.alU < 5) {
            return false;
        }
        Log.d("PluginWrapper", "needAutoUnWrap true 连续相同堆栈");
        return true;
    }

    public static LayoutInflater a(LayoutInflater layoutInflater, String str) {
        com.kwad.library.b.a bH = bH(str);
        if (bH == null || !bH.isLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof b) {
            return layoutInflater;
        }
        Context i10 = i(context, str);
        return i10 instanceof b ? layoutInflater.cloneInContext(i10) : layoutInflater;
    }

    public static Resources a(Resources resources, String str) {
        com.kwad.library.b.a bH = bH(str);
        if (bH != null && bH.isLoaded()) {
            Resources resources2 = bH.getResources();
            Objects.toString(resources2);
            return resources2 != null ? resources2 : resources;
        }
        Objects.toString(bH);
        return resources;
    }

    public static Resources.Theme a(Resources.Theme theme, Resources.Theme theme2, int i10, String str) {
        Resources resources;
        com.kwad.library.b.a bH = bH(str);
        if (bH == null || !bH.isLoaded() || (resources = bH.getResources()) == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = resources.newTheme();
        newTheme.applyStyle(i10, true);
        return newTheme;
    }

    public static ClassLoader a(ClassLoader classLoader, String str) {
        com.kwad.library.b.a.b yc2;
        com.kwad.library.b.a bH = bH(str);
        return (bH == null || !bH.isLoaded() || (yc2 = bH.yc()) == null) ? classLoader : yc2;
    }
}
