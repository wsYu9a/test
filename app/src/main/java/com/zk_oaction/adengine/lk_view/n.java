package com.zk_oaction.adengine.lk_view;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.ViewGroup;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.cdo.oaps.ad.OapsKey;
import com.vivo.ic.dm.Downloads;
import com.zk_oaction.adengine.lk_expression.a;
import com.zk_oaction.adengine.lk_expression.c;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.apache.http.HttpHost;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;

/* loaded from: classes5.dex */
public class n extends TextureView implements MediaPlayer.OnPreparedListener, TextureView.SurfaceTextureListener, a.w {
    public float A;
    public AudioManager B;
    public boolean C;
    public float D;
    private boolean E;
    private i F;
    private boolean G;
    private String H;

    /* renamed from: a */
    private boolean f35171a;

    /* renamed from: b */
    private int f35172b;

    /* renamed from: c */
    private int f35173c;

    /* renamed from: d */
    private Map f35174d;

    /* renamed from: e */
    private boolean f35175e;

    /* renamed from: f */
    private boolean f35176f;

    /* renamed from: g */
    private Handler f35177g;

    /* renamed from: h */
    private AudioManager.OnAudioFocusChangeListener f35178h;

    /* renamed from: i */
    public com.zk_oaction.adengine.lk_sdk.c f35179i;

    /* renamed from: j */
    public String f35180j;
    public com.zk_oaction.adengine.lk_expression.a k;
    public com.zk_oaction.adengine.lk_expression.a l;
    public com.zk_oaction.adengine.lk_expression.a m;
    public com.zk_oaction.adengine.lk_expression.a n;
    public com.zk_oaction.adengine.lk_expression.a o;
    public boolean p;
    public boolean q;
    public boolean r;
    public boolean s;
    public boolean t;
    public String u;
    public String v;
    public Surface w;
    public MediaPlayer x;
    public int y;
    public int z;

    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 0) {
                try {
                    n.this.Y();
                    n nVar = n.this;
                    if (nVar.x == null || !nVar.p) {
                        return;
                    }
                    sendEmptyMessageDelayed(0, nVar.f35179i.f34885j);
                } catch (Throwable unused) {
                }
            }
        }
    }

    class b implements AudioManager.OnAudioFocusChangeListener {
        b() {
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(int i2) {
            n nVar;
            float f2;
            if (i2 != -3 && i2 != -2 && i2 != -1) {
                if (i2 == 1 || i2 == 2) {
                    nVar = n.this;
                    f2 = 1.0f;
                    nVar.c(f2);
                } else if (i2 != 3 && i2 != 4) {
                    return;
                }
            }
            nVar = n.this;
            f2 = 0.0f;
            nVar.c(f2);
        }
    }

    class c implements MediaPlayer.OnCompletionListener {
        c() {
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            try {
                n nVar = n.this;
                nVar.p = false;
                if (nVar.f35180j != null) {
                    nVar.f35179i.J.f(n.this.f35180j + ".play", "0");
                }
                n nVar2 = n.this;
                if (nVar2.q) {
                    return;
                }
                nVar2.Z();
            } catch (Throwable unused) {
            }
        }
    }

    class d implements MediaPlayer.OnInfoListener {
        d() {
        }

        @Override // android.media.MediaPlayer.OnInfoListener
        public boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
            if (i2 != 3 || n.this.F == null) {
                return false;
            }
            n.this.F.a();
            return false;
        }
    }

    class e implements MediaPlayer.OnErrorListener {
        e() {
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
            mediaPlayer.reset();
            n.this.C("MediaPlayer onError:" + i2);
            return true;
        }
    }

    class f implements MediaPlayer.OnVideoSizeChangedListener {
        f() {
        }

        @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
            n nVar = n.this;
            nVar.y = i2;
            nVar.z = i3;
            if (nVar.P()) {
                n.this.requestLayout();
            }
        }
    }

    class g implements Runnable {
        g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            n nVar = n.this;
            MediaPlayer mediaPlayer = nVar.x;
            if (mediaPlayer == null || nVar.s) {
                return;
            }
            mediaPlayer.release();
            n.this.x = null;
        }
    }

    class h implements c.b {
        h() {
        }

        @Override // com.zk_oaction.adengine.lk_expression.c.b
        public void m(String str) {
            n.this.z(str);
        }
    }

    public interface i {
        void a();
    }

    public n(com.zk_oaction.adengine.lk_sdk.c cVar, i iVar) {
        super(cVar.F);
        this.A = 0.0f;
        this.G = false;
        this.f35171a = false;
        this.f35173c = -1;
        this.f35175e = false;
        this.f35176f = false;
        this.f35177g = new a(Looper.getMainLooper());
        this.f35178h = new b();
        this.f35179i = cVar;
        setSurfaceTextureListener(this);
        AudioManager audioManager = (AudioManager) cVar.F.getSystemService("audio");
        this.B = audioManager;
        if (audioManager != null) {
            this.E = audioManager.isMusicActive();
        }
        this.F = iVar;
    }

    private void A(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "play");
        this.p = attributeValue != null ? Boolean.parseBoolean(attributeValue) : true;
    }

    public void C(String str) {
        this.f35177g.removeCallbacksAndMessages(null);
        if (this.f35171a) {
            this.f35179i.G.c(this.H, this.f35173c, str, this.f35174d);
        }
    }

    private void D(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "looping");
        if (attributeValue != null) {
            this.q = Boolean.parseBoolean(attributeValue);
        }
        if (xmlPullParser.getAttributeValue(null, "count") != null) {
            this.q = false;
        }
    }

    private void F(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "sound");
        if (attributeValue != null) {
            try {
                this.A = Float.parseFloat(attributeValue);
            } catch (Exception unused) {
                this.A = 0.0f;
            }
        }
        this.f35179i.J.f(this.f35180j + ".sound", "" + this.A);
    }

    private void H(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "living");
        if (attributeValue != null) {
            this.r = Boolean.parseBoolean(attributeValue);
        }
        String attributeValue2 = xmlPullParser.getAttributeValue(null, OapsKey.KEY_SRC);
        if (attributeValue2 == null) {
            attributeValue2 = "";
        } else if (!this.r) {
            attributeValue2 = this.f35179i.H + attributeValue2;
        }
        this.v = attributeValue2;
    }

    private void I() {
        if (this.o.b() == 0.0f) {
            this.o.h(1.0f);
            setVisibility(0);
            if (this.p && this.s) {
                T();
            }
        }
    }

    private void J(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "scaleType");
        this.u = attributeValue;
        if (attributeValue == null) {
            this.u = "fill";
        }
    }

    private void K() {
        if (this.o.b() == 1.0f) {
            this.o.h(0.0f);
            setVisibility(4);
            MediaPlayer mediaPlayer = this.x;
            if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
                return;
            }
            this.x.pause();
        }
    }

    private void L(XmlPullParser xmlPullParser) {
        this.o = new com.zk_oaction.adengine.lk_expression.a(this.f35179i, Downloads.Column.VISIBILITY, xmlPullParser.getAttributeValue(null, Downloads.Column.VISIBILITY), 1.0f, null, false);
    }

    private void M() {
        if (this.o.b() != 1.0f) {
            this.o.h(1.0f);
            setVisibility(0);
            if (this.p && this.s) {
                T();
                return;
            }
            return;
        }
        this.o.h(0.0f);
        setVisibility(4);
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.x.pause();
    }

    private void N(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "defaultBitmap");
        if (attributeValue != null) {
            ((com.zk_oaction.adengine.lk_view.c) getParent()).l(attributeValue);
        }
    }

    private void O(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "audioFocus");
        if (attributeValue != null) {
            this.f35176f = Boolean.parseBoolean(attributeValue);
        }
    }

    public boolean P() {
        float width;
        int height;
        float height2;
        try {
            if (!this.u.equals("fill") && this.y != 0 && this.z != 0) {
                float b2 = this.m.b() / this.y;
                float b3 = this.n.b() / this.z;
                Matrix matrix = new Matrix();
                matrix.preTranslate((this.m.b() - this.y) / 2.0f, (this.n.b() - this.z) / 2.0f);
                matrix.preScale(this.y / this.m.b(), this.z / this.n.b());
                if (this.u.equals("fit_width")) {
                    width = getWidth() / 2;
                    height = getHeight();
                } else {
                    if (this.u.equals("fit_height")) {
                        float width2 = getWidth() / 2;
                        height2 = getHeight() / 2;
                        width = width2;
                        b2 = b3;
                        matrix.postScale(b2, b2, width, height2);
                        setTransform(matrix);
                        return true;
                    }
                    if (!this.u.equals("center")) {
                        if (this.u.equals("center_crop")) {
                            b2 = Math.max(b2, b3);
                            width = getWidth() / 2;
                            height = getHeight();
                        }
                        setTransform(matrix);
                        return true;
                    }
                    b2 = Math.min(b2, b3);
                    width = getWidth() / 2;
                    height = getHeight();
                }
                height2 = height / 2;
                matrix.postScale(b2, b2, width, height2);
                setTransform(matrix);
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private void Q(XmlPullParser xmlPullParser) {
        this.H = xmlPullParser.getAttributeValue(null, "scene");
        v(xmlPullParser.getAttributeValue(null, "report"));
        try {
            String attributeValue = xmlPullParser.getAttributeValue(null, "scenetype");
            if (attributeValue != null) {
                this.f35173c = Integer.parseInt(attributeValue);
            }
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "extend");
            if (attributeValue2 != null) {
                new com.zk_oaction.adengine.lk_expression.c(this.f35179i, attributeValue2, new h());
            }
        } catch (Throwable unused) {
        }
    }

    private boolean R() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        if (this.A == 0.0f || this.E || j(4) || (onAudioFocusChangeListener = this.f35178h) == null) {
            return false;
        }
        this.C = true;
        return 1 == this.B.requestAudioFocus(onAudioFocusChangeListener, 3, 2);
    }

    private boolean S() {
        AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener;
        if (this.C && (onAudioFocusChangeListener = this.f35178h) != null) {
            this.C = false;
            if (1 == this.B.abandonAudioFocus(onAudioFocusChangeListener)) {
                return true;
            }
        }
        return false;
    }

    private void T() {
        try {
            if (this.x == null || !this.t) {
                return;
            }
            if (this.f35176f) {
                R();
            }
            this.x.start();
            if (this.f35180j != null) {
                this.f35179i.J.f(this.f35180j + ".play", "1");
            }
            com.zk_oaction.adengine.lk_interfaces.d dVar = this.f35179i.f34883h;
            if (dVar != null) {
                dVar.a(this.f35180j);
            }
            W();
        } catch (Throwable th) {
            th.printStackTrace();
            C(th.getMessage());
        }
    }

    private void U() {
        try {
            if (this.x == null || !this.t) {
                return;
            }
            X();
            if (this.f35176f) {
                S();
            }
            this.x.pause();
            if (this.f35180j != null) {
                this.f35179i.J.f(this.f35180j + ".play", "0");
            }
            this.D = this.x.getCurrentPosition() / this.x.getDuration();
            com.zk_oaction.adengine.lk_interfaces.d dVar = this.f35179i.f34883h;
            if (dVar != null) {
                dVar.b(this.f35180j);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            C(th.getMessage());
        }
    }

    private void V() {
        try {
            if (this.x != null) {
                this.t = false;
                ((com.zk_oaction.adengine.lk_view.c) getParent()).invalidate();
                Handler handler = getHandler();
                if (handler != null) {
                    handler.postDelayed(new g(), 10L);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void W() {
        try {
            if (this.f35171a) {
                this.f35175e = false;
                this.f35179i.G.k(this.H, this.f35173c, this.f35172b, this.f35174d);
                this.f35177g.removeMessages(0);
                this.f35177g.sendEmptyMessageDelayed(0, this.f35179i.f34885j);
            }
        } catch (Throwable unused) {
        }
    }

    private void X() {
        MediaPlayer mediaPlayer;
        try {
            this.f35177g.removeCallbacksAndMessages(null);
            if (this.f35175e || !this.f35171a || (mediaPlayer = this.x) == null) {
                return;
            }
            this.f35179i.G.e(this.H, this.f35173c, mediaPlayer.getCurrentPosition(), this.f35172b, this.f35174d);
        } catch (Throwable unused) {
        }
    }

    public void Y() {
        MediaPlayer mediaPlayer;
        if (!this.f35171a || (mediaPlayer = this.x) == null) {
            return;
        }
        this.f35179i.G.d(this.H, this.f35173c, mediaPlayer.getCurrentPosition(), this.f35172b, this.f35174d);
    }

    public void Z() {
        this.f35177g.removeCallbacksAndMessages(null);
        this.f35175e = true;
        if (this.f35171a) {
            com.zk_oaction.adengine.lk_interfaces.a aVar = this.f35179i.G;
            String str = this.H;
            int i2 = this.f35173c;
            int i3 = this.f35172b;
            aVar.f(str, i2, i3, i3, this.f35174d);
        }
    }

    public static boolean j(int i2) {
        try {
            Class<?> cls = Class.forName("android.media.AudioSystem");
            Class<?> cls2 = Integer.TYPE;
            Method declaredMethod = cls.getDeclaredMethod("isStreamActive", cls2, cls2);
            if (declaredMethod != null) {
                return ((Boolean) declaredMethod.invoke(null, Integer.valueOf(i2), 0)).booleanValue();
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    private void p(XmlPullParser xmlPullParser) {
        this.f35180j = xmlPullParser.getAttributeValue(null, "name");
    }

    private void s(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        MediaPlayer mediaPlayer = this.x;
        if (mediaPlayer != null) {
            mediaPlayer.release();
            this.x = null;
        }
        if (this.w != null) {
            try {
                MediaPlayer mediaPlayer2 = new MediaPlayer();
                this.x = mediaPlayer2;
                mediaPlayer2.setSurface(this.w);
                this.x.setOnPreparedListener(this);
                this.x.setOnCompletionListener(new c());
                this.x.setOnInfoListener(new d());
                this.x.setOnErrorListener(new e());
                this.x.setOnVideoSizeChangedListener(new f());
                this.x.reset();
                if (TextUtils.isEmpty(str) || !str.startsWith(HttpHost.DEFAULT_SCHEME_NAME)) {
                    this.x.setDataSource(str);
                } else {
                    this.r = true;
                    this.x.setDataSource(getContext(), Uri.parse(this.v));
                }
                this.x.setLooping(this.q);
                if (this.G) {
                    this.x.setVolume(0.0f, 0.0f);
                } else {
                    MediaPlayer mediaPlayer3 = this.x;
                    float f2 = this.A;
                    mediaPlayer3.setVolume(f2, f2);
                }
                this.t = false;
                this.x.prepareAsync();
            } catch (Exception e2) {
                C(e2.getMessage());
                e2.printStackTrace();
            }
        }
    }

    private void t(XmlPullParser xmlPullParser) {
        this.k = new com.zk_oaction.adengine.lk_expression.a(this.f35179i, "x", xmlPullParser.getAttributeValue(null, "x"), 0.0f, this, true);
        this.l = new com.zk_oaction.adengine.lk_expression.a(this.f35179i, "y", xmlPullParser.getAttributeValue(null, "y"), 0.0f, this, true);
    }

    private void v(String str) {
        this.f35171a = !TextUtils.isEmpty(this.H) && "1".equals(str);
    }

    private void w(XmlPullParser xmlPullParser) {
        float f2;
        String attributeValue = xmlPullParser.getAttributeValue(null, IAdInterListener.AdReqParam.WIDTH);
        if (attributeValue == null) {
            attributeValue = xmlPullParser.getAttributeValue(null, "width");
        }
        String str = attributeValue;
        com.zk_oaction.adengine.lk_sdk.c cVar = this.f35179i;
        float f3 = com.zk_oaction.adengine.lk_sdk.c.f34877b;
        float f4 = com.zk_oaction.adengine.lk_sdk.c.f34878c;
        if (f3 > f4) {
            f2 = f4;
        } else {
            f2 = f3;
            f3 = f4;
        }
        if (cVar.Y) {
            f3 = (16.0f * f2) / 9.0f;
        }
        float f5 = f3;
        this.m = new com.zk_oaction.adengine.lk_expression.a(this.f35179i, "width", str, f2, this, true);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "h");
        this.n = new com.zk_oaction.adengine.lk_expression.a(this.f35179i, "height", attributeValue2 == null ? xmlPullParser.getAttributeValue(null, "height") : attributeValue2, f5, this, true);
    }

    public void z(String str) {
        try {
            if (this.f35174d == null) {
                this.f35174d = new HashMap();
            }
            this.f35174d.clear();
            if (TextUtils.isEmpty(str)) {
                return;
            }
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String obj = keys.next().toString();
                if (!TextUtils.isEmpty(obj)) {
                    this.f35174d.put(obj, jSONObject.optString(obj));
                }
            }
        } catch (Throwable unused) {
        }
    }

    public float B() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.n;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }

    public float E() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.k;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }

    public float G() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.l;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0039, code lost:
    
        if (r2.equals("fill") == false) goto L51;
     */
    @Override // com.zk_oaction.adengine.lk_expression.a.w
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.String r2, float r3) {
        /*
            r1 = this;
            if (r2 != 0) goto L3
            goto L55
        L3:
            java.lang.String r0 = "x"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L15
            android.view.ViewParent r2 = r1.getParent()     // Catch: java.lang.Throwable -> L55
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch: java.lang.Throwable -> L55
            r2.setTranslationX(r3)     // Catch: java.lang.Throwable -> L55
            goto L55
        L15:
            java.lang.String r0 = "y"
            boolean r0 = r2.equals(r0)     // Catch: java.lang.Throwable -> L55
            if (r0 == 0) goto L27
            android.view.ViewParent r2 = r1.getParent()     // Catch: java.lang.Throwable -> L55
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2     // Catch: java.lang.Throwable -> L55
            r2.setTranslationY(r3)     // Catch: java.lang.Throwable -> L55
            goto L55
        L27:
            java.lang.String r3 = "width"
            boolean r3 = r2.equals(r3)     // Catch: java.lang.Throwable -> L55
            java.lang.String r0 = "fill"
            if (r3 == 0) goto L3f
            java.lang.String r2 = r1.u     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L52
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L55
            if (r2 != 0) goto L52
        L3b:
            r1.P()     // Catch: java.lang.Throwable -> L55
            goto L52
        L3f:
            java.lang.String r3 = "height"
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L55
            java.lang.String r2 = r1.u     // Catch: java.lang.Throwable -> L55
            if (r2 == 0) goto L52
            boolean r2 = r2.equals(r0)     // Catch: java.lang.Throwable -> L55
            if (r2 != 0) goto L52
            goto L3b
        L52:
            r1.requestLayout()     // Catch: java.lang.Throwable -> L55
        L55:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.zk_oaction.adengine.lk_view.n.a(java.lang.String, float):void");
    }

    public String b() {
        return this.f35180j;
    }

    public void c(float f2) {
        try {
            if (this.G) {
                this.A = 0.0f;
            } else {
                this.A = f2;
            }
            this.f35179i.J.f(this.f35180j + ".sound", "" + this.A);
            MediaPlayer mediaPlayer = this.x;
            if (mediaPlayer != null) {
                float f3 = this.A;
                mediaPlayer.setVolume(f3, f3);
            }
        } catch (Throwable unused) {
        }
    }

    public void f(String str) {
        if (str.equals("true")) {
            I();
        } else if (str.equals("false")) {
            K();
        } else if (str.equals("toggle")) {
            M();
        }
    }

    public void g(String str, int i2, String str2, String str3, String str4) {
        this.f35173c = i2;
        this.H = str2;
        z(str3);
        v(str4);
        o(str);
    }

    public void h(boolean z) {
        try {
            this.G = z;
            MediaPlayer mediaPlayer = this.x;
            if (mediaPlayer != null) {
                float f2 = z ? 0.0f : 1.0f;
                mediaPlayer.setVolume(f2, f2);
            }
        } catch (Throwable unused) {
        }
    }

    public void i(boolean z, boolean z2) {
        if (this.p == z) {
            return;
        }
        this.p = z;
        if (this.w != null) {
            if (!z) {
                U();
                if (z2) {
                    V();
                    return;
                }
                return;
            }
            if (this.s && this.o.b() == 1.0f) {
                if (z2) {
                    o(this.v);
                } else {
                    T();
                }
            }
        }
    }

    public boolean k(XmlPullParser xmlPullParser) {
        p(xmlPullParser);
        t(xmlPullParser);
        w(xmlPullParser);
        A(xmlPullParser);
        D(xmlPullParser);
        F(xmlPullParser);
        H(xmlPullParser);
        J(xmlPullParser);
        L(xmlPullParser);
        N(xmlPullParser);
        O(xmlPullParser);
        Q(xmlPullParser);
        ((ViewGroup) getParent()).setTranslationX(this.k.b());
        ((ViewGroup) getParent()).setTranslationY(this.l.b());
        return true;
    }

    public void l() {
        this.s = true;
        if (this.p && this.o.b() == 1.0f) {
            if (this.x == null) {
                o(this.v);
            } else {
                T();
            }
        }
    }

    public void o(String str) {
        if (!str.equals(this.v)) {
            this.v = str;
        }
        s(this.v);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        setMeasuredDimension((int) this.m.b(), (int) this.n.b());
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        try {
            if (this.f35179i.f34882g) {
                MediaPlayer mediaPlayer2 = this.x;
                if (mediaPlayer2 != null) {
                    mediaPlayer2.release();
                    this.x = null;
                    return;
                }
                return;
            }
            this.t = true;
            MediaPlayer mediaPlayer3 = this.x;
            if (mediaPlayer3 != null) {
                this.f35172b = mediaPlayer3.getDuration();
                if (!this.p || !this.s || this.o.b() != 1.0f) {
                    if (this.r) {
                        return;
                    }
                    this.x.seekTo(0);
                    return;
                }
                if (this.E || this.G) {
                    this.x.setVolume(0.0f, 0.0f);
                } else {
                    MediaPlayer mediaPlayer4 = this.x;
                    float f2 = this.A;
                    mediaPlayer4.setVolume(f2, f2);
                }
                T();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        this.w = new Surface(surfaceTexture);
        if (this.p && this.s && this.o.b() == 1.0f) {
            o(this.v);
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        this.t = false;
        try {
            if (this.x != null) {
                this.D = r0.getCurrentPosition() / this.x.getDuration();
                this.x.release();
                this.x = null;
            }
        } catch (Throwable unused) {
        }
        try {
            Surface surface = this.w;
            if (surface == null) {
                return true;
            }
            surface.release();
            this.w = null;
            return true;
        } catch (Throwable unused2) {
            return true;
        }
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void r() {
        this.s = false;
        U();
    }

    public void u() {
        try {
            V();
            Surface surface = this.w;
            if (surface != null) {
                surface.release();
                this.w = null;
            }
        } catch (Throwable unused) {
        }
    }

    public float y() {
        com.zk_oaction.adengine.lk_expression.a aVar = this.m;
        if (aVar != null) {
            return aVar.b();
        }
        return 0.0f;
    }
}
