package com.umeng.commonsdk.framework;

import android.content.ContentValues;
import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.bx;
import com.umeng.analytics.pro.k;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.statistics.UMServerURL;
import com.umeng.commonsdk.statistics.b;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class UMEnvelopeBuild {
    public static boolean transmissionSendFlag = false;

    private static JSONObject add2CacheTable(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        if (jSONObject == null || jSONObject2 == null) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]构建信封传入 header 或 body 字段为空，直接返回");
            return null;
        }
        k a10 = k.a(context);
        long currentTimeMillis = System.currentTimeMillis();
        UUID randomUUID = UUID.randomUUID();
        ContentValues contentValues = new ContentValues();
        contentValues.put(bx.f23687e, str2);
        contentValues.put(bx.f23688f, a10.c(jSONObject.toString()));
        contentValues.put(bx.f23689g, a10.c(jSONObject2.toString()));
        contentValues.put(bx.f23690h, String.valueOf(currentTimeMillis));
        contentValues.put(bx.f23691i, randomUUID.toString());
        contentValues.put(bx.f23692j, str);
        contentValues.put(bx.f23693k, str3);
        bv.a(context).a(bx.f23685c, contentValues);
        if ("i".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]inner业务，返回空 JSONObject。");
        } else if ("s".equalsIgnoreCase(str2)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]分享业务 返回body。");
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("header", new JSONObject());
                jSONObject3.put("share", jSONObject2.getJSONObject("share"));
                return jSONObject3;
            } catch (JSONException unused) {
            }
        } else if (!"p".equalsIgnoreCase(str2)) {
            try {
                if (bt.aO.equalsIgnoreCase(str2)) {
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 半开报文，返回body。");
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.put(b.a("header"), new JSONObject());
                    jSONObject4.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                    return jSONObject4;
                }
                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]统计业务 闭合报文，返回body。");
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put(b.a("header"), new JSONObject());
                jSONObject5.put(b.a("analytics"), jSONObject2.getJSONObject("analytics"));
                return jSONObject5;
            } catch (JSONException unused2) {
                return jSONObject2;
            }
        }
        return new JSONObject();
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2) {
        return buildEnvelopeWithExtHeader(context, jSONObject, jSONObject2, UMServerURL.PATH_ANALYTICS, jSONObject.has("st") ? bt.aO : jSONObject2.has(bt.aA) ? "i" : "a", "9.7.9");
    }

    public static JSONObject buildSilentEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        JSONObject jSONObject3;
        if (UMUtils.isMainProgress(context)) {
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        JSONObject jSONObject4 = null;
        try {
            jSONObject3 = new JSONObject();
        } catch (JSONException unused) {
        }
        try {
            jSONObject3.put("exception", 120);
            return jSONObject3;
        } catch (JSONException unused2) {
            jSONObject4 = jSONObject3;
            return jSONObject4;
        }
    }

    public static JSONObject buildZeroEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str) {
        JSONObject jSONObject3;
        if (UMUtils.isMainProgress(context)) {
            return new b().b(context.getApplicationContext(), jSONObject, jSONObject2, str);
        }
        JSONObject jSONObject4 = null;
        try {
            jSONObject3 = new JSONObject();
        } catch (JSONException unused) {
        }
        try {
            jSONObject3.put("exception", 120);
            return jSONObject3;
        } catch (JSONException unused2) {
            jSONObject4 = jSONObject3;
            return jSONObject4;
        }
    }

    public static long getLastInstantBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastInstantBuildTime(context.getApplicationContext());
    }

    public static long getLastSuccessfulBuildTime(Context context) {
        if (context == null) {
            return 0L;
        }
        return UMFrUtils.getLastSuccessfulBuildTime(context.getApplicationContext());
    }

    public static synchronized boolean getTransmissionSendFlag() {
        boolean z10;
        synchronized (UMEnvelopeBuild.class) {
            z10 = transmissionSendFlag;
        }
        return z10;
    }

    public static String imprintProperty(Context context, String str, String str2) {
        return context == null ? str2 : ImprintHandler.getImprintService(context.getApplicationContext()).c().a(str, str2);
    }

    public static boolean isOnline(Context context) {
        return UMFrUtils.isOnline(context) && (UMConfigure.needSendZcfgEnv(context) ^ true);
    }

    public static boolean isReadyBuild(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        a.a(context);
        return isRet(context, uMBusinessType, false);
    }

    public static boolean isReadyBuildNew(Context context, UMLogDataProtocol.UMBusinessType uMBusinessType) {
        if (getTransmissionSendFlag()) {
            return isRet(context, uMBusinessType, false);
        }
        return false;
    }

    public static boolean isReadyBuildStateless() {
        return getTransmissionSendFlag();
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0039, code lost:
    
        if (com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5) == false) goto L56;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
    
        if (com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6) != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x001e, code lost:
    
        r7 = true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isRet(android.content.Context r5, com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType r6, boolean r7) {
        /*
            if (r5 == 0) goto L43
            android.content.Context r0 = r5.getApplicationContext()
            boolean r1 = com.umeng.commonsdk.framework.UMFrUtils.isOnline(r0)
            int r2 = com.umeng.commonsdk.framework.UMFrUtils.envelopeFileNumber(r0)
            if (r1 == 0) goto L3c
            com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType r7 = com.umeng.commonsdk.framework.UMLogDataProtocol.UMBusinessType.U_INTERNAL
            r3 = 1
            r4 = 0
            if (r6 != r7) goto L20
            boolean r5 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r5 == 0) goto L1e
        L1c:
            r7 = 0
            goto L3c
        L1e:
            r7 = 1
            goto L3c
        L20:
            boolean r7 = com.umeng.commonsdk.framework.a.a()
            if (r7 == 0) goto L2f
            int r5 = com.umeng.commonsdk.framework.a.b()
            long r5 = (long) r5
            com.umeng.commonsdk.framework.UMWorkDispatch.sendDelayProcessMsg(r5)
            goto L1c
        L2f:
            boolean r6 = com.umeng.commonsdk.framework.UMFrUtils.hasEnvelopeFile(r0, r6)
            if (r6 != 0) goto L1c
            boolean r5 = com.umeng.commonsdk.UMConfigure.needSendZcfgEnv(r5)
            if (r5 == 0) goto L1e
            goto L1c
        L3c:
            if (r1 == 0) goto L43
            if (r2 <= 0) goto L43
            com.umeng.commonsdk.framework.a.d()
        L43:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.commonsdk.framework.UMEnvelopeBuild.isRet(android.content.Context, com.umeng.commonsdk.framework.UMLogDataProtocol$UMBusinessType, boolean):boolean");
    }

    public static long maxDataSpace(Context context) {
        if (context == null) {
            return 0L;
        }
        return b.a(context.getApplicationContext());
    }

    public static void registerNetReceiver(Context context) {
        a.b(context);
    }

    public static void sendProcessNextMsgOnce() {
        a.d();
    }

    public static synchronized void setTransmissionSendFlag(boolean z10) {
        synchronized (UMEnvelopeBuild.class) {
            transmissionSendFlag = z10;
        }
    }

    public static JSONObject buildEnvelopeWithExtHeader(Context context, JSONObject jSONObject, JSONObject jSONObject2, String str, String str2, String str3) {
        JSONObject jSONObject3;
        JSONObject jSONObject4;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]业务发起构建普通有状态信封请求。");
        JSONObject jSONObject5 = null;
        if (TextUtils.isEmpty(str)) {
            try {
                jSONObject3 = new JSONObject();
            } catch (JSONException unused) {
            }
            try {
                jSONObject3.put("exception", 121);
                return jSONObject3;
            } catch (JSONException unused2) {
                jSONObject5 = jSONObject3;
                return jSONObject5;
            }
        }
        if (!UMUtils.isMainProgress(context)) {
            try {
                jSONObject4 = new JSONObject();
            } catch (JSONException unused3) {
            }
            try {
                jSONObject4.put("exception", 120);
                return jSONObject4;
            } catch (JSONException unused4) {
                jSONObject5 = jSONObject4;
                return jSONObject5;
            }
        }
        if (UMConfigure.needSendZcfgEnv(context)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 未获取到，写入二级缓存");
            return add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]零号报文应答数据 已获取到，判断二级缓存是否为空");
        if (bv.a(context).c()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存为空，直接打信封");
            return new b().a(context.getApplicationContext(), jSONObject, jSONObject2, str, str2, str3);
        }
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> [有状态]二级缓存不为空，写入二级缓存");
        JSONObject add2CacheTable = add2CacheTable(context, jSONObject, jSONObject2, str, str2, str3);
        if (!UMWorkDispatch.eventHasExist(com.umeng.commonsdk.internal.a.f24484t)) {
            UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24484t, com.umeng.commonsdk.internal.b.a(context).a(), null);
        }
        return add2CacheTable;
    }
}
