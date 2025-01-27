package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes.dex */
public class au extends at {

    /* renamed from: b */
    public static final String f5553b = "logout";

    /* renamed from: c */
    private static final String[] f5554c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    @NonNull
    String a() {
        return f5553b;
    }

    @Override // com.baidu.mobads.sdk.internal.at, com.baidu.mobads.sdk.internal.av.a
    protected void a(int i2, String str, String str2, Throwable th) {
        try {
            IXAdContainerFactory c2 = z.a().c();
            if (c2 != null) {
                c2.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f5554c[i2] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
