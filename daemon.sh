#!/bin/bash
def value = sh (script: 'eval $(minikube docker-env)', returnStdout: true)
println value
eval \$$(minikube docker-env)
