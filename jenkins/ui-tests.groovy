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
        }
    }
}