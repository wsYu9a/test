package com.martian.mibook.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.martian.libmars.activity.j1;
import com.martian.libmars.ui.theme.ThemeTextView;
import com.martian.mibook.application.MiBookManager;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.j.s2;
import com.martian.mibook.lib.model.data.TYBookItem;
import com.martian.mibook.lib.model.data.abs.Book;
import com.martian.ttbookhd.R;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/* loaded from: classes4.dex */
public class j extends BaseAdapter {

    /* renamed from: a */
    protected List<TYBookItem> f14251a;

    /* renamed from: b */
    final j1 f14252b;

    /* renamed from: c */
    private final Set<String> f14253c = new HashSet();

    /* renamed from: d */
    private boolean f14254d = true;

    class a implements com.martian.mibook.lib.model.d.b {
        a() {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void a(Book book1) {
            if (book1 == null) {
                j.this.f14252b.k1("加入失败，请重试");
                return;
            }
            MiConfigSingleton.V3().l3().d(j.this.f14252b, book1.buildMibook(), book1);
            j.this.f14252b.k1("已加入书架");
            if (book1 instanceof TYBookItem) {
                TYBookItem tYBookItem = (TYBookItem) book1;
                MiConfigSingleton.V3().l3().I1(3, book1.getSourceName(), book1.getSourceId(), tYBookItem.getRecommendId(), tYBookItem.getRecommend(), "退出阅读加书架");
            }
            j.this.notifyDataSetChanged();
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onLoading(boolean loading) {
        }

        @Override // com.martian.mibook.lib.model.d.b
        public void onResultError(b.d.c.b.c errorResult) {
            j.this.f14252b.k1("加入失败，请重试");
        }
    }

    public static class b {

        /* renamed from: a */
        ImageView f14256a;

        /* renamed from: b */
        TextView f14257b;

        /* renamed from: c */
        TextView f14258c;

        /* renamed from: d */
        TextView f14259d;

        /* renamed from: e */
        TextView f14260e;

        /* renamed from: f */
        ThemeTextView f14261f;
    }

    public j(j1 activity) {
        this.f14252b = activity;
        com.martian.mibook.lib.model.g.b.S(activity, "退出阅读推荐", "展示");
    }

    /* renamed from: b */
    public /* synthetic */ void c(final int position, View v) {
        s2.U(this.f14252b, (Book) getItem(position));
    }

    /* renamed from: d */
    public /* synthetic */ void e(final int position, View v) {
        s2.U(this.f14252b, (Book) getItem(position));
    }

    /* renamed from: f */
    public /* synthetic */ void g(final boolean isInBookrack, final TYBookItem tyBookItem, View view) {
        if (isInBookrack) {
            this.f14252b.k1("已在书架");
        } else {
            MiConfigSingleton.V3().l3().m(tyBookItem.getSource(), new a());
        }
    }

    private void h(TYBookItem tyBookItem) {
        if (this.f14253c.contains(tyBookItem.getSourceId())) {
            return;
        }
        this.f14253c.add(tyBookItem.getSourceId());
        MiConfigSingleton.V3().l3().I1(0, tyBookItem.getSourceName(), tyBookItem.getSourceId(), tyBookItem.getRecommendId(), "", "展示");
    }

    public boolean a() {
        return this.f14254d;
    }

    public Context getContext() {
        return this.f14252b;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<TYBookItem> list = this.f14251a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int position) {
        return this.f14251a.get((getCount() - position) - 1);
    }

    @Override // android.widget.Adapter
    public long getItemId(int position) {
        return getItem(position).hashCode();
    }

    @Override // android.widget.Adapter
    @SuppressLint({"SetTextI18n"})
    public View getView(final int position, View convertView, ViewGroup parent) {
        b bVar;
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(this.f14254d ? R.layout.book_cover_reading_list_item : R.layout.book_cover_reading_grid_item, (ViewGroup) null);
            bVar = new b();
            bVar.f14256a = (ImageView) convertView.findViewById(R.id.rd_book_cover);
            bVar.f14257b = (TextView) convertView.findViewById(R.id.rd_book_name);
            bVar.f14258c = (TextView) convertView.findViewById(R.id.rd_book_score);
            bVar.f14259d = (TextView) convertView.findViewById(R.id.rd_book_short_content);
            bVar.f14260e = (TextView) convertView.findViewById(R.id.rd_book_author_name);
            bVar.f14261f = (ThemeTextView) convertView.findViewById(R.id.rd_book_add_bookrack);
            convertView.setTag(bVar);
            convertView.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.a
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.this.c(position, view);
                }
            });
            bVar.f14256a.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.this.e(position, view);
                }
            });
        } else {
            bVar = (b) convertView.getTag();
        }
        final TYBookItem tYBookItem = (TYBookItem) getItem(position);
        MiBookManager.d2(this.f14252b, tYBookItem, bVar.f14256a);
        if (!com.martian.libsupport.k.p(tYBookItem.getBookName())) {
            bVar.f14257b.setText(tYBookItem.getBookName());
        }
        if (bVar.f14259d != null && !com.martian.libsupport.k.p(tYBookItem.getShortIntro())) {
            bVar.f14259d.setText(com.martian.libsupport.k.v(tYBookItem.getShortIntro()));
        }
        if (bVar.f14261f != null) {
            final boolean v0 = MiConfigSingleton.V3().l3().v0(tYBookItem.buildMibook());
            bVar.f14261f.setBackgroundResource(MiConfigSingleton.V3().I0() ? R.drawable.border_mission_button_night : R.drawable.border_mission_button);
            if (v0) {
                bVar.f14261f.setAlpha(0.5f);
                bVar.f14261f.setSelectable(false);
                bVar.f14261f.setText(this.f14252b.getString(R.string.already_in_bookrack));
            } else {
                bVar.f14261f.setAlpha(1.0f);
                bVar.f14261f.setSelectable(true);
                bVar.f14261f.setText(this.f14252b.getString(R.string.add_to_book_store));
            }
            bVar.f14261f.setOnClickListener(new View.OnClickListener() { // from class: com.martian.mibook.ui.c
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    j.this.g(v0, tYBookItem, view);
                }
            });
        }
        bVar.f14260e.setText(tYBookItem.getBookInfo());
        bVar.f14260e.setVisibility(0);
        if (!this.f14254d) {
            bVar.f14260e.setText(tYBookItem.getCategoryInfo());
        } else if (!com.martian.libsupport.k.p(tYBookItem.getRecTitle())) {
            bVar.f14260e.setText(tYBookItem.getRecTitle());
        }
        if (tYBookItem.getScore() > 0) {
            bVar.f14258c.setVisibility(0);
            double score = tYBookItem.getScore();
            Double.isNaN(score);
            bVar.f14258c.setText(String.format(Locale.getDefault(), "%.1f", Double.valueOf(score / 10.0d)) + "分");
            if (!this.f14254d) {
                bVar.f14260e.setVisibility(8);
            }
        } else {
            bVar.f14258c.setVisibility(8);
        }
        h(tYBookItem);
        return convertView;
    }

    public void i(List<TYBookItem> data) {
        this.f14251a = data;
        notifyDataSetChanged();
    }

    public void j(boolean portrait) {
        this.f14254d = portrait;
    }
}
