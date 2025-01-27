package com.alimm.tanx.core.utils;

import android.widget.TextView;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class CountDownComponent implements NotConfused {
    private static final int DEFAULT_COUNT_DOWN_INTERVAL = 300;
    private static final String TAG = "CountDownComponent";
    private final int mAdDuration;
    private final TanxCountDownTimer mCountDownTimer;
    private int mCurrentCount;
    private boolean mIsTimerStarted = false;
    private OnFinishListener mOnFinishListener;
    private final TextView mTvCountDown;

    /* renamed from: com.alimm.tanx.core.utils.CountDownComponent$1 */
    public class AnonymousClass1 extends TanxCountDownTimer {
        public AnonymousClass1(long j10, long j11) {
            super(j10, j11);
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onFinish() {
            LogUtils.d(CountDownComponent.TAG, "onFinish.");
            if (CountDownComponent.this.mOnFinishListener != null) {
                CountDownComponent.this.mOnFinishListener.onFinish();
            }
        }

        @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
        public void onTick(long j10) {
            CountDownComponent.this.mCurrentCount = Math.round(j10 / 1000.0f);
            LogUtils.d(CountDownComponent.TAG, "onTick: millisUntilFinished = " + j10 + " mCurrentCount :" + CountDownComponent.this.mCurrentCount);
            if (CountDownComponent.this.mCurrentCount < 1) {
                CountDownComponent.this.mCurrentCount = 1;
            }
            CountDownComponent countDownComponent = CountDownComponent.this;
            countDownComponent.updateCountDown(countDownComponent.mCurrentCount);
        }
    }

    public interface OnFinishListener {
        void onFinish();
    }

    public CountDownComponent(@NonNull TextView textView, int i10, OnFinishListener onFinishListener) {
        this.mTvCountDown = textView;
        this.mAdDuration = i10;
        this.mOnFinishListener = onFinishListener;
        this.mCountDownTimer = new TanxCountDownTimer((i10 * 1000) + 300, 300L) { // from class: com.alimm.tanx.core.utils.CountDownComponent.1
            public AnonymousClass1(long j10, long j11) {
                super(j10, j11);
            }

            @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
            public void onFinish() {
                LogUtils.d(CountDownComponent.TAG, "onFinish.");
                if (CountDownComponent.this.mOnFinishListener != null) {
                    CountDownComponent.this.mOnFinishListener.onFinish();
                }
            }

            @Override // com.alimm.tanx.core.utils.TanxCountDownTimer
            public void onTick(long j10) {
                CountDownComponent.this.mCurrentCount = Math.round(j10 / 1000.0f);
                LogUtils.d(CountDownComponent.TAG, "onTick: millisUntilFinished = " + j10 + " mCurrentCount :" + CountDownComponent.this.mCurrentCount);
                if (CountDownComponent.this.mCurrentCount < 1) {
                    CountDownComponent.this.mCurrentCount = 1;
                }
                CountDownComponent countDownComponent = CountDownComponent.this;
                countDownComponent.updateCountDown(countDownComponent.mCurrentCount);
            }
        };
    }

    public void pauseCountDown() {
        TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.pause();
        }
    }

    public void resumeCountDown() {
        TanxCountDownTimer tanxCountDownTimer = this.mCountDownTimer;
        if (tanxCountDownTimer != null) {
            tanxCountDownTimer.resume();
        }
    }

    public void startCountDown() {
        LogUtils.d(TAG, "startCountDown: mCurrentCount = " + this.mCurrentCount + ", mIsTimerStarted = " + this.mIsTimerStarted + ", mCountDownTimer = " + this.mCountDownTimer);
        if (this.mIsTimerStarted || this.mCountDownTimer == null) {
            return;
        }
        this.mTvCountDown.setText(String.valueOf(this.mAdDuration));
        this.mCountDownTimer.start();
        this.mIsTimerStarted = true;
    }

    public void stopAndHideCountDown() {
        stopCountDown();
        this.mTvCountDown.setVisibility(8);
    }

    public void stopCountDown() {
        TanxCountDownTimer tanxCountDownTimer;
        if (this.mIsTimerStarted && (tanxCountDownTimer = this.mCountDownTimer) != null) {
            tanxCountDownTimer.cancel();
            this.mIsTimerStarted = false;
        }
        this.mOnFinishListener = null;
    }

    public void updateCountDown(int i10) {
        TextView textView = this.mTvCountDown;
        if (textView == null || i10 <= 0) {
            return;
        }
        textView.setText(String.valueOf(i10));
    }
}
