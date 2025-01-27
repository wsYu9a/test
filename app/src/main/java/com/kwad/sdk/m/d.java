package com.kwad.sdk.m;

import android.text.TextUtils;
import android.util.Log;
import com.kwad.sdk.utils.w;
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

/* loaded from: classes3.dex */
public final class d {

    /* renamed from: com.kwad.sdk.m.d$1 */
    public class AnonymousClass1 implements InvocationHandler {
        final /* synthetic */ String aRI;
        final /* synthetic */ a aRJ;
        final /* synthetic */ PluginListener aRK;

        public AnonymousClass1(String str, a aVar, PluginListener pluginListener) {
            str2 = str;
            aVar = aVar;
            pluginListener = pluginListener;
        }

        @Override // java.lang.reflect.InvocationHandler
        public final Object invoke(Object obj, Method method, Object[] objArr) {
            if (method != null) {
                try {
                    com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                } catch (Throwable th2) {
                    a aVar = aVar;
                    if (aVar != null) {
                        aVar.onError(Log.getStackTraceString(th2));
                    }
                    return null;
                }
            }
            if (method.getName().contains(str2)) {
                Issue issue = (Issue) objArr[0];
                com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                try {
                    JSONObject content = issue.getContent();
                    String p10 = d.p(content);
                    long q10 = d.q(content);
                    long r10 = d.r(content);
                    String s10 = d.s(content);
                    String t10 = d.t(content);
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(p10, r10, q10, s10, t10);
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
                } catch (Throwable th3) {
                    com.kwad.sdk.core.d.c.e("perfMonitor.RangerInjector", Log.getStackTraceString(th3));
                }
            }
            return null;
        }
    }

    public interface a {
        void a(String str, long j10, long j11, String str2, String str3);

        void onError(String str);
    }

    public static void a(String str, String str2, a aVar) {
        try {
            TracePlugin pluginByClass = Matrix.with().getPluginByClass(TracePlugin.class);
            if (pluginByClass == null) {
                aVar.onError("getPluginByClass is null");
                return;
            }
            PluginListener pluginListener = (PluginListener) w.getField(pluginByClass, "pluginListener");
            if (pluginListener != null) {
                try {
                    w.a(pluginByClass, "pluginListener", Proxy.newProxyInstance(pluginByClass.getClass().getClassLoader(), new Class[]{Class.forName(str)}, new InvocationHandler() { // from class: com.kwad.sdk.m.d.1
                        final /* synthetic */ String aRI;
                        final /* synthetic */ a aRJ;
                        final /* synthetic */ PluginListener aRK;

                        public AnonymousClass1(String str22, a aVar2, PluginListener pluginListener2) {
                            str2 = str22;
                            aVar = aVar2;
                            pluginListener = pluginListener2;
                        }

                        @Override // java.lang.reflect.InvocationHandler
                        public final Object invoke(Object obj, Method method, Object[] objArr) {
                            if (method != null) {
                                try {
                                    com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + method.getName());
                                } catch (Throwable th2) {
                                    a aVar2 = aVar;
                                    if (aVar2 != null) {
                                        aVar2.onError(Log.getStackTraceString(th2));
                                    }
                                    return null;
                                }
                            }
                            if (method.getName().contains(str2)) {
                                Issue issue = (Issue) objArr[0];
                                com.kwad.sdk.core.d.c.i("perfMonitor.RangerInjector", "originPluginListener callback:" + issue.toString());
                                try {
                                    JSONObject content = issue.getContent();
                                    String p10 = d.p(content);
                                    long q10 = d.q(content);
                                    long r10 = d.r(content);
                                    String s10 = d.s(content);
                                    String t10 = d.t(content);
                                    a aVar22 = aVar;
                                    if (aVar22 != null) {
                                        aVar22.a(p10, r10, q10, s10, t10);
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
                                } catch (Throwable th3) {
                                    com.kwad.sdk.core.d.c.e("perfMonitor.RangerInjector", Log.getStackTraceString(th3));
                                }
                            }
                            return null;
                        }
                    }));
                } catch (Exception e10) {
                    aVar2.onError(Log.getStackTraceString(e10));
                }
            }
        } catch (Exception e11) {
            aVar2.onError(Log.getStackTraceString(e11));
        }
    }

    public static String p(JSONObject jSONObject) {
        try {
            return jSONObject.optString("threadStack");
        } catch (Exception unused) {
            return "";
        }
    }

    public static long q(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("cost");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static long r(JSONObject jSONObject) {
        try {
            return jSONObject.optLong("time");
        } catch (Exception unused) {
            return 0L;
        }
    }

    public static String s(JSONObject jSONObject) {
        try {
            return jSONObject.optString(com.umeng.ccg.a.f24233j);
        } catch (Exception unused) {
            return "";
        }
    }

    public static String t(JSONObject jSONObject) {
        try {
            return jSONObject.optString(UMModuleRegister.PROCESS);
        } catch (Exception unused) {
            return "";
        }
    }
}
