package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class VectorDrawableCompat extends VectorDrawableCommon {

    /* renamed from: b */
    static final String f3967b = "VectorDrawableCompat";

    /* renamed from: c */
    static final PorterDuff.Mode f3968c = PorterDuff.Mode.SRC_IN;

    /* renamed from: d */
    private static final String f3969d = "clip-path";

    /* renamed from: e */
    private static final String f3970e = "group";

    /* renamed from: f */
    private static final String f3971f = "path";

    /* renamed from: g */
    private static final String f3972g = "vector";

    /* renamed from: h */
    private static final int f3973h = 0;

    /* renamed from: i */
    private static final int f3974i = 1;

    /* renamed from: j */
    private static final int f3975j = 2;
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 2048;
    private static final boolean o = false;
    private VectorDrawableCompatState p;
    private PorterDuffColorFilter q;
    private ColorFilter r;
    private boolean s;
    private boolean t;
    private Drawable.ConstantState u;
    private final float[] v;
    private final Matrix w;
    private final Rect x;

    private static class VClipPath extends VPath {
        VClipPath() {
        }

        private void a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f3993c = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f3992b = PathParser.createNodesFromPathData(string2);
            }
            this.f3994d = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.I);
                a(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean isClipPath() {
            return true;
        }

        VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    private static abstract class VObject {
        private VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }

        /* synthetic */ VObject(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    private static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a */
        int f4006a;

        /* renamed from: b */
        VPathRenderer f4007b;

        /* renamed from: c */
        ColorStateList f4008c;

        /* renamed from: d */
        PorterDuff.Mode f4009d;

        /* renamed from: e */
        boolean f4010e;

        /* renamed from: f */
        Bitmap f4011f;

        /* renamed from: g */
        int[] f4012g;

        /* renamed from: h */
        ColorStateList f4013h;

        /* renamed from: i */
        PorterDuff.Mode f4014i;

        /* renamed from: j */
        int f4015j;
        boolean k;
        boolean l;
        Paint m;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f4008c = null;
            this.f4009d = VectorDrawableCompat.f3968c;
            if (vectorDrawableCompatState != null) {
                this.f4006a = vectorDrawableCompatState.f4006a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f4007b);
                this.f4007b = vPathRenderer;
                if (vectorDrawableCompatState.f4007b.f4001f != null) {
                    vPathRenderer.f4001f = new Paint(vectorDrawableCompatState.f4007b.f4001f);
                }
                if (vectorDrawableCompatState.f4007b.f4000e != null) {
                    this.f4007b.f4000e = new Paint(vectorDrawableCompatState.f4007b.f4000e);
                }
                this.f4008c = vectorDrawableCompatState.f4008c;
                this.f4009d = vectorDrawableCompatState.f4009d;
                this.f4010e = vectorDrawableCompatState.f4010e;
            }
        }

        public boolean canReuseBitmap(int i2, int i3) {
            return i2 == this.f4011f.getWidth() && i3 == this.f4011f.getHeight();
        }

        public boolean canReuseCache() {
            return !this.l && this.f4013h == this.f4008c && this.f4014i == this.f4009d && this.k == this.f4010e && this.f4015j == this.f4007b.getRootAlpha();
        }

        public void createCachedBitmapIfNeeded(int i2, int i3) {
            if (this.f4011f == null || !canReuseBitmap(i2, i3)) {
                this.f4011f = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
                this.l = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f4011f, (Rect) null, rect, getPaint(colorFilter));
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4006a;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.m == null) {
                Paint paint = new Paint();
                this.m = paint;
                paint.setFilterBitmap(true);
            }
            this.m.setAlpha(this.f4007b.getRootAlpha());
            this.m.setColorFilter(colorFilter);
            return this.m;
        }

        public boolean hasTranslucentRoot() {
            return this.f4007b.getRootAlpha() < 255;
        }

        public boolean isStateful() {
            return this.f4007b.isStateful();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.f4007b.onStateChanged(iArr);
            this.l |= onStateChanged;
            return onStateChanged;
        }

        public void updateCacheStates() {
            this.f4013h = this.f4008c;
            this.f4014i = this.f4009d;
            this.f4015j = this.f4007b.getRootAlpha();
            this.k = this.f4010e;
            this.l = false;
        }

        public void updateCachedBitmap(int i2, int i3) {
            this.f4011f.eraseColor(0);
            this.f4007b.draw(new Canvas(this.f4011f), i2, i3, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f4008c = null;
            this.f4009d = VectorDrawableCompat.f3968c;
            this.f4007b = new VPathRenderer();
        }
    }

    VectorDrawableCompat() {
        this.t = true;
        this.v = new float[9];
        this.w = new Matrix();
        this.x = new Rect();
        this.p = new VectorDrawableCompatState();
    }

    static int a(int i2, float f2) {
        return (i2 & 16777215) | (((int) (Color.alpha(i2) * f2)) << 24);
    }

    private void c(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f4007b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f4004i);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if ("path".equals(name)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f3982b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.q.put(vFullPath.getPathName(), vFullPath);
                    }
                    z = false;
                    vectorDrawableCompatState.f4006a = vFullPath.f3995e | vectorDrawableCompatState.f4006a;
                } else if (f3969d.equals(name)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f3982b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.q.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f4006a = vClipPath.f3995e | vectorDrawableCompatState.f4006a;
                } else if (f3970e.equals(name)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f3982b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.q.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f4006a = vGroup2.k | vectorDrawableCompatState.f4006a;
                }
            } else if (eventType == 3 && f3970e.equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    @Nullable
    public static VectorDrawableCompat create(@NonNull Resources resources, @DrawableRes int i2, @Nullable Resources.Theme theme) {
        int next;
        if (Build.VERSION.SDK_INT >= 24) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f3966a = ResourcesCompat.getDrawable(resources, i2, theme);
            vectorDrawableCompat.u = new VectorDrawableDelegateState(vectorDrawableCompat.f3966a.getConstantState());
            return vectorDrawableCompat;
        }
        try {
            XmlResourceParser xml = resources.getXml(i2);
            AttributeSet asAttributeSet = Xml.asAttributeSet(xml);
            do {
                next = xml.next();
                if (next == 2) {
                    break;
                }
            } while (next != 1);
            if (next == 2) {
                return createFromXmlInner(resources, (XmlPullParser) xml, asAttributeSet, theme);
            }
            throw new XmlPullParserException("No start tag found");
        } catch (IOException e2) {
            Log.e(f3967b, "parser error", e2);
            return null;
        } catch (XmlPullParserException e3) {
            Log.e(f3967b, "parser error", e3);
            return null;
        }
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private boolean d() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && DrawableCompat.getLayoutDirection(this) == 1;
    }

    private static PorterDuff.Mode e(int i2, PorterDuff.Mode mode) {
        if (i2 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i2 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i2 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i2) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void f(VGroup vGroup, int i2) {
        String str = "";
        for (int i3 = 0; i3 < i2; i3++) {
            str = str + "    ";
        }
        Log.v(f3967b, str + "current group is :" + vGroup.getGroupName() + " rotation is " + vGroup.f3983c);
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("matrix is :");
        sb.append(vGroup.getLocalMatrix().toString());
        Log.v(f3967b, sb.toString());
        for (int i4 = 0; i4 < vGroup.f3982b.size(); i4++) {
            VObject vObject = vGroup.f3982b.get(i4);
            if (vObject instanceof VGroup) {
                f((VGroup) vObject, i2 + 1);
            } else {
                ((VPath) vObject).printVPath(i2 + 1);
            }
        }
    }

    private void h(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f4007b;
        vectorDrawableCompatState.f4009d = e(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            vectorDrawableCompatState.f4008c = namedColorStateList;
        }
        vectorDrawableCompatState.f4010e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f4010e);
        vPathRenderer.l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.l);
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.m);
        vPathRenderer.m = namedFloat;
        if (vPathRenderer.l <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        }
        if (namedFloat <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
        vPathRenderer.f4005j = typedArray.getDimension(3, vPathRenderer.f4005j);
        float dimension = typedArray.getDimension(2, vPathRenderer.k);
        vPathRenderer.k = dimension;
        if (vPathRenderer.f4005j <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
        }
        if (dimension <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
        }
        vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
        String string = typedArray.getString(0);
        if (string != null) {
            vPathRenderer.o = string;
            vPathRenderer.q.put(string, vPathRenderer);
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    Object b(String str) {
        return this.p.f4007b.q.get(str);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        Drawable drawable = this.f3966a;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.x);
        if (this.x.width() <= 0 || this.x.height() <= 0) {
            return;
        }
        ColorFilter colorFilter = this.r;
        if (colorFilter == null) {
            colorFilter = this.q;
        }
        canvas.getMatrix(this.w);
        this.w.getValues(this.v);
        float abs = Math.abs(this.v[0]);
        float abs2 = Math.abs(this.v[4]);
        float abs3 = Math.abs(this.v[1]);
        float abs4 = Math.abs(this.v[3]);
        if (abs3 != 0.0f || abs4 != 0.0f) {
            abs = 1.0f;
            abs2 = 1.0f;
        }
        int min = Math.min(2048, (int) (this.x.width() * abs));
        int min2 = Math.min(2048, (int) (this.x.height() * abs2));
        if (min <= 0 || min2 <= 0) {
            return;
        }
        int save = canvas.save();
        Rect rect = this.x;
        canvas.translate(rect.left, rect.top);
        if (d()) {
            canvas.translate(this.x.width(), 0.0f);
            canvas.scale(-1.0f, 1.0f);
        }
        this.x.offsetTo(0, 0);
        this.p.createCachedBitmapIfNeeded(min, min2);
        if (!this.t) {
            this.p.updateCachedBitmap(min, min2);
        } else if (!this.p.canReuseCache()) {
            this.p.updateCachedBitmap(min, min2);
            this.p.updateCacheStates();
        }
        this.p.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.x);
        canvas.restoreToCount(save);
    }

    void g(boolean z) {
        this.t = z;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        Drawable drawable = this.f3966a;
        return drawable != null ? DrawableCompat.getAlpha(drawable) : this.p.f4007b.getRootAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public int getChangingConfigurations() {
        Drawable drawable = this.f3966a;
        return drawable != null ? drawable.getChangingConfigurations() : super.getChangingConfigurations() | this.p.getChangingConfigurations();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        Drawable drawable = this.f3966a;
        return drawable != null ? DrawableCompat.getColorFilter(drawable) : this.r;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (this.f3966a != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.f3966a.getConstantState());
        }
        this.p.f4006a = getChangingConfigurations();
        return this.p;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        Drawable drawable = this.f3966a;
        return drawable != null ? drawable.getIntrinsicHeight() : (int) this.p.f4007b.k;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        Drawable drawable = this.f3966a;
        return drawable != null ? drawable.getIntrinsicWidth() : (int) this.p.f4007b.f4005j;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        VPathRenderer vPathRenderer;
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        if (vectorDrawableCompatState == null || (vPathRenderer = vectorDrawableCompatState.f4007b) == null) {
            return 1.0f;
        }
        float f2 = vPathRenderer.f4005j;
        if (f2 == 0.0f) {
            return 1.0f;
        }
        float f3 = vPathRenderer.k;
        if (f3 == 0.0f) {
            return 1.0f;
        }
        float f4 = vPathRenderer.m;
        if (f4 == 0.0f) {
            return 1.0f;
        }
        float f5 = vPathRenderer.l;
        if (f5 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f5 / f2, f4 / f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    PorterDuffColorFilter i(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, null);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isAutoMirrored() {
        Drawable drawable = this.f3966a;
        return drawable != null ? DrawableCompat.isAutoMirrored(drawable) : this.p.f4010e;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.f3966a;
        return drawable != null ? drawable.isStateful() : super.isStateful() || ((vectorDrawableCompatState = this.p) != null && (vectorDrawableCompatState.isStateful() || ((colorStateList = this.p.f4008c) != null && colorStateList.isStateful())));
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.s && super.mutate() == this) {
            this.p = new VectorDrawableCompatState(this.p);
            this.s = true;
        }
        return this;
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        PorterDuff.Mode mode;
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        boolean z = false;
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        ColorStateList colorStateList = vectorDrawableCompatState.f4008c;
        if (colorStateList != null && (mode = vectorDrawableCompatState.f4009d) != null) {
            this.q = i(this.q, colorStateList, mode);
            invalidateSelf();
            z = true;
        }
        if (!vectorDrawableCompatState.isStateful() || !vectorDrawableCompatState.onStateChanged(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void scheduleSelf(Runnable runnable, long j2) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j2);
        } else {
            super.scheduleSelf(runnable, j2);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i2) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.setAlpha(i2);
        } else if (this.p.f4007b.getRootAlpha() != i2) {
            this.p.f4007b.setRootAlpha(i2);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAutoMirrored(boolean z) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z);
        } else {
            this.p.f4010e = z;
        }
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i2) {
        super.setChangingConfigurations(i2);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(int i2, PorterDuff.Mode mode) {
        super.setColorFilter(i2, mode);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspot(float f2, float f3) {
        super.setHotspot(f2, f3);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setHotspotBounds(int i2, int i3, int i4, int i5) {
        super.setHotspotBounds(i2, i3, i4, i5);
    }

    @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCommon, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i2) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i2);
        } else {
            setTintList(ColorStateList.valueOf(i2));
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        if (vectorDrawableCompatState.f4008c != colorStateList) {
            vectorDrawableCompatState.f4008c = colorStateList;
            this.q = i(this.q, colorStateList, vectorDrawableCompatState.f4009d);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        if (vectorDrawableCompatState.f4009d != mode) {
            vectorDrawableCompatState.f4009d = mode;
            this.q = i(this.q, vectorDrawableCompatState.f4008c, mode);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        Drawable drawable = this.f3966a;
        return drawable != null ? drawable.setVisible(z, z2) : super.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi(24)
    private static class VectorDrawableDelegateState extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f4016a;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.f4016a = constantState;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public boolean canApplyTheme() {
            return this.f4016a.canApplyTheme();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.f4016a.getChangingConfigurations();
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f3966a = (VectorDrawable) this.f4016a.newDrawable();
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f3966a = (VectorDrawable) this.f4016a.newDrawable(resources);
            return vectorDrawableCompat;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f3966a = (VectorDrawable) this.f4016a.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        } else {
            this.r = colorFilter;
            invalidateSelf();
        }
    }

    private static abstract class VPath extends VObject {

        /* renamed from: a */
        protected static final int f3991a = 0;

        /* renamed from: b */
        protected PathParser.PathDataNode[] f3992b;

        /* renamed from: c */
        String f3993c;

        /* renamed from: d */
        int f3994d;

        /* renamed from: e */
        int f3995e;

        public VPath() {
            super();
            this.f3992b = null;
            this.f3994d = 0;
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f3992b;
        }

        public String getPathName() {
            return this.f3993c;
        }

        public boolean isClipPath() {
            return false;
        }

        public String nodesToString(PathParser.PathDataNode[] pathDataNodeArr) {
            String str = " ";
            for (int i2 = 0; i2 < pathDataNodeArr.length; i2++) {
                str = str + pathDataNodeArr[i2].mType + ":";
                for (float f2 : pathDataNodeArr[i2].mParams) {
                    str = str + f2 + ",";
                }
            }
            return str;
        }

        public void printVPath(int i2) {
            String str = "";
            for (int i3 = 0; i3 < i2; i3++) {
                str = str + "    ";
            }
            Log.v(VectorDrawableCompat.f3967b, str + "current path is :" + this.f3993c + " pathData is " + nodesToString(this.f3992b));
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (PathParser.canMorph(this.f3992b, pathDataNodeArr)) {
                PathParser.updateNodes(this.f3992b, pathDataNodeArr);
            } else {
                this.f3992b = PathParser.deepCopyNodes(pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f3992b;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f3992b = null;
            this.f3994d = 0;
            this.f3993c = vPath.f3993c;
            this.f3995e = vPath.f3995e;
            this.f3992b = PathParser.deepCopyNodes(vPath.f3992b);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f3966a;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.p;
        vectorDrawableCompatState.f4007b = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f3923a);
        h(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        vectorDrawableCompatState.f4006a = getChangingConfigurations();
        vectorDrawableCompatState.l = true;
        c(resources, xmlPullParser, attributeSet, theme);
        this.q = i(this.q, vectorDrawableCompatState.f4008c, vectorDrawableCompatState.f4009d);
    }

    VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.t = true;
        this.v = new float[9];
        this.w = new Matrix();
        this.x = new Rect();
        this.p = vectorDrawableCompatState;
        this.q = i(this.q, vectorDrawableCompatState.f4008c, vectorDrawableCompatState.f4009d);
    }

    private static class VFullPath extends VPath {

        /* renamed from: f */
        private int[] f3976f;

        /* renamed from: g */
        ComplexColorCompat f3977g;

        /* renamed from: h */
        float f3978h;

        /* renamed from: i */
        ComplexColorCompat f3979i;

        /* renamed from: j */
        float f3980j;
        float k;
        float l;
        float m;
        float n;
        Paint.Cap o;
        Paint.Join p;
        float q;

        VFullPath() {
            this.f3978h = 0.0f;
            this.f3980j = 1.0f;
            this.k = 1.0f;
            this.l = 0.0f;
            this.m = 1.0f;
            this.n = 0.0f;
            this.o = Paint.Cap.BUTT;
            this.p = Paint.Join.MITER;
            this.q = 4.0f;
        }

        private Paint.Cap a(int i2, Paint.Cap cap) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? cap : Paint.Cap.SQUARE : Paint.Cap.ROUND : Paint.Cap.BUTT;
        }

        private Paint.Join b(int i2, Paint.Join join) {
            return i2 != 0 ? i2 != 1 ? i2 != 2 ? join : Paint.Join.BEVEL : Paint.Join.ROUND : Paint.Join.MITER;
        }

        private void c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f3976f = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f3993c = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f3992b = PathParser.createNodesFromPathData(string2);
                }
                this.f3979i = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "fillColor", 1, 0);
                this.k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.k);
                this.o = a(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.o);
                this.p = b(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.p);
                this.q = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.q);
                this.f3977g = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme, "strokeColor", 3, 0);
                this.f3980j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f3980j);
                this.f3978h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeWidth", 4, this.f3978h);
                this.m = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.m);
                this.n = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.n);
                this.l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.l);
                this.f3994d = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f3994d);
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public void applyTheme(Resources.Theme theme) {
            if (this.f3976f == null) {
            }
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VPath
        public boolean canApplyTheme() {
            return this.f3976f != null;
        }

        float getFillAlpha() {
            return this.k;
        }

        @ColorInt
        int getFillColor() {
            return this.f3979i.getColor();
        }

        float getStrokeAlpha() {
            return this.f3980j;
        }

        @ColorInt
        int getStrokeColor() {
            return this.f3977g.getColor();
        }

        float getStrokeWidth() {
            return this.f3978h;
        }

        float getTrimPathEnd() {
            return this.m;
        }

        float getTrimPathOffset() {
            return this.n;
        }

        float getTrimPathStart() {
            return this.l;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.t);
            c(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            return this.f3979i.isStateful() || this.f3977g.isStateful();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            return this.f3977g.onStateChanged(iArr) | this.f3979i.onStateChanged(iArr);
        }

        void setFillAlpha(float f2) {
            this.k = f2;
        }

        void setFillColor(int i2) {
            this.f3979i.setColor(i2);
        }

        void setStrokeAlpha(float f2) {
            this.f3980j = f2;
        }

        void setStrokeColor(int i2) {
            this.f3977g.setColor(i2);
        }

        void setStrokeWidth(float f2) {
            this.f3978h = f2;
        }

        void setTrimPathEnd(float f2) {
            this.m = f2;
        }

        void setTrimPathOffset(float f2) {
            this.n = f2;
        }

        void setTrimPathStart(float f2) {
            this.l = f2;
        }

        VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.f3978h = 0.0f;
            this.f3980j = 1.0f;
            this.k = 1.0f;
            this.l = 0.0f;
            this.m = 1.0f;
            this.n = 0.0f;
            this.o = Paint.Cap.BUTT;
            this.p = Paint.Join.MITER;
            this.q = 4.0f;
            this.f3976f = vFullPath.f3976f;
            this.f3977g = vFullPath.f3977g;
            this.f3978h = vFullPath.f3978h;
            this.f3980j = vFullPath.f3980j;
            this.f3979i = vFullPath.f3979i;
            this.f3994d = vFullPath.f3994d;
            this.k = vFullPath.k;
            this.l = vFullPath.l;
            this.m = vFullPath.m;
            this.n = vFullPath.n;
            this.o = vFullPath.o;
            this.p = vFullPath.p;
            this.q = vFullPath.q;
        }
    }

    private static class VPathRenderer {

        /* renamed from: a */
        private static final Matrix f3996a = new Matrix();

        /* renamed from: b */
        private final Path f3997b;

        /* renamed from: c */
        private final Path f3998c;

        /* renamed from: d */
        private final Matrix f3999d;

        /* renamed from: e */
        Paint f4000e;

        /* renamed from: f */
        Paint f4001f;

        /* renamed from: g */
        private PathMeasure f4002g;

        /* renamed from: h */
        private int f4003h;

        /* renamed from: i */
        final VGroup f4004i;

        /* renamed from: j */
        float f4005j;
        float k;
        float l;
        float m;
        int n;
        String o;
        Boolean p;
        final ArrayMap<String, Object> q;

        public VPathRenderer() {
            this.f3999d = new Matrix();
            this.f4005j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            this.q = new ArrayMap<>();
            this.f4004i = new VGroup();
            this.f3997b = new Path();
            this.f3998c = new Path();
        }

        private static float a(float f2, float f3, float f4, float f5) {
            return (f2 * f5) - (f3 * f4);
        }

        private void b(VGroup vGroup, Matrix matrix, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            vGroup.f3981a.set(matrix);
            vGroup.f3981a.preConcat(vGroup.f3990j);
            canvas.save();
            for (int i4 = 0; i4 < vGroup.f3982b.size(); i4++) {
                VObject vObject = vGroup.f3982b.get(i4);
                if (vObject instanceof VGroup) {
                    b((VGroup) vObject, vGroup.f3981a, canvas, i2, i3, colorFilter);
                } else if (vObject instanceof VPath) {
                    c(vGroup, (VPath) vObject, canvas, i2, i3, colorFilter);
                }
            }
            canvas.restore();
        }

        private void c(VGroup vGroup, VPath vPath, Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            float f2 = i2 / this.l;
            float f3 = i3 / this.m;
            float min = Math.min(f2, f3);
            Matrix matrix = vGroup.f3981a;
            this.f3999d.set(matrix);
            this.f3999d.postScale(f2, f3);
            float d2 = d(matrix);
            if (d2 == 0.0f) {
                return;
            }
            vPath.toPath(this.f3997b);
            Path path = this.f3997b;
            this.f3998c.reset();
            if (vPath.isClipPath()) {
                this.f3998c.setFillType(vPath.f3994d == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                this.f3998c.addPath(path, this.f3999d);
                canvas.clipPath(this.f3998c);
                return;
            }
            VFullPath vFullPath = (VFullPath) vPath;
            float f4 = vFullPath.l;
            if (f4 != 0.0f || vFullPath.m != 1.0f) {
                float f5 = vFullPath.n;
                float f6 = (f4 + f5) % 1.0f;
                float f7 = (vFullPath.m + f5) % 1.0f;
                if (this.f4002g == null) {
                    this.f4002g = new PathMeasure();
                }
                this.f4002g.setPath(this.f3997b, false);
                float length = this.f4002g.getLength();
                float f8 = f6 * length;
                float f9 = f7 * length;
                path.reset();
                if (f8 > f9) {
                    this.f4002g.getSegment(f8, length, path, true);
                    this.f4002g.getSegment(0.0f, f9, path, true);
                } else {
                    this.f4002g.getSegment(f8, f9, path, true);
                }
                path.rLineTo(0.0f, 0.0f);
            }
            this.f3998c.addPath(path, this.f3999d);
            if (vFullPath.f3979i.willDraw()) {
                ComplexColorCompat complexColorCompat = vFullPath.f3979i;
                if (this.f4001f == null) {
                    Paint paint = new Paint(1);
                    this.f4001f = paint;
                    paint.setStyle(Paint.Style.FILL);
                }
                Paint paint2 = this.f4001f;
                if (complexColorCompat.isGradient()) {
                    Shader shader = complexColorCompat.getShader();
                    shader.setLocalMatrix(this.f3999d);
                    paint2.setShader(shader);
                    paint2.setAlpha(Math.round(vFullPath.k * 255.0f));
                } else {
                    paint2.setShader(null);
                    paint2.setAlpha(255);
                    paint2.setColor(VectorDrawableCompat.a(complexColorCompat.getColor(), vFullPath.k));
                }
                paint2.setColorFilter(colorFilter);
                this.f3998c.setFillType(vFullPath.f3994d == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                canvas.drawPath(this.f3998c, paint2);
            }
            if (vFullPath.f3977g.willDraw()) {
                ComplexColorCompat complexColorCompat2 = vFullPath.f3977g;
                if (this.f4000e == null) {
                    Paint paint3 = new Paint(1);
                    this.f4000e = paint3;
                    paint3.setStyle(Paint.Style.STROKE);
                }
                Paint paint4 = this.f4000e;
                Paint.Join join = vFullPath.p;
                if (join != null) {
                    paint4.setStrokeJoin(join);
                }
                Paint.Cap cap = vFullPath.o;
                if (cap != null) {
                    paint4.setStrokeCap(cap);
                }
                paint4.setStrokeMiter(vFullPath.q);
                if (complexColorCompat2.isGradient()) {
                    Shader shader2 = complexColorCompat2.getShader();
                    shader2.setLocalMatrix(this.f3999d);
                    paint4.setShader(shader2);
                    paint4.setAlpha(Math.round(vFullPath.f3980j * 255.0f));
                } else {
                    paint4.setShader(null);
                    paint4.setAlpha(255);
                    paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.getColor(), vFullPath.f3980j));
                }
                paint4.setColorFilter(colorFilter);
                paint4.setStrokeWidth(vFullPath.f3978h * min * d2);
                canvas.drawPath(this.f3998c, paint4);
            }
        }

        private float d(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float hypot = (float) Math.hypot(fArr[0], fArr[1]);
            float hypot2 = (float) Math.hypot(fArr[2], fArr[3]);
            float a2 = a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max(hypot, hypot2);
            if (max > 0.0f) {
                return Math.abs(a2) / max;
            }
            return 0.0f;
        }

        public void draw(Canvas canvas, int i2, int i3, ColorFilter colorFilter) {
            b(this.f4004i, f3996a, canvas, i2, i3, colorFilter);
        }

        public float getAlpha() {
            return getRootAlpha() / 255.0f;
        }

        public int getRootAlpha() {
            return this.n;
        }

        public boolean isStateful() {
            if (this.p == null) {
                this.p = Boolean.valueOf(this.f4004i.isStateful());
            }
            return this.p.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.f4004i.onStateChanged(iArr);
        }

        public void setAlpha(float f2) {
            setRootAlpha((int) (f2 * 255.0f));
        }

        public void setRootAlpha(int i2) {
            this.n = i2;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.f3999d = new Matrix();
            this.f4005j = 0.0f;
            this.k = 0.0f;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 255;
            this.o = null;
            this.p = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.q = arrayMap;
            this.f4004i = new VGroup(vPathRenderer.f4004i, arrayMap);
            this.f3997b = new Path(vPathRenderer.f3997b);
            this.f3998c = new Path(vPathRenderer.f3998c);
            this.f4005j = vPathRenderer.f4005j;
            this.k = vPathRenderer.k;
            this.l = vPathRenderer.l;
            this.m = vPathRenderer.m;
            this.f4003h = vPathRenderer.f4003h;
            this.n = vPathRenderer.n;
            this.o = vPathRenderer.o;
            String str = vPathRenderer.o;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.p = vPathRenderer.p;
        }
    }

    private static class VGroup extends VObject {

        /* renamed from: a */
        final Matrix f3981a;

        /* renamed from: b */
        final ArrayList<VObject> f3982b;

        /* renamed from: c */
        float f3983c;

        /* renamed from: d */
        private float f3984d;

        /* renamed from: e */
        private float f3985e;

        /* renamed from: f */
        private float f3986f;

        /* renamed from: g */
        private float f3987g;

        /* renamed from: h */
        private float f3988h;

        /* renamed from: i */
        private float f3989i;

        /* renamed from: j */
        final Matrix f3990j;
        int k;
        private int[] l;
        private String m;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vClipPath;
            this.f3981a = new Matrix();
            this.f3982b = new ArrayList<>();
            this.f3983c = 0.0f;
            this.f3984d = 0.0f;
            this.f3985e = 0.0f;
            this.f3986f = 1.0f;
            this.f3987g = 1.0f;
            this.f3988h = 0.0f;
            this.f3989i = 0.0f;
            Matrix matrix = new Matrix();
            this.f3990j = matrix;
            this.m = null;
            this.f3983c = vGroup.f3983c;
            this.f3984d = vGroup.f3984d;
            this.f3985e = vGroup.f3985e;
            this.f3986f = vGroup.f3986f;
            this.f3987g = vGroup.f3987g;
            this.f3988h = vGroup.f3988h;
            this.f3989i = vGroup.f3989i;
            this.l = vGroup.l;
            String str = vGroup.m;
            this.m = str;
            this.k = vGroup.k;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f3990j);
            ArrayList<VObject> arrayList = vGroup.f3982b;
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                VObject vObject = arrayList.get(i2);
                if (vObject instanceof VGroup) {
                    this.f3982b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vClipPath = new VFullPath((VFullPath) vObject);
                    } else {
                        if (!(vObject instanceof VClipPath)) {
                            throw new IllegalStateException("Unknown object in the tree!");
                        }
                        vClipPath = new VClipPath((VClipPath) vObject);
                    }
                    this.f3982b.add(vClipPath);
                    String str2 = vClipPath.f3993c;
                    if (str2 != null) {
                        arrayMap.put(str2, vClipPath);
                    }
                }
            }
        }

        private void a() {
            this.f3990j.reset();
            this.f3990j.postTranslate(-this.f3984d, -this.f3985e);
            this.f3990j.postScale(this.f3986f, this.f3987g);
            this.f3990j.postRotate(this.f3983c, 0.0f, 0.0f);
            this.f3990j.postTranslate(this.f3988h + this.f3984d, this.f3989i + this.f3985e);
        }

        private void b(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.l = null;
            this.f3983c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f3983c);
            this.f3984d = typedArray.getFloat(1, this.f3984d);
            this.f3985e = typedArray.getFloat(2, this.f3985e);
            this.f3986f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.f3986f);
            this.f3987g = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.f3987g);
            this.f3988h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.f3988h);
            this.f3989i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.f3989i);
            String string = typedArray.getString(0);
            if (string != null) {
                this.m = string;
            }
            a();
        }

        public String getGroupName() {
            return this.m;
        }

        public Matrix getLocalMatrix() {
            return this.f3990j;
        }

        public float getPivotX() {
            return this.f3984d;
        }

        public float getPivotY() {
            return this.f3985e;
        }

        public float getRotation() {
            return this.f3983c;
        }

        public float getScaleX() {
            return this.f3986f;
        }

        public float getScaleY() {
            return this.f3987g;
        }

        public float getTranslateX() {
            return this.f3988h;
        }

        public float getTranslateY() {
            return this.f3989i;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.k);
            b(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean isStateful() {
            for (int i2 = 0; i2 < this.f3982b.size(); i2++) {
                if (this.f3982b.get(i2).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        @Override // androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.VObject
        public boolean onStateChanged(int[] iArr) {
            boolean z = false;
            for (int i2 = 0; i2 < this.f3982b.size(); i2++) {
                z |= this.f3982b.get(i2).onStateChanged(iArr);
            }
            return z;
        }

        public void setPivotX(float f2) {
            if (f2 != this.f3984d) {
                this.f3984d = f2;
                a();
            }
        }

        public void setPivotY(float f2) {
            if (f2 != this.f3985e) {
                this.f3985e = f2;
                a();
            }
        }

        public void setRotation(float f2) {
            if (f2 != this.f3983c) {
                this.f3983c = f2;
                a();
            }
        }

        public void setScaleX(float f2) {
            if (f2 != this.f3986f) {
                this.f3986f = f2;
                a();
            }
        }

        public void setScaleY(float f2) {
            if (f2 != this.f3987g) {
                this.f3987g = f2;
                a();
            }
        }

        public void setTranslateX(float f2) {
            if (f2 != this.f3988h) {
                this.f3988h = f2;
                a();
            }
        }

        public void setTranslateY(float f2) {
            if (f2 != this.f3989i) {
                this.f3989i = f2;
                a();
            }
        }

        public VGroup() {
            super();
            this.f3981a = new Matrix();
            this.f3982b = new ArrayList<>();
            this.f3983c = 0.0f;
            this.f3984d = 0.0f;
            this.f3985e = 0.0f;
            this.f3986f = 1.0f;
            this.f3987g = 1.0f;
            this.f3988h = 0.0f;
            this.f3989i = 0.0f;
            this.f3990j = new Matrix();
            this.m = null;
        }
    }
}
