def call(String SonarQubeAPI, String Projectname, String ProjectKey) {
    withSonarQubeEnv("${SonarQubeAPI}") {
        withEnv([
            'SONAR_SCANNER_OPTS=-Xmx2g -Dsonar.scanner.skipSystemTruststore=true'
        ]) {
            sh """
              ${SONAR_HOME}/bin/sonar-scanner \
                -Dsonar.projectName=${Projectname} \
                -Dsonar.projectKey=${ProjectKey} \
                -X
            """
        }
    }
}
