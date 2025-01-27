package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libmars.fragment.ProgressDialogFragment;
import com.martian.libmars.ui.theme.ThemeEditText;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.libmars.widget.FoldedTextView;
import com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment;
import com.martian.mibook.R;
import com.martian.mibook.activity.book.CoverSwitchActivity;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookShelfBatchBottomViewBinding;
import com.martian.mibook.databinding.BookShelfBatchTopViewBinding;
import com.martian.mibook.databinding.BookrackSearchBinding;
import com.martian.mibook.databinding.BookrackTagsBinding;
import com.martian.mibook.databinding.FragmentBookShelfBinding;
import com.martian.mibook.databinding.FragmentBookShelfCategoryBinding;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.lib.model.data.BookrackCategoryManager;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.model.manager.BookManager;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfCategoryAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.BookShelfTagsAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import je.i;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import l9.i0;
import l9.m0;
import l9.t0;
import sf.g;
import xi.k;
import xi.l;
import ya.j2;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b$\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 x2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001yB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001b\u0010\u001d\u001a\u00020\u00062\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0019\u0010\u001f\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b\u001f\u0010\u001eJ\u0017\u0010 \u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u000fH\u0002¢\u0006\u0004\b \u0010\u001aJ\u000f\u0010!\u001a\u00020\u0006H\u0002¢\u0006\u0004\b!\u0010\u0005J\u000f\u0010\"\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\"\u0010\u0005J\u0017\u0010$\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0013H\u0002¢\u0006\u0004\b$\u0010\u0016J\u000f\u0010%\u001a\u00020\u0006H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0006H\u0002¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0006H\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0006H\u0002¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0006H\u0002¢\u0006\u0004\b)\u0010\u0005J\u000f\u0010*\u001a\u00020\u0006H\u0002¢\u0006\u0004\b*\u0010\u0005J\u000f\u0010+\u001a\u00020\u0006H\u0003¢\u0006\u0004\b+\u0010\u0005J\u0017\u0010-\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\u0013H\u0002¢\u0006\u0004\b-\u0010\u0016J\u000f\u0010.\u001a\u00020\u0006H\u0002¢\u0006\u0004\b.\u0010\u0005J\u000f\u0010/\u001a\u00020\u0006H\u0003¢\u0006\u0004\b/\u0010\u0005J\u000f\u00100\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u0010\u0005J\u0019\u00101\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b1\u0010\u001eJ\u0017\u00103\u001a\u00020\u00132\u0006\u00102\u001a\u00020\u0013H\u0002¢\u0006\u0004\b3\u00104J#\u00107\u001a\u00020\u00062\u0006\u00105\u001a\u00020\u00132\n\b\u0002\u00106\u001a\u0004\u0018\u00010\u001bH\u0002¢\u0006\u0004\b7\u00108J\u001f\u0010:\u001a\u00020\u00062\u0006\u00109\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0002¢\u0006\u0004\b:\u0010;J\u000f\u0010<\u001a\u00020\u0006H\u0002¢\u0006\u0004\b<\u0010\u0005J\u000f\u0010=\u001a\u00020\u0006H\u0002¢\u0006\u0004\b=\u0010\u0005J\u000f\u0010>\u001a\u00020\u0006H\u0002¢\u0006\u0004\b>\u0010\u0005J\u000f\u0010?\u001a\u00020\u0006H\u0002¢\u0006\u0004\b?\u0010\u0005J\u0015\u0010A\u001a\b\u0012\u0004\u0012\u00020\u000f0@H\u0002¢\u0006\u0004\bA\u0010BJ\u000f\u0010C\u001a\u00020\u0006H\u0016¢\u0006\u0004\bC\u0010\u0005J\u0019\u0010F\u001a\u00020\u00062\b\u0010E\u001a\u0004\u0018\u00010DH\u0016¢\u0006\u0004\bF\u0010GJ\u000f\u0010H\u001a\u00020\u0006H\u0016¢\u0006\u0004\bH\u0010\u0005J\u000f\u0010I\u001a\u00020\u0006H\u0016¢\u0006\u0004\bI\u0010\u0005J\u000f\u0010J\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010\u0005J\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010\u0005R\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bH\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u001e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010XR\u0018\u0010\\\u001a\u0004\u0018\u00010Y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bZ\u0010[R\u0018\u0010`\u001a\u0004\u0018\u00010]8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b^\u0010_R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bF\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bc\u0010dR\u0016\u0010g\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010aR\u0018\u0010k\u001a\u0004\u0018\u00010h8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bi\u0010jR\u0018\u0010o\u001a\u0004\u0018\u00010l8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010nR\u0016\u0010q\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010aR\u0018\u0010u\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bs\u0010tR\u0016\u0010w\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010a¨\u0006z"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/BookShelfFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentBookShelfBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "<init>", "()V", "", "u1", "r1", "o1", "X0", "K1", "q1", "D1", "", "Lcom/martian/mibook/lib/model/data/BookWrapper;", "bookWrappers", "C1", "(Ljava/util/List;)V", "", "refreshContent", "e1", "(Z)V", r3.c.f30241d, "bookWrapper", "U1", "(Lcom/martian/mibook/lib/model/data/BookWrapper;)V", "", "category", "Y1", "(Ljava/lang/String;)V", "J1", "S1", "Z0", "T1", com.umeng.ccg.a.f24245v, "X1", "h1", "z1", "x1", "w1", "y1", "W1", "V1", "selectAll", "b2", "F1", "M1", "O1", "c1", "handle", "f1", "(Z)Z", "loading", "msg", "Q1", "(ZLjava/lang/String;)V", "showMsg", "A1", "(Ljava/lang/String;Ljava/lang/String;)V", "B1", "g1", "W0", "a2", "", "p1", "()Ljava/util/List;", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "onResume", "onStop", "onDestroyView", "Le9/c;", "Le9/c;", "rxManager", "Lcom/martian/mibook/databinding/BookrackSearchBinding;", t.f11204d, "Lcom/martian/mibook/databinding/BookrackSearchBinding;", "searchBinding", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "m", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfAdapter;", "bookShelfAdapter", "n", "Ljava/util/List;", "Lcom/martian/mibook/databinding/BookrackTagsBinding;", "o", "Lcom/martian/mibook/databinding/BookrackTagsBinding;", "bookShelfTagsBinding", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter;", "p", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookShelfTagsAdapter;", "bookShelfTagsAdapter", "Z", "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", t.f11211k, "Lcom/martian/libmars/widget/dialog/MartianBottomSheetDialogFragment;", "categoryDialogFragment", "s", "secretCategoryEnabled", "Lcom/martian/mibook/databinding/BookShelfBatchBottomViewBinding;", bt.aO, "Lcom/martian/mibook/databinding/BookShelfBatchBottomViewBinding;", "batchBottomBinding", "Lcom/martian/mibook/databinding/BookShelfBatchTopViewBinding;", "u", "Lcom/martian/mibook/databinding/BookShelfBatchTopViewBinding;", "batchTopBinding", "v", "isProcessing", "Lcom/martian/libmars/fragment/ProgressDialogFragment;", IAdInterListener.AdReqParam.WIDTH, "Lcom/martian/libmars/fragment/ProgressDialogFragment;", "loadingDialog", "x", "isFlagTop", "y", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookShelfFragment extends BaseMVVMFragment<FragmentBookShelfBinding, BookShelfViewModel> {

    /* renamed from: y, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public e9.c rxManager;

    /* renamed from: l */
    @l
    public BookrackSearchBinding searchBinding;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public BookShelfAdapter bookShelfAdapter;

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public List<BookWrapper> bookWrappers;

    /* renamed from: o, reason: from kotlin metadata */
    @l
    public BookrackTagsBinding bookShelfTagsBinding;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public BookShelfTagsAdapter bookShelfTagsAdapter;

    /* renamed from: q, reason: from kotlin metadata */
    public boolean refreshContent;

    /* renamed from: r */
    @l
    public MartianBottomSheetDialogFragment categoryDialogFragment;

    /* renamed from: s, reason: from kotlin metadata */
    public boolean secretCategoryEnabled;

    /* renamed from: t */
    @l
    public BookShelfBatchBottomViewBinding batchBottomBinding;

    /* renamed from: u, reason: from kotlin metadata */
    @l
    public BookShelfBatchTopViewBinding batchTopBinding;

    /* renamed from: v, reason: from kotlin metadata */
    public boolean isProcessing;

    /* renamed from: w */
    @l
    public ProgressDialogFragment loadingDialog;

    /* renamed from: x, reason: from kotlin metadata */
    public boolean isFlagTop = true;

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final BookShelfFragment a() {
            return new BookShelfFragment();
        }

        public Companion() {
        }
    }

    public static final class b implements BookShelfAdapter.b {
        public b() {
        }

        public static final void d(BookShelfFragment this$0, BookWrapper bookWrapper) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this$0.U1(bookWrapper);
            this$0.v1();
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.b
        public boolean a(@l View view, @l BookWrapper bookWrapper, int i10) {
            BookShelfAdapter bookShelfAdapter;
            if (bookWrapper != null && (((bookShelfAdapter = BookShelfFragment.this.bookShelfAdapter) == null || !bookShelfAdapter.getIsBatch()) && !bookWrapper.notBookItem())) {
                ac.a.x(BookShelfFragment.this.getContext(), "批量管理-长按");
                BookShelfFragment.this.X1(true);
                BookShelfAdapter bookShelfAdapter2 = BookShelfFragment.this.bookShelfAdapter;
                if (bookShelfAdapter2 != null) {
                    bookShelfAdapter2.r(bookWrapper, i10);
                }
                BookShelfFragment.this.V1();
            }
            return false;
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter.b
        public void b(@l View view, @l BookWrapper bookWrapper, int i10) {
            if (bookWrapper == null) {
                return;
            }
            BookShelfAdapter bookShelfAdapter = BookShelfFragment.this.bookShelfAdapter;
            if (bookShelfAdapter != null && bookShelfAdapter.getIsBatch()) {
                BookShelfAdapter bookShelfAdapter2 = BookShelfFragment.this.bookShelfAdapter;
                if (bookShelfAdapter2 != null) {
                    bookShelfAdapter2.r(bookWrapper, i10);
                }
                BookShelfFragment.this.V1();
                return;
            }
            if (!bookWrapper.isAdderItem()) {
                if (bookWrapper.isAdItem()) {
                    return;
                }
                MiConfigSingleton.b2().M1().L2(BookShelfFragment.this.getActivity(), bookWrapper, new MiBookManager.k0() { // from class: vd.g1

                    /* renamed from: b */
                    public final /* synthetic */ BookWrapper f31345b;

                    public /* synthetic */ g1(BookWrapper bookWrapper2) {
                        bookWrapper = bookWrapper2;
                    }

                    @Override // com.martian.mibook.application.MiBookManager.k0
                    public final void a() {
                        BookShelfFragment.b.d(BookShelfFragment.this, bookWrapper);
                    }
                });
                ac.a.K(BookShelfFragment.this.getContext(), MiConfigSingleton.b2().p() == 2 ? "女频书架" : "男频书架", "点击阅读");
                return;
            }
            ac.a.K(BookShelfFragment.this.getContext(), MiConfigSingleton.b2().p() == 2 ? "女频书架" : "男频书架", "点击添加");
            e9.c cVar = BookShelfFragment.this.rxManager;
            if (cVar != null) {
                cVar.d(j2.f33262c, Integer.valueOf(j2.f33272m));
            }
        }
    }

    public static final class c implements TextWatcher {
        public c() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(@k Editable s10) {
            Intrinsics.checkNotNullParameter(s10, "s");
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(@k CharSequence s10, int i10, int i11, int i12) {
            Intrinsics.checkNotNullParameter(s10, "s");
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(@k CharSequence s10, int i10, int i11, int i12) {
            Intrinsics.checkNotNullParameter(s10, "s");
            BookShelfAdapter bookShelfAdapter = BookShelfFragment.this.bookShelfAdapter;
            if (bookShelfAdapter != null) {
                bookShelfAdapter.x(s10.toString());
            }
        }
    }

    public static final class d implements MartianBottomSheetDialogFragment.b {
        @Override // com.martian.libmars.widget.dialog.MartianBottomSheetDialogFragment.b
        public void a(@k DialogFragment dialogFragment) {
            Intrinsics.checkNotNullParameter(dialogFragment, "dialogFragment");
            boolean A0 = MiConfigSingleton.b2().A0();
            com.gyf.immersionbar.d.y3(dialogFragment).T2(!A0).G1(!A0).v1(ConfigSingleton.D().L(), 0.0f).a1();
        }
    }

    public static final class e implements MiBookManager.b0 {
        public e() {
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void a(@k x8.c errorResult) {
            Intrinsics.checkNotNullParameter(errorResult, "errorResult");
            t0.b(BookShelfFragment.this.getContext(), "同步出错：" + ExtKt.c(errorResult.d()));
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void b() {
            t0.b(BookShelfFragment.this.getContext(), BookShelfFragment.this.getString(R.string.sync_success));
            BookShelfFragment.this.Y1(BookrackCategoryManager.ALL_BOOK_CATEGORY);
            BookShelfFragment.this.v1();
        }

        @Override // com.martian.mibook.application.MiBookManager.b0
        public void onLoading(boolean z10) {
            BookShelfFragment bookShelfFragment = BookShelfFragment.this;
            bookShelfFragment.Q1(z10, bookShelfFragment.getString(R.string.book_shelf_sync) + FoldedTextView.f12585y);
        }
    }

    public static final class f implements BookShelfTagsAdapter.a {
        public f() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfTagsAdapter.a
        public void a(@l String str) {
            if (StringsKt.equals(BookrackCategoryManager.SECRETE_CATEGORY, str, true)) {
                BookShelfFragment.this.secretCategoryEnabled = true;
            }
            BookShelfFragment.this.J1(str);
        }
    }

    private final void D1() {
        I().q().observe(this, new Observer() { // from class: vd.b1
            public /* synthetic */ b1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookShelfFragment.E1(Function1.this, obj);
            }
        });
    }

    public static final void E1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentBookShelfBinding F0(BookShelfFragment bookShelfFragment) {
        return (FragmentBookShelfBinding) bookShelfFragment.n();
    }

    public static final void G1(BookShelfFragment this$0, boolean z10, boolean z11) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.bookShelfAdapter != null) {
            this$0.Q1(true, this$0.getString(R.string.deleting));
            MiConfigSingleton.b2().M1().p(new BookManager.d() { // from class: vd.p0
                public /* synthetic */ p0() {
                }

                @Override // com.martian.mibook.lib.model.manager.BookManager.d
                public final void a() {
                    BookShelfFragment.H1(BookShelfFragment.this);
                }
            });
            if (z10 && z11) {
                i0.z0(this$0.getActivity(), this$0.getString(R.string.confirm_message), this$0.getString(R.string.turn_off_book_recommend_tips), new i0.l() { // from class: vd.q0
                    public /* synthetic */ q0() {
                    }

                    @Override // l9.i0.l
                    public final void a() {
                        BookShelfFragment.I1(BookShelfFragment.this);
                    }
                });
            }
        }
    }

    public static final void H1(BookShelfFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        String string = this$0.getString(R.string.delete_successful);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String ALL_BOOK_CATEGORY = BookrackCategoryManager.ALL_BOOK_CATEGORY;
        Intrinsics.checkNotNullExpressionValue(ALL_BOOK_CATEGORY, "ALL_BOOK_CATEGORY");
        this$0.A1(string, ALL_BOOK_CATEGORY);
    }

    public static final void I1(BookShelfFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().M1().D2(this$0.getContext(), true);
    }

    public static final void L1(BookShelfFragment this$0, View view) {
        ThemeEditText themeEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ac.a.x(this$0.getContext(), "清空关键字");
        BookrackSearchBinding bookrackSearchBinding = this$0.searchBinding;
        if (bookrackSearchBinding != null && (themeEditText = bookrackSearchBinding.etSearch) != null) {
            themeEditText.setText("");
        }
        BookrackSearchBinding bookrackSearchBinding2 = this$0.searchBinding;
        ThemeLinearLayout themeLinearLayout = bookrackSearchBinding2 != null ? bookrackSearchBinding2.brSearch : null;
        if (themeLinearLayout != null) {
            themeLinearLayout.setVisibility(8);
        }
        FragmentActivity activity = this$0.getActivity();
        BookrackSearchBinding bookrackSearchBinding3 = this$0.searchBinding;
        i.n(activity, bookrackSearchBinding3 != null ? bookrackSearchBinding3.etSearch : null);
    }

    public static final void N1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this$0.categoryDialogFragment;
        if (martianBottomSheetDialogFragment != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
    }

    public static final void P1(BookShelfFragment this$0, String category) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(category, "category");
        if (ba.l.q(category)) {
            t0.b(this$0.getContext(), this$0.getString(R.string.enter_custom_group_name));
        } else {
            this$0.c1(category);
        }
    }

    public final void Q1(boolean loading, String msg) {
        this.isProcessing = loading;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            if (activity == null || !activity.isDestroyed()) {
                if (this.loadingDialog == null) {
                    this.loadingDialog = new ProgressDialogFragment();
                }
                ProgressDialogFragment progressDialogFragment = this.loadingDialog;
                if (progressDialogFragment != null) {
                    progressDialogFragment.k(msg);
                }
                if (!loading) {
                    ProgressDialogFragment progressDialogFragment2 = this.loadingDialog;
                    if (progressDialogFragment2 != null) {
                        progressDialogFragment2.dismiss();
                        return;
                    }
                    return;
                }
                ProgressDialogFragment progressDialogFragment3 = this.loadingDialog;
                if (progressDialogFragment3 != null) {
                    FragmentManager supportFragmentManager = requireActivity().getSupportFragmentManager();
                    Intrinsics.checkNotNullExpressionValue(supportFragmentManager, "getSupportFragmentManager(...)");
                    progressDialogFragment3.l(supportFragmentManager);
                }
            }
        }
    }

    public static /* synthetic */ void R1(BookShelfFragment bookShelfFragment, boolean z10, String str, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str = null;
        }
        bookShelfFragment.Q1(z10, str);
    }

    private final void X0() {
        if (this.rxManager == null) {
            this.rxManager = new e9.c();
        }
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.c(j2.f33277r, new wj.b() { // from class: vd.z0
                public /* synthetic */ z0() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    BookShelfFragment.Y0(BookShelfFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void Y0(BookShelfFragment this$0, Integer num) {
        ThemeEditText themeEditText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        if (intValue == j2.f33278s) {
            BookrackSearchBinding bookrackSearchBinding = this$0.searchBinding;
            if (bookrackSearchBinding == null || (themeEditText = bookrackSearchBinding.etSearch) == null) {
                return;
            }
            i.n(this$0.getActivity(), themeEditText);
            return;
        }
        if (intValue == j2.f33279t) {
            this$0.q1();
            return;
        }
        if (intValue == j2.f33280u) {
            this$0.K1();
            return;
        }
        if (intValue == j2.f33281v) {
            this$0.Z0();
            return;
        }
        if (intValue == j2.f33282w) {
            this$0.X1(true);
            return;
        }
        if (intValue == j2.f33283x) {
            this$0.X1(false);
        } else if (intValue == j2.f33276q) {
            ((FragmentBookShelfBinding) this$0.n()).rvBookShelf.smoothScrollToPosition(0);
        } else if (intValue == j2.f33284y) {
            this$0.v1();
        }
    }

    public static /* synthetic */ void Z1(BookShelfFragment bookShelfFragment, String str, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            BookShelfTagsAdapter bookShelfTagsAdapter = bookShelfFragment.bookShelfTagsAdapter;
            str = bookShelfTagsAdapter != null ? bookShelfTagsAdapter.n() : null;
        }
        bookShelfFragment.Y1(str);
    }

    public static final void a1(BookShelfFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.T1();
    }

    public static final void b1() {
    }

    public static final void d1(BookShelfFragment this$0, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().M1().E2(this$0.getActivity());
        String c10 = ExtKt.c("成功将选中的");
        BookShelfAdapter bookShelfAdapter = this$0.bookShelfAdapter;
        Integer valueOf = bookShelfAdapter != null ? Integer.valueOf(bookShelfAdapter.getSelectNumber()) : null;
        String str2 = c10 + valueOf + ExtKt.c("本小说分类至\"") + str + "\"中";
        Intrinsics.checkNotNull(str);
        this$0.A1(str2, str);
    }

    public static final void i1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.z1();
    }

    public static final void j1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.x1();
    }

    public static final void k1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y1();
    }

    public static final void l1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.w1();
    }

    public static final void m1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<BookWrapper> p12 = this$0.p1();
        if (p12.isEmpty()) {
            t0.b(this$0.getContext(), this$0.getString(R.string.no_actionable_books));
            return;
        }
        if (p12.size() > 1) {
            t0.b(this$0.getContext(), this$0.getString(R.string.only_supports_single_book_details));
            return;
        }
        BookWrapper bookWrapper = p12.get(0);
        Book book = bookWrapper.book;
        if (book == null || !book.isLocal()) {
            i.E(this$0.getActivity(), bookWrapper.book);
        } else {
            this$0.S1(bookWrapper);
        }
    }

    public static final void n1(BookShelfFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.X1(false);
    }

    private final void o1() {
        e1(true);
    }

    public static final void s1(BookShelfFragment this$0, pf.f it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(it, "it");
        this$0.o1();
    }

    public static final void t1(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final synchronized void v1() {
        try {
            BookShelfTagsAdapter bookShelfTagsAdapter = this.bookShelfTagsAdapter;
            if (bookShelfTagsAdapter != null) {
                J1(bookShelfTagsAdapter != null ? bookShelfTagsAdapter.n() : null);
            } else {
                BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
                if (bookShelfAdapter != null && bookShelfAdapter != null) {
                    bookShelfAdapter.B();
                }
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public final void A1(String showMsg, String category) {
        Q1(false, "");
        t0.b(getContext(), showMsg);
        Y1(category);
        B1();
        v1();
    }

    public final void B1() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getIO(), null, new BookShelfFragment$quitBookShelfBatchMode$1(this, null), 2, null);
    }

    public final void C1(List<BookWrapper> bookWrappers) {
        this.bookWrappers = bookWrappers;
        q1();
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        if (bookShelfAdapter != null) {
            bookShelfAdapter.m();
        }
        e1(false);
        Y1(BookrackCategoryManager.ALL_BOOK_CATEGORY);
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x000b, code lost:
    
        if (r0.q() == true) goto L49;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void F1() {
        /*
            r8 = this;
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r0 = r8.bookShelfAdapter
            if (r0 == 0) goto Le
            if (r0 == 0) goto Le
            boolean r0 = r0.q()
            r1 = 1
            if (r0 != r1) goto Le
            goto Lf
        Le:
            r1 = 0
        Lf:
            androidx.fragment.app.FragmentActivity r2 = r8.getActivity()
            int r0 = com.martian.mibook.R.string.delete_hint
            java.lang.String r3 = r8.getString(r0)
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r0 = r8.bookShelfAdapter
            if (r0 == 0) goto L26
            int r0 = r0.getSelectNumber()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L27
        L26:
            r0 = 0
        L27:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "是否删除选中的"
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = "本小说?"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            java.lang.String r4 = com.martian.mibook.mvvm.extensions.ExtKt.c(r0)
            if (r1 == 0) goto L4b
            int r0 = com.martian.mibook.R.string.no_accepting_bookshelf_book_recommend
        L45:
            java.lang.String r0 = r8.getString(r0)
            r5 = r0
            goto L4e
        L4b:
            int r0 = com.martian.mibook.R.string.clear_book_cache
            goto L45
        L4e:
            r6 = r1 ^ 1
            vd.x0 r7 = new vd.x0
            r7.<init>()
            l9.i0.A0(r2, r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment.F1():void");
    }

    public final void J1(String category) {
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        if (bookShelfAdapter == null || bookShelfAdapter == null) {
            return;
        }
        bookShelfAdapter.y(category);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void K1() {
        ThemeEditText themeEditText;
        ThemeImageView themeImageView;
        if (this.searchBinding == null) {
            ((FragmentBookShelfBinding) n()).bookShelfSearch.setLayoutResource(R.layout.bookrack_search);
            BookrackSearchBinding bind = BookrackSearchBinding.bind(((FragmentBookShelfBinding) n()).bookShelfSearch.inflate());
            this.searchBinding = bind;
            if (bind != null && (themeImageView = bind.btnClearSearchText) != null) {
                themeImageView.setOnClickListener(new View.OnClickListener() { // from class: vd.e1
                    public /* synthetic */ e1() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.L1(BookShelfFragment.this, view);
                    }
                });
            }
            BookrackSearchBinding bookrackSearchBinding = this.searchBinding;
            if (bookrackSearchBinding != null && (themeEditText = bookrackSearchBinding.etSearch) != null) {
                themeEditText.addTextChangedListener(new c());
            }
        }
        BookrackSearchBinding bookrackSearchBinding2 = this.searchBinding;
        ThemeLinearLayout root = bookrackSearchBinding2 != null ? bookrackSearchBinding2.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(0);
    }

    @SuppressLint({"ClickableViewAccessibility", "InflateParams"})
    public final void M1() {
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment;
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment2 = this.categoryDialogFragment;
        if (martianBottomSheetDialogFragment2 != null && martianBottomSheetDialogFragment2 != null && martianBottomSheetDialogFragment2.isVisible() && (martianBottomSheetDialogFragment = this.categoryDialogFragment) != null) {
            martianBottomSheetDialogFragment.dismiss();
        }
        List<BookShelfCategoryAdapter.a> n10 = I().n();
        if (n10.isEmpty()) {
            O1();
            return;
        }
        com.martian.libmars.widget.dialog.a a10 = MartianBottomSheetDialogFragment.INSTANCE.a();
        View inflate = getLayoutInflater().inflate(R.layout.fragment_book_shelf_category, (ViewGroup) null);
        FragmentBookShelfCategoryBinding bind = FragmentBookShelfCategoryBinding.bind(inflate);
        Intrinsics.checkNotNullExpressionValue(bind, "bind(...)");
        bind.rvBookShelfCategory.setLayoutManager(new LinearLayoutManager(getContext()));
        BookShelfCategoryAdapter bookShelfCategoryAdapter = new BookShelfCategoryAdapter();
        bookShelfCategoryAdapter.l(n10);
        bookShelfCategoryAdapter.m(new BookShelfCategoryAdapter.b() { // from class: com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment$showCategoryDialog$1
            public BookShelfFragment$showCategoryDialog$1() {
            }

            @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfCategoryAdapter.b
            public void a(@l View view, @l BookShelfCategoryAdapter.a aVar, int i10) {
                MartianBottomSheetDialogFragment martianBottomSheetDialogFragment3;
                String e10 = aVar != null ? aVar.e() : null;
                if (StringsKt.equals(BookrackCategoryManager.SECRETE_CATEGORY, e10, true) && aVar != null && aVar.f() == 0 && !MiConfigSingleton.b2().K2()) {
                    i.d0(BookShelfFragment.this.getActivity(), "私密分类");
                    return;
                }
                BookShelfFragment.this.c1(e10);
                martianBottomSheetDialogFragment3 = BookShelfFragment.this.categoryDialogFragment;
                if (martianBottomSheetDialogFragment3 != null) {
                    martianBottomSheetDialogFragment3.dismiss();
                }
            }

            @Override // com.martian.mibook.mvvm.yuewen.adapter.BookShelfCategoryAdapter.b
            public void b() {
                MartianBottomSheetDialogFragment martianBottomSheetDialogFragment3;
                martianBottomSheetDialogFragment3 = BookShelfFragment.this.categoryDialogFragment;
                if (martianBottomSheetDialogFragment3 != null) {
                    martianBottomSheetDialogFragment3.dismiss();
                }
                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(BookShelfFragment.this), Dispatchers.getIO(), null, new BookShelfFragment$showCategoryDialog$1$onNewCreate$1(BookShelfFragment.this, null), 2, null);
            }
        });
        bind.ivWindowClose.setOnClickListener(new View.OnClickListener() { // from class: vd.a1
            public /* synthetic */ a1() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookShelfFragment.N1(BookShelfFragment.this, view);
            }
        });
        bind.rvBookShelfCategory.setAdapter(bookShelfCategoryAdapter);
        this.categoryDialogFragment = com.martian.libmars.widget.dialog.a.e0(a10.y0(inflate).k0(true).j0(true).w0(true).n0(ConfigSingleton.i(370.0f)).s0(new d()), this, null, "fragment_book_shelf_category", true, 2, null);
    }

    public final void O1() {
        i0.D0(getActivity(), getString(R.string.bookrack_create_group), getString(R.string.input_ud_tag_name), false, false, new i0.j() { // from class: vd.y0
            public /* synthetic */ y0() {
            }

            @Override // l9.i0.j
            public final void a(String str) {
                BookShelfFragment.P1(BookShelfFragment.this, str);
            }
        });
    }

    public final void S1(BookWrapper bookWrapper) {
        CoverSwitchActivity.q3(getActivity(), bookWrapper);
    }

    public final void T1() {
        MiConfigSingleton.b2().M1().N2(getActivity(), new e());
    }

    public final void U1(BookWrapper bookWrapper) {
        if (!bookWrapper.txtChapterLoading || bookWrapper.book == null) {
            return;
        }
        MiConfigSingleton.b2().P1().i(bookWrapper.book);
    }

    @SuppressLint({"SetTextI18n"})
    public final void V1() {
        String str;
        W1();
        a2();
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        int selectNumber = bookShelfAdapter != null ? bookShelfAdapter.getSelectNumber() : 0;
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding = this.batchBottomBinding;
        TextView textView = bookShelfBatchBottomViewBinding != null ? bookShelfBatchBottomViewBinding.bpDelete : null;
        if (textView != null) {
            String string = getString(R.string.cd_delete);
            if (selectNumber > 0) {
                str = "(" + selectNumber + ")";
            } else {
                str = "";
            }
            textView.setText(string + str);
        }
        BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding = this.batchTopBinding;
        ThemeTextView themeTextView = bookShelfBatchTopViewBinding != null ? bookShelfBatchTopViewBinding.bpTitle : null;
        if (themeTextView != null) {
            themeTextView.setText(ExtKt.c("已选择" + selectNumber + "本书"));
        }
        BookShelfAdapter bookShelfAdapter2 = this.bookShelfAdapter;
        b2(selectNumber >= (bookShelfAdapter2 != null ? bookShelfAdapter2.n() : 0));
    }

    public final void W0() {
        ac.a.x(getActivity(), this.isFlagTop ? "置顶" : "取消置顶");
        MiConfigSingleton.b2().M1().s0(p1(), this.isFlagTop);
        v1();
        B1();
    }

    public final void W1() {
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        boolean z10 = false;
        boolean z11 = (bookShelfAdapter != null ? bookShelfAdapter.getSelectNumber() : 0) > 0;
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding = this.batchBottomBinding;
        ThemeLinearLayout themeLinearLayout = bookShelfBatchBottomViewBinding != null ? bookShelfBatchBottomViewBinding.bpFlagTopView : null;
        if (themeLinearLayout != null) {
            themeLinearLayout.setAlpha(z11 ? 1.0f : 0.6f);
        }
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding2 = this.batchBottomBinding;
        ThemeLinearLayout themeLinearLayout2 = bookShelfBatchBottomViewBinding2 != null ? bookShelfBatchBottomViewBinding2.bpCategoryView : null;
        if (themeLinearLayout2 != null) {
            themeLinearLayout2.setAlpha(z11 ? 1.0f : 0.6f);
        }
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding3 = this.batchBottomBinding;
        ThemeLinearLayout themeLinearLayout3 = bookShelfBatchBottomViewBinding3 != null ? bookShelfBatchBottomViewBinding3.bpDeleteView : null;
        if (themeLinearLayout3 != null) {
            themeLinearLayout3.setAlpha(z11 ? 1.0f : 0.6f);
        }
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding4 = this.batchBottomBinding;
        ThemeLinearLayout themeLinearLayout4 = bookShelfBatchBottomViewBinding4 != null ? bookShelfBatchBottomViewBinding4.batchDetailView : null;
        if (themeLinearLayout4 == null) {
            return;
        }
        BookShelfAdapter bookShelfAdapter2 = this.bookShelfAdapter;
        if (bookShelfAdapter2 != null && bookShelfAdapter2.getSelectNumber() == 1) {
            z10 = true;
        }
        themeLinearLayout4.setAlpha(z10 ? 1.0f : 0.6f);
    }

    public final void X1(boolean r62) {
        BookShelfTagsAdapter bookShelfTagsAdapter;
        int i10;
        if (!r62 || f1(false)) {
            e9.c cVar = this.rxManager;
            if (cVar != null) {
                cVar.d(j2.f33266g, Integer.valueOf(r62 ? j2.f33282w : 0));
            }
            BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
            if (bookShelfAdapter != null) {
                bookShelfAdapter.w(r62);
            }
            e0(!r62);
            if (r62) {
                h1();
            }
            BookrackSearchBinding bookrackSearchBinding = this.searchBinding;
            if (bookrackSearchBinding != null) {
                Intrinsics.checkNotNull(bookrackSearchBinding);
                ThemeLinearLayout themeLinearLayout = bookrackSearchBinding.brSearch;
                if (!r62) {
                    BookrackSearchBinding bookrackSearchBinding2 = this.searchBinding;
                    Intrinsics.checkNotNull(bookrackSearchBinding2);
                    if (!ba.l.q(bookrackSearchBinding2.etSearch.getText().toString())) {
                        i10 = 0;
                        themeLinearLayout.setVisibility(i10);
                    }
                }
                i10 = 8;
                themeLinearLayout.setVisibility(i10);
            }
            if (this.bookShelfTagsBinding != null && (bookShelfTagsAdapter = this.bookShelfTagsAdapter) != null) {
                if ((bookShelfTagsAdapter != null ? bookShelfTagsAdapter.getPageSize() : 0) > 0) {
                    Context context = getContext();
                    BookrackTagsBinding bookrackTagsBinding = this.bookShelfTagsBinding;
                    l9.a.a(context, bookrackTagsBinding != null ? bookrackTagsBinding.getRoot() : null, !r62, l9.a.f27956b);
                }
            }
            Context context2 = getContext();
            BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding = this.batchTopBinding;
            l9.a.a(context2, bookShelfBatchTopViewBinding != null ? bookShelfBatchTopViewBinding.getRoot() : null, r62, l9.a.f27956b);
            Context context3 = getContext();
            BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding = this.batchBottomBinding;
            l9.a.a(context3, bookShelfBatchBottomViewBinding != null ? bookShelfBatchBottomViewBinding.getRoot() : null, r62, l9.a.f27955a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void Y1(String category) {
        RecyclerView root;
        RecyclerView recyclerView;
        if (m0.c(getContext()) || !MiConfigSingleton.b2().M1().I1(getContext())) {
            return;
        }
        List<String> bookCategories = MiConfigSingleton.b2().M1().T().r().getBookCategories();
        Intrinsics.checkNotNullExpressionValue(bookCategories, "getBookCategories(...)");
        if (bookCategories.isEmpty() || bookCategories.size() == 1) {
            BookShelfTagsAdapter bookShelfTagsAdapter = this.bookShelfTagsAdapter;
            if (bookShelfTagsAdapter != null) {
                bookShelfTagsAdapter.t(new ArrayList(), "");
            }
            BookrackTagsBinding bookrackTagsBinding = this.bookShelfTagsBinding;
            root = bookrackTagsBinding != null ? bookrackTagsBinding.getRoot() : null;
            if (root == null) {
                return;
            }
            root.setVisibility(8);
            return;
        }
        if (this.bookShelfTagsBinding == null) {
            ((FragmentBookShelfBinding) n()).bookShelfCategories.setLayoutResource(R.layout.bookrack_tags);
            BookrackTagsBinding bind = BookrackTagsBinding.bind(((FragmentBookShelfBinding) n()).bookShelfCategories.inflate());
            this.bookShelfTagsBinding = bind;
            RecyclerView recyclerView2 = bind != null ? bind.bookrackCategoryIrc : null;
            if (recyclerView2 != null) {
                recyclerView2.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            }
        }
        BookrackTagsBinding bookrackTagsBinding2 = this.bookShelfTagsBinding;
        RecyclerView root2 = bookrackTagsBinding2 != null ? bookrackTagsBinding2.getRoot() : null;
        if (root2 != null) {
            root2.setVisibility(0);
        }
        if (!Intrinsics.areEqual(bookCategories.get(0), BookrackCategoryManager.ALL_BOOK_CATEGORY)) {
            String ALL_BOOK_CATEGORY = BookrackCategoryManager.ALL_BOOK_CATEGORY;
            Intrinsics.checkNotNullExpressionValue(ALL_BOOK_CATEGORY, "ALL_BOOK_CATEGORY");
            bookCategories.add(0, ALL_BOOK_CATEGORY);
        }
        if (this.bookShelfTagsAdapter == null) {
            BookShelfTagsAdapter bookShelfTagsAdapter2 = new BookShelfTagsAdapter(getActivity(), bookCategories, this.secretCategoryEnabled);
            this.bookShelfTagsAdapter = bookShelfTagsAdapter2;
            bookShelfTagsAdapter2.u(new f());
            BookrackTagsBinding bookrackTagsBinding3 = this.bookShelfTagsBinding;
            root = bookrackTagsBinding3 != null ? bookrackTagsBinding3.bookrackCategoryIrc : null;
            if (root != null) {
                root.setAdapter(this.bookShelfTagsAdapter);
            }
        }
        BookShelfTagsAdapter bookShelfTagsAdapter3 = this.bookShelfTagsAdapter;
        if (bookShelfTagsAdapter3 != null) {
            bookShelfTagsAdapter3.t(bookCategories, category);
        }
        BookrackTagsBinding bookrackTagsBinding4 = this.bookShelfTagsBinding;
        if (bookrackTagsBinding4 == null || (recyclerView = bookrackTagsBinding4.bookrackCategoryIrc) == null) {
            return;
        }
        BookShelfTagsAdapter bookShelfTagsAdapter4 = this.bookShelfTagsAdapter;
        recyclerView.scrollToPosition(bookShelfTagsAdapter4 != null ? bookShelfTagsAdapter4.getSelectedPosition() : -1);
    }

    public final void Z0() {
        if (MiConfigSingleton.b2().G1().i(getActivity())) {
            i0.x0(getActivity(), getResources().getString(R.string.cloud_sync), getString(R.string.is_cloud_sync), getResources().getString(R.string.search_close), getResources().getString(R.string.confirm), true, new i0.l() { // from class: vd.c1
                public /* synthetic */ c1() {
                }

                @Override // l9.i0.l
                public final void a() {
                    BookShelfFragment.a1(BookShelfFragment.this);
                }
            }, new i0.k() { // from class: vd.d1
                @Override // l9.i0.k
                public final void a() {
                    BookShelfFragment.b1();
                }
            });
        }
    }

    public final void a2() {
        List<BookWrapper> p12 = p1();
        if (!p12.isEmpty()) {
            Iterator<BookWrapper> it = p12.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                MiBookStoreItem miBookStoreItem = it.next().item;
                if (miBookStoreItem != null && !miBookStoreItem.isFlagTop()) {
                    this.isFlagTop = true;
                    break;
                }
                this.isFlagTop = false;
            }
        } else {
            this.isFlagTop = true;
        }
        BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding = this.batchBottomBinding;
        ThemeTextView themeTextView = bookShelfBatchBottomViewBinding != null ? bookShelfBatchBottomViewBinding.bpFlagTop : null;
        if (themeTextView == null) {
            return;
        }
        themeTextView.setText(getString(this.isFlagTop ? R.string.book_top : R.string.book_cancel_top));
    }

    public final void b2(boolean selectAll) {
        BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding = this.batchTopBinding;
        ThemeTextView themeTextView = bookShelfBatchTopViewBinding != null ? bookShelfBatchTopViewBinding.bpSelectAll : null;
        if (themeTextView == null) {
            return;
        }
        themeTextView.setText(getString(selectAll ? R.string.cancel_select_all : R.string.select_all));
    }

    public final void c1(String category) {
        if (this.bookShelfAdapter == null || TextUtils.isEmpty(category)) {
            return;
        }
        Q1(true, getString(R.string.batch_classification));
        MiConfigSingleton.b2().M1().o(category, new BookManager.d() { // from class: vd.o0

            /* renamed from: b */
            public final /* synthetic */ String f31396b;

            public /* synthetic */ o0(String category2) {
                category = category2;
            }

            @Override // com.martian.mibook.lib.model.manager.BookManager.d
            public final void a() {
                BookShelfFragment.d1(BookShelfFragment.this, category);
            }
        });
    }

    public final void e1(boolean refreshContent) {
        this.refreshContent = refreshContent;
        BookShelfViewModel I = I();
        String s10 = MiConfigSingleton.b2().M1().T().s();
        Intrinsics.checkNotNullExpressionValue(s10, "getCheckUpdateSourceStrings(...)");
        I.p(s10);
    }

    public final boolean f1(boolean handle) {
        if (this.isProcessing) {
            t0.b(getContext(), getString(R.string.processing_please_wait));
            return false;
        }
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        if (bookShelfAdapter != null) {
            if ((bookShelfAdapter != null ? bookShelfAdapter.n() : 0) > 0) {
                if (!handle) {
                    return true;
                }
                BookShelfAdapter bookShelfAdapter2 = this.bookShelfAdapter;
                if ((bookShelfAdapter2 != null ? bookShelfAdapter2.getSelectNumber() : 0) > 0) {
                    return true;
                }
                t0.b(getContext(), getString(R.string.none_actionable_books));
                return false;
            }
        }
        t0.b(getContext(), getString(R.string.none_actionable_books));
        return false;
    }

    public final void g1() {
        BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
        if (bookShelfAdapter != null) {
            bookShelfAdapter.k();
        }
        V1();
    }

    public final void h1() {
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        ThemeLinearLayout themeLinearLayout3;
        ThemeLinearLayout themeLinearLayout4;
        ThemeTextView themeTextView;
        ThemeTextView themeTextView2;
        ThemeLinearLayout themeLinearLayout5;
        if (getContext() == null) {
            return;
        }
        if (this.batchTopBinding == null || this.batchBottomBinding == null) {
            this.batchBottomBinding = BookShelfBatchBottomViewBinding.bind(View.inflate(getContext(), R.layout.book_shelf_batch_bottom_view, null));
            this.batchTopBinding = BookShelfBatchTopViewBinding.bind(View.inflate(getActivity(), R.layout.book_shelf_batch_top_view, null));
            Context context = getContext();
            if (context != null) {
                int J0 = com.gyf.immersionbar.d.J0(context);
                BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding = this.batchTopBinding;
                if (bookShelfBatchTopViewBinding != null && (themeLinearLayout5 = bookShelfBatchTopViewBinding.brHeaderSetting) != null) {
                    themeLinearLayout5.setPadding(0, J0, 0, 0);
                }
            }
            FragmentActivity activity = getActivity();
            Window window = activity != null ? activity.getWindow() : null;
            if (window != null) {
                BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding2 = this.batchTopBinding;
                window.addContentView(bookShelfBatchTopViewBinding2 != null ? bookShelfBatchTopViewBinding2.getRoot() : null, new FrameLayout.LayoutParams(-1, -2));
            }
            if (window != null) {
                BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding = this.batchBottomBinding;
                window.addContentView(bookShelfBatchBottomViewBinding != null ? bookShelfBatchBottomViewBinding.getRoot() : null, new FrameLayout.LayoutParams(-1, -2, 80));
            }
            BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding3 = this.batchTopBinding;
            if (bookShelfBatchTopViewBinding3 != null && (themeTextView2 = bookShelfBatchTopViewBinding3.bpDone) != null) {
                themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: vd.r0
                    public /* synthetic */ r0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.n1(BookShelfFragment.this, view);
                    }
                });
            }
            BookShelfBatchTopViewBinding bookShelfBatchTopViewBinding4 = this.batchTopBinding;
            if (bookShelfBatchTopViewBinding4 != null && (themeTextView = bookShelfBatchTopViewBinding4.bpSelectAll) != null) {
                themeTextView.setOnClickListener(new View.OnClickListener() { // from class: vd.s0
                    public /* synthetic */ s0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.i1(BookShelfFragment.this, view);
                    }
                });
            }
            BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding2 = this.batchBottomBinding;
            if (bookShelfBatchBottomViewBinding2 != null && (themeLinearLayout4 = bookShelfBatchBottomViewBinding2.bpDeleteView) != null) {
                themeLinearLayout4.setOnClickListener(new View.OnClickListener() { // from class: vd.t0
                    public /* synthetic */ t0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.j1(BookShelfFragment.this, view);
                    }
                });
            }
            BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding3 = this.batchBottomBinding;
            if (bookShelfBatchBottomViewBinding3 != null && (themeLinearLayout3 = bookShelfBatchBottomViewBinding3.bpFlagTopView) != null) {
                themeLinearLayout3.setOnClickListener(new View.OnClickListener() { // from class: vd.u0
                    public /* synthetic */ u0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.k1(BookShelfFragment.this, view);
                    }
                });
            }
            BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding4 = this.batchBottomBinding;
            if (bookShelfBatchBottomViewBinding4 != null && (themeLinearLayout2 = bookShelfBatchBottomViewBinding4.bpCategoryView) != null) {
                themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: vd.v0
                    public /* synthetic */ v0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.l1(BookShelfFragment.this, view);
                    }
                });
            }
            BookShelfBatchBottomViewBinding bookShelfBatchBottomViewBinding5 = this.batchBottomBinding;
            if (bookShelfBatchBottomViewBinding5 != null && (themeLinearLayout = bookShelfBatchBottomViewBinding5.batchDetailView) != null) {
                themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: vd.w0
                    public /* synthetic */ w0() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        BookShelfFragment.m1(BookShelfFragment.this, view);
                    }
                });
            }
        }
        g1();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        BookShelfTagsAdapter bookShelfTagsAdapter = this.bookShelfTagsAdapter;
        if (bookShelfTagsAdapter != null) {
            bookShelfTagsAdapter.s();
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        MutableLiveData<Boolean> V;
        super.k();
        X0();
        AppViewModel G = G();
        if (G == null || (V = G.V()) == null) {
            return;
        }
        V.observe(this, new Observer() { // from class: vd.f1
            public /* synthetic */ f1() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookShelfFragment.t1(Function1.this, obj);
            }
        });
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ProgressDialogFragment progressDialogFragment = this.loadingDialog;
        if (progressDialogFragment != null && progressDialogFragment.isShowing()) {
            ProgressDialogFragment progressDialogFragment2 = this.loadingDialog;
            if (progressDialogFragment2 != null) {
                progressDialogFragment2.dismiss();
            }
            this.loadingDialog = null;
        }
        MartianBottomSheetDialogFragment martianBottomSheetDialogFragment = this.categoryDialogFragment;
        if (martianBottomSheetDialogFragment != null && martianBottomSheetDialogFragment.isVisible()) {
            MartianBottomSheetDialogFragment martianBottomSheetDialogFragment2 = this.categoryDialogFragment;
            if (martianBottomSheetDialogFragment2 != null) {
                martianBottomSheetDialogFragment2.dismiss();
            }
            this.categoryDialogFragment = null;
        }
        e9.c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
        this.rxManager = null;
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Z1(this, null, 1, null);
        v1();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        MiConfigSingleton.b2().M1().Q2();
        MiConfigSingleton.b2().M1().R2();
    }

    public final List<BookWrapper> p1() {
        ArrayList arrayList = new ArrayList();
        List<BookWrapper> list = this.bookWrappers;
        Intrinsics.checkNotNull(list);
        for (BookWrapper bookWrapper : list) {
            int size = arrayList.size();
            BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
            if (size >= (bookShelfAdapter != null ? bookShelfAdapter.getSelectNumber() : 0)) {
                break;
            }
            if (bookWrapper.isSelect()) {
                arrayList.add(bookWrapper);
            }
        }
        return arrayList;
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        D1();
        r1();
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x005c, code lost:
    
        if (r0.get(kotlin.collections.CollectionsKt.getLastIndex(r1)).isAdderItem() == false) goto L72;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void q1() {
        /*
            r4 = this;
            android.content.Context r0 = r4.getContext()
            boolean r0 = l9.m0.c(r0)
            if (r0 == 0) goto Lb
            return
        Lb:
            androidx.viewbinding.ViewBinding r0 = r4.n()
            com.martian.mibook.databinding.FragmentBookShelfBinding r0 = (com.martian.mibook.databinding.FragmentBookShelfBinding) r0
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvBookShelf
            com.martian.mibook.application.MiConfigSingleton r1 = com.martian.mibook.application.MiConfigSingleton.b2()
            int r1 = r1.O1()
            r2 = 1
            if (r1 != r2) goto L29
            androidx.recyclerview.widget.GridLayoutManager r1 = new androidx.recyclerview.widget.GridLayoutManager
            android.content.Context r2 = r4.getContext()
            r3 = 3
            r1.<init>(r2, r3)
            goto L32
        L29:
            androidx.recyclerview.widget.LinearLayoutManager r1 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r2 = r4.getContext()
            r1.<init>(r2)
        L32:
            r0.setLayoutManager(r1)
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r0 = r4.bookShelfAdapter
            if (r0 != 0) goto L99
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r0 = r4.bookWrappers
            if (r0 == 0) goto L44
            int r0 = r0.size()
            if (r0 != 0) goto L44
            goto L5e
        L44:
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r0 = r4.bookWrappers
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r1 = r4.bookWrappers
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = kotlin.collections.CollectionsKt.getLastIndex(r1)
            java.lang.Object r0 = r0.get(r1)
            com.martian.mibook.lib.model.data.BookWrapper r0 = (com.martian.mibook.lib.model.data.BookWrapper) r0
            boolean r0 = r0.isAdderItem()
            if (r0 != 0) goto L70
        L5e:
            com.martian.mibook.lib.model.data.BookWrapper r0 = new com.martian.mibook.lib.model.data.BookWrapper
            r1 = 0
            r0.<init>(r1, r1)
            com.martian.mibook.lib.model.data.BookWrapper$Type r1 = com.martian.mibook.lib.model.data.BookWrapper.Type.ADDER
            r0.setType(r1)
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r1 = r4.bookWrappers
            if (r1 == 0) goto L70
            r1.add(r0)
        L70:
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r0 = new com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter
            r0.<init>()
            r4.bookShelfAdapter = r0
            com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment$b r1 = new com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment$b
            r1.<init>()
            r0.z(r1)
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r0 = r4.bookShelfAdapter
            if (r0 == 0) goto L88
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r1 = r4.bookWrappers
            r0.A(r1)
        L88:
            com.martian.mibook.application.MiConfigSingleton r0 = com.martian.mibook.application.MiConfigSingleton.b2()
            com.martian.mibook.application.a r0 = r0.H1()
            android.content.Context r1 = r4.getContext()
            java.util.List<com.martian.mibook.lib.model.data.BookWrapper> r2 = r4.bookWrappers
            r0.W0(r1, r2)
        L99:
            androidx.viewbinding.ViewBinding r0 = r4.n()
            com.martian.mibook.databinding.FragmentBookShelfBinding r0 = (com.martian.mibook.databinding.FragmentBookShelfBinding) r0
            androidx.recyclerview.widget.RecyclerView r0 = r0.rvBookShelf
            com.martian.mibook.mvvm.yuewen.adapter.BookShelfAdapter r1 = r4.bookShelfAdapter
            r0.setAdapter(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.yuewen.fragment.BookShelfFragment.q1():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void r1() {
        ((FragmentBookShelfBinding) n()).refreshLayout.E(new g() { // from class: vd.n0
            public /* synthetic */ n0() {
            }

            @Override // sf.g
            public final void b(pf.f fVar) {
                BookShelfFragment.s1(BookShelfFragment.this, fVar);
            }
        });
    }

    public final void u1() {
        ac.a.K(getContext(), MiConfigSingleton.b2().p() == 2 ? "女频书架" : "男频书架", "展示");
        C1(MiConfigSingleton.b2().M1().T().p());
    }

    public final void w1() {
        if (f1(true)) {
            M1();
        }
    }

    public final void x1() {
        if (f1(true)) {
            F1();
        }
    }

    public final void y1() {
        if (f1(true)) {
            W0();
        }
    }

    public final void z1() {
        if (f1(false)) {
            BookShelfAdapter bookShelfAdapter = this.bookShelfAdapter;
            if (bookShelfAdapter != null) {
                bookShelfAdapter.v();
            }
            V1();
        }
    }
}
