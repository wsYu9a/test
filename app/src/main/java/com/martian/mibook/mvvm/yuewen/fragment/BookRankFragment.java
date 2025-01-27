package com.martian.mibook.mvvm.yuewen.fragment;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.data.BookRankTab;
import com.martian.mibook.databinding.FragmentBookRankNewBinding;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.net.request.YWRankBooksParams;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.widget.MiClassicsHeader;
import com.martian.mibook.mvvm.yuewen.adapter.BookRankChildAdapter;
import com.martian.mibook.mvvm.yuewen.adapter.BookRankGroupAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.BookRankFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookRankViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SourceDebugExtension;
import pf.f;
import sf.h;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 +2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001,B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u001f\u0010\f\u001a\u00020\u00062\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tH\u0002¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J\u000f\u0010\u0015\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0015\u0010\u0005J#\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u0017\u001a\u00020\u00162\b\b\u0002\u0010\u0018\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0019\u0010\u001aR\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u001cR\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0016\u0010$\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\"\u0010#R\u0016\u0010(\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010'R\u0016\u0010*\u001a\u00020%8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010'¨\u0006-"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/BookRankFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentBookRankNewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel;", "<init>", "()V", "", "F0", "B0", "", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookRankViewModel$b;", "bookList", "G0", "(Ljava/util/List;)V", "C0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "y", "k", "i0", "", "isLoadMore", "showLoading", "D0", "(ZZ)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter;", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankGroupAdapter;", "bookRankGroupAdapter", "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/yuewen/adapter/BookRankChildAdapter;", "bookRankChildAdapter", "m", "Z", "loadMoreFail", "", "n", "I", "pageIndex", "o", "rankStatus", "p", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class BookRankFragment extends BaseMVVMFragment<FragmentBookRankNewBinding, BookRankViewModel> {

    /* renamed from: p, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: q */
    @k
    public static final String f15591q = "intent_cType";

    /* renamed from: r */
    @k
    public static final String f15592r = "intent_category";

    /* renamed from: s */
    @k
    public static final String f15593s = "intent_brtype";

    /* renamed from: t */
    @k
    public static final String f15594t = "intent_source";

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public BookRankGroupAdapter bookRankGroupAdapter;

    /* renamed from: l */
    @l
    public BookRankChildAdapter bookRankChildAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    public boolean loadMoreFail;

    /* renamed from: n, reason: from kotlin metadata */
    public int pageIndex;

    /* renamed from: o, reason: from kotlin metadata */
    public int rankStatus;

    @SourceDebugExtension({"SMAP\nBookRankFragment.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BookRankFragment.kt\ncom/martian/mibook/mvvm/yuewen/fragment/BookRankFragment$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,219:1\n1#2:220\n*E\n"})
    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.BookRankFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @k
        public final BookRankFragment a(int i10, @l String str, @l Integer num, @l String str2) {
            BookRankFragment bookRankFragment = new BookRankFragment();
            Bundle bundle = new Bundle();
            bundle.putInt(BookRankFragment.f15591q, i10);
            bundle.putString("intent_category", str);
            if (num != null) {
                bundle.putInt("intent_brtype", num.intValue());
            }
            bundle.putString("intent_source", str2);
            bookRankFragment.setArguments(bundle);
            return bookRankFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements BookRankChildAdapter.b {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookRankChildAdapter.b
        public void a(boolean z10) {
            BookRankFragment.this.rankStatus = z10 ? 50 : 0;
            BookRankFragment.this.B0();
        }
    }

    public static final class c implements h {
        public c() {
        }

        @Override // sf.g
        public void b(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            BookRankFragment.this.B0();
        }

        @Override // sf.e
        public void p(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!BookRankFragment.this.loadMoreFail) {
                BookRankFragment.this.pageIndex++;
            }
            BookRankFragment.E0(BookRankFragment.this, true, false, 2, null);
        }
    }

    public static final class d implements BookRankGroupAdapter.a {
        public d() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.BookRankGroupAdapter.a
        public void a(int i10) {
            BookRankGroupAdapter bookRankGroupAdapter = BookRankFragment.this.bookRankGroupAdapter;
            if (bookRankGroupAdapter != null) {
                bookRankGroupAdapter.r(i10);
            }
            BookRankFragment.this.rankStatus = 0;
            BookRankViewModel I = BookRankFragment.this.I();
            BookRankGroupAdapter bookRankGroupAdapter2 = BookRankFragment.this.bookRankGroupAdapter;
            I.A(bookRankGroupAdapter2 != null ? bookRankGroupAdapter2.j() : null);
            BookRankFragment.this.B0();
        }
    }

    public static final void A0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void B0() {
        this.pageIndex = 0;
        E0(this, false, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void C0() {
        this.loadMoreFail = false;
        ((FragmentBookRankNewBinding) n()).refreshLayout.p();
        ((FragmentBookRankNewBinding) n()).refreshLayout.S();
        ((FragmentBookRankNewBinding) n()).refreshLayout.n();
    }

    public static /* synthetic */ void E0(BookRankFragment bookRankFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            BookRankChildAdapter bookRankChildAdapter = bookRankFragment.bookRankChildAdapter;
            z11 = (bookRankChildAdapter != null ? bookRankChildAdapter.getPageSize() : 0) <= 0;
        }
        bookRankFragment.D0(z10, z11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void F0() {
        ((FragmentBookRankNewBinding) n()).rvLoadedTip.setBackgroundType(-1);
        ((FragmentBookRankNewBinding) n()).refreshLayout.O(new MiClassicsHeader(getContext(), (Integer) 2));
        ((FragmentBookRankNewBinding) n()).refreshLayout.j0(false);
        ((FragmentBookRankNewBinding) n()).refreshLayout.U(new MiClassicsFooter(getContext(), 2, false, 4, null));
        ((FragmentBookRankNewBinding) n()).refreshLayout.B(new c());
        List<BookRankTab> o10 = I().o();
        if (this.bookRankGroupAdapter == null) {
            this.bookRankGroupAdapter = new BookRankGroupAdapter(o10);
        }
        ((FragmentBookRankNewBinding) n()).rvGroup.setLayoutManager(new LinearLayoutManager(getContext()));
        RecyclerView recyclerView = ((FragmentBookRankNewBinding) n()).rvGroup;
        BookRankGroupAdapter bookRankGroupAdapter = this.bookRankGroupAdapter;
        if (bookRankGroupAdapter != null) {
            bookRankGroupAdapter.o(new d());
        } else {
            bookRankGroupAdapter = null;
        }
        recyclerView.setAdapter(bookRankGroupAdapter);
        if (I().getBrtype() == null) {
            BookRankViewModel I = I();
            BookRankGroupAdapter bookRankGroupAdapter2 = this.bookRankGroupAdapter;
            I.A(bookRankGroupAdapter2 != null ? bookRankGroupAdapter2.j() : null);
        } else {
            BookRankGroupAdapter bookRankGroupAdapter3 = this.bookRankGroupAdapter;
            if (bookRankGroupAdapter3 != null) {
                bookRankGroupAdapter3.q(I().getBrtype());
            }
        }
        if (this.bookRankChildAdapter == null) {
            this.bookRankChildAdapter = new BookRankChildAdapter();
        }
        ((FragmentBookRankNewBinding) n()).rvChild.setLayoutManager(new LinearLayoutManager(getContext()));
        ((FragmentBookRankNewBinding) n()).rvChild.setAdapter(this.bookRankChildAdapter);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void G0(List<BookRankViewModel.b> bookList) {
        C0();
        if (this.pageIndex != 0) {
            List<BookRankViewModel.b> list = bookList;
            if (list == null || list.isEmpty()) {
                ((FragmentBookRankNewBinding) n()).refreshLayout.e0();
                return;
            }
            BookRankChildAdapter bookRankChildAdapter = this.bookRankChildAdapter;
            if (bookRankChildAdapter != null) {
                bookRankChildAdapter.k(bookList);
                return;
            }
            return;
        }
        List<BookRankViewModel.b> list2 = bookList;
        if (list2 == null || list2.isEmpty()) {
            ((FragmentBookRankNewBinding) n()).rvChild.setVisibility(8);
            O("", ((FragmentBookRankNewBinding) n()).rvLoadedTip);
            ((FragmentBookRankNewBinding) n()).refreshLayout.N(false);
        } else {
            ((FragmentBookRankNewBinding) n()).refreshLayout.N(true);
            T(((FragmentBookRankNewBinding) n()).rvLoadedTip);
            BookRankChildAdapter bookRankChildAdapter2 = this.bookRankChildAdapter;
            if (bookRankChildAdapter2 != null) {
                bookRankChildAdapter2.n(bookList, bookList.get(0).h() == null);
            }
            ((FragmentBookRankNewBinding) n()).rvChild.setVisibility(0);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentBookRankNewBinding q0(BookRankFragment bookRankFragment) {
        return (FragmentBookRankNewBinding) bookRankFragment.n();
    }

    public static final void y0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public final void D0(boolean isLoadMore, boolean showLoading) {
        YWRankBooksParams yWRankBooksParams = new YWRankBooksParams(null, 0, 0, null, null, null, 63, null);
        yWRankBooksParams.setCategory(I().getCategory());
        yWRankBooksParams.setCtype(Integer.valueOf(I().getCType()));
        yWRankBooksParams.setPage(this.pageIndex);
        yWRankBooksParams.setBrtype(I().getBrtype());
        yWRankBooksParams.setStatus(Integer.valueOf(this.rankStatus));
        I().p(yWRankBooksParams, showLoading, isLoadMore);
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        BookRankGroupAdapter bookRankGroupAdapter = this.bookRankGroupAdapter;
        if (bookRankGroupAdapter != null) {
            bookRankGroupAdapter.n();
        }
        BookRankChildAdapter bookRankChildAdapter = this.bookRankChildAdapter;
        if (bookRankChildAdapter != null) {
            bookRankChildAdapter.l();
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        B0();
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            I().C(arguments.getInt(f15591q, 1));
            I().D(arguments.getString("intent_category"));
            int i10 = arguments.getInt("intent_brtype", -1);
            I().A(i10 == -1 ? null : Integer.valueOf(i10));
            I().F(arguments.getString("intent_source"));
        }
        F0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void y() {
        I().v().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.k0
            public /* synthetic */ k0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankFragment.y0(Function1.this, obj);
            }
        });
        I().h().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.l0
            public /* synthetic */ l0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankFragment.z0(Function1.this, obj);
            }
        });
        I().g().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.m0
            public /* synthetic */ m0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                BookRankFragment.A0(Function1.this, obj);
            }
        });
        ((FragmentBookRankNewBinding) n()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.BookRankFragment$addObserver$4
            public BookRankFragment$addObserver$4() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                BookRankFragment.this.D0(false, true);
            }
        });
        BookRankChildAdapter bookRankChildAdapter = this.bookRankChildAdapter;
        if (bookRankChildAdapter != null) {
            bookRankChildAdapter.m(new b());
        }
    }
}
