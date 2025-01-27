package com.alimm.tanx.core.ad.ad.template.rendering.splash.shake;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSON;
import com.alimm.tanx.core.R;
import com.alimm.tanx.core.ut.bean.UtSensor;
import com.alimm.tanx.core.ut.core.LifeCycleManager;
import com.alimm.tanx.core.utils.DimenUtil;
import com.alimm.tanx.core.utils.LogUtils;
import com.alimm.tanx.core.utils.NotConfused;
import com.umeng.analytics.pro.bt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import l5.c;

/* loaded from: classes.dex */
public class ShakeView extends View implements SensorEventListener, IShakeView, NotConfused {
    private static final long ROTATE_ANIM_INTERVAL_TIME = 333;
    private static final long ROTATE_ANIM_TIME = 1000;
    private static final String TAG = "ShakeView";
    public final int GESTURE_INTERACTION_END_CLICK;
    public final int GESTURE_INTERACTION_END_FAIL;
    public final int GESTURE_INTERACTION_END_SUCCESS;
    public final int GESTURE_INTERACTION_START;
    public final int MAX_SHAKE_THRESHOLD;
    public final int MIN_SHAKE_THRESHOLD;
    int count;
    private volatile boolean isShake;

    @Nullable
    private InteractiveCallback mCallBack;

    @NonNull
    @Nullable
    private Rect mCircleImgRect;
    private int mCircleLength;
    private Context mContext;
    private int mImagePadding;
    private float[] mLastMatchedSensorValues;
    private long mLastSenorCheckTime;
    private float[] mLastSensorValues;
    private long mLastShakeTime;
    private long mLastTimeShake;
    private float mNowShakeDegree;
    private int mNowVisibility;

    @NonNull
    private Paint mPaint;
    private int[] mPhoneImgSize;

    @NonNull
    private Rect mRealShakeImgRect;
    private ValueAnimator.AnimatorUpdateListener mRotateAnimListener;

    @Nullable
    private ValueAnimator mRotateAnimation;
    Sensor mSenAccelerometer;

    @Nullable
    private SensorManager mSenSensorManager;

    @Nullable
    private Bitmap mShakeBitMap;
    private int mShakeCnt;

    @NonNull
    private Rect mShakeImgRect;
    private int mShakeViewHeight;
    private String mShowText1;
    private String mShowText2;
    private int mShowTextColor1;
    private int mShowTextColor2;
    private float mShowTextHeight1;
    private float mShowTextHeight2;
    private Rect mShowTextRect1;
    private Rect mShowTextRect2;
    private float mShowTextSize1;
    private float mShowTextSize2;
    private int mTextPadding;

    @NonNull
    private Paint mTextPaint;
    private List<UtSensor> sensorList;
    private ShakeBean shakeBean;

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView$1 */
    public class AnonymousClass1 implements LifeCycleManager.AppVisibleCallBack {
        public AnonymousClass1() {
        }

        @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
        public void appVisibleCallBack(boolean z10, boolean z11) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("当前前后台状态：->");
            sb2.append(z10 ? "后台" : "前台");
            sb2.append(",是否由后台切换到前台：");
            sb2.append(z11);
            LogUtils.d(ShakeView.TAG, sb2.toString());
            if (z10) {
                ShakeView.this.pauseShake();
            }
            if (!z11 || ShakeView.this.mContext == null) {
                return;
            }
            ShakeView shakeView = ShakeView.this;
            shakeView.startShake(shakeView.mContext);
        }
    }

    /* renamed from: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView$2 */
    public class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        public AnonymousClass2() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            ShakeView.this.mNowShakeDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            ShakeView.this.postInvalidate();
        }
    }

    public ShakeView(@NonNull Context context, ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        init(context, shakeBean);
    }

    private void drawText(@NonNull Canvas canvas, @NonNull Paint paint, @NonNull String str, @NonNull Rect rect, float f10, int i10, boolean z10) {
        if (z10) {
            paint.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            paint.setTypeface(Typeface.DEFAULT);
        }
        paint.setTextSize(f10);
        paint.setColor(i10);
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float f11 = fontMetrics.bottom;
        canvas.drawText(str, rect.centerX(), rect.centerY() + (((f11 - fontMetrics.top) / 2.0f) - f11), paint);
    }

    private double getShakeIntensity(float[] fArr, float[] fArr2) {
        return (fArr == null || fArr2 == null || fArr.length < 2 || fArr2.length < 2) ? c.f27899e : Math.sqrt(Math.pow(fArr[0] - fArr2[0], 2.0d) + Math.pow(fArr[1] - fArr2[1], 2.0d));
    }

    private void init(Context context, ShakeBean shakeBean) {
        this.mContext = context;
        if (shakeBean != null) {
            this.shakeBean = shakeBean;
        } else {
            this.shakeBean = new ShakeBean().build(null);
        }
        LogUtils.d(TAG, "摇一摇参数：" + shakeBean.toString());
        SensorManager sensorManager = (SensorManager) context.getSystemService(bt.f23586ac);
        this.mSenSensorManager = sensorManager;
        Sensor defaultSensor = sensorManager.getDefaultSensor(10);
        this.mSenAccelerometer = defaultSensor;
        this.mSenSensorManager.registerListener(this, defaultSensor, 2);
        this.mShakeBitMap = BitmapFactory.decodeResource(context.getResources(), R.drawable.tanx_shake_phone);
        this.mCircleLength = DimenUtil.dp2px(context, 112.0f);
        this.mShakeViewHeight = DimenUtil.dp2px(context, 220.0f);
        this.mPhoneImgSize = new int[]{DimenUtil.dp2px(context, 79.0f), DimenUtil.dp2px(context, 71.0f)};
        this.mShowTextSize1 = DimenUtil.dp2px(context, 20.0f);
        this.mShowTextHeight1 = DimenUtil.dp2px(context, 2.0f);
        this.mPaint = new Paint();
        this.mShakeImgRect = new Rect();
        this.mRealShakeImgRect = new Rect();
        this.mCircleImgRect = new Rect();
        this.mShowTextRect1 = new Rect();
        this.mShowTextRect2 = new Rect();
        Paint paint = this.mPaint;
        Paint.Style style = Paint.Style.FILL;
        paint.setStyle(style);
        this.mPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mTextPaint = paint2;
        paint2.setStyle(style);
        this.mTextPaint.setAntiAlias(true);
        if (TextUtils.isEmpty(this.mShowText1)) {
            this.mShowText1 = "摇一摇";
        }
        this.mShowText2 = "互动跳转详情页面或第三方应用";
        this.mShowTextColor1 = Color.parseColor("#ffffff");
        this.mShowTextColor2 = Color.parseColor("#ffffff");
        startAnimation();
        LifeCycleManager.getInstance().register(TAG, new LifeCycleManager.AppVisibleCallBack() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.1
            public AnonymousClass1() {
            }

            @Override // com.alimm.tanx.core.ut.core.LifeCycleManager.AppVisibleCallBack
            public void appVisibleCallBack(boolean z10, boolean z11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("当前前后台状态：->");
                sb2.append(z10 ? "后台" : "前台");
                sb2.append(",是否由后台切换到前台：");
                sb2.append(z11);
                LogUtils.d(ShakeView.TAG, sb2.toString());
                if (z10) {
                    ShakeView.this.pauseShake();
                }
                if (!z11 || ShakeView.this.mContext == null) {
                    return;
                }
                ShakeView shakeView = ShakeView.this;
                shakeView.startShake(shakeView.mContext);
            }
        });
    }

    private boolean isShakeDirectionOpposite(float[] fArr, float[] fArr2) {
        return fArr != null && fArr2 != null && fArr.length >= 2 && fArr2.length >= 2 && (fArr[0] * fArr2[0]) + (fArr[1] * fArr2[1]) < 0.0f;
    }

    private void onLinerAccSenorChanged(SensorEvent sensorEvent) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (elapsedRealtime - this.mLastSenorCheckTime < this.shakeBean.getShakeSensorCheckInterval()) {
            LogUtils.d(TAG, "采集间隔过滤，return");
            return;
        }
        onLinerAccSenorChangedInner(sensorEvent, elapsedRealtime);
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastSensorValues = Arrays.copyOf(fArr, fArr.length);
        }
        this.mLastSenorCheckTime = elapsedRealtime;
    }

    private void onLinerAccSenorChangedInner(SensorEvent sensorEvent, long j10) {
        double shakeIntensity = getShakeIntensity(sensorEvent.values, this.mLastSensorValues);
        if (shakeIntensity < this.shakeBean.getShakeSplash()) {
            return;
        }
        LogUtils.d(TAG, "摇晃强度：" + shakeIntensity);
        if (j10 - this.mLastShakeTime > this.shakeBean.getShakeSensorShakeInterval()) {
            this.mShakeCnt = 1;
            this.mLastShakeTime = j10;
        } else {
            if (!isShakeDirectionOpposite(sensorEvent.values, this.mLastMatchedSensorValues)) {
                LogUtils.d(TAG, "摇晃不是相反方向，return");
                return;
            }
            this.mShakeCnt++;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null) {
            this.mLastMatchedSensorValues = Arrays.copyOf(fArr, fArr.length);
        }
        if (this.mShakeCnt >= this.shakeBean.getShakeCount()) {
            this.mShakeCnt = 0;
            this.mLastShakeTime = j10;
            onShake();
        }
    }

    private void onShake() {
        InteractiveCallback interactiveCallback;
        long currentTimeMillis = System.currentTimeMillis();
        if (getVisibility() != 0 || (interactiveCallback = this.mCallBack) == null || currentTimeMillis - this.mLastTimeShake <= 1000) {
            return;
        }
        this.mLastTimeShake = currentTimeMillis;
        interactiveCallback.onShake();
        this.isShake = true;
    }

    private void startAnimation() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 15.0f, -5.0f, 15.0f, -5.0f, 10.0f, -5.0f);
        this.mRotateAnimation = ofFloat;
        ofFloat.setDuration(1000L);
        this.mRotateAnimation.setStartDelay(ROTATE_ANIM_INTERVAL_TIME);
        this.mRotateAnimation.setRepeatCount(-1);
        this.mRotateAnimation.setRepeatMode(1);
        AnonymousClass2 anonymousClass2 = new ValueAnimator.AnimatorUpdateListener() { // from class: com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.ShakeView.2
            public AnonymousClass2() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ShakeView.this.mNowShakeDegree = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                ShakeView.this.postInvalidate();
            }
        };
        this.mRotateAnimListener = anonymousClass2;
        this.mRotateAnimation.addUpdateListener(anonymousClass2);
    }

    private void startShakeAnim() {
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.start();
        }
    }

    public void addSensorList(float f10, float f11, float f12) {
        try {
            if (this.sensorList == null) {
                this.sensorList = Collections.synchronizedList(new ArrayList());
            }
            if (this.sensorList.size() < 10) {
                this.sensorList.add(new UtSensor(f10, f11, f12));
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    @Override // com.alimm.tanx.core.ad.ad.template.rendering.splash.shake.IShakeView
    public void load(@NonNull InteractiveCallback interactiveCallback, boolean z10) {
        this.mCallBack = interactiveCallback;
        if (z10) {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 190.0f);
        } else {
            this.mShakeViewHeight = DimenUtil.dp2px(getContext(), 160.0f);
        }
        setMeasuredDimension(getMeasuredWidth(), this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i10) {
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        startShakeAnim();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        InteractiveCallback interactiveCallback = this.mCallBack;
        if (interactiveCallback != null) {
            List<UtSensor> list = this.sensorList;
            if (list != null) {
                interactiveCallback.destroy(JSON.toJSONString(list));
            } else {
                interactiveCallback.destroy("");
            }
        }
        LogUtils.d(TAG, "onDetachedFromWindow");
        recycle();
        LifeCycleManager.getInstance().unRegister(TAG);
        LogUtils.d(TAG, "onDetachedFromWindow");
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            Bitmap bitmap = this.mShakeBitMap;
            if (bitmap != null && !bitmap.isRecycled()) {
                canvas.save();
                canvas.translate(this.mShakeImgRect.centerX(), this.mShakeImgRect.centerY());
                canvas.rotate(this.mNowShakeDegree);
                canvas.drawBitmap(this.mShakeBitMap, (Rect) null, this.mRealShakeImgRect, this.mPaint);
                canvas.restore();
            }
            this.mTextPaint.setTextAlign(Paint.Align.CENTER);
            this.mTextPaint.setShadowLayer(3.0f, 2.0f, 2.0f, 1711276032);
            drawText(canvas, this.mTextPaint, this.mShowText1, this.mShowTextRect1, this.mShowTextSize1, this.mShowTextColor1, true);
        } catch (Exception e10) {
            LogUtils.e(TAG, e10);
        }
    }

    @Override // android.view.View
    public void onMeasure(int i10, int i11) {
        super.onMeasure(i10, i11);
        int measuredWidth = getMeasuredWidth();
        int dp2px = DimenUtil.dp2px(getContext(), 10.0f);
        Rect rect = this.mCircleImgRect;
        if (rect != null) {
            int i12 = measuredWidth / 2;
            int i13 = this.mCircleLength;
            rect.set(i12 - (i13 / 2), dp2px, i12 + (i13 / 2), i13 + dp2px);
        }
        int i14 = this.mCircleLength / 2;
        int[] iArr = this.mPhoneImgSize;
        int i15 = iArr[1];
        int i16 = dp2px + (i14 - (i15 / 2));
        Rect rect2 = this.mShakeImgRect;
        if (rect2 != null) {
            int i17 = measuredWidth / 2;
            int i18 = iArr[0];
            rect2.set(i17 - (i18 / 2), i16, i17 + (i18 / 2), i15 + i16);
        }
        Rect rect3 = this.mRealShakeImgRect;
        if (rect3 != null) {
            int[] iArr2 = this.mPhoneImgSize;
            int i19 = iArr2[0];
            int i20 = iArr2[1];
            rect3.set((-i19) / 2, (-i20) / 2, i19 / 2, i20 / 2);
        }
        int dp2px2 = DimenUtil.dp2px(getContext(), 10.0f) + this.mCircleLength + this.mImagePadding;
        this.mShowTextRect1.set(getPaddingLeft(), dp2px2, measuredWidth - getPaddingRight(), ((int) this.mShowTextHeight1) + dp2px2);
        setMeasuredDimension(i10, this.mShakeViewHeight);
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor = sensorEvent.sensor;
        if (this.mNowVisibility == 0 && sensor.getType() == 1) {
            float[] fArr = sensorEvent.values;
            addSensorList(fArr[0], fArr[1], fArr[2]);
            if (((float) Math.sqrt((r2 * r2) + (r1 * r1) + (r0 * r0))) >= this.shakeBean.getShakeSplash()) {
                onShake();
            }
        }
        Sensor sensor2 = this.mSenAccelerometer;
        if (sensor2 == null || sensor2.getType() != 10) {
            return;
        }
        onLinerAccSenorChanged(sensorEvent);
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i10) {
        super.onVisibilityChanged(view, i10);
        this.mNowVisibility = i10;
    }

    public void pauseShake() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.pause();
        }
    }

    public void recycle() {
        SensorManager sensorManager = this.mSenSensorManager;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
            this.mSenSensorManager = null;
        }
        ValueAnimator valueAnimator = this.mRotateAnimation;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            ValueAnimator.AnimatorUpdateListener animatorUpdateListener = this.mRotateAnimListener;
            if (animatorUpdateListener != null) {
                this.mRotateAnimation.removeUpdateListener(animatorUpdateListener);
            }
            this.mRotateAnimation = null;
        }
        Bitmap bitmap = this.mShakeBitMap;
        if (bitmap != null) {
            bitmap.recycle();
            this.mShakeBitMap = null;
        }
    }

    public void setImagePadding(int i10) {
        if (getContext() != null) {
            this.mImagePadding = DimenUtil.dp2px(getContext(), i10);
        }
    }

    public void setMessageTextSize(float f10) {
        if (getContext() == null || f10 <= 0.0f) {
            return;
        }
        this.mShowTextSize2 = DimenUtil.dp2px(getContext(), f10);
    }

    public void setTextPadding(int i10) {
        if (getContext() != null) {
            this.mTextPadding = DimenUtil.dp2px(getContext(), i10);
        }
    }

    public void setTitleTextSize(float f10) {
        this.mShowTextSize1 = f10;
    }

    public void startShake(Context context) {
        try {
            if (this.mSenSensorManager == null) {
                this.mSenSensorManager = (SensorManager) context.getSystemService(bt.f23586ac);
            }
            Sensor defaultSensor = this.mSenSensorManager.getDefaultSensor(10);
            this.mSenAccelerometer = defaultSensor;
            this.mSenSensorManager.registerListener(this, defaultSensor, 2);
            ValueAnimator valueAnimator = this.mRotateAnimation;
            if (valueAnimator != null) {
                valueAnimator.resume();
            }
        } catch (Exception e10) {
            LogUtils.e(e10);
        }
    }

    public ShakeView(@NonNull Context context, String str, ShakeBean shakeBean) {
        super(context);
        this.isShake = false;
        this.mLastTimeShake = 0L;
        this.mSenAccelerometer = null;
        this.GESTURE_INTERACTION_START = -1;
        this.GESTURE_INTERACTION_END_CLICK = 0;
        this.GESTURE_INTERACTION_END_SUCCESS = 1;
        this.GESTURE_INTERACTION_END_FAIL = 2;
        this.MIN_SHAKE_THRESHOLD = 1;
        this.MAX_SHAKE_THRESHOLD = 50;
        this.sensorList = Collections.synchronizedList(new ArrayList());
        this.count = 0;
        this.mShowText1 = str;
        init(context, shakeBean);
    }
}
