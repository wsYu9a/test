package com.martian.mibook.lib.model.e;

import android.database.Cursor;
import com.martian.mibook.lib.model.data.MiBookMark;

/* loaded from: classes3.dex */
public class f extends o<MiBookMark> {

    /* renamed from: h */
    private static f f13974h;

    public f() {
        super("tfbookmarks.db", 1, MiBookMark.class);
    }

    public static f q() {
        if (f13974h == null) {
            f13974h = new f();
        }
        return f13974h;
    }

    public boolean o(MiBookMark bookMark) {
        return insert(bookMark) == 1;
    }

    public boolean p(MiBookMark bookMark) {
        return delete(bookMark);
    }

    public Cursor r(String sourceString) {
        return query("sourceString = ?", new String[]{sourceString}, "markTime DESC");
    }
}
