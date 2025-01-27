package com.martian.mibook.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
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
import com.martian.mibook.databinding.BookLocalDirectoryBinding;
import com.martian.mibook.fragment.BookSelectFragment;
import com.martian.mibook.lib.model.data.BookWrapper;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import l9.m0;
import vb.e;
import ya.d0;
import ya.j2;

/* loaded from: classes3.dex */
public class BookSelectFragment extends Fragment {

    /* renamed from: c */
    public v f13659c;

    /* renamed from: f */
    public String[] f13662f;

    /* renamed from: g */
    public String f13663g;

    /* renamed from: h */
    public d0 f13664h;

    /* renamed from: j */
    public ArrayList<FileInfo> f13666j;

    /* renamed from: k */
    public BookLocalDirectoryBinding f13667k;

    /* renamed from: l */
    public e9.c f13668l;

    /* renamed from: d */
    public boolean f13660d = false;

    /* renamed from: e */
    public String f13661e = "/'";

    /* renamed from: i */
    public int f13665i = 0;

    /* renamed from: m */
    public final d0.b f13669m = new a();

    /* renamed from: n */
    public final v.a f13670n = new b();

    public class a implements d0.b {
        public a() {
        }

        @Override // ya.d0.b
        public void a(ArrayList<FileInfo> arrayList) {
            BookSelectFragment.this.f13659c.j(arrayList);
            if (BookSelectFragment.this.f13659c.g()) {
                BookSelectFragment.this.f13667k.tvSelectAll.setEnabled(true);
                BookSelectFragment.this.f13667k.tvAddBookRack.setEnabled(true);
            }
        }
    }

    public class b implements v.a {
        public b() {
        }

        @Override // ce.v.a
        public void a() {
            BookSelectFragment.this.K();
        }

        @Override // ce.v.a
        public void b(String str) {
            BookSelectFragment.this.w(str);
        }
    }

    public class c implements MiBookManager.a0 {

        /* renamed from: a */
        public final /* synthetic */ int f13673a;

        /* renamed from: b */
        public final /* synthetic */ int f13674b;

        public c(int i10, int i11) {
            this.f13673a = i10;
            this.f13674b = i11;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String str) {
            if (m0.C(BookSelectFragment.this.getActivity())) {
                BookSelectFragment.this.G(this.f13673a, this.f13674b);
                BookSelectFragment.this.f13659c.notifyDataSetChanged();
            }
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper bookWrapper) {
            if (m0.C(BookSelectFragment.this.getActivity())) {
                ac.a.o(BookSelectFragment.this.getActivity(), "选择导入:" + bookWrapper.book.getBookName());
                BookSelectFragment bookSelectFragment = BookSelectFragment.this;
                bookSelectFragment.f13665i = bookSelectFragment.f13665i + 1;
                BookSelectFragment.this.G(this.f13673a, this.f13674b);
                BookSelectFragment.this.f13659c.notifyDataSetChanged();
            }
        }
    }

    public /* synthetic */ void A(View view) {
        N();
    }

    public /* synthetic */ void B(View view) {
        I();
    }

    public /* synthetic */ void C(View view) {
        t();
    }

    public static BookSelectFragment H(String str, String[] strArr, String str2) {
        BookSelectFragment bookSelectFragment = new BookSelectFragment();
        Bundle bundle = new Bundle();
        bundle.putString("FILE_PATH", str);
        bundle.putStringArray("FILE_TYPE", strArr);
        bundle.putString("ACTIVITY_TYPE", str2);
        bookSelectFragment.setArguments(bundle);
        return bookSelectFragment;
    }

    private void I() {
        if (this.f13660d) {
            this.f13659c.i(false);
            this.f13660d = false;
            this.f13667k.tvSelectAll.setText(getResources().getString(R.string.select_all));
        } else {
            this.f13659c.i(true);
            this.f13660d = true;
            this.f13667k.tvSelectAll.setText(getResources().getString(R.string.cancel_select_all));
        }
        K();
        this.f13659c.notifyDataSetChanged();
    }

    private void t() {
        LinkedList<String> d10 = this.f13659c.d();
        int size = d10.size();
        if (size <= 0) {
            M("还没有选中任何一项哦~");
            return;
        }
        this.f13667k.tvSelectAll.setEnabled(false);
        this.f13667k.tvAddBookRack.setEnabled(false);
        this.f13665i = 0;
        if (l.q(this.f13663g)) {
            return;
        }
        if (this.f13663g.equals("BOOKSTORE")) {
            this.f13667k.bsImportHint.setVisibility(0);
            for (int i10 = 0; i10 < size; i10++) {
                u(i10, size, d10.get(i10));
            }
            return;
        }
        if (this.f13663g.equals("TYPEFACE")) {
            this.f13667k.bsImportHint.setVisibility(8);
            this.f13667k.tvSelectAll.setEnabled(true);
            this.f13667k.tvAddBookRack.setEnabled(true);
            this.f13660d = false;
            this.f13667k.tvSelectAll.setText(getResources().getString(R.string.select_all));
            MiConfigSingleton.b2().i2().r(d10);
            if (getActivity() != null) {
                getActivity().setResult(-1);
            }
            this.f13659c.notifyDataSetChanged();
        }
    }

    private void v() {
        e9.c cVar = new e9.c();
        this.f13668l = cVar;
        cVar.c(j2.T, new wj.b() { // from class: db.s
            public /* synthetic */ s() {
            }

            @Override // wj.b
            public final void call(Object obj) {
                BookSelectFragment.this.y((Boolean) obj);
            }
        });
    }

    public /* synthetic */ void y(Boolean bool) {
        w(this.f13661e);
    }

    public void G(int i10, int i11) {
        if (i10 == i11 - 1) {
            this.f13667k.bsImportHint.setVisibility(8);
            M("已成功添加" + this.f13665i + "本图书");
            this.f13667k.tvSelectAll.setEnabled(true);
            this.f13667k.tvAddBookRack.setEnabled(true);
            this.f13660d = false;
            this.f13667k.tvSelectAll.setText(getResources().getString(R.string.select_all));
            K();
            this.f13659c.notifyDataSetChanged();
        }
    }

    @SuppressLint({"SetTextI18n"})
    public final void K() {
        if (this.f13659c != null) {
            ThemeTextView themeTextView = this.f13667k.tvAddBookRack;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString("TYPEFACE".equalsIgnoreCase(this.f13663g) ? R.string.add_typeface : R.string.add_bookstore));
            sb2.append("(");
            sb2.append(this.f13659c.e().size());
            sb2.append(")");
            themeTextView.setText(sb2.toString());
        }
    }

    public void M(String str) {
        FragmentActivity activity = getActivity();
        if (activity instanceof BaseActivity) {
            ((BaseActivity) activity).P1(str);
        }
    }

    public final void N() {
        String parent = new File(this.f13661e).getParent();
        if (parent == null) {
            M("没有上一级了哦~");
            return;
        }
        File file = new File(parent);
        if (file.exists() && file.canRead()) {
            w(parent);
        } else {
            M("文件不存在或没有访问权限~");
        }
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13661e = arguments.getString("FILE_PATH");
            this.f13662f = arguments.getStringArray("FILE_TYPE");
            this.f13663g = arguments.getString("ACTIVITY_TYPE");
        } else {
            this.f13661e = MiConfigSingleton.P0;
            this.f13662f = new String[]{e.f31296c, "ttb"};
            this.f13663g = "BOOKSTORE";
        }
        View inflate = layoutInflater.inflate(R.layout.book_local_directory, viewGroup, false);
        this.f13667k = BookLocalDirectoryBinding.bind(inflate);
        K();
        this.f13667k.bsFilepath.setText(getResources().getString(R.string.sdcard) + this.f13661e);
        this.f13667k.bsLocalUp.setOnClickListener(new View.OnClickListener() { // from class: db.t
            public /* synthetic */ t() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookSelectFragment.this.A(view);
            }
        });
        this.f13667k.tvSelectAll.setOnClickListener(new View.OnClickListener() { // from class: db.u
            public /* synthetic */ u() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookSelectFragment.this.B(view);
            }
        });
        this.f13667k.tvAddBookRack.setOnClickListener(new View.OnClickListener() { // from class: db.v
            public /* synthetic */ v() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                BookSelectFragment.this.C(view);
            }
        });
        x();
        v();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        e9.c cVar = this.f13668l;
        if (cVar != null) {
            cVar.b();
        }
        MiConfigSingleton.b2().c3(this.f13661e);
        d0 d0Var = this.f13664h;
        if (d0Var != null) {
            d0Var.c();
        }
    }

    public void u(int i10, int i11, String str) {
        MiConfigSingleton.b2().M1().d1(getActivity(), str, new c(i10, i11));
    }

    @SuppressLint({"SetTextI18n"})
    public void w(String str) {
        if (this.f13664h == null) {
            this.f13664h = new d0();
        }
        this.f13667k.tvSelectAll.setEnabled(false);
        this.f13667k.tvAddBookRack.setEnabled(false);
        this.f13661e = str;
        K();
        this.f13667k.bsFilepath.setText(getResources().getString(R.string.sdcard) + str);
        this.f13667k.tvSelectAll.setText(getResources().getString(R.string.select_all));
        this.f13666j.clear();
        this.f13659c.notifyDataSetChanged();
        this.f13664h.a(str, this.f13669m, this.f13662f);
    }

    public final void x() {
        this.f13666j = new ArrayList<>();
        this.f13664h = new d0();
        v vVar = new v(getActivity(), this.f13666j, this.f13663g);
        this.f13659c = vVar;
        this.f13667k.list.setAdapter((ListAdapter) vVar);
        registerForContextMenu(this.f13667k.list);
        this.f13667k.list.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: db.w
            public /* synthetic */ w() {
            }

            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
                BookSelectFragment.this.z(adapterView, view, i10, j10);
            }
        });
    }

    public final /* synthetic */ void z(AdapterView adapterView, View view, int i10, long j10) {
        this.f13659c.l(i10, this.f13670n);
        this.f13659c.notifyDataSetChanged();
    }
}
