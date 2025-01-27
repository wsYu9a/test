package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ck;
import com.umeng.analytics.pro.cz;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.f;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: b */
    private static final int f24603b = 1;

    /* renamed from: c */
    private static final int f24604c = 2;

    /* renamed from: d */
    private static final int f24605d = 3;

    /* renamed from: o */
    private static final String f24606o = "thtstart";

    /* renamed from: p */
    private static final String f24607p = "gkvc";

    /* renamed from: q */
    private static final String f24608q = "ekvc";

    /* renamed from: a */
    String f24609a;

    /* renamed from: f */
    private com.umeng.commonsdk.statistics.internal.c f24611f;

    /* renamed from: g */
    private ImprintHandler f24612g;

    /* renamed from: h */
    private f f24613h;

    /* renamed from: i */
    private ImprintHandler.a f24614i;

    /* renamed from: k */
    private Defcon f24616k;

    /* renamed from: l */
    private long f24617l;

    /* renamed from: m */
    private int f24618m;

    /* renamed from: n */
    private int f24619n;

    /* renamed from: r */
    private Context f24620r;

    /* renamed from: e */
    private final int f24610e = 1;

    /* renamed from: j */
    private ABTest f24615j = null;

    /* renamed from: com.umeng.commonsdk.statistics.c$1 */
    public class AnonymousClass1 implements d {
        public AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.d
        public void onImprintChanged(ImprintHandler.a aVar) {
            c.this.f24616k.onImprintChanged(aVar);
            c cVar = c.this;
            cVar.f24609a = UMEnvelopeBuild.imprintProperty(cVar.f24620r, "track_list", null);
        }
    }

    public c(Context context) {
        this.f24613h = null;
        this.f24614i = null;
        this.f24616k = null;
        this.f24617l = 0L;
        this.f24618m = 0;
        this.f24619n = 0;
        this.f24609a = null;
        this.f24620r = context;
        this.f24614i = ImprintHandler.getImprintService(context).c();
        this.f24616k = Defcon.getService(this.f24620r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f24620r);
        this.f24617l = sharedPreferences.getLong(f24606o, 0L);
        this.f24618m = sharedPreferences.getInt(f24607p, 0);
        this.f24619n = sharedPreferences.getInt(f24608q, 0);
        this.f24609a = UMEnvelopeBuild.imprintProperty(this.f24620r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.f24620r);
        this.f24612g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            public AnonymousClass1() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f24616k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f24609a = UMEnvelopeBuild.imprintProperty(cVar.f24620r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f24620r)) {
            this.f24613h = f.a(this.f24620r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.f24620r);
        this.f24611f = cVar;
        cVar.a(StatTracer.getInstance(this.f24620r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a a10 = com.umeng.commonsdk.statistics.internal.a.a(this.f24620r);
            a10.e(name);
            boolean a11 = a10.a(name);
            boolean b10 = a10.b(name);
            boolean c10 = a10.c(name);
            boolean d10 = a10.d(name);
            String d11 = com.umeng.commonsdk.stateless.d.d(name);
            byte[] a12 = this.f24611f.a(byteArray, a11, c10, !TextUtils.isEmpty(d11) ? com.umeng.commonsdk.stateless.d.c(d11) : d10 ? UMServerURL.SILENT_HEART_BEAT : c10 ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int a13 = a12 == null ? 1 : a(a12);
            if (UMConfigure.isDebugLog()) {
                if (d10 && a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c10 && a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b10 && a13 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a11 && a13 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a13 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a13 == 2) {
                f fVar = this.f24613h;
                if (fVar != null) {
                    fVar.e();
                }
                StatTracer.getInstance(this.f24620r).saveSate();
                if (d10) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f24620r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.f24620r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.f24620r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.f24620r);
                        }
                    }
                }
            } else if (a13 == 3) {
                StatTracer.getInstance(this.f24620r).saveSate();
                if (c10) {
                    FieldManager.a().a(this.f24620r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.f24620r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.f24483s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a13 == 2;
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(this.f24620r, th2);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ck(new cz.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f24612g.b(response.getImprint());
                this.f24612g.d();
            }
        } catch (Throwable th2) {
            UMCrashManager.reportCrash(this.f24620r, th2);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
