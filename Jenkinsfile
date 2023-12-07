pipeline {
    agent any

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '10', daysToKeepStr: '', numToKeepStr: '10')
    }

    tools {
        // Use the name specified in the Global Tool Configuration
        allure 'ALLURE_HOME'
    }
    environment {
        PROJECT_ROOT = 'D:\\Testing\\NesmaProject\\Estate-Book'
        WORKSPACE_WINDOWS = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\EstateBookPipeline'
        WORKSPACE = "${env.WORKSPACE}"
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
        stage('Build') {
            steps {
                script {
                    echo "Starting 'Build' Stage!!"
                    bat 'mvn install -DskipTests'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    echo "Starting 'Test' Stage!!"
//                    def testsToRun = ["SignInTest"]
//                    for (test in testsToRun) {
//                        bat "mvn clean test -Dtest=${test}"
//                    }
                    bat 'mvn clean test -Dtest="SignInTest"'
                }
            }
        }
        stage('Generate Allure Report') {
            steps {
                script {
                    ws("${PROJECT_ROOT}") {
                        allure([
                                includeProperties: false,
                                jdk              : '',
                                properties       : [],
                                reportBuildPolicy: 'ALWAYS',
                                results          : [[path: 'allure-results']]
                        ])
                    }
                }
            }
        }
        stage('Mail Distribution') {
            steps {
                script {
                    bat 'zip -r allure-report.zip allure-report'
                    echo "Starting 'Mail Distribution' Stage!!"
                    def attachmentPath = "${PATH_TO_ALLURE_REPORT}"
                    if (fileExists('allure-report.zip')) {
                        emailext(
                                subject: "Allure Results",
                                body: "Please find the attached test results.",
                                to: "${EMAIL_RECIPIENT}",
                                mimeType: 'text/html',

                                attachmentsPattern: 'allure-report.zip'
                        )
                    } else {
                        echo "File doesn't exist at: 'allure-report.zip'"
                    }
                }
            }
        }
    }
}

