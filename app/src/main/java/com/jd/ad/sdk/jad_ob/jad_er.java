package com.jd.ad.sdk.jad_ob;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.jd.ad.sdk.bl.initsdk.JADYunSdk;
import com.jd.ad.sdk.fdt.thread.WorkExecutor;
import com.jd.ad.sdk.fdt.utils.ActLifecycle;
import com.jd.ad.sdk.fdt.utils.HandlerUtils;
import com.jd.ad.sdk.fdt.utils.UUIDUtils;
import com.jd.ad.sdk.jad_qd.jad_cp;
import com.jd.ad.sdk.jad_uh.jad_an;
import com.jd.ad.sdk.jad_zm.jad_ly;
import com.jd.ad.sdk.logger.Logger;
import com.kwad.components.offline.api.explore.model.ExploreConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class jad_er {
    public static final Handler jad_an = new Handler(Looper.getMainLooper());
    public static jad_hu jad_bo;

    public class jad_an implements Runnable {
        public final /* synthetic */ String jad_an;

        public jad_an(String str) {
            this.jad_an = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            String uuid = UUIDUtils.uuid();
            try {
                com.jd.ad.sdk.jad_ob.jad_cp.jad_an(new jad_cp(this.jad_an, uuid), uuid);
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(uuid);
            } catch (Exception e10) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an(uuid, 2, jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()), 0);
            }
        }
    }

    public static class jad_bo implements ActLifecycle.jad_an {
        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_an() {
            try {
                Logger.d("InitImp onChangeToForeground hotRequestConfig");
                com.jd.ad.sdk.jad_vi.jad_an.jad_bo = false;
                if (com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
                    return;
                }
                jad_er.jad_an(JADYunSdk.getAppId());
            } catch (Exception e10) {
                com.jd.ad.sdk.jad_wj.jad_an jad_anVar = com.jd.ad.sdk.jad_wj.jad_an.AN_REQUEST_OTHER_ERROR;
                com.jd.ad.sdk.jad_xk.jad_fs.jad_an("", jad_anVar.jad_an, jad_anVar.jad_an(e10.getMessage()));
            }
        }

        @Override // com.jd.ad.sdk.fdt.utils.ActLifecycle.jad_an
        public void jad_bo() {
            com.jd.ad.sdk.jad_vi.jad_an.jad_bo = true;
            com.jd.ad.sdk.jad_ob.jad_bo.jad_bo = false;
        }
    }

    public static void jad_an(String str, com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar) {
        try {
            com.jd.ad.sdk.jad_uh.jad_an jad_anVar = jad_an.jad_bo.jad_an;
            String jSONObject = jad_cpVar.jad_an().toString();
            jad_anVar.getClass();
            if (!TextUtils.isEmpty("Config")) {
                jad_anVar.jad_an("Config" + JADYunSdk.getAppId(), jSONObject);
            }
            Long valueOf = Long.valueOf(System.currentTimeMillis());
            if (!TextUtils.isEmpty("cat")) {
                jad_anVar.jad_an("cat" + JADYunSdk.getAppId(), valueOf);
            }
            jad_jt.jad_an();
            List<com.jd.ad.sdk.jad_pc.jad_er> list = jad_cpVar.jad_jt;
            for (int i10 = 0; i10 < list.size(); i10++) {
                com.jd.ad.sdk.jad_pc.jad_er jad_erVar = list.get(i10);
                int i11 = jad_erVar.jad_bo;
                String str2 = i11 == 1 ? ExploreConstants.SCENE_SPLASH : i11 == 2 ? ExploreConstants.SCENE_FEED : i11 == 4 ? ExploreConstants.SCENE_INTERSTITIAL : "Banner";
                if (jad_erVar.jad_er != 4) {
                    Logger.i(str2 + " 广告位 " + jad_erVar.jad_an + " 为线上状态", new Object[0]);
                } else {
                    Logger.w(str2 + " 广告位 " + jad_erVar.jad_an + " 为测试状态", new Object[0]);
                }
            }
            jad_an(jad_cpVar);
        } catch (Exception e10) {
            com.jd.ad.sdk.jad_wj.jad_an jad_anVar2 = com.jd.ad.sdk.jad_wj.jad_an.AN_RESPONSE_DATA_PROCESS_ERROR;
            com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, jad_anVar2.jad_an, jad_anVar2.jad_an(e10.getMessage()));
        }
    }

    public static void jad_an(String str) {
        AtomicInteger atomicInteger = com.jd.ad.sdk.jad_ob.jad_bo.jad_an;
        if (Math.abs(System.currentTimeMillis() - com.jd.ad.sdk.jad_ob.jad_bo.jad_cp) > 30000) {
            com.jd.ad.sdk.jad_ob.jad_bo.jad_cp = System.currentTimeMillis();
            WorkExecutor.execute(new jad_an(str));
        }
    }

    public static void jad_an(com.jd.ad.sdk.jad_pc.jad_cp jad_cpVar) {
        try {
            ArrayList arrayList = new ArrayList();
            com.jd.ad.sdk.jad_pc.jad_an jad_anVar = jad_cpVar.jad_iv;
            if (jad_anVar != null) {
                String str = jad_anVar.jad_qd;
                if (!TextUtils.isEmpty(str)) {
                    arrayList.addAll(Arrays.asList(str.split(",")));
                }
                com.jd.ad.sdk.jad_qd.jad_cp jad_cpVar2 = jad_cp.jad_an.jad_an;
                jad_cpVar2.jad_iv.clear();
                if (arrayList.size() > 0) {
                    jad_cpVar2.jad_iv.addAll(arrayList);
                }
            }
        } catch (Exception unused) {
        }
    }

    public static void jad_an(String str, int i10, String str2, String str3) {
        AtomicInteger atomicInteger = com.jd.ad.sdk.jad_ob.jad_bo.jad_an;
        if (atomicInteger.get() < 10) {
            atomicInteger.incrementAndGet();
        }
        Logger.d("retry time: " + atomicInteger);
        if (atomicInteger.get() < 3 && com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
            jad_an.postDelayed(new jad_fs(str2), 30000L);
        }
        com.jd.ad.sdk.jad_xk.jad_fs.jad_an(str, 2, i10, str3, 0);
    }

    public static class jad_cp implements jad_ly.jad_an {
        public final String jad_an;
        public String jad_bo;
        public final long jad_cp = System.currentTimeMillis();

        public jad_cp(String str, String str2) {
            this.jad_an = str;
            this.jad_bo = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:118:0x0093 A[Catch: Exception -> 0x0031, TRY_LEAVE, TryCatch #7 {Exception -> 0x0031, blocks: (B:3:0x000c, B:120:0x001a, B:6:0x003a, B:9:0x006d, B:118:0x0093, B:123:0x0035), top: B:2:0x000c, inners: #8 }] */
        /* JADX WARN: Removed duplicated region for block: B:13:0x00d5 A[Catch: all -> 0x00de, Exception -> 0x00e1, IOException -> 0x00e4, JSONException -> 0x00e7, TryCatch #14 {Exception -> 0x00e1, blocks: (B:11:0x00cf, B:13:0x00d5, B:15:0x00d9, B:16:0x00eb, B:26:0x0115, B:28:0x0119, B:36:0x014b, B:38:0x0155, B:46:0x0187, B:48:0x0191, B:56:0x01c3, B:58:0x01f6, B:60:0x0205, B:61:0x020a, B:71:0x0211, B:72:0x0215), top: B:10:0x00cf, outer: #13 }] */
        /* JADX WARN: Removed duplicated region for block: B:26:0x0115 A[Catch: all -> 0x00de, Exception -> 0x00e1, IOException -> 0x00e4, JSONException -> 0x00e7, TRY_ENTER, TryCatch #14 {Exception -> 0x00e1, blocks: (B:11:0x00cf, B:13:0x00d5, B:15:0x00d9, B:16:0x00eb, B:26:0x0115, B:28:0x0119, B:36:0x014b, B:38:0x0155, B:46:0x0187, B:48:0x0191, B:56:0x01c3, B:58:0x01f6, B:60:0x0205, B:61:0x020a, B:71:0x0211, B:72:0x0215), top: B:10:0x00cf, outer: #13 }] */
        /* JADX WARN: Removed duplicated region for block: B:9:0x006d A[Catch: Exception -> 0x0031, TRY_ENTER, TryCatch #7 {Exception -> 0x0031, blocks: (B:3:0x000c, B:120:0x001a, B:6:0x003a, B:9:0x006d, B:118:0x0093, B:123:0x0035), top: B:2:0x000c, inners: #8 }] */
        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void jad_an(com.jd.ad.sdk.jad_zm.jad_mz r15) {
            /*
                Method dump skipped, instructions count: 778
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jd.ad.sdk.jad_ob.jad_er.jad_cp.jad_an(com.jd.ad.sdk.jad_zm.jad_mz):void");
        }

        public final void jad_an(boolean z10, int i10, String str) {
            JADYunSdk.jad_er jad_erVar = JADYunSdk.mInnerInitCallBack;
            if (jad_erVar != null) {
                boolean unused = JADYunSdk.isInitSuccess = z10;
                if (com.jd.ad.sdk.jad_ob.jad_bo.jad_an.get() == 0 && com.jd.ad.sdk.jad_ob.jad_bo.jad_bo) {
                    if (z10) {
                        JADYunSdk.jad_cp jad_cpVar = (JADYunSdk.jad_cp) JADYunSdk.mInnerInitCallBack;
                        jad_cpVar.getClass();
                        HandlerUtils.runOnUiThread(new com.jd.ad.sdk.bl.initsdk.jad_an(jad_cpVar));
                    } else {
                        if (TextUtils.isEmpty(str)) {
                            str = "sdk init error";
                        }
                        JADYunSdk.jad_cp jad_cpVar2 = (JADYunSdk.jad_cp) JADYunSdk.mInnerInitCallBack;
                        jad_cpVar2.getClass();
                        HandlerUtils.runOnUiThread(new com.jd.ad.sdk.bl.initsdk.jad_bo(jad_cpVar2, i10, str));
                    }
                }
            }
        }

        @Override // com.jd.ad.sdk.jad_zm.jad_ly.jad_an
        public void jad_an(int i10, String str) {
            jad_er.jad_an(this.jad_bo, i10, this.jad_an, str);
            jad_an(false, i10, str);
        }
    }
}
