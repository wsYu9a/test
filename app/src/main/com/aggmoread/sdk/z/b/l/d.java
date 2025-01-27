package com.aggmoread.sdk.z.b.l;

import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.aggmoread.sdk.z.b.g.b;
import com.aggmoread.sdk.z.b.l.e;
import com.aggmoread.sdk.z.b.m.l;
import com.aggmoread.sdk.z.b.t.f;
import com.aggmoread.sdk.z.b.u.d;
import com.aggmoread.sdk.z.b.u.g;
import com.baidu.mobads.sdk.api.IAdInterListener;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/* loaded from: classes.dex */
public class d extends com.aggmoread.sdk.z.b.b implements com.aggmoread.sdk.z.b.l.c, e, View.OnClickListener, d.c {

    /* renamed from: i */
    static final String f4683i = "d";

    /* renamed from: a */
    private b.a.C0072a f4684a;

    /* renamed from: b */
    private f f4685b;

    /* renamed from: c */
    private com.aggmoread.sdk.z.b.g.b f4686c;

    /* renamed from: f */
    private com.aggmoread.sdk.z.b.u.d f4689f;

    /* renamed from: g */
    private com.aggmoread.sdk.z.b.t.f f4690g;

    /* renamed from: d */
    private boolean f4687d = false;

    /* renamed from: e */
    private volatile int f4688e = 0;

    /* renamed from: h */
    private volatile long f4691h = 0;

    public class a implements f.j {

        /* renamed from: a */
        final /* synthetic */ e.a f4692a;

        public a(d dVar, e.a aVar) {
            this.f4692a = aVar;
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void a(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4692a;
            if (aVar != null) {
                aVar.a();
                this.f4692a.e();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void b(MediaPlayer mediaPlayer) {
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void c(MediaPlayer mediaPlayer) {
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void d(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4692a;
            if (aVar != null) {
                aVar.d();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void e(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4692a;
            if (aVar != null) {
                aVar.e();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void f(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4692a;
            if (aVar != null) {
                aVar.f();
            }
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void g(MediaPlayer mediaPlayer) {
        }

        @Override // com.aggmoread.sdk.z.b.t.f.j
        public void a(boolean z10) {
        }
    }

    public class b implements MediaPlayer.OnPreparedListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4693a;

        public b(d dVar, e.a aVar) {
            this.f4693a = aVar;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4693a;
            if (aVar != null) {
                aVar.a(mediaPlayer.getDuration());
                this.f4693a.b();
            }
        }
    }

    public class c implements MediaPlayer.OnCompletionListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4694a;

        public c(d dVar, e.a aVar) {
            this.f4694a = aVar;
        }

        @Override // android.media.MediaPlayer.OnCompletionListener
        public void onCompletion(MediaPlayer mediaPlayer) {
            e.a aVar = this.f4694a;
            if (aVar != null) {
                aVar.c();
            }
        }
    }

    /* renamed from: com.aggmoread.sdk.z.b.l.d$d */
    public class C0081d implements MediaPlayer.OnErrorListener {

        /* renamed from: a */
        final /* synthetic */ e.a f4695a;

        public C0081d(d dVar, e.a aVar) {
            this.f4695a = aVar;
        }

        @Override // android.media.MediaPlayer.OnErrorListener
        public boolean onError(MediaPlayer mediaPlayer, int i10, int i11) {
            e.a aVar = this.f4695a;
            if (aVar == null) {
                return false;
            }
            aVar.a(new com.aggmoread.sdk.z.b.g.e(i10, "extra msg: " + i11));
            return false;
        }
    }

    public d(com.aggmoread.sdk.z.b.g.b bVar, b.a.C0072a c0072a) {
        this.f4684a = c0072a;
        this.f4686c = bVar;
        bVar.d().i();
        UUID.randomUUID().toString();
    }

    private boolean d() {
        return com.aggmoread.sdk.z.b.h.a.d().g() ? this.f4687d && this.f4688e < 2 && System.currentTimeMillis() - this.f4691h > 5000 : this.f4687d;
    }

    private void f() {
        if (this.f4687d || !com.aggmoread.sdk.z.b.m.b.a(this.f4689f)) {
            return;
        }
        this.f4685b.onADExposed();
        com.aggmoread.sdk.z.b.q.a.a("onAdExposure", this.f4684a.f4461q);
        this.f4687d = true;
        this.f4689f.a();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public View a(View view, List<View> list, f fVar) {
        view.getContext();
        ArrayList<View> arrayList = new ArrayList<>();
        this.f4685b = fVar;
        if (list != null) {
            if (list.indexOf(view) == -1) {
                com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "bindView enter, add clickable view");
                arrayList.add(view);
            }
            com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "bindView enter, view = " + view + " , clickableViews size = " + list.size());
            arrayList.addAll(list);
        } else {
            arrayList.add(view);
        }
        a(arrayList);
        if (view instanceof com.aggmoread.sdk.z.b.u.d) {
            com.aggmoread.sdk.z.b.u.d dVar = (com.aggmoread.sdk.z.b.u.d) view;
            this.f4689f = dVar;
            dVar.a(this);
            f();
            return view;
        }
        com.aggmoread.sdk.z.b.u.d dVar2 = new com.aggmoread.sdk.z.b.u.d(view.getContext());
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            ((ViewGroup) parent).removeView(view);
        }
        this.f4689f = dVar2;
        dVar2.a(this);
        this.f4689f.addView(view);
        return this.f4689f;
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public List<String> b() {
        return this.f4684a.l();
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void c() {
        f();
        com.aggmoread.sdk.z.b.d.c(f4683i, "dispatchDraw enter , SdkHelper.isShown(nativeAdViewExt) = " + com.aggmoread.sdk.z.b.m.b.a(this.f4689f));
    }

    public int e() {
        return this.f4684a.n();
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getDesc() {
        List<String> g10 = this.f4684a.g();
        if (g10 == null || g10.size() <= 0) {
            return null;
        }
        return g10.get(0);
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getIconUrl() {
        List<String> k10 = this.f4684a.k();
        if (k10 == null || k10.size() <= 0) {
            return null;
        }
        return k10.get(0);
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getImageUrl() {
        List<String> l10 = this.f4684a.l();
        if (l10 == null || l10.size() <= 0) {
            return null;
        }
        return l10.get(0);
    }

    @Override // com.aggmoread.sdk.z.b.l.b
    public String getTitle() {
        return this.f4684a.f4447c;
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public int getVideoCurrentPosition() {
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            return fVar.f();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public int getVideoDuration() {
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            return fVar.e();
        }
        return 0;
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isAppAd() {
        return this.f4684a.r();
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public boolean isVideoAd() {
        return !TextUtils.isEmpty(this.f4684a.o());
    }

    @Override // android.view.View.OnClickListener, com.aggmoread.sdk.z.b.u.d.c
    public void onClick(View view) {
        if (!d()) {
            com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "abort click , reason: hasExporsed = " + this.f4687d + " , isClicked = " + this.f4688e);
            return;
        }
        this.f4691h = System.currentTimeMillis();
        this.f4688e++;
        this.f4685b.onADClicked();
        com.aggmoread.sdk.z.b.g.c cVar = this.f4689f.f5046c;
        String str = f4683i;
        com.aggmoread.sdk.z.b.d.c(str, "feedsListFrameLayout2 juHeApiAdUrlDefine = " + cVar);
        com.aggmoread.sdk.z.b.d.c(str, "action e x = " + (((float) cVar.f4469a) / ((float) cVar.f4473e)) + " ,y = " + (((float) cVar.f4470b) / ((float) cVar.f4474f)));
        com.aggmoread.sdk.z.b.q.a.a(IAdInterListener.AdCommandType.AD_CLICK, this.f4684a.f4462r, cVar);
        l.a(this.f4686c, this.f4684a, cVar, this.f4685b);
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void onScrollChanged() {
        f();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void pauseVideo() {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "pauseVideo");
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            fVar.b();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.c
    public void resume() {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", id.c.f26967d);
        resumeVideo();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void resumeVideo() {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "resumeVideo");
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            fVar.d();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void startVideo() {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "startVideo");
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            fVar.d();
        }
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void stopVideo() {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "stopVideo");
        com.aggmoread.sdk.z.b.t.f fVar = this.f4690g;
        if (fVar != null) {
            fVar.q();
        }
    }

    @Override // com.aggmoread.sdk.z.b.u.d.c
    public void a(int i10) {
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", "onWindowVisibilityChanged = " + i10);
        if (this.f4687d || i10 != 0) {
            return;
        }
        f();
    }

    @Override // com.aggmoread.sdk.z.b.l.e
    public void a(g gVar, com.aggmoread.sdk.z.b.t.e eVar, e.a aVar) {
        String str;
        if (this.f4689f == null) {
            str = "container shouldn't be null!";
        } else if (gVar == null) {
            str = "media view shouldn't be null!";
        } else if (gVar.getVisibility() != 0) {
            str = "media view should be visible!";
        } else if (!isVideoAd()) {
            str = "The native ad doesn't contain video!";
        } else {
            if (com.aggmoread.sdk.z.b.m.b.a(this.f4689f, gVar)) {
                com.aggmoread.sdk.z.b.t.f b10 = gVar.b();
                com.aggmoread.sdk.z.b.t.a a10 = gVar.a();
                if (a10 instanceof com.aggmoread.sdk.z.b.t.b) {
                    if (eVar == null && this.f4686c.d() != null) {
                        eVar = this.f4686c.d().l();
                    }
                    if (eVar != null) {
                        ((com.aggmoread.sdk.z.b.t.b) a10).b(eVar.a());
                    }
                }
                if (b10 != null) {
                    this.f4690g = b10;
                    b10.a(new a(this, aVar));
                    b10.a(new b(this, aVar));
                    b10.a(new c(this, aVar));
                    b10.a(new C0081d(this, aVar));
                    String o10 = this.f4684a.o();
                    if (TextUtils.isEmpty(o10)) {
                        return;
                    }
                    b10.a(o10);
                    b10.requestFocus();
                    b10.d();
                    return;
                }
                return;
            }
            str = "The media view not in container !";
        }
        com.aggmoread.sdk.z.b.d.c("JHAIMPTAG", str);
    }

    private void a(ArrayList<View> arrayList) {
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            View view = arrayList.get(i10);
            if (view != null) {
                view.setFocusable(true);
                view.setClickable(true);
            }
        }
    }
}
