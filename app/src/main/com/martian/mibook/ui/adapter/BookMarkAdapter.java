package com.martian.mibook.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import ba.k;
import com.martian.mibook.R;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.mibook.ui.adapter.BookMarkAdapter;
import l9.o0;

/* loaded from: classes3.dex */
public class BookMarkAdapter extends SimpleCursorAdapter {
    public BookMarkAdapter(Context context, Cursor cursor) {
        super(context, R.layout.book_mark_item, cursor, new String[]{"chapterTitle", "summary", "markTime", "dimiPercent"}, new int[]{R.id.tv_chapter_title, R.id.tv_summary, R.id.tv_mark_time, R.id.tv_dimi_percent}, 2);
        setViewBinder(new SimpleCursorAdapter.ViewBinder() { // from class: ce.k
            @Override // androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder
            public final boolean setViewValue(View view, Cursor cursor2, int i10) {
                boolean c10;
                c10 = BookMarkAdapter.c(view, cursor2, i10);
                return c10;
            }
        });
    }

    public static /* synthetic */ boolean c(View view, Cursor cursor, int i10) {
        if (view.getId() == R.id.tv_mark_time) {
            ((TextView) view).setText(o0.B(cursor.getLong(i10)));
            return true;
        }
        if (view.getId() != R.id.tv_summary) {
            return false;
        }
        try {
            TextView textView = (TextView) view;
            if (cursor.getInt(cursor.getColumnIndex("type")) == 1) {
                textView.setPaintFlags(textView.getPaintFlags() | 8);
            } else {
                textView.setPaintFlags(textView.getPaintFlags() & (-9));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public MiBookMark b(int i10) {
        return (MiBookMark) k.h(MiBookMark.class, (Cursor) getItem(i10));
    }
}
