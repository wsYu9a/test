package com.martian.mibook.mvvm.read.popwindow;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kwad.sdk.m.e;
import com.martian.mibook.R;
import com.martian.mibook.mvvm.read.popwindow.ReadingMoreItemPopupWindow;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.umeng.analytics.pro.f;
import gd.a;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\t\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0015\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010 \u001a\u0004\u0018\u00010\u001c8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006%"}, d2 = {"Lcom/martian/mibook/mvvm/read/popwindow/ReadingMoreItemPopupWindow;", "Landroid/widget/PopupWindow;", "Landroid/content/Context;", f.X, "<init>", "(Landroid/content/Context;)V", "", "k", "()V", "m", "a", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/widget/TextView;", "b", "Landroid/widget/TextView;", "bookMarkView", "", "c", "Z", "addBookMark", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "d", "Lkotlin/Lazy;", "i", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Landroidx/fragment/app/FragmentActivity;", e.TAG, "getActivity", "()Landroidx/fragment/app/FragmentActivity;", TTDownloadField.TT_ACTIVITY, "Lgd/a;", "j", "()Lgd/a;", "slidingCallBack", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
@SuppressLint({"MissingInflatedId"})
/* loaded from: classes3.dex */
public final class ReadingMoreItemPopupWindow extends PopupWindow {

    /* renamed from: a, reason: from kotlin metadata */
    @k
    public final Context com.umeng.analytics.pro.f.X java.lang.String;

    /* renamed from: b, reason: from kotlin metadata */
    @l
    public TextView bookMarkView;

    /* renamed from: c, reason: from kotlin metadata */
    public boolean addBookMark;

    /* renamed from: d, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel;

    /* renamed from: e */
    @k
    public final Lazy activity;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingMoreItemPopupWindow(@k Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.com.umeng.analytics.pro.f.X java.lang.String = context;
        this.addBookMark = true;
        this.mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.popwindow.ReadingMoreItemPopupWindow$mViewModel$2
            public ReadingMoreItemPopupWindow$mViewModel$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final ReadingViewModel invoke() {
                if (ReadingMoreItemPopupWindow.this.getCom.umeng.analytics.pro.f.X java.lang.String() instanceof FragmentActivity) {
                    return (ReadingViewModel) new ViewModelProvider((ViewModelStoreOwner) ReadingMoreItemPopupWindow.this.getCom.umeng.analytics.pro.f.X java.lang.String()).get(ReadingViewModel.class);
                }
                return null;
            }
        });
        this.activity = LazyKt.lazy(new Function0<FragmentActivity>() { // from class: com.martian.mibook.mvvm.read.popwindow.ReadingMoreItemPopupWindow$activity$2
            public ReadingMoreItemPopupWindow$activity$2() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            @l
            public final FragmentActivity invoke() {
                if (ReadingMoreItemPopupWindow.this.getCom.umeng.analytics.pro.f.X java.lang.String() instanceof FragmentActivity) {
                    return (FragmentActivity) ReadingMoreItemPopupWindow.this.getCom.umeng.analytics.pro.f.X java.lang.String();
                }
                return null;
            }
        });
        m();
        k();
    }

    private final FragmentActivity getActivity() {
        return (FragmentActivity) this.activity.getValue();
    }

    public static final void l(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void n(ReadingMoreItemPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.addBookMark) {
            a j10 = this$0.j();
            if (j10 != null) {
                j10.I0();
                return;
            }
            return;
        }
        a j11 = this$0.j();
        if (j11 != null) {
            j11.j();
        }
    }

    public static final void o(ReadingMoreItemPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a j10 = this$0.j();
        if (j10 != null) {
            j10.B();
        }
    }

    public static final void p(ReadingMoreItemPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a j10 = this$0.j();
        if (j10 != null) {
            j10.N();
        }
    }

    public static final void q(ReadingMoreItemPopupWindow this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        a j10 = this$0.j();
        if (j10 != null) {
            j10.H();
        }
    }

    @k
    /* renamed from: getContext, reason: from getter */
    public final Context getCom.umeng.analytics.pro.f.X java.lang.String() {
        return this.com.umeng.analytics.pro.f.X java.lang.String;
    }

    public final ReadingViewModel i() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    public final a j() {
        Object obj = this.com.umeng.analytics.pro.f.X java.lang.String;
        if (obj instanceof a) {
            return (a) obj;
        }
        return null;
    }

    public final void k() {
        ReadingViewModel i10;
        MutableLiveData<Boolean> J0;
        FragmentActivity activity = getActivity();
        if (activity == null || (i10 = i()) == null || (J0 = i10.J0()) == null) {
            return;
        }
        J0.observe(activity, new Observer() { // from class: fd.a
            public /* synthetic */ a() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingMoreItemPopupWindow.l(Function1.this, obj);
            }
        });
    }

    @SuppressLint({"InflateParams"})
    public final void m() {
        View inflate = LayoutInflater.from(this.com.umeng.analytics.pro.f.X java.lang.String).inflate(R.layout.reading_pop_menu_bar, (ViewGroup) null);
        setContentView(inflate);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable(0));
        setOutsideTouchable(true);
        setFocusable(true);
        this.bookMarkView = (TextView) inflate.findViewById(R.id.rtv_book_mark);
        ReadingViewModel i10 = i();
        if (i10 == null || !i10.T1()) {
            inflate.findViewById(R.id.ll_book_comment).setVisibility(0);
            inflate.findViewById(R.id.book_comment_view_divider).setVisibility(0);
            inflate.findViewById(R.id.ll_book_detail).setVisibility(0);
            inflate.findViewById(R.id.ll_book_detail_divider).setVisibility(0);
        } else {
            inflate.findViewById(R.id.ll_book_comment).setVisibility(8);
            inflate.findViewById(R.id.book_comment_view_divider).setVisibility(8);
            inflate.findViewById(R.id.ll_book_detail).setVisibility(8);
            inflate.findViewById(R.id.ll_book_detail_divider).setVisibility(8);
        }
        inflate.findViewById(R.id.ll_add_bookmark).setOnClickListener(new View.OnClickListener() { // from class: fd.b
            public /* synthetic */ b() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreItemPopupWindow.n(ReadingMoreItemPopupWindow.this, view);
            }
        });
        inflate.findViewById(R.id.ll_book_comment).setOnClickListener(new View.OnClickListener() { // from class: fd.c
            public /* synthetic */ c() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreItemPopupWindow.o(ReadingMoreItemPopupWindow.this, view);
            }
        });
        inflate.findViewById(R.id.ll_book_detail).setOnClickListener(new View.OnClickListener() { // from class: fd.d
            public /* synthetic */ d() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreItemPopupWindow.p(ReadingMoreItemPopupWindow.this, view);
            }
        });
        inflate.findViewById(R.id.ll_book_report).setOnClickListener(new View.OnClickListener() { // from class: fd.e
            public /* synthetic */ e() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingMoreItemPopupWindow.q(ReadingMoreItemPopupWindow.this, view);
            }
        });
    }
}
