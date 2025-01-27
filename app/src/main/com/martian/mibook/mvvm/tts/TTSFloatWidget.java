package com.martian.mibook.mvvm.tts;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.kwad.sdk.m.e;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.book.activity.BookDetailActivity;
import com.martian.mibook.mvvm.tts.ReadAloudBook;
import com.martian.mibook.mvvm.tts.TTSFloatWidget;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.utils.coroutine.Coroutine;
import com.umeng.analytics.pro.bt;
import id.i;
import java.lang.ref.WeakReference;
import java.util.List;
import kc.b;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import l9.m0;
import l9.t0;
import xi.k;
import xi.l;
import ya.n0;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\r\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\r\u0010\u000f\u001a\u00020\f¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0011\u001a\u00020\f¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\fH\u0003¢\u0006\u0004\b\u0012\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0014\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0014\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0015\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0016\u0010\u0010J\u000f\u0010\u0017\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0017\u0010\u0010J\u000f\u0010\u0018\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0018\u0010\u0010J\u000f\u0010\u0019\u001a\u00020\fH\u0002¢\u0006\u0004\b\u0019\u0010\u0010J\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001aH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\fH\u0002¢\u0006\u0004\b\u001f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0018\u0010&\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010*\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010,\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010)R\u0018\u0010-\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010)R\u0018\u0010/\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010.R\u0016\u00103\u001a\u0002008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u001e\u00107\u001a\n\u0012\u0004\u0012\u000205\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u00106¨\u00068"}, d2 = {"Lcom/martian/mibook/mvvm/tts/TTSFloatWidget;", "Landroidx/lifecycle/LifecycleEventObserver;", "Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Landroid/view/ViewGroup;", "targetParent", "<init>", "(Landroidx/fragment/app/FragmentActivity;Landroid/view/ViewGroup;)V", "Landroidx/lifecycle/LifecycleOwner;", "source", "Landroidx/lifecycle/Lifecycle$Event;", NotificationCompat.CATEGORY_EVENT, "", "onStateChanged", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V", "g", "()V", "u", t.f11204d, "p", "h", "v", t.f11211k, bt.aO, "s", "k", "Landroid/view/View;", "view", "Landroid/animation/ObjectAnimator;", IAdInterListener.AdReqParam.WIDTH, "(Landroid/view/View;)Landroid/animation/ObjectAnimator;", "j", "b", "Landroidx/fragment/app/FragmentActivity;", "c", "Landroid/view/ViewGroup;", "d", "Landroid/view/View;", "floatingView", "Landroid/widget/ImageView;", e.TAG, "Landroid/widget/ImageView;", "ttsFloatOperation", "f", "ttsFloatCover", "ttsFloatClose", "Landroid/animation/ObjectAnimator;", "ttsAnimator", "", "i", "J", "audioStartTime", "Landroidx/lifecycle/Observer;", "Lcom/martian/mibook/mvvm/tts/ReadAloudBook$a;", "Landroidx/lifecycle/Observer;", "readAloudEventObserver", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SourceDebugExtension({"SMAP\nTTSFloatWidget.kt\nKotlin\n*S Kotlin\n*F\n+ 1 TTSFloatWidget.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidget\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 ViewGroup.kt\nandroidx/core/view/ViewGroupKt\n*L\n1#1,307:1\n1#2:308\n36#3:309\n*S KotlinDebug\n*F\n+ 1 TTSFloatWidget.kt\ncom/martian/mibook/mvvm/tts/TTSFloatWidget\n*L\n226#1:309\n*E\n"})
/* loaded from: classes3.dex */
public final class TTSFloatWidget implements LifecycleEventObserver {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final FragmentActivity com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public final ViewGroup targetParent;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public View floatingView;

    /* renamed from: e */
    @l
    public ImageView ttsFloatOperation;

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public ImageView ttsFloatCover;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public ImageView ttsFloatClose;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public ObjectAnimator ttsAnimator;

    /* renamed from: i, reason: from kotlin metadata */
    public long audioStartTime;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public Observer<ReadAloudBook.a> readAloudEventObserver;

    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f15056a;

        /* renamed from: b */
        public static final /* synthetic */ int[] f15057b;

        /* renamed from: c */
        public static final /* synthetic */ int[] f15058c;

        static {
            int[] iArr = new int[Lifecycle.Event.values().length];
            try {
                iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[Lifecycle.Event.ON_DESTROY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f15056a = iArr;
            int[] iArr2 = new int[ReadAloudBook.ReadAloudPlayerStatus.values().length];
            try {
                iArr2[ReadAloudBook.ReadAloudPlayerStatus.STATE_PLAYING.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[ReadAloudBook.ReadAloudPlayerStatus.STATE_PAUSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[ReadAloudBook.ReadAloudPlayerStatus.STATE_STOPPED.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            f15057b = iArr2;
            int[] iArr3 = new int[ReadAloudBook.EventAction.values().length];
            try {
                iArr3[ReadAloudBook.EventAction.STATE_REPLENISH_TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr3[ReadAloudBook.EventAction.STATE_NONE_AVAILABLE_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr3[ReadAloudBook.EventAction.STATE_NONE_NEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused10) {
            }
            f15058c = iArr3;
        }
    }

    public TTSFloatWidget(@k FragmentActivity activity, @l ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String = activity;
        this.targetParent = viewGroup;
        this.audioStartTime = -1L;
        activity.getLifecycle().addObserver(this);
        l();
    }

    public static final void i(TTSFloatWidget this$0, ReadAloudBook.a aVar) {
        WeakReference<Activity> weakReference;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = a.f15058c[aVar.f().ordinal()];
        Activity activity = null;
        if (i10 == 1 || i10 == 2) {
            Coroutine.onSuccess$default(Coroutine.Companion.async$default(Coroutine.INSTANCE, null, null, null, null, new TTSFloatWidget$addReadAloudEventObserver$1$1(null), 15, null), null, new TTSFloatWidget$addReadAloudEventObserver$1$2(this$0, null), 1, null);
            return;
        }
        if (i10 != 3) {
            return;
        }
        List<WeakReference<Activity>> d10 = n0.f33313a.d(AudiobookActivity.class);
        if (d10 != null && (weakReference = d10.get(0)) != null) {
            activity = weakReference.get();
        }
        if (activity == null || !(activity instanceof AudiobookActivity)) {
            Book a10 = ReadAloudBook.f15003a.a();
            t0.b(this$0.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String, (a10 == null || !a10.isSerialEnd()) ? "您已听到最新章节，去听听其他书籍吧" : "您已听完本书，去听听其他书籍吧");
        }
    }

    public static final void m(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        TTSReadManager.i(context);
    }

    public static final void n(TTSFloatWidget this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        TTSReadManager.l(this$0.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String);
    }

    public static final void o(View view) {
        b.f(null, 0, 0, false, null, 31, null);
    }

    public static final void q(TTSFloatWidget this$0, ReadAloudBook.ReadAloudPlayerStatus readAloudPlayerStatus) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i10 = readAloudPlayerStatus == null ? -1 : a.f15057b[readAloudPlayerStatus.ordinal()];
        if (i10 == 1) {
            this$0.t();
            return;
        }
        if (i10 == 2) {
            this$0.s();
        } else {
            if (i10 != 3) {
                return;
            }
            this$0.u();
            this$0.audioStartTime = -1L;
        }
    }

    public final void g() {
        if (this.floatingView == null) {
            return;
        }
        u();
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ConfigSingleton.i(152.0f), ConfigSingleton.i(60.0f));
        ViewGroup viewGroup = this.targetParent;
        if (viewGroup == null) {
            int i10 = Intrinsics.areEqual(this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getClass(), BookDetailActivity.class) ? ConfigSingleton.i(73.0f) : ConfigSingleton.i(61.0f);
            layoutParams.gravity = 80;
            layoutParams.setMargins(ConfigSingleton.i(12.0f), 0, 0, i10);
            this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getWindow().addContentView(this.floatingView, layoutParams);
        } else {
            viewGroup.addView(this.floatingView, layoutParams);
        }
        p();
        r();
    }

    public final void h() {
        if (this.readAloudEventObserver == null) {
            this.readAloudEventObserver = new Observer() { // from class: id.d
                public /* synthetic */ d() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    TTSFloatWidget.i(TTSFloatWidget.this, (ReadAloudBook.a) obj);
                }
            };
        }
        Observer<ReadAloudBook.a> observer = this.readAloudEventObserver;
        if (observer != null) {
            TTSReadManager.u(observer);
        }
    }

    public final void j() {
        ObjectAnimator objectAnimator = this.ttsAnimator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
        this.ttsAnimator = null;
    }

    public final void k() {
        i.f(this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String);
        this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String.getLifecycle().removeObserver(this);
        v();
        j();
        this.floatingView = null;
        this.audioStartTime = -1L;
    }

    @SuppressLint({"InflateParams"})
    public final void l() {
        if (this.floatingView == null) {
            View inflate = LayoutInflater.from(this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String).inflate(R.layout.tts_float_widget, (ViewGroup) null);
            this.floatingView = inflate;
            this.ttsFloatOperation = inflate != null ? (ImageView) inflate.findViewById(R.id.tts_float_operation) : null;
            View view = this.floatingView;
            this.ttsFloatCover = view != null ? (ImageView) view.findViewById(R.id.tts_float_cover) : null;
            View view2 = this.floatingView;
            this.ttsFloatClose = view2 != null ? (ImageView) view2.findViewById(R.id.tts_float_close) : null;
            ImageView imageView = this.ttsFloatOperation;
            if (imageView != null) {
                imageView.setOnClickListener(new View.OnClickListener() { // from class: id.e
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        TTSFloatWidget.m(view3);
                    }
                });
            }
            ImageView imageView2 = this.ttsFloatClose;
            if (imageView2 != null) {
                imageView2.setOnClickListener(new View.OnClickListener() { // from class: id.f
                    public /* synthetic */ f() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        TTSFloatWidget.n(TTSFloatWidget.this, view3);
                    }
                });
            }
            ImageView imageView3 = this.ttsFloatCover;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() { // from class: id.g
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view3) {
                        TTSFloatWidget.o(view3);
                    }
                });
            }
        }
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public void onStateChanged(@k LifecycleOwner source, @k Lifecycle.Event r62) {
        ObjectAnimator objectAnimator;
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(r62, "event");
        int i10 = a.f15056a[r62.ordinal()];
        if (i10 == 1) {
            v();
            if (TTSReadManager.f15059a.n() != this.audioStartTime || (objectAnimator = this.ttsAnimator) == null) {
                return;
            }
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            Object animatedValue = objectAnimator.getAnimatedValue();
            Float f10 = animatedValue instanceof Float ? (Float) animatedValue : null;
            readAloudBook.G(f10 != null ? f10.floatValue() : 0.0f);
            return;
        }
        if (i10 == 2) {
            h();
            if (this.targetParent != null) {
                r();
                return;
            }
            return;
        }
        if (i10 != 3) {
            if (i10 != 4) {
                return;
            }
            k();
        } else {
            if (this.targetParent == null) {
                u();
                return;
            }
            ObjectAnimator objectAnimator2 = this.ttsAnimator;
            if (objectAnimator2 != null) {
                objectAnimator2.cancel();
            }
            this.ttsAnimator = null;
        }
    }

    public final void p() {
        ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
        Book a10 = readAloudBook.a();
        if (a10 != null) {
            long n10 = TTSReadManager.f15059a.n();
            ImageView imageView = this.ttsFloatCover;
            if (imageView != null) {
                imageView.setRotation(readAloudBook.j());
            }
            if (n10 != this.audioStartTime) {
                this.audioStartTime = n10;
                j();
                TTSReadManager.v(this.com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField.TT_ACTIVITY java.lang.String, new Observer() { // from class: id.h
                    public /* synthetic */ h() {
                    }

                    @Override // androidx.lifecycle.Observer
                    public final void onChanged(Object obj) {
                        TTSFloatWidget.q(TTSFloatWidget.this, (ReadAloudBook.ReadAloudPlayerStatus) obj);
                    }
                });
                View view = this.floatingView;
                Context context = view != null ? view.getContext() : null;
                String cover = a10.getCover();
                ImageView imageView2 = this.ttsFloatCover;
                int i10 = R.drawable.cover_default;
                m0.f(context, cover, imageView2, i10, i10);
            }
        }
    }

    public final void r() {
        if (TTSReadManager.p()) {
            t();
        } else {
            s();
        }
    }

    public final void s() {
        if (this.floatingView == null) {
            return;
        }
        ImageView imageView = this.ttsFloatOperation;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.icon_tts_float_play);
        }
        ObjectAnimator objectAnimator = this.ttsAnimator;
        if (objectAnimator == null || objectAnimator.isPaused()) {
            return;
        }
        ObjectAnimator objectAnimator2 = this.ttsAnimator;
        if (objectAnimator2 != null) {
            objectAnimator2.pause();
        }
        ObjectAnimator objectAnimator3 = this.ttsAnimator;
        if (objectAnimator3 != null) {
            ReadAloudBook readAloudBook = ReadAloudBook.f15003a;
            Object animatedValue = objectAnimator3.getAnimatedValue();
            Float f10 = animatedValue instanceof Float ? (Float) animatedValue : null;
            readAloudBook.G(f10 != null ? f10.floatValue() : 0.0f);
        }
    }

    public final void t() {
        if (this.floatingView == null) {
            return;
        }
        ImageView imageView = this.ttsFloatOperation;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.icon_tts_float_pause);
        }
        ObjectAnimator objectAnimator = this.ttsAnimator;
        if (objectAnimator == null) {
            this.ttsAnimator = w(this.ttsFloatCover);
        } else if (objectAnimator != null) {
            objectAnimator.resume();
        }
    }

    public final void u() {
        j();
        View view = this.floatingView;
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.indexOfChild(view);
            }
            if (viewGroup != null) {
                viewGroup.removeView(view);
            }
        }
    }

    public final void v() {
        Observer<ReadAloudBook.a> observer = this.readAloudEventObserver;
        if (observer != null) {
            TTSReadManager.A(observer);
        }
    }

    public final ObjectAnimator w(View view) {
        if (view == null) {
            return null;
        }
        float j10 = ReadAloudBook.f15003a.j();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "rotation", j10 - 359.0f, j10);
        ofFloat.setRepeatCount(-1);
        ofFloat.setDuration(8000L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ofFloat.start();
        return ofFloat;
    }

    public /* synthetic */ TTSFloatWidget(FragmentActivity fragmentActivity, ViewGroup viewGroup, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(fragmentActivity, (i10 & 2) != 0 ? null : viewGroup);
    }
}
