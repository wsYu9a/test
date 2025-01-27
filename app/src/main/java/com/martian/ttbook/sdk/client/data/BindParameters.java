package com.martian.ttbook.sdk.client.data;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import java.util.List;

/* loaded from: classes4.dex */
public class BindParameters {
    private ViewGroup.LayoutParams adViewLayoutParams;
    private FrameLayout.LayoutParams adlogoLayoutParams;
    private List<View> clickableViews;
    private View closeView;
    private View view;

    public static final class Builder {
        private ViewGroup.LayoutParams adViewLayoutParams;
        private FrameLayout.LayoutParams adlogoLayoutParams;
        private List<View> clickableViews;
        private View closeView;
        private View view;

        private Builder() {
        }

        public Builder(View view) {
            setView(view);
        }

        public BindParameters build() {
            BindParameters bindParameters = new BindParameters();
            bindParameters.adViewLayoutParams = this.adViewLayoutParams;
            bindParameters.view = this.view;
            bindParameters.adlogoLayoutParams = this.adlogoLayoutParams;
            bindParameters.clickableViews = this.clickableViews;
            bindParameters.closeView = this.closeView;
            return bindParameters;
        }

        public Builder setAdViewLayoutParams(ViewGroup.LayoutParams layoutParams) {
            this.adViewLayoutParams = layoutParams;
            return this;
        }

        public Builder setAdlogoLayoutParams(FrameLayout.LayoutParams layoutParams) {
            this.adlogoLayoutParams = layoutParams;
            return this;
        }

        public Builder setClickableViews(List<View> list) {
            this.clickableViews = list;
            return this;
        }

        public Builder setCloseView(View view) {
            this.closeView = view;
            return this;
        }

        Builder setView(View view) {
            this.view = view;
            return this;
        }
    }

    public ViewGroup.LayoutParams getAdViewLayoutParams() {
        return this.adViewLayoutParams;
    }

    public FrameLayout.LayoutParams getAdlogoLayoutParams() {
        return this.adlogoLayoutParams;
    }

    public List<View> getClickableViews() {
        return this.clickableViews;
    }

    public View getCloseView() {
        return this.closeView;
    }

    public View getView() {
        return this.view;
    }
}
