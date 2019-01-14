pipeline {
    agent any

    stages {
        stage('Code Quality Check') {
            steps {
                echo 'Code Quality Checking.'
		sh "pwd"		
		//sh "sbt"
		//sh "sbt scalastyle"
		//sh "sbt coverage test coverageReport"
            }
        }
        stage('Packaging Stage') {
            steps {
                echo 'Packaging'
		//sh "sbt universal:packageBin"
            }
        }
        stage('DockerStage') {
            steps {
                echo 'Deploying....'
		sh "minikube start"
                def value ='$(minikube docker-env)'
		sh 'eval $value'
			//sh 'eval "\$(minikube docker-env)"' 
		sh "docker images"               
		//sh "sbt docker:publishLocal"
		
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
