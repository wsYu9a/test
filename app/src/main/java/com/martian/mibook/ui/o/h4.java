package com.martian.mibook.ui.o;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListView;
import androidx.core.content.ContextCompat;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.e.w5;
import com.martian.mibook.lib.local.txt.data.TXTChapter;
import com.martian.mibook.lib.model.data.MiChapterList;
import com.martian.mibook.lib.model.data.MiReadingTheme;
import com.martian.mibook.lib.model.data.abs.Chapter;
import com.martian.ttbookhd.R;
import java.util.Hashtable;
import java.util.Map;

/* loaded from: classes4.dex */
public class h4 extends SimpleCursorAdapter implements AbsListView.OnScrollListener {
    private boolean A;
    private final boolean B;
    private int s;
    private final Context t;
    private boolean u;
    private MiChapterList v;
    private final Map<Integer, Boolean> w;
    private final Map<Integer, Boolean> x;
    private final com.martian.mibook.lib.model.c.g y;
    private final ListView z;

    class a extends b.d.c.c.g<Void, Boolean> {

        /* renamed from: a */
        final /* synthetic */ int f14404a;

        /* renamed from: b */
        final /* synthetic */ int f14405b;

        a(final int val$end, final int val$start) {
            this.f14404a = val$end;
            this.f14405b = val$start;
        }

        @Override // b.d.c.c.g
        /* renamed from: f */
        public Boolean doInBackground(Void... params) {
            if (h4.this.getCursor() != null) {
                for (int i2 = this.f14404a; i2 <= this.f14405b && i2 < h4.this.getCount(); i2++) {
                    h4.this.f(i2);
                }
            }
            return Boolean.TRUE;
        }

        @Override // b.d.c.c.g
        /* renamed from: g */
        public void onPostExecute(Boolean val) {
            if (val.booleanValue()) {
                h4.this.notifyDataSetChanged();
            }
        }

        @Override // b.d.c.c.g
        protected void showLoading(boolean show) {
        }
    }

    public h4(Context context, Cursor cursor, int chapterIndex, com.martian.mibook.lib.model.c.g source, ListView listView, boolean readingMode) {
        super(context, R.layout.reading_dir_item, cursor, new String[]{"title"}, new int[]{R.id.tv_chapter_title}, 2);
        this.u = false;
        this.A = false;
        this.t = context;
        this.s = chapterIndex;
        this.w = new Hashtable();
        this.x = new Hashtable();
        this.y = source;
        this.z = listView;
        this.B = readingMode;
        listView.setOnScrollListener(this);
    }

    public void f(final int position) {
        Chapter item;
        MiChapterList miChapterList = this.v;
        if (miChapterList == null || miChapterList.getChapterClass() == TXTChapter.class || this.w.containsKey(Integer.valueOf(position))) {
            return;
        }
        synchronized (this) {
            try {
                item = this.v.getItem(position);
            } catch (Exception unused) {
                return;
            }
        }
        if (item == null) {
            return;
        }
        this.w.put(Integer.valueOf(position), Boolean.valueOf(MiConfigSingleton.V3().l3().o0(this.y, item)));
        this.x.put(Integer.valueOf(position), Boolean.valueOf(item.isFree()));
    }

    private void g(final int start, final int end) {
        new a(start, end).execute(new Void[0]);
    }

    private synchronized View j(int position, View convertView, ViewGroup parent) {
        View view;
        view = super.getView(position, convertView, parent);
        w5 a2 = w5.a(view);
        if (l(position)) {
            a2.f12898c.setVisibility(0);
            a2.f12898c.setText(this.t.getString(R.string.cached));
        } else if (m(position)) {
            a2.f12898c.setVisibility(4);
        } else {
            a2.f12898c.setVisibility(0);
            a2.f12898c.setText(this.t.getString(R.string.locked));
        }
        if (this.B) {
            MiReadingTheme r = MiConfigSingleton.V3().J4.r();
            a2.f12898c.setTextColor(r.getTextColorThirdly(this.t));
            if (this.s == position) {
                a2.f12897b.setVisibility(0);
                if (MiConfigSingleton.V3().J4.E()) {
                    a2.f12899d.setTextColor(ContextCompat.getColor(this.t, com.martian.libmars.d.h.F().t0()));
                    a2.f12897b.setColorFilter(ContextCompat.getColor(this.t, com.martian.libmars.d.h.F().t0()));
                } else if (r.isCowTheme()) {
                    a2.f12899d.setTextColor(ContextCompat.getColor(this.t, R.color.reader_cow_item_color_primary_highlight));
                    a2.f12897b.setColorFilter(ContextCompat.getColor(this.t, R.color.reader_cow_item_color_primary_highlight));
                } else {
                    a2.f12899d.setTextColor(r.getItemColorPrimary());
                    a2.f12897b.setColorFilter(r.getItemColorPrimary());
                }
            } else {
                a2.f12899d.setTextColor(r.getTextColorPrimary(this.t));
                a2.f12897b.setVisibility(8);
            }
        } else {
            if (this.s == position) {
                a2.f12897b.setVisibility(0);
                a2.f12897b.setColorFilter(ContextCompat.getColor(this.t, com.martian.libmars.d.h.F().t0()));
                a2.f12899d.setTextColor(ContextCompat.getColor(this.t, com.martian.libmars.d.h.F().t0()));
            } else {
                a2.f12897b.setVisibility(8);
                a2.f12899d.setTextColor(com.martian.libmars.d.h.F().q0());
            }
            a2.f12898c.setTextColor(com.martian.libmars.d.h.F().r0());
        }
        return view;
    }

    private boolean l(int position) {
        MiChapterList miChapterList = this.v;
        if (miChapterList == null) {
            return false;
        }
        if (miChapterList.getChapterClass() == TXTChapter.class) {
            return true;
        }
        Boolean bool = this.w.get(Integer.valueOf(position));
        return bool != null && bool.booleanValue();
    }

    private boolean m(int position) {
        Boolean bool;
        MiChapterList miChapterList = this.v;
        return miChapterList == null || miChapterList.getChapterClass() == TXTChapter.class || (bool = this.x.get(Integer.valueOf(position))) == null || bool.booleanValue();
    }

    @Override // androidx.cursoradapter.widget.CursorAdapter, android.widget.Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        return j(i(position), convertView, parent);
    }

    public int h() {
        return this.s;
    }

    public int i(int position) {
        return this.u ? (getCount() - position) - 1 : position;
    }

    public int k() {
        return i(this.s);
    }

    public boolean n() {
        return this.u;
    }

    public void o() {
        this.u = !this.u;
        notifyDataSetChanged();
        onScrollStateChanged(this.z, 0);
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        this.A = true;
        if (scrollState == 0) {
            int firstVisiblePosition = this.z.getFirstVisiblePosition();
            int lastVisiblePosition = this.z.getLastVisiblePosition() + 1;
            if (this.u) {
                int count = getCount() - lastVisiblePosition;
                lastVisiblePosition = (getCount() - firstVisiblePosition) - 1;
                firstVisiblePosition = count;
            }
            g(firstVisiblePosition, lastVisiblePosition);
        }
    }

    public void p(int index) {
        this.s = index;
        g(Math.max(0, index), Math.min(getCount(), this.s + 20));
        notifyDataSetChanged();
    }

    public void q(MiChapterList chapterList) {
        this.v = chapterList;
        if (!this.A) {
            g(Math.max(0, this.s), Math.min(getCount(), this.s + 20));
        }
        notifyDataSetChanged();
    }
}
