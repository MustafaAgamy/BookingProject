import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import utils.ReadJSON;

public class SignInTest extends TestBase{

    private ReadJSON jsonFile;
    private final String SIGN_IN_FILE = "signIn/data.json";

    @Test
    public void sign_In_Test(){
        jsonFile = new ReadJSON(SIGN_IN_FILE);
        Assertions.assertThat(
            homePage.clickSignInBtn()
                    .login(
                        jsonFile.readJsonString("email"),
                        jsonFile.readJsonString("password"))
                    .getSuccessfulLoginMsg())
                            .contains("Authenticated");
    }
}
