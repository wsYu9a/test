package com.opos.process.bridge.provider;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.text.TextUtils;
import com.opos.process.bridge.annotation.IBridgeTargetIdentify;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes4.dex */
public class a {

    /* renamed from: a */
    protected Context f23782a;

    /* renamed from: b */
    protected IBridgeTargetIdentify f23783b;

    /* renamed from: c */
    private AtomicInteger f23784c = new AtomicInteger(-1);

    private boolean a(Context context, Uri uri) {
        int i2 = this.f23784c.get();
        if (i2 < 0) {
            try {
                String c2 = com.opos.cmn.an.h.a.a.c(context.getApplicationContext());
                ProviderInfo resolveContentProvider = context.getApplicationContext().getPackageManager().resolveContentProvider(uri.getAuthority(), 128);
                if (!TextUtils.isEmpty(resolveContentProvider.processName) && resolveContentProvider.processName.equals(c2)) {
                    this.f23784c.compareAndSet(-1, 0);
                    return false;
                }
            } catch (Exception unused) {
            }
            this.f23784c.compareAndSet(-1, 1);
        } else if (i2 != 1) {
            return false;
        }
        return true;
    }

    private Bundle c(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i2, Object... objArr) {
        Uri a2 = a(context);
        if (!a(context, a2)) {
            return ProcessBridgeProvider.dispatch(context, str, iBridgeTargetIdentify, i2, objArr);
        }
        Bundle bundle = new Bundle();
        bundle.setClassLoader(getClass().getClassLoader());
        bundle.putString(ProcessBridgeProvider.KEY_TARGET_CLASS, str);
        if (iBridgeTargetIdentify != null) {
            Parcel obtain = Parcel.obtain();
            obtain.writeParcelable(iBridgeTargetIdentify, 0);
            bundle.putByteArray(ProcessBridgeProvider.KEY_TARGET_IDENTIFY, obtain.marshall());
            obtain.recycle();
        }
        bundle.putInt(ProcessBridgeProvider.KEY_METHOD_ID, i2);
        if (objArr == null) {
            objArr = new Object[0];
        }
        Parcel obtain2 = Parcel.obtain();
        obtain2.writeArray(objArr);
        bundle.putByteArray(ProcessBridgeProvider.KEY_ARGS, obtain2.marshall());
        obtain2.recycle();
        return context.getContentResolver().call(a2, ProcessBridgeProvider.DISPATCH_METHOD, "", bundle);
    }

    protected Uri a(Context context) {
        return ProcessBridgeProvider.getUri(context);
    }

    protected final <T> T a(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i2, Object... objArr) throws b, c {
        Bundle c2 = c(context, str, iBridgeTargetIdentify, i2, objArr);
        c2.setClassLoader(getClass().getClassLoader());
        int i3 = c2.getInt(ProcessBridgeProvider.KEY_RESULT_CODE);
        if (i3 == 0) {
            return (T) c2.get(ProcessBridgeProvider.KEY_RESULT_DATA);
        }
        if (i3 == 2) {
            throw new c((Exception) c2.getSerializable(ProcessBridgeProvider.KEY_RESULT_EXCEPTION));
        }
        throw new b("code:" + i3 + ",msg:" + c2.getString(ProcessBridgeProvider.KEY_RESULT_MSG));
    }

    protected final void b(Context context, String str, IBridgeTargetIdentify iBridgeTargetIdentify, int i2, Object... objArr) throws b, c {
        Bundle c2 = c(context, str, iBridgeTargetIdentify, i2, objArr);
        int i3 = c2.getInt(ProcessBridgeProvider.KEY_RESULT_CODE);
        if (i3 == 0) {
            return;
        }
        if (i3 == 2) {
            throw new c((Exception) c2.getSerializable(ProcessBridgeProvider.KEY_RESULT_EXCEPTION));
        }
        throw new b("code:" + i3 + ",msg:" + c2.getString(ProcessBridgeProvider.KEY_RESULT_MSG));
    }
}
