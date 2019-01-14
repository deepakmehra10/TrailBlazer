pipeline {
    agent any
	environment {
	DOCKER_TLS_VERIFY="1"
DOCKER_HOST="tcp://192.168.99.115:2376"
DOCKER_CERT_PATH="/home/knoldus/.minikube/certs"
DOCKER_API_VERSION="1.35"

}
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
		sh "kubectl run from-jenkins --image=temperature-processor-impl:1.0.0-SNAPSHOT --port=9001"
		sh "kubectl expose deployment from-jenkins --type=NodePort"
		sh "kubectl get pod"
		sh 'curl $(minikube service hello-minikube --url)'

            }
        }
    }
}
