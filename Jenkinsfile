pipeline {
    agent any

    options {
        buildDiscarder logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '10', daysToKeepStr: '', numToKeepStr: '10')
    }

    environment {
        PROJECT_ROOT = 'D:\\Testing\\NesmaProject\\Estate-Book'
        WORKSPACE_WINDOWS = 'C:\\ProgramData\\Jenkins\\.jenkins\\workspace\\EstateBookPipeline'
        WORKSPACE = 'C:/ProgramData/Jenkins/.jenkins/workspace/EstateBookPipeline'
        ALLURE_REPORT = "allure-report/"
        ALLURE_REPORT_HTML = "index.html"
        ALLURE_RESULTS = "allure-results"
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
                    def allurePath = "${WORKSPACE_WINDOWS}\\${ALLURE_RESULTS}"
                    if (fileExists(allurePath)) {
                        // Delete the target folder
                        bat "rmdir /s /q ${allurePath}"
                        echo "Allure-results directory removed successfully : ${allurePath}"
                    } else {
                        echo "Allure-results directory does not exist at : ${allurePath}. No cleanup needed."
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
                    echo "Starting 'Mail Distribution' Stage!!"
                    bat "C:/Users/Agami/scoop/apps/allure/2.25.0/bin/allure.bat generate --single-file allure-results --clean"
                    def allureAttachment = "${ALLURE_REPORT}"
                    def allureReportPath = "${ALLURE_REPORT}${ALLURE_REPORT_HTML}"
                    def testNGAttachment = "${TARGET_FOLDER}${SUREFIRE_REPORTS}${HTML_REPORT}"
                    def testNGReportPath = "${TARGET_FOLDER}${SUREFIRE_REPORTS}"
                    def testNGReportContent = readFile(file: testNGAttachment)

                    if (fileExists(allureAttachment) || fileExists(testNGAttachment)) {
                        emailext(
                                subject: "Allure Results",
                                body: "Please find the attached test results. \n\n${testNGReportContent}",
                                to: "${EMAIL_RECIPIENT}",
                                mimeType: 'text/html',
                                attachmentsPattern: "${allureAttachment},${testNGAttachment}"
                        )
                    } else {
                        echo "File doesn't exist at: ${allureAttachment},${testNGAttachment}"
                    }
                }
            }
        }
    }
}

