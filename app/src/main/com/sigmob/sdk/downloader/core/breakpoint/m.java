package com.sigmob.sdk.downloader.core.breakpoint;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* loaded from: classes4.dex */
public class m implements Handler.Callback {

    /* renamed from: d */
    public static final String f19068d = "RemitSyncExecutor";

    /* renamed from: e */
    public static final int f19069e = 0;

    /* renamed from: f */
    public static final int f19070f = -1;

    /* renamed from: g */
    public static final int f19071g = -2;

    /* renamed from: h */
    public static final int f19072h = -3;

    /* renamed from: a */
    public final Handler f19073a;

    /* renamed from: b */
    public final Set<Integer> f19074b;

    /* renamed from: c */
    public final a f19075c;

    public interface a {
        void a(List<Integer> list) throws IOException;

        void d(int i10);

        void f(int i10) throws IOException;
    }

    public m(a aVar) {
        this.f19075c = aVar;
        this.f19074b = new HashSet();
        HandlerThread handlerThread = new HandlerThread("FileDownload RemitHandoverToDB");
        handlerThread.start();
        this.f19073a = new Handler(handlerThread.getLooper(), this);
    }

    public boolean a(int i10) {
        return this.f19074b.contains(Integer.valueOf(i10));
    }

    public void b(int i10) {
        Message obtainMessage = this.f19073a.obtainMessage(-2);
        obtainMessage.arg1 = i10;
        this.f19073a.sendMessage(obtainMessage);
    }

    public void c(int i10) {
        Message obtainMessage = this.f19073a.obtainMessage(-3);
        obtainMessage.arg1 = i10;
        this.f19073a.sendMessage(obtainMessage);
    }

    public void d(int i10) {
        this.f19073a.sendEmptyMessage(i10);
    }

    public void e(int i10) {
        this.f19073a.removeMessages(i10);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        int i10;
        StringBuilder sb2;
        String str;
        String str2;
        int i11 = message.what;
        if (i11 == -3) {
            i10 = message.arg1;
            this.f19074b.remove(Integer.valueOf(i10));
            this.f19075c.d(i10);
            sb2 = new StringBuilder();
            str = "remove info ";
        } else {
            if (i11 != -2) {
                if (i11 == -1) {
                    List list = (List) message.obj;
                    this.f19074b.removeAll(list);
                    sb2 = new StringBuilder();
                    sb2.append("remove free bunch ids ");
                    sb2.append(list);
                    com.sigmob.sdk.downloader.core.c.a(f19068d, sb2.toString());
                    return true;
                }
                if (i11 != 0) {
                    try {
                        this.f19075c.f(i11);
                        this.f19074b.add(Integer.valueOf(i11));
                        com.sigmob.sdk.downloader.core.c.a(f19068d, "sync info with id: " + i11);
                        return true;
                    } catch (IOException unused) {
                        str2 = "sync cache to db failed for id: " + i11;
                    }
                } else {
                    List<Integer> list2 = (List) message.obj;
                    try {
                        this.f19075c.a(list2);
                        this.f19074b.addAll(list2);
                        com.sigmob.sdk.downloader.core.c.a(f19068d, "sync bunch info with ids: " + list2);
                        return true;
                    } catch (IOException unused2) {
                        str2 = "sync info to db failed for ids: " + list2;
                    }
                }
                com.sigmob.sdk.downloader.core.c.c(f19068d, str2);
                return true;
            }
            i10 = message.arg1;
            this.f19074b.remove(Integer.valueOf(i10));
            sb2 = new StringBuilder();
            str = "remove free bunch id ";
        }
        sb2.append(str);
        sb2.append(i10);
        com.sigmob.sdk.downloader.core.c.a(f19068d, sb2.toString());
        return true;
    }

    public m(a aVar, Handler handler, Set<Integer> set) {
        this.f19075c = aVar;
        this.f19073a = handler;
        this.f19074b = set;
    }

    public void a(List<Integer> list) {
        Message obtainMessage = this.f19073a.obtainMessage(-1);
        obtainMessage.obj = list;
        this.f19073a.sendMessage(obtainMessage);
    }

    public void b(List<Integer> list) {
        Message obtainMessage = this.f19073a.obtainMessage(0);
        obtainMessage.obj = list;
        this.f19073a.sendMessage(obtainMessage);
    }

    public void a(int i10, long j10) {
        this.f19073a.sendEmptyMessageDelayed(i10, j10);
    }

    public void a(int[] iArr) {
        for (int i10 : iArr) {
            this.f19073a.removeMessages(i10);
        }
    }

    public void a() {
        this.f19073a.getLooper().quit();
    }
}
