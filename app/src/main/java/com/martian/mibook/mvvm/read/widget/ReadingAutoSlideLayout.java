package com.martian.mibook.mvvm.read.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.SeekBar;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.martian.mibook.R;
import com.martian.mibook.application.ReadingInstance;
import com.martian.mibook.databinding.ReaderAutoSlideLayoutBinding;
import com.martian.mibook.mvvm.read.widget.ReadingAutoSlideLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0003¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\bH\u0003¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\nR\u0014\u0010\u0010\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0015"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReadingAutoSlideLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "g", "()V", "k", "f", "Lcom/martian/mibook/databinding/ReaderAutoSlideLayoutBinding;", "b", "Lcom/martian/mibook/databinding/ReaderAutoSlideLayoutBinding;", "mViewBinding", "Lcom/martian/mibook/mvvm/read/widget/a;", "getReadMenuCallBack", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingAutoSlideLayout extends FrameLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @k
    public final ReaderAutoSlideLayoutBinding mViewBinding;

    public static final class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        @SuppressLint({"SetTextI18n"})
        public void onProgressChanged(@l SeekBar seekBar, int i10, boolean z10) {
            ReadingAutoSlideLayout.this.mViewBinding.tvTitle.setText(ReadingAutoSlideLayout.this.getContext().getString(R.string.auto_sliding_setting) + "·" + ((i10 * 0.5d) + 0.5d) + "x");
            ReaderThemeTextView readerThemeTextView = ReadingAutoSlideLayout.this.mViewBinding.tvReset;
            readerThemeTextView.setEnabled(i10 != 1);
            readerThemeTextView.setAlpha(readerThemeTextView.isEnabled() ? 1.0f : 0.4f);
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(@l SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(@l SeekBar seekBar) {
            ReadingAutoSlideLayout.this.k();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingAutoSlideLayout(@k Context context) {
        this(context, null, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final com.martian.mibook.mvvm.read.widget.a getReadMenuCallBack() {
        Object context = getContext();
        if (context instanceof com.martian.mibook.mvvm.read.widget.a) {
            return (com.martian.mibook.mvvm.read.widget.a) context;
        }
        return null;
    }

    public static final void h(ReadingAutoSlideLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f();
    }

    public static final void i(ReadingAutoSlideLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = this$0.getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.b0();
        }
        this$0.f();
    }

    public static final void j(ReadingAutoSlideLayout this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.mViewBinding.seekBar.setProgress(1);
        this$0.k();
    }

    public final void f() {
        Object parent = this.mViewBinding.getRoot().getParent();
        View view = parent instanceof View ? (View) parent : null;
        if (view != null) {
            view.setTag(Boolean.FALSE);
            BottomSheetBehavior from = BottomSheetBehavior.from(view);
            Intrinsics.checkNotNullExpressionValue(from, "from(...)");
            from.setState(5);
        }
    }

    @SuppressLint({"NotifyDataSetChanged", "ClickableViewAccessibility", "SetTextI18n"})
    public final void g() {
        this.mViewBinding.getRoot().setOnClickListener(null);
        this.mViewBinding.ivClose.setOnClickListener(new View.OnClickListener() { // from class: hd.o1
            public /* synthetic */ o1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingAutoSlideLayout.h(ReadingAutoSlideLayout.this, view);
            }
        });
        this.mViewBinding.llStopAutoSlide.setOnClickListener(new View.OnClickListener() { // from class: hd.p1
            public /* synthetic */ p1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingAutoSlideLayout.i(ReadingAutoSlideLayout.this, view);
            }
        });
        int round = Math.round((RangesKt.coerceIn(ReadingInstance.z().u(getContext()), 20, 380) - 20) / 40);
        this.mViewBinding.seekBar.setProgress(round);
        this.mViewBinding.tvTitle.setText(getContext().getString(R.string.auto_sliding_setting) + "·" + ((round * 0.5d) + 0.5d) + "x");
        ReaderThemeTextView readerThemeTextView = this.mViewBinding.tvReset;
        readerThemeTextView.setEnabled(round != 1);
        readerThemeTextView.setAlpha(readerThemeTextView.isEnabled() ? 1.0f : 0.4f);
        this.mViewBinding.tvReset.setOnClickListener(new View.OnClickListener() { // from class: hd.q1
            public /* synthetic */ q1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingAutoSlideLayout.j(ReadingAutoSlideLayout.this, view);
            }
        });
        this.mViewBinding.seekBar.setOnSeekBarChangeListener(new a());
    }

    @SuppressLint({"SetTextI18n"})
    public final void k() {
        int progress = this.mViewBinding.seekBar.getProgress();
        ReadingInstance.z().e0(getContext(), (progress * 40) + 20);
        this.mViewBinding.tvTitle.setText(getContext().getString(R.string.auto_sliding_setting) + "·" + ((progress * 0.5d) + 0.5d) + "x");
        com.martian.mibook.mvvm.read.widget.a readMenuCallBack = getReadMenuCallBack();
        if (readMenuCallBack != null) {
            readMenuCallBack.M0();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ReadingAutoSlideLayout(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ReaderAutoSlideLayoutBinding inflate = ReaderAutoSlideLayoutBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.mViewBinding = inflate;
        g();
    }

    public /* synthetic */ ReadingAutoSlideLayout(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
