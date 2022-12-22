timeout(60) {
    node("maven-slave") {
        stage("Checkout") {
            checkout scm
        }
        stage("Run tests") {
            def exitCode = sh(
                    returnStatus: true,
                    script: """
                    mvn test -Dbrowser=$BROWSER -Dbrowser.version=$BROWSER_VERSION -Dwebdriver.base.url=$BASE_URL -Dwebdriver.remote.url=$GRID_URL
                    """
            )
            if(exitCode == 1) {
                currentBuild.result = 'UNSTABLE'
            }
        }
        stage("Publish allure results") {
            allure([
                    includeProperties: false,
                    jdk: '',
                    properties: [],
                    reportBuildPolicy: 'ALWAYS',
                    results: [[path: 'allure-results']]
            ])
        }
    }
}