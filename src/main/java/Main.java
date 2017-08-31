import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Main {

    public static void main (String[] args) throws InterruptedException, FileNotFoundException {

        //Clear Console
        System.setProperty("webdriver.chrome.silentOutput", "true");

        //Create an instance of webdriver (ChromeDriver)
        String OS_EXTENSION = (System.getProperty("os.name").toLowerCase().contains("win")) ? ".exe" : "_mac";
        String DRIVER_PATH = "drivers/chromedriver" + OS_EXTENSION;
        System.setProperty("webdriver.chrome.driver", DRIVER_PATH);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigating to Salesforce instance
        driver.navigate().to("https://test.salesforce.com");

        // Logging in to Salesforce
        driver.findElement(By.id("username")).sendKeys("apolloit.offshoretrad@gmail.com.qa");
        driver.findElement(By.id("password")).sendKeys("Apollo4000");
        driver.findElement(By.id("Login")).click();
        Thread.sleep(1000);

        //Entering a student creation cycle
        boolean exitLoop = false;
        while (!exitLoop) {
            //----------------------------------------------------------------------------------------------------------------------------------------ACCOUNT SECTION
            //Randomizing a gender
            String [] equality = {"Male", "Female"};
            int random = new Random().nextInt(equality.length);

            String name;
            if (random == 1) {

                //Randomizing a Female student First name
                String [] namegen = {"TORA", "TEMPLE", "MISSY" ,"KAYE", "LUCI", "ETHELENE", "KATHLYN", "WILLENA", "SHIRELY", "SUSANNE", "HILLARY", "VALERIE", "PIEDAD", "CHRISTIE",
                        "MELDA", "BETTE", "ZELMA", "MARLA", "DORLA", "ALEC", "ELANOR", "ALEX", "OLINDA", "ALEXIS", "MARGUERITA", "DULCE", "LASHANDRA", "MISTIE", "NIKIA", "ROXIE",
                        "ROXANNA", "DEBORAH", "JOI", "LORRINE", "JACQUI", "SAGE", "ALVA", "SHERLY", "FIDELA", "DORETTA", "TRESA", "TOBI", "AUGUSTA", "SHERIKA", "MEGAN", "ANDREAS",
                        "SIMA", "SADIE", "OLETA", "ANGEL", "ORA", "GISELA", "DYAN", "HEDWIG", "LAJUANA", "MARI", "MARIA", "SAKURA", "SHINO", "DIANA", "OSHINO",
                        "TENA", "FE", "ARIEL", "JOLENE", "ARLIE", "DANIKA", "CONSUELO", "ESPERANZA", "SHARLEEN", "CATHERIN", "REBA", "DANICA", "ART", "VI", "BONG", "ASA", "ASHLEY",
                        "AUBREY", "KRYSTYNA", "AUGUSTINE", "KIRSTEN", "EVA", "WILLENA", "AVERY", "SHEA", "TA", "KATHARINE", "MALIKA", "EDEN", "MOZELLE", "BEAU", "JANA", "CHARLEEN",
                        "SIGRID", "ANNMARIE", "ANN", "BRIANA", "LUE", "ROBBYN", "NIDIA", "RAISA", "LAVONE", "BERRY", "PHYLLIS", "NICHOL", "HILDRED", "ZELDA", "LORALEE", "BLAINE",
                        "BLAIR", "BLAKE", "BO", "CARMELIA", "SHANTAE", "NAIDA", "GENOVEVA", "JASMINE", "FELICIA", "JENAE", "JULIANN", "MAURA", "SIRENA", "DELORIS", "FRANCENE", "JANE",
                        "BETTIE", "PENNY", "LAVONNE", "LUCINDA", "ROSANNE", "PEI", "CECELIA", "HUONG", "YESSENIA", "RONNA", "NGUYET", "TERRESA", "MELISSIA", "DONNETTE", "STEPHAINE",
                        "ADA", "BRYANT", "BRYCE", "BRYON", "BUCK", "BUD", "BUDDY", "BUFORD", "BURL", "BURT", "BURTON", "BUSTER", "BYRON", "CALEB", "CALVIN", "CAMERON", "CAREY",
                        "AI", "AIKO", "AKANE", "AMANE", "ANZU", "MIU", "KONOMI", "MADOKA", "MAAYA", "KAWAI", "MINAE", "MEGUMI", "MAYUMI", "HONOKA", "HONAMI", "CHINATSU",
                        "YUI", "RIO", "YUNA", "KOHARU", "CHANCE", "HINA", "KOKONA", "NANAMI", "SARA", "RISA", "KANON", "SUZUKI", "SAKI", "SHIORI", "CHI", "NATSUKI",
                        "CHRIS", "FLORRIE", "CLARISA", "MITTIE", "MONIKA", "JONE", "CLAIR", "CLARENCE", "LUCRETIA", "IRMGARD", "JUDY", "LOREAN", "TATIANA", "ALMEDA", "CHERY",
                        "CLEMENTINE", "CLEO", "MAYRA", "LEEANNE", "MEAGHAN", "MORRIGAN", "MIRIAN", "PHOEBE", "CONSUELA", "BRIANA", "CODY", "HYUN", "COLE", "MAXINE", "COLIN", "EUNICE",
                        "GENA", "CHASITY", "CONNIE", "DEANDRA", "EDNA", "COREY", "SCARLET", "SHAVON", "EMILIA", "CORY", "SHAVON", "PATSY", "MISSY", "SORAYA", "VALENTINA",
                        "SIMONA", "ELEANORE", "ARLENA", "ESTHER", "SHAUNTE", "KIA", "EDWINA", "FERNE", "ESTELA", "DANELLE", "ALEXA", "ALEXSTRAZA", "DENYSE", "DANA", "LOISE", "LESLEE",
                        "WINONA", "DANNIE", "DANNY", "DANTE", "JACKQUELINE", "MARGO", "JENNIE", "JACQUI", "IRENE", "INGA", "KERRI", "CORDIE", "ELOUISE", "DORIE", "TATUM", "DEVORAH",
                        "APRIL", "KAMILAH", "BIRGIT", "CORINA", "LINDA", "ZANA", "TAMATHA", "TERINA",  "DEANDRE", "CARLEE", "DEE", "DEL", "CHING", "TONA", "LASHANDA", "SUE",
                        "CHAROLETTE", "ALYSHA", "MARYJANE", "WAI", "EVELINA", "DEON", "LEESA", "ODA", "WINTER", "SUMMER", "FALL", "BRITTNEY", "ZONIA", "KEITHA", "GLENDORA", "KARI",
                        "MITTIE", "GABRIELE", "GABRIELLA", "GABI", "OLYMPIA", "ATHENA", "OLGA", "LIZBETH", "LIZ", "THI", "MAPLE", "SADIE", "MEG", "KRISTYN", "TORIE", "GIUSEPPINA",
                        "LORRAINE", "DONNIE", "MALLIE", "ZOE", "TRULA", "MIN", "CARITA", "ERNA", "PRECIOUS", "ELYSE", "ELIZE", "KRYSTA", "AMELI", "ALBERTINA", "SALLY", "HILMA",
                        "MA", "LALA", "ELSA", "FRIDA", "BROOKE"};
                Random ran = new Random();
                name = namegen[ran.nextInt(namegen.length)];
            }
            else {

                //Randomizing a Male student First Name
                String[] namegen = {"AARON", "ABDUL", "ABE" ,"ABEL", "ABRAHAM", "ABRAM", "ADALBERTO", "ADAM", "ADAN", "ADOLFO", "ADOLPH", "ADRIAN", "AGUSTIN", "AHMAD", "AHMED", "AL",
                        "ALAN", "ALBERT", "ALBERTO", "ALDEN", "ALDO", "ALEC", "ALEJANDRO", "ALEX", "ALEXANDER", "ALEXIS", "ALFONSO", "ALFONZO", "ALFRED", "ALFREDO", "ALI", "ALLAN",
                        "ALLEN", "ALONSO", "ALONZO", "ALPHONSE", "ALPHONSO", "ALTON", "ALVA", "ALVARO", "ALVIN", "AMADO", "AMBROSE", "AMOS", "ANDERSON", "ANDRE", "ANDREA", "ANDREAS",
                        "ANDRES", "ANDREW", "ANDY", "ANGEL", "ANGELO", "ANIBAL", "ANTHONY", "ANTIONE", "ANTOINE", "ANTON", "ANTONE", "ANTONIA", "ANTONIO", "ANTONY", "ANTWAN",
                        "ARCHIE", "ARDEN", "ARIEL", "ARLEN", "ARLIE", "ARMAND", "ARMANDO", "ARNOLD", "ARNOLDO", "ARNULFO", "ARON", "ARRON", "ART", "ARTHUR", "ARTURO", "ASA", "ASHLEY",
                        "AUBREY", "AUGUST", "AUGUSTINE", "AUGUSTUS", "AURELIO", "AUSTIN", "AVERY", "BARNEY", "BARRETT", "BARRY", "BART", "BARTON", "BASIL", "BEAU", "BEN", "BENEDICT",
                        "BENITO", "BENJAMIN", "BENNETT", "BENNIE", "BENNY", "BENTON", "BERNARD", "BERNARDO", "BERNIE", "BERRY", "BERT", "BERTRAM", "BILL", "BILLIE", "BILLY", "BLAINE",
                        "BLAIR", "BLAKE", "BO", "BOB", "BOBBIE", "BOBBY", "BOOKER", "BORIS", "BOYCE", "BOYD", "BRAD", "BRADFORD", "BRADLEY", "BRADLY", "BRADY", "BRAIN", "BRANDEN",
                        "BRANDON", "BRANT", "BRENDAN", "BRENDON", "BRENT", "BRENTON", "BRET", "BRETT", "BRIAN", "BRICE", "BRITT", "BROCK", "BRODERICK", "BROOKS", "BRUCE", "BRUNO",
                        "BRYAN", "BRYANT", "BRYCE", "BRYON", "BUCK", "BUD", "BUDDY", "BUFORD", "BURL", "BURT", "BURTON", "BUSTER", "BYRON", "CALEB", "CALVIN", "CAMERON", "CAREY",
                        "CARL", "CARLO", "CARLOS", "CARLTON", "CARMELO", "CARMEN", "CARMINE", "CAROL", "CARROL", "CARROLL", "CARSON", "CARTER", "CARY", "CASEY", "CECIL", "CEDRIC",
                        "CEDRICK", "CESAR", "CHAD", "CHADWICK", "CHANCE", "CHANG", "CHARLES", "CHARLEY", "CHARLIE", "CHAS", "CHASE", "CHAUNCEY", "CHESTER", "CHET", "CHI", "CHONG",
                        "CHRIS", "CHRISTIAN", "CHRISTOPER", "CHRISTOPHER", "CHUCK", "CHUNG", "CLAIR", "CLARENCE", "CLARK", "CLAUD", "CLAUDE", "CLAUDIO", "CLAY", "CLAYTON", "CLEMENT",
                        "CLEMENTE", "CLEO", "CLETUS", "CLEVELAND", "CLIFF", "CLIFFORD", "CLIFTON", "CLINT", "CLINTON", "CLYDE", "CODY", "COLBY", "COLE", "COLEMAN", "COLIN", "COLLIN",
                        "COLTON", "COLUMBUS", "CONNIE", "CONRAD", "CORDELL", "COREY", "CORNELIUS", "CORNELL", "CORTEZ", "CORY", "COURTNEY", "COY", "CRAIG", "CRISTOBAL", "CRISTOPHER",
                        "CRUZ", "CURT", "CURTIS", "CYRIL", "CYRUS", "DALE", "DALLAS", "DALTON", "DAMIAN", "DAMIEN", "DAMION", "DAMON", "DAN", "DANA", "DANE", "DANIAL", "DANIEL",
                        "DANILO", "DANNIE", "DANNY", "DANTE", "DARELL", "DAREN", "DARIN", "DARIO", "DARIUS", "DARNELL", "DARON", "DARREL", "DARRELL", "DARREN", "DARRICK", "DARRIN",
                        "DARRON", "DARRYL", "DARWIN", "DARYL", "DAVE", "DAVID", "DAVIS", "DEAN",  "DEANDRE", "DEANGELO", "DEE", "DEL", "DELBERT", "DELMAR", "DELMER", "DEMARCUS",
                        "DEMETRIUS", "DENIS", "DENNIS", "DENNY", "DENVER", "DEON", "DEREK", "DERICK", "DERRICK", "DESHAWN", "DESMOND", "DEVIN", "DEVON", "DEWAYNE", "DEWEY", "DEWITT",
                        "DEXTER", "DICK", "DIEGO", "DILLON", "DINO", "DION", "DIRK", "DOMENIC", "DOMINGO", "DOMINIC", "DOMINICK", "DOMINIQUE", "DON", "DONALD", "DONG", "DONN",
                        "DONNELL", "DONNIE", "DONNY", "DONOVAN", "DONTE", "DORIAN", "DORSEY", "DOUG", "DOUGLAS", "DOUGLASS", "DOYLE", "DREW", "DUANE", "DUDLEY", "DUNCAN", "DUSTIN",
                        "DUSTY", "DWAIN", "DWAYNE", "DWIGHT", "DYLAN"};
                Random ran = new Random();
                name = namegen[ran.nextInt(namegen.length)];
            }

            //Selecting a random Last Name for a student
            String[] surnamegen = {"SMITH", "JOHNSON", "WILLIAMS", "BROWN", "JONES", "MILLER", "DAVIS", "GARCIA", "RODRIGUEZ", "WILSON", "MARTINEZ", "ANDERSON", "TAYLOR", "THOMAS",
                    "MOORE", "MARTIN", "JACKSON", "THOMPSON", "WHITE", "LOPEZ", "LEE", "GONZALEZ", "HARRIS", "CLARK", "LEWIS", "ROBINSON", "WALKER", "PEREZ", "HALL", "YOUNG", "HERNANDEZ",
                    "ALLEN", "SANCHEZ", "WRIGHT", "KING", "SCOTT", "GREEN", "BAKER", "ADAMS", "NELSON", "HILL", "RAMIREZ", "CAMPBELL", "MITCHELL", "ROBERTS", "CARTER", "PHILLIPS",
                    "EVANS", "TURNER", "TORRES", "PARKER", "COLLINS", "EDWARDS", "STEWART", "FLORES", "MORRIS", "NGUYEN", "MURPHY", "RIVERA", "COOK", "ROGERS", "MORGAN", "PETERSON",
                    "COOPER", "REED", "BAILEY", "BELL", "GOMEZ", "KELLY", "HOWARD", "WARD", "COX", "DIAZ", "RICHARDSON", "WOOD", "WATSON", "BROOKS", "BENNETT", "GRAY", "JAMES", "REYES",
                    "CRUZ", "HUGHES", "PRICE", "MYERS", "LONG", "FOSTER", "SANDERS", "ROSS", "MORALES", "POWELL", "SULLIVAN", "RUSSELL", "ORTIZ", "JENKINS", "GUTIERREZ", "PERRY", "BUTLER",
                    "BARNES", "FISHER", "HENDERSON", "COLEMAN", "SIMMONS", "PATTERSON", "REYNOLDS", "HAMILTON", "GRAHAM", "KIM", "GONZALES", "ALEXANDER", "RAMOS", "WALLACE", "GRIFFIN",
                    "WELLS", "ALVAREZ", "WOODS", "MENDOZA", "CASTILLO", "OLSON", "WEBB", "WASHINGTON", "TUCKER", "FREEMAN", "BURNS", "HENRY", "VASQUEZ", "SNYDER", "SIMPSON", "CRAWFORD",
                    "JIMENEZ", "PORTER", "MASON", "SHAW", "GORDON", "WAGNER", "HUNTER", "ROMERO", "HICKS", "DIXON", "HUNT", "PALMER", "ROBERTSON", "BLACK", "HOLMES", "STONE", "MEYER",
                    "BOYD", "MILLS", "WARREN", "FOX", "ROSE", "RICE", "MORENO", "SCHMIDT", "PATEL", "FERGUSON", "NICHOLS", "HERRERA", "MEDINA", "RYAN", "FERNANDEZ", "WEAVER", "DANIELS",
                    "BURKE", "GUZMAN", "MORRISON", "MUNOZ", "JACOBS", "OBRIEN", "LAWSON", "FRANKLIN", "LYNCH", "BISHOP", "CARR", "SALAZAR", "AUSTIN", "MENDEZ", "GILBERT", "JENSEN",
                    "WALTERS", "REID", "FIELDS", "WALSH", "LITTLE", "FOWLER", "BOWMAN", "DAVIDSON", "MAY", "DAY", "SCHNEIDER", "NEWMAN", "BREWER", "LUCAS", "HOLLAND", "WONG", "BANKS",
                    "SANTOS", "CURTIS", "PEARSON", "DELGADO", "VALDEZ", "PENA", "RIOS", "DOUGLAS", "SANDOVAL", "BARRETT", "HOPKINS", "KELLER", "GUERRERO", "STANLEY", "BATES", "ALVARADO",
                    "BECK", "ORTEGA", "WADE", "ESTRADA", "CONTRERAS", "BARNETT", "CALDWELL", "SANTIAGO", "LAMBERT", "POWERS", "CHAMBERS", "NUNEZ", "CRAIG", "LEONARD", "LOWE", "RHODES",
                    "BYRD", "GREGORY", "SHELTON", "FRAZIER", "BECKER", "MALDONADO", "FLEMING", "VEGA", "SUTTON", "COHEN", "JENNINGS", "PARKS", "MCDANIEL", "WATTS", "BARKER", "NORRIS",
                    "VAUGHN", "VAZQUEZ", "HOLT", "SCHWARTZ", "STEELE", "BENSON", "NEAL", "DOMINGUEZ", "HORTON", "TERRY", "WOLFE", "HALE", "LYONS", "GRAVES", "HAYNES", "MILES", "PARK",
                    "WARNER", "PADILLA", "BUSH", "THORNTON", "MCCARTHY", "MANN", "ZIMMERMAN", "ERICKSON", "FLETCHER", "MCKINNEY", "PAGE", "DAWSON", "JOSEPH", "MARQUEZ", "REEVES", "KLEIN",
                    "ESPINOZA", "BALDWIN", "MORAN", "LOVE", "ROBBINS", "HIGGINS", "BALL", "CORTEZ", "LE", "GRIFFITH", "BOWEN", "SHARP", "CUMMINGS", "RAMSEY", "HARDY", "SWANSON", "BARBER",
                    "ACOSTA", "LUNA", "CHANDLER", "DANIEL", "BLAIR", "CROSS", "SIMON", "DENNIS", "OCONNOR", "QUINN", "GROSS", "NAVARRO", "MOSS", "FITZGERALD", "DOYLE", "MCLAUGHLIN", "ROJAS",
                    "BLAKE", "MALONE", "WOLF", "HODGES", "JUAREZ", "GILL", "FARMER", "HINES", "GALLAGHER", "DURAN", "HUBBARD", "CANNON", "MIRANDA", "WANG", "SAUNDERS", "TATE", "MACK",
                    "HAMMOND", "CARRILLO", "TOWNSEND", "WISE", "INGRAM", "BARTON", "MEJIA", "AYALA", "SCHROEDER", "HAMPTON", "ROWE", "PARSONS", "FRANK", "WATERS", "STRICKLAND", "OSBORNE",
                    "MAXWELL", "CHAN", "DELEON", "NORMAN", "HARRINGTON", "CASEY", "PATTON", "LOGAN", "BOWERS", "MUELLER", "GLOVER", "FLOYD", "HARTMAN", "BUCHANAN", "COBB", "FRENCH", "KRAMER",
                    "YATES", "LINDSEY", "LLOYD", "MARSH", "MCBRIDE", "OWEN", "SOLIS", "PHAM", "LANG", "PRATT", "LARA", "BROCK", "BALLARD", "TRUJILLO", "SHAFFER", "DRAKE", "ROMAN", "AGUIRRE",
                    "VELASQUEZ", "MONTOYA", "ROTH", "MEYERS", "CARDENAS", "FUENTES", "WEISS", "WILKINS", "HOOVER", "NICHOLSON", "UNDERWOOD", "SHORT", "CARSON"};
            Random ran2 = new Random();
            String surname = surnamegen[ran2.nextInt(surnamegen.length)];

            //Randomizing a Street
            String[] streetgen = {"Eje Central", "Eje vial", "Viaducto Miguel Alemán", "Paseo de la Reforma", "Francisco I. Madero Avenue", "Avenida Álvaro Obregón", "Avenida de los Insurgentes", "Amsterdam Avenue", "Avenida Álvaro Obregón", "Avenida Presidente Masaryk"};
            Random ran3 = new Random();
            String Street = streetgen[ran3.nextInt(streetgen.length)];

            // Tab navigation "+" => "Accounts"
            driver.findElement(By.className("allTabsArrow")).click();
            driver.findElement(By.xpath(".//*[@title='Accounts']")).click();
            driver.findElement(By.xpath(".//*[@title='New']")).click();

            // Randomizing a Phone number
            Random randNum = new Random(System.currentTimeMillis());
            int num = randNum.nextInt(1000000000);

            // Randomizing a Street number
            Random rNum = new Random(System.currentTimeMillis());
            int num2 = rNum.nextInt(1000);
            Random ryNum = new Random(System.currentTimeMillis());
            int num3 = ryNum.nextInt(200);

            // Randomizing a Postal Code number
            Random rynNum = new Random(System.currentTimeMillis());
            int num4 = rynNum.nextInt(6000);

            // Filling in student's First & Last name
            driver.findElement(By.xpath("//*[@id='name_firstacc2']")).sendKeys(name);
            driver.findElement(By.xpath("//*[@id='name_lastacc2']")).sendKeys(surname);

            //Selecting a student type
            Select Student_Type = new Select(driver.findElement(By.xpath("//*[@id='00NE0000000cqG8']")));
            Student_Type.selectByVisibleText("Prospect");

            //Filling in Birth Date
            driver.findElement(By.xpath("//*[@id='00NE0000000dOMX']")).sendKeys("02/02/1990");

            //Selecting a student's gender
            Select Gender = new Select(driver.findElement(By.xpath("//*[@id='00NE0000000mStE']")));
            Gender.selectByVisibleText(equality[random]);

            //Filling in Email address
            Select Email = new Select(driver.findElement(By.xpath("//*[@id='00NE0000000mStN']")));
            Email.selectByVisibleText("Personal Email");
            driver.findElement(By.xpath("//*[@id='00NE0000000mStM']")).sendKeys(name + surname + "@mailinator.com");

            //Filling in Mobile phone
            Select Phone = new Select(driver.findElement(By.xpath("//*[@id='00NE0000000mStP']")));
            Phone.selectByVisibleText("Mobile Phone");
            driver.findElement(By.xpath("//*[@id='PersonMobilePhone']")).sendKeys(num +"158");

            //Filling in Address section
            driver.findElement(By.xpath("//*[@id='CF00NE0000004Gbgg']")).sendKeys("Mexico");
            driver.findElement(By.xpath("//*[@id='00NE0000000dOMq']")).sendKeys("ME-" + num4);
            driver.findElement(By.xpath("//*[@id='CF00NE0000004Gbgi']")).sendKeys("México");
            driver.findElement(By.xpath("//*[@id='00NE0000000dOMo']")).sendKeys("Mexico");
            driver.findElement(By.xpath("//*[@id='00NE0000000dOMs']")).sendKeys(Street + ' ' + num2 + "/" + num3);

            //Save Account and advance
            driver.findElement(By.xpath(".//*[@title='Save']")).click();

            //-------------------------------------------------------------------------------------------------------------------------------OPPORTUNITY SECTION
            //Navigate to Opportunity creation
            driver.findElement(By.name("new_ula_traditional_opportunity")).click();

            //Selecting an Opportunity Close Date
            driver.findElement(By.xpath("//*[@class='dateFormat']")).click();

            //Selecting an Opportunity Status
            Select Opportunity_Status = new Select(driver.findElement(By.xpath("//*[@id='opp11']")));
            Opportunity_Status.selectByVisibleText("Appointment");

            //Selecting an Opportunity ADMT Code
            Select ADMT_Select = new Select(driver.findElement(By.xpath("//*[@id='00NE0000004GbfL']")));
            ADMT_Select.selectByVisibleText("EM~ Empleado");

            //Selecting an Opportunity RESD Code
            Select RESD_Select = new Select(driver.findElement(By.xpath("//*[@id='00NE0000004GbfM']")));
            RESD_Select.selectByVisibleText("E~ EXTRANJERO");

            //Selecting an Opportunity STYPE Code
            Select STYPE_Select = new Select(driver.findElement(By.xpath("//*[@id='00NE0000004GbfN']")));
            STYPE_Select.selectByVisibleText("C~ REINGRESO");

            //Selecting an Opportunity Term Code
            Select Term_Code = new Select(driver.findElement(By.xpath("//*[@id='00NE0000004GbfT']")));
            Term_Code.selectByVisibleText("201805~ TC Ciclo 17-18 Annual Aug17 - Jul18");

            //Selecting a Quoter Fee Discount
            Select Fee_Discount = new Select(driver.findElement(By.xpath("//*[@id='00NL0000003PW7S']")));
            Fee_Discount.selectByVisibleText("5% de descuento FEE");

            //Selecting a Quoted Tuition Discount
            Select Tuition_Discount = new Select(driver.findElement(By.xpath("//*[@id='00NL0000003PW7T']")));
            Tuition_Discount.selectByVisibleText("10% de descuento TUI");

            //Selecting an Opportunity Registrant Type
            Select Registrant_Type = new Select(driver.findElement(By.xpath("//*[@id='00NE0000000dOOS']")));
            Registrant_Type.selectByVisibleText("Baccalaureate - International");

            //Save Opportunity and advance
            driver.findElement(By.xpath(".//*[@title='Save']")).click();
            //-------------------------------------------------------------------------------------------------------------------------------SEARCH CATALOG SECTION
            //Advancing to Search Catalog lookup
            driver.findElement(By.xpath(".//*[@title='Search Catalog']")).click();
            Thread.sleep(3000);

            String parentHandle = driver.getWindowHandle();
            for (String childHandle : driver.getWindowHandles()) {
                if (!childHandle.equals(parentHandle))
                {driver.switchTo().window(childHandle); }
            }

            //Selecting an Opportunity Registrant Type
            Select Campus = new Select(driver.findElement(By.xpath("//*[@name='j_id0:j_id27:j_id30:j_id31:j_id33']")));
            Campus.selectByVisibleText("Norte");
            Thread.sleep(1000);

            //Selecting an Opportunity Registrant Type
            Select Program = new Select(driver.findElement(By.xpath("//*[@name='j_id0:j_id27:j_id30:j_id31:j_id64']")));
            Program.selectByVisibleText("Licenciatura En Administración");
            Thread.sleep(1000);

            //Selecting an Opportunity Registrant Type
            Select Payments_Number = new Select(driver.findElement(By.xpath("//*[@name='j_id0:j_id27:j_id30:j_id31:j_id95']")));
            Payments_Number.selectByVisibleText("5 Licenciatura");
            Thread.sleep(1000);

            //Saving an Search Cagalog lookup
            driver.findElement(By.xpath("//input[@value='Save']")).click();
            Thread.sleep(1000);

            driver.switchTo().window(parentHandle);
            //-------------------------------------------------------------------------------------------------------------------------------FINISHING UP

            //Editing an Opportunity to change the Status
            driver.findElement(By.xpath(".//*[@title='Edit']")).click();

            //Selecting an Opportunity Status
            Select Opportunity_Completing = new Select(driver.findElement(By.xpath("//*[@id='opp11']")));
            Opportunity_Completing.selectByVisibleText("Application Submitted");

            //Editing an Opportunity to change the Status
            driver.findElement(By.xpath(".//*[@title='Save']")).click();

            //Submitting an application
            driver.findElement(By.xpath(".//*[@title='Submit Application']")).click();
            Thread.sleep(3000);

            //Student Provisioning
            driver.findElement(By.xpath(".//*[@title='Student Provision']")).click();
            Thread.sleep(3000);

            //Opting out Student Credentials & Info
            System.out.printf("%-15s\t %-15s\t %-15s\n", name + " " + surname, driver.getCurrentUrl(), driver.findElement(By.id("00NE0000000dOOW_ilecell")).getText());

            //driver.close();
        }
    }
}