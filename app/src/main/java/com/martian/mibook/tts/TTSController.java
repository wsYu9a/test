package com.martian.mibook.tts;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import com.martian.libsupport.k;
import com.martian.libsupport.l;
import com.ss.android.socialbase.downloader.utils.DownloadExpSwitchCode;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: classes4.dex */
public class TTSController implements TextToSpeech.OnInitListener {

    /* renamed from: a */
    public static final int f14119a = 5873;

    /* renamed from: b */
    protected TtsStatus f14120b;

    /* renamed from: c */
    private TextToSpeech f14121c;

    /* renamed from: f */
    private b f14124f;

    /* renamed from: g */
    private List<Integer> f14125g;

    /* renamed from: h */
    private String f14126h;

    /* renamed from: i */
    private boolean f14127i = false;

    /* renamed from: j */
    private int f14128j = 0;

    /* renamed from: d */
    private int f14122d = -1;

    /* renamed from: e */
    private final Locale f14123e = Locale.CHINA;

    private enum TtsStatus {
        SS_STOP,
        SS_START,
        SS_PAUSE
    }

    class a extends UtteranceProgressListener {
        a() {
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onDone(String utteranceId) {
            if (TTSController.this.f14127i) {
                TTSController.this.f14127i = false;
            } else {
                if (TTSController.this.f14128j != TTSController.this.f14125g.size() - 1 || TTSController.this.f14124f == null) {
                    return;
                }
                TTSController.this.f14124f.c(true);
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onError(String utteranceId) {
            if (TTSController.this.f14124f != null) {
                TTSController.this.f14124f.b();
            }
        }

        @Override // android.speech.tts.UtteranceProgressListener
        public void onStart(String utteranceId) {
            TTSController.this.f14128j = Integer.parseInt(utteranceId);
            if (TTSController.this.f14128j + 1 < TTSController.this.f14125g.size()) {
                TTSController tTSController = TTSController.this;
                tTSController.w(tTSController.j(tTSController.f14128j + 1), TTSController.this.f14128j + 1);
            }
        }
    }

    public interface b {
        void a();

        void b();

        void c(boolean moveForwardWhenEmpty);

        void d();
    }

    public TTSController(Context context, b ttsActionListener) {
        this.f14124f = ttsActionListener;
        try {
            this.f14121c = new TextToSpeech(context, this);
        } catch (Exception unused) {
            b bVar = this.f14124f;
            if (bVar != null) {
                bVar.d();
            }
        }
    }

    public static void i(Activity activity) {
        try {
            Intent intent = new Intent();
            intent.setAction("android.speech.tts.engine.CHECK_TTS_DATA");
            activity.startActivityForResult(intent, f14119a);
        } catch (Exception unused) {
        }
    }

    public String j(int index) {
        List<Integer> list = this.f14125g;
        if (list == null) {
            return "";
        }
        return this.f14126h.substring(index == 0 ? 0 : list.get(index - 1).intValue(), this.f14125g.get(index).intValue());
    }

    /* renamed from: o */
    public /* synthetic */ void p(String s) {
        if (this.f14127i) {
            this.f14127i = false;
            return;
        }
        b bVar = this.f14124f;
        if (bVar != null) {
            bVar.c(true);
        }
    }

    private boolean s() {
        if (l.l()) {
            if (w(j(this.f14128j), this.f14128j)) {
                this.f14120b = TtsStatus.SS_START;
                return true;
            }
        } else if (w(this.f14126h, 0)) {
            this.f14120b = TtsStatus.SS_START;
            return true;
        }
        return false;
    }

    private boolean v(String text, int queueFlag, int id) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("utteranceId", "" + id);
        return this.f14121c.speak(text, queueFlag, hashMap) == 0;
    }

    public boolean w(String text, int id) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("utteranceId", "" + id);
        return this.f14121c.speak(text, 1, hashMap) == 0;
    }

    public boolean k() {
        return this.f14122d == -1 || this.f14121c == null;
    }

    public boolean l() {
        return this.f14122d == 0 && this.f14121c != null;
    }

    public boolean m() {
        return l() && this.f14121c.isSpeaking();
    }

    public boolean n() {
        return this.f14120b == TtsStatus.SS_START;
    }

    @Override // android.speech.tts.TextToSpeech.OnInitListener
    public void onInit(int status) {
        this.f14122d = status;
        if (l()) {
            if (this.f14121c.isLanguageAvailable(this.f14123e) < 0) {
                b bVar = this.f14124f;
                if (bVar != null) {
                    bVar.b();
                }
                this.f14122d = -1;
                this.f14121c.shutdown();
                return;
            }
            if (l.l()) {
                this.f14121c.setOnUtteranceProgressListener(new a());
            } else {
                this.f14121c.setOnUtteranceCompletedListener(new TextToSpeech.OnUtteranceCompletedListener() { // from class: com.martian.mibook.tts.a
                    @Override // android.speech.tts.TextToSpeech.OnUtteranceCompletedListener
                    public final void onUtteranceCompleted(String str) {
                        TTSController.this.p(str);
                    }
                });
            }
            b bVar2 = this.f14124f;
            if (bVar2 != null) {
                bVar2.a();
            }
        }
    }

    public boolean q() {
        TtsStatus ttsStatus = this.f14120b;
        TtsStatus ttsStatus2 = TtsStatus.SS_PAUSE;
        if (ttsStatus != ttsStatus2 && l()) {
            this.f14127i = true;
            if (this.f14121c.stop() == 0) {
                this.f14120b = ttsStatus2;
                return true;
            }
        }
        return false;
    }

    public boolean r() {
        TtsStatus ttsStatus = this.f14120b;
        return (ttsStatus == TtsStatus.SS_PAUSE || ttsStatus == TtsStatus.SS_STOP) && l() && s();
    }

    public void t(int speed) {
        if (l()) {
            this.f14121c.setSpeechRate(speed / 100.0f);
        }
    }

    public void u() {
        TextToSpeech textToSpeech = this.f14121c;
        if (textToSpeech != null) {
            textToSpeech.shutdown();
            this.f14121c = null;
        }
    }

    public boolean x(String pageContent, boolean moveForwardWhenEmpty) {
        if (!l()) {
            return false;
        }
        if (k.p(pageContent)) {
            b bVar = this.f14124f;
            if (bVar != null) {
                bVar.c(moveForwardWhenEmpty);
            }
            return false;
        }
        this.f14126h = pageContent;
        this.f14125g = k.u(pageContent);
        this.f14128j = 0;
        s();
        return true;
    }

    public boolean y(Context context) {
        try {
            Intent intent = new Intent("com.android.settings.TTS_SETTINGS");
            intent.setFlags(DownloadExpSwitchCode.BUGFIX_GETPACKAGEINFO_BY_UNZIP);
            context.startActivity(intent);
            return true;
        } catch (ActivityNotFoundException unused) {
            return false;
        }
    }

    public boolean z() {
        TtsStatus ttsStatus = this.f14120b;
        TtsStatus ttsStatus2 = TtsStatus.SS_STOP;
        if (ttsStatus != ttsStatus2 && l()) {
            this.f14128j = 0;
            this.f14127i = true;
            if (this.f14121c.stop() == 0) {
                this.f14120b = ttsStatus2;
                return true;
            }
        }
        return false;
    }
}
