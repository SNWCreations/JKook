package snw.jkook.message.component.card.module;

import org.apache.commons.lang.Validate;
import snw.jkook.message.component.FileComponent;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a group of image components.
 */
public class ImageGroupModule extends BaseModule {
    private final List<FileComponent> images;

    public ImageGroupModule(List<FileComponent> images) {
        Validate.isTrue(images.size() >= 1, "Unexpected image module count, expected >= 1, got " + images.size());
        Validate.isTrue(images.size() <= 9, "Unexpected image module count, expected <= 9, got " + images.size());
        Validate.isTrue(images.stream().allMatch(IT -> IT.getType() == FileComponent.Type.IMAGE), "The container only contains the image files.");
        this.images = Collections.unmodifiableList(new LinkedList<>(images));
    }

    /**
     * Get the images that already stored in this module.
     */
    public List<FileComponent> getImages() {
        return images;
    }
}
