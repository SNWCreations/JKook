package snw.jkook.entity.abilities;

import snw.jkook.entity.CustomEmoji;
import snw.jkook.entity.Reaction;

import java.util.Collection;

/**
 * Represents a object that can hold the reactions.
 */
public interface ReactionHolder {

    /**
     * Get the reactions that applied to this object.
     */
    Collection<Reaction> getReactions();

    /**
     * Add a emoji as the reaction to this object.
     *
     * @param emoji The target emoji
     */
    void sendReaction(CustomEmoji emoji);

    /**
     * Remove the reaction that you have applied to this object.
     */
    void removeReactionOnThis();
}
