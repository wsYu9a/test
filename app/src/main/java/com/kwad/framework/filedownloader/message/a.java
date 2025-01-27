package com.kwad.framework.filedownloader.message;

/* loaded from: classes3.dex */
public interface a {

    /* renamed from: com.kwad.framework.filedownloader.message.a$a */
    public static class C0469a extends MessageSnapshot implements a {
        private final MessageSnapshot aku;

        public C0469a(MessageSnapshot messageSnapshot) {
            super(messageSnapshot.getId());
            if (messageSnapshot.vd() != -3) {
                throw new IllegalArgumentException(com.kwad.framework.filedownloader.f.f.b("can't create the block complete message for id[%d], status[%d]", Integer.valueOf(messageSnapshot.getId()), Byte.valueOf(messageSnapshot.vd())));
            }
            this.aku = messageSnapshot;
        }

        @Override // com.kwad.framework.filedownloader.message.c
        public final byte vd() {
            return (byte) 4;
        }

        @Override // com.kwad.framework.filedownloader.message.a
        public final MessageSnapshot xf() {
            return this.aku;
        }
    }

    MessageSnapshot xf();
}
