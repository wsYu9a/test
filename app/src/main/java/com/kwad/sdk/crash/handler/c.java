package com.kwad.sdk.crash.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.crash.f;
import com.kwad.sdk.crash.model.message.ExceptionMessage;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.kwai.e;
import java.io.File;
import java.util.concurrent.CountDownLatch;

/* loaded from: classes2.dex */
public final class c extends b {

    static class a {
        private static final c art = new c((byte) 0);
    }

    private c() {
    }

    /* synthetic */ c(byte b2) {
        this();
    }

    /* JADX WARN: Can't wrap try/catch for region: R(16:0|1|2|3|(24:(4:(3:194|195|(13:197|198|6|(6:182|183|184|185|186|187)|(6:170|171|172|173|174|175)|(6:158|159|160|161|162|163)|(6:146|147|148|149|150|151)|15|16|(1:18)|20|21|(5:23|(1:25)|(2:27|(3:29|30|31)(1:34))|35|36)(1:(4:39|(1:41)(1:51)|42|(3:44|45|47)(1:50))(1:52))))|20|21|(0)(0))|170|171|172|173|174|175|(0)|158|159|160|161|162|163|(0)|146|147|148|149|150|151|15|16|(0))|5|6|(0)|182|183|184|185|186|187|(0)|(1:(0))) */
    /* JADX WARN: Can't wrap try/catch for region: R(21:(4:(4:(3:194|195|(13:197|198|6|(6:182|183|184|185|186|187)|(6:170|171|172|173|174|175)|(6:158|159|160|161|162|163)|(6:146|147|148|149|150|151)|15|16|(1:18)|20|21|(5:23|(1:25)|(2:27|(3:29|30|31)(1:34))|35|36)(1:(4:39|(1:41)(1:51)|42|(3:44|45|47)(1:50))(1:52))))|20|21|(0)(0))|15|16|(0))|170|171|172|173|174|175|(0)|158|159|160|161|162|163|(0)|146|147|148|149|150|151) */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x018f, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0190, code lost:
    
        r9 = r9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0193, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0195, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:166:0x0196, code lost:
    
        r8 = r8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x019b, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:177:0x019d, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x019e, code lost:
    
        r7 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:189:0x01a7, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:190:0x01a8, code lost:
    
        r6 = r6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:192:0x01b1, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010b A[Catch: all -> 0x018d, TRY_LEAVE, TryCatch #9 {all -> 0x018d, blocks: (B:16:0x00fd, B:18:0x010b), top: B:15:0x00fd }] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x011c A[Catch: all -> 0x0184, TryCatch #4 {all -> 0x0184, blocks: (B:21:0x0112, B:23:0x011c, B:25:0x012f, B:27:0x0136, B:29:0x0140, B:31:0x014e, B:34:0x0156, B:35:0x0159, B:39:0x0160, B:41:0x0165, B:42:0x016d, B:45:0x017a), top: B:20:0x0112 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x015e  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x01e2 A[Catch: all -> 0x0248, TryCatch #8 {all -> 0x0248, blocks: (B:66:0x01d8, B:68:0x01e2, B:70:0x01f5, B:72:0x01fc, B:74:0x0206, B:76:0x0214, B:79:0x021c, B:80:0x021f, B:83:0x0225, B:85:0x022a, B:86:0x0232, B:89:0x023f), top: B:65:0x01d8 }] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0223  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void a(@androidx.annotation.NonNull java.lang.Throwable r21, @androidx.annotation.NonNull com.kwad.sdk.crash.model.message.ExceptionMessage r22, @androidx.annotation.Nullable android.content.Context r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 711
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.sdk.crash.handler.c.a(java.lang.Throwable, com.kwad.sdk.crash.model.message.ExceptionMessage, android.content.Context, boolean):void");
    }

    public static c zO() {
        return a.art;
    }

    public final void a(@NonNull Throwable th, @NonNull ExceptionMessage exceptionMessage, @Nullable Context context) {
        a(th, exceptionMessage, context, ((e) ServiceProvider.get(e.class)).getIsExternal());
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final int getCrashType() {
        return 1;
    }

    @Override // com.kwad.sdk.crash.handler.b
    public final void init(File file, f fVar, com.kwad.sdk.crash.report.e eVar) {
        super.init(file, fVar, eVar);
        if (com.kwad.sdk.crash.e.zy().isDebug()) {
            b.initBackupDir(new File("sdcard/kwad_ex/java_crash/dump"));
        }
    }

    @Override // com.kwad.sdk.crash.handler.b
    protected final void reportException(@NonNull File[] fileArr, @Nullable CountDownLatch countDownLatch) {
        com.kwad.sdk.crash.report.f fVar = new com.kwad.sdk.crash.report.f();
        fVar.a(getUploader());
        for (File file : fileArr) {
            fVar.a(file, countDownLatch);
        }
    }
}
