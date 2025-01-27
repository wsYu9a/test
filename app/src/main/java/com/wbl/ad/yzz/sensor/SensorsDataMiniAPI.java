package com.wbl.ad.yzz.sensor;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.WindowManager;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.vivo.ic.dm.Constants;
import com.wbl.ad.yzz.sensor.exceptions.InvalidDataException;
import com.wbl.ad.yzz.sensor.q;
import com.wbl.ad.yzz.sensor.util.SensorsDataUtils;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.regex.Pattern;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class SensorsDataMiniAPI {
    public static m v;

    /* renamed from: a */
    public String f33784a;

    /* renamed from: b */
    public String f33785b;

    /* renamed from: c */
    public DebugMode f33786c;

    /* renamed from: d */
    public int f33787d;

    /* renamed from: e */
    public int f33788e;

    /* renamed from: f */
    public boolean f33789f;

    /* renamed from: g */
    public final Context f33790g;

    /* renamed from: h */
    public final com.wbl.ad.yzz.sensor.a f33791h;

    /* renamed from: i */
    public final d f33792i;

    /* renamed from: j */
    public final h f33793j;
    public final i k;
    public final f l;
    public final e m;
    public final Map<String, Object> n;
    public final Map<String, com.wbl.ad.yzz.sensor.c> o;
    public int p;
    public o q;
    public static Boolean r = Boolean.FALSE;
    public static final Pattern s = Pattern.compile("^((?!^distinct_id$|^original_id$|^time$|^properties$|^id$|^first_id$|^second_id$|^users$|^events$|^event$|^user_id$|^date$|^datetime$)[a-zA-Z_$][a-zA-Z\\d_$]{0,99})$", 2);
    public static final Map<Context, SensorsDataMiniAPI> t = new HashMap();
    public static final q u = new q();
    public static final SimpleDateFormat w = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

    public enum DebugMode {
        DEBUG_OFF(false, false),
        DEBUG_ONLY(true, false),
        DEBUG_AND_TRACK(true, true);

        private final boolean debugMode;
        private final boolean debugWriteData;

        DebugMode(boolean z, boolean z2) {
            this.debugMode = z;
            this.debugWriteData = z2;
        }

        public static DebugMode valueOf(String str) {
            return (DebugMode) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10674, null, str);
        }

        /* renamed from: values, reason: to resolve conflict with enum method */
        public static DebugMode[] valuesCustom() {
            return (DebugMode[]) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10673, null, null);
        }

        public boolean a() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10676, this, null);
        }

        public boolean b() {
            return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10675, this, null);
        }
    }

    public class a implements q.b {
        public a(SensorsDataMiniAPI sensorsDataMiniAPI) {
        }

        @Override // com.wbl.ad.yzz.sensor.q.b
        public void a(SharedPreferences sharedPreferences) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10638, this, sharedPreferences);
        }
    }

    public class b implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ EventType f33795a;

        /* renamed from: b */
        public final /* synthetic */ String f33796b;

        /* renamed from: c */
        public final /* synthetic */ JSONObject f33797c;

        /* renamed from: d */
        public final /* synthetic */ com.wbl.ad.yzz.sensor.c f33798d;

        /* renamed from: e */
        public final /* synthetic */ String f33799e;

        public b(EventType eventType, String str, JSONObject jSONObject, com.wbl.ad.yzz.sensor.c cVar, String str2) {
            this.f33795a = eventType;
            this.f33796b = str;
            this.f33797c = jSONObject;
            this.f33798d = cVar;
            this.f33799e = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10637, this, null);
        }
    }

    public interface c {
        void a(SensorsDataMiniAPI sensorsDataMiniAPI);
    }

    public SensorsDataMiniAPI() {
        this.p = 14;
        this.f33790g = null;
        this.f33791h = null;
        this.f33792i = null;
        this.f33793j = null;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
    }

    public static SensorsDataMiniAPI a(Context context) {
        return (SensorsDataMiniAPI) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10640, null, context);
    }

    public static SensorsDataMiniAPI a(Context context, String str, DebugMode debugMode) {
        return (SensorsDataMiniAPI) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10639, null, context, str, debugMode);
    }

    public static /* synthetic */ m a() {
        return (m) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10634, null, null);
    }

    public static /* synthetic */ Map a(SensorsDataMiniAPI sensorsDataMiniAPI) {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10633, null, sensorsDataMiniAPI);
    }

    public static void a(c cVar) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10636, null, cVar);
    }

    public static /* synthetic */ Context b(SensorsDataMiniAPI sensorsDataMiniAPI) {
        return (Context) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10629, null, sensorsDataMiniAPI);
    }

    public static /* synthetic */ i c(SensorsDataMiniAPI sensorsDataMiniAPI) {
        return (i) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10632, null, sensorsDataMiniAPI);
    }

    public static /* synthetic */ com.wbl.ad.yzz.sensor.a e(SensorsDataMiniAPI sensorsDataMiniAPI) {
        return (com.wbl.ad.yzz.sensor.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10626, null, sensorsDataMiniAPI);
    }

    public static SensorsDataMiniAPI p() {
        return (SensorsDataMiniAPI) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10625, null, null);
    }

    public final void a(EventType eventType, String str, JSONObject jSONObject, String str2) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10628, this, eventType, str, jSONObject, str2);
    }

    public final void a(EventType eventType, JSONObject jSONObject) throws InvalidDataException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10627, this, eventType, jSONObject);
    }

    public final void a(String str) throws InvalidDataException {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10654, this, str);
    }

    public void a(String str, JSONObject jSONObject) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10653, this, str, jSONObject);
    }

    public void a(boolean z) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10656, this, Boolean.valueOf(z));
    }

    public void b() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10655, this, null);
    }

    public boolean b(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10650, this, str);
    }

    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10649, this, null);
    }

    public void c(String str) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10652, this, str);
    }

    public final int d(String str) {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10651, this, str);
    }

    public final void d() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10646, this, null);
    }

    public void e() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10645, this, null);
    }

    public String f() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10648, this, null);
    }

    public int g() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10647, this, null);
    }

    public int h() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10642, this, null);
    }

    public String i() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10641, this, null);
    }

    public String j() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10644, this, null);
    }

    public String k() {
        return (String) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10643, this, null);
    }

    public boolean l() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10734, this, null);
    }

    public boolean m() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10733, this, null);
    }

    public final boolean n() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10736, this, null);
    }

    public void o() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10735, this, null);
    }

    public void q() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10730, this, null);
    }

    public void r() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10729, this, null);
    }

    public SensorsDataMiniAPI(Context context, String str, DebugMode debugMode) {
        this.p = 14;
        this.f33790g = context;
        this.f33786c = debugMode;
        String packageName = context.getApplicationContext().getPackageName();
        try {
            SensorsDataUtils.a(context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            j.a(this);
            Bundle bundle = context.getApplicationContext().getPackageManager().getApplicationInfo(packageName, 128).metaData;
            bundle = bundle == null ? new Bundle() : bundle;
            c(str);
            DebugMode debugMode2 = DebugMode.DEBUG_OFF;
            if (debugMode == debugMode2) {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", false));
            } else {
                r = Boolean.valueOf(bundle.getBoolean("com.sensorsdata.analytics.android.EnableLogging", true));
            }
            this.f33787d = bundle.getInt("com.sensorsdata.analytics.android.FlushInterval", Constants.DEFAULT_READ_TIMEOUT);
            this.f33788e = bundle.getInt("com.sensorsdata.analytics.android.FlushBulkSize", 100);
            this.f33789f = bundle.getBoolean("com.sensorsdata.analytics.android.AndroidId", true);
            this.f33791h = com.wbl.ad.yzz.sensor.a.a(this.f33790g, "com.wbl.ad.yzz.sa");
            Future<SharedPreferences> a2 = u.a(context, "com.wbl.ad.yzz.sa", new a(this));
            this.f33792i = new d(a2, context, this.f33789f);
            this.f33793j = new h(a2);
            this.k = new i(a2);
            f fVar = new f(a2);
            this.l = fVar;
            e eVar = new e(a2);
            this.m = eVar;
            if (Build.VERSION.SDK_INT >= 14) {
                ((Application) context.getApplicationContext()).registerActivityLifecycleCallbacks(new k(this, fVar, eVar));
            }
            if (debugMode != debugMode2) {
                Log.i("SA.SensorsDataAPI", String.format(Locale.CHINA, "Initialized the instance of Sensors Analytics SDK with server url '%s', flush interval %d ms, debugMode: %s", this.f33784a, Integer.valueOf(this.f33787d), debugMode));
            }
            HashMap hashMap = new HashMap();
            hashMap.put("$lib", "Android");
            hashMap.put("$lib_version", "1.10.4-mini");
            hashMap.put("$os", "Android");
            String str2 = Build.VERSION.RELEASE;
            hashMap.put("$os_version", str2 == null ? "UNKNOWN" : str2);
            String str3 = Build.MANUFACTURER;
            hashMap.put("$manufacturer", str3 == null ? "UNKNOWN" : str3);
            String str4 = Build.MODEL;
            if (TextUtils.isEmpty(str4)) {
                hashMap.put("$model", "UNKNOWN");
            } else {
                hashMap.put("$model", str4.trim());
            }
            try {
                hashMap.put("$app_version", this.f33790g.getPackageManager().getPackageInfo(this.f33790g.getPackageName(), 0).versionName);
            } catch (Exception e3) {
                if (debugMode != DebugMode.DEBUG_OFF) {
                    Log.i("SA.SensorsDataAPI", "Exception getting app version name", e3);
                }
            }
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("$screen_width", Integer.valueOf(displayMetrics.widthPixels));
            try {
                WindowManager windowManager = (WindowManager) this.f33790g.getSystemService("window");
                if (Build.VERSION.SDK_INT >= 17) {
                    Point point = new Point();
                    if (windowManager != null) {
                        windowManager.getDefaultDisplay().getRealSize(point);
                        hashMap.put("$screen_height", Integer.valueOf(point.y));
                    }
                }
            } catch (Exception unused) {
                hashMap.put("$screen_height", Integer.valueOf(displayMetrics.heightPixels));
            }
            String c2 = SensorsDataUtils.c(this.f33790g);
            if (!TextUtils.isEmpty(c2)) {
                hashMap.put("$carrier", c2);
            }
            String b2 = SensorsDataUtils.b(this.f33790g);
            if (!TextUtils.isEmpty(b2)) {
                hashMap.put("$device_id", b2);
            }
            this.n = Collections.unmodifiableMap(hashMap);
            this.o = new HashMap();
        } catch (PackageManager.NameNotFoundException e4) {
            throw new RuntimeException("Can't configure SensorsDataAPI with package name " + packageName, e4);
        }
    }
}
