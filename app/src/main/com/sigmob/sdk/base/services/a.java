package com.sigmob.sdk.base.services;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.czhj.sdk.common.ThreadPool.ThreadPoolFactory;
import com.czhj.sdk.common.utils.FileUtil;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.common.b0;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import com.sigmob.sdk.base.mta.PointCategory;
import java.io.File;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class a extends BroadcastReceiver {

    /* renamed from: com.sigmob.sdk.base.services.a$a */
    public class RunnableC0575a implements Runnable {

        /* renamed from: a */
        public final /* synthetic */ Context f18346a;

        /* renamed from: b */
        public final /* synthetic */ BaseAdUnit f18347b;

        public RunnableC0575a(Context context, BaseAdUnit baseAdUnit) {
            this.f18346a = context;
            this.f18347b = baseAdUnit;
        }

        @Override // java.lang.Runnable
        public void run() {
            FileUtil.deleteFile(new File(com.sigmob.sdk.base.utils.d.a(this.f18346a.getApplicationContext()), this.f18347b.getApkName()).getAbsolutePath());
        }
    }

    public final void a(Context context, PackageInfo packageInfo, String str) {
        b0.a((BaseAdUnit) null, PointCategory.APP_INSTALL_MONITOR, packageInfo, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0055 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0004, B:10:0x002f, B:12:0x0039, B:14:0x0043, B:16:0x0047, B:17:0x004f, B:19:0x0055, B:21:0x0079, B:23:0x007d, B:26:0x008b, B:29:0x0095, B:32:0x00b3, B:47:0x0100, B:49:0x0108, B:50:0x0120, B:53:0x015a, B:55:0x0162, B:56:0x0175, B:57:0x0191, B:60:0x017b, B:61:0x0195, B:63:0x019d, B:66:0x01b6, B:68:0x01be, B:69:0x00cd, B:72:0x00d7, B:75:0x00e1, B:78:0x00e9), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0094 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0095 A[Catch: all -> 0x004b, TRY_LEAVE, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0004, B:10:0x002f, B:12:0x0039, B:14:0x0043, B:16:0x0047, B:17:0x004f, B:19:0x0055, B:21:0x0079, B:23:0x007d, B:26:0x008b, B:29:0x0095, B:32:0x00b3, B:47:0x0100, B:49:0x0108, B:50:0x0120, B:53:0x015a, B:55:0x0162, B:56:0x0175, B:57:0x0191, B:60:0x017b, B:61:0x0195, B:63:0x019d, B:66:0x01b6, B:68:0x01be, B:69:0x00cd, B:72:0x00d7, B:75:0x00e1, B:78:0x00e9), top: B:2:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01b6 A[Catch: all -> 0x004b, TryCatch #2 {all -> 0x004b, blocks: (B:3:0x0004, B:10:0x002f, B:12:0x0039, B:14:0x0043, B:16:0x0047, B:17:0x004f, B:19:0x0055, B:21:0x0079, B:23:0x007d, B:26:0x008b, B:29:0x0095, B:32:0x00b3, B:47:0x0100, B:49:0x0108, B:50:0x0120, B:53:0x015a, B:55:0x0162, B:56:0x0175, B:57:0x0191, B:60:0x017b, B:61:0x0195, B:63:0x019d, B:66:0x01b6, B:68:0x01be, B:69:0x00cd, B:72:0x00d7, B:75:0x00e1, B:78:0x00e9), top: B:2:0x0004 }] */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            Method dump skipped, instructions count: 476
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sigmob.sdk.base.services.a.onReceive(android.content.Context, android.content.Intent):void");
    }

    public final void a(Context context, BaseAdUnit baseAdUnit, PackageInfo packageInfo) {
        com.sigmob.sdk.base.network.f.a(baseAdUnit, com.sigmob.sdk.base.common.a.J);
        b0.a(baseAdUnit, PointCategory.APP_INSTALL_END, packageInfo, "1");
        HashMap hashMap = new HashMap();
        hashMap.put(p3.i.f29758c, "1");
        BaseBroadcastReceiver.a(context, baseAdUnit.getUuid(), hashMap, IntentActions.ACTION_INTERSTITIAL_INSTALL_END);
        baseAdUnit.setApkPackageName(packageInfo.packageName);
        ThreadPoolFactory.BackgroundThreadPool.getInstance().submit(new RunnableC0575a(context, baseAdUnit));
        TextUtils.isEmpty(baseAdUnit.getDeeplinkUrl());
    }
}
