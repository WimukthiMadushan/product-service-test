pipeline {
    agent any

    tools{
        maven 'maven_3_5_0'
    }

    stages {


        stage('Checkout') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/WimukthiMadushan/product-service-test.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean package'
            }
        }

        stage('Build Docker Image') {
            steps {
                sh 'docker build -t wimukthibandara/product-service:latest .'
            }
        }

        stage('Push Docker Image') {
            steps {
                sh '''update
                docker login -u wimukthibandara -p #WM@b2000#
                docker push wimukthibandara/product-service:latest
                '''
            }
        }
    }
}