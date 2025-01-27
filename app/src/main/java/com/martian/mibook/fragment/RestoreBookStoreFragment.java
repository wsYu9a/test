package com.martian.mibook.fragment;

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
import ba.g;
import ce.n;
import com.google.gson.GsonBuilder;
import com.martian.libmars.fragment.MartianFragment;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.fragment.RestoreBookStoreFragment;
import com.martian.mibook.lib.model.InterfaceAdapter;
import com.martian.mibook.lib.model.data.BookWrapperList;
import com.martian.mibook.lib.model.data.abs.Book;
import hf.e;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import je.z0;
import l9.i0;
import l9.m0;
import y8.f;

/* loaded from: classes3.dex */
public class RestoreBookStoreFragment extends MartianFragment implements AdapterView.OnItemClickListener {

    /* renamed from: d */
    public ListView f13680d;

    /* renamed from: e */
    public View f13681e;

    /* renamed from: f */
    public TextView f13682f;

    /* renamed from: g */
    public n f13683g;

    public class a extends f<Void, List<FileInfo>> {
        public a() {
        }

        public static /* synthetic */ boolean h(File file) {
            return file.getName().endsWith(".tbs");
        }

        @Override // y8.f
        /* renamed from: g */
        public List<FileInfo> doInBackground(Void... voidArr) {
            File[] listFiles = new File(MiConfigSingleton.b2().K1()).listFiles(new FileFilter() { // from class: db.e0
                @Override // java.io.FileFilter
                public final boolean accept(File file) {
                    boolean h10;
                    h10 = RestoreBookStoreFragment.a.h(file);
                    return h10;
                }
            });
            if (listFiles == null || listFiles.length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(listFiles.length);
            for (File file : listFiles) {
                if (file.isFile()) {
                    String absolutePath = file.getAbsolutePath();
                    long h10 = z0.h(file);
                    FileInfo fileInfo = new FileInfo();
                    fileInfo.fileName = file.getName();
                    fileInfo.filePath = absolutePath;
                    fileInfo.fileSize = z0.b(h10);
                    fileInfo.fileDate = z0.e(file);
                    fileInfo.isChecked = false;
                    arrayList.add(fileInfo);
                }
            }
            return arrayList;
        }

        @Override // y8.f
        /* renamed from: i */
        public void onPostExecute(List<FileInfo> list) {
            super.onPostExecute(list);
            RestoreBookStoreFragment.this.f13683g = new n(RestoreBookStoreFragment.this.getActivity(), list);
            RestoreBookStoreFragment.this.getListView().setAdapter((ListAdapter) RestoreBookStoreFragment.this.f13683g);
            RestoreBookStoreFragment.this.M();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
            RestoreBookStoreFragment.this.P(z10);
        }
    }

    public class b extends f<Void, Boolean> {

        /* renamed from: a */
        public final /* synthetic */ String f13685a;

        public b(String str) {
            this.f13685a = str;
        }

        @Override // y8.f
        /* renamed from: f */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(RestoreBookStoreFragment.this.K(this.f13685a));
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (m0.C(RestoreBookStoreFragment.this.f12352c)) {
                if (bool.booleanValue()) {
                    RestoreBookStoreFragment.this.j("备份信息恢复成功");
                } else {
                    RestoreBookStoreFragment.this.j("备份信息恢复失败，请重试");
                }
                showLoading(false);
                if (RestoreBookStoreFragment.this.getActivity() != null) {
                    RestoreBookStoreFragment.this.getActivity().finish();
                }
            }
        }

        @Override // y8.f
        public void onPreExecute() {
            super.onPreExecute();
            showLoading(true);
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public class c extends f<Void, Boolean> {

        /* renamed from: a */
        public final /* synthetic */ String f13687a;

        public c(String str) {
            this.f13687a = str;
        }

        @Override // y8.f
        /* renamed from: f */
        public Boolean doInBackground(Void... voidArr) {
            return Boolean.valueOf(MiConfigSingleton.b2().w1(this.f13687a));
        }

        @Override // y8.f
        /* renamed from: g */
        public void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);
            if (bool.booleanValue()) {
                RestoreBookStoreFragment.this.j("信息备份成功");
            } else {
                RestoreBookStoreFragment.this.j("信息备份失败，请重试");
            }
            RestoreBookStoreFragment.this.R();
        }

        @Override // y8.f
        public void showLoading(boolean z10) {
        }
    }

    public /* synthetic */ void z(View view) {
        N();
    }

    public final /* synthetic */ void A(View view) {
        n nVar = this.f13683g;
        if (nVar == null || nVar.getCount() == 0) {
            return;
        }
        Q(this.f13683g.c());
    }

    public final /* synthetic */ void B(View view) {
        O();
    }

    public final /* synthetic */ void C(EditText editText, DialogInterface dialogInterface, int i10) {
        String obj = editText.getText().toString();
        if (TextUtils.isEmpty(obj)) {
            j("文件名不能为空");
        } else {
            w(obj + y());
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public final /* synthetic */ void G(EditText editText, DialogInterface dialogInterface, int i10) {
        ((InputMethodManager) getActivity().getSystemService("input_method")).hideSoftInputFromWindow(editText.getWindowToken(), 0);
    }

    public final /* synthetic */ void H(FileInfo fileInfo) {
        if (g.o(fileInfo.filePath)) {
            j("删除成功");
            this.f13683g.a();
        } else {
            j("删除失败");
        }
        this.f13683g.notifyDataSetChanged();
    }

    public final /* synthetic */ void I(FileInfo fileInfo) {
        v(fileInfo.filePath);
    }

    public boolean K(String str) {
        try {
            BookWrapperList bookWrapperList = (BookWrapperList) new GsonBuilder().registerTypeAdapter(Book.class, new InterfaceAdapter()).create().fromJson(g.A(str), BookWrapperList.class);
            if (bookWrapperList == null) {
                return false;
            }
            MiConfigSingleton.b2().M1().A0(bookWrapperList.bookWrappers);
            MiConfigSingleton.b2().M1().z0(bookWrapperList.archiveBooks);
            return true;
        } catch (IOException e10) {
            e10.printStackTrace();
            return false;
        }
    }

    public final void M() {
        n nVar = this.f13683g;
        if (nVar == null || nVar.getCount() <= 0) {
            this.f13682f.setVisibility(8);
        } else {
            this.f13682f.setVisibility(0);
            this.f13682f.setText(this.f13683g.c().filePath);
        }
    }

    public final void N() {
        if (getActivity() == null) {
            return;
        }
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_backup_name, (ViewGroup) null);
        EditText editText = (EditText) inflate.findViewById(R.id.et_backup_name);
        ((TextView) inflate.findViewById(R.id.tv_backup_suffix)).setText(y());
        editText.setText(MiConfigSingleton.b2().J1());
        editText.selectAll();
        new AlertDialog.Builder(getActivity()).setTitle("信息备份").setView(inflate).setPositiveButton(getActivity().getResources().getString(R.string.cd_confirm), new DialogInterface.OnClickListener() { // from class: db.z

            /* renamed from: c */
            public final /* synthetic */ EditText f25455c;

            public /* synthetic */ z(EditText editText2) {
                editText = editText2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RestoreBookStoreFragment.this.C(editText, dialogInterface, i10);
            }
        }).setNegativeButton(getActivity().getResources().getString(com.martian.libmars.R.string.cancel), new DialogInterface.OnClickListener() { // from class: db.a0

            /* renamed from: c */
            public final /* synthetic */ EditText f25420c;

            public /* synthetic */ a0(EditText editText2) {
                editText = editText2;
            }

            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i10) {
                RestoreBookStoreFragment.this.G(editText, dialogInterface, i10);
            }
        }).show();
        if (getActivity() == null) {
            return;
        }
        ((InputMethodManager) getActivity().getSystemService("input_method")).toggleSoftInput(2, 0);
        editText2.requestFocus();
    }

    public final void O() {
        n nVar = this.f13683g;
        if (nVar == null || nVar.getCount() == 0 || getContext() == null) {
            return;
        }
        FileInfo c10 = this.f13683g.c();
        i0.z0(getActivity(), getContext().getResources().getString(R.string.delete_hint), "是否删除备份文件\"" + c10.fileName + "\"？", new i0.l() { // from class: db.x

            /* renamed from: b */
            public final /* synthetic */ FileInfo f25451b;

            public /* synthetic */ x(FileInfo c102) {
                c10 = c102;
            }

            @Override // l9.i0.l
            public final void a() {
                RestoreBookStoreFragment.this.H(c10);
            }
        });
    }

    public void P(boolean z10) {
        if (z10) {
            this.f13681e.setVisibility(0);
        } else {
            this.f13681e.setVisibility(8);
        }
    }

    public final void Q(FileInfo fileInfo) {
        i0.z0(getContext(), "信息恢复提示", "是否从\"" + fileInfo.fileName + "\"恢复？\n(包括书架、归档和网页收藏。现有信息将被清空替换。)", new i0.l() { // from class: db.y

            /* renamed from: b */
            public final /* synthetic */ FileInfo f25453b;

            public /* synthetic */ y(FileInfo fileInfo2) {
                fileInfo = fileInfo2;
            }

            @Override // l9.i0.l
            public final void a() {
                RestoreBookStoreFragment.this.I(fileInfo);
            }
        });
    }

    public void R() {
        new a().executeSerial(new Void[0]);
    }

    public ListView getListView() {
        return this.f13680d;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setHasOptionsMenu(true);
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);
        menuInflater.inflate(R.menu.backup_book_store, menu);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_restore_book_store, (ViewGroup) null);
        this.f13680d = (ListView) inflate.findViewById(android.R.id.list);
        this.f13680d.setEmptyView(inflate.findViewById(R.id.ly_empty_hint));
        inflate.findViewById(R.id.tv_create_backup).setOnClickListener(new View.OnClickListener() { // from class: db.b0
            public /* synthetic */ b0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestoreBookStoreFragment.this.z(view);
            }
        });
        this.f13681e = inflate.findViewById(R.id.pb_loading);
        inflate.findViewById(R.id.tv_restore_book_store).setOnClickListener(new View.OnClickListener() { // from class: db.c0
            public /* synthetic */ c0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestoreBookStoreFragment.this.A(view);
            }
        });
        inflate.findViewById(R.id.tv_delete_backup).setOnClickListener(new View.OnClickListener() { // from class: db.d0
            public /* synthetic */ d0() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestoreBookStoreFragment.this.B(view);
            }
        });
        this.f13682f = (TextView) inflate.findViewById(R.id.tv_backup_filepath);
        return inflate;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i10, long j10) {
        ((n) adapterView.getAdapter()).d(i10);
        M();
        ((n) adapterView.getAdapter()).notifyDataSetChanged();
    }

    @Override // androidx.fragment.app.Fragment
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != R.id.action_backup) {
            return super.onOptionsItemSelected(menuItem);
        }
        N();
        return true;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        R();
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getListView().setOnItemClickListener(this);
    }

    public final void v(String str) {
        new b(str).executeSerial(new Void[0]);
    }

    public void w(String str) {
        new c(str).executeSerial(new Void[0]);
    }

    public final int x() {
        n nVar = this.f13683g;
        if (nVar == null) {
            return 0;
        }
        return nVar.getCount();
    }

    public final String y() {
        return e.f26694a + (x() + 1) + ".tbs";
    }
}
