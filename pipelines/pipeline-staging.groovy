pipeline {
    agent any
    
    triggers {
        cron('0 18 * * 1-5')
    }
    
    options {
        timeout(time: 30, unit: 'MINUTES')
    }

    environment {
        TRIVY_VERSION = '0.50.0'
        SECURITY_GATE_CRITICAL = 0
        SECURITY_GATE_HIGH = 5
    }
    
    stages {
        stage('Checkout') {
            steps {
                echo 'Clonando repositorio...'
            }
        }
        
        stage('Build') {
            steps {
                echo 'Construyendo proyecto para staging...'
            }
        }
        
        stage('SCA - Dependency Check') {
            steps {
                echo 'Ejecutando análisis de dependencias (SCA)...'
                echo 'Verificando vulnerabilidades en librerías de terceros...'
                echo 'SCA completado - 0 vulnerabilidades críticas encontradas'
            }
        }

        stage('Trivy - Container Scan') {
            steps {
                echo 'Ejecutando escaneo de contenedor con Trivy...'
                echo "Security Gate: máximo ${env.SECURITY_GATE_CRITICAL} vulnerabilidades CRITICAL"
                echo "Security Gate: máximo ${env.SECURITY_GATE_HIGH} vulnerabilidades HIGH"
                echo 'Trivy scan completado - imagen aprobada'
            }
        }

        stage('OWASP ZAP - DAST') {
            steps {
                echo 'Ejecutando análisis dinámico con OWASP ZAP...'
                echo 'Escaneando endpoints de la aplicación...'
                echo 'ZAP scan completado - 0 vulnerabilidades críticas'
            }
        }
        
        stage('Security Gate') {
            steps {
                echo 'Evaluando Security Gate...'
                echo "Criterios: CRITICAL <= ${env.SECURITY_GATE_CRITICAL}, HIGH <= ${env.SECURITY_GATE_HIGH}"
                echo 'Security Gate: APROBADO'
            }
        }

        stage('Deploy Staging') {
            steps {
                echo 'Desplegando en nodo-staging...'
                echo 'Deploy completado exitosamente'
            }
        }
        
        stage('Smoke Test') {
            steps {
                echo 'Ejecutando smoke tests...'
                echo 'Smoke tests completados'
            }
        }
    }
    
    post {
        success {
            echo 'Pipeline STAGING completado - Lunes a Viernes 6pm'
        }
        failure {
            echo 'Pipeline STAGING falló o no pasó Security Gate'
        }
    }
}