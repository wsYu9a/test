package com.martian.mibook.mvvm.yuewen.fragment;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.gyf.immersionbar.d;
import com.kuaishou.weapon.p0.t;
import com.martian.libmars.ui.theme.ThemeImageView;
import com.martian.libmars.ui.theme.ThemeLinearLayout;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.BookrackBatchTopViewBinding;
import com.martian.mibook.databinding.FragmentReadingRecordBinding;
import com.martian.mibook.databinding.ReadingRecordBatchBottomBinding;
import com.martian.mibook.databinding.ReadingRecordSyncBottomBinding;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.base.BaseMVVMFragment;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.home.activity.HomeActivity;
import com.martian.mibook.mvvm.yuewen.adapter.ReadingRecordListAdapter;
import com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment;
import com.martian.mibook.mvvm.yuewen.viewmodel.BookShelfViewModel;
import e9.c;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.i0;
import l9.t0;
import vb.e;
import xi.k;
import xi.l;
import ya.j2;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 H2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001IB\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\b\u0010\u0005J\u000f\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\t\u0010\u0005J\u000f\u0010\n\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\n\u0010\u0005J\u000f\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000b\u0010\u0005J\u000f\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\u0005J\u0017\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0011\u0010\u0005J\u000f\u0010\u0012\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0012\u0010\u0005J\u0017\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0016\u0010\u0005J!\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\r2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u001d\u0010\u0005J\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u0005J\u0019\u0010!\u001a\u00020\u00062\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\u0006H\u0016¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0006H\u0016¢\u0006\u0004\b$\u0010\u0005J\u0015\u0010&\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\r¢\u0006\u0004\b&\u0010\u0015J\r\u0010'\u001a\u00020\r¢\u0006\u0004\b'\u0010(J\u000f\u0010)\u001a\u00020\u0006H\u0016¢\u0006\u0004\b)\u0010\u0005R\u0018\u0010,\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010+R\u0018\u00100\u001a\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00104\u001a\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b2\u00103R\u001b\u00109\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b7\u00108R\u0016\u0010<\u001a\u00020\r8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b:\u0010;R\u0018\u0010@\u001a\u0004\u0018\u00010=8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b>\u0010?R\u0018\u0010C\u001a\u0004\u0018\u00010A8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b!\u0010BR\u0018\u0010G\u001a\u0004\u0018\u00010D8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bE\u0010F¨\u0006J"}, d2 = {"Lcom/martian/mibook/mvvm/yuewen/fragment/ReadingRecordFragment;", "Lcom/martian/mibook/mvvm/base/BaseMVVMFragment;", "Lcom/martian/mibook/databinding/FragmentReadingRecordBinding;", "Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "<init>", "()V", "", "U0", "z0", "R0", "y0", "L0", "Q0", "", "handle", "C0", "(Z)Z", "E0", "c1", "selectAll", "b1", "(Z)V", "D0", "loading", "", "msg", "Z0", "(ZLjava/lang/String;)V", "B0", "X0", "i0", "Landroid/os/Bundle;", "savedInstanceState", "q", "(Landroid/os/Bundle;)V", "k", "onResume", com.umeng.ccg.a.f24245v, "a1", "V0", "()Z", "onDestroyView", "Le9/c;", "Le9/c;", "rxManager", "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter;", t.f11204d, "Lcom/martian/mibook/mvvm/yuewen/adapter/ReadingRecordListAdapter;", "readingRecordListAdapter", "Lcom/martian/mibook/databinding/ReadingRecordSyncBottomBinding;", "m", "Lcom/martian/mibook/databinding/ReadingRecordSyncBottomBinding;", "recordSyncBottomBinding", "n", "Lkotlin/Lazy;", "P0", "()Lcom/martian/mibook/mvvm/yuewen/viewmodel/BookShelfViewModel;", "mViewModel", "o", "Z", "isProcessing", "Lcom/martian/mibook/databinding/ReadingRecordBatchBottomBinding;", "p", "Lcom/martian/mibook/databinding/ReadingRecordBatchBottomBinding;", "batchBottomBinding", "Lcom/martian/mibook/databinding/BookrackBatchTopViewBinding;", "Lcom/martian/mibook/databinding/BookrackBatchTopViewBinding;", "batchTopBinding", "Landroid/app/ProgressDialog;", t.f11211k, "Landroid/app/ProgressDialog;", "loadingDialog", "s", "a", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class ReadingRecordFragment extends BaseMVVMFragment<FragmentReadingRecordBinding, BookShelfViewModel> {

    /* renamed from: s, reason: from kotlin metadata */
    @k
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: t */
    @k
    public static final String f15650t = "isNeedSyncReadRecord";

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public c rxManager;

    /* renamed from: l */
    @l
    public ReadingRecordListAdapter readingRecordListAdapter;

    /* renamed from: m, reason: from kotlin metadata */
    @l
    public ReadingRecordSyncBottomBinding recordSyncBottomBinding;

    /* renamed from: n, reason: from kotlin metadata */
    @k
    public final Lazy mViewModel = LazyKt.lazy(new Function0<BookShelfViewModel>() { // from class: com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment$mViewModel$2
        public ReadingRecordFragment$mViewModel$2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        @k
        public final BookShelfViewModel invoke() {
            ViewModelStoreOwner activity = ReadingRecordFragment.this.getActivity();
            if (activity == null) {
                activity = ReadingRecordFragment.this;
            }
            return (BookShelfViewModel) new ViewModelProvider(activity).get(ReadingRecordFragment.this.M());
        }
    });

    /* renamed from: o, reason: from kotlin metadata */
    public boolean isProcessing;

    /* renamed from: p, reason: from kotlin metadata */
    @l
    public ReadingRecordBatchBottomBinding batchBottomBinding;

    /* renamed from: q, reason: from kotlin metadata */
    @l
    public BookrackBatchTopViewBinding batchTopBinding;

    /* renamed from: r */
    @l
    public ProgressDialog loadingDialog;

    /* renamed from: com.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment$a, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ ReadingRecordFragment b(Companion companion, boolean z10, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = true;
            }
            return companion.a(z10);
        }

        @JvmStatic
        @k
        public final ReadingRecordFragment a(boolean z10) {
            ReadingRecordFragment readingRecordFragment = new ReadingRecordFragment();
            Bundle bundle = new Bundle();
            bundle.putBoolean(ReadingRecordFragment.f15650t, z10);
            readingRecordFragment.setArguments(bundle);
            return readingRecordFragment;
        }

        public Companion() {
        }
    }

    public static final class b implements ReadingRecordListAdapter.a {
        public b() {
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.ReadingRecordListAdapter.a
        public void a(@l View view, @l ReadingRecordListAdapter.b bVar, int i10) {
            ReadingRecordListAdapter readingRecordListAdapter = ReadingRecordFragment.this.readingRecordListAdapter;
            if (readingRecordListAdapter == null || readingRecordListAdapter.getIsBatch()) {
                return;
            }
            ReadingRecordFragment.this.a1(true);
            ReadingRecordListAdapter readingRecordListAdapter2 = ReadingRecordFragment.this.readingRecordListAdapter;
            if (readingRecordListAdapter2 != null) {
                readingRecordListAdapter2.v(bVar, i10);
            }
            ReadingRecordFragment.this.c1();
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.ReadingRecordListAdapter.a
        public void b(@k ReadingRecordListAdapter.BookShelfOperateType operateType) {
            Intrinsics.checkNotNullParameter(operateType, "operateType");
            ReadingRecordFragment.this.B0();
            t0.b(ReadingRecordFragment.this.getContext(), ReadingRecordFragment.this.getString(R.string.operation_successful));
            ReadingRecordListAdapter.BookShelfOperateType bookShelfOperateType = ReadingRecordListAdapter.BookShelfOperateType.SINGLE_ADD_BOOK_SHELF;
            if (operateType == bookShelfOperateType || operateType == ReadingRecordListAdapter.BookShelfOperateType.BATCH_ADD_BOOK_SHELF) {
                c cVar = ReadingRecordFragment.this.rxManager;
                if (cVar != null) {
                    cVar.d(j2.f33277r, Integer.valueOf(j2.f33284y));
                }
                if (operateType == bookShelfOperateType) {
                    return;
                }
            }
            ReadingRecordFragment readingRecordFragment = ReadingRecordFragment.this;
            readingRecordFragment.Z0(false, readingRecordFragment.getString(R.string.operation_successful));
            ReadingRecordFragment.this.a1(false);
        }

        @Override // com.martian.mibook.mvvm.yuewen.adapter.ReadingRecordListAdapter.a
        public void c(@l View view, @l ReadingRecordListAdapter.b bVar, int i10) {
            ReadingRecordListAdapter readingRecordListAdapter = ReadingRecordFragment.this.readingRecordListAdapter;
            if (readingRecordListAdapter == null || !readingRecordListAdapter.getIsBatch()) {
                ReadingRecordListAdapter readingRecordListAdapter2 = ReadingRecordFragment.this.readingRecordListAdapter;
                if (readingRecordListAdapter2 != null) {
                    readingRecordListAdapter2.B(ReadingRecordFragment.this.getContext(), bVar);
                    return;
                }
                return;
            }
            ReadingRecordListAdapter readingRecordListAdapter3 = ReadingRecordFragment.this.readingRecordListAdapter;
            if (readingRecordListAdapter3 != null) {
                readingRecordListAdapter3.v(bVar, i10);
            }
            ReadingRecordFragment.this.c1();
        }
    }

    public static final void A0(ReadingRecordFragment this$0, Integer num) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (num == null) {
            return;
        }
        if (num.intValue() == j2.B) {
            this$0.a1(true);
            return;
        }
        if (num.intValue() == j2.C) {
            this$0.a1(false);
        }
    }

    private final boolean C0(boolean handle) {
        if (this.isProcessing) {
            t0.b(getContext(), getString(R.string.processing_please_wait));
            return false;
        }
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        if (readingRecordListAdapter != null) {
            if ((readingRecordListAdapter != null ? readingRecordListAdapter.getPageSize() : 0) > 0) {
                if (!handle) {
                    return true;
                }
                ReadingRecordListAdapter readingRecordListAdapter2 = this.readingRecordListAdapter;
                if (readingRecordListAdapter2 != null) {
                    if ((readingRecordListAdapter2 != null ? readingRecordListAdapter2.p() : 0) > 0) {
                        return true;
                    }
                }
                t0.b(getContext(), getString(R.string.none_actionable_books));
                return false;
            }
        }
        t0.b(getContext(), getString(R.string.none_actionable_books));
        return false;
    }

    private final void D0() {
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        if (readingRecordListAdapter != null) {
            readingRecordListAdapter.o();
        }
        c1();
    }

    public static final void F0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.a1(false);
    }

    public static final void G0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.C0(false)) {
            ReadingRecordListAdapter readingRecordListAdapter = this$0.readingRecordListAdapter;
            if (readingRecordListAdapter != null) {
                readingRecordListAdapter.y();
            }
            this$0.c1();
        }
    }

    public static final void H0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentActivity activity = this$0.getActivity();
        String string = this$0.getString(R.string.delete_hint);
        ReadingRecordListAdapter readingRecordListAdapter = this$0.readingRecordListAdapter;
        i0.z0(activity, string, ExtKt.c("是否删除选中的" + (readingRecordListAdapter != null ? Integer.valueOf(readingRecordListAdapter.p()) : null) + "条记录?"), new i0.l() { // from class: vd.q3
            public /* synthetic */ q3() {
            }

            @Override // l9.i0.l
            public final void a() {
                ReadingRecordFragment.I0(ReadingRecordFragment.this);
            }
        });
    }

    public static final void I0(ReadingRecordFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.C0(true)) {
            this$0.Z0(true, this$0.getString(R.string.deleting));
            ReadingRecordListAdapter readingRecordListAdapter = this$0.readingRecordListAdapter;
            if (readingRecordListAdapter != null) {
                readingRecordListAdapter.w();
            }
        }
    }

    public static final void J0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.C0(true)) {
            this$0.Z0(true, this$0.getString(R.string.batch_operation));
            ReadingRecordListAdapter readingRecordListAdapter = this$0.readingRecordListAdapter;
            if (readingRecordListAdapter != null) {
                readingRecordListAdapter.m(this$0.getActivity());
            }
        }
    }

    public static final void M0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ReadingRecordSyncBottomBinding readingRecordSyncBottomBinding = this$0.recordSyncBottomBinding;
        LinearLayout root = readingRecordSyncBottomBinding != null ? readingRecordSyncBottomBinding.getRoot() : null;
        if (root == null) {
            return;
        }
        root.setVisibility(8);
    }

    public static final void O0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MiConfigSingleton.b2().G1().j(this$0.getActivity(), 200);
    }

    private final void R0() {
        MiConfigSingleton.b2().M1().O2(getActivity(), new MiBookManager.f0() { // from class: vd.l3
            public /* synthetic */ l3() {
            }

            @Override // com.martian.mibook.application.MiBookManager.f0
            public final void a() {
                ReadingRecordFragment.T0(ReadingRecordFragment.this);
            }
        });
    }

    public static final void T0(ReadingRecordFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.y0();
    }

    private final void U0() {
        BookShelfViewModel I = I();
        Bundle arguments = getArguments();
        I.t(arguments != null ? arguments.getBoolean(f15650t, false) : false);
    }

    @JvmStatic
    @k
    public static final ReadingRecordFragment W0(boolean z10) {
        return INSTANCE.a(z10);
    }

    public static final void Y0(ReadingRecordFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        c cVar = this$0.rxManager;
        if (cVar != null) {
            cVar.d(j2.f33262c, Integer.valueOf(j2.f33272m));
        }
    }

    public final void Z0(boolean loading, String msg) {
        this.isProcessing = loading;
        FragmentActivity activity = getActivity();
        if (activity == null || !activity.isDestroyed()) {
            if (this.loadingDialog == null) {
                this.loadingDialog = new ProgressDialog(getContext());
            }
            ProgressDialog progressDialog = this.loadingDialog;
            if (progressDialog != null) {
                progressDialog.setMessage(msg);
            }
            if (loading) {
                ProgressDialog progressDialog2 = this.loadingDialog;
                if (progressDialog2 != null) {
                    progressDialog2.show();
                    return;
                }
                return;
            }
            ProgressDialog progressDialog3 = this.loadingDialog;
            if (progressDialog3 != null) {
                progressDialog3.dismiss();
            }
        }
    }

    private final void b1(boolean selectAll) {
        BookrackBatchTopViewBinding bookrackBatchTopViewBinding = this.batchTopBinding;
        ThemeTextView themeTextView = bookrackBatchTopViewBinding != null ? bookrackBatchTopViewBinding.bpSelectAll : null;
        if (themeTextView == null) {
            return;
        }
        themeTextView.setText(getString(selectAll ? R.string.cancel_select_all : R.string.select_all));
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void y0() {
        Book H;
        List<MiReadingRecord> miReadingRecords = MiConfigSingleton.b2().M1().a0().getMiReadingRecords();
        if (miReadingRecords == null || miReadingRecords.isEmpty()) {
            X0();
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (MiReadingRecord miReadingRecord : miReadingRecords) {
            if (miReadingRecord != null) {
                ReadingRecordListAdapter.b bVar = new ReadingRecordListAdapter.b();
                bVar.i(miReadingRecord);
                bVar.f(miReadingRecord.getCover());
                String sourceString = miReadingRecord.getSourceString();
                Intrinsics.checkNotNullExpressionValue(sourceString, "getSourceString(...)");
                bVar.h(StringsKt.startsWith$default(sourceString, e.f31296c, false, 2, (Object) null));
                if (!bVar.d() && TextUtils.isEmpty(miReadingRecord.getCover()) && (H = MiConfigSingleton.b2().M1().H(miReadingRecord.getSourceString())) != null) {
                    bVar.f(H.getCover());
                    miReadingRecord.setCover(H.getCover());
                }
                bVar.g(MiConfigSingleton.b2().M1().T().v(miReadingRecord.getSourceString()));
                arrayList.add(bVar);
            }
        }
        if (this.readingRecordListAdapter == null) {
            ReadingRecordListAdapter readingRecordListAdapter = new ReadingRecordListAdapter();
            this.readingRecordListAdapter = readingRecordListAdapter;
            readingRecordListAdapter.A(new b());
            ((FragmentReadingRecordBinding) n()).rvRecord.setLayoutManager(new LinearLayoutManager(getContext()));
            ((FragmentReadingRecordBinding) n()).rvRecord.setAdapter(this.readingRecordListAdapter);
        }
        ReadingRecordListAdapter readingRecordListAdapter2 = this.readingRecordListAdapter;
        if (readingRecordListAdapter2 != null) {
            readingRecordListAdapter2.C(arrayList);
        }
        T(((FragmentReadingRecordBinding) n()).rvLoadedTip);
        if (!I().getCom.martian.mibook.mvvm.yuewen.fragment.ReadingRecordFragment.t java.lang.String() || MiConfigSingleton.b2().N2()) {
            Q0();
        } else {
            L0();
        }
    }

    private final void z0() {
        FragmentActivity activity = getActivity();
        if (Intrinsics.areEqual(activity != null ? activity.getClass() : null, HomeActivity.class)) {
            c cVar = new c();
            this.rxManager = cVar;
            cVar.c(j2.A, new wj.b() { // from class: vd.k3
                public /* synthetic */ k3() {
                }

                @Override // wj.b
                public final void call(Object obj) {
                    ReadingRecordFragment.A0(ReadingRecordFragment.this, (Integer) obj);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void B0() {
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        if (readingRecordListAdapter == null || (readingRecordListAdapter != null && readingRecordListAdapter.getPageSize() == 0)) {
            X0();
        } else {
            T(((FragmentReadingRecordBinding) n()).rvLoadedTip);
        }
    }

    public final void E0() {
        ThemeLinearLayout themeLinearLayout;
        ThemeLinearLayout themeLinearLayout2;
        ThemeTextView themeTextView;
        ThemeTextView themeTextView2;
        Window window;
        Window window2;
        ThemeLinearLayout themeLinearLayout3;
        if (this.batchTopBinding == null || this.batchBottomBinding == null) {
            this.batchBottomBinding = ReadingRecordBatchBottomBinding.bind(View.inflate(getContext(), R.layout.reading_record_batch_bottom, null));
            BookrackBatchTopViewBinding bind = BookrackBatchTopViewBinding.bind(View.inflate(getContext(), R.layout.bookrack_batch_top_view, null));
            this.batchTopBinding = bind;
            if (bind != null && (themeLinearLayout3 = bind.brHeaderSetting) != null) {
                themeLinearLayout3.setPadding(0, d.J0(requireContext()), 0, 0);
            }
            FragmentActivity activity = getActivity();
            if (activity != null && (window2 = activity.getWindow()) != null) {
                BookrackBatchTopViewBinding bookrackBatchTopViewBinding = this.batchTopBinding;
                window2.addContentView(bookrackBatchTopViewBinding != null ? bookrackBatchTopViewBinding.getRoot() : null, new FrameLayout.LayoutParams(-1, -2));
            }
            FragmentActivity activity2 = getActivity();
            if (activity2 != null && (window = activity2.getWindow()) != null) {
                ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding = this.batchBottomBinding;
                window.addContentView(readingRecordBatchBottomBinding != null ? readingRecordBatchBottomBinding.getRoot() : null, new FrameLayout.LayoutParams(-1, -2, 80));
            }
            BookrackBatchTopViewBinding bookrackBatchTopViewBinding2 = this.batchTopBinding;
            if (bookrackBatchTopViewBinding2 != null && (themeTextView2 = bookrackBatchTopViewBinding2.bpDone) != null) {
                themeTextView2.setOnClickListener(new View.OnClickListener() { // from class: vd.m3
                    public /* synthetic */ m3() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingRecordFragment.F0(ReadingRecordFragment.this, view);
                    }
                });
            }
            BookrackBatchTopViewBinding bookrackBatchTopViewBinding3 = this.batchTopBinding;
            if (bookrackBatchTopViewBinding3 != null && (themeTextView = bookrackBatchTopViewBinding3.bpSelectAll) != null) {
                themeTextView.setOnClickListener(new View.OnClickListener() { // from class: vd.n3
                    public /* synthetic */ n3() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingRecordFragment.G0(ReadingRecordFragment.this, view);
                    }
                });
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding2 = this.batchBottomBinding;
            if (readingRecordBatchBottomBinding2 != null && (themeLinearLayout2 = readingRecordBatchBottomBinding2.rrDeleteView) != null) {
                themeLinearLayout2.setOnClickListener(new View.OnClickListener() { // from class: vd.o3
                    public /* synthetic */ o3() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingRecordFragment.H0(ReadingRecordFragment.this, view);
                    }
                });
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding3 = this.batchBottomBinding;
            if (readingRecordBatchBottomBinding3 != null && (themeLinearLayout = readingRecordBatchBottomBinding3.rrAddBookstoreView) != null) {
                themeLinearLayout.setOnClickListener(new View.OnClickListener() { // from class: vd.p3
                    public /* synthetic */ p3() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingRecordFragment.J0(ReadingRecordFragment.this, view);
                    }
                });
            }
        }
        D0();
    }

    public final void L0() {
        ThemeTextView themeTextView;
        ThemeImageView themeImageView;
        Window window;
        if (this.recordSyncBottomBinding == null) {
            this.recordSyncBottomBinding = ReadingRecordSyncBottomBinding.bind(View.inflate(getContext(), R.layout.reading_record_sync_bottom, null));
            FragmentActivity activity = getActivity();
            if (activity != null && (window = activity.getWindow()) != null) {
                ReadingRecordSyncBottomBinding readingRecordSyncBottomBinding = this.recordSyncBottomBinding;
                window.addContentView(readingRecordSyncBottomBinding != null ? readingRecordSyncBottomBinding.getRoot() : null, new FrameLayout.LayoutParams(-1, -2, 80));
            }
            ReadingRecordSyncBottomBinding readingRecordSyncBottomBinding2 = this.recordSyncBottomBinding;
            if (readingRecordSyncBottomBinding2 != null && (themeImageView = readingRecordSyncBottomBinding2.recordSyncClose) != null) {
                themeImageView.setOnClickListener(new View.OnClickListener() { // from class: vd.r3
                    public /* synthetic */ r3() {
                    }

                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        ReadingRecordFragment.M0(ReadingRecordFragment.this, view);
                    }
                });
            }
            ReadingRecordSyncBottomBinding readingRecordSyncBottomBinding3 = this.recordSyncBottomBinding;
            if (readingRecordSyncBottomBinding3 == null || (themeTextView = readingRecordSyncBottomBinding3.recordSync) == null) {
                return;
            }
            themeTextView.setOnClickListener(new View.OnClickListener() { // from class: vd.s3
                public /* synthetic */ s3() {
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ReadingRecordFragment.O0(ReadingRecordFragment.this, view);
                }
            });
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    @k
    /* renamed from: P0 */
    public BookShelfViewModel I() {
        return (BookShelfViewModel) this.mViewModel.getValue();
    }

    public final void Q0() {
        ThemeImageView themeImageView;
        ReadingRecordSyncBottomBinding readingRecordSyncBottomBinding = this.recordSyncBottomBinding;
        if (readingRecordSyncBottomBinding == null || (themeImageView = readingRecordSyncBottomBinding.recordSyncClose) == null) {
            return;
        }
        themeImageView.performClick();
    }

    public final boolean V0() {
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        return (readingRecordListAdapter == null || readingRecordListAdapter == null || !readingRecordListAdapter.getIsBatch()) ? false : true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void X0() {
        O(getString(R.string.no_reading_record), ((FragmentReadingRecordBinding) n()).rvLoadedTip);
        ((FragmentReadingRecordBinding) n()).rvLoadedTip.h(getString(R.string.go_book_mall), new View.OnClickListener() { // from class: vd.j3
            public /* synthetic */ j3() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ReadingRecordFragment.Y0(ReadingRecordFragment.this, view);
            }
        });
    }

    public final void a1(boolean r52) {
        c cVar;
        if (!r52 || C0(false)) {
            if (!(getActivity() instanceof BaseMVVMActivity) && (cVar = this.rxManager) != null) {
                cVar.d(j2.f33266g, Integer.valueOf(r52 ? j2.B : 0));
            }
            ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
            if (readingRecordListAdapter != null) {
                readingRecordListAdapter.z(r52);
            }
            E0();
            if (r52) {
                Q0();
            }
            Context context = getContext();
            BookrackBatchTopViewBinding bookrackBatchTopViewBinding = this.batchTopBinding;
            l9.a.a(context, bookrackBatchTopViewBinding != null ? bookrackBatchTopViewBinding.getRoot() : null, r52, l9.a.f27956b);
            Context context2 = getContext();
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding = this.batchBottomBinding;
            l9.a.a(context2, readingRecordBatchBottomBinding != null ? readingRecordBatchBottomBinding.getRoot() : null, r52, l9.a.f27955a);
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void c1() {
        String str;
        if (this.batchBottomBinding == null) {
            return;
        }
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        int p10 = readingRecordListAdapter != null ? readingRecordListAdapter.p() : 0;
        if (p10 > 0) {
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout = readingRecordBatchBottomBinding != null ? readingRecordBatchBottomBinding.rrDeleteView : null;
            if (themeLinearLayout != null) {
                themeLinearLayout.setAlpha(1.0f);
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding2 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout2 = readingRecordBatchBottomBinding2 != null ? readingRecordBatchBottomBinding2.rrDeleteView : null;
            if (themeLinearLayout2 != null) {
                themeLinearLayout2.setEnabled(true);
            }
        } else {
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding3 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout3 = readingRecordBatchBottomBinding3 != null ? readingRecordBatchBottomBinding3.rrDeleteView : null;
            if (themeLinearLayout3 != null) {
                themeLinearLayout3.setAlpha(0.6f);
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding4 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout4 = readingRecordBatchBottomBinding4 != null ? readingRecordBatchBottomBinding4.rrDeleteView : null;
            if (themeLinearLayout4 != null) {
                themeLinearLayout4.setEnabled(false);
            }
        }
        ReadingRecordListAdapter readingRecordListAdapter2 = this.readingRecordListAdapter;
        if (readingRecordListAdapter2 != null ? readingRecordListAdapter2.n() : false) {
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding5 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout5 = readingRecordBatchBottomBinding5 != null ? readingRecordBatchBottomBinding5.rrAddBookstoreView : null;
            if (themeLinearLayout5 != null) {
                themeLinearLayout5.setAlpha(1.0f);
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding6 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout6 = readingRecordBatchBottomBinding6 != null ? readingRecordBatchBottomBinding6.rrAddBookstoreView : null;
            if (themeLinearLayout6 != null) {
                themeLinearLayout6.setEnabled(true);
            }
        } else {
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding7 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout7 = readingRecordBatchBottomBinding7 != null ? readingRecordBatchBottomBinding7.rrAddBookstoreView : null;
            if (themeLinearLayout7 != null) {
                themeLinearLayout7.setAlpha(0.6f);
            }
            ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding8 = this.batchBottomBinding;
            ThemeLinearLayout themeLinearLayout8 = readingRecordBatchBottomBinding8 != null ? readingRecordBatchBottomBinding8.rrAddBookstoreView : null;
            if (themeLinearLayout8 != null) {
                themeLinearLayout8.setEnabled(false);
            }
        }
        ReadingRecordBatchBottomBinding readingRecordBatchBottomBinding9 = this.batchBottomBinding;
        TextView textView = readingRecordBatchBottomBinding9 != null ? readingRecordBatchBottomBinding9.rrDelete : null;
        if (textView != null) {
            String string = getString(R.string.cd_delete);
            if (p10 > 0) {
                str = "(" + p10 + ")";
            } else {
                str = "";
            }
            textView.setText(string + str);
        }
        BookrackBatchTopViewBinding bookrackBatchTopViewBinding = this.batchTopBinding;
        ThemeTextView themeTextView = bookrackBatchTopViewBinding != null ? bookrackBatchTopViewBinding.bpTitle : null;
        if (themeTextView != null) {
            themeTextView.setText(ExtKt.c("已选择" + p10 + "本书"));
        }
        ReadingRecordListAdapter readingRecordListAdapter3 = this.readingRecordListAdapter;
        b1(p10 >= (readingRecordListAdapter3 != null ? readingRecordListAdapter3.getPageSize() : 0));
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMFragment
    public void i0() {
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        if (readingRecordListAdapter != null) {
            readingRecordListAdapter.r();
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment
    public void k() {
        super.k();
        z0();
        ac.a.x(getContext(), "切到阅读记录");
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        ProgressDialog progressDialog = this.loadingDialog;
        if (progressDialog != null && progressDialog.isShowing()) {
            ProgressDialog progressDialog2 = this.loadingDialog;
            if (progressDialog2 != null) {
                progressDialog2.dismiss();
            }
            this.loadingDialog = null;
        }
        c cVar = this.rxManager;
        if (cVar != null) {
            cVar.b();
        }
    }

    @Override // com.martian.mibook.mvvm.base.LazyFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        ReadingRecordListAdapter readingRecordListAdapter = this.readingRecordListAdapter;
        if (readingRecordListAdapter == null || !readingRecordListAdapter.getIsBatch()) {
            R0();
        }
    }

    @Override // com.martian.mibook.mvvm.base.BaseFragment
    public void q(@l Bundle savedInstanceState) {
        U0();
    }
}
