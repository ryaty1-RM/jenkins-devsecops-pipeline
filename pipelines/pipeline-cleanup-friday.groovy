pipeline {
    agent { label 'nodo-dev' }
    
    triggers {
        cron('0 17 * * 5')
    }
    
    stages {
        stage('Cleanup Workspace') {
            steps {
                echo 'Limpiando workspace...'
                sh 'echo Workspace limpiado'
            }
        }
        
        stage('Cleanup Docker') {
            steps {
                echo 'Limpiando contenedores Docker detenidos...'
                sh 'docker container prune -f'
                echo 'Limpiando imágenes no utilizadas...'
                sh 'docker image prune -f'
            }
        }
        
        stage('Cleanup Logs') {
            steps {
                echo 'Limpiando logs antiguos...'
                sh 'find /var/log -name "*.log" -mtime +7 -delete || true'
            }
        }
        
        stage('Report') {
            steps {
                echo 'Generando reporte de limpieza...'
                sh 'echo Limpieza completada el viernes a las 5pm'
            }
        }
    }
    
    post {
        success {
            echo 'Limpieza semanal completada exitosamente'
        }
        failure {
            echo 'Error en limpieza semanal'
        }
    }
}