import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.developers.DevelopsEnumMaps;
import utils.ReadJSON;

public class DevelopersPageTest extends TestBase{
    private ReadJSON jsonFile;
    private final String MARQ_COMMUNITIES_FILE = "developers/marqCommunities.json";
    private final String UPWYDE_DEVELOPMENTS_FILE = "developers/upwydeDevelopments.json";
    private final String AFFIX_DEVELOPMENT_FILE = "developers/ICapitalDevelopments.json";

    @Test
    public void marqCommunitiesTest(){
        jsonFile = new ReadJSON(MARQ_COMMUNITIES_FILE);

        Assertions.assertThat(
        homePage.clickDevelopersBtn()
                .pickDeveloper(DevelopsEnumMaps.Developers.MARQ_COMMUNITIES)
                .developersProjects())
                    .contains(jsonFile.readJsonString("project1"))
                    .contains(jsonFile.readJsonString("project2"))
                    .contains(jsonFile.readJsonString("project3"))
                    .contains(jsonFile.readJsonString("project4"))
                    .contains(jsonFile.readJsonString("project5"));

    }

    @Test
    public void upwydeDevelopmentTest(){
        jsonFile = new ReadJSON(UPWYDE_DEVELOPMENTS_FILE);

        Assertions.assertThat(
                homePage.clickDevelopersBtn()
                        .pickDeveloper(DevelopsEnumMaps.Developers.UPWYDE_DEVELOPMENTS)
                        .developersProjects())
                            .contains(jsonFile.readJsonString("project1"))
                            .contains(jsonFile.readJsonString("project2"))
                            .contains(jsonFile.readJsonString("project3"))
                            .contains(jsonFile.readJsonString("project4"))
                            .contains(jsonFile.readJsonString("project5"))
                            .contains(jsonFile.readJsonString("project6"))
                            .contains(jsonFile.readJsonString("project7"))
                            .contains(jsonFile.readJsonString("title"));

    }

    @Test
    public void affixDevelopmentTest(){
        jsonFile = new ReadJSON(AFFIX_DEVELOPMENT_FILE);
        Assertions.assertThat(
                homePage.clickDevelopersBtn()
                        .pickDeveloper(DevelopsEnumMaps.Developers.ICAPITAL_DEVELOPMENTS)
                        .developersProjects())
                            .contains(jsonFile.readJsonString("project1"))
                            .contains(jsonFile.readJsonString("title"));
    }
}
