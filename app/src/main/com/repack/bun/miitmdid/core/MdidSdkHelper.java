package com.repack.bun.miitmdid.core;

import android.content.Context;
import android.util.Log;
import androidx.annotation.Keep;
import com.repack.bun.supplier.IIdentifierListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import jk.a;

@Keep
/* loaded from: classes3.dex */
public class MdidSdkHelper {
    public static String TAG = "MdidSdkHelper";

    @Keep
    public static boolean _OuterIsOk = true;

    @Keep
    private String sdk_date = "2020011018";

    @Keep
    public static int InitSdk(Context context, boolean z10, IIdentifierListener iIdentifierListener) {
        try {
            if (!_OuterIsOk) {
                if (iIdentifierListener != null) {
                    iIdentifierListener.OnSupport(false, new a());
                }
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Constructor constructor = MdidSdk.class.getConstructor(Boolean.TYPE);
            if (constructor == null) {
                logd(z10, "not found MdidSdk Constructor");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Object newInstance = constructor.newInstance(Boolean.valueOf(z10));
            if (newInstance == null) {
                logd(z10, "Create MdidSdk Instance failed");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            Method declaredMethod = MdidSdk.class.getDeclaredMethod("InitSdk", Context.class, IIdentifierListener.class);
            if (declaredMethod == null) {
                logd(z10, "not found MdidSdk InitSdk function");
                return ErrorCode.INIT_HELPER_CALL_ERROR;
            }
            int intValue = ((Integer) declaredMethod.invoke(newInstance, context, iIdentifierListener)).intValue();
            logd(z10, "call and retvalue:" + intValue);
            return intValue;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            loge(z10, e10);
            logd(z10, "exception exit");
            return ErrorCode.INIT_HELPER_CALL_ERROR;
        }
    }

    public static void logd(boolean z10, String str) {
        if (z10) {
            Log.d(TAG, str);
        }
    }

    public static void loge(boolean z10, Exception exc) {
        if (z10) {
            Log.e(TAG, exc.getClass().getSimpleName(), exc);
        }
    }
}
