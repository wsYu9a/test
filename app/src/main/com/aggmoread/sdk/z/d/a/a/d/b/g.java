package com.aggmoread.sdk.z.d.a.a.d.b;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.aggmoread.sdk.z.d.a.a.c.g;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.e.b;
import com.aggmoread.sdk.z.d.a.a.e.d;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.aggmoread.sdk.z.d.a.a.e.n;
import com.baidu.mobads.sdk.internal.am;
import com.kwad.sdk.core.response.model.SdkConfigData;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
public final class g {

    /* renamed from: b */
    static Map<Integer, com.aggmoread.sdk.z.d.a.a.d.b.b> f5953b = new ConcurrentHashMap();

    /* renamed from: c */
    static com.aggmoread.sdk.z.d.a.a.d.b.h f5954c = com.aggmoread.sdk.z.d.a.a.d.b.h.f5999e;

    /* renamed from: a */
    private boolean f5955a = false;

    public class a implements d.c {

        /* renamed from: a */
        final /* synthetic */ Handler.Callback f5956a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.h f5957b;

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.g$a$a */
        public class RunnableC0184a implements Runnable {
            public RunnableC0184a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Message obtain = Message.obtain();
                obtain.what = 0;
                obtain.obj = Boolean.TRUE;
                a.this.f5956a.handleMessage(obtain);
            }
        }

        public a(g gVar, Handler.Callback callback, com.aggmoread.sdk.z.d.a.a.d.b.h hVar) {
            this.f5956a = callback;
            this.f5957b = hVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            Log.e("xxx", "exit ");
            if (iVar != null || bArr == null) {
                return;
            }
            try {
                com.aggmoread.sdk.z.d.a.a.e.f fVar = new com.aggmoread.sdk.z.d.a.a.e.f(com.aggmoread.sdk.z.d.a.a.b.d(new String(bArr, "UTF-8")));
                if (fVar.a(l.f5997a, false)) {
                    com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r = Boolean.TRUE;
                    com.aggmoread.sdk.z.d.a.a.b.c();
                } else {
                    com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r = Boolean.FALSE;
                }
                String str = null;
                fVar.a(l.f5998b, (String) null);
                if (this.f5956a != null) {
                    n.a(new RunnableC0184a());
                }
                com.aggmoread.sdk.z.d.a.a.e.h.a().b("debugLog", com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue());
                com.aggmoread.sdk.z.d.a.a.d.b.h hVar = this.f5957b;
                if (hVar != null) {
                    str = hVar.a();
                }
                Log.e("xxx", "init set oaid " + str);
            } catch (UnsupportedEncodingException e10) {
                e10.printStackTrace();
            }
        }
    }

    public class b implements b.c {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5959a;

        /* renamed from: b */
        final /* synthetic */ k f5960b;

        public class a implements k {

            /* renamed from: a */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.e.b f5962a;

            /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.g$b$a$a */
            public class C0185a implements k {
                public C0185a() {
                }

                @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
                public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                    if (bArr != null) {
                        a.this.f5962a.a(bArr);
                    }
                }
            }

            public a(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
                this.f5962a = bVar;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
            public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                b.this.f5960b.a(eVar, bArr, iVar);
                b bVar = b.this;
                g.this.b(bVar.f5959a, new C0185a());
            }
        }

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.g$b$b */
        public class C0186b implements k {

            /* renamed from: a */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.e.b f5965a;

            public C0186b(b bVar, com.aggmoread.sdk.z.d.a.a.e.b bVar2) {
                this.f5965a = bVar2;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
            public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                if (bArr != null) {
                    this.f5965a.a(bArr);
                }
            }
        }

        public class c implements k {

            /* renamed from: a */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.e.b f5966a;

            public class a implements k {
                public a() {
                }

                @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
                public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                    if (bArr != null) {
                        c.this.f5966a.a(bArr);
                    }
                }
            }

            public c(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
                this.f5966a = bVar;
            }

            @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
            public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
                b.this.f5960b.a(eVar, bArr, iVar);
                b bVar = b.this;
                g.this.b(bVar.f5959a, new a());
            }
        }

        public b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, k kVar) {
            this.f5959a = dVar;
            this.f5960b = kVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.b.c
        public void a(com.aggmoread.sdk.z.d.a.a.e.b bVar) {
            Map<Object, Object> b10;
            com.aggmoread.sdk.z.d.a.a.d.b.e eVar;
            g gVar;
            com.aggmoread.sdk.z.d.a.a.d.b.d dVar;
            k cVar;
            byte[] b11 = bVar != null ? bVar.b() : null;
            if (b11 != null) {
                try {
                    String str = new String(b11, "UTF-8");
                    com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "cached ad data = " + str);
                    b10 = com.aggmoread.sdk.z.d.a.a.b.b(str);
                } catch (UnsupportedEncodingException e10) {
                    e10.printStackTrace();
                }
                if (b10 != null) {
                    eVar = new com.aggmoread.sdk.z.d.a.a.d.b.e(this.f5959a, b10);
                    if (eVar == null && eVar.c() == null) {
                        String d10 = bVar.d();
                        if ("8091910".equals(d10)) {
                            this.f5960b.a(eVar, bVar.b(), null);
                            long a10 = g.this.a(eVar) * 1000;
                            long currentTimeMillis = System.currentTimeMillis() - bVar.c();
                            com.aggmoread.sdk.z.d.a.a.e.e.a("ct " + currentTimeMillis + ", pct " + a10 + ", db " + bVar.c());
                            if (currentTimeMillis < a10) {
                                return;
                            }
                            bVar.a((byte[]) null);
                            gVar = g.this;
                            dVar = this.f5959a;
                            cVar = new C0186b(this, bVar);
                        } else {
                            com.aggmoread.sdk.z.d.a.a.e.e.a("sv " + d10);
                            bVar.a((byte[]) null);
                            gVar = g.this;
                            dVar = this.f5959a;
                            cVar = new a(bVar);
                        }
                    } else {
                        gVar = g.this;
                        dVar = this.f5959a;
                        cVar = new c(bVar);
                    }
                    gVar.b(dVar, cVar);
                }
            }
            eVar = null;
            if (eVar == null) {
            }
            gVar = g.this;
            dVar = this.f5959a;
            cVar = new c(bVar);
            gVar.b(dVar, cVar);
        }
    }

    public class c implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5969b;

        public c(g gVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5969b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5969b.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "lv:广告无填充"), (com.aggmoread.sdk.z.d.a.a.d.b.e) null);
        }
    }

    public class d implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5970b;

        public d(g gVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5970b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5970b.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "init: 广告无填充"), (com.aggmoread.sdk.z.d.a.a.d.b.e) null);
        }
    }

    public class e implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5971b;

        public e(g gVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5971b = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5971b.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "sc:广告无填充"), (com.aggmoread.sdk.z.d.a.a.d.b.e) null);
        }
    }

    public class f implements k {

        /* renamed from: a */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5972a;

        public class a implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.i f5973b;

            /* renamed from: c */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5974c;

            public a(com.aggmoread.sdk.z.d.a.a.d.b.i iVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5973b = iVar;
                this.f5974c = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "err: " + this.f5973b.f6008a + ", " + this.f5973b.f6009b), this.f5974c);
            }
        }

        public class b implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5976b;

            public b(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5976b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001005001, "广告无填充"), this.f5976b);
            }
        }

        public class c implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5978b;

            public c(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5978b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001005000, "广告无填充"), this.f5978b);
            }
        }

        public class d implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5980b;

            public d(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5980b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001005003, "广告无填充"), this.f5980b);
            }
        }

        public class e implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5982b;

            public e(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5982b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001005002, "广告无填充"), this.f5982b);
            }
        }

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.g$f$f */
        public class RunnableC0187f implements Runnable {

            /* renamed from: b */
            final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5984b;

            public RunnableC0187f(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
                this.f5984b = eVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                f.this.f5972a.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001005004, "广告无填充"), this.f5984b);
            }
        }

        public f(g gVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5972a = dVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.d.b.g.k
        public void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            if (iVar != null) {
                n.a(new a(iVar, eVar));
                return;
            }
            int a10 = eVar.f5908d.a(e.c.f5937m, 0);
            if (a10 > 0 && a10 <= this.f5972a.C.d()) {
                n.a(new b(eVar));
                return;
            }
            int a11 = eVar.f5908d.a(e.c.f5936l, 0);
            if (a11 > 0 && a11 <= this.f5972a.B.d()) {
                n.a(new c(eVar));
                return;
            }
            int a12 = eVar.f5908d.a(e.c.f5935k, 0);
            if (a12 > 0 && a12 <= this.f5972a.E.d()) {
                n.a(new d(eVar));
                return;
            }
            int a13 = eVar.f5908d.a(e.c.f5934j, 0);
            if (a13 > 0 && a13 <= this.f5972a.D.d()) {
                n.a(new e(eVar));
                return;
            }
            int a14 = eVar.f5908d.a(e.c.f5946v, 0);
            String format = String.format("REQ_%s_LAST", this.f5972a.f5863i);
            if (a14 > 0 && a14 * 1000 >= System.currentTimeMillis() - com.aggmoread.sdk.z.d.a.a.e.h.a().a(format, 0L)) {
                n.a(new RunnableC0187f(eVar));
                return;
            }
            this.f5972a.a(eVar);
            com.aggmoread.sdk.z.d.a.a.e.h.a().b(format, System.currentTimeMillis());
            if (eVar.a()) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMSdkThread", "cc bid ");
                if (com.aggmoread.sdk.z.d.a.a.d.a.d.r.d.a().b(this.f5972a, eVar)) {
                    return;
                }
            }
            g.a(this.f5972a, eVar);
        }
    }

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.b.g$g */
    public static class RunnableC0188g implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5986b;

        /* renamed from: c */
        final /* synthetic */ int f5987c;

        /* renamed from: d */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5988d;

        public RunnableC0188g(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
            this.f5986b = dVar;
            this.f5987c = i10;
            this.f5988d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5986b.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "不支持的广告源. adSource=" + this.f5987c), this.f5988d);
        }
    }

    public static class h implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5989b;

        /* renamed from: c */
        final /* synthetic */ int f5990c;

        /* renamed from: d */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5991d;

        public h(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, int i10, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
            this.f5989b = dVar;
            this.f5990c = i10;
            this.f5991d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f5989b.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003005, "未检测到广告源，请确认广告源接入是否成功. adSource=" + this.f5990c), this.f5991d);
        }
    }

    public static class i implements Runnable {

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.b f5992b;

        /* renamed from: c */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5993c;

        /* renamed from: d */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.e f5994d;

        public i(com.aggmoread.sdk.z.d.a.a.d.b.b bVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
            this.f5992b = bVar;
            this.f5993c = dVar;
            this.f5994d = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f5992b.a(this.f5993c, this.f5994d).p();
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.a(e10.getMessage());
            } catch (OutOfMemoryError e11) {
                e11.printStackTrace();
                com.aggmoread.sdk.z.d.a.a.e.e.b("AMSdkThread", "oom err");
                this.f5993c.a(new com.aggmoread.sdk.z.d.a.a.d.b.i(1001003006, "内存空间不足，广告请求失败！"), this.f5994d);
            }
        }
    }

    public class j implements d.c {

        /* renamed from: a */
        final /* synthetic */ k f5995a;

        /* renamed from: b */
        final /* synthetic */ com.aggmoread.sdk.z.d.a.a.d.b.d f5996b;

        public j(g gVar, k kVar, com.aggmoread.sdk.z.d.a.a.d.b.d dVar) {
            this.f5995a = kVar;
            this.f5996b = dVar;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.d.c
        public void a(int i10, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar) {
            if (iVar != null) {
                this.f5995a.a(null, bArr, iVar);
                return;
            }
            if (i10 != 200) {
                this.f5995a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002001, "HTTP error，statusCode=" + i10));
                return;
            }
            if (bArr == null) {
                this.f5995a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error，response parse error."));
                return;
            }
            try {
                Map<Object, Object> b10 = com.aggmoread.sdk.z.d.a.a.b.b(new String(bArr, "UTF-8"));
                if (b10 == null) {
                    this.f5995a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002006, "HTTP error, response parse error, parse json."));
                    return;
                }
                com.aggmoread.sdk.z.d.a.a.d.b.e eVar = new com.aggmoread.sdk.z.d.a.a.d.b.e(this.f5996b, b10);
                com.aggmoread.sdk.z.d.a.a.d.b.i c10 = eVar.c();
                if (c10 != null) {
                    this.f5995a.a(null, bArr, c10);
                } else {
                    this.f5995a.a(eVar, bArr, null);
                }
            } catch (UnsupportedEncodingException unused) {
                this.f5995a.a(null, bArr, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002002, "HTTP error，response parse error, encodeing error."));
            }
        }
    }

    public interface k {
        void a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar, byte[] bArr, com.aggmoread.sdk.z.d.a.a.d.b.i iVar);
    }

    public static class l {

        /* renamed from: a */
        public static final Object f5997a = new Object();

        /* renamed from: b */
        public static final Object f5998b = new Object();
    }

    public g(Context context) {
        com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q = context;
        com.aggmoread.sdk.z.d.a.a.d.b.j.f6029s = Boolean.FALSE;
        a(100);
        a(10086);
        a(105);
        a(101);
        a(106);
        a(107);
        a(1);
        a(500);
        a(TypedValues.PositionType.TYPE_TRANSITION_EASING);
        a(TypedValues.PositionType.TYPE_DRAWPATH);
        a(TypedValues.PositionType.TYPE_PERCENT_WIDTH);
        a(504);
        a(TypedValues.PositionType.TYPE_SIZE_PERCENT);
        a(TypedValues.PositionType.TYPE_PERCENT_X);
    }

    public int a(com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        int b10 = eVar.f5908d.b(e.c.D);
        return b10 > 3600 ? SdkConfigData.DEFAULT_REQUEST_INTERVAL : b10;
    }

    public void b() {
        com.aggmoread.sdk.z.d.a.a.b.a();
        com.aggmoread.sdk.z.d.a.a.d.b.d.g();
        com.aggmoread.sdk.z.d.a.a.d.b.e.i();
        com.aggmoread.sdk.z.d.a.a.d.b.k.a();
        com.aggmoread.sdk.z.d.a.a.b.e(new Object[]{l.f5997a, l.f5998b});
        com.aggmoread.sdk.z.d.a.a.b.e(com.aggmoread.sdk.z.d.a.a.d.b.j.f6011a);
        com.aggmoread.sdk.z.d.a.a.b.f(com.aggmoread.sdk.z.d.a.a.d.b.j.f6022l);
        com.aggmoread.sdk.z.d.a.a.b.m(com.aggmoread.sdk.z.d.a.a.d.b.j.f6013c);
        com.aggmoread.sdk.z.d.a.a.b.n(com.aggmoread.sdk.z.d.a.a.d.b.j.f6015e);
        com.aggmoread.sdk.z.d.a.a.d.b.j.g();
        com.aggmoread.sdk.z.d.a.a.b.o(com.aggmoread.sdk.z.d.a.a.d.b.j.f6012b);
        com.aggmoread.sdk.z.d.a.a.b.p(com.aggmoread.sdk.z.d.a.a.d.b.j.f6024n);
        com.aggmoread.sdk.z.d.a.a.b.q(com.aggmoread.sdk.z.d.a.a.d.b.j.f6020j);
        com.aggmoread.sdk.z.d.a.a.b.r(com.aggmoread.sdk.z.d.a.a.d.b.j.f6016f);
        com.aggmoread.sdk.z.d.a.a.b.s(com.aggmoread.sdk.z.d.a.a.d.b.j.f6025o);
        com.aggmoread.sdk.z.d.a.a.b.t(com.aggmoread.sdk.z.d.a.a.d.b.j.f6018h);
        com.aggmoread.sdk.z.d.a.a.b.g(com.aggmoread.sdk.z.d.a.a.d.b.j.f6019i);
        com.aggmoread.sdk.z.d.a.a.b.h(com.aggmoread.sdk.z.d.a.a.d.b.j.f6017g);
        com.aggmoread.sdk.z.d.a.a.b.i(com.aggmoread.sdk.z.d.a.a.d.b.j.f6023m);
        com.aggmoread.sdk.z.d.a.a.b.j(com.aggmoread.sdk.z.d.a.a.d.b.j.f6021k);
        com.aggmoread.sdk.z.d.a.a.b.k(com.aggmoread.sdk.z.d.a.a.d.b.j.f6014d);
        com.aggmoread.sdk.z.d.a.a.b.l(com.aggmoread.sdk.z.d.a.a.d.b.j.f6026p);
    }

    public void b(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, k kVar) {
        String a10 = com.aggmoread.sdk.z.d.a.a.b.a(dVar.c());
        com.aggmoread.sdk.z.d.a.a.e.e.b("AMGTAG", "params is " + a10);
        HashMap hashMap = new HashMap();
        hashMap.put("Content-type", am.f6738d);
        try {
            com.aggmoread.sdk.z.d.a.a.e.d.a(com.aggmoread.sdk.z.d.a.a.d.b.j.a(), a10.getBytes("UTF-8"), hashMap, new j(this, kVar, dVar));
        } catch (UnsupportedEncodingException unused) {
            kVar.a(null, null, new com.aggmoread.sdk.z.d.a.a.d.b.i(1001002004, "HTTP error, request error"));
        }
    }

    public g.a a(Activity activity) {
        return new com.aggmoread.sdk.z.d.a.a.d.b.c(activity);
    }

    public g.a a(Context context) {
        return new com.aggmoread.sdk.z.d.a.a.d.b.c(context);
    }

    public static com.aggmoread.sdk.z.d.a.a.d.b.h a() {
        return f5954c;
    }

    public Object a(Handler.Callback callback, com.aggmoread.sdk.z.d.a.a.d.b.h hVar) {
        if (m.a(19)) {
            return null;
        }
        if (hVar != null) {
            f5954c = hVar;
        }
        b();
        com.aggmoread.sdk.z.d.a.a.e.d.a(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q);
        n.b();
        com.aggmoread.sdk.z.d.a.a.e.h.a().a("debugFile", (String) null);
        com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r = Boolean.valueOf(com.aggmoread.sdk.z.d.a.a.e.h.a().a("debugLog", false));
        com.aggmoread.sdk.z.d.a.a.e.c.w();
        try {
            String a10 = com.aggmoread.sdk.z.d.a.a.b.a(com.aggmoread.sdk.z.d.a.a.e.d.b(null));
            com.aggmoread.sdk.z.d.a.a.b.a(com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q, com.aggmoread.sdk.z.d.a.a.d.b.j.f6028r.booleanValue());
            byte[] bytes = a10.getBytes("UTF-8");
            HashMap hashMap = new HashMap();
            hashMap.put("Content-type", am.f6738d);
            com.aggmoread.sdk.z.d.a.a.e.d.a(com.aggmoread.sdk.z.d.a.a.d.b.j.e(), bytes, hashMap, new a(this, callback, hVar));
            this.f5955a = true;
            com.aggmoread.sdk.z.d.a.a.d.b.j.f6029s = Boolean.TRUE;
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        return null;
    }

    private void a(int i10) {
        Class cls = i10 != 1 ? i10 != 105 ? i10 != 107 ? i10 != 10086 ? i10 != 100 ? i10 != 101 ? i10 != 504 ? i10 != 505 ? null : com.aggmoread.sdk.z.d.a.a.d.a.d.o.a.class : com.aggmoread.sdk.z.d.a.a.d.a.d.w.b.class : com.aggmoread.sdk.z.d.a.a.d.a.d.s.d.a.class : com.aggmoread.sdk.z.d.a.a.d.a.d.u.c.class : com.aggmoread.sdk.z.d.a.a.d.a.d.p.a.class : com.aggmoread.sdk.z.d.a.a.d.a.d.v.a.class : com.aggmoread.sdk.z.d.a.a.d.a.d.t.a.class : com.aggmoread.sdk.z.d.a.a.d.a.d.q.b.class;
        if (cls != null) {
            try {
                Constructor constructor = cls.getConstructor(null);
                constructor.setAccessible(true);
                Object newInstance = constructor.newInstance(null);
                if (newInstance instanceof com.aggmoread.sdk.z.d.a.a.d.b.b) {
                    f5953b.put(Integer.valueOf(i10), (com.aggmoread.sdk.z.d.a.a.d.b.b) newInstance);
                }
            } catch (Exception e10) {
                com.aggmoread.sdk.z.d.a.a.e.e.b("err " + e10.getMessage());
            }
        }
    }

    public void a(com.aggmoread.sdk.z.d.a.a.c.g gVar) {
        com.aggmoread.sdk.z.d.a.a.d.b.d dVar = (com.aggmoread.sdk.z.d.a.a.d.b.d) gVar;
        dVar.a();
        if (m.a(19)) {
            n.a(new c(this, dVar));
            return;
        }
        Log.e("AMGTAG", "init " + this.f5955a);
        if (!this.f5955a) {
            n.a(new d(this, dVar));
        } else if (m.d() >= 3) {
            n.a(new e(this, dVar));
        } else {
            a(dVar, new f(this, dVar));
        }
    }

    public static void a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar) {
        int f10 = eVar.f();
        if (f10 == 0) {
            f10 = 10086;
        }
        com.aggmoread.sdk.z.d.a.a.d.b.b bVar = f5953b.get(Integer.valueOf(f10));
        if (bVar == null) {
            n.a(new RunnableC0188g(dVar, f10, eVar));
        } else if (bVar.a()) {
            n.a(new i(bVar, dVar, eVar));
        } else {
            n.a(new h(dVar, f10, eVar));
        }
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.d dVar, k kVar) {
        com.aggmoread.sdk.z.d.a.a.e.b a10 = com.aggmoread.sdk.z.d.a.a.e.b.a("sc_" + dVar.f5863i);
        b bVar = new b(dVar, kVar);
        if (a10 != null) {
            a10.a(bVar);
        } else {
            bVar.a(null);
        }
    }
}
