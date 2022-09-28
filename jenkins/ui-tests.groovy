timeout(60) {
    node('maven-slave') {
        timestamps {
            wrap([$class: 'BuildUser']){
                summary = """<b>Owner:</b> ${env.BUILD_USER}"""
                currentBuild.description = summary
            }
            stage('Checkout') {
                checkout scm
            }
            // stage('Ping selenoid') {
            //     sh "telnet 127.0.0.1 4445"
            // }
            stage('Running UI test') {
                result = sh "mvn test -Dbrowser=${BROWSER} -Dwebdriver.base.url=${BASE_URL} -Dbrowser.version=${BROWSER_VERSION} -Dwebdriver.remote.url=http://127.0.0.1:4445/wd/hub"
                if(result > 0) {
                    currentBuild.result = 'UNSTABLE'
                }
            }
            stage('Publication allure report') {
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
}