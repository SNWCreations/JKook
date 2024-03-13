package snw.jkook.util;

public interface Meta {

    /**
     * Get the current page number.
     */
    int getPage();

    /**
     * Get the total number of pages.
     */
    int getPageTotal();

    /**
     * Get the size of this page.
     */
    int getPageSize();

    /**
     * Get the total item number of this api.
     * Not only the total number of items in this page.
     */
    int getTotal();

}
