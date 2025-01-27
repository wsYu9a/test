package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.kwad.components.core.page.AdWebViewActivityProxy;
import com.kwad.sdk.R;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.utils.an;
import com.kwad.sdk.utils.bd;
import com.tencent.bugly.beta.tinker.TinkerReport;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes3.dex */
public class ComplianceTextView extends TextView {
    private String aeA;
    private int aeB;
    private String aeu;
    private String aev;
    private String aew;
    private String aex;
    private String aey;
    private String aez;
    private AdTemplate mAdTemplate;

    @ColorInt
    private int textColor;

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$1 */
    public class AnonymousClass1 extends bd {
        final /* synthetic */ AdInfo tK;

        public AnonymousClass1(AdInfo adInfo) {
            eb2 = adInfo;
        }

        @Override // com.kwad.sdk.utils.bd
        public final void doTask() {
            ComplianceTextView complianceTextView = ComplianceTextView.this;
            AdInfo.DownloadSafeInfo downloadSafeInfo = eb2.downloadSafeInfo;
            complianceTextView.a(downloadSafeInfo.appName, TextUtils.isEmpty(downloadSafeInfo.corporationName) ? "" : eb2.downloadSafeInfo.corporationName, TextUtils.isEmpty(eb2.downloadSafeInfo.recordNumber) ? "" : eb2.downloadSafeInfo.recordNumber, eb2.downloadSafeInfo.appVersion, ComplianceTextView.this.aev, ComplianceTextView.this.aew, ComplianceTextView.this.aex);
        }
    }

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$2 */
    public class AnonymousClass2 extends ClickableSpan {
        public AnonymousClass2() {
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(@NonNull View view) {
            AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("功能介绍").av(ComplianceTextView.this.aez).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ComplianceTextView.this.textColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$3 */
    public class AnonymousClass3 extends ClickableSpan {
        public AnonymousClass3() {
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(@NonNull View view) {
            AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("权限信息").av(ComplianceTextView.this.aey).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ComplianceTextView.this.textColor);
            textPaint.setUnderlineText(false);
        }
    }

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$4 */
    public class AnonymousClass4 extends ClickableSpan {
        public AnonymousClass4() {
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(@NonNull View view) {
            AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("隐私政策").av(ComplianceTextView.this.aeA).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ComplianceTextView.this.textColor);
            textPaint.setUnderlineText(false);
        }
    }

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.aeB = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND);
        int color = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, Color.parseColor("#99FFFFFF"));
        this.textColor = color;
        setTextColor(color);
        if (an.isOrientationPortrait()) {
            setBackgroundColor(0);
        } else {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo eb2 = com.kwad.sdk.core.response.b.e.eb(adTemplate);
        this.aev = "功能";
        this.aew = "权限";
        this.aex = "隐私";
        AdInfo.DownloadSafeInfo downloadSafeInfo = eb2.downloadSafeInfo;
        this.aey = downloadSafeInfo.appPermissionInfoUrl;
        this.aeA = downloadSafeInfo.appPrivacyUrl;
        this.aez = downloadSafeInfo.introductionInfoUrl;
        if (this.aeB > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            if (an.NS()) {
                layoutParams.width = -1;
            } else {
                layoutParams.width = com.kwad.sdk.c.a.a.a(getContext(), this.aeB);
            }
            setLayoutParams(layoutParams);
        }
        post(new bd() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            final /* synthetic */ AdInfo tK;

            public AnonymousClass1(AdInfo eb22) {
                eb2 = eb22;
            }

            @Override // com.kwad.sdk.utils.bd
            public final void doTask() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                AdInfo.DownloadSafeInfo downloadSafeInfo2 = eb2.downloadSafeInfo;
                complianceTextView.a(downloadSafeInfo2.appName, TextUtils.isEmpty(downloadSafeInfo2.corporationName) ? "" : eb2.downloadSafeInfo.corporationName, TextUtils.isEmpty(eb2.downloadSafeInfo.recordNumber) ? "" : eb2.downloadSafeInfo.recordNumber, eb2.downloadSafeInfo.appVersion, ComplianceTextView.this.aev, ComplianceTextView.this.aew, ComplianceTextView.this.aex);
            }
        });
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (!TextUtils.isEmpty(str)) {
            spannableStringBuilder.append((CharSequence) str);
        }
        if (!TextUtils.isEmpty(str2)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str2);
        }
        if (!TextUtils.isEmpty(str3)) {
            spannableStringBuilder.append((CharSequence) " ").append((CharSequence) str3);
        }
        if (!TextUtils.isEmpty(str4)) {
            spannableStringBuilder.append((CharSequence) " | 版本 ").append((CharSequence) str4);
        }
        if (!TextUtils.isEmpty(this.aez)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str5);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                public AnonymousClass2() {
                }

                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("功能介绍").av(ComplianceTextView.this.aez).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.aey)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str6);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                public AnonymousClass3() {
                }

                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("权限信息").av(ComplianceTextView.this.aey).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.aeA)) {
            int length3 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) " | ").append((CharSequence) str7);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.4
                public AnonymousClass4() {
                }

                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0438a().au("隐私政策").av(ComplianceTextView.this.aeA).aD(true).aw(ComplianceTextView.this.mAdTemplate).qa());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.textColor);
                    textPaint.setUnderlineText(false);
                }
            }, length3, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        this.aeu = "...\n";
        this.aeB = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
        init(context, attributeSet);
    }

    public void a(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        int width;
        boolean z10;
        String str8;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        getContext();
        if (!an.NS()) {
            width = (this.aeB - getPaddingLeft()) - getPaddingRight();
            z10 = true;
        } else {
            width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            z10 = false;
        }
        if (width < 0) {
            return;
        }
        if (!z10 && !TextUtils.isEmpty(str2)) {
            Paint paint = new Paint();
            paint.setTextSize(getTextSize());
            float measureText = width - paint.measureText(str);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" ");
            str8 = str2;
            sb2.append(str2);
            if (paint.measureText(sb2.toString()) > measureText && measureText > 0.0f) {
                while (str8.length() > 1) {
                    str8 = str8.substring(0, str8.length() - 1);
                    sb2.setLength(0);
                    sb2.append(" ");
                    sb2.append(str8);
                    sb2.append(this.aeu);
                    if (paint.measureText(sb2.toString()) <= measureText) {
                        break;
                    }
                }
            } else {
                this.aeu = "";
            }
        } else {
            str8 = str2;
            this.aeu = "";
        }
        b(str, str8 + this.aeu, str3, str4, str5, str6, str7);
        requestLayout();
    }
}
