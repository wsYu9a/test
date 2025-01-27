package com.martian.mibook.f;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
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
import java.util.ArrayList;
import java.util.LinkedList;

/* loaded from: classes3.dex */
public class s3 extends Fragment {

    /* renamed from: a */
    private p4 f13256a;

    /* renamed from: e */
    private String[] f13260e;

    /* renamed from: f */
    private String f13261f;

    /* renamed from: g */
    private ArrayList<FileInfo> f13262g;

    /* renamed from: h */
    private com.martian.mibook.e.v0 f13263h;

    /* renamed from: i */
    private com.martian.mibook.application.j0 f13264i;

    /* renamed from: b */
    private boolean f13257b = false;

    /* renamed from: c */
    private boolean f13258c = false;

    /* renamed from: d */
    private int f13259d = 0;

    /* renamed from: j */
    private final j0.a f13265j = new a();

    class a implements j0.a {
        a() {
        }

        @Override // com.martian.mibook.application.j0.a
        @SuppressLint({"SetTextI18n"})
        public void a() {
            if (com.martian.libmars.utils.n0.C(s3.this.getActivity())) {
                s3.this.f13263h.f12809b.setText(s3.this.getString(R.string.scan_finish) + s3.this.f13262g.size() + "个" + s3.this.f13260e[0] + s3.this.getString(R.string.file));
                s3.this.f13257b = true;
                s3.this.f13263h.f12811d.setText(s3.this.getResources().getString(R.string.start_scan));
                s3.this.f13256a.j();
                s3.this.f13256a.notifyDataSetChanged();
            }
        }

        @Override // com.martian.mibook.application.j0.a
        @SuppressLint({"SetTextI18n"})
        public void b() {
            if (com.martian.libmars.utils.n0.C(s3.this.getActivity())) {
                s3.this.f13263h.f12809b.setText(s3.this.getString(R.string.scan) + s3.this.f13262g.size() + "个" + s3.this.f13260e[0] + s3.this.getString(R.string.file));
                s3.this.f13256a.notifyDataSetChanged();
            }
        }
    }

    class b implements MiBookManager.a0 {

        /* renamed from: a */
        final /* synthetic */ int f13267a;

        /* renamed from: b */
        final /* synthetic */ int f13268b;

        b(final int val$size, final int val$i) {
            this.f13267a = val$size;
            this.f13268b = val$i;
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void a(String errMsg) {
            s3.this.s(this.f13267a, this.f13268b);
            s3.this.f13256a.notifyDataSetChanged();
        }

        @Override // com.martian.mibook.application.MiBookManager.a0
        public void b(BookWrapper item) {
            if (com.martian.libmars.utils.n0.C(s3.this.getActivity())) {
                com.martian.mibook.lib.model.g.b.q(s3.this.getActivity(), "扫描导入:" + item.book.getBookName());
                s3.f(s3.this);
                s3.this.s(this.f13267a, this.f13268b);
                s3.this.f13256a.notifyDataSetChanged();
            }
        }
    }

    static /* synthetic */ int f(s3 s3Var) {
        int i2 = s3Var.f13259d;
        s3Var.f13259d = i2 + 1;
        return i2;
    }

    private void g() {
        LinkedList<String> c2 = this.f13256a.c();
        if (c2 == null || c2.size() <= 0) {
            w("还没有选中任何一项哦~");
            return;
        }
        this.f13263h.f12814g.setEnabled(false);
        this.f13263h.f12813f.setEnabled(false);
        int size = c2.size();
        this.f13259d = 0;
        if (!com.martian.libsupport.k.p(this.f13261f)) {
            if (this.f13261f.equals("BOOKSTORE")) {
                this.f13263h.f12810c.setVisibility(0);
                for (int i2 = 0; i2 < c2.size(); i2++) {
                    h(i2, size, c2.get(i2));
                }
            } else if (this.f13261f.equals("TYPEFACE")) {
                this.f13263h.f12810c.setVisibility(8);
                this.f13263h.f12814g.setEnabled(true);
                this.f13263h.f12813f.setEnabled(true);
                this.f13258c = false;
                this.f13263h.f12814g.setText(getResources().getString(R.string.select_all));
                new TypefaceManager(getActivity()).k(c2);
                w("导入成功");
                if (getActivity() != null) {
                    getActivity().setResult(-1);
                }
            }
        }
        this.f13256a.notifyDataSetChanged();
    }

    /* renamed from: i */
    public /* synthetic */ void j() {
        x();
        if (getActivity() != null) {
            ActivityCompat.requestPermissions(getActivity(), new String[]{com.kuaishou.weapon.p0.g.f9325j}, 10);
        }
    }

    /* renamed from: k */
    public /* synthetic */ void l(View view13) {
        y();
    }

    /* renamed from: m */
    public /* synthetic */ void n(View view12) {
        u();
    }

    /* renamed from: o */
    public /* synthetic */ void p(View view1) {
        g();
    }

    /* renamed from: q */
    public /* synthetic */ void r(AdapterView adapterView, View view, int i2, long l) {
        this.f13256a.l(i2, null);
        this.f13256a.notifyDataSetChanged();
        v(false);
    }

    public static s3 t(String[] fileType, String activityType) {
        s3 s3Var = new s3();
        Bundle bundle = new Bundle();
        bundle.putStringArray("FILE_TYPE", fileType);
        bundle.putString("ACTIVITY_TYPE", activityType);
        s3Var.setArguments(bundle);
        return s3Var;
    }

    private void u() {
        if (this.f13258c) {
            this.f13256a.h(false);
            this.f13258c = false;
            this.f13263h.f12814g.setText(getResources().getString(R.string.select_all));
        } else {
            this.f13256a.h(true);
            this.f13258c = true;
            this.f13263h.f12814g.setText(getResources().getString(R.string.cancel_select_all));
        }
        v(false);
        this.f13256a.notifyDataSetChanged();
    }

    @SuppressLint({"SetTextI18n"})
    private void v(boolean isZero) {
        if (com.martian.libsupport.k.p(this.f13261f)) {
            return;
        }
        String str = "(0)";
        if (this.f13261f.equals("BOOKSTORE")) {
            ThemeTextView themeTextView = this.f13263h.f12813f;
            StringBuilder sb = new StringBuilder();
            sb.append(getResources().getString(R.string.add_bookstore));
            if (!isZero) {
                str = "(" + this.f13256a.d().size() + ")";
            }
            sb.append(str);
            themeTextView.setText(sb.toString());
            return;
        }
        if (this.f13261f.equals("TYPEFACE")) {
            ThemeTextView themeTextView2 = this.f13263h.f12813f;
            StringBuilder sb2 = new StringBuilder();
            sb2.append(getResources().getString(R.string.add_typeface));
            if (!isZero) {
                str = "(" + this.f13256a.d().size() + ")";
            }
            sb2.append(str);
            themeTextView2.setText(sb2.toString());
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void y() {
        if (this.f13257b) {
            this.f13263h.f12809b.setText(getResources().getString(R.string.scanning));
            this.f13257b = false;
            this.f13263h.f12811d.setText(getResources().getString(R.string.stop_scan));
            this.f13262g.clear();
            this.f13264i.b(MiConfigSingleton.B0, this.f13262g, 6, this.f13260e, this.f13265j);
        } else {
            this.f13263h.f12809b.setText(getString(R.string.scan_finish) + this.f13262g.size() + "个" + this.f13260e[0] + getString(R.string.file));
            this.f13257b = true;
            this.f13263h.f12811d.setText(getResources().getString(R.string.start_scan));
            this.f13264i.d();
        }
        this.f13256a.notifyDataSetChanged();
    }

    public void h(final int i2, final int size, String selectFile) {
        MiConfigSingleton.V3().l3().L1(getActivity(), selectFile, new b(i2, size));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.book_list, container, false);
        MiConfigSingleton.V3().G6(getActivity(), 10, new MiConfigSingleton.z() { // from class: com.martian.mibook.f.a0
            @Override // com.martian.mibook.application.MiConfigSingleton.z
            public final void a() {
                s3.this.j();
            }
        });
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f13260e = arguments.getStringArray("FILE_TYPE");
            this.f13261f = arguments.getString("ACTIVITY_TYPE");
        } else {
            this.f13260e = new String[]{com.martian.mibook.lib.model.manager.d.f14056h, "ttb"};
            this.f13261f = "BOOKSTORE";
        }
        this.f13263h = com.martian.mibook.e.v0.a(inflate);
        v(true);
        this.f13262g = new ArrayList<>();
        this.f13263h.f12811d.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.y
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s3.this.l(view);
            }
        });
        this.f13263h.f12814g.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.x
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s3.this.n(view);
            }
        });
        this.f13263h.f12813f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.z
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                s3.this.p(view);
            }
        });
        return inflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.f13264i.d();
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 10) {
            if (grantResults.length <= 0 || grantResults[0] != 0) {
                x();
            } else {
                z();
            }
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.f13256a == null) {
            z();
        }
    }

    public void s(int tag, int size) {
        if (tag == size - 1) {
            this.f13263h.f12810c.setVisibility(8);
            w("已成功添加" + this.f13259d + "本图书");
            this.f13263h.f12814g.setEnabled(true);
            this.f13263h.f12813f.setEnabled(true);
            this.f13258c = false;
            this.f13263h.f12814g.setText(getResources().getString(R.string.select_all));
            v(true);
        }
    }

    public void w(String msg) {
        FragmentActivity activity = getActivity();
        if (activity instanceof com.martian.libmars.activity.h1) {
            ((com.martian.libmars.activity.h1) activity).k1(msg);
        }
    }

    public void x() {
        FragmentActivity activity = getActivity();
        if (activity instanceof com.martian.libmars.activity.h1) {
            ((com.martian.libmars.activity.h1) activity).k1(getResources().getString(R.string.request_storage_write_permission));
        }
    }

    public void z() {
        this.f13264i = new com.martian.mibook.application.j0();
        this.f13256a = new p4(getActivity(), this.f13262g, this.f13261f);
        this.f13264i.b(MiConfigSingleton.B0, this.f13262g, 4, this.f13260e, this.f13265j);
        this.f13263h.f12814g.setEnabled(true);
        this.f13263h.f12813f.setEnabled(true);
        this.f13263h.f12812e.setAdapter((ListAdapter) this.f13256a);
        registerForContextMenu(this.f13263h.f12812e);
        this.f13263h.f12812e.setChoiceMode(2);
        this.f13263h.f12812e.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.martian.mibook.f.w
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i2, long j2) {
                s3.this.r(adapterView, view, i2, j2);
            }
        });
    }
}
