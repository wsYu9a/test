package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes5.dex */
public class a extends FrameLayout {
    private int A;
    private int B;
    private int C;
    private int D;
    private long E;
    private long F;
    private MotionEvent G;
    private MotionEvent H;
    private boolean I;
    private Runnable J;
    private int K;
    private int L;
    private int M;

    /* renamed from: a */
    private boolean f34911a;

    /* renamed from: b */
    private boolean f34912b;

    /* renamed from: c */
    private String f34913c;

    /* renamed from: d */
    private long f34914d;

    /* renamed from: e */
    private String f34915e;

    /* renamed from: f */
    private float f34916f;

    /* renamed from: g */
    private boolean f34917g;

    /* renamed from: h */
    private boolean f34918h;

    /* renamed from: i */
    private String f34919i;

    /* renamed from: j */
    private int f34920j;
    private long k;
    private long l;
    private int m;
    protected View n;
    protected String o;
    protected Context p;
    protected String q;
    protected com.zk_oaction.adengine.lk_sdkwrapper.d r;
    protected HashMap<ZkViewSDK.KEY, Object> s;
    protected Map t;
    protected ZkViewSDK.a u;
    protected com.zk_oaction.adengine.lk_interfaces.c v;
    private boolean w;
    private Handler x;
    private Handler y;
    private HandlerThread z;

    /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$a */
    class C0810a implements com.zk_oaction.adengine.lk_interfaces.c {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$a$a */
        class RunnableC0811a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f34922a;

            /* renamed from: b */
            final /* synthetic */ int f34923b;

            /* renamed from: c */
            final /* synthetic */ String f34924c;

            RunnableC0811a(String str, int i2, String str2) {
                this.f34922a = str;
                this.f34923b = i2;
                this.f34924c = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.B(this.f34922a, this.f34923b, this.f34924c);
            }
        }

        C0810a() {
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x00a9 A[Catch: all -> 0x00f1, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:6:0x0085, B:8:0x008d, B:9:0x00a3, B:11:0x00a9, B:13:0x00af, B:14:0x00bc, B:16:0x00e6, B:17:0x00b6, B:18:0x00eb, B:22:0x009c), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:22:0x009c A[Catch: all -> 0x00f1, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:6:0x0085, B:8:0x008d, B:9:0x00a3, B:11:0x00a9, B:13:0x00af, B:14:0x00bc, B:16:0x00e6, B:17:0x00b6, B:18:0x00eb, B:22:0x009c), top: B:1:0x0000 }] */
        /* JADX WARN: Removed duplicated region for block: B:8:0x008d A[Catch: all -> 0x00f1, TryCatch #1 {all -> 0x00f1, blocks: (B:2:0x0000, B:6:0x0085, B:8:0x008d, B:9:0x00a3, B:11:0x00a9, B:13:0x00af, B:14:0x00bc, B:16:0x00e6, B:17:0x00b6, B:18:0x00eb, B:22:0x009c), top: B:1:0x0000 }] */
        @Override // com.zk_oaction.adengine.lk_interfaces.c
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void a() {
            /*
                r13 = this;
                com.zk_oaction.adengine.lk_sdkwrapper.a r0 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a.b(r0, r1)     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a r0 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                r1 = 1
                com.zk_oaction.adengine.lk_sdkwrapper.a.q(r0, r1)     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a r0 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.d r0 = r0.r     // Catch: java.lang.Throwable -> Lf1
                java.lang.String r1 = ""
                r2 = 0
                r3 = 0
                if (r0 == 0) goto L83
                com.zk_oaction.adengine.lk_sdk.b r0 = r0.t()     // Catch: java.lang.Throwable -> L83
                java.lang.String r4 = "first_scene_name"
                java.lang.String r0 = r0.j(r4)     // Catch: java.lang.Throwable -> L83
                com.zk_oaction.adengine.lk_sdkwrapper.a r4 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdkwrapper.a.f(r4, r0)     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdkwrapper.a r4 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdkwrapper.d r4 = r4.r     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdk.b r4 = r4.t()     // Catch: java.lang.Throwable -> L81
                java.lang.String r5 = "first_scene_type"
                java.lang.String r4 = r4.j(r5)     // Catch: java.lang.Throwable -> L81
                boolean r5 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> L81
                if (r5 != 0) goto L41
                float r2 = java.lang.Float.parseFloat(r4)     // Catch: java.lang.Throwable -> L81
                int r2 = (int) r2     // Catch: java.lang.Throwable -> L81
            L41:
                com.zk_oaction.adengine.lk_sdkwrapper.a r4 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdkwrapper.d r4 = r4.r     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdk.b r4 = r4.t()     // Catch: java.lang.Throwable -> L81
                java.lang.String r5 = "first_scene_log"
                java.lang.String r4 = r4.j(r5)     // Catch: java.lang.Throwable -> L81
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdkwrapper.d r5 = r5.r     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdk.b r5 = r5.t()     // Catch: java.lang.Throwable -> L85
                java.lang.String r6 = "skip_time"
                java.lang.String r5 = r5.j(r6)     // Catch: java.lang.Throwable -> L85
                boolean r6 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Throwable -> L85
                if (r6 != 0) goto L72
                float r5 = java.lang.Float.parseFloat(r5)     // Catch: java.lang.Throwable -> L85
                int r5 = (int) r5     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdkwrapper.a r6 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L85
                r6.h(r5)     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L85
                r5.g()     // Catch: java.lang.Throwable -> L85
            L72:
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdkwrapper.d r5 = r5.r     // Catch: java.lang.Throwable -> L85
                com.zk_oaction.adengine.lk_sdk.b r5 = r5.t()     // Catch: java.lang.Throwable -> L85
                java.lang.String r6 = "load_success_log"
                java.lang.String r1 = r5.j(r6)     // Catch: java.lang.Throwable -> L85
                goto L85
            L81:
                r4 = r1
                goto L85
            L83:
                r4 = r1
                r0 = r3
            L85:
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.lang.Runnable r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.d(r5)     // Catch: java.lang.Throwable -> Lf1
                if (r5 == 0) goto L9c
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.lang.Runnable r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.d(r5)     // Catch: java.lang.Throwable -> Lf1
                r5.run()     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a r5 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a.e(r5, r3)     // Catch: java.lang.Throwable -> Lf1
                goto La3
            L9c:
                com.zk_oaction.adengine.lk_sdkwrapper.a r3 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.util.HashMap<com.wrapper_oaction.ZkViewSDK$KEY, java.lang.Object> r5 = r3.s     // Catch: java.lang.Throwable -> Lf1
                r3.C(r5)     // Catch: java.lang.Throwable -> Lf1
            La3:
                com.zk_oaction.adengine.lk_sdkwrapper.a r3 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.wrapper_oaction.ZkViewSDK$a r3 = r3.u     // Catch: java.lang.Throwable -> Lf1
                if (r3 == 0) goto Leb
                boolean r3 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lf1
                if (r3 != 0) goto Lb6
                com.zk_oaction.adengine.lk_sdkwrapper.a r3 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.util.Map r1 = com.zk_oaction.adengine.lk_sdkwrapper.a.w(r3, r1)     // Catch: java.lang.Throwable -> Lf1
                goto Lbc
            Lb6:
                com.zk_oaction.adengine.lk_sdkwrapper.a r1 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.util.Map r1 = com.zk_oaction.adengine.lk_sdkwrapper.a.v(r1)     // Catch: java.lang.Throwable -> Lf1
            Lbc:
                com.zk_oaction.adengine.lk_sdkwrapper.a r3 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.wrapper_oaction.ZkViewSDK$a r5 = r3.u     // Catch: java.lang.Throwable -> Lf1
                java.util.Map r6 = r3.t     // Catch: java.lang.Throwable -> Lf1
                int r3 = com.zk_oaction.adengine.lk_sdkwrapper.a.a(r3, r2)     // Catch: java.lang.Throwable -> Lf1
                r5.a(r6, r0, r3, r1)     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a r7 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                java.lang.String r8 = "view_load_success"
                long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a r1 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                long r9 = com.zk_oaction.adengine.lk_sdkwrapper.a.F(r1)     // Catch: java.lang.Throwable -> Lf1
                long r9 = r5 - r9
                java.lang.String r11 = ""
                java.lang.String r12 = ""
                com.zk_oaction.adengine.lk_sdkwrapper.a.k(r7, r8, r9, r11, r12)     // Catch: java.lang.Throwable -> Lf1
                boolean r1 = android.text.TextUtils.isEmpty(r4)     // Catch: java.lang.Throwable -> Lf1
                if (r1 != 0) goto Leb
                com.zk_oaction.adengine.lk_sdkwrapper.a r1 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a.j(r1, r0, r2, r4)     // Catch: java.lang.Throwable -> Lf1
            Leb:
                com.zk_oaction.adengine.lk_sdkwrapper.a r0 = com.zk_oaction.adengine.lk_sdkwrapper.a.this     // Catch: java.lang.Throwable -> Lf1
                com.zk_oaction.adengine.lk_sdkwrapper.a.M(r0)     // Catch: java.lang.Throwable -> Lf1
                goto Lf5
            Lf1:
                r0 = move-exception
                r0.printStackTrace()
            Lf5:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.a.C0810a.a():void");
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void a(String str) {
            a.this.l(str);
            a.this.y();
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void b() {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void b(View view, Map map) {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void c(String str, int i2, String str2, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.u;
            if (aVar2 != null) {
                aVar2.a(aVar.t, str, aVar.r(i2), str2, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void d(String str, int i2, int i3, int i4, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.u;
            if (aVar2 != null) {
                aVar2.a(aVar.t, str, aVar.r(i2), i3, i4, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void e(String str, int i2, int i3, int i4, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.u;
            if (aVar2 != null) {
                aVar2.b(aVar.t, str, aVar.r(i2), i3, i4, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void f(String str, int i2, int i3, int i4, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.u;
            if (aVar2 != null) {
                aVar2.c(aVar.t, str, aVar.r(i2), i3, i4, map);
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void g(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void h(MotionEvent motionEvent, int i2, int i3) {
            if (motionEvent != null) {
                a.this.H = motionEvent;
                a.this.C = i2;
                a.this.D = i3;
                a.this.F = System.currentTimeMillis();
                a.this.B = 0;
                a.this.A = 0;
                a.this.G = null;
                a.this.E = 0L;
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void i(MotionEvent motionEvent, int i2, int i3) {
            if (motionEvent != null) {
                a.this.B = i3;
                a.this.A = i2;
                a.this.G = motionEvent;
                a.this.E = System.currentTimeMillis();
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void j(String str, int i2, String str2) {
            if (a.this.x != null) {
                a.this.x.post(new RunnableC0811a(str, i2, str2));
            }
        }

        @Override // com.zk_oaction.adengine.lk_interfaces.c
        public void k(String str, int i2, int i3, Map map) {
            a aVar = a.this;
            ZkViewSDK.a aVar2 = aVar.u;
            if (aVar2 != null) {
                aVar2.a(aVar.t, str, aVar.r(i2), i3, map);
            }
        }
    }

    class b extends Handler {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$b$a */
        class RunnableC0812a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ String f34927a;

            /* renamed from: b */
            final /* synthetic */ View f34928b;

            /* renamed from: c */
            final /* synthetic */ String f34929c;

            /* renamed from: d */
            final /* synthetic */ Bitmap f34930d;

            RunnableC0812a(String str, View view, String str2, Bitmap bitmap) {
                this.f34927a = str;
                this.f34928b = view;
                this.f34929c = str2;
                this.f34930d = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (a.this.r != null) {
                        if (!TextUtils.isEmpty(this.f34927a)) {
                            a.this.r.t().h("ad_res_index", this.f34927a);
                        }
                        a.this.r.t().f(this.f34928b, this.f34929c, this.f34930d);
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }

        b(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            File[] listFiles;
            int i2 = message.what;
            try {
                if (i2 == 1) {
                    HashMap hashMap = (HashMap) message.obj;
                    View view = (View) hashMap.get("param_view");
                    String str = (String) hashMap.get("param_path");
                    String str2 = (String) hashMap.get("ad_res_index");
                    if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                        Bitmap decodeFile = BitmapFactory.decodeFile(str);
                        if (a.this.x != null) {
                            a.this.x.post(new RunnableC0812a(str2, view, str, decodeFile));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 != 2 || a.this.f34912b) {
                    return;
                }
                ArrayList arrayList = new ArrayList();
                File file = new File(a.this.o + "/adres");
                if (!file.exists() || (listFiles = file.listFiles()) == null) {
                    return;
                }
                for (File file2 : listFiles) {
                    if (!file2.isDirectory()) {
                        arrayList.add(file2.getName());
                    }
                }
                a.this.f34913c = (String) arrayList.get(new Random().nextInt(arrayList.size()));
                String str3 = a.this.o + "adres/" + a.this.f34913c;
                Message obtain = Message.obtain();
                HashMap hashMap2 = new HashMap();
                hashMap2.put("param_view", ((HashMap) message.obj).get("param_view"));
                hashMap2.put("param_path", str3);
                StringBuilder sb = new StringBuilder();
                sb.append("");
                a aVar = a.this;
                sb.append(aVar.E(aVar.f34913c));
                hashMap2.put("ad_res_index", sb.toString());
                obtain.obj = hashMap2;
                obtain.what = 1;
                if (!new File(str3).exists() || a.this.y == null) {
                    return;
                }
                a.this.y.sendMessage(obtain);
            } catch (Throwable unused) {
            }
        }
    }

    class c extends Handler {

        /* renamed from: com.zk_oaction.adengine.lk_sdkwrapper.a$c$a */
        class RunnableC0813a implements Runnable {

            /* renamed from: a */
            final /* synthetic */ HashMap f34933a;

            RunnableC0813a(HashMap hashMap) {
                this.f34933a = hashMap;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.C(this.f34933a);
            }
        }

        c(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            try {
                if (i2 == 101) {
                    if (a.this.M > 0) {
                        a.Y(a.this);
                        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = a.this.r;
                        if (dVar != null && dVar.t() != null) {
                            a.this.r.t().h(ZkViewSDK.c.R, "" + a.this.M);
                        }
                        if (a.this.x != null) {
                            a.this.x.sendEmptyMessageDelayed(101, 1000L);
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (i2 == 102) {
                    HashMap<ZkViewSDK.KEY, Object> hashMap = (HashMap) message.obj;
                    if (a.this.I) {
                        a.this.C(hashMap);
                        return;
                    } else {
                        a.this.J = new RunnableC0813a(hashMap);
                        return;
                    }
                }
                if (i2 == 103) {
                    d dVar2 = (d) message.obj;
                    com.zk_oaction.adengine.lk_sdkwrapper.d dVar3 = a.this.r;
                    if (dVar3 == null || dVar3.t() == null) {
                        return;
                    }
                    a.this.r.t().h("download_state", "" + dVar2.f34935a);
                    a.this.r.t().h("download_progress", "" + dVar2.f34936b);
                }
            } catch (Throwable unused) {
            }
        }
    }

    private class d {

        /* renamed from: a */
        int f34935a;

        /* renamed from: b */
        int f34936b;
    }

    public a(Context context, int i2, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i3, Map map, ZkViewSDK.a aVar) {
        super(context);
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        this.w = false;
        this.s = null;
        this.t = null;
        this.u = null;
        this.I = false;
        this.K = 1;
        this.L = -1;
        this.M = -1;
        this.f34911a = false;
        this.f34914d = 0L;
        this.f34916f = 1.0f;
        this.f34917g = false;
        this.f34918h = false;
        this.v = new C0810a();
        this.m = 0;
        this.p = context;
        this.f34920j = i3;
        this.K = i2;
        this.s = hashMap;
        this.t = map;
        this.u = aVar;
        if (str.endsWith("/")) {
            this.o = str;
        } else {
            this.o = str + "/";
        }
        setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        V();
        X();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0158 A[Catch: all -> 0x016a, TRY_LEAVE, TryCatch #0 {all -> 0x016a, blocks: (B:3:0x0006, B:8:0x000c, B:11:0x0080, B:13:0x0086, B:16:0x008f, B:18:0x00cf, B:21:0x0158, B:26:0x00a5, B:28:0x00ae, B:30:0x00b4, B:33:0x00bd, B:35:0x00e0, B:37:0x00eb, B:39:0x00f1, B:42:0x00fd, B:44:0x011b, B:46:0x0124, B:48:0x012a, B:50:0x012d, B:52:0x0135, B:54:0x0152, B:55:0x0144, B:57:0x0147), top: B:2:0x0006 }] */
    /* JADX WARN: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void B(java.lang.String r25, int r26, java.lang.String r27) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdkwrapper.a.B(java.lang.String, int, java.lang.String):void");
    }

    public int E(String str) {
        try {
            return Integer.parseInt(Pattern.compile("[^0-9]").matcher(str).replaceAll("").trim());
        } catch (Throwable unused) {
            return 0;
        }
    }

    public Map T() {
        HashMap hashMap = new HashMap();
        int i2 = this.L;
        if (i2 >= 0) {
            hashMap.put(ZkViewSDK.c.q, Integer.valueOf(i2 * 1000));
        }
        return hashMap;
    }

    private void V() {
        HandlerThread handlerThread = new HandlerThread("engine_work");
        this.z = handlerThread;
        handlerThread.start();
        this.y = new b(this.z.getLooper());
    }

    private void X() {
        if (this.x == null) {
            this.x = new c(Looper.getMainLooper());
        }
    }

    static /* synthetic */ int Y(a aVar) {
        int i2 = aVar.M;
        aVar.M = i2 - 1;
        return i2;
    }

    public void Z() {
        View a2 = this.r.t().a(ZkViewSDK.c.O);
        if (a2 == null || this.f34912b) {
            return;
        }
        Message obtain = Message.obtain();
        HashMap hashMap = new HashMap();
        hashMap.put("param_view", a2);
        obtain.obj = hashMap;
        obtain.what = 2;
        Handler handler = this.y;
        if (handler != null) {
            handler.sendMessage(obtain);
        }
    }

    public void m(String str, int i2, String str2) {
        try {
            if (this.u != null) {
                this.u.a(this.t, "useraction_openadshow", new ZkViewSDK.Event(), str, r(i2), TextUtils.isEmpty(str2) ? null : x(str2));
            }
        } catch (Throwable unused) {
        }
    }

    public void n(String str, long j2, String str2, String str3) {
        com.zk_oaction.adengine.log.b.a().d(this.p, str, this.o, this.f34919i, (String) this.s.get(ZkViewSDK.KEY.KEY_AD_ID), (String) this.s.get(ZkViewSDK.KEY.KEY_USER_ID), this.f34920j, j2, str2, str3, this.t);
    }

    public int r(int i2) {
        if (i2 == 0) {
            return 0;
        }
        if (i2 != 1) {
            return i2 != 2 ? -1 : 2;
        }
        return 1;
    }

    public Map x(String str) {
        int i2;
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap hashMap = new HashMap();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String obj = keys.next().toString();
            if (!TextUtils.isEmpty(obj) && !obj.equals(ZkViewSDK.c.m) && !obj.equals(ZkViewSDK.c.n) && !obj.equals(ZkViewSDK.c.p)) {
                hashMap.put(obj, jSONObject.getString(obj));
            }
        }
        if (jSONObject.has(ZkViewSDK.c.m)) {
            hashMap.put(ZkViewSDK.c.m, Integer.valueOf(E(this.f34913c)));
        }
        if (jSONObject.has(ZkViewSDK.c.n)) {
            hashMap.put(ZkViewSDK.c.n, this.f34913c);
        }
        if (jSONObject.has(ZkViewSDK.c.p) && this.f34914d != 0) {
            hashMap.put(ZkViewSDK.c.p, Integer.valueOf((int) (System.currentTimeMillis() - this.f34914d)));
            this.f34914d = System.currentTimeMillis();
        }
        if (!jSONObject.has(ZkViewSDK.c.q) || (i2 = this.L) < 0) {
            return hashMap;
        }
        hashMap.put(ZkViewSDK.c.q, Integer.valueOf(i2 * 1000));
        return hashMap;
    }

    public void C(HashMap<ZkViewSDK.KEY, Object> hashMap) {
        Handler handler;
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar;
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar2;
        Handler handler2;
        View view;
        try {
            com.zk_oaction.adengine.lk_sdkwrapper.d dVar3 = this.r;
            if (dVar3 == null || dVar3.t() == null || hashMap == null || hashMap.size() <= 0) {
                return;
            }
            for (Map.Entry<ZkViewSDK.KEY, Object> entry : hashMap.entrySet()) {
                ZkViewSDK.KEY key = entry.getKey();
                Object value = entry.getValue();
                int i2 = key.keyType;
                boolean z = true;
                if (i2 == ZkViewSDK.c.z) {
                    View a2 = this.r.t().a(key.key);
                    if (a2 != null) {
                        try {
                            if (value instanceof String) {
                                String str = (String) value;
                                Message obtain = Message.obtain();
                                HashMap hashMap2 = new HashMap();
                                if (ZkViewSDK.c.O.equals(key.key)) {
                                    this.f34913c = (String) value;
                                    str = this.o + "adres/" + this.f34913c;
                                    this.f34912b = true;
                                    hashMap2.put("ad_res_index", "" + E(this.f34913c));
                                }
                                hashMap2.put("param_view", a2);
                                hashMap2.put("param_path", str);
                                obtain.obj = hashMap2;
                                obtain.what = 1;
                                if (new File(str).exists() && (handler = this.y) != null) {
                                    handler.sendMessage(obtain);
                                }
                            } else if ((value instanceof Bitmap) && (dVar = this.r) != null) {
                                dVar.t().f(a2, null, (Bitmap) value);
                            }
                        } catch (Throwable th) {
                            th = th;
                            th.printStackTrace();
                        }
                    }
                } else if (i2 == ZkViewSDK.c.A && (value instanceof String)) {
                    String str2 = key.key;
                    if (str2 == null || !str2.equals(ZkViewSDK.c.f34678b)) {
                        String str3 = key.key;
                        if (str3 != null && str3.equals(ZkViewSDK.c.f34679c)) {
                            this.f34918h = true;
                        }
                    } else {
                        this.f34917g = true;
                    }
                    if (this.f34917g && this.f34918h) {
                        this.r.t().h("show_developer", "1");
                    }
                    View a3 = this.r.t().a(key.key);
                    if (a3 != null) {
                        String str4 = (String) value;
                        if (!TextUtils.isEmpty(str4)) {
                            this.r.t().e(a3, str4);
                        }
                    }
                } else {
                    if (i2 == ZkViewSDK.c.B && (value instanceof Integer)) {
                        String str5 = key.key;
                        if (str5 == null || !str5.equals(ZkViewSDK.c.R)) {
                            String str6 = key.key;
                            if (str6 == null || !str6.equals(ZkViewSDK.c.k)) {
                                String str7 = key.key;
                                if (str7 == null || !str7.equals(ZkViewSDK.c.S)) {
                                    String str8 = key.key;
                                    if (str8 != null && str8.equals(ZkViewSDK.c.f34685i) && ((Integer) value).intValue() <= 0) {
                                        value = 1;
                                    }
                                    this.r.t().h(key.key, "" + value);
                                } else {
                                    this.r.t().l(((Integer) value).intValue());
                                }
                            } else {
                                if (((Integer) value).intValue() <= 0) {
                                    z = false;
                                }
                                this.f34911a = z;
                                if (this.L > 0 && this.M <= 0) {
                                }
                            }
                        } else {
                            h(((Integer) value).intValue());
                        }
                        g();
                    } else if (i2 == ZkViewSDK.c.C && (value instanceof View)) {
                        View a4 = this.r.t().a(key.key);
                        if ((a4 instanceof com.zk_oaction.adengine.lk_view.e) && (view = (View) value) != null) {
                            if (((com.zk_oaction.adengine.lk_view.e) a4).getChildCount() > 0) {
                                ((com.zk_oaction.adengine.lk_view.e) a4).removeAllViews();
                            }
                            ((com.zk_oaction.adengine.lk_view.e) a4).addView(view);
                        }
                    } else if (i2 == ZkViewSDK.c.D && (value instanceof List)) {
                        try {
                            if (((List) value).size() > 0) {
                                for (int i3 = 0; i3 < ((List) value).size(); i3++) {
                                    Object obj = ((List) value).get(i3);
                                    if (obj instanceof String) {
                                        View a5 = this.r.t().a(key.key + "_" + i3);
                                        if (a5 != null) {
                                            String str9 = (String) obj;
                                            Message obtain2 = Message.obtain();
                                            HashMap hashMap3 = new HashMap();
                                            hashMap3.put("param_view", a5);
                                            hashMap3.put("param_path", str9);
                                            obtain2.obj = hashMap3;
                                            obtain2.what = 1;
                                            if (new File(str9).exists() && (handler2 = this.y) != null) {
                                                handler2.sendMessage(obtain2);
                                            }
                                        }
                                    } else if ((obj instanceof Bitmap) && (dVar2 = this.r) != null) {
                                        View a6 = dVar2.t().a(key.key + "_" + i3);
                                        if (a6 != null) {
                                            this.r.t().f(a6, null, (Bitmap) obj);
                                        }
                                    }
                                }
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            th.printStackTrace();
                        }
                    } else if (i2 == ZkViewSDK.c.E && (value instanceof String)) {
                        try {
                            String str10 = key.key;
                            if (str10 != null && str10.equals(ZkViewSDK.c.f34680d)) {
                                this.r.t().m(key.key, (String) value);
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            th.printStackTrace();
                        }
                    }
                }
            }
        } catch (Throwable th4) {
            th4.printStackTrace();
        }
    }

    public void I() {
        Handler handler;
        synchronized (this) {
            if (this.r != null) {
                this.k = System.currentTimeMillis();
                n("view_resume", -1L, "", "");
                this.w = false;
                this.r.u();
                try {
                    if (this.M > 0 && (handler = this.x) != null) {
                        handler.removeMessages(101);
                        this.x.sendEmptyMessageDelayed(101, 1000L);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public void L() {
        synchronized (this) {
            if (this.r != null && !this.w) {
                n("view_hide", System.currentTimeMillis() - this.k, "", "");
                this.w = true;
                this.r.v();
                try {
                    Handler handler = this.x;
                    if (handler != null) {
                        handler.removeMessages(101);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    public String P() {
        return this.q;
    }

    protected void Q() {
        if (this.n == null || this.r == null) {
            return;
        }
        float measuredWidth = getMeasuredWidth();
        float measuredHeight = getMeasuredHeight();
        float measuredWidth2 = this.n.getMeasuredWidth();
        float measuredHeight2 = this.n.getMeasuredHeight();
        if (measuredHeight2 == 0.0f || measuredWidth2 == 0.0f) {
            return;
        }
        float f2 = measuredWidth / measuredWidth2;
        float f3 = measuredHeight / measuredHeight2;
        float f4 = f3 > f2 ? f2 : f3;
        if (this.K != 2) {
            f2 = f4;
        } else if (f3 >= f2) {
            f2 = f3;
        }
        this.f34916f = f2;
        this.n.setPivotX(0.0f);
        this.n.setPivotY(0.0f);
        this.n.setScaleX(f2);
        this.n.setScaleY(f2);
        this.n.setTranslationX((int) ((measuredWidth - (measuredWidth2 * f2)) / 2.0f));
        this.n.setTranslationY((int) ((measuredHeight - (f2 * measuredHeight2)) / 2.0f));
        forceLayout();
    }

    public void g() {
        int i2;
        try {
            if (this.f34911a && (i2 = this.L) > 0 && this.x != null) {
                this.M = i2;
                com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.r;
                if (dVar != null && dVar.t() != null) {
                    this.r.t().h(ZkViewSDK.c.R, "" + this.M);
                }
                this.x.removeMessages(101);
                this.x.sendEmptyMessageDelayed(101, 1000L);
            }
        } catch (Throwable unused) {
        }
    }

    public void h(int i2) {
        this.L = i2;
    }

    public void i(int i2, int i3) {
        synchronized (this) {
            try {
                this.l = System.currentTimeMillis();
                n("view_start_load", -1L, "", "");
                String frameLayout = toString();
                this.q = this.o + frameLayout.substring(frameLayout.indexOf("{"), frameLayout.indexOf("{") + 8);
                if (this.r == null) {
                    this.r = new com.zk_oaction.adengine.lk_sdkwrapper.d(this.p, 1, i2, i3);
                }
                View r = this.r.r(this.o, this.v);
                this.n = r;
                if (r != null && r.getParent() == null) {
                    addView(this.n);
                    invalidate();
                }
            } finally {
            }
        }
    }

    protected void l(String str) {
        try {
            ZkViewSDK.a aVar = this.u;
            if (aVar != null) {
                aVar.a(this.t, str, null);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void o(HashMap<ZkViewSDK.KEY, Object> hashMap) {
        if (this.x != null) {
            Message obtain = Message.obtain();
            obtain.obj = hashMap;
            obtain.what = 102;
            this.x.removeMessages(102);
            this.x.sendMessage(obtain);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        View view = this.n;
        if (view != null) {
            view.layout(0, 0, view.getMeasuredWidth(), this.n.getMeasuredHeight());
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        try {
            if (this.n != null) {
                int size = View.MeasureSpec.getSize(i2);
                int size2 = View.MeasureSpec.getSize(i3);
                if (size > 0 && size2 > 0) {
                    float o = this.r.t().o();
                    float p = this.r.t().p();
                    float q = this.r.t().q();
                    z(size, size2);
                    int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec((int) (p * o), View.MeasureSpec.getMode(i2));
                    int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec((int) (o * q), View.MeasureSpec.getMode(i3));
                    this.n.measure(makeMeasureSpec, makeMeasureSpec2);
                    ViewGroup viewGroup = (ViewGroup) this.n;
                    for (int i4 = 0; i4 < viewGroup.getChildCount(); i4++) {
                        viewGroup.getChildAt(i4).measure(makeMeasureSpec, makeMeasureSpec2);
                    }
                    Q();
                }
            }
        } catch (Exception e2) {
            l(e2.getMessage());
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void p(boolean z) {
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.r;
        if (dVar == null) {
            return;
        }
        dVar.s(z);
    }

    @Override // android.view.ViewGroup
    public void removeAllViews() {
        this.n = null;
        try {
            super.removeAllViews();
        } catch (Throwable unused) {
        }
    }

    public void y() {
        synchronized (this) {
            try {
                if (this.r != null) {
                    L();
                    n("view_destroy", -1L, "", "");
                    this.r.w();
                    removeAllViews();
                    this.r = null;
                    this.t = null;
                    this.s = null;
                    this.u = null;
                    Handler handler = this.y;
                    if (handler != null) {
                        handler.removeCallbacksAndMessages(null);
                    }
                    HandlerThread handlerThread = this.z;
                    if (handlerThread != null) {
                        handlerThread.quit();
                        this.z = null;
                    }
                    if (this.J != null) {
                        this.J = null;
                    }
                    Handler handler2 = this.x;
                    if (handler2 != null) {
                        handler2.removeCallbacksAndMessages(null);
                        this.x = null;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected void z(int i2, int i3) {
        com.zk_oaction.adengine.lk_sdkwrapper.d dVar = this.r;
        if (dVar == null || dVar.t() == null) {
            return;
        }
        float o = this.r.t().o();
        this.r.t().h("container_width", "" + (i2 / o));
        this.r.t().h("container_height", "" + (i3 / o));
    }
}
