timeout(60) {
    node('maven') {
        timestamps {
            wrap([$class: 'BuildUser']){
                summary = """<b>Owner:</b> ${env.BUILD_USER}"""
            stage('Checkout') {
                checkout([
                    $class: 'GitSCM',
                    branches: [[name: 'refs/heads/master']],
                    doGenerateSubmoduleConfigurations: false,
                    submoduleCfg: [],
                    userRemoteConfigs: [[credentialsId: 'jenkins', url: 'git@github.com:saint88/selenium_otus_students.git']]
                ])
            }
            stage('Clean project') {
                sh """
                    mvn clean
                """
            }
            stage('Running tests') {
                sh """
                mvn test -Dbase.url=${env.BASE_URL}
                """
            }
        }
    }
}