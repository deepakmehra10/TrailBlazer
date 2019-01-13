pipeline {
    agent any

    stages {
        stage('Code Quality Check') {
            steps {
                echo 'Code Quality Checking.'
		sh "pwd"		
		//sh "sbt"
		sh "sbt scalastyle"
		sh "sbt coverage test coverageReport"
            }
        }
        stage('Packaging Stage') {
            steps {
                echo 'Packaging'
		sh "sbt universal:packageBin"
            }
        }
        stage('DockerStage') {
            steps {
                echo 'Deploying....'
		sh "minikube start && eval $(minikube docker-env)"                
		sh "sbt docker:publishLocal"
		
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
