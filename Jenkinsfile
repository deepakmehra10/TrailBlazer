pipeline {
    agent any

    stages {
        stage('Code Quality Check') {
            steps {
                echo 'Code Quality Checking.'
		sbt scalastyle
		sbt coverage test coverageReport
            }
        }
        stage('Packaging Stage') {
            steps {
                echo 'Packaging'
		sbt universal:packageBin
            }
        }
        stage('DockerStage') {
            steps {
                echo 'Deploying....'
eval $(minikube docker-env)
sbt docker:publishLocal
		
            }
        }
       stage('Deploy Stage') {
            steps {
                echo 'Deploying....'
		minikube start
            }
        }
    }
}
