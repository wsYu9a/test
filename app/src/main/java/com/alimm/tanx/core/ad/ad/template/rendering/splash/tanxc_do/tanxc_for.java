package com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ad.ITanxAd;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.ITanxSplashInteractionListener;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeBean;
import com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView;
import com.alimm.tanx.core.ad.bean.BidInfo;
import com.alimm.tanx.core.ut.impl.TanxBaseUt;
import com.alimm.tanx.core.ut.impl.TanxCommonUt;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public class tanxc_for extends tanxc_if {
    private long tanxc_break;
    private ShakeView tanxc_catch;
    protected ViewGroup tanxc_this;
    protected LinearLayout tanxc_void;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for$1 */
    public class AnonymousClass1 implements InteractiveCallback {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void destroy(String str) {
            TanxCommonUt.utShakeDestroy(tanxc_for.this.tanxc_int, str);
        }

        @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
        public void onShake() {
            LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView 互动成功摇一摇跳转");
            tanxc_for.this.tanxc_break();
        }
    }

    public tanxc_for(@NonNull com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do tanxc_doVar, @NonNull Context context, @NonNull ViewGroup viewGroup, @NonNull ITanxAd iTanxAd) {
        super(tanxc_doVar, context, viewGroup, iTanxAd);
    }

    private void tanxc_catch() {
        HashMap hashMap = new HashMap();
        hashMap.put("add_interaction_view_time", String.valueOf(SystemClock.elapsedRealtime() - this.tanxc_break));
        TanxBaseUt.shake("add_interaction_view_time", null, hashMap);
    }

    private void tanxc_if(@NonNull ViewGroup viewGroup) {
        LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView");
        BidInfo bidInfo = this.tanxc_for;
        ShakeBean build = (bidInfo == null || bidInfo.getTemplateConf() == null) ? null : new ShakeBean().build(this.tanxc_for.getTemplateConf());
        if (this.tanxc_catch == null) {
            this.tanxc_catch = new ShakeView(this.tanxc_do, build);
        }
        this.tanxc_this.setVisibility(0);
        tanxc_catch();
        this.tanxc_catch.setClickable(false);
        this.tanxc_catch.setOnTouchListener(null);
        this.tanxc_catch.load(new InteractiveCallback() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_for.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
            public void destroy(String str) {
                TanxCommonUt.utShakeDestroy(tanxc_for.this.tanxc_int, str);
            }

            @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.InteractiveCallback
            public void onShake() {
                LogUtils.d("ShakeInteractionTemplate", "showNativeShakeView 互动成功摇一摇跳转");
                tanxc_for.this.tanxc_break();
            }
        }, true);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, DimenUtil.dp2px(this.tanxc_do, 280.0f));
        layoutParams.gravity = 80;
        viewGroup.addView(this.tanxc_catch, layoutParams);
    }

    public void tanxc_break() {
        if (this.tanxc_char) {
            LogUtils.d("ShakeInteractionTemplate", "mClickedOnce = true");
            return;
        }
        this.tanxc_char = true;
        ITanxSplashInteractionListener iTanxSplashInteractionListener = this.tanxc_long;
        if (iTanxSplashInteractionListener != null) {
            iTanxSplashInteractionListener.onAdShake();
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_byte() {
        super.tanxc_byte();
        this.tanxc_void = (LinearLayout) this.tanxc_if.findViewById(R.id.splash_ad_interaction_root);
        this.tanxc_this = (ViewGroup) this.tanxc_if.findViewById(R.id.splash_ad_interaction_container);
        if (tanxc_void()) {
            this.tanxc_void.setVisibility(0);
            this.tanxc_this.setVisibility(0);
            tanxc_do(this.tanxc_this);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public View tanxc_char() {
        return this.tanxc_catch;
    }

    public void tanxc_do(@NonNull ViewGroup viewGroup) {
        this.tanxc_break = SystemClock.elapsedRealtime();
        tanxc_if(viewGroup);
        tanxc_do(this.tanxc_for, "add_interaction_view", null);
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public void tanxc_new() {
        super.tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_if, com.alimm.tanx.core.ad.ad.template.rendering.splash.tanxc_do.tanxc_do
    public int tanxc_try() {
        return R.id.xadsdk_splash_ad_stub_interaction;
    }

    public boolean tanxc_void() {
        return true;
    }

    public static void tanxc_do(BidInfo bidInfo, String str, Map<String, String> map) {
        HashMap hashMap = new HashMap();
        if (map != null) {
            hashMap.putAll(map);
        }
        TanxBaseUt.shake(str, bidInfo, null);
    }
}
