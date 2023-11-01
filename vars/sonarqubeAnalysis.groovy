def call() {
    withSonarQubeEnv('sonar-scanner') {
        sh ''' $SCANNER_HOME/bin/sonar-scanner -Dsonar.projectName=Youtube-video -Dsonar.projectKey=Youtube-video '''
    }
}
