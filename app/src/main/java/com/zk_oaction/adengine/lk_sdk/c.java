package com.zk_oaction.adengine.lk_sdk;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.Time;
import android.view.View;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.vivo.ic.dm.Downloads;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

/* loaded from: classes5.dex */
public class c {

    /* renamed from: a */
    private static final byte[] f34876a = "6^)(9-p35@%3#4S!4S0)$Y%%^&5(j.&^&o(*0)$Y%!#O@*GpG@=+@j.&6^)(0-=+".getBytes(Charset.defaultCharset());

    /* renamed from: b */
    public static int f34877b;

    /* renamed from: c */
    public static int f34878c;

    /* renamed from: d */
    public static float f34879d;

    /* renamed from: e */
    public static float f34880e;
    private com.zk_oaction.adengine.lk_interfaces.c A;
    private HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> B;
    private BroadcastReceiver C;
    private HashMap<String, HashSet<String>> D;
    public Context F;
    public com.zk_oaction.adengine.lk_interfaces.a G;
    public String H;
    public com.zk_oaction.adengine.lk_view.d I;
    public com.zk_oaction.adengine.lk_variable.g J;
    public com.zk_oaction.adengine.lk_animation.c K;
    public HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.f> L;
    public CopyOnWriteArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.a> M;
    public HashMap<com.zk_oaction.adengine.lk_interfaces.b, HashSet<View>> N;
    public ArrayList<com.zk_oaction.adengine.lk_unlock.b> O;
    public float P;
    public boolean R;
    public Thread S;
    public Looper T;
    public Handler U;
    public ArrayList<Bitmap> V;
    public boolean W;
    public boolean X;
    public boolean Y;
    public int Z;
    public int a0;

    /* renamed from: f */
    public boolean f34881f;

    /* renamed from: g */
    public boolean f34882g;

    /* renamed from: h */
    public com.zk_oaction.adengine.lk_interfaces.d f34883h;

    /* renamed from: i */
    public ArrayList<com.zk_oaction.adengine.lk_view.a> f34884i;
    private HashMap<String, com.zk_oaction.adengine.lk_view.c> k;
    private com.zk_oaction.adengine.lk_command.d l;
    private boolean m;
    private Handler n;
    private Time o;
    private com.zk_oaction.adengine.lk_sdk.interfaces.d p;
    private View q;
    private ArrayList<com.zk_oaction.adengine.lk_sdk.interfaces.e> r;
    private boolean s;
    private int u;
    private int v;
    private int w;
    private int x;
    private int y;
    private int z;
    public long Q = 16;
    private boolean t = false;
    private boolean E = false;

    /* renamed from: j */
    public int f34885j = 2000;

    class a implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        a() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.U(xmlPullParser);
            return null;
        }
    }

    class b implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        b() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.Z(xmlPullParser);
            return null;
        }
    }

    /* renamed from: com.zk_oaction.adengine.lk_sdk.c$c */
    class C0809c implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        C0809c() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.d0(xmlPullParser);
            return null;
        }
    }

    class d implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        d() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.h0(xmlPullParser);
            return null;
        }
    }

    class e implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        e() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.k0(xmlPullParser);
            return null;
        }
    }

    class f implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        f() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.n0(xmlPullParser);
            return null;
        }
    }

    class g implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        g() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.q0(xmlPullParser);
            return null;
        }
    }

    class h implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.t0(xmlPullParser);
            return null;
        }
    }

    class i implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        i() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.w0(xmlPullParser);
            return null;
        }
    }

    class j implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        j() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.z0(xmlPullParser);
            return null;
        }
    }

    class k extends Handler {
        k(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            c.this.o.setToNow();
            c cVar = c.this;
            c.this.J.f("second", cVar.J(cVar.o.second));
            sendEmptyMessageDelayed(0, 1000L);
        }
    }

    class l implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        l() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.C0(xmlPullParser);
            return null;
        }
    }

    class m implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        m() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.F0(xmlPullParser);
            return null;
        }
    }

    class n implements Runnable {
        n() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J0();
            if (c.this.m) {
                c.this.r0();
            }
        }
    }

    class o implements Runnable {
        o() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.A != null) {
                c.this.A.a("parser error");
            }
        }
    }

    class p implements FileFilter {
        p(c cVar) {
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            String name = file.getName();
            return !name.startsWith("manifest") && name.contains("manifest") && name.endsWith(".xml");
        }
    }

    class q extends BroadcastReceiver {
        q() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.TIME_TICK".equals(intent.getAction()) || "android.intent.action.TIME_SET".equals(intent.getAction()) || "android.intent.action.TIMEZONE_CHANGED".equals(intent.getAction())) {
                c.this.o0();
            }
        }
    }

    class r implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f34902a;

        /* renamed from: b */
        final /* synthetic */ String f34903b;

        r(String str, String str2) {
            this.f34902a = str;
            this.f34903b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.J.f(this.f34902a, this.f34903b);
        }
    }

    class s implements Runnable {
        s() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.D0();
            c.this.t = false;
        }
    }

    class t extends Thread {

        /* renamed from: a */
        final /* synthetic */ Runnable f34906a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        t(c cVar, String str, Runnable runnable) {
            super(str);
            this.f34906a = runnable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            this.f34906a.run();
        }
    }

    class u implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        u() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.x(xmlPullParser);
            return null;
        }
    }

    class v implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        v() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.x(xmlPullParser);
            return null;
        }
    }

    class w implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        w() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.I(xmlPullParser);
            return null;
        }
    }

    class x implements com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> {
        x() {
        }

        @Override // com.zk_oaction.adengine.lk_sdk.interfaces.c
        /* renamed from: b */
        public Void a(XmlPullParser xmlPullParser) {
            c.this.P(xmlPullParser);
            return null;
        }
    }

    public c(Context context, com.zk_oaction.adengine.lk_interfaces.a aVar) {
        this.F = context;
        this.G = aVar;
        l0();
        if (f34877b / f34878c >= 0.562f) {
            this.Y = true;
        }
        this.J = new com.zk_oaction.adengine.lk_variable.g(this);
        this.K = new com.zk_oaction.adengine.lk_animation.c(this);
        this.L = new HashMap<>();
        this.k = new HashMap<>();
        this.M = new CopyOnWriteArrayList<>();
        this.O = new ArrayList<>();
        this.N = new HashMap<>();
        this.V = new ArrayList<>();
        this.f34884i = new ArrayList<>();
        this.D = new HashMap<>();
        Looper mainLooper = Looper.getMainLooper();
        this.T = mainLooper;
        this.S = mainLooper.getThread();
        this.U = new Handler(this.T);
        this.r = new ArrayList<>();
        this.z = -1;
        this.y = -1;
        this.x = -1;
        this.w = -1;
        this.v = -1;
        this.u = -1;
        A0();
    }

    private void A0() {
        HashMap<String, com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void>> hashMap = new HashMap<>();
        this.B = hashMap;
        hashMap.put("Lockscreen", new u());
        this.B.put("Root", new v());
        this.B.put("Var", new w());
        this.B.put("ExternalCommands", new x());
        this.B.put("VarArray", new a());
        this.B.put("Group", new b());
        this.B.put("Image", new C0809c());
        this.B.put("Frame", new d());
        this.B.put("ImageNumber", new e());
        this.B.put("Text", new f());
        this.B.put("Button", new g());
        this.B.put("Slider", new h());
        this.B.put("VariableBinders", new i());
        this.B.put("UnlockerView", new j());
        this.B.put("Video", new l());
        this.B.put("ParticleView", new m());
    }

    public void C0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.c cVar = new com.zk_oaction.adengine.lk_view.c(this);
        if (cVar.h(xmlPullParser, "Video")) {
            this.I.g(cVar);
            if (cVar.e() != null) {
                this.k.put(cVar.e(), cVar);
                this.L.put(cVar.e(), cVar);
            }
        }
    }

    public void D0() {
        com.zk_oaction.adengine.lk_sdk.interfaces.c<XmlPullParser, Void> cVar;
        p(this, this.H, this.F, this.J);
        String K = K(this.H);
        InputStream inputStream = null;
        this.p = null;
        try {
            XmlPullParserFactory newInstance = XmlPullParserFactory.newInstance();
            newInstance.setFeature("http://xmlpull.org/v1/doc/features.html#process-docdecl", false);
            XmlPullParser newPullParser = newInstance.newPullParser();
            inputStream = Q(this.H + K);
            newPullParser.setInput(inputStream, "utf-8");
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (this.f34882g) {
                    break;
                }
                if (eventType == 2 && (cVar = this.B.get(newPullParser.getName())) != null) {
                    cVar.a(newPullParser);
                }
            }
            try {
                inputStream.close();
            } catch (Throwable unused) {
            }
            if (this.E) {
                return;
            }
            G0();
        } catch (Throwable th) {
            try {
                this.E = true;
                th.printStackTrace();
                H0();
                try {
                    inputStream.close();
                } catch (Throwable unused2) {
                }
            } catch (Throwable th2) {
                try {
                    inputStream.close();
                } catch (Throwable unused3) {
                }
                throw th2;
            }
        }
    }

    public void F0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.l lVar = new com.zk_oaction.adengine.lk_view.l(this);
        if (lVar.g(xmlPullParser, "ParticleView")) {
            this.M.add(lVar);
        }
    }

    private void G0() {
        if (this.f34882g) {
            return;
        }
        if (Thread.currentThread() == this.S) {
            J0();
        } else {
            this.U.post(new n());
        }
    }

    private void H0() {
        try {
            o oVar = new o();
            if (Thread.currentThread() != this.S) {
                this.U.post(oVar);
            } else {
                oVar.run();
            }
        } catch (Throwable unused) {
        }
    }

    public void I(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "name");
        com.zk_oaction.adengine.lk_variable.d a2 = this.J.a(attributeValue);
        if (a2 == null) {
            a2 = new com.zk_oaction.adengine.lk_variable.d(this, attributeValue);
            this.J.d(a2);
        }
        a2.d(xmlPullParser);
    }

    private void I0() {
        if (!this.f34881f) {
            this.f34881f = true;
            this.G.b();
        }
        if (this.H.endsWith("/")) {
            return;
        }
        this.H += "/";
    }

    public String J(int i2) {
        return ("" + (i2 / 10)) + (i2 % 10);
    }

    public void J0() {
        if (this.f34882g) {
            return;
        }
        com.zk_oaction.adengine.lk_interfaces.c cVar = this.A;
        if (cVar != null) {
            cVar.a();
        }
        if (K0() || L0() || M0()) {
            C();
        }
        if (this.J.a("second") != null) {
            k();
        }
        if (this.J.a(com.alipay.mobilesecuritysdk.deviceID.c.y) != null) {
            this.K.c(new com.zk_oaction.adengine.lk_animation.h(this));
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.l;
        if (dVar != null) {
            dVar.a("pause");
        }
        if (this.f34881f) {
            this.f34881f = false;
            this.G.c();
        }
    }

    private String K(String str) {
        String R = R(str, "manifest.xml");
        if (!TextUtils.isEmpty(R)) {
            return R;
        }
        File file = new File(str + "manifest_110.xml");
        return file.exists() ? file.getName() : L(str, "manifest.xml");
    }

    private boolean K0() {
        return (this.J.a("year") == null && this.J.a("month") == null && this.J.a("date") == null) ? false : true;
    }

    private String L(String str, String str2) {
        File[] listFiles = new File(str).listFiles();
        if (listFiles == null) {
            return str2;
        }
        File file = null;
        int i2 = 0;
        for (File file2 : listFiles) {
            if (!file2.isDirectory()) {
                String name = file2.getName();
                if (name.startsWith("manifest") && name.endsWith(".xml") && !name.equals("manifest.xml")) {
                    try {
                        int parseInt = Integer.parseInt(name.substring(9, name.indexOf(".xml")));
                        if (parseInt < 110 && parseInt / 100 == 1 && i2 < parseInt) {
                            file = file2;
                            i2 = parseInt;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return file != null ? file.getName() : str2;
    }

    private boolean L0() {
        return (this.J.a("hour") == null && this.J.a("hour24") == null && this.J.a("hour12") == null) ? false : true;
    }

    private boolean M0() {
        return (this.J.a("day_of_week") == null && this.J.a("minute") == null) ? false : true;
    }

    private static String N0() {
        try {
            Class<?> cls = Class.forName("android.os.LocaleList");
            Method declaredMethod = cls.getDeclaredMethod("getDefault", new Class[0]);
            declaredMethod.setAccessible(true);
            return cls.getDeclaredMethod(MonitorConstants.CONNECT_TYPE_GET, Integer.TYPE).invoke(declaredMethod.invoke(null, new Object[0]), 0).toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    private void O0() {
        if (this.C == null) {
            this.C = new q();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_TICK");
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            Context context = this.F;
            if (context != null) {
                context.registerReceiver(this.C, intentFilter);
            }
        }
    }

    public void P(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.d dVar = new com.zk_oaction.adengine.lk_command.d(this);
        this.l = dVar;
        if (dVar.b(xmlPullParser, "ExternalCommands")) {
            return;
        }
        this.l = null;
    }

    private void P0() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.F;
        if (context == null || (broadcastReceiver = this.C) == null) {
            return;
        }
        try {
            context.unregisterReceiver(broadcastReceiver);
            this.C = null;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private InputStream Q(String str) {
        FileInputStream fileInputStream;
        int length = f34876a.length;
        byte[] bArr = new byte[512];
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            fileInputStream = new FileInputStream(new File(str));
            int i2 = 3;
            try {
                if (fileInputStream.read(bArr, 0, 3) != -1 && bArr[0] == 101 && bArr[1] == 110 && bArr[2] == 99) {
                    int i3 = 0;
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        for (int i4 = 0; i4 < read; i4++) {
                            bArr[i4] = (byte) (bArr[i4] ^ f34876a[i3]);
                            byteArrayOutputStream.write(bArr[i4]);
                            i3++;
                            if (i3 == length) {
                                i3 = 0;
                            }
                        }
                    }
                } else {
                    do {
                        byteArrayOutputStream.write(bArr, 0, i2);
                        i2 = fileInputStream.read(bArr);
                    } while (i2 != -1);
                }
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
                try {
                    fileInputStream.close();
                } catch (Throwable unused) {
                }
                return byteArrayInputStream;
            } catch (Throwable unused2) {
                try {
                    fileInputStream.close();
                    return null;
                } catch (Throwable unused3) {
                    return null;
                }
            }
        } catch (Throwable unused4) {
            fileInputStream = null;
        }
    }

    private String R(String str, String str2) {
        File[] listFiles = new File(str).listFiles(new p(this));
        if (listFiles != null && listFiles.length > 0) {
            float f2 = f34878c / f34877b;
            float abs = Math.abs(f2 - 1.7777778f);
            String str3 = str2;
            for (File file : listFiles) {
                try {
                    String name = file.getName();
                    String[] split = name.substring(0, name.indexOf("manifest") - 1).split("_");
                    float abs2 = Math.abs(f2 - (Float.parseFloat(split[0]) / Float.parseFloat(split[1])));
                    if (abs2 < abs) {
                        try {
                            str3 = file.getName();
                        } catch (Throwable unused) {
                        }
                        abs = abs2;
                    } else if (abs2 == abs) {
                        if (a(file.getName()) > a(str3)) {
                            str3 = file.getName();
                        }
                    }
                } catch (Throwable unused2) {
                }
            }
            if (!str3.equals(str2)) {
                return str3;
            }
        }
        return null;
    }

    public void U(XmlPullParser xmlPullParser) {
        new com.zk_oaction.adengine.lk_variable.c(this).b(xmlPullParser);
    }

    public void Z(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.f fVar = new com.zk_oaction.adengine.lk_view.f(this);
        if (fVar.s(xmlPullParser, "Group")) {
            this.I.h(fVar);
            if (fVar.e() != null) {
                this.L.put(fVar.e(), fVar);
            }
        }
    }

    public static int a(String str) {
        if (str.contains("manifest_")) {
            try {
                String substring = str.substring(str.indexOf("manifest"));
                return Integer.parseInt(substring.substring(9, substring.indexOf(".xml")));
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    public void d0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.g gVar = new com.zk_oaction.adengine.lk_view.g(this);
        if (gVar.W(xmlPullParser, "Image")) {
            this.I.h(gVar);
            if (gVar.e() != null) {
                this.L.put(gVar.e(), gVar);
            }
        }
    }

    private static String h(Context context) {
        String N0;
        String locale = context.getResources().getConfiguration().locale.toString();
        if (Build.VERSION.SDK_INT >= 24 && (N0 = N0()) != null) {
            locale = N0;
        }
        return locale.contains("zh_CN") ? "zh_CN" : locale;
    }

    public void h0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.e eVar = new com.zk_oaction.adengine.lk_view.e(this);
        if (eVar.T(xmlPullParser, "Frame")) {
            this.I.h(eVar);
            if (eVar.e() != null) {
                this.L.put(eVar.e(), eVar);
            }
        }
    }

    private static String j(File file, String str) {
        String[] list = file.list();
        if (list != null) {
            for (String str2 : list) {
                String str3 = "strings_" + str + ".xml";
                if (str2.equals(str3)) {
                    return str3;
                }
            }
        }
        return "strings.xml";
    }

    public void k0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.i iVar = new com.zk_oaction.adengine.lk_view.i(this);
        if (iVar.R(xmlPullParser, "ImageNumber")) {
            this.I.h(iVar);
            if (iVar.e() != null) {
                this.L.put(iVar.e(), iVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void l0() {
        /*
            r11 = this;
            android.content.Context r0 = r11.F
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            r0.getMetrics(r1)
            int r2 = r1.widthPixels
            int r1 = r1.heightPixels
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 17
            r5 = 0
            r6 = 15
            if (r3 < r6) goto L56
            if (r3 >= r4) goto L56
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r6 = "getRawWidth"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L52
            java.lang.reflect.Method r3 = r3.getMethod(r6, r7)     // Catch: java.lang.Exception -> L52
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L52
            java.lang.Object r3 = r3.invoke(r0, r6)     // Catch: java.lang.Exception -> L52
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L52
            int r2 = r3.intValue()     // Catch: java.lang.Exception -> L52
            java.lang.Class<android.view.Display> r3 = android.view.Display.class
            java.lang.String r6 = "getRawHeight"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch: java.lang.Exception -> L52
            java.lang.reflect.Method r3 = r3.getMethod(r6, r7)     // Catch: java.lang.Exception -> L52
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch: java.lang.Exception -> L52
            java.lang.Object r3 = r3.invoke(r0, r6)     // Catch: java.lang.Exception -> L52
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch: java.lang.Exception -> L52
            int r1 = r3.intValue()     // Catch: java.lang.Exception -> L52
            goto L56
        L52:
            r3 = move-exception
            r3.printStackTrace()
        L56:
            int r3 = android.os.Build.VERSION.SDK_INT
            if (r3 < r4) goto L84
            android.graphics.Point r3 = new android.graphics.Point     // Catch: java.lang.Exception -> L7c
            r3.<init>()     // Catch: java.lang.Exception -> L7c
            java.lang.Class<android.view.Display> r4 = android.view.Display.class
            java.lang.String r6 = "getRealSize"
            r7 = 1
            java.lang.Class[] r8 = new java.lang.Class[r7]     // Catch: java.lang.Exception -> L7c
            java.lang.Class<android.graphics.Point> r9 = android.graphics.Point.class
            r8[r5] = r9     // Catch: java.lang.Exception -> L7c
            java.lang.reflect.Method r4 = r4.getMethod(r6, r8)     // Catch: java.lang.Exception -> L7c
            java.lang.Object[] r6 = new java.lang.Object[r7]     // Catch: java.lang.Exception -> L7c
            r6[r5] = r3     // Catch: java.lang.Exception -> L7c
            r4.invoke(r0, r6)     // Catch: java.lang.Exception -> L7c
            int r0 = r3.x     // Catch: java.lang.Exception -> L7c
            int r1 = r3.y     // Catch: java.lang.Exception -> L7a
            goto L85
        L7a:
            r2 = move-exception
            goto L80
        L7c:
            r0 = move-exception
            r10 = r2
            r2 = r0
            r0 = r10
        L80:
            r2.printStackTrace()
            r2 = r0
        L84:
            r0 = r2
        L85:
            if (r0 <= r1) goto L8a
            r10 = r1
            r1 = r0
            r0 = r10
        L8a:
            com.zk_oaction.adengine.lk_sdk.c.f34877b = r0
            com.zk_oaction.adengine.lk_sdk.c.f34878c = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_sdk.c.l0():void");
    }

    public void n0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_view.m mVar = new com.zk_oaction.adengine.lk_view.m(this);
        if (mVar.R(xmlPullParser, "Text")) {
            this.I.h(mVar);
            if (mVar.e() != null) {
                this.L.put(mVar.e(), mVar);
            }
        }
    }

    public void o0() {
        String J;
        this.o.setToNow();
        int i2 = this.u;
        int i3 = this.o.year;
        if (i2 != i3) {
            this.u = i3;
            this.J.f("year", "" + this.o.year);
        }
        int i4 = this.v;
        int i5 = this.o.month;
        if (i4 != i5) {
            this.v = i5;
            this.J.f("month", "" + this.o.month);
        }
        int i6 = this.w;
        int i7 = this.o.monthDay;
        if (i6 != i7) {
            this.w = i7;
            this.J.f("date", "" + this.o.monthDay);
        }
        int i8 = this.x;
        int i9 = this.o.weekDay;
        if (i8 != i9) {
            this.x = i9;
            this.J.f("day_of_week", "" + (this.o.weekDay + 1));
        }
        int i10 = this.y;
        int i11 = this.o.hour;
        if (i10 != i11) {
            this.y = i11;
            this.J.f("hour", "" + this.o.hour);
            if (this.R) {
                J = J(this.o.hour % 12);
                if (J.equals("00")) {
                    this.J.f("hour24", "12");
                    this.J.f("hour12", "12");
                }
            } else {
                J = J(this.o.hour);
            }
            this.J.f("hour24", J);
            this.J.f("hour12", J);
        }
        int i12 = this.z;
        int i13 = this.o.minute;
        if (i12 != i13) {
            this.z = i13;
            this.J.f("minute", J(i13));
        }
    }

    public void q0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_command.a aVar = new com.zk_oaction.adengine.lk_command.a(this);
        if (aVar.e(xmlPullParser, "Button")) {
            this.M.add(aVar);
            if (aVar.e() != null) {
                this.L.put(aVar.e(), aVar);
            }
        }
    }

    public void r0() {
        if (this.f34882g) {
            return;
        }
        this.K.e();
        Handler handler = this.n;
        if (handler != null) {
            handler.sendEmptyMessage(0);
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.l;
        if (dVar != null) {
            dVar.a("resume");
        }
        Iterator<Map.Entry<String, com.zk_oaction.adengine.lk_view.c>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().i();
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar2 = this.p;
        if (dVar2 != null) {
            dVar2.a();
        }
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.e> it2 = this.r.iterator();
        while (it2.hasNext()) {
            it2.next().a();
        }
    }

    public void t0(XmlPullParser xmlPullParser) {
        com.zk_oaction.adengine.lk_unlock.b bVar = new com.zk_oaction.adengine.lk_unlock.b(this);
        if (bVar.i(xmlPullParser, "Slider")) {
            this.M.add(bVar);
            if (bVar.e() != null) {
                this.L.put(bVar.e(), bVar);
            }
        }
    }

    private void u0() {
        this.K.f();
        Handler handler = this.n;
        if (handler != null) {
            handler.removeMessages(0);
        }
        com.zk_oaction.adengine.lk_command.d dVar = this.l;
        if (dVar != null) {
            dVar.a("pause");
        }
        Iterator<Map.Entry<String, com.zk_oaction.adengine.lk_view.c>> it = this.k.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().j();
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar2 = this.p;
        if (dVar2 != null) {
            dVar2.b();
        }
        Iterator<com.zk_oaction.adengine.lk_sdk.interfaces.e> it2 = this.r.iterator();
        while (it2.hasNext()) {
            it2.next().b();
        }
    }

    public void w0(XmlPullParser xmlPullParser) {
        new com.zk_oaction.adengine.lk_variable.e(this).a(xmlPullParser, "VariableBinders");
    }

    public void x(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "screenWidth");
        int parseInt = attributeValue != null ? Integer.parseInt(attributeValue) : 720;
        int i2 = f34877b;
        int i3 = f34878c;
        if (i2 > i3) {
            i3 = i2;
            i2 = i3;
        }
        if (this.Y) {
            i3 = (i2 * 16) / 9;
        }
        float f2 = i2;
        float f3 = f2 / parseInt;
        this.P = f3;
        f34879d = f2 / f3;
        float f4 = i3;
        f34880e = f4 / f3;
        this.J.f("screen_width", "" + f34879d);
        this.J.f("screen_height", "" + f34880e);
        float f5 = this.P;
        this.Z = (int) (f2 / f5);
        this.a0 = (int) (f4 / f5);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "displayWidth");
        if (attributeValue2 != null) {
            this.Z = Integer.parseInt(attributeValue2);
        }
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "displayHeight");
        if (attributeValue3 != null) {
            this.a0 = Integer.parseInt(attributeValue3);
        }
        String attributeValue4 = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue4 != null && !attributeValue4.equals("0")) {
            this.Q = 1000 / Integer.parseInt(attributeValue4);
        }
        xmlPullParser.getAttributeValue(null, "id");
        String attributeValue5 = xmlPullParser.getAttributeValue(null, "vibrate");
        this.s = attributeValue5 != null ? Boolean.parseBoolean(attributeValue5) : true;
        String attributeValue6 = xmlPullParser.getAttributeValue(null, "pressure");
        if (attributeValue6 != null) {
            this.W = Boolean.parseBoolean(attributeValue6);
        }
    }

    private void x0() {
        this.J.c();
        this.K.b();
        this.L.clear();
        this.k.clear();
        this.M.clear();
        this.O.clear();
        this.N.clear();
        this.l = null;
        this.p = null;
        Iterator<Bitmap> it = this.V.iterator();
        while (it.hasNext()) {
            it.next().recycle();
        }
        this.V.clear();
        this.B.clear();
        for (int i2 = 0; i2 < this.f34884i.size(); i2++) {
            if (this.f34884i.get(i2) != null) {
                this.f34884i.get(i2).p();
            }
        }
        this.f34884i.clear();
    }

    public void z0(XmlPullParser xmlPullParser) {
        try {
            com.zk_oaction.adengine.lk_sdk.interfaces.d dVar = (com.zk_oaction.adengine.lk_sdk.interfaces.d) Class.forName(xmlPullParser.getAttributeValue(null, "class")).newInstance();
            this.p = dVar;
            this.I.g(dVar.a(xmlPullParser.getAttributeValue(null, "params"), this));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public boolean A(String str, HashSet<String> hashSet) {
        if (hashSet != null && hashSet.contains(str)) {
            return false;
        }
        HashSet hashSet2 = new HashSet();
        Iterator<String> it = hashSet.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (this.D.containsKey(next)) {
                if (this.D.get(next).contains(str)) {
                    return false;
                }
                hashSet2.add(next);
            }
        }
        Iterator it2 = hashSet2.iterator();
        while (it2.hasNext()) {
            String str2 = (String) it2.next();
            HashSet<String> hashSet3 = this.D.get(str2);
            hashSet.remove(str2);
            hashSet.addAll(hashSet3);
        }
        hashSet2.clear();
        for (Map.Entry<String, HashSet<String>> entry : this.D.entrySet()) {
            if (entry.getValue().contains(str)) {
                if (hashSet.contains(entry.getKey())) {
                    return false;
                }
                hashSet2.add(entry.getKey());
            }
        }
        Iterator it3 = hashSet2.iterator();
        while (it3.hasNext()) {
            HashSet<String> hashSet4 = this.D.get((String) it3.next());
            hashSet4.remove(str);
            hashSet4.addAll(hashSet);
        }
        this.D.put(str, hashSet);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public View B(String str) {
        String e2;
        if (this.I == null) {
            return null;
        }
        for (int i2 = 0; i2 < this.I.a(); i2++) {
            View b2 = this.I.b(i2);
            if ((b2 instanceof com.zk_oaction.adengine.lk_sdk.interfaces.f) && (e2 = ((com.zk_oaction.adengine.lk_sdk.interfaces.f) b2).e()) != null && e2.equals(str)) {
                return b2;
            }
        }
        return null;
    }

    public void C() {
        Time time = new Time();
        this.o = time;
        time.setToNow();
        O0();
        M();
        o0();
    }

    public void D(int i2) {
        if (i2 > 0) {
            this.f34885j = i2;
        }
    }

    public void G(String str, float f2) {
        com.zk_oaction.adengine.lk_interfaces.d dVar = this.f34883h;
        if (dVar != null) {
            dVar.a(str, f2);
        }
    }

    public void H(String str, String str2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.k.get(str);
        if (cVar != null) {
            cVar.m(str2);
        }
    }

    public void M() {
        com.zk_oaction.adengine.lk_variable.g gVar;
        int i2;
        String str;
        String string = Settings.System.getString(this.F.getContentResolver(), "time_12_24");
        boolean z = true;
        if (string == null || string.equals("24")) {
            try {
                z = true ^ DateFormat.is24HourFormat(this.F);
            } catch (Exception unused) {
                z = false;
            }
        }
        Time time = new Time();
        this.o = time;
        time.setToNow();
        this.J.f("hour", "" + this.o.hour);
        this.y = this.o.hour;
        this.R = z;
        this.J.f("ishour12", "" + z);
        if (this.R) {
            int i3 = this.o.hour % 12;
            if (i3 == 0) {
                this.J.f("hour24", J(12));
                gVar = this.J;
                str = J(12);
                gVar.f("hour12", str);
            }
            this.J.f("hour24", J(i3));
            gVar = this.J;
            i2 = this.o.hour % 12;
        } else {
            this.J.f("hour24", J(this.o.hour));
            gVar = this.J;
            i2 = this.o.hour;
        }
        str = J(i2);
        gVar.f("hour12", str);
    }

    public void S() {
        if (this.n != null) {
            M();
        }
        if (this.m) {
            return;
        }
        this.m = true;
        View view = this.q;
        if (view != null) {
            view.setVisibility(0);
        } else {
            if (this.f34881f) {
                return;
            }
            r0();
        }
    }

    public void W() {
        if (this.m) {
            this.m = false;
            View view = this.q;
            if (view != null) {
                view.setVisibility(4);
            } else {
                if (this.f34881f) {
                    return;
                }
                u0();
            }
        }
    }

    public Rect b(com.zk_oaction.adengine.lk_view.b bVar) {
        Rect rect = new Rect();
        rect.left = (int) bVar.getX();
        rect.top = (int) bVar.getY();
        rect.right = (int) (rect.left + bVar.M());
        rect.bottom = (int) (rect.top + bVar.O());
        return rect;
    }

    public void b0() {
        this.f34882g = true;
        W();
        if (this.f34883h != null) {
            for (Map.Entry<String, com.zk_oaction.adengine.lk_view.c> entry : this.k.entrySet()) {
                this.f34883h.a();
            }
        }
        com.zk_oaction.adengine.lk_sdk.interfaces.d dVar = this.p;
        if (dVar != null) {
            dVar.c();
        }
        try {
            Iterator<Map.Entry<String, com.zk_oaction.adengine.lk_view.c>> it = this.k.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().c();
            }
        } catch (Throwable unused) {
        }
        x0();
        P0();
    }

    public Rect c(com.zk_oaction.adengine.lk_view.c cVar) {
        Rect rect = new Rect();
        rect.left = (int) cVar.o();
        rect.top = (int) cVar.p();
        rect.right = (int) (rect.left + cVar.k());
        rect.bottom = (int) (rect.top + cVar.n());
        return rect;
    }

    public View e(String str, com.zk_oaction.adengine.lk_interfaces.c cVar) {
        if (this.t) {
            return null;
        }
        this.t = true;
        this.A = cVar;
        this.I = new com.zk_oaction.adengine.lk_view.d(this);
        this.H = str;
        I0();
        t tVar = new t(this, "load_view", new s());
        tVar.setPriority(10);
        tVar.start();
        return this.I;
    }

    public float e0() {
        return f34880e;
    }

    public com.zk_oaction.adengine.lk_interfaces.b f(String str, View view, float f2, int i2) {
        com.zk_oaction.adengine.lk_interfaces.b a2 = this.G.a(this.H + str, f2, i2);
        HashSet<View> hashSet = this.N.get(a2);
        if (hashSet == null) {
            hashSet = new HashSet<>();
            this.N.put(a2, hashSet);
        }
        hashSet.add(view);
        return a2;
    }

    public com.zk_oaction.adengine.lk_interfaces.b g(String str, View view, int i2) {
        return f(str, view, this.P, i2);
    }

    public float i0() {
        return f34879d;
    }

    public void k() {
        if (this.n == null) {
            Time time = new Time();
            this.o = time;
            time.setToNow();
            this.n = new k(this.T);
            this.J.f("second", J(this.o.second));
        }
    }

    public void l(int i2) {
    }

    public void m(long j2) {
        if (this.s) {
            this.G.a(j2);
        }
    }

    public void n(com.zk_oaction.adengine.lk_animation.b bVar) {
        this.K.c(bVar);
    }

    public void o(com.zk_oaction.adengine.lk_interfaces.b bVar) {
        HashSet<View> hashSet = this.N.get(bVar);
        if (hashSet != null) {
            Iterator<View> it = hashSet.iterator();
            while (it.hasNext()) {
                it.next().invalidate();
            }
        }
    }

    public void p(c cVar, String str, Context context, com.zk_oaction.adengine.lk_variable.g gVar) {
        File file = new File(str + "strings");
        if (file.exists() && file.isDirectory()) {
            File file2 = new File(str + "strings/" + j(file, h(context)));
            if (file2.exists()) {
                FileInputStream fileInputStream = null;
                try {
                    XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                    FileInputStream fileInputStream2 = new FileInputStream(file2);
                    try {
                        newPullParser.setInput(fileInputStream2, "utf-8");
                        for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                            if (eventType == 2) {
                                if (newPullParser.getName().equals("string")) {
                                    String attributeValue = newPullParser.getAttributeValue(null, "name");
                                    com.zk_oaction.adengine.lk_variable.d a2 = gVar.a(attributeValue);
                                    if (a2 == null) {
                                        a2 = new com.zk_oaction.adengine.lk_variable.d(cVar, attributeValue);
                                        gVar.d(a2);
                                    }
                                    a2.f(newPullParser.getAttributeValue(null, Downloads.RequestHeaders.COLUMN_VALUE));
                                }
                            }
                        }
                    } catch (Throwable unused) {
                    }
                    fileInputStream = fileInputStream2;
                } catch (Throwable unused2) {
                }
                try {
                    fileInputStream.close();
                } catch (Throwable unused3) {
                }
            }
        }
    }

    public void r(com.zk_oaction.adengine.lk_unlock.b bVar) {
        int i2 = 0;
        if (!bVar.m()) {
            while (i2 < this.O.size()) {
                this.O.get(i2).a("true");
                i2++;
            }
        } else {
            bVar.a("true");
            while (i2 < this.O.size()) {
                com.zk_oaction.adengine.lk_unlock.b bVar2 = this.O.get(i2);
                if (bVar2 != bVar) {
                    bVar2.a("false");
                }
                i2++;
            }
        }
    }

    public void s(String str, float f2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.k.get(str);
        if (cVar != null) {
            cVar.d(f2);
        }
    }

    public void t(String str, com.zk_oaction.adengine.lk_variable.f fVar) {
        this.J.e(str, fVar);
    }

    public void u(String str, String str2) {
        r rVar = new r(str, str2);
        if (Thread.currentThread() != this.S) {
            this.U.post(rVar);
        } else {
            rVar.run();
        }
    }

    public void v(String str, String str2, String str3, int i2, String str4, String str5) {
        com.zk_oaction.adengine.lk_view.c cVar = this.k.get(str);
        if (cVar != null) {
            cVar.e(str2, i2, str3, str4, str5);
        }
    }

    public void w(String str, boolean z, boolean z2) {
        com.zk_oaction.adengine.lk_view.c cVar = this.k.get(str);
        if (cVar != null) {
            cVar.g(z, z2);
        }
    }

    public void y(boolean z) {
        try {
            HashMap<String, com.zk_oaction.adengine.lk_view.c> hashMap = this.k;
            if (hashMap != null) {
                Iterator<Map.Entry<String, com.zk_oaction.adengine.lk_view.c>> it = hashMap.entrySet().iterator();
                while (it.hasNext()) {
                    it.next().getValue().f(z);
                }
            }
        } catch (Throwable unused) {
        }
    }
}
