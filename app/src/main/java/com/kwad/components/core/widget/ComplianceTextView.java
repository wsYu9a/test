package com.kwad.components.core.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.StaticLayout;
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
import com.kwad.sdk.utils.ai;
import com.tencent.bugly.beta.tinker.TinkerReport;

@SuppressLint({"AppCompatCustomView"})
/* loaded from: classes2.dex */
public class ComplianceTextView extends TextView {
    private String VV;
    private String VW;
    private String VX;
    private String VY;
    private String VZ;
    private int Wa;
    private String Wb;

    @ColorInt
    private int Wc;
    private boolean Wd;
    private AdTemplate mAdTemplate;

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$1 */
    final class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public final void run() {
            ComplianceTextView complianceTextView = ComplianceTextView.this;
            complianceTextView.a(complianceTextView.VV, ComplianceTextView.this.VW, ComplianceTextView.this.VX);
        }
    }

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$2 */
    final class AnonymousClass2 extends ClickableSpan {
        final /* synthetic */ String Wf;

        AnonymousClass2(String str) {
            str = str;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(@NonNull View view) {
            AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(str).av(ComplianceTextView.this.VY).aA(true).L(ComplianceTextView.this.mAdTemplate).oc());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ComplianceTextView.this.Wc);
            textPaint.setUnderlineText(ComplianceTextView.this.Wd);
        }
    }

    /* renamed from: com.kwad.components.core.widget.ComplianceTextView$3 */
    final class AnonymousClass3 extends ClickableSpan {
        final /* synthetic */ String Wg;

        AnonymousClass3(String str) {
            str2 = str;
        }

        @Override // android.text.style.ClickableSpan
        public final void onClick(@NonNull View view) {
            AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(str2).av(ComplianceTextView.this.VZ).aA(true).L(ComplianceTextView.this.mAdTemplate).oc());
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public final void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(ComplianceTextView.this.Wc);
            textPaint.setUnderlineText(ComplianceTextView.this.Wd);
        }
    }

    public ComplianceTextView(Context context) {
        this(context, null);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ComplianceTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.Wa = TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND;
        init(context, attributeSet);
    }

    public void a(String str, String str2, String str3) {
        StringBuilder sb;
        String str4;
        if (TextUtils.isEmpty(str)) {
            setVisibility(8);
            return;
        }
        StringBuilder sb2 = new StringBuilder();
        if (!TextUtils.isEmpty(this.VY) || !TextUtils.isEmpty(this.VZ)) {
            sb2.append("  ");
        }
        if (!TextUtils.isEmpty(this.VY)) {
            sb2.append(str2);
        }
        if (!TextUtils.isEmpty(this.VY) && !TextUtils.isEmpty(this.VZ)) {
            sb2.append(" | ");
        }
        if (!TextUtils.isEmpty(this.VZ)) {
            sb2.append(str3);
        }
        getContext();
        int width = ((!ai.DL() ? this.Wa : getWidth()) - getPaddingLeft()) - getPaddingRight();
        if (width < 0) {
            return;
        }
        if (a(str, sb2.toString(), width)) {
            sb = new StringBuilder();
            sb.append(str);
            str4 = "\n";
        } else {
            sb = new StringBuilder();
            sb.append(str);
            str4 = "   ";
        }
        sb.append(str4);
        this.Wb = sb.toString();
        l(str2, str3);
        requestLayout();
    }

    private boolean a(String str, String str2, int i2) {
        StaticLayout staticLayout;
        StaticLayout staticLayout2;
        String str3 = str + str2;
        if (Build.VERSION.SDK_INT >= 23) {
            staticLayout2 = StaticLayout.Builder.obtain(str, 0, str.length(), getPaint(), i2).build();
            staticLayout = StaticLayout.Builder.obtain(str3, 0, str3.length(), getPaint(), i2).build();
        } else {
            StaticLayout staticLayout3 = new StaticLayout(str, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout = new StaticLayout(str3, getPaint(), i2, Layout.Alignment.ALIGN_NORMAL, 0.0f, 0.0f, true);
            staticLayout2 = staticLayout3;
        }
        return staticLayout.getLineCount() > staticLayout2.getLineCount();
    }

    @SuppressLint({"CustomViewStyleable"})
    private void init(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ComplianceTextView);
        this.Wa = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.ksad_ComplianceTextView_ksad_width_in_landscape, TinkerReport.KEY_APPLIED_PACKAGE_CHECK_PATCH_TINKER_ID_NOT_FOUND);
        this.Wc = obtainStyledAttributes.getColor(R.styleable.ksad_ComplianceTextView_ksad_privacy_color, getResources().getColor(R.color.ksad_default_privacy_link_color));
        this.Wd = obtainStyledAttributes.getBoolean(R.styleable.ksad_ComplianceTextView_ksad_show_clickable_underline, true);
        if (getBackground() == null) {
            setBackground(ContextCompat.getDrawable(context, R.drawable.ksad_compliance_view_bg));
        }
        obtainStyledAttributes.recycle();
    }

    private void l(String str, String str2) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) this.Wb);
        if (!TextUtils.isEmpty(this.VY)) {
            int length = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.2
                final /* synthetic */ String Wf;

                AnonymousClass2(String str3) {
                    str = str3;
                }

                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(str).av(ComplianceTextView.this.VY).aA(true).L(ComplianceTextView.this.mAdTemplate).oc());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.Wc);
                    textPaint.setUnderlineText(ComplianceTextView.this.Wd);
                }
            }, length, spannableStringBuilder.length(), 33);
        }
        if (!TextUtils.isEmpty(this.VY) && !TextUtils.isEmpty(this.VZ)) {
            spannableStringBuilder.append((CharSequence) " | ");
        }
        if (!TextUtils.isEmpty(this.VZ)) {
            int length2 = spannableStringBuilder.length();
            spannableStringBuilder.append((CharSequence) str2);
            spannableStringBuilder.setSpan(new ClickableSpan() { // from class: com.kwad.components.core.widget.ComplianceTextView.3
                final /* synthetic */ String Wg;

                AnonymousClass3(String str22) {
                    str2 = str22;
                }

                @Override // android.text.style.ClickableSpan
                public final void onClick(@NonNull View view) {
                    AdWebViewActivityProxy.launch(ComplianceTextView.this.getContext(), new AdWebViewActivityProxy.a.C0182a().au(str2).av(ComplianceTextView.this.VZ).aA(true).L(ComplianceTextView.this.mAdTemplate).oc());
                }

                @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                public final void updateDrawState(@NonNull TextPaint textPaint) {
                    super.updateDrawState(textPaint);
                    textPaint.setColor(ComplianceTextView.this.Wc);
                    textPaint.setUnderlineText(ComplianceTextView.this.Wd);
                }
            }, length2, spannableStringBuilder.length(), 33);
        }
        spannableStringBuilder.append((CharSequence) " ");
        setMovementMethod(LinkMovementMethod.getInstance());
        setHighlightColor(ContextCompat.getColor(getContext(), R.color.ksad_translucent));
        setText(spannableStringBuilder);
    }

    public void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        AdInfo cb = com.kwad.sdk.core.response.a.d.cb(adTemplate);
        StringBuilder sb = new StringBuilder();
        if (!TextUtils.isEmpty(cb.downloadSafeInfo.appName)) {
            sb.append("应用名：");
            sb.append(cb.downloadSafeInfo.appName);
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(cb.downloadSafeInfo.appVersion)) {
            sb.append("版本号：");
            sb.append(cb.downloadSafeInfo.appVersion);
            sb.append(" ");
        }
        if (cb.downloadSafeInfo.packageSize > 0) {
            sb.append("应用大小：");
            sb.append(com.kwad.components.core.r.e.a(cb.downloadSafeInfo.packageSize, true));
            sb.append(" ");
        }
        if (!TextUtils.isEmpty(cb.downloadSafeInfo.corporationName)) {
            sb.append("开发者：");
            sb.append(cb.downloadSafeInfo.corporationName);
            sb.append(" ");
        }
        this.VV = sb.toString();
        this.VW = "权限信息";
        this.VX = "隐私政策";
        AdInfo.DownloadSafeInfo downloadSafeInfo = cb.downloadSafeInfo;
        this.VY = downloadSafeInfo.appPermissionInfoUrl;
        this.VZ = downloadSafeInfo.appPrivacyUrl;
        if (this.Wa > 0) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            getContext();
            layoutParams.width = !ai.DL() ? com.kwad.sdk.c.kwai.a.a(getContext(), this.Wa) : -1;
            setLayoutParams(layoutParams);
        }
        post(new Runnable() { // from class: com.kwad.components.core.widget.ComplianceTextView.1
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public final void run() {
                ComplianceTextView complianceTextView = ComplianceTextView.this;
                complianceTextView.a(complianceTextView.VV, ComplianceTextView.this.VW, ComplianceTextView.this.VX);
            }
        });
    }
}
