package com.aggmoread.sdk.z.d.a.a.e;

import android.content.SharedPreferences;
import com.ss.android.socialbase.downloader.setting.DownloadSettingKeys;

/* loaded from: classes.dex */
public class h {

    /* renamed from: b */
    private static h f6093b;

    /* renamed from: a */
    private String f6094a;

    public class a implements e {

        /* renamed from: a */
        final /* synthetic */ String f6095a;

        /* renamed from: b */
        final /* synthetic */ String f6096b;

        public a(h hVar, String str, String str2) {
            this.f6095a = str;
            this.f6096b = str2;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.h.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putString(this.f6095a, this.f6096b);
            return false;
        }
    }

    public class b implements e {

        /* renamed from: a */
        final /* synthetic */ String f6097a;

        /* renamed from: b */
        final /* synthetic */ long f6098b;

        public b(h hVar, String str, long j10) {
            this.f6097a = str;
            this.f6098b = j10;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.h.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putLong(this.f6097a, this.f6098b);
            return false;
        }
    }

    public class c implements e {

        /* renamed from: a */
        final /* synthetic */ String f6099a;

        /* renamed from: b */
        final /* synthetic */ boolean f6100b;

        public c(h hVar, String str, boolean z10) {
            this.f6099a = str;
            this.f6100b = z10;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.h.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.putBoolean(this.f6099a, this.f6100b);
            return false;
        }
    }

    public class d implements e {

        /* renamed from: a */
        final /* synthetic */ String f6101a;

        public d(h hVar, String str) {
            this.f6101a = str;
        }

        @Override // com.aggmoread.sdk.z.d.a.a.e.h.e
        public boolean a(SharedPreferences.Editor editor) {
            editor.remove(this.f6101a);
            return false;
        }
    }

    public interface e {
        boolean a(SharedPreferences.Editor editor);
    }

    public h(String str) {
        this.f6094a = com.aggmoread.sdk.z.d.a.a.e.c.l() + hf.e.f26694a + str;
    }

    public int a(String str, int i10) {
        return b().getInt(str, i10);
    }

    public SharedPreferences b() {
        return com.aggmoread.sdk.z.d.a.a.d.b.j.f6027q.getSharedPreferences(this.f6094a, 0);
    }

    public long a(String str, long j10) {
        return b().getLong(str, j10);
    }

    public void b(String str, long j10) {
        a(new b(this, str, j10));
    }

    public static h a() {
        if (f6093b == null) {
            synchronized (h.class) {
                try {
                    if (f6093b == null) {
                        f6093b = new h(DownloadSettingKeys.BugFix.DEFAULT);
                    }
                } finally {
                }
            }
        }
        return f6093b;
    }

    public void b(String str, String str2) {
        a(new a(this, str, str2));
    }

    public String a(String str, String str2) {
        return b().getString(str, str2);
    }

    public void b(String str, boolean z10) {
        a(new c(this, str, z10));
    }

    public void a(e eVar) {
        SharedPreferences.Editor edit = b().edit();
        if (eVar.a(edit)) {
            edit.commit();
        } else {
            edit.apply();
        }
    }

    public void a(String str) {
        a(new d(this, str));
    }

    public boolean a(String str, boolean z10) {
        return b().getBoolean(str, z10);
    }
}
