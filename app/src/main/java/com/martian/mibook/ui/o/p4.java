package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.TypefaceManager;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.ttbookhd.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes4.dex */
public class p4 extends BaseAdapter {

    /* renamed from: a */
    private ArrayList<FileInfo> f14626a;

    /* renamed from: b */
    private final String f14627b;

    /* renamed from: c */
    private final Context f14628c;

    public interface a {
        void a();

        void b(String filepath);
    }

    public p4(Context c2, ArrayList<FileInfo> list, String activity) {
        this.f14626a = list;
        this.f14628c = c2;
        this.f14627b = activity;
    }

    static /* synthetic */ int g(FileInfo fileInfo, FileInfo fileInfo2) {
        if (fileInfo == null || fileInfo2 == null) {
            return 0;
        }
        return com.martian.libsupport.k.e(fileInfo.getFileName()) ? com.martian.libsupport.k.e(fileInfo2.getFileName()) ? 0 : -1 : com.martian.libsupport.k.e(fileInfo2.getFileName()) ? 1 : 0;
    }

    private void m(int position, a fileDirectorySelect) {
        this.f14626a.get(position).setIsChecked(!this.f14626a.get(position).getIsChecked());
        if (fileDirectorySelect != null) {
            fileDirectorySelect.a();
        }
    }

    @Override // android.widget.Adapter
    /* renamed from: a */
    public FileInfo getItem(int position) {
        return this.f14626a.get(position);
    }

    public String[] b() {
        List<Integer> d2 = d();
        String[] strArr = new String[d2.size()];
        for (int i2 = 0; i2 < d2.size(); i2++) {
            strArr[i2] = getItem(d2.get(i2).intValue()).getFileName();
        }
        return strArr;
    }

    public LinkedList<String> c() {
        List<Integer> d2 = d();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i2 = 0; i2 < d2.size(); i2++) {
            linkedList.add(getItem(d2.get(i2).intValue()).getFilePath());
        }
        return linkedList;
    }

    public List<Integer> d() {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < this.f14626a.size(); i2++) {
            if (this.f14626a.get(i2).getIsChecked()) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    public List<FileInfo> e() {
        List<Integer> d2 = d();
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < d2.size(); i2++) {
            arrayList.add(getItem(d2.get(i2).intValue()));
        }
        return arrayList;
    }

    public boolean f() {
        for (int i2 = 0; i2 < this.f14626a.size(); i2++) {
            if (!this.f14626a.get(i2).getFileDate().equals("MIBOOK_DIRECTORY")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<FileInfo> arrayList = this.f14626a;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        com.martian.mibook.e.u3 u3Var;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14628c).inflate(R.layout.list_item_track_mutiple, parent, false);
            u3Var = com.martian.mibook.e.u3.a(convertView);
            convertView.setTag(u3Var);
        } else {
            u3Var = (com.martian.mibook.e.u3) convertView.getTag();
        }
        FileInfo item = getItem(position);
        if (!com.martian.libsupport.k.p(item.getFileName())) {
            u3Var.f12783e.setText(item.getFileName());
        }
        if (!com.martian.libsupport.k.p(item.getFileSize())) {
            u3Var.f12784f.setText(item.getFileSize());
        }
        if (!com.martian.libsupport.k.p(item.getFileDate())) {
            if (item.getFileDate().equals("MIBOOK_DIRECTORY")) {
                u3Var.f12786h.setImageResource(R.drawable.file_type_folder);
                u3Var.f12781c.setVisibility(8);
                u3Var.f12782d.setText("");
                u3Var.f12780b.setVisibility(8);
            } else {
                u3Var.f12781c.setVisibility(0);
                u3Var.f12782d.setText(item.getFileDate());
                String filePath = item.getFilePath();
                if (!com.martian.libsupport.k.p(this.f14627b)) {
                    boolean equals = this.f14627b.equals("BOOKSTORE");
                    int i2 = R.drawable.btn_check_on_default;
                    if (equals) {
                        u3Var.f12786h.setImageResource(R.drawable.file_type_txt);
                        MiBookStoreItem d0 = MiConfigSingleton.V3().l3().d0(filePath);
                        if (com.martian.libsupport.k.p(filePath) || d0 == null) {
                            u3Var.f12780b.setVisibility(8);
                            u3Var.f12781c.setVisibility(0);
                            ImageView imageView = u3Var.f12781c;
                            if (!this.f14626a.get(position).getIsChecked()) {
                                i2 = R.drawable.btn_check_off_default;
                            }
                            imageView.setImageResource(i2);
                        } else {
                            u3Var.f12780b.setVisibility(0);
                            u3Var.f12781c.setVisibility(8);
                            if (!com.martian.libsupport.k.p(d0.getBookName()) && !com.martian.libsupport.k.p(item.getFileName()) && !item.getFileName().contains(d0.getBookName())) {
                                u3Var.f12783e.setText("(" + d0.getBookName() + ")" + item.getFileName());
                            }
                            this.f14626a.get(position).setIsChecked(false);
                        }
                    } else if (this.f14627b.equals("TYPEFACE")) {
                        u3Var.f12786h.setImageResource(R.drawable.file_type_ttf);
                        TypefaceManager typefaceManager = new TypefaceManager(this.f14628c);
                        if (com.martian.libsupport.k.p(filePath) || !typefaceManager.g(filePath)) {
                            u3Var.f12780b.setVisibility(8);
                            u3Var.f12781c.setVisibility(0);
                            ImageView imageView2 = u3Var.f12781c;
                            if (!this.f14626a.get(position).getIsChecked()) {
                                i2 = R.drawable.btn_check_off_default;
                            }
                            imageView2.setImageResource(i2);
                        } else {
                            u3Var.f12780b.setVisibility(0);
                            u3Var.f12781c.setVisibility(8);
                            this.f14626a.get(position).setIsChecked(false);
                        }
                    }
                }
            }
        }
        return convertView;
    }

    public void h(boolean selectAll) {
        for (int i2 = 0; i2 < this.f14626a.size(); i2++) {
            if (this.f14626a.get(i2).getFileDate().equals("MIBOOK_DIRECTORY") || !selectAll) {
                this.f14626a.get(i2).setIsChecked(false);
            } else {
                String filePath = this.f14626a.get(i2).getFilePath();
                if (!com.martian.libsupport.k.p(filePath) && !MiConfigSingleton.V3().l3().y0(filePath)) {
                    this.f14626a.get(i2).setIsChecked(true);
                }
            }
        }
    }

    public void i(ArrayList<FileInfo> list) {
        this.f14626a = list;
        notifyDataSetChanged();
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ArrayList<FileInfo> arrayList = this.f14626a;
        return arrayList == null || arrayList.size() == 0;
    }

    public void j() {
        Collections.sort(this.f14626a, new Comparator() { // from class: com.martian.mibook.ui.o.z2
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return p4.g((FileInfo) obj, (FileInfo) obj2);
            }
        });
    }

    public void k(int position, final a fileDirectorySelect) {
        if (position < 0 || com.martian.libsupport.k.p(this.f14626a.get(position).getFileDate())) {
            return;
        }
        if (this.f14626a.get(position).getFileDate().equals("MIBOOK_DIRECTORY")) {
            fileDirectorySelect.b(this.f14626a.get(position).getFilePath());
        } else {
            l(position, fileDirectorySelect);
        }
    }

    public void l(int position, a fileDirectorySelect) {
        String filePath = this.f14626a.get(position).getFilePath();
        if (com.martian.libsupport.k.p(this.f14627b)) {
            return;
        }
        if (this.f14627b.equals("BOOKSTORE")) {
            if (com.martian.libsupport.k.p(filePath) || MiConfigSingleton.V3().l3().y0(filePath)) {
                return;
            }
            m(position, fileDirectorySelect);
            return;
        }
        if (this.f14627b.equals("TYPEFACE")) {
            TypefaceManager typefaceManager = new TypefaceManager(this.f14628c);
            if (com.martian.libsupport.k.p(filePath) || typefaceManager.g(filePath)) {
                return;
            }
            m(position, fileDirectorySelect);
        }
    }
}
