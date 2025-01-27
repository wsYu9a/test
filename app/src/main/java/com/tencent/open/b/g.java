package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.martian.libmars.activity.PermissionActivity;
import com.shu.priory.config.AdKeys;
import com.sigmob.sdk.base.mta.PointCategory;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.umeng.analytics.pro.bt;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import kotlin.text.Typography;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.entity.ByteArrayEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    protected static g f23187a;

    /* renamed from: e */
    protected HandlerThread f23191e;

    /* renamed from: f */
    protected Handler f23192f;

    /* renamed from: b */
    protected Random f23188b = new Random();

    /* renamed from: d */
    protected List<Serializable> f23190d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    protected List<Serializable> f23189c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g */
    protected Executor f23193g = h.b();

    /* renamed from: h */
    protected Executor f23194h = h.b();

    /* renamed from: com.tencent.open.b.g$1 */
    public class AnonymousClass1 extends Handler {
        public AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i10 = message.what;
            if (i10 == 1000) {
                g.this.b();
            } else if (i10 == 1001) {
                g.this.e();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.tencent.open.b.g$2 */
    public class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f23196a;

        /* renamed from: b */
        final /* synthetic */ boolean f23197b;

        public AnonymousClass2(Bundle bundle, boolean z10) {
            bundle = bundle;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("uin", "1000");
                bundle.putString("imei", c.b(com.tencent.open.utils.d.a()));
                bundle.putString("imsi", c.c(com.tencent.open.utils.d.a()));
                bundle.putString("android_id", c.d(com.tencent.open.utils.d.a()));
                bundle.putString("mac", c.a());
                bundle.putString("platform", "1");
                bundle.putString("os_ver", Build.VERSION.RELEASE);
                bundle.putString(id.c.f26972i, i.d(com.tencent.open.utils.d.a()));
                bundle.putString(PointCategory.NETWORK, a.a(com.tencent.open.utils.d.a()));
                bundle.putString(bt.N, c.b());
                bundle.putString(bt.f23630z, c.a(com.tencent.open.utils.d.a()));
                bundle.putString("apn", a.b(com.tencent.open.utils.d.a()));
                bundle.putString("model_name", Build.MODEL);
                bundle.putString(bt.M, TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", Constants.SDK_VERSION);
                bundle.putString("qz_ver", i.d(com.tencent.open.utils.d.a(), Constants.PACKAGE_QZONE));
                bundle.putString("qq_ver", i.c(com.tencent.open.utils.d.a(), "com.tencent.mobileqq"));
                bundle.putString("qua", i.e(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                bundle.putString("packagename", com.tencent.open.utils.d.b());
                bundle.putString(AdKeys.APP_VER, i.d(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                g.this.f23190d.add(new b(bundle));
                int size = g.this.f23190d.size();
                int a10 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a10 == 0) {
                    a10 = 10000;
                }
                if (!g.this.a("report_via", size) && !z10) {
                    if (g.this.f23192f.hasMessages(1001)) {
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1001;
                    g.this.f23192f.sendMessageDelayed(obtain, a10);
                    return;
                }
                g.this.e();
                g.this.f23192f.removeMessages(1001);
            } catch (Exception e10) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e10);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$3 */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f23199a;

        /* renamed from: b */
        final /* synthetic */ String f23200b;

        /* renamed from: c */
        final /* synthetic */ String f23201c;

        /* renamed from: d */
        final /* synthetic */ int f23202d;

        /* renamed from: e */
        final /* synthetic */ long f23203e;

        /* renamed from: f */
        final /* synthetic */ long f23204f;

        /* renamed from: g */
        final /* synthetic */ boolean f23205g;

        public AnonymousClass3(long j10, String str, String str2, int i10, long j11, long j12, boolean z10) {
            j10 = j10;
            str = str;
            str2 = str2;
            i10 = i10;
            j11 = j11;
            j12 = j12;
            z10 = z10;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
                Bundle bundle = new Bundle();
                String a10 = a.a(com.tencent.open.utils.d.a());
                bundle.putString("apn", a10);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", str);
                bundle.putString("detail", str2);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("network=");
                sb2.append(a10);
                sb2.append(Typography.amp);
                sb2.append("sdcard=");
                int i10 = 1;
                sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb2.append(Typography.amp);
                sb2.append("wifi=");
                sb2.append(a.e(com.tencent.open.utils.d.a()));
                bundle.putString("deviceInfo", sb2.toString());
                int a11 = 100 / g.this.a(i10);
                if (a11 > 0) {
                    i10 = a11 > 100 ? 100 : a11;
                }
                bundle.putString("frequency", i10 + "");
                bundle.putString("reqSize", j11 + "");
                bundle.putString("resultCode", i10 + "");
                bundle.putString("rspSize", j12 + "");
                bundle.putString("timeCost", elapsedRealtime + "");
                bundle.putString("uin", "1000");
                g.this.f23189c.add(new b(bundle));
                int size = g.this.f23189c.size();
                int a12 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a12 == 0) {
                    a12 = 10000;
                }
                if (!g.this.a("report_cgi", size) && !z10) {
                    if (!g.this.f23192f.hasMessages(1000)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1000;
                        g.this.f23192f.sendMessageDelayed(obtain, a12);
                    }
                }
                g.this.b();
                g.this.f23192f.removeMessages(1000);
            } catch (Exception e10) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e10);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$4 */
    public class AnonymousClass4 implements Runnable {
        public AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle c10 = g.this.c();
                if (c10 == null) {
                    return;
                }
                int a10 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_HttpRetryCount");
                if (a10 == 0) {
                    a10 = 3;
                }
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + a10);
                int i10 = 0;
                do {
                    i10++;
                    try {
                        try {
                            HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.d.a(), null, "http://wspeed.qq.com/w.cgi");
                            HttpPost httpPost = new HttpPost("http://wspeed.qq.com/w.cgi");
                            httpPost.addHeader(m5.c.f28316j, "gzip");
                            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                            httpPost.setEntity(new ByteArrayEntity(i.i(HttpUtils.encodeUrl(c10))));
                            int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                            if (statusCode != 200) {
                                break;
                            }
                            f.a().b("report_cgi");
                            break;
                        } catch (SocketTimeoutException e10) {
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e10);
                        } catch (ConnectTimeoutException e11) {
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e11);
                        }
                    } catch (Exception e12) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e12);
                    }
                } while (i10 < a10);
                f.a().a("report_cgi", g.this.f23189c);
                g.this.f23189c.clear();
            } catch (Exception e13) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e13);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$5 */
    public class AnonymousClass5 implements Runnable {
        public AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i10;
            try {
                Bundle d10 = g.this.d();
                if (d10 == null) {
                    return;
                }
                com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d10.toString());
                int a10 = e.a();
                int i11 = 0;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean z10 = false;
                int i12 = 0;
                long j10 = 0;
                long j11 = 0;
                do {
                    int i13 = i11 + 1;
                    try {
                        try {
                            try {
                                try {
                                    try {
                                        i.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.d.a(), "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d10);
                                        try {
                                            i10 = i.d(openUrl2.f23289a).getInt("ret");
                                        } catch (JSONException unused) {
                                            i10 = -4;
                                        }
                                        if (i10 != 0) {
                                            if (!TextUtils.isEmpty(openUrl2.f23289a)) {
                                            }
                                            j10 = openUrl2.f23290b;
                                            j11 = openUrl2.f23291c;
                                            i11 = i13;
                                        }
                                        i13 = a10;
                                        z10 = true;
                                        j10 = openUrl2.f23290b;
                                        j11 = openUrl2.f23291c;
                                        i11 = i13;
                                    } catch (HttpUtils.HttpStatusException e10) {
                                        try {
                                            i12 = Integer.parseInt(e10.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                        } catch (Exception unused2) {
                                        }
                                    } catch (IOException e11) {
                                        i12 = HttpUtils.getErrorCodeFromException(e11);
                                        i11 = i13;
                                        j10 = 0;
                                        j11 = 0;
                                    }
                                } catch (ConnectTimeoutException unused3) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i11 = i13;
                                    i12 = -7;
                                    j10 = 0;
                                    j11 = 0;
                                } catch (Exception unused4) {
                                    i11 = a10;
                                    i12 = -6;
                                    j10 = 0;
                                    j11 = 0;
                                }
                            } catch (SocketTimeoutException unused5) {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                i11 = i13;
                                i12 = -8;
                                j10 = 0;
                                j11 = 0;
                            }
                        } catch (HttpUtils.NetworkUnavailableException unused6) {
                            g.this.f23190d.clear();
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                            return;
                        }
                    } catch (JSONException unused7) {
                        i11 = i13;
                        i12 = -4;
                        j10 = 0;
                        j11 = 0;
                    }
                } while (i11 < a10);
                g.this.a("mapp_apptrace_sdk", elapsedRealtime, j10, j11, i12, null, false);
                if (z10) {
                    f.a().b("report_via");
                } else {
                    f.a().a("report_via", g.this.f23190d);
                }
                g.this.f23190d.clear();
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z10);
            } catch (Exception e12) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e12);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$6 */
    public class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f23209a;

        /* renamed from: b */
        final /* synthetic */ String f23210b;

        /* renamed from: c */
        final /* synthetic */ boolean f23211c;

        /* renamed from: d */
        final /* synthetic */ String f23212d;

        public AnonymousClass6(Bundle bundle, String str, boolean z10, String str2) {
            bundle = bundle;
            str = str;
            z10 = z10;
            str2 = str2;
        }

        /* JADX WARN: Removed duplicated region for block: B:27:0x00e2 A[Catch: Exception -> 0x00f4, TryCatch #5 {Exception -> 0x00f4, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000c, B:11:0x0013, B:13:0x003c, B:14:0x0040, B:16:0x004e, B:17:0x0084, B:27:0x00e2, B:29:0x00e8, B:46:0x00cd, B:37:0x00d3, B:43:0x00d9, B:50:0x0062, B:52:0x0070, B:53:0x00ee), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00e8 A[Catch: Exception -> 0x00f4, TryCatch #5 {Exception -> 0x00f4, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x000c, B:11:0x0013, B:13:0x003c, B:14:0x0040, B:16:0x004e, B:17:0x0084, B:27:0x00e2, B:29:0x00e8, B:46:0x00cd, B:37:0x00d3, B:43:0x00d9, B:50:0x0062, B:52:0x0070, B:53:0x00ee), top: B:2:0x0002 }] */
        /* JADX WARN: Removed duplicated region for block: B:40:0x00e0 A[EDGE_INSN: B:40:0x00e0->B:26:0x00e0 BREAK  A[LOOP:0: B:19:0x0094->B:41:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:41:? A[LOOP:0: B:19:0x0094->B:41:?, LOOP_END, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 250
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass6.run():void");
        }
    }

    private g() {
        this.f23191e = null;
        if (this.f23191e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f23191e = handlerThread;
            handlerThread.start();
        }
        if (!this.f23191e.isAlive() || this.f23191e.getLooper() == null) {
            return;
        }
        this.f23192f = new Handler(this.f23191e.getLooper()) { // from class: com.tencent.open.b.g.1
            public AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i10 = message.what;
                if (i10 == 1000) {
                    g.this.b();
                } else if (i10 == 1001) {
                    g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            try {
                if (f23187a == null) {
                    f23187a = new g();
                }
                gVar = f23187a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return gVar;
    }

    public void b() {
        this.f23194h.execute(new Runnable() { // from class: com.tencent.open.b.g.4
            public AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    Bundle c10 = g.this.c();
                    if (c10 == null) {
                        return;
                    }
                    int a10 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_HttpRetryCount");
                    if (a10 == 0) {
                        a10 = 3;
                    }
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, retryCount: " + a10);
                    int i10 = 0;
                    do {
                        i10++;
                        try {
                            try {
                                HttpClient httpClient = HttpUtils.getHttpClient(com.tencent.open.utils.d.a(), null, "http://wspeed.qq.com/w.cgi");
                                HttpPost httpPost = new HttpPost("http://wspeed.qq.com/w.cgi");
                                httpPost.addHeader(m5.c.f28316j, "gzip");
                                httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");
                                httpPost.setEntity(new ByteArrayEntity(i.i(HttpUtils.encodeUrl(c10))));
                                int statusCode = httpClient.execute(httpPost).getStatusLine().getStatusCode();
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, statusCode: " + statusCode);
                                if (statusCode != 200) {
                                    break;
                                }
                                f.a().b("report_cgi");
                                break;
                            } catch (SocketTimeoutException e10) {
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e10);
                            } catch (ConnectTimeoutException e11) {
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e11);
                            }
                        } catch (Exception e12) {
                            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception", e12);
                        }
                    } while (i10 < a10);
                    f.a().a("report_cgi", g.this.f23189c);
                    g.this.f23189c.clear();
                } catch (Exception e13) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportCgi, doupload exception out.", e13);
                }
            }
        });
    }

    public Bundle c() {
        if (this.f23189c.size() == 0) {
            return null;
        }
        b bVar = (b) this.f23189c.get(0);
        if (bVar == null) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f23178a.get("appid");
        List<Serializable> a10 = f.a().a("report_cgi");
        if (a10 != null) {
            this.f23189c.addAll(a10);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f23189c.size());
        if (this.f23189c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString(h3.e.f26411p, Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString(PermissionActivity.f12046p, "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i10 = 0; i10 < this.f23189c.size(); i10++) {
                b bVar2 = (b) this.f23189c.get(i10);
                bundle.putString(i10 + "_1", bVar2.f23178a.get("apn"));
                bundle.putString(i10 + "_2", bVar2.f23178a.get("frequency"));
                bundle.putString(i10 + "_3", bVar2.f23178a.get("commandid"));
                bundle.putString(i10 + "_4", bVar2.f23178a.get("resultCode"));
                bundle.putString(i10 + "_5", bVar2.f23178a.get("timeCost"));
                bundle.putString(i10 + "_6", bVar2.f23178a.get("reqSize"));
                bundle.putString(i10 + "_7", bVar2.f23178a.get("rspSize"));
                bundle.putString(i10 + "_8", bVar2.f23178a.get("detail"));
                bundle.putString(i10 + "_9", bVar2.f23178a.get("uin"));
                bundle.putString(i10 + "_10", c.e(com.tencent.open.utils.d.a()) + "&" + bVar2.f23178a.get("deviceInfo"));
            }
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e10) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e10);
            return null;
        }
    }

    public Bundle d() {
        List<Serializable> a10 = f.a().a("report_via");
        if (a10 != null) {
            this.f23190d.addAll(a10);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f23190d.size());
        if (this.f23190d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f23190d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.f23178a.keySet()) {
                try {
                    String str2 = bVar.f23178a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e10) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e10);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(h3.e.f26408m, jSONArray);
            bundle.putString(h3.e.f26408m, jSONObject2.toString());
            return bundle;
        } catch (JSONException e11) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e11);
            return null;
        }
    }

    public void e() {
        this.f23193g.execute(new Runnable() { // from class: com.tencent.open.b.g.5
            public AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i10;
                try {
                    Bundle d10 = g.this.d();
                    if (d10 == null) {
                        return;
                    }
                    com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d10.toString());
                    int a10 = e.a();
                    int i11 = 0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z10 = false;
                    int i12 = 0;
                    long j10 = 0;
                    long j11 = 0;
                    do {
                        int i13 = i11 + 1;
                        try {
                            try {
                                try {
                                    try {
                                        try {
                                            i.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.d.a(), "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d10);
                                            try {
                                                i10 = i.d(openUrl2.f23289a).getInt("ret");
                                            } catch (JSONException unused) {
                                                i10 = -4;
                                            }
                                            if (i10 != 0) {
                                                if (!TextUtils.isEmpty(openUrl2.f23289a)) {
                                                }
                                                j10 = openUrl2.f23290b;
                                                j11 = openUrl2.f23291c;
                                                i11 = i13;
                                            }
                                            i13 = a10;
                                            z10 = true;
                                            j10 = openUrl2.f23290b;
                                            j11 = openUrl2.f23291c;
                                            i11 = i13;
                                        } catch (HttpUtils.HttpStatusException e10) {
                                            try {
                                                i12 = Integer.parseInt(e10.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                            } catch (Exception unused2) {
                                            }
                                        } catch (IOException e11) {
                                            i12 = HttpUtils.getErrorCodeFromException(e11);
                                            i11 = i13;
                                            j10 = 0;
                                            j11 = 0;
                                        }
                                    } catch (ConnectTimeoutException unused3) {
                                        elapsedRealtime = SystemClock.elapsedRealtime();
                                        i11 = i13;
                                        i12 = -7;
                                        j10 = 0;
                                        j11 = 0;
                                    } catch (Exception unused4) {
                                        i11 = a10;
                                        i12 = -6;
                                        j10 = 0;
                                        j11 = 0;
                                    }
                                } catch (SocketTimeoutException unused5) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i11 = i13;
                                    i12 = -8;
                                    j10 = 0;
                                    j11 = 0;
                                }
                            } catch (HttpUtils.NetworkUnavailableException unused6) {
                                g.this.f23190d.clear();
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                return;
                            }
                        } catch (JSONException unused7) {
                            i11 = i13;
                            i12 = -4;
                            j10 = 0;
                            j11 = 0;
                        }
                    } while (i11 < a10);
                    g.this.a("mapp_apptrace_sdk", elapsedRealtime, j10, j11, i12, null, false);
                    if (z10) {
                        f.a().b("report_via");
                    } else {
                        f.a().a("report_via", g.this.f23190d);
                    }
                    g.this.f23190d.clear();
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z10);
                } catch (Exception e12) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e12);
                }
            }
        });
    }

    public void a(Bundle bundle, String str, boolean z10) {
        if (bundle == null) {
            return;
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z10) {
            this.f23193g.execute(new Runnable() { // from class: com.tencent.open.b.g.2

                /* renamed from: a */
                final /* synthetic */ Bundle f23196a;

                /* renamed from: b */
                final /* synthetic */ boolean f23197b;

                public AnonymousClass2(Bundle bundle2, boolean z102) {
                    bundle = bundle2;
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", "1000");
                        bundle2.putString("imei", c.b(com.tencent.open.utils.d.a()));
                        bundle2.putString("imsi", c.c(com.tencent.open.utils.d.a()));
                        bundle2.putString("android_id", c.d(com.tencent.open.utils.d.a()));
                        bundle2.putString("mac", c.a());
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString(id.c.f26972i, i.d(com.tencent.open.utils.d.a()));
                        bundle2.putString(PointCategory.NETWORK, a.a(com.tencent.open.utils.d.a()));
                        bundle2.putString(bt.N, c.b());
                        bundle2.putString(bt.f23630z, c.a(com.tencent.open.utils.d.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.d.a()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString(bt.M, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", i.d(com.tencent.open.utils.d.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString("qq_ver", i.c(com.tencent.open.utils.d.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", i.e(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.d.b());
                        bundle2.putString(AdKeys.APP_VER, i.d(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                        Bundle bundle22 = bundle;
                        if (bundle22 != null) {
                            bundle2.putAll(bundle22);
                        }
                        g.this.f23190d.add(new b(bundle2));
                        int size = g.this.f23190d.size();
                        int a10 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a10 == 0) {
                            a10 = 10000;
                        }
                        if (!g.this.a("report_via", size) && !z10) {
                            if (g.this.f23192f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            g.this.f23192f.sendMessageDelayed(obtain, a10);
                            return;
                        }
                        g.this.e();
                        g.this.f23192f.removeMessages(1001);
                    } catch (Exception e10) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e10);
                    }
                }
            });
        }
    }

    public void a(String str, long j10, long j11, long j12, int i10) {
        a(str, j10, j11, j12, i10, "", false);
    }

    public void a(String str, long j10, long j11, long j12, int i10, String str2, boolean z10) {
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j10 + " | reqSize:" + j11 + " | rspSize: " + j12 + " | responseCode: " + i10 + " | detail: " + str2);
        if (a("report_cgi", "" + i10) || z10) {
            this.f23194h.execute(new Runnable() { // from class: com.tencent.open.b.g.3

                /* renamed from: a */
                final /* synthetic */ long f23199a;

                /* renamed from: b */
                final /* synthetic */ String f23200b;

                /* renamed from: c */
                final /* synthetic */ String f23201c;

                /* renamed from: d */
                final /* synthetic */ int f23202d;

                /* renamed from: e */
                final /* synthetic */ long f23203e;

                /* renamed from: f */
                final /* synthetic */ long f23204f;

                /* renamed from: g */
                final /* synthetic */ boolean f23205g;

                public AnonymousClass3(long j102, String str3, String str22, int i102, long j112, long j122, boolean z102) {
                    j10 = j102;
                    str = str3;
                    str2 = str22;
                    i10 = i102;
                    j11 = j112;
                    j12 = j122;
                    z10 = z102;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j10;
                        Bundle bundle = new Bundle();
                        String a10 = a.a(com.tencent.open.utils.d.a());
                        bundle.putString("apn", a10);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("network=");
                        sb2.append(a10);
                        sb2.append(Typography.amp);
                        sb2.append("sdcard=");
                        int i102 = 1;
                        sb2.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb2.append(Typography.amp);
                        sb2.append("wifi=");
                        sb2.append(a.e(com.tencent.open.utils.d.a()));
                        bundle.putString("deviceInfo", sb2.toString());
                        int a11 = 100 / g.this.a(i10);
                        if (a11 > 0) {
                            i102 = a11 > 100 ? 100 : a11;
                        }
                        bundle.putString("frequency", i102 + "");
                        bundle.putString("reqSize", j11 + "");
                        bundle.putString("resultCode", i10 + "");
                        bundle.putString("rspSize", j12 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", "1000");
                        g.this.f23189c.add(new b(bundle));
                        int size = g.this.f23189c.size();
                        int a12 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a12 == 0) {
                            a12 = 10000;
                        }
                        if (!g.this.a("report_cgi", size) && !z10) {
                            if (!g.this.f23192f.hasMessages(1000)) {
                                Message obtain = Message.obtain();
                                obtain.what = 1000;
                                g.this.f23192f.sendMessageDelayed(obtain, a12);
                            }
                        }
                        g.this.b();
                        g.this.f23192f.removeMessages(1000);
                    } catch (Exception e10) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e10);
                    }
                }
            });
        }
    }

    public boolean a(String str, String str2) {
        int a10;
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z10 = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i10 = 100;
        if (str.equals("report_cgi")) {
            try {
                a10 = a(Integer.parseInt(str2));
                if (this.f23188b.nextInt(100) < a10) {
                    z10 = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a10 = e.a(str2);
                if (this.f23188b.nextInt(100) < a10) {
                    i10 = a10;
                    z10 = true;
                }
            }
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
            return z10;
        }
        i10 = a10;
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z10 + " | frequency: " + i10);
        return z10;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1e
            android.content.Context r0 = com.tencent.open.utils.d.a()
            com.tencent.open.utils.e r0 = com.tencent.open.utils.e.a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L1c:
            r1 = r0
            goto L38
        L1e:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L37
            android.content.Context r0 = com.tencent.open.utils.d.a()
            com.tencent.open.utils.e r0 = com.tencent.open.utils.e.a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.a(r2)
            if (r0 != 0) goto L1c
            goto L38
        L37:
            r1 = 0
        L38:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r0.append(r2)
            r0.append(r5)
            java.lang.String r5 = " | dataSize: "
            r0.append(r5)
            r0.append(r6)
            java.lang.String r5 = " | maxcount: "
            r0.append(r5)
            r0.append(r1)
            java.lang.String r5 = r0.toString()
            java.lang.String r0 = "openSDK_LOG.ReportManager"
            com.tencent.open.a.f.b(r0, r5)
            if (r6 < r1) goto L62
            r5 = 1
            return r5
        L62:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.a(java.lang.String, int):boolean");
    }

    public int a(int i10) {
        if (i10 == 0) {
            int a10 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a10 == 0) {
                return 10;
            }
            return a10;
        }
        int a11 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a11 == 0) {
            return 100;
        }
        return a11;
    }

    public void a(String str, String str2, Bundle bundle, boolean z10) {
        h.a(new Runnable() { // from class: com.tencent.open.b.g.6

            /* renamed from: a */
            final /* synthetic */ Bundle f23209a;

            /* renamed from: b */
            final /* synthetic */ String f23210b;

            /* renamed from: c */
            final /* synthetic */ boolean f23211c;

            /* renamed from: d */
            final /* synthetic */ String f23212d;

            public AnonymousClass6(Bundle bundle2, String str3, boolean z102, String str22) {
                bundle = bundle2;
                str = str3;
                z10 = z102;
                str2 = str22;
            }

            @Override // java.lang.Runnable
            public void run() {
                /*
                    Method dump skipped, instructions count: 250
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass6.run():void");
            }
        });
    }
}
