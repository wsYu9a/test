package com.opos.mobad.o.b;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.opos.mobad.model.data.AdItemData;

/* loaded from: classes4.dex */
public class j extends h {
    private a H;

    /* renamed from: a */
    private volatile boolean f23048a;

    /* renamed from: com.opos.mobad.o.b.j$1 */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (k.a().a(j.this.A)) {
                com.opos.cmn.an.f.a.b("MediaCreative", "onViewDetachedFromWindow release video");
                k.a().c();
            }
            j.this.ai();
        }
    }

    /* renamed from: com.opos.mobad.o.b.j$2 */
    class AnonymousClass2 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23050a;

        /* renamed from: b */
        final /* synthetic */ AdItemData f23051b;

        AnonymousClass2(String str, AdItemData adItemData) {
            str = str;
            adItemData = adItemData;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (j.this.f23048a) {
                return;
            }
            j jVar = j.this;
            jVar.a(jVar.l, 5);
            j jVar2 = j.this;
            jVar2.a(jVar2.n, 4);
            k a2 = k.a();
            Context context = j.this.f22992b;
            String str = str;
            int P = adItemData.P();
            j jVar3 = j.this;
            a2.a(context, str, P, jVar3.n, jVar3, false);
        }
    }

    /* renamed from: com.opos.mobad.o.b.j$3 */
    class AnonymousClass3 implements Runnable {

        /* renamed from: a */
        final /* synthetic */ String f23053a;

        AnonymousClass3(String str) {
            str = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Bitmap a2 = com.opos.mobad.cmn.a.b.g.a(str, com.opos.cmn.an.h.f.a.b(j.this.f22992b), (com.opos.cmn.an.h.f.a.b(j.this.f22992b) * 9) / 16);
            if (a2 != null) {
                j.this.H.a(j.this.l, a2);
            }
        }
    }

    /* renamed from: com.opos.mobad.o.b.j$4 */
    class AnonymousClass4 implements a {

        /* renamed from: com.opos.mobad.o.b.j$4$1 */
        class AnonymousClass1 implements Runnable {

            /* renamed from: a */
            final /* synthetic */ ImageView f23056a;

            /* renamed from: b */
            final /* synthetic */ Bitmap f23057b;

            AnonymousClass1(ImageView imageView, Bitmap bitmap) {
                imageView = imageView;
                bitmap = bitmap;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap bitmap;
                ImageView imageView = imageView;
                if (imageView == null || (bitmap = bitmap) == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
                com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
            }
        }

        AnonymousClass4() {
        }

        @Override // com.opos.mobad.o.b.j.a
        public void a(ImageView imageView, Bitmap bitmap) {
            if (imageView == null || bitmap == null) {
                return;
            }
            com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.j.4.1

                /* renamed from: a */
                final /* synthetic */ ImageView f23056a;

                /* renamed from: b */
                final /* synthetic */ Bitmap f23057b;

                AnonymousClass1(ImageView imageView2, Bitmap bitmap2) {
                    imageView = imageView2;
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    ImageView imageView2 = imageView;
                    if (imageView2 == null || (bitmap2 = bitmap) == null) {
                        return;
                    }
                    imageView2.setImageBitmap(bitmap2);
                    com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                }
            });
        }
    }

    private interface a {
        void a(ImageView imageView, Bitmap bitmap);
    }

    public j(Context context, d dVar, FrameLayout frameLayout) {
        super(context, dVar, frameLayout, false);
        this.f23048a = false;
        this.H = new a() { // from class: com.opos.mobad.o.b.j.4

            /* renamed from: com.opos.mobad.o.b.j$4$1 */
            class AnonymousClass1 implements Runnable {

                /* renamed from: a */
                final /* synthetic */ ImageView f23056a;

                /* renamed from: b */
                final /* synthetic */ Bitmap f23057b;

                AnonymousClass1(ImageView imageView2, Bitmap bitmap2) {
                    imageView = imageView2;
                    bitmap = bitmap2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Bitmap bitmap2;
                    ImageView imageView2 = imageView;
                    if (imageView2 == null || (bitmap2 = bitmap) == null) {
                        return;
                    }
                    imageView2.setImageBitmap(bitmap2);
                    com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                }
            }

            AnonymousClass4() {
            }

            @Override // com.opos.mobad.o.b.j.a
            public void a(ImageView imageView2, Bitmap bitmap2) {
                if (imageView2 == null || bitmap2 == null) {
                    return;
                }
                com.opos.mobad.service.c.a(new Runnable() { // from class: com.opos.mobad.o.b.j.4.1

                    /* renamed from: a */
                    final /* synthetic */ ImageView f23056a;

                    /* renamed from: b */
                    final /* synthetic */ Bitmap f23057b;

                    AnonymousClass1(ImageView imageView22, Bitmap bitmap22) {
                        imageView = imageView22;
                        bitmap = bitmap22;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        Bitmap bitmap22;
                        ImageView imageView22 = imageView;
                        if (imageView22 == null || (bitmap22 = bitmap) == null) {
                            return;
                        }
                        imageView22.setImageBitmap(bitmap22);
                        com.opos.cmn.an.f.a.b("MediaCreative", "mIImgLoaderResult success");
                    }
                });
            }
        };
    }

    public void ai() {
        Drawable drawable;
        ImageView imageView = this.l;
        if (imageView == null || (drawable = imageView.getDrawable()) == null) {
            return;
        }
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null && !bitmapDrawable.getBitmap().isRecycled()) {
                bitmapDrawable.getBitmap().recycle();
                com.opos.cmn.an.f.a.b("MediaCreative", "recycle bitmap");
            }
        }
        this.l.setImageDrawable(null);
    }

    @Override // com.opos.mobad.o.b.a
    protected void a() {
        RelativeLayout relativeLayout = this.n;
        if (relativeLayout != null) {
            relativeLayout.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.opos.mobad.o.b.j.1
                AnonymousClass1() {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                    if (k.a().a(j.this.A)) {
                        com.opos.cmn.an.f.a.b("MediaCreative", "onViewDetachedFromWindow release video");
                        k.a().c();
                    }
                    j.this.ai();
                }
            });
        }
    }

    @Override // com.opos.mobad.o.b.e
    public void a(View view, int[] iArr) {
        c(view, iArr);
    }

    @Override // com.opos.mobad.o.b.a
    public void a(View view, int[] iArr, int i2) {
        c(view, iArr);
    }

    public void a(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideo url:" + str);
        if (adItemData != null) {
            this.f22993c = adItemData;
            this.A = str;
            if (adItemData.i().get(0) != null) {
                com.opos.mobad.service.c.c(new Runnable() { // from class: com.opos.mobad.o.b.j.2

                    /* renamed from: a */
                    final /* synthetic */ String f23050a;

                    /* renamed from: b */
                    final /* synthetic */ AdItemData f23051b;

                    AnonymousClass2(String str2, AdItemData adItemData2) {
                        str = str2;
                        adItemData = adItemData2;
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (j.this.f23048a) {
                            return;
                        }
                        j jVar = j.this;
                        jVar.a(jVar.l, 5);
                        j jVar2 = j.this;
                        jVar2.a(jVar2.n, 4);
                        k a2 = k.a();
                        Context context = j.this.f22992b;
                        String str2 = str;
                        int P = adItemData.P();
                        j jVar3 = j.this;
                        a2.a(context, str2, P, jVar3.n, jVar3, false);
                    }
                });
            }
        }
    }

    @Override // com.opos.mobad.o.b.h
    protected void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        com.opos.cmn.an.j.b.c(new Runnable() { // from class: com.opos.mobad.o.b.j.3

            /* renamed from: a */
            final /* synthetic */ String f23053a;

            AnonymousClass3(String str2) {
                str = str2;
            }

            @Override // java.lang.Runnable
            public void run() {
                Bitmap a2 = com.opos.mobad.cmn.a.b.g.a(str, com.opos.cmn.an.h.f.a.b(j.this.f22992b), (com.opos.cmn.an.h.f.a.b(j.this.f22992b) * 9) / 16);
                if (a2 != null) {
                    j.this.H.a(j.this.l, a2);
                }
            }
        });
    }

    public void b() {
        com.opos.cmn.an.f.a.b("MediaCreative", "release video and ad");
        this.f23048a = true;
        W();
        S();
        T();
    }

    @Override // com.opos.mobad.o.b.e
    public void b(View view, int[] iArr) {
        c(view, iArr);
    }

    public void b(AdItemData adItemData) {
        ViewGroup.LayoutParams layoutParams;
        com.opos.cmn.an.f.a.b("MediaCreative", "renderInitCoverUI ");
        if (this.l == null) {
            ImageView imageView = new ImageView(this.f22992b);
            this.l = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        }
        if (this.l.getParent() == null || this.l.getParent() == this.f22994d) {
            if (this.l.getParent() == null) {
                layoutParams = new ViewGroup.LayoutParams(-1, -1);
            }
            a(adItemData);
            X();
        }
        ((ViewGroup) this.l.getParent()).removeView(this.l);
        layoutParams = new ViewGroup.LayoutParams(-1, -1);
        this.f22994d.addView(this.l, layoutParams);
        a(this.l, 5);
        a(adItemData);
        X();
    }

    public void b(AdItemData adItemData, String str) {
        com.opos.cmn.an.f.a.b("MediaCreative", "playVideoWithoutCheckPlaying url:" + str);
        if (adItemData != null) {
            this.f22993c = adItemData;
            this.A = str;
            if (adItemData.i().get(0) != null) {
                a(this.l, 5);
                a(this.n, 4);
                X();
                k.a().b(this.f22992b, str, adItemData.P(), this.n, this, false);
            }
        }
    }

    protected void c(View view, int[] iArr) {
        d dVar = this.u;
        if (dVar != null) {
            dVar.a(view, iArr, k.a().e(this.A), com.opos.mobad.cmn.a.b.a.Video);
        }
    }
}
