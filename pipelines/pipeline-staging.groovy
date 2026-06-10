pipeline {
    agent { label 'nodo-staging' }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando repositorio...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Construyendo proyecto para staging...'
                sh 'echo Build staging completado'
            }
        }
        
        stage('Security Scan') {
            steps {
                echo 'Ejecutando escaneo de seguridad...'
                sh 'echo Escaneo OWASP completado'
            }
        }
        
        stage('Deploy Staging') {
            steps {
                echo 'Desplegando en staging...'
                sh 'echo Deploy completado en nodo-staging'
            }
        }
        
        stage('Smoke Test') {
            steps {
                echo 'Ejecutando smoke tests...'
                sh 'echo Smoke tests completados'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline STAGING completado exitosamente'
        }
        failure {
            echo 'Pipeline STAGING falló'
        }
    }
}