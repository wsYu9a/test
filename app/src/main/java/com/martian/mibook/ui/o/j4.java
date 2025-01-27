package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.martian.mibook.data.FileInfo;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class j4 extends BaseAdapter {

    /* renamed from: a */
    private final Context f14511a;

    /* renamed from: b */
    private final List<FileInfo> f14512b;

    /* renamed from: c */
    private int f14513c = 0;

    static class a {

        /* renamed from: a */
        TextView f14514a;

        /* renamed from: b */
        TextView f14515b;

        /* renamed from: c */
        TextView f14516c;

        /* renamed from: d */
        View f14517d;

        a() {
        }
    }

    public j4(Context context, List<FileInfo> fileInfos) {
        this.f14511a = context;
        this.f14512b = fileInfos;
    }

    public void a() {
        List<FileInfo> list = this.f14512b;
        if (list != null) {
            int size = list.size();
            int i2 = this.f14513c;
            if (size > i2) {
                this.f14512b.remove(i2);
                this.f14513c = Math.max(0, this.f14513c - 1);
            }
        }
    }

    public int b() {
        return this.f14513c;
    }

    public FileInfo c() {
        return (FileInfo) getItem(this.f14513c);
    }

    public void d(int i2) {
        this.f14513c = i2;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<FileInfo> list = this.f14512b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14512b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams"})
    public View getView(int position, View convertView, ViewGroup parent) {
        a aVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14511a).inflate(R.layout.restore_book_store_item, (ViewGroup) null);
            aVar = new a();
            aVar.f14516c = (TextView) convertView.findViewById(R.id.tv_file_date);
            aVar.f14514a = (TextView) convertView.findViewById(R.id.tv_file_name);
            aVar.f14515b = (TextView) convertView.findViewById(R.id.tv_file_size);
            aVar.f14517d = convertView.findViewById(R.id.iv_selection);
            convertView.setTag(aVar);
        } else {
            aVar = (a) convertView.getTag();
        }
        FileInfo fileInfo = (FileInfo) getItem(position);
        aVar.f14515b.setText(fileInfo.getFileSize());
        aVar.f14514a.setText(fileInfo.getFileName());
        aVar.f14516c.setText(fileInfo.getFileDate());
        if (position == this.f14513c) {
            aVar.f14517d.setVisibility(0);
        } else {
            aVar.f14517d.setVisibility(8);
        }
        return convertView;
    }
}
