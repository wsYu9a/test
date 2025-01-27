package com.kwad.sdk.crash.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.crash.model.message.AnrExceptionMessage;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public final class b extends d {
    /* JADX WARN: Removed duplicated region for block: B:30:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(com.kwad.sdk.crash.model.message.AnrExceptionMessage r10, java.io.File r11) {
        /*
            Method dump skipped, instructions count: 273
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.report.b.a(com.kwad.sdk.crash.model.message.AnrExceptionMessage, java.io.File):void");
    }

    private String dQ(String str) {
        File file = new File(str + ".anr");
        String str2 = "";
        if (file.exists()) {
            try {
                str2 = q.Q(file);
            } catch (IOException e2) {
                this.mErrorMessage += e2 + "\n";
            }
            q.N(file);
        }
        return str2;
    }

    private static boolean dR(@NonNull String str) {
        for (String str2 : com.kwad.sdk.crash.e.zy().zz()) {
            if (str.contains(str2)) {
                com.kwad.sdk.core.d.b.d("AnrReporter", " tag=" + str2);
                return true;
            }
        }
        return false;
    }

    private AnrExceptionMessage w(File file) {
        String str;
        try {
            str = q.Q(file);
        } catch (IOException e2) {
            this.mErrorMessage += e2 + "\n";
            str = null;
        }
        AnrExceptionMessage anrExceptionMessage = new AnrExceptionMessage();
        if (str != null) {
            try {
                anrExceptionMessage.parseJson(new JSONObject(str));
            } catch (Exception e3) {
                this.mErrorMessage += e3 + "\n";
            }
        }
        q.N(file);
        return anrExceptionMessage;
    }

    @Override // com.kwad.sdk.crash.report.d
    protected final ExceptionMessage a(@NonNull File file, File file2, File file3, String str) {
        com.kwad.sdk.core.d.b.d("AnrReporter", "AnrReporter parseExceptionInfo basePath=" + str);
        AnrExceptionMessage w = w(file2);
        try {
            w.mReason = dQ(str);
            a(w, file);
            b(file3, w);
            com.kwad.sdk.crash.utils.g.a(file, (CharSequence) w.toString(), true);
            com.kwad.sdk.crash.utils.g.b(file3, file);
            file.renameTo(file3);
            new StringBuilder("------ ANR Report Begin ------\n").append(w);
            w.mDumpsys = q.Q(new File(str + ".minfo"));
        } catch (Exception e2) {
            com.kwad.sdk.core.d.b.printStackTraceOnly(e2);
            this.mErrorMessage += e2 + "\n";
        }
        if (!TextUtils.isEmpty(this.mErrorMessage)) {
            w.mErrorMessage += this.mErrorMessage;
        }
        return w;
    }
}
