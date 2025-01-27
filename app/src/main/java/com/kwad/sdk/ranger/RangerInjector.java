package com.kwad.sdk.ranger;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.common.utility.Logger;
import com.kwad.sdk.utils.s;
import com.tencent.matrix.Matrix;
import com.tencent.matrix.plugin.Plugin;
import com.tencent.matrix.plugin.PluginListener;
import com.tencent.matrix.report.Issue;
import com.tencent.matrix.trace.TracePlugin;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class RangerInjector {

    /* renamed from: com.kwad.sdk.ranger.RangerInjector$1 */
    static class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ String ayg;
        final /* synthetic */ b ayh;
        final /* synthetic */ PluginListener ayi;

        AnonymousClass1(String str, b bVar, PluginListener pluginListener) {
            str2 = str;
            bVar = bVar;
            pluginListener = pluginListener;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (method != null) {
                try {
                    com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                } catch (Throwable th) {
                    b bVar = bVar;
                    if (bVar != null) {
                        bVar.onError(Log.getStackTraceString(th));
                    }
                    return null;
                }
            }
            if (method.getName().contains(str2)) {
                Issue issue = (Issue) objArr[0];
                com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                try {
                    JSONObject content = issue.getContent();
                    String E = RangerInjector.E(content);
                    long F = RangerInjector.F(content);
                    long G = RangerInjector.G(content);
                    String H = RangerInjector.H(content);
                    String I = RangerInjector.I(content);
                    b bVar2 = bVar;
                    if (bVar2 != null) {
                        bVar2.a(E, G, F, H, I);
                    }
                } catch (Throwable unused) {
                }
                pluginListener.onReportIssue(issue);
            } else if (TextUtils.equals(method.getName(), "onInit")) {
                pluginListener.onInit((Plugin) objArr[0]);
            } else if (TextUtils.equals(method.getName(), "onStart")) {
                pluginListener.onStart((Plugin) objArr[0]);
            } else if (TextUtils.equals(method.getName(), "onStop")) {
                pluginListener.onStop((Plugin) objArr[0]);
            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                pluginListener.onDestroy((Plugin) objArr[0]);
            } else {
                try {
                    method.invoke(pluginListener, objArr);
                } catch (Throwable th2) {
                    com.kwad.sdk.core.d.b.e("perfMonitor.RangerInjector", Log.getStackTraceString(th2));
                }
            }
            return null;
        }
    }

    /* renamed from: com.kwad.sdk.ranger.RangerInjector$2 */
    static class AnonymousClass2 extends Logger.ILogWritter {
        final /* synthetic */ int ayj;
        final /* synthetic */ Logger.ILogWritter ayk;
        final /* synthetic */ String ayl;
        final /* synthetic */ a aym;

        AnonymousClass2(int i2, Logger.ILogWritter iLogWritter, String str, a aVar) {
            intValue = i2;
            iLogWritter = iLogWritter;
            str4 = str;
            aVar = aVar;
        }

        @Keep
        public final boolean isLoggable(int i2) {
            return true;
        }

        @Keep
        public final void logD(String str, String str2) {
            try {
                if (intValue > 3) {
                    return;
                }
                iLogWritter.logD(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logD(String str, String str2, Throwable th) {
            try {
                if (intValue > 3) {
                    return;
                }
                iLogWritter.logD(str, str2, th);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logE(String str, String str2) {
            try {
                if (intValue > 6) {
                    return;
                }
                iLogWritter.logE(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logE(String str, String str2, Throwable th) {
            a aVar;
            try {
                if (TextUtils.equals(str, str4) && (aVar = aVar) != null) {
                    aVar.dI(Log.getStackTraceString(th));
                }
                if (intValue > 6) {
                    return;
                }
                iLogWritter.logE(str, str2, th);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logI(String str, String str2) {
            try {
                if (intValue > 4) {
                    return;
                }
                iLogWritter.logI(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logI(String str, String str2, Throwable th) {
            try {
                if (intValue > 4) {
                    return;
                }
                iLogWritter.logI(str, str2, th);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logK(String str, String str2) {
            try {
                iLogWritter.logK(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logV(String str, String str2) {
            try {
                if (intValue > 2) {
                    return;
                }
                iLogWritter.logV(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logV(String str, String str2, Throwable th) {
            try {
                if (intValue > 2) {
                    return;
                }
                iLogWritter.logV(str, str2, th);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logW(String str, String str2) {
            try {
                if (intValue > 5) {
                    return;
                }
                iLogWritter.logW(str, str2);
            } catch (Throwable unused) {
            }
        }

        @Keep
        public final void logW(String str, String str2, Throwable th) {
            try {
                if (intValue > 5) {
                    return;
                }
                iLogWritter.logW(str, str2, th);
            } catch (Throwable unused) {
            }
        }
    }

    public interface a {
        void dI(String str);
    }

    public interface b {
        void a(String str, long j2, long j3, String str2, String str3);

        void onError(String str);
    }

    public static String E(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    public static long F(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long G(JSONObject jSONObject) {
        try {
            return jSONObject.optLong(com.alipay.mobilesecuritysdk.deviceID.c.y);
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String H(JSONObject jSONObject) {
        try {
            return jSONObject.optString("scene");
        } catch (Exception unused) {
            return "";
        }
    }

    public static String I(JSONObject jSONObject) {
        try {
            return jSONObject.optString(UMModuleRegister.PROCESS);
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(String str, String str2, b bVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                bVar.onError("getPluginByClass is null");
                return;
            }
            PluginListener pluginListener = (PluginListener) s.d(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    s.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.ranger.RangerInjector.1
                        final /* synthetic */ String ayg;
                        final /* synthetic */ b ayh;
                        final /* synthetic */ PluginListener ayi;

                        AnonymousClass1(String str22, b bVar2, PluginListener pluginListener2) {
                            str2 = str22;
                            bVar = bVar2;
                            pluginListener = pluginListener2;
                        }

                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th) {
                                    b bVar2 = bVar;
                                    if (bVar2 != null) {
                                        bVar2.onError(Log.getStackTraceString(th));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.d.b.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String E = RangerInjector.E(content);
                                    long F = RangerInjector.F(content);
                                    long G = RangerInjector.G(content);
                                    String H = RangerInjector.H(content);
                                    String I = RangerInjector.I(content);
                                    b bVar22 = bVar;
                                    if (bVar22 != null) {
                                        bVar22.a(E, G, F, H, I);
                                    }
                                } catch (Throwable unused) {
                                }
                                pluginListener.onReportIssue(issue);
                            } else if (TextUtils.equals(method.getName(), "onInit")) {
                                pluginListener.onInit((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStart")) {
                                pluginListener.onStart((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onStop")) {
                                pluginListener.onStop((Plugin) objArr[0]);
                            } else if (TextUtils.equals(method.getName(), "onDestroy")) {
                                pluginListener.onDestroy((Plugin) objArr[0]);
                            } else {
                                try {
                                    method.invoke(pluginListener, objArr);
                                } catch (Throwable th2) {
                                    com.kwad.sdk.core.d.b.e("perfMonitor.RangerInjector", Log.getStackTraceString(th2));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (Exception e2) {
                    bVar2.onError(Log.getStackTraceString(e2));
                }
            }
        } catch (Exception e3) {
            bVar2.onError(Log.getStackTraceString(e3));
        }
    }

    @Keep
    public static void tryProxyOtherOutput(String str, String str2, String str3, String str4, a aVar) {
        try {
            Logger.ILogWritter iLogWritter = (Logger.ILogWritter) s.aa(str, str2);
            if (iLogWritter == null) {
                return;
            }
            Integer num = (Integer) s.aa(str, str3);
            s.a(Class.forName(str), str2, (Object) new Logger.ILogWritter() { // from class: com.kwad.sdk.ranger.RangerInjector.2
                final /* synthetic */ int ayj;
                final /* synthetic */ Logger.ILogWritter ayk;
                final /* synthetic */ String ayl;
                final /* synthetic */ a aym;

                AnonymousClass2(int i2, Logger.ILogWritter iLogWritter2, String str42, a aVar2) {
                    intValue = i2;
                    iLogWritter = iLogWritter2;
                    str4 = str42;
                    aVar = aVar2;
                }

                @Keep
                public final boolean isLoggable(int i2) {
                    return true;
                }

                @Keep
                public final void logD(String str5, String str22) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logD(String str5, String str22, Throwable th) {
                    try {
                        if (intValue > 3) {
                            return;
                        }
                        iLogWritter.logD(str5, str22, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str22) {
                    try {
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logE(String str5, String str22, Throwable th) {
                    a aVar2;
                    try {
                        if (TextUtils.equals(str5, str4) && (aVar2 = aVar) != null) {
                            aVar2.dI(Log.getStackTraceString(th));
                        }
                        if (intValue > 6) {
                            return;
                        }
                        iLogWritter.logE(str5, str22, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str22) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logI(String str5, String str22, Throwable th) {
                    try {
                        if (intValue > 4) {
                            return;
                        }
                        iLogWritter.logI(str5, str22, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logK(String str5, String str22) {
                    try {
                        iLogWritter.logK(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str22) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logV(String str5, String str22, Throwable th) {
                    try {
                        if (intValue > 2) {
                            return;
                        }
                        iLogWritter.logV(str5, str22, th);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str22) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str22);
                    } catch (Throwable unused) {
                    }
                }

                @Keep
                public final void logW(String str5, String str22, Throwable th) {
                    try {
                        if (intValue > 5) {
                            return;
                        }
                        iLogWritter.logW(str5, str22, th);
                    } catch (Throwable unused) {
                    }
                }
            });
        } catch (Throwable th) {
            com.kwad.sdk.core.d.b.w("perfMonitor.RangerInjector", Log.getStackTraceString(th));
        }
    }
}
