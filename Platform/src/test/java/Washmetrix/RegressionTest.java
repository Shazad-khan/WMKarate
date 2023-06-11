package Washmetrix;

import com.intuit.karate.Results;
import com.intuit.karate.Runner;

import static org.junit.jupiter.api.Assertions.*;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class ExamplesTest {


    @Test
    public void testParallel() {
        Runner.Builder path = Runner.path("classpath:Washmetrix");
        path.outputCucumberJson(true);
        Results results = path
                .parallel(5);
        generateReport(results.getReportDir());
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }

    public static void generateReport(String karateOutputPath) {
        Collection<File> jsonFiles = FileUtils.listFiles(new File(karateOutputPath), new String[] {"json"}, true);
        List<String> jsonPaths = new ArrayList<>(jsonFiles.size());
        jsonFiles.forEach(file -> jsonPaths.add(file.getAbsolutePath()));
        Configuration config = new Configuration( new File("target"), "Platform");
        ReportBuilder reportBuilder = new ReportBuilder(jsonPaths, config);
        reportBuilder.generateReports();
    }
}
