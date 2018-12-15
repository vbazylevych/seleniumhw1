import org.junit.Test;

import java.util.HashMap;

public class HW11 extends BaseTest {
    @Test
    public void LoginLogout() {
        HashMap<String, String> userCredential = loginAsNewUser();
        logOut();
        reLoginAsUser(userCredential);
        logOut();
    }

}
