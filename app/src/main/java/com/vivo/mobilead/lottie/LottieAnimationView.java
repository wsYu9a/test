package com.vivo.mobilead.lottie;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import java.io.StringReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class LottieAnimationView extends ImageView {
    private static final String TAG = LottieAnimationView.class.getSimpleName();
    private String animationName;
    private int animationResId;
    private boolean autoPlay;
    private LottieComposition composition;
    private LottieTask<LottieComposition> compositionTask;
    private final LottieListener<Throwable> failureListener;
    private final LottieListener<LottieComposition> loadedListener;
    private final c lottieDrawable;
    private Set<f> lottieOnCompositionLoadedListeners;
    private j renderMode;
    private boolean wasAnimatingWhenDetached;
    private boolean wasAnimatingWhenNotShown;

    /* renamed from: com.vivo.mobilead.lottie.LottieAnimationView$1 */
    class AnonymousClass1 implements LottieListener<LottieComposition> {
        AnonymousClass1() {
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(LottieComposition lottieComposition) {
            LottieAnimationView.this.setComposition(lottieComposition);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieAnimationView$2 */
    class AnonymousClass2 implements LottieListener<Throwable> {
        AnonymousClass2() {
        }

        @Override // com.vivo.mobilead.lottie.LottieListener
        /* renamed from: a */
        public void onResult(Throwable th) {
            throw new IllegalStateException("Unable to parse composition", th);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieAnimationView$3 */
    class AnonymousClass3<T> extends com.vivo.mobilead.lottie.g.c<T> {

        /* renamed from: a */
        final /* synthetic */ com.vivo.mobilead.lottie.g.e f28925a;

        AnonymousClass3(com.vivo.mobilead.lottie.g.e eVar) {
            eVar2 = eVar;
        }

        @Override // com.vivo.mobilead.lottie.g.c
        public T a(com.vivo.mobilead.lottie.g.b<T> bVar) {
            return (T) eVar2.a(bVar);
        }
    }

    /* renamed from: com.vivo.mobilead.lottie.LottieAnimationView$4 */
    static /* synthetic */ class AnonymousClass4 {

        /* renamed from: a */
        static final /* synthetic */ int[] f28927a;

        static {
            int[] iArr = new int[j.values().length];
            f28927a = iArr;
            try {
                iArr[j.HARDWARE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f28927a[j.SOFTWARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f28927a[j.AUTOMATIC.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private static class a extends View.BaseSavedState {
        public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.a.1
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a[] newArray(int i2) {
                return new a[i2];
            }
        };

        /* renamed from: a */
        String f28928a;

        /* renamed from: b */
        int f28929b;

        /* renamed from: c */
        float f28930c;

        /* renamed from: d */
        boolean f28931d;

        /* renamed from: e */
        String f28932e;

        /* renamed from: f */
        int f28933f;

        /* renamed from: g */
        int f28934g;

        /* renamed from: com.vivo.mobilead.lottie.LottieAnimationView$a$1 */
        static class AnonymousClass1 implements Parcelable.Creator<a> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a createFromParcel(Parcel parcel) {
                return new a(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a */
            public a[] newArray(int i2) {
                return new a[i2];
            }
        }

        private a(Parcel parcel) {
            super(parcel);
            this.f28928a = parcel.readString();
            this.f28930c = parcel.readFloat();
            this.f28931d = parcel.readInt() == 1;
            this.f28932e = parcel.readString();
            this.f28933f = parcel.readInt();
            this.f28934g = parcel.readInt();
        }

        /* synthetic */ a(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        a(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f28928a);
            parcel.writeFloat(this.f28930c);
            parcel.writeInt(this.f28931d ? 1 : 0);
            parcel.writeString(this.f28932e);
            parcel.writeInt(this.f28933f);
            parcel.writeInt(this.f28934g);
        }
    }

    public LottieAnimationView(Context context) {
        super(context);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.1
            AnonymousClass1() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.2
            AnonymousClass2() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.lottieDrawable = new c();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = j.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(null);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.1
            AnonymousClass1() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.2
            AnonymousClass2() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.lottieDrawable = new c();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = j.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }

    public LottieAnimationView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.loadedListener = new LottieListener<LottieComposition>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.1
            AnonymousClass1() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(LottieComposition lottieComposition) {
                LottieAnimationView.this.setComposition(lottieComposition);
            }
        };
        this.failureListener = new LottieListener<Throwable>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.2
            AnonymousClass2() {
            }

            @Override // com.vivo.mobilead.lottie.LottieListener
            /* renamed from: a */
            public void onResult(Throwable th) {
                throw new IllegalStateException("Unable to parse composition", th);
            }
        };
        this.lottieDrawable = new c();
        this.wasAnimatingWhenNotShown = false;
        this.wasAnimatingWhenDetached = false;
        this.autoPlay = false;
        this.renderMode = j.AUTOMATIC;
        this.lottieOnCompositionLoadedListeners = new HashSet();
        init(attributeSet);
    }

    private void cancelLoaderTask() {
        LottieTask<LottieComposition> lottieTask = this.compositionTask;
        if (lottieTask != null) {
            lottieTask.removeListener(this.loadedListener);
            this.compositionTask.removeFailureListener(this.failureListener);
        }
    }

    private void clearComposition() {
        this.composition = null;
        this.lottieDrawable.g();
    }

    private void enableOrDisableHardwareLayer() {
        LottieComposition lottieComposition;
        int i2 = AnonymousClass4.f28927a[this.renderMode.ordinal()];
        int i3 = 2;
        if (i2 != 1) {
            if (i2 == 2) {
                setLayerType(1, null);
                return;
            } else {
                if (i2 != 3) {
                    return;
                }
                LottieComposition lottieComposition2 = this.composition;
                if (!((lottieComposition2 == null || !lottieComposition2.hasDashPattern() || Build.VERSION.SDK_INT >= 28) && ((lottieComposition = this.composition) == null || lottieComposition.getMaskAndMatteCount() <= 4))) {
                    i3 = 1;
                }
            }
        }
        setLayerType(i3, null);
    }

    private void init(AttributeSet attributeSet) {
        setProgress(0.0f);
        enableMergePathsForKitKatAndAbove(false);
        this.lottieDrawable.a(Boolean.valueOf(com.vivo.mobilead.lottie.f.h.a(getContext()) != 0.0f));
        enableOrDisableHardwareLayer();
    }

    private void setCompositionTask(LottieTask<LottieComposition> lottieTask) {
        clearComposition();
        cancelLoaderTask();
        this.compositionTask = lottieTask.addListener(this.loadedListener).addFailureListener(this.failureListener);
    }

    public void addAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.a(animatorListener);
    }

    public void addAnimatorUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.a(animatorUpdateListener);
    }

    public boolean addLottieOnCompositionLoadedListener(f fVar) {
        return this.lottieOnCompositionLoadedListeners.add(fVar);
    }

    public <T> void addValueCallback(com.vivo.mobilead.lottie.c.e eVar, T t, com.vivo.mobilead.lottie.g.c<T> cVar) {
        this.lottieDrawable.a(eVar, t, cVar);
    }

    public <T> void addValueCallback(com.vivo.mobilead.lottie.c.e eVar, T t, com.vivo.mobilead.lottie.g.e<T> eVar2) {
        this.lottieDrawable.a(eVar, t, new com.vivo.mobilead.lottie.g.c<T>() { // from class: com.vivo.mobilead.lottie.LottieAnimationView.3

            /* renamed from: a */
            final /* synthetic */ com.vivo.mobilead.lottie.g.e f28925a;

            AnonymousClass3(com.vivo.mobilead.lottie.g.e eVar22) {
                eVar2 = eVar22;
            }

            @Override // com.vivo.mobilead.lottie.g.c
            public T a(com.vivo.mobilead.lottie.g.b<T> bVar) {
                return (T) eVar2.a(bVar);
            }
        });
    }

    @Override // android.view.View
    public void buildDrawingCache(boolean z) {
        super.buildDrawingCache(z);
        if (getLayerType() == 1 && getDrawingCache(z) == null) {
            setRenderMode(j.HARDWARE);
        }
    }

    public void cancelAnimation() {
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.y();
        enableOrDisableHardwareLayer();
    }

    public void enableMergePathsForKitKatAndAbove(boolean z) {
        this.lottieDrawable.a(z);
    }

    public LottieComposition getComposition() {
        return this.composition;
    }

    public long getDuration() {
        LottieComposition lottieComposition = this.composition;
        if (lottieComposition != null) {
            return (long) lottieComposition.getDuration();
        }
        return 0L;
    }

    public int getFrame() {
        return this.lottieDrawable.q();
    }

    public String getImageAssetsFolder() {
        return this.lottieDrawable.e();
    }

    public float getMaxFrame() {
        return this.lottieDrawable.l();
    }

    public float getMinFrame() {
        return this.lottieDrawable.k();
    }

    public i getPerformanceTracker() {
        return this.lottieDrawable.f();
    }

    public float getProgress() {
        return this.lottieDrawable.A();
    }

    public int getRepeatCount() {
        return this.lottieDrawable.s();
    }

    public int getRepeatMode() {
        return this.lottieDrawable.r();
    }

    public float getScale() {
        return this.lottieDrawable.w();
    }

    public float getSpeed() {
        return this.lottieDrawable.n();
    }

    public boolean hasMasks() {
        return this.lottieDrawable.a();
    }

    public boolean hasMatte() {
        return this.lottieDrawable.b();
    }

    @Override // android.widget.ImageView, android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        Drawable drawable2 = getDrawable();
        c cVar = this.lottieDrawable;
        if (drawable2 == cVar) {
            super.invalidateDrawable(cVar);
        } else {
            super.invalidateDrawable(drawable);
        }
    }

    public boolean isAnimating() {
        return this.lottieDrawable.t();
    }

    public boolean isMergePathsEnabledForKitKatAndAbove() {
        return this.lottieDrawable.d();
    }

    @Deprecated
    public void loop(boolean z) {
        this.lottieDrawable.e(z ? -1 : 0);
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.autoPlay && this.wasAnimatingWhenDetached) {
            playAnimation();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (isAnimating()) {
            cancelAnimation();
            this.wasAnimatingWhenDetached = true;
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof a)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        a aVar = (a) parcelable;
        super.onRestoreInstanceState(aVar.getSuperState());
        String str = aVar.f28928a;
        this.animationName = str;
        if (!TextUtils.isEmpty(str)) {
            setAnimation(this.animationName);
        }
        int i2 = aVar.f28929b;
        this.animationResId = i2;
        if (i2 != 0) {
            setAnimation(i2);
        }
        setProgress(aVar.f28930c);
        if (aVar.f28931d) {
            playAnimation();
        }
        this.lottieDrawable.a(aVar.f28932e);
        setRepeatMode(aVar.f28933f);
        setRepeatCount(aVar.f28934g);
    }

    @Override // android.view.View
    protected Parcelable onSaveInstanceState() {
        a aVar = new a(super.onSaveInstanceState());
        aVar.f28928a = this.animationName;
        aVar.f28929b = this.animationResId;
        aVar.f28930c = this.lottieDrawable.A();
        aVar.f28931d = this.lottieDrawable.t();
        aVar.f28932e = this.lottieDrawable.e();
        aVar.f28933f = this.lottieDrawable.r();
        aVar.f28934g = this.lottieDrawable.s();
        return aVar;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i2) {
        boolean z;
        if (this.lottieDrawable == null) {
            return;
        }
        if (isShown()) {
            if (!this.wasAnimatingWhenNotShown) {
                return;
            }
            resumeAnimation();
            z = false;
        } else {
            if (!isAnimating()) {
                return;
            }
            pauseAnimation();
            z = true;
        }
        this.wasAnimatingWhenNotShown = z;
    }

    public void pauseAnimation() {
        this.wasAnimatingWhenDetached = false;
        this.wasAnimatingWhenNotShown = false;
        this.lottieDrawable.z();
        enableOrDisableHardwareLayer();
    }

    public void playAnimation() {
        if (!isShown()) {
            this.wasAnimatingWhenNotShown = true;
        } else {
            this.lottieDrawable.h();
            enableOrDisableHardwareLayer();
        }
    }

    public void removeAllAnimatorListeners() {
        this.lottieDrawable.p();
    }

    public void removeAllLottieOnCompositionLoadedListener() {
        this.lottieOnCompositionLoadedListeners.clear();
    }

    public void removeAllUpdateListeners() {
        this.lottieDrawable.o();
    }

    public void removeAnimatorListener(Animator.AnimatorListener animatorListener) {
        this.lottieDrawable.b(animatorListener);
    }

    public boolean removeLottieOnCompositionLoadedListener(f fVar) {
        return this.lottieOnCompositionLoadedListeners.remove(fVar);
    }

    public void removeUpdateListener(ValueAnimator.AnimatorUpdateListener animatorUpdateListener) {
        this.lottieDrawable.b(animatorUpdateListener);
    }

    public List<com.vivo.mobilead.lottie.c.e> resolveKeyPath(com.vivo.mobilead.lottie.c.e eVar) {
        return this.lottieDrawable.a(eVar);
    }

    public void resumeAnimation() {
        if (!isShown()) {
            this.wasAnimatingWhenNotShown = true;
        } else {
            this.lottieDrawable.j();
            enableOrDisableHardwareLayer();
        }
    }

    public void reverseAnimationSpeed() {
        this.lottieDrawable.m();
    }

    public void setAnimation(int i2) {
        this.animationResId = i2;
        this.animationName = null;
        setCompositionTask(LottieCompositionFactory.fromRawRes(getContext(), i2));
    }

    public void setAnimation(JsonReader jsonReader, String str) {
        setCompositionTask(LottieCompositionFactory.fromJsonReader(jsonReader, str));
    }

    public void setAnimation(String str) {
        this.animationName = str;
        this.animationResId = 0;
        setCompositionTask(LottieCompositionFactory.fromAsset(getContext(), str));
    }

    @Deprecated
    public void setAnimationFromJson(String str) {
        setAnimationFromJson(str, null);
    }

    public void setAnimationFromJson(String str, String str2) {
        setAnimation(new JsonReader(new StringReader(str)), str2);
    }

    public void setAnimationFromUrl(String str) {
        setCompositionTask(LottieCompositionFactory.fromUrl(getContext(), str));
    }

    public void setComposition(LottieComposition lottieComposition) {
        if (b.f29112a) {
            Log.v(TAG, "Set Composition \n" + lottieComposition);
        }
        this.lottieDrawable.setCallback(this);
        this.composition = lottieComposition;
        boolean a2 = this.lottieDrawable.a(lottieComposition);
        enableOrDisableHardwareLayer();
        if (getDrawable() != this.lottieDrawable || a2) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
            requestLayout();
            Iterator<f> it = this.lottieOnCompositionLoadedListeners.iterator();
            while (it.hasNext()) {
                it.next().a(lottieComposition);
            }
        }
    }

    public void setFontAssetDelegate(FontAssetDelegate fontAssetDelegate) {
        this.lottieDrawable.a(fontAssetDelegate);
    }

    public void setFrame(int i2) {
        this.lottieDrawable.c(i2);
    }

    public void setImageAssetDelegate(com.vivo.mobilead.lottie.a aVar) {
        this.lottieDrawable.a(aVar);
    }

    public void setImageAssetsFolder(String str) {
        this.lottieDrawable.a(str);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        cancelLoaderTask();
        super.setImageBitmap(bitmap);
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        cancelLoaderTask();
        super.setImageDrawable(drawable);
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i2) {
        cancelLoaderTask();
        super.setImageResource(i2);
    }

    public void setMaxFrame(int i2) {
        this.lottieDrawable.b(i2);
    }

    public void setMaxFrame(String str) {
        this.lottieDrawable.c(str);
    }

    public void setMaxProgress(float f2) {
        this.lottieDrawable.b(f2);
    }

    public void setMinAndMaxFrame(int i2, int i3) {
        this.lottieDrawable.a(i2, i3);
    }

    public void setMinAndMaxFrame(String str) {
        this.lottieDrawable.d(str);
    }

    public void setMinAndMaxProgress(float f2, float f3) {
        this.lottieDrawable.a(f2, f3);
    }

    public void setMinFrame(int i2) {
        this.lottieDrawable.a(i2);
    }

    public void setMinFrame(String str) {
        this.lottieDrawable.b(str);
    }

    public void setMinProgress(float f2) {
        this.lottieDrawable.a(f2);
    }

    public void setPerformanceTrackingEnabled(boolean z) {
        this.lottieDrawable.b(z);
    }

    public void setProgress(float f2) {
        this.lottieDrawable.d(f2);
    }

    public void setRenderMode(j jVar) {
        this.renderMode = jVar;
        enableOrDisableHardwareLayer();
    }

    public void setRepeatCount(int i2) {
        this.lottieDrawable.e(i2);
    }

    public void setRepeatMode(int i2) {
        this.lottieDrawable.d(i2);
    }

    public void setScale(float f2) {
        this.lottieDrawable.e(f2);
        if (getDrawable() == this.lottieDrawable) {
            setImageDrawable(null);
            setImageDrawable(this.lottieDrawable);
        }
    }

    public void setSpeed(float f2) {
        this.lottieDrawable.c(f2);
    }

    public void setTextDelegate(TextDelegate textDelegate) {
        this.lottieDrawable.a(textDelegate);
    }

    public Bitmap updateBitmap(String str, Bitmap bitmap) {
        return this.lottieDrawable.a(str, bitmap);
    }
}
