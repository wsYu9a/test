package cn.vlion.ad.inland.base;

import android.os.HandlerThread;
import android.text.TextUtils;
import cn.vlion.ad.inland.base.javabean.VlionADNetBodyParameter;
import cn.vlion.ad.inland.base.javabean.VlionServiceConfigParse;
import cn.vlion.ad.inland.base.network.ok.HttpRequestUtil;
import cn.vlion.ad.inland.base.util.VlionAESUtils;
import cn.vlion.ad.inland.base.util.event.VlionADEventManager;
import cn.vlion.ad.inland.base.util.init.VlionSDkManager;
import cn.vlion.ad.inland.base.util.log.LogVlion;
import cn.vlion.ad.inland.base.util.nettype.NetWorkTypeUtil;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class f6 extends HandlerThread {

    /* renamed from: a */
    public static volatile e6 f2802a;

    public f6() {
        super("vlionEventHandlerThread");
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x003d A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x005f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0060 A[Catch: all -> 0x0070, TryCatch #0 {all -> 0x0070, blocks: (B:2:0x0000, B:3:0x001c, B:9:0x002f, B:29:0x005b, B:32:0x0060, B:34:0x006a, B:36:0x0072, B:39:0x0054, B:45:0x007a, B:46:0x007b, B:11:0x0030, B:13:0x0034, B:16:0x003c, B:27:0x0052, B:5:0x001d, B:7:0x0023, B:42:0x0028), top: B:1:0x0000, inners: #1, #2, #3 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void a(java.lang.String r4, int r5, int r6) {
        /*
            r3 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L70
            r0.<init>()     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = "VlionSendMessageThread sendData:eventType="
            r0.append(r1)     // Catch: java.lang.Throwable -> L70
            r0.append(r5)     // Catch: java.lang.Throwable -> L70
            java.lang.String r1 = " delayMs="
            r0.append(r1)     // Catch: java.lang.Throwable -> L70
            r0.append(r6)     // Catch: java.lang.Throwable -> L70
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> L70
            cn.vlion.ad.inland.base.util.log.LogVlion.e(r0)     // Catch: java.lang.Throwable -> L70
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L70
            boolean r0 = r3.isAlive()     // Catch: java.lang.Throwable -> L27
            if (r0 != 0) goto L2f
            r3.start()     // Catch: java.lang.Throwable -> L27
            goto L2f
        L27:
            r0 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L79
            r1.upLoadCatchException(r0)     // Catch: java.lang.Throwable -> L79
        L2f:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
            cn.vlion.ad.inland.base.e6 r0 = cn.vlion.ad.inland.base.f6.f2802a     // Catch: java.lang.Throwable -> L53
            if (r0 != 0) goto L5b
            android.os.Looper r0 = r3.getLooper()     // Catch: java.lang.Throwable -> L53
            if (r0 == 0) goto L5b
            java.lang.Class<cn.vlion.ad.inland.base.f6> r0 = cn.vlion.ad.inland.base.f6.class
            monitor-enter(r0)     // Catch: java.lang.Throwable -> L53
            cn.vlion.ad.inland.base.e6 r1 = cn.vlion.ad.inland.base.f6.f2802a     // Catch: java.lang.Throwable -> L4d
            if (r1 != 0) goto L4f
            cn.vlion.ad.inland.base.e6 r1 = new cn.vlion.ad.inland.base.e6     // Catch: java.lang.Throwable -> L4d
            android.os.Looper r2 = r3.getLooper()     // Catch: java.lang.Throwable -> L4d
            r1.<init>(r3, r2)     // Catch: java.lang.Throwable -> L4d
            cn.vlion.ad.inland.base.f6.f2802a = r1     // Catch: java.lang.Throwable -> L4d
            goto L4f
        L4d:
            r1 = move-exception
            goto L51
        L4f:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
            goto L5b
        L51:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4d
            throw r1     // Catch: java.lang.Throwable -> L53
        L53:
            r0 = move-exception
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r1 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()     // Catch: java.lang.Throwable -> L70
            r1.upLoadCatchException(r0)     // Catch: java.lang.Throwable -> L70
        L5b:
            cn.vlion.ad.inland.base.e6 r0 = cn.vlion.ad.inland.base.f6.f2802a     // Catch: java.lang.Throwable -> L70
            if (r0 != 0) goto L60
            return
        L60:
            android.os.Message r0 = android.os.Message.obtain()     // Catch: java.lang.Throwable -> L70
            r0.what = r5     // Catch: java.lang.Throwable -> L70
            r0.obj = r4     // Catch: java.lang.Throwable -> L70
            if (r6 > 0) goto L72
            cn.vlion.ad.inland.base.e6 r4 = cn.vlion.ad.inland.base.f6.f2802a     // Catch: java.lang.Throwable -> L70
            r4.sendMessage(r0)     // Catch: java.lang.Throwable -> L70
            goto L83
        L70:
            r4 = move-exception
            goto L7c
        L72:
            cn.vlion.ad.inland.base.e6 r4 = cn.vlion.ad.inland.base.f6.f2802a     // Catch: java.lang.Throwable -> L70
            long r5 = (long) r6     // Catch: java.lang.Throwable -> L70
            r4.sendMessageDelayed(r0, r5)     // Catch: java.lang.Throwable -> L70
            goto L83
        L79:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L70
            throw r4     // Catch: java.lang.Throwable -> L70
        L7c:
            cn.vlion.ad.inland.base.util.init.VlionSDkManager r5 = cn.vlion.ad.inland.base.util.init.VlionSDkManager.getInstance()
            r5.upLoadCatchException(r4)
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.vlion.ad.inland.base.f6.a(java.lang.String, int, int):void");
    }

    public static JSONObject a(String str) {
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str) || "null".equals(str)) {
            return jSONObject;
        }
        try {
            return new JSONObject(str);
        } catch (JSONException e10) {
            StringBuilder a10 = l1.a("VlionSendMessageThread toJSONObject=");
            a10.append(e10.getMessage());
            LogVlion.e(a10.toString());
            return jSONObject;
        } catch (Throwable th2) {
            VlionSDkManager.getInstance().upLoadCatchException(th2);
            return jSONObject;
        }
    }

    public final void a(int i10, String str) {
        ArrayList arrayList;
        try {
            String reportUrl = VlionServiceConfigParse.getInstance().getReportUrl();
            if (TextUtils.isEmpty(reportUrl)) {
                LogVlion.e("VlionSendMessageThread 上报地址url为空！");
                return;
            }
            if (!NetWorkTypeUtil.f3414a) {
                LogVlion.e("VlionSendMessageThread 发送数据没有网络");
                return;
            }
            try {
                LogVlion.e("VlionSendMessageThread msgWhat=" + i10);
                ArrayList b10 = o0.a().b();
                if (b10.size() > 0) {
                    LogVlion.e("VlionSendMessageThread adxEvents adxEvents.size()=" + b10.size());
                    for (int i11 = 0; i11 < b10.size(); i11++) {
                        l0 l0Var = (l0) b10.get(i11);
                        if (l0Var != null) {
                            long j10 = l0Var.f3061e;
                            long abs = Math.abs(System.currentTimeMillis() - j10) / 1000;
                            long adxExpireTime = VlionServiceConfigParse.getInstance().getAdxExpireTime();
                            boolean isEmpty = TextUtils.isEmpty(l0Var.f3058b);
                            LogVlion.e("VlionSendMessageThread adxEvents isEmpty" + isEmpty + " eventTime=" + j10 + " interval=" + abs + " adxExpireTime=" + adxExpireTime);
                            if (!isEmpty && (j10 <= 0 || adxExpireTime <= 0 || abs <= adxExpireTime)) {
                                LogVlion.e("VlionSendMessageThread adxEvents upload" + i11);
                                VlionADNetBodyParameter submitBehaviorRetry = HttpRequestUtil.submitBehaviorRetry((l0) b10.get(i11));
                                if (submitBehaviorRetry != null) {
                                    u4.a().a(VlionADEventManager.getNetEvent(submitBehaviorRetry));
                                    if ("1".equals(submitBehaviorRetry.getApi_status())) {
                                        o0.a().b(l0Var);
                                    }
                                }
                            }
                            o0.a().b(l0Var);
                            LogVlion.e("VlionSendMessageThread adxEvents Expire" + l0Var.f3058b);
                        }
                    }
                }
                if (i10 == 2) {
                    u4 a10 = u4.a();
                    synchronized (a10) {
                        arrayList = a10.a("");
                    }
                    try {
                        LogVlion.e("VlionSendMessageThread events events.size()=" + arrayList.size());
                        if (arrayList.size() == 0 && b10.size() == 0) {
                            LogVlion.e("VlionSendMessageThread 数据为空定时关闭");
                            p6 a11 = p6.a();
                            synchronized (a11) {
                                try {
                                    LogVlion.e("VlionTimerManager destroyTimer");
                                    if (a11.f3296a != null && !a11.f3296a.isShutdown()) {
                                        a11.f3296a.shutdown();
                                    }
                                } finally {
                                    return;
                                }
                            }
                            return;
                        }
                    } catch (Exception e10) {
                        e = e10;
                        LogVlion.e("VlionSendMessageThread Exception=" + e);
                        e.printStackTrace();
                        if (arrayList != null) {
                        }
                        LogVlion.e("VlionSendMessageThread 数据为空");
                        return;
                    }
                } else {
                    LogVlion.e("VlionSendMessageThread eventsReal_time=");
                    arrayList = u4.a().a("100");
                }
            } catch (Exception e11) {
                e = e11;
                arrayList = null;
            }
            try {
                if (arrayList != null || arrayList.size() == 0) {
                    LogVlion.e("VlionSendMessageThread 数据为空");
                    return;
                }
                LogVlion.e("VlionSendMessageThread 数据数 " + arrayList.size() + "msgWhat=" + i10);
                JSONArray jSONArray = new JSONArray();
                for (int i12 = 0; i12 < arrayList.size(); i12++) {
                    try {
                        n0 n0Var = (n0) arrayList.get(i12);
                        if (n0Var != null) {
                            jSONArray.put(a(n0Var.f3109c));
                        }
                    } catch (Throwable th2) {
                        VlionSDkManager.getInstance().upLoadCatchException(th2);
                    }
                }
                String jSONArray2 = jSONArray.toString();
                LogVlion.e("VlionSendMessageThread 准备发送数据，sendData:" + jSONArray2);
                String str2 = "";
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(h3.e.f26408m, VlionAESUtils.encrypt(jSONArray2, HttpRequestUtil.KEY, HttpRequestUtil.IV));
                    str2 = jSONObject.toString();
                } catch (Throwable th3) {
                    VlionSDkManager.getInstance().upLoadCatchException(th3);
                    LogVlion.e("SendJsonAESData == 请求参数=====Exception=" + th3);
                }
                LogVlion.e("SendJsonAESData === 请求参数=====" + str2);
                LogVlion.e("VlionSendMessageThread 准备发送数据，加密数据 sendData:" + str2);
                boolean uploadAdEvent = HttpRequestUtil.uploadAdEvent(reportUrl, str2);
                LogVlion.e("VlionSendMessageThread isSuccess=" + uploadAdEvent);
                if (uploadAdEvent) {
                    try {
                        u4.a().a(arrayList);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                } else if ("retry".equals(str)) {
                    LogVlion.e("VlionSendMessageThread 失败了，等待下一次循环");
                } else {
                    LogVlion.e("VlionSendMessageThread 失败了，重新上报一次");
                    a("retry", i10, 3000);
                }
            } catch (Throwable th4) {
                th = th4;
                VlionSDkManager.getInstance().upLoadCatchException(th);
            }
        } catch (Throwable th5) {
            th = th5;
            VlionSDkManager.getInstance().upLoadCatchException(th);
        }
    }
}
