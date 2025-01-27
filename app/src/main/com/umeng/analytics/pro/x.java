package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.k;
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
public class x {

    /* renamed from: c */
    private static final int f24172c = 5;

    /* renamed from: d */
    private static JSONArray f24173d = new JSONArray();

    /* renamed from: e */
    private static Object f24174e = new Object();

    /* renamed from: f */
    private final Map<String, Long> f24177f = new HashMap();

    /* renamed from: a */
    Stack<String> f24175a = new Stack<>();

    /* renamed from: b */
    com.umeng.analytics.vshelper.a f24176b = PageNameMonitor.getInstance();

    public int a() {
        return 2;
    }

    public void b(String str) {
        Long l10;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f24177f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f24175a.size() == 0) {
                UMLog.aq(l.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f24177f) {
            l10 = this.f24177f.get(str);
            this.f24177f.remove(str);
        }
        if (l10 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f24175a.size() > 0 && str.equals(this.f24175a.peek())) {
            this.f24175a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l10.longValue();
        synchronized (f24174e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(f.f23914v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(f.f23916x, l10);
                jSONObject.put("type", a());
                f24173d.put(jSONObject);
                if (f24173d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f24175a.size() == 0) {
            return;
        }
        UMLog.aq(l.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public static void a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f24174e) {
                    jSONArray = f24173d.toString();
                    f24173d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        k.a(context).a(w.a().c(), jSONObject, k.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f24175a.size() != 0) {
            String[] strArr = {this.f24175a.peek()};
            UMLog.aq(l.F, 0, "\\|", new String[]{"@"}, strArr, null, null);
        }
        this.f24176b.customPageBegin(str);
        synchronized (this.f24177f) {
            try {
                this.f24177f.put(str, Long.valueOf(System.currentTimeMillis()));
                if (UMConfigure.isDebugLog()) {
                    this.f24175a.push(str);
                }
            } finally {
            }
        }
    }

    public void b() {
        String str;
        synchronized (this.f24177f) {
            try {
                str = null;
                long j10 = 0;
                for (Map.Entry<String, Long> entry : this.f24177f.entrySet()) {
                    if (entry.getValue().longValue() > j10) {
                        long longValue = entry.getValue().longValue();
                        str = entry.getKey();
                        j10 = longValue;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        if (str != null) {
            b(str);
        }
    }
}
