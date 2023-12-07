pipeline {
    agent any

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '10', daysToKeepStr: '', numToKeepStr: '10')
    }

    environment {
        PROJECT_ROOT = 'D:\\Testing\\NesmaProject\\Estate-Book'
        WORKSPACE_WINDOWS = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\FirstPipeLine'
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace/EstateBookPipeline'
        PATH_TO_ALLURE_REPORT = "${WORKSPACE}/allure-report"
        TARGET_FOLDER = 'target'
        SUREFIRE_REPORTS = '/surefire-reports'
        HTML_REPORT = '/emailable-report.html'
        EMAIL_RECIPIENT = 'czczc2009@gmail.com'

    }
    stages {
        stage('Cleanup') {
            steps {
                script {
                echo "Starting 'Cleanup' Stage!!"
                   def targetPath = "${WORKSPACE_WINDOWS}\\${TARGET_FOLDER}"
                   if (fileExists(targetPath)) {
                    // Delete the target folder
                    bat "rmdir /s /q ${targetPath}"
                    echo "Target directory removed successfully : ${targetPath}"
                    } else {
                        echo "Target directory does not exist at : ${targetPath}. No cleanup needed."
                }
            }
        }
    }
    stage('Build'){
        steps{
            script{
                echo "Starting 'Build' Stage!!"
                bat 'mvn install -DskipTests'
            }
        }
    }
        stage('Test') {
            steps {
                script{
                echo "Starting 'Test' Stage!!"
                bat 'mvn clean test -Dtest="SignInTest"'
                }
            }
        }

        stage('Generate Allure Report') {
            steps {
                script{
                    echo "Starting 'Generate Allure Report' Stage!!"
                    bat 'allure generate --single-file allure-results --clean'
                }
            }
        }
        stage('Mail Distribution') {
            steps {
                script {
                  echo "Starting 'Mail Distribution' Stage!!"
                  def attachmentPath = "${PATH_TO_ALLURE_REPORT}"
                    if(fileExists(attachmentPath)){
                         echo "File exists at: ${attachmentPath}"
                    } else {
                         echo "File doesn't exist at: ${attachmentPath}"
                    }
                    // Attach the HTML file and send email
                    def htmlReport = readFile("${attachmentPath}")
                    emailext (
                        subject: "Test Results",
//                         body: "Please find the attached test results.",
                        //To be used if you want the report to be viewed in the body of the mail
                        body: "Please find the attached test results.\n\n ${htmlReport}",
//                          readFile("${WORKSPACE}${HTML_FILE}"),
                        to: "${EMAIL_RECIPIENT}",
//                         replyTo: "noreply@example.com",
                        mimeType: 'text/html',

                        //To be used if you want the report to attached to the mail
                        attachmentsPattern: "${attachmentPath}"
                    )
                }
            }
        }
    }
}
