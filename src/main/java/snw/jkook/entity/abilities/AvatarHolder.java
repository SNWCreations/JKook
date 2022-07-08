package snw.jkook.entity.abilities;

/**
 * Represents an object that can hold an avatar.
 */
public interface AvatarHolder {

    /**
     * Get the avatar url of this object.
     *
     * @param vip True if you want the url of the vip avatar.
     * @return The avatar url. Sometimes, whether true or false is provided, the result may be the same, because the object may not be a VIP.
     */
    String getAvatarUrl(boolean vip);
}
