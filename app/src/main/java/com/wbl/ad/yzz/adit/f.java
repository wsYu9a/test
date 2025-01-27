package com.wbl.ad.yzz.adit;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import com.wbl.ad.yzz.config.AdInitConfig;
import com.wbl.ad.yzz.config.IAdEventListener;
import com.wbl.ad.yzz.config.IConfigAdFilter;
import com.wbl.ad.yzz.config.IPersonalAdSettingListener;
import com.wbl.ad.yzz.config.OnAdClickListener;
import com.wbl.ad.yzz.config.PageOptions;

/* loaded from: classes5.dex */
public interface f {
    void a(int i2);

    void a(@f.b.a.e Activity activity, @f.b.a.e PageOptions pageOptions);

    void a(@f.b.a.e Activity activity, @f.b.a.e String str);

    void a(@f.b.a.e Application application, @f.b.a.e AdInitConfig adInitConfig);

    void a(@f.b.a.e Context context);

    void a(@f.b.a.e IAdEventListener iAdEventListener);

    void a(@f.b.a.e IConfigAdFilter iConfigAdFilter);

    void a(@f.b.a.e IPersonalAdSettingListener iPersonalAdSettingListener);

    void a(@f.b.a.e OnAdClickListener onAdClickListener);

    void a(@f.b.a.e String str);

    void a(boolean z);

    void a(boolean z, @f.b.a.e String str);

    boolean a();

    void b(@f.b.a.e Activity activity, @f.b.a.e PageOptions pageOptions);

    void b(@f.b.a.e String str);

    void b(boolean z);

    boolean b();

    void c();

    void c(@f.b.a.e Activity activity, @f.b.a.e PageOptions pageOptions);

    void c(@f.b.a.e String str);

    void c(boolean z);
}
