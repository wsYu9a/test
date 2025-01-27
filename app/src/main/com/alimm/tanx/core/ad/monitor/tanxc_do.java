package com.alimm.tanx.core.ad.monitor;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import com.alimm.tanx.core.ad.view.TanxAdView;
import com.alimm.tanx.core.constant.AdConstants;
import com.alimm.tanx.core.orange.OrangeManager;
import com.alimm.tanx.core.orange.bean.ExposureConfigBean;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.TanxCountDownTimer;

/* loaded from: classes.dex */
public class tanxc_do implements ViewTreeObserver.OnPreDrawListener, ITanxAdMonitor {
    private long tanxc_break;
    protected volatile boolean tanxc_byte;
    protected float tanxc_case;
    private long tanxc_catch;
    protected long tanxc_char;
    private final int tanxc_class;
    protected TanxAdView tanxc_do;
    protected boolean tanxc_else;
    protected boolean tanxc_for;
    protected Rect tanxc_goto;
    protected ITanxExposureCallback tanxc_if;
    protected boolean tanxc_int;
    protected String tanxc_long;
    protected boolean tanxc_new;
    private volatile TanxCountDownTimer tanxc_this;
    protected volatile boolean tanxc_try;
    private long tanxc_void;

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i10) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = true;
        this.tanxc_break = 500L;
        this.tanxc_catch = 0L;
        this.tanxc_goto = new Rect();
        this.tanxc_long = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_class = i10;
        tanxc_if();
    }

    public void tanxc_break() {
        try {
            LogUtils.d("TanxAdMonitor", "cancelTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "cancelTimer 开关关闭");
            } else if (this.tanxc_this != null) {
                this.tanxc_this.cancel();
                this.tanxc_this = null;
            }
        } catch (Exception e10) {
            LogUtils.e("TanxAdMonitor", "cancelTimer", e10);
        }
    }

    private void tanxc_long() {
        try {
            LogUtils.d("TanxAdMonitor", "initTimer  init");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "initTimer 开关关闭");
            } else {
                if (this.tanxc_this != null) {
                    return;
                }
                LogUtils.d("TanxAdMonitor", "initTimer  init start");
                this.tanxc_this = new TanxCountDownTimer(180000L, 200L) { // from class: com.alimm.tanx.core.ad.monitor.TanxAdMonitor$1
                    public TanxAdMonitor$1(long j10, long j11) {
                        super(j10, j11);
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onFinish() {
                        LogUtils.d("TanxAdMonitor", "initTimer - onFinish");
                    }

                    @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
                    public void onTick(long j10) {
                        LogUtils.d("TanxAdMonitor", "initTimer  onTick exposureCompleted: " + tanxc_do.this.tanxc_byte + " isOnExposure: " + tanxc_do.this.tanxc_try);
                        if (tanxc_do.this.tanxc_byte) {
                            tanxc_do.this.tanxc_break();
                        } else if (tanxc_do.this.tanxc_try) {
                            tanxc_do.this.onPreDraw();
                        }
                    }
                };
            }
        } catch (Exception e10) {
            LogUtils.e("TanxAdMonitor", "initTimer", e10);
        }
    }

    private void tanxc_this() {
        try {
            LogUtils.d("TanxAdMonitor", "startTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "startTimer 开关关闭");
                return;
            }
            if (this.tanxc_byte) {
                LogUtils.d("TanxAdMonitor", "startTimer 已经曝光，不再重复启动");
                return;
            }
            tanxc_long();
            if (this.tanxc_this == null) {
                LogUtils.d("TanxAdMonitor", "startTimer tanxExposureCheckTimer为空");
            } else if (this.tanxc_this.isPaused()) {
                LogUtils.d("TanxAdMonitor", "startTimer resume");
                this.tanxc_this.resume();
            } else {
                LogUtils.d("TanxAdMonitor", "startTimer start");
                this.tanxc_this.start();
            }
        } catch (Exception e10) {
            LogUtils.e("TanxAdMonitor", "startTimer", e10);
        }
    }

    private void tanxc_void() {
        try {
            LogUtils.d("TanxAdMonitor", "stopTimer");
            if (!OrangeManager.getInstance().getCommonSwitch("useRealTimeExposer")) {
                LogUtils.d("TanxAdMonitor", "stopTimer 开关关闭");
            } else if (this.tanxc_this != null) {
                this.tanxc_this.pause();
            }
        } catch (Exception e10) {
            LogUtils.e("TanxAdMonitor", "stopTimer", e10);
        }
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onAttachedToWindow() {
        this.tanxc_for = true;
        this.tanxc_do.getViewTreeObserver().addOnPreDrawListener(this);
        tanxc_long();
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onAttachedToWindow");
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onDetachedFromWindow() {
        this.tanxc_for = false;
        this.tanxc_do.getViewTreeObserver().removeOnPreDrawListener(this);
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告onDetachedFromWindow");
        tanxc_new();
        tanxc_break();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        boolean z10 = this.tanxc_do.getLocalVisibleRect(this.tanxc_goto) && this.tanxc_do.isShown();
        LogUtils.i("TanxAdMonitor", "onPreDraw isVisible->" + z10 + " showRatio：" + this.tanxc_case);
        if (!z10) {
            tanxc_new();
            return true;
        }
        if (this.tanxc_case <= 0.0f) {
            tanxc_for();
        } else if (Math.abs(this.tanxc_goto.height()) <= this.tanxc_do.getHeight() * this.tanxc_case || Math.abs(this.tanxc_goto.width()) <= this.tanxc_do.getWidth() * this.tanxc_case) {
            tanxc_new();
        } else {
            LogUtils.i("TanxAdMonitor", "满足曝光面积");
            tanxc_for();
        }
        return true;
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onVisibilityAggregated(boolean z10) {
        this.tanxc_new = z10;
        if (z10) {
            return;
        }
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告变为不可见");
        tanxc_new();
    }

    @Override // com.alimm.tanx.core.ad.monitor.ITanxAdMonitor
    public void onWindowFocusChanged(boolean z10) {
        this.tanxc_int = z10;
        LogUtils.d("TanxAdMonitor_Lifecycle", "广告焦点发生变化，onWindowFocusChanged=" + z10);
        tanxc_new();
        if (z10) {
            onPreDraw();
        }
    }

    public void tanxc_byte() {
        this.tanxc_try = true;
        this.tanxc_void = System.currentTimeMillis();
    }

    public void tanxc_case() {
        this.tanxc_try = false;
    }

    public boolean tanxc_char() {
        LogUtils.d("TanxAdMonitor-Cover", "checkCover开始计算遮挡比例,adType:" + this.tanxc_class);
        ExposureConfigBean exposureConfigBean = OrangeManager.getInstance().getExposureConfigBean(this.tanxc_class);
        if (exposureConfigBean == null || !exposureConfigBean.checkCoverSwitch) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(exposureConfigBean == null ? "exposureConfigBean==null" : "checkCoverSwitch为false");
            sb2.append("，终止检测。adType:");
            sb2.append(this.tanxc_class);
            LogUtils.d("TanxAdMonitor-Cover", sb2.toString());
            return true;
        }
        if (System.currentTimeMillis() - this.tanxc_catch < this.tanxc_break) {
            LogUtils.d("TanxAdMonitor-Cover", "checkCover时间间隔条件触发熔断，直接返回coverBoolean：" + this.tanxc_else);
            return this.tanxc_else;
        }
        this.tanxc_catch = System.currentTimeMillis();
        if (this.tanxc_byte) {
            LogUtils.d("TanxAdMonitor-Cover", "checkCover-已经曝光，不再计算遮挡比例");
            this.tanxc_else = true;
        } else {
            long currentTimeMillis = System.currentTimeMillis();
            float tanxc_else = tanxc_else();
            this.tanxc_else = tanxc_else <= 1.0f - this.tanxc_case;
            LogUtils.d("TanxAdMonitor-Cover", "checkCover-coverFloat:" + tanxc_else + ",coverBoolean:" + this.tanxc_else + ",耗时：" + (System.currentTimeMillis() - currentTimeMillis));
        }
        return this.tanxc_else;
    }

    public float tanxc_else() {
        if (this.tanxc_do.getVisibility() != 0) {
            return 1.0f;
        }
        View view = this.tanxc_do;
        Rect rect = new Rect();
        if (!view.getGlobalVisibleRect(rect)) {
            return 1.0f;
        }
        int measuredHeight = (this.tanxc_do.getMeasuredHeight() * this.tanxc_do.getMeasuredWidth()) - (rect.width() * rect.height());
        float f10 = 0.0f;
        while (view.getParent() instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view.getParent();
            if (viewGroup.getVisibility() != 0) {
                return 1.0f;
            }
            int tanxc_do = tanxc_do(view, viewGroup);
            while (true) {
                tanxc_do++;
                if (tanxc_do < viewGroup.getChildCount()) {
                    View childAt = viewGroup.getChildAt(tanxc_do);
                    if (childAt.getVisibility() != 0) {
                        break;
                    }
                    Rect rect2 = new Rect();
                    this.tanxc_do.getGlobalVisibleRect(rect2);
                    Rect rect3 = new Rect();
                    childAt.getGlobalVisibleRect(rect3);
                    if (rect3.intersect(rect2)) {
                        f10 = Math.max(f10, ((rect3.width() * rect3.height()) + measuredHeight) / ((rect2.width() * rect2.height()) * 1.0f));
                    }
                }
            }
            view = viewGroup;
        }
        return Math.round(f10 * 100.0f) / 100.0f;
    }

    public void tanxc_for() {
        this.tanxc_new = this.tanxc_do.getVisibility() == 0;
        LogUtils.i("TanxAdMonitor", "tryStartExposure 尝试开始曝光计时，相关数据：attachedWindow=" + this.tanxc_for + "; hasWindowFocus" + this.tanxc_int + "; visibilityAggregated" + this.tanxc_new + "; isOnExposure=" + this.tanxc_try);
        if (this.tanxc_for && this.tanxc_int && this.tanxc_new && tanxc_char()) {
            if (!this.tanxc_try) {
                tanxc_byte();
                LogUtils.i("TanxAdMonitor", "开始曝光计时showTime:" + this.tanxc_char);
            }
            tanxc_int();
        }
        tanxc_this();
    }

    public boolean tanxc_goto() {
        return this.tanxc_for;
    }

    public void tanxc_if() {
        ExposureConfigBean exposureConfigBean = OrangeManager.getInstance().getExposureConfigBean(this.tanxc_class);
        if (exposureConfigBean == null) {
            tanxc_do();
        } else {
            this.tanxc_case = exposureConfigBean.showRatio;
            this.tanxc_char = exposureConfigBean.showTime;
        }
        if (this.tanxc_long.equals(AdConstants.PID_STYLE_NEW_REWARD_ID) || this.tanxc_long.equals("100016") || this.tanxc_long.equals("100022")) {
            LogUtils.d("TanxAdMonitor", "新激励浏览直接曝光 adType=" + this.tanxc_class + " pidStyleId=" + this.tanxc_long);
            tanxc_try();
            tanxc_do(0L);
        }
    }

    public void tanxc_int() {
        if (this.tanxc_char == 0) {
            tanxc_case();
            tanxc_try();
            tanxc_do(0L);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.tanxc_void;
        LogUtils.i("TanxAdMonitor", "tryExposure 曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
        if (currentTimeMillis > this.tanxc_char) {
            tanxc_try();
            LogUtils.i("TanxAdMonitor", "tryExposure 广告曝光成功，曝光时长=" + currentTimeMillis);
        }
    }

    public void tanxc_new() {
        if (this.tanxc_try) {
            tanxc_case();
            long currentTimeMillis = System.currentTimeMillis() - this.tanxc_void;
            LogUtils.i("TanxAdMonitor", "停止曝光,曝光时长=" + currentTimeMillis + " showTime=" + this.tanxc_char);
            if (currentTimeMillis > this.tanxc_char && tanxc_char()) {
                tanxc_try();
                tanxc_do(currentTimeMillis);
                LogUtils.i("TanxAdMonitor", "广告曝光总时长=" + currentTimeMillis);
            }
        }
        tanxc_void();
    }

    public void tanxc_try() {
        if (this.tanxc_byte) {
            return;
        }
        this.tanxc_byte = true;
        ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
        if (iTanxExposureCallback != null) {
            iTanxExposureCallback.exposure();
        }
    }

    public void tanxc_do() {
        this.tanxc_case = 0.5f;
        this.tanxc_char = 1000L;
    }

    public void tanxc_do(long j10) {
        ITanxExposureCallback iTanxExposureCallback = this.tanxc_if;
        if (iTanxExposureCallback != null) {
            iTanxExposureCallback.exposureTime(j10);
        }
    }

    private int tanxc_do(View view, ViewGroup viewGroup) {
        int i10 = 0;
        while (i10 < viewGroup.getChildCount() && viewGroup.getChildAt(i10) != view) {
            i10++;
        }
        return i10;
    }

    public tanxc_do(TanxAdView tanxAdView, ITanxExposureCallback iTanxExposureCallback, int i10, String str) {
        this.tanxc_for = false;
        this.tanxc_int = true;
        this.tanxc_try = false;
        this.tanxc_byte = false;
        this.tanxc_else = true;
        this.tanxc_break = 500L;
        this.tanxc_catch = 0L;
        this.tanxc_goto = new Rect();
        this.tanxc_long = "";
        this.tanxc_do = tanxAdView;
        this.tanxc_if = iTanxExposureCallback;
        this.tanxc_class = i10;
        if (!TextUtils.isEmpty(str)) {
            this.tanxc_long = str;
        }
        tanxc_if();
    }
}
