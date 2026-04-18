pipeline {
    agent any

    stages {

        stage('Clone Code') {
            steps {
                git branch: 'main', url: 'https://github.com/omkardgawas/devops-project-2.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh '''
                docker build -t my-app .
                '''
            }
        }

        stage('Deploy Container') {
            steps {
                sh '''
                docker rm -f my-app || true
                docker run -d -p 8081:80 --name my-app my-app
                '''
            }
        }
    }
}
