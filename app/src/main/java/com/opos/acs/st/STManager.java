package com.opos.acs.st;

import android.content.Context;
import android.text.TextUtils;
import com.opos.acs.st.InitParams;
import com.opos.acs.st.utils.b;
import com.opos.acs.st.utils.c;
import com.opos.acs.st.utils.d;
import com.opos.acs.st.utils.e;
import com.opos.acs.st.utils.g;
import com.opos.acs.st.utils.h;
import com.opos.cmn.nt.crypt.EncryptUtils;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public final class STManager {
    public static final String KEY_AD_ID = "adId";
    public static final String KEY_AD_POS_ID = "adposId";
    public static final String KEY_APP_ID = "appId";
    public static final String KEY_CATEGORY_ID = "categoryId";
    public static final String KEY_CHANNEL = "channel";
    public static final String KEY_CHANNEL_ID = "channelId";
    public static final String KEY_DATA_TYPE = "dataType";
    public static final String KEY_DOWN_X = "downX";
    public static final String KEY_DOWN_Y = "downY";
    public static final String KEY_ENTER_ID = "enterId";
    public static final String KEY_EVT_TRACE_ID = "evtTraceId";
    public static final String KEY_EXPOSE_DURATION = "exposeDur";
    public static final String KEY_EXT_CHANNEL = "extChannel";
    public static final String KEY_INSTALL_PKG_NAME = "installPkgName";
    public static final String KEY_LATITUDE = "latitude";
    public static final String KEY_LONGITUDE = "longitude";
    public static final String KEY_MODULE_ID = "moduleId";
    public static final String KEY_PAR_MODULE_ID = "parModuleId";
    public static final String KEY_PAR_POS_ID = "parPosId";
    public static final String KEY_PAR_TAB_ID = "parTabId";
    public static final String KEY_SCAN_PKG_NAME = "scanPkgName";
    public static final String KEY_SDK_VERSION = "sdkVersion";
    public static final String KEY_SSO_ID = "ssoid";
    public static final String KEY_TAB_ID = "tabId";
    public static final String KEY_TRACE_ID = "traceId";
    public static final String KEY_UP_X = "upX";
    public static final String KEY_UP_Y = "upY";
    public static final int NO_NEED_UPLOAD = 3;
    public static final int PARAM_ERROR = 4;
    public static final String REGION_OF_CN = "CN";
    public static final String REGION_OF_ID = "ID";
    public static final String REGION_OF_IN = "IN";
    public static final String REGION_OF_MY = "MY";
    public static final String REGION_OF_PH = "PH";
    public static final String REGION_OF_TH = "TH";
    public static final String REGION_OF_TW = "TW";
    public static final String REGION_OF_VN = "VN";
    public static final int REPORT_FINISH = 7;
    public static final int REPORT_NO_STCONFIG = 6;
    private static final long REPORT_TIME_OUT = 1000;
    public static final int SAVED_ON_DB = 5;
    private static final String TAG = "STManager";
    public static final int UPLOAD_FAILURE = 2;
    public static final int UPLOAD_OK = 1;
    private static volatile STManager sInstance;
    private Context mContext = null;
    private static final byte[] LOCK = new byte[0];
    public static final String BRAND_OF_O = b.f16301a;
    public static final String BRAND_OF_P = b.f16302b;
    public static final String BRAND_OF_R = b.f16303c;

    /* renamed from: com.opos.acs.st.STManager$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b("lshxjtu", "init startReportTimer now!!!");
            h.g(STManager.this.mContext);
            e.a(STManager.this.mContext).a();
        }
    }

    /* renamed from: com.opos.acs.st.STManager$2 */
    final class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16266a;

        /* renamed from: b */
        private /* synthetic */ Map f16267b;

        /* renamed from: c */
        private /* synthetic */ EventListener f16268c;

        AnonymousClass2(Context context, Map map, EventListener eventListener) {
            context2 = context;
            map = map;
            eventListener = eventListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            h.a(context2, (Map<String, String>) map, eventListener);
            d.a(STManager.TAG, "record data Context is :" + context2);
        }
    }

    /* renamed from: com.opos.acs.st.STManager$3 */
    final class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16270a;

        /* renamed from: b */
        private /* synthetic */ ExitListener f16271b;

        AnonymousClass3(Context context, ExitListener exitListener) {
            context2 = context;
            exitListener = exitListener;
        }

        @Override // java.lang.Runnable
        public final void run() {
            try {
                STManager.this.reportDataOnExit(context2);
            } finally {
                h.a();
                exitListener.onFinish(true);
            }
        }
    }

    /* renamed from: com.opos.acs.st.STManager$4 */
    final class AnonymousClass4 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16273a;

        AnonymousClass4(Context context) {
            context2 = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            d.b("lshxjtu", "resume startReportTimer now!!!");
            h.c(context2);
        }
    }

    /* renamed from: com.opos.acs.st.STManager$5 */
    final class AnonymousClass5 implements Runnable {

        /* renamed from: a */
        private /* synthetic */ Context f16275a;

        AnonymousClass5(Context context) {
            context2 = context;
        }

        @Override // java.lang.Runnable
        public final void run() {
            STManager.this.reportDataOnExit(context2);
            h.a();
        }
    }

    public interface EventListener {
        void onEventReturn(int i2);
    }

    public interface ExitListener {
        void onFinish(boolean z);
    }

    private void checkInit(Context context) throws Exception {
        if (h.f(context)) {
            throw new Exception("Please init st sdk at first!");
        }
    }

    private Context getContext(Context context) {
        Context context2 = this.mContext;
        if (context2 != null) {
            return context2;
        }
        if (context != null) {
            return context.getApplicationContext();
        }
        return null;
    }

    public static STManager getInstance() {
        if (sInstance == null) {
            synchronized (LOCK) {
                if (sInstance == null) {
                    sInstance = new STManager();
                }
            }
        }
        return sInstance;
    }

    public static String getSdkVersion() {
        return "3.3.0";
    }

    public static boolean isReleaseServer() {
        return com.opos.acs.st.utils.a.f16300a;
    }

    public static Map<String, String> jsonObject2Map(JSONObject jSONObject) {
        if (jSONObject != null) {
            return com.opos.acs.st.b.a.a(jSONObject);
        }
        return null;
    }

    public static Map<String, String> jsonString2Map(String str) {
        if (h.a(str)) {
            return null;
        }
        return com.opos.acs.st.b.a.a(str.trim());
    }

    public static void setLogBuriedPointSwitch(boolean z) {
        com.opos.cmn.an.f.a.a(z);
    }

    public static void setTouristModeSwitch(Context context, boolean z) {
        com.opos.cmn.an.f.a.a(context, z);
    }

    public final void enableDebugLog() {
        if (d.f16307a) {
            return;
        }
        d.f16307a = true;
        d.a();
    }

    public final int getSdkVerCode() {
        return 330;
    }

    public final void init(Context context, String str, String str2) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().build());
    }

    public final void init(Context context, String str, String str2, InitParams initParams) throws NullPointerException {
        if (!c.b()) {
            c.a();
            if (initParams == null || context == null) {
                throw new NullPointerException("initParams or context is null.");
            }
            this.mContext = context.getApplicationContext();
            if (initParams.getIsLoganInit()) {
                d.a(this.mContext);
            }
            d.a(TAG, "init start.");
            if (!EncryptUtils.isSoEnabled()) {
                d.b(TAG, "Init failed,miss so lib！");
                if (h.e(context)) {
                    throw new IllegalStateException("Init failed,miss so lib!");
                }
            }
            c.a(initParams.getIsTablet());
            c.b(this.mContext, str);
            c.a(this.mContext, str2);
            c.c(this.mContext);
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.1
                AnonymousClass1() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.b("lshxjtu", "init startReportTimer now!!!");
                    h.g(STManager.this.mContext);
                    e.a(STManager.this.mContext).a();
                }
            });
        }
        if (!com.opos.cmn.an.h.c.a.d(this.mContext)) {
            d.a(TAG, "no net!");
        } else if (TextUtils.isEmpty(initParams.getPkgName())) {
            g.a(this.mContext);
        } else {
            g.a(this.mContext, initParams.getPkgName());
        }
    }

    public final void init(Context context, String str, String str2, String str3) throws NullPointerException {
        init(context, str, str2, new InitParams.Builder().setPkgName(str3).build());
    }

    public final String onEvent(Context context, String str, Map<String, String> map) throws Exception {
        return onEvent(context, str, map, (EventListener) null);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener) throws Exception {
        checkInit(context);
        if (h.a(str) || map == null) {
            d.a(TAG, "jsonString is null or eventMap is null.");
        } else {
            d.a(TAG, str);
            Map<String, String> a2 = com.opos.acs.st.b.a.a(str.trim());
            if (a2 != null) {
                try {
                    map.putAll(a2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d(TAG, "onEvent", e2);
                }
            }
        }
        return onEvent(context, map, eventListener);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, EventListener eventListener, String str2, String str3) throws Exception {
        checkInit(context);
        if (h.a(str) || map == null) {
            d.a(TAG, "jsonString is null or eventMap is null.");
        } else {
            d.a(TAG, str);
            Map<String, String> a2 = com.opos.acs.st.b.a.a(str.trim());
            if (a2 != null) {
                try {
                    map.putAll(a2);
                } catch (Exception e2) {
                    com.opos.cmn.an.f.a.d(TAG, "onEvent", e2);
                }
            }
        }
        return onEvent(context, map, eventListener, str2, str3);
    }

    public final String onEvent(Context context, String str, Map<String, String> map, String str2, String str3) throws Exception {
        return onEvent(context, str, map, null, str2, str3);
    }

    public final String onEvent(Context context, Map<String, String> map) throws Exception {
        return onEvent(context, map, (EventListener) null);
    }

    public final String onEvent(Context context, Map<String, String> map, EventListener eventListener) throws Exception {
        return onEvent(context, map, eventListener, (String) null, (String) null);
    }

    public final String onEvent(Context context, Map<String, String> map, EventListener eventListener, String str, String str2) throws Exception {
        String str3;
        checkInit(context);
        Context context2 = getContext(context);
        if (context2 == null || map == null) {
            if (eventListener != null) {
                eventListener.onEventReturn(4);
            }
            return null;
        }
        if (h.f(context2)) {
            throw new Exception("Please init st sdk at first!");
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (map.containsKey("traceId")) {
            str3 = map.get("traceId");
        } else {
            String str4 = h.a(map.get(KEY_AD_ID)) ? "0" : map.get(KEY_AD_ID);
            if (h.a(str)) {
                str = "0";
            }
            if (h.a(str2)) {
                str2 = "0";
            }
            str3 = "0-" + str4 + "-" + currentTimeMillis + "-" + str + "-" + str2;
        }
        d.a(TAG, "traceId=".concat(String.valueOf(str3)));
        map.put("evtId", String.valueOf(currentTimeMillis));
        com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.2

            /* renamed from: a */
            private /* synthetic */ Context f16266a;

            /* renamed from: b */
            private /* synthetic */ Map f16267b;

            /* renamed from: c */
            private /* synthetic */ EventListener f16268c;

            AnonymousClass2(Context context22, Map map2, EventListener eventListener2) {
                context2 = context22;
                map = map2;
                eventListener = eventListener2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                h.a(context2, (Map<String, String>) map, eventListener);
                d.a(STManager.TAG, "record data Context is :" + context2);
            }
        });
        return str3;
    }

    public final String onEvent(Context context, Map<String, String> map, String str, String str2) throws Exception {
        return onEvent(context, map, (EventListener) null, str, str2);
    }

    public final void onExit(Context context, ExitListener exitListener) throws NullPointerException {
        Context context2 = getContext(context);
        if (context2 == null || exitListener == null) {
            throw new NullPointerException("context or exitListener is null.");
        }
        new Thread(new Runnable() { // from class: com.opos.acs.st.STManager.3

            /* renamed from: a */
            private /* synthetic */ Context f16270a;

            /* renamed from: b */
            private /* synthetic */ ExitListener f16271b;

            AnonymousClass3(Context context22, ExitListener exitListener2) {
                context2 = context22;
                exitListener = exitListener2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                try {
                    STManager.this.reportDataOnExit(context2);
                } finally {
                    h.a();
                    exitListener.onFinish(true);
                }
            }
        }).start();
    }

    public final void pause(Context context) {
        Context context2 = getContext(context);
        if (context2 != null) {
            new Thread(new Runnable() { // from class: com.opos.acs.st.STManager.5

                /* renamed from: a */
                private /* synthetic */ Context f16275a;

                AnonymousClass5(Context context22) {
                    context2 = context22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    STManager.this.reportDataOnExit(context2);
                    h.a();
                }
            }).start();
        }
    }

    public final void reportDataOnExit(Context context) {
        Context context2 = getContext(context);
        if (context2 != null) {
            if (!com.opos.cmn.an.h.c.a.d(context2)) {
                d.a(TAG, "has no net,do nothing and  application exit.");
            } else {
                d.a(TAG, "has net,report all data before application exit.");
                h.b(context2);
            }
        }
    }

    public final void resume(Context context) {
        Context context2 = getContext(context);
        if (context2 != null) {
            com.opos.cmn.an.j.b.b(new Runnable() { // from class: com.opos.acs.st.STManager.4

                /* renamed from: a */
                private /* synthetic */ Context f16273a;

                AnonymousClass4(Context context22) {
                    context2 = context22;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    d.b("lshxjtu", "resume startReportTimer now!!!");
                    h.c(context2);
                }
            });
        }
    }
}
