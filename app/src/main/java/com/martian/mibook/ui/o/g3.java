package com.martian.mibook.ui.o;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.martian.libmars.utils.k0;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.s4;
import com.martian.mibook.e.t4;
import com.martian.mibook.lib.model.data.MiArchiveBookItem;
import com.martian.mibook.lib.model.data.MiBook;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import java.util.List;

/* loaded from: classes4.dex */
public class g3 extends BaseAdapter {

    /* renamed from: a */
    private final com.martian.libmars.activity.j1 f14377a;

    /* renamed from: b */
    private List<MiArchiveBookItem> f14378b;

    /* renamed from: c */
    private final TextView f14379c;

    class a implements com.martian.mibook.lib.model.d.b {

        /* renamed from: a */
        final /* synthetic */ MiArchiveBookItem f14380a;

        /* renamed from: b */
        final /* synthetic */ MiBook f14381b;

        a(final MiArchiveBookItem val$mibook, final MiBook val$item) {
            this.f14380a = val$mibook;
            this.f14381b = val$item;
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book) {
            g3.this.m(this.f14380a, book, this.f14381b);
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
            if (loading) {
                g3.this.f14377a.k1("加载书籍信息中，请稍等");
            }
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            g3.this.f14377a.k1("通信失败");
        }
    }

    public g3(com.martian.libmars.activity.j1 activity, List<MiArchiveBookItem> archiveList, TextView textView) {
        this.f14377a = activity;
        this.f14378b = archiveList;
        this.f14379c = textView;
    }

    private View c(String menuItem, final int position, final MiArchiveBookItem item, final PopupWindow popWindow) {
        View inflate = View.inflate(this.f14377a, R.layout.popupwindow_list_item, null);
        t4 a2 = t4.a(inflate);
        if (!com.martian.libsupport.k.p(menuItem)) {
            a2.f12737b.setText(menuItem);
        }
        a2.f12737b.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g3.this.f(position, item, popWindow, view);
            }
        });
        return inflate;
    }

    /* renamed from: e */
    public /* synthetic */ void f(final int position, final MiArchiveBookItem item, final PopupWindow popWindow, View v) {
        if (position == 0) {
            p(item);
        } else if (position == 1) {
            com.martian.mibook.j.s2.U(this.f14377a, item);
        } else if (position == 2) {
            l(item);
        }
        popWindow.dismiss();
    }

    /* renamed from: g */
    public /* synthetic */ void h(View v) {
        o(((Integer) v.getTag()).intValue());
    }

    static /* synthetic */ boolean i(final View view, final PopupWindow popWindow, View v, MotionEvent event) {
        int top = view.findViewById(R.id.popupwindow_view).getTop();
        int y = (int) event.getY();
        if (event.getAction() == 1 && y < top) {
            popWindow.dismiss();
        }
        return true;
    }

    /* renamed from: j */
    public /* synthetic */ void k(final MiArchiveBookItem item) {
        MiConfigSingleton.V3().l3().B(item);
        this.f14377a.k1("删除成功");
        this.f14378b.remove(item);
        notifyDataSetChanged();
    }

    private void l(final MiArchiveBookItem item) {
        Book S = MiConfigSingleton.V3().l3().S(item);
        MiBook Q = MiConfigSingleton.V3().l3().Q(item.getBookId());
        if (S != null) {
            m(item, S, Q);
        } else if (!TextUtils.isEmpty(item.getSourceString())) {
            MiConfigSingleton.V3().l3().m(item, new a(item, Q));
        } else if (Q == null) {
            this.f14377a.k1("无效的小说信息");
        }
    }

    public void m(MiArchiveBookItem item, Book book, MiBook mibook) {
        if (mibook == null) {
            mibook = book.buildMibook();
            MiConfigSingleton.V3().l3().T0(mibook);
        }
        if (MiConfigSingleton.V3().l3().d(this.f14377a, mibook, book) != null) {
            this.f14377a.k1("移回成功");
            MiConfigSingleton.V3().l3().M0(item);
            this.f14378b.remove(item);
            notifyDataSetChanged();
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    private void o(final int position) {
        String[] strArr = {"删除", "书籍详情", "移回书架"};
        MiArchiveBookItem d2 = d(position);
        final View inflate = View.inflate(this.f14377a, R.layout.popupwindow_list, null);
        s4 a2 = s4.a(inflate);
        a2.f12678c.setVisibility(MiConfigSingleton.V3().I0() ? 0 : 8);
        a2.f12679d.setText(d2.getBookName());
        a2.f12677b.removeAllViews();
        final PopupWindow j2 = com.martian.mibook.j.v2.j(inflate, this.f14379c, this.f14377a);
        inflate.setOnTouchListener(new View.OnTouchListener() { // from class: com.martian.mibook.ui.o.e
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                return g3.i(inflate, j2, view, motionEvent);
            }
        });
        for (int i2 = 0; i2 < 3; i2++) {
            a2.f12677b.addView(c(strArr[i2], i2, d2, j2));
        }
    }

    private void p(final MiArchiveBookItem item) {
        com.martian.libmars.activity.j1 j1Var = this.f14377a;
        com.martian.libmars.utils.k0.P(j1Var, j1Var.getString(R.string.confirm_message), "是否删除《" + item.getBookName() + "》?\n(该书的所有缓存内容将被清空)", new k0.l() { // from class: com.martian.mibook.ui.o.d
            @Override // com.martian.libmars.utils.k0.l
            public final void a() {
                g3.this.k(item);
            }
        });
    }

    public MiArchiveBookItem d(int pos) {
        return this.f14378b.get(pos);
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<MiArchiveBookItem> list = this.f14378b;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14378b.get(position);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // android.widget.Adapter
    @SuppressLint({"InflateParams", "SetTextI18n"})
    public View getView(int position, View convertView, ViewGroup parent) {
        com.martian.mibook.e.h0 h0Var;
        if (convertView == null) {
            convertView = LayoutInflater.from(this.f14377a).inflate(R.layout.archive_list_item, (ViewGroup) null);
            h0Var = com.martian.mibook.e.h0.a(convertView);
            convertView.setTag(h0Var);
        } else {
            h0Var = (com.martian.mibook.e.h0) convertView.getTag();
        }
        MiArchiveBookItem d2 = d(position);
        h0Var.f12040f.setText(d2.getBookName());
        h0Var.f12038d.setText(this.f14377a.getString(R.string.archive_time) + com.martian.libmars.utils.p0.n(d2.getArchiveDate()));
        h0Var.f12039e.setText(!TextUtils.isEmpty(d2.getAuthor()) ? d2.getAuthor() : "");
        h0Var.f12041g.setText(!TextUtils.isEmpty(d2.getLastestChapter()) ? d2.getLastestChapter() : d2.getBookUrl());
        if (TextUtils.isEmpty(d2.getCoverUrl())) {
            h0Var.f12036b.setImageResource(R.drawable.cover_default);
        } else {
            com.martian.libmars.utils.n0.l(this.f14377a, d2.getCoverUrl(), h0Var.f12036b, MiConfigSingleton.V3().i3());
        }
        h0Var.f12037c.setTag(Integer.valueOf(position));
        h0Var.f12037c.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.o.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                g3.this.h(view);
            }
        });
        return convertView;
    }

    public void n(List<MiArchiveBookItem> archiveList) {
        this.f14378b = archiveList;
        notifyDataSetChanged();
    }
}
