package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;
import net.masterthought.cucumber.json.support.Status;
import net.masterthought.cucumber.presentation.PresentationMode;
import net.masterthought.cucumber.sorting.SortingMethod;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = {"steps"},
        features = {"src/test/resources"},
//        features = {"src/test/resources/Features/storyBookMain.feature"},


        //features = {"src\\test\\resources\\Features\\storyBookMain.feature"},

        tags = "@test",
        monochrome = true

)
public class Runner_OLD {


    @RunWith(Cucumber.class)

    @CucumberOptions(features = "src/test/resources/features/", glue = ".steps", plugin = {"pretty",
            "json:target/cucumber-report/cucumber-json-report.json", "html:target/cucumber-report.html"},
            monochrome = true, tags = "@CompareFiles01"
    )

    public class TestRunner {

        @AfterClass
        public static void generateReport() {
            try {
                File reportOutputDirectory = new File("target");

                List<String> jsonFiles = new ArrayList<>();
                jsonFiles.add("-report.json");
                String projectName = "Aris Global Automation Project";

                Configuration configuration = new Configuration(reportOutputDirectory, projectName);
                // configuration.setBuildNumber("1");
                // optional configuration - check javadoc for details
                configuration.addPresentationModes(PresentationMode.RUN_WITH_JENKINS);
                configuration.setNotFailingStatuses(Collections.singleton(Status.SKIPPED));
                configuration.addClassifications("Platform", "Windows");
                configuration.addClassifications("Browser", "Chrome");
                configuration.addClassifications("Branch", "release/1.0");
                configuration.setSortingMethod(SortingMethod.NATURAL);
                configuration.addPresentationModes(PresentationMode.EXPAND_ALL_STEPS);
                configuration.addPresentationModes(PresentationMode.PARALLEL_TESTING);

                List<String> classificationFiles = new ArrayList<>();
                classificationFiles.add("cucumber-reporting.properties");

                configuration.setTrendsStatsFile(new File("target/test-classes/demp-trends.json"));

                ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
                @SuppressWarnings("unused")
                Reportable result = reportBuilder.generateReports();
            } catch (Exception e) {
                e.printStackTrace();

            }
        }

    }
}


