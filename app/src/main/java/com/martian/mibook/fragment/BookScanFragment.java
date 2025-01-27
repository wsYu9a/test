package com.martian.mibook.fragment;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import ba.l;
import ce.v;
import com.martian.libmars.activity.BaseActivity;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.R;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.databinding.BookListBinding;
import com.martian.mibook.fragment.BookScanFragment;
import com.martian.mibook.lib.model.data.BookWrapper;
import e9.c;
import java.util.ArrayList;
import java.util.LinkedList;
import l9.m0;
import vb.e;
import ya.d0;
import ya.j2;

/* loaded from: classes3.dex */
public class BookScanFragment extends Fragment {

    /* renamed from: n */
    public static final String f13642n = MiConfigSingleton.P0;

    /* renamed from: o */
    public static final int f13643o = 10;

    /* renamed from: c */
    public v f13644c;

    /* renamed from: g */
    public String[] f13648g;

    /* renamed from: h */
    public String f13649h;

    /* renamed from: i */
    public ArrayList<FileInfo> f13650i;

    /* renamed from: j */
    public BookListBinding f13651j;

    /* renamed from: k */
    public d0 f13652k;

    /* renamed from: l */
    public c f13653l;

    /* renamed from: d */
    public boolean f13645d = false;

    /* renamed from: e */
    public boolean f13646e = false;

    /* renamed from: f */
    public int f13647f = 0;

    /* renamed from: m */
    public final d0.a f13654m = new a();

    public class a implements d0.a {
        public a() {
        }

        @Override // ya.d0.a
        @SuppressLint({"SetTextI18n"})
        public void a() {
            if (m0.C(BookScanFragment.this.getActivity())) {
                BookScanFragment.this.f13651j.bsFileScan.setText(BookScanFragment.this.getString(R.string.scan_finish) + BookScanFragment.this.f13650i.size() + "个" + BookScanFragment.this.f13648g[0] + BookScanFragment.this.getString(R.string.file));
                BookScanFragment.this.f13645d = true;
                BookScanFragment.this.f13651j.bsStopScan.setText(BookScanFragment.this.getResources().getString(R.string.start_scan));
                BookScanFragment.this.f13644c.k();
                BookScanFragment.this.f13644c.notifyDataSetChanged();
            }
        }

        @Override // ya.d0.a
        @SuppressLint({"SetTextI18n"})
        public void b() {
            if (m0.C(BookScanFragment.this.getActivity())) {
                BookScanFragment.this.f13651j.bsFileScan.setText(BookScanFragment.this.getString(R.string.scan) + BookScanFragment.this.f13650i.size() + "个" + BookScanFragment.this.f13648g[0] + BookScanFragment.this.getString(R.string.file));
                BookScanFragment.this.f13644c.notifyDataSetChanged();
            }
        }
    }

    public class b implements MiBookManager.a0 {

        /* renamed from: a */
        public final /* synthetic */ int f13656a;

        /* renamed from: b */
        public final /* synthetic */ int f13657b;

        public b(int i10, int i11) {
            this.f13656a = i10;
            this.f13657b = i11;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String str) {
            BookScanFragment.this.N(this.f13656a, this.f13657b);
            if (BookScanFragment.this.f13644c != null) {
                BookScanFragment.this.f13644c.notifyDataSetChanged();
            }
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper bookWrapper) {
            if (m0.C(BookScanFragment.this.getActivity())) {
                ac.a.o(BookScanFragment.this.getActivity(), "扫描导入:" + bookWrapper.book.getBookName());
                BookScanFragment bookScanFragment = BookScanFragment.this;
                bookScanFragment.f13647f = bookScanFragment.f13647f + 1;
                BookScanFragment.this.N(this.f13656a, this.f13657b);
                if (BookScanFragment.this.f13644c != null) {
                    BookScanFragment.this.f13644c.notifyDataSetChanged();
                }
            }
        }
    }

    private void A() {
        if (this.f13652k == null) {
            this.f13652k = new d0();
        }
        v vVar = new v(getActivity(), this.f13650i, this.f13649h);
        this.f13644c = vVar;
        this.f13651j.list.setAdapter((ListAdapter) vVar);
        registerForContextMenu(this.f13651j.list);
        this.f13651j.list.setChoiceMode(2);
        this.f13651j.list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: db.r
            public /* synthetic */ r() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                BookScanFragment.this.H(adapterView, view, i10, j10);
            }
        });
        this.f13651j.tvSelectAll.setEnabled(true);
        this.f13651j.tvAddBookRack.setEnabled(true);
    }

    public /* synthetic */ void I(View view) {
        boolean isExternalStorageManager;
        if (getActivity() == null) {
            return;
        }
        if (this.f13653l != null && ea.c.h(getActivity(), MiConfigSingleton.b2().I0()) && Build.VERSION.SDK_INT >= 30) {
            isExternalStorageManager = Environment.isExternalStorageManager();
            if (!isExternalStorageManager) {
                this.f13653l.d(j2.V, Integer.valueOf(j2.Y));
                return;
            }
        }
        T();
    }

    public /* synthetic */ void K(View view) {
        P();
    }

    public /* synthetic */ void M(View view) {
        x();
    }

    public static BookScanFragment O(String[] strArr, String str) {
        BookScanFragment bookScanFragment = new BookScanFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("FILE_TYPE", strArr);
        bundle.putString("ACTIVITY_TYPE", str);
        bookScanFragment.setArguments(bundle);
        return bookScanFragment;
    }

    private void z() {
        c cVar = new c();
        this.f13653l = cVar;
        cVar.c(j2.T, new wj.b() { // from class: db.o
            public /* synthetic */ o() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                BookScanFragment.this.B((Boolean) obj);
            }
        });
        this.f13653l.c(j2.U, new wj.b() { // from class: db.p
            public /* synthetic */ p() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                BookScanFragment.this.C((Boolean) obj);
            }
        });
        new Handler().postDelayed(new Runnable() { // from class: db.q
            public /* synthetic */ q() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                BookScanFragment.this.G();
            }
        }, 300L);
    }

    public final /* synthetic */ void B(Boolean bool) {
        U();
    }

    public final /* synthetic */ void C(Boolean bool) {
        T();
    }

    public final /* synthetic */ void G() {
        if (getActivity() == null) {
            return;
        }
        if (ea.c.h(getActivity(), MiConfigSingleton.b2().I0())) {
            this.f13653l.d(j2.V, Integer.valueOf(j2.X));
        } else {
            this.f13653l.d(j2.V, Integer.valueOf(j2.W));
        }
    }

    public final /* synthetic */ void H(AdapterView adapterView, View view, int i10, long j10) {
        this.f13644c.m(i10, null);
        this.f13644c.notifyDataSetChanged();
        Q(false);
    }

    public void N(int i10, int i11) {
        if (i10 == i11 - 1) {
            this.f13651j.bsImport.setVisibility(8);
            R("已成功添加" + this.f13647f + "本图书");
            this.f13651j.tvSelectAll.setEnabled(true);
            this.f13651j.tvAddBookRack.setEnabled(true);
            this.f13646e = false;
            this.f13651j.tvSelectAll.setText(getResources().getString(R.string.select_all));
            Q(true);
        }
    }

    public final void P() {
        if (this.f13646e) {
            this.f13644c.i(false);
            this.f13646e = false;
            this.f13651j.tvSelectAll.setText(getResources().getString(R.string.select_all));
        } else {
            this.f13644c.i(true);
            this.f13646e = true;
            this.f13651j.tvSelectAll.setText(getResources().getString(R.string.cancel_select_all));
        }
        Q(false);
        v vVar = this.f13644c;
        if (vVar != null) {
            vVar.notifyDataSetChanged();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void Q(boolean z10) {
        if (l.q(this.f13649h)) {
            return;
        }
        String str = "(0)";
        if (this.f13649h.equals("BOOKSTORE")) {
            ThemeTextView themeTextView = this.f13651j.tvAddBookRack;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(R.string.add_bookstore));
            if (!z10) {
                str = "(" + this.f13644c.e().size() + ")";
            }
            sb2.append(str);
            themeTextView.setText(sb2.toString());
            return;
        }
        if (this.f13649h.equals("TYPEFACE")) {
            ThemeTextView themeTextView2 = this.f13651j.tvAddBookRack;
            StringBuilder sb3 = new StringBuilder();
            sb3.append(getResources().getString(R.string.add_typeface));
            if (!z10) {
                str = "(" + this.f13644c.e().size() + ")";
            }
            sb3.append(str);
            themeTextView2.setText(sb3.toString());
        }
    }

    public void R(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).P1(str);
        }
    }

    public void S() {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).P1(getResources().getString(R.string.request_storage_write_permission));
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void T() {
        if (this.f13645d) {
            this.f13651j.bsFileScan.setText(getResources().getString(R.string.scanning));
            this.f13645d = false;
            this.f13651j.bsStopScan.setText(getResources().getString(R.string.stop_scan));
            this.f13650i.clear();
            d0 d0Var = this.f13652k;
            if (d0Var != null) {
                d0Var.b(f13642n, this.f13650i, 8, this.f13648g, this.f13654m);
            }
        } else {
            this.f13651j.bsFileScan.setText(getString(R.string.scan_finish) + this.f13650i.size() + "个" + this.f13648g[0] + getString(R.string.file));
            this.f13645d = true;
            this.f13651j.bsStopScan.setText(getResources().getString(R.string.start_scan));
            d0 d0Var2 = this.f13652k;
            if (d0Var2 != null) {
                d0Var2.d();
            }
        }
        v vVar = this.f13644c;
        if (vVar != null) {
            vVar.notifyDataSetChanged();
        }
    }

    public void U() {
        if (this.f13652k == null) {
            this.f13652k = new d0();
        }
        this.f13651j.bsFileScan.setText(getResources().getString(R.string.scanning));
        this.f13645d = false;
        this.f13651j.bsStopScan.setText(getResources().getString(R.string.stop_scan));
        this.f13650i.clear();
        this.f13652k.b(f13642n, this.f13650i, 4, this.f13648g, this.f13654m);
        this.f13651j.tvSelectAll.setEnabled(true);
        this.f13651j.tvAddBookRack.setEnabled(true);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.book_list, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13648g = arguments.getStringArray("FILE_TYPE");
            this.f13649h = arguments.getString("ACTIVITY_TYPE");
        } else {
            this.f13648g = new String[]{e.f31296c, "ttb"};
            this.f13649h = "BOOKSTORE";
        }
        this.f13651j = BookListBinding.bind(inflate);
        Q(true);
        this.f13650i = new ArrayList<>();
        this.f13651j.bsStopScan.setOnClickListener(new View.OnClickListener() { // from class: db.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookScanFragment.this.I(view);
            }
        });
        this.f13651j.tvSelectAll.setOnClickListener(new View.OnClickListener() { // from class: db.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookScanFragment.this.K(view);
            }
        });
        this.f13651j.tvAddBookRack.setOnClickListener(new View.OnClickListener() { // from class: db.n
            public /* synthetic */ n() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookScanFragment.this.M(view);
            }
        });
        A();
        z();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        c cVar = this.f13653l;
        if (cVar != null) {
            cVar.b();
        }
        d0 d0Var = this.f13652k;
        if (d0Var != null) {
            d0Var.d();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int i10, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (i10 == 10) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                S();
            } else {
                U();
            }
        }
    }

    public final void x() {
        LinkedList<String> d10 = this.f13644c.d();
        if (d10 == null || d10.size() <= 0) {
            R("还没有选中任何一项哦~");
            return;
        }
        this.f13651j.tvSelectAll.setEnabled(false);
        this.f13651j.tvAddBookRack.setEnabled(false);
        int size = d10.size();
        this.f13647f = 0;
        if (!l.q(this.f13649h)) {
            if (this.f13649h.equals("BOOKSTORE")) {
                this.f13651j.bsImport.setVisibility(0);
                for (int i10 = 0; i10 < d10.size(); i10++) {
                    y(i10, size, d10.get(i10));
                }
            } else if (this.f13649h.equals("TYPEFACE")) {
                this.f13651j.bsImport.setVisibility(8);
                this.f13651j.tvSelectAll.setEnabled(true);
                this.f13651j.tvAddBookRack.setEnabled(true);
                this.f13646e = false;
                this.f13651j.tvSelectAll.setText(getResources().getString(R.string.select_all));
                MiConfigSingleton.b2().i2().r(d10);
                R("导入成功");
                if (getActivity() != null) {
                    getActivity().setResult(-1);
                }
            }
        }
        v vVar = this.f13644c;
        if (vVar != null) {
            vVar.notifyDataSetChanged();
        }
    }

    public void y(int i10, int i11, String str) {
        MiConfigSingleton.b2().M1().d1(getActivity(), str, new b(i10, i11));
    }
}
