pipeline {
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }
    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/AhlemTrabelsi22/DevOps.git'

            }
        }
        stage('Check Maven and Java') {
            steps {
                sh "java -version"
                sh "mvn -version"
            }
        }
    }
}
