package com.zk_oaction.adengine.lk_sdkwrapper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.qq.e.comm.constants.ErrorCode;
import com.wrapper_oaction.ZkViewSDK;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes5.dex */
public class c extends a {
    private Bitmap N;

    public c(Context context, int i2, String str, HashMap<ZkViewSDK.KEY, Object> hashMap, int i3, Map map, ZkViewSDK.a aVar) {
        super(context, i2, str, hashMap, i3, map, aVar);
        if (!new File(this.o + "no_first_draw").exists()) {
            V();
        }
        b0();
    }

    private void V() {
        try {
            ImageView imageView = new ImageView(this.p);
            Bitmap decodeFile = BitmapFactory.decodeFile(this.o + "bj.jpg");
            this.N = decodeFile;
            imageView.setImageBitmap(decodeFile);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            addView(imageView, new FrameLayout.LayoutParams(-1, -1));
        } catch (Throwable unused) {
        }
    }

    private void b0() {
        int i2;
        String str;
        if (this.u == null) {
            return;
        }
        HashMap hashMap = new HashMap();
        HashMap<ZkViewSDK.KEY, Object> hashMap2 = this.s;
        if (hashMap2 != null) {
            Object obj = hashMap2.get(ZkViewSDK.KEY.KEY_SKIP_TIME);
            if (obj instanceof Integer) {
                int intValue = ((Integer) obj).intValue();
                str = ZkViewSDK.c.q;
                i2 = intValue * 1000;
                hashMap.put(str, Integer.valueOf(i2));
                this.u.a(this.t, hashMap);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.o);
        sb.append("isVideo");
        i2 = new File(sb.toString()).exists() ? ErrorCode.UNKNOWN_ERROR : 4000;
        str = ZkViewSDK.c.q;
        hashMap.put(str, Integer.valueOf(i2));
        this.u.a(this.t, hashMap);
    }

    @Override // com.zk_oaction.adengine.lk_sdkwrapper.a
    public void y() {
        synchronized (this) {
            super.y();
            try {
                Bitmap bitmap = this.N;
                if (bitmap != null && !bitmap.isRecycled()) {
                    this.N.recycle();
                    this.N = null;
                }
            } catch (Throwable unused) {
            }
        }
    }
}
