package com.martian.ttbook.b.c.a.a.e;

import android.content.SharedPreferences;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes4.dex */
public class f {

    /* renamed from: a */
    private static f f15827a;

    /* renamed from: b */
    private String f15828b;

    class a implements e {

        /* renamed from: a */
        final /* synthetic */ String f15829a;

        /* renamed from: b */
        final /* synthetic */ String f15830b;

        a(f fVar, String str, String str2) {
            this.f15829a = str;
            this.f15830b = str2;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.f.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putString(this.f15829a, this.f15830b);
            return false;
        }
    }

    class b implements e {

        /* renamed from: a */
        final /* synthetic */ String f15831a;

        /* renamed from: b */
        final /* synthetic */ long f15832b;

        b(f fVar, String str, long j2) {
            this.f15831a = str;
            this.f15832b = j2;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.f.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putLong(this.f15831a, this.f15832b);
            return false;
        }
    }

    class c implements e {

        /* renamed from: a */
        final /* synthetic */ String f15833a;

        /* renamed from: b */
        final /* synthetic */ boolean f15834b;

        c(f fVar, String str, boolean z) {
            this.f15833a = str;
            this.f15834b = z;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.f.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putBoolean(this.f15833a, this.f15834b);
            return false;
        }
    }

    class d implements e {

        /* renamed from: a */
        final /* synthetic */ String f15835a;

        d(f fVar, String str) {
            this.f15835a = str;
        }

        @Override // com.martian.ttbook.b.c.a.a.e.f.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.remove(this.f15835a);
            return false;
        }
    }

    public interface e {
        boolean a(SharedPreferences.Editor editor);
    }

    public f(String str) {
        this.f15828b = com.martian.ttbook.b.c.a.a.e.b.s() + "_" + str;
    }

    public static f c() {
        if (f15827a == null) {
            synchronized (f.class) {
                if (f15827a == null) {
                    f15827a = new f(DownloadSettingKeys.BugFix.DEFAULT);
                }
            }
        }
        return f15827a;
    }

    public int a(String str, int i2) {
        return h().getInt(str, i2);
    }

    public long b(String str, long j2) {
        return h().getLong(str, j2);
    }

    public String d(String str, String str2) {
        return h().getString(str, str2);
    }

    public void e(e eVar) {
        SharedPreferences.Editor edit = h().edit();
        if (eVar.a(edit)) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public void f(String str) {
        e(new d(this, str));
    }

    public boolean g(String str, boolean z) {
        return h().getBoolean(str, z);
    }

    protected SharedPreferences h() {
        return com.martian.ttbook.b.c.a.a.d.b.j.q.getSharedPreferences(this.f15828b, 0);
    }

    public void i(String str, long j2) {
        e(new b(this, str, j2));
    }

    public void j(String str, String str2) {
        e(new a(this, str, str2));
    }

    public void k(String str, boolean z) {
        e(new c(this, str, z));
    }
}
