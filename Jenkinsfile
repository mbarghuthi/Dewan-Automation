pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK8'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/mbarghuthi/Dewan-Automation.git'
            }
        }

        stage('Clean') {
            steps {
                bat 'mvn clean'
            }
        }

        stage('Clean Reports Folder') {
            steps {
                bat '''
                if exist "%WORKSPACE%\\reports" rmdir /s /q "%WORKSPACE%\\reports"
                mkdir "%WORKSPACE%\\reports"
                '''
            }
        }

        stage('Test') {
            steps {
                bat 'mvn test -DreportDirectory="%WORKSPACE%\\reports"'
            }
        }

        stage('Debug Reports') {
            steps {
                bat 'dir /s "%WORKSPACE%\\reports"'
            }
        }
    }

    post {
        always {
            echo 'Build finished'

            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true

            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles:'**/Wrong-Report.html',
                reportName: 'Extent Report',
                reportTitles: 'Dewan Automation Extent Report'
            ])
        }

        success {
            echo 'Build SUCCESS'
        }

        failure {
            echo 'Build FAILED'
        }
    }
}