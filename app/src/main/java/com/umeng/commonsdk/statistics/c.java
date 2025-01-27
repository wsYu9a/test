package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.ay;
import com.umeng.analytics.pro.bn;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
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
    private static final int f26289b = 1;

    /* renamed from: c */
    private static final int f26290c = 2;

    /* renamed from: d */
    private static final int f26291d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";

    /* renamed from: a */
    String f26292a;

    /* renamed from: f */
    private com.umeng.commonsdk.statistics.internal.c f26294f;

    /* renamed from: g */
    private ImprintHandler f26295g;

    /* renamed from: h */
    private e f26296h;

    /* renamed from: i */
    private ImprintHandler.a f26297i;
    private Defcon k;
    private long l;
    private int m;
    private int n;
    private Context r;

    /* renamed from: e */
    private final int f26293e = 1;

    /* renamed from: j */
    private ABTest f26298j = null;

    /* renamed from: com.umeng.commonsdk.statistics.c$1 */
    class AnonymousClass1 implements d {
        AnonymousClass1() {
        }

        @Override // com.umeng.commonsdk.statistics.internal.d
        public void onImprintChanged(ImprintHandler.a aVar) {
            c.this.k.onImprintChanged(aVar);
            c cVar = c.this;
            cVar.f26292a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
        }
    }

    public c(Context context) {
        this.f26296h = null;
        this.f26297i = null;
        this.k = null;
        this.l = 0L;
        this.m = 0;
        this.n = 0;
        this.f26292a = null;
        this.r = context;
        this.f26297i = ImprintHandler.getImprintService(context).c();
        this.k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.l = sharedPreferences.getLong(o, 0L);
        this.m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.f26292a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        ImprintHandler imprintService = ImprintHandler.getImprintService(this.r);
        this.f26295g = imprintService;
        imprintService.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            AnonymousClass1() {
            }

            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f26292a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.f26296h = e.a(this.r);
        }
        com.umeng.commonsdk.statistics.internal.c cVar = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f26294f = cVar;
        cVar.a(StatTracer.getInstance(this.r));
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
            com.umeng.commonsdk.statistics.internal.a a2 = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            a2.e(name);
            boolean a3 = a2.a(name);
            boolean b2 = a2.b(name);
            boolean c2 = a2.c(name);
            boolean d2 = a2.d(name);
            String d3 = com.umeng.commonsdk.stateless.d.d(name);
            byte[] a4 = this.f26294f.a(byteArray, a3, c2, !TextUtils.isEmpty(d3) ? com.umeng.commonsdk.stateless.d.c(d3) : d2 ? UMServerURL.SILENT_HEART_BEAT : c2 ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int a5 = a4 == null ? 1 : a(a4);
            if (UMConfigure.isDebugLog()) {
                if (d2 && a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c2 && a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b2 && a5 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a3 && a5 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a5 == 2) {
                e eVar = this.f26296h;
                if (eVar != null) {
                    eVar.e();
                }
                StatTracer.getInstance(this.r).saveSate();
                if (d2) {
                    String imprintProperty = UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                    if (!TextUtils.isEmpty(imprintProperty)) {
                        if ("1".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                            com.umeng.commonsdk.utils.c.a(this.r, System.currentTimeMillis());
                        } else if ("0".equalsIgnoreCase(imprintProperty)) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                            com.umeng.commonsdk.utils.c.a(this.r, 0L);
                            com.umeng.commonsdk.utils.c.d(this.r);
                        }
                    }
                }
            } else if (a5 == 3) {
                StatTracer.getInstance(this.r).saveSate();
                if (c2) {
                    FieldManager.a().a(this.r);
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                    Context context = this.r;
                    UMWorkDispatch.sendEvent(context, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(context).a(), null);
                    return true;
                }
            }
            return a5 == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new ay(new bn.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f26295g.b(response.getImprint());
                this.f26295g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
