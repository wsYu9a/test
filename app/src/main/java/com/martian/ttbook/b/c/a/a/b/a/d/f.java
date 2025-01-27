package com.martian.ttbook.b.c.a.a.b.a.d;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.martian.ttbook.b.c.a.a.b.a.a;
import com.martian.ttbook.b.c.a.a.b.a.c;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public abstract class f extends a implements com.martian.ttbook.b.c.a.a.c.l.d {
    public Map<String, Object> l;

    public f(com.martian.ttbook.b.c.a.a.d.b.d dVar, com.martian.ttbook.b.c.a.a.d.b.e eVar, Map<String, Object> map) {
        super(dVar, eVar);
        HashMap hashMap = new HashMap();
        this.l = hashMap;
        if (map != null) {
            hashMap.putAll(map);
        }
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public Map<String, Object> a() {
        return this.l;
    }

    public void a(int i2, int i3, String str) {
    }

    public void a(View view) {
    }

    public void b() {
    }

    public int c() {
        return 0;
    }

    public void c(c cVar) {
    }

    public com.martian.ttbook.b.c.a.a.c.c d() {
        return null;
    }

    public int e() {
        return 0;
    }

    public int f() {
        return 0;
    }

    public int getAdPatternType() {
        return 0;
    }

    public int getAppStatus() {
        return 0;
    }

    public String getImageUrl() {
        return null;
    }

    public String getVideoCoverImage() {
        return null;
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public int getVideoCurrentPosition() {
        return 0;
    }

    public boolean isAppAd() {
        return false;
    }

    public boolean isVideoAd() {
        return false;
    }

    public void n(@NonNull ViewGroup viewGroup, com.martian.ttbook.b.c.a.a.c.q.a aVar) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public void pauseAppDownload() {
    }

    public void pauseVideo() {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public void resume() {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public void resumeAppDownload() {
    }

    public void resumeVideo() {
    }

    public void sendWinNotification(int i2) {
    }

    @Override // com.martian.ttbook.b.c.a.a.c.l.d
    public void setVideoMute(boolean z) {
    }

    public void startVideo() {
    }

    public void stopVideo() {
    }
}
