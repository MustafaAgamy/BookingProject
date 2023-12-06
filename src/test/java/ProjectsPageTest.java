import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pages.projects.ProjectsEnumMaps;
import utils.ReadJSON;

public class ProjectsPageTest extends TestBase{
    private ReadJSON jsonFile;
    private final String THREE_POINTS_FILE = "projects/3Points.json";
    private final String WONDER_MOSTAKBAL_FILE = "projects/wonderMostkbal.json";
    private final String THE_BUSINESS_LOUNGE_FILE = "projects/theBusinessLounge.json";

    @Test
    public void wonderMostakbalProject(){
        jsonFile = new ReadJSON(WONDER_MOSTAKBAL_FILE);
        Assertions.assertThat(
                homePage.clickProjectsBtn()
                .pickProject(ProjectsEnumMaps.ProjectsNames.WONDER_MOSTAKBAL)
                .navigateToProjectPage(ProjectsEnumMaps.ProjectsNames.WONDER_MOSTAKBAL)
                .projectDetailsMap())
                    .containsEntry("title",jsonFile.readJsonString("title"))
                    .containsEntry("startingFrom",jsonFile.readJsonInt("startingFrom"))
                    .containsEntry("minDownPayment",jsonFile.readJsonInt("minDownPayment"))
                    .containsEntry("minMonthlyPayment",jsonFile.readJsonInt("minMonthlyPayment"))
                    .containsEntry("deliveryInfo",jsonFile.readJsonString("deliveryInfo"))
                    .containsEntry("paymentOptionInfo",jsonFile.readJsonString("paymentOptionInfo"));
    }

    @Test
    public void threePointsProject() {
        jsonFile = new ReadJSON(THREE_POINTS_FILE);
        Assertions.assertThat(
        homePage.clickProjectsBtn()
                .pickProject(ProjectsEnumMaps.ProjectsNames.THREE_POINTS)
                .navigateToProjectPage(ProjectsEnumMaps.ProjectsNames.THREE_POINTS)
                .projectDetailsMap())
                    .containsEntry("title",jsonFile.readJsonString("title"))
                    .containsEntry("startingFrom",jsonFile.readJsonInt("startingFrom"))
                    .containsEntry("minDownPayment",jsonFile.readJsonInt("minDownPayment"))
                    .containsEntry("minMonthlyPayment",jsonFile.readJsonInt("minMonthlyPayment"))
                    .containsEntry("deliveryInfo",jsonFile.readJsonString("deliveryInfo"))
                    .containsEntry("paymentOptionInfo",jsonFile.readJsonString("paymentOptionInfo"))
                    .containsEntry("maintenanceFeesInfo",jsonFile.readJsonString("maintenanceFeesInfo"));

    }


    @Test
    public void TheBusinessLoungeProject() {
        jsonFile = new ReadJSON(THE_BUSINESS_LOUNGE_FILE);
        Assertions.assertThat(
                        homePage.clickProjectsBtn()
                                .pickProject(ProjectsEnumMaps.ProjectsNames.THE_BUSINESS_LOUNGE)
                                .navigateToProjectPage(ProjectsEnumMaps.ProjectsNames.THE_BUSINESS_LOUNGE)
                                .projectDetailsMap())
                .containsEntry("title",jsonFile.readJsonString("title"))
                .containsEntry("startingFrom",jsonFile.readJsonInt("startingFrom"))
                .containsEntry("minDownPayment",jsonFile.readJsonInt("minDownPayment"))
                .containsEntry("minMonthlyPayment",jsonFile.readJsonInt("minMonthlyPayment"))
                .containsEntry("deliveryInfo",jsonFile.readJsonString("deliveryInfo"))
                .containsEntry("paymentOptionInfo",jsonFile.readJsonString("paymentOptionInfo"))
                .containsEntry("maintenanceFeesInfo",jsonFile.readJsonString("maintenanceFeesInfo"));

    }
}

