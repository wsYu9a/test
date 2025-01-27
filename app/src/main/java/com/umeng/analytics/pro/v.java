package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class v {

    /* renamed from: c */
    private static final int f26020c = 5;

    /* renamed from: d */
    private static JSONArray f26021d = new JSONArray();

    /* renamed from: e */
    private static Object f26022e = new Object();

    /* renamed from: f */
    private final Map<String, Long> f26025f = new HashMap();

    /* renamed from: a */
    Stack<String> f26023a = new Stack<>();

    /* renamed from: b */
    com.umeng.analytics.vshelper.a f26024b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f26022e) {
                    jSONArray = f26021d.toString();
                    f26021d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f26025f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f26023a.size() == 0) {
                UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f26025f) {
            l = this.f26025f.get(str);
            this.f26025f.remove(str);
        }
        if (l == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f26023a.size() > 0 && str.equals(this.f26023a.peek())) {
            this.f26023a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l.longValue();
        synchronized (f26022e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(d.x, l);
                jSONObject.put("type", a());
                f26021d.put(jSONObject);
                if (f26021d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f26023a.size() == 0) {
            return;
        }
        UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f26023a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.f26023a.peek()}, null, null);
        }
        this.f26024b.customPageBegin(str);
        synchronized (this.f26025f) {
            this.f26025f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f26023a.push(str);
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f26025f) {
            str = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f26025f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j2 = longValue;
                }
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
