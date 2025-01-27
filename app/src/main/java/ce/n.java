package ce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.mibook.R;
import com.martian.mibook.data.FileInfo;
import java.util.List;

/* loaded from: classes3.dex */
public class n extends BaseAdapter {

    /* renamed from: b */
    public final Context f1953b;

    /* renamed from: c */
    public final List<FileInfo> f1954c;

    /* renamed from: d */
    public int f1955d = 0;

    public static class a {

        /* renamed from: a */
        public TextView f1956a;

        /* renamed from: b */
        public TextView f1957b;

        /* renamed from: c */
        public TextView f1958c;

        /* renamed from: d */
        public View f1959d;
    }

    public n(Context context, List<FileInfo> list) {
        this.f1953b = context;
        this.f1954c = list;
    }

    public void a() {
        List<FileInfo> list = this.f1954c;
        if (list != null) {
            int size = list.size();
            int i10 = this.f1955d;
            if (size > i10) {
                this.f1954c.remove(i10);
                this.f1955d = Math.max(0, this.f1955d - 1);
            }
        }
    }

    public int b() {
        return this.f1955d;
    }

    public FileInfo c() {
        return (FileInfo) getItem(this.f1955d);
    }

    public void d(int i10) {
        this.f1955d = i10;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FileInfo> list = this.f1954c;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i10) {
        return this.f1954c.get(i10);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i10) {
        return i10;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int i10, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = LayoutInflater.from(this.f1953b).inflate(R.layout.restore_book_store_item, (ViewGroup) null);
            aVar = new a();
            aVar.f1958c = (TextView) view.findViewById(R.id.tv_file_date);
            aVar.f1956a = (TextView) view.findViewById(R.id.tv_file_name);
            aVar.f1957b = (TextView) view.findViewById(R.id.tv_file_size);
            aVar.f1959d = view.findViewById(R.id.iv_selection);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        FileInfo fileInfo = (FileInfo) getItem(i10);
        aVar.f1957b.setText(fileInfo.getFileSize());
        aVar.f1956a.setText(fileInfo.getFileName());
        aVar.f1958c.setText(fileInfo.getFileDate());
        if (i10 == this.f1955d) {
            aVar.f1959d.setVisibility(0);
        } else {
            aVar.f1959d.setVisibility(8);
        }
        return view;
    }
}
