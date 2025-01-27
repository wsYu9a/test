package com.martian.libmars.widget.recyclerview;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import androidx.core.content.ContextCompat;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.libmars.databinding.LayoutLoadingTip2Binding;
import com.martian.libmars.databinding.LayoutLoadingTipBinding;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.recyclerview.LoadingTip;
import com.umeng.analytics.pro.f;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u00002\u00020\u0001:\u0003G.HB\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ/\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u0015\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\r¢\u0006\u0004\b\u0015\u0010\u0016J\u0017\u0010\u0019\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017¢\u0006\u0004\b\u0019\u0010\u001aJ!\u0010\u001e\u001a\u00020\n2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001c¢\u0006\u0004\b\u001e\u0010\u001fJ\u0015\u0010\"\u001a\u00020\n2\u0006\u0010!\u001a\u00020 ¢\u0006\u0004\b\"\u0010#J\u001b\u0010&\u001a\u00020\n2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\n0$¢\u0006\u0004\b&\u0010'J\u0015\u0010&\u001a\u00020\n2\u0006\u0010)\u001a\u00020(¢\u0006\u0004\b&\u0010*J\u0017\u0010+\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b+\u0010,R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u0016\u00108\u001a\u0002058\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u00107R\u0016\u0010:\u001a\u0004\u0018\u00010\u00178\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u00109R\u0016\u0010\t\u001a\u00020\b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R$\u0010B\u001a\u0004\u0018\u00010 8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u0004\bA\u0010#R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010CR\u0016\u0010F\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bD\u0010E¨\u0006I"}, d2 = {"Lcom/martian/libmars/widget/recyclerview/LoadingTip;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "withIcon", "", "setWithIcon", "(Z)V", "", "leftPadding", "topPadding", "rightPadding", "bottomPadding", "setPadding", "(IIII)V", "backgroundType", "setBackgroundType", "(I)V", "", "tips", "setTips", "(Ljava/lang/String;)V", "text", "Landroid/view/View$OnClickListener;", "onClickListener", "h", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;", "loadStatus", "setLoadingTip", "(Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;)V", "Lkotlin/Function0;", "onReload", "setOnReloadListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$b;", "onReloadListener", "(Lcom/martian/libmars/widget/recyclerview/LoadingTip$b;)V", e.TAG, "(Landroid/content/Context;)V", "Lcom/martian/libmars/databinding/LayoutLoadingTip2Binding;", "b", "Lcom/martian/libmars/databinding/LayoutLoadingTip2Binding;", "loadingTip2Binding", "Lcom/martian/libmars/databinding/LayoutLoadingTipBinding;", "c", "Lcom/martian/libmars/databinding/LayoutLoadingTipBinding;", "loadingTipBinding", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$StyleType;", "d", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$StyleType;", "currentStyle", "Ljava/lang/String;", MediationConstant.KEY_ERROR_MSG, "f", "Z", "g", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;", "getCurrentStatus", "()Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;", "setCurrentStatus", "currentStatus", "Lcom/martian/libmars/widget/recyclerview/LoadingTip$b;", "i", "I", "bottomOffset", "LoadStatus", "StyleType", "libmars_release"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class LoadingTip extends LinearLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public LayoutLoadingTip2Binding loadingTip2Binding;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public LayoutLoadingTipBinding loadingTipBinding;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public StyleType currentStyle;

    /* renamed from: e */
    @l
    public final String errorMsg;

    /* renamed from: f, reason: from kotlin metadata */
    public boolean withIcon;

    /* renamed from: g, reason: from kotlin metadata */
    @l
    public LoadStatus currentStatus;

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public b onReloadListener;

    /* renamed from: i, reason: from kotlin metadata */
    public int bottomOffset;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/martian/libmars/widget/recyclerview/LoadingTip$LoadStatus;", "", "(Ljava/lang/String;I)V", "serverError", "network_error", "empty", "loading", "finish", "libmars_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class LoadStatus extends Enum<LoadStatus> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ LoadStatus[] $VALUES;
        public static final LoadStatus serverError = new LoadStatus("serverError", 0);
        public static final LoadStatus network_error = new LoadStatus("network_error", 1);
        public static final LoadStatus empty = new LoadStatus("empty", 2);
        public static final LoadStatus loading = new LoadStatus("loading", 3);
        public static final LoadStatus finish = new LoadStatus("finish", 4);

        private static final /* synthetic */ LoadStatus[] $values() {
            return new LoadStatus[]{serverError, network_error, empty, loading, finish};
        }

        static {
            LoadStatus[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private LoadStatus(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<LoadStatus> getEntries() {
            return $ENTRIES;
        }

        public static LoadStatus valueOf(String str) {
            return (LoadStatus) Enum.valueOf(LoadStatus.class, str);
        }

        public static LoadStatus[] values() {
            return (LoadStatus[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/martian/libmars/widget/recyclerview/LoadingTip$StyleType;", "", "(Ljava/lang/String;I)V", "DEFAULT_STYLE", "QD_STYLE", "libmars_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class StyleType extends Enum<StyleType> {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ StyleType[] $VALUES;
        public static final StyleType DEFAULT_STYLE = new StyleType("DEFAULT_STYLE", 0);
        public static final StyleType QD_STYLE = new StyleType("QD_STYLE", 1);

        private static final /* synthetic */ StyleType[] $values() {
            return new StyleType[]{DEFAULT_STYLE, QD_STYLE};
        }

        static {
            StyleType[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private StyleType(String str, int i10) {
            super(str, i10);
        }

        @k
        public static EnumEntries<StyleType> getEntries() {
            return $ENTRIES;
        }

        public static StyleType valueOf(String str) {
            return (StyleType) Enum.valueOf(StyleType.class, str);
        }

        public static StyleType[] values() {
            return (StyleType[]) $VALUES.clone();
        }
    }

    public static final class a implements ViewTreeObserver.OnGlobalLayoutListener {
        public a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            int height = LoadingTip.this.getHeight();
            if (height <= 0 || LoadingTip.this.getLayoutParams() == null) {
                return;
            }
            if (LoadingTip.this.getLayoutParams().height == -2) {
                ViewParent parent = LoadingTip.this.getParent();
                ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
                height = viewGroup != null ? viewGroup.getHeight() : 0;
            }
            if (height > 0 && LoadingTip.this.getPaddingBottom() <= 0 && LoadingTip.this.bottomOffset <= 0) {
                LoadingTip.this.bottomOffset = (int) (height * 0.118f);
                LoadingTip loadingTip = LoadingTip.this;
                loadingTip.setPadding(loadingTip.getPaddingLeft(), LoadingTip.this.getPaddingTop(), LoadingTip.this.getPaddingRight(), LoadingTip.this.bottomOffset);
            }
            LoadingTip.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
        }
    }

    public interface b {
        void a();
    }

    public /* synthetic */ class c {

        /* renamed from: a */
        public static final /* synthetic */ int[] f12809a;

        static {
            int[] iArr = new int[LoadStatus.values().length];
            try {
                iArr[LoadStatus.empty.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LoadStatus.serverError.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LoadStatus.network_error.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LoadStatus.loading.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f12809a = iArr;
        }
    }

    public static final class d implements b {

        /* renamed from: a */
        public final /* synthetic */ Function0<Unit> f12810a;

        public d(Function0<Unit> function0) {
            this.f12810a = function0;
        }

        @Override // com.martian.libmars.widget.recyclerview.LoadingTip.b
        public void a() {
            this.f12810a.invoke();
        }
    }

    public /* synthetic */ LoadingTip(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }

    public static final void f(LoadingTip this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.onReloadListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    public static final void g(LoadingTip this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b bVar = this$0.onReloadListener;
        if (bVar != null) {
            bVar.a();
        }
    }

    public final void e(Context context) {
        ThemeTextView themeTextView;
        ThemeTextView themeTextView2;
        if (this.currentStyle == StyleType.QD_STYLE) {
            LayoutLoadingTip2Binding d10 = LayoutLoadingTip2Binding.d(LayoutInflater.from(context), this, true);
            this.loadingTip2Binding = d10;
            if (d10 != null && (themeTextView2 = d10.f12223b) != null) {
                themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: q9.b
                    public /* synthetic */ b() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        LoadingTip.f(LoadingTip.this, view);
                    }
                });
            }
            setVisibility(8);
            return;
        }
        LayoutLoadingTipBinding d11 = LayoutLoadingTipBinding.d(LayoutInflater.from(context), this, true);
        this.loadingTipBinding = d11;
        if (d11 != null && (themeTextView = d11.f12233b) != null) {
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: q9.c
                public /* synthetic */ c() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LoadingTip.g(LoadingTip.this, view);
                }
            });
        }
        setVisibility(8);
    }

    @l
    public final LoadStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public final void h(@l String text, @l View.OnClickListener onClickListener) {
        ThemeTextView themeTextView;
        ThemeTextView themeTextView2;
        LayoutLoadingTipBinding layoutLoadingTipBinding = this.loadingTipBinding;
        if (layoutLoadingTipBinding != null && (themeTextView2 = layoutLoadingTipBinding.f12233b) != null) {
            themeTextView2.setText(text);
            themeTextView2.setVisibility(0);
            if (onClickListener != null) {
                themeTextView2.setOnClickListener(onClickListener);
            }
        }
        LayoutLoadingTip2Binding layoutLoadingTip2Binding = this.loadingTip2Binding;
        if (layoutLoadingTip2Binding == null || (themeTextView = layoutLoadingTip2Binding.f12223b) == null) {
            return;
        }
        themeTextView.setText(text);
        themeTextView.setVisibility(0);
        if (onClickListener != null) {
            themeTextView.setOnClickListener(onClickListener);
        }
    }

    public final void setBackgroundType(int backgroundType) {
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        LayoutLoadingTipBinding layoutLoadingTipBinding = this.loadingTipBinding;
        if (layoutLoadingTipBinding != null && (themeLinearLayout2 = layoutLoadingTipBinding.f12235d) != null) {
            themeLinearLayout2.setBackgroundType(backgroundType);
            if (backgroundType < 0) {
                themeLinearLayout2.setBackgroundColor(ContextCompat.getColor(themeLinearLayout2.getContext(), R.color.transparent));
            }
        }
        LayoutLoadingTip2Binding layoutLoadingTip2Binding = this.loadingTip2Binding;
        if (layoutLoadingTip2Binding == null || (themeLinearLayout = layoutLoadingTip2Binding.f12224c) == null) {
            return;
        }
        themeLinearLayout.setBackgroundType(backgroundType);
        if (backgroundType < 0) {
            themeLinearLayout.setBackgroundColor(ContextCompat.getColor(themeLinearLayout.getContext(), R.color.transparent));
        }
    }

    public final void setCurrentStatus(@l LoadStatus loadStatus) {
        this.currentStatus = loadStatus;
    }

    public final void setLoadingTip(@k LoadStatus loadStatus) {
        Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
        LayoutLoadingTipBinding layoutLoadingTipBinding = this.loadingTipBinding;
        if (layoutLoadingTipBinding != null) {
            Drawable background = layoutLoadingTipBinding.f12237f.getBackground();
            AnimationDrawable animationDrawable = background instanceof AnimationDrawable ? (AnimationDrawable) background : null;
            this.currentStatus = loadStatus;
            int i10 = c.f12809a[loadStatus.ordinal()];
            if (i10 == 1) {
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                setVisibility(0);
                layoutLoadingTipBinding.f12234c.setVisibility(0);
                layoutLoadingTipBinding.f12240i.setVisibility(8);
                layoutLoadingTipBinding.f12233b.setVisibility(8);
                layoutLoadingTipBinding.f12239h.setVisibility(0);
                layoutLoadingTipBinding.f12236e.setVisibility(8);
                layoutLoadingTipBinding.f12234c.setImageResource(R.drawable.tip_no_content);
                layoutLoadingTipBinding.f12239h.setText(getContext().getText(R.string.empty).toString());
                if (this.withIcon) {
                    layoutLoadingTipBinding.f12234c.setVisibility(0);
                } else {
                    layoutLoadingTipBinding.f12234c.setVisibility(8);
                }
            } else if (i10 == 2) {
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                setVisibility(0);
                layoutLoadingTipBinding.f12234c.setVisibility(0);
                layoutLoadingTipBinding.f12240i.setVisibility(0);
                layoutLoadingTipBinding.f12239h.setVisibility(0);
                layoutLoadingTipBinding.f12236e.setVisibility(8);
                layoutLoadingTipBinding.f12234c.setImageResource(R.drawable.tip_content_error);
                if (TextUtils.isEmpty(this.errorMsg)) {
                    layoutLoadingTipBinding.f12239h.setText(getContext().getText(R.string.net_error).toString());
                } else {
                    layoutLoadingTipBinding.f12239h.setText(this.errorMsg);
                }
                layoutLoadingTipBinding.f12233b.setVisibility(0);
            } else if (i10 == 3) {
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                setVisibility(0);
                layoutLoadingTipBinding.f12234c.setVisibility(0);
                layoutLoadingTipBinding.f12240i.setVisibility(0);
                layoutLoadingTipBinding.f12239h.setVisibility(0);
                layoutLoadingTipBinding.f12236e.setVisibility(8);
                layoutLoadingTipBinding.f12234c.setImageResource(R.drawable.tip_wifi_off);
                if (TextUtils.isEmpty(this.errorMsg)) {
                    layoutLoadingTipBinding.f12239h.setText(getContext().getText(R.string.net_error).toString());
                } else {
                    layoutLoadingTipBinding.f12239h.setText(this.errorMsg);
                }
                layoutLoadingTipBinding.f12240i.setText(getContext().getText(R.string.net_error_retry_hint).toString());
                layoutLoadingTipBinding.f12233b.setVisibility(0);
            } else if (i10 != 4) {
                if (animationDrawable != null) {
                    animationDrawable.stop();
                }
                setVisibility(8);
            } else {
                if (animationDrawable != null) {
                    animationDrawable.start();
                }
                setVisibility(0);
                layoutLoadingTipBinding.f12234c.setVisibility(8);
                layoutLoadingTipBinding.f12240i.setVisibility(8);
                layoutLoadingTipBinding.f12239h.setVisibility(8);
                layoutLoadingTipBinding.f12236e.setVisibility(0);
                layoutLoadingTipBinding.f12233b.setVisibility(8);
                if (this.withIcon) {
                    layoutLoadingTipBinding.f12237f.setVisibility(0);
                } else {
                    layoutLoadingTipBinding.f12237f.setVisibility(8);
                }
            }
        }
        LayoutLoadingTip2Binding layoutLoadingTip2Binding = this.loadingTip2Binding;
        if (layoutLoadingTip2Binding != null) {
            Drawable background2 = layoutLoadingTip2Binding.f12228g.getBackground();
            AnimationDrawable animationDrawable2 = background2 instanceof AnimationDrawable ? (AnimationDrawable) background2 : null;
            this.currentStatus = loadStatus;
            int i11 = c.f12809a[loadStatus.ordinal()];
            if (i11 == 1) {
                if (animationDrawable2 != null) {
                    animationDrawable2.stop();
                }
                setVisibility(0);
                layoutLoadingTip2Binding.f12225d.setVisibility(8);
                layoutLoadingTip2Binding.f12229h.setVisibility(0);
                layoutLoadingTip2Binding.f12227f.setVisibility(8);
                layoutLoadingTip2Binding.f12229h.setText(getContext().getText(R.string.empty).toString());
                return;
            }
            if (i11 == 2 || i11 == 3) {
                if (animationDrawable2 != null) {
                    animationDrawable2.stop();
                }
                setVisibility(0);
                layoutLoadingTip2Binding.f12225d.setVisibility(0);
                layoutLoadingTip2Binding.f12229h.setVisibility(8);
                layoutLoadingTip2Binding.f12227f.setVisibility(8);
                layoutLoadingTip2Binding.f12223b.setVisibility(0);
                return;
            }
            if (i11 != 4) {
                if (animationDrawable2 != null) {
                    animationDrawable2.stop();
                }
                setVisibility(8);
            } else {
                if (animationDrawable2 != null) {
                    animationDrawable2.start();
                }
                setVisibility(0);
                layoutLoadingTip2Binding.f12225d.setVisibility(8);
                layoutLoadingTip2Binding.f12229h.setVisibility(8);
                layoutLoadingTip2Binding.f12227f.setVisibility(0);
            }
        }
    }

    public final void setOnReloadListener(@k Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        this.onReloadListener = new d(onReload);
    }

    @Override // android.view.View
    public void setPadding(int leftPadding, int topPadding, int rightPadding, int bottomPadding) {
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        LayoutLoadingTipBinding layoutLoadingTipBinding = this.loadingTipBinding;
        if (layoutLoadingTipBinding != null && (themeLinearLayout2 = layoutLoadingTipBinding.f12235d) != null) {
            themeLinearLayout2.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
        }
        LayoutLoadingTip2Binding layoutLoadingTip2Binding = this.loadingTip2Binding;
        if (layoutLoadingTip2Binding == null || (themeLinearLayout = layoutLoadingTip2Binding.f12224c) == null) {
            return;
        }
        themeLinearLayout.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
    }

    public final void setTips(@l String tips) {
        LayoutLoadingTipBinding layoutLoadingTipBinding = this.loadingTipBinding;
        ThemeTextView themeTextView = layoutLoadingTipBinding != null ? layoutLoadingTipBinding.f12239h : null;
        if (themeTextView != null) {
            themeTextView.setText(tips);
        }
        LayoutLoadingTip2Binding layoutLoadingTip2Binding = this.loadingTip2Binding;
        ThemeTextView themeTextView2 = layoutLoadingTip2Binding != null ? layoutLoadingTip2Binding.f12229h : null;
        if (themeTextView2 == null) {
            return;
        }
        themeTextView2.setText(tips);
    }

    public final void setWithIcon(boolean withIcon) {
        this.withIcon = withIcon;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LoadingTip(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        this.currentStyle = StyleType.DEFAULT_STYLE;
        this.withIcon = true;
        if (Intrinsics.areEqual(context.getPackageName(), "com.martian.qmbook.qdbook")) {
            this.currentStyle = StyleType.QD_STYLE;
        }
        e(context);
        getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public final void setOnReloadListener(@k b onReloadListener) {
        Intrinsics.checkNotNullParameter(onReloadListener, "onReloadListener");
        this.onReloadListener = onReloadListener;
    }
}
