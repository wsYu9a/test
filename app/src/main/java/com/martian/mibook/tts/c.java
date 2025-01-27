package com.martian.mibook.tts;

import android.content.Intent;
import com.martian.libmars.activity.j1;
import com.martian.libmars.utils.q0;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;

/* loaded from: classes4.dex */
public class c {

    /* renamed from: a */
    private String f14135a;

    /* renamed from: b */
    private String f14136b;

    /* renamed from: c */
    private Intent f14137c;

    /* renamed from: d */
    private boolean f14138d;

    public c(Intent intent, String title, String desc, boolean opened) {
        this.f14137c = intent;
        this.f14135a = title;
        this.f14136b = desc;
        this.f14138d = opened;
    }

    public String a() {
        return this.f14136b;
    }

    public Intent b() {
        return this.f14137c;
    }

    public String c() {
        return this.f14135a;
    }

    public boolean d() {
        return this.f14138d;
    }

    public c e(String desc) {
        this.f14136b = desc;
        return this;
    }

    public c f(Intent intent) {
        this.f14137c = intent;
        return this;
    }

    public c g(boolean opened) {
        this.f14138d = opened;
        return this;
    }

    public c h(String title) {
        this.f14135a = title;
        return this;
    }

    public void i(j1 activity) {
        if (this.f14138d) {
            activity.k1("您已设置");
        }
        Intent intent = this.f14137c;
        if (intent != null) {
            try {
                intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
                activity.startActivityForResult(this.f14137c, 1025);
            } catch (Exception e2) {
                q0.e(e2.toString());
                activity.startActivity(new Intent("android.settings.SETTINGS"));
            }
        }
    }
}
