def call() {
    withSonarQubeEnv('sonar-server') {
        sh """
            sonar-scanner \\
            -Dsonar.projectKey=youtube \\
            -Dsonar.sources=. \\
            -Dsonar.host.url=http://107.23.87.138:9000 \\
            -Dsonar.login=sqp_6e06d98f07f8f21c42b16180985c84e1455445fd
        """
    }
}
