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
		//sh "minikube start"
script {
		def value = sh script: 'eval $(minikube docker-env)', returnStdout: true
		println value
}
		sh 'chmod +x ./daemon.sh'
		sh './daemon.sh'                
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
