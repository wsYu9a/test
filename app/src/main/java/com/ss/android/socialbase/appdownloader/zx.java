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
import com.ss.android.download.api.constant.BaseConstants;
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
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class zx {

    /* renamed from: i */
    private static j f24520i = null;

    /* renamed from: j */
    private static final String f24521j = "zx";
    private static i zx;

    /* renamed from: com.ss.android.socialbase.appdownloader.zx$1 */
    static class AnonymousClass1 implements InterfaceC0510zx {
        AnonymousClass1() {
        }

        @Override // com.ss.android.socialbase.appdownloader.zx.InterfaceC0510zx
        public boolean j(@NonNull Context context) {
            return zx.g(context);
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.zx$2 */
    static class AnonymousClass2 implements InterfaceC0510zx {
        AnonymousClass2() {
        }

        @Override // com.ss.android.socialbase.appdownloader.zx.InterfaceC0510zx
        public boolean j(@NonNull Context context) {
            return zx.q(context);
        }
    }

    private static class g implements Callable<Boolean> {

        /* renamed from: g */
        private final long f24522g;

        /* renamed from: i */
        private final Handler f24523i;

        /* renamed from: j */
        private final Context f24524j;
        private final InterfaceC0510zx zx;

        public g(Handler handler, Context context, InterfaceC0510zx interfaceC0510zx, long j2) {
            this.f24524j = context;
            this.zx = interfaceC0510zx;
            this.f24523i = handler;
            this.f24522g = j2;
        }

        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            InterfaceC0510zx interfaceC0510zx;
            try {
                interfaceC0510zx = this.zx;
            } catch (Throwable unused) {
            }
            if (interfaceC0510zx != null) {
                long j2 = this.f24522g;
                if (j2 > 0 && j2 <= 10000) {
                    Context context = this.f24524j;
                    boolean j3 = context != null ? interfaceC0510zx.j(context) : false;
                    Message obtain = Message.obtain();
                    if (j3) {
                        obtain.what = 2;
                        this.f24523i.sendMessage(obtain);
                    } else {
                        obtain.what = 1;
                        this.f24523i.sendMessageDelayed(obtain, this.f24522g);
                    }
                    return Boolean.FALSE;
                }
            }
            return Boolean.FALSE;
        }
    }

    public interface i {
        void j(DownloadInfo downloadInfo, com.ss.android.socialbase.appdownloader.j jVar);
    }

    private static class j implements AppStatusManager.AppStatusChangeListener {

        /* renamed from: i */
        private JSONObject f24525i;

        /* renamed from: j */
        private final q f24526j;
        private final int zx;

        public j(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0510zx interfaceC0510zx) {
            this.f24525i = jSONObject;
            int optInt = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_QUERY_INTERVAL, 1000);
            this.zx = optInt;
            this.f24526j = new q(context, intent, i2, interfaceC0510zx, optInt);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppBackground() {
            int optInt = this.f24525i.optInt(DownloadSettingKeys.AhPlans.KEY_JUMP_UNKNWON_SOURCE_WAIT_TIME_OUT, 20);
            Message obtain = Message.obtain();
            obtain.what = 1;
            this.f24526j.gv.sendMessage(obtain);
            if (optInt <= 0 || optInt >= 60) {
                return;
            }
            Message obtain2 = Message.obtain();
            obtain2.what = 2;
            this.f24526j.gv.sendMessageDelayed(obtain2, optInt * 1000);
        }

        @Override // com.ss.android.socialbase.downloader.common.AppStatusManager.AppStatusChangeListener
        public void onAppForeground() {
            if (!this.f24526j.k) {
                Message obtain = Message.obtain();
                obtain.what = 2;
                this.f24526j.gv.sendMessage(obtain);
            }
            AppStatusManager.getInstance().unregisterAppSwitchListener(this);
            j unused = zx.f24520i = null;
        }
    }

    private static class q implements WeakDownloadHandler.IHandler {

        /* renamed from: j */
        public static int f24528j;
        private static int zx;

        /* renamed from: g */
        private final Intent f24529g;
        private final Handler gv;

        /* renamed from: i */
        private final Context f24530i;
        private boolean k = false;
        private final long lg;
        private final InterfaceC0510zx q;
        private Future<Boolean> y;

        public q(Context context, Intent intent, int i2, InterfaceC0510zx interfaceC0510zx, long j2) {
            this.f24530i = context;
            this.f24529g = intent;
            zx = i2;
            this.q = interfaceC0510zx;
            this.gv = new WeakDownloadHandler(Looper.getMainLooper(), this);
            this.lg = j2;
        }

        @Override // com.ss.android.socialbase.downloader.thread.WeakDownloadHandler.IHandler
        public void handleMsg(Message message) {
            if (message != null) {
                int i2 = message.what;
                if (i2 == 1) {
                    long j2 = this.lg;
                    if (j2 <= 0 || j2 > 10000) {
                        return;
                    }
                    f24528j = 1;
                    this.y = DownloadComponentManager.getCPUThreadExecutor().submit(new g(this.gv, this.f24530i, this.q, this.lg));
                    return;
                }
                if (i2 == 2) {
                    f24528j = 2;
                    this.gv.removeMessages(2);
                    this.gv.removeMessages(1);
                    Future<Boolean> future = this.y;
                    if (future != null) {
                        future.cancel(true);
                    }
                    if (!this.k && (Build.VERSION.SDK_INT < 29 || AppStatusManager.getInstance().isAppForeground())) {
                        Intent intent = this.f24529g;
                        if (intent != null) {
                            zx.zx(this.f24530i, intent);
                        } else {
                            DownloadInfo downloadInfo = Downloader.getInstance(this.f24530i).getDownloadInfo(zx);
                            if (downloadInfo != null && downloadInfo.isDownloadOverStatus()) {
                                com.ss.android.socialbase.appdownloader.i.zx(this.f24530i, zx, false);
                            }
                        }
                        this.k = true;
                    }
                    zx.zx(zx, this.f24529g == null, zx.j(this.f24530i));
                }
            }
        }
    }

    /* renamed from: com.ss.android.socialbase.appdownloader.zx$zx */
    interface InterfaceC0510zx {
        boolean j(@NonNull Context context);
    }

    public static boolean g(Context context) {
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
    public static boolean q(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return context.getPackageManager().canRequestPackageInstalls();
        } catch (Throwable unused) {
            return true;
        }
    }

    private static void g(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_SHOW, jSONObject2);
    }

    public static void i(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_OPEN_SETTING, jSONObject2);
    }

    private static boolean zx(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.j jVar) {
        if (context != null && jSONObject != null) {
            String savePath = downloadInfo.getSavePath();
            if (TextUtils.isEmpty(savePath)) {
                return false;
            }
            jVar.f24469g = "custom";
            com.ss.android.socialbase.appdownloader.j.j j2 = com.ss.android.socialbase.appdownloader.j.g.j(context, "custom", jSONObject, downloadInfo);
            if (j2 != null && j2.j()) {
                Intent zx2 = j2.zx();
                if (zx2 == null) {
                    return false;
                }
                if (!j(new File(savePath), downloadInfo, jSONObject)) {
                    jVar.zx = 6;
                } else {
                    if (zx(context, zx2)) {
                        jVar.zx = 0;
                        return true;
                    }
                    jVar.zx = 1;
                }
                return false;
            }
            jVar.zx = 3;
        }
        return false;
    }

    public static boolean j(Context context, DownloadInfo downloadInfo, Intent intent, boolean z) {
        JSONArray optJSONArray = DownloadSetting.obtain(downloadInfo.getId()).optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        if (optJSONArray == null) {
            return false;
        }
        int length = optJSONArray.length();
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (com.ss.android.socialbase.appdownloader.gv.j.j(optJSONObject) && j(context, downloadInfo, intent, optJSONObject, z)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01a7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean j(android.content.Context r11, com.ss.android.socialbase.downloader.model.DownloadInfo r12, android.content.Intent r13, org.json.JSONObject r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 478
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.appdownloader.zx.j(android.content.Context, com.ss.android.socialbase.downloader.model.DownloadInfo, android.content.Intent, org.json.JSONObject, boolean):boolean");
    }

    public static com.ss.android.socialbase.appdownloader.j zx(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.j jVar = new com.ss.android.socialbase.appdownloader.j();
        if (jSONObject == null) {
            return jVar;
        }
        jVar.f24471j = jSONObject.optString("type");
        jVar.q = "vbi";
        if (com.ss.android.socialbase.appdownloader.j.g.j(DownloadComponentManager.getAppContext(), "vbi", jSONObject, downloadSetting)) {
            jVar.zx = 0;
        } else {
            j(jVar, 3);
        }
        return jVar;
    }

    public static void zx(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CANCEL, jSONObject2);
    }

    public static void zx(int i2, boolean z, boolean z2) {
        JSONObject jSONObject = new JSONObject();
        int i3 = 1;
        try {
            jSONObject.put("scene", z ? 1 : 2);
            if (!z2) {
                i3 = 2;
            }
            jSONObject.put(FontsContractCompat.Columns.RESULT_CODE, i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_RESULT, jSONObject);
    }

    public static boolean zx(Context context, Intent intent) {
        return j(context, intent, true);
    }

    private static boolean j(Context context, @NonNull DownloadInfo downloadInfo, JSONObject jSONObject, @NonNull com.ss.android.socialbase.appdownloader.j jVar, DownloadSetting downloadSetting) {
        boolean z;
        String optString = jSONObject.optString("type");
        jVar.f24471j = optString;
        Intent zx2 = com.ss.android.socialbase.appdownloader.j.g.j(context, "vbi", jSONObject, downloadInfo).zx();
        StringBuilder sb = new StringBuilder();
        try {
            z = zx(context, zx2);
        } catch (Throwable th) {
            sb.append(optString);
            sb.append(" startActivity failed : ");
            sb.append(j(th));
            j(jVar, 1);
            z = false;
        }
        if (!z) {
            jVar.f24470i = sb.toString();
        } else {
            jVar.zx = 0;
        }
        return true;
    }

    private static boolean j(Context context, DownloadInfo downloadInfo, JSONObject jSONObject, com.ss.android.socialbase.appdownloader.j jVar) {
        boolean z;
        if (context != null && jSONObject != null) {
            String optString = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            jVar.q = optString;
            if (!TextUtils.isEmpty(optString)) {
                String[] split = optString.split(",");
                String savePath = downloadInfo.getSavePath();
                if (TextUtils.isEmpty(savePath)) {
                    return false;
                }
                File file = new File(savePath);
                StringBuilder sb = new StringBuilder();
                String str = null;
                int length = split.length;
                int i2 = 0;
                while (true) {
                    z = true;
                    if (i2 >= length) {
                        z = false;
                        break;
                    }
                    String str2 = split[i2];
                    com.ss.android.socialbase.appdownloader.j.j j2 = com.ss.android.socialbase.appdownloader.j.g.j(context, str2, jSONObject, downloadInfo);
                    if (j2 != null) {
                        Intent zx2 = j2.zx();
                        if (zx2 != null) {
                            if (j(file, downloadInfo, jSONObject)) {
                                try {
                                    j(context, zx2, false);
                                    str = str2;
                                    break;
                                } catch (Throwable th) {
                                    sb.append(str2);
                                    sb.append(" startActivity failed : ");
                                    sb.append(j(th));
                                    j(jVar, 1);
                                }
                            } else {
                                j(jVar, 6);
                                sb.append(str2);
                                sb.append(" createDescFile failed! ");
                            }
                        } else {
                            j(jVar, 3);
                            sb.append(str2);
                            sb.append(" resolveActivity failed! ");
                        }
                    }
                    sb.append("  ");
                    i2++;
                }
                if (!z) {
                    jVar.f24470i = sb.toString();
                } else {
                    jVar.f24469g = str;
                    jVar.zx = 0;
                }
                return z;
            }
        }
        return false;
    }

    public static int j(@NonNull DownloadSetting downloadSetting) {
        if (!(downloadSetting.optJSONObject(DownloadSettingKeys.KEY_ANTI_HIJACK_DIR) != null ? !TextUtils.isEmpty(r0.optString(DownloadSettingKeys.AntiHijackDir.KEY_ANTI_HIJACK_DIR_NAME)) : false)) {
            return 5;
        }
        if (!DownloadSetting.obtainGlobal().optBugFix(DownloadSettingKeys.BugFix.BUGFIX_GET_DOWNLOAD_INFO_BY_LIST)) {
            return 4;
        }
        JSONArray optJSONArray = downloadSetting.optJSONArray(DownloadSettingKeys.KEY_AH_PLANS);
        int i2 = -1;
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
                if (com.ss.android.socialbase.appdownloader.gv.j.j(optJSONObject)) {
                    String optString = optJSONObject.optString("type");
                    if (!"plan_a".equals(optString) && !"plan_b".equals(optString) && !"plan_e".equals(optString) && !"plan_f".equals(optString)) {
                        if ("plan_d".equalsIgnoreCase(optString) || "plan_h".equalsIgnoreCase(optString) || ("plan_g".equalsIgnoreCase(optString) && (i2 = zx(optJSONObject, downloadSetting).zx) == 0)) {
                            return 0;
                        }
                    } else {
                        i2 = j(optJSONObject, downloadSetting).zx;
                        if (i2 == 0) {
                            return 0;
                        }
                    }
                }
            }
        }
        return i2;
    }

    @NonNull
    public static com.ss.android.socialbase.appdownloader.j j(JSONObject jSONObject, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.j jVar = new com.ss.android.socialbase.appdownloader.j();
        if (jSONObject == null) {
            return jVar;
        }
        String optString = jSONObject.optString("type");
        jVar.f24471j = optString;
        if ("plan_b".equals(optString)) {
            jVar.q = "custom";
            if (com.ss.android.socialbase.appdownloader.j.g.j(DownloadComponentManager.getAppContext(), "custom", jSONObject, downloadSetting)) {
                jVar.zx = 0;
                return jVar;
            }
            j(jVar, 3);
        } else {
            String optString2 = jSONObject.optString(DownloadSettingKeys.AhPlans.KEY_AH_DEVICE_PLANS);
            jVar.q = optString2;
            if (!TextUtils.isEmpty(optString2)) {
                for (String str : optString2.split(",")) {
                    if (com.ss.android.socialbase.appdownloader.j.g.j(DownloadComponentManager.getAppContext(), str, jSONObject, downloadSetting)) {
                        jVar.zx = 0;
                        return jVar;
                    }
                    j(jVar, 3);
                }
            }
        }
        return jVar;
    }

    public static com.ss.android.socialbase.appdownloader.j j(JSONObject jSONObject, String str, Context context, DownloadSetting downloadSetting) {
        com.ss.android.socialbase.appdownloader.j jVar = new com.ss.android.socialbase.appdownloader.j();
        if (jSONObject != null && com.ss.android.socialbase.appdownloader.gv.q.zx()) {
            jVar.f24471j = jSONObject.optString("type");
            if (downloadSetting.optInt("bi", 0) == 1) {
                jVar.zx = 0;
                return jVar;
            }
            if (j(context)) {
                jVar.zx = 2;
            } else if (com.ss.android.socialbase.appdownloader.gv.j.j(str) != null) {
                jVar.zx = 0;
            } else {
                jVar.zx = 9;
            }
        }
        return jVar;
    }

    private static void j(com.ss.android.socialbase.appdownloader.j jVar, int i2) {
        int i3 = jVar.zx;
        if (i3 != -1) {
            jVar.zx = (i3 * 10) + i2;
        } else {
            jVar.zx = i2;
        }
    }

    private static boolean j(File file, DownloadInfo downloadInfo, @NonNull JSONObject jSONObject) {
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

    public static boolean j(Context context, @Nullable Intent intent, JSONObject jSONObject, int i2, @Nullable com.ss.android.socialbase.appdownloader.j jVar) {
        if (context != null && jSONObject != null) {
            long optLong = jSONObject.optLong(DownloadSettingKeys.AhPlans.KEY_JUMP_INTERVAL, 0L);
            if (optLong <= 0) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(DownloadConstants.SP_ANTI_HIJACK_CONFIG, 0);
            if ((System.currentTimeMillis() - sharedPreferences.getLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, 0L)) / 60000 >= optLong && !j(context)) {
                sharedPreferences.edit().putLong(SpJsonConstants.KEY_LAST_JUMP_UNKNOWN_SOURCE_TIME, System.currentTimeMillis()).apply();
                if (jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_SHOW_UNKNOWN_SOURCE_DIALOG, 0) == 1) {
                    Intent intent2 = new Intent(context, (Class<?>) JumpUnknownSourceActivity.class);
                    intent2.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                    intent2.putExtra("intent", intent);
                    intent2.putExtra("config", jSONObject.toString());
                    intent2.putExtra("id", i2);
                    try {
                        if (j(context, intent2, false)) {
                            g(i2, jSONObject);
                        }
                        return true;
                    } catch (Throwable th) {
                        if (jVar != null) {
                            jVar.zx = 1;
                            jVar.f24470i = "tryShowUnknownSourceDialog" + j(th);
                        }
                        return false;
                    }
                }
                if (j(context, intent, i2, jSONObject)) {
                    i(i2, jSONObject);
                }
                return true;
            }
        }
        return false;
    }

    public static boolean j(Context context, @Nullable Intent intent, int i2, JSONObject jSONObject) {
        try {
            if (com.ss.android.socialbase.appdownloader.gv.q.zx() && Build.VERSION.SDK_INT < 26 && !g(context)) {
                com.ss.android.socialbase.appdownloader.j.gv gvVar = new com.ss.android.socialbase.appdownloader.j.gv(context);
                if (gvVar.j()) {
                    j(context, intent, i2, jSONObject, new InterfaceC0510zx() { // from class: com.ss.android.socialbase.appdownloader.zx.1
                        AnonymousClass1() {
                        }

                        @Override // com.ss.android.socialbase.appdownloader.zx.InterfaceC0510zx
                        public boolean j(@NonNull Context context2) {
                            return zx.g(context2);
                        }
                    });
                    return zx(context, gvVar.zx());
                }
            } else if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26 && !q(context)) {
                com.ss.android.socialbase.appdownloader.j.zx zxVar = new com.ss.android.socialbase.appdownloader.j.zx(context);
                if (zxVar.j()) {
                    j(context, intent, i2, jSONObject, new InterfaceC0510zx() { // from class: com.ss.android.socialbase.appdownloader.zx.2
                        AnonymousClass2() {
                        }

                        @Override // com.ss.android.socialbase.appdownloader.zx.InterfaceC0510zx
                        public boolean j(@NonNull Context context2) {
                            return zx.q(context2);
                        }
                    });
                    return zx(context, zxVar.zx());
                }
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    public static boolean j(Context context) {
        if (context == null) {
            return true;
        }
        if (com.ss.android.socialbase.appdownloader.gv.q.zx() && Build.VERSION.SDK_INT < 26) {
            return g(context);
        }
        if (Build.VERSION.SDK_INT >= 26 && context.getApplicationInfo().targetSdkVersion >= 26) {
            return q(context);
        }
        return true;
    }

    public static boolean j() {
        return q.f24528j == 1;
    }

    public static void j(int i2, JSONObject jSONObject) {
        int i3 = 1;
        boolean z = jSONObject.optInt(DownloadSettingKeys.AhPlans.KEY_ALLOW_UNKNOWN_SOURCE_ON_STARTUP) == 1;
        JSONObject jSONObject2 = new JSONObject();
        if (!z) {
            i3 = 2;
        }
        try {
            jSONObject2.put("scene", i3);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        DownloadComponentManager.getEventListener().onUnityEvent(i2, MonitorConstants.UnityLabel.GUIDE_AUTH_DIALOG_CONFIRM, jSONObject2);
    }

    private static void j(Context context, Intent intent, int i2, JSONObject jSONObject, InterfaceC0510zx interfaceC0510zx) {
        if (f24520i != null) {
            AppStatusManager.getInstance().unregisterAppSwitchListener(f24520i);
            f24520i = null;
        }
        f24520i = new j(context, intent, i2, jSONObject, interfaceC0510zx);
        AppStatusManager.getInstance().registerAppSwitchListener(f24520i);
    }

    public static boolean j(Context context, Intent intent, boolean z) {
        if (context == null || intent == null) {
            return false;
        }
        if (z) {
            try {
                intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
                context.startActivity(intent);
                return true;
            } catch (Throwable unused) {
                return false;
            }
        }
        intent.putExtra(BaseConstants.START_ONLY_FOR_ANDROID, true);
        context.startActivity(intent);
        return true;
    }

    public static String j(Throwable th) {
        String th2 = th.toString();
        return th2.length() > 800 ? th2.substring(0, 500) : th2;
    }

    public static void j(i iVar) {
        zx = iVar;
    }
}
