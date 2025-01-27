package com.baidu.mobads.sdk.internal;

import androidx.annotation.NonNull;
import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IXAdContainerFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public class ax extends aw {

    /* renamed from: b */
    public static final String f6807b = "logout";

    /* renamed from: c */
    private static final String[] f6808c = {"#", "#", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "D", "I", ExifInterface.LONGITUDE_WEST, ExifInterface.LONGITUDE_EAST, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS};

    @Override // com.baidu.mobads.sdk.internal.aw, com.baidu.mobads.sdk.internal.ay.a
    @NonNull
    public String a() {
        return f6807b;
    }

    @Override // com.baidu.mobads.sdk.internal.aw, com.baidu.mobads.sdk.internal.ay.a
    public void a(int i10, String str, String str2, Throwable th2) {
        try {
            IXAdContainerFactory c10 = aa.a().c();
            if (c10 != null) {
                c10.getRemoteParam("debugLogout", (new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS", Locale.getDefault()).format(new Date()) + " " + f6808c[i10] + "/" + str + ": ") + "当前线程：" + Thread.currentThread().getName() + ";  调用位置：" + c() + ";  打印消息：" + str2 + "\n");
            }
        } catch (Throwable unused) {
        }
    }
}
