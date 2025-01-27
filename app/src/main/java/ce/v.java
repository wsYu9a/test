package ce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.martian.mibook.R;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.application.ReaderTypefaceManager;
import com.martian.mibook.data.FileInfo;
import com.martian.mibook.databinding.ListItemTrackMutipleBinding;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes3.dex */
public class v extends BaseAdapter {

    /* renamed from: b */
    public ArrayList<FileInfo> f1982b;

    /* renamed from: c */
    public final String f1983c;

    /* renamed from: d */
    public final Context f1984d;

    public interface a {
        void a();

        void b(String str);
    }

    public v(Context context, ArrayList<FileInfo> arrayList, String str) {
        this.f1982b = arrayList;
        this.f1984d = context;
        this.f1983c = str;
    }

    public static /* synthetic */ int h(FileInfo fileInfo, FileInfo fileInfo2) {
        if (fileInfo == null || fileInfo2 == null) {
            return 0;
        }
        return ba.l.e(fileInfo.getFileName()) ? ba.l.e(fileInfo2.getFileName()) ? 0 : -1 : ba.l.e(fileInfo2.getFileName()) ? 1 : 0;
    }

    @Override // android.widget.Adapter
    /* renamed from: b */
    public FileInfo getItem(int i10) {
        return this.f1982b.get(i10);
    }

    public String[] c() {
        List<Integer> e10 = e();
        String[] strArr = new String[e10.size()];
        for (int i10 = 0; i10 < e10.size(); i10++) {
            strArr[i10] = getItem(e10.get(i10).intValue()).getFileName();
        }
        return strArr;
    }

    public LinkedList<String> d() {
        List<Integer> e10 = e();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i10 = 0; i10 < e10.size(); i10++) {
            linkedList.add(getItem(e10.get(i10).intValue()).getFilePath());
        }
        return linkedList;
    }

    public List<Integer> e() {
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < this.f1982b.size(); i10++) {
            if (this.f1982b.get(i10).getIsChecked()) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        return arrayList;
    }

    public List<FileInfo> f() {
        List<Integer> e10 = e();
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < e10.size(); i10++) {
            arrayList.add(getItem(e10.get(i10).intValue()));
        }
        return arrayList;
    }

    public boolean g() {
        for (int i10 = 0; i10 < this.f1982b.size(); i10++) {
            if (!this.f1982b.get(i10).getFileDate().equals("MIBOOK_DIRECTORY")) {
                return true;
            }
        }
        return false;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        ArrayList<FileInfo> arrayList = this.f1982b;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        ListItemTrackMutipleBinding listItemTrackMutipleBinding;
        if (view == null) {
            view = LayoutInflater.from(this.f1984d).inflate(R.layout.list_item_track_mutiple, viewGroup, false);
            listItemTrackMutipleBinding = ListItemTrackMutipleBinding.bind(view);
            view.setTag(listItemTrackMutipleBinding);
        } else {
            listItemTrackMutipleBinding = (ListItemTrackMutipleBinding) view.getTag();
        }
        FileInfo item = getItem(i10);
        if (!ba.l.q(item.getFileName())) {
            listItemTrackMutipleBinding.textviewBookName.setText(item.getFileName());
        }
        if (!ba.l.q(item.getFileSize())) {
            listItemTrackMutipleBinding.textviewBookSize.setText(item.getFileSize());
        }
        if (!ba.l.q(item.getFileDate())) {
            if (item.getFileDate().equals("MIBOOK_DIRECTORY")) {
                listItemTrackMutipleBinding.tvType.setImageResource(R.drawable.file_type_folder);
                listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(8);
                listItemTrackMutipleBinding.textviewBookDate.setText("");
                listItemTrackMutipleBinding.bsAlreadyIn.setVisibility(8);
            } else {
                listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(0);
                listItemTrackMutipleBinding.textviewBookDate.setText(item.getFileDate());
                String filePath = item.getFilePath();
                if (!ba.l.q(this.f1983c)) {
                    if (this.f1983c.equals("BOOKSTORE")) {
                        listItemTrackMutipleBinding.tvType.setImageResource(R.drawable.file_type_txt);
                        MiBookStoreItem b02 = MiConfigSingleton.b2().M1().b0(filePath);
                        if (ba.l.q(filePath) || b02 == null) {
                            listItemTrackMutipleBinding.bsAlreadyIn.setVisibility(8);
                            listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(0);
                            listItemTrackMutipleBinding.cbTrackMultiple.setImageResource(this.f1982b.get(i10).getIsChecked() ? R.drawable.btn_check_on_default : R.drawable.btn_check_off_default);
                        } else {
                            listItemTrackMutipleBinding.bsAlreadyIn.setVisibility(0);
                            listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(8);
                            if (!ba.l.q(b02.getBookName()) && !ba.l.q(item.getFileName()) && !item.getFileName().contains(b02.getBookName())) {
                                listItemTrackMutipleBinding.textviewBookName.setText("(" + b02.getBookName() + ")" + item.getFileName());
                            }
                            this.f1982b.get(i10).setIsChecked(false);
                        }
                    } else if (this.f1983c.equals("TYPEFACE")) {
                        listItemTrackMutipleBinding.tvType.setImageResource(R.drawable.file_type_ttf);
                        ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
                        if (ba.l.q(filePath) || !i22.n(filePath)) {
                            listItemTrackMutipleBinding.bsAlreadyIn.setVisibility(8);
                            listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(0);
                            listItemTrackMutipleBinding.cbTrackMultiple.setImageResource(this.f1982b.get(i10).getIsChecked() ? R.drawable.btn_check_on_default : R.drawable.btn_check_off_default);
                        } else {
                            listItemTrackMutipleBinding.bsAlreadyIn.setVisibility(0);
                            listItemTrackMutipleBinding.cbTrackMultiple.setVisibility(8);
                            this.f1982b.get(i10).setIsChecked(false);
                        }
                    }
                }
            }
        }
        return view;
    }

    public void i(boolean z10) {
        for (int i10 = 0; i10 < this.f1982b.size(); i10++) {
            if (this.f1982b.get(i10).getFileDate().equals("MIBOOK_DIRECTORY") || !z10) {
                this.f1982b.get(i10).setIsChecked(false);
            } else {
                String filePath = this.f1982b.get(i10).getFilePath();
                if (!ba.l.q(filePath) && MiConfigSingleton.b2().M1().t0(filePath)) {
                    this.f1982b.get(i10).setIsChecked(true);
                }
            }
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean isEmpty() {
        ArrayList<FileInfo> arrayList = this.f1982b;
        return arrayList == null || arrayList.size() == 0;
    }

    public void j(ArrayList<FileInfo> arrayList) {
        this.f1982b = arrayList;
        notifyDataSetChanged();
    }

    public void k() {
        Collections.sort(this.f1982b, new Comparator() { // from class: ce.u
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                int h10;
                h10 = v.h((FileInfo) obj, (FileInfo) obj2);
                return h10;
            }
        });
    }

    public void l(int i10, a aVar) {
        if (i10 < 0 || ba.l.q(this.f1982b.get(i10).getFileDate())) {
            return;
        }
        if (this.f1982b.get(i10).getFileDate().equals("MIBOOK_DIRECTORY")) {
            aVar.b(this.f1982b.get(i10).getFilePath());
        } else {
            m(i10, aVar);
        }
    }

    public void m(int i10, a aVar) {
        String filePath = this.f1982b.get(i10).getFilePath();
        if (ba.l.q(this.f1983c)) {
            return;
        }
        if (this.f1983c.equals("BOOKSTORE")) {
            if (ba.l.q(filePath) || !MiConfigSingleton.b2().M1().t0(filePath)) {
                return;
            }
            n(i10, aVar);
            return;
        }
        if (this.f1983c.equals("TYPEFACE")) {
            ReaderTypefaceManager i22 = MiConfigSingleton.b2().i2();
            if (ba.l.q(filePath) || i22.n(filePath)) {
                return;
            }
            n(i10, aVar);
        }
    }

    public final void n(int i10, a aVar) {
        this.f1982b.get(i10).setIsChecked(!this.f1982b.get(i10).getIsChecked());
        if (aVar != null) {
            aVar.a();
        }
    }
}
