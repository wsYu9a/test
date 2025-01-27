package com.kwai.filedownloader.message;

/* loaded from: classes2.dex */
public interface a {

    /* renamed from: com.kwai.filedownloader.message.a$a */
    public static class C0243a extends MessageSnapshot implements a {
        private final MessageSnapshot aIp;

        public C0243a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.Gq() != -3) {
                throw new IllegalArgumentException(com.kwai.filedownloader.e.f.j("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.Gq())));
            }
            this.aIp = messageSnapshot;
        }

        @Override // com.kwai.filedownloader.message.c
        public final byte Gq() {
            return (byte) 4;
        }

        @Override // com.kwai.filedownloader.message.a
        public final MessageSnapshot In() {
            return this.aIp;
        }
    }

    MessageSnapshot In();
}
