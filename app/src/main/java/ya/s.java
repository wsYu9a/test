package ya;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.NonNull;
import com.martian.ads.ad.AdConfig;
import com.martian.apptask.data.AppTask;
import com.martian.apptask.data.AppTaskList;
import com.martian.libmars.common.ConfigSingleton;
import com.martian.mibook.application.MiConfigSingleton;
import com.martian.mibook.mvvm.tts.activity.AudiobookActivity;
import com.martian.mibook.mvvm.utils.SensorHook;
import java.lang.ref.WeakReference;

/* loaded from: classes3.dex */
public class s {

    /* renamed from: a */
    public final WeakReference<AudiobookActivity> f33359a;

    /* renamed from: b */
    public AppTask f33360b;

    /* renamed from: c */
    public final b f33361c;

    /* renamed from: d */
    public final d8.b f33362d = new a();

    public class a extends d8.b {
        public a() {
        }

        @Override // d8.b, d8.a
        public void a() {
            l9.t0.b((Context) s.this.f33359a.get(), ConfigSingleton.D().s("视频加载失败"));
            s.this.i(false);
            s.this.f33361c.onRewardVerify(false);
        }

        @Override // d8.b, d8.a
        public void b(AdConfig adConfig) {
            if (adConfig.isCsjAd() || adConfig.isDxAd()) {
                MiConfigSingleton.b2().H1().y(adConfig);
                SensorHook.INSTANCE.getInstance().enableSensor();
            }
        }

        @Override // d8.b, d8.a
        public void i(AdConfig adConfig, AppTaskList appTaskList) {
            if (appTaskList == null || appTaskList.isEmpty()) {
                a();
                return;
            }
            s.this.f33360b = appTaskList.getApps().get(0);
            MiConfigSingleton.b2().H1().U0((Activity) s.this.f33359a.get(), s.this.f33360b, s.this.f33362d, s.this.f33362d);
            s.this.f33361c.a();
            s.this.i(false);
        }

        @Override // d8.b, d8.a
        public void k(AdConfig adConfig, boolean z10) {
            s.this.f33361c.onRewardVerify(z10);
        }

        @Override // d8.b, d8.a
        public void l(AdConfig adConfig) {
            if (adConfig.isCsjAd() || adConfig.isDxAd()) {
                MiConfigSingleton.b2().H1().x(adConfig);
            }
        }
    }

    public interface b {
        void a();

        void onRewardVerify(boolean z10);
    }

    public s(AudiobookActivity audiobookActivity, @NonNull b bVar) {
        this.f33359a = new WeakReference<>(audiobookActivity);
        this.f33361c = bVar;
    }

    public void g() {
        AppTask appTask = this.f33360b;
        if (appTask != null) {
            appTask.origin = null;
            this.f33360b = null;
        }
    }

    public void h() {
        if (!com.martian.mibook.application.a.z(this.f33360b)) {
            this.f33362d.i(null, new AppTaskList().addAppTask(this.f33360b));
        } else {
            i(true);
            MiConfigSingleton.b2().H1().I0(this.f33359a.get(), false, this.f33362d);
        }
    }

    public final void i(boolean z10) {
        AudiobookActivity audiobookActivity = this.f33359a.get();
        if (audiobookActivity != null) {
            audiobookActivity.g4(z10);
        }
    }
}
