package com.martian.mibook.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import ba.g;
import ba.l;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.libqq.QQAPIInstance;
import com.martian.mibook.R;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.rpauth.MartianRPUserManager;
import i8.i;
import i8.j;
import java.io.File;
import l9.m0;
import oe.f;
import z7.b;

/* loaded from: classes3.dex */
public class ShareImageUrlActivity extends Activity {

    /* renamed from: b */
    public Bitmap f13122b;

    /* renamed from: c */
    public ImageView f13123c;

    /* renamed from: d */
    public RelativeLayout f13124d;

    /* renamed from: e */
    public ShareInfo f13125e;

    /* renamed from: f */
    public View f13126f;

    /* renamed from: g */
    public Bitmap f13127g;

    /* renamed from: h */
    public boolean f13128h = false;

    /* renamed from: i */
    public final String f13129i = "ttbook_activity_bg_share_activity";

    public class a implements j.d {
        public a() {
        }

        @Override // i8.j.d
        public void a() {
            ShareImageUrlActivity.this.k("分享取消");
        }

        @Override // i8.j.d
        public void b() {
            ShareImageUrlActivity.this.k("分享成功");
        }

        @Override // i8.j.d
        public void onShareError(int i10, String str) {
            ShareImageUrlActivity.this.k("分享失败：" + str);
        }
    }

    public class b implements b.InterfaceC0852b {
        public b() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
            ac.a.e(ShareImageUrlActivity.this, "shared", "friends");
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }
    }

    public class c implements b.InterfaceC0852b {
        public c() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
            ac.a.e(ShareImageUrlActivity.this, "shared", "circle");
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }
    }

    public class d implements m0.c {
        public d() {
        }

        @Override // l9.m0.c
        public void a(Drawable drawable) {
            ShareImageUrlActivity.this.runOnUiThread(new Runnable() { // from class: qa.w
                public /* synthetic */ w() {
                }

                @Override // java.lang.Runnable
                public final void run() {
                    ShareImageUrlActivity.d.this.c();
                }
            });
        }

        public final /* synthetic */ void c() {
            ShareImageUrlActivity.this.e();
        }

        @Override // l9.m0.c
        public void onError() {
            ShareImageUrlActivity.this.q();
        }
    }

    public class e implements b.InterfaceC0852b {
        public e() {
        }

        @Override // z7.b.InterfaceC0852b
        public void a() {
            ShareImageUrlActivity.this.k("分享取消");
        }

        @Override // z7.b.InterfaceC0852b
        public void b() {
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // z7.b.InterfaceC0852b
        public void c(String str) {
            ShareImageUrlActivity.this.k("分享失败：" + str);
        }

        @Override // z7.b.InterfaceC0852b
        public void d() {
        }
    }

    public static void n(Activity activity, int i10) {
        o(activity, u(activity, i10));
    }

    public static void o(Activity activity, ShareInfo shareInfo) {
        Intent intent = new Intent(activity, (Class<?>) ShareImageUrlActivity.class);
        intent.putExtra(MartianRPUserManager.f16188l, GsonUtils.b().toJson(shareInfo));
        activity.startActivityForResult(intent, shareInfo.getShareType().intValue());
    }

    public static ShareInfo u(Activity activity, int i10) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(Integer.valueOf(i10));
        if (i10 == 1 || i10 == 2) {
            shareInfo.setUrl(MiConfigSingleton.b2().c2().getInviteShareLink());
        } else {
            shareInfo.setUrl(MiConfigSingleton.b2().c2().getPhoneInviteShareLink());
        }
        MiTaskAccount p22 = MiConfigSingleton.b2().p2();
        if (p22 == null || p22.getWealth() <= 0) {
            shareInfo.setCode("快来一起用" + activity.getString(R.string.app_name));
        } else {
            shareInfo.setCode("我在" + activity.getString(R.string.app_name) + "赚了" + f.n(Integer.valueOf(p22.getWealth())) + "元");
        }
        return shareInfo;
    }

    @SuppressLint({"SetTextI18n"})
    public final void c() {
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f13125e.getCodeLeft() == null) {
            layoutParams.setMargins(0, ConfigSingleton.i(this.f13125e.getCodeTop().intValue()), 0, 0);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(ConfigSingleton.i(this.f13125e.getCodeLeft().intValue()), ConfigSingleton.i(this.f13125e.getCodeTop().intValue()), 0, 0);
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, this.f13125e.getCodeTextSize().intValue());
        textView.setTextColor(Color.parseColor(this.f13125e.getCodeTextColor()));
        if (l.q(this.f13125e.getCode())) {
            textView.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + MiConfigSingleton.b2().t2());
        } else {
            textView.setText(Html.fromHtml(this.f13125e.getCode()));
        }
        this.f13124d.addView(textView);
    }

    public final boolean d() {
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ConfigSingleton.i(this.f13125e.getQrcodeWidth().intValue()), ConfigSingleton.i(this.f13125e.getQrcodeHeight().intValue()));
        if (this.f13125e.getQrcodeLeft() == null) {
            layoutParams.setMargins(0, ConfigSingleton.i(this.f13125e.getQrcodeTop().intValue()), 0, 0);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(ConfigSingleton.i(this.f13125e.getQrcodeLeft().intValue()), ConfigSingleton.i(this.f13125e.getQrcodeTop().intValue()), 0, 0);
        }
        imageView.setLayoutParams(layoutParams);
        Bitmap g10 = g();
        this.f13122b = g10;
        if (g10 == null || g10.isRecycled()) {
            this.f13126f.setVisibility(8);
            q();
            return false;
        }
        imageView.setImageBitmap(this.f13122b);
        this.f13124d.addView(imageView);
        return true;
    }

    public final void e() {
        if (!l.q(this.f13125e.getUrl()) ? d() : true) {
            if (!l.q(this.f13125e.getCode())) {
                c();
            }
            l();
        }
    }

    public String f(Bitmap bitmap, String str) {
        String str2 = ConfigSingleton.A + "ttbook" + File.separator;
        try {
            i.b(this, bitmap, str2, str);
        } catch (Exception e10) {
            System.out.println(e10.getMessage());
        }
        return str2 + str;
    }

    public Bitmap g() {
        Bitmap a10 = ma.b.a(this.f13125e.getUrl());
        this.f13122b = a10;
        if (a10 == null || a10.isRecycled()) {
            return null;
        }
        return this.f13122b;
    }

    public String h(String str) {
        File file = new File((ConfigSingleton.A + "ttbook" + File.separator) + str);
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public final void i() {
        if (l.q(this.f13125e.getImageUrl())) {
            e();
        } else {
            m0.q(this, this.f13125e.getImageUrl(), this.f13123c, new d());
        }
    }

    public void j() {
        ComponentName componentName = this.f13125e.getShareType().intValue() == 3 ? new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity") : new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        File file = new File(h("ttbook_activity_bg_share_activity"));
        Uri uri = Uri.EMPTY;
        String f10 = f(this.f13127g, "ttbook_activity_bg_share_activity");
        if (this.f13127g != null) {
            file = new File(f10);
        }
        intent.setComponent(componentName);
        if (file.exists() && (uri = g.z(this, file)) == null) {
            return;
        }
        try {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(268435456);
            startActivity(Intent.createChooser(intent, "推荐" + getResources().getString(R.string.app_name_bak)));
        } catch (ActivityNotFoundException e10) {
            System.out.println(e10.getMessage());
        }
        finish();
    }

    public void k(String str) {
        if (l.q(str)) {
            str = getString(com.martian.libmars.R.string.unknown_error);
        }
        Toast.makeText(this, str, 0).show();
    }

    public final void l() {
        this.f13128h = true;
        if (this.f13127g == null) {
            try {
                this.f13127g = l9.b.r(this.f13124d);
            } catch (Exception unused) {
                q();
                return;
            }
        }
        Bitmap bitmap = this.f13127g;
        if (bitmap == null || bitmap.isRecycled()) {
            q();
            return;
        }
        int intValue = this.f13125e.getShareType().intValue();
        if (intValue == 2) {
            t();
        } else if (intValue == 4) {
            m();
        } else {
            j();
        }
    }

    public void m() {
        f(this.f13127g, "ttbook_activity_bg_share_activity");
        j.b(this, this.f13125e.getUrl(), h("ttbook_activity_bg_share_activity"));
    }

    @Override // android.app.Activity
    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        QQAPIInstance.getInstance().onActivityResult(i10, i11, intent);
    }

    @Override // android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_share_image_url);
        String string = bundle != null ? bundle.getString(MartianRPUserManager.f16188l) : getIntent().getStringExtra(MartianRPUserManager.f16188l);
        if (l.q(string)) {
            k("获取信息失败");
            finish();
        }
        ShareInfo shareInfo = (ShareInfo) GsonUtils.b().fromJson(string, ShareInfo.class);
        this.f13125e = shareInfo;
        if (shareInfo == null) {
            k("获取信息失败");
            finish();
            return;
        }
        this.f13126f = findViewById(R.id.share_loading_hint);
        this.f13123c = (ImageView) findViewById(R.id.share_image);
        this.f13124d = (RelativeLayout) findViewById(R.id.share_view);
        if (!MiConfigSingleton.b2().F2()) {
            k("请先登录");
            finish();
        } else if (this.f13125e.getStyle().intValue() == 1) {
            q();
        } else {
            i();
        }
    }

    @Override // android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f13127g;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.f13122b;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        if (!this.f13128h || isFinishing()) {
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        if (this.f13125e != null) {
            String json = GsonUtils.b().toJson(this.f13125e);
            if (l.q(json)) {
                return;
            }
            bundle.putString(MartianRPUserManager.f16188l, json);
        }
    }

    public void p() {
        j.a(this, MiConfigSingleton.b2().Y1(), this.f13125e.getTitle(), this.f13125e.getContent(), this.f13125e.getUrl(), new a());
    }

    public final void q() {
        int intValue = this.f13125e.getShareType().intValue();
        if (intValue == 2) {
            s();
        } else if (intValue == 3) {
            p();
        } else if (intValue != 4) {
            r();
        } else {
            j.c(this, MiConfigSingleton.b2().Y1(), this.f13125e.getTitle(), this.f13125e.getContent(), this.f13125e.getUrl());
        }
        finish();
    }

    public void r() {
        z7.b.d().t(this, this.f13125e.getTitle(), this.f13125e.getContent(), this.f13125e.getUrl(), R.drawable.ic_launcher, new b());
    }

    public void s() {
        z7.b.d().r(this, this.f13125e.getTitle(), this.f13125e.getContent(), this.f13125e.getUrl(), R.drawable.ic_launcher, new c());
    }

    public void t() {
        z7.b.d().v(this.f13127g, true, new e());
    }
}
