package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@Keep
/* loaded from: classes3.dex */
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

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
        Object obj = ApiReflect.g(context).cl("getThemeResId").get();
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (Arrays.equals(stackTrace, aVar.alT)) {
            a.g(aVar);
            aVar.alT = stackTrace;
            if (aVar.alU < 5) {
                return false;
            }
            Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
            return true;
        }
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
                    Log.d(TAG, "needAutoUnWrap true 命中白名单");
                    return true;
                }
            }
            String methodName = stackTraceElement.getMethodName();
            i10++;
            if (i10 < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i10];
                if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i11 = i11 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i10) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.f("WRT", theme, theme2, Integer.valueOf(i10));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme newTheme = externalResource.newTheme();
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
            if (aVar.alS >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.f("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        Context context3 = context;
        while (context3 instanceof ContextWrapper) {
            if (context3 instanceof Activity) {
                return context3;
            }
            if (context3 instanceof ResContext) {
                resContext = context3;
                context3 = resContext.getDelegatedContext();
            } else {
                context3 = ((ContextWrapper) context3).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.f("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            Context context3 = sResContextCache.get(context);
            if (context3 != null) {
                return context3;
            }
            p pVar = new p((ContextThemeWrapper) context);
            sResContextCache.put(context, pVar);
            return pVar;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            Context context4 = sResContextCache.get(context);
            if (context4 != null) {
                return context4;
            }
            q qVar = new q((androidx.appcompat.view.ContextThemeWrapper) context);
            sResContextCache.put(context, qVar);
            return qVar;
        }
        if (context instanceof ContextWrapper) {
            Context context5 = sResContextCache.get(context);
            if (context5 != null) {
                return context5;
            }
            r rVar = new r(context);
            sResContextCache.put(context, rVar);
            return rVar;
        }
        Context context6 = sResContextCache.get(context);
        if (context6 != null) {
            return context6;
        }
        r rVar2 = new r(context);
        sResContextCache.put(context, rVar2);
        return rVar2;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.f("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof ResContext) {
            return layoutInflater;
        }
        Context wrapContextIfNeed = wrapContextIfNeed(context);
        return wrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(wrapContextIfNeed) : layoutInflater;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
    }
}
