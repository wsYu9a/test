package com.martian.mibook.mvvm.read.fragment;

import ac.a;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p0.t;
import com.martian.free.response.TFBook;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentReadingBookInfoBinding;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.lib.yuewen.response.YWBook;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.book.viewmodel.BookInfo;
import com.martian.mibook.mvvm.net.request.GetCommentByScoreParams;
import com.martian.mibook.mvvm.read.adapter.ReaderCommentAdapter;
import com.martian.mibook.mvvm.read.comment.Comment;
import com.martian.mibook.mvvm.read.comment.CommentReply;
import com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment;
import com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReaderCommentViewModel;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.mibook.ui.FlexboxTagLayout;
import com.martian.mibook.ui.reader.ReaderThemeTextView;
import java.util.List;
import je.i;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 82\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u00019B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u0019\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\f\u0010\u000bJ\u000f\u0010\r\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\r\u0010\u0005J\u001f\u0010\u0011\u001a\u00020\u00062\u000e\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u001f\u0010\u0015\u001a\u00020\u00062\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0015\u0010\u0012J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J\u0019\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0017H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0006H\u0016¢\u0006\u0004\b \u0010\u0005J\u0019\u0010#\u001a\u00020\u00062\b\u0010\"\u001a\u0004\u0018\u00010!H\u0016¢\u0006\u0004\b#\u0010$J\u000f\u0010%\u001a\u00020\u0006H\u0016¢\u0006\u0004\b%\u0010\u0005J\u0015\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\b¢\u0006\u0004\b'\u0010\u000bR\u0018\u0010*\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u0010)R\u001b\u0010/\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u0001008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b1\u0010,\u001a\u0004\b2\u00103R\u0018\u00107\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/martian/mibook/mvvm/read/fragment/ReadingBookInfoFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentReadingBookInfoBinding;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "<init>", "()V", "", "L0", "", "isRefresh", "X0", "(Z)V", "D0", "H0", "", "Lcom/martian/mibook/mvvm/read/comment/Comment;", "comments", "d1", "(Ljava/util/List;)V", "", "tagList", "c1", "f1", "", "score", "a1", "(I)V", TTDownloadField.TT_TAG, "g1", "(Ljava/lang/String;)V", "C0", "()I", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "enable", "e1", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "Lcom/martian/mibook/mvvm/read/adapter/ReaderCommentAdapter;", "mReaderCommentAdapter", t.f11204d, "Lkotlin/Lazy;", "G0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "m", "F0", "()Lcom/martian/mibook/mvvm/read/viewmodel/ReaderCommentViewModel;", "mCommentViewModel", "n", "Ljava/lang/String;", "commentString", "o", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingBookInfoFragment extends BaseMVVMFragment<FragmentReadingBookInfoBinding, ReadingViewModel> {

    /* renamed from: o, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public ReaderCommentAdapter mReaderCommentAdapter;

    /* renamed from: l */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment$mViewModel$2
        public ReadingBookInfoFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = ReadingBookInfoFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingBookInfoFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingBookInfoFragment.this.M());
        }
    });

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public final Lazy mCommentViewModel = LazyKt.lazy(new Function0<ReaderCommentViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment$mCommentViewModel$2
        public ReadingBookInfoFragment$mCommentViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReaderCommentViewModel invoke() {
            ViewModelStoreOwner activity = ReadingBookInfoFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingBookInfoFragment.this;
            }
            return (ReaderCommentViewModel) new ViewModelProvider(activity).get(ReaderCommentViewModel.class);
        }
    });

    /* renamed from: n, reason: from kotlin metadata */
    @l
    public String commentString;

    /* renamed from: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final ReadingBookInfoFragment a() {
            return new ReadingBookInfoFragment();
        }

        public Companion() {
        }
    }

    public static final class b implements ReaderPostBookCommentFragment.e {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void a(@k CommentReply comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void b(@k Comment comment) {
            Intrinsics.checkNotNullParameter(comment, "comment");
            a.L(ReadingBookInfoFragment.this.getContext(), "写评论-最后一页-成功");
            ReadingBookInfoFragment.this.commentString = null;
            ReadingBookInfoFragment.this.X0(true);
        }

        @Override // com.martian.mibook.mvvm.read.fragment.ReaderPostBookCommentFragment.e
        public void c(@k String tag, @k String comment) {
            Intrinsics.checkNotNullParameter(tag, "tag");
            Intrinsics.checkNotNullParameter(comment, "comment");
            ReadingBookInfoFragment.this.commentString = comment;
        }
    }

    public static final class c implements FlexboxTagLayout.a {
        public c() {
        }

        @Override // com.martian.mibook.ui.FlexboxTagLayout.a
        public void a(@k String title, int i10) {
            Intrinsics.checkNotNullParameter(title, "title");
            ReadingBookInfoFragment.this.g1(title);
        }
    }

    private final int C0() {
        Book book = I().getBook();
        if (book instanceof YWBook) {
            Book book2 = I().getBook();
            Intrinsics.checkNotNull(book2, "null cannot be cast to non-null type com.martian.mibook.lib.yuewen.response.YWBook");
            return ((YWBook) book2).getFreeType();
        }
        if (!(book instanceof TFBook)) {
            return MiConfigSingleton.b2().p();
        }
        try {
            Book book3 = I().getBook();
            Intrinsics.checkNotNull(book3, "null cannot be cast to non-null type com.martian.free.response.TFBook");
            String freeType = ((TFBook) book3).getFreeType();
            Intrinsics.checkNotNullExpressionValue(freeType, "getFreeType(...)");
            return Integer.parseInt(freeType);
        } catch (Exception unused) {
            return MiConfigSingleton.b2().p();
        }
    }

    public static /* synthetic */ void E0(ReadingBookInfoFragment readingBookInfoFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        readingBookInfoFragment.D0(z10);
    }

    private final ReaderCommentViewModel F0() {
        return (ReaderCommentViewModel) this.mCommentViewModel.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:10:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00bf  */
    @android.annotation.SuppressLint({"SetTextI18n"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void H0() {
        /*
            Method dump skipped, instructions count: 592
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment.H0():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void I0(ReadingBookInfoFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ((FragmentReadingBookInfoBinding) this$0.n()).bdIntroMoreView.setVisibility(((FragmentReadingBookInfoBinding) this$0.n()).bdIntroText.getLineCount() > 4 ? 0 : 8);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void J0(ReadingBookInfoFragment this$0, View view) {
        int i10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (((FragmentReadingBookInfoBinding) this$0.n()).bdIntroMoreView.getVisibility() == 0) {
            boolean z10 = !((FragmentReadingBookInfoBinding) this$0.n()).bdIntroText.f();
            ((FragmentReadingBookInfoBinding) this$0.n()).bdIntroText.setMaxLines(z10 ? Integer.MAX_VALUE : 4);
            ((FragmentReadingBookInfoBinding) this$0.n()).bdIntroText.g(z10, z10 ? ConfigSingleton.i(20.0f) : 0);
            ReaderThemeTextView readerThemeTextView = ((FragmentReadingBookInfoBinding) this$0.n()).bdIntroMoreView;
            boolean f10 = ((FragmentReadingBookInfoBinding) this$0.n()).bdIntroText.f();
            String str = null;
            Context context = this$0.getContext();
            if (f10) {
                if (context != null) {
                    i10 = R.string.fold;
                    str = context.getString(i10);
                }
                readerThemeTextView.setText(str);
            }
            if (context != null) {
                i10 = R.string.expand;
                str = context.getString(i10);
            }
            readerThemeTextView.setText(str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged"})
    private final void L0() {
        MutableLiveData<Pair<Integer, Object>> f02;
        MutableLiveData<Unit> i02;
        a.L(getContext(), "目录-详情");
        I().Y0().observe(this, new Observer() { // from class: ed.h0
            public /* synthetic */ h0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingBookInfoFragment.M0(Function1.this, obj);
            }
        });
        I().X0().observe(this, new Observer() { // from class: ed.i0
            public /* synthetic */ i0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingBookInfoFragment.O0(Function1.this, obj);
            }
        });
        AppViewModel G = G();
        if (G != null && (i02 = G.i0()) != null) {
            i02.observe(this, new Observer() { // from class: ed.j0
                public /* synthetic */ j0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingBookInfoFragment.P0(Function1.this, obj);
                }
            });
        }
        AppViewModel G2 = G();
        if (G2 != null && (f02 = G2.f0()) != null) {
            f02.observe(this, new Observer() { // from class: ed.k0
                public /* synthetic */ k0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingBookInfoFragment.Q0(Function1.this, obj);
                }
            });
        }
        I().N0().observe(this, new Observer() { // from class: ed.l0
            public /* synthetic */ l0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingBookInfoFragment.R0(Function1.this, obj);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).loadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment$initView$6
            public ReadingBookInfoFragment$initView$6() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                ReadingBookInfoFragment.Y0(ReadingBookInfoFragment.this, false, 1, null);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).tvMoreComment.setOnClickListener(new View.OnClickListener() { // from class: ed.m0
            public /* synthetic */ m0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingBookInfoFragment.T0(ReadingBookInfoFragment.this, view);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).ivMoreComment.setOnClickListener(new View.OnClickListener() { // from class: ed.n0
            public /* synthetic */ n0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingBookInfoFragment.U0(ReadingBookInfoFragment.this, view);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).rlEmpty.setOnClickListener(new View.OnClickListener() { // from class: ed.o0
            public /* synthetic */ o0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingBookInfoFragment.V0(ReadingBookInfoFragment.this, view);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).ivGoComment.setOnClickListener(new View.OnClickListener() { // from class: ed.f0
            public /* synthetic */ f0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingBookInfoFragment.W0(ReadingBookInfoFragment.this, view);
            }
        });
        ((FragmentReadingBookInfoBinding) n()).rvHotComment.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public static final void M0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void O0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void P0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void Q0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void R0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void T0(ReadingBookInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1();
    }

    public static final void U0(ReadingBookInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.f1();
    }

    public static final void V0(ReadingBookInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b1(this$0, 0, 1, null);
    }

    public static final void W0(ReadingBookInfoFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        b1(this$0, 0, 1, null);
    }

    public static /* synthetic */ void Y0(ReadingBookInfoFragment readingBookInfoFragment, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        readingBookInfoFragment.X0(z10);
    }

    @JvmStatic
    @k
    public static final ReadingBookInfoFragment Z0() {
        return INSTANCE.a();
    }

    public static /* synthetic */ void b1(ReadingBookInfoFragment readingBookInfoFragment, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = 100;
        }
        readingBookInfoFragment.a1(i10);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void c1(List<String> tagList) {
        List<String> list = tagList;
        if (list == null || list.isEmpty()) {
            ((FragmentReadingBookInfoBinding) n()).flexboxCategory.setVisibility(8);
            return;
        }
        if (((FragmentReadingBookInfoBinding) n()).flexboxCategory.getChildCount() == 0) {
            ((FragmentReadingBookInfoBinding) n()).flexboxCategory.O();
            ((FragmentReadingBookInfoBinding) n()).flexboxCategory.setData(tagList);
            ((FragmentReadingBookInfoBinding) n()).flexboxCategory.setVisibility(0);
        }
        ((FragmentReadingBookInfoBinding) n()).horizontalScrollview.smoothScrollTo(0, 0);
        ((FragmentReadingBookInfoBinding) n()).flexboxCategory.setOnItemTitleClickListener(new c());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void d1(List<Comment> comments) {
        if (!MiConfigSingleton.b2().p3()) {
            ((FragmentReadingBookInfoBinding) n()).llHotCommentList.setVisibility(8);
            return;
        }
        ((FragmentReadingBookInfoBinding) n()).llHotCommentList.setVisibility(0);
        List<Comment> list = comments;
        if (list == null || list.isEmpty()) {
            ((FragmentReadingBookInfoBinding) n()).llMoreComment.setVisibility(8);
            ((FragmentReadingBookInfoBinding) n()).rlEmpty.setVisibility(0);
            ((FragmentReadingBookInfoBinding) n()).rvHotComment.setVisibility(8);
            return;
        }
        ((FragmentReadingBookInfoBinding) n()).llMoreComment.setVisibility(0);
        ((FragmentReadingBookInfoBinding) n()).rlEmpty.setVisibility(8);
        ((FragmentReadingBookInfoBinding) n()).rvHotComment.setVisibility(0);
        ReaderCommentAdapter readerCommentAdapter = this.mReaderCommentAdapter;
        if (readerCommentAdapter != null) {
            if (readerCommentAdapter != null) {
                readerCommentAdapter.I(comments);
            }
        } else {
            this.mReaderCommentAdapter = new ReaderCommentAdapter(F0(), ReaderCommentViewModel.CommentType.TYPE_BOOK_COMMENT);
            ((FragmentReadingBookInfoBinding) n()).rvHotComment.setAdapter(this.mReaderCommentAdapter);
            ReaderCommentAdapter readerCommentAdapter2 = this.mReaderCommentAdapter;
            if (readerCommentAdapter2 != null) {
                readerCommentAdapter2.n(comments);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentReadingBookInfoBinding w0(ReadingBookInfoFragment readingBookInfoFragment) {
        return (FragmentReadingBookInfoBinding) readingBookInfoFragment.n();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D0(boolean isRefresh) {
        if (!MiConfigSingleton.b2().p3()) {
            ((FragmentReadingBookInfoBinding) n()).llHotCommentList.setVisibility(8);
            return;
        }
        if (!isRefresh && I().y0() != null) {
            d1(I().y0());
            return;
        }
        GetCommentByScoreParams getCommentByScoreParams = new GetCommentByScoreParams(null, null, null, null, null, null, 0, 127, null);
        getCommentByScoreParams.setType(1);
        getCommentByScoreParams.setSourceName(I().getSourceName());
        getCommentByScoreParams.setSourceId(I().getSourceId());
        getCommentByScoreParams.setPage(0);
        ReadingViewModel.x0(I(), getCommentByScoreParams, 0, 2, null);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: G0 */
    public ReadingViewModel I() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0027, code lost:
    
        if (android.text.TextUtils.isEmpty(r0 != null ? r0.getIntro() : null) != false) goto L31;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void X0(boolean r3) {
        /*
            r2 = this;
            if (r3 != 0) goto L29
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r0 = r2.I()
            com.martian.mibook.data.book.ReadingInfo r0 = r0.getReadingInfo()
            r1 = 0
            if (r0 == 0) goto L12
            java.util.List r0 = r0.getTagList()
            goto L13
        L12:
            r0 = r1
        L13:
            if (r0 == 0) goto L29
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r0 = r2.I()
            com.martian.mibook.data.book.ReadingInfo r0 = r0.getReadingInfo()
            if (r0 == 0) goto L23
            java.lang.String r1 = r0.getIntro()
        L23:
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 == 0) goto L3f
        L29:
            if (r3 != 0) goto L38
            androidx.viewbinding.ViewBinding r0 = r2.n()
            com.martian.mibook.databinding.FragmentReadingBookInfoBinding r0 = (com.martian.mibook.databinding.FragmentReadingBookInfoBinding) r0
            com.martian.mibook.mvvm.read.widget.ReaderLoadingTip r0 = r0.loadedTip
            com.martian.mibook.mvvm.read.widget.ReaderLoadingTip$LoadStatus r1 = com.martian.mibook.mvvm.read.widget.ReaderLoadingTip.LoadStatus.loading
            r0.setLoadingTip(r1)
        L38:
            com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel r0 = r2.I()
            r0.o1()
        L3f:
            r2.D0(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.read.fragment.ReadingBookInfoFragment.X0(boolean):void");
    }

    public final void a1(int score) {
        ReaderPostBookCommentFragment.q0(getActivity(), I().w3(), score, this.commentString, new b());
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e1(boolean enable) {
        ((FragmentReadingBookInfoBinding) n()).nsvContent.setNestedScrollingEnabled(enable);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void f1() {
        a.L(getContext(), "目录-详情-查看评论");
        BookInfo w32 = I().w3();
        w32.setPostComment(Boolean.valueOf(((FragmentReadingBookInfoBinding) n()).rlEmpty.getVisibility() == 0));
        ReaderCommentFragment.INSTANCE.b(getActivity(), w32);
    }

    public final void g1(String r32) {
        i.b0(C0(), r32, 7);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        L0();
        Y0(this, false, 1, null);
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
    }
}
