package com.martian.mibook.f;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.ui.o.j4;
import com.martian.ttbookhd.R;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class b4 extends com.martian.libmars.f.f implements AdapterView.OnItemClickListener {

    /* renamed from: b */
    private ListView f13048b;

    /* renamed from: c */
    private View f13049c;

    /* renamed from: d */
    private TextView f13050d;

    /* renamed from: e */
    private j4 f13051e;

    class a extends b.d.c.c.g<Void, List<FileInfo>> {
        a() {
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public List<FileInfo> doInBackground(Void... params) {
            File[] listFiles = new File(MiConfigSingleton.V3().d3()).listFiles(new FileFilter() { // from class: com.martian.mibook.f.c3
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean endsWith;
                    endsWith = file.getName().endsWith(".tbs");
                    return endsWith;
                }
            });
            if (listFiles == null || listFiles.length <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                if (file.isFile()) {
                    String absolutePath = file.getAbsolutePath();
                    long h2 = com.martian.mibook.j.w2.h(file);
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file.getName();
                    fileInfo.filePath = absolutePath;
                    fileInfo.fileSize = com.martian.mibook.j.w2.b(h2);
                    fileInfo.fileDate = com.martian.mibook.j.w2.e(file);
                    fileInfo.isChecked = false;
                    arrayList.add(fileInfo);
                }
            }
            return arrayList;
        }

        @Override // b.d.c.c.g
        /* renamed from: h */
        public void onPostExecute(List<FileInfo> fileInfos) {
            super.onPostExecute(fileInfos);
            b4.this.f13051e = new j4(b4.this.getContext(), fileInfos);
            b4.this.getListView().setAdapter((ListAdapter) b4.this.f13051e);
            b4.this.y();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
            b4.this.B(show);
        }
    }

    class b extends b.d.c.c.g<Void, Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f13053a;

        b(final String val$path) {
            this.f13053a = val$path;
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public Boolean doInBackground(Void... params) {
            return Boolean.valueOf(MiConfigSingleton.V3().J6(this.f13053a));
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            if (com.martian.libmars.utils.n0.C(((com.martian.libmars.f.f) b4.this).f10086a)) {
                if (success.booleanValue()) {
                    b4.this.b("备份信息恢复成功");
                } else {
                    b4.this.b("备份信息恢复失败，请重试");
                }
                showLoading(false);
                if (b4.this.getActivity() != null) {
                    b4.this.getActivity().finish();
                }
            }
        }

        @Override // b.d.c.c.g
        protected void onPreExecute() {
            super.onPreExecute();
            showLoading(true);
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    class c extends b.d.c.c.g<Void, Boolean> {

        /* renamed from: a */
        final /* synthetic */ String f13055a;

        c(final String val$filename) {
            this.f13055a = val$filename;
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public Boolean doInBackground(Void... params) {
            return Boolean.valueOf(MiConfigSingleton.V3().U1(this.f13055a));
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Boolean success) {
            super.onPostExecute(success);
            if (success.booleanValue()) {
                b4.this.b("信息备份成功");
            } else {
                b4.this.b("信息备份失败，请重试");
            }
            b4.this.D();
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    private void A() {
        j4 j4Var = this.f13051e;
        if (j4Var == null || j4Var.getCount() == 0) {
            return;
        }
        final FileInfo c2 = this.f13051e.c();
        com.martian.libmars.utils.k0.P(a(), a().getResources().getString(R.string.delete_hint), "是否删除备份文件\"" + c2.fileName + "\"？", new k0.l() { // from class: com.martian.mibook.f.h3
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                b4.this.v(c2);
            }
        });
    }

    private void C(final FileInfo fileInfo) {
        com.martian.libmars.utils.k0.P(a(), "信息恢复提示", "是否从\"" + fileInfo.fileName + "\"恢复？\n(包括书架、归档和网页收藏。现有信息将被清空替换。)", new k0.l() { // from class: com.martian.mibook.f.e3
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                b4.this.x(fileInfo);
            }
        });
    }

    private void g(final String path) {
        new b(path).execute(new Void[0]);
    }

    private int i() {
        j4 j4Var = this.f13051e;
        if (j4Var == null) {
            return 0;
        }
        return j4Var.getCount();
    }

    private String j() {
        return "_" + (i() + 1) + ".tbs";
    }

    /* renamed from: k */
    public /* synthetic */ void l(View v) {
        z();
    }

    /* renamed from: m */
    public /* synthetic */ void n(View v) {
        j4 j4Var = this.f13051e;
        if (j4Var == null || j4Var.getCount() == 0) {
            return;
        }
        C(this.f13051e.c());
    }

    /* renamed from: o */
    public /* synthetic */ void p(View v) {
        A();
    }

    /* renamed from: q */
    public /* synthetic */ void r(final EditText et_backup_name, DialogInterface dialog, int which) {
        String obj = et_backup_name.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            b("文件名不能为空");
        } else {
            h(obj + j());
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(et_backup_name.getWindowToken(), 0);
    }

    /* renamed from: s */
    public /* synthetic */ void t(final EditText et_backup_name, DialogInterface dialog, int which) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(et_backup_name.getWindowToken(), 0);
    }

    /* renamed from: u */
    public /* synthetic */ void v(final FileInfo fileInfo) {
        if (com.martian.libsupport.e.o(fileInfo.filePath)) {
            b("删除成功");
            this.f13051e.a();
        } else {
            b("删除失败");
        }
        this.f13051e.notifyDataSetChanged();
    }

    /* renamed from: w */
    public /* synthetic */ void x(final FileInfo fileInfo) {
        g(fileInfo.filePath);
    }

    public void y() {
        j4 j4Var = this.f13051e;
        if (j4Var == null || j4Var.getCount() <= 0) {
            this.f13050d.setVisibility(8);
        } else {
            this.f13050d.setVisibility(0);
            this.f13050d.setText(this.f13051e.c().filePath);
        }
    }

    private void z() {
        if (getActivity() == null) {
            return;
        }
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_backup_name, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.et_backup_name);
        ((TextView) inflate.findViewById(R.id.tv_backup_suffix)).setText(j());
        editText.setText(MiConfigSingleton.V3().b3());
        editText.selectAll();
        new AlertDialog.Builder(getActivity()).setTitle("信息备份").setView(inflate).setPositiveButton(a().getResources().getString(R.string.cd_confirm), new DialogInterface.OnClickListener() { // from class: com.martian.mibook.f.j3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                b4.this.r(editText, dialogInterface, i2);
            }
        }).setNegativeButton(a().getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() { // from class: com.martian.mibook.f.i3
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                b4.this.t(editText, dialogInterface, i2);
            }
        }).show();
        if (getActivity() == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        editText.requestFocus();
    }

    public void B(boolean show) {
        if (show) {
            this.f13049c.setVisibility(0);
        } else {
            this.f13049c.setVisibility(8);
        }
    }

    public void D() {
        new a().execute(new Void[0]);
    }

    public ListView getListView() {
        return this.f13048b;
    }

    protected void h(final String filename) {
        new c(filename).execute(new Void[0]);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.backup_book_store, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_restore_book_store, (ViewGroup) null);
        this.f13048b = (ListView) inflate.findViewById(android.R.id.list);
        this.f13048b.setEmptyView(inflate.findViewById(R.id.ly_empty_hint));
        inflate.findViewById(R.id.tv_create_backup).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.d3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b4.this.l(view);
            }
        });
        this.f13049c = inflate.findViewById(R.id.pb_loading);
        inflate.findViewById(R.id.tv_restore_book_store).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.f3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b4.this.n(view);
            }
        });
        inflate.findViewById(R.id.tv_delete_backup).setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.f.g3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                b4.this.p(view);
            }
        });
        this.f13050d = (TextView) inflate.findViewById(R.id.tv_backup_filepath);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ((j4) parent.getAdapter()).d(position);
        y();
        ((j4) parent.getAdapter()).notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() != R.id.action_backup) {
            return super.onOptionsItemSelected(item);
        }
        z();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        D();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getListView().setOnItemClickListener(this);
    }
}
