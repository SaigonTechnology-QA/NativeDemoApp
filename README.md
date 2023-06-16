# This a very simple automation framework to test Mobile using TestNG, Maven, Appium and ReportPortal report

## Setup and run locally
1. Download and install IntelliJ IDEA Community Edition: [Link download](https://www.jetbrains.com/idea/download/download-thanks.html?platform=windows&code=IIC)
2. Download and install Java JDK 8:
- Create `JAVA_HOME` environment variables
- Add `JAVA_HOME` to Path: `%JAVA_HOME%\bin`

![Alt text](./assets/JavaHome.png?raw=true "JAVA_HOME")

- Check if `JAVA_HOME` is configured properly or not by typing the command `echo %JAVA_HOME%` and `java -version` on terminal/cmd

3.  Download and install Android Studio: [Link download](https://developer.android.com/studio)
- Open Android Studio then install all default components
- Create `ANDROID_HOME` environment variables for the path to : `Android\Sdk`
- Add `%ANDROID_HOME%\tools` to Path
- Add `%ANDROID_HOME%\platform-tools` to Path
- Add `%ANDROID_HOME%\emulator` to Path
- Create and start an emulator

4. Install Appium: `npm install -g appium`
- Update file `AppiumServer` to start appium automatically when running testcases

![Alt text](./assets/AutoStartAppium.png?raw=true "AutoStartAppium")


5. Follow this [Link](https://developer.android.com/studio/run/managing-avds) to create emulator

6. On emulator, install the demo app at the [Link](https://github.com/webdriverio/native-demo-app/releases/download/v0.4.0/Android-NativeDemoApp-0.4.0.apk)

7. Download and unzip latest Maven source file: [Link download](https://dlcdn.apache.org/maven/maven-3)
- Create `MAVEN_HOME` environment variables
- Add `MAVEN_HOME` to Path: `%MAVEN_HOME%\bin`

![Alt text](./assets/MavenHome.png?raw=true "MAVEN_HOME")

- Check if `MAVEN_HOME` is configured properly or not by typing the command `echo %MAVEN_HOME%` and `mvn -v` on terminal/cmd

8. Open this base project
9. Project structure settings:
- From the main menu of IntelliJ select: `File => Project Structure => Project Settings => Project`
- Select the wanted SDK

![Alt text](./assets/ProjectSetings.png?raw=true "ProjectSetings")

10. Select Maven plugin for IntelliJ:
- From IntelliJ select: `Ctrl+Alt+S -> Build, Execution, Deployment -> Build tool -> Maven -> Maven home directory`
- Select the Maven plugin at `C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2023.1\plugins\maven\lib\maven3\bin`
- Add the path of Maven plugin above to the Path environment variables

![Alt text](./assets/MavenPlugins.png?raw=true "MavenPlugins")

11. Download and unzip latest Allure report source file: [Link download](https://repo.maven.apache.org/maven2/io/qameta/allure/allure-commandline/)
- Create `ALLURE_HOME` environment variables
- Add `ALLURE_HOME` to Path: `%ALLURE_HOME%\bin`

![Alt text](./assets/AllureHome.png?raw=true "ALLURE_HOME")

- Check if `ALLURE_HOME` is configured properly or not by typing the command `echo %ALLURE_HOME%` and `allure --version` on terminal/cmd

- Allure Integration with TestNG

![Alt text](./assets/Allure_Config.png?raw=true "Allure_Config")

12. Install dependencies: `mvn clean install`

13. Run the tests by commandline: `mvn clean test -DxmlSuite="src/test/resources/test-suites/Regression.xml"`

![Alt text](./assets/ExecuteTest.png?raw=true "ExecuteTest")

14. Generate Allure report by commandline:
- `allure generate allure-results`
- `allure open`

## ReportPortal Integration with TestNG
1. Dependencies

![Alt text](./assets/Dependencies.png?raw=true "Dependencies")

2. Install listener

![Alt text](./assets/Listener.png?raw=true "Listener")

3. Configure reportportal.properties

![Alt text](./assets/Properties.png?raw=true "Properties")


## Run on GitHub Actions
1. Create Docker image for CI/CD (GitHub Actions, CircleCI)
- Build image: `docker build -t <user_name>/testng-allure .`
- Push image to Docker Hub: `docker push <user_name>/testng-allure`
2. Run tests on GitHub Actions:
- Check/update the file `.github/workflows/actions.yml`
- Commit and push code, the test will be triggered
- Download Allure report at the session Artifacts

