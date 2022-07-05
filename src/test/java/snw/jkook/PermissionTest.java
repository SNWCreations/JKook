package snw.jkook;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class PermissionTest {

    @Test
    public void hasPermission() {
        System.out.println("==== Attempting to check Permission value ====");
        for (Permission permission : Permission.values()) {
            if (permission == Permission.ADMIN) continue;
            System.out.println("Attempting to check " + permission);
            assertFalse(Permission.hasPermission(Permission.ADMIN, permission.getValue()));
            System.out.println(permission + " OK");
        }
        System.out.println("====             Checking DONE            ====");
    }
}