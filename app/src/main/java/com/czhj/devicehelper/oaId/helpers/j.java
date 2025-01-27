package com.czhj.devicehelper.oaId.helpers;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.czhj.sdk.logger.SigmobLog;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;

/* loaded from: classes2.dex */
public class j {

    /* renamed from: a */
    public Context f8341a;

    /* renamed from: b */
    public HandlerThread f8342b;

    /* renamed from: c */
    public Handler f8343c;

    /* renamed from: d */
    public boolean f8344d = false;

    /* renamed from: e */
    public String f8345e = null;

    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.what == 11) {
                j.this.a(message.getData().getInt("type"), message.getData().getString("appid"));
            }
        }
    }

    public j(Context context) {
        this.f8341a = context;
    }

    public String b() {
        int columnIndex;
        Cursor query = this.f8341a.getContentResolver().query(Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        String str = null;
        if (query != null) {
            if (query.moveToNext() && (columnIndex = query.getColumnIndex("value")) >= 0) {
                str = query.getString(columnIndex);
            }
            query.close();
        }
        return str;
    }

    public final boolean c() {
        boolean equals = a(i3.b.f26849c, "0").equals("1");
        this.f8344d = equals;
        return equals;
    }

    public String d() {
        a();
        if (!this.f8344d || this.f8345e != null) {
            return null;
        }
        b(0, null);
        return null;
    }

    public final void a() {
        HandlerThread handlerThread = new HandlerThread("SqlWorkThread");
        this.f8342b = handlerThread;
        handlerThread.start();
        this.f8343c = new a(this.f8342b.getLooper());
    }

    public final void b(int i10, String str) {
        Message obtainMessage = this.f8343c.obtainMessage();
        obtainMessage.what = 11;
        Bundle bundle = new Bundle();
        bundle.putInt("type", 0);
        if (i10 == 1 || i10 == 2) {
            bundle.putString("appid", str);
        }
        obtainMessage.setData(bundle);
        this.f8343c.sendMessage(obtainMessage);
    }

    public final String a(int i10, String str) {
        int columnIndex;
        String str2 = null;
        Cursor query = this.f8341a.getContentResolver().query(i10 != 0 ? null : Uri.parse("content://com.vivo.vms.IdProvider/IdentifierId/OAID"), null, null, null, null);
        if (query != null) {
            if (query.moveToNext() && (columnIndex = query.getColumnIndex("value")) >= 0) {
                str2 = query.getString(columnIndex);
            }
            query.close();
        }
        return str2;
    }

    public final String a(String str, String str2) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(MonitorConstants.CONNECT_TYPE_GET, String.class, String.class).invoke(cls, str, str2);
        } catch (Exception e10) {
            SigmobLog.e(e10.getMessage());
            return str2;
        }
    }
}
