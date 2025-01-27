package com.sigmob.sdk.downloader.core.breakpoint;

import android.database.Cursor;
import java.io.File;

/* loaded from: classes4.dex */
public class d {

    /* renamed from: a */
    public final int f19014a;

    /* renamed from: b */
    public final String f19015b;

    /* renamed from: c */
    public final String f19016c;

    /* renamed from: d */
    public final String f19017d;

    /* renamed from: e */
    public final String f19018e;

    /* renamed from: f */
    public final boolean f19019f;

    /* renamed from: g */
    public final boolean f19020g;

    public d(Cursor cursor) {
        int columnIndex = cursor.getColumnIndex("id");
        boolean z10 = false;
        this.f19014a = columnIndex >= 0 ? cursor.getInt(columnIndex) : 0;
        int columnIndex2 = cursor.getColumnIndex("url");
        this.f19015b = columnIndex2 >= 0 ? cursor.getString(columnIndex2) : "";
        int columnIndex3 = cursor.getColumnIndex(f.f19041c);
        this.f19016c = columnIndex3 >= 0 ? cursor.getString(columnIndex3) : "";
        int columnIndex4 = cursor.getColumnIndex(f.f19042d);
        this.f19017d = columnIndex4 >= 0 ? cursor.getString(columnIndex4) : "";
        int columnIndex5 = cursor.getColumnIndex(f.f19043e);
        this.f19018e = columnIndex5 >= 0 ? cursor.getString(columnIndex5) : "";
        int columnIndex6 = cursor.getColumnIndex(f.f19044f);
        this.f19019f = columnIndex6 >= 0 && cursor.getInt(columnIndex6) == 1;
        int columnIndex7 = cursor.getColumnIndex("chunked");
        if (columnIndex7 >= 0 && cursor.getInt(columnIndex7) == 1) {
            z10 = true;
        }
        this.f19020g = z10;
    }

    public String a() {
        return this.f19016c;
    }

    public String b() {
        return this.f19018e;
    }

    public int c() {
        return this.f19014a;
    }

    public String d() {
        return this.f19017d;
    }

    public String e() {
        return this.f19015b;
    }

    public boolean f() {
        return this.f19020g;
    }

    public boolean g() {
        return this.f19019f;
    }

    public c h() {
        c cVar = new c(this.f19014a, this.f19015b, new File(this.f19017d), this.f19018e, this.f19019f);
        cVar.a(this.f19016c);
        cVar.a(this.f19020g);
        return cVar;
    }
}
