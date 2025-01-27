package cn.vlion.ad.inland.base.util;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import cn.vlion.ad.inland.base.l1;
import cn.vlion.ad.inland.base.util.VlionHandlerUtils;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: classes.dex */
public class VlionHandlerUtils {

    public static class HandlerInstant {
        public static final Handler handler = new Handler(Looper.getMainLooper());
    }

    public static Handler instant() {
        return HandlerInstant.handler;
    }

    public static boolean isMainProcess(Context context) {
        try {
            LogVlion.e("isMainProcess context " + context);
            if (context == null) {
                return false;
            }
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(TTDownloadField.TT_ACTIVITY);
            if (activityManager == null) {
                return true;
            }
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                if (runningAppProcessInfo != null) {
                    instant().post(new Runnable() { // from class: c1.a

                        /* renamed from: b */
                        public final /* synthetic */ ActivityManager.RunningAppProcessInfo f1686b;

                        /* renamed from: c */
                        public final /* synthetic */ int f1687c;

                        public /* synthetic */ a(ActivityManager.RunningAppProcessInfo runningAppProcessInfo2, int myPid2) {
                            runningAppProcessInfo = runningAppProcessInfo2;
                            myPid = myPid2;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            VlionHandlerUtils.lambda$isMainProcess$0(runningAppProcessInfo, myPid);
                        }
                    });
                    if (runningAppProcessInfo2.pid == myPid2) {
                        boolean equals = context.getPackageName().equals(runningAppProcessInfo2.processName);
                        instant().post(new Runnable() { // from class: c1.b

                            /* renamed from: b */
                            public final /* synthetic */ Context f1688b;

                            /* renamed from: c */
                            public final /* synthetic */ ActivityManager.RunningAppProcessInfo f1689c;

                            /* renamed from: d */
                            public final /* synthetic */ boolean f1690d;

                            public /* synthetic */ b(Context context2, ActivityManager.RunningAppProcessInfo runningAppProcessInfo2, boolean equals2) {
                                context = context2;
                                runningAppProcessInfo = runningAppProcessInfo2;
                                equals = equals2;
                            }

                            @Override // java.lang.Runnable
                            public final void run() {
                                VlionHandlerUtils.lambda$isMainProcess$1(context, runningAppProcessInfo, equals);
                            }
                        });
                        return equals2;
                    }
                }
            }
            return false;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return true;
        }
    }

    public static /* synthetic */ void lambda$isMainProcess$0(ActivityManager.RunningAppProcessInfo runningAppProcessInfo, int i10) {
        StringBuilder a10 = l1.a("isMainProcess processInfo ");
        a10.append(runningAppProcessInfo.pid);
        a10.append(",pid=");
        a10.append(i10);
        LogVlion.e(a10.toString());
    }

    public static /* synthetic */ void lambda$isMainProcess$1(Context context, ActivityManager.RunningAppProcessInfo runningAppProcessInfo, boolean z10) {
        StringBuilder a10 = l1.a("isMainProcess getPackageName()= ");
        a10.append(context.getPackageName());
        a10.append(",processInfo.processName=");
        a10.append(runningAppProcessInfo.processName);
        a10.append(" ,isSameProcess= ");
        a10.append(z10);
        LogVlion.e(a10.toString());
    }
}
