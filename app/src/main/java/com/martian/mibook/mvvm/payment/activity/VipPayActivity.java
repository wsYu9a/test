package com.martian.mibook.mvvm.payment.activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.martian.libmars.R;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.activity.base.MiWebViewActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.databinding.ActivityVipPayBinding;
import com.martian.mibook.lib.account.activity.PopupLoginActivity;
import com.martian.mibook.lib.account.response.MiUser;
import com.martian.mibook.mvvm.base.BaseMVVMActivity;
import com.martian.mibook.mvvm.extensions.ExtKt;
import com.martian.mibook.mvvm.payment.activity.VipPayActivity;
import com.martian.mibook.mvvm.payment.adapter.VipBenefitGridAdapter;
import com.martian.mibook.mvvm.payment.adapter.VipPaymentMethodAdapter;
import com.martian.mibook.mvvm.payment.adapter.VipProductAdapter;
import com.martian.mibook.mvvm.payment.data.VipProduct;
import com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel;
import com.martian.mibook.mvvm.tts.NonStickyLiveData;
import com.martian.mibook.mvvm.ui.viewmodel.AppViewModel;
import com.martian.rpauth.response.MartianRPAccount;
import i8.g;
import je.i;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import l9.m0;
import l9.t0;
import xi.k;
import xi.l;

@Route(path = kc.a.f27762r)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0007\u0010\u0005J\u001b\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0019\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0005J\u000f\u0010\u0010\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0010\u0010\u0005J\u0017\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0011H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0015\u0010\u0005J\u000f\u0010\u0016\u001a\u00020\u0006H\u0003¢\u0006\u0004\b\u0016\u0010\u0005J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0019\u0010\u001a\u001a\u00020\u00062\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0017¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u001c\u0010\u0005J\u000f\u0010\u001d\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u0005R\u0018\u0010!\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001f\u0010 R\u0018\u0010%\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010-\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/martian/mibook/mvvm/payment/activity/VipPayActivity;", "Lcom/martian/mibook/mvvm/base/BaseMVVMActivity;", "Lcom/martian/mibook/databinding/ActivityVipPayBinding;", "Lcom/martian/mibook/mvvm/payment/viewmodel/VipPayViewModel;", "<init>", "()V", "", "k2", "", "show", "D2", "(Ljava/lang/Boolean;)V", "withCallback", "h2", "(Z)V", "H2", "G2", "Lcom/martian/mibook/mvvm/payment/data/VipProduct;", "vipProduct", "F2", "(Lcom/martian/mibook/mvvm/payment/data/VipProduct;)V", "I2", "A2", "j2", "Landroid/os/Bundle;", "savedInstanceState", "c1", "(Landroid/os/Bundle;)V", "onResume", "q1", "Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;", "h", "Lcom/martian/mibook/mvvm/payment/adapter/VipProductAdapter;", "productAdapter", "Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;", "i", "Lcom/martian/mibook/mvvm/payment/adapter/VipBenefitGridAdapter;", "benefitGridAdapter", "Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;", "j", "Lcom/martian/mibook/mvvm/payment/adapter/VipPaymentMethodAdapter;", "paymentMethodAdapter", "Landroid/app/AlertDialog;", "k", "Landroid/app/AlertDialog;", "payStatusDialog", "mibook_VivoRelease"}, k = 1, mv = {1, 9, 0})
/* loaded from: classes3.dex */
public final class VipPayActivity extends BaseMVVMActivity<ActivityVipPayBinding, VipPayViewModel> {

    /* renamed from: h, reason: from kotlin metadata */
    @l
    public VipProductAdapter productAdapter;

    /* renamed from: i, reason: from kotlin metadata */
    @l
    public VipBenefitGridAdapter benefitGridAdapter;

    /* renamed from: j, reason: from kotlin metadata */
    @l
    public VipPaymentMethodAdapter paymentMethodAdapter;

    /* renamed from: k, reason: from kotlin metadata */
    @l
    public AlertDialog payStatusDialog;

    public static final class a extends ClickableSpan {
        public a() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            VipPayActivity.this.m1().h0(VipPayActivity.this, "问题反馈");
            i.Y(VipPayActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class b extends ClickableSpan {
        public b() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            VipPayActivity.this.m1().h0(VipPayActivity.this, "微信客服");
            String wechatCustomerUrl = MiConfigSingleton.b2().c2().getWechatCustomerUrl();
            Intrinsics.checkNotNull(wechatCustomerUrl);
            if (StringsKt.contains$default((CharSequence) wechatCustomerUrl, (CharSequence) "{{UID}}", false, 2, (Object) null)) {
                Intrinsics.checkNotNull(wechatCustomerUrl);
                String t22 = MiConfigSingleton.b2().t2();
                Intrinsics.checkNotNullExpressionValue(t22, "getUserId(...)");
                wechatCustomerUrl = StringsKt.replace$default(wechatCustomerUrl, "{{UID}}", t22, false, 4, (Object) null);
            }
            MiWebViewActivity.J5(VipPayActivity.this, wechatCustomerUrl, false, "", false, "", false, true);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class c extends ClickableSpan {
        public c() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.s(VipPayActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
            ds.setColor(ContextCompat.getColor(VipPayActivity.this, R.color.day_text_color_primary));
        }
    }

    public static final class d extends ClickableSpan {
        public d() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.r(VipPayActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
            ds.setColor(ContextCompat.getColor(VipPayActivity.this, R.color.day_text_color_primary));
        }
    }

    public static final class e extends ClickableSpan {
        public e() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.s(VipPayActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final class f extends ClickableSpan {
        public f() {
        }

        @Override // android.text.style.ClickableSpan
        public void onClick(@k View widget) {
            Intrinsics.checkNotNullParameter(widget, "widget");
            lb.c.r(VipPayActivity.this);
        }

        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
        public void updateDrawState(@k TextPaint ds) {
            Intrinsics.checkNotNullParameter(ds, "ds");
            ds.setUnderlineText(true);
        }
    }

    public static final void B2(AlertDialog alertDialog, View view) {
        alertDialog.dismiss();
    }

    public static final void C2(VipPayActivity this$0, AlertDialog alertDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1().s0(true);
        this$0.H2();
        this$0.j2();
        alertDialog.dismiss();
    }

    public static /* synthetic */ void E2(VipPayActivity vipPayActivity, Boolean bool, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            bool = Boolean.TRUE;
        }
        vipPayActivity.D2(bool);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ ActivityVipPayBinding X1(VipPayActivity vipPayActivity) {
        return (ActivityVipPayBinding) vipPayActivity.a1();
    }

    public static /* synthetic */ void i2(VipPayActivity vipPayActivity, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        vipPayActivity.h2(z10);
    }

    public static final void l2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1().Z();
    }

    public static final void m2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (this$0.m1().getVipRuleAgreed()) {
            this$0.j2();
        } else {
            this$0.A2();
        }
    }

    public static final void n2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1().h0(this$0, "关联账号");
        PopupLoginActivity.q1(this$0, this$0.m1().getVipRuleAgreed() ? 200 : 1024, !MiConfigSingleton.b2().C2());
    }

    public static final void o2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        i2(this$0, false, 1, null);
    }

    public static final void p2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.m1().s0(!this$0.m1().getVipRuleAgreed());
        this$0.H2();
    }

    public static final void q2(VipPayActivity this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.finish();
    }

    public static final void r2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void s2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void t2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void u2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void v2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void w2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void x2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void y2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    public static final void z2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: yc.n.<init>(android.app.AlertDialog):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:290)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:193)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(Unknown Source)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @android.annotation.SuppressLint({"InflateParams", "SetTextI18n"})
    public final void A2() {
        /*
            r8 = this;
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r8)
            int r1 = com.martian.mibook.R.layout.vip_popupwindow_agreement
            r2 = 0
            android.view.View r0 = r0.inflate(r1, r2)
            java.lang.String r1 = "inflate(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r1 = 0
            android.app.AlertDialog r2 = l9.i0.G(r8, r0, r1)
            com.martian.mibook.databinding.VipPopupwindowAgreementBinding r0 = com.martian.mibook.databinding.VipPopupwindowAgreementBinding.bind(r0)
            java.lang.String r3 = "bind(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            android.widget.TextView r3 = r0.privacyDesc
            r4 = 0
            r5 = 1067030938(0x3f99999a, float:1.2)
            r3.setLineSpacing(r4, r5)
            android.widget.TextView r3 = r0.privacyDesc
            com.martian.mibook.mvvm.base.BaseViewModel r4 = r8.m1()
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel r4 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel) r4
            boolean r4 = r4.getIsVip()
            if (r4 == 0) goto L3c
            java.lang.String r4 = "如需续费，请先同意 "
        L37:
            java.lang.String r4 = com.martian.mibook.mvvm.extensions.ExtKt.c(r4)
            goto L3f
        L3c:
            java.lang.String r4 = "如需开通，请先同意 "
            goto L37
        L3f:
            r3.setText(r4)
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.String r4 = "会员服务协议"
            java.lang.String r4 = com.martian.mibook.mvvm.extensions.ExtKt.c(r4)
            r3.<init>(r4)
            com.martian.mibook.mvvm.payment.activity.VipPayActivity$d r4 = new com.martian.mibook.mvvm.payment.activity.VipPayActivity$d
            r4.<init>()
            r5 = 6
            r6 = 17
            r3.setSpan(r4, r1, r5, r6)
            android.widget.TextView r4 = r0.privacyDesc
            android.text.method.MovementMethod r7 = android.text.method.LinkMovementMethod.getInstance()
            r4.setMovementMethod(r7)
            android.widget.TextView r4 = r0.privacyDesc
            r4.append(r3)
            com.martian.mibook.mvvm.base.BaseViewModel r3 = r8.m1()
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel r3 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel) r3
            boolean r3 = r3.f0()
            if (r3 == 0) goto L91
            android.widget.TextView r3 = r0.privacyDesc
            java.lang.String r4 = " 和 "
            r3.append(r4)
            android.text.SpannableString r3 = new android.text.SpannableString
            java.lang.String r4 = "自动续费协议"
            java.lang.String r4 = com.martian.mibook.mvvm.extensions.ExtKt.c(r4)
            r3.<init>(r4)
            com.martian.mibook.mvvm.payment.activity.VipPayActivity$c r4 = new com.martian.mibook.mvvm.payment.activity.VipPayActivity$c
            r4.<init>()
            r3.setSpan(r4, r1, r5, r6)
            android.widget.TextView r1 = r0.privacyDesc
            r1.append(r3)
        L91:
            com.martian.libmars.ui.theme.ThemeTextView r1 = r0.privacyKnown
            java.lang.String r3 = "取消"
            java.lang.String r3 = com.martian.mibook.mvvm.extensions.ExtKt.c(r3)
            r1.setText(r3)
            com.martian.libmars.ui.theme.ThemeTextView r1 = r0.privacyKnown
            yc.n r3 = new yc.n
            r3.<init>()
            r1.setOnClickListener(r3)
            com.martian.libmars.ui.theme.ThemeTextView r1 = r0.privacyAgree
            com.martian.mibook.mvvm.base.BaseViewModel r3 = r8.m1()
            com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel r3 = (com.martian.mibook.mvvm.payment.viewmodel.VipPayViewModel) r3
            boolean r3 = r3.getIsVip()
            if (r3 == 0) goto Lbb
            java.lang.String r3 = "同意并续费"
        Lb6:
            java.lang.String r3 = com.martian.mibook.mvvm.extensions.ExtKt.c(r3)
            goto Lbe
        Lbb:
            java.lang.String r3 = "同意并开通"
            goto Lb6
        Lbe:
            r1.setText(r3)
            com.martian.libmars.ui.theme.ThemeTextView r0 = r0.privacyAgree
            yc.o r1 = new yc.o
            r1.<init>()
            r0.setOnClickListener(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.martian.mibook.mvvm.payment.activity.VipPayActivity.A2():void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D2(Boolean show) {
        if (Intrinsics.areEqual(show, Boolean.TRUE)) {
            ((ActivityVipPayBinding) a1()).vipOrderResult.setVisibility(0);
        } else {
            ((ActivityVipPayBinding) a1()).vipOrderResult.setVisibility(8);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void F2(VipProduct vipProduct) {
        m1().j0(vipProduct);
        if (MiConfigSingleton.b2().K2()) {
            ((ActivityVipPayBinding) a1()).vipOpenText.setText(m1().G(vipProduct) + ExtKt.c(" 立即续费"));
        } else {
            ((ActivityVipPayBinding) a1()).vipOpenText.setText(m1().G(vipProduct) + ExtKt.c(" 立即开通"));
        }
        G2();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n"})
    public final void G2() {
        ((ActivityVipPayBinding) a1()).vipPrivacyCheckText.setText("");
        SpannableString spannableString = new SpannableString(ExtKt.c("会员服务协议"));
        spannableString.setSpan(new f(), 0, 6, 17);
        ((ActivityVipPayBinding) a1()).vipPrivacyCheckText.setMovementMethod(LinkMovementMethod.getInstance());
        ((ActivityVipPayBinding) a1()).vipPrivacyCheckText.append(spannableString);
        if (m1().f0()) {
            ((ActivityVipPayBinding) a1()).vipPrivacyCheckText.append(" ");
            SpannableString spannableString2 = new SpannableString(ExtKt.c("自动续费协议"));
            spannableString2.setSpan(new e(), 0, 6, 17);
            ((ActivityVipPayBinding) a1()).vipPrivacyCheckText.append(spannableString2);
        }
        VipProduct currentVipProduct = m1().getCurrentVipProduct();
        if (currentVipProduct != null) {
            if (m1().f0() && !TextUtils.isEmpty(currentVipProduct.getPeriodTag())) {
                ((ActivityVipPayBinding) a1()).vipSubscribeDesc.setText(currentVipProduct.getPeriodTag());
                ((ActivityVipPayBinding) a1()).vipSubscribeDesc.append(ExtKt.c("，您可以随时在支付宝APP中进行解约"));
                return;
            }
            ((ActivityVipPayBinding) a1()).vipSubscribeDesc.setText(currentVipProduct.getSubject());
            if (m1().getIsChargeUser()) {
                ((ActivityVipPayBinding) a1()).vipSubscribeDesc.append(ExtKt.c("，畅享全站无广告免费阅读"));
            } else {
                ((ActivityVipPayBinding) a1()).vipSubscribeDesc.append(ExtKt.c("，畅享免广告阅读"));
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void H2() {
        ((ActivityVipPayBinding) a1()).vipPrivacyCheckIcon.setItemSelected(m1().getVipRuleAgreed());
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"SetTextI18n", "NotifyDataSetChanged"})
    public final void I2() {
        boolean K2 = MiConfigSingleton.b2().K2();
        if (K2 != m1().getIsVip()) {
            m1().q0(K2);
            ((ActivityVipPayBinding) a1()).vipBgView.setVip(K2);
            ((ActivityVipPayBinding) a1()).actionbarBack.setVip(K2);
            ((ActivityVipPayBinding) a1()).actionbarTitle.setVip(K2);
            ((ActivityVipPayBinding) a1()).accountVipTitle.setVip(K2);
            ((ActivityVipPayBinding) a1()).accountVipDesc.setVip(K2);
            ((ActivityVipPayBinding) a1()).vipOpenText.setVip(K2);
            ((ActivityVipPayBinding) a1()).vipOpenTextButton.setVip(K2);
            ((ActivityVipPayBinding) a1()).vipOpenTextProgressbar.setVip(K2);
            ((ActivityVipPayBinding) a1()).vipPrivacyCheckIcon.setVip(K2);
            VipBenefitGridAdapter vipBenefitGridAdapter = this.benefitGridAdapter;
            if (vipBenefitGridAdapter != null) {
                vipBenefitGridAdapter.notifyDataSetChanged();
            }
            VipProductAdapter vipProductAdapter = this.productAdapter;
            if (vipProductAdapter != null) {
                vipProductAdapter.notifyDataSetChanged();
            }
            q1();
        }
        if (MiConfigSingleton.b2().L2()) {
            long v22 = MiConfigSingleton.b2().v2();
            if (v22 > 0) {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(ExtKt.c("已过期：") + ba.f.i(v22, "yyyy-MM-dd HH:mm"));
            } else {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(getString(com.martian.mibook.R.string.vip_expired));
            }
            ((ActivityVipPayBinding) a1()).accountVipTag.setVisibility(8);
        } else if (m1().getIsVip()) {
            long v23 = MiConfigSingleton.b2().v2();
            if (v23 > 0) {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(ExtKt.c("会员至：") + ba.f.i(v23, "yyyy-MM-dd HH:mm"));
            } else {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(ExtKt.c("已开通"));
            }
            if (MiConfigSingleton.b2().N2()) {
                ((ActivityVipPayBinding) a1()).accountLinkAccountView.setVisibility(8);
            } else {
                ((ActivityVipPayBinding) a1()).accountLinkAccountView.setVisibility(0);
            }
            ((ActivityVipPayBinding) a1()).accountVipTag.setVisibility(0);
        } else {
            if (m1().getIsChargeUser()) {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(getString(com.martian.mibook.R.string.vip_activity_title_charge_user));
            } else {
                ((ActivityVipPayBinding) a1()).accountVipDesc.setText(getString(com.martian.mibook.R.string.vip_activity_title));
            }
            ((ActivityVipPayBinding) a1()).accountVipTag.setVisibility(8);
        }
        MiUser p10 = MiConfigSingleton.b2().G1().p();
        if (p10 != null) {
            ((ActivityVipPayBinding) a1()).accountVipTitle.setText(ExtKt.c(p10.getNickname()));
            m0.l(this, p10.getHeader(), ((ActivityVipPayBinding) a1()).vipHeader, com.martian.mibook.lib.account.R.drawable.day_img_heads);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.martian.mibook.mvvm.base.BaseActivity
    @SuppressLint({"NotifyDataSetChanged"})
    public void c1(@l Bundle savedInstanceState) {
        NonStickyLiveData<MartianRPAccount> Y;
        VipPayViewModel m12 = m1();
        Bundle extras = getIntent().getExtras();
        m12.n0(extras != null ? extras.getString("intent_source") : null);
        m1().h0(this, "曝光");
        ((ActivityVipPayBinding) a1()).vipComboLoadingTip.setWithIcon(false);
        ((ActivityVipPayBinding) a1()).vipComboLoadingTip.setBackgroundType(-1);
        y1(true, ((ActivityVipPayBinding) a1()).vipComboLoadingTip);
        k2();
        m1().O().observe(this, new Observer() { // from class: yc.p
            public /* synthetic */ p() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.r2(Function1.this, obj);
            }
        });
        m1().P().observe(this, new Observer() { // from class: yc.q
            public /* synthetic */ q() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.s2(Function1.this, obj);
            }
        });
        m1().I().observe(this, new Observer() { // from class: yc.b
            public /* synthetic */ b() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.t2(Function1.this, obj);
            }
        });
        m1().M().observe(this, new Observer() { // from class: yc.c
            public /* synthetic */ c() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.u2(Function1.this, obj);
            }
        });
        m1().N().observe(this, new Observer() { // from class: yc.d
            public /* synthetic */ d() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.v2(Function1.this, obj);
            }
        });
        m1().J().observe(this, new Observer() { // from class: yc.e
            public /* synthetic */ e() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.w2(Function1.this, obj);
            }
        });
        m1().K().observe(this, new Observer() { // from class: yc.f
            public /* synthetic */ f() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.x2(Function1.this, obj);
            }
        });
        m1().L().observe(this, new Observer() { // from class: yc.g
            public /* synthetic */ g() {
            }

            @Override // androidx.lifecycle.Observer
            public final void onChanged(Object obj) {
                VipPayActivity.y2(Function1.this, obj);
            }
        });
        AppViewModel l12 = l1();
        if (l12 != null && (Y = l12.Y()) != null) {
            Y.observe(this, new Observer() { // from class: yc.h
                public /* synthetic */ h() {
                }

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    VipPayActivity.z2(Function1.this, obj);
                }
            });
        }
        m1().Z();
        AppViewModel l13 = l1();
        if (l13 != null) {
            AppViewModel.m0(l13, false, 1, null);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void h2(boolean withCallback) {
        if (((ActivityVipPayBinding) a1()).vipOrderProgressbar.getVisibility() == 0) {
            t0.b(this, ExtKt.c("支付处理中,请稍候重试"));
        } else {
            ((ActivityVipPayBinding) a1()).vipOrderProgressbar.setVisibility(0);
            m1().x(withCallback);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void j2() {
        if (!MiConfigSingleton.b2().C2() || MiConfigSingleton.b2().G1().i(this)) {
            if (((ActivityVipPayBinding) a1()).vipOpenTextProgressbar.getVisibility() == 0) {
                t0.b(this, "订单创建中，请稍候");
            } else {
                ((ActivityVipPayBinding) a1()).vipOpenTextProgressbar.setVisibility(0);
                m1().A();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @SuppressLint({"NotifyDataSetChanged", "SetTextI18n"})
    public final void k2() {
        com.gyf.immersionbar.d.x2(this, ((ActivityVipPayBinding) a1()).toolbar);
        ((ActivityVipPayBinding) a1()).actionbarBack.setOnClickListener(new View.OnClickListener() { // from class: yc.a
            public /* synthetic */ a() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.q2(VipPayActivity.this, view);
            }
        });
        ((ActivityVipPayBinding) a1()).vipComboRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        ((ActivityVipPayBinding) a1()).vipBenefitRecyclerView.setLayoutManager(new GridLayoutManager(this, 5));
        this.benefitGridAdapter = new VipBenefitGridAdapter(m1(), new Function1<Integer, Unit>() { // from class: com.martian.mibook.mvvm.payment.activity.VipPayActivity$initialView$2
            public VipPayActivity$initialView$2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i10) {
                VipPayActivity vipPayActivity = VipPayActivity.this;
                od.k.p(vipPayActivity, vipPayActivity.m1().E(), i10);
            }
        });
        ((ActivityVipPayBinding) a1()).vipBenefitRecyclerView.setAdapter(this.benefitGridAdapter);
        ((ActivityVipPayBinding) a1()).vipPaymentMethodRecyclerView.setLayoutManager(new LinearLayoutManager(this, 0, false));
        this.paymentMethodAdapter = new VipPaymentMethodAdapter(m1(), new Function1<Integer, Unit>() { // from class: com.martian.mibook.mvvm.payment.activity.VipPayActivity$initialView$3
            public VipPayActivity$initialView$3() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i10) {
                VipProductAdapter vipProductAdapter;
                if (VipPayActivity.this.m1().getPaymentMethod() == i10) {
                    return;
                }
                VipPayActivity.this.m1().l0(i10);
                vipProductAdapter = VipPayActivity.this.productAdapter;
                if (vipProductAdapter != null) {
                    vipProductAdapter.p();
                }
                VipPayActivity.this.G2();
            }
        });
        ((ActivityVipPayBinding) a1()).vipPaymentMethodRecyclerView.setAdapter(this.paymentMethodAdapter);
        ((ActivityVipPayBinding) a1()).vipComboLoadingTip.setOnClickListener(new View.OnClickListener() { // from class: yc.i
            public /* synthetic */ i() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.l2(VipPayActivity.this, view);
            }
        });
        ((ActivityVipPayBinding) a1()).vipOpenTextButton.setOnClickListener(new View.OnClickListener() { // from class: yc.j
            public /* synthetic */ j() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.m2(VipPayActivity.this, view);
            }
        });
        ((ActivityVipPayBinding) a1()).accountLinkAccountView.setOnClickListener(new View.OnClickListener() { // from class: yc.k
            public /* synthetic */ k() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.n2(VipPayActivity.this, view);
            }
        });
        ((ActivityVipPayBinding) a1()).vipOrderRefresh.setOnClickListener(new View.OnClickListener() { // from class: yc.l
            public /* synthetic */ l() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.o2(VipPayActivity.this, view);
            }
        });
        ((ActivityVipPayBinding) a1()).vipPrivacyCheck.setOnClickListener(new View.OnClickListener() { // from class: yc.m
            public /* synthetic */ m() {
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                VipPayActivity.p2(VipPayActivity.this, view);
            }
        });
        H2();
        G2();
        ((ActivityVipPayBinding) a1()).vipContactCustomerService.setText(ExtKt.c("充值后会员未生效，请联系 "));
        ((ActivityVipPayBinding) a1()).vipContactCustomerService.setMovementMethod(LinkMovementMethod.getInstance());
        ((ActivityVipPayBinding) a1()).vipCustomerHint.setText(ExtKt.c("2.如有其他疑问，请通过 "));
        SpannableString spannableString = new SpannableString(ExtKt.c("问题反馈"));
        spannableString.setSpan(new a(), 0, 4, 17);
        ((ActivityVipPayBinding) a1()).vipCustomerHint.setMovementMethod(LinkMovementMethod.getInstance());
        ((ActivityVipPayBinding) a1()).vipCustomerHint.append(spannableString);
        if (TextUtils.isEmpty(MiConfigSingleton.b2().c2().getWechatCustomerUrl()) || !g.p(this)) {
            ((ActivityVipPayBinding) a1()).vipContactCustomerService.append(spannableString);
        } else {
            ((ActivityVipPayBinding) a1()).vipCustomerHint.append(" 或 ");
            SpannableString spannableString2 = new SpannableString(ExtKt.c("微信客服"));
            spannableString2.setSpan(new b(), 0, 4, 17);
            ((ActivityVipPayBinding) a1()).vipCustomerHint.append(spannableString2);
            ((ActivityVipPayBinding) a1()).vipContactCustomerService.append(spannableString2);
        }
        ((ActivityVipPayBinding) a1()).vipCustomerHint.append(ExtKt.c(" 获得支持"));
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        I2();
    }

    @Override // com.martian.mibook.mvvm.base.BaseMVVMActivity
    public void q1() {
        boolean z10 = ConfigSingleton.D().A0() || m1().getIsVip();
        com.gyf.immersionbar.d.q3(this).T2(!z10).G1(!z10).v1(ConfigSingleton.D().L(), 0.0f).a1();
    }
}
