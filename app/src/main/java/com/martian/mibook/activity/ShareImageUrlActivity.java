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
import android.os.Environment;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.maritan.libweixin.c;
import com.martian.apptask.g.j;
import com.martian.libcomm.utils.GsonUtils;
import com.martian.libmars.utils.n0;
import com.martian.libqq.QQAPIInstance;
import com.martian.mibook.activity.ShareImageUrlActivity;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.data.ShareInfo;
import com.martian.mibook.lib.account.response.MiTaskAccount;
import com.martian.rpauth.MartianRPUserManager;
import com.martian.ttbookhd.R;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.io.File;

/* loaded from: classes3.dex */
public class ShareImageUrlActivity extends Activity {

    /* renamed from: a */
    private Bitmap f10838a;

    /* renamed from: b */
    private ImageView f10839b;

    /* renamed from: c */
    private RelativeLayout f10840c;

    /* renamed from: d */
    private ShareInfo f10841d;

    /* renamed from: e */
    private View f10842e;

    /* renamed from: f */
    private Bitmap f10843f;

    /* renamed from: g */
    private boolean f10844g = false;

    /* renamed from: h */
    private final String f10845h = "ttbook_activity_bg_share_activity";

    class a implements j.d {
        a() {
        }

        @Override // com.martian.apptask.g.j.d
        public void a() {
            ShareImageUrlActivity.this.k("分享取消");
        }

        @Override // com.martian.apptask.g.j.d
        public void b() {
            ShareImageUrlActivity.this.k("分享成功");
        }

        @Override // com.martian.apptask.g.j.d
        public void onShareError(int errCode, String errMsg) {
            ShareImageUrlActivity.this.k("分享失败：" + errMsg);
        }
    }

    class b implements c.f {
        b() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            com.martian.mibook.lib.model.g.b.e(ShareImageUrlActivity.this, "shared", "friends");
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class c implements c.f {
        c() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            com.martian.mibook.lib.model.g.b.e(ShareImageUrlActivity.this, "shared", "circle");
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    class d implements n0.c {
        d() {
        }

        /* renamed from: a */
        public /* synthetic */ void b() {
            ShareImageUrlActivity.this.e();
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onError() {
            ShareImageUrlActivity.this.q();
        }

        @Override // com.martian.libmars.utils.n0.c
        public void onSuccess(Drawable resource) {
            ShareImageUrlActivity.this.runOnUiThread(new Runnable() { // from class: com.martian.mibook.activity.u0
                @Override // java.lang.Runnable
                public final void run() {
                    ShareImageUrlActivity.d.this.b();
                }
            });
        }
    }

    class e implements c.f {
        e() {
        }

        @Override // com.maritan.libweixin.c.f
        public void a() {
            ShareImageUrlActivity.this.k("分享取消");
        }

        @Override // com.maritan.libweixin.c.f
        public void b() {
            ShareImageUrlActivity.this.setResult(-1);
        }

        @Override // com.maritan.libweixin.c.f
        public void c(String errMsg) {
            ShareImageUrlActivity.this.k("分享失败：" + errMsg);
        }

        @Override // com.maritan.libweixin.c.f
        public void d() {
        }
    }

    @SuppressLint({"SetTextI18n"})
    private void c() {
        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        if (this.f10841d.getCodeLeft() == null) {
            layoutParams.setMargins(0, com.martian.libmars.d.h.b(this.f10841d.getCodeTop().intValue()), 0, 0);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(com.martian.libmars.d.h.b(this.f10841d.getCodeLeft().intValue()), com.martian.libmars.d.h.b(this.f10841d.getCodeTop().intValue()), 0, 0);
        }
        textView.setLayoutParams(layoutParams);
        textView.setTextSize(2, this.f10841d.getCodeTextSize().intValue());
        textView.setTextColor(Color.parseColor(this.f10841d.getCodeTextColor()));
        if (com.martian.libsupport.k.p(this.f10841d.getCode())) {
            textView.setText(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS + MiConfigSingleton.V3().D4());
        } else {
            textView.setText(Html.fromHtml(this.f10841d.getCode()));
        }
        this.f10840c.addView(textView);
    }

    private boolean d() {
        ImageView imageView = new ImageView(this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(com.martian.libmars.d.h.b(this.f10841d.getQrcodeWidth().intValue()), com.martian.libmars.d.h.b(this.f10841d.getQrcodeHeight().intValue()));
        if (this.f10841d.getQrcodeLeft() == null) {
            layoutParams.setMargins(0, com.martian.libmars.d.h.b(this.f10841d.getQrcodeTop().intValue()), 0, 0);
            layoutParams.addRule(14);
        } else {
            layoutParams.setMargins(com.martian.libmars.d.h.b(this.f10841d.getQrcodeLeft().intValue()), com.martian.libmars.d.h.b(this.f10841d.getQrcodeTop().intValue()), 0, 0);
        }
        imageView.setLayoutParams(layoutParams);
        Bitmap g2 = g();
        this.f10838a = g2;
        if (g2 == null || g2.isRecycled()) {
            this.f10842e.setVisibility(8);
            q();
            return false;
        }
        imageView.setImageBitmap(this.f10838a);
        this.f10840c.addView(imageView);
        return true;
    }

    public void e() {
        if (!com.martian.libsupport.k.p(this.f10841d.getUrl()) ? d() : true) {
            if (!com.martian.libsupport.k.p(this.f10841d.getCode())) {
                c();
            }
            l();
        }
    }

    private void i() {
        if (com.martian.libsupport.k.p(this.f10841d.getImageUrl())) {
            e();
        } else {
            com.martian.libmars.utils.n0.q(this, this.f10841d.getImageUrl(), this.f10839b, new d());
        }
    }

    private void l() {
        this.f10844g = true;
        if (this.f10843f == null) {
            try {
                this.f10843f = com.martian.libmars.utils.i0.r(this.f10840c);
            } catch (Exception unused) {
                q();
                return;
            }
        }
        Bitmap bitmap = this.f10843f;
        if (bitmap == null || bitmap.isRecycled()) {
            q();
            return;
        }
        int intValue = this.f10841d.getShareType().intValue();
        if (intValue == 2) {
            t();
        } else if (intValue == 4) {
            m();
        } else {
            j();
        }
    }

    public static void n(Activity activity, int shareType) {
        o(activity, u(activity, shareType));
    }

    public static void o(Activity activity, ShareInfo shareInfo) {
        Intent intent = new Intent(activity, (Class<?>) ShareImageUrlActivity.class);
        intent.putExtra(MartianRPUserManager.F, GsonUtils.b().toJson(shareInfo));
        activity.startActivityForResult(intent, shareInfo.getShareType().intValue());
    }

    public void q() {
        int intValue = this.f10841d.getShareType().intValue();
        if (intValue == 2) {
            s();
        } else if (intValue == 3) {
            p();
        } else if (intValue != 4) {
            r();
        } else {
            com.martian.apptask.g.j.c(this, MiConfigSingleton.V3().J3(), this.f10841d.getTitle(), this.f10841d.getContent(), this.f10841d.getUrl());
        }
        finish();
    }

    public static ShareInfo u(Activity activity, int shareType) {
        ShareInfo shareInfo = new ShareInfo();
        shareInfo.setShareType(Integer.valueOf(shareType));
        if (shareType == 1 || shareType == 2) {
            shareInfo.setUrl(MiConfigSingleton.V3().W3().getInviteShareLink());
        } else {
            shareInfo.setUrl(MiConfigSingleton.V3().W3().getPhoneInviteShareLink());
        }
        MiTaskAccount x4 = MiConfigSingleton.V3().x4();
        if (x4 == null || x4.getWealth() <= 0) {
            shareInfo.setCode("快来一起用" + activity.getString(R.string.app_name));
        } else {
            shareInfo.setCode("我在" + activity.getString(R.string.app_name) + "赚了" + com.martian.rpauth.d.i.m(Integer.valueOf(x4.getWealth())) + "元");
        }
        return shareInfo;
    }

    public String f(Bitmap bitmap, String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("");
        String str = File.separator;
        sb.append(str);
        sb.append("ttbook");
        sb.append(str);
        try {
            return com.martian.apptask.g.i.b(this, bitmap, sb.toString(), fileName);
        } catch (Exception unused) {
            return "";
        }
    }

    public Bitmap g() {
        Bitmap a2 = b.d.d.c.a(this.f10841d.getUrl());
        this.f10838a = a2;
        if (a2 == null || a2.isRecycled()) {
            return null;
        }
        return this.f10838a;
    }

    public String h(String fileName) {
        StringBuilder sb = new StringBuilder();
        sb.append(Environment.getExternalStorageDirectory());
        sb.append("");
        String str = File.separator;
        sb.append(str);
        sb.append("ttbook");
        sb.append(str);
        File file = new File(sb.toString() + fileName);
        return file.exists() ? file.getAbsolutePath() : "";
    }

    public void j() {
        ComponentName componentName = this.f10841d.getShareType().intValue() == 3 ? new ComponentName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.JumpActivity") : new ComponentName("com.tencent.mm", "com.tencent.mm.ui.tools.ShareImgUI");
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/*");
        File file = new File(h("ttbook_activity_bg_share_activity"));
        Uri uri = Uri.EMPTY;
        if (this.f10843f != null) {
            file = new File(f(this.f10843f, "ttbook_activity_bg_share_activity"));
        }
        intent.setComponent(componentName);
        if (file.exists() && (uri = com.martian.libsupport.e.z(this, file)) == null) {
            return;
        }
        try {
            intent.putExtra("android.intent.extra.STREAM", uri);
            intent.addFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            startActivity(Intent.createChooser(intent, "推荐" + getResources().getString(R.string.app_name_bak)));
        } catch (ActivityNotFoundException e2) {
            e2.printStackTrace();
        }
        finish();
    }

    public void k(String msg) {
        if (com.martian.libsupport.k.p(msg)) {
            msg = getString(R.string.unknown_error);
        }
        Toast.makeText(this, msg, 0).show();
    }

    public void m() {
        f(this.f10843f, "ttbook_activity_bg_share_activity");
        com.martian.apptask.g.j.b(this, this.f10841d.getUrl(), h("ttbook_activity_bg_share_activity"));
    }

    @Override // android.app.Activity
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        QQAPIInstance.getInstance().onActivityResult(requestCode, resultCode, data);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_image_url);
        String string = savedInstanceState != null ? savedInstanceState.getString(MartianRPUserManager.F) : getIntent().getStringExtra(MartianRPUserManager.F);
        if (com.martian.libsupport.k.p(string)) {
            k("获取信息失败");
            finish();
        }
        ShareInfo shareInfo = (ShareInfo) GsonUtils.b().fromJson(string, ShareInfo.class);
        this.f10841d = shareInfo;
        if (shareInfo == null) {
            k("获取信息失败");
            finish();
            return;
        }
        this.f10842e = findViewById(R.id.share_loading_hint);
        this.f10839b = (ImageView) findViewById(R.id.share_image);
        this.f10840c = (RelativeLayout) findViewById(R.id.share_view);
        if (!MiConfigSingleton.V3().x5()) {
            k("请先登录");
            finish();
        } else if (this.f10841d.getStyle().intValue() == 1) {
            q();
        } else {
            i();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        Bitmap bitmap = this.f10843f;
        if (bitmap != null) {
            bitmap.recycle();
        }
        Bitmap bitmap2 = this.f10838a;
        if (bitmap2 != null) {
            bitmap2.recycle();
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (!this.f10844g || isFinishing()) {
            return;
        }
        setResult(-1);
        finish();
    }

    @Override // android.app.Activity
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        if (this.f10841d != null) {
            String json = GsonUtils.b().toJson(this.f10841d);
            if (com.martian.libsupport.k.p(json)) {
                return;
            }
            outState.putString(MartianRPUserManager.F, json);
        }
    }

    public void p() {
        com.martian.apptask.g.j.a(this, MiConfigSingleton.V3().J3(), this.f10841d.getTitle(), this.f10841d.getContent(), this.f10841d.getUrl(), new a());
    }

    public void r() {
        com.maritan.libweixin.c.g().y(this.f10841d.getTitle(), this.f10841d.getContent(), this.f10841d.getUrl(), R.drawable.ic_launcher_80x80, new b());
    }

    public void s() {
        com.maritan.libweixin.c.g().v(this.f10841d.getTitle(), this.f10841d.getContent(), this.f10841d.getUrl(), R.drawable.ic_launcher_80x80, new c());
    }

    public void t() {
        com.maritan.libweixin.c.g().A(this.f10843f, true, new e());
    }
}
