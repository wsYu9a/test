package com.martian.mibook.ui.o;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.core.content.ContextCompat;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.h6;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.MiBookStoreItem;
import com.martian.mibook.lib.model.data.MiReadingRecord;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes4.dex */
public class d4 extends BaseAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14328a;

    /* renamed from: b */
    private List<MiReadingRecord> f14329b;

    /* renamed from: c */
    private boolean f14330c = false;

    /* renamed from: d */
    private int f14331d = 0;

    /* renamed from: e */
    private b f14332e;

    public interface a {
        void a();

        void b();
    }

    public interface b {
        void a(MiReadingRecord miReadingRecord);

        void b(MiReadingRecord miReadingRecord);
    }

    public d4(com.martian.libmars.activity.j1 context, List<MiReadingRecord> data) {
        this.f14328a = context;
        this.f14329b = data;
    }

    private void b(Book book, MiReadingRecord readingRecord) {
        if (book != null) {
            if (i(book)) {
                w(readingRecord);
                return;
            }
            MiBook buildMibook = book.buildMibook();
            if (buildMibook == null) {
                return;
            }
            MiConfigSingleton.V3().l3().d(this.f14328a, buildMibook, book);
            this.f14328a.k1("已添加到书架！");
            notifyDataSetChanged();
        }
    }

    private int e(int position) {
        while (position < this.f14329b.size()) {
            MiReadingRecord miReadingRecord = this.f14329b.get(position);
            if (miReadingRecord.isSelect()) {
                MiConfigSingleton.V3().l3().N0(miReadingRecord);
                return position;
            }
            position++;
        }
        return this.f14329b.size();
    }

    private boolean i(Book book) {
        MiBookStoreItem O = MiConfigSingleton.V3().l3().O(book.isLocal() ? book.getSourceId() : com.martian.mibook.lib.model.manager.d.a(book));
        return (O == null || TextUtils.isEmpty(O.getSourceString())) ? false : true;
    }

    /* renamed from: j */
    public /* synthetic */ void k(final Book book, final MiReadingRecord readingRecord, View v) {
        b(book, readingRecord);
    }

    /* renamed from: l */
    public /* synthetic */ boolean m(final MiReadingRecord readingRecord, View view) {
        b bVar = this.f14332e;
        if (bVar == null) {
            return false;
        }
        bVar.b(readingRecord);
        return false;
    }

    /* renamed from: n */
    public /* synthetic */ void o(final MiReadingRecord readingRecord, View v) {
        b bVar = this.f14332e;
        if (bVar != null) {
            bVar.a(readingRecord);
        }
    }

    public void a(List<MiReadingRecord> records) {
        this.f14329b.addAll(records);
    }

    public void c() {
        this.f14329b.clear();
    }

    public void d() {
        this.f14331d = 0;
        r(false);
    }

    public void f(a listener) {
        int i2 = 0;
        while (i2 < this.f14329b.size()) {
            i2 = e(i2);
        }
        if (listener != null) {
            listener.b();
        }
    }

    public int g() {
        return this.f14331d;
    }

    public Context getContext() {
        return this.f14328a;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MiReadingRecord> list = this.f14329b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14329b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override // android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        h6 h6Var;
        if (convertView == null) {
            h6Var = h6.d(this.f14328a.getLayoutInflater(), null, false);
            view = h6Var.getRoot();
            view.setTag(h6Var);
        } else {
            view = convertView;
            h6Var = (h6) convertView.getTag();
        }
        final MiReadingRecord miReadingRecord = (MiReadingRecord) getItem(position);
        final Book S = MiConfigSingleton.V3().l3().S(com.martian.mibook.lib.model.manager.d.k(miReadingRecord.getSourceString()));
        if (S != null) {
            MiBookManager.d2(this.f14328a, S, h6Var.f12088f);
            h6Var.f12085c.setVisibility(0);
            if (i(S)) {
                h6Var.f12085c.setBackgroundResource(MiConfigSingleton.V3().o3());
                h6Var.f12085c.setTextColor(MiConfigSingleton.V3().s0());
                h6Var.f12085c.setText(this.f14328a.getString(R.string.in_bookrack));
            } else {
                h6Var.f12085c.setBackgroundResource(R.drawable.border_button_line_default);
                h6Var.f12085c.setTextColor(ContextCompat.getColor(this.f14328a, com.martian.libmars.d.h.F().t0()));
                h6Var.f12085c.setText(this.f14328a.getString(R.string.cd_add_bookstore));
            }
        } else {
            h6Var.f12085c.setVisibility(8);
        }
        if (this.f14330c) {
            h6Var.f12085c.setVisibility(8);
            h6Var.f12084b.setVisibility(0);
            h6Var.f12084b.setImageResource(miReadingRecord.isSelect() ? R.drawable.icon_bookrack_batch_checked : R.drawable.icon_bookrack_batch_checkin);
        } else {
            h6Var.f12084b.setVisibility(8);
        }
        h6Var.f12085c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.u0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d4.this.k(S, miReadingRecord, view2);
            }
        });
        h6Var.f12086d.setText(S == null ? miReadingRecord.getBookName() : S.getBookName());
        String chapterTitle = miReadingRecord.getChapterTitle();
        if (com.martian.libsupport.k.p(chapterTitle)) {
            int chapterIndex = miReadingRecord.getChapterIndex() + 1;
            chapterTitle = "已读" + (chapterIndex >= 0 ? chapterIndex : 0) + "章";
        }
        h6Var.f12087e.setText(chapterTitle);
        long lastReadingTime = miReadingRecord.getLastReadingTime();
        h6Var.f12089g.setText(lastReadingTime <= 0 ? "" : com.martian.libmars.utils.p0.A(new Date(lastReadingTime)));
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.martian.mibook.ui.o.t0
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                return d4.this.m(miReadingRecord, view2);
            }
        });
        view.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.s0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                d4.this.o(miReadingRecord, view2);
            }
        });
        return view;
    }

    public boolean h() {
        return this.f14330c;
    }

    public void p(MiReadingRecord miReadingRecord) {
        miReadingRecord.setSelect(!miReadingRecord.isSelect());
        if (miReadingRecord.isSelect()) {
            this.f14331d++;
        } else {
            this.f14331d--;
        }
        notifyDataSetChanged();
    }

    public void q(List<MiReadingRecord> records) {
        this.f14329b = records;
        notifyDataSetChanged();
    }

    public void r(boolean selectAll) {
        Iterator<MiReadingRecord> it = this.f14329b.iterator();
        while (it.hasNext()) {
            it.next().setSelect(selectAll);
        }
    }

    public void s() {
        if (this.f14331d < this.f14329b.size()) {
            this.f14331d = this.f14329b.size();
            r(true);
        } else {
            this.f14331d = 0;
            r(false);
        }
        notifyDataSetChanged();
    }

    public void t(boolean batch) {
        this.f14330c = batch;
        notifyDataSetChanged();
    }

    public void u(List<MiReadingRecord> data) {
        this.f14329b = data;
    }

    public void v(b onItemClickListener) {
        this.f14332e = onItemClickListener;
    }

    public void w(MiReadingRecord readingRecord) {
        if (com.martian.mibook.j.s2.j0(this.f14328a, readingRecord)) {
            return;
        }
        this.f14328a.k1("无效的书籍记录");
    }
}
