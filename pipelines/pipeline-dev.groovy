pipeline {
    agent { label 'nodo-dev' }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando repositorio...'
                checkout scm
            }
        }
        
        stage('Build') {
            steps {
                echo 'Construyendo proyecto...'
                sh 'echo Build completado'
            }
        }
        
        stage('Test') {
            steps {
                echo 'Ejecutando pruebas...'
                sh 'echo Pruebas completadas'
            }
        }
        
        stage('Code Quality') {
            steps {
                echo 'Verificando calidad de código...'
                sh 'echo Calidad verificada'
            }
        }
        
        stage('Report') {
            steps {
                echo 'Generando reporte...'
                sh 'echo Reporte generado'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline DEV completado exitosamente'
        }
        failure {
            echo 'Pipeline DEV falló'
        }
    }
}