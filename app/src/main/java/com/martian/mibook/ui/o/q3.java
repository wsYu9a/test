package com.martian.mibook.ui.o;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.widget.TextView;
import androidx.cursoradapter.widget.SimpleCursorAdapter;
import com.martian.mibook.lib.model.data.MiBookMark;
import com.martian.ttbookhd.R;

/* loaded from: classes4.dex */
public class q3 extends SimpleCursorAdapter {
    public q3(final Context context, Cursor c2) {
        super(context, R.layout.book_mark_item, c2, new String[]{"chapterTitle", "summary", "markTime", "dimiPercent"}, new int[]{R.id.tv_chapter_title, R.id.tv_summary, R.id.tv_mark_time, R.id.tv_dimi_percent}, 2);
        setViewBinder(new SimpleCursorAdapter.ViewBinder() { // from class: com.martian.mibook.ui.o.k
            @Override // androidx.cursoradapter.widget.SimpleCursorAdapter.ViewBinder
            public final boolean setViewValue(View view, Cursor cursor, int i2) {
                return q3.f(view, cursor, i2);
            }
        });
    }

    static /* synthetic */ boolean f(View view, Cursor cursor, int columnIndex) {
        if (view.getId() != R.id.tv_mark_time) {
            return false;
        }
        ((TextView) view).setText(com.martian.libmars.utils.p0.z(cursor.getLong(columnIndex)));
        return true;
    }

    public MiBookMark e(int position) {
        return (MiBookMark) com.martian.libsupport.j.createInstanceFromCursor(MiBookMark.class, (Cursor) getItem(position));
    }
}
