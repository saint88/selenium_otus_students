timeout(60) {
    node('maven-slave') {
        timestamps {
            wrap([$class: 'BuildUser']){
                summary = """<b>Owner:</b> ${env.BUILD_USER}"""
                currentBuild.description = summary
            }
            stage('Checkout') {
                // checkout scm
                checkout([
                                $class: 'GitSCM',
                                branches: [[name: "refs/heads/master"]],
                                doGenerateSubmoduleConfigurations: false,
                                submoduleCfg: [],
                                userRemoteConfigs: [[credentialsId: 'jenkins', url: 'git@github.com:saint88/selenium_otus_students.git']]
                            ])
            }
        }
    }
}