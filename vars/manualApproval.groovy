def call() {
    stage('Manual Approval') {
        steps {
            script {
                timeout(time: 10, unit: 'MINUTES') {
                    def approvalMailContent = """
                    Project: ${env.JOB_NAME}
                    Build Number: ${env.BUILD_NUMBER}
                    Go to build URL and approve the deployment request.
                    URL de build: ${env.BUILD_URL}
                    """
                    mail(
                        to: 'devops4577@gmail.com',
                        subject: "${currentBuild.result} CI: Project name -> ${env.JOB_NAME}", 
                        body: approvalMailContent,
                        mimeType: 'text/plain'
                    )
                    input(
                        id: "DeployGate",
                        message: "Deploy ${params.project_name}?",
                        submitter: "approver",
                        parameters: [choice(name: 'action', choices: ['Deploy'], description: 'Approve deployment')]
                    )
                }
            }
        }
    }
}
