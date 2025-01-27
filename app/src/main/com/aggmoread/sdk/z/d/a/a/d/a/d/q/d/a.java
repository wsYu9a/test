package com.aggmoread.sdk.z.d.a.a.d.a.d.q.d;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.aggmoread.sdk.z.d.a.a.d.a.c;
import com.aggmoread.sdk.z.d.a.a.d.b.d;
import com.aggmoread.sdk.z.d.a.a.d.b.e;
import com.aggmoread.sdk.z.d.a.a.d.b.i;
import com.aggmoread.sdk.z.d.a.a.d.b.k;
import com.aggmoread.sdk.z.d.a.a.d.b.l;
import com.aggmoread.sdk.z.d.a.a.e.e;
import com.aggmoread.sdk.z.d.a.a.e.k;
import com.aggmoread.sdk.z.d.a.a.e.m;
import com.baidu.mobads.sdk.api.FeedPortraitVideoView;
import com.baidu.mobads.sdk.api.IFeedPortraitListener;
import com.baidu.mobads.sdk.api.NativeResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public class a extends com.aggmoread.sdk.z.d.a.a.d.a.d.b {

    /* renamed from: t */
    private String f5460t;

    /* renamed from: u */
    private NativeResponse f5461u;

    /* renamed from: v */
    private com.aggmoread.sdk.z.d.a.a.d.b.m.a f5462v;

    /* renamed from: w */
    private FeedPortraitVideoView f5463w;

    /* renamed from: x */
    private AtomicBoolean f5464x;

    /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.d.a$a */
    public class ViewOnAttachStateChangeListenerC0128a implements View.OnAttachStateChangeListener {

        /* renamed from: com.aggmoread.sdk.z.d.a.a.d.a.d.q.d.a$a$a */
        public class C0129a implements IFeedPortraitListener {
            public C0129a() {
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void pauseBtnClick() {
                e.b(a.this.f5460t, "pauseBtnClick ");
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playCompletion() {
                e.b(a.this.f5460t, "playCompletion ");
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q.onVideoComplete();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playError() {
                e.b(a.this.f5460t, "playError ");
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q.a(new i(-1000, "bd:视频素材播放失败！"));
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playPause() {
                e.b(a.this.f5460t, "playPause ");
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q.onVideoPause();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playRenderingStart() {
                e.b(a.this.f5460t, "playRenderingStart ");
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q.onVideoStart();
                }
            }

            @Override // com.baidu.mobads.sdk.api.IFeedPortraitListener
            public void playResume() {
                e.b(a.this.f5460t, "playResume ");
                if (((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q != null) {
                    ((com.aggmoread.sdk.z.d.a.a.d.a.d.b) a.this).f5299q.onVideoStart();
                }
            }
        }

        public ViewOnAttachStateChangeListenerC0128a() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
            e.b(a.this.f5460t, "onViewAttachedToWindow enter ");
            if (!a.this.f5464x.compareAndSet(false, true)) {
                if (a.this.f5463w != null) {
                    a.this.f5463w.play();
                    return;
                }
                return;
            }
            if (a.this.f5463w == null) {
                Object parent = a.this.f5462v.getParent();
                if (parent instanceof ViewGroup) {
                    Activity a10 = m.a((View) parent);
                    e.b(a.this.f5460t, "getView onViewAttachedToWindow " + a10);
                    if (a10 != null) {
                        a.this.f5463w = new FeedPortraitVideoView(a10);
                    } else {
                        a.this.f5463w = new FeedPortraitVideoView(a.this.f5275h.f5858d);
                    }
                }
            }
            if (a.this.f5463w != null) {
                a.this.f5463w.setUseDownloadFrame(true);
                a.this.f5463w.setFeedPortraitListener(new C0129a());
                e.b(a.this.f5460t, "portraitVideoView parent " + a.this.f5463w);
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                layoutParams.gravity = 17;
                a.this.f5462v.addView(a.this.f5463w, layoutParams);
                ArrayList arrayList = new ArrayList();
                arrayList.add(a.this.f5463w);
                a aVar = a.this;
                aVar.a(aVar.f5462v, arrayList);
                e.b(a.this.f5460t, "render enter ");
                l.a(a.this.f5462v, a.this.f5281n);
                a aVar2 = a.this;
                l.a(aVar2.f5275h.f5856b, aVar2.f5281n, com.aggmoread.sdk.z.d.a.a.c.i.INFORMATION_FLOW, aVar2.f5462v, new View[0], new WeakReference(a.this.f5462v), null);
                a aVar3 = a.this;
                l.b(aVar3.f5275h.f5856b, aVar3.f5276i.e(), a.this.f5276i.b());
                byte[] b10 = a.this.f5275h.f5872r.b();
                if (b10 != null) {
                    l.a(a.this.f5275h.f5856b, b10);
                }
                a aVar4 = a.this;
                l.a(aVar4.f5281n, aVar4.f5276i);
            }
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    public class b implements NativeResponse.AdInteractionListener {
        public b() {
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposed() {
            e.b(a.this.f5460t, "onADExposed ");
            HashMap hashMap = new HashMap();
            a.this.f5278k = System.currentTimeMillis();
            hashMap.put(k.f6102a, a.this.f5276i.f5906b.a(e.c.f5928f, "-1"));
            l.a((Object) a.this.f5281n, true, true);
            a.this.d();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADExposureFailed(int i10) {
            com.aggmoread.sdk.z.d.a.a.e.e.a(a.this.f5460t, "onADError %d", Integer.valueOf(i10));
            a.this.a(new i(-1000, String.valueOf(i10)));
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onADStatusChanged() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(a.this.f5460t, "onADStatusChanged");
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdClick() {
            com.aggmoread.sdk.z.d.a.a.e.e.b(a.this.f5460t, "onADClicked");
            a aVar = a.this;
            aVar.f5277j++;
            aVar.j();
        }

        @Override // com.baidu.mobads.sdk.api.NativeResponse.AdInteractionListener
        public void onAdUnionClick() {
        }
    }

    public a(NativeResponse nativeResponse, d dVar, com.aggmoread.sdk.z.d.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar, map);
        this.f5460t = "AMDRAWTAGBD";
        new AtomicBoolean();
        this.f5464x = new AtomicBoolean();
        this.f5461u = nativeResponse;
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.b(this.f5298p, com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(nativeResponse), eVar);
        this.f5462v = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(dVar.f5858d);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.a
    public com.aggmoread.sdk.z.d.a.a.d.b.m.a a() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5460t, "ac " + this.f5462v);
        com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar = this.f5462v;
        return aVar != null ? aVar : super.a();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void destroy() {
        if (this.f5461u != null) {
            this.f5461u = null;
            this.f5463w = null;
            this.f5462v = null;
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public String getTitle() {
        return this.f5461u.getTitle();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public View getView() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5460t, "getView");
        if (this.f5462v == null) {
            this.f5462v = new com.aggmoread.sdk.z.d.a.a.d.b.m.a(this.f5275h.f5858d.getApplicationContext());
        }
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5460t, "getView " + this.f5462v);
        this.f5462v.addOnAttachStateChangeListener(new ViewOnAttachStateChangeListenerC0128a());
        return this.f5462v;
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void render() {
        com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5460t, "render");
        if (this.f5461u == null) {
            com.aggmoread.sdk.z.d.a.a.e.e.b(this.f5460t, "render failed");
            return;
        }
        if (this.f5463w == null) {
            this.f5463w = new FeedPortraitVideoView(this.f5275h.f5858d);
        }
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar = this.f5300r;
        if (bVar != null) {
            bVar.onRenderSuccess();
        }
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.n.a
    public void renderActivity(Activity activity) {
        render();
    }

    public void j() {
        com.aggmoread.sdk.z.d.a.a.c.n.b bVar;
        com.aggmoread.sdk.z.d.a.a.d.b.k kVar = new com.aggmoread.sdk.z.d.a.a.d.b.k(this.f5275h, this.f5276i);
        boolean a10 = kVar.a(k.b.f6046n, this.f5273f).a(this.f5276i, a(), this.f5278k, this.f5281n);
        kVar.b();
        l.a((Object) this.f5281n, false, true);
        if (!a10 || (bVar = this.f5300r) == null) {
            return;
        }
        bVar.onAdClicked();
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10) {
        super.b(i10);
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5461u, i10);
    }

    @Override // com.aggmoread.sdk.z.d.a.a.d.a.d.b
    public void b(int i10, int i11, String str) {
        com.aggmoread.sdk.z.d.a.a.d.a.d.q.a.a(this.f5461u, "203");
    }

    @Override // com.aggmoread.sdk.z.d.a.a.c.a
    public void a(c cVar) {
    }

    public void a(com.aggmoread.sdk.z.d.a.a.d.b.m.a aVar, List<View> list) {
        if (this.f5461u == null || aVar == null || this.f5463w == null) {
            return;
        }
        this.f5461u.registerViewForInteraction(this.f5463w, list, new ArrayList(), new b());
        this.f5463w.setAdData(this.f5461u);
        this.f5463w.play();
    }
}
