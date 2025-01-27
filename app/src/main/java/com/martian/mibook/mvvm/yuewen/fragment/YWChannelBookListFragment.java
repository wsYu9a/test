package com.martian.mibook.mvvm.yuewen.fragment;

import android.os.Bundle;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.FragmentComomonRecyclerviewBinding;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.net.request.YWBookChannelBooksParams;
import com.martian.mibook.mvvm.widget.MiClassicsFooter;
import com.martian.mibook.mvvm.widget.MiClassicsHeader;
import com.martian.mibook.mvvm.yuewen.adapter.TYBookItemListAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.YWChannelBookListFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.YWChannelBookListViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import pf.f;
import sf.h;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 !2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\"B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u001f\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u0005J\u000f\u0010\u000e\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000e\u0010\u0005J\u0019\u0010\u0011\u001a\u00020\u00062\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0013\u0010\u0005J\u000f\u0010\u0014\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0014\u0010\u0005J#\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0016\u001a\u00020\u00152\b\b\u0002\u0010\u0017\u001a\u00020\u0015H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010 \u001a\u00020\u00158\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006#"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/YWChannelBookListFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentComomonRecyclerviewBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/YWChannelBookListViewModel;", "<init>", "()V", "", "z0", "", "Lcom/martian/mibook/lib/model/data/TYBookItem;", "bookList", "A0", "(Ljava/util/List;)V", "x0", "y0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "y", "i0", "", "isLoadMore", "showLoading", "v0", "(ZZ)V", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "k", "Lcom/martian/mibook/mvvm/yuewen/adapter/TYBookItemListAdapter;", "mAdapter", t.f11204d, "Z", "loadMoreFail", "m", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class YWChannelBookListFragment extends BaseMVVMFragment<FragmentComomonRecyclerviewBinding, YWChannelBookListViewModel> {

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public TYBookItemListAdapter mAdapter;

    /* renamed from: l */
    public boolean loadMoreFail;

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.YWChannelBookListFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @l
        public final YWChannelBookListFragment a(@l String str, int i10, int i11, int i12, @l String str2) {
            Bundle bundle = new Bundle();
            bundle.putString(MiConfigSingleton.f13316b1, str);
            bundle.putString(MiConfigSingleton.f13318d1, str2);
            bundle.putInt(MiConfigSingleton.Z0, i10);
            bundle.putInt(MiConfigSingleton.f13315a1, i11);
            bundle.putInt(MiConfigSingleton.f13317c1, i12);
            YWChannelBookListFragment yWChannelBookListFragment = new YWChannelBookListFragment();
            yWChannelBookListFragment.setArguments(bundle);
            return yWChannelBookListFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements h {
        public b() {
        }

        @Override // sf.g
        public void b(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            YWChannelBookListFragment.this.x0();
        }

        @Override // sf.e
        public void p(@k f refreshLayout) {
            Intrinsics.checkNotNullParameter(refreshLayout, "refreshLayout");
            if (!YWChannelBookListFragment.this.loadMoreFail) {
                YWChannelBookListViewModel I = YWChannelBookListFragment.this.I();
                I.y(I.getPageIndex() + 1);
            }
            YWChannelBookListFragment.w0(YWChannelBookListFragment.this, true, false, 2, null);
        }
    }

    public static final void A(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void A0(List<? extends TYBookItem> bookList) {
        y0();
        if (this.mAdapter == null) {
            this.mAdapter = new TYBookItemListAdapter();
            ((FragmentComomonRecyclerviewBinding) n()).recyclerview.setAdapter(this.mAdapter);
            TYBookItemListAdapter tYBookItemListAdapter = this.mAdapter;
            if (tYBookItemListAdapter != null) {
                tYBookItemListAdapter.o("-查看全部");
            }
        }
        if (I().getPageIndex() != 0) {
            List<? extends TYBookItem> list = bookList;
            if (list == null || list.isEmpty()) {
                ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.e0();
                return;
            }
            TYBookItemListAdapter tYBookItemListAdapter2 = this.mAdapter;
            if (tYBookItemListAdapter2 != null) {
                tYBookItemListAdapter2.k(bookList);
                return;
            }
            return;
        }
        List<? extends TYBookItem> list2 = bookList;
        if (list2 == null || list2.isEmpty()) {
            ((FragmentComomonRecyclerviewBinding) n()).recyclerview.setVisibility(8);
            O("", ((FragmentComomonRecyclerviewBinding) n()).rvLoadedTip);
            return;
        }
        T(((FragmentComomonRecyclerviewBinding) n()).rvLoadedTip);
        TYBookItemListAdapter tYBookItemListAdapter3 = this.mAdapter;
        if (tYBookItemListAdapter3 != null) {
            tYBookItemListAdapter3.q(null);
        }
        TYBookItemListAdapter tYBookItemListAdapter4 = this.mAdapter;
        if (tYBookItemListAdapter4 != null) {
            tYBookItemListAdapter4.q(bookList);
        }
        ((FragmentComomonRecyclerviewBinding) n()).recyclerview.setVisibility(0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentComomonRecyclerviewBinding p0(YWChannelBookListFragment yWChannelBookListFragment) {
        return (FragmentComomonRecyclerviewBinding) yWChannelBookListFragment.n();
    }

    public static final void u0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static /* synthetic */ void w0(YWChannelBookListFragment yWChannelBookListFragment, boolean z10, boolean z11, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        if ((i10 & 2) != 0) {
            TYBookItemListAdapter tYBookItemListAdapter = yWChannelBookListFragment.mAdapter;
            z11 = (tYBookItemListAdapter != null ? tYBookItemListAdapter.getPageSize() : 0) <= 0;
        }
        yWChannelBookListFragment.v0(z10, z11);
    }

    public final void x0() {
        I().y(0);
        w0(this, false, false, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        this.loadMoreFail = false;
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.p();
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.S();
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.n();
    }

    public static final void z(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void z0() {
        ((FragmentComomonRecyclerviewBinding) n()).recyclerview.setLayoutManager(new LinearLayoutManager(getContext()));
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.O(new MiClassicsHeader(getContext(), null, 2, null));
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.U(new MiClassicsFooter(getContext(), null, false, 6, null));
        ((FragmentComomonRecyclerviewBinding) n()).refreshLayout.B(new b());
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            I().A(arguments.getString(MiConfigSingleton.f13316b1));
            I().w(arguments.getString(MiConfigSingleton.f13318d1));
            I().x(arguments.getInt(MiConfigSingleton.Z0));
            I().z(arguments.getInt(MiConfigSingleton.f13315a1));
            I().y(arguments.getInt(MiConfigSingleton.f13317c1));
        }
        z0();
        x0();
    }

    public final void v0(boolean isLoadMore, boolean showLoading) {
        YWBookChannelBooksParams yWBookChannelBooksParams = new YWBookChannelBooksParams(null, null, 0, 0, null, null, 63, null);
        yWBookChannelBooksParams.setPage(Integer.valueOf(I().getPageIndex()));
        yWBookChannelBooksParams.setPageSize(10);
        yWBookChannelBooksParams.setMcid(I().getMcid());
        yWBookChannelBooksParams.setExt(I().getExt());
        yWBookChannelBooksParams.makeSpeed();
        I().u(yWBookChannelBooksParams, showLoading, isLoadMore);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void y() {
        I().h().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.g4
            public /* synthetic */ g4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWChannelBookListFragment.z(Function1.this, obj);
            }
        });
        I().p().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.h4
            public /* synthetic */ h4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWChannelBookListFragment.A(Function1.this, obj);
            }
        });
        ((FragmentComomonRecyclerviewBinding) n()).rvLoadedTip.setOnReloadListener(new Function0<Unit>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.YWChannelBookListFragment$addObserver$3
            public YWChannelBookListFragment$addObserver$3() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke */
            public final void invoke2() {
                YWChannelBookListFragment.this.v0(false, true);
            }
        });
        I().o().observe(getViewLifecycleOwner(), new Observer() { // from class: vd.i4
            public /* synthetic */ i4() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                YWChannelBookListFragment.u0(Function1.this, obj);
            }
        });
    }
}
