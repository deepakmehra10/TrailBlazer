pipeline {
    agent any

    stages {
        stage('Code Quality Check') {
            steps {
                echo 'Code Quality Checking.'
		sbt
		//sbt scalastyle
		//sbt coverage test coverageReport
            }
        }
        stage('Packaging Stage') {
            steps {
                echo 'Packaging'
		//sbt universal:packageBin
            }
        }
        stage('DockerStage') {
            steps {
                echo 'Deploying....'
                //sbt docker:publishLocal
		
            }
        }
       stage('Deploy Stage') {
            steps {
                echo 'Deploying....'
		//minikube start
            }
        }
    }
}
