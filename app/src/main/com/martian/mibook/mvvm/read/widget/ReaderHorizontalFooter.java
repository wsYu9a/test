package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.ui.reader.ReaderBrokenLineView;
import com.scwang.smart.refresh.layout.constant.RefreshState;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.f;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pf.c;
import pf.e;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u001f\b\u0007\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0007\u0010\bJ'\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0017¢\u0006\u0004\b\u0013\u0010\u0014J'\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0015H\u0017¢\u0006\u0004\b\u0018\u0010\u0019J7\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\u001f\u0010 J\u000f\u0010!\u001a\u00020\u000eH\u0002¢\u0006\u0004\b!\u0010\"R\u0018\u0010%\u001a\u0004\u0018\u00010\t8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,R\u001b\u00103\u001a\u00020.8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b1\u00102¨\u00064"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderHorizontalFooter;", "Ly9/a;", "Lpf/c;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "Lpf/e;", "kernel", "", "height", "maxDragHeight", "", "d", "(Lpf/e;II)V", "Lpf/f;", "refreshLayout", bt.aO, "(Lpf/f;II)V", "Lcom/scwang/smart/refresh/layout/constant/RefreshState;", "oldState", "newState", "c", "(Lpf/f;Lcom/scwang/smart/refresh/layout/constant/RefreshState;Lcom/scwang/smart/refresh/layout/constant/RefreshState;)V", "", "isDragging", "", "percent", TypedValues.CycleType.S_WAVE_OFFSET, t.f11211k, "(ZFIII)V", "b", "()V", "f", "Lpf/e;", "mRefreshKernel", "Lcom/martian/mibook/ui/reader/ReaderBrokenLineView;", "g", "Lcom/martian/mibook/ui/reader/ReaderBrokenLineView;", "brokenLineView", "Landroid/widget/TextView;", "h", "Landroid/widget/TextView;", "tvTipsView", "Landroid/os/Vibrator;", "i", "Lkotlin/Lazy;", "getVibrator", "()Landroid/os/Vibrator;", "vibrator", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderHorizontalFooter extends y9.a implements c {

    /* renamed from: f, reason: from kotlin metadata */
    @l
    public e mRefreshKernel;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public ReaderBrokenLineView brokenLineView;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public TextView tvTipsView;

    /* renamed from: i, reason: from kotlin metadata */
    @k
    public final Lazy vibrator;

    public /* synthetic */ class a {

        /* renamed from: a */
        public static final /* synthetic */ int[] f14918a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            try {
                iArr[RefreshState.ReleaseToLoad.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RefreshState.LoadReleased.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[RefreshState.ReleaseToTwoLevel.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[RefreshState.TwoLevelFinish.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[RefreshState.LoadFinish.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[RefreshState.Loading.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            f14918a = iArr;
        }
    }

    @JvmOverloads
    public ReaderHorizontalFooter(@l Context context) {
        this(context, null, 2, null);
    }

    private final Vibrator getVibrator() {
        return (Vibrator) this.vibrator.getValue();
    }

    public final void b() {
        VibrationEffect createWaveform;
        if (getVibrator().hasVibrator()) {
            long[] jArr = {0, 40};
            if (Build.VERSION.SDK_INT < 26) {
                getVibrator().vibrate(jArr, -1);
                return;
            }
            Vibrator vibrator = getVibrator();
            createWaveform = VibrationEffect.createWaveform(jArr, -1);
            vibrator.vibrate(createWaveform);
        }
    }

    @Override // tf.b, sf.i
    @SuppressLint({"SetTextI18n"})
    public void c(@k pf.f refreshLayout, @k RefreshState oldState, @k RefreshState newState) {
        TextView textView;
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        Intrinsics.checkNotNullParameter(oldState, "oldState");
        Intrinsics.checkNotNullParameter(newState, "newState");
        switch (a.f14918a[newState.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 4:
                TextView textView2 = this.tvTipsView;
                if (textView2 != null) {
                    textView2.setText(ExtKt.c("松手退出"));
                }
                if (newState == RefreshState.ReleaseToLoad) {
                    b();
                    break;
                }
                break;
            case 5:
            case 6:
                TextView textView3 = this.tvTipsView;
                if (textView3 != null) {
                    textView3.setText(ExtKt.c("正在退出"));
                    break;
                }
                break;
            default:
                if (oldState != RefreshState.LoadFinish && oldState != RefreshState.Loading && (textView = this.tvTipsView) != null) {
                    textView.setText(ExtKt.c("左滑退出阅读器"));
                    break;
                }
                break;
        }
    }

    @Override // tf.b, pf.a
    public void d(@k e kernel, int height, int maxDragHeight) {
        Intrinsics.checkNotNullParameter(kernel, "kernel");
        super.d(kernel, height, maxDragHeight);
        this.mRefreshKernel = kernel;
        kernel.l().C(false);
    }

    @Override // tf.b, pf.a
    public void r(boolean z10, float f10, int i10, int i11, int i12) {
        super.r(z10, f10, i10, i11, i12);
        ReaderBrokenLineView readerBrokenLineView = this.brokenLineView;
        if (readerBrokenLineView != null) {
            readerBrokenLineView.a(f10);
        }
    }

    @Override // tf.b, pf.a
    @SuppressLint({"SetTextI18n"})
    public void t(@k pf.f refreshLayout, int i10, int i11) {
        Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
        TextView textView = this.tvTipsView;
        if (textView != null) {
            textView.setText(ExtKt.c("正在退出"));
        }
        e eVar = this.mRefreshKernel;
        Intrinsics.checkNotNull(eVar);
        eVar.o(RefreshState.LoadFinish);
        e eVar2 = this.mRefreshKernel;
        Intrinsics.checkNotNull(eVar2);
        eVar2.o(RefreshState.None);
    }

    @JvmOverloads
    public ReaderHorizontalFooter(@l Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.vibrator = LazyKt.lazy(new Function0<Vibrator>() { // from class: com.martian.mibook.mvvm.read.widget.ReaderHorizontalFooter$vibrator$2
            final /* synthetic */ Context $context;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ReaderHorizontalFooter$vibrator$2(Context context2) {
                super(0);
                context = context2;
            }

            @Override // kotlin.jvm.functions.Function0
            @k
            public final Vibrator invoke() {
                Context context2 = context;
                Object systemService = context2 != null ? context2.getSystemService("vibrator") : null;
                Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.os.Vibrator");
                return (Vibrator) systemService;
            }
        });
        View.inflate(context2, R.layout.reader_widget_horizontal_footer, this);
        this.brokenLineView = (ReaderBrokenLineView) findViewById(R.id.broken_line);
        this.tvTipsView = (TextView) findViewById(R.id.tv_tips);
    }

    public /* synthetic */ ReaderHorizontalFooter(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
