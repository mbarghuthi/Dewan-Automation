pipeline {
    agent any

    tools {
        maven 'Maven'
        jdk 'JDK8'
    }
  parameters {
        string(
            name: 'APP_NAME',
            defaultValue: '*',
            description: 'Which app to test: UOP, JPPMC, JIC, or * for all'
        )
        string(
            name: 'VERSION',
            defaultValue: 'unknown',
            description: 'Deployed version (passed from n8n)'
        )
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
               script {
                   def storyPattern = "*"
                   if (params.APP_NAME && params.APP_NAME != "*") {
                       storyPattern = "*${params.APP_NAME}*"
                   }
                   bat """
                       chcp 65001
                       set JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8 -Dsun.jnu.encoding=UTF-8
                       mvn test "-Dstory.filter=${storyPattern}" -DreportDirectory="%WORKSPACE%\\reports"
                   """
               }
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
            echo "Build result: ${currentBuild.result ?: 'SUCCESS'}"
            echo "Tested app: ${params.APP_NAME}, version: ${params.VERSION}"
            archiveArtifacts artifacts: 'target/surefire-reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'reports/**/*', allowEmptyArchive: true
            archiveArtifacts artifacts: 'target/jbehave/**/*', allowEmptyArchive: true

            junit allowEmptyResults: true, testResults: 'target/surefire-reports/*.xml'

            publishHTML(target: [
                allowMissing: true,
                alwaysLinkToLastBuild: true,
                keepAll: true,
                reportDir: 'reports',
                reportFiles: '**/Dewan-Automation-Report.html',
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