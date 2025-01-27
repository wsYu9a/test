package com.martian.mibook.mvvm.read.fragment;

import android.os.Bundle;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.kuaishou.weapon.p0.bq;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.databinding.FragmentReadingBookMarkBinding;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.read.adapter.BookMarkListAdapter;
import com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment;
import com.martian.mibook.mvvm.read.viewmodel.ReadingViewModel;
import com.martian.mibook.mvvm.read.widget.a;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi.k;
import xi.l;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 %2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001&B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\u0005J\u0019\u0010\u000b\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0012\u0010\u0005J\u000f\u0010\u0013\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0013\u0010\u0005J\u001f\u0010\u0017\u001a\u00020\u00062\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014H\u0002¢\u0006\u0004\b\u0017\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0019\u001a\u0004\b\u001a\u0010\u001bR\u0018\u0010 \u001a\u0004\u0018\u00010\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#¨\u0006'"}, d2 = {"Lcom/martian/mibook/mvvm/read/fragment/ReadingBookMarkFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentReadingBookMarkBinding;", "Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "<init>", "()V", "", "r0", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "", "enable", "x0", "(Z)V", "k", "onResume", "v0", "", "Lcom/martian/mibook/lib/model/data/MiBookMark;", "miBookMarks", "w0", "(Ljava/util/List;)V", "Lkotlin/Lazy;", bq.f10843g, "()Lcom/martian/mibook/mvvm/read/viewmodel/ReadingViewModel;", "mViewModel", "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/read/adapter/BookMarkListAdapter;", "bookMarkListAdapter", "Lcom/martian/mibook/mvvm/read/widget/a;", "q0", "()Lcom/martian/mibook/mvvm/read/widget/a;", "readMenuCallBack", "m", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingBookMarkFragment extends BaseMVVMFragment<FragmentReadingBookMarkBinding, ReadingViewModel> {

    /* renamed from: m, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: k, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<ReadingViewModel>() { // from class: com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$mViewModel$2
        public ReadingBookMarkFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final ReadingViewModel invoke() {
            ViewModelStoreOwner activity = ReadingBookMarkFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingBookMarkFragment.this;
            }
            return (ReadingViewModel) new ViewModelProvider(activity).get(ReadingBookMarkFragment.this.M());
        }
    });

    /* renamed from: l */
    @l
    public BookMarkListAdapter bookMarkListAdapter;

    /* renamed from: com.martian.mibook.mvvm.read.fragment.ReadingBookMarkFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @k
        public final ReadingBookMarkFragment a() {
            return new ReadingBookMarkFragment();
        }

        public Companion() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ FragmentReadingBookMarkBinding m0(ReadingBookMarkFragment readingBookMarkFragment) {
        return (FragmentReadingBookMarkBinding) readingBookMarkFragment.n();
    }

    public final a q0() {
        Object context = getContext();
        if (context instanceof a) {
            return (a) context;
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void r0() {
        MutableLiveData<Unit> i02;
        ac.a.L(getContext(), "目录-书签");
        ((FragmentReadingBookMarkBinding) n()).rvMarks.setLayoutManager(new LinearLayoutManager(getContext()));
        this.bookMarkListAdapter = new BookMarkListAdapter();
        ((FragmentReadingBookMarkBinding) n()).rvMarks.setAdapter(this.bookMarkListAdapter);
        I().T0().observe(this, new Observer() { // from class: ed.p0
            public /* synthetic */ p0() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                ReadingBookMarkFragment.s0(Function1.this, obj);
            }
        });
        AppViewModel G = G();
        if (G != null && (i02 = G.i0()) != null) {
            i02.observe(this, new Observer() { // from class: ed.q0
                public /* synthetic */ q0() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    ReadingBookMarkFragment.t0(Function1.this, obj);
                }
            });
        }
        BookMarkListAdapter bookMarkListAdapter = this.bookMarkListAdapter;
        if (bookMarkListAdapter != null) {
            bookMarkListAdapter.q(new ReadingBookMarkFragment$initView$3(this));
        }
    }

    public static final void s0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t0(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    @JvmStatic
    @k
    public static final ReadingBookMarkFragment u0() {
        return INSTANCE.a();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        r0();
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        if (isVisible()) {
            v0();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: p0 */
    public ReadingViewModel I() {
        return (ReadingViewModel) this.mViewModel.getValue();
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
    }

    public final void v0() {
        I().d0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void w0(List<? extends MiBookMark> miBookMarks) {
        List<? extends MiBookMark> list = miBookMarks;
        if (list == null || list.isEmpty()) {
            ((FragmentReadingBookMarkBinding) n()).rvMarks.setVisibility(8);
            ((FragmentReadingBookMarkBinding) n()).llEmpty.setVisibility(0);
            return;
        }
        ((FragmentReadingBookMarkBinding) n()).llEmpty.setVisibility(8);
        ((FragmentReadingBookMarkBinding) n()).rvMarks.setVisibility(0);
        BookMarkListAdapter bookMarkListAdapter = this.bookMarkListAdapter;
        if (bookMarkListAdapter != null) {
            bookMarkListAdapter.r(miBookMarks);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void x0(boolean enable) {
        ((FragmentReadingBookMarkBinding) n()).rvMarks.setNestedScrollingEnabled(enable);
    }
}
