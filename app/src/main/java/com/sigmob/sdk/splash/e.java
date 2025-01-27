package com.sigmob.sdk.splash;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.czhj.sdk.common.utils.FileUtil;
import com.czhj.sdk.common.utils.ImageTypeUtil;
import com.czhj.sdk.logger.SigmobLog;
import com.sigmob.sdk.base.common.BaseBroadcastReceiver;
import com.sigmob.sdk.base.models.BaseAdUnit;
import com.sigmob.sdk.base.models.IntentActions;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes4.dex */
public class e extends d {

    /* renamed from: b */
    public com.sigmob.sdk.base.views.gif.e f20310b;

    public e(Context context) {
        super(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        com.sigmob.sdk.base.views.gif.e eVar = new com.sigmob.sdk.base.views.gif.e(context);
        this.f20310b = eVar;
        eVar.setScaleType(ImageView.ScaleType.FIT_XY);
        setBackgroundColor(-1);
        addView(this.f20310b, layoutParams);
    }

    @Override // com.sigmob.sdk.splash.d
    public boolean a(BaseAdUnit baseAdUnit) {
        Bitmap decodeFile;
        if (baseAdUnit == null || baseAdUnit.getSplashFilePath() == null) {
            SigmobLog.e("adUnit or splashFilePath is null");
            return false;
        }
        String splashFilePath = baseAdUnit.getSplashFilePath();
        List asList = Arrays.asList("git", "jpeg", "jpg", "png", "bmp", "webp", "tif");
        String fileType = ImageTypeUtil.getFileType(splashFilePath);
        if (TextUtils.isEmpty(fileType)) {
            return false;
        }
        if (fileType.equals("gif")) {
            this.f20310b.setBytes(FileUtil.readBytes(splashFilePath));
            this.f20310b.e();
            BaseBroadcastReceiver.a(getContext(), baseAdUnit.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
            return true;
        }
        if (!asList.contains(fileType) || (decodeFile = BitmapFactory.decodeFile(splashFilePath)) == null) {
            return false;
        }
        BaseBroadcastReceiver.a(getContext(), baseAdUnit.getUuid(), IntentActions.ACTION_INTERSTITIAL_SHOW);
        this.f20310b.setImageBitmap(decodeFile);
        return true;
    }

    @Override // com.sigmob.sdk.splash.d
    public void b() {
        super.b();
        com.sigmob.sdk.base.views.gif.e eVar = this.f20310b;
        if (eVar != null) {
            eVar.e();
        }
    }

    @Override // com.sigmob.sdk.splash.d
    public /* bridge */ /* synthetic */ void c() {
        super.c();
    }

    @Override // com.sigmob.sdk.splash.d
    public /* bridge */ /* synthetic */ int getDuration() {
        return super.getDuration();
    }

    @Override // com.sigmob.sdk.splash.d
    public void a() {
        super.a();
        com.sigmob.sdk.base.views.gif.e eVar = this.f20310b;
        if (eVar != null) {
            eVar.g();
        }
    }
}
