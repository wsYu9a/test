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
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.process.bridge.provider.ProcessBridgeProvider;
import com.tencent.connect.common.Constants;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.h;
import com.tencent.open.utils.i;
import com.umeng.analytics.pro.am;
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
import org.apache.http.conn.ConnectTimeoutException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class g {

    /* renamed from: a */
    protected static g f25454a;

    /* renamed from: e */
    protected HandlerThread f25458e;

    /* renamed from: f */
    protected Handler f25459f;

    /* renamed from: b */
    protected Random f25455b = new Random();

    /* renamed from: d */
    protected List<Serializable> f25457d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    protected List<Serializable> f25456c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g */
    protected Executor f25460g = h.b();

    /* renamed from: h */
    protected Executor f25461h = h.b();

    /* renamed from: com.tencent.open.b.g$1 */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                g.this.b();
            } else if (i2 == 1001) {
                g.this.e();
            }
            super.handleMessage(message);
        }
    }

    /* renamed from: com.tencent.open.b.g$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f25463a;

        /* renamed from: b */
        final /* synthetic */ boolean f25464b;

        AnonymousClass2(Bundle bundle, boolean z) {
            bundle = bundle;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("uin", Constants.DEFAULT_UIN);
                bundle.putString("imei", c.b(com.tencent.open.utils.d.a()));
                bundle.putString("imsi", c.c(com.tencent.open.utils.d.a()));
                bundle.putString("android_id", c.d(com.tencent.open.utils.d.a()));
                bundle.putString("mac", c.a());
                bundle.putString("platform", "1");
                bundle.putString("os_ver", Build.VERSION.RELEASE);
                bundle.putString("position", i.d(com.tencent.open.utils.d.a()));
                bundle.putString("network", a.a(com.tencent.open.utils.d.a()));
                bundle.putString(am.N, c.b());
                bundle.putString(am.z, c.a(com.tencent.open.utils.d.a()));
                bundle.putString("apn", a.b(com.tencent.open.utils.d.a()));
                bundle.putString("model_name", Build.MODEL);
                bundle.putString(am.M, TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", Constants.SDK_VERSION);
                bundle.putString("qz_ver", i.d(com.tencent.open.utils.d.a(), Constants.PACKAGE_QZONE));
                bundle.putString("qq_ver", i.c(com.tencent.open.utils.d.a(), "com.tencent.mobileqq"));
                bundle.putString("qua", i.e(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                bundle.putString("packagename", com.tencent.open.utils.d.b());
                bundle.putString("app_ver", i.d(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                Bundle bundle2 = bundle;
                if (bundle2 != null) {
                    bundle.putAll(bundle2);
                }
                g.this.f25457d.add(new b(bundle));
                int size = g.this.f25457d.size();
                int a2 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a2 == 0) {
                    a2 = 10000;
                }
                if (!g.this.a("report_via", size) && !z) {
                    if (g.this.f25459f.hasMessages(1001)) {
                        return;
                    }
                    Message obtain = Message.obtain();
                    obtain.what = 1001;
                    g.this.f25459f.sendMessageDelayed(obtain, a2);
                    return;
                }
                g.this.e();
                g.this.f25459f.removeMessages(1001);
            } catch (Exception e2) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f25466a;

        /* renamed from: b */
        final /* synthetic */ String f25467b;

        /* renamed from: c */
        final /* synthetic */ String f25468c;

        /* renamed from: d */
        final /* synthetic */ int f25469d;

        /* renamed from: e */
        final /* synthetic */ long f25470e;

        /* renamed from: f */
        final /* synthetic */ long f25471f;

        /* renamed from: g */
        final /* synthetic */ boolean f25472g;

        AnonymousClass3(long j2, String str, String str2, int i2, long j3, long j4, boolean z) {
            j2 = j2;
            str = str;
            str2 = str2;
            i2 = i2;
            j3 = j3;
            j4 = j4;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
                Bundle bundle = new Bundle();
                String a2 = a.a(com.tencent.open.utils.d.a());
                bundle.putString("apn", a2);
                bundle.putString("appid", "1000067");
                bundle.putString("commandid", str);
                bundle.putString("detail", str2);
                StringBuilder sb = new StringBuilder();
                sb.append("network=");
                sb.append(a2);
                sb.append(Typography.amp);
                sb.append("sdcard=");
                int i2 = 1;
                sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                sb.append(Typography.amp);
                sb.append("wifi=");
                sb.append(a.e(com.tencent.open.utils.d.a()));
                bundle.putString(com.alipay.mobilesecuritysdk.deviceID.c.v, sb.toString());
                int a3 = 100 / g.this.a(i2);
                if (a3 > 0) {
                    i2 = a3 > 100 ? 100 : a3;
                }
                bundle.putString("frequency", i2 + "");
                bundle.putString("reqSize", j3 + "");
                bundle.putString(ProcessBridgeProvider.KEY_RESULT_CODE, i2 + "");
                bundle.putString("rspSize", j4 + "");
                bundle.putString("timeCost", elapsedRealtime + "");
                bundle.putString("uin", Constants.DEFAULT_UIN);
                g.this.f25456c.add(new b(bundle));
                int size = g.this.f25456c.size();
                int a4 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                if (a4 == 0) {
                    a4 = 10000;
                }
                if (!g.this.a("report_cgi", size) && !z) {
                    if (!g.this.f25459f.hasMessages(1000)) {
                        Message obtain = Message.obtain();
                        obtain.what = 1000;
                        g.this.f25459f.sendMessageDelayed(obtain, a4);
                    }
                }
                g.this.b();
                g.this.f25459f.removeMessages(1000);
            } catch (Exception e2) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$4 */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        /* JADX WARN: Removed duplicated region for block: B:21:0x00a5 A[Catch: Exception -> 0x00b8, TryCatch #0 {Exception -> 0x00b8, blocks: (B:3:0x0008, B:7:0x0011, B:10:0x0023, B:21:0x00a5, B:22:0x00b0, B:28:0x0094, B:30:0x0099, B:36:0x009e, B:14:0x003b, B:16:0x008a), top: B:2:0x0008, inners: #1, #2, #3 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00a3 A[EDGE_INSN: B:33:0x00a3->B:20:0x00a3 BREAK  A[LOOP:0: B:12:0x0039->B:34:?], SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:34:? A[LOOP:0: B:12:0x0039->B:34:?, LOOP_END, SYNTHETIC] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r14 = this;
                java.lang.String r0 = "report_cgi"
                java.lang.String r1 = "http://wspeed.qq.com/w.cgi"
                java.lang.String r2 = "-->doReportCgi, doupload exception"
                java.lang.String r3 = "openSDK_LOG.ReportManager"
                com.tencent.open.b.g r4 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                android.os.Bundle r4 = r4.c()     // Catch: java.lang.Exception -> Lb8
                if (r4 != 0) goto L11
                return
            L11:
                android.content.Context r5 = com.tencent.open.utils.d.a()     // Catch: java.lang.Exception -> Lb8
                r6 = 0
                com.tencent.open.utils.e r5 = com.tencent.open.utils.e.a(r5, r6)     // Catch: java.lang.Exception -> Lb8
                java.lang.String r7 = "Common_HttpRetryCount"
                int r5 = r5.a(r7)     // Catch: java.lang.Exception -> Lb8
                if (r5 != 0) goto L23
                r5 = 3
            L23:
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb8
                r7.<init>()     // Catch: java.lang.Exception -> Lb8
                java.lang.String r8 = "-->doReportCgi, retryCount: "
                r7.append(r8)     // Catch: java.lang.Exception -> Lb8
                r7.append(r5)     // Catch: java.lang.Exception -> Lb8
                java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lb8
                com.tencent.open.a.f.b(r3, r7)     // Catch: java.lang.Exception -> Lb8
                r7 = 0
                r8 = 0
            L39:
                r9 = 1
                int r8 = r8 + r9
                android.content.Context r10 = com.tencent.open.utils.d.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r11.<init>(r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.String r12 = "Accept-Encoding"
                java.lang.String r13 = "gzip"
                r11.addHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.String r12 = "Content-Type"
                java.lang.String r13 = "application/x-www-form-urlencoded"
                r11.setHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                byte[] r12 = com.tencent.open.utils.i.i(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r13.<init>(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r11.setEntity(r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                int r10 = r10.getStatusCode()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r11.<init>()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.String r12 = "-->doReportCgi, statusCode: "
                r11.append(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r11.append(r10)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                com.tencent.open.a.f.b(r3, r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r11 = 200(0xc8, float:2.8E-43)
                if (r10 != r11) goto La3
                com.tencent.open.b.f r10 = com.tencent.open.b.f.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r10.b(r0)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                r7 = 1
                goto La3
            L93:
                r1 = move-exception
                com.tencent.open.a.f.b(r3, r2, r1)     // Catch: java.lang.Exception -> Lb8
                goto La3
            L98:
                r9 = move-exception
                com.tencent.open.a.f.b(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
                goto La1
            L9d:
                r9 = move-exception
                com.tencent.open.a.f.b(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
            La1:
                if (r8 < r5) goto L39
            La3:
                if (r7 != 0) goto Lb0
                com.tencent.open.b.f r1 = com.tencent.open.b.f.a()     // Catch: java.lang.Exception -> Lb8
                com.tencent.open.b.g r2 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                java.util.List<java.io.Serializable> r2 = r2.f25456c     // Catch: java.lang.Exception -> Lb8
                r1.a(r0, r2)     // Catch: java.lang.Exception -> Lb8
            Lb0:
                com.tencent.open.b.g r0 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                java.util.List<java.io.Serializable> r0 = r0.f25456c     // Catch: java.lang.Exception -> Lb8
                r0.clear()     // Catch: java.lang.Exception -> Lb8
                goto Lbe
            Lb8:
                r0 = move-exception
                java.lang.String r1 = "-->doReportCgi, doupload exception out."
                com.tencent.open.a.f.b(r3, r1, r0)
            Lbe:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass4.run():void");
        }
    }

    /* renamed from: com.tencent.open.b.g$5 */
    class AnonymousClass5 implements Runnable {
        AnonymousClass5() {
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2;
            try {
                Bundle d2 = g.this.d();
                if (d2 == null) {
                    return;
                }
                com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d2.toString());
                int a2 = e.a();
                int i3 = 0;
                long elapsedRealtime = SystemClock.elapsedRealtime();
                boolean z = false;
                int i4 = 0;
                long j2 = 0;
                long j3 = 0;
                do {
                    int i5 = i3 + 1;
                    try {
                        try {
                            try {
                                i.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.d.a(), "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d2);
                                try {
                                    i2 = i.d(openUrl2.f25555a).getInt("ret");
                                } catch (JSONException unused) {
                                    i2 = -4;
                                }
                                if (i2 == 0 || !TextUtils.isEmpty(openUrl2.f25555a)) {
                                    i5 = a2;
                                    z = true;
                                }
                                j2 = openUrl2.f25556b;
                                j3 = openUrl2.f25557c;
                                i3 = i5;
                            } catch (HttpUtils.HttpStatusException e2) {
                                try {
                                    i4 = Integer.parseInt(e2.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                } catch (Exception unused2) {
                                }
                            } catch (HttpUtils.NetworkUnavailableException unused3) {
                                g.this.f25457d.clear();
                                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                return;
                            } catch (ConnectTimeoutException unused4) {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                i3 = i5;
                                i4 = -7;
                                j2 = 0;
                                j3 = 0;
                            } catch (Exception unused5) {
                                i3 = a2;
                                i4 = -6;
                                j2 = 0;
                                j3 = 0;
                            }
                        } catch (SocketTimeoutException unused6) {
                            elapsedRealtime = SystemClock.elapsedRealtime();
                            i3 = i5;
                            i4 = -8;
                            j2 = 0;
                            j3 = 0;
                        } catch (IOException e3) {
                            i4 = HttpUtils.getErrorCodeFromException(e3);
                            i3 = i5;
                            j2 = 0;
                            j3 = 0;
                        }
                    } catch (JSONException unused7) {
                        i3 = i5;
                        i4 = -4;
                        j2 = 0;
                        j3 = 0;
                    }
                } while (i3 < a2);
                g.this.a("mapp_apptrace_sdk", elapsedRealtime, j2, j3, i4, null, false);
                if (z) {
                    f.a().b("report_via");
                } else {
                    f.a().a("report_via", g.this.f25457d);
                }
                g.this.f25457d.clear();
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
            } catch (Exception e4) {
                com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
            }
        }
    }

    /* renamed from: com.tencent.open.b.g$6 */
    class AnonymousClass6 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ Bundle f25476a;

        /* renamed from: b */
        final /* synthetic */ String f25477b;

        /* renamed from: c */
        final /* synthetic */ boolean f25478c;

        /* renamed from: d */
        final /* synthetic */ String f25479d;

        AnonymousClass6(Bundle bundle, String str, boolean z, String str2) {
            bundle = bundle;
            str = str;
            z = z;
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
        this.f25458e = null;
        if (this.f25458e == null) {
            HandlerThread handlerThread = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f25458e = handlerThread;
            handlerThread.start();
        }
        if (!this.f25458e.isAlive() || this.f25458e.getLooper() == null) {
            return;
        }
        this.f25459f = new Handler(this.f25458e.getLooper()) { // from class: com.tencent.open.b.g.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    g.this.b();
                } else if (i2 == 1001) {
                    g.this.e();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f25454a == null) {
                f25454a = new g();
            }
            gVar = f25454a;
        }
        return gVar;
    }

    protected void b() {
        this.f25461h.execute(new Runnable() { // from class: com.tencent.open.b.g.4
            AnonymousClass4() {
            }

            @Override // java.lang.Runnable
            public void run() {
                /*
                    this = this;
                    java.lang.String r0 = "report_cgi"
                    java.lang.String r1 = "http://wspeed.qq.com/w.cgi"
                    java.lang.String r2 = "-->doReportCgi, doupload exception"
                    java.lang.String r3 = "openSDK_LOG.ReportManager"
                    com.tencent.open.b.g r4 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                    android.os.Bundle r4 = r4.c()     // Catch: java.lang.Exception -> Lb8
                    if (r4 != 0) goto L11
                    return
                L11:
                    android.content.Context r5 = com.tencent.open.utils.d.a()     // Catch: java.lang.Exception -> Lb8
                    r6 = 0
                    com.tencent.open.utils.e r5 = com.tencent.open.utils.e.a(r5, r6)     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r7 = "Common_HttpRetryCount"
                    int r5 = r5.a(r7)     // Catch: java.lang.Exception -> Lb8
                    if (r5 != 0) goto L23
                    r5 = 3
                L23:
                    java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lb8
                    r7.<init>()     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r8 = "-->doReportCgi, retryCount: "
                    r7.append(r8)     // Catch: java.lang.Exception -> Lb8
                    r7.append(r5)     // Catch: java.lang.Exception -> Lb8
                    java.lang.String r7 = r7.toString()     // Catch: java.lang.Exception -> Lb8
                    com.tencent.open.a.f.b(r3, r7)     // Catch: java.lang.Exception -> Lb8
                    r7 = 0
                    r8 = 0
                L39:
                    r9 = 1
                    int r8 = r8 + r9
                    android.content.Context r10 = com.tencent.open.utils.d.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.client.HttpClient r10 = com.tencent.open.utils.HttpUtils.getHttpClient(r10, r6, r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.client.methods.HttpPost r11 = new org.apache.http.client.methods.HttpPost     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.<init>(r1)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "Accept-Encoding"
                    java.lang.String r13 = "gzip"
                    r11.addHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "Content-Type"
                    java.lang.String r13 = "application/x-www-form-urlencoded"
                    r11.setHeader(r12, r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = com.tencent.open.utils.HttpUtils.encodeUrl(r4)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    byte[] r12 = com.tencent.open.utils.i.i(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.entity.ByteArrayEntity r13 = new org.apache.http.entity.ByteArrayEntity     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r13.<init>(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.setEntity(r13)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.HttpResponse r10 = r10.execute(r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    org.apache.http.StatusLine r10 = r10.getStatusLine()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    int r10 = r10.getStatusCode()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.<init>()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r12 = "-->doReportCgi, statusCode: "
                    r11.append(r12)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11.append(r10)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    java.lang.String r11 = r11.toString()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    com.tencent.open.a.f.b(r3, r11)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r11 = 200(0xc8, float:2.8E-43)
                    if (r10 != r11) goto La3
                    com.tencent.open.b.f r10 = com.tencent.open.b.f.a()     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r10.b(r0)     // Catch: java.lang.Exception -> L93 java.net.SocketTimeoutException -> L98 org.apache.http.conn.ConnectTimeoutException -> L9d
                    r7 = 1
                    goto La3
                L93:
                    r1 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r1)     // Catch: java.lang.Exception -> Lb8
                    goto La3
                L98:
                    r9 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
                    goto La1
                L9d:
                    r9 = move-exception
                    com.tencent.open.a.f.b(r3, r2, r9)     // Catch: java.lang.Exception -> Lb8
                La1:
                    if (r8 < r5) goto L39
                La3:
                    if (r7 != 0) goto Lb0
                    com.tencent.open.b.f r1 = com.tencent.open.b.f.a()     // Catch: java.lang.Exception -> Lb8
                    com.tencent.open.b.g r2 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                    java.util.List<java.io.Serializable> r2 = r2.f25456c     // Catch: java.lang.Exception -> Lb8
                    r1.a(r0, r2)     // Catch: java.lang.Exception -> Lb8
                Lb0:
                    com.tencent.open.b.g r0 = com.tencent.open.b.g.this     // Catch: java.lang.Exception -> Lb8
                    java.util.List<java.io.Serializable> r0 = r0.f25456c     // Catch: java.lang.Exception -> Lb8
                    r0.clear()     // Catch: java.lang.Exception -> Lb8
                    goto Lbe
                Lb8:
                    r0 = move-exception
                    java.lang.String r1 = "-->doReportCgi, doupload exception out."
                    com.tencent.open.a.f.b(r3, r1, r0)
                Lbe:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.b.g.AnonymousClass4.run():void");
            }
        });
    }

    protected Bundle c() {
        if (this.f25456c.size() == 0) {
            return null;
        }
        b bVar = (b) this.f25456c.get(0);
        if (bVar == null) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, the 0th cgireportitem is null.");
            return null;
        }
        String str = bVar.f25445a.get("appid");
        List<Serializable> a2 = f.a().a("report_cgi");
        if (a2 != null) {
            this.f25456c.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, mCgiList size: " + this.f25456c.size());
        if (this.f25456c.size() == 0) {
            return null;
        }
        Bundle bundle = new Bundle();
        try {
            bundle.putString("appid", str);
            bundle.putString("releaseversion", Constants.SDK_VERSION_REPORT);
            bundle.putString("device", Build.DEVICE);
            bundle.putString("qua", Constants.SDK_QUA);
            bundle.putString("key", "apn,frequency,commandid,resultcode,tmcost,reqsize,rspsize,detail,touin,deviceinfo");
            for (int i2 = 0; i2 < this.f25456c.size(); i2++) {
                b bVar2 = (b) this.f25456c.get(i2);
                bundle.putString(i2 + "_1", bVar2.f25445a.get("apn"));
                bundle.putString(i2 + "_2", bVar2.f25445a.get("frequency"));
                bundle.putString(i2 + "_3", bVar2.f25445a.get("commandid"));
                bundle.putString(i2 + "_4", bVar2.f25445a.get(ProcessBridgeProvider.KEY_RESULT_CODE));
                bundle.putString(i2 + "_5", bVar2.f25445a.get("timeCost"));
                bundle.putString(i2 + "_6", bVar2.f25445a.get("reqSize"));
                bundle.putString(i2 + "_7", bVar2.f25445a.get("rspSize"));
                bundle.putString(i2 + "_8", bVar2.f25445a.get("detail"));
                bundle.putString(i2 + "_9", bVar2.f25445a.get("uin"));
                bundle.putString(i2 + "_10", c.e(com.tencent.open.utils.d.a()) + "&" + bVar2.f25445a.get(com.alipay.mobilesecuritysdk.deviceID.c.v));
            }
            com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareCgiData, end. params: " + bundle.toString());
            return bundle;
        } catch (Exception e2) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareCgiData, exception.", e2);
            return null;
        }
    }

    protected Bundle d() {
        List<Serializable> a2 = f.a().a("report_via");
        if (a2 != null) {
            this.f25457d.addAll(a2);
        }
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f25457d.size());
        if (this.f25457d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f25457d) {
            JSONObject jSONObject = new JSONObject();
            b bVar = (b) serializable;
            for (String str : bVar.f25445a.keySet()) {
                try {
                    String str2 = bVar.f25445a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        Bundle bundle = new Bundle();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put(MiConfigSingleton.t0, jSONArray);
            bundle.putString(MiConfigSingleton.t0, jSONObject2.toString());
            return bundle;
        } catch (JSONException e3) {
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    protected void e() {
        this.f25460g.execute(new Runnable() { // from class: com.tencent.open.b.g.5
            AnonymousClass5() {
            }

            @Override // java.lang.Runnable
            public void run() {
                int i2;
                try {
                    Bundle d2 = g.this.d();
                    if (d2 == null) {
                        return;
                    }
                    com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->doReportVia, params: " + d2.toString());
                    int a2 = e.a();
                    int i3 = 0;
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    boolean z = false;
                    int i4 = 0;
                    long j2 = 0;
                    long j3 = 0;
                    do {
                        int i5 = i3 + 1;
                        try {
                            try {
                                try {
                                    i.a openUrl2 = HttpUtils.openUrl2(com.tencent.open.utils.d.a(), "http://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", "POST", d2);
                                    try {
                                        i2 = i.d(openUrl2.f25555a).getInt("ret");
                                    } catch (JSONException unused) {
                                        i2 = -4;
                                    }
                                    if (i2 == 0 || !TextUtils.isEmpty(openUrl2.f25555a)) {
                                        i5 = a2;
                                        z = true;
                                    }
                                    j2 = openUrl2.f25556b;
                                    j3 = openUrl2.f25557c;
                                    i3 = i5;
                                } catch (HttpUtils.HttpStatusException e2) {
                                    try {
                                        i4 = Integer.parseInt(e2.getMessage().replace(HttpUtils.HttpStatusException.ERROR_INFO, ""));
                                    } catch (Exception unused2) {
                                    }
                                } catch (HttpUtils.NetworkUnavailableException unused3) {
                                    g.this.f25457d.clear();
                                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "doReportVia, NetworkUnavailableException.");
                                    return;
                                } catch (ConnectTimeoutException unused4) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    i3 = i5;
                                    i4 = -7;
                                    j2 = 0;
                                    j3 = 0;
                                } catch (Exception unused5) {
                                    i3 = a2;
                                    i4 = -6;
                                    j2 = 0;
                                    j3 = 0;
                                }
                            } catch (SocketTimeoutException unused6) {
                                elapsedRealtime = SystemClock.elapsedRealtime();
                                i3 = i5;
                                i4 = -8;
                                j2 = 0;
                                j3 = 0;
                            } catch (IOException e3) {
                                i4 = HttpUtils.getErrorCodeFromException(e3);
                                i3 = i5;
                                j2 = 0;
                                j3 = 0;
                            }
                        } catch (JSONException unused7) {
                            i3 = i5;
                            i4 = -4;
                            j2 = 0;
                            j3 = 0;
                        }
                    } while (i3 < a2);
                    g.this.a("mapp_apptrace_sdk", elapsedRealtime, j2, j3, i4, null, false);
                    if (z) {
                        f.a().b("report_via");
                    } else {
                        f.a().a("report_via", g.this.f25457d);
                    }
                    g.this.f25457d.clear();
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z);
                } catch (Exception e4) {
                    com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
                }
            }
        });
    }

    public void a(Bundle bundle, String str, boolean z) {
        if (bundle == null) {
            return;
        }
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.f25460g.execute(new Runnable() { // from class: com.tencent.open.b.g.2

                /* renamed from: a */
                final /* synthetic */ Bundle f25463a;

                /* renamed from: b */
                final /* synthetic */ boolean f25464b;

                AnonymousClass2(Bundle bundle2, boolean z2) {
                    bundle = bundle2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("imei", c.b(com.tencent.open.utils.d.a()));
                        bundle2.putString("imsi", c.c(com.tencent.open.utils.d.a()));
                        bundle2.putString("android_id", c.d(com.tencent.open.utils.d.a()));
                        bundle2.putString("mac", c.a());
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", i.d(com.tencent.open.utils.d.a()));
                        bundle2.putString("network", a.a(com.tencent.open.utils.d.a()));
                        bundle2.putString(am.N, c.b());
                        bundle2.putString(am.z, c.a(com.tencent.open.utils.d.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.d.a()));
                        bundle2.putString("model_name", Build.MODEL);
                        bundle2.putString(am.M, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", i.d(com.tencent.open.utils.d.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString("qq_ver", i.c(com.tencent.open.utils.d.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", i.e(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.d.b());
                        bundle2.putString("app_ver", i.d(com.tencent.open.utils.d.a(), com.tencent.open.utils.d.b()));
                        Bundle bundle22 = bundle;
                        if (bundle22 != null) {
                            bundle2.putAll(bundle22);
                        }
                        g.this.f25457d.add(new b(bundle2));
                        int size = g.this.f25457d.size();
                        int a2 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a2 == 0) {
                            a2 = 10000;
                        }
                        if (!g.this.a("report_via", size) && !z) {
                            if (g.this.f25459f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            g.this.f25459f.sendMessageDelayed(obtain, a2);
                            return;
                        }
                        g.this.e();
                        g.this.f25459f.removeMessages(1001);
                    } catch (Exception e2) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    public void a(String str, long j2, long j3, long j4, int i2) {
        a(str, j2, j3, j4, i2, "", false);
    }

    public void a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
        com.tencent.open.a.f.a("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
        if (a("report_cgi", "" + i2) || z) {
            this.f25461h.execute(new Runnable() { // from class: com.tencent.open.b.g.3

                /* renamed from: a */
                final /* synthetic */ long f25466a;

                /* renamed from: b */
                final /* synthetic */ String f25467b;

                /* renamed from: c */
                final /* synthetic */ String f25468c;

                /* renamed from: d */
                final /* synthetic */ int f25469d;

                /* renamed from: e */
                final /* synthetic */ long f25470e;

                /* renamed from: f */
                final /* synthetic */ long f25471f;

                /* renamed from: g */
                final /* synthetic */ boolean f25472g;

                AnonymousClass3(long j22, String str3, String str22, int i22, long j32, long j42, boolean z2) {
                    j2 = j22;
                    str = str3;
                    str2 = str22;
                    i2 = i22;
                    j3 = j32;
                    j4 = j42;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime() - j2;
                        Bundle bundle = new Bundle();
                        String a2 = a.a(com.tencent.open.utils.d.a());
                        bundle.putString("apn", a2);
                        bundle.putString("appid", "1000067");
                        bundle.putString("commandid", str);
                        bundle.putString("detail", str2);
                        StringBuilder sb = new StringBuilder();
                        sb.append("network=");
                        sb.append(a2);
                        sb.append(Typography.amp);
                        sb.append("sdcard=");
                        int i22 = 1;
                        sb.append(Environment.getExternalStorageState().equals("mounted") ? 1 : 0);
                        sb.append(Typography.amp);
                        sb.append("wifi=");
                        sb.append(a.e(com.tencent.open.utils.d.a()));
                        bundle.putString(com.alipay.mobilesecuritysdk.deviceID.c.v, sb.toString());
                        int a3 = 100 / g.this.a(i2);
                        if (a3 > 0) {
                            i22 = a3 > 100 ? 100 : a3;
                        }
                        bundle.putString("frequency", i22 + "");
                        bundle.putString("reqSize", j3 + "");
                        bundle.putString(ProcessBridgeProvider.KEY_RESULT_CODE, i2 + "");
                        bundle.putString("rspSize", j4 + "");
                        bundle.putString("timeCost", elapsedRealtime + "");
                        bundle.putString("uin", Constants.DEFAULT_UIN);
                        g.this.f25456c.add(new b(bundle));
                        int size = g.this.f25456c.size();
                        int a4 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (a4 == 0) {
                            a4 = 10000;
                        }
                        if (!g.this.a("report_cgi", size) && !z) {
                            if (!g.this.f25459f.hasMessages(1000)) {
                                Message obtain = Message.obtain();
                                obtain.what = 1000;
                                g.this.f25459f.sendMessageDelayed(obtain, a4);
                            }
                        }
                        g.this.b();
                        g.this.f25459f.removeMessages(1000);
                    } catch (Exception e2) {
                        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "--> reportCGI, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    protected boolean a(String str, String str2) {
        int a2;
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        int i2 = 100;
        if (str.equals("report_cgi")) {
            try {
                a2 = a(Integer.parseInt(str2));
                if (this.f25455b.nextInt(100) < a2) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else {
            if (str.equals("report_via")) {
                a2 = e.a(str2);
                if (this.f25455b.nextInt(100) < a2) {
                    i2 = a2;
                    z = true;
                }
            }
            com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
            return z;
        }
        i2 = a2;
        com.tencent.open.a.f.b("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + i2);
        return z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0034, code lost:
    
        if (r0 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001c, code lost:
    
        r1 = r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean a(java.lang.String r5, int r6) {
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

    protected int a(int i2) {
        if (i2 == 0) {
            int a2 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (a2 == 0) {
                return 10;
            }
            return a2;
        }
        int a3 = com.tencent.open.utils.e.a(com.tencent.open.utils.d.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (a3 == 0) {
            return 100;
        }
        return a3;
    }

    public void a(String str, String str2, Bundle bundle, boolean z) {
        h.a(new Runnable() { // from class: com.tencent.open.b.g.6

            /* renamed from: a */
            final /* synthetic */ Bundle f25476a;

            /* renamed from: b */
            final /* synthetic */ String f25477b;

            /* renamed from: c */
            final /* synthetic */ boolean f25478c;

            /* renamed from: d */
            final /* synthetic */ String f25479d;

            AnonymousClass6(Bundle bundle2, String str3, boolean z2, String str22) {
                bundle = bundle2;
                str = str3;
                z = z2;
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
