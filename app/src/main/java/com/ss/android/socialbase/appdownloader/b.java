package com.ss.android.socialbase.appdownloader;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.provider.FontsContractCompat;
import com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity;
import com.ss.android.socialbase.downloader.common.AppStatusManager;
import com.ss.android.socialbase.downloader.constants.DownloadConstants;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.android.socialbase.downloader.constants.SpJsonConstants;
import com.ss.android.socialbase.downloader.downloader.DownloadComponentManager;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.setting.DownloadSetting;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;
import com.ss.android.socialbase.downloader.thread.WeakDownloadHandler;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class b {

    /* renamed from: a */
    private static final String f21751a = "b";

    /* renamed from: b */
    private static c f21752b;

    /* renamed from: c */
    private static a f21753c;

    /* renamed from: com.ss.android.socialbase.appdownloader.b$1 */
    public static class AnonymousClass1 implements InterfaceC0646b {
        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0646b
        public boolean a(@NonNull Context context) {
            return b.d(context);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$2 */
    public static class AnonymousClass2 implements InterfaceC0646b {
        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0646b
        public boolean a(@NonNull Context context) {
            return b.e(context);
        }
    }

    public static class a implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: a */
        private final e f21754a;

        /* renamed from: b */
        private final int f21755b;

        /* renamed from: c */
        private JSONObject f21756c;

        public a(Context context, Intent intent, int i10, JSONObject jSONObject, InterfaceC0646b interfaceC0646b) {
            this.f21756c = jSONObject;
            int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.f21755b = optInt;
            this.f21754a = new e(context, intent, i10, interfaceC0646b, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.f21756c.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f21754a.f21767f.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f21754a.f21767f.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.f21754a.f21770i) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f21754a.f21767f.sendMessage(obtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            a unused = b.f21753c = null;
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.b$b */
    public interface InterfaceC0646b {
        boolean a(@NonNull Context context);
    }

    public interface c {
        void a(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.a aVar);
    }

    public static class d implements Callable<Boolean> {

        /* renamed from: a */
        private final Context f21758a;

        /* renamed from: b */
        private final InterfaceC0646b f21759b;

        /* renamed from: c */
        private final Handler f21760c;

        /* renamed from: d */
        private final long f21761d;

        public d(Handler handler, Context context, InterfaceC0646b interfaceC0646b, long j10) {
            this.f21758a = context;
            this.f21759b = interfaceC0646b;
            this.f21760c = handler;
            this.f21761d = j10;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a */
        public Boolean call() throws Exception {
            InterfaceC0646b interfaceC0646b;
            try {
                interfaceC0646b = this.f21759b;
            } catch (Throwable unused) {
            }
            if (interfaceC0646b != null) {
                long j10 = this.f21761d;
                if (j10 > 0 && j10 <= 10000) {
                    Context context = this.f21758a;
                    boolean a10 = context != null ? interfaceC0646b.a(context) : false;
                    Message obtain = Message.obtain();
                    if (a10) {
                        obtain.what = 2;
                        this.f21760c.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f21760c.sendMessageDelayed(obtain, this.f21761d);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public static class e implements WeakDownloadHandler.IHandler {

        /* renamed from: a */
        public static int f21762a;

        /* renamed from: b */
        private static int f21763b;

        /* renamed from: c */
        private final Context f21764c;

        /* renamed from: d */
        private final Intent f21765d;

        /* renamed from: e */
        private final InterfaceC0646b f21766e;

        /* renamed from: f */
        private final Handler f21767f;

        /* renamed from: g */
        private final long f21768g;

        /* renamed from: h */
        private Future<Boolean> f21769h;

        /* renamed from: i */
        private boolean f21770i = false;

        public e(Context context, Intent intent, int i10, InterfaceC0646b interfaceC0646b, long j10) {
            this.f21764c = context;
            this.f21765d = intent;
            f21763b = i10;
            this.f21766e = interfaceC0646b;
            this.f21767f = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.f21768g = j10;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                int i10 = message.what;
                if (i10 == 1) {
                    long j10 = this.f21768g;
                    if (j10 <= 0 || j10 > 10000) {
                        return;
                    }
                    f21762a = 1;
                    this.f21769h = DownloadComponentManager.getCPUThreadExecutor().submit(new d(this.f21767f, this.f21764c, this.f21766e, this.f21768g));
                    return;
                }
                if (i10 == 2) {
                    f21762a = 2;
                    this.f21767f.removeMessages(2);
                    this.f21767f.removeMessages(1);
                    Future<Boolean> future = this.f21769h;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.f21770i && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.f21765d;
                        if (intent != null) {
                            b.b(this.f21764c, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f21764c).getDownloadInfo(f21763b);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.c.b(this.f21764c, f21763b, false);
                            }
                        }
                        this.f21770i = true;
                    }
                    b.b(f21763b, this.f21765d == null, b.a(this.f21764c));
                }
            }
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps", 1) > 0;
        } catch (Throwable unused) {
            return true;
        }
    }

    @RequiresApi(api = 26)
    public static boolean e(Context context) {
        boolean canRequestPackageInstalls;
        if (context == null) {
            return true;
        }
        try {
            canRequestPackageInstalls = context.getPackageManager().canRequestPackageInstalls();
            return canRequestPackageInstalls;
        } catch (Throwable unused) {
            return true;
        }
    }

    private static boolean b(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            aVar.f21743d = "custom";
            com.ss.android.socialbase.appdownloader.a.a a10 = com.ss.android.socialbase.appdownloader.a.d.a(context, "custom", jSONObject, downloadInfo);
            if (a10 != null && a10.a()) {
                Intent b10 = a10.b();
                if (b10 == null) {
                    return false;
                }
                if (!a(new File(savePath), downloadInfo, jSONObject)) {
                    aVar.f21741b = 6;
                } else {
                    if (b(context, b10)) {
                        aVar.f21741b = 0;
                        return true;
                    }
                    aVar.f21741b = 1;
                }
                return false;
            }
            aVar.f21741b = 3;
        }
        return false;
    }

    public static void c(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.f24233j, i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    private static void d(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.f24233j, i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    public static boolean a(Context context, DownloadInfo downloadInfo, Intent intent, boolean z10) {
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i10 = 0; i10 < length; i10++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
            if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject) && a(context, downloadInfo, intent, optJSONObject, z10)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:20:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x016a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 470
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.b.a(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.a b(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar;
        }
        aVar.f21740a = jSONObject.optString("type");
        aVar.f21744e = "vbi";
        if (com.ss.android.socialbase.appdownloader.a.d.a(DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            aVar.f21741b = 0;
        } else {
            a(aVar, 3);
        }
        return aVar;
    }

    public static void b(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.f24233j, i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    public static void b(int i10, boolean z10, boolean z11) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(com.umeng.ccg.a.f24233j, z10 ? 1 : 2);
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, z11 ? 1 : 2);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    public static boolean b(Context context, Intent intent) {
        return a(context, intent, true);
    }

    private static boolean a(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.a aVar, DownloadSetting downloadSetting) {
        boolean z10;
        String optString = jSONObject.optString("type");
        aVar.f21740a = optString;
        Intent b10 = com.ss.android.socialbase.appdownloader.a.d.a(context, "vbi", jSONObject, downloadInfo).b();
        StringBuilder sb2 = new StringBuilder();
        try {
            z10 = b(context, b10);
        } catch (Throwable th2) {
            sb2.append(optString);
            sb2.append(" startActivity failed : ");
            sb2.append(a(th2));
            a(aVar, 1);
            z10 = false;
        }
        if (!z10) {
            aVar.f21742c = sb2.toString();
        } else {
            aVar.f21741b = 0;
        }
        return true;
    }

    private static boolean a(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.a aVar) {
        String str;
        boolean z10;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            aVar.f21744e = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb2 = new StringBuilder();
                int length = split.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        str = null;
                        z10 = false;
                        break;
                    }
                    str = split[i10];
                    com.ss.android.socialbase.appdownloader.a.a a10 = com.ss.android.socialbase.appdownloader.a.d.a(context, str, jSONObject, downloadInfo);
                    if (a10 != null) {
                        Intent b10 = a10.b();
                        if (b10 != null) {
                            if (a(file, downloadInfo, jSONObject)) {
                                z10 = true;
                                try {
                                    a(context, b10, false);
                                    break;
                                } catch (Throwable th2) {
                                    sb2.append(str);
                                    sb2.append(" startActivity failed : ");
                                    sb2.append(a(th2));
                                    a(aVar, 1);
                                }
                            } else {
                                a(aVar, 6);
                                sb2.append(str);
                                sb2.append(" createDescFile failed! ");
                            }
                        } else {
                            a(aVar, 3);
                            sb2.append(str);
                            sb2.append(" resolveActivity failed! ");
                        }
                    }
                    sb2.append("  ");
                    i10++;
                }
                if (!z10) {
                    aVar.f21742c = sb2.toString();
                } else {
                    aVar.f21743d = str;
                    aVar.f21741b = 0;
                }
                return z10;
            }
        }
        return false;
    }

    public static int a(@NonNull DownloadSetting downloadSetting) {
        if (!(downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(r0.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
            return 4;
        }
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        int i10 = -1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i11);
                if (com.ss.android.socialbase.appdownloader.f.a.a(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                        if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i10 = b(optJSONObject, downloadSetting).f21741b) == 0)) {
                            return 0;
                        }
                    } else {
                        i10 = a(optJSONObject, downloadSetting).f21741b;
                        if (i10 == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i10;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject == null) {
            return aVar;
        }
        String optString = jSONObject.optString("type");
        aVar.f21740a = optString;
        if ("plan_b".equals(optString)) {
            aVar.f21744e = "custom";
            if (com.ss.android.socialbase.appdownloader.a.d.a(DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                aVar.f21741b = 0;
                return aVar;
            }
            a(aVar, 3);
        } else {
            String optString2 = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            aVar.f21744e = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.a.d.a(DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        aVar.f21741b = 0;
                        return aVar;
                    }
                    a(aVar, 3);
                }
            }
        }
        return aVar;
    }

    public static com.ss.android.socialbase.appdownloader.a a(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.a aVar = new com.ss.android.socialbase.appdownloader.a();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.f.e.c()) {
            aVar.f21740a = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                aVar.f21741b = 0;
                return aVar;
            }
            if (a(context)) {
                aVar.f21741b = 2;
            } else if (com.ss.android.socialbase.appdownloader.f.a.a(str) != null) {
                aVar.f21741b = 0;
            } else {
                aVar.f21741b = 9;
            }
        }
        return aVar;
    }

    private static void a(com.ss.android.socialbase.appdownloader.a aVar, int i10) {
        int i11 = aVar.f21741b;
        if (i11 != -1) {
            aVar.f21741b = (i11 * 10) + i10;
        } else {
            aVar.f21741b = i10;
        }
    }

    private static boolean a(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
        if (file == null) {
            return false;
        }
        String path = file.getPath();
        JSONObject optJSONObject = DownloadSetting.obtain(downloadInfo.getId()).optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR);
        File file2 = null;
        String optString = optJSONObject != null ? optJSONObject.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_INSTALL_DESC) : null;
        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString)) {
            file2 = new File(path + File.separator + optString);
        }
        if (file2 == null) {
            return true;
        }
        try {
            if (!file2.createNewFile()) {
                return true;
            }
            file2.deleteOnExit();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(Context context, @Nullable Intent intent, JSONObject jSONObject, int i10, @Nullable com.ss.android.socialbase.appdownloader.a aVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= optLong && !a(context)) {
                sharedPreferences.edit().putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis()).apply();
                if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(268435456);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i10);
                    try {
                        if (a(context, intent2, false)) {
                            d(i10, jSONObject);
                        }
                        return true;
                    } catch (Throwable th2) {
                        if (aVar != null) {
                            aVar.f21741b = 1;
                            aVar.f21742c = "tryShowUnknownSourceDialog" + a(th2);
                        }
                        return false;
                    }
                }
                if (a(context, intent, i10, jSONObject)) {
                    c(i10, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(Context context, @Nullable Intent intent, int i10, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.f.e.c() && Build.VERSION.SDK_INT < 26 && !d(context)) {
                com.ss.android.socialbase.appdownloader.a.f fVar = new com.ss.android.socialbase.appdownloader.a.f(context);
                if (fVar.a()) {
                    a(context, intent, i10, jSONObject, new InterfaceC0646b() { // from class: com.ss.android.socialbase.appdownloader.b.1
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0646b
                        public boolean a(@NonNull Context context2) {
                            return b.d(context2);
                        }
                    });
                    return b(context, fVar.b());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !e(context)) {
                com.ss.android.socialbase.appdownloader.a.b bVar = new com.ss.android.socialbase.appdownloader.a.b(context);
                if (bVar.a()) {
                    a(context, intent, i10, jSONObject, new InterfaceC0646b() { // from class: com.ss.android.socialbase.appdownloader.b.2
                        @Override // com.ss.android.socialbase.appdownloader.b.InterfaceC0646b
                        public boolean a(@NonNull Context context2) {
                            return b.e(context2);
                        }
                    });
                    return b(context, bVar.b());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean a(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.f.e.c() && Build.VERSION.SDK_INT < 26) {
            return d(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return e(context);
        }
        return true;
    }

    public static boolean a() {
        return e.f21762a == 1;
    }

    public static void a(int i10, JSONObject jSONObject) {
        int i11 = 1;
        boolean z10 = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z10) {
            i11 = 2;
        }
        try {
            jSONObject2.put(com.umeng.ccg.a.f24233j, i11);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i10, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void a(Context context, Intent intent, int i10, JSONObject jSONObject, InterfaceC0646b interfaceC0646b) {
        if (f21753c != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(f21753c);
            f21753c = null;
        }
        f21753c = new a(context, intent, i10, jSONObject, interfaceC0646b);
        AppStatusManager.getInstance().registerAppSwitchListener(f21753c);
    }

    public static boolean a(Context context, Intent intent, boolean z10) {
        if (context == null || intent == null) {
            return false;
        }
        if (z10) {
            try {
                intent.putExtra("start_only_for_android", true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra("start_only_for_android", true);
        context.startActivity(intent);
        return true;
    }

    public static String a(Throwable th2) {
        String th3 = th2.toString();
        return th3.length() > 800 ? th3.substring(0, 500) : th3;
    }

    public static void a(c cVar) {
        f21752b = cVar;
    }
}
