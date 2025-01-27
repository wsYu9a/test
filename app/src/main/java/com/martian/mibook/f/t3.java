package com.martian.mibook.f;

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
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.TypefaceManager;
import com.martian.mibook.application.j0;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.lib.model.data.BookWrapper;
import com.martian.mibook.ui.o.p4;
import com.martian.ttbookhd.R;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class t3 extends Fragment {

    /* renamed from: a */
    private p4 f13277a;

    /* renamed from: d */
    private String[] f13280d;

    /* renamed from: e */
    private String f13281e;

    /* renamed from: f */
    private com.martian.mibook.application.j0 f13282f;

    /* renamed from: h */
    private ArrayList<FileInfo> f13284h;

    /* renamed from: i */
    private com.martian.mibook.e.w0 f13285i;

    /* renamed from: b */
    private boolean f13278b = false;

    /* renamed from: c */
    private String f13279c = "/'";

    /* renamed from: g */
    private int f13283g = 0;

    /* renamed from: j */
    private final j0.b f13286j = new a();
    private final p4.a k = new b();

    class a implements j0.b {
        a() {
        }

        @Override // com.martian.mibook.application.j0.b
        public void a(ArrayList<FileInfo> list) {
            t3.this.f13277a.i(list);
            if (t3.this.f13277a.f()) {
                t3.this.f13285i.f12864i.setEnabled(true);
                t3.this.f13285i.f12863h.setEnabled(true);
            }
        }
    }

    class b implements p4.a {
        b() {
        }

        @Override // com.martian.mibook.ui.o.p4.a
        public void a() {
            t3.this.t();
        }

        @Override // com.martian.mibook.ui.o.p4.a
        public void b(String filepath) {
            t3.this.g(filepath);
        }
    }

    class c implements MiBookManager.a0 {

        /* renamed from: a */
        final /* synthetic */ int f13289a;

        /* renamed from: b */
        final /* synthetic */ int f13290b;

        c(final int val$size, final int val$i) {
            this.f13289a = val$size;
            this.f13290b = val$i;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String errMsg) {
            if (com.martian.libmars.utils.n0.C(t3.this.getActivity())) {
                t3.this.q(this.f13289a, this.f13290b);
                t3.this.f13277a.notifyDataSetChanged();
            }
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper item) {
            if (com.martian.libmars.utils.n0.C(t3.this.getActivity())) {
                com.martian.mibook.lib.model.g.b.q(t3.this.getActivity(), "选择导入:" + item.book.getBookName());
                t3.d(t3.this);
                t3.this.q(this.f13289a, this.f13290b);
                t3.this.f13277a.notifyDataSetChanged();
            }
        }
    }

    static /* synthetic */ int d(t3 t3Var) {
        int i2 = t3Var.f13283g;
        t3Var.f13283g = i2 + 1;
        return i2;
    }

    private void e() {
        LinkedList<String> c2 = this.f13277a.c();
        int size = c2.size();
        if (size <= 0) {
            u("还没有选中任何一项哦~");
            return;
        }
        this.f13285i.f12864i.setEnabled(false);
        this.f13285i.f12863h.setEnabled(false);
        this.f13283g = 0;
        if (com.martian.libsupport.k.p(this.f13281e)) {
            return;
        }
        if (this.f13281e.equals("BOOKSTORE")) {
            this.f13285i.f12858c.setVisibility(0);
            for (int i2 = 0; i2 < size; i2++) {
                f(i2, size, c2.get(i2));
            }
            return;
        }
        if (this.f13281e.equals("TYPEFACE")) {
            this.f13285i.f12858c.setVisibility(8);
            this.f13285i.f12864i.setEnabled(true);
            this.f13285i.f12863h.setEnabled(true);
            this.f13278b = false;
            this.f13285i.f12864i.setText(getResources().getString(R.string.select_all));
            new TypefaceManager(getActivity()).k(c2);
            if (getActivity() != null) {
                getActivity().setResult(-1);
            }
            this.f13277a.notifyDataSetChanged();
        }
    }

    private void h() {
        this.f13284h = new ArrayList<>();
        this.f13282f = new com.martian.mibook.application.j0();
        p4 p4Var = new p4(getActivity(), this.f13284h, this.f13281e);
        this.f13277a = p4Var;
        this.f13285i.f12862g.setAdapter((ListAdapter) p4Var);
        registerForContextMenu(this.f13285i.f12862g);
        this.f13285i.f12862g.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.f.d0
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                t3.this.j(adapterView, view, i2, j2);
            }
        });
        g(this.f13279c);
    }

    /* renamed from: i */
    public /* synthetic */ void j(AdapterView adapterView, View view, int i2, long l) {
        this.f13277a.k(i2, this.k);
        this.f13277a.notifyDataSetChanged();
    }

    /* renamed from: k */
    public /* synthetic */ void l(View view13) {
        v();
    }

    /* renamed from: m */
    public /* synthetic */ void n(View view12) {
        s();
    }

    /* renamed from: o */
    public /* synthetic */ void p(View view1) {
        e();
    }

    public static t3 r(String filePath, String[] fileType, String activityType) {
        t3 t3Var = new t3();
        Bundle bundle = new Bundle();
        bundle.putString("FILE_PATH", filePath);
        bundle.putStringArray("FILE_TYPE", fileType);
        bundle.putString("ACTIVITY_TYPE", activityType);
        t3Var.setArguments(bundle);
        return t3Var;
    }

    private void s() {
        if (this.f13278b) {
            this.f13277a.h(false);
            this.f13278b = false;
            this.f13285i.f12864i.setText(getResources().getString(R.string.select_all));
        } else {
            this.f13277a.h(true);
            this.f13278b = true;
            this.f13285i.f12864i.setText(getResources().getString(R.string.cancel_select_all));
        }
        t();
        this.f13277a.notifyDataSetChanged();
    }

    @SuppressLint({"SetTextI18n"})
    public void t() {
        if (this.f13277a != null) {
            ThemeTextView themeTextView = this.f13285i.f12863h;
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString("TYPEFACE".equalsIgnoreCase(this.f13281e) ? R.string.add_typeface : R.string.add_bookstore));
            sb.append("(");
            sb.append(this.f13277a.d().size());
            sb.append(")");
            themeTextView.setText(sb.toString());
        }
    }

    private void v() {
        String parent = new File(this.f13279c).getParent();
        if (parent == null) {
            u("没有上一级了哦~");
            return;
        }
        File file = new File(parent);
        if (file.exists() && file.canRead()) {
            g(parent);
        } else {
            u("文件不存在或没有访问权限~");
        }
    }

    public void f(final int i2, final int size, String selectFile) {
        MiConfigSingleton.V3().l3().L1(getActivity(), selectFile, new c(i2, size));
    }

    @SuppressLint({"SetTextI18n"})
    public void g(String path) {
        this.f13285i.f12864i.setEnabled(false);
        this.f13285i.f12863h.setEnabled(false);
        this.f13279c = path;
        t();
        this.f13285i.f12857b.setText(getResources().getString(R.string.sdcard) + path);
        this.f13285i.f12864i.setText(getResources().getString(R.string.select_all));
        this.f13284h.clear();
        this.f13277a.notifyDataSetChanged();
        this.f13282f.a(path, this.f13286j, this.f13280d);
    }

    @Override // androidx.fragment.app.Fragment
    @SuppressLint({"SetTextI18n"})
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13279c = arguments.getString("FILE_PATH");
            this.f13280d = arguments.getStringArray("FILE_TYPE");
            this.f13281e = arguments.getString("ACTIVITY_TYPE");
        } else {
            this.f13279c = MiConfigSingleton.B0;
            this.f13280d = new String[]{com.martian.mibook.lib.model.manager.d.f14056h, "ttb"};
            this.f13281e = "BOOKSTORE";
        }
        View inflate = inflater.inflate(R.layout.book_local_directory, container, false);
        this.f13285i = com.martian.mibook.e.w0.a(inflate);
        t();
        this.f13285i.f12857b.setText(getResources().getString(R.string.sdcard) + this.f13279c);
        this.f13285i.f12859d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.c0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t3.this.l(view);
            }
        });
        this.f13285i.f12864i.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.e0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t3.this.n(view);
            }
        });
        this.f13285i.f12863h.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.b0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                t3.this.p(view);
            }
        });
        h();
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        MiConfigSingleton.V3().s7(this.f13279c);
        this.f13282f.c();
    }

    public void q(int tag, int size) {
        if (tag == size - 1) {
            this.f13285i.f12858c.setVisibility(8);
            u("已成功添加" + this.f13283g + "本图书");
            this.f13285i.f12864i.setEnabled(true);
            this.f13285i.f12863h.setEnabled(true);
            this.f13278b = false;
            this.f13285i.f12864i.setText(getResources().getString(R.string.select_all));
            t();
            this.f13277a.notifyDataSetChanged();
        }
    }

    public void u(String msg) {
        FragmentActivity activity = getActivity();
        if (activity instanceof com.martian.libmars.activity.h1) {
            ((com.martian.libmars.activity.h1) activity).k1(msg);
        }
    }
}
