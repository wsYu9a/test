package com.sigmob.sdk.mraid2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.czhj.sdk.common.ClientMetadata;
import com.czhj.sdk.common.utils.Dips;
import com.czhj.sdk.common.utils.IntentUtil;
import com.czhj.sdk.common.utils.Preconditions;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.mraid2.c;
import com.sigmob.sdk.mraid2.g;
import com.sigmob.windad.WindAdError;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public final FrameLayout f19726a;

    /* renamed from: c */
    public e f19728c;

    /* renamed from: d */
    public g f19729d;

    /* renamed from: e */
    public LinearLayout f19730e;

    /* renamed from: f */
    public l f19731f;

    /* renamed from: g */
    public f f19732g;

    /* renamed from: i */
    public List<BaseAdUnit> f19734i;

    /* renamed from: j */
    public com.sigmob.sdk.base.common.g f19735j;

    /* renamed from: k */
    public d f19736k;

    /* renamed from: b */
    public boolean f19727b = false;

    /* renamed from: h */
    public List<g> f19733h = new ArrayList();

    /* renamed from: l */
    public g.e f19737l = new b();

    public class a implements g.d {
        public a() {
        }

        @Override // com.sigmob.sdk.mraid2.g.d
        public void a(WindAdError windAdError) {
            try {
                if (d.this.f19728c != null) {
                    d.this.f19728c.a(windAdError);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.d
        public void a(g gVar) {
            try {
                if (d.this.f19728c != null) {
                    d.this.f19728c.a(d.this.f19729d);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public class b implements g.e {

        public class a implements c.g {
            public a() {
            }

            @Override // com.sigmob.sdk.mraid2.c.g
            public void a(g gVar, int i10, int i11) {
                if (gVar == null || gVar.getMraidBridge() == null) {
                    return;
                }
                gVar.getMraidBridge().a(i10, i11);
            }
        }

        /* renamed from: com.sigmob.sdk.mraid2.d$b$b */
        public class C0604b implements g.f {
            public C0604b() {
            }

            @Override // com.sigmob.sdk.mraid2.g.f
            public void a(g gVar, JSONObject jSONObject) {
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt("y");
                if (d.this.f19731f != null) {
                    d.this.f19731f.a(gVar, Dips.asIntPixels(optInt, d.this.c()), Dips.asIntPixels(optInt2, d.this.c()));
                }
            }

            @Override // com.sigmob.sdk.mraid2.g.f
            public void b(JSONObject jSONObject) {
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt("y");
                if (d.this.f19731f != null) {
                    d.this.f19731f.a(Dips.asIntPixels(optInt, d.this.c()), Dips.asIntPixels(optInt2, d.this.c()));
                }
            }

            @Override // com.sigmob.sdk.mraid2.g.f
            public void a(JSONObject jSONObject) {
                int optInt = jSONObject.optInt("x");
                int optInt2 = jSONObject.optInt("y");
                if (d.this.f19731f != null) {
                    d.this.f19731f.b(Dips.asIntPixels(optInt, d.this.c()), Dips.asIntPixels(optInt2, d.this.c()));
                }
            }
        }

        public b() {
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public void a(g gVar) {
            if (d.this.f19728c != null) {
                d.this.f19728c.a();
            }
            if (d.this.f19733h == null || d.this.f19733h.size() <= 0) {
                return;
            }
            for (int i10 = 0; i10 < d.this.f19733h.size(); i10++) {
                ((g) d.this.f19733h.get(i10)).b();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public g b(g gVar, JSONObject jSONObject) {
            d dVar = d.this;
            g a10 = dVar.a(dVar.c(), gVar, jSONObject);
            d.this.f19733h.add(a10);
            return a10;
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public void a(g gVar, JSONObject jSONObject) {
            d.this.f19727b = jSONObject.optBoolean("flag");
            if (d.this.f19728c != null) {
                d.this.f19728c.a(d.this.f19727b);
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public void b() {
            if (d.this.f19728c != null) {
                d.this.f19728c.b();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public LinearLayout a(g gVar, int i10) {
            if (d.this.f19730e == null) {
                d.this.f19730e = new LinearLayout(d.this.c());
            }
            if (d.this.f19731f == null) {
                if (i10 == 1) {
                    d.this.f19731f = new j(d.this.c());
                    d.this.f19730e.setOrientation(0);
                } else {
                    d.this.f19731f = new o(d.this.c());
                    d.this.f19730e.setOrientation(1);
                }
                d.this.f19731f.setPageChangedListener(new a());
                d.this.f19731f.getView().addView(d.this.f19730e, new ViewGroup.LayoutParams(-1, -1));
                d.this.f19726a.addView(d.this.f19731f.getView(), 0, new ViewGroup.LayoutParams(-1, -1));
            }
            if (gVar != null && gVar.getScrollTouchListener() == null) {
                gVar.setScrollTouchListener(new C0604b());
            }
            return d.this.f19730e;
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public void b(g gVar) {
            if (d.this.f19728c != null) {
                d.this.f19728c.d();
            }
        }

        @Override // com.sigmob.sdk.mraid2.g.e
        public void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject) {
            if (d.this.f19728c != null) {
                d.this.f19728c.a(gVar, baseAdUnit, jSONObject);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SigmobLog.e("onShow end");
            if (d.this.f19728c != null) {
                d.this.f19728c.a(d.this.f19727b);
            }
        }
    }

    /* renamed from: com.sigmob.sdk.mraid2.d$d */
    public interface InterfaceC0605d {
        void a();

        void a(int i10, int i11, int i12, int i13);

        void a(BaseAdUnit baseAdUnit);

        boolean a(ConsoleMessage consoleMessage);

        boolean a(String str, JsResult jsResult);

        void b();
    }

    public interface e {
        void a();

        void a(View view);

        void a(g gVar, BaseAdUnit baseAdUnit, JSONObject jSONObject);

        void a(WindAdError windAdError);

        void a(boolean z10);

        void b();

        void d();

        void e();
    }

    public class f extends BroadcastReceiver {

        /* renamed from: a */
        public Context f19743a;

        /* renamed from: b */
        public int f19744b = -1;

        public f() {
        }

        public void a(Context context) {
            Preconditions.checkNotNull(context);
            Context applicationContext = context.getApplicationContext();
            this.f19743a = applicationContext;
            if (applicationContext != null) {
                IntentUtil.registerReceiver(applicationContext, this, new IntentFilter("android.intent.action.CONFIGURATION_CHANGED"));
            }
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int screenOrientation;
            if (this.f19743a == null || !"android.intent.action.CONFIGURATION_CHANGED".equals(intent.getAction()) || (screenOrientation = ClientMetadata.getInstance().getScreenOrientation(d.this.c())) == this.f19744b) {
                return;
            }
            this.f19744b = screenOrientation;
            d.this.a(screenOrientation);
        }

        public void a() {
            Context context = this.f19743a;
            if (context != null) {
                context.unregisterReceiver(this);
                this.f19743a = null;
            }
        }
    }

    public d(Context context, List<BaseAdUnit> list) {
        Preconditions.checkNotNull(context);
        this.f19734i = list;
        FrameLayout frameLayout = new FrameLayout(context);
        this.f19726a = frameLayout;
        frameLayout.setBackgroundColor(0);
        f fVar = new f();
        this.f19732g = fVar;
        fVar.a(context);
        g gVar = new g(context, list, frameLayout);
        this.f19729d = gVar;
        gVar.setLoadListener(new a());
        this.f19729d.setNextWebViewListener(this.f19737l);
        this.f19733h.clear();
        this.f19733h.add(this.f19729d);
        frameLayout.addView(this.f19729d, new FrameLayout.LayoutParams(-1, -1));
    }

    public FrameLayout b() {
        return this.f19726a;
    }

    public final Context c() {
        FrameLayout frameLayout = this.f19726a;
        if (frameLayout != null) {
            return frameLayout.getContext();
        }
        return null;
    }

    public g d() {
        return this.f19729d;
    }

    public void e() {
        List<g> list = this.f19733h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i10 = 0; i10 < this.f19733h.size(); i10++) {
            g gVar = this.f19733h.get(i10);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().a(false);
            }
        }
    }

    public void f() {
        List<g> list = this.f19733h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i10 = 0; i10 < this.f19733h.size(); i10++) {
            g gVar = this.f19733h.get(i10);
            gVar.j();
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().a(true);
            }
        }
    }

    public final g a(Context context, g gVar, JSONObject jSONObject) {
        g gVar2 = new g(context, this.f19734i, this.f19726a, gVar, jSONObject);
        gVar2.setAdSize(this.f19735j);
        gVar2.setNextWebViewListener(this.f19737l);
        return gVar2;
    }

    public void a() {
        f fVar = this.f19732g;
        if (fVar != null) {
            fVar.a();
            this.f19732g = null;
        }
        try {
            Iterator<g> it = this.f19733h.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        try {
            this.f19733h.clear();
            this.f19729d = null;
            this.f19728c = null;
        } catch (Throwable unused) {
        }
    }

    public void a(int i10) {
        SigmobLog.i("handleOrientationChange " + i10);
        List<g> list = this.f19733h;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i11 = 0; i11 < this.f19733h.size(); i11++) {
            g gVar = this.f19733h.get(i11);
            if (gVar.getMraidBridge() != null) {
                gVar.getMraidBridge().i();
                gVar.getMraidBridge().a(this.f19735j);
            }
        }
    }

    public void a(BaseAdUnit baseAdUnit) {
        SigmobLog.e("onShow start");
        new Handler(Looper.getMainLooper()).postDelayed(new c(), 5 * 1000);
    }

    public void a(com.sigmob.sdk.base.common.g gVar) {
        this.f19735j = gVar;
        this.f19729d.setAdSize(gVar);
        this.f19729d.n();
    }

    public void a(InterfaceC0605d interfaceC0605d) {
        this.f19729d.getMraidBridge().a(interfaceC0605d);
    }

    public void a(e eVar) {
        this.f19728c = eVar;
    }
}
