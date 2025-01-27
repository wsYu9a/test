package com.martian.mibook.application;

import android.app.Activity;
import com.wbl.ad.yzz.config.AdInitialize;
import com.wbl.ad.yzz.config.CheckNextChapterCallback;
import com.wbl.ad.yzz.config.PageOptions;
import com.wbl.ad.yzz.config.RewardCallback;

/* loaded from: classes.dex */
public class w0 {

    /* renamed from: a */
    public static final int f11608a = 1;

    /* renamed from: b */
    public static final int f11609b = 0;

    public void a(Activity activity, String str, int i2, CheckNextChapterCallback checkNextChapterCallback) {
        MiConfigSingleton.V3().c5();
        AdInitialize.getInstance().checkNextChapter(activity, new PageOptions.Builder().gender(MiConfigSingleton.V3().k()).bgType(0).isInNoAdTime(MiConfigSingleton.V3().x8() ? 1 : 0).isActiveCall(0).isDarkMode(MiConfigSingleton.V3().P0() ? 1 : 0).bookId(str).chapterNo(i2).build(), checkNextChapterCallback);
    }

    public void b(Activity activity, String str, int i2, int i3, String str2, RewardCallback rewardCallback) {
        com.martian.mibook.lib.model.g.b.l0(activity, str2 + "-启动");
        MiConfigSingleton.V3().c5();
        AdInitialize.getInstance().startAdPage(activity, new PageOptions.Builder().gender(MiConfigSingleton.V3().k()).bgType(MiConfigSingleton.V3().J4.B()).isInNoAdTime(MiConfigSingleton.V3().x8() ? 1 : 0).isActiveCall(i3).isDarkMode(MiConfigSingleton.V3().P0() ? 1 : 0).bookId(str).chapterNo(i2).build(), rewardCallback);
    }
}
