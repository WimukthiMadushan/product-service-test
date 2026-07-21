pipeline {
    agent any

    tools {
        maven 'Maven3'
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
                sh 'docker build -t wimukthibandara/product-service:${BUILD_NUMBER} .'
            }
        }

        stage('Push Docker Image') {
            steps {
                withCredentials([
                        usernamePassword(
                            credentialsId: 'dockerhub',
                            usernameVariable: 'DOCKER_USER',
                            passwordVariable: 'DOCKER_PASS'
                        )
                    ]) {
                    sh '''
                    echo $DOCKER_PASS | docker login \
                        -u $DOCKER_USER \
                        --password-stdin

                    docker push wimukthibandara/product-service:${BUILD_NUMBER}
                    '''
                }
            }
        }
    }
}