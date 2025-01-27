package com.martian.mibook.mvvm.read.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import com.kwad.sdk.m.e;
import com.martian.libmars.R;
import com.martian.mibook.databinding.ReaderLoadingTipBinding;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.net.ErrorResult;
import com.martian.mibook.mvvm.read.widget.ReaderLoadingTip;
import com.martian.mibook.ui.reader.ReaderThemeItemTextView;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
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

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001:\u000256B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J/\u0010\u000e\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J!\u0010\u0017\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00102\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\u000f\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u0019¢\u0006\u0004\b\u001d\u0010\u001eJ!\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00192\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010!¢\u0006\u0004\b#\u0010$J\u001b\u0010'\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\r0%¢\u0006\u0004\b'\u0010(J\u0015\u0010'\u001a\u00020\r2\u0006\u0010*\u001a\u00020)¢\u0006\u0004\b'\u0010+J\u0017\u0010,\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b,\u0010-R\u0018\u00100\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u0010/R\u0018\u00103\u001a\u0004\u0018\u00010\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u0010*\u001a\u0004\u0018\u00010)8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u00104¨\u00067"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", f.X, "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "", "leftPadding", "topPadding", "rightPadding", "bottomPadding", "", "setPadding", "(IIII)V", "", "tips", "setTips", "(Ljava/lang/String;)V", "text", "Landroid/view/View$OnClickListener;", "onClickListener", "g", "(Ljava/lang/String;Landroid/view/View$OnClickListener;)V", "Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;", "getCurrentStatus", "()Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;", "loadStatus", "setLoadingTip", "(Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;)V", e.TAG, "(Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;Ljava/lang/String;)V", "Lcom/martian/mibook/mvvm/net/ErrorResult;", "errorResult", "d", "(Lcom/martian/mibook/mvvm/net/ErrorResult;)V", "Lkotlin/Function0;", "onReload", "setOnReloadListener", "(Lkotlin/jvm/functions/Function0;)V", "Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$a;", "onReloadListener", "(Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$a;)V", "b", "(Landroid/content/Context;)V", "Lcom/martian/mibook/databinding/ReaderLoadingTipBinding;", "Lcom/martian/mibook/databinding/ReaderLoadingTipBinding;", "loadingTipBinding", "c", "Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;", "currentStatus", "Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$a;", "LoadStatus", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReaderLoadingTip extends LinearLayout {

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public ReaderLoadingTipBinding loadingTipBinding;

    /* renamed from: c, reason: from kotlin metadata */
    @l
    public LoadStatus currentStatus;

    /* renamed from: d, reason: from kotlin metadata */
    @l
    public a onReloadListener;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/martian/mibook/mvvm/read/widget/ReaderLoadingTip$LoadStatus;", "", "(Ljava/lang/String;I)V", "serverError", "network_error", "empty", "loading", "finish", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0}, xi = 48)
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

    public interface a {
        void a();
    }

    public /* synthetic */ class b {

        /* renamed from: a */
        public static final /* synthetic */ int[] f14927a;

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
            f14927a = iArr;
        }
    }

    public static final class c implements a {

        /* renamed from: a */
        public final /* synthetic */ Function0<Unit> f14928a;

        public c(Function0<Unit> function0) {
            this.f14928a = function0;
        }

        @Override // com.martian.mibook.mvvm.read.widget.ReaderLoadingTip.a
        public void a() {
            this.f14928a.invoke();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReaderLoadingTip(@k Context context, @l AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
        b(context);
    }

    public static final void c(ReaderLoadingTip this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a aVar = this$0.onReloadListener;
        if (aVar != null) {
            aVar.a();
        }
    }

    public static /* synthetic */ void f(ReaderLoadingTip readerLoadingTip, LoadStatus loadStatus, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        readerLoadingTip.e(loadStatus, str);
    }

    public final void b(Context r22) {
        ReaderThemeItemTextView readerThemeItemTextView;
        ReaderLoadingTipBinding inflate = ReaderLoadingTipBinding.inflate(LayoutInflater.from(r22), this, true);
        this.loadingTipBinding = inflate;
        if (inflate != null && (readerThemeItemTextView = inflate.btOperate) != null) {
            readerThemeItemTextView.setOnClickListener(new View.OnClickListener() { // from class: hd.f1
                public /* synthetic */ f1() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReaderLoadingTip.c(ReaderLoadingTip.this, view);
                }
            });
        }
        setVisibility(8);
    }

    public final void d(@l ErrorResult errorResult) {
        if (errorResult == null) {
            return;
        }
        if (errorResult.getErrorCode() == -100002) {
            setLoadingTip(LoadStatus.network_error);
        } else {
            setLoadingTip(LoadStatus.serverError);
        }
        if (ba.l.q(errorResult.getErrorMsg()) || errorResult.getErrorMsg().length() >= 20) {
            return;
        }
        setTips(ExtKt.c(errorResult.getErrorMsg()));
    }

    public final void e(@k LoadStatus loadStatus, @l String str) {
        Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
        ReaderLoadingTipBinding readerLoadingTipBinding = this.loadingTipBinding;
        if (readerLoadingTipBinding != null) {
            this.currentStatus = loadStatus;
            int i10 = b.f14927a[loadStatus.ordinal()];
            if (i10 == 1) {
                setVisibility(0);
                readerLoadingTipBinding.tvTipsRetryHint.setVisibility(8);
                readerLoadingTipBinding.btOperate.setVisibility(8);
                readerLoadingTipBinding.tvTips.setVisibility(0);
                readerLoadingTipBinding.llLoading.setVisibility(8);
                if (TextUtils.isEmpty(str)) {
                    readerLoadingTipBinding.tvTips.setText(getContext().getText(R.string.empty).toString());
                    return;
                } else {
                    readerLoadingTipBinding.tvTips.setText(str);
                    return;
                }
            }
            if (i10 == 2) {
                setVisibility(0);
                readerLoadingTipBinding.tvTipsRetryHint.setVisibility(0);
                readerLoadingTipBinding.tvTips.setVisibility(0);
                readerLoadingTipBinding.llLoading.setVisibility(8);
                if (TextUtils.isEmpty(str)) {
                    readerLoadingTipBinding.tvTips.setText(getContext().getText(R.string.net_error).toString());
                } else {
                    readerLoadingTipBinding.tvTips.setText(str);
                }
                readerLoadingTipBinding.btOperate.setVisibility(0);
                return;
            }
            if (i10 != 3) {
                if (i10 != 4) {
                    setVisibility(8);
                    return;
                }
                setVisibility(0);
                readerLoadingTipBinding.tvTipsRetryHint.setVisibility(8);
                readerLoadingTipBinding.tvTips.setVisibility(8);
                readerLoadingTipBinding.llLoading.setVisibility(0);
                readerLoadingTipBinding.btOperate.setVisibility(8);
                return;
            }
            setVisibility(0);
            readerLoadingTipBinding.tvTipsRetryHint.setVisibility(0);
            readerLoadingTipBinding.tvTips.setVisibility(0);
            readerLoadingTipBinding.llLoading.setVisibility(8);
            if (TextUtils.isEmpty(str)) {
                readerLoadingTipBinding.tvTips.setText(getContext().getText(R.string.net_error).toString());
            } else {
                readerLoadingTipBinding.tvTips.setText(str);
            }
            readerLoadingTipBinding.tvTipsRetryHint.setText(getContext().getText(R.string.net_error_retry_hint).toString());
            readerLoadingTipBinding.btOperate.setVisibility(0);
        }
    }

    public final void g(@l String text, @l View.OnClickListener onClickListener) {
        ReaderThemeItemTextView readerThemeItemTextView;
        ReaderLoadingTipBinding readerLoadingTipBinding = this.loadingTipBinding;
        if (readerLoadingTipBinding == null || (readerThemeItemTextView = readerLoadingTipBinding.btOperate) == null) {
            return;
        }
        readerThemeItemTextView.setText(text);
        readerThemeItemTextView.setVisibility(0);
        if (onClickListener != null) {
            readerThemeItemTextView.setOnClickListener(onClickListener);
        }
    }

    @l
    public final LoadStatus getCurrentStatus() {
        return this.currentStatus;
    }

    public final void setLoadingTip(@k LoadStatus loadStatus) {
        Intrinsics.checkNotNullParameter(loadStatus, "loadStatus");
        e(loadStatus, null);
    }

    public final void setOnReloadListener(@k Function0<Unit> onReload) {
        Intrinsics.checkNotNullParameter(onReload, "onReload");
        this.onReloadListener = new c(onReload);
    }

    @Override // android.view.View
    public void setPadding(int leftPadding, int topPadding, int rightPadding, int bottomPadding) {
        LinearLayout root;
        ReaderLoadingTipBinding readerLoadingTipBinding = this.loadingTipBinding;
        if (readerLoadingTipBinding == null || (root = readerLoadingTipBinding.getRoot()) == null) {
            return;
        }
        root.setPadding(leftPadding, topPadding, rightPadding, bottomPadding);
    }

    public final void setTips(@l String tips) {
        ReaderLoadingTipBinding readerLoadingTipBinding = this.loadingTipBinding;
        ReaderThemeTextView readerThemeTextView = readerLoadingTipBinding != null ? readerLoadingTipBinding.tvTips : null;
        if (readerThemeTextView == null) {
            return;
        }
        readerThemeTextView.setText(tips);
    }

    public final void setOnReloadListener(@k a onReloadListener) {
        Intrinsics.checkNotNullParameter(onReloadListener, "onReloadListener");
        this.onReloadListener = onReloadListener;
    }

    public /* synthetic */ ReaderLoadingTip(Context context, AttributeSet attributeSet, int i10, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
