package cn.vlion.ad.inland.base;

import android.view.View;
import cn.vlion.ad.inland.base.javabean.VlionADClickType;

/* loaded from: classes.dex */
public interface g1 {
    void a(int i10);

    void a(View view);

    void a(VlionADClickType vlionADClickType);

    void b(int i10);

    void onAdPlayFailure(int i10, String str);

    void onAdReward();

    void onAdVideoPlayComplete();

    void onAdVideoPlaying(int i10, int i11);

    void onAdVideoStart();
}
