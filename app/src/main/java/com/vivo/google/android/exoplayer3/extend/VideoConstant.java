package com.vivo.google.android.exoplayer3.extend;

/* loaded from: classes4.dex */
public class VideoConstant {

    public enum PlayerType {
        ANDROID,
        EXO
    }

    public interface Status {
        public static final int COMPLETION = 10;
        public static final int ERROR = 8;
        public static final int INIT = 1;
        public static final int LOADING = 9;
        public static final int PAUSE = 5;
        public static final int PREPARE = 2;
        public static final int RELEASE = 11;
        public static final int RESUME = 6;
        public static final int START = 4;
        public static final int STOP = 7;
    }
}
