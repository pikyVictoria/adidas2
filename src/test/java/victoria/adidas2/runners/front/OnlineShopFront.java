package victoria.adidas2.runners.front;

import com.privalia.qa.utils.BaseGTest;
import io.cucumber.testng.CucumberOptions;


/**
 * This is the runner class responsible of running the included *.feature files in the project.
 * Glue files can be specified in the {@link CucumberOptions} annotation
 *
 * Here you can also create your own TestNG hooks or even configure parallel tests execution.
 * For more info on these topics check:
 * https://testng.org/doc/documentation-main.html#annotations
 * https://cucumber.io/docs/guides/parallel-execution/#testng
 */
@CucumberOptions(plugin = {
                "json:target/OnlineShopFront.json",
                "html:target/OnlineShopFront.html",
                "junit:target/OnlineShopFront.xml"
        }, features =
        {
                "src/test/resources/features/front/online_shop_front.feature"
        },
        glue = "classpath:victoria.adidas2.glue")
public class OnlineShopFront extends BaseGTest {


}
