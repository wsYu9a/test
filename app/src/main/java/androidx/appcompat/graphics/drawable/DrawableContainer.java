package androidx.appcompat.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.graphics.drawable.DrawableCompat;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
class DrawableContainer extends Drawable implements Drawable.Callback {

    /* renamed from: a */
    private static final boolean f367a = false;

    /* renamed from: b */
    private static final String f368b = "DrawableContainer";

    /* renamed from: c */
    private static final boolean f369c = true;

    /* renamed from: d */
    private DrawableContainerState f370d;

    /* renamed from: e */
    private Rect f371e;

    /* renamed from: f */
    private Drawable f372f;

    /* renamed from: g */
    private Drawable f373g;

    /* renamed from: i */
    private boolean f375i;
    private boolean l;
    private Runnable m;
    private long n;
    private long o;
    private BlockInvalidateCallback p;

    /* renamed from: h */
    private int f374h = 255;

    /* renamed from: j */
    private int f376j = -1;
    private int k = -1;

    /* renamed from: androidx.appcompat.graphics.drawable.DrawableContainer$1 */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DrawableContainer.this.a(true);
            DrawableContainer.this.invalidateSelf();
        }
    }

    static class BlockInvalidateCallback implements Drawable.Callback {

        /* renamed from: a */
        private Drawable.Callback f378a;

        BlockInvalidateCallback() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(@NonNull Drawable drawable) {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
            Drawable.Callback callback = this.f378a;
            if (callback != null) {
                callback.scheduleDrawable(drawable, runnable, j2);
            }
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
            Drawable.Callback callback = this.f378a;
            if (callback != null) {
                callback.unscheduleDrawable(drawable, runnable);
            }
        }

        public Drawable.Callback unwrap() {
            Drawable.Callback callback = this.f378a;
            this.f378a = null;
            return callback;
        }

        public BlockInvalidateCallback wrap(Drawable.Callback callback) {
            this.f378a = callback;
            return this;
        }
    }

    static abstract class DrawableContainerState extends Drawable.ConstantState {
        int A;
        int B;
        boolean C;
        ColorFilter D;
        boolean E;
        ColorStateList F;
        PorterDuff.Mode G;
        boolean H;
        boolean I;

        /* renamed from: a */
        final DrawableContainer f379a;

        /* renamed from: b */
        Resources f380b;

        /* renamed from: c */
        int f381c;

        /* renamed from: d */
        int f382d;

        /* renamed from: e */
        int f383e;

        /* renamed from: f */
        SparseArray<Drawable.ConstantState> f384f;

        /* renamed from: g */
        Drawable[] f385g;

        /* renamed from: h */
        int f386h;

        /* renamed from: i */
        boolean f387i;

        /* renamed from: j */
        boolean f388j;
        Rect k;
        boolean l;
        boolean m;
        int n;
        int o;
        int p;
        int q;
        boolean r;
        int s;
        boolean t;
        boolean u;
        boolean v;
        boolean w;
        boolean x;
        boolean y;
        int z;

        DrawableContainerState(DrawableContainerState drawableContainerState, DrawableContainer drawableContainer, Resources resources) {
            this.f381c = 160;
            this.f387i = false;
            this.l = false;
            this.x = true;
            this.A = 0;
            this.B = 0;
            this.f379a = drawableContainer;
            this.f380b = resources != null ? resources : drawableContainerState != null ? drawableContainerState.f380b : null;
            int g2 = DrawableContainer.g(resources, drawableContainerState != null ? drawableContainerState.f381c : 0);
            this.f381c = g2;
            if (drawableContainerState == null) {
                this.f385g = new Drawable[10];
                this.f386h = 0;
                return;
            }
            this.f382d = drawableContainerState.f382d;
            this.f383e = drawableContainerState.f383e;
            this.v = true;
            this.w = true;
            this.f387i = drawableContainerState.f387i;
            this.l = drawableContainerState.l;
            this.x = drawableContainerState.x;
            this.y = drawableContainerState.y;
            this.z = drawableContainerState.z;
            this.A = drawableContainerState.A;
            this.B = drawableContainerState.B;
            this.C = drawableContainerState.C;
            this.D = drawableContainerState.D;
            this.E = drawableContainerState.E;
            this.F = drawableContainerState.F;
            this.G = drawableContainerState.G;
            this.H = drawableContainerState.H;
            this.I = drawableContainerState.I;
            if (drawableContainerState.f381c == g2) {
                if (drawableContainerState.f388j) {
                    this.k = new Rect(drawableContainerState.k);
                    this.f388j = true;
                }
                if (drawableContainerState.m) {
                    this.n = drawableContainerState.n;
                    this.o = drawableContainerState.o;
                    this.p = drawableContainerState.p;
                    this.q = drawableContainerState.q;
                    this.m = true;
                }
            }
            if (drawableContainerState.r) {
                this.s = drawableContainerState.s;
                this.r = true;
            }
            if (drawableContainerState.t) {
                this.u = drawableContainerState.u;
                this.t = true;
            }
            Drawable[] drawableArr = drawableContainerState.f385g;
            this.f385g = new Drawable[drawableArr.length];
            this.f386h = drawableContainerState.f386h;
            SparseArray<Drawable.ConstantState> sparseArray = drawableContainerState.f384f;
            if (sparseArray != null) {
                this.f384f = sparseArray.clone();
            } else {
                this.f384f = new SparseArray<>(this.f386h);
            }
            int i2 = this.f386h;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    Drawable.ConstantState constantState = drawableArr[i3].getConstantState();
                    if (constantState != null) {
                        this.f384f.put(i3, constantState);
                    } else {
                        this.f385g[i3] = drawableArr[i3];
                    }
                }
            }
        }

        private void d() {
            SparseArray<Drawable.ConstantState> sparseArray = this.f384f;
            if (sparseArray != null) {
                int size = sparseArray.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f385g[this.f384f.keyAt(i2)] = h(this.f384f.valueAt(i2).newDrawable(this.f380b));
                }
                this.f384f = null;
            }
        }

        private Drawable h(Drawable drawable) {
            if (Build.VERSION.SDK_INT >= 23) {
                drawable.setLayoutDirection(this.z);
            }
            Drawable mutate = drawable.mutate();
            mutate.setCallback(this.f379a);
            return mutate;
        }

        @RequiresApi(21)
        final void a(Resources.Theme theme) {
            if (theme != null) {
                d();
                int i2 = this.f386h;
                Drawable[] drawableArr = this.f385g;
                for (int i3 = 0; i3 < i2; i3++) {
                    if (drawableArr[i3] != null && drawableArr[i3].canApplyTheme()) {
                        drawableArr[i3].applyTheme(theme);
                        this.f383e |= drawableArr[i3].getChangingConfigurations();
                    }
                }
                j(theme.getResources());
            }
        }

        public final int addChild(Drawable drawable) {
            int i2 = this.f386h;
            if (i2 >= this.f385g.length) {
                growArray(i2, i2 + 10);
            }
            drawable.mutate();
            drawable.setVisible(false, true);
            drawable.setCallback(this.f379a);
            this.f385g[i2] = drawable;
            this.f386h++;
            this.f383e = drawable.getChangingConfigurations() | this.f383e;
            f();
            this.k = null;
            this.f388j = false;
            this.m = false;
            this.v = false;
            return i2;
        }

        final void b() {
            this.y = false;
        }

        protected void c() {
            this.m = true;
            d();
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            this.o = -1;
            this.n = -1;
            this.q = 0;
            this.p = 0;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                int intrinsicWidth = drawable.getIntrinsicWidth();
                if (intrinsicWidth > this.n) {
                    this.n = intrinsicWidth;
                }
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicHeight > this.o) {
                    this.o = intrinsicHeight;
                }
                int minimumWidth = drawable.getMinimumWidth();
                if (minimumWidth > this.p) {
                    this.p = minimumWidth;
                }
                int minimumHeight = drawable.getMinimumHeight();
                if (minimumHeight > this.q) {
                    this.q = minimumHeight;
                }
            }
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @RequiresApi(21)
        public boolean canApplyTheme() {
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            for (int i3 = 0; i3 < i2; i3++) {
                Drawable drawable = drawableArr[i3];
                if (drawable == null) {
                    Drawable.ConstantState constantState = this.f384f.get(i3);
                    if (constantState != null && constantState.canApplyTheme()) {
                        return true;
                    }
                } else if (drawable.canApplyTheme()) {
                    return true;
                }
            }
            return false;
        }

        public synchronized boolean canConstantState() {
            if (this.v) {
                return this.w;
            }
            d();
            this.v = true;
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getConstantState() == null) {
                    this.w = false;
                    return false;
                }
            }
            this.w = true;
            return true;
        }

        final int e() {
            return this.f385g.length;
        }

        void f() {
            this.r = false;
            this.t = false;
        }

        void g() {
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3] != null) {
                    drawableArr[i3].mutate();
                }
            }
            this.y = true;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f382d | this.f383e;
        }

        public final Drawable getChild(int i2) {
            int indexOfKey;
            Drawable drawable = this.f385g[i2];
            if (drawable != null) {
                return drawable;
            }
            SparseArray<Drawable.ConstantState> sparseArray = this.f384f;
            if (sparseArray == null || (indexOfKey = sparseArray.indexOfKey(i2)) < 0) {
                return null;
            }
            Drawable h2 = h(this.f384f.valueAt(indexOfKey).newDrawable(this.f380b));
            this.f385g[i2] = h2;
            this.f384f.removeAt(indexOfKey);
            if (this.f384f.size() == 0) {
                this.f384f = null;
            }
            return h2;
        }

        public final int getChildCount() {
            return this.f386h;
        }

        public final int getConstantHeight() {
            if (!this.m) {
                c();
            }
            return this.o;
        }

        public final int getConstantMinimumHeight() {
            if (!this.m) {
                c();
            }
            return this.q;
        }

        public final int getConstantMinimumWidth() {
            if (!this.m) {
                c();
            }
            return this.p;
        }

        public final Rect getConstantPadding() {
            Rect rect = null;
            if (this.f387i) {
                return null;
            }
            Rect rect2 = this.k;
            if (rect2 != null || this.f388j) {
                return rect2;
            }
            d();
            Rect rect3 = new Rect();
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            for (int i3 = 0; i3 < i2; i3++) {
                if (drawableArr[i3].getPadding(rect3)) {
                    if (rect == null) {
                        rect = new Rect(0, 0, 0, 0);
                    }
                    int i4 = rect3.left;
                    if (i4 > rect.left) {
                        rect.left = i4;
                    }
                    int i5 = rect3.top;
                    if (i5 > rect.top) {
                        rect.top = i5;
                    }
                    int i6 = rect3.right;
                    if (i6 > rect.right) {
                        rect.right = i6;
                    }
                    int i7 = rect3.bottom;
                    if (i7 > rect.bottom) {
                        rect.bottom = i7;
                    }
                }
            }
            this.f388j = true;
            this.k = rect;
            return rect;
        }

        public final int getConstantWidth() {
            if (!this.m) {
                c();
            }
            return this.n;
        }

        public final int getEnterFadeDuration() {
            return this.A;
        }

        public final int getExitFadeDuration() {
            return this.B;
        }

        public final int getOpacity() {
            if (this.r) {
                return this.s;
            }
            d();
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            int opacity = i2 > 0 ? drawableArr[0].getOpacity() : -2;
            for (int i3 = 1; i3 < i2; i3++) {
                opacity = Drawable.resolveOpacity(opacity, drawableArr[i3].getOpacity());
            }
            this.s = opacity;
            this.r = true;
            return opacity;
        }

        public void growArray(int i2, int i3) {
            Drawable[] drawableArr = new Drawable[i3];
            System.arraycopy(this.f385g, 0, drawableArr, 0, i2);
            this.f385g = drawableArr;
        }

        final boolean i(int i2, int i3) {
            int i4 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            boolean z = false;
            for (int i5 = 0; i5 < i4; i5++) {
                if (drawableArr[i5] != null) {
                    boolean layoutDirection = Build.VERSION.SDK_INT >= 23 ? drawableArr[i5].setLayoutDirection(i2) : false;
                    if (i5 == i3) {
                        z = layoutDirection;
                    }
                }
            }
            this.z = i2;
            return z;
        }

        public final boolean isConstantSize() {
            return this.l;
        }

        public final boolean isStateful() {
            if (this.t) {
                return this.u;
            }
            d();
            int i2 = this.f386h;
            Drawable[] drawableArr = this.f385g;
            boolean z = false;
            int i3 = 0;
            while (true) {
                if (i3 >= i2) {
                    break;
                }
                if (drawableArr[i3].isStateful()) {
                    z = true;
                    break;
                }
                i3++;
            }
            this.u = z;
            this.t = true;
            return z;
        }

        final void j(Resources resources) {
            if (resources != null) {
                this.f380b = resources;
                int g2 = DrawableContainer.g(resources, this.f381c);
                int i2 = this.f381c;
                this.f381c = g2;
                if (i2 != g2) {
                    this.m = false;
                    this.f388j = false;
                }
            }
        }

        public final void setConstantSize(boolean z) {
            this.l = z;
        }

        public final void setEnterFadeDuration(int i2) {
            this.A = i2;
        }

        public final void setExitFadeDuration(int i2) {
            this.B = i2;
        }

        public final void setVariablePadding(boolean z) {
            this.f387i = z;
        }
    }

    DrawableContainer() {
    }

    private void e(Drawable drawable) {
        if (this.p == null) {
            this.p = new BlockInvalidateCallback();
        }
        drawable.setCallback(this.p.wrap(drawable.getCallback()));
        try {
            if (this.f370d.A <= 0 && this.f375i) {
                drawable.setAlpha(this.f374h);
            }
            DrawableContainerState drawableContainerState = this.f370d;
            if (drawableContainerState.E) {
                drawable.setColorFilter(drawableContainerState.D);
            } else {
                if (drawableContainerState.H) {
                    DrawableCompat.setTintList(drawable, drawableContainerState.F);
                }
                DrawableContainerState drawableContainerState2 = this.f370d;
                if (drawableContainerState2.I) {
                    DrawableCompat.setTintMode(drawable, drawableContainerState2.G);
                }
            }
            drawable.setVisible(isVisible(), true);
            drawable.setDither(this.f370d.x);
            drawable.setState(getState());
            drawable.setLevel(getLevel());
            drawable.setBounds(getBounds());
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 23) {
                drawable.setLayoutDirection(getLayoutDirection());
            }
            if (i2 >= 19) {
                drawable.setAutoMirrored(this.f370d.C);
            }
            Rect rect = this.f371e;
            if (i2 >= 21 && rect != null) {
                drawable.setHotspotBounds(rect.left, rect.top, rect.right, rect.bottom);
            }
        } finally {
            drawable.setCallback(this.p.unwrap());
        }
    }

    private boolean f() {
        return isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }

    static int g(@Nullable Resources resources, int i2) {
        if (resources != null) {
            i2 = resources.getDisplayMetrics().densityDpi;
        }
        if (i2 == 0) {
            return 160;
        }
        return i2;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x006d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:23:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    void a(boolean r14) {
        /*
            r13 = this;
            r0 = 1
            r13.f375i = r0
            long r1 = android.os.SystemClock.uptimeMillis()
            android.graphics.drawable.Drawable r3 = r13.f372f
            r4 = 255(0xff, double:1.26E-321)
            r6 = 0
            r7 = 0
            if (r3 == 0) goto L38
            long r9 = r13.n
            int r11 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r11 == 0) goto L3a
            int r11 = (r9 > r1 ? 1 : (r9 == r1 ? 0 : -1))
            if (r11 > 0) goto L22
            int r9 = r13.f374h
            r3.setAlpha(r9)
            r13.n = r7
            goto L3a
        L22:
            long r9 = r9 - r1
            long r9 = r9 * r4
            int r10 = (int) r9
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r9 = r13.f370d
            int r9 = r9.A
            int r10 = r10 / r9
            int r9 = 255 - r10
            int r10 = r13.f374h
            int r9 = r9 * r10
            int r9 = r9 / 255
            r3.setAlpha(r9)
            r3 = 1
            goto L3b
        L38:
            r13.n = r7
        L3a:
            r3 = 0
        L3b:
            android.graphics.drawable.Drawable r9 = r13.f373g
            if (r9 == 0) goto L68
            long r10 = r13.o
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 == 0) goto L6a
            int r12 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r12 > 0) goto L55
            r9.setVisible(r6, r6)
            r0 = 0
            r13.f373g = r0
            r0 = -1
            r13.k = r0
            r13.o = r7
            goto L6a
        L55:
            long r10 = r10 - r1
            long r10 = r10 * r4
            int r3 = (int) r10
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r4 = r13.f370d
            int r4 = r4.B
            int r3 = r3 / r4
            int r4 = r13.f374h
            int r3 = r3 * r4
            int r3 = r3 / 255
            r9.setAlpha(r3)
            goto L6b
        L68:
            r13.o = r7
        L6a:
            r0 = r3
        L6b:
            if (r14 == 0) goto L77
            if (r0 == 0) goto L77
            java.lang.Runnable r14 = r13.m
            r3 = 16
            long r1 = r1 + r3
            r13.scheduleSelf(r14, r1)
        L77:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainer.a(boolean):void");
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void applyTheme(@NonNull Resources.Theme theme) {
        this.f370d.a(theme);
    }

    void b() {
        this.f370d.b();
        this.l = false;
    }

    /* renamed from: c */
    DrawableContainerState l() {
        return this.f370d;
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public boolean canApplyTheme() {
        return this.f370d.canApplyTheme();
    }

    int d() {
        return this.f376j;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(@NonNull Canvas canvas) {
        Drawable drawable = this.f372f;
        if (drawable != null) {
            drawable.draw(canvas);
        }
        Drawable drawable2 = this.f373g;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f374h;
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        return super.getChangingConfigurations() | this.f370d.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public final Drawable.ConstantState getConstantState() {
        if (!this.f370d.canConstantState()) {
            return null;
        }
        this.f370d.f382d = getChangingConfigurations();
        return this.f370d;
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable getCurrent() {
        return this.f372f;
    }

    @Override // android.graphics.drawable.Drawable
    public void getHotspotBounds(@NonNull Rect rect) {
        Rect rect2 = this.f371e;
        if (rect2 != null) {
            rect.set(rect2);
        } else {
            super.getHotspotBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        if (this.f370d.isConstantSize()) {
            return this.f370d.getConstantHeight();
        }
        Drawable drawable = this.f372f;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        if (this.f370d.isConstantSize()) {
            return this.f370d.getConstantWidth();
        }
        Drawable drawable = this.f372f;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return -1;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        if (this.f370d.isConstantSize()) {
            return this.f370d.getConstantMinimumHeight();
        }
        Drawable drawable = this.f372f;
        if (drawable != null) {
            return drawable.getMinimumHeight();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        if (this.f370d.isConstantSize()) {
            return this.f370d.getConstantMinimumWidth();
        }
        Drawable drawable = this.f372f;
        if (drawable != null) {
            return drawable.getMinimumWidth();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f372f;
        if (drawable == null || !drawable.isVisible()) {
            return -2;
        }
        return this.f370d.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    @RequiresApi(21)
    public void getOutline(@NonNull Outline outline) {
        Drawable drawable = this.f372f;
        if (drawable != null) {
            drawable.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(@NonNull Rect rect) {
        boolean padding;
        Rect constantPadding = this.f370d.getConstantPadding();
        if (constantPadding != null) {
            rect.set(constantPadding);
            padding = (constantPadding.right | ((constantPadding.left | constantPadding.top) | constantPadding.bottom)) != 0;
        } else {
            Drawable drawable = this.f372f;
            padding = drawable != null ? drawable.getPadding(rect) : super.getPadding(rect);
        }
        if (f()) {
            int i2 = rect.left;
            rect.left = rect.right;
            rect.right = i2;
        }
        return padding;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    boolean h(int r9) {
        /*
            r8 = this;
            int r0 = r8.f376j
            r1 = 0
            if (r9 != r0) goto L6
            return r1
        L6:
            long r2 = android.os.SystemClock.uptimeMillis()
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r0 = r8.f370d
            int r0 = r0.B
            r4 = -1
            r5 = 0
            r6 = 0
            if (r0 <= 0) goto L35
            android.graphics.drawable.Drawable r0 = r8.f373g
            if (r0 == 0) goto L1b
            r0.setVisible(r1, r1)
        L1b:
            android.graphics.drawable.Drawable r0 = r8.f372f
            if (r0 == 0) goto L2e
            r8.f373g = r0
            int r0 = r8.f376j
            r8.k = r0
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r0 = r8.f370d
            int r0 = r0.B
            long r0 = (long) r0
            long r0 = r0 + r2
            r8.o = r0
            goto L3c
        L2e:
            r8.f373g = r5
            r8.k = r4
            r8.o = r6
            goto L3c
        L35:
            android.graphics.drawable.Drawable r0 = r8.f372f
            if (r0 == 0) goto L3c
            r0.setVisible(r1, r1)
        L3c:
            if (r9 < 0) goto L5c
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r0 = r8.f370d
            int r1 = r0.f386h
            if (r9 >= r1) goto L5c
            android.graphics.drawable.Drawable r0 = r0.getChild(r9)
            r8.f372f = r0
            r8.f376j = r9
            if (r0 == 0) goto L60
            androidx.appcompat.graphics.drawable.DrawableContainer$DrawableContainerState r9 = r8.f370d
            int r9 = r9.A
            if (r9 <= 0) goto L58
            long r4 = (long) r9
            long r2 = r2 + r4
            r8.n = r2
        L58:
            r8.e(r0)
            goto L60
        L5c:
            r8.f372f = r5
            r8.f376j = r4
        L60:
            long r0 = r8.n
            r9 = 1
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 != 0) goto L6d
            long r0 = r8.o
            int r2 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r2 == 0) goto L7f
        L6d:
            java.lang.Runnable r0 = r8.m
            if (r0 != 0) goto L79
            androidx.appcompat.graphics.drawable.DrawableContainer$1 r0 = new androidx.appcompat.graphics.drawable.DrawableContainer$1
            r0.<init>()
            r8.m = r0
            goto L7c
        L79:
            r8.unscheduleSelf(r0)
        L7c:
            r8.a(r9)
        L7f:
            r8.invalidateSelf()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.graphics.drawable.DrawableContainer.h(int):boolean");
    }

    void i(DrawableContainerState drawableContainerState) {
        this.f370d = drawableContainerState;
        int i2 = this.f376j;
        if (i2 >= 0) {
            Drawable child = drawableContainerState.getChild(i2);
            this.f372f = child;
            if (child != null) {
                e(child);
            }
        }
        this.k = -1;
        this.f373g = null;
    }

    public void invalidateDrawable(@NonNull Drawable drawable) {
        DrawableContainerState drawableContainerState = this.f370d;
        if (drawableContainerState != null) {
            drawableContainerState.f();
        }
        if (drawable != this.f372f || getCallback() == null) {
            return;
        }
        getCallback().invalidateDrawable(this);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        return this.f370d.C;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f370d.isStateful();
    }

    void j(int i2) {
        h(i2);
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        boolean z;
        Drawable drawable = this.f373g;
        boolean z2 = true;
        if (drawable != null) {
            drawable.jumpToCurrentState();
            this.f373g = null;
            this.k = -1;
            z = true;
        } else {
            z = false;
        }
        Drawable drawable2 = this.f372f;
        if (drawable2 != null) {
            drawable2.jumpToCurrentState();
            if (this.f375i) {
                this.f372f.setAlpha(this.f374h);
            }
        }
        if (this.o != 0) {
            this.o = 0L;
            z = true;
        }
        if (this.n != 0) {
            this.n = 0L;
        } else {
            z2 = z;
        }
        if (z2) {
            invalidateSelf();
        }
    }

    final void k(Resources resources) {
        this.f370d.j(resources);
    }

    @Override // android.graphics.drawable.Drawable
    @NonNull
    public Drawable mutate() {
        if (!this.l && super.mutate() == this) {
            DrawableContainerState l = l();
            l.g();
            i(l);
            this.l = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f373g;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        Drawable drawable2 = this.f372f;
        if (drawable2 != null) {
            drawable2.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLayoutDirectionChanged(int i2) {
        return this.f370d.i(i2, d());
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i2) {
        Drawable drawable = this.f373g;
        if (drawable != null) {
            return drawable.setLevel(i2);
        }
        Drawable drawable2 = this.f372f;
        if (drawable2 != null) {
            return drawable2.setLevel(i2);
        }
        return false;
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        Drawable drawable = this.f373g;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        Drawable drawable2 = this.f372f;
        if (drawable2 != null) {
            return drawable2.setState(iArr);
        }
        return false;
    }

    public void scheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable, long j2) {
        if (drawable != this.f372f || getCallback() == null) {
            return;
        }
        getCallback().scheduleDrawable(this, runnable, j2);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        if (this.f375i && this.f374h == i2) {
            return;
        }
        this.f375i = true;
        this.f374h = i2;
        Drawable drawable = this.f372f;
        if (drawable != null) {
            if (this.n == 0) {
                drawable.setAlpha(i2);
            } else {
                a(false);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        DrawableContainerState drawableContainerState = this.f370d;
        if (drawableContainerState.C != z) {
            drawableContainerState.C = z;
            Drawable drawable = this.f372f;
            if (drawable != null) {
                DrawableCompat.setAutoMirrored(drawable, z);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        DrawableContainerState drawableContainerState = this.f370d;
        drawableContainerState.E = true;
        if (drawableContainerState.D != colorFilter) {
            drawableContainerState.D = colorFilter;
            Drawable drawable = this.f372f;
            if (drawable != null) {
                drawable.setColorFilter(colorFilter);
            }
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        DrawableContainerState drawableContainerState = this.f370d;
        if (drawableContainerState.x != z) {
            drawableContainerState.x = z;
            Drawable drawable = this.f372f;
            if (drawable != null) {
                drawable.setDither(z);
            }
        }
    }

    public void setEnterFadeDuration(int i2) {
        this.f370d.A = i2;
    }

    public void setExitFadeDuration(int i2) {
        this.f370d.B = i2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspot(float f2, float f3) {
        Drawable drawable = this.f372f;
        if (drawable != null) {
            DrawableCompat.setHotspot(drawable, f2, f3);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setHotspotBounds(int i2, int i3, int i4, int i5) {
        Rect rect = this.f371e;
        if (rect == null) {
            this.f371e = new Rect(i2, i3, i4, i5);
        } else {
            rect.set(i2, i3, i4, i5);
        }
        Drawable drawable = this.f372f;
        if (drawable != null) {
            DrawableCompat.setHotspotBounds(drawable, i2, i3, i4, i5);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        DrawableContainerState drawableContainerState = this.f370d;
        drawableContainerState.H = true;
        if (drawableContainerState.F != colorStateList) {
            drawableContainerState.F = colorStateList;
            DrawableCompat.setTintList(this.f372f, colorStateList);
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(@NonNull PorterDuff.Mode mode) {
        DrawableContainerState drawableContainerState = this.f370d;
        drawableContainerState.I = true;
        if (drawableContainerState.G != mode) {
            drawableContainerState.G = mode;
            DrawableCompat.setTintMode(this.f372f, mode);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        Drawable drawable = this.f373g;
        if (drawable != null) {
            drawable.setVisible(z, z2);
        }
        Drawable drawable2 = this.f372f;
        if (drawable2 != null) {
            drawable2.setVisible(z, z2);
        }
        return visible;
    }

    public void unscheduleDrawable(@NonNull Drawable drawable, @NonNull Runnable runnable) {
        if (drawable != this.f372f || getCallback() == null) {
            return;
        }
        getCallback().unscheduleDrawable(this, runnable);
    }
}
