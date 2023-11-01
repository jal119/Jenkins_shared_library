def call() {
    sh 'trivy image jall1985/youtube:latest > trivyimage.txt'
}
