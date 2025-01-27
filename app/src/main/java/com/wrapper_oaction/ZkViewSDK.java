package com.wrapper_oaction;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.zk_oaction.adengine.lk_sdkwrapper.e;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class ZkViewSDK {

    /* renamed from: a */
    private static ZkViewSDK f34672a;

    /* renamed from: b */
    private Context f34673b;

    /* renamed from: c */
    private e f34674c;

    /* renamed from: d */
    private b f34675d;

    public static class Event {
        public MotionEvent downEvent;
        public long downTime;
        public int downX;
        public int downY;
        public MotionEvent upEvent;
        public long upTime;
        public int upX;
        public int upY;
    }

    public enum KEY {
        KEY_AD_TITLE(c.F, c.A),
        KEY_AD_DESC(c.G, c.A),
        KEY_AD_IMAGE(c.H, c.z),
        KEY_AD_ICON(c.I, c.z),
        KEY_AD_LOGO(c.J, c.z),
        KEY_AD_ACTION(c.K, c.A),
        KEY_SHOW_HOT_AREA(c.L, c.B),
        KEY_HOT_ZONE_DESC(c.M, c.A),
        KEY_TURNTABLE_IMAGE(c.N, c.z),
        KEY_ADIMAGE_FILE_NAME(c.O, c.z),
        KEY_ROTATE_ANGLE(c.P, c.B),
        KEY_SHAKE_DESC(c.Q, c.A),
        KEY_SKIP_TIME(c.R, c.B),
        KEY_VIDEO_PROGRESS_STEP(c.S, c.B),
        KEY_SHAKE_ENABLE(c.T, c.B),
        KEY_SHAKE_RANGE(c.U, c.B),
        KEY_SHAKE_WAIT(c.V, c.B),
        KEY_AD_IMAGE_LIST(c.W, c.D),
        KEY_INVERSE_FEEDBACK(c.X, c.A),
        KEY_REWARD_DESC(c.Y, c.A),
        KEY_APP_INFO(c.f34677a, c.A),
        KEY_APP_DEVELOPER(c.f34678b, c.A),
        KEY_APP_VERSION(c.f34679c, c.A),
        KEY_VIDEO_EXTERNAL(c.f34680d, c.E),
        KEY_APP_DOWNLOAD_COUNT(c.f34681e, c.A),
        KEY_APP_SIZE(c.f34682f, c.A),
        KEY_VIP_INFO(c.f34683g, c.A),
        KEY_REWARD_TIME(c.f34684h, c.B),
        KEY_ROTATE_ANGLE_MULTI(c.f34685i, c.B),
        KEY_TT_AUTO_SKIP_TIME(c.f34686j, c.B),
        KEY_SHOW_SKIP_TIME(c.k, c.B),
        KEY_AD_VIEW(c.l, c.C),
        KEY_ADRES_ID(c.m, c.B),
        KEY_ADRES_NAME(c.n, c.A),
        KEY_ACTION(c.o, c.A),
        KEY_SHOW_TIME(c.p, c.B),
        KEY_TOTAL_TIME(c.q, c.B),
        KEY_TYPE_CODE(c.r, c.A),
        KEY_TARGET_URL(c.s, c.A),
        KEY_DEEPLINK(c.t, c.A),
        KEY_INSTANTAPP_URL(c.u, c.A),
        KEY_WXAPPLET_ID(c.v, c.A),
        KEY_WXAPPLET_PATH(c.w, c.A),
        KEY_AD_ID(c.x, c.A),
        KEY_USER_ID(c.y, c.A);

        public String key;
        public int keyType;

        KEY(String str, int i2) {
            this.key = str;
            this.keyType = i2;
        }
    }

    public interface a {
        void a(Map map, String str, int i2, int i3, int i4, Map map2);

        void a(Map map, String str, int i2, int i3, Map map2);

        void a(Map map, String str, int i2, String str2, Map map2);

        void a(Map map, String str, int i2, Map map2);

        void a(Map map, String str, Event event, int i2, String str2, int i3, Map map2);

        void a(Map map, String str, Event event, int i2, Map map2);

        void a(Map map, String str, Event event, String str2, int i2, Map map2);

        void a(Map map, String str, String str2, int i2, Map map2);

        void a(Map map, String str, Map map2);

        void a(Map map, Map map2);

        void b(Map map, String str, int i2, int i3, int i4, Map map2);

        void c(Map map, String str, int i2, int i3, int i4, Map map2);
    }

    public interface b {
        void a(Map map, String str);
    }

    public static class c {
        public static int A = 1;
        public static int B = 2;
        public static int C = 3;
        public static int D = 4;
        public static int E = 5;
        public static String F = "ad_title";
        public static String G = "ad_description";
        public static String H = "ad_image";
        public static String I = "ad_icon";
        public static String J = "ad_logo";
        public static String K = "ad_action";
        public static String L = "show_hot_zone";
        public static String M = "hot_zone_desc";
        public static String N = "turntalbe_image";
        public static String O = "adimage_file_name";
        public static String P = "rotate_angle";
        public static String Q = "shake_desc";
        public static String R = "skip_time";
        public static String S = "video_progress_step";
        public static String T = "shake_enable";
        public static String U = "shake_range";
        public static String V = "shake_wait";
        public static String W = "ad_imagelist";
        public static String X = "inverse_feedback";
        public static String Y = "reward_desc";

        /* renamed from: a */
        public static String f34677a = "app_info";

        /* renamed from: b */
        public static String f34678b = "app_developer";

        /* renamed from: c */
        public static String f34679c = "app_version";

        /* renamed from: d */
        public static String f34680d = "video_external";

        /* renamed from: e */
        public static String f34681e = "app_download_count";

        /* renamed from: f */
        public static String f34682f = "app_size";

        /* renamed from: g */
        public static String f34683g = "vip_info";

        /* renamed from: h */
        public static String f34684h = "reward_desc";

        /* renamed from: i */
        public static String f34685i = "rotate_angle_multi";

        /* renamed from: j */
        public static String f34686j = "tt_skip_time";
        public static String k = "show_skip_time";
        public static String l = "ad_view";
        public static String m = "ad_res_id";
        public static String n = "ad_res_name";
        public static String o = "ad_action";
        public static String p = "show_time";
        public static String q = "total_time";
        public static String r = "typeCode";
        public static String s = "targetUrl";
        public static String t = "deeplink";
        public static String u = "instantAppUrl";
        public static String v = "wxAppletId";
        public static String w = "wxAppletPath";
        public static String x = "ad_id";
        public static String y = "user_id";
        public static int z;
    }

    public static ZkViewSDK b() {
        ZkViewSDK zkViewSDK;
        synchronized (ZkViewSDK.class) {
            if (f34672a == null) {
                f34672a = new ZkViewSDK();
            }
            zkViewSDK = f34672a;
        }
        return zkViewSDK;
    }

    private void c(Context context) {
        try {
            if (this.f34673b != null) {
                return;
            }
            this.f34673b = context;
            if (context.getApplicationContext() != null) {
                this.f34673b = context.getApplicationContext();
            }
            e eVar = new e();
            this.f34674c = eVar;
            eVar.d(this.f34673b);
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.view.View] */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r13v6 */
    /* JADX WARN: Type inference failed for: r13v7 */
    /* JADX WARN: Type inference failed for: r13v8 */
    /* JADX WARN: Type inference failed for: r20v0, types: [com.wrapper_oaction.ZkViewSDK$a] */
    public View a(Context context, String str, boolean z, HashMap<KEY, Object> hashMap, Map map, a aVar) {
        ?? r13 = 0;
        r13 = 0;
        try {
            c(context);
            if (this.f34674c != null) {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("/fullscreen_match");
                r13 = new File(sb.toString()).exists() ? this.f34674c.h(str, 0, 0, z, hashMap, aVar, -1, map, 2) : this.f34674c.b(str, 0, 0, z, hashMap, aVar, -1, map, 1);
            }
        } catch (Throwable th) {
            if (aVar != 0) {
                aVar.a(map, "" + th.getMessage(), r13);
            }
        }
        return r13;
    }

    public void d(View view) {
        e eVar = this.f34674c;
        if (eVar != null) {
            eVar.e(view);
        }
    }

    public void e(View view, HashMap<KEY, Object> hashMap) {
        e eVar = this.f34674c;
        if (eVar != null) {
            eVar.f(view, hashMap);
        }
    }

    public void f(View view, boolean z) {
        e eVar = this.f34674c;
        if (eVar != null) {
            eVar.g(view, z);
        }
    }

    public void g(Map map, String str) {
        b bVar = this.f34675d;
        if (bVar != null) {
            bVar.a(map, str);
        }
    }

    public View h(Context context, String str, boolean z, HashMap<KEY, Object> hashMap, Map map, a aVar) {
        try {
            c(context);
            try {
                e eVar = this.f34674c;
                if (eVar != null) {
                    return eVar.h(str, 0, 0, z, hashMap, aVar, -1, map, 2);
                }
                return null;
            } catch (Throwable th) {
                th = th;
                if (aVar == null) {
                    return null;
                }
                aVar.a(map, "" + th.getMessage(), null);
                return null;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void i(View view) {
        e eVar = this.f34674c;
        if (eVar != null) {
            eVar.i(view);
        }
    }

    public void j(View view) {
        e eVar = this.f34674c;
        if (eVar != null) {
            eVar.j(view);
        }
    }
}
