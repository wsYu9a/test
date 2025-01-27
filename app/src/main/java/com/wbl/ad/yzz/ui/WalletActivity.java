package com.wbl.ad.yzz.ui;

import android.app.Dialog;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.protect.sdk.Ab758f312afd958f045aa4ee1ad5ae334fbdd9645;
import com.cdo.oaps.ad.OapsKey;
import com.kuaishou.weapon.p0.t;
import com.martian.mibook.application.MiConfigSingleton;
import com.opos.mobad.f.a.j;
import com.umeng.analytics.pro.am;
import com.wbl.ad.yzz.base.BaseActivity;
import com.wbl.ad.yzz.dialog.g;
import com.wbl.ad.yzz.network.b.b.l0;
import com.wbl.ad.yzz.ui.f.i;
import com.wbl.ad.yzz.wigdet.h.c;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\n\u0002\u0010$\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u007f\u0010\u0005J\u000f\u0010\u0004\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0003H\u0014¢\u0006\u0004\b\u0006\u0010\u0005J\u000f\u0010\b\u001a\u00020\u0007H\u0014¢\u0006\u0004\b\b\u0010\tJ/\u0010\u0010\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00072\u000e\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u000b2\u0006\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0004\u0010\u0014J\u0019\u0010\u0004\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\fH\u0016¢\u0006\u0004\b\u0004\u0010\u0016J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0004\u0010\u001bJ!\u0010\u0004\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u0004\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u001d\u0010\u0005J\u0017\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\u0004\u0010\u001eJ\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b\u0004\u0010!J'\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010 \u001a\u00020\fH\u0016¢\u0006\u0004\b\u0004\u0010\"J\u000f\u0010#\u001a\u00020\u0003H\u0002¢\u0006\u0004\b#\u0010\u0005J\u000f\u0010$\u001a\u00020\u0003H\u0002¢\u0006\u0004\b$\u0010\u0005J\u000f\u0010%\u001a\u00020\u0003H\u0002¢\u0006\u0004\b%\u0010\u0005J\u000f\u0010&\u001a\u00020\u0003H\u0002¢\u0006\u0004\b&\u0010\u0005J\u000f\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0004\b'\u0010\u0005J\u000f\u0010(\u001a\u00020\u0003H\u0002¢\u0006\u0004\b(\u0010\u0005J\u000f\u0010)\u001a\u00020\u0003H\u0002¢\u0006\u0004\b)\u0010\u0005J\u0017\u0010\u001d\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u001f\u0010\u0004\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0004\u0010+J\u000f\u0010,\u001a\u00020\u0003H\u0002¢\u0006\u0004\b,\u0010\u0005J\u000f\u0010-\u001a\u00020\u0019H\u0002¢\u0006\u0004\b-\u0010.J!\u0010\u0004\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u00172\u0006\u0010/\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u0004\u00100J#\u0010\u0004\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0002¢\u0006\u0004\b\u0004\u00101J#\u00104\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f032\u0006\u00102\u001a\u00020\u0007H\u0002¢\u0006\u0004\b4\u00105R\u0016\u00107\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001d\u00106R\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u0004\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010>\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b%\u00106R\u0016\u0010?\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\b\u00106R\u0016\u0010@\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u00106R\u0016\u0010A\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u00106R\u0018\u0010E\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bC\u0010DR\u0018\u0010I\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bG\u0010HR\u0018\u0010K\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bJ\u0010HR\u0018\u0010N\u001a\u0004\u0018\u00010L8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b#\u0010MR\u0018\u0010P\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bO\u0010HR\u0018\u0010R\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bQ\u0010<R\u0018\u0010V\u001a\u0004\u0018\u00010S8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bT\u0010UR\u0018\u0010X\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bW\u0010<R\u0018\u0010Z\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bY\u0010HR\u0018\u0010\\\u001a\u0004\u0018\u00010\u00178\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b&\u0010[R\u0016\u0010]\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u00106R\u0016\u0010a\u001a\u00020^8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b_\u0010`R\u0018\u0010d\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010cR\u0016\u0010e\u001a\u00020\u00078\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b(\u00106R\u0018\u0010g\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bf\u0010HR\u0016\u0010h\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b,\u00106R\u0018\u0010l\u001a\u0004\u0018\u00010i8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bj\u0010kR\u0018\u0010n\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bm\u0010<R\u0018\u0010p\u001a\u0004\u0018\u00010B8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bo\u0010DR$\u0010t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020r\u0018\u00010q8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b4\u0010sR\u0016\u0010x\u001a\u00020u8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bv\u0010wR\u0018\u0010z\u001a\u0004\u0018\u00010F8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\by\u0010HR\u0018\u0010|\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u0010<R\u0018\u0010~\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u0010<¨\u0006\u0080\u0001"}, d2 = {"Lcom/wbl/ad/yzz/ui/WalletActivity;", "Lcom/wbl/ad/yzz/base/BaseActivity;", "Lcom/wbl/ad/yzz/d/d/c;", "", "a", "()V", "onDestroy", "", "d", "()I", "requestCode", "", "", "permissions", "", "grantResults", "onRequestPermissionsResult", "(I[Ljava/lang/String;[I)V", "Lcom/wbl/ad/yzz/network/b/b/l0;", MiConfigSingleton.t0, "(Lcom/wbl/ad/yzz/network/b/b/l0;)V", "msg", "(Ljava/lang/String;)V", "Lcom/wbl/ad/yzz/network/b/a/b;", "amount", "", "isFromBindPhoneNumber", "(Lcom/wbl/ad/yzz/network/b/a/b;IZ)V", "(Ljava/lang/String;Z)V", "c", "(I)V", "code", "wrongMsg", "(Ljava/lang/String;Ljava/lang/String;)V", "(ILjava/lang/String;Ljava/lang/String;)V", "k", "m", "i", t.f9404d, "h", j.f20763a, OapsKey.KEY_GRADE, "money", "(IZ)V", "f", com.kwad.sdk.ranger.e.TAG, "()Z", "needCheckPermission", "(Lcom/wbl/ad/yzz/network/b/a/b;Z)V", "(Ljava/lang/Integer;[I)V", "status", "", "b", "(I)Ljava/util/Map;", "I", "money1", "Ljava/lang/String;", "TAG", "Landroid/widget/TextView;", "x", "Landroid/widget/TextView;", "walletUserIdTv", "mUserId", "money2", "money3", "money6", "Landroid/widget/ImageView;", "p", "Landroid/widget/ImageView;", "walletDarkModeMask", "Landroid/widget/Button;", "s", "Landroid/widget/Button;", "walletBtn30", "t", "walletBtn50", "Landroid/app/Dialog;", "Landroid/app/Dialog;", "mTiXianDialog", IAdInterListener.AdReqParam.WIDTH, "walletBtn150", am.aD, "walletCanGetMoneyTv", "Landroid/widget/LinearLayout;", "D", "Landroid/widget/LinearLayout;", "walletRuleTextLl", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "walletTodayMoneyTv", "v", "walletBtn100", "Lcom/wbl/ad/yzz/network/b/a/b;", "mDataRequestWithdrawalRes", "money5", "Landroid/view/View$OnClickListener;", ExifInterface.LONGITUDE_EAST, "Landroid/view/View$OnClickListener;", "mClickListener", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "Lcom/wbl/ad/yzz/innerconfig/d/d;", "mSceneCache", "REQUEST_CODE", "q", "walletBtn10", "money4", "Landroid/view/View;", "u", "Landroid/view/View;", "walletBtnContainer3", "B", "tiXianTopTextView", "o", "walletBackIv", "Lcom/wbl/ad/yzz/d/b/f/a;", "Lcom/wbl/ad/yzz/d/a/c;", "Lcom/wbl/ad/yzz/d/b/f/a;", "mPresenter", "Lcom/wbl/ad/yzz/ui/f/i;", "n", "Lcom/wbl/ad/yzz/ui/f/i;", "mPhoneNumberWithdrawal", t.k, "walletBtn20", "C", "walletGetMoneyDayTv", "y", "walletCurrentMoneyTv", "<init>", "wblsdk_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class WalletActivity extends BaseActivity implements com.wbl.ad.yzz.d.d.c {

    /* renamed from: A */
    public TextView walletTodayMoneyTv;

    /* renamed from: B, reason: from kotlin metadata */
    public TextView tiXianTopTextView;

    /* renamed from: C, reason: from kotlin metadata */
    public TextView walletGetMoneyDayTv;

    /* renamed from: D, reason: from kotlin metadata */
    public LinearLayout walletRuleTextLl;

    /* renamed from: b, reason: from kotlin metadata */
    public com.wbl.ad.yzz.d.b.f.a<com.wbl.ad.yzz.d.d.c, com.wbl.ad.yzz.d.a.c> mPresenter;

    /* renamed from: c, reason: from kotlin metadata */
    public int money1;

    /* renamed from: d, reason: from kotlin metadata */
    public int money2;

    /* renamed from: e */
    public int money3;

    /* renamed from: f, reason: from kotlin metadata */
    public int money4;

    /* renamed from: g */
    public int money5;

    /* renamed from: h, reason: from kotlin metadata */
    public int money6;

    /* renamed from: i, reason: from kotlin metadata */
    public int mUserId;

    /* renamed from: k, reason: from kotlin metadata */
    public Dialog mTiXianDialog;

    /* renamed from: l */
    public com.wbl.ad.yzz.network.b.a.b mDataRequestWithdrawalRes;

    /* renamed from: m, reason: from kotlin metadata */
    public com.wbl.ad.yzz.innerconfig.d.d mSceneCache;

    /* renamed from: o, reason: from kotlin metadata */
    public ImageView walletBackIv;

    /* renamed from: p, reason: from kotlin metadata */
    public ImageView walletDarkModeMask;

    /* renamed from: q, reason: from kotlin metadata */
    public Button walletBtn10;

    /* renamed from: r */
    public Button walletBtn20;

    /* renamed from: s, reason: from kotlin metadata */
    public Button walletBtn30;

    /* renamed from: t, reason: from kotlin metadata */
    public Button walletBtn50;

    /* renamed from: u, reason: from kotlin metadata */
    public View walletBtnContainer3;

    /* renamed from: v, reason: from kotlin metadata */
    public Button walletBtn100;

    /* renamed from: w */
    public Button walletBtn150;

    /* renamed from: x, reason: from kotlin metadata */
    public TextView walletUserIdTv;

    /* renamed from: y, reason: from kotlin metadata */
    public TextView walletCurrentMoneyTv;

    /* renamed from: z */
    public TextView walletCanGetMoneyTv;

    /* renamed from: a, reason: from kotlin metadata */
    public final String TAG = "WaletTi";

    /* renamed from: j */
    public final int REQUEST_CODE = 599;

    /* renamed from: n, reason: from kotlin metadata */
    public final i mPhoneNumberWithdrawal = new i();

    /* renamed from: E */
    public final View.OnClickListener mClickListener = new b();

    public static final class a implements g.a {
        public a() {
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10171, this, null);
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10166, this, str);
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void b(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10165, this, str);
        }
    }

    public static final class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10168, this, view);
        }
    }

    public static final class c implements g.a {

        /* renamed from: b */
        public final /* synthetic */ int f33944b;

        public c(int i2) {
            this.f33944b = i2;
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void a() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10167, this, null);
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void a(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10162, this, str);
        }

        @Override // com.wbl.ad.yzz.dialog.g.a
        public void b(String str) {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10161, this, str);
        }
    }

    public static final class d implements c.d {
        public d() {
        }

        @Override // com.wbl.ad.yzz.wigdet.h.c.d
        public final void dismiss() {
            Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10164, this, null);
        }
    }

    public static final /* synthetic */ com.wbl.ad.yzz.d.b.f.a a(WalletActivity walletActivity) {
        return (com.wbl.ad.yzz.d.b.f.a) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10163, null, walletActivity);
    }

    public static final /* synthetic */ com.wbl.ad.yzz.innerconfig.d.d b(WalletActivity walletActivity) {
        return (com.wbl.ad.yzz.innerconfig.d.d) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10125, null, walletActivity);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public void a() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10120, this, null);
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(int amount) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10119, this, Integer.valueOf(amount));
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(int amount, String code, String wrongMsg) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10114, this, Integer.valueOf(amount), code, wrongMsg);
    }

    public final void a(int money, boolean isFromBindPhoneNumber) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10113, this, Integer.valueOf(money), Boolean.valueOf(isFromBindPhoneNumber));
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(com.wbl.ad.yzz.network.b.a.b r3, int amount, boolean isFromBindPhoneNumber) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10116, this, r3, Integer.valueOf(amount), Boolean.valueOf(isFromBindPhoneNumber));
    }

    public final void a(com.wbl.ad.yzz.network.b.a.b r3, boolean needCheckPermission) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10115, this, r3, Boolean.valueOf(needCheckPermission));
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(l0 r3) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10142, this, r3);
    }

    public final void a(Integer requestCode, int[] grantResults) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10141, this, requestCode, grantResults);
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(String msg) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10144, this, msg);
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(String code, String wrongMsg) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10143, this, code, wrongMsg);
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void a(String msg, boolean isFromBindPhoneNumber) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10138, this, msg, Boolean.valueOf(isFromBindPhoneNumber));
    }

    public final Map<String, String> b(int status) {
        return (Map) Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.l(-10137, this, Integer.valueOf(status));
    }

    @Override // com.wbl.ad.yzz.d.d.c
    public void c() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10140, this, null);
    }

    public final void c(int money) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10139, this, Integer.valueOf(money));
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity
    public int d() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.i(-10134, this, null);
    }

    public final boolean e() {
        return Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.z(-10133, this, null);
    }

    public final void f() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10136, this, null);
    }

    public final void g() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10135, this, null);
    }

    public final void h() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10130, this, null);
    }

    public final void i() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10129, this, null);
    }

    public final void j() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10132, this, null);
    }

    public final void k() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10131, this, null);
    }

    public final void l() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10222, this, null);
    }

    public final void m() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10221, this, null);
    }

    @Override // com.wbl.ad.yzz.base.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10224, this, null);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        Ab758f312afd958f045aa4ee1ad5ae334fbdd9645.v(-10223, this, Integer.valueOf(requestCode), permissions, grantResults);
    }
}
