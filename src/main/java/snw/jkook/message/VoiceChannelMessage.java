package snw.jkook.message;

import snw.jkook.entity.channel.VoiceChannel;

/**
 * Represents a message from a voice channel.
 */
public interface VoiceChannelMessage extends ChannelMessage {

    /**
     * Get the channel that contains this message.
     */
    @Override
    VoiceChannel getChannel();

}
