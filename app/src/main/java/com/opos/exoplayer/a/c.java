package com.opos.exoplayer.a;

import android.R;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.opos.exoplayer.core.e.m;
import com.opos.exoplayer.core.f.j;
import com.opos.exoplayer.core.g.g;
import com.opos.exoplayer.core.i.u;
import com.opos.exoplayer.core.metadata.Metadata;
import com.opos.exoplayer.core.metadata.id3.ApicFrame;
import com.opos.exoplayer.core.q;
import java.util.List;

/* loaded from: classes4.dex */
public class c extends FrameLayout {

    /* renamed from: a */
    private int f17462a;

    /* renamed from: b */
    private final com.opos.exoplayer.a.a f17463b;

    /* renamed from: c */
    private View f17464c;

    /* renamed from: d */
    private final a f17465d;

    /* renamed from: e */
    private final View f17466e;

    /* renamed from: f */
    private final ImageView f17467f;

    /* renamed from: g */
    private final d f17468g;

    /* renamed from: h */
    private final b f17469h;

    /* renamed from: i */
    private final FrameLayout f17470i;

    /* renamed from: j */
    private q f17471j;
    private boolean k;
    private boolean l;
    private Bitmap m;
    private int n;
    private boolean o;
    private boolean p;
    private boolean q;
    private int r;

    private final class a extends q.a implements View.OnLayoutChangeListener, j, com.opos.exoplayer.core.video.e {
        private a() {
        }

        /* synthetic */ a(c cVar, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a() {
            if (c.this.f17466e != null) {
                c.this.f17466e.setVisibility(4);
            }
        }

        @Override // com.opos.exoplayer.core.video.e
        public void a(int i2, int i3, int i4, float f2) {
            if (c.this.f17463b == null) {
                return;
            }
            float f3 = (i3 == 0 || i2 == 0) ? 1.0f : (i2 * f2) / i3;
            if (c.this.f17464c instanceof TextureView) {
                if (i4 == 90 || i4 == 270) {
                    f3 = 1.0f / f3;
                }
                if (c.this.r != 0) {
                    c.this.f17464c.removeOnLayoutChangeListener(this);
                }
                c.this.r = i4;
                if (c.this.r != 0) {
                    c.this.f17464c.addOnLayoutChangeListener(this);
                }
                c.b((TextureView) c.this.f17464c, c.this.r);
            }
            c.this.f17463b.a(f3);
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(m mVar, g gVar) {
            c.this.e();
        }

        @Override // com.opos.exoplayer.core.f.j
        public void a(List<com.opos.exoplayer.core.f.b> list) {
            if (c.this.f17468g != null) {
                c.this.f17468g.a(list);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void a(boolean z, int i2) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            } else {
                c.this.b(false);
            }
        }

        @Override // com.opos.exoplayer.core.q.a, com.opos.exoplayer.core.q.b
        public void b(int i2) {
            if (c.this.d() && c.this.p) {
                c.this.a();
            }
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            c.b((TextureView) view, c.this.r);
        }
    }

    public c(Context context) {
        this(context, null);
    }

    public c(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public c(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17462a = 2;
        if (isInEditMode()) {
            this.f17463b = null;
            this.f17465d = null;
            this.f17464c = null;
            this.f17466e = null;
            this.f17467f = null;
            this.f17468g = null;
            this.f17469h = null;
            this.f17470i = null;
            ImageView imageView = new ImageView(context);
            if (u.f19078a >= 23) {
                a(getResources(), imageView);
            } else {
                b(getResources(), imageView);
            }
            addView(imageView);
            return;
        }
        this.f17465d = new a();
        setDescendantFocusability(262144);
        com.opos.exoplayer.a.a aVar = new com.opos.exoplayer.a.a(context);
        this.f17463b = aVar;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        layoutParams.gravity = 17;
        addView(aVar, layoutParams);
        a(aVar, 0);
        View view = new View(context);
        this.f17466e = view;
        view.setBackgroundColor(-16777216);
        aVar.addView(view, new FrameLayout.LayoutParams(-1, -1));
        if (this.f17462a != 0) {
            ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(-1, -1);
            View textureView = this.f17462a == 2 ? new TextureView(context) : new SurfaceView(context);
            this.f17464c = textureView;
            textureView.setLayoutParams(layoutParams2);
            aVar.addView(this.f17464c, 0);
        } else {
            this.f17464c = null;
        }
        FrameLayout frameLayout = new FrameLayout(context);
        this.f17470i = frameLayout;
        addView(frameLayout, new FrameLayout.LayoutParams(-1, -1));
        ImageView imageView2 = new ImageView(context);
        this.f17467f = imageView2;
        imageView2.setScaleType(ImageView.ScaleType.FIT_XY);
        aVar.addView(imageView2, new FrameLayout.LayoutParams(-1, -1));
        this.l = true;
        d dVar = new d(context);
        this.f17468g = dVar;
        aVar.addView(dVar, new FrameLayout.LayoutParams(-1, -1));
        dVar.b();
        dVar.a();
        View view2 = new View(context);
        addView(view2, new FrameLayout.LayoutParams(-1, -1));
        b bVar = new b(context, null, 0, attributeSet);
        this.f17469h = bVar;
        bVar.setLayoutParams(view2.getLayoutParams());
        ViewGroup viewGroup = (ViewGroup) view2.getParent();
        int indexOfChild = viewGroup.indexOfChild(view2);
        viewGroup.removeView(view2);
        viewGroup.addView(bVar, indexOfChild);
        this.n = this.n;
        this.q = true;
        this.o = true;
        this.p = true;
        this.k = true;
        a();
    }

    @TargetApi(23)
    private static void a(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    private static void a(com.opos.exoplayer.a.a aVar, int i2) {
        aVar.a(i2);
    }

    private boolean a(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= 0 || height <= 0) {
            return false;
        }
        com.opos.exoplayer.a.a aVar = this.f17463b;
        if (aVar != null) {
            aVar.a(width / height);
        }
        this.f17467f.setImageBitmap(bitmap);
        this.f17467f.setVisibility(0);
        return true;
    }

    private boolean a(Metadata metadata) {
        for (int i2 = 0; i2 < metadata.a(); i2++) {
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof ApicFrame) {
                byte[] bArr = ((ApicFrame) a2).f19118d;
                return a(BitmapFactory.decodeByteArray(bArr, 0, bArr.length));
            }
        }
        return false;
    }

    private static void b(Resources resources, ImageView imageView) {
        imageView.setBackgroundColor(Color.parseColor("#FFF4F3F0"));
    }

    public static void b(TextureView textureView, int i2) {
        float width = textureView.getWidth();
        float height = textureView.getHeight();
        if (width == 0.0f || height == 0.0f || i2 == 0) {
            textureView.setTransform(null);
            return;
        }
        Matrix matrix = new Matrix();
        float f2 = width / 2.0f;
        float f3 = height / 2.0f;
        matrix.postRotate(i2, f2, f3);
        RectF rectF = new RectF(0.0f, 0.0f, width, height);
        RectF rectF2 = new RectF();
        matrix.mapRect(rectF2, rectF);
        matrix.postScale(width / rectF2.width(), height / rectF2.height(), f2, f3);
        textureView.setTransform(matrix);
    }

    public void b(boolean z) {
        if (!(d() && this.p) && this.k) {
            boolean z2 = this.f17469h.d() && this.f17469h.a() <= 0;
            boolean c2 = c();
            if (z || z2 || c2) {
                c(c2);
            }
            if (z || c2) {
                c(c2);
            }
        }
    }

    private void c(boolean z) {
        if (this.k) {
            this.f17469h.a(z ? 0 : this.n);
            this.f17469h.b();
        }
    }

    private boolean c() {
        q qVar = this.f17471j;
        if (qVar == null) {
            return true;
        }
        int c2 = qVar.c();
        return this.o && (c2 == 1 || c2 == 4 || !this.f17471j.d());
    }

    public boolean d() {
        q qVar = this.f17471j;
        return qVar != null && qVar.o() && this.f17471j.d();
    }

    @SuppressLint({"InlinedApi"})
    private boolean d(int i2) {
        return i2 == 19 || i2 == 270 || i2 == 22 || i2 == 271 || i2 == 20 || i2 == 269 || i2 == 21 || i2 == 268 || i2 == 23;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x005b, code lost:
    
        f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x005e, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void e() {
        /*
            r6 = this;
            com.opos.exoplayer.core.q r0 = r6.f17471j
            if (r0 != 0) goto L5
            goto L5e
        L5:
            com.opos.exoplayer.core.g.g r0 = r0.g()
            r1 = 0
            r2 = 0
        Lb:
            int r3 = r0.f18888a
            if (r2 >= r3) goto L22
            com.opos.exoplayer.core.q r3 = r6.f17471j
            int r3 = r3.b(r2)
            r4 = 2
            if (r3 != r4) goto L1f
            com.opos.exoplayer.core.g.f r3 = r0.a(r2)
            if (r3 == 0) goto L1f
            goto L5b
        L1f:
            int r2 = r2 + 1
            goto Lb
        L22:
            android.view.View r2 = r6.f17466e
            if (r2 == 0) goto L29
            r2.setVisibility(r1)
        L29:
            boolean r2 = r6.l
            if (r2 == 0) goto L5b
            r2 = 0
        L2e:
            int r3 = r0.f18888a
            if (r2 >= r3) goto L53
            com.opos.exoplayer.core.g.f r3 = r0.a(r2)
            if (r3 == 0) goto L50
            r4 = 0
        L39:
            int r5 = r3.e()
            if (r4 >= r5) goto L50
            com.opos.exoplayer.core.Format r5 = r3.a(r4)
            com.opos.exoplayer.core.metadata.Metadata r5 = r5.f17494d
            if (r5 == 0) goto L4d
            boolean r5 = r6.a(r5)
            if (r5 != 0) goto L5e
        L4d:
            int r4 = r4 + 1
            goto L39
        L50:
            int r2 = r2 + 1
            goto L2e
        L53:
            android.graphics.Bitmap r0 = r6.m
            boolean r0 = r6.a(r0)
            if (r0 != 0) goto L5e
        L5b:
            r6.f()
        L5e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.opos.exoplayer.a.c.e():void");
    }

    private void f() {
        ImageView imageView = this.f17467f;
        if (imageView != null) {
            imageView.setImageResource(R.color.transparent);
            this.f17467f.setVisibility(4);
        }
    }

    public void a() {
        b bVar = this.f17469h;
        if (bVar != null) {
            bVar.c();
        }
    }

    public void a(int i2) {
        if (this.f17462a == i2 || this.f17471j == null || this.f17463b == null) {
            return;
        }
        View view = this.f17464c;
        this.f17462a = i2;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        View surfaceView = this.f17462a == 1 ? new SurfaceView(getContext()) : new TextureView(getContext());
        this.f17464c = surfaceView;
        surfaceView.setLayoutParams(layoutParams);
        q.d a2 = this.f17471j.a();
        if (a2 != null) {
            if (view != null) {
                this.f17463b.removeView(view);
                if (view instanceof TextureView) {
                    a2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    a2.b((SurfaceView) view);
                }
            }
            View view2 = this.f17464c;
            if (view2 != null) {
                this.f17463b.addView(view2, 0);
                View view3 = this.f17464c;
                if (view3 instanceof TextureView) {
                    a2.a((TextureView) view3);
                } else if (view3 instanceof SurfaceView) {
                    a2.a((SurfaceView) view3);
                }
            }
        }
    }

    public void a(q qVar) {
        q qVar2 = this.f17471j;
        if (qVar2 == qVar) {
            return;
        }
        if (qVar2 != null) {
            qVar2.b(this.f17465d);
            q.d a2 = this.f17471j.a();
            if (a2 != null) {
                a2.b(this.f17465d);
                View view = this.f17464c;
                if (view instanceof TextureView) {
                    a2.b((TextureView) view);
                } else if (view instanceof SurfaceView) {
                    a2.b((SurfaceView) view);
                }
            }
            q.c b2 = this.f17471j.b();
            if (b2 != null) {
                b2.b(this.f17465d);
            }
        }
        this.f17471j = qVar;
        if (this.k) {
            this.f17469h.a(qVar);
        }
        View view2 = this.f17466e;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        d dVar = this.f17468g;
        if (dVar != null) {
            dVar.b(null);
        }
        if (qVar == null) {
            a();
            f();
            return;
        }
        q.d a3 = qVar.a();
        if (a3 != null) {
            View view3 = this.f17464c;
            if (view3 instanceof TextureView) {
                a3.a((TextureView) view3);
            } else if (view3 instanceof SurfaceView) {
                a3.a((SurfaceView) view3);
            }
            a3.a(this.f17465d);
        }
        q.c b3 = qVar.b();
        if (b3 != null) {
            b3.a(this.f17465d);
        }
        qVar.a(this.f17465d);
        b(false);
        e();
    }

    public void a(boolean z) {
        b bVar;
        q qVar;
        com.opos.exoplayer.core.i.a.b((z && this.f17469h == null) ? false : true);
        if (this.k == z) {
            return;
        }
        this.k = z;
        if (z) {
            bVar = this.f17469h;
            qVar = this.f17471j;
        } else {
            b bVar2 = this.f17469h;
            if (bVar2 == null) {
                return;
            }
            bVar2.c();
            bVar = this.f17469h;
            qVar = null;
        }
        bVar.a(qVar);
    }

    public boolean a(KeyEvent keyEvent) {
        return this.k && this.f17469h.a(keyEvent);
    }

    public View b() {
        return this.f17464c;
    }

    public void b(int i2) {
        com.opos.exoplayer.core.i.a.b(this.f17463b != null);
        this.f17463b.a(i2);
    }

    public void c(int i2) {
        View view = this.f17466e;
        if (view != null) {
            view.setBackgroundColor(i2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        q qVar = this.f17471j;
        if (qVar != null && qVar.o()) {
            this.f17470i.requestFocus();
            return super.dispatchKeyEvent(keyEvent);
        }
        boolean z = d(keyEvent.getKeyCode()) && this.k && !this.f17469h.d();
        b(true);
        return z || a(keyEvent) || super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.k || this.f17471j == null || motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (!this.f17469h.d()) {
            b(true);
            return true;
        }
        if (!this.q) {
            return true;
        }
        this.f17469h.c();
        return true;
    }

    @Override // android.view.View
    public boolean onTrackballEvent(MotionEvent motionEvent) {
        if (!this.k || this.f17471j == null) {
            return false;
        }
        b(true);
        return true;
    }

    @Override // android.view.View
    public void setVisibility(int i2) {
        super.setVisibility(i2);
        View view = this.f17464c;
        if (view instanceof SurfaceView) {
            view.setVisibility(i2);
        }
    }
}
