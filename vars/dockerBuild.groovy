def call(String dockerHubUsername, String imageName) {
    // Build the Docker image
    sh "docker build --build-arg REACT_APP_RAPID_API_KEY=c231aa0f36msh2395b89a552c03dp166a17jsneea07afcd86f -t ${imageName} ."
     // Tag the Docker image
    sh "docker tag ${imageName} ${dockerHubUsername}/${imageName}:latest"
    // Push the Docker image
    withDockerRegistry([url: 'https://index.docker.io/v1/', credentialsId: 'docker']) {
        sh "docker push ${dockerHubUsername}/${imageName}:latest"
    }
}
