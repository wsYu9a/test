package com.shu.priory.utils;

import android.content.Context;
import android.media.MediaRecorder;
import java.io.File;

/* loaded from: classes3.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    private Context f17320a;

    public n(Context context) {
        this.f17320a = context;
    }

    public boolean a() throws Throwable {
        MediaRecorder mediaRecorder = new MediaRecorder();
        File file = null;
        try {
            try {
                file = File.createTempFile("permission", "test");
                mediaRecorder.setAudioSource(1);
                mediaRecorder.setOutputFormat(3);
                mediaRecorder.setAudioEncoder(1);
                mediaRecorder.setOutputFile(file.getAbsolutePath());
                mediaRecorder.prepare();
                mediaRecorder.start();
                try {
                    mediaRecorder.stop();
                } catch (Exception unused) {
                }
                try {
                    mediaRecorder.release();
                } catch (Exception unused2) {
                }
                if (file.exists()) {
                    file.delete();
                }
                return true;
            } catch (Throwable th2) {
                try {
                    mediaRecorder.stop();
                } catch (Exception unused3) {
                }
                try {
                    mediaRecorder.release();
                } catch (Exception unused4) {
                }
                if (file == null) {
                    throw th2;
                }
                if (!file.exists()) {
                    throw th2;
                }
                file.delete();
                throw th2;
            }
        } catch (Throwable unused5) {
            boolean hasSystemFeature = true ^ this.f17320a.getPackageManager().hasSystemFeature("android.hardware.microphone");
            try {
                mediaRecorder.stop();
            } catch (Exception unused6) {
            }
            try {
                mediaRecorder.release();
            } catch (Exception unused7) {
            }
            if (file != null && file.exists()) {
                file.delete();
            }
            return hasSystemFeature;
        }
    }
}
